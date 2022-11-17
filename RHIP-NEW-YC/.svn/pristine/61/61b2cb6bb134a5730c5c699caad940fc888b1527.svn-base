<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<fieldset>
	<legend>个人史</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%" />
			<col span="3" style="width: 28%" />
		</colgroup>
		<tr style="height: 1px;">
			<td style="height: 1px;"></td>
			<td style="height: 1px;"></td>
			<td style="height: 1px;"></td>
			<td style="height: 1px;"></td>
		</tr>
		<tr>
			<th>疾病</th>
			<td colspan="3"><ehr:tip trim="true" defaultValue="无"> 
			${personBasicInfoDto.gxy eq '201' ? ' 名称:高血压,' : ''} ${not empty personBasicInfoDto.gxyDate ? "确诊时间:":""}<fmt:formatDate
						value='${personBasicInfoDto.gxyDate}' pattern='yyyy/MM/dd'
					/> ${not empty personBasicInfoDto.gxyDate ? ";":""}
			${personBasicInfoDto.tnb eq '202' ? ' 名称:糖尿病,' : ''} ${not empty personBasicInfoDto.tnbDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.tnbDate}' pattern='yyyy/MM/dd'
					/> ${not empty personBasicInfoDto.tnbDate ? ";": ""}
			${personBasicInfoDto.gxb eq '203' ? ' 名称:冠心病,' : ''} ${not empty personBasicInfoDto.gxbDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.gxbDate}' pattern='yyyy/MM/dd'
					/>  ${not empty personBasicInfoDto.gxbDate ? ";": ""}
			${personBasicInfoDto.fjb eq '204' ? ' 名称:慢性阻塞性肺疾病,' : ''}  ${not empty personBasicInfoDto.fjbDate ? "确诊时间:": ""} <fmt:formatDate
						value='${personBasicInfoDto.fjbDate}' pattern='yyyy/MM/dd'
					/> ${not empty personBasicInfoDto.fjbDate ? ";": ""}
		 ${personBasicInfoDto.exzl eq '205' ? '名称:恶性肿瘤,' : ''}   ${not empty personBasicInfoDto.exzlDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.exzlDate}' pattern='yyyy/MM/dd'
					/> ${not empty personBasicInfoDto.exzlDate ? ";": ""}
		 ${personBasicInfoDto.nzz eq '206' ? ' 名称:脑卒中,' : ''} ${not empty personBasicInfoDto.nzzDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.nzzDate}' pattern='yyyy/MM/dd'
					/>  ${not empty personBasicInfoDto.nzzDate ? ";": ""}
		${personBasicInfoDto.zxjsb eq '207' ? ' 名称:重性精神障碍,' : ''} ${not empty personBasicInfoDto.zxjsbDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.zxjsbDate}' pattern='yyyy/MM/dd'
					/> ${not empty personBasicInfoDto.zxjsbDate ? ";": ""}
	 ${personBasicInfoDto.jhb eq '208' ? ' 名称:结核病,' : ''} ${not empty personBasicInfoDto.jhbDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.jhbDate}' pattern='yyyy/MM/dd'
					/>  ${not empty personBasicInfoDto.jhbDate ? ";": ""}
		${personBasicInfoDto.gy eq '209' ? ' 名称:肝炎,' : ''} ${not empty personBasicInfoDto.gyDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.gyDate}' pattern='yyyy/MM/dd'
					/> ${not empty personBasicInfoDto.gyDate ? ";": ""}
	 ${personBasicInfoDto.xtjx eq '210' ? ' 名称:先天畸形,' : ''} ${not empty personBasicInfoDto.xtjxDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.xtjxDate}' pattern='yyyy/MM/dd'
					/>  ${not empty personBasicInfoDto.xtjxDate ? ";": ""}
	${personBasicInfoDto.qt eq '211' ? ' 其它,' : ''} ${personBasicInfoDto.qtxx} ${not empty personBasicInfoDto.qtDate ? "确诊时间:": ""}<fmt:formatDate
						value='${personBasicInfoDto.qtDate}' pattern='yyyy/MM/dd'
					/> ${not empty personBasicInfoDto.qtDate ? ";": ""}
				</ehr:tip></td>
		</tr>
		<tr>
			<th>手术</th>
			<td colspan="3"><ehr:tip trim="true" defaultValue="无">
					<c:forEach items="${personBasicInfoDto.surgeryHistoryList}" var="surgeryHistoryOne">
						<c:if test="${not empty surgeryHistoryOne.opsName }">
                	名称: ${surgeryHistoryOne.opsName},
                	时间: <fmt:formatDate value='${surgeryHistoryOne.opsDate}' pattern='yyyy/MM/dd' />;
						 
					</c:if>
					</c:forEach>
				</ehr:tip></td>
		</tr>
		<tr>
			<th>外伤</th>
			<td colspan="3"><ehr:tip trim="true" defaultValue="无">
					<c:forEach items="${personBasicInfoDto.traumaHistoryList}" var="traumaHistoryOne">
						<c:if test="${not empty traumaHistoryOne.opsName }">
                	名称: ${traumaHistoryOne.opsName},
               	 	时间: <fmt:formatDate value='${traumaHistoryOne.opsDate}' pattern='yyyy/MM/dd' />;
						 
					</c:if>
					</c:forEach>
				</ehr:tip></td>
		</tr>
		<tr>
			<th>输血</th>
			<td colspan="3"><ehr:tip trim="true" defaultValue="无">
					<c:forEach items="${personBasicInfoDto.transBloodHistoryList}" var="transBloodHistoryOne">
						<c:if test="${not empty transBloodHistoryOne.bloodReason }">
	               	 原因: ${transBloodHistoryOne.bloodReason},
	               	 时间: <fmt:formatDate value='${transBloodHistoryOne.bloodDate}' pattern='yyyy/MM/dd' />;
						 
					</c:if>
					</c:forEach>
				</ehr:tip></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>药物过敏史</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%" />
			<col style="width: 35%" />
			<col style="width: 15%" />
			<col style="width: 35%" />
		</colgroup>
		<tr style="height: 1px;">
			<td style="height: 1px;"></td>
			<td style="height: 1px;"></td>
			<td style="height: 1px;"></td>
			<td style="height: 1px;"></td>
		</tr>
		<tr>
			<th>药物过敏史</th>
			<td colspan="3"><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="CV0501038" code="${personBasicInfoDto.drugAllergyHistoryStr}" />
				</ehr:tip></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>家族史</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%" />
			<col style="width: 35%" />
			<col style="width: 15%" />
			<col style="width: 35%" />
		</colgroup>
		<tr>
			<th>父亲</th>
			<td valign="top"><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.fatherStr}" />
				</ehr:tip></td>
			<th>母亲</th>
			<td valign="top"><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.motherStr}" />
				</ehr:tip></td>
		</tr>
		<tr>
			<th>兄妹</th>
			<td valign="top"><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.brotherStr}" />
				</ehr:tip></td>
			<th>子女</th>
			<td valign="top"><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.childStr}" />
				</ehr:tip></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>生活情况</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%" />
			<col style="width: 35%" />
			<col style="width: 15%" />
			<col style="width: 35%" />
		</colgroup>
		<tr>
			<th>体育锻炼</th>
			<td><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="FS10208" code="${physiqueExamination.trainFrequencyTypeCode}" />
				</ehr:tip></td>
			<th>吸烟情况</th>
			<td><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="CV0300101" code="${physiqueExamination.smodeStatusCode}" />
				</ehr:tip></td>
		</tr>
		<tr>
			<th>饮酒情况</th>
			<td colspan="3"><ehr:tip trim="true" defaultValue="无">
					<ehr:dic dicmeta="FS10208" code="${physiqueExamination.drinkFrequency}" />
				</ehr:tip></td>
		</tr>
	</table>
</fieldset>
