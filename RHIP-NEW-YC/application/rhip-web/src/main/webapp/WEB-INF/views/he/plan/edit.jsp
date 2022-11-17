<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/he/plan/edit.js" type="text/javascript"></script>

<div class="toolbar">
<!-- 	<a href="javascript:void(0)" id="heWorkPlanBackButton"><b class="fanhui">返回</b></a> -->
	 <!-- <a href="javascript:void(0)" id="heWorkPlanSaveButton"><b class="baocun">保存</b></a> -->
	 <a href="javascript:void(0)" id="heWorkPlanSaveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form id="heWorkPlanForm">
	<div class="postcontent divAbsolute55">
		<input type="hidden" name="id" value="${heWorkPlan.id}">
		<tag:dateInput name="createDate" id="createDate" date="${heWorkPlan.createDate}" style="display:none;"/>
		<input type="hidden" name="createUserCode" value="${heWorkPlan.createUserCode}">
		<table class="posttable">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>填报人</th>
				<td>
					<ehr:user userCode="${heWorkPlan.createUserCode}"/>
				</td>
				<th>填报日期</th>
				<td>
					<fmt:formatDate value="${heWorkPlan.createDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th><label class="required">计划类型</label></th>
				<td><ehr:dic-list name="planType" dicmeta="HE00033" reg='{"required":"true"}' value="${heWorkPlan.planType}" width="75%;" cssClass="x-layui-input"/></td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<th><label class="required">计划开始日期</label></th>
				<td>
					<%-- <tag:dateInput reg='{"required":"true"}' name="beginDate" id="beginDate" date="${heWorkPlan.beginDate}" onlypast="true" /> --%>
					<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="beginDate" id="beginDateId" value="<fmt:formatDate value='${heWorkPlan.beginDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<th><label class="required">计划结束日期</label></th>
				<td>
					<%-- <tag:dateInput reg='{"required":"true"}' name="endDate" id="endDate" date="${heWorkPlan.endDate}" onlypast="true" /> --%>
					<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="endDate" id="endDateId" value="<fmt:formatDate value='${heWorkPlan.endDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
			</tr>
			<tr>
				<th><label class="required">计划内容</label></th>
				<td colspan="6"><textarea name="planContent" reg='{"required":"true", "maxlength":"2000"}' style="height: 80px; width: 700px;" class="x-layui-input">${heWorkPlan.planContent}</textarea></td>
			</tr>
		</table>
	</div>
</form>

<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#beginDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#beginDateId").removeClass("lose");
			}else{
				$("#beginDateId").addClass("lose");
			}
		}
    });
    
    laydate.render({
        elem: '#endDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   // ,max:0 //HNYC-428 【健康教育登记】年度工作计划-新增-计划结束日期应该支持选到当日之后的日期
		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#endDateId").removeClass("lose");
			}else{
				$("#endDateId").addClass("lose");
			}
		}
      });
    
  });
</script>