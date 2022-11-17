<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/employees/add.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js//views/ehr/person/list.js" type="text/javascript"></script>

<!-- <style>
#printDiv {
         height: 500px;width: 870px;overflow: auto;
    }
</style> -->
<div id="msgError" class="msgError" style="display: none;"></div>
<div class="Contentbox" style="text-align: left;">
<input type="hidden" id="text_inputOrganCode" name="createOrganCode" value="${employeesHealthChecklist.createOrganCode}">
<form id="employeesForm" name="employeesForm" method="post" class="${contentfixed265}">
<input type="hidden" id="flag" name="flag" value="${flag}"/> 
<input type="hidden" id="id" name="id" value="${employeesHealthChecklist.id}"/> 
<input type="hidden" id="text_personId" name="personId" value="${employeesHealthChecklist.personId}"/> 
<input type="hidden" id="idcard"  value="${employeesHealthChecklist.idcard}"/>
	<div class="toolbar">
		<a href="javascript:void(0)" id="cancelBtn"><b class="fanhui">返回</b></a>
		<a class="bc" id="button_save"><b class="baocun">保存</b></a>
		 <a class="bc" id="button_print"><b class="baocun">打印</b></a>
	</div>
	<div class="postcontent" id="printDiv">
	<div class="postcontent">
	<fieldset>
							
				<legend class="required">基本信息</legend>
				<br/><br/>
		
		<table style="line-height: 10px;" class="posttable">
					<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
			<!-- <tr>
			<td colspan="4" >
			<s class="pop_No">
					<span class="text"><b>编号：</b></span>
					<span></span><span></span><span></span><span></span><span></span>
					<span class="line">-</span>
					<span></span><span></span><span></span>
					<span class="line">-</span>
					<span></span><span></span><span></span>
					<span class="line">-</span>
					<span></span><span></span><span></span><span></span>
					</s>
			</td>
			</tr> -->
			<tr>
				<td colspan="4" align="center" style="font-size: 20px;font-weight: bold;">
					银川市预防性健康检查用表
					<br/>
					从业人员健康检查表
					<br/>
					<br/>
				</td>
			</tr>
			<tr>
			<td colspan="4" align="center" >
					<img src="${pageContext.request.contextPath}/images/128.gif" style="width: 100px;height: 100px;"/>
				</td>
			
			</tr>
			
			<tr>
				<th><label class="required">姓名：</label></th>
				<td><input reg='{"required":"true","maxlength":16}'  type="text" style="width: 155px;"
					id="text_name" name="name"
					value="${employeesHealthChecklist.name}" /></td>
				<th><label>编号：</label></th>
				<td>
					<input style="width: 155px;" type="text" class=physicalExaminationNo id="physicalExaminationNo" readonly="readonly"
							reg='{"maxlength":13}' name="physicalExaminationNo"
							value="${employeesHealthChecklist.physicalExaminationNo}" />
                </td>	
			</tr>
			
             <tr>
             	<th><label class="required">身份证号：</label></th>
             	<td>
             	<c:if test="${empty employeesHealthChecklist.id}">
             	<input type="text" name="idcard" id="text_idcard"  reg='{"required":"true","idCard":true}' value="${employeesHealthChecklist.idcard}" style="width: 155px;" placeholder="输入身份证获取人员信息"></input>
             	</c:if>
             	<c:if test="${ not empty employeesHealthChecklist.id}">
             	<input type="text" name="idcard"  readonly="readonly" value="${employeesHealthChecklist.idcard}" style="width: 155px;" placeholder="输入身份证获取人员信息"></input>
             	</c:if>
             	</td>
				<th><label class="required">体检日期：</label></th>
				<td >
					<tag:dateInput id="text_inputDate" reg='{"required":true}' style="width:155px" name="physicalExaminationDate"  date="${employeesHealthChecklist.physicalExaminationDate}" onlypast="true" ></tag:dateInput>
				</td>
			</tr>
			<tr>
				<th><label class="required">性别：</label></th>
             	<td>
             	<%-- <ehr:dic-radio uninclude="0,9" reg="{'required':'true'}" dicmeta="GBT226112003" 
								name="gender" 
								 /> --%>
				 <ehr:dic-radio dicmeta="GBT226112003"
								name="genders" reg="{'required':'true'}"
								value='${employeesHealthChecklist.genders}' />			
								
             	</td>
				<th><label class="required">年龄：</label></th>
				<td >
					<input type="text" name="age" id="age"  reg='{"required":"true"}' value="${employeesHealthChecklist.age}" style="width: 155px;"></input>
				</td>
			</tr>
			
			<tr>
				<th><label class="required">民族：</label></th>
             	<td>
             	<input type="text" name="familyName" id="familyName"  reg='{"required":"true"}' value="${employeesHealthChecklist.familyName}" style="width: 155px;"></input>
             	</td>
				<th></th>
				<td >
				</td>
			</tr>
			 <tr>
				<th ><label class="required">单位：</label></th>
				<td><input reg='{"required":"true","maxlength":50}'  type="text" style="width:155px"
					name="companys"
					value="${employeesHealthChecklist.companys}" /></td>
				<th><label class="required">性质：</label></th>
				<td>
				
				<ehr:dic-radio dicmeta="CHG10600"
								name="nature" reg="{'required':'true'}"
								value='${employeesHealthChecklist.nature}' />
					</td>	
			</tr>
			<tr>
			<th><label class="required">单位详细地址： </label></th>
				<td colspan="2">
				
				<input reg='{"required":"true","maxlength":50}'  type="text" 
					id="companyDetailAddress" name="companyDetailAddress"
					value="${employeesHealthChecklist.companyDetailAddress}" />
				</td>
				<td></td>
			</tr> 
			
			<tr>
			<th><label class="required">个人户口所在地： </label></th>
				<td colspan="2">
				
				<input reg='{"required":"true","maxlength":50}'  type="text" 
					id="text_name" name="registeredResidence"
					value="${employeesHealthChecklist.registeredResidence}" />
				</td>
				<td></td>
			</tr> 
			
			<tr>
				<th><label class="required">行业种类：</label></th>
				<td><input reg='{"required":"true","maxlength":50}'  type="text" style="width:155px"
					name="industryCategory"
					value="${employeesHealthChecklist.industryCategory}" /></td>
				<th><label class="required">本人工种：</label></th>
				<td>
				
				<input reg='{"required":"true","maxlength":50}'  type="text" style="width:155px"
					name="myselfWorkType"
					value="${employeesHealthChecklist.myselfWorkType}" />
					</td>	
			</tr>
		</table></fieldset>
	</div>
	
	<div class="postcontent"  id="diseaseHistorySpan" align="left">
			<fieldset>
				<legend class="required">既往史</legend>
				<table class="posttable">
				<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
					<tr><th>疾病:</th>
					<td><label><input class="flag" type="radio" name="diseaseHistoryFlag" value="1" id="diseaseHistory_Flag1" ${employeesHealthChecklist.diseaseHistoryFlag eq '1' || employeesHealthChecklist.diseaseHistoryFlag eq null  ? 'checked=checked' : ''}/> 无</label>
							<label><input class="flag selectedFlag" type="radio" name="diseaseHistoryFlag" value="2" id="diseaseHistory_Flag2" ${employeesHealthChecklist.diseaseHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
							<br/></td>
					
							<%-- <div id="diseaseHistorySpan" style="display:${PersonalBasicInfoDTO.diseaseHistoryFlag eq '2' ? '' : 'none'}"> --%>
					
					</tr>
					<tr class="diseaseHistoryFlag" style="${employeesHealthChecklist.diseaseHistoryFlag eq '2' ? '' : 'display:none'}">
						<!-- <td>
							<div >
								<table>
									<tr> -->
										<th></th>
										<td >
											<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="hepatitisFlag" value="201" ${employeesHealthChecklist.hepatitisFlag eq '201' ? 'checked=checked' : ''}/>肝炎 </label>
											患病时间 <tag:dateInput  reg='{"dependOn":"employeesHealthChecklist.hepatitisFlag","dependValue":"201","required":"true"}' name="hepatitisDate" date="${employeesHealthChecklist.hepatitisDate}" style="width:100px"/>
										</td>
										<th></th>							
										<td >
											<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="dysenteryFlag" value="202" ${employeesHealthChecklist.dysenteryFlag eq '202' ? 'checked=checked' : ''}/> 痢疾 </label>
											 患病时间<tag:dateInput onlypast="true" reg='{"dependOn":"employeesHealthChecklist.dysenteryFlag","dependValue":"202","required":"true"}'  name="dysenteryDate" date="${employeesHealthChecklist.dysenteryDate}"  style="width:100px"/>
										</td>
										
									</tr>
									<tr class="diseaseHistoryFlag" style="${employeesHealthChecklist.diseaseHistoryFlag eq '2' ? '' : 'display:none'}">
										<th></th>
										<td >
											<label><input  reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}' type="checkbox" name="typhoidfeverFlag" value="203" ${employeesHealthChecklist.typhoidfeverFlag eq '203' ? 'checked=checked' : ''}/>伤寒</label>
											 患病时间<tag:dateInput onlypast="true" reg='{"dependOn":"employeesHealthChecklist.typhoidfeverFlag","dependValue":"203","required":"true"}'  name="typhoidfeverDate" date="${employeesHealthChecklist.typhoidfeverDate}"  style="width:100px"/>
										</td>
										<th></th>
										<td>
											<label><input  reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}' type="checkbox" name="tuberculosisFlag" value="204" ${employeesHealthChecklist.tuberculosisFlag eq '204' ? 'checked=checked' : ''}/>结核病</label>
								                                     患病时间<tag:dateInput onlypast="true" reg='{"dependOn":"employeesHealthChecklist.tuberculosisFlag","dependValue":"204","required":"true"}'  name="tuberculosisDate" date="${employeesHealthChecklist.tuberculosisDate}"  style="width:100px"/>
										</td>
										</tr>
										
										<tr class="diseaseHistoryFlag" style="${employeesHealthChecklist.diseaseHistoryFlag eq '2' ? '' : 'display:none'}">
										<th></th>
										<td>
											<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="skindiseaseFlag" value="205" ${employeesHealthChecklist.skindiseaseFlag eq '205' ? 'checked=checked' : ''}/>皮肤病</label>
											 患病时间<tag:dateInput onlypast="true" reg='{"dependOn":"employeesHealthChecklist.skindiseaseFlag","dependValue":"205","required":"true"}'  name="skindiseaseDate"  date="${employeesHealthChecklist.skindiseaseDate}"   style="width:100px"/>
										</td>
										<th></th>
										<td>
											<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="nzzFlag" value="206" ${employeesHealthChecklist.nzzFlag eq '206' ? 'checked=checked' : ''}/>其他</label>
											 患病时间<tag:dateInput onlypast="true" reg='{"dependOn":"employeesHealthChecklist.nzzFlag","dependValue":"206","required":"true"}'  name="nzzDate" date="${employeesHealthChecklist.nzzDate}"  style="width:100px"/>
										</td>
									</tr>
									
								<!-- </table>
							</div>
						</td>
					</tr> --></table></fieldset></div>
					
	<div class="postcontent" >
			<fieldset>
				<legend class="required">体征</legend>
				<table class="posttable">
				<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
					<tr>
										<th>心:</th>
										<td >
											<input type="text" name="cardiacSign" id="cardiacSign"  reg='{"required":"true"}' value="${employeesHealthChecklist.cardiacSign}" style="width: 155px;"></input>
										</td>
										<th>肝:</th>							
										<td >
											 <input type="text" name="liverSign" id="liverSign"  reg='{"required":"true"}' value="${employeesHealthChecklist.liverSign}" style="width: 155px;"></input>
										</td>
										
									</tr>
									<tr>
										<th>脾:</th>
										<td >
											 <input type="text" name="splenicSign" id="splenicSign"  reg='{"required":"true"}' value="${employeesHealthChecklist.splenicSign}" style="width: 155px;"></input>
										</td>
										<th>肺:</th>
										<td>
								             <input type="text" name="lungSign" id="lungSign"  reg='{"required":"true"}' value="${employeesHealthChecklist.lungSign}" style="width: 155px;"></input>
										</td>
										</tr>
									<tr>
									<th></th>
									<td colspan="3">
									<ehr:dic-checkbox  reg='{"required":"true"}'
											name="skinSign"  code="1,4,2,3,5,6,7,8,9"
											value="${employeesHealthChecklist.skinSign}"
											dicmeta="CHG10601"></ehr:dic-checkbox></td>
									
									</tr>
									<tr>
										<th>其它:</th>
										<td >
											 <input type="text" name="otherSkinSigns" id="otherSkinSigns"  reg='{"required":"true"}' value="${employeesHealthChecklist.otherSkinSigns}" style="width: 155px;"></input>
										</td>
										<th>医师签名:</th>
										<td>
								             <input type="text" name="signDoctorSignature" id="signDoctorSignature"  reg='{"required":"true"}' value="${employeesHealthChecklist.signDoctorSignature}" style="width: 155px;"></input>
										</td>
										</tr>
													
								</table>
							</fieldset>
							<br/><br/>
							<fieldset>
							
				<legend class="required">X线胸透或肺部拍片</legend>
				<table class="posttable">
				<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
									<tr>	
										<th>胸透或肺部拍片</th>
										<td  colspan="3">
											<input reg='{"required":"true","maxlength":200}'  type="text" 
												id="chest" name="chest"
												value="${employeesHealthChecklist.chest}" />
										</td>
										
									</tr>
									<tr>
										<th></th>
										<td >
										</td>
										<th>医师签名:</th>
										<td>
								             <input type="text" name="chestDoctorSignature" id="chestDoctorSignature"  reg='{"required":"true"}' value="${employeesHealthChecklist.chestDoctorSignature}" style="width: 155px;"></input>
										</td>
										</tr>
													
								</table>
							</fieldset>
							<br/><br/>
							<fieldset>
							
				<legend class="required">实验室检查化验单附后</legend>
				<br/><br/>
				<table class="posttable" border="1">
				<colgroup>
						<col style="width: 15%;" />
						<col style="width: 25%;" />
						<col style="width: 30%;" />
						<col style="width: 30%;" />
					</colgroup>
									<tr>	
										<td colspan="2">检查项目</td>
										<td>检查结果</td>
										<td>检验师签名</td>
									</tr>
									<tr>
									<td rowspan="2" align="center" style="vertical-align: middle;">大便培养</td>
									<td>痢疾杆菌</td>
									<td><input type="text" name="dysenteryBacillus" id="dysenteryBacillus"  reg='{"required":"true"}' value="${employeesHealthChecklist.dysenteryBacillus}" style="width: 100%"></input></td>
									<td><input type="text" name="dysenteryBacillusDoctor" id="dysenteryBacillusDoctor"  reg='{"required":"true"}' value="${employeesHealthChecklist.dysenteryBacillusDoctor}" style="width: 155px"></input></td>
									</tr>				
									<tr>
									<td>伤寒或副伤寒</td>
									<td><input type="text" name="typhoidResult" id="typhoidResult"  reg='{"required":"true"}' value="${employeesHealthChecklist.typhoidResult}" style="width: 100%"></input></td>
									<td><input type="text" name="typhoidDoctorSignature" id="typhoidDoctorSignature"  reg='{"required":"true"}' value="${employeesHealthChecklist.typhoidDoctorSignature}" style="width: 155px"></input></td>
									</tr>
									
									
									<tr>
									<td rowspan="3" align="center" style="vertical-align: middle;">肝功能</td>
									<td>谷丙转氨酶</td>
									<td><input type="text" name="glutamicPyruvicTransaminase" id="glutamicPyruvicTransaminase"  reg='{"required":"true"}' value="${employeesHealthChecklist.glutamicPyruvicTransaminase}" style="width: 100%"></input></td>
									<td><input type="text" name="glutamicPyruvicDoctor" id="glutamicPyruvicDoctor"  reg='{"required":"true"}' value="${employeesHealthChecklist.glutamicPyruvicDoctor}" style="width: 155px"></input></td>
									</tr>				
									<tr>
									<td>甲肝1gM</td>
									<td><input type="text" name="hepatitisa" id="hepatitisa"   value="${employeesHealthChecklist.hepatitisa}" style="width: 100%"></input></td>
									<td><input type="text" name="hepatitisaDoctor" id="hepatitisaDoctor"   value="${employeesHealthChecklist.hepatitisaDoctor}" style="width: 155px"></input></td>
									</tr>
									<tr>
									<td>戊肝1gM</td>
									<td><input type="text" name="hepatitise" id="hepatitise"   value="${employeesHealthChecklist.hepatitise}" style="width: 100%"></input></td>
									<td><input type="text" name="hepatitiseDoctor" id="hepatitiseDoctor"   value="${employeesHealthChecklist.hepatitiseDoctor}" style="width: 155px"></input></td>
									</tr>
									<tr><td align="center"><span style="font-size: 11px;font-weight: bold;">TRUST:</span></td>
										<td colspan="3">
										<input type="text" name="trust" id="trust"   value="${employeesHealthChecklist.trust}" style="width: 100%"></input>
										</td>
									</tr>	
								</table>
							</fieldset>
							<br/><br/>
							<fieldset>
							
				<legend class="required">结论</legend>
				<table class="posttable">
				<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
									<tr>	
										<th>检查结论:</th>
										<td  colspan="3">
											<input reg='{"required":"true","maxlength":200}'  type="text" 
												id="inspectResult" name="inspectResult"
												value="${employeesHealthChecklist.inspectResult}" />
										</td>
										
									</tr>
									<tr>
										
										<th>主检医师签名:</th>
										<td>
								             <input type="text" name="inspectResultDoctor" id="inspectResultDoctor"  reg='{"required":"true"}' value="${employeesHealthChecklist.inspectResultDoctor}" style="width: 155px;"></input>
										</td>
										<th>日期:</th>
										<td >
										<tag:dateInput onlypast="true" reg='{"required":"true"}'  name="inspectResultDate" date="${employeesHealthChecklist.inspectResultDate}"  style="width:155px"/>
										</td>
										</tr>
													
								</table>
							</fieldset>
						</div>			</div>	
	</form>
</div>