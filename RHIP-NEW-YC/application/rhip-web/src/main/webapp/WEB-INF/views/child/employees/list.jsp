<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table>
        <colgroup>
        <col style="min-width:20px;"/>
            <col style="min-width:150px;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 7%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 12%;"/>
        </colgroup>

        <%--新生儿随访--%>
        <thead>
        <tr><th></th>
            <th>姓名</th>
            <th>身份证</th>
            <th>性别</th>
            <th>体检日期</th>
            <th>主检医师姓名</th>
             <th>创建机构</th>
            <th>创建日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employees" items="${employeesList}" varStatus="status">
            <tr>
            	<td class="centertd">
            	<input type="checkbox" name="checked" value="${employees.id}"/>
            	</td>
                <td class="centertd"><ehr:ehrBrwLink personId="${employees.personId}" >${employees.name}</ehr:ehrBrwLink></td>
                 <td class="centertd"><ehr:ehrBrwLink personId="${employees.personId}" >${employees.idcard}</ehr:ehrBrwLink></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${employees.genders}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
               
                <td class="centertd"><ehr:tip><fmt:formatDate value="${employees.physicalExaminationDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                 
                <td class="centertd">${employees.inspectResultDoctor}
                <%-- <ehr:staff-name staffCode="${employees.inspectResultDoctor}"/> --%>
                </td>
                
                 <td class="centertd">
                 <c:choose>
                 <c:when test="${employees.createOrganCode eq '640104000000'}">
                 		兴庆区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employees.createOrganCode eq '640105000000'}">
                 		西夏区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employees.createOrganCode eq '640106000000'}">
                 		金凤区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employees.createOrganCode eq '640104000000'}">
                 		永宁县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employees.createOrganCode eq '640104000000'}">
                 		贺兰县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employees.createOrganCode eq '640104000000'}">
                 		灵武市卫生管理中心
                 
                 </c:when>
                 <c:otherwise>
                  <ehr:tip><ehr:org code="${employees.createOrganCode}"/></ehr:tip>
                 </c:otherwise></c:choose>
               </td> 
                 <td class="centertd"><fmt:formatDate value="${employees.createTime}" pattern="yyyy/MM/dd"/></td>
                <td class="centertd">
                    <a href="javascript:void(0)" onclick="employeesSearch.viewNeonatalVisit(${employees.id})"
                       class="person-link-btn">查看</a>
                        <ehr:authorize ifAnyGranted="04"> 
                        <%--<c:if test="${currentLoginInfo.organization.organCode eq employees.createOrganCode}">--%>
                     <a href="javascript:void(0)" onclick="employeesSearch.editViewNeonatalVisit(${employees.id})"
                       class="person-link-btn">修改</a>
                       
                      <%-- </c:if> --%>
                       
                      </ehr:authorize>
                          
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<div id="list_datagrid" 	class="repeattable">
	</div>
    <table>
        <tr>
            <ehr:pagination action="employeesSearch.search"/>
        </tr>
    </table>
</div>