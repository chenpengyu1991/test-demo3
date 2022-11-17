<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/idm/malaria/restdrugreg.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:restdrugreg.returnSearch()"><b class="fanhui">返回</b></a>
	<c:if test="${logoff != '1'}">
    	<a href="javascript:void(0)"onclick="javascript:restdrugreg.drugregSubmit()"><b class="baocun">保存</b></a>
    </c:if>
    <c:if test="${not empty malariaDto.singleId}">
		<a href="javascript:void(0)" onclick="javascript:restdrugreg.exportDrugreg(${malariaDto.idmId})"><b class="dayin">打印预览</b></a>
	</c:if>
    
</div>

<form id="restDrugregForm">
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" name="singleId" value="${malariaDto.singleId}"/>
	<input type="hidden" name="idmId" value="${malariaDto.idmId}"/>
	<input type="hidden" id="type" name="type" value="${type}"/>
	<input type="hidden" id="logoff" value="${logoff}"/>
    <input type="hidden" id="specialStatusId" name="specialStatus" value="${malariaDto.specialStatus}"/>
    <input type="hidden" name="listSdJson" id="listSdJson">	
    <div class="postcontent">
        <i class="popno">间日疟休止期根治督导服药登记表 </i>
        <div class="postdiv">
        	<fieldset>
        		<legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 120px; width: 12%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 120px; width: 12%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 120px; width: 12%;"/>
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
                        	<input type="text" id="weight" name="clinicalManifestations.weight" value="${malariaDto.clinicalManifestations.weight}"
                        		style="width: 100px;" reg='{"required":"true","digits":"true","maxlength":"20"}'/>&nbsp;Kg
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
				 			<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
				           		value="${malariaDto.generalCondition.floatPopulation}" onchange="restdrugreg.toggerAddress()" reg='{"required":"true"}'/>
				       	</td>
		       		</tr>
	        		<tr>
		            	<th><label class="required">详细住址:</label></th>
			            <td colspan="5">
				        	<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
				            	villageValue="${malariaDto.generalCondition.pastreet}" townValue="${malariaDto.generalCondition.patownShip}" width="160px;" reg='{"required":"true"}'/>
                            <div>
	                            <label id="tempPaValue">
	                                <ehr:dic code="${malariaDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                            </label>
	                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${malariaDto.generalCondition.pahouseNumber}"
					                	reg='{"maxlength":"50"}'  style="width: 120px;">
					         	<span id="spanPaNumber">(门牌号)</span>
				         	</div>
				        </td>
			     	</tr>
                    <tr>
                        <th><label class="required">发病日期:</label></th>
                        <td>
                        	<input type="hidden" name="attackCondition.id" value="${malariaDto.attackCondition.id}"/>
                        	<tag:dateInput nullToToday="true" id="pathogenesisDateId" name="attackCondition.pathogenesisDate" style="width: 100px;"
                        		reg='{"required":"true","regex":"date"}'  pattern="yyyy/MM/dd" date="${malariaDto.attackCondition.pathogenesisDate}" onlypast="true"></tag:dateInput>
                        </td>
                        <th><label class="required">诊断日期:</label></th>
                        <td>
                        	<input type="hidden" name="diagnosis.id" value="${malariaDto.diagnosis.id}"/>
                        	<tag:dateInput nullToToday="true" id="diagnosisDtId" name="diagnosis.diagnosisDt" style="width: 100px;"
                        		reg='{"required":"true","compare":["pathogenesisDateId","ge","诊断日期不能小于发病日期"]}'  pattern="yyyy/MM/dd" date="${malariaDto.diagnosis.diagnosisDt}" onlypast="true"></tag:dateInput>
                        </td>   
                        <th><label class="required">诊断单位:</label></th>
                        <td colspan="3">
							<ehr:org-type-list name="diagnosis.diagnosisUnit" type="hospital,centre"  value="${malariaDto.diagnosis.diagnosisUnit}"  width="100px" reg='{"required":"true"}'/>
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
				 			<ehr:dic-radio name="otherCondition.drugNorm" dicmeta="PH00001" code="1,2"  reg='{"required":"true"}'
				           		value="${malariaDto.otherCondition.drugNorm}"/>
                        </td>  
                        <td></td>
                        <td></td>                       		
                    </tr>                    
                    </tbody>
                </table>
            </fieldset>
            <fieldset class="topfield">
            	<legend>督导服药</legend>
                <table>
                    <tr>
                        <td>
                            <span><label class="required">是否为应服对象:</label></span>
                            <ehr:dic-radio id="drugObjectId" name="otherCondition.drugObject" dicmeta="PH00001" value="${malariaDto.otherCondition.drugObject}" reg='{"required":"true"}'
                                           onchange="toggleOther('otherCondition.drugObject','spanDrugObjectId','2');toggleOther('otherCondition.noObjectResult','spannoObjectResultId','99')" code="1,2"/>
                            <span id="spanDrugObjectId">
                                    &nbsp;&nbsp;&nbsp;(如否请注明原因:
                                    <ehr:dic-radio id="noObjectResultId" name="otherCondition.noObjectResult" dicmeta="IDM00270" value="${malariaDto.otherCondition.noObjectResult}" reg='{"required":"true"}'
                                                      onchange="toggleOther('otherCondition.noObjectResult','spannoObjectResultId','99')"  code="1,2,99"/>
                                    <span id="spannoObjectResultId" style="display:none;">
                                        <input type="text" id="noObjectOtherId" name="otherCondition.noObjectOther" value="${malariaDto.otherCondition.noObjectOther}" reg='{"maxlength":"100"}' style="width:140px;"/>
                                    </span>)
                            </span>
                        </td>
                    </tr>
                </table>
                <br>
				<div class="toolbarsublist">
				    <a href="javascript:void(0)" id="addRecord" ><b class="xinz">新增督导服药</b></a>
				</div>
				<div id ="childDiv" class="repeattable">
					<table id="sdTable">
						<colgroup>
							<col style="width:15%;"/>
							<col style="width:20%;"/>
							<col style="width:5%;"/>
							<col style="width:5%;"/>
							<col style="width:5%;"/>
							<col style="width:5%;"/>
							<col style="width:5%;"/>
							<col style="width:5%;"/>																																			
							<col style="width:20%;"/>
							<col style="width:15%;"/>
						</colgroup>	
						<thead>
							<tr>
						        <th class="centerth" rowspan="2">服药日期</th>
						        <th class="centerth" rowspan="2">药物(片)</th>
						        <th class="centerth" colspan="6">年龄(周岁)</th>
						        <th class="centerth" rowspan="2">患者签名</th>
						        <th class="centerth" rowspan="2">操作</th>	        
							</tr>
							<tr>
						        <th class="centerth">1-(&frac12;)</th>
						        <th class="centerth">4-(1)</th>
						        <th class="centerth">7-(1&frac12;)</th>
						        <th class="centerth">10-(2)</th>
						        <th class="centerth">13-(2&frac12;)</th>	
						        <th class="centerth">16-(3)</th>						                
							</tr>							
						</thead>
						<tbody>
							<c:forEach var="drugreg" items="${restdrugregs}" varStatus="status">
								<tr item="${status.count}">
									<td field="drugDt"><ehr:tip><fmt:formatDate value="${drugreg.drugDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
									<td field="drugName"><ehr:tip>${drugreg.drugName}</ehr:tip></td>
									<td field="ageDose"  style="display:none;">${drugreg.ageDose}</td>
									<td field="ageDoseStr1" style="text-align:center;">
										<c:if test="${drugreg.ageDose == '1'}">√</c:if>
									</td>
									<td field="ageDoseStr2" style="text-align:center;">
										<c:if test="${drugreg.ageDose == '2'}">√</c:if>					
									</td>
									<td field="ageDoseStr3" style="text-align:center;">
										<c:if test="${drugreg.ageDose == '3'}">√</c:if>
									</td>
									<td field="ageDoseStr4" style="text-align:center;">
										<c:if test="${drugreg.ageDose == '4'}">√</c:if>
									</td>	
									<td field="ageDoseStr5" style="text-align:center;">
										<c:if test="${drugreg.ageDose == '5'}">√</c:if>
									</td>
									<td field="ageDoseStr6" style="text-align:center;">
										<c:if test="${drugreg.ageDose == '6'}">√</c:if>
									</td>																										
									<td field=patientName><ehr:tip>${drugreg.patientName}</ehr:tip></td>
									<td class="btnsublist" field="btn">
										<a href="javascript:void(0)" onclick='restdrugreg.popupRecord(this,"edit")'>修改</a>				
										<a href="javascript:void(0)" onclick="restdrugreg.removeTr(this);" >删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
                <br/>
                <table>
                    <tr>
                        <td>
                            <span><label class="required">未全程规范服药原因:</label></span>
                            <ehr:dic-radio name="otherCondition.noWholeResult" dicmeta="IDM00271" code="1,2,3,99"  uninclude=""
                                           reg='{"required":"true"}'
                                           onchange="toggleOther('otherCondition.noWholeResult','spannoWholeResultId','99')"
                                           value="${malariaDto.otherCondition.noWholeResult}"/>
                            <span id="spannoWholeResultId">
                                <input type="text" id="noWholeOtherId" name="otherCondition.noWholeOther"
                                        value="${malariaDto.otherCondition.noWholeOther}" reg='{"maxlength":"100"}'
                                        style="width:140px;"/>&nbsp;(请注明)
                            </span>
                        </td>
                    </tr>
                </table>
                <br>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 120px; width: 16%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 120px; width: 12%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 120px; width: 12%;"/>
                        <col style="min-width: 120px; width: 20%;"/>                        	                        
                    </colgroup>                                                        
	                    <tr>
	                        <th><label class="required">休止期督导服药人:</label></th>
	                        <td>
	                        	<input type="hidden" name="caseInformation.id" value="${malariaDto.caseInformation.id}"/>
	                        	<input type="hidden" name="caseInformation.dutyDoctor" value="${malariaDto.caseInformation.dutyDoctor}" style="width:120px"
	                                   reg='{"maxlength":"50"}'/>
                                <ehr:user userCode="${malariaDto.caseInformation.dutyDoctor}"/>
                            </td>
	                        <th>上报单位:</th>
	                        <td>
	                        	<ehr:org code="${malariaDto.caseInformation.reportOrg}"/>
	                        	<input type="hidden"  name="caseInformation.reportOrg" value="${malariaDto.caseInformation.reportOrg}"/>
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
