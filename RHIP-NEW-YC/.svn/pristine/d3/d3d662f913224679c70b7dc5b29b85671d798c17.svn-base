<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/paramSetting/brwIdmRole/setting.js" type="text/javascript"></script>

<div class="toolbar">
    <a href="javascript:void(0)" id="confirmId" title="修改"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe642;</i>修改</button></a>
</div>
<form id="brwIdmRoleForm">
    <div class="postcontent">
        <div class="postdiv">
            <div style="font-size: 18px;">该页面的功能提供用户可以根据角色需要设置健康档案浏览器中“疾病控制”菜单是否可见。勾选的角色表示可见，未勾选则不可见。</div><br>
            <div>请设置健康档案浏览器中“疾病控制”访问权限：</div><br>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 30%"/>
                        <col style="width: 30%"/>
                        <col style="width: 30%"/>

                    </colgroup>
                    <c:forEach var="role" items="${roles}" varStatus="status">
                        <c:if test="${status.index%3==0}"><tr></c:if>
                        <td>
                            <c:choose>
                                <c:when test="${role.isCheck eq 1}">
                                    <input name="roleNames" type="checkbox" value="${role.roleCode}" checked/>${role.description}
                                </c:when>
                                <c:otherwise>
                                    <input name="roleNames" type="checkbox" value="${role.roleCode}"/>${role.description}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <c:if test="${status.count%3==0}"></tr></c:if>
                    </c:forEach>
                </table>
        </div>
    </div>
</form>
