<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<i class="popno">
     男女婚检信息<br/>
</i>
<fieldset class="layui-elem-field">
	<legend>1、基本信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
		    <th>姓名：</th>
			<td style="text-align: left">${premaritalHealth.name}</td>
			<th>身份证件号码：</th>
			<td style="text-align: left">${premaritalHealth.idCard}</td>
		</tr>
		<tr>
			<th>民族：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="GBT3304" code="${premaritalHealth.nation}"/>
		    </td>
			<th>出生日期：</th>
			<td style="text-align: left">${premaritalHealth.birthday}</td>
		</tr>
		<tr>
			<th>学历：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="GBT46582006" code="${premaritalHealth.education}"/>
		    </td>
			<th>国籍：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="GBT26592000" code="${premaritalHealth.nationalityCode}"/>
		    </td>
		</tr>
		<tr>
		    <th>详细地址：</th>
			<td style="text-align: left" colspan="3">
			    ${premaritalHealth.paprovince} ${premaritalHealth.pacounty} ${premaritalHealth.patownShip} ${premaritalHealth.pastreet}
			</td>
		</tr>
	</table>
</fieldset>
<fieldset class="layui-elem-field">
	<legend>2、检查指标</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
			<th>身高(cm)：</th>
			<td style="text-align: left">${premaritalHealth.height}</td>
			<th>体重(kg)：</th>
			<td style="text-align: left">${premaritalHealth.bodyWeight}</td>
		</tr>
		<tr>
			<th>收缩压(mmHg)：</th>
			<td style="text-align: left">${premaritalHealth.sbp}</td>
			<th>舒张压(mmHg)：</th>
			<td style="text-align: left">${premaritalHealth.dbp}</td>
		</tr>
		<tr>
			<th>特殊体态检查结果：</th>
			<td style="text-align: left">${premaritalHealth.specialBodyCheckResult}</td>
			<th>特殊面容检查结果：</th>
			<td style="text-align: left">${premaritalHealth.specialFaceCheckResult}</td>
		</tr>
		<tr>
			<th>五官检查结果：</th>
			<td style="text-align: left">${premaritalHealth.facialFeaturesCheckResult}</td>
			<th>智力发育：</th>
			<td style="text-align: left">${premaritalHealth.mentalDevelopment}</td>
		</tr>
		<tr>
			<th>心律：</th>
			<td style="text-align: left">${premaritalHealth.cardioverter}</td>
			<th>心率(次/分钟)：</th>
			<td style="text-align: left">${premaritalHealth.heartRate}</td>
		</tr>
		<tr>
			<th>心脏听诊结果：</th>
			<td style="text-align: left">${premaritalHealth.cardiacAuscuResult}</td>
			<th>肺部听诊结果：</th>
			<td style="text-align: left">${premaritalHealth.lungAuscuResult}</td>
		</tr>
		<tr>
			<th>肝脏触诊结果：</th>
			<td style="text-align: left">${premaritalHealth.liverPalpResult}</td>
			<th>四肢检查结果：</th>
			<td style="text-align: left">${premaritalHealth.limbsCheckResult}</td>
		</tr>
		<tr>
			<th>脊柱检查结果：</th>
			<td style="text-align: left">${premaritalHealth.spineCheckResult}</td>
			<th>皮肤毛发检查结果：</th>
			<td style="text-align: left">${premaritalHealth.skinHairCheckResult}</td>
		</tr>
		<tr>
			<th>胸部X线检查结果：</th>
			<td style="text-align: left">${premaritalHealth.chestXCheckResult}</td>
			<th>白细胞分类结果：</th>
			<td style="text-align: left">${premaritalHealth.leukocyteType}</td>
		</tr>
		<tr>
			<th>白细胞计数值(G/L)：</th>
			<td style="text-align: left">${premaritalHealth.leukocyteCount}</td>
			<th>红细胞计数值(G/L)：</th>
			<td style="text-align: left">${premaritalHealth.erythrocyteCount}</td>
		</tr>
		<tr>
			<th>血红蛋白值(g/L)：</th>
			<td style="text-align: left">${premaritalHealth.hemoglobinValue}</td>
			<th>血小板计数值(G/L)：</th>
			<td style="text-align: left">${premaritalHealth.plateletCount}</td>
		</tr>
		<tr>
			<th>尿比重：</th>
			<td style="text-align: left">${premaritalHealth.urineProportion}</td>
			<th>尿蛋白定量检测值(mg/24h)：</th>
			<td style="text-align: left">${premaritalHealth.urineProQuantitativeValue}</td>
		</tr>
		<tr>
			<th>尿糖定量检测(mmol/L)：</th>
			<td style="text-align: left">${premaritalHealth.urineSugQuantitativeDetect}</td>
			<th>尿液酸碱度：</th>
			<td style="text-align: left">${premaritalHealth.urinePh}</td>
		</tr>
		<tr>
		    <th>ABO血型：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0450005" code="${premaritalHealth.aboBloodType}"/>
		    </td>
			<th>Rh血型：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10010" code="${premaritalHealth.rhBloodType}"/>
		    </td>
		</tr>
		<tr>
			<th>血缘关系：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0201201" code="${premaritalHealth.bloodRelation}"/>
		    </td>
			<th>精神状态：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10210" code="${premaritalHealth.mentalStateCode}"/>
		    </td>
		</tr>
		<tr>
			<th>梅毒血清学试验结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10058" code="${premaritalHealth.syphilisSerologyCheckResult}"/>
		    </td>
			<th>HIV抗体检测结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10056" code="${premaritalHealth.hivlgDetectResult}"/>
		    </td>
		</tr>
		<tr>
			<th>乙型肝炎病毒表面抗原检测结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10092" code="${premaritalHealth.hbsagDetectResult}"/>
		    </td>
			<th>疾病诊断：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV550219" code="${premaritalHealth.diseaseDiagnosisCode}"/>
		    </td>
		</tr>
		<tr>
			<th>婚前医学检查结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0510005" code="${premaritalHealth.preMedicalCheckResult}"/>
		    </td>
			<th>婚检咨询指导结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10027" code="${premaritalHealth.preConsultationGuidResult}"/>
		    </td>
		</tr>
	</table>
</fieldset>
<fieldset class="layui-elem-field">
	<legend>3、其他信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%;"/>
	        <col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
		    <th>首诊医师姓名：</th>
			<td style="text-align: left">${premaritalHealth.firstVisitDoctorName}</td>
			<th>检查(测)人员姓名：</th>
			<td style="text-align: left">${premaritalHealth.checkName}</td>
		</tr>
		<tr>
			<th>检查(测)机构名称：</th>
			<td style="text-align: left">${premaritalHealth.checkOrganName}</td>
			<th>检查(测)日期：</th>
			<td style="text-align: left">${premaritalHealth.checkDate}</td>
		</tr>
		<tr>
			<th>填报机构名称：</th>
			<td style="text-align: left">
                ${premaritalHealth.createOrganName}<%--<ehr:dic dicmeta="GBT46582006" code="${premaritalHealth.createOrganName}"/>--%>
		    </td>
			<th>填报日期：</th>
			<td style="text-align: left">${premaritalHealth.fillDate}</td>
		</tr>
	</table>
</fieldset>
</div>