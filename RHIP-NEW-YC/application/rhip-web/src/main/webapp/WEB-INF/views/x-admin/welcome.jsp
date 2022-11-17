<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/layouts/homepage.js" type="text/javascript"></script>
<script type="text/javascript"> 
        setInterval(function(){   
        var date = new Date();   
        var year = date.getFullYear();    //获取当前年份   
        var mon = date.getMonth()+1;      //获取当前月份   
        var da = date.getDate();          //获取当前日   
        var day = date.getDay();          //获取当前星期几   
        var h = date.getHours();          //获取小时   
        var m = date.getMinutes();        //获取分钟   
        var s = date.getSeconds();        //获取秒   
        var d = document.getElementById('currentDateSpan'); 
        var weekDay = '';
        if (day == 1) {
        	weekDay = "一";
		} else if (day == 2) {
			weekDay = "二";
		} else if (day == 3) {
			weekDay = "三";
		} else if (day == 4) {
			weekDay = "四";
		} else if (day == 5) {
			weekDay = "五";
		} else if (day == 6) {
			weekDay = "六";
		} else if (day == 7) {
			weekDay = "七";
		}
          d.innerHTML= year+'年'+'&nbsp;'+mon+'月'+'&nbsp;'+da+'日 '+'&nbsp;'+'星期'+weekDay+'&nbsp;'+h+':'+m+':'+s;  
        },1000);
</script>
    <div class="x-body" id="homeDiv">
        <blockquote class="layui-elem-quote">
        	欢迎用户：
            <span style="font-weight: bolder;margin: 5px;">${currentUser.name}</span>当前时间:&nbsp;<span id="currentDateSpan"></span>
        </blockquote>
        <%-- <fieldset class="layui-elem-field">
            <legend>待办事项</legend>
            <div class="layui-field-box" style="height: 180px;overflow: auto;">
                                    <ehr:authorize ifAnyGranted="01,03,10,19">
                                        <ul>
                                            <li><i class="layui-icon">&#xe667;</i>&nbsp;传染病报卡待审核数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.idmCount}</a></li>
                                           <li> <i class="layui-icon">&#xe667;</i>&nbsp;食源性疾病报卡待审核数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.fdmCount}</a></li>
                                        </ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="01,02">
                                        <ul><li><i class="layui-icon">&#xe667;</i>&nbsp;健康档案未建档数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.personNofileCount}</a></li></ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="01,02,03">
                                        <ul><li><i class="layui-icon">&#xe667;</i>&nbsp;老年人待体检数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(3)">${todoMap.physicalExamCount}</a></li></ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="01,03,11,19">
                                        <ul><li><i class="layui-icon">&#xe667;</i>&nbsp;慢病报卡待审核数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.cdmCount}</a></li></ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="02">
                                        <ul><li>围产保健预约数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" &lt;%&ndash;onclick="homepageInit.reserveList(2)"&ndash;%&gt;>${todoMap.maternalCount}</a></li></ul>
                                    </ehr:authorize>
                                        <ehr:authorize ifAnyGranted="02,03">
                                        <ul><li>儿童一周内体检预约数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" &lt;%&ndash;onclick="homepageInit.reserveList(1)"&ndash;%&gt;>${todoMap.childCount}</a></li></ul>
                                        </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="02">
                                    <ul><li>计划免疫预约数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" &lt;%&ndash;onclick="homepageInit.reserveList(3)"&ndash;%&gt;>${todoMap.vaccinationCount}</a></li></ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="01,02">
                                        <ul><li><i class="layui-icon">&#xe667;</i>&nbsp;慢病过期待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.expireCount}</a></li></ul>
                                        <ul><li><i class="layui-icon">&#xe667;</i>&nbsp;慢病本日待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.todayCount}</a></li></ul>
                                        <ul><li><i class="layui-icon">&#xe667;</i>&nbsp;慢病7天内待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.thisWeekCount}</a></li></ul>
                                        <ul><li><i class="layui-icon">&#xe667;</i>&nbsp;慢病30天内待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${todoMap.thisMonthCount}</a></li></ul>
                                    </ehr:authorize>
                                <c:if test="${! empty emergencyList}">
                                    	<ul>
                                        <c:forEach items="${emergencyList}" var="emergency">
                                            <li>
                                                    <i class="layui-icon">&#xe667;</i>&nbsp;${emergency.content}
                                            </li>
                                        </c:forEach>
                                    	</ul>
                                </c:if>

            </div>
        </fieldset> --%>
        <fieldset class="layui-elem-field">
        	<div style="float: right;margin-right: 15px;margin-top: 8px;">
        			<ehr:authorize ifNotGranted="01">
	            	<a href="javascript:void(0)" onclick="homepageInit.moreBulletin()" class="x-a" ><i class="layui-icon">&#xe65b;</i>更多</a>
	            	</ehr:authorize>
                      <ehr:authorize ifAnyGranted="01">
                      <a href="javascript:void(0)" onclick="homepageInit.moreBulletin()" class="x-a" ><i class="layui-icon">&#xe65b;</i>管理</a>
                      </ehr:authorize>
            </div>
            <legend>公告通知</legend>
            <div class="layui-field-box" style="clear: both;height: 120px;overflow: auto;">
                <ul>
                      <c:forEach items="${bulletins}" var="bulletin">
                          <li>
                               <i class="layui-icon">&#xe667;</i>&nbsp;<a class="x-a" href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${bulletin.title}</a>
                          </li>
                      </c:forEach>
                 </ul>
            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>问题解答</legend>
            <div class="layui-field-box" style="height: 200px;overflow: auto;">
            	<div style="float: right;margin-top: -12px;margin-bottom: 5px;">
            	<ehr:authorize ifNotGranted="01">
	            	<a href="javascript:void(0)" onclick="homepageInit.addQuestion(0)" class="x-a" ><i class="layui-icon">&#xe6b2;</i>提问</a>
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            </ehr:authorize>
	            	<a href="javascript:void(0)" onclick="homepageInit.moreQuestion(0)" class="x-a" ><i class="layui-icon">&#xe65b;</i>更多</a>
            	</div>
                <table class="x-admin-sm-table-list-middle" style="clear: both;">
                	<colgroup>
					<col style="width: 80%;" />
					<col style="width: 20%;" />
				</colgroup>
                    <tbody>
                   <c:forEach items="${questions}" var="question">
                    <tr style="background-color: #F7F7F7;">
                        <td style="border-style: none;font-size: 12px;">
                        	 <span style="font-weight: bolder;font-size: 12px;"><i class="layui-icon">&#xe606;</i></span>[ <ehr:user userCode="${question.submitor}"/> - <ehr:user userCode="${question.submitor}"/> ]
                        	 
                        </td>
                        <td style="text-align: right;border-style: none;font-size: 12px;">
                        	 <ehr:authorize ifNotGranted="01">
                                        <c:if test="${empty question.answer}">
                                        <c:if test="${submitor eq question.submitor  || createrOrg eq '_999'}">
                                            <a class="x-a" href="javascript:void(0)" onclick="homepageInit.addQuestion(${question.id})" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
                                            <a class="x-a" href="javascript:void(0)" onclick="homepageInit.deleteQuestion(${question.id})" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp;&nbsp;
                                       	</c:if>
                                        </c:if>
                                       <%--  <c:if test="${not empty question.answer}"> --%>
                                            <a class="x-a" href="javascript:void(0)" onclick="homepageInit.viewQuestion(${question.id})" title="查看"><i class="layui-icon">&#xe615;</i></a>&nbsp;&nbsp;
                                       <%--  </c:if> --%>
                                    </ehr:authorize>

                                    <ehr:authorize ifAnyGranted="01">
                                        <a class="x-a" href="javascript:void(0)" onclick="homepageInit.answerQuestion(${question.id})" title="解答"><i class="layui-icon">&#xe611;</i></a>
                                    </ehr:authorize>
                        </td>
                        </tr>
                        <tr>
                        	<td colspan="2" style="border-style: none;font-size: 12px;">
                        	<span style="font-weight: bolder;"><i class="layui-icon">&#xe611;</i></span>
                        		 <c:if test="${not empty question.answer}">
                                        ${question.answerContent}
                                    </c:if>
                                    <c:if test="${empty question.answer}">
                                       	 尚未解答
                                    </c:if>
                        	</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </fieldset>
    </div>
    <div id="moreDiv">

</div>