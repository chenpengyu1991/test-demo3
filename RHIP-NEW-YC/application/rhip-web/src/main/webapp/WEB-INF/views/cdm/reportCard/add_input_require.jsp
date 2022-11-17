<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <script src="${pageContext.request.contextPath}/js/views/ehr/person/basicCover.js" type="text/javascript"></script>
 --%>
<form id="report-input-form">
	<c:if test="${hospitalaReport ==true}">
		<input type="hidden" id="report-result" name='report-result' value="-1" />
		<input type="hidden"  name="hosReportRecordId" value="${reportInfo.hosReportRecordId}">
	</c:if>
	<input type="hidden" id="cdm_report_personId" name="personId" value="${personInfo.id}">
	<input type="hidden" id="cdm_person_personId"  name="personInfo.personId" value="${personInfo.id}">
	<div class="postcontent">
		<i class="popno">慢病上报</i>
		<div class="postdiv">
			<fieldset>
				
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
					</colgroup>
					<tr>
							<th><label   for="cdm_report_idcard">身份证</label></th>
						<td>
						<c:choose>
							<c:when test="${hospitalaReport ==true}">
								<input ${personInfo.idcard !=null and personInfo.idcard !='' ? 'readonly="readonly"' :'' } type="text"  id="cdm_report_idcard" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}'  />
							</c:when>
							<c:otherwise>
								<input type="text" id="cdm_report_idcard" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}' placeholder="输入身份证获取人员信息" />
							</c:otherwise>
						</c:choose>
							<!-- <input type="button" id="check-submit-btn" value="刷新"> -->
						</td>
						<th><label class="required" class="required" for="cdm_report_name">姓名</label></th>
						<td><input type="text" id="cdm_report_name" name="personInfo.name" value="${personInfo.name}" reg="{'required':true,'maxlength':16}" /></td>
					</tr>
					<tr>
						<th><label class="required" class="required" for="birthday">出生日期</label></th>
						<td><tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}" date="${personInfo.birthday}" /></td>
						<th><label class="required" class="required">性别</label></th>
						<td><ehr:dic-radio id="gender" uninclude="0,9" dicmeta="GBT226112003" name="personInfo.gender" value="${personInfo.gender}" reg="{'required':true}" /></td>
					</tr>
					<tr>
						<th><label class="required" for="marriage">婚姻</label></th>
						<td><ehr:dic-list dicmeta="GBT226122003" id="marriage" width="180px;"  name="personInfo.marriage" value="${personInfo.marriage}" reg="{'required':true}" /></td>
						<th><label class="required" for="occupation">职业</label></th>
						<td><ehr:dic-list dicmeta="GBT6565" width="180px;" code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120224,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299"  value="${personInfo.occupation}" id="occupation" name="personInfo.occupation" reg="{'required':true}" /></td>
					</tr>
					<tr>
						<th><label class="required" for="nation">民族</label></th>
						<td><ehr:dic-list dicmeta="GBT3304" id="nation" width="180px;"  name="personInfo.nation" value="${personInfo.nation}" reg="{'required':true}" /></td>
						<th><label class="required" for="education">文化程度</label></th>
						<td><ehr:dic-list dicmeta="GBT46582006" width="180px;" code="IDM11,IDM12,IDM04,IDM13,IDM03,IDM02,IDM07,90"   value="${personInfo.education}" id="education" name="personInfo.education" reg="{'required':true}" /></td>
					</tr>
					
					<tr>
						<th><label class="required" for="phoneNumber">电话</label></th>
						<td><input id="phoneNumber" type="text" name="personInfo.phoneNumber" value="${personInfo.phoneNumber}" reg="{'required':true,'regex':'phone'}" /></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th><label class="required">常住类型</label></th>
						<td><ehr:dic-radio reg="{'required':true}" dicmeta="FS10005" name="personInfo.householdType"
								value='${"2"!=personInfo.householdType?"1":"2"}'
							/></td>
						<td></td>
						<td></td>				</tr>
					<tr>
						<th><label class="required">现地址</label></th>
						<td colspan="3"><ehr:dic-town-village  width="180px" villageId="pastreet" townId="patownShip" villageName="personInfo.pastreet"
								townName="personInfo.patownShip" villageValue="${personInfo.pastreet}" townValue="${personInfo.patownShip}" reg="{'required':true}"
							/> <br /><span  id="text_pahouseNumber_prefix" ></span><input style="width: 300px" type="text" id="pahouseNumber" reg='{"required":"true","maxlength":23}'  name="personInfo.pahouseNumber"
							value="${personInfo.pahouseNumber}"
						/>(详细地址)</td>
					</tr>
					<tr>
						<th><label class="required">户籍地址</label></th>
						<td colspan="3"><div class="${'2' eq personInfo.householdType?'hide':'' }" id="hr-address-select"><ehr:dic-town-village 
									villageId="hrstreet" townId="hrtownShip" villageName="personInfo.hrstreet" townName="personInfo.hrtownShip"
									villageValue="${personInfo.hrstreet}" townValue="${personInfo.hrtownShip}" width="180px;"
									reg="{'dependOn':'personInfo.householdType','dependValue':'1','required':true}"
								/></div><span  id="text_hrhouseNumber_prefix" ></span> <input style="width: 300px" reg='{"required":"true","maxlength":23}'  type="text" id="hrhouseNumber" name="personInfo.hrhouseNumber"
							reg="{'required':true,'maxlength':23}" value="${personInfo.hrhouseNumber}"
						/>(详细地址)</td>
					</tr>
					<tr>
						<th><label  for="unitName">工作单位</label></th>
						<td><input type="text" id="unitName" name="personInfo.unitName" value="${personInfo.unitName}" reg="{'maxlength':46}" /></td>
						<th>建档单位</th>
						<td><input type="text" id="inputOrganName" readonly="readonly" name="personInfo.inputOrganName" value="${personInfo.inputOrganName}" />
							<input type="hidden" id="inputOrganCode" name="personInfo.inputOrganCode" value="${personInfo.inputOrganCode}" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="${hospitalaReport==true?'hide' :'show'}">
				<legend>选报慢病</legend>
				<div id="dis-select-box">
					<c:if test="${reportAbledFlags[0]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="diFlag" ${reportInfo.diFlag eq '1' ?'checked=true':''}>
						<label>糖尿病</label>
					</c:if>
					<c:if test="${reportAbledFlags[1]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="coronaryFlag" ${reportInfo.coronaryFlag eq '1' ? 'checked=true':''}>冠心病
	     		   </c:if>
					<c:if test="${reportAbledFlags[2]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="strokeFlag" ${reportInfo.strokeFlag eq '1' ? 'checked=true':''}>
						<label>脑卒中</label>
					</c:if>
					<c:if test="${reportAbledFlags[3]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="tumorFlag" ${reportInfo.tumorFlag eq '1' ? 'checked=true':''}>肿瘤
	    		    </c:if>
				</div>
			</fieldset>
			<c:if test="${hospitalaReport !=true}">
			<ehr:authorize ifAnyGranted="03,11,19">
			<fieldset >
				<legend>报卡类型</legend>
				<div id="report-type-select-box">
						<input type="radio" class="report-type-switch" value="1" name="reportType" ${reportInfo.reportType !='2' ? 'checked=true':''}>
	     		 		<label>病例</label>
						<input type="radio" class="report-type-switch" value="2" name="reportType" ${reportInfo.reportType eq '2' ? 'checked=true':''}>
						<label>死亡</label>
				</div>
			</fieldset>
		
				<fieldset id="death-info-box" class="${reportInfo.reportType =='2' ? 'show' :'hide'}" >
					<legend>死亡信息</legend>
					<table class="posttable">
									<colgroup>
										<col style="width: 15%;min-width:100px;" />
										<col style="width: 35%;min-width:200px;" />
										<col style="width: 15%;min-width:100px;" />
										<col style="width: 35%;min-width:200px;" />
									</colgroup>
									<tr>
										<th><label class="required" >死亡上报单位</label></th>
										<td><ehr:org-type-list id="deathReportOrganCode" type="hospital,centre"  width="250px" reg="{'required':true}" name="deathReportOrganCode" value="${reportInfo.deathReportOrganCode}"/>
										</td>
										<th><label class="required" >死亡日期</label></th>
										<td><tag:dateInput onlypast="true"  name="deathDate" date="${reportInfo.deathDate}" reg="{'required':true}" /></td>
									</tr>
									<tr>
										<th><label class="required">死亡原因</label></th>
										<td colspan="3" ><input type="text" value="${reportInfo.deathReason}" name="deathReason" reg="{'required':true,'maxlength':100}" /></td>
									</tr>
								</table>
				</fieldset>
			</ehr:authorize>
			</c:if>
			
			<div id="dis-info">
				<c:if test="${reportAbledFlags[0]}">
					<div id="diFlag-box" class="${reportInfo.diFlag eq '1'?'show':'hide'}">
						<fieldset>
							<legend>糖尿病</legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
								</colgroup>
								<tr>
									<th><label class="required" for="diType2">糖尿病类型</label></th>
									<td><ehr:dic-list width="180px;"  dicmeta="DMD00007" id="diType2" name="diType" value="${reportInfo.diType}" reg="{'required':true}" code="2"/></td>
									<th><label class="required" for="diAccidentDate">发病日期</label></th>
									<td><tag:dateInput onlypast="true" id="diAccidentDate" name="diAccidentDate" date="${reportInfo.diAccidentDate}" reg="{'required':true}" /></td>
								</tr>
								<tr>
									<th><label class="required" for="diDiagnosisDate">诊断日期</label></th>
									<td style="vertical-align:top;"><tag:dateInput onlypast="true" id="diDiagnosisDate" name="diDiagnosisDate" date="${reportInfo.diDiagnosisDate}" reg="{'required':true,'greaterThan':'diAccidentDate'}" /></td>
									<th><label for="diDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010"  id="diDiagnosisDepends" name="diDiagnosisDepends" value="${reportInfo.diDiagnosisDepends}" reg="{'maxlength':33}" /></td>
								</tr>
							</table>
						</fieldset>
					</div>
				</c:if>
				<c:if test="${reportAbledFlags[1]}">
					<div id="coronaryFlag-box" class="${reportInfo.coronaryFlag eq '1'?'show':'hide'}">
						<fieldset>
							<legend>冠心病</legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
							</colgroup>
								<tr>
									<th><label class="required" for="coronaryType">冠心病类型</label></th>
									<td><ehr:dic-list width="180px;"   dicmeta="DMD00008" id="coronaryType" name="coronaryType" value="${reportInfo.coronaryType}" reg="{'required':true}" /></td>
									<th><label class="required" for="coronaryAccidentDate">发病日期</label></th>
									<td><tag:dateInput onlypast="true" id="coronaryAccidentDate" name="coronaryAccidentDate" date="${reportInfo.coronaryAccidentDate}" reg="{'required':true}" /></td>
								</tr>
								<tr>
									<th><label class="required" for="coronaryDiagnosisDate">诊断日期</label></th>
									<td style="vertical-align:top;"><tag:dateInput onlypast="true" id="coronaryDiagnosisDate" name="coronaryDiagnosisDate" date="${reportInfo.coronaryDiagnosisDate}" reg="{'required':true,'greaterThan':'coronaryAccidentDate'}" /></td>
									<th><label for="coronaryDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010" id="coronaryDiagnosisDepends" name="coronaryDiagnosisDepends" value="${reportInfo.coronaryDiagnosisDepends}"/></td>
								</tr>
							</table>
						</fieldset>
					</div>
				</c:if>
				<c:if test="${reportAbledFlags[2]}">
					<div id="strokeFlag-box" class="${reportInfo.strokeFlag eq '1'?'show':'hide'}">
						<fieldset>
							<legend>脑卒中</legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
								</colgroup>
								<tr>
									<th><label class="required" for="strokeType">脑卒中类型</label></th>
									<td><ehr:dic-list width="180px;"  dicmeta="DMD00009" id="strokeType" name="strokeType" value="${reportInfo.strokeType}" reg="{'required':true}" /></td>
									<th><label class="required" for="strokeAccidentDate">发病日期</label></th>
									<td><tag:dateInput onlypast="true" id="strokeAccidentDate" name="strokeAccidentDate" date="${reportInfo.strokeAccidentDate}" reg="{'required':true}" /></td>
								</tr>
								<tr>
									<th><label class="required" for="strokeDiagnosisDate">诊断日期</label></th>
									<td style="vertical-align:top;"><tag:dateInput onlypast="true" id="strokeDiagnosisDate" name="strokeDiagnosisDate" date="${reportInfo.strokeDiagnosisDate}"  reg="{'required':true,'greaterThan':'strokeAccidentDate'}" /></td>
									<th><label for="strokeDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010" id="strokeDiagnosisDepends" name="strokeDiagnosisDepends" value="${reportInfo.strokeDiagnosisDepends}" reg="{'maxlength':33}" />
									</td>
								</tr>
							</table>
						</fieldset>
					</div>
				</c:if>
				<c:if test="${reportAbledFlags[3]}">
					<div id="tumorFlag-box" class="${reportInfo.tumorFlag eq '1'?'show':'hide'}">
						<fieldset>
							<legend>肿瘤</legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
								</colgroup>
								<tr>

									<%-- <th><label class="required"  for="tumorIcd10Code">ICD-10编码</label></th>
									<td><input type="text" id="tumorIcd10Code" name="tumorIcdTenCode" value="${reportInfo.tumorIcdTenCode}" reg='{"required":true,"regex":"^C[0-9]{2}(\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[0-3][0-9](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[4][0-8](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$"}' tip="请输入正确的肿瘤icd10编码" /></td>
                                     --%><th><label class="required" for="tumorType">肿瘤病名</label></th>
                                    <td><input type="text" id="tumorType" name="tumorType" value="${reportInfo.tumorType}" reg="{'required':true,'maxlength':50}" /></td>

                                </tr>
								<tr>
									
									<th><label class="required" for="tumorInformedFlag">知情状态标志</label></th>
									<td ><ehr:dic-list width="180px" dicmeta="PH00001"  id="tumorInformedFlag" name="tumorInformedFlag" value="${reportInfo.tumorInformedFlag}" reg="{'required':true}" /></td>
						
									<th><label for="tumorPrimaryPart">原发部位</label></th>
									<td><input type="text" id="tumorPrimaryPart" name="tumorPrimaryPart" value="${reportInfo.tumorPrimaryPart}" reg="{'maxlength':33}" /></td>
								</tr>
								<tr>
									<th><label for="tumorMetastasisPart">转移部位</label></th>
									<td  style="vertical-align:top;"><input type="text" id="tumorMetastasisPart" name="tumorMetastasisPart" value="${reportInfo.tumorMetastasisPart}"
										reg="{'maxlength':33}"
									/></td>
									<th><label for="tumorDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010" id="tumorDiagnosisDepends" name="tumorDiagnosisDepends" value="${reportInfo.tumorDiagnosisDepends}"
										reg="{'maxlength':33}"
									/></td>
								</tr>
								<tr>
									<th><label for="tumorPathologyType">病理类型</label></th>
									<td><input type="text" id="tumorPathologyType" name="tumorPathologyType" value="${reportInfo.tumorPathologyType}" reg="{'maxlength':16}" /></td>
									<th><label for="tumorIcd03Code">ICD-0-3编码</label></th>
									<td><input type="text" id="tumorIcd03Code" name="tumorIcdThreeCode" value="${reportInfo.tumorIcdThreeCode}" reg="{'maxlength':8}" /></td>
								</tr>
								<tr>
									<th><label class="required" for="tumorAccidentDate">发病日期</label></th>
									<td><tag:dateInput onlypast="true" id="tumorAccidentDate" name="tumorAccidentDate" date="${reportInfo.tumorAccidentDate}" reg="{'required':true}" /></td>
									<th><label class="required" for="tumorDiagnosisDate">诊断日期</label></th>
									<td><tag:dateInput onlypast="true" id="tumorDiagnosisDate" name="tumorDiagnosisDate" date="${reportInfo.tumorDiagnosisDate}" reg="{'required':true,'greaterThan':'tumorAccidentDate'}" /></td>
								</tr>
<%-- 								<tr> -->
<%-- 								<th><label class="required" for="tumorIcd10Name">ICD-10名称</label></th> --%>
<%-- 									<td><input type="text" id="tumorIcd10Name" name="tumorIcdTenName" value="${reportInfo.tumorIcdTenName}" --%>
<%-- 										reg="{'required':true,'maxlength':100}" --%>
<%-- 									/></td> --%>
<%-- 									</tr> --%>
							</table>
						</fieldset>
					</div>
				</c:if>
				<c:choose>
					<c:when test="${hideAlloc ==true }"></c:when>
					<c:otherwise>
							<ehr:authorize ifAnyGranted="11,01">
							<fieldset id="alloc-info-box">
									<legend> 分配 </legend>
									<table class="posttable">
									<colgroup>
												<col style="width: 15%;min-width:100px;" />
												<col style="width: 85%;min-width:200px;" />
									</colgroup>
									<tbody>
										<tr>
											<th><label class="required" for="diagnosisOrganCode">分配到</label></th>
											<td ><ehr:org-type-list  width="250px" code="320002922,320002930,320002981,320002994,320003006,320003020,320003021,320003041,320003049,320003061,320003080,320003134,320003136,320003160,320003169,320003177,320003178,320003180,320003190,320003191,320003228,320003234,320003247,320003263,320003265,320003282,320003295,320003300,320003303,320003353,320003364,320003394,32000_,"  reg="{'required':true}" name="superManageOrganCode"  />
											</td>
										</tr>
										</tbody>
								</table>
							</fieldset>
							</ehr:authorize>
					</c:otherwise>
				</c:choose>
				<div id="input-info">
					<fieldset>
						<legend> 报告信息 </legend>
						<table class="posttable">
							<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
						</colgroup>
							<tr>
								<th><label class="required" for="diagnosisOrganCode">诊断机构</label></th>
								<td colspan="3">
											<ehr:org-type-list id="diagnosisOrganCode"  width="250px" reg="{'required':true}" name="diagnosisOrganCode" type="hospital,centre"  value="${reportInfo.diagnosisOrganCode}"/>
											<c:if test="${hospitalaReport !=true}">
											外地诊断:<input id="otherDiagnosisOrganFlag" type="checkbox" value="2" name="otherDiagnosisOrganFlag" ${reportInfo.otherDiagnosisOrganFlag eq '2' ?'checked':''}>
											<input id="otherDiagnosisOrganName" style="width:150px " reg="{'maxlength':23,'dependOn':'otherDiagnosisOrganFlag','required':true}" type="text" value="${reportInfo.otherDiagnosisOrganName}" name="otherDiagnosisOrganName">
											</c:if>
								</td>
							</tr>
							<tr>
								<th><label for="ehrNo">门诊号</label></th>
								<td><input type="text" id="ehrNo" name="ehrNo" value="${reportInfo.ehrNo}" reg="{'maxlength':10}" /></td>
								<th><label for="admissionNo">住院号</label></th>
								<td><input type="text" id="admissionNo" name="admissionNo" value="${reportInfo.admissionNo}" reg="{'maxlength':10}" /></td>
							</tr>
							<tr>
								<th><label class="required">填报机构 </label></th>
								<td><input type="hidden" name="createOrganCode" value="${reportInfo.createOrganCode}" />
								
								 <input type="text" readonly="readonly"
									name="createOrganName" value="<ehr:org code="${reportInfo.createOrganCode}"  />"
								/></td>
								<th><label class="required" for="createDate">填报时间</label></th>
								<td>
								<input id="createDate"  type="text" name="createDate"  readonly="readonly" value='<fmt:formatDate value="${reportInfo.createDate}" pattern="yyyy/MM/dd" />' />
							</tr>
							<tr>
								<th><label class="required">填报医生 </label></th>
								<td><input type="hidden" name="createDoctorCode" value="${reportInfo.createDoctorCode}" />
									<c:if test="${not empty reportInfo.createDoctorCode }">
                             				<input type="text" readonly="readonly" name="createDoctorName" value="<ehr:user userCode="${reportInfo.createDoctorCode}"></ehr:user>" />
                             		</c:if>
                             		<c:if test="${ empty reportInfo.createDoctorCode }">
                             				<input type="text" readonly="readonly" name="createDoctorName" value="${reportInfo.createDoctorName}" />
                             		</c:if>
								</td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</form>