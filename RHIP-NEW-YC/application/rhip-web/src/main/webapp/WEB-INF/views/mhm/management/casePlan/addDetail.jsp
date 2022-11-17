<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/casePlan/detailEdit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>

<div class="postcontent">
	<form id="detailForm">
		<div class="postdiv">
			<input type="hidden" id="rowIndex" value="${rowIndex}"/>
			<table id="detailChildTable"  class="layui-table x-admin-sm-table-list-middle">
				<colgroup>
					<col style="width:25%;"/>
					<col style="width:75%;"/>
				</colgroup>	
				<tr>
					<th>现况评估，明确问题:</th>
					<td>
						<input type="text" name="definiteQuestion" reg='{"maxlength":"100"}' 
							value ="${caseDetail.definiteQuestion }" style="width:98%"/>					
					</td>
				</tr>
				<tr>
					<th>确定目标，制订指标:</th>
					<td>
						<input type="text" name="setGoal" reg='{"maxlength":"100"}' 
							value ="${caseDetail.setGoal }" style="width:98%"/>					
					</td>
				</tr>
				<tr>
					<th>采取策略:</th>
					<td>
						<input type="text" name="takeStrategy" reg='{"maxlength":"100"}' 
							value ="${caseDetail.takeStrategy }" style="width:98%"/>					
					</td>
				</tr>
				<tr>
					<th>责任人:</th>
					<td>
						<input type="text" name="personLiable" reg='{"maxlength":"50"}' 
							value ="${caseDetail.personLiable }" style="width:98%"/>					
					</td>
				</tr>
				<tr>
					<th>完成时间:</th>
					<td>
						<input type="text" class="layui-input x-admin-content-sm-date"  name="finishTime" id="finishTimeId" value="<fmt:formatDate value='${caseDetail.finishTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
					</td>
				</tr>																	
			</table>
		</div>
	</form>
	<div class="toolbarpop">
	    <c:if test="${type == 'add'}">
			<!-- <input type="button" id="saveDetail" value="添加" onclick="detailEdit.save('add')"> -->
			<button class="layui-btn layui-btn-sm"  id="saveBulletinButtonId" onclick="detailEdit.save('add')">添加</button>
	    </c:if>
	    <c:if test="${type == 'edit'}">
			<!-- <input type="button" id="modifyDetail" value="修改" onclick="detailEdit.save('edit')"> -->
			<button class="layui-btn layui-btn-sm"  id="saveBulletinButtonId" onclick="detailEdit.save('edit')">修改</button>
	    </c:if>	
		<!-- <input type="button" id="cancelDetail" value="取消" onclick="mhmCommon.closePopUp('detialDialog')"> -->
		<button class="layui-btn layui-btn-sm"  id="saveBulletinButtonId" onclick="mhmCommon.closeLayUiDialog()">取消</button>
	</div>
</div>
<script type="text/javascript">
layui.use('laydate', function() {
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#finishTimeId' 
   	   ,format: 'yyyy/MM/dd'
   	  , trigger: 'click' 
    });
    
  });
</script>