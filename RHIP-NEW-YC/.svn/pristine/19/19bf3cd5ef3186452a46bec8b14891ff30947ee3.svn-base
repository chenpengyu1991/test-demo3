<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/casePlan/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<form id="casePlanForm">
<div class="postcontent postdiv" style="margin-top: 10px;">
<fieldset class="layui-elem-field">
	<input name="statusId" value="${statusId}" type="hidden"/>
	<input id="eventId"  name="eventId" value="${mhmCase.eventId}" type="hidden"/>
	<input name="mhmCase.id" value="${mhmCase.id}" type="hidden"/>
	<input name="mhmCase.caseDetailJson" id="caseDetailJson" type="hidden"/>
	
	<legend>个案管理计划</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 180px; width: 28%;"/>
           <col style="min-width: 400px; width: 72%;"/>
   		</colgroup>
      	<tbody>
       		<tr>
       			<th><label class="required">制定日期:</label></th>
           		<td>
           			<%-- <tag:dateInput id="ihaDtId" name="mhmCase.createDate" style="width: 100px;" date="${mhmCase.createDate}"
                    	reg='{"regex":"date","required":"true"}'  pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput> --%>
                    	<input type="text" reg='{"regex":"date","required":"true"}' class="layui-input x-admin-content-sm-date"  name="mhmCase.createDate" id="ihaDtId" value="<fmt:formatDate value='${mhmCase.createDate}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;width: 100px;" />
           		</td>
			</tr>
			<tr>   
				<th><label class="required">制定次数(请填写数字):</label></th>                 
           		<td>
		           	第<input type="text" name="mhmCase.createNumber" value="${mhmCase.createNumber}"
		           		style="width: 100px;" reg='{"digits":"true","maxlength":"5","required":"true"}'/>次
                </td>
			</tr>
			<tr>                 
                <th>危险性评级:</th>
                <td>
	               	<ehr:dic-radio name="mhmCase.riskEvaluate" value="${mhmCase.riskEvaluate}" dicmeta="MH00021"/>
                </td>                
			</tr>
			<tr>
		       	<th>目前就医方式:</th>
		       	<td>
		 			<ehr:dic-radio name="mhmCase.treatmentMode" value="${mhmCase.treatmentMode}" dicmeta="MH00036"/>
		       	</td>
       		</tr>			
       		<tr>
            	<th>如未治，未治原因：</th>
	            <td>
		 			<ehr:dic-radio name="mhmCase.untreatedReason" value="${mhmCase.untreatedReason}" dicmeta="MH00016" 
		           		 onchange="toggleOther('mhmCase.untreatedReason','mh00016Id','99')"/>
		           	<span id="mh00016Id">
		           		，请说明
		           		<input type="text" name="mhmCase.untreatedReasonOther" value="${mhmCase.untreatedReasonOther}"
		           		style="width: 100px;" reg='{"maxlength":"100"}'/>
		           	</span>
		        </td>
	     	</tr> 
       		<tr>
            	<th>目前管理级别：</th>
	            <td>
		 			<ehr:dic-radio name="mhmCase.managementLevel" value="${mhmCase.managementLevel}" dicmeta="MH00023" 
		           		code="1,2,3"/>
		        </td>
	     	</tr> 	
       		<tr>
            	<th>服药方式：</th>
	            <td>
		 			<ehr:dic-radio name="mhmCase.takeMedicineWay" value="${mhmCase.takeMedicineWay}" dicmeta="MH00022"/>
		        </td>
	     	</tr>	
       		<tr>
            	<th>药物不良反应：</th>
	            <td>
		 			<%-- <ehr:dic-list name="mhmCase.adverseReaction" value="${mhmCase.adverseReaction}" dicmeta="MH00015" 
		           		 onchange="toggleOther('mhmCase.adverseReaction','mh00015Id','13')"/>
					<span id="mh00015Id">
		           		，请简述
		           		<input type="text" name="mhmCase.adverseReactionOther" value="${mhmCase.adverseReactionOther}"
		           		style="width: 100px;" reg='{"maxlength":"100"}'/>
		           	</span> --%>
		           	<ehr:dic-checkbox name="mhmCase.adverseReaction" value="${mhmCase.adverseReaction}" dicmeta="MH00015" onchange="toggleOtherCK('mhmCase.adverseReaction','divDrugAdverseReaction','13')"/>
		                <span id="divDrugAdverseReaction">，请简述<input type="text" name="mhmCase.adverseReactionOther" value="${mhmCase.adverseReactionOther}" 
		                		style="width:120px;" reg='{"maxlength":"100"}'/>
		                </span>
		           	
		           			           		
		        </td>
	     	</tr>
       		<tr>
            	<th>康复地点：</th>
	            <td>
		 			<ehr:dic-radio name="mhmCase.recoveryPlace" value="${mhmCase.recoveryPlace}" dicmeta="MH00037" 
		           		 onchange="toggleOther('mhmCase.recoveryPlace','MH00037Id','99')"/>
					<span id="MH00037Id">
		           		<input type="text" name="mhmCase.recoveryPlaceOther" value="${mhmCase.recoveryPlaceOther}"
		           		style="width: 100px;" reg='{"maxlength":"100"}'/>
		           	</span>			           		
		        </td>
	     	</tr>	
       		<tr>
            	<th>劳动收入水平：</th>
	            <td>
		 			<ehr:dic-radio name="mhmCase.income" value="${mhmCase.income}" dicmeta="PH00002" 
		           		code="2,1" onchange="toggleOther('mhmCase.income','PH00002Id','1')"/>
					<span id="PH00002Id">
		           		<input type="text" name="mhmCase.incomePre" value="${mhmCase.incomePre}"
		           		style="width: 100px;" reg='{"digits":"true","maxlength":"20"}'/>元/月
		           	</span>			           		
		        </td>
	     	</tr>
       		<tr>
            	<th>下阶段拟管理级别：</th>
	            <td>
		 			<ehr:dic-radio name="mhmCase.nextManagementLevel" value="${mhmCase.nextManagementLevel}" dicmeta="MH00023" 
		           		code="1,2,3" />
		        </td>
	     	</tr>
       		<tr>
       			<th>个体服务计划中需要考虑的领域：</th>
	            <td>
		 			<ehr:dic-checkbox name="mhmCase.consideringField" value="${mhmCase.consideringField}" dicmeta="MH00041" />
		        </td>
	     	</tr>		     		     		     	     		     	     	     	
       </tbody>
  </table>
</fieldset>
<fieldset style="margin-top: 20px;" class="layui-elem-field">
	<legend>个案管理明细计划单(由个案管理员和患者协商制定)</legend><!-- <button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe608;</i>新增</button> -->
	<div class="toolbarsublist">
	<a href="javascript:void(0)" id="addDetailId" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"  title="新增"><i class="layui-icon">&#xe608;</i>新增</a>
	</div>
	<div id ="childDiv" class="repeattable">  	
	 	<table id="caseDetailId" class="layui-table x-admin-sm-table-list-middle">
	       	<colgroup>
	           <col style="min-width: 140px; width: 20%;"/>
	           <col style="min-width: 140px; width: 20%;"/>
			   <col style="min-width: 140px; width: 20%;"/>
	           <col style="min-width: 80px; width: 10%;"/>	
	            <col style="min-width: 120px; width: 15%;"/>
	           <col style="min-width: 120px; width: 15%;"/>
	   		</colgroup>
	      		<tbody>
	      			<tr>
						<th class="centerth">现况评估，明确问题</th>	
						<th class="centerth">确定目标，制订指标</th>
						<th class="centerth">采取策略</th>
						<th class="centerth">责任人</th>
						<th class="centerth">完成时间</th> 
						<th class="centerth">操作</th>     			
	      			</tr>
	      			<c:forEach var="caseDetail" items="${mhmCase.caseDetails}" varStatus="status">	
	      				<tr>
							<td field="definiteQuestion"><ehr:tip>${caseDetail.definiteQuestion }</ehr:tip></td>
							<td field="setGoal" ><ehr:tip>${caseDetail.setGoal }</ehr:tip></td>	
							<td field="takeStrategy" ><ehr:tip>${caseDetail.takeStrategy }</ehr:tip></td>
							<td field="personLiable" ><ehr:tip>${caseDetail.personLiable }</ehr:tip></td>
							<td field="finishTime"><ehr:tip><fmt:formatDate value="${caseDetail.finishTime }" pattern="yyyy/MM/dd"/></ehr:tip></td>		
							<td class="btnsublist" field="btn">
								<a class="layui-btn layui-btn-xs" href="#" onclick="casePlanEdit.popupDetail(this,'edit')" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
									 		
								<a class="layui-btn layui-btn-danger layui-btn-xs" href="#"  onclick="mhmCommon.removeTr(this)" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
							</td>
						</tr>
	      			</c:forEach>
				</tbody> 
		</table>	
	</div>
</fieldset>
<fieldset class="layui-elem-field">
<table class="posttable" style="margin-top: 20px;">
	<colgroup>
    	<col style="min-width: 120px; width: 28%;"/>
        <col style="min-width: 280px; width: 22%;"/>
    	<col style="min-width: 120px; width: 28%;"/>
        <col style="min-width: 280px; width: 22%;"/>        
	</colgroup>
   	<tbody>
    	<tr>
    		<th>患者姓名：</th>
        	<td>${patientName}</td>
    		<th>个案管理员签字：</th>
        	<td>
        		<ehr:user userCode="${mhmCase.modifyDoctorId == null ? currentUser.id : mhmCase.modifyDoctorId}"/>
				<input type="hidden" name="mhmCase.modifyDoctorId" value="${mhmCase.modifyDoctorId == null ? currentUser.id : mhmCase.modifyDoctorId}"/>
         	</td>         	
		</tr>
	</tbody>
</table>
</fieldset>
</div>
</form>
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#ihaDtId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
       ,done:function (value) {
			if(!$.isEmpty(value)){
				$("#ihaDtId").removeClass("lose");
			}else{
				$("#ihaDtId").addClass("lose");
			}
		}
    });

  });
</script>