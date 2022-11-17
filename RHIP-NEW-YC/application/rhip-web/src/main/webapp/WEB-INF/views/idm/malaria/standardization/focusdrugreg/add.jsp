<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/idm/malaria/fgrestdrugreg.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:fgrestdrugreg.returnSearch()"><b class="fanhui">返回</b></a>
    <a href="javascript:void(0)" onclick="javascript:fgrestdrugreg.drugregSubmit()"><b class="baocun">保存</b></a>
    <c:if test="${not empty malariaDto.listFg.id}">
   		<a href="javascript:void(0)" onclick="javascript:fgrestdrugreg.exportFg(${malariaDto.listFg.id})"><b class="dayin">打印预览</b></a>
    </c:if>
</div>

<form id="drugregForm">
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" name="listFg.id" value="${malariaDto.listFg.id}"/>
	<input type="hidden" id="patientIdmId" name="listFg.contactPatientId" value="${malariaDto.listFg.contactPatientId}"/>
	<input type="hidden" id="acceptTownId" name="listFg.acceptTown" value="${malariaDto.listFg.acceptTown}"/>
	<input type="hidden" id="acceptUnitId" name="listFg.acceptUnit" value="${malariaDto.listFg.acceptUnit}"/>  
    <input type="hidden" name="listSdJson" id="listSdJson">	
    <div class="postcontent">
        <i class="popno">重点人群休止期督导服药登记表 </i>
        <div class="postdiv">
        	<fieldset>
        		<legend>患者信息</legend>
 				<table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 20%;"/>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 50%;"/>
                    </colgroup>
                    <tbody>
	             		<tr>
							<td colspan="4">
								<div class="toolbarsublist">
									<a href="javascript:void(0)" onclick="javascript:fgrestdrugreg.choosePatient()"><b class="search">选择患者</b></a>
								</div>
							</td>                    	
	                    </tr>                    
	             		<tr>
	                    	<th><label class="required">患者姓名:</label></th>
	                    	<td>
								<input type="text" id="patientNameId" name="listFg.patientName" value="${malariaDto.listFg.patientName}" 
	                        		style="width: 100px; background:#F0F0F0; border:0;" reg='{"required":"true","maxlength":"50"}' readonly="readonly" />                    		
	                    	</td>
	                    	<th>患者身份证:</th>
	                    	<td>
								<input type="text" id="patientIdcardId" name="listFg.patientIdcard" value="${malariaDto.listFg.patientIdcard}" 
	                        		style="width: 150px; background:#F0F0F0; border:0;" reg='{"maxlength":"50"}' readonly="readonly" />                    		
	                    	</td>	                    	
	                    </tr>
                   	</tbody>
            	</table>        		
        	</fieldset>
        	<fieldset>
        		<legend>人群信息</legend>
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
                        <th><label class="required">休治对象:</label></th>
                        <td colspan="3">
                            <ehr:dic-radio id="restObjectId" name="listFg.restObject" dicmeta="IDM00272" code="1,2,3,99"  reg='{"required":"true"}'
                                           value="${malariaDto.listFg.restObject}" onchange="fgrestdrugreg.getPatient()"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">姓名:</label></th>
                        <td>
                        	<input type="text" id="fgNameId" name="listFg.name" value="${malariaDto.listFg.name}" 
                        		style="width: 100px;" reg='{"required":"true","maxlength":"50"}'/>
                        </td>
                        <th>家长姓名:</th>
                        <td>
                        	<input type="text" id="parentsName" name="listFg.parentsName" value="${malariaDto.listFg.parentsName}" 
                        		style="width: 100px;" reg='{"maxlength":"50"}'/>
                        </td>                        
                        <th><label class="required">性别:</label></th>
                        <td>
                        	<ehr:dic-radio name="listFg.gender" dicmeta="GBT226112003" value="${malariaDto.listFg.gender}"  reg='{"required":"true"}' code="1,2"/>
                        </td>
                     </tr>
                    <tr>
                        <th><label class="required">年龄:</label></th>
                        <td>
                        	<input type="text" id="age" name="listFg.age" value="${malariaDto.listFg.age}" 
                        		style="width: 100px;" reg='{"required":"true","digits":"true","maxlength":"20"}'/>
                        </td>
                        <th><label class="required">体重:</label></th>
                        <td>
                        	<input type="text" id="weight" name="listFg.weight" value="${malariaDto.listFg.weight}" 
                        		style="width: 100px;" reg='{"required":"true","digits":"true","maxlength":"20"}'/>&nbsp;Kg
                        </td>
                        <th><label class="required">联系电话:</label></th>
                        <td>
                            <input type="text" id="phoneNumberId" name="listFg.phoneNumber" value="${malariaDto.listFg.phoneNumber}"
                                   reg='{"required":"true","phone":"true"}' style="width: 100px;"/>
                        </td>
                    </tr>
	        		<tr>
		            	<th><label class="required">详细住址:</label></th>
			            <td colspan="5">
				        	<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="listFg.pastreet" townName="listFg.patownShip"
				            	villageValue="${malariaDto.listFg.pastreet}" townValue="${malariaDto.listFg.patownShip}" width="180px;" reg='{"required":"true"}'/>
				            <div>
	                            <label id="tempPaValue">
	                                <ehr:dic code="${malariaDto.listFg.patownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.listFg.pastreet}" dicmeta="FS990001"/>
	                            </label>
	                            <input type="text" id="pahomeNumber" name="listFg.pahomeNumber" value="${malariaDto.listFg.pahomeNumber}"
					                	reg='{"required":"true","maxlength":"50"}'  style="width: 180px;">
					         	<span id="spanPaNumber">(门牌号)</span>
				         	</div>
				        </td>
			     	</tr>
                    <tr>
                        <th><label class="required">督导服药人:</label></th>
                        <td colspan="3">
                        	<input type="text" id="dutyDoctorId" name="listFg.dutyDoctor" value="${malariaDto.listFg.dutyDoctor}"
                                   reg='{"required":"true","maxlength":"50"}' style="width: 100px;"/>   
                        </td>                        
                        <th><label class="required">服药是否规范:</label></th>
                        <td>
				 			<ehr:dic-radio name="listFg.drugNorm" dicmeta="PH00001" code="1,2" reg='{"required":"true"}' 
				           		value="${malariaDto.listFg.drugNorm}"/>
                        </td>  
                    </tr>                    
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
            	<legend>督导服药</legend>
                <table>
                    <tr>
                        <td style="border: solid #ffffff 0px;">
                            <span><label class="required">是否为应服对象:</label></span>
                            <ehr:dic-radio id="drugObjectId" name="listFg.drugObject" dicmeta="PH00001" value="${malariaDto.listFg.drugObject}" reg='{"required":"true"}'
                                           onchange="toggleOther('listFg.drugObject','spanDrugObjectId','2');toggleOther('listFg.noObjectResult','spannoObjectResultId','99')" code="1,2"/>
                            <span id="spanDrugObjectId">
                                    &nbsp;&nbsp;&nbsp;(如否请注明原因:
                                    <ehr:dic-radio id="noObjectResultId" name="listFg.noObjectResult" dicmeta="IDM00270" value="${malariaDto.listFg.noObjectResult}" reg='{"required":"true"}'
                                                      onchange="toggleOther('listFg.noObjectResult','spannoObjectResultId','99')"  code="1,2,99"/>
                                    <span id="spannoObjectResultId" style="display:none;">
                                        <input type="text" id="noObjectOtherId" name="listFg.noObjectOther" value="${malariaDto.listFg.noObjectOther}" reg='{"maxlength":"100"}' style="width:140px;"/>
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
							<c:forEach var="drugreg" items="${fgrestdrugregs}" varStatus="status">
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
										<a href="javascript:void(0)" onclick='fgrestdrugreg.popupRecord(this,"edit")'>修改</a>				
										<a href="javascript:void(0)" onclick="fgrestdrugreg.removeTr(this);" >删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
                <br/>
                <table>
                    <tr>
                        <td style="border: solid #ffffff 0px;">
                            <span><label class="required">未全程规范服药原因:</label></span>
                            <ehr:dic-radio name="listFg.noWholeResult" dicmeta="IDM00271" code="1,2,3,99"  reg='{"required":"true"}'
                                           onchange="toggleOther('listFg.noWholeResult','spannoWholeResultId','99')" value="${malariaDto.listFg.noWholeResult}"/>
                            <span id="spannoWholeResultId">
                                <input type="text" id="noWholeOtherId" name="listFg.noWholeOther" value="${malariaDto.listFg.noWholeOther}" reg='{"maxlength":"100"}' style="width:140px;"/>&nbsp;(请注明)
                            </span>
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
	                        <th>休止期督导服药人:</th>
	                        <td>
	                        	<!--<ehr:staff-list name="listFg.restDutyDoctor" value="${malariaDto.listFg.restDutyDoctor}" style="width:120px" reg='{"required":"true"}'/>-->
	                        	<input type="hidden" name="listFg.restDutyDoctor" value="${malariaDto.listFg.restDutyDoctor}" style="width:120px"
	                                   reg='{"required":"true","maxlength":"50"}'/>
                                <ehr:user userCode="${malariaDto.listFg.restDutyDoctor}"/>

                            </td>
	                        <th>上报单位:</th>
	                        <td>
	                        	<ehr:org code="${malariaDto.listFg.reportOrg}"/>
	                        	<input type="hidden"  name="listFg.reportOrg" value="${malariaDto.listFg.reportOrg}"/>
	                        </td>
	                        <th>上报日期:</th>
	                        <td>
	                        	<fmt:formatDate value="${malariaDto.listFg.reportDate}" pattern="yyyy/MM/dd" />
	                        	<input type="hidden"  name="listFg.reportDate" value="<fmt:formatDate value="${malariaDto.listFg.reportDate}" pattern="yyyy/MM/dd" />"/>
	                        </td>		                        
	                    </tr>		                                        
                    </tbody>
                </table>					               
            </fieldset>
        </div>
    </div>
</form>
