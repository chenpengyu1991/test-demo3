﻿<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script src="${pageContext.request.contextPath}/js/views/idm/report/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/h1n1.js" type="text/javascript"></script>


<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    甲型H1N1流感病例个案调查表<br/>
    <span>（乙类传染病）</span>
</i>
<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
<input type="hidden" name="caseInformation.reportDiseases" value="h1n1" id="reportDiseasesId"/>
<div class="postdiv">
	<fieldset class="layui-elem-field">
	    <legend>一、编码</legend>
	    <table class="posttable">
	        <colgroup>
                <col style="width: 23%"/>
                <col style="width: 67%"/>
	        </colgroup>
	        <tr>
	            <th><label class="required">1、行政区划代码：</label></th>
	            <td><input type="text" name="caseInformation.adminiDivCode" value="${caseDto.caseInformation.adminiDivCode}" reg='{"required":"true","length":"8"}' style="width: 36%" /></td>
	        </tr>
	        <tr>
	            <th><label class="required">2、调查地点编码：</label></th>
	            <td><input type="text" name="caseInformation.wayResearchCode" value="${caseDto.caseInformation.wayResearchCode}" reg='{"required":"true","length":"2"}' style="width: 36%"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">3、患 者 编 码：</label></th>
	            <td><input type="text" name="caseInformation.patientCode" value="${caseDto.caseInformation.patientCode}" reg='{"required":"true","length":"3"}' style="width: 36%"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">4、身份证 号 码：</label></th>
	            <td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}"  reg='{"required":"true","idCard":"true"}' style="width: 36%"
                           placeholder="输入身份证获取个人信息"/></td>
	        </tr>
	    </table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <legend>二、报告</legend>
	    <table class="posttable">
	        <colgroup>
                <col style="width: 23%"/>
                <col style="width: 67%"/>
	        </colgroup>
	        <tr>
	            <th><label class="required">1、报告单位：</label></th>
	            <td>
                    <ehr:org code="${caseDto.caseInformation.reportOrg}" />
                    <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}" reg='{"required":"true","maxlength":"100"}'/>
	                （具体到科室）
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">2、报告时间：</label></th>
	            <td>
                    <%-- <tag:dateInput nullToToday="true" id="reportDate" name="caseInformation.reportDate" onlypast="true" pattern="yyyy/MM/dd HH" date="${caseDto.caseInformation.reportDate}"
	                reg='{"required":"true"}' style="width: 15%"/>时 --%>
	                <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="caseInformation.reportDate" id="caseInformationReportDateId" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.caseInformation.reportDate}' pattern='yyyy/MM/dd HH'/>" />时
	                <input type="hidden" id="reportDateHM" name="caseInformation.reportDateHM"/>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">3、病例分类：</label></th>
	            <td>
	            	<ehr:dic-radio dicmeta="IDM00257" code="1,2" name="otherCondition.caseType" value="${caseDto.otherCondition.caseType}" reg='{"required":"true"}'/>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">4、报告种类：</label></th>
	            <td><ehr:dic-radio dicmeta="IDM00061" name="caseInformation.reportType" value="${caseDto.caseInformation.reportType}" reg='{"required":"true"}'/></td>
	        </tr>
	
	    </table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <legend>三、基本信息</legend>
	    <table class="posttable">
	        <colgroup>
                <col style="width: 23%"/>
                <col style="width: 67%"/>
        	</colgroup>
	        <tr>
	            <th><label class="required">1、姓名：</label></th>
	            <td>
	                <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" style="width: 100px;" reg='{"required":"true","maxlength":"100"}'/>
	                （如果患者<14周岁，请填写其监护人姓名
	                <input type="text" id="parentsName" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                   reg='{"maxlength":"50"}' style="width: 36%"/>）
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">2、性别：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">3、出生日期：</label></th>
	            <td>
	                <%-- <tag:dateInput id="birthday" name="generalCondition.birthday" reg='{"required":"true"}' date="${caseDto.generalCondition.birthday}" style="width: 16%" /> --%>
	                <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' id="birthday" name="generalCondition.birthday" style="width: 16%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.generalCondition.birthday}' pattern='yyyy/MM/dd'/>" />时
	               	<span>
	               		<ehr:dic-radio id="birthdateType" reg='{"required":"true"}' dicmeta="IDM00002" name="generalCondition.birthdateType" 
	                	value="${caseDto.generalCondition.birthdateType}"/>
	               	</span>
	           		(如果不知道其生日，请填写年龄
	           		<span>
	            	<tag:numberInput id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}" 
	            	maxlength="3" cssClass="width30" style="width: 6%"/>
	            	 <ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"  dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/></span>)
	            </td>
	        </tr>
	        <tr>
	            <th>4、国籍：</th>
	            <td>
	            	<ehr:dic-list name="generalCondition.nationality" reg='{"required":"true"}' dicmeta="GBT26592000" id="nationality_h1n1"
	            	value="${caseDto.generalCondition.nationality eq null ? '44': caseDto.generalCondition.nationality}" width="25%"/>
	            </td>
	        </tr>
	        <tr>
	            <th>5、民族：</th>
	            <td>
	            	<span id="nation">
	            		<ehr:dic-list name="generalCondition.nation" reg='{"required":"true"}' dicmeta="GBT3304" value="${caseDto.generalCondition.nationality eq null ? '01' : caseDto.generalCondition.nation}"
	            	     width="25%"/>
	            	</span>
	            	<span id="nationOther" style="<c:if test="${caseDto.generalCondition.nationality != '44'}">display: none;</c:if>">
	            		<input type="text" name="generalCondition.nationOther" value="${caseDto.generalCondition.nationOther}" 
	            	 	style="width: 36%;" reg='{"required":"true","maxlength":"20"}'/>
	            	</span>
	             </td>
	        </tr>
            <tr>
                <th>6、常住类型：</th>
                <td>
                    <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" id="floatPopulation_h1n1"
                                   value="${caseDto.generalCondition.floatPopulation}" />
                </td>
            </tr>
	        <tr>
	            <th><label class="required">7、家庭地址：</label></th>
	            <td>
					<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
												 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
												 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/><input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                           reg='{"maxlength":"50"}'  style="width: 180px;">
                    <span id="spanPaNumber">(门牌号)</span>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">8、工作单位：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' id="unitFlag" dicmeta="PH00002" name="generalCondition.unitFlag" code="1,2" value="${caseDto.generalCondition.unitFlag}"/>
	            	 <span id="unitNameTb" style="display: none">
	            	 	<label class="required">单位名称：</label>
	            	 	<input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
						  reg='{"dependOn":"generalCondition.unitFlag","dependValue":"1","required":"true","maxlength":"70"}' style="display: none;width: 36%"/>
	            	 </span>
	            </td>
	        </tr>
			 <tr>
	            <th>9、联系电话（至少列出一个）：</th>
	            <td></td>
	        </tr>
	        <tr>
	            <th><label class="required">(1)移动电话：</label></th>
	            <td><input type="text" class='phoneVali' name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}" reg='{"regex":"phone","extension":["phoneVali","请至少填写一项"],"maxlength":20}' style="width: 36%"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">(2)家庭电话：</label></th>
	            <td><input type="text" class='phoneVali' name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}" reg='{"regex":"phone","extension":["phoneVali","请至少填写一项"],"maxlength":20}' style="width: 36%"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">(3)办公电话：</label></th>
	            <td><input type="text" class='phoneVali' name="generalCondition.unitPhone" value="${caseDto.generalCondition.unitPhone}" reg='{"regex":"phone","extension":["phoneVali","请至少填写一项"],"maxlength":20}' style="width: 36%"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">10、职业：</label></th>
	            <td>
	            	<ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120224,CV020120299"
                                  reg='{"required":"true"}'/>
	            	 <span  id="occupationOtherPart" style="display: none">
                         <label class="required"></label>
                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                                reg='{"required":"true","maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 200px;"/>
                     </span>
	            </td>
	        </tr>
	    </table>
	
	</fieldset>
	<fieldset class="layui-elem-field">
		<legend>四、发病后就诊经过和既往史</legend>
		<table class="posttable">
		      <colgroup>
		            <col style="width: 35%"/>
		            <col style="width: 65%"/>
		       </colgroup>
				<tr>
				    <th><label class="required">1、发病日期：</label></th>
				    <td>
				    	<%-- <tag:dateInput id="pathogenesisDate" nullToToday="true" name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd" 
				    	 reg='{"required":"true","compare":["firstVisitDate","le","发病日期不能大于首诊日期"]}' date="${caseDto.attackCondition.pathogenesisDate}" style="width: 15%"/> --%>
				    	 
				    	 <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["firstVisitDate","le","发病日期不能大于首诊日期"]}' id="pathogenesisDate" name="attackCondition.pathogenesisDate" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.pathogenesisDate}' pattern='yyyy/MM/dd'/>" />
				    </td>
				</tr>
				<tr>
				    <th><label class="required">2、首诊日期：</label></th>
				    <td><%-- <tag:dateInput id="firstVisitDate" nullToToday="true" name="attackCondition.firstVisitDate" onlypast="true" pattern="yyyy/MM/dd"
				     reg='{"required":"true","compare":["pathogenesisDate","ge","首诊日期不能小于发病日期"]}' date="${caseDto.attackCondition.firstVisitDate}" style="width: 15%"/> --%>
				     
				     <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["pathogenesisDate","ge","首诊日期不能小于发病日期"]}' id="firstVisitDate" name="attackCondition.firstVisitDate" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.firstVisitDate}' pattern='yyyy/MM/dd'/>" />
				     </td>
				</tr>
				<tr>
				    <th><label class="required">首诊医疗机构名称（具体到科室）：</label></th>
				    <td><input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}" reg='{"required":"true","maxlength":"100"}'/></td>
				</tr>
				<tr>
				    <th>3、发病时临床表现（可多选）：</th>
				    <td></td>
				</tr>
				<tr>
				    <td style="padding:0px;" colspan="2">
				    	<table>
				    		<colgroup>
		                        <col style="width: 35%" />
		                        <col style="width: 20%" />
		                        <col style="width: 15%" />
		                        <col style="width: 30%" />
							</colgroup>
							<tr>
								<th><label class="required">发热：</label></th>
								<td>
									<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.fever" code="1,2" value="${caseDto.clinicalManifestations.fever}"/>
					            	 <span id="temperature" style="display: none;">
										<label class="required">体温 (℃)：</label>
										<input type="text" name="clinicalManifestations.temperature" value="${caseDto.clinicalManifestations.temperature}" 
			            	 				reg='{"maxlength":"20","required":"true"}' style="width: 30%;"/>
					            	 </span>
								</td>
								<th><label class="required">咽痛：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.soreThroat" code="1,2" value="${caseDto.clinicalManifestations.soreThroat}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required">畏寒：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.chills" code="1,2" value="${caseDto.clinicalManifestations.chills}"/><br/></td>
								<th><label class="required">咳嗽：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.cough" code="1,2" value="${caseDto.clinicalManifestations.cough}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required">咳痰：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.expectoration" code="1,2" value="${caseDto.clinicalManifestations.expectoration}"/><br/></td>
								<th><label class="required">头痛：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.headache" code="1,2" value="${caseDto.clinicalManifestations.headache}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required">鼻塞：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.nasalObstruction" code="1,2" value="${caseDto.clinicalManifestations.nasalObstruction}"/><br/></td>
								<th><label class="required">打喷嚏：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.sneeze" code="1,2" value="${caseDto.clinicalManifestations.sneeze}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required">流涕：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.runningNose" code="1,2" value="${caseDto.clinicalManifestations.runningNose}"/><br/></td>
								<th><label class="required">乏力：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.feeble" code="1,2" value="${caseDto.clinicalManifestations.feeble}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required">胸闷：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.chestStufly" code="1,2" value="${caseDto.clinicalManifestations.chestStufly}"/><br/></td>
								<th><label class="required">气促：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.asthma" code="1,2" value="${caseDto.clinicalManifestations.asthma}"/></td>
							</tr>
							<tr>
								<th><label class="required">呼吸困难：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.dyspnea" code="1,2" value="${caseDto.clinicalManifestations.dyspnea}"/><br/></td>
								<th><label class="required"> 腹泻：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.diarrhea" code="1,2" value="${caseDto.clinicalManifestations.diarrhea}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required">恶心：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.nausea" code="1,2" value="${caseDto.clinicalManifestations.nausea}"/><br/></td>
								<th><label class="required">呕吐：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.vomit" code="1,2" value="${caseDto.clinicalManifestations.vomit}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required">肌肉酸痛：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.muscularStiffness" code="1,2" value="${caseDto.clinicalManifestations.muscularStiffness}"/><br/></td>
								<th><label class="required">关节酸痛：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.limbAche" code="1,2" value="${caseDto.clinicalManifestations.limbAche}"/><br/></td>
							</tr>
							<tr>
								<th><label class="required"> 结膜炎：</label></th>
								<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.conjunctivitis" code="1,2" value="${caseDto.clinicalManifestations.conjunctivitis}"/><br/></td>
								<th><label class="required">其它：</label></th>
								<td>
									<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.otherSelect" code="1,2"
					   					value="${caseDto.clinicalManifestations.otherSelect}" 
					   					/>
					   				<span id="otherSpan" style="display: none;">
									   	  <label class="required">临床表现：</label><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"required":"true","maxlength":"500"}' style="width: 36%"/>
									   </span> 
								</td>
							</tr>
						</table>
					</td>
			</tr>
			<tr>
			    <th><label class="required">4、是否进展为肺炎：</label></th>
			    <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="clinicalManifestations.pneumonia" code="1,2" value="${caseDto.clinicalManifestations.pneumonia}"/></td>
			</tr>
			<tr>
			    <th>5、既往病史（可多选）</th>
			    <td></td>
			</tr>
			<tr>
			    <td style="padding:0px;" colspan="2">
			    	<table>
			    		<colgroup>
	                        <col style="width: 35%" />
	                        <col style="width: 20%" />
	                        <col style="width: 15%" />
	                        <col style="width: 30%" />
						</colgroup>
			    		<tr>
			    			<th><label class="required">哮喘：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.asthmaFlg" uninclude="3" value="${caseDto.pastHistory.asthmaFlg}"/></td>
			    			<th><label class="required">慢性肺病：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.cpdFlg" uninclude="3" value="${caseDto.pastHistory.cpdFlg}"/></td>
			    		</tr>
			    		<tr>
			    			<th><label class="required">慢性肝病：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.cldFlg" uninclude="3" value="${caseDto.pastHistory.cldFlg}"/></td>
			    			<th><label class="required">糖尿病：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.dmFlg" uninclude="3" value="${caseDto.pastHistory.dmFlg}"/></td>
			    		</tr>
			    		<tr>
			    			<th><label class="required">结核病：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.tuberculosisFlg" uninclude="3" value="${caseDto.pastHistory.tuberculosisFlg}"/></td>
			    			<th><label class="required">慢性肾脏疾病：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.crdFlg" uninclude="3" value="${caseDto.pastHistory.crdFlg}"/></td>
			    		</tr>
			    		<tr>
			    			<th><label class="required">心脏病：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.heartDiseaseFlg" uninclude="3" value="${caseDto.pastHistory.heartDiseaseFlg}"/></td>
			    			<th><label class="required">神经系统疾病：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.nervousDiseasesFlg" uninclude="3" value="${caseDto.pastHistory.nervousDiseasesFlg}"/></td>
			    		</tr>
			    		<tr>
			    			<th><label class="required">癌症：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.cancerFlg" uninclude="3" value="${caseDto.pastHistory.cancerFlg}"/></td>
			    			<th><label class="required">HIV/AIDS：</label></th>
			    			<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.hivAidsFlg" uninclude="3" value="${caseDto.pastHistory.hivAidsFlg}"/></td>
			    		</tr>
			    		<tr>
			    			<th><label class="required">其他免疫缺陷疾病：</label></th>
			    			<td colspan="3"><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.immuneDeficiencyFlg" uninclude="3" value="${caseDto.pastHistory.immuneDeficiencyFlg}"/></td>
			    		</tr>
			    	</table>
			    </td>
			</tr>
			<tr>
			    <th><label class="required">6、是否怀孕：</label></th>
			    <td>
			    	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.pregnancyFlg" code="1,2" value="${caseDto.pastHistory.pregnancyFlg}"
			       	  />
                     <span id="gestation" style="display: none;">
						 <label class="required">孕期：</label>
						 <input type="text" name="pastHistory.gestation" value="${caseDto.pastHistory.gestation}" 
			            	 	 style="width: 10%;" reg='{"maxlength":"20","required":"true"}'/>月
                     </span>
			    </td>
			</tr>
			<tr>
			    <th><label class="required">7、是否吸烟：</label></th>
			    <td>
			    	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.smokeFlg" code="1,2" value="${caseDto.pastHistory.smokeFlg}"/>
			    </td>
			</tr>
			<tr id="smokeDayCount">
			    <th><label class="required">7.1若抽烟，每天抽：</label></th>
			    <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="IDM00062" name="pastHistory.smokeDayCount" value="${caseDto.pastHistory.smokeDayCount}"/></td>
			</tr>
			<tr>
			    <th><label class="required">8、发病前1年内是否接种流感疫苗：</label></th>
			    <td>
			    	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.influenzaVaccine" uninclude="3" value="${caseDto.pastHistory.influenzaVaccine}"/>
                     <span id="influenzaVaccineDate" style="display: none;">
						<label class="required">接种时间：</label>
						<%-- <tag:dateInput nullToToday="true" name="pastHistory.influenzaVaccineDate" onlypast="true" style="width: 36%"
			                    reg='{"required":"true"}' pattern="yyyy/MM/dd" date="${caseDto.pastHistory.influenzaVaccineDate}"/> --%>
			                    
			                    <input type="text" class="layui-input x-admin-content-sm-date"  reg='{"required":"true"}' name="pastHistory.influenzaVaccineDate" id="pastHistoryInfluenzaVaccineDateId" style="width: 36%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.pastHistory.influenzaVaccineDate}' pattern='yyyy/MM/dd'/>" />
                     </span>
			    </td>
			</tr>
			<tr>
			    <th><label class="required">9、发病前1年内是否接种肺炎球菌疫苗：</label></th>
			    <td>
			    	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="pastHistory.pnuImuneFlg" uninclude="3" value="${caseDto.pastHistory.pnuImuneFlg}"/>
                     <span id="pnuImuneDate" style="display: none;">
						<label class="required">接种时间：</label>
						<%-- <tag:dateInput  nullToToday="true" name="pastHistory.pnuImuneDate" onlypast="true" style="width: 36%"
			                    reg='{"required":"true"}' pattern="yyyy/MM/dd" date="${caseDto.pastHistory.pnuImuneDate}"/> --%>
			                    <input type="text" class="layui-input x-admin-content-sm-date"  reg='{"required":"true"}'  name="pastHistory.pnuImuneDate" id="pastHistoryPnuImuneDateId" style="width: 36%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.pastHistory.pnuImuneDate}' pattern='yyyy/MM/dd'/>" />
                     </span> 
			    </td>
			</tr>
			</table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <legend>五、抗病毒药物与治疗</legend>
	    <table class="posttable">
	        <colgroup>
	            <col style="width: 35%"/>
	            <col style="width: 65%"/>
	        </colgroup>
	        <tr>
	            <th><label class="required">1、患者发病前两周是否服用过抗病毒药物：</label></th>
	            <td>
					<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="attackCondition.takeAntiviralDrug" uninclude="3" value="${caseDto.attackCondition.takeAntiviralDrug}"/>
	            </td>
	        </tr>
	        <tr id="takeAntiviralDrugTr" style="display: none;">
	        	<td colspan="2" style="padding: 0;">
	        		<table>
	        			 <colgroup>
				            <col style="width: 35%"/>
				            <col style="width: 65%"/>
				        </colgroup>
        				<tr>
				            <th><label class="required">1.1如果是,药物名称：</label></th>
				            <td>
								<ehr:dic-radio name="attackCondition.antiviralDrugName" reg='{"required":"true"}' dicmeta="IDM00063" value="${caseDto.attackCondition.antiviralDrugName}"/>
			                     <span id="antiviralDrugOther" style="display: none;">
									<label class="required"></label><input type="text" name="attackCondition.antiviralDrugOther" value="${caseDto.attackCondition.antiviralDrugOther}" reg='{"required":"true","maxlength":"100"}' style="width: 36%"/>			
			                     </span>
				            </td>
				        </tr>
	        		</table>
	        	</td>
	        </tr>
	        <tr>
	            <th><label class="required">2、发病后是否服用过达菲？</label></th>
	            <td>
					<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="attackCondition.takeTamiflu" uninclude="3" value="${caseDto.attackCondition.takeTamiflu}"/>
	            </td>
	        </tr>
	        <tr id="takeTamifluTr" style="display: none;">
	        	<td colspan="2" style="padding: 0;">
	        		<table>
	        			 <colgroup>
				            <col style="width: 35%"/>
				            <col style="width: 65%"/>
				        </colgroup>
				         <tr>
				            <th><label class="required">2.1开始服用日期：</label></th>
				            <td>
				                <%-- <tag:dateInput id="takeTamifluStart" nullToToday="true" name="attackCondition.takeTamifluStart" onlypast="true"  pattern="yyyy/MM/dd"  reg='{"required":"true","compare":["takeTamifluLast","le","开始服用日期不能大于最后服用日期"]}' 
				                	date="${caseDto.attackCondition.takeTamifluStart}" style="width: 15%"/> --%>
				                	
				                <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["takeTamifluLast","le","开始服用日期不能大于最后服用日期"]}' id="attackConditionTakeTamifluStartId" name="attackCondition.takeTamifluStart" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.takeTamifluStart}' pattern='yyyy/MM/dd'/>" />	
				            </td>
				        </tr>
				        <tr>
				            <th><label class="required">2.2最后服用日期：</label></th>
				            <td>
				                <%-- <tag:dateInput id="takeTamifluLast" nullToToday="true" name="attackCondition.takeTamifluLast" onlypast="true" pattern="yyyy/MM/dd" 
				                reg='{"required":"true","compare":["takeTamifluStart","ge","最后服用日期不能小于开始服用日期"]}' date="${caseDto.attackCondition.takeTamifluLast}" style="width: 15%"/> --%>
				                
				                <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["takeTamifluStart","ge","最后服用日期不能小于开始服用日期"]}' id="takeTamifluLast" name="attackCondition.takeTamifluLast" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.takeTamifluLast}' pattern='yyyy/MM/dd'/>" />
				            </td>
				        </tr>
				        <tr>
				            <th><label class="required">2.3服用剂量：</label></th>
				            <td>
				            	<input type="text" name="attackCondition.takeTamifluDos" value="${caseDto.attackCondition.takeTamifluDos}"
				             	cssClass="width30" reg='{"maxlength":"20"}' style="width: 5%"/>（毫克/天）
				            </td>
				        </tr>
				        <tr>
				            <th><label class="required">2.4服药过程中是否出现副作用：</label></th>
				            <td>
				            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="attackCondition.sideEffect" uninclude="3" value="${caseDto.attackCondition.sideEffect}"/>
			                     <span id="sideEffectExpression" style="display: none;">
			                     	<label class="required">表现：</label> <input type="text" name="attackCondition.sideEffectExpression" value="${caseDto.attackCondition.sideEffectExpression}" reg='{"required":"true","maxlength":"100"}'/>
			                     </span> 
				            </td>
				        </tr>
	        		</table>
	        	</td>
	        </tr>
	        <tr>
	            <th><label class="required">3、是否服用过其他抗病毒药物？</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="attackCondition.takeOtherAntiviralDrug" uninclude="3" value="${caseDto.attackCondition.takeOtherAntiviralDrug}"/>
                     <span id="otherAntiviralDrugName" style="display: none;">
                     	 <label class="required">药物名称：</label><input type="text" name="attackCondition.otherAntiviralDrugName" value="${caseDto.attackCondition.otherAntiviralDrugName}"
                     	  reg='{"required":"true","maxlength":"100"}' style="width: 36%"/>
                     </span>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">4、患者治疗过程中是否曾使用辅助通气？</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="attackCondition.assistedVentilation" uninclude="3" value="${caseDto.attackCondition.assistedVentilation}"
	            	 />
	            </td>
	        </tr>
	        <tr id="assistedVentilationType" style="display: none;">
	            <th><label class="required">4.1如果是,种类是：</label></th>
	            <td>
	            	<ehr:dic-radio name="attackCondition.assistedVentilationType" reg='{"required":"true"}' dicmeta="IDM00064" value="${caseDto.attackCondition.assistedVentilationType}"/>
                     <span id="assistedVentilationOther" style="display: none;">
                     	<label class="required"></label><input type="text" name="attackCondition.assistedVentilationOther" value="${caseDto.attackCondition.assistedVentilationOther}"
                     	 reg='{"required":"true","maxlength":"100"}' style="width: 36%"/>
                     </span>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">5、患者是否曾服用抗生素：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="attackCondition.takeAntibiotic" uninclude="3" value="${caseDto.attackCondition.takeAntibiotic}"/>
                     <span id="antibioticName" style="display: none;">
                     	<label class="required">药物名称：</label><input type="text" name="attackCondition.antibioticName" value="${caseDto.attackCondition.antibioticName}" 
                     	reg='{"required":"true","maxlength":"100"}' style="width: 36%"/>
                     </span>
	            </td>
	        </tr>
	    </table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <legend>六、病例发病前7天的暴露史</legend>
	    <table class="posttable">
	        <colgroup>
	            <col style="width: 40%"/>
	            <col style="width: 60%"/>
	        </colgroup>
	        <tr>
	            <th><label class="required">1、发病前7天内是否曾经到过出现疑似或确诊病例的国家/地区：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.caseArea" uninclude="3" value="${caseDto.exposureHistory.caseArea}"
	            	 />
                     <span id="caseAreaAddr" style="display: none;">
						  <label class="required">详细地址：</label>
						  <input type="text" name="exposureHistory.caseAreaAddr" value="${caseDto.exposureHistory.caseAreaAddr}" reg='{"required":"true","maxlength":"100"}' style="width: 60%;"/>
                     </span> 
	            </td>
	        </tr>
	        <tr>
	            <th>2、发病前7天内是否曾经接触过以下病例：</th>
	            <td></td>
	        </tr>
	        <tr>
	            <th><label class="required">2.1 疑似甲型H1N1流感病人：</label></th>
	            <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.doubtfulHn" uninclude="3" value="${caseDto.exposureHistory.doubtfulHn}"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">2.2 确诊甲型H1N1流感病人：</label></th>
	            <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.diagnosisHn" uninclude="3" value="${caseDto.exposureHistory.diagnosisHn}"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">2.3 发热（体温≥37.5℃）伴咽痛或咳嗽的病人：</label></th>
	            <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.feverPatient" uninclude="3" value="${caseDto.exposureHistory.feverPatient}"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">2.4 仅有呼吸道症状的病人（无发热）：</label></th>
	            <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.respiratorySymptomsPatient" uninclude="3" value="${caseDto.exposureHistory.respiratorySymptomsPatient}"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">2.5其他发热病人：</label></th>
	            <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.patientOther" uninclude="3" value="${caseDto.exposureHistory.patientOther}"/></td>
	        </tr>
	        <tr>
	            <th><label class="required">3、如果曾暴露于上述任何病人，请填写</label></th>
	        </tr>
	        <tr>
	            <th><label class="required">3.1 首次暴露时间：</label></th>
	            <td>
	            	<%-- <tag:dateInput id="exposureDtFirst" nullToToday="true" name="exposureHistory.exposureDtFirst" onlypast="true" pattern="yyyy/MM/dd" 
	            	reg='{"required":"true","compare":["exposureDtLast","le","首次暴露时间不能大于末次暴露时间"]}' date="${caseDto.exposureHistory.exposureDtFirst}" style="width: 15%"/> --%>
	            	
	            	<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["exposureDtLast","le","首次暴露时间不能大于末次暴露时间"]}' id="exposureDtFirst"  name="exposureHistory.exposureDtFirst" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.exposureDtFirst}' pattern='yyyy/MM/dd'/>" />
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">3.2 末次暴露时间：</label></th>
	            <td>
	            	<%-- <tag:dateInput id="exposureDtLast" nullToToday="true" name="exposureHistory.exposureDtLast" onlypast="true" pattern="yyyy/MM/dd" 
	            	reg='{"required":"true","compare":["exposureDtFirst","ge","末次暴露时间不能小于首次暴露时间"]}' date="${caseDto.exposureHistory.exposureDtLast}" style="width: 15%"/> --%>
	            	
	            	<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["exposureDtFirst","ge","末次暴露时间不能小于首次暴露时间"]}' id="exposureDtLast"  name="exposureHistory.exposureDtLast" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.exposureDtLast}' pattern='yyyy/MM/dd'/>" />
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">3.3 接触方式（可多选）：</label></th>
	            <td>
	            	<ehr:dic-checkbox reg='{"required":"true"}' name="exposureHistory.contactWay" dicmeta="IDM00065" value="${caseDto.exposureHistory.contactWay}"
	                 />
                     <span id="contactWayOther" style="display: none;">
                     	<input type="text" name="exposureHistory.contactWayOther" value="${caseDto.exposureHistory.contactWayOther}" reg='{"required":"true","maxlength":"100"}' style="width: 20%;"/>
                     </span>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">3.4 接触患者时是否采取防护措施：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.conservatoryMeasure" uninclude="3" value="${caseDto.exposureHistory.conservatoryMeasure}"
	            	/>
	            </td>
	        </tr>
	        <tr id="conservatoryMeasureWay">
	            <th><label class="required">3.4.1 如果是，采取的防护措施是：</label></th>
	            <td>
	            	<ehr:dic-radio name="exposureHistory.conservatoryMeasureWay" reg='{"required":"true"}' dicmeta="IDM00066" value="${caseDto.exposureHistory.conservatoryMeasureWay}"
	            	/>
                     <span id="conservatoryMeasureWayOther" style="display: none;">
                     	<label class="required"></label><input type="text" name="exposureHistory.conservatoryMeasureWayOther" value="${caseDto.exposureHistory.conservatoryMeasureWayOther}" reg='{"required":"true","maxlength":"200"}' style="width: 30%"/>
                     </span>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">4、发病前7天内，是否到过甲型H1N1流感病毒学实验室：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.hnLab" uninclude="3" 
	            	value="${caseDto.exposureHistory.hnLab}" />
	            </td>
	        </tr>
	        <tr id="conservatoryMeasureLab" style="${caseDto.exposureHistory.hnLab eq '1' ? '' : 'display:none;'}">
	            <th><label class="required">4.1 若曾到过实验室，是否采取防护措施：</label></th>
	            <td>
					<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="exposureHistory.conservatoryMeasureLab" uninclude="3" value="${caseDto.exposureHistory.conservatoryMeasureLab}"/>
	            </td>
	        </tr>
	    </table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <legend>七、病例的密切接触者（疾控人员填写并负责更新）</legend>
	    <table class="posttable">
	       <colgroup>
	            <col style="width: 35%"/>
	            <col style="width: 65%"/>
	        </colgroup>
	        <tr>
	            <th><label class="required">1、发病前7天内是否到过以下场所（可多选）：</label></th>
	            <td>
	            	<ehr:dic-checkbox reg='{"required":"true"}' dicmeta="IDM00067" name="epidemicFocusClose.isGoPlace" value="${caseDto.epidemicFocusClose.isGoPlace}"
	            	 />
	            </td>
	        </tr>
	        <tr id="pubPlaNameAddr" style="display: none;">
	            <th><label class="required">所到公共场所的具体名称及地址：</label></th>
	            <td>
	                <input type="text" name="epidemicFocusClose.pubPlaNameAddr" value="${caseDto.epidemicFocusClose.pubPlaNameAddr}" reg='{"required":"true","maxlength":"400"}'/>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">2、发病前7天内是否外出旅行、出差：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="epidemicFocusClose.isAgenda" uninclude="3" value="${caseDto.epidemicFocusClose.isAgenda}"
	            	 />
	            </td>
	        </tr>
	        <tr style="display: none;" id="isAgendaTr">
	        	<td colspan="2" style="padding: 0px;">
	        		<table>
	        			<colgroup>
				            <col style="width: 35%"/>
				            <col style="width: 65%"/>
				        </colgroup>
	        			<tr>
				            <th><label class="required">2.1如果是，请说明行程：</label></th>
				            <td>
				                <input type="text" name="epidemicFocusClose.travelAgenda" value="${caseDto.epidemicFocusClose.travelAgenda}" reg='{"required":"true","maxlength":"500"}'/>
				            </td>
				        </tr>
				        <tr>
				            <th><label class="required">2.2旅行、出差所经地是否有甲型H1N1流感疫情：</label></th>
				            <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="epidemicFocusClose.isHnEpidemic" uninclude="3" value="${caseDto.epidemicFocusClose.isHnEpidemic}"/></td>
				        </tr>
	        		</table>
	        	</td>
	        </tr>
	        <tr>
	            <th><label class="required">3、发病前七天曾经搭乘过的交通工具（可多选）：</label></th>
	            <td>
	            	<ehr:dic-checkbox reg='{"required":"true"}' dicmeta="IDM00068" name="epidemicFocusClose.trafficToolsBefore" value="${caseDto.epidemicFocusClose.trafficToolsBefore}"
	                 />
	            </td>
	        </tr>
	        <tr style="display: none;" id="trafficToolsBeOthTr">
	        	<td colspan="2" style="padding: 0px;">
	        		<table>
	        			<colgroup>
				            <col style="width: 35%"/>
				            <col style="width: 65%"/>
				        </colgroup>
	        			<tr>
				        	<th><label class="required">交通工具名称：</label></th>
				            <td>
				                <input type="text" name="epidemicFocusClose.trafficToolsBeOth" value="${caseDto.epidemicFocusClose.trafficToolsBeOth}" reg='{"required":"true","maxlength":"200"}'/>
				            </td>
				        </tr>
				        <tr>
				            <th><label class="required">具体说明搭乘交通工具的情况：</label></th>
				            <td>
				                <input type="text" name="epidemicFocusClose.trafficTools" value="${caseDto.epidemicFocusClose.trafficTools}" reg='{"required":"true","maxlength":"200"}'/>
				            </td>
				        </tr>
	        		</table>
	        	</td>
	        </tr>
	        <tr>
	            <th><label class="required">4、有无密切接触者：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="epidemicFocusClose.isContacts" uninclude="3" value="${caseDto.epidemicFocusClose.isContacts}"
	            	 />
	            </td>
	        </tr>
	        <tr style="display: none;" id="isContactsTr">
	        	<td colspan="2" style="padding: 0px;">
	        		<table>
	        			<colgroup>
				            <col style="width: 35%"/>
				            <col style="width: 65%"/>
				        </colgroup>
	        			<tr>
				            <td colspan="2">如果有密切接触者，请填写密切接触者流行病学调查一揽表，并填写如下内容。</td>
				        </tr>
				        <tr>
				            <th><label class="required">4.1 密切接触者的人数：</label></th>
				            <td>
				            	<input type="text" name="epidemicFocusClose.contactsNum" value="${caseDto.epidemicFocusClose.contactsNum}" 
										cssClass="width30" reg='{"maxlength":"20"}' style="width: 5%" />人
							</td>
				        </tr>
				        <tr>
				            <th><label class="required">4.2 目前已纳入医学观察的人数：</label></th>
				            <td>
				            	<input type="text" name="epidemicFocusClose.medObsNum" value="${caseDto.epidemicFocusClose.medObsNum}" 
										cssClass="width30" reg='{"maxlength":"20"}' style="width: 5%" />人
				            </td>
				        </tr>
				        <tr>
				            <th><label class="required">4.3 是否有人出现发热和/或呼吸道症状？</label></th>
				            <td>
				            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00002" name="epidemicFocusClose.isFeverRespiratory" code="1,2"
				            	 value="${caseDto.epidemicFocusClose.isFeverRespiratory}"/>
				            	<span id="isFeverRespiratoryNum">
				            		<label class="required">人数：</label>
									<input type="text" name="epidemicFocusClose.isFeverRespiratoryNum" value="${caseDto.epidemicFocusClose.isFeverRespiratoryNum}" 
										cssClass="width30" reg='{"maxlength":"20"}' style="width: 5%"/>
				            	</span>
				            </td>
				        </tr>
	        		</table>
	        	</td>
	        </tr>
	    </table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <legend>八、患者转归</legend>
	    <table class="posttable">
	        <colgroup>
	            <col style="width: 35%"/>
	            <col style="width: 65%"/>
	        </colgroup>
	        <tr>
	            <th><label class="required">1、最终诊断：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="IDM00257" name="diagnosis.diagnosisType" value="${caseDto.diagnosis.diagnosisType}" 
	            	 />
	            	 <span id="doubtfulDtT" style="display: none;">
		            	<label class="required">诊断时间：</label><%-- <tag:dateInput  nullToToday="true" name="diagnosis.doubtfulDt" onlypast="true" pattern="yyyy/MM/dd"
		            	  reg='{"dependOn":"diagnosis.diagnosisType","dependValue":"1","required":"true"}' date="${caseDto.diagnosis.doubtfulDt}" style="width: 15%"/> --%>
		            	  <input type="text" class="layui-input x-admin-content-sm-date" reg='{"dependOn":"diagnosis.diagnosisType","dependValue":"1","required":"true"}' id="diagnosisDoubtfulDtId"  name="diagnosis.doubtfulDt" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.diagnosis.doubtfulDt}' pattern='yyyy/MM/dd'/>" />
	            	</span>
	            	 <span id="diagnosisDtT" style="display: none;">
		            	<label class="required">诊断时间：</label><%-- <tag:dateInput nullToToday="true" name="diagnosis.diagnosisDt" onlypast="true" pattern="yyyy/MM/dd"
		            	  reg='{"dependOn":"diagnosis.diagnosisType","dependValue":"2","required":"true"}' date="${caseDto.diagnosis.diagnosisDt}" style="width: 15%"/> --%>
		            	  <input type="text" class="layui-input x-admin-content-sm-date" reg='{"dependOn":"diagnosis.diagnosisType","dependValue":"2","required":"true"}'  id="diagnosisDiagnosisDtId"  name="diagnosis.diagnosisDt" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.diagnosis.diagnosisDt}' pattern='yyyy/MM/dd'/>" />
	            	 </span>
	            	 <span id="excludeDtT" style="display: none;">
		            	<label class="required">排除时间：</label><%-- <tag:dateInput id="excludeDtT" nullToToday="true" name="diagnosis.excludeDt" onlypast="true" pattern="yyyy/MM/dd"
		            	 reg='{"dependOn":"diagnosis.diagnosisType","dependValue":"3","required":"true"}' date="${caseDto.diagnosis.excludeDt}" style="width: 15%"/> --%>
		            	 <input type="text" class="layui-input x-admin-content-sm-date" reg='{"dependOn":"diagnosis.diagnosisType","dependValue":"3","required":"true"}' id="excludeDtT"   name="diagnosis.excludeDt" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.diagnosis.excludeDt}' pattern='yyyy/MM/dd'/>" />
		           		  <label class="required"> 排除病例最后确诊疾病：</label>
		           		   <input id="diagnosisDiseaseT" type="text" name="diagnosis.diagnosisDisease" value="${caseDto.diagnosis.diagnosisDisease}"
		           		     reg='{"dependOn":"diagnosis.diagnosisType","dependValue":"3","required":"true","maxlength":"100"}' style="width: 20%"/>
	           		 </span>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">2、是否治愈：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="otherCondition.cureFlg" code="1,2" value="${caseDto.otherCondition.cureFlg}"
	            	/>
	            	<span id="cureDate" style="display: none;">
	            		治愈时间：<%-- <tag:dateInput nullToToday="true" name="otherCondition.cureDate" onlypast="true" pattern="yyyy/MM/dd" 
	               		reg='{"required":"true"}' date="${caseDto.otherCondition.cureDate}" style="width: 15%"/> --%>
	               		<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}'  id="otherConditionCureDateId"  name="otherCondition.cureDate" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.otherCondition.cureDate}' pattern='yyyy/MM/dd'/>" />
	            	</span>
	            </td>
	        </tr>
	        <tr>
	            <th><label class="required">3、是否死亡：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="otherCondition.deathFlg" code="1,2" value="${caseDto.otherCondition.deathFlg}"
	            	/>
	            </td>
	        </tr>
	        <tr style="display: none;" id="deathTime">
	        	<td colspan="2" style="padding: 0px;">
	        		<table>
	        			<colgroup>
				            <col style="width: 35%"/>
				            <col style="width: 65%"/>
				        </colgroup>
	        			 <tr>
				            <th><label class="required">死亡时间：</label></th>
				            <td>
				               <%--  <tag:dateInput nullToToday="true" name="otherCondition.deathTime" onlypast="true" pattern="yyyy/MM/dd" 
				            			reg='{"required":"true"}' date="${caseDto.otherCondition.deathTime}" style="width: 15%"/> --%>
				            			
				            			<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' id="otherConditionDeathTimeId"   name="otherCondition.deathTime" style="width: 15%;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.otherCondition.deathTime}' pattern='yyyy/MM/dd'/>" />
				            </td>
				        </tr>
				        <tr>
				            <th><label class="required">3.1 如果是死亡病例，死亡诊断：</label></th>
				            <td>
				                <input type="text" name="otherCondition.deathCause" value="${caseDto.otherCondition.deathCause}"
				                	 reg='{"required":"true","maxlength":"100"}' style="width: 36%"/>
				            </td>
				        </tr>
	        		</table>
	        	</td>
	        </tr>
	        <tr>
	            <th><label class="required">4、是否住院：</label></th>
	            <td>
	            	<ehr:dic-radio reg='{"required":"true"}' dicmeta="PH00001" name="otherCondition.inpatientFlg" code="1,2" value="${caseDto.otherCondition.inpatientFlg}"
	            	/>
	            </td>
	        </tr>
	        <tr style="display: none;" id="inpatientFlgTd">
	        	<td colspan="2" style="padding: 0px;">
	        		<table>
	        			<colgroup>
				            <col style="width: 35%"/>
				            <col style="width: 65%"/>
				        </colgroup>
	        			<tr>
	        				<th>4.1 如果是住院病例：</th>
				            <td></td>
				        </tr>
				        <tr>
				            <th><label class="required">入院时间：</label></th>
				            <td>
				            	<%-- <tag:dateInput id="inhosTime" nullToToday="true" name="otherCondition.inhosTime" onlypast="true" pattern="yyyy/MM/dd"
				             	reg='{"required":"true","compare":["outhosDate","le","入院时间不能大于出院时间"]}' date="${caseDto.otherCondition.inhosTime}" style="width: 15%"/> --%>
				             	<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["outhosDate","le","入院时间不能大于出院时间"]}' id="inhosTime"   name="otherCondition.inhosTime" style="width: 15%" value="<fmt:formatDate value='${caseDto.otherCondition.inhosTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;"/>
				             </td>
				        </tr>
				        <tr>
				            <th><label class="required">出院时间：</label></th>
				            <td>
				            	<%-- <tag:dateInput id="outhosDate" nullToToday="true" name="otherCondition.outhosDate" onlypast="true" pattern="yyyy/MM/dd"
				             	reg='{"required":"true","compare":["inhosTime","ge","出院时间不能小于入院时间"]}' date="${caseDto.otherCondition.outhosDate}" style="width: 15%"/> --%>
				             	<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["inhosTime","ge","出院时间不能小于入院时间"]}' id="outhosDate"   name="otherCondition.outhosDate" style="width: 15%" value="<fmt:formatDate value='${caseDto.otherCondition.outhosDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;"/>
				             </td>
				        </tr>
	        		</table>
	        	</td>
	        </tr>
	    </table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <legend>九、调查小结</legend>
	    <table class="posttable">
	        <tr>
	             <td>
                          <textarea name="otherCondition.surveySummary" style="width: 100%" rows="5" reg='{"maxlength":"4000"}'>${caseDto.otherCondition.surveySummary}</textarea>
                       </td>
	        </tr>
	    </table>
	</fieldset>
	<fieldset class="layui-elem-field">
	    <table class="posttable">
	        <colgroup>
	            <col style="width: 10%"/>
	            <col style="width: 23%"/>
	             <col style="width: 10%"/>
	             <col style="width: 23%"/>
	             <col style="width: 10%"/>
	            <col style="width: 24%"/>
	        </colgroup>
	        <tr>
	            <th><label class="required">调查单位：</label></th>
	            <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
	        	 <th><label class="required">调查时间：</label></th>
	            <td>
                    <%-- <tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
                                   pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/> --%>
                                   
                    <input type="text" class="layui-input x-admin-content-sm-date"  id="caseInformationModifySurveyDateId"   name="caseInformation.modifySurveyDate"  value="<fmt:formatDate value='${caseDto.caseInformation.modifySurveyDate}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;"/>               
                                   </td>
	            <th><label class="required">调查员签名：</label></th>
	            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
	        </tr>
	         <tr style="display:none;">
                 <td>
                 	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
                 	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
                 	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
                 </td> 
             </tr>
	    </table>
	</fieldset>
</div>
<div>
    填表说明：<br/>
    1、每个问题的题目后都附有“□”或“ ”，“□”除题目明确说明填写日期，如 □□□□年□□月□□日者，其余请在答案后面的“□” 里打勾“√”。数字及代码一律使用阿拉伯数字，数字不应填出格外。<br/>
    2、如果选填了“其他”的选项，除了在相应的内容后面的“□” 里打勾“√”，还要填写具体的内容。<br/>
    3、调查表中不得有空项。如无特殊说明，选择题为单选题。遇到实际情况在所给选项中没有对应答案时，可在对应题目的侧边，标注题号，然后将实际情况用文字表述出来。陈述题，如果确实不清楚，请标明“不详”。<br/>
    4、编码说明：地区编码统一按国家统计局设管司发布的“乡镇行政区划代码”进行编定；调查地点编码：同一地区内只有一个调查地点时，统一编01，同一地区内有多个调查地点时，每个地点一个编码，从01开始顺序编码；患者编码：从001开始顺序编码。<br/>

</div>
</div>
</form>

<script type="text/javascript">
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        
        laydate.render({
            elem: '#birthday'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        
        laydate.render({
            elem: '#caseInformationReportDateId'
            	,type:'datetime'
            	,format:'yyyy/MM/dd HH'
            		, trigger: 'click'
          });
        
        
        laydate.render({
            elem: '#pathogenesisDate'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        laydate.render({
            elem: '#firstVisitDate'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        laydate.render({
            elem: '#pastHistoryInfluenzaVaccineDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#pastHistoryPnuImuneDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#attackConditionTakeTamifluStartId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#takeTamifluLast'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#exposureDtFirst'
            	,format:'yyyy/MM/dd'
         	  , max:0
          });
        
        laydate.render({
            elem: '#exposureDtLast'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#diagnosisDoubtfulDtId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#diagnosisDiagnosisDtId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#excludeDtT'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#otherConditionDeathTimeId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#inhosTime'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#outhosDate'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#caseInformationModifySurveyDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#otherConditionCureDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        
      });

    </script>