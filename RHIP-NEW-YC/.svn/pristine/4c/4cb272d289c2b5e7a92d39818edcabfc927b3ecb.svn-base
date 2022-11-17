<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="repeattable" >
		<table class="layui-table x-admin-sm-table-list-small">
			<thead>
				<tr>
					<th>日期</th>
					<th>标题</th>
					<th>样本</th>
				
					<th>机构</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${examineEvents}" var="examineEvent">
					<tr>
						<td><fmt:formatDate value="${examineEvent.checkDate}" pattern="yyyy/MM/dd" /></td>
						<td><a  title="检验报告单" class="exam_report_btn" href="<c:url value="/exam/report/${examineEvent.id}"  />" id="${examineEvent.id}"><tags:textWithTip linkStyle="true" value="${examineEvent.checkListTitle eq null||examineEvent.checkListTitle eq '' ? '...' : examineEvent.checkListTitle}"></tags:textWithTip></a></td>
						<td><tags:textWithTip value="${examineEvent.sampleTypeName}"></tags:textWithTip></td>
						<td><tags:textWithTip value="${examineEvent.hospitalName}"></tags:textWithTip></td>
					</tr>
				</c:forEach>
            </tbody>
            <tr>
                	<ehr:pagination action="examSearch.search" colspan="4"/>
              </tr>
        </table>
    </div>
