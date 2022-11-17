<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<table>
	<colgroup>
	    <col style="min-width:80px; width: 10%;"/>
	    <col style="min-width:160px; width: 20%;"/>
	    <col style="min-width:80px; width: 10%;"/>
	    <col style="min-width:90px; width: 10%;"/>
	    <col style="min-width:70px; width: 10%;"/>
	    <col style="min-width:70px; width: 10%;"/>
	    <col style="min-width:70px; width: 10%;"/>
	    <col style="min-width:70px; width: 10%;"/>
	</colgroup>	
	<thead>
	<tr>
		<th>机构编码</th>
		<th>机构名称</th>
		<th>机构类别</th>
		<th>经营性质</th>
		<th>机构级别</th>
		<th>法人代表</th>
		<th>单位电话</th>
		<th>操作</th>
	</tr>
	</thead>
	<c:forEach items="${organList}" var="organ" varStatus="status">
		<tr>
			<td><ehr:tip>${organ.organ_Code}</ehr:tip></td>
			<td><ehr:tip>${organ.organ_Name}</ehr:tip></td>
			<td><ehr:tip><ehr:dic dicmeta="GBT2182002" code="${organ.genre_Code}" /></ehr:tip> </td>
			<td><ehr:tip><ehr:dic dicmeta="FS10223" code="${organ.manage_Code}" /></ehr:tip> </td>
			<td><ehr:dic dicmeta="DM02-02" code="${organ.grade_Code}" /></td>
			<td><ehr:tip>${organ.artificial_Person}</ehr:tip></td>
			<td><ehr:tip>${organ.tel}</ehr:tip></td>
			<td>
				<c:choose>
					<c:when test="${organ.hospitalFlag}">已添加</c:when>
					<c:otherwise>
					<a href="#this" id="addOrg${organ.organ_Code}" data-recordId="${organ.organ_Code}">选择</a>
					</c:otherwise>
				</c:choose>
			</td>	
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:paging/>
	</tr>
</table>
</div>