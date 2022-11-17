<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.collapse.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/ehr.css"/>
<script type="text/javascript">
	function ehrHref(url){
		window.location.href = "${pageContext.request.contextPath}" + url;
	}
/* 	console.log($("#location").attr("title"));
	  $("div[title='" + $("#location").attr("title") + "']").trigger("open"); */
	  
</script>

<div class="leftNav">
  <div class="login-panel">
     <div class="head-portrait health-record-leftnav-sprite">
     </div>

     <div class="user-name">${personInfo.name}</div>
     <%-- <div class="user-name">${personInfo.name}</div> --%>

     <hr class="hr-line"/>
     <div class="person-info">
       <div class="sex"><span><strong>性别</strong>：</span><span><ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}"/></span></div>
       <div class="birthday"><span><strong>生日：</strong></span><span><fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/></span></div>

     </div>
  </div>
  <div class="col c2">
  <!-- BEGIN Custom open and close -->
  <div id="menuCollapse">
    <h5 pMenu="basic-info" class="parent-item health-record-leftnav-sprite basic-info"><span class="arrow  health-record-leftnav-sprite"></span></h5>
    <div>
      <div cMenu="basic" class="child-item" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/userSpace/ehr/basic')">个人信息</a></div>
      <div cMenu="phy" class="child-item" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/userSpace/ehr/phy')">个人体检</a></div>
      <div cMenu="history" class="child-item" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/userSpace/ehr/history')">既往病史</a></div>
    </div>
    <h5 pMenu="medical-activties" class="parent-item health-record-leftnav-sprite medical-activties"><span class="arrow  health-record-leftnav-sprite"></span></h5>
    <div>
      <div cMenu="result" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/userSpace/service/result')">医疗保健活动</a></div>
      <div cMenu="lis" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/userSpace/service/lis')">检验</a></div>
      <div cMenu="ris" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/userSpace/service/ris')">检查</a></div>
      <div cMenu="drug" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/userSpace/service/drug')">用药信息</a></div>
     </div>
    <h5 pMenu="women-health" class="parent-item health-record-leftnav-sprite women-health"><span class="arrow  health-record-leftnav-sprite"></span></h5>
    <div>
      <div cMenu="prenatalFollowupList" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/prenatalFollowupList')">产前随访</a></div>
      <div cMenu="prenatalScreenDiagnosisList" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/prenatalScreenDiagnosisList')">产前筛查与诊断</a></div>
      <div cMenu="deliveryRecord" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/deliveryRecord')">分娩记录</a></div>
      <div cMenu="postnatalFollowupList" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/postnatalFollowupList')">产后访视</a></div>
      <div cMenu="postpartumDaysHealthInfo" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/postpartumDaysHealthInfo')">产后42天随访</a></div>
      <div cMenu="bornDefect" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/bornDefect')">新生儿缺陷检测</a></div>
      <div cMenu="neonatalFamilyVisitList" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/neonatalFamilyVisitList')">新生儿家庭访视</a></div>
      <div cMenu="neonatalDiseaseScreen" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/neonatalDiseaseScreen')">新生儿疾病筛查</a></div>
      <div cMenu="motherhoodPeriodFollowupList" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/motherhoodPeriodFollowupList')">孕期保健和高危随访管理</a></div>
      <div cMenu="premaritalHealthService" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/premaritalHealthService')">婚前保健服务</a></div>
      <div cMenu="womanDiseaseCensusList" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/womanDiseaseCensusList')">妇女病普查</a></div>
      <div cMenu="ownBornDetail" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/ownBornDetail')">本人出生证明</a></div>
      <div cMenu="birthController" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/womenHealthCare/birthController')">计划生育计划服务信息</a></div>
     </div>
    <h5 pMenu="child-care" class="parent-item health-record-leftnav-sprite child-care"><span class="arrow  health-record-leftnav-sprite"></span></h5>
    <div>
      <div cMenu="childHealthCard" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/childrenHealthCare/childHealthCard')">儿童保健卡</a></div>
      <div cMenu="frailChildFollowupList" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/childrenHealthCare/frailChildFollowupList')">体弱儿童随访管理</a></div>
     <c:if test="${empty chBirthCertificates}">
      <div cMenu="newBornDetail" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/childrenHealthCare/newBornDetail/0')">子女出生医学证明</a></div>
      </c:if>
      <c:if test="${ not empty chBirthCertificates}">
		<c:forEach items="${chBirthCertificates}" var="fcf">
    	  <div cMenu="newBornDetail" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/childrenHealthCare/newBornDetail/${fcf.id}')">子女${fcf.name}的出生医学证明</a></div>
      </c:forEach>
	</c:if>
     </div>
    <h5 pMenu="disease-management" class="parent-item health-record-leftnav-sprite disease-management"><span class="arrow  health-record-leftnav-sprite"></span></h5>
    <div>
      <div cMenu="manageIndex" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/CDmanage/manageIndex')">管理首页</a></div>
      <div cMenu="managePlan" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/CDmanage/managePlan')">保健计划</a></div>
      <div cMenu="manageFollow" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/CDmanage/manageFollow')">随访登记</a></div>
     </div>
     
     <h5 pMenu="health-record-leftnav-sprite" class="parent-item health-record-leftnav-sprite self-eva"><span class="arrow  health-record-leftnav-sprite"></span></h5>
    <div>
      <div cMenu="selfEvaluation" class="child-item"><a href="javascript:void(0)" onclick="ehrHref('/oldManHealthCare/selfEvaluation')">老年人自我评估</a></div>
     </div>
  </div>
  <script>
        new jQueryCollapse($("#menuCollapse"), {
          open: function() {
            this.slideDown(150);
          },
          close: function() {
            this.slideUp(150);
          }
        });
        
        $(function() { 
            //每次进入模块保证当前模块菜单项选中
        	$("h5[pMenu='" + $("#location").attr("parentMenu") + "']").removeClass("close").addClass("open");
        	$(".open+div").css({display:"block"}); 
            $("div[cMenu='" + $("#location").attr("childMenu") + "']").css({backgroundColor:"#96D7FE"});
        	//$(".open+div").attr("display","block");
	   });
      </script>
 </div>
</div>


<div style="display: none;">

</div>


