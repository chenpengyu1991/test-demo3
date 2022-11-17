<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<fieldset class="layui-elem-field">
	<legend>最近一次体检</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%; min-width: 100px;" />
			<col style="width: 20%; min-width: 150px;" />
			<col style="width: 20%; min-width: 150px;" />
			<col style="width: 35%; min-width: 200px;" />
		</colgroup>
		<tr>
			<th>身高</th>
			<td><input style="width: 45px" type="text" readonly="readonly" value="${physiqueExamination.height}"/>cm</td>
			<th>体重</th>
			<td><input style="width: 45px" type="text" readonly="readonly" value="${physiqueExamination.bodyWeight}"/>kg</td>
		</tr>
		<tr>
			<th>体质指数（BMI）</th>
			<td><input style="width: 45px"  type="text" readonly="readonly" value="${physiqueExamination.indexOfBodyCharacteristics}"/>kg/㎡</td>
			<th>血压</th>
			<td>左 <input style="width: 40px" type="text" readonly="readonly" value="${physiqueExamination.leftSbp}"/>/ 
			<input style="width: 40px" type="text" readonly="readonly" value="${physiqueExamination.leftDbp}"/>mmHg 右
				<input style="width: 40px" type="text" readonly="readonly" value="${physiqueExamination.rightSbp}"/>/ 
				<input  style="width: 40px" type="text" readonly="readonly" value="${physiqueExamination.rightDbp}"/>mmHg</td>
		</tr>
		<tr>
			<th>空腹血糖</th>
			<td><input style="width: 45px"  type="text" readonly="readonly" value="${physiqueExamination.fpgMmol}"/>mmol/L</td>
			<th>糖化血红蛋白</th>
			<td><input style="width: 45px"  type="text" readonly="readonly" value="${physiqueExamination.hgb}"/>%</td>
		</tr>
		<tr>
			<th>总胆固醇</th>
			<td><input style="width: 45px" type="text" readonly="readonly" value="${physiqueExamination.tc}"/>mmol/L</td>
			<th>甘油三酯</th>
			<td><input style="width: 45px"  type="text" readonly="readonly" value="${physiqueExamination.triglycerideValue}"/>mmol/L</td>
		</tr>
		<tr>
			<th>神经系统疾病</th>
			<td>${physiqueExamination.nervousDiseasesFlag eq"0" ?"未发现 ":""}
				${physiqueExamination.nervousDiseasesFlag eq"1" ?"<b>有</b> ":""} ${physiqueExamination.nervousDiseasesDesc}
			</td>

			<th>尿微量白蛋白</th>
			<td><input style="width: 45px" type="text" readonly="readonly" value="${physiqueExamination.urineMicroTongAlbumin}"/>mg/dL</td>
		</tr>
		<tr>
			<th>眼部疾病</th>
			<td>${physiqueExamination.eyeDiseasesFlag eq"0" ?"未发现":""} ${physiqueExamination.eyeDiseasesFlag eq"1"
				?"<b>已发现</b>":""} <c:if test="${physiqueExamination.eyeDiseasesFlag eq '1'}">
					<span id="ttb13"> ${physiqueExamination.eyeRetinalOozing eq '1' ? '视网膜出血或者渗出 ':''}
						${physiqueExamination.eyeOpticPapilla eq '1' ? '视乳头水肿 ':''} ${physiqueExamination.eyeCataract eq '1' ?
						'白内障 ':''} ${physiqueExamination.eyeOther eq '1' ? '其它 ':''} ${physiqueExamination.eyeOtherDesc} </span>
				</c:if>
			</td>
		</tr>
		
	</table>
</fieldset>
