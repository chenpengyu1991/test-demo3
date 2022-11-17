<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>业务信息</legend>
		<table class="posttable">
			<colgroup>
				<col style="width: 15%;" />
				<col style="width: 35%;" />
				<col style="width: 15%;" />
				<col style="width: 35%;" />
			</colgroup>
			<tr>
				<th><label for="healthProfessional">卫生专业 </label></th>
				<td><ehr:dic-list dicmeta="HSA00006"  parentCode="0" name="healthProfessional" value="${businessInfo.healthProfessional}"
						reg="{'maxlength':2}"
					/></td>
				<th><label for="mainBusinessName"> 主营行业分类名称 </label></th>
				<td><input type="text" id="mainBusinessName" name="mainBusinessName" value="${businessInfo.mainBusinessName}" reg="{'maxlength':500}"></input></td>
			</tr>
			<tr>
				<th><label for="secondaryBusinessName">兼营行业分类名称</label></th>
				<td><input type="text" id="secondaryBusinessName" name="secondaryBusinessName" value="${businessInfo.secondaryBusinessName}"
					reg="{'maxlength':500}"
				></input>
				<th><label for="businessItem">经营项目</label></th>
				<td><input type="text" id="businessItem" name="businessItem" value="${businessInfo.businessItem}" reg="{'maxlength':500}"></input></td>
			</tr>
			<c:if test="${businessInfo.noFileId != 2}">
				<tr>
					<th><label for="license">许可证号</label></th>
					<td><input type="text" id="license" name="license" value="${businessInfo.license}" reg="{'maxlength':30}"></input></td>
					<th><label for="licenseStateCode">许可状态</label></th>
					<td><ehr:dic-list dicmeta="HSA00008" id="licenseStateCode" name="licenseStateCode" value="${businessInfo.licenseStateCode}" /></td>
				</tr>
				<tr>
					<th><label for="releaseDate">发证日期</label></th>
					<td><input type="text" id="releaseDate" name="releaseDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${businessInfo.releaseDate}"/>'
						reg="{}"
					></input></td>
					<th><label for="dueDate">到期日期</label></th>
					<td><input type="text" id="dueDate" name="dueDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${businessInfo.dueDate}"/>' reg="{}"></input></td>
				</tr>
			</c:if>
			<tr>
				<th><label for="businessTypeCode">业务类型</label></th>
				<td><ehr:dic-list dicmeta="HSA00007" id="businessTypeCode" name="businessTypeCode" value="${businessInfo.businessTypeCode}" /></td>
			</tr>
			
		</table>
	</fieldset>
</div>
