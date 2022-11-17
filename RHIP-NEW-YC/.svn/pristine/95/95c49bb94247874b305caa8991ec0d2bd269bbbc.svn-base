<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset>
	<legend>用药情况</legend>
	<fieldset>
		<table class="posttable">
			<colgroup>
				<col style="width: 30%" />
				<col style="width: 70%" />
			</colgroup>
			<tr>
				<th><label for="bpDrugFlag">控制血压用药情况</label></th>
				<td><ehr:dic dicmeta="DMD00032" code="${strtum.bpDrugFlag}"></ehr:dic></td>
			</tr>
			<tr>
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
							<!-- <th><label for="bpDrugCodeFirst">第一种药物编码</label></th> -->
							<%-- <td><input type="text" id="bpDrugCodeFirst" name="bpDrugCodeFirst" value="${strtum.bpDrugCodeFirst}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bpDrugNameFirst">第一种药物名称</label></th>
							<td><c:out value="${strtum.bpDrugNameFirst}" /></td>
							<th><label for="bpDrugMethodFirst">第一种药物使用方法</label></th>
							<td><c:out value="${strtum.bpDrugMethodFirst}" /></td>
						</tr>
						<tr>
							<!-- <th><label for="bpDrugCodeSecond">第二种药物名称</label></th>-->
							<%-- <td><input type="text" id="bpDrugCodeSecond" name="bpDrugCodeSecond" value="${strtum.bpDrugCodeSecond}" reg="{'maxlength':4}"></input></td>--%>
							<th><label for="bpDrugNameSecond">第二种药物编码</label></th> 
							<td><c:out value="${strtum.bpDrugNameSecond}"/></td> 
							<th><label for="bpDrugMethodSecond">第二种药物使用方法</label></th>
							<td><c:out value="${strtum.bpDrugMethodSecond}"/></td>
						</tr>
						<tr>
							<!--<th><label for="bpDrugCodeThird">第三种药物编码</label></th> -->
							<%--<td><input type="text" id="bpDrugCodeThird" name="bpDrugCodeThird" value="${strtum.bpDrugCodeThird}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bpDrugNameThird">第三种药物名称</label></th>
							<td><c:out value="${strtum.bpDrugNameThird}" /></td>
							<th><label for="bpDrugMethodThird">第三种药物使用方法</label></th>
							<td><c:out value="${strtum.bpDrugMethodThird}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>未规律用药原因</th>
				<td><ehr:dic  dicmeta="DMD00033" code="${strtum.bpDrugNoRegularReason }"></ehr:dic></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<table class="posttable">
			<colgroup>
				<col style="width: 30%" />
				<col style="width: 70%" />
			</colgroup>
			<tr>
				<th><label for="bgDrugFlag">控制血糖用药情况</label></th>
				<td><ehr:dic dicmeta="DMD00032" code="${strtum.bgDrugFlag}"></ehr:dic></td>
			</tr>
			<tr>
				<th><label>规律用药品种</label></th>
				<td>
					<table>
						<tr>
							<!-- <th><label for="bgDrugCodeFirst">第一种药物编码</label></th> -->
							<%-- <td><input type="text" id="bgDrugCodeFirst" name="bgDrugCodeFirst" value="${strtum.bgDrugCodeFirst}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bgDrugNameFirst">第一种药物名称</label></th>
							<td><c:out value="${strtum.bgDrugNameFirst}" /></td>
							<th><label for="bgDrugMethodFirst">第一种药物使用方法</label></th>
							<td><c:out value="${strtum.bgDrugMethodFirst}" /></td>
						</tr>
						<tr>
							<!--<th><label for="bgDrugCodeSecond">第二种药物名称</label></th>-->
							<%-- <td><input type="text" id="bgDrugCodeSecond" name="bgDrugCodeSecond" value="${strtum.bgDrugCodeSecond}" reg="{'maxlength':4}"></input></td>--%>
							<th><label for="bgDrugNameSecond">第二种药物名称</label></th> 
							<td><c:out value="${strtum.bgDrugNameSecond}" /></td> 
							<th><label for="bgDrugMethodSecond">第二种药物使用方法</label></th>
							<td><c:out value="${strtum.bgDrugMethodSecond}" /></td>
						</tr>
						<tr>
							<!-- <th><label for="bgDrugCodeThird">第三种药物编码</label></th> -->
							<%-- <td><input type="text" id="bgDrugCodeThird" name="bgDrugCodeThird" value="${strtum.bgDrugCodeThird}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bgDrugNameThird">第三种药物名称</label></th>
							<td><c:out value="${strtum.bgDrugNameThird}" /></td>
							<th><label for="bgDrugMethodThird">第三种药物使用方法</label></th>
							<td><c:out value="${strtum.bgDrugMethodThird}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>未规律用药原因</th>
				<td><ehr:dic  dicmeta="DMD00033" code="${strtum.bgDrugNoRegularReason }"></ehr:dic></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<table class="posttable">
			<colgroup>
				<col style="width: 30%" />
				<col style="width: 70%" />
			</colgroup>
			<tr>
				<th><label for="bfDrugFlag">控制血脂用药情况</label></th>
				<td><ehr:dic dicmeta="DMD00032" code="${strtum.bfDrugFlag}"></ehr:dic></td>
			</tr>
			<tr>
				<th><label>规律用药品种</label></th>
				<td>
					<table>
						<tr>
							<!-- <th><label for="bfDrugCodeFirst">第一种药物编码</label></th> -->
							<%-- <td><input type="text" id="bfDrugCodeFirst" name="bfDrugCodeFirst" value="${strtum.bfDrugCodeFirst}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bfDrugNameFirst">第一种药物名称</label></th>
							<td><c:out value="${strtum.bfDrugNameFirst}" /></td>
							<th><label for="bfDrugMethodFirst">第一种药物使用方法</label></th>
							<td><c:out value="${strtum.bfDrugMethodFirst}" /></td>
						</tr>
						<tr>
							<!--<th><label for="bfDrugCodeSecond">第二种药物名称</label></th>-->
							<%-- <td><input type="text" id="bfDrugCodeSecond" name="bfDrugCodeSecond" value="${strtum.bfDrugCodeSecond}" reg="{'maxlength':4}"></input></td>--%>
							<th><label for="bfDrugNameSecond">第二种药物名称</label></th> 
							<td><c:out value="${strtum.bfDrugNameSecond}" /></td> 
							<th><label for="bfDrugMethodSecond">第二种药物使用方法</label></th>
							<td><c:out value="${strtum.bfDrugMethodSecond}" /></td>
						</tr>
						<tr>
							<!-- <th><label for="bfDrugCodeThird">第三种药物编码</label></th> -->
							<%-- <td><input type="text" id="bfDrugCodeThird" name="bfDrugCodeThird" value="${strtum.bfDrugCodeThird}" reg="{'maxlength':4}"></input></td> --%>
							<th><label for="bfDrugNameThird">第三种药物名称</label></th>
							<td><c:out value="${strtum.bfDrugNameThird}" /></td>
							<th><label for="bfDrugMethodThird">第三种药物使用方法</label></th>
							<td><c:out value="${strtum.bfDrugMethodThird}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>未规律用药原因</th>
				<td><ehr:dic  dicmeta="DMD00033" code="${strtum.bfDrugNoRegularReason }"></ehr:dic></td>
			</tr>
		</table>
	</fieldset>
</fieldset>
