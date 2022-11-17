<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/sewageTreatmentAdd.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script>
    $(function(){
    	
    	 <c:if test="${msg == true}">
    	 	layer.alert("保存成功！", {icon:0,title:'提示'});
 	    </c:if>
 	    <c:if test="${msg == false}">
 	   		layer.alert("保存失败！", {icon:0,title:'提示'});
 		</c:if>
 		if($("#message").val()!=''&&$("#message").val()!=undefined)
 			layer.alert($("#message").val(), {icon:0,title:'提示'});
		//validate = $("#sewageTreatmentForm").easyValidate();
        enableChangeConfirm();
	    sewageTreatmentAdd.uploadFile("picUrl","/he/upload/uploadFile/dmbcSewageTreatment","/he/upload/deleteFile/dmbcSewageTreatment");
    });
</script>
<div class="toolbar">
    <a href="javascript:void(0)" onclick="javascript:sewageTreatmentAdd.returnSearch()"><b class="fanhui">返回</b></a>
    <c:if test="${type == 'add'||type == 'edit'}">
            <a href="javascript:sewageTreatmentAdd.saveSewageTreatment()"><b class="baocun">保存</b></a>
    </c:if>
</div>
<div class="postcontent" >
<form id="sewageTreatmentForm">
<input type="hidden" id="message" value="${message}" />
<input type="hidden" name="type" id="type" value="${type}" />
<input type="hidden" name="createBy" value="${sewageTreatment.createBy}" />
<tag:dateInput id="createTime" name="createTime" date="${sewageTreatment.createTime}" style="display:none"/>
      		<fieldset>
				<legend>污水处理登记</legend>
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" id="monitorId" name="id" value="${sewageTreatment.id}">
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:80px;" />
						<col style="width: 20%;min-width:260px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 15%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 15%;min-width:200px;" />
					</colgroup>
					<tr>
						<th><label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>机构名称</label></th>
						<td colspan="5">
                            <c:if test="${type eq 'view'}">
                                <ehr:org code="${sewageTreatment.orgName}"/>
                            </c:if>
                            <c:if test="${type ne 'view'}">
                                ${currentOrg.organName}
                                <input type="hidden" name="orgName" value="${currentOrg.organCode}"/>
                            </c:if>
						</td>
					</tr>
					<tr>
						<th><label<c:if test="${type != 'view'}">
							class="required"  </c:if> >污水处理原液池</label></th>
						<td><label>长:</label><input type="text" name="originalPoolLength" id="originalPoolLength" value="${sewageTreatment.originalPoolLength}" style="width:30px"
							reg="{'required':'true','maxlength':3,'number':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/><label >米,</label>
							<label>宽:</label>
							<input type="text" name="originalPoolWidth" id="originalPoolWidth" value="${sewageTreatment.originalPoolWidth}" style="width:30px"
							reg="{'required':'true','maxlength':3,'number':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/><label >米,</label>
							<br/>
							<label >高:</label>
							<input type="text" name="originalPoolHeight" id="originalPoolHeight" value="${sewageTreatment.originalPoolHeight}" style="width:30px"
							reg="{'required':'true','maxlength':3,'number':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
							<label >米</label>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>污水处理反应池</label></th>
						<td colspan="3" style="vertical-align: top">
							<label>长:</label><input type="text" name="reactionTankLength" id="reactionTankLength" value="${sewageTreatment.reactionTankLength}" style="width:30px"
							reg="{'required':'true','maxlength':3,'number':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/><label >米,</label>
							<label>宽:</label>
							<input type="text" name="reactionTankWidth" id="reactionTankWidth" value="${sewageTreatment.reactionTankWidth}" style="width:30px"
							reg="{'required':'true','maxlength':3,'number':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/><label >米,</label>
							<label >高:</label>
							<input type="text" name="reactionTankHeight" id="reactionTankHeight" value="${sewageTreatment.reactionTankHeight}" style="width:30px"
							reg="{'required':'true','maxlength':3,'number':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
							<label >米</label>
						</td>
					</tr>
					<tr>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>污水日均产生量</label></th>
						<td>
							<input type="text" name="avgDailyOutput" value="${sewageTreatment.avgDailyOutput}" style="width:50px" reg="{'required':'true','maxlength':3,'digits':'true'}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
							<label >吨</label>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>污水处理周期</label></th>
						<td colspan="3">
							<input type="text" name="processingPeriod" style="width:125px" value="${sewageTreatment.processingPeriod}" reg="{'required':'true','maxlength':10}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
		
						</td>
					</tr>
					<tr>
						<th>污水消毒处理方式</th>
						<td>
							<ehr:dic-list name="disinfectionTreatment" id="disinfectionTreatment" dicmeta="DMBC00011" defaultval="Y" value="${sewageTreatment.disinfectionTreatment}"/>   
						</td>
						<th class="material">原料是否有生产许可证</th>
						<td colspan="3" class="material">
							<ehr:dic-radio name="matProductionPermit" dicmeta="PH00001" code="1,2" value="${sewageTreatment.matProductionPermit}" />
						</td>
					</tr>
					<tr class="disinfectant">
						<th>消毒剂名称</th>
						<td>
							<input type="text" name="disinfectantName" value="${sewageTreatment.disinfectantName}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
						</td>
						<th>消毒剂有效成分</th>
						<td >
							<input type="text" name="effectiveConstituent" value="${sewageTreatment.effectiveConstituent}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
		
						</td>
						<th>使用量</th>
						<td >
							<input type="text" name="disUsageAmount" value="${sewageTreatment.disUsageAmount}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
		
						</td>
					</tr>
					<tr class="disinfectant">
						<th>消毒剂生产单位</th>
						<td>
							<input type="text" name="productionUnit" value="${sewageTreatment.productionUnit}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
						</td>
						<th>消毒剂是否有生产许可证</th>
						<td colspan="3">
							<ehr:dic-radio name="disProductionPermit" dicmeta="PH00001" code="1,2" value="${sewageTreatment.disProductionPermit}" />
						</td>
					</tr>
					<tr class="material">
						<th>原料名称</th>
						<td>
							<input type="text" name="materialName" value="${sewageTreatment.materialName}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
						</td>
						<th>使用量</th>
						<td >
							<input type="text" name="matUsageAmount" value="${sewageTreatment.matUsageAmount}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
						</td>
						<th>原料来源</th>
						<td >
							<input type="text" name="source" value="${sewageTreatment.source}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
						</td>
					</tr>
					
					<tr>
						<th>处理人员所属科室</th>
						<td>
							<input type="text" name="assignerDept" value="${sewageTreatment.assignerDept}" reg="{'maxlength':20}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
						</td>
						<th>年龄</th>
						<td >
							<input type="text" name="age" value="${sewageTreatment.age}" reg="{'maxlength':3,'digits':'true'}" style="width: 50px" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
							岁
						</td>
						<th>性别</th>
						<td >
							<ehr:dic-list name="gender" dicmeta="FS10006" value="${sewageTreatment.gender}" />
						</td>
					</tr>
					<tr>
						<th>文化程度</th>
						<td>
							<ehr:dic-list name="education" dicmeta="GBT46582006" code="IDM01,IDM02,IDM03,IDM04,IDM05" value="${sewageTreatment.education}" />
						</td>
						<th>从事年数</th>
						<td >
							<input type="text" name="years" value="${sewageTreatment.years}" reg="{'maxlength':2,'digits':'true'}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
		
						</td>
						<th>培训次数</th>
						<td >
							<input type="text" name="trainNum" value="${sewageTreatment.trainNum}" reg="{'maxlength':3,'digits':'true'}" <c:if test="${type == 'view'}">readonly="readonly"</c:if>/>
		
						</td>
					</tr>
					<tr>
						<th>余氯比色器材</th>
						<td>
							<ehr:dic-radio name="colorimetricEq" dicmeta="PH00002" code="1,2" value="${sewageTreatment.colorimetricEq}" />
						</td>
						<th>余氯比色试剂</th>
						<td >
							<ehr:dic-radio name="colorimetricReagent" dicmeta="PH00002" code="1,2" value="${sewageTreatment.colorimetricReagent}" />
						</td>
						<th>试剂是否避光保存</th>
						<td >
							<ehr:dic-radio name="keepDark" dicmeta="PH00001" code="1,2" value="${sewageTreatment.keepDark}" />
						</td>
					</tr>
					<tr>
						<th>试剂更换时间</th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" name="changeTime" value="<fmt:formatDate value='${sewageTreatment.changeTime}' pattern='yyyy/MM/dd' />" 
								readonly="readonly"/>
							</c:if>
							<c:if test="${type != 'view'}">
								<tag:dateInput nullToToday="true" name="changeTime" date="${sewageTreatment.changeTime}"
								 pattern="yyyy/MM/dd"  onlypast="true"  reg="{'tip':'请填写更换时间'}"></tag:dateInput>
							</c:if>
						</td>
						<th>记录台帐资料</th>
						<td colspan="3">
							<ehr:dic-radio name="accountRecord" dicmeta="PH00002" code="1,2" value="${sewageTreatment.accountRecord}" />
						</td>
					</tr>
					<tr>
						<th>日常问题及建议</th>
						<td >
								<textarea name="suggest" rows="3" reg="{'maxlength':100}"
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>>${sewageTreatment.suggest}</textarea>
						</td>
						<th>处理工艺流程图</th>
						<td colspan="3" style="vertical-align: top">
							<c:if test="${type != 'view'}">
								<div id="picUrl"></div>
								<span style="color: blue;">附件支持jpeg, jpg, gif, png格式，单个附件请控制在5M之内</span>
								<input type="hidden" name="picUrl" value="${sewageTreatment.picUrl}"/>
							</c:if>
							<c:if test="${type == 'view'}"><ehr:imageShow imgUrl="${sewageTreatment.picUrl}" title="示意图"/></c:if>
						</td>
					</tr>
				</table>
			</fieldset>
</form>
<br/>
<c:if test="${type == 'edit'}">
<div id="" class="toolbar">
				<a href="#this" onclick="javascript:sewageTreatmentAdd.initTreatmentAdd()"><b
						class="xinz">新增</b></a>
				</div>
</c:if>
<div id="treatmentList">
	<jsp:include page="treatmentList.jsp"></jsp:include>
</div>
</div>