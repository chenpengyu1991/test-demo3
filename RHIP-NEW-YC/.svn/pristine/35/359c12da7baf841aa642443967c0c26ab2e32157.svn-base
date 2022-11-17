<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<tr>
	<th width="150px">资格证书编码</th>
	<td>${staff.qualCert}</td>
</tr>
<tr>
	<th width="150px">执业证书编码</th>
	<td>${staff.pracCert}</td>
</tr>
<tr>
	<th width="150px">执业级别</th>
	<td>${staff.practiceLevel}</td>
</tr>
<tr>
	<th width="150px">执业类别</th>
	<td>
        <ehr:dic dicmeta="FS990008" code="${staff.practiceType}"/>
    </td>
</tr>
<tr>
	<th width="150px">执业科目</th>
	<td>${staff.practiceSubject}</td>
</tr>
<tr>
	<th width="150px">批准日期</th>
	<td><fmt:formatDate value="${staff.approvalDate}"
	                    pattern="yyyy/MM/dd"/></td>
</tr>
