<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/typhia.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    伤寒、副伤寒个案调查表<br/>
		    <span>（乙类传染病）</span>
		</i>
		
		<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
		<input type="hidden" id="leList" name="leList">
		<input type="hidden" value="typhia" id="reportDiseasesId"/>
		<div class="postdiv">
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 50%"/>
			            <col style="width: 50%"/>
			        </colgroup>
			        <tr>
			            <td style="text-align: left;">地区国标编码：<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" reg='{"length":"8"}' style="width: 180px;"/></td>
			            <td style="text-align: right;">病例编码：<input type="text" name="caseInformation.mediRecordNum" reg='{"length":"7"}' value="${caseDto.caseInformation.mediRecordNum}" style="width: 180px;"/></td>
			        </tr>
			    </table>
			<fieldset>
			    <legend>1．一般情况</legend>
			    <table class="posttable">
			         <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>1.1 姓名：</th>
			            <td colspan="3">
			   				<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" 
			   				style="width: 100px;" reg='{"maxlength":"100"}'/>
			            	若为14 岁以下儿童，家长姓名<input type="text" id="parentsName" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                   reg='{"maxlength":"50"}' style="width: 100px;"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.2 性别：</th>
			            <td>
			            	<ehr:dic-radio  dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			            </td>
			             <th>1.3 年龄：</th>
			            <td>
                            <input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                                            reg='{"maxlength":"6"}' cssClass="width30" style="width: 6%;"/>
			            	 <ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"  dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.4 职业：</th>
			            <td colspan="3">
			                <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,4-3,CV020120207,CV020120208,CV020120209,CV020120211,CV020120210,CV020120212,CV020120213,CV020120215,CV020120216,CV020120299,CV020120217,CV020120214"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>
			            	 <span  id="occupationPart" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 30%;"/>
		                     </span>
			            </td>
			            
			        </tr>
			        <tr>
			        	<th>1.5 文化程度：</th>
			            <td>
			                <ehr:dic-list dicmeta="GBT46582006" code="IDM06,IDM09,IDM07,IDM02,IDM03,IDM08,IDM10" name="generalCondition.education" value="${caseDto.generalCondition.education}"/>
			            </td>
			        </tr>
			        <tr>
				       	<th>1.6 常住类型：</th>
				       	<td>
				 		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
				           		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
				       	</td>
			       </tr>
			        <tr>
			            <th>1.7 现住址：</th>
			            <td colspan="3">
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
			                        reg='{"maxlength":"50"}'  style="width: 180px;">
			             	<span id="spanPaNumber">(门牌号)</span>
			             </td>
			        </tr>
					<tr>
						<th>1.8 户籍地址：</th>
						<td colspan="3">
							<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
	                           			reg='{"maxlength":"100"}'  style="width: 180px;">
						</td>
					</tr>
			        <tr>
			            <th>1.9 工作（学习）单位：</th>
			            <td colspan="3">
			                <input reg='{"maxlength":"70"}' type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.10 联系人：</th>
			            <td colspan="3">
			                <input type="text" name="generalCondition.contactName" value="${caseDto.generalCondition.contactName}" reg='{"maxlength":50}' style="width: 20%"/>
			                     联系电话（办）<input type="text" name="generalCondition.unitPhone" value="${caseDto.generalCondition.unitPhone}" reg='{"regex":"phone","maxlength":20}' style="width: 15%"/>
			               	（宅）<input type="text" name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}" reg='{"regex":"phone","maxlength":20}' style="width: 15%"/>
			                （手机）<input type="text" name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}" reg='{"regex":"phone","maxlength":20}' style="width: 15%"/>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			
			<fieldset>
			    <legend>2．发病情况</legend>
			    <table class="posttable">
			         <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>2.1 发病日期：</th>
			            <td>
			            	<tag:dateInput id="pathogenesisDate" nullToToday="true" name="attackCondition.pathogenesisDate" onlypast="true"
						         reg='{"compare":["clinicDate","le","发病日期不能大于就诊日期"]}' pattern="yyyy/MM/dd HH" date="${caseDto.attackCondition.pathogenesisDate }"/>时
						         <input type="hidden" id="pathogenesisHour" name="attackCondition.pathogenesisHour">
						</td>
						 <th>2.2 发病地点：</th>
			             <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>2.3 首诊时间：</th>
			           <td>
			                <tag:dateInput id="firstVisitDate" nullToToday="true" name="attackCondition.firstVisitDate"  onlypast="true"
			                    reg='{"compare":["pathogenesisDate","ge","首诊时间不能小于发病日期"]}' pattern="yyyy/MM/dd HH" date="${caseDto.attackCondition.firstVisitDate }"/>时
			            	<input type="hidden" id="firstVisitHour" name="attackCondition.firstVisitHour">
			            </td>
			             <th>2.4 首诊单位：</th>
			             <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>2.5 诊断医院：</th>
			            <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"/>
			            </td>
		             	<th>2.6 报告时间：</th>
			            <td>
                            <tag:dateInput id="reportDate" nullToToday="true" name="caseInformation.reportDate" onlypast="true"
			                  reg='{"compare":["pathogenesisDate","ge","报告时间不能小于发病日期"]}' pattern="yyyy/MM/dd HH" date="${caseDto.caseInformation.reportDate}"/>时
			            	<input type="hidden" id="reportDateHM" name="caseInformation.reportDateHM">
			            </td>
			        </tr>
			        <tr>
			            <th>2.7 是否住院：</th>
			             <td colspan="3">
			            	<ehr:dic-radio dicmeta="PH00002" name="otherCondition.inpatientFlg" code="1,2" value="${caseDto.otherCondition.inpatientFlg}"
				            	onchange="toggleOther('otherCondition.inpatientFlg','inpatientFlgTd',1)"/>
			            </td>
			        </tr>
			         <tr style="display: none;" id="inpatientFlgTd">
			         	 <td colspan="4" style="padding: 0px;">
				        	<table>
			        			<colgroup>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						        </colgroup>
			        			<tr>
			        			   <th>2.7.1 住院时间：</th>
						           <td>
							           <tag:dateInput id="inhosTime" nullToToday="true" name="otherCondition.inhosTime" onlypast="true" pattern="yyyy/MM/dd"
							            	reg='{"compare":["pathogenesisDate","ge","住院时间不能小于发病日期"]}' date="${caseDto.otherCondition.inhosTime}"/>
							       </td>
						           
						           <th>2.7.2 出院时间：</th>
						           <td>
						                <tag:dateInput nullToToday="true" name="otherCondition.outhosDate" onlypast="true" pattern="yyyy/MM/dd"
					             			reg='{"compare":["inhosTime","ge","出院时间不能小于 住院时间"]}' date="${caseDto.otherCondition.outhosDate}"/>
					             </td>
					             </tr>
			        		</table>
			        	</td>
				    </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>3．临床资料</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>3.1 临床表现：</th>
			        </tr>
			   <%--      <tr>
			            <th>3.1.1 发热：</th>
			             <td colspan="3">
			             	<ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.fever}"
			             		onchange="toggleOther('clinicalManifestations.fever','heatingDurationTd',1)"/>
			             </td>
			        </tr>
			        <tr style="display: none;" id="heatingDurationTd">
			         	 <td colspan="4" style="padding: 0px;">
				        	<table>
			        			<colgroup>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						        </colgroup>
			        			<tr>
			        			   <th>3.1.1.1 发热持续：</th>
						            <td>
						            	<input type="text" name="clinicalManifestations.heatingDuration" value="${caseDto.clinicalManifestations.heatingDuration}"
																cssClass="width30" reg='{"maxlength":"20"}'/>天
						            </td>
						             <th>3.1.1.2 最高体温：</th>
						            <td>
										<input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}" 
		            	 					reg='{"maxlength":"20"}' style="width: 30%;"/>℃
									</td>
					             </tr>
					             <tr>
						           <th>3.1.1.3 热型：</th>
			            			<td colspan="3"><ehr:dic-radio dicmeta="IDM00195" code="1,2,4" name="clinicalManifestations.hotType"
			            				 value="${caseDto.clinicalManifestations.hotType}"/>
			            			</td>
						        </tr>
			        		</table>
			        	</td>
				    </tr> --%>
				    <tr>
        			   <th>3.1.1 发热持续：</th>
			            <td>
			            	<input type="text" name="clinicalManifestations.heatingDuration" value="${caseDto.clinicalManifestations.heatingDuration}"
													cssClass="width30" reg='{"maxlength":"20"}'/>天
			            </td>
			             <th>最高体温：</th>
			            <td>
							<input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}" 
           	 					reg='{"maxlength":"20"}' style="width: 30%;"/>℃
						</td>
		             </tr>
		             <tr>
			           <th>3.1.2 热型：</th>
            			<td colspan="3"><ehr:dic-radio dicmeta="IDM00195" code="1,2,4" name="clinicalManifestations.hotType"
            				 value="${caseDto.clinicalManifestations.hotType}"/>
            			</td>
			        </tr>
			         <tr>
			            <th>3.1.3有无如下症状与体征：</th>
			            <td colspan="3"><ehr:dic-checkbox dicmeta="IDM00609" code="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18" name="clinicalManifestations.sign"  value="${caseDto.clinicalManifestations.sign}"/></td>
			           
			        </tr>
			          <tr>
			            <th>3.2有无下列并发症：</th>
			            <td colspan="3"><ehr:dic-checkbox dicmeta="IDM00609" code="19,20,21"  name="clinicalManifestations.complications"  value="${caseDto.clinicalManifestations.complications}" onchange="toggleOtherCK('clinicalManifestations.complications','complications','21');"/>
			            <span id="complications" style="dispay:none;"><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"maxlength":"100"}' style="width: 100px;"/></span>
			            </td>
			           
			        </tr>
			       <%--  <tr>
			            <th>3.1.2 畏寒：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.chills" code="1,2" value="${caseDto.clinicalManifestations.chills}"/></td>
			            <th>3.1.3 头痛：</th>
			           <td><ehr:dic-radio name="clinicalManifestations.headache" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.headache}"/></td>
			        </tr>
			        <tr>
			            <th>3.1.4 头晕：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.dizziness" code="1,2" value="${caseDto.clinicalManifestations.dizziness}"/></td>
			       		<tr>
			            <th>3.1.5 腹痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.stomachache" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.stomachache}"/></td>
			        </tr>
			        <tr>
			            <th>3.1.6 腹胀：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.abdominalDistension" code="1,2" value="${caseDto.clinicalManifestations.abdominalDistension}"/></td>
			            <th>3.1.7 便秘：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.constipation" code="1,2" value="${caseDto.clinicalManifestations.constipation}"/></td>
			        </tr>
			        <tr>
			            <th>3.1.8 腹泻：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.diarrhea" code="1,2" value="${caseDto.clinicalManifestations.diarrhea}"/></td>
			       		<th>3.1.9 便血：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hemafecia" code="1,2" value="${caseDto.clinicalManifestations.hemafecia}"/></td>
			        </tr>
			        <tr>
			            <th>3.1.10 恶心：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.nausea" code="1,2" value="${caseDto.clinicalManifestations.nausea}"/></td>
			         	<th>3.1.11 呕吐：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.vomit" code="1,2" value="${caseDto.clinicalManifestations.vomit}"/></td>
			        
			         </tr>
			        <tr>
			            <th>3.1.12 表清淡漠：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.apathia" code="1,2" value="${caseDto.clinicalManifestations.apathia}"/></td>
			           <th>3.1.13 谵妄：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.delirium" code="1,2" value="${caseDto.clinicalManifestations.delirium}"/></td>
			        </tr>
			        <tr>
			            <th>3.1.14 昏迷：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.coma" code="1,2" value="${caseDto.clinicalManifestations.coma}"/></td>
			         	<th>3.1.15 相对缓脉：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.relativeBradycardia" code="1,2" value="${caseDto.clinicalManifestations.relativeBradycardia}"/></td>
			        </tr>
			           
			        <tr>
			            <th>3.1.16 玫瑰疹：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.roseola" code="1,2" value="${caseDto.clinicalManifestations.roseola}"/></td>
			         	<th>3.1.17 脾大：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.splenomegaly" code="1,2" value="${caseDto.clinicalManifestations.splenomegaly}"/></td>
			        </tr>
			        <tr>
			            <th>3.1.18 肝大：</th>
			            <td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hepatomegaly" code="1,2" value="${caseDto.clinicalManifestations.hepatomegaly}"/></td>
			        </tr>
			        <tr>
			            <th>3.2 有无下列并发症？：</th>
			            <td><ehr:dic-radio dicmeta="IDM00609" name="clinicalManifestations.enterorrhagia" code="1,2" value="${caseDto.clinicalManifestations.enterorrhagia}"/></td>			            
			        </tr> --%>
			      <%--   <tr>
			            <th>3.2.1 肠出血：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.enterorrhagia" code="1,2" value="${caseDto.clinicalManifestations.enterorrhagia}"/></td>
			            <th>3.2.2 肠穿孔：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.enterobrosis" code="1,2" value="${caseDto.clinicalManifestations.enterobrosis}"/></td>
			        </tr> --%>
			        <tr>
			        	<th>3.3 病人转归：</th>
			            <td><ehr:dic-radio dicmeta="IDM00005" code="1,4,5" name="clinicalManifestations.pasteurelleses" value="${caseDto.clinicalManifestations.pasteurelleses}"/></td>
			        </tr>
			        
			        <%-- <tr>
			            <th>3.2.3 其它（注明）：</th>
			            <td><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"maxlength":"100"}'/></td>
			        	<th>3.3 病人转归：</th>
			            <td><ehr:dic-radio dicmeta="IDM00005" code="1,4,5" name="clinicalManifestations.pasteurelleses" value="${caseDto.clinicalManifestations.pasteurelleses}"/></td>
			        </tr> --%>
			            
			        <tr>
			            <th>3.4 诊断依据：</th>
			        </tr>
			        <tr>
			            <th>3.4.1 确诊依据：</th>
			            <td><ehr:dic-radio dicmeta="IDM00106" name="clinicalManifestations.diagnosisL" value="${caseDto.clinicalManifestations.diagnosisL}"/></td>
			        </tr>
			        <tr>
			        	 <th>3.4.2 检验结果：</th>
					    <td colspan="3">
					    	<div class="repeattable">
						       	<div class="toolbarsublist">
						            	（1）培养（细菌型别）<a href="javascript:void(0)" id="addCultureList" ><b class="xinz">添加</b></a>
						        </div>
						        <table id="cultureTable">
						            <thead>
						                <tr>
						                	<th class="centerth" style="width: 10%">日期</th>
						                    <th class="centerth" style="width: 10%">血</th>
						                    <th class="centerth" style="width: 20%">粪</th>
						                    <th class="centerth" style="width: 20%">尿</th>
						                    <th class="centerth" style="width: 20%">其它</th>
						                    <th class="centerth" style="width: 10%;">操作</th>
						                </tr>
						            </thead>
						           <c:forEach var="culture" items="${caseDto.idmListLeList}" varStatus="status">
						           	   <c:choose>
											<c:when test="${empty culture.cultureDt && empty culture.blood && empty culture.dung 
													 && empty culture.urine && empty culture.other}"></c:when>
											<c:otherwise>
												<tr>
								                  <td field="cultureDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${culture.cultureDt}"/></ehr:tip></td>
								                  <td field="blood"><ehr:tip>${culture.blood}</ehr:tip></td>
								                  <td field="dung"><ehr:tip>${culture.dung}</ehr:tip></td>
								                  <td field="urine"><ehr:tip>${culture.urine}</ehr:tip></td>
								                  <td field="other"><ehr:tip>${culture.other}</ehr:tip></td>
								                  <td class="btnsublist" field="btn">
								                  	   <a href="javascript:void(0)" onclick="typhiaCase.editTr(this, 'cultureList')">修改</a>
								                       <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
								                  </td>
								              </tr>
											</c:otherwise>
										</c:choose>
					             </c:forEach>
						        </table>
						    </div>
						    <div class="repeattable">
						       	<div class="toolbarsublist">
						            	（2）肥达氏反应<a href="javascript:void(0)" id="addGrubersList" ><b class="xinz">添加</b></a>
						        </div>
						        <table id="grubersTable">
						            <thead>
						                <tr>
						                	<th class="centerth" style="width: 10%">日期</th>
						                    <th class="centerth" style="width: 10%">O</th>
						                    <th class="centerth" style="width: 20%">H</th>
						                    <th class="centerth" style="width: 20%">A</th>
						                    <th class="centerth" style="width: 10%">B</th>
						                    <th class="centerth" style="width: 10%">C</th>
						                    <th class="centerth" style="width: 10%;">操作</th>
						                </tr>
						            </thead>
						           <c:forEach var="grubers" items="${caseDto.idmListLeList}" varStatus="status">
										<c:choose>
											<c:when test="${empty grubers.o && empty grubers.grubersReactionDt && empty grubers.h  && empty grubers.a && empty grubers.b  && empty grubers.c }"></c:when>
											<c:otherwise>
												<tr>
									                  <td field=grubersReactionDt><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${grubers.grubersReactionDt}"/></ehr:tip></td>
									                  <td field="o"><ehr:tip>${grubers.o}</ehr:tip></td>
									                  <td field="h"><ehr:tip>${grubers.h}</ehr:tip></td>
									                  <td field="a"><ehr:tip>${grubers.a}</ehr:tip></td>
									                  <td field="b"><ehr:tip>${grubers.b}</ehr:tip></td>
									                   <td field="c"><ehr:tip>${grubers.c}</ehr:tip></td>
									                  <td class="btnsublist" field="btn">
									                  	   <a href="javascript:void(0)" onclick="typhiaCase.editTr(this, 'grubersList')">修改</a>
									                       <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
									                  </td>
									              </tr>
											</c:otherwise>
										</c:choose>
					             </c:forEach>
						        </table>
						    </div>
						     <div class="repeattable">
						       	<div class="toolbarsublist">
						            	（3）白细胞计数、分类<a href="javascript:void(0)" id="addCellList" ><b class="xinz">添加</b></a>
						        </div>
						        <table id="cellTable">
						            <thead>
						                <tr>
						                	<th class="centerth" style="width: 10%">日期</th>
						                    <th class="centerth" style="width: 10%">总数</th>
						                    <th class="centerth" style="width: 20%">中性</th>
						                    <th class="centerth" style="width: 20%">淋巴</th>
						                    <th class="centerth" style="width: 10%">嗜酸性</th>
						                    <th class="centerth" style="width: 10%">其它</th>
						                    <th class="centerth" style="width: 10%;">操作</th>
						                </tr>
						            </thead>
						           <c:forEach var="cell" items="${caseDto.idmListLeList}" varStatus="status">
						           		<c:choose>
											<c:when test="${empty cell.cellCategoryDt && empty cell.totality && empty cell.neutrophilcell 
													 && empty cell.lymphocyte && empty cell.eosinophils  && empty cell.otherResult}"></c:when>
											<c:otherwise>
												<tr>
									                  <td field="cellCategoryDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${cell.cellCategoryDt}"/></ehr:tip></td>
									                  <td field="totality"><ehr:tip>${cell.totality}</ehr:tip></td>
									                  <td field="neutrophilcell"><ehr:tip>${cell.neutrophilcell}</ehr:tip></td>
									                  <td field="lymphocyte"><ehr:tip>${cell.lymphocyte}</ehr:tip></td>
									                  <td field="eosinophils"><ehr:tip>${cell.eosinophils}</ehr:tip></td>
									                   <td field="otherResult"><ehr:tip>${cell.otherResult}</ehr:tip></td>
									                  <td class="btnsublist" field="btn">
									                  	   <a href="javascript:void(0)" onclick="typhiaCase.editTr(this, 'cellList')">修改</a>
									                       <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
									                  </td>
									              </tr>
											</c:otherwise>
										</c:choose>
					             </c:forEach>
						        </table>
						    </div>
					    </td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
			    <legend>4．流行病学调查</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 27%"/>
			            <col style="width: 23%"/>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			        </colgroup>
			        <tr>
			            <th>4.1 传染源和传播途径的追溯（病前1 个月）：</th>
			        </tr>
			        <tr>
			            <th>4.1.1 外出史：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.outHistory" code="1,2" value="${caseDto.epidemiologicalSurvey.outHistory}"
			            		onchange="toggleOther('epidemiologicalSurvey.outHistory','outHistoryTd',1)"/>
			            </td>
			        </tr>
			         <tr style="display: none;" id="outHistoryTd">
			         	 <td colspan="4" style="padding: 0px;">
				        	<table>
			        			<colgroup>
						            <col style="width: 27%"/>
						            <col style="width: 23%"/>
						            <col style="width: 25%"/>
						            <col style="width: 25%"/>
						        </colgroup>
			        			<tr>
			        			    <th>4.1.1.1 去过何地：</th>
		             				<td colspan="3"><input reg='{"maxlength":"200"}' type="text" name="epidemiologicalSurvey.outHistoryAddr" value="${caseDto.epidemiologicalSurvey.outHistoryAddr}" style="width: 180px;"/></td>
					             </tr>
					             <tr>
						            <th>4.1.1.2 在该地有无下列活动：</th>
						        </tr>
						        <tr>
						            <th>（1）住宿：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerLive" code="1,2" value="${caseDto.infectionSourceRoute.strangerLive}"/></td>
						       		<th>（2）用餐：</th>
			            			<td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerDiner" code="1,2" value="${caseDto.infectionSourceRoute.strangerDiner}"/></td>
						        </tr>
						        <tr>
						            <th>（3）带回食品：</th>
						            <td colspan="3">
						            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerBackFood" code="1,2" 
						            		value="${caseDto.infectionSourceRoute.strangerBackFood}" onchange="toggleOther('infectionSourceRoute.strangerBackFood','strangerFoodName','1')"/>
						            		<span id="strangerFoodName" style="${caseDto.infectionSourceRoute.strangerBackFood == '1' ? '' : 'display: none;'}">
						            			食品名称:<input type="text" name="infectionSourceRoute.strangerFoodName" value="${caseDto.infectionSourceRoute.strangerFoodName}" reg='{"maxlength":"100"}' style="width: 180px;"/>
						            		</span>
						            </td>
						        </tr>
						        <tr>
						            <th>4.1.1.2.4 该地同样疾病：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outSameDisease" code="1,2" value="${caseDto.infectionSourceRoute.outSameDisease}"/></td>
						        </tr>
			        		</table>
			        	</td>
				    </tr>
				     <tr>
			            <th>4.1.2 外人来家：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.stranger" code="1,2" value="${caseDto.infectionSourceRoute.stranger}"
			            		onchange="toggleOther('infectionSourceRoute.stranger','strangerFromAddrd',1);"/>
			            </td>
			        </tr>
			        <tr id="strangerFromAddrd" style="display: none;">
			            <th>4.1.2.1 来自何地：</th>
			            <td><input type="text" name="infectionSourceRoute.strangerFromAddr" value="${caseDto.infectionSourceRoute.strangerFromAddr}" reg='{"maxlength":"100"}'/></td>
			            <th>4.1.2.2 该地同样疾病：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerSameDisease" code="1,2" value="${caseDto.infectionSourceRoute.strangerSameDisease}"/></td>
			        </tr>  
			        <tr>
			            <th>4.1.3 接触过同样病人：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.contactSimilerPatient" code="1,2" value="${caseDto.infectionSourceRoute.contactSimilerPatient}"
			            		onchange="toggleOther('infectionSourceRoute.contactSimilerPatient','contactSimilerPatientDt',1)"/>
			            </td>
			        </tr>
			        <tr id="contactSimilerPatientDt" style="${caseDto.infectionSourceRoute.contactSimilerPatient == '1' ? '' : 'display: none;'}">
			         	 <td colspan="4" style="padding: 0px;">
				        	<table>
			        			<colgroup>
						            <col style="width: 27%"/>
						            <col style="width: 23%"/>
						            <col style="width: 25%"/>
						            <col style="width: 25%"/>
						        </colgroup>
						         <tr>
						            <th>4.1.3.1 接触时间：</th>
						            <td><tag:dateInput id="contactSimilerPatient_Dt" name="infectionSourceRoute.contactSimilerPatientDt" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" date="${caseDto.infectionSourceRoute.contactSimilerPatientDt}"/>时
						            	<input type="hidden" id="contactSimilerPatientHour" name="infectionSourceRoute.contactSimilerPatientHour"/>
						            </td>
						            <th>4.1.3.2 接触地点：</th>
						            <td><input type="text" name="infectionSourceRoute.contactSimilerPatientAddr" value="${caseDto.infectionSourceRoute.contactSimilerPatientAddr}" reg='{"maxlength":"100"}'/></td>
						        </tr>
						        <tr>
						            <th>4.1.3.3 接触方式：</th>
						        </tr>
						        <tr>
						            <th>（1）同吃：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareDiner" code="1,2" value="${caseDto.infectionSourceRoute.shareDiner}"/></td>
						            <th>（2）同住：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareLiver" code="1,2" value="${caseDto.infectionSourceRoute.shareLiver}"/></td>
						        </tr>
						        <tr>
						            <th>（3）护理：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareNurse" code="1,2" value="${caseDto.infectionSourceRoute.shareNurse}"/></td>
						            <th>（4）其他：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareOther" code="1,2" value="${caseDto.infectionSourceRoute.shareOther}"/></td>
						        </tr>
						     </table>
						   </td>
					</tr>
			        <tr>
			            <th>4.2 饮食情况（病前1 个月）：</th>
			        </tr>
			        <tr>
			            <th>4.2.1 饮生水：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.drinkingHistory" code="1,2" value="${caseDto.beforeDiseaseDiet.drinkingHistory}"
			            		onchange="toggleOther('beforeDiseaseDiet.drinkingHistory','waterType',1)"/>
			            </td>
			            <td colspan="2" style="padding: 0px;" id="waterType">
				        	<table>
			        			<colgroup>
						            <col style="width: 25%"/>
						            <col style="width: 25%"/>
						        </colgroup>
						        <tr>
							         <th>4.2.1.1 水源类型：</th>
				           			 <td><ehr:dic-radio name="beforeDiseaseDiet.waterType" dicmeta="IDM00034" code="3,4,6,8,99" value="${caseDto.beforeDiseaseDiet.waterType}"/></td>
						    	</tr>
						    </table>
						 </td>
			        </tr>
			        <tr>
			            <th>4.2.2 吃生冷食品：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.coldFood" code="1,2" value="${caseDto.beforeDiseaseDiet.coldFood}"
			            		onchange="toggleOther('beforeDiseaseDiet.coldFood','coldFoodName',1)"/>
			            </td>
			        </tr>
			        <tr id="coldFoodName">
			            <th>4.2.2.1 生冷食品名称：</th>
			            <td><input type="text" name="beforeDiseaseDiet.coldFoodName" value="${caseDto.beforeDiseaseDiet.coldFoodName}" reg='{"maxlength":"100"}'/></td>
			            <th>购买地点：</th>
			            <td><input type="text" name="beforeDiseaseDiet.coldFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.coldFoodBuyPlace}" reg='{"maxlength":"100"}'/></td>
			        </tr>
			        <tr>
			            <th>4.2.3 熟食冷吃：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.cookedFoodColdEat" code="1,2" value="${caseDto.beforeDiseaseDiet.cookedFoodColdEat}"
			            		onchange="toggleOther('beforeDiseaseDiet.cookedFoodColdEat','cookedFoodName',1)"/>
			            </td>
			            <td></td>
			            <td></td>
			        </tr>
			        <tr id="cookedFoodName">
			            <th>4.2.3.1 熟食品名称 ：</th>
			            <td>
			            	<input type="text" name="beforeDiseaseDiet.cookedFoodName" value="${caseDto.beforeDiseaseDiet.cookedFoodName}" reg='{"maxlength":"50"}'/>
			            </td>
			             <th>购买地点：</th>
			              <td>
			            	<input type="text" name="beforeDiseaseDiet.cookedFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.cookedFoodBuyPlace}" reg='{"maxlength":"200"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>4.2.4 其他可疑食品名称：</th>
			            <td>
			            	<input type="text" name="beforeDiseaseDiet.suspiciousFood" value="${caseDto.beforeDiseaseDiet.suspiciousFood}"  reg='{"maxlength":"100"}'/>
			            </td>
			            <th>购买地点：</th>
			            <td>
			            	<input type="text" name="beforeDiseaseDiet.susSalesPlaces" value="${caseDto.beforeDiseaseDiet.susSalesPlaces}"  reg='{"maxlength":"100"}'/>
						 </td>
			        </tr>
			        <tr>
			            <th>4.2.5 在外就餐史：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.outsideDiningHistory" code="1,2" value="${caseDto.beforeDiseaseDiet.outsideDiningHistory}"
			            		onchange="toggleOther('beforeDiseaseDiet.outsideDiningHistory','eatPlace',1)"/>
			            </td>
			        </tr>
			        <tr id="eatPlace">
			            <th>4.2.5.1 就餐地点：</th>
			            <td><ehr:dic-list name="beforeDiseaseDiet.eatPlace" dicmeta="IDM00037" value="${caseDto.beforeDiseaseDiet.eatPlace}"/></td>
			            <th>4.2.5.2 就餐地点名称：</th>
			            <td><input type="text" name="beforeDiseaseDiet.cookedFoodEatPlace" value="${caseDto.beforeDiseaseDiet.cookedFoodEatPlace}" reg='{"maxlength":"50"}'/></td>
			        </tr>
			        <tr>
			            <th>4.2.6 同餐者：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.meals" code="1,2" value="${caseDto.beforeDiseaseDiet.meals}"
			            		onchange="toggleOther('beforeDiseaseDiet.meals','mealPNum',1)"/>
			            </td>
			        </tr>
			        <tr id="mealPNum">
			            <th>4.2.6.1 同餐人数：</th>
			            <td><input type="text" name="beforeDiseaseDiet.mealPNum" value="${caseDto.beforeDiseaseDiet.mealPNum}" reg='{"maxlength":"20"}'/></td>
			        	<th>4.2.6.2 同餐日期：</th>
			            <td><tag:dateInput id="dinnerDate" name="beforeDiseaseDiet.dinnerDate" date="${caseDto.beforeDiseaseDiet.dinnerDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="dinnerHour" name="beforeDiseaseDiet.dinnerHour">
			            </td>
			        </tr>
			        <tr>
			            <th>4.3 预防接种：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.inoculateHistory" code="1,2" value="${caseDto.epidemiologicalSurvey.inoculateHistory}"
			            		onchange="toggleOther('epidemiologicalSurvey.inoculateHistory','lastInoculateDt',1)"/>
			            </td>
			        </tr>
			        <tr id="lastInoculateDt">
			            <th>4.3.1 最近一次接种时间：</th>
			            <td>
			            	<tag:dateInput name="epidemiologicalSurvey.lastInoculateDt" pattern="yyyy/MM/dd"
                                           date="${caseDto.epidemiologicalSurvey.lastInoculateDt}" nullToToday="true" onlypast="true"/>
			            </td>
			        	<th>4.3.2 接种：</th>
			            <td>
			            	<input type="text" name="epidemiologicalSurvey.inoculateNum" value="${caseDto.epidemiologicalSurvey.inoculateNum}"
													cssClass="width30" reg='{"maxlength":"20"}'/>次
			            	</td>
			        </tr>
			    </table>
			</fieldset>
			
			<fieldset>
			    <legend>5．疫点疫区处理</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			        </colgroup>
			        <tr>
			            <th>5.1 县级疾病预防控制中心接到报告时间：</th>
			            <td><tag:dateInput id="diseaseReportDate" name="epidemicFocusClose.diseaseReportDate" date="${caseDto.epidemicFocusClose.diseaseReportDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="diseaseReportHour" name="epidemicFocusClose.diseaseReportHour">
			            </td>
			            <th>5.2 县级疾病预防控制中心到达现场时间：</th>
			            <td><tag:dateInput id="diseaseSceneDate" name="epidemicFocusClose.diseaseSceneDate" date="${caseDto.epidemicFocusClose.diseaseSceneDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="diseaseSceneHour" name="epidemicFocusClose.diseaseSceneHour">
			            </td>
			        </tr>
			        <tr>
			            <th>5.3 疫点：</th>
			            <td>
			            	<input type="text" name="epidemicFocusClose.farmNum" value="${caseDto.epidemicFocusClose.farmNum}"
													cssClass="width30" reg='{"maxlength":"20"}' style="width:30%;"/>个
					   </td>
			            <th>5.4 范围：</th>
			            <td>
			            	<input type="text" name="epidemicFocusClose.rangeFamily" value="${caseDto.epidemicFocusClose.rangeFamily}"
													cssClass="width30" reg='{"maxlength":"20"}' style="width:30%;"/>户
			            	<input type="text" name="epidemicFocusClose.rangeNum" value="${caseDto.epidemicFocusClose.rangeNum}"
													cssClass="width30" reg='{"maxlength":"20"}' style="width:30%;"/> 个
			            </td>
			        </tr>
			        <tr>
			            <th>5.5 解除时间：</th>
			            <td><tag:dateInput id="removeDate" name="epidemicFocusClose.removeDate" date="${caseDto.epidemicFocusClose.removeDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="removeHour" name="epidemicFocusClose.removeHour">
			            </td>
			            <th>5.6 终末消毒时间：</th>
			            <td><tag:dateInput id="termSterTime" name="epidemicFocusClose.termSterTime" date="${caseDto.epidemicFocusClose.termSterTime}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="termSterHour" name="epidemicFocusClose.termSterHour">
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>6.小结</legend>
			    <table class="posttable">
			        <tr>
			            <td>
                            <textarea name="otherCondition.surveySummary" style="width: 100%" rows="5" reg='{"maxlength":"800"}'>${caseDto.otherCondition.surveySummary}</textarea>
                         </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
                <table class="posttable">
                   <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
                    <tr>
                        <th>调查者单位：：</th>
                        <td>
                        	<ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                        </td>
                        <th>调查者：：</th>
                        <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
                    </tr>
                    <tr>
                        <th>审查者：：</th>
                        <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
                        <th>调查时间：：</th>
                        <td>
                        <tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
	                               pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
	                    </td>
                    </tr>
                    <tr style="display:none;">
			             <td>
			             	<input type="hidden" name="caseInformation.caseFillOrg" value="${caseDto.caseInformation.caseFillOrg}"/>
			             	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
			             	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
			             	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
			             </td> 
			         </tr>
                </table>
            </fieldset>
		</div>
	</div>
</form>
