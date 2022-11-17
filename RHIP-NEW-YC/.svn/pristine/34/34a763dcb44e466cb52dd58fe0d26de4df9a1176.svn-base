<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<i class="popno">育龄妇女登记信息<br/></i>
<fieldset class="layui-elem-field">
	<legend>1、基本信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:30%;"/>
			<col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
		    <th>姓名：</th>
			<td style="text-align: left">${childBearing.name}</td>
			<th>身份证件号码：</th>
			<td style="text-align: left">${childBearing.idCard}</td>
		</tr>
		<tr>
			<th>民族：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="GBT3304" code="${childBearing.nation}"/>
		    </td>
			<th>出生日期：</th>
			<td style="text-align: left"><fmt:formatDate value="${childBearing.birthday}" pattern="yyyy/MM/dd"/></td>
		</tr>
		<tr>
			<th>学历：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="GBT46582006" code="${childBearing.education}"/>
		    </td>
			<th>国籍：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="GBT26592000" code="${childBearing.nationalityCode}"/>
		    </td>
		</tr>
		<tr>
			<th>详细地址：</th>
			<td style="text-align: left" colspan="3">
			    ${childBearing.paprovince} ${childBearing.pacounty}
					${childBearing.pastreet}${childBearing.pahouseNumber}
			</td>
		</tr>
	</table>
</fieldset>
<fieldset class="layui-elem-field">
	<legend>2、检查指标</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:30%;"/>
			<col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
			<th>身高(cm)：</th>
			<td style="text-align: left">${childBearing.height}</td>
			<th>体重(kg)：</th>
			<td style="text-align: left">${childBearing.bodyWeight}</td>
		</tr>
		<tr>
			<th>收缩压(mmHg)：</th>
			<td style="text-align: left">${childBearing.sbp}</td>
			<th>舒张压(mmHg)：</th>
			<td style="text-align: left">${childBearing.dbp}</td>
		</tr>
		<tr>
			<th>特殊体态检查结果：</th>
			<td style="text-align: left">${childBearing.specialBodyCheckResult}</td>
			<th>特殊面容检查结果：</th>
			<td style="text-align: left">${childBearing.specialFaceCheckResult}</td>
		</tr>
		<tr>
			<th>五官检查结果：</th>
			<td style="text-align: left">${childBearing.facialFeaturesCheckResult}</td>
			<th>智力发育：</th>
			<td style="text-align: left">${childBearing.mentalDevelopment}</td>
		</tr>
		<tr>
			<th>心律：</th>
			<td style="text-align: left">${childBearing.cardioverter}</td>
			<th>心率(次/分钟)：</th>
			<td style="text-align: left">${childBearing.heartRate}</td>
		</tr>
		<tr>
			<th>心脏听诊结果：</th>
			<td style="text-align: left">${childBearing.cardiacAuscuResult}</td>
			<th>肺部听诊结果：</th>
			<td style="text-align: left">${childBearing.lungAuscuResult}</td>
		</tr>
		<tr>
			<th>肝脏触诊结果：</th>
			<td style="text-align: left">${childBearing.liverPalpResult}</td>
			<th>四肢检查结果：</th>
			<td style="text-align: left">${childBearing.limbsCheckResult}</td>
		</tr>
		<tr>
			<th>脊柱检查结果：</th>
			<td style="text-align: left">${childBearing.spineCheckResult}</td>
			<th>皮肤毛发检查结果：</th>
			<td style="text-align: left">${childBearing.skinHairCheckResult}</td>
		</tr>
		<tr>
			<th>甲状腺检查结果：</th>
			<td style="text-align: left">${childBearing.thyroidCheckResult}</td>
			<th>阴道分泌物性状描述：</th>
			<td style="text-align: left">${childBearing.vaginaSecretionsDesc}</td>
		</tr>
		<tr>
			<th>阴毛检查结果：</th>
			<td style="text-align: left">${childBearing.pubesCheckResult}</td>
			<th>外阴检查结果：</th>
			<td style="text-align: left">${childBearing.vulvaCheckResult}</td>
		</tr>
		<tr>
			<th>阴道检查结果：</th>
			<td style="text-align: left">${childBearing.vaginaCheckResult}</td>
			<th>子宫检查结果：</th>
			<td style="text-align: left">${childBearing.uterusCheckResult}</td>
		</tr>
		<tr>
			<th>胸部X线检查结果：</th>
			<td style="text-align: left">${childBearing.chestXCheckResult}</td>
			<th>白细胞分类结果：</th>
			<td style="text-align: left">${childBearing.leukocyteType}</td>
		</tr>
		<tr>
			<th>白细胞计数值(G/L)：</th>
			<td style="text-align: left">${childBearing.leukocyteCount}</td>
			<th>红细胞计数值(G/L)：</th>
			<td style="text-align: left">${childBearing.erythrocyteCount}</td>
		</tr>
		<tr>
			<th>血红蛋白值(g/L)：</th>
			<td style="text-align: left">${childBearing.hemoglobinValue}</td>
			<th>血小板计数值(G/L)：</th>
			<td style="text-align: left">${childBearing.plateletCount}</td>
		</tr>
		<tr>
			<th>尿比重：</th>
			<td style="text-align: left">${childBearing.urineProportion}</td>
			<th>尿蛋白定量检测值(mg/24h)：</th>
			<td style="text-align: left">${childBearing.urineProQuantitativeValue}</td>
		</tr>
		<tr>
			<th>尿糖定量检测(mmol/L)：</th>
			<td style="text-align: left">${childBearing.urineSugQuantitativeDetect}</td>
			<th>尿液酸碱度：</th>
			<td style="text-align: left">${childBearing.urinePh}</td>
		</tr>
		<tr>
			<th>ABO血型：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0450005" code="${childBearing.aboBloodType}"/>
		    </td>
			<th>Rh血型：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10010" code="${childBearing.rhBloodType}"/>
		    </td>
		</tr>
		<tr>
			<th>血缘关系：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0201201" code="${childBearing.bloodRelation}"/>
		    </td>
			<th>月经出血量类别：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10028" code="${childBearing.menstrualBleedingType}"/>
		    </td>
		</tr>
		<tr>
			<th>痛经程度：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10041" code="${childBearing.dysmenorrheaDegree}"/>
		    </td>
			<th>精神状态：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10210" code="${childBearing.mentalStateCode}"/>
		    </td>
		</tr>
		<tr>
			<th>妇科检查方式：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0410003" code="${childBearing.gynaecologyExamWay}"/>
		    </td>
			<th>左侧附件检查结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0410001" code="${childBearing.lAttachmentCheckResult}"/>
		    </td>
		</tr>
		<tr>
			<th>右侧附件检查结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0410001" code="${childBearing.rAttachmentCheckResult}"/>
		    </td>
			<th>左侧乳腺检查结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0410012" code="${childBearing.lBreastCheckResult}"/>
		    </td>
		</tr>
		<tr>
			<th>右侧乳腺检查结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0410012" code="${childBearing.rBreastCheckResult}"/>
		    </td>
			<th>乙型肝炎病毒表面抗原检测结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10092" code="${childBearing.hbsagDetectResult}"/>
		    </td>
		</tr>
		<tr>
			<th>梅毒血清学试验结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10058" code="${childBearing.syphilisSerologyCheckResult}"/>
		    </td>
			<th>HIV抗体检测结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10056" code="${childBearing.hivlgDetectResult}"/>
		    </td>
		</tr>
		<tr>
			<th>滴虫检测结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10045" code="${childBearing.trichomoDetectResult}"/>
		    </td>
			<th>念珠菌检测结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10044" code="${childBearing.candidaDetectResult}"/>
		    </td>
		</tr>
		<tr>
			<th>阴道分泌物清洁度：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0450010" code="${childBearing.vaginaSecretionsCleanliness}"/>
		    </td>
			<th>疾病诊断：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV550219" code="${childBearing.diseaseDiagnosisCode}"/>
		    </td>
		</tr>
		<tr>
			<th>婚前医学检查结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="CV0510005" code="${childBearing.preMedicalCheckResult}"/>
		    </td>
			<th>婚检咨询指导结果：</th>
			<td style="text-align: left">
				<ehr:dic dicmeta="FS10027" code="${childBearing.preConsultationGuidResult}"/>
		    </td>
		</tr>
	</table>
</fieldset>
<fieldset class="layui-elem-field">
 	<legend>3、其他信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:30%;"/>
			<col style="min-width:80px;width:25%;"/>
			<col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
		    <th>首诊医师姓名：</th>
			<td style="text-align: left">${childBearing.firstVisitDoctorName}</td>
			<th>检查(测)人员姓名：</th>
			<td style="text-align: left">${childBearing.checkName}</td>
		</tr>
		<tr>
			<th>检查(测)机构名称：</th>
			<td style="text-align: left">${childBearing.checkOrganName}</td>
			<th>检查(测)日期：</th>
			<td style="text-align: left"><fmt:formatDate value="${childBearing.checkDate}" pattern="yyyy/MM/dd"/></td>
		</tr>
		<tr>
			<th>填报机构名称：</th>
			<td style="text-align: left">${childBearing.createOrganName}</td>
			<th>填报日期：</th>
			<td style="text-align: left"><fmt:formatDate value="${childBearing.fillDate}" pattern="yyyy/MM/dd"/></td>
		</tr>
	</table>
</fieldset>
</div>