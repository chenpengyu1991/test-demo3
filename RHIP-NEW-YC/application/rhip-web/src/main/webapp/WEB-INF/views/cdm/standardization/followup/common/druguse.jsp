<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
	<legend>用药情况</legend>
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 30%" />
				<col style="width: 70%" />
			</colgroup>
			<tr>
				<th><label for="bpDrugFlag">控制血压用药情况</label></th>
				<td><ehr:dic-radio  name="bpDrugFlag" dicmeta="DMD00032" value="${strtum.bpDrugFlag}"></ehr:dic-radio></td>
			</tr>
			<tr id="bpDrugFlagSpan1" style="${strtum.bpDrugFlag=='1'?'':'display:none'}">
				<th><label>规律用药品种</label></th>
				<td>
					<table>
						<colgroup>
							<col style="width: 25%" />
							<col style="width: 25%" />
							<col style="width: 25%" />
							<col style="width: 25%" />
						</colgroup>
						<tr>
							<th><label for="bpDrugNameFirst">第一种药物名称</label></th>
							<td><input type="text" id="bpDrugNameFirst" name="bpDrugNameFirst" value="${strtum.bpDrugNameFirst}" reg="{'required':true,'maxlength':50}"></input></td>
							<th><label for="bpDrugMethodFirst">第一种药物使用方法</label></th>
							<td><input type="text" id="bpDrugMethodFirst" name="bpDrugMethodFirst" value="${strtum.bpDrugMethodFirst}" reg="{'required':true,'maxlength':100}"></input></td>
						</tr>
						<tr>
							<th><label for="bpDrugNameSecond">第二种药物名称</label></th> 
							<td><input type="text" id="bpDrugNameSecond" name="bpDrugNameSecond" value="${strtum.bpDrugNameSecond}" reg="{'maxlength':50}"></input></td> 
							<th><label for="bpDrugMethodSecond">第二种药物使用方法</label></th>
							<td><input type="text" id="bpDrugMethodSecond" name="bpDrugMethodSecond" value="${strtum.bpDrugMethodSecond}" reg="{'maxlength':100}"></input></td>
						</tr>
						<tr>
							<th><label for="bpDrugNameThird">第三种药物名称</label></th>
							<td><input type="text" id="bpDrugNameThird" name="bpDrugNameThird" value="${strtum.bpDrugNameThird}" reg="{'maxlength':50}"></input></td>
							<th><label for="bpDrugMethodThird">第三种药物使用方法</label></th>
							<td><input type="text" id="bpDrugMethodThird" name="bpDrugMethodThird" value="${strtum.bpDrugMethodThird}" reg="{'maxlength':100}"></input></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr id="bpDrugFlagSpan2" style="${strtum.bpDrugFlag=='2'?'':'display:none'}" >
				<th>未规律用药原因</th>
				<td><ehr:dic-radio  dicmeta="DMD00033" name="bpDrugNoRegularReason" value="${strtum.bpDrugNoRegularReason }"></ehr:dic-radio></td>
			</tr>
		</table>
	</fieldset>
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 30%" />
				<col style="width: 70%" />
			</colgroup>
			<tr>
				<th><label for="bgDrugFlag">控制血糖用药情况</label></th>
				<td><ehr:dic-radio name="bgDrugFlag" dicmeta="DMD00032" value="${strtum.bgDrugFlag}"></ehr:dic-radio></td>
			</tr>
			<tr id="bgDrugFlagSpan1" style="${strtum.bgDrugFlag=='1'?'':'display:none'}" >
				<th><label>规律用药品种</label></th>
				<td>
					<table>
						<tr>
							<!-- <th><label for="bgDrugCodeFirst">第一种药物编码</label></th> -->
							<%-- <td><input type="text" id="bgDrugCodeFirst" name="bgDrugCodeFirst" value="${strtum.bgDrugCodeFirst}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bgDrugNameFirst">第一种药物名称</label></th>
							<td><input type="text" id="bgDrugNameFirst" name="bgDrugNameFirst" value="${strtum.bgDrugNameFirst}" reg="{'required':true,'maxlength':50}"></input></td>
							<th><label for="bgDrugMethodFirst">第一种药物使用方法</label></th>
							<td><input type="text" id="bgDrugMethodFirst" name="bgDrugMethodFirst" value="${strtum.bgDrugMethodFirst}" reg="{'required':true,'maxlength':100}"></input></td>
						</tr>
						<tr>
							<!--<th><label for="bgDrugCodeSecond">第二种药物名称</label></th>-->
							<%-- <td><input type="text" id="bgDrugCodeSecond" name="bgDrugCodeSecond" value="${strtum.bgDrugCodeSecond}" reg="{'maxlength':4}"></input></td>--%>
							<th><label for="bgDrugNameSecond">第二种药物名称</label></th> 
							<td><input type="text" id="bgDrugNameSecond" name="bgDrugNameSecond" value="${strtum.bgDrugNameSecond}" reg="{'maxlength':50}"></input></td> 
							<th><label for="bgDrugMethodSecond">第二种药物使用方法</label></th>
							<td><input type="text" id="bgDrugMethodSecond" name="bgDrugMethodSecond" value="${strtum.bgDrugMethodSecond}" reg="{'maxlength':100}"></input></td>
						</tr>
						<tr>
							<!-- <th><label for="bgDrugCodeThird">第三种药物编码</label></th> -->
							<%-- <td><input type="text" id="bgDrugCodeThird" name="bgDrugCodeThird" value="${strtum.bgDrugCodeThird}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bgDrugNameThird">第三种药物名称</label></th>
							<td><input type="text" id="bgDrugNameThird" name="bgDrugNameThird" value="${strtum.bgDrugNameThird}" reg="{'maxlength':50}"></input></td>
							<th><label for="bgDrugMethodThird">第三种药物使用方法</label></th>
							<td><input type="text" id="bgDrugMethodThird" name="bgDrugMethodThird" value="${strtum.bgDrugMethodThird}" reg="{'maxlength':100}"></input></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr id="bgDrugFlagSpan2" style="${strtum.bgDrugFlag=='2'?'':'display:none'}"  >
				<th>未规律用药原因</th>
				<td><ehr:dic-radio  dicmeta="DMD00033" name="bgDrugNoRegularReason" value="${strtum.bgDrugNoRegularReason }"></ehr:dic-radio></td>
			</tr>
		</table>
	</fieldset>
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 30%" />
				<col style="width: 70%" />
			</colgroup>
			<tr>
				<th><label for="bfDrugFlag">控制血脂用药情况</label></th>
				<td><ehr:dic-radio name="bfDrugFlag" dicmeta="DMD00032" value="${strtum.bfDrugFlag}"></ehr:dic-radio></td>
			</tr>
			<tr id="bfDrugFlagSpan1" style="${strtum.bfDrugFlag=='1'?'':'display:none'}" >
				<th><label>规律用药品种</label></th>
				<td>
					<table>
						<tr>
							<!-- <th><label for="bfDrugCodeFirst">第一种药物编码</label></th> -->
							<%-- <td><input type="text" id="bfDrugCodeFirst" name="bfDrugCodeFirst" value="${strtum.bfDrugCodeFirst}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bfDrugNameFirst">第一种药物名称</label></th>
							<td><input type="text" id="bfDrugNameFirst" name="bfDrugNameFirst" value="${strtum.bfDrugNameFirst}" reg="{'required':true,'maxlength':50}"></input></td>
							<th><label for="bfDrugMethodFirst">第一种药物使用方法</label></th>
							<td><input type="text" id="bfDrugMethodFirst" name="bfDrugMethodFirst" value="${strtum.bfDrugMethodFirst}" reg="{'required':true,'maxlength':100}"></input></td>
						</tr>
						<tr>
							<!--<th><label for="bfDrugCodeSecond">第二种药物名称</label></th>-->
							<%-- <td><input type="text" id="bfDrugCodeSecond" name="bfDrugCodeSecond" value="${strtum.bfDrugCodeSecond}" reg="{'maxlength':4}"></input></td>--%>
							<th><label for="bfDrugNameSecond">第二种药物名称</label></th> 
							<td><input type="text" id="bfDrugNameSecond" name="bfDrugNameSecond" value="${strtum.bfDrugNameSecond}" reg="{'maxlength':50}"></input></td> 
							<th><label for="bfDrugMethodSecond">第二种药物使用方法</label></th>
							<td><input type="text" id="bfDrugMethodSecond" name="bfDrugMethodSecond" value="${strtum.bfDrugMethodSecond}" reg="{'maxlength':100}"></input></td>
						</tr>
						<tr>
							<!-- <th><label for="bfDrugCodeThird">第三种药物编码</label></th> -->
							<%-- <td><input type="text" id="bfDrugCodeThird" name="bfDrugCodeThird" value="${strtum.bfDrugCodeThird}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bfDrugNameThird">第三种药物名称</label></th>
							<td><input type="text" id="bfDrugNameThird" name="bfDrugNameThird" value="${strtum.bfDrugNameThird}" reg="{'maxlength':50}"></input></td>
							<th><label for="bfDrugMethodThird">第三种药物使用方法</label></th>
							<td><input type="text" id="bfDrugMethodThird" name="bfDrugMethodThird" value="${strtum.bfDrugMethodThird}" reg="{'maxlength':100}"></input></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr id="bfDrugFlagSpan2" style="${strtum.bfDrugFlag=='2'?'':'display:none'}" >
				<th>未规律用药原因</th>
				<td><ehr:dic-radio  dicmeta="DMD00033" name="bfDrugNoRegularReason" value="${strtum.bfDrugNoRegularReason }"></ehr:dic-radio></td>
			</tr>
		</table>
	</fieldset>
</fieldset>
