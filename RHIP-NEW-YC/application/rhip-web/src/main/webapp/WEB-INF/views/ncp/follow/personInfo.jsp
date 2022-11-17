<%@ page import="com.founder.fasf.util.DateUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
	<legend style="color: black;">&nbsp;基本信息&nbsp; </legend>
	<input type="hidden" name="personInfo.id" value="${personInfo.id}">
	<input type="hidden" name="personInfo.birthday" value="<fmt:formatDate value="${personInfo.birthday}" pattern="yyyy/MM/dd" />">
	<table class="posttable">
		<colgroup>
			<col style="width: 7%; min-width: 100px;" />
			<col style="width: 10%; min-width: 200px;" />
			<col style="width: 5%; min-width: 100px;" />
		</colgroup>
		<tr>
			<td > &nbsp; &nbsp; <label>姓名：<ehr:tip>${personInfo.name}</ehr:tip></label></td>
			<td><label>身份证号：<ehr:ehrBrwLink personId="${personInfo.id}" ><ehr:tip>${personInfo.idcard}</ehr:tip></ehr:ehrBrwLink></label></td>
			<td><label>年龄：<ehr:tip> ${personInfo.age}岁</ehr:tip></label></td>
			<%--<td><label>出生日期：<ehr:tip><fmt:formatDate value="${personInfo.birthday}" pattern="yyyy/MM/dd" /></ehr:tip></label></td>--%>
		</tr>
		<tr>
			<td>
				<label>既往病史：</label>
				<c:if test="${dmDiseaseInfo.hbpFlag eq '2'}">
						<span>高血压&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.diFlag eq '2'}">
						<span>糖尿病&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.tumorFlag eq '2'}">
						<span>肿瘤&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.coronaryFlag eq '2'}">
						<span>冠心病&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.strokeFlag eq '2'}">
						<span>脑卒中</span>
					</c:if>
					<c:if test="${dmDiseaseInfo.hbpFlag ne '2' and dmDiseaseInfo.diFlag ne '2' and dmDiseaseInfo.tumorFlag ne '2' and dmDiseaseInfo.coronaryFlag ne '2' and dmDiseaseInfo.strokeFlag ne '2'}">无</c:if>
				<%-- <ehr:tip><ehr:dic dicmeta="FS990023" code="${personInfo.populationCategory}"/></ehr:tip> --%> &nbsp;
				<%--<label>性别：</label>
				<ehr:tip><ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}" /></ehr:tip>--%>
			</td>
			<td><label>现住地址：</label><ehr:tip><ehr:dic dicmeta="FS990001" code="${personInfo.patownShip }"></ehr:dic> <ehr:dic dicmeta="FS990001" code="${personInfo.pastreet }"></ehr:dic> ${personInfo.pahouseNumber }</ehr:tip></td>
			<td><label>联系电话：<ehr:tip>${personInfo.phoneNumber}</ehr:tip></label></td>
		</tr>
	</table>
</fieldset>