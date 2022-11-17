<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/studentExam/editExamReport.js"></script>
<div id="editExamReportDiv">
<div id="top"></div>
<div class="toolbar">
	<a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)" id="save"><b class="baocun">保存</b></a>
</div>
<form id="examReport">
	<div class="postcontent contentfixed">
		<i class="popno">市中小学生健康检查表</i>
		<div class="postdiv">
			<input type="hidden" id="studentExamId" name="studentExamId" value="${exam.studentExamId}"/>
			<input type="hidden" id="personInfoId" name="personInfoId" value="${exam.personInfoId}"/>
			<input type="hidden" name="ehrId" value="${exam.ehrId}"/>
			<table>
				<tr>
					<td style="text-align: left">
						<label class="required"><b>学生身份证号：</b></label>
						<input type="text" id="idCard" name="idcard" placeholder="输入身份证获取个人信息"
						        value="${exam.idcard}" style="width: 200px" reg='{"required":"true", "idCard":"true"}'/>
					</td>
					<td style="text-align: right">
						<b><label class="required">体检日期</label>：</b>
						<tag:dateInput id="examDate" name="examDate" pattern="yyyy/MM/dd" date="${exam.examDate}" style="width:75px;" reg='{"required":"true"}'/>
						<input type="hidden" id="hiddenExamDate" name="hiddenExanDate" value="<fmt:formatDate value="${exam.examDate}" pattern="yyyy/MM/dd"/>" />
						<input type="hidden" id="addFlag" value="${addFlag}" />
					</td>
				</tr>
			</table>
			<fieldset>
				<legend>学生信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>姓名</th>
						<td>
							<input type="text" id="name" name="name" value="${exam.name}"  style="width: 100px;" readonly="true" />
						</td>
						<th>学校</th>
						<td>
							<input id="schoolName" type="text" name="schoolName" value="${exam.schoolName}"  style="width: 100px;" readonly="true" />
							<input type="hidden" id="schoolCode" name="schoolCode" value="${exam.schoolCode}"/>
						</td>
					</tr>
					<tr>
						<th>性别</th>
						<td>
							<input type="text" id="genderName" value="${exam.genderName}"  style="width: 100px;" readonly="true" />
							<input type="hidden" id="gender" name="gender" value="${exam.gender}"  />
						</td>
						<th>入学年份</th>
						<td>
							<%--<input type="text" name="inYear" value="${exam.inYear}" style="width: 75px;" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})" maxlength="10" readonly="true" />--%>
							<input type="text"  id="inYear"  name="inYear"  value="${exam.inYear}"  style="width: 100px;" readonly="true" />
						</td>
					</tr>
					<tr>
						<th>出生日期</th>
						<td>
							<input type="text" id="birthday" name="birthday" value='<fmt:formatDate value="${exam.birthday}"
									pattern="yyyy/MM/dd"/>'  style="width: 100px;" readonly="true" />
						</td>
						<th>年级</th>
						<td><input id="gradeName" type="text" name="gradeName" value="${exam.gradeName}"  style="width: 100px;" readonly="true" />
						<input type="hidden" id="gradeCode" name="gradeCode" value="${exam.gradeCode}"/></td>
					</tr>
					<tr>
						<th>民族</th>
						<td>
							<%-- <ehr:dic-list name="nation" dicmeta="GBT3304" value="${exam.nation}" width="150px"/> --%>
							<input type="text"  id="nation"  name="nation"  value="${exam.nation}"   style="width: 100px;" readonly="true"  />
						</td>
						<th>班级</th>
						<td><input id="classCode" type="text" name="classCode" value="${exam.classCode}"  style="width: 100px;" readonly="true" /></td>
					</tr>
					<tr>
						<th>血型</th>
						<td>
							<%-- <ehr:dic-list name="aboBloodType" dicmeta="CV0450005" value="${exam.aboBloodType}" width="150px" /> --%>
							<input type="text"  id="aboBloodType"  name="aboBloodType"  value="${exam.aboBloodType}"   style="width: 100px;" readonly="true" />
						</td>
						<th>学籍卡号</th>
						<td><input id="studentNo" type="text" name="studentNo" value="${exam.studentNo}"  style="width: 100px;" readonly="true" /></td>
					</tr>
					<tr>
						<th>父亲文化程度</th>
						<td>
							<ehr:dic-list name="fatherEducation" dicmeta="GBT46582006" value="${exam.fatherEducation}" width="150px" code="IDM02,IDM03,IDM04,IDM07,IDM11,IDM12,IDM13,90"/>
						</td>
						<th>母亲文化程度</th>
						<td>
						    <ehr:dic-list name="motherEducation" dicmeta="GBT46582006" value="${exam.motherEducation}" width="150px" code="IDM02,IDM03,IDM04,IDM07,IDM11,IDM12,IDM13,90"/>
                        </td>
					</tr>
					<tr>
						<th>既往重要病史</th>
						<td colspan="3">
							<input type="checkbox" name="medicalHistory" value="结核病" ${fn:contains(exam.medicalHistory, "结核病") ? "checked" : ""}/> 结核病
							<input type="checkbox" name="medicalHistory" value="肝炎" ${fn:contains(exam.medicalHistory, "肝炎") ? "checked" : ""}/> 肝炎
							<input type="checkbox" name="medicalHistory" value="肾炎" ${fn:contains(exam.medicalHistory, "肾炎") ? "checked" : ""}/> 肾炎
							<input type="checkbox" name="medicalHistory" value="心脏病" ${fn:contains(exam.medicalHistory, "心脏病") ? "checked" : ""}/> 心脏病
							<input type="checkbox" name="medicalHistory" value="风湿病" ${fn:contains(exam.medicalHistory, "风湿病") ? "checked" : ""}/> 风湿病
							<input type="checkbox" name="medicalHistory" value="过敏性疾病" ${fn:contains(exam.medicalHistory, "过敏性疾病") ? "checked" : ""}/> 过敏性疾病
							<input type="checkbox" name="medicalHistory" value="其他" onclick="util.clickShowText(this, 'otherMedicalHistory')" ${fn:contains(exam.medicalHistory, "其他") ? "checked" : ""}/> 其他
							<input type="text" id="otherMedicalHistory" name="otherMedicalHistory" style="width: 80px;${exam.otherMedicalHistory eq null ? 'display:none;' : ''}" value="${exam.otherMedicalHistory}" reg='{"maxlength":50}'/>
						</td>
					</tr>
					<tr>
					    <th>预防接种</th>
						<td colspan="3">
						    <textarea name="vaccination" value="" style="width: 90%; font-size:12px;" rows="3" >${exam.vaccination}</textarea>
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>形体</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">身高</label></th>
						<td><tag:numberInput id="height" name="height" value="${exam.height}" style="width: 100px" reg='{"required":"true","min":90.0,"max":210.0}' point="point"/> cm</td>
						<th>医生签名</th>
						<td><input type="text" name="bodyDoctor" value="${exam.bodyDoctor}" reg='{"maxlength":16}'/></td>
					</tr>
					<tr>
						<th><label class="required">体重</label></th>
						<td><tag:numberInput id="bodyWeight" name="bodyWeight" value="${exam.bodyWeight}" style="width: 100px" reg='{"required":"true","min":10.0,"max":150.0}' point="point"/> kg</td>
						<th></th>
						<td></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>生理功能</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">血压</label></th>
						<td>
							<tag:numberInput name="sbp" value="${exam.sbp}" style="width: 40px" reg='{"required":"true","min":60,"max":250}' /> /
							<tag:numberInput name="dbp" value="${exam.dbp}" style="width: 40px" reg='{"required":"true","min":40,"max":140}' />mmHg
						</td>
						<th>脉搏</th>
						<td><tag:numberInput name="pulseRate" value="${exam.pulseRate}" style="width: 100px" reg='{"min":30,"max":200}'/> 次/分</td>
					</tr>
					<tr>
						<th>肺活量</th>
						<td><tag:numberInput name="vitalCapacity" value="${exam.vitalCapacity}" style="width: 100px" reg='{"min":100,"max":8000}'/> ml</td>
						<th>医生签名</th>
						<td><input type="text" name="physicalDoctor" value="${exam.physicalDoctor}" style="width: 100px;" reg='{"maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>眼科</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">裸眼视力</label></th>
						<td>
							右 <tag:numberInput name="rNakedEye" point="point" value="${exam.rNakedEye}" style="width: 60px" reg='{"required":true,"min":0,"max":5.3}'/>
							左 <tag:numberInput name="lNakedEye" point="point" value="${exam.lNakedEye}" style="width: 60px" reg='{"required":true,"min":0,"max":5.3}'/>
						</td>
						<th>辨色</th>
						<td>
							<input type="radio" name="colorVision" value="1" ${exam.colorVision eq "1" ? "checked" : ""}/> 正常
							<input type="radio" name="colorVision" value="0" ${exam.colorVision eq "0" ? "checked" : ""}/> 异常
						</td>
					</tr>
					<tr>
						<th>沙眼</th>
						<td>
						    <table>
						        <tr>
								    <th style="width: 10px;text-align:left;">右</th>
							        <td><ehr:dic-radio id="rTrachomaEye" name="rTrachomaEye" dicmeta="HM00001" value="${exam.rTrachomaEye}"/></td>
							        <th style="width: 10px;text-align:left;">左</th>
							        <td><ehr:dic-radio id="lTrachomaEye" name="lTrachomaEye" dicmeta="HM00001" value="${exam.lTrachomaEye}"/></td>
							    </tr>
						    </table>
						</td>
						<th>结膜炎</th>
						<td>
						    <ehr:dic-radio id="conjunctivitis" name="conjunctivitis" dicmeta="HM00001" value="${exam.conjunctivitis}" code="0,1"/>
						</td>
					</tr>
					<tr>
						<th>其他</th>
						<td><input type="text" name="eyeOther" value="${exam.eyeOther}" reg='{"maxlength":50}'/></td>
						<th>医生签名</th>
						<td><input type="text" name="eyeDoctor" value="${exam.eyeDoctor}" style="width: 100px;" reg='{"maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>口腔</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>齿列</th>
						<td colspan="3">
							<span style="float:left;">龋齿</span>
							<table id="decayedToothNo" style="width: 10%;float:left;margin-right:5px;">
								<tr>
									<td>乳牙<tag:numberInput name="decayedToothNoUpl" value="${exam.decayedToothNoUpl}" style="width: 20px" reg='{"min":0,"max":20}' />颗</td>
								</tr>
								<tr>
									<td>恒牙<tag:numberInput name="decayedToothNoUpr" value="${exam.decayedToothNoUpr}" style="width: 20px" reg='{"min":0,"max":32}' />颗</td>
								</tr>
							</table>
							<span style="float:left;">龋缺</span>
							<table id="missingToothNo" style="width: 10%;float:left;margin-right:5px;">
								<tr >
									<td>乳牙<tag:numberInput name="missingToothNoUpl"  value="${exam.missingToothNoUpl}" style="width: 20px" reg='{"min":0,"max":20}' />颗</td>
								</tr>
								<tr>
									<td>恒牙<tag:numberInput name="missingToothNoUpr" value="${exam.missingToothNoUpr}" style="width: 20px" reg='{"min":0,"max":32}' />颗</td>
								</tr>
							</table>
							<span style="float:left;"> 龋补</span>
							<table id="fillToothNo" style="width: 10%;float:left;margin-right:5px;">
								<tr >
									<td>乳牙<tag:numberInput name="fillToothNoUpl"  value="${exam.fillToothNoUpl}" style="width: 20px" reg='{"min":0,"max":20}' />颗</td>
								</tr>
								<tr>
									<td>恒牙<tag:numberInput name="fillToothNoUpr" value="${exam.fillToothNoUpr}" style="width: 20px" reg='{"min":0,"max":32}' />颗</td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<th>牙周病</th>
						<td colspan="3">
						    <ehr:dic-radio id="periodontalCehckResult" name="periodontalCehckResult" dicmeta="HM00002" value="${exam.periodontalCehckResult}"
                            	         onchange="hmStudentExamReport.toggle('periodontalCehckResult','toothOther','9')"/>
                            <span id="toothOther" style="display:${exam.periodontalCehckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="toothOther" value="${exam.toothOther}" reg='{"maxlength":"10","required":"true"}' />
                            </span>
						</td>
					</tr>
					<tr>
						<th>医生签名</th>
						<td><input type="text" name="toothDoctor" value="${exam.toothDoctor}" style="width: 100px;" reg='{"maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>内科</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 85%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>心</th>
						<td colspan="3">
						    <ehr:dic-radio id="heartCheckResult" name="heartCheckResult" dicmeta="HM00003" value="${exam.heartCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('heartCheckResult','heartOther','9')"/>
                            <span id="heartOther" style="display:${exam.heartCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="heartOther" value="${exam.heartOther}" reg='{"maxlength":"10","required":"true"}' />
                            </span>
						</td>
					</tr>
					<tr>
						<th>肝</th>
						<td colspan="3">
						    <ehr:dic-radio id="liverCheckResult" name="liverCheckResult" dicmeta="HM00005" value="${exam.liverCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('liverCheckResult','liverOther','9')"/>
                            <span id="liverOther" style="display:${exam.liverCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="liverOther" value="${exam.liverOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>肺</th>
						<td colspan="3">
						    <ehr:dic-radio id="lungsCheckResult" name="lungsCheckResult" dicmeta="HM00004" value="${exam.lungsCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('lungsCheckResult','lungsOther','9')"/>
                            <span id="lungsOther" style="display:${exam.lungsCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="lungsOther" value="${exam.lungsOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>脾</th>
						<td colspan="3">
						    <ehr:dic-radio id="spleenCheckResult" name="spleenCheckResult" dicmeta="HM00006" value="${exam.spleenCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('spleenCheckResult','spleenOther','9')"/>
                            <span id="spleenOther" style="display:${exam.spleenCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="spleenOther" value="${exam.spleenOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>医生签名</th>
						<td><input type="text" name="internalDoctor" value="${exam.internalDoctor}" style="width: 100px;" reg='{"maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>外科</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 85%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>头部</th>
						<td colspan="3">
						    <ehr:dic-radio id="headCheckResult" name="headCheckResult" dicmeta="HM00007" value="${exam.headCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('headCheckResult','headOther','9')"/>
                            <span id="headOther" style="display:${exam.headCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="headOther" value="${exam.headOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>颈部</th>
						<td colspan="3">
						    <ehr:dic-radio id="neckCheckResult" name="neckCheckResult" dicmeta="HM00008" value="${exam.neckCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('neckCheckResult','neckOther','9')"/>
                            <span id="neckOther" style="display:${exam.neckCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="neckOther" value="${exam.neckOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>胸部</th>
						<td colspan="3">
						    <ehr:dic-radio id="chestCheckResult" name="chestCheckResult" dicmeta="HM00009" value="${exam.chestCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('chestCheckResult','chestOther','9')"/>
                            <span id="chestOther" style="display:${exam.chestCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="chestOther" value="${exam.chestOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>脊柱</th>
						<td colspan="3">
						    <ehr:dic-radio id="spineCheckResult" name="spineCheckResult" dicmeta="HM00010" value="${exam.spineCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('spineCheckResult','spineOther','9')"/>
                            <span id="spineOther" style="display:${exam.spineCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="spineOther" value="${exam.spineOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>四肢</th>
						<td colspan="3">
						    <ehr:dic-radio id="limbsCheckResult" name="limbsCheckResult" dicmeta="HM00011" value="${exam.limbsCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('limbsCheckResult','limbsOther','9')"/>
                            <span id="limbsOther" style="display:${exam.limbsCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="limbsOther" value="${exam.limbsOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>皮肤</th>
						<td colspan="3">
						    <ehr:dic-radio id="skinCheckResult" name="skinCheckResult" dicmeta="HM00012" value="${exam.skinCheckResult}"
                            	         onchange="hmStudentExamReport.toggle('skinCheckResult','skinOther','9')"/>
                            <span id="skinOther" style="display:${exam.skinCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="skinOther" value="${exam.skinOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>淋巴结</th>
						<td colspan="3">
						    <ehr:dic-radio id="lymphNodeCheckResult" name="lymphNodeCheckResult"  dicmeta="HM00013" value="${exam.lymphNodeCheckResult}"
						        onchange="hmStudentExamReport.toggle('lymphNodeCheckResult','lymphNodeOther','9')"/>
                            <span id="lymphNodeOther" style="display:${exam.lymphNodeCheckResult eq '9' ? 'true' : 'none'}">
                            	<input type="text" style="width: 150px;" name="lymphNodeOther" value="${exam.lymphNodeOther}" reg='{"maxlength":"10","required":"true"}'/>
                            </span>
						</td>
					</tr>
					<tr>
						<th>医生签名</th>
						<td><input type="text" name="surgeryDoctor" value="${exam.surgeryDoctor}" style="width: 100px;" reg='{"maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>化验</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th><span><sup title="【注】小学、初中入学新生必检项目">[1]</sup>结核菌素试验</span></th>
						<td>
							<input type="radio" name="tuberculinTest" value="阴性"  ${exam.tuberculinTest eq "阴性" ? "checked" : ""}/> 阴性
							<input type="radio" name="tuberculinTest" value="阳性"  ${exam.tuberculinTest eq "阳性" ? "checked" : ""}/> 阳性
						</td>
						<th><span><sup title="【注】小学生必要时进行的体检项目">[2]</sup>血红蛋白</span></th>
						<td><tag:numberInput name="hemoglobinValue" value="${exam.hemoglobinValue}" style="width: 50px" reg='{"min":0,"max":9999}' point="point"/> g/L</td>
					</tr>
					<tr>
						<th><span><sup title="【注】寄宿制学生必要时进行的体检项目">[3]</sup>肝功能</span></th>
						<td>
							谷丙转氨酶
							<tag:numberInput name="serumGptValue" value="${exam.serumGptValue}" style="width: 50px" reg='{"min":0,"max":9999}' point="point"/> U/L
							&nbsp;&nbsp;&nbsp;
							胆红素
							<tag:numberInput name="totalBilirubin" value="${exam.totalBilirubin}" style="width: 50px" reg='{"scale":"1","min":0,"max":999.9}' point="point"/> umol/L
						</td>
						<th>医生签名</th>
						<td><input type="text" name="labTestDoctor" value="${exam.labTestDoctor}" style="width: 100px;" reg='{"maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>其他</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 85%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>检查项</th>
						<td colspan="3"><input type="text" name="otherCheckItem" value="${exam.otherCheckItem}" reg='{"maxlength":66}'/></td>
					</tr>
					<tr>
						<th>检查结果</th>
						<td colspan="3"><input type="text" name="otherCheckResult" value="${exam.otherCheckResult}" reg='{"maxlength":66}'/></td>
					</tr>
					<tr>
						<th>医生签名</th>
						<td><input type="text" name="otherCheckDoctor" value="${exam.otherCheckDoctor}" style="width: 100px;" reg='{"maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>体检结论</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 85%;"/>
					</colgroup>
					<tbody>
					<%-- 
					<tr>
						<th>结果</th>
						<td colspan="3">
							<input type="radio" name="totalResult" value="1" ${exam.totalResult eq "1" ? "checked" : ""} /> 正常
							<input type="radio" name="totalResult" value="0" ${exam.totalResult eq "0" ? "checked" : ""} /> 异常
						</td>
					</tr>
					--%>
					<tr>
						<th>结论</th>
						<td colspan="3">
							<input type="hidden" name="totalResult" value="${exam.totalResult}" />
							<textarea name="examinationResult" value="" style="width: 90%; font-size:12px;" rows="3" >${exam.examinationResult}</textarea>
						</td>
					</tr>
					<tr>
						<th><label class="required">主检医生签名</label></th>
						<td><input type="text" name="manaDoctorName" value="${exam.manaDoctorName}" style="width: 100px;" reg='{"required":"true","maxlength":16}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>健康指导意见</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 85%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>健康指导</th>
						<td>
							<textarea name="healthGuidance" value="" style="width: 90%; font-size:12px;" rows="7" >${exam.healthGuidance}</textarea>
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
</div>