<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/idm/malaria/drugreg.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:drugreg.returnSearch()"><b class="fanhui">返回</b></a>
	<c:if test="${logoff != '1'}">
    	<a href="javascript:void(0)" onclick="javascript:drugreg.drugregSubmit()"><b class="baocun">保存</b></a>
    </c:if>
    <c:if test="${not empty malariaDto.singleId}">
    	<a href="javascript:void(0)" onclick="javascript:drugreg.exportDrugreg(${malariaDto.idmId})"><b class="dayin">打印预览</b></a>
    </c:if>
</div>

<form id="drugregForm">
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" name="singleId" value="${malariaDto.singleId}"/>
	<input type="hidden" name="idmId" value="${malariaDto.idmId}"/>
	<input type="hidden" id="type" name="type" value="${type}"/>
	<input type="hidden" id="logoff" value="${logoff}"/>
    <input type="hidden" id="specialStatusId" name="specialStatus" value="${malariaDto.specialStatus}"/>
    <input type="hidden" name="listSdJson" id="listSdJson">	
    <div class="postcontent">
        <i class="popno">疟疾病例治疗督导服药登记表 </i>
        <div class="postdiv">
        	<fieldset>
        		<legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th><label class="required">姓名:</label></th>
                        <td>
                        	<input type="hidden" name="generalCondition.id" value="${malariaDto.generalCondition.id}"/>
                        	<input type="text" id="name" name="generalCondition.name" value="${malariaDto.generalCondition.name}" 
                        		style="width: 100px;" reg='{"required":"true","maxlength":"50"}'/>
                        </td>
                        <th>家长姓名:</th>
                        <td>
                        	<input type="text" id="parentsName" name="generalCondition.parentsName" value="${malariaDto.generalCondition.parentsName}" 
                        		style="width: 100px;" reg='{"maxlength":"50"}'/>
                        </td>                        
                        <th><label class="required">性别:</label></th>
                        <td>
                        	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${malariaDto.generalCondition.gender}"  reg='{"required":"true"}' code="1,2"/>
                        </td>
                     </tr>
                    <tr>
                        <th><label class="required">年龄:</label></th>
                        <td>
                        	<input type="text" id="age" name="generalCondition.age" value="${malariaDto.generalCondition.age}" 
                        		style="width: 100px;" reg='{"required":"true","digits":"true","maxlength":"20"}'/>
                        </td>
                        <th><label class="required">体重:</label></th>
                        <td>
                        	<input type="hidden" name="clinicalManifestations.id" value="${malariaDto.clinicalManifestations.id}"/>
                        	<input type="text" id="weightId" name="clinicalManifestations.weight" value="${malariaDto.clinicalManifestations.weight}"
                        		style="width: 100px;" reg='{"required":"true","maxlength":"20"}'/>&nbsp;Kg
                        </td>
                        <th><label class="required">联系电话:</label></th>
                        <td>
                        	<input type="text" id="phoneNumberId" name="generalCondition.phoneNumber" value="${malariaDto.generalCondition.phoneNumber}"
                                   reg='{"required":"true","phone":"true"}' style="width: 100px;"/>
                        </td>                       
                    </tr>
					<tr>
				       	<th><label class="required">常住类型:</label></th>
				       	<td colspan="5">
				 			<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
				           		value="${malariaDto.generalCondition.floatPopulation}" onchange="drugreg.toggerAddress()"/>
				       	</td>
		       		</tr>
	        		<tr>
		            	<th><label class="required">详细住址:</label></th>
			            <td colspan="5">
				        	<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
				            	villageValue="${malariaDto.generalCondition.pastreet}" townValue="${malariaDto.generalCondition.patownShip}" width="180px;" reg='{"required":"true"}' />
				            <div>
	                            <label id="tempPaValue">
	                                <ehr:dic code="${malariaDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                            </label>
					            	<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${malariaDto.generalCondition.pahouseNumber}"
					                	reg='{"maxlength":"50"}'  style="width: 180px;">
					         	<span id="spanPaNumber">(门牌号)</span>
				         	</div>
				        </td>
			     	</tr>                    
                    <tr>
                        <th><label class="required">发病日期:</label></th>
                        <td>
                        	<input type="hidden" name="attackCondition.id" value="${malariaDto.attackCondition.id}"/>
                        	<tag:dateInput nullToToday="true" id="pathogenesisDateId" name="attackCondition.pathogenesisDate" style="width: 100px;"
                        		reg='{"required":"true"}'  pattern="yyyy/MM/dd" date="${malariaDto.attackCondition.pathogenesisDate}" onlypast="true"></tag:dateInput>
                        </td>
                        <th><label class="required">首诊日期:</label></th>
                        <td>
                        	<tag:dateInput nullToToday="true" id="firstVisitDateId" name="attackCondition.firstVisitDate" style="width: 100px;"
                        		reg='{"required":"true","compare":["pathogenesisDateId","ge","首诊日期不能小于发病日期"]}'  pattern="yyyy/MM/dd" date="${malariaDto.attackCondition.firstVisitDate}" onlypast="true"></tag:dateInput>
                        </td>
                        <th><label class="required">诊断日期:</label></th>
                        <td>
                        	<input type="hidden" name="diagnosis.id" value="${malariaDto.diagnosis.id}"/>
                        	<tag:dateInput nullToToday="true" id="diagnosisDtId" name="diagnosis.diagnosisDt" style="width: 100px;"
                        		reg='{"required":"true","compare":["pathogenesisDateId","ge","诊断日期不能小于发病日期"]}'  pattern="yyyy/MM/dd" date="${malariaDto.diagnosis.diagnosisDt}" onlypast="true"></tag:dateInput>
                        </td>                                                
                    </tr>
                    <tr>
                        <th><label class="required">治疗日期:</label></th>
                        <td>
                        	<input type="hidden" name="otherCondition.id" value="${malariaDto.otherCondition.id}"/>
                        	<tag:dateInput nullToToday="true" id="thisDtId" name="otherCondition.thisDt" style="width: 100px;"
                        		reg='{"required":"true","compare":["pathogenesisDateId","ge","治疗日期不能小于发病日期"]}'  pattern="yyyy/MM/dd" date="${malariaDto.otherCondition.thisDt}" onlypast="true"></tag:dateInput>
                        <th><label class="required">治疗方法:</label></th>
                        <td colspan="3">
                        	<input type="text" id="treatMethodId" name="otherCondition.treatMethod" value="${malariaDto.otherCondition.treatMethod}"
                                   reg='{"required":"true","maxlength":"200"}' style="width: 99%;"/>                        
                        </td>                        		
                    </tr>
                    <tr>
                        <th><label class="required">督导服药人:</label></th>
                        <td>
                        	<input type="text" id="supervisorUserId" name="otherCondition.supervisorUser" value="${malariaDto.otherCondition.supervisorUser}"
                                   reg='{"required":"true","maxlength":"50"}' style="width: 100px;"/>
                        </td>
                        <th><label class="required">服药是否规范:</label></th>
                        <td>
				 			<ehr:dic-radio name="otherCondition.drugNorm" dicmeta="PH00001" code="1,2" reg='{"required":"true"}' 
				           		value="${malariaDto.otherCondition.drugNorm}"/>
                        </td>  
                        <td></td>
                        <td></td>                       		
                    </tr>                    
                    <tr>
                        <th><label class="required">诊断单位:</label></th>
                        <td colspan="3">
							<ehr:org-type-list name="diagnosis.diagnosisUnit" type="hospital,centre"  value="${malariaDto.diagnosis.diagnosisUnit}"  width="300px" reg='{"required":"true"}' />
                        </td>
                        <th><label class="required">诊断医生:</label></th>
                        <td>
                        	<input type="hidden" name="diagnosis.diagnosisDoctor" value="${malariaDto.diagnosis.diagnosisDoctor}" style="width:120px"
                                   reg='{"required":"true","maxlength":"50"}'/>
                            <ehr:user userCode="${malariaDto.diagnosis.diagnosisDoctor}"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
            	<legend>督导服药</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 180px; width: 35%;"/>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 180px; width: 35%;"/>                        
                    </colgroup>
                    <tbody>
	                    <tr>
	                        <th><label class="required">抗疟治疗类型:</label></th>
	                        <td>
		                       	<ehr:dic-list id="caseTypeId" name="otherCondition.caseType" dicmeta="IDM00268" value="${malariaDto.otherCondition.caseType}" reg='{"required":"true"}' width="200px"
		                            	code="1,2,3"/>
		                        </td>
	                        <th><label class="required">镜检/RDT结果:</label></th>
	                        <td>
	                        	<input type="hidden" name="labExamine.id" value="${malariaDto.labExamine.id}"/>
	                        	<input type="hidden" name="labExamine.testResult" value="${malariaDto.labExamine.testResult}"/>
		                       	<ehr:dic-list id="rdtId" name="labExamine.rdt" dicmeta="IDM00263" value="${malariaDto.labExamine.rdt}" reg='{"required":"true"}' width="200px"
		                            	code="2,3,4,5"/>
                                <input type="hidden" name="labExamine.testDt" value='<fmt:formatDate value="${malariaDto.labExamine.testDt}" pattern="yyyy/MM/dd" />'/>
	                        </td>                        
	                    </tr>                    
                    </tbody>
                </table>
                <br>
				<div class="toolbarsublist">
				    <a href="javascript:void(0)" id="addRecord" ><b class="xinz">新增服药记录</b></a>
				</div>
				<div id ="childDiv" class="repeattable">
					<table id="sdTable">
						<colgroup>
							<col style="width:15%;"/>
							<col style="width:15%;"/>
							<col style="width:15%;"/>
							<col style="width:15%;"/>
							<col style="width:15%;"/>
						</colgroup>	
						<thead>
							<tr>
						        <th class="centerth">用药时间</th>
						        <th class="centerth">药物名称</th>
						        <th class="centerth">成人剂量</th>
						        <th class="centerth">实用剂量</th>
						        <%--<th class="centerth">患者本人签名</th>--%>
						        <th class="centerth">操作</th>	        
							</tr>
						</thead>
						<tbody>
							<c:forEach var="drugreg" items="${drugregs}" varStatus="status1">
								<tr item="${status1.count}">
									<td field="drugDtStr" rowspan="${fn:length(drugreg.listSds)}"><ehr:tip><fmt:formatDate value="${drugreg.drugDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
									<c:forEach var="sd" items="${drugreg.listSds}" varStatus="status2">
											<c:if test="${status2.count != 1 }">
												<tr item="${status1.count}">
											</c:if>
											<td field="drugDt" style="display:none;"><fmt:formatDate value="${drugreg.drugDt}" pattern="yyyy/MM/dd" /></td>
											<td field="drugName"><ehr:tip>${sd.drugName}</ehr:tip></td>
											<td field="adultMetering"><ehr:tip>${sd.adultMetering}</ehr:tip></td>
											<td field="practicalMetering"><ehr:tip>${sd.practicalMetering}</ehr:tip></td>
											<%--<td field=patientName><ehr:tip>${sd.patientName}</ehr:tip></td>--%>
											<c:if test="${status2.count == 1}">
												<td class="btnsublist" field="btn" rowspan="${fn:length(drugreg.listSds)}">
													<a href="javascript:void(0)" onclick='drugreg.editTr(this)'>修改</a>				
													<a href="javascript:void(0)" onclick="drugreg.removeTr(this)" >删除</a>
												</td>
											</c:if>
											</tr>
									</c:forEach>
							</c:forEach>
						</tbody>
					</table>
				</div>
                <br/>
                <table>
                    <tr>
                        <td style="border: solid #ffffff 0px;">
                            <label class="required">试治病例抗疟治疗是否有效:</label>
                            <ehr:dic-radio name="otherCondition.valid" dicmeta="IDM00074" value="${malariaDto.otherCondition.valid}" reg='{"required":"true"}' code="1,3"/>
                        </td>
                    </tr>
                </table>
                <br>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 20%;"/>                        	                        
                    </colgroup>                                                        
	                    <tr>
	                        <th><label class="required">督导服药人:</label></th>
	                        <td>
	                        	<input type="hidden" name="caseInformation.id" value="${malariaDto.caseInformation.id}"/>
	                        	<input type="hidden" name="caseInformation.dutyDoctor" value="${malariaDto.caseInformation.dutyDoctor}" style="width:120px"
	                                   reg='{"required":"true","maxlength":"50"}'/>
                                <ehr:user userCode="${malariaDto.caseInformation.dutyDoctor}"/>
	                        </td>
	                        <th>上报单位:</th>
	                        <td>
	                        	<ehr:org code="${malariaDto.caseInformation.reportOrg}"/>
	                        	<input type="hidden"  name="caseInformation.reportOrg" value="${malariaDto.caseInformation.reportOrg}"/>
	                        	<input type="hidden"  name="caseInformation.acceptUnit" value="${malariaDto.caseInformation.reportOrg}"/>
	                        </td>
	                        <th>上报日期:</th>
	                        <td>
	                        	<fmt:formatDate value="${malariaDto.caseInformation.reportDate}" pattern="yyyy/MM/dd" />
	                        	<input type="hidden"  name="caseInformation.reportDate" value="<fmt:formatDate value="${malariaDto.caseInformation.reportDate}" pattern="yyyy/MM/dd" />"/>
	                        </td>		                        
	                    </tr>		                                        
                    </tbody>
                </table>					               
            </fieldset>
        </div>
    </div>
</form>
