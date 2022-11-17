<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table id="result_table" class="layui-table x-admin-sm-table-list-small">
		<thead>
			<tr>
				<th style="width: 45px;" rowspan="2">修改时间</th>
				<th style="width: 60px;" rowspan="2">修改人</th>
				<th style="width: 110px;" rowspan="2">修改机构</th>
				<th style="width: 60px;" rowspan="2">业务类型</th>
				<th style="width: 60px;" rowspan="2">项目</th>
				<th colspan="2" style="width: 150px;">内容</th>
			</tr>
			<tr>
				<th class="zimu">原值</th>
				<th class="zimu">新值</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${pageList}" var="fi">
				<tr>
					<td style="text-align: center" title=<fmt:formatDate value="${fi.inputDate}" pattern="yyyy/MM/dd" />>
                        <fmt:formatDate value="${fi.inputDate}" pattern="yyyy/MM/dd" />
                    </td>
					<td title="${fi.inputName}">${fi.inputName}</td>
					<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap">
                        <tags:textWithTip value="${fi.inputOrg}"/>
                    </td>
					<td>${fi.regionName}</td>
					<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap" title="${fi.itemName}">
					    ${fi.itemName}
                    </td>
					<c:if test="${fi.itemCode != null }">
						<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap">
							<c:if test="${fi.oldValue==null||fi.oldValue==''||fi.oldValue eq '未填'}">
								<tags:textWithTip value="未填"/>
							</c:if>
                            <div style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap" title=<ehr:dic dicmeta="${fi.itemCode}" code="${fi.oldValue}" />>
								<c:if test="${fi.oldValue!=null}">
									<ehr:dic dicmeta="${fi.itemCode}" code="${fi.oldValue}" />
								</c:if>
							</div>
						</td>
						<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap" title=<ehr:dic dicmeta="${fi.itemCode}" code="${fi.newValue}"></ehr:dic>>
							<ehr:dic dicmeta="${fi.itemCode}" code="${fi.newValue}"></ehr:dic>
						</td>
					</c:if>
					<c:if test="${fi.itemCode == null }">
						<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap">
							<c:if test="${fi.oldValue==null||fi.oldValue==''}">
								<tags:textWithTip value="未填"/>
							</c:if>
							<c:if test="${fi.oldValue!=null}">
								<ehr:tipWoldWrap titleLength="20" ><c:out value="${fi.oldValue}"/></ehr:tipWoldWrap>
							</c:if>
						</td>
						<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap">
							<ehr:tipWoldWrap titleLength="20" ><c:out value="${fi.newValue}"/></ehr:tipWoldWrap>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
		<ehr:pagination action="modifyTracePagination.pagination" colspan="7" />
	</table>
</div>