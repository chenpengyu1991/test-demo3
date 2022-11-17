<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.SchStatus" %>
<c:set var="REGISTER_DOCTOR" value="<%=SchStatus.REGISTER_DOCTOR.getValue()%>" />
<c:set var="REGISTER_SQZX" value="<%=SchStatus.REGISTER_SQZX.getValue()%>" />
<c:set var="REGISTER_JKTJZX" value="<%=SchStatus.REGISTER_JKTJZX.getValue()%>" />
<c:set var="REGISTER_WSYJYK" value="<%=SchStatus.REGISTER_WSYJYK.getValue()%>" />
<c:set var="FBK_VERIFY"  value="<%=SchStatus.FBK_VERIFY.getValue()%>" />
<c:set var="JK_VERIFY"  value="<%=SchStatus.JK_VERIFY.getValue()%>" />
<c:set var="WRITE"  value="<%=SchStatus.WRITE.getValue()%>" />
<c:set var="ELIMINATION"  value="<%=SchStatus.ELIMINATION.getValue()%>" />
<c:set var="WRITE"  value="<%=SchStatus.WRITE.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="width:200px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:200px;"/>						
		</colgroup>	
		<thead>
			<tr>
				<th>机构名称</th>
				<th>操作人姓名</th>
				<th>审批时间</th>
				<th>状态</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="approval" items="${ApprovalInfo.list}" varStatus="status">
				<tr>
					<td>
						<ehr:org code="${approval.unitCode}"/>

					</td>
					<td><ehr:tip>${approval.userName}</ehr:tip></td>
					<td><ehr:tip><fmt:formatDate value="${approval.approvalDate}" pattern="yyyy/MM/dd HH:mm" /></ehr:tip></td>
					<td>
						<c:choose>
                             <c:when test="${approval.status == REGISTER_DOCTOR}">
								<label class="loadclass">防保科审核</label>
                            </c:when> 
                             <c:when test="${approval.status == REGISTER_SQZX}">
								<label class="loadclass">疾控审核</label>
                            </c:when>  
                             <c:when test="${approval.status == REGISTER_JKTJZX}">
								<label class="loadclass">疾控审核</label>
                            </c:when> 
                             <c:when test="${approval.status == REGISTER_WSYJYK}">
								<label class="loadclass">疾控审核</label>
                            </c:when>                             
                             <c:when test="${approval.status == FBK_VERIFY}">
								<label class="loadclass">疾控审核</label>
                            </c:when> 
                             <c:when test="${approval.status == JK_VERIFY}">
								<label class="loadclass">通过</label>
                            </c:when>
                             <c:when test="${approval.status == ELIMINATION}">
								<label class="loadclass">排除</label>
                            </c:when>  
                             <c:when test="${approval.status == WRITE}">
								<label class="loadclass">个案已填写</label>
                            </c:when>                                                       
                        </c:choose>							
					</td>
					<td><ehr:tip>${approval.comments}</ehr:tip></td>
				</tr>
			</c:forEach>
			<tr>
			 <ehr:pagination action="schlog.searchLog" colspan="5"/>
			</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="schlog.searchLog"/>
		</tr>
	</table> --%>
</div>