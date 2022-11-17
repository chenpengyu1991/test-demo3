<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/followUpPlanSearch.js" type="text/javascript"></script>

<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="postdiv">
	<fieldset style="margin-top:2px;margin-left:5px;float:left;width:47%; height:324px;overflow: auto" class="layui-elem-field">
		<div style="margin-bottom: 5px;">
			<table>
				<tbody>
					<tr>
						<td>选择年份:
							<%-- <tag:dateInput  date="${searchYear }" style="width:178px;" id="year" name="year" pattern="yyyy"></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="year" id="year" value="<fmt:formatDate value='${searchYear}' pattern='yyyy'/>" style="padding-left: 0px;"/>
							年
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="repeattable">
		   <table id="followStatus" class="layui-table x-admin-sm-table-list-small">
				<colgroup>
					<col style="width:50px;"/>
					<col style="width:50px;"/>
					<col style="width:50px;"/>
				</colgroup>
				<thead>
					<tr>
						<th>年度</th>
						<th>计划日期</th>
						<th>随访日期</th>
					</tr>
				</thead>			
				<tbody>
					<c:forEach var="followUpInfo" items="${followUpPlanInfo}">
						<tr id="${followUpInfo.id}" class="${empty followUpInfo.followupId ? 'toBeBuild':'hasBeenBuild' }">
							<td><ehr:tip>${followUpInfo.planYear}年</ehr:tip></td>
							<td><ehr:tip><fmt:formatDate value="${followUpInfo.planDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
							<td>
								<c:if test="${empty followUpInfo.followupId}">
									<%--<c:if test="${empty isNotTheFirst}">--%>
								<c:if test="${aMonthBefore <= followUpInfo.planDate && followUpInfo.planDate <= aMonthLater}">

									<c:set var="isNotTheFirst" value="${true}" scope="request"></c:set>
									<span  title="点击新建随访记录" style="cursor: pointer;" data-planid="${followUpInfo.id}" data-followupid="${followUpInfo.followupId}" class="deal-plan" >
											填写随访
									</span>
								</c:if>
									<%--</c:if>--%>
								</c:if>
								<c:if test="${not empty followUpInfo.followupId}">
									<span title="点击修改随访记录" style="cursor: pointer;" data-planid="${followUpInfo.id}" data-followupid="${followUpInfo.followupId}" class="deal-plan" >
										<fmt:formatDate value="${followUpInfo.followupDate}" pattern="yyyy/MM/dd"/>
									</span>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		   </table>
	   </div>
	</fieldset>		
	<div class="postcontent"> 
			<div id="followUpPlanResult"></div>
    </div>
</div>    
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#year' 
      ,type:'year'
    	  ,done: function(value, date, endDate) {
    		    $("#year").val(value);
    		    followUp_main.searchFollowUpPlan(1);
    		  }
    });

    
  });
</script>