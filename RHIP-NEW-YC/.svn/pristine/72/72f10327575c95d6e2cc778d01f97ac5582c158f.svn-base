<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<fieldset class="layui-elem-field">
	<legend>
		<span>检查信息</span>
	</legend>
	<table class="fieldset_table">
		<tr>
			<th>身高</th>
			<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="personHeightId" point="point" name="physiqueExamination.height"
					value="${physiqueExamination.height}" cssClass="width30"
				/>cm</td>
			<th>体重</th>
			<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="personWeightId" point="point" name="physiqueExamination.bodyWeight"
					value="${physiqueExamination.bodyWeight}" cssClass="width30"
				/>kg</td>
		</tr>
		<tr>
			<th>体质指数（BMI）</th>
			<td><input reg="{'min':0,'max':999.99}" id="personBMIId" name="physiqueExamination.indexOfBodyCharacteristics"
				value="${physiqueExamination.indexOfBodyCharacteristics}" readonly="readonly" style="width: 40px;"
			/>kg/㎡</td>
			<th>空腹血糖*</th>
			<td><tag:numberInput point="point" reg="{'min':0,'max':999.9}" name="physiqueExamination.fpgMmol"
					value="${physiqueExamination.fpgMmol}" cssClass="width50"
				/>mmol/L</td>
		</tr>
		<tr>
			<th>血压(左侧/右侧)</th>
			<td > <tag:numberInput name="physiqueExamination.leftSbp"
					value="${physiqueExamination.leftSbp}" cssClass="width30" reg="{'min':0,'max':9999}"
				/>~<tag:numberInput name="physiqueExamination.leftDbp" value="${physiqueExamination.leftDbp}"
					cssClass="width30" reg="{'min':0,'max':9999}"
				/> / <tag:numberInput name="physiqueExamination.rightSbp" value="${physiqueExamination.rightSbp}"
					cssClass="width30" reg="{'min':0,'max':9999}"
				/>~<tag:numberInput name="physiqueExamination.rightDbp" value="${physiqueExamination.rightDbp}"
					cssClass="width30" reg="{'min':0,'max':9999}"
				/>mmHg
			</td>
			
			<th>糖化血红蛋白*</th>
    <td >
        <tag:numberInput  point="point" reg="{'min':0,'max':999.9}"  name="physiqueExamination.hgb" value="${physiqueExamination.hgb}" cssClass="width50" />%
    </td>
		</tr>
		<tr>
			<th>总胆固醇</th>
			<td><tag:numberInput point="point" reg="{'min':0,'max':999.99}" name="physiqueExamination.tc"
					value="${physiqueExamination.tc}" cssClass="width50"
				/>mmol/L</td>
			<th>甘油三酯</th>
			<td><tag:numberInput point="point" reg="{'min':0,'max':99.9}" name="physiqueExamination.triglycerideValue"
					value="${physiqueExamination.triglycerideValue}" cssClass="width50"
				/>mmol/L</td>
		</tr>
		<tr>
			<th>低密度脂蛋白胆固醇</th>
			<td><tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="physiqueExamination.ldlcDetectValue"
					value="${physiqueExamination.ldlcDetectValue}" cssClass="width50"
				/>mmol/L</td>
			<th>高密度脂蛋白胆固醇</th>
			<td><tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="physiqueExamination.hdlcDetectValue"
					value="${physiqueExamination.hdlcDetectValue}" cssClass="width50"
				/>mmol/L</td>
		</tr>
		<tr>
			<th>眼部疾病</th>
			<td></td>
			<th>神经系统疾病</th>
			<td></td>
		</tr>
		<tr>
			<th>尿微量蛋白</th>
			<td></td>
			<th>糖尿病足</th>
			<td></td>
		</tr>
		<tr>
			<th>其它疾病</th>
			<td colspan="3"><label>病名</label><input><label>确诊时间</label> <tag:dateInput name="" /></td>
		</tr>
		<tr>
			<th>手术</th>
			<td colspan="3"><label>病名</label><input><label>确诊时间</label> <tag:dateInput name="" /></td>
		</tr>
		<tr>
			<th>外伤</th>
			<td colspan="3"><label>病名</label><input><label>确诊时间</label> <tag:dateInput name="" /></td>
		</tr>
		<tr>
			<th>输血</th>
			<td colspan="3"><label>病名</label><input><label>确诊时间</label> <tag:dateInput name="" /></td>
		</tr>
		<tr>
			<th>家族史</th>
			<td colspan="3"></td>
		</tr>
		<tr>
			<th>吸烟</th>
			<td colspan="3"><ehr:dic-radio name="smodeStatusCode" dicmeta="CV0300101" value="${smodeStatusCode}" /></td>
		</tr>
		<tr>
			<th>饮酒</th>
			<td colspan="3"><ehr:dic-radio name="drinkFrequency" value="${drinkFrequency }" dicmeta="FS10208" /></td>
		</tr>
		<tr>
			<th>体育锻炼</th>
			<td colspan="3"><ehr:dic-radio name="trainFrequencyTypeCode" dicmeta="FS10208" value="${trainFrequencyTypeCode}" /></td>
		</tr>
		
	</table>
</fieldset>