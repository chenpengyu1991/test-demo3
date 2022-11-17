<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<i class="popno">
     妇女疾病筛查记录<br/>
</i>
	<fieldset class="layui-elem-field">
		<legend>1、基本信息</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width:150px;width:25%;"/>
				<col style="min-width:80px;width:25%;"/>
				<col style="min-width:80px;width:25%;"/>
				<col style="min-width:80px;width:25%"/>
			</colgroup>
			<tr>
				<th>姓名：</th>
				<td style="text-align: left">${womanDisease.name}</td>
				<th>出生日期：</th>
				<td style="text-align: left">
					<fmt:formatDate value="${womanDisease.birthday}" pattern="yyyy/MM/dd" />
				</td>
			</tr>
			<tr>
				<th>民族：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="GBT3304" code="${womanDisease.nation}"/>
				</td>
				<th>职业：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="GBT6565" code="${womanDisease.occupation}"/>
				</td>
			</tr>
			<tr>
				<th>工作单位：</th>
				<td style="text-align: left">${womanDisease.unitName}</td>
				<th>文化程度：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="GBT46582006" code="${womanDisease.education}"/>
				</td>
			</tr>
			<tr>
				<th>身份证件号码：</th>
				<td style="text-align: left">${womanDisease.idCard}</td>
				<th>婚姻状况：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="GBT226122003" code="${womanDisease.marriage}"/>
				</td>
			</tr>
			<tr>
				<th>详细地址：</th>
				<td style="text-align: left" colspan="3">
					${womanDisease.paprovince}${womanDisease.pacity}${womanDisease.pacounty}${womanDisease.patownShip}${womanDisease.pastreet}${womanDisease.pahouseNumber}
				</td>
			</tr>
		</table>
	</fieldset>
	<fieldset class="layui-elem-field">
		<legend>2、检查指标</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width:150px;width:25%;"/>
				<col style="min-width:80px;width:25%;"/>
				<col style="min-width:80px;width:25%;"/>
				<col style="min-width:80px;width:25%"/>
			</colgroup>
			<tr>
				<th>心率(次/分钟)：</th>
				<td style="text-align: left">${womanDisease.heartRate}</td>
				<th>收缩压(mmHg)：</th>
				<td style="text-align: left">${womanDisease.sbp}</td>
			</tr>
			<tr>
				<th>舒张压(mmHg)：</th>
				<td style="text-align: left">${womanDisease.dbp}</td>
				<th>初潮年龄(岁)：</th>
				<td style="text-align: left">${womanDisease.menarcheAge}</td>
			</tr>
			<tr>
				<th>月经周期(d)：</th>
				<td style="text-align: left">${womanDisease.menstrualCycle}</td>
				<th>月经持续时间(d)：</th>
				<td style="text-align: left">${womanDisease.menstrualDuration}</td>
			</tr>
			<tr>
				<th>末次月经日期：</th>
				<td style="text-align: left">
					<fmt:formatDate value="${womanDisease.lastMenstrualDate}" pattern="yyyy/MM/dd" />
				</td>
				<th>绝经年龄(岁)：</th>
				<td style="text-align: left">${womanDisease.menopauseAge}</td>
			</tr>
			<tr>
				<th>孕次：</th>
				<td style="text-align: left">${womanDisease.gravidityTimes}</td>
				<th>产次：</th>
				<td style="text-align: left">${womanDisease.productionTimes}</td>
			</tr>
			<tr>
				<th>自然流产次数：</th>
				<td style="text-align: left">${womanDisease.spontaneousAbortionTimes}</td>
				<th>人工流产次数：</th>
				<td style="text-align: left">${womanDisease.artificialAbortionTimes}</td>
			</tr>
			<tr>
				<th>阴道助产次数：</th>
				<td style="text-align: left">${womanDisease.vaginaDeliveryTimes}</td>
				<th>剖宫产次数：</th>
				<td style="text-align: left">${womanDisease.cesareanSectionTimes}</td>
			</tr>
			<tr>
				<th>末次分娩日期：</th>
				<td style="text-align: left">${womanDisease.lastDeliveryDate}</td>
				<th>宫颈检查结果：</th>
				<td style="text-align: left">${womanDisease.cervixCheckResult}</td>
			</tr>
			<tr>
				<th>阴道检查结果：</th>
				<td style="text-align: left">${womanDisease.vaginaCheckResult}</td>
				<th>外阴检查结果：</th>
				<td style="text-align: left">${womanDisease.vulvaCheckResult}</td>
			</tr>
			<tr>
				<th>子宫检查结果：</th>
				<td style="text-align: left">${womanDisease.uterusCheckResult}</td>
				<th>乳腺X线检查结果：</th>
				<td style="text-align: left">${womanDisease.breastXCheckResult}</td>
			</tr>
			<tr>
				<th>乳腺B超检查结果：</th>
				<td style="text-align: left">${womanDisease.breastBCheckResult}</td>
				<th>阴道镜检查结果：</th>
				<td style="text-align: left">${womanDisease.colposcopyCheckResult}</td>
			</tr>
			<tr>
				<th>阴道分泌物性状描述：</th>
				<td style="text-align: left">${womanDisease.vaginaSecretionsDesc}</td>
				<th>淋球菌检查结果：</th>
				<td style="text-align: left">${womanDisease.nGonorrhoeaeCheckResult}</td>
			</tr>
			<tr>
				<th>妇科及乳腺不适症状：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0401001" code="${womanDisease.gBdiscomfortCode}"/>
				</td>
				<th>月经出血量类别：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="FS10028" code="${womanDisease.menstrualBleedingType}"/>
				</td>
			</tr>
			<tr>
				<th>末次妊娠终止方式：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0210002" code="${womanDisease.lastPregnancyWay}"/>
				</td>
				<th>末次分娩方式：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0210003" code="${womanDisease.lastDeliveryWay}"/>
				</td>
			</tr>
			<tr>
				<th>避孕方式：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0600211" code="${womanDisease.contraceptiveWay}"/>
				</td>
				<th>左侧附件检查结果：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0410001" code="${womanDisease.lAttachmentCheckResult}"/>
				</td>
			</tr>
			<tr>
				<th>右侧附件检查结果：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0410001" code="${womanDisease.rAttachmentCheckResult}"/>
				</td>
				<th>左侧乳腺检查结果：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0410012" code="${womanDisease.lBreastCheckResult}"/>
				</td>
			</tr>
			<tr>
				<th>右侧乳腺检查结果：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0410012" code="${womanDisease.rBreastCheckResult}"/>
				</td>
				<th>滴虫检测结果：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="FS10045" code="${womanDisease.trichomoDetectResult}"/>
				</td>
			</tr>
			<tr>
				<th>念珠菌检测结果：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="FS10044" code="${womanDisease.candidaDetectResult}"/>
				</td>
				<th>阴道分泌物清洁度：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="CV0450010" code="${womanDisease.vaginaSecretionsCleanliness}"/>
				</td>
			</tr>
			<tr>
				<th>梅毒血清学试验结果：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="FS10058" code="${womanDisease.syphilisSerologyCheckResult}"/>
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
				<th>检查(测)机构名称：</th>
				<td style="text-align: left">${womanDisease.checkOrganName}</td>
				<th>检查(测)日期：</th>
				<td style="text-align: left">
					<fmt:formatDate value="${womanDisease.checkDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>检查(测)人员姓名：</th>
					<td style="text-align: left">${womanDisease.checkName}</td>
				<th>填报机构名称：</th>
				<td style="text-align: left">${womanDisease.createOrganName}</td>
			</tr>
		</table>
	</fieldset>
</div>