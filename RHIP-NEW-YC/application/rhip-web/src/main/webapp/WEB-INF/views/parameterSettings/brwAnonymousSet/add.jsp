<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/paramSetting/brwAnonymousSet/setting.js" type="text/javascript"></script>

<div class="toolbar">
    <a href="javascript:void(0)" id="confirmId" title="修改"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe642;</i>修改</button></a>
<%--    <a href="javascript:void(0)" id="confirmId" onclick="javascript:brwAnonymousSet.confirm()"><b class="xiug">修改</b></a>--%>
    <a href="javascript:void(0);" id="saveId" style="display: none;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>确认</button></a>
<%--    <a href="javascript:void(0)" id="saveId" onclick="javascript:brwAnonymousSet.save()" style="display: none;"><b class="baocun">确认</b></a>--%>

</div>
<div id="brwAnonymousSetFormDiv">
<form id="brwAnonymousSetForm">
    <div class="postcontent">
        <div class="postdiv">
            <div style="font-size: 18px;">该页面的功能提供用户设置健康档案浏览器中基础信息是否用"${ANONYMOUS_XS}"代替，从而匿名显示的功能。勾选的角色表示匿名显示，未勾选则开放显示。</div><br>
            <div>请设置健康档案基本信息需要“匿名访问”的角色：</div><br>
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
</div>
<div id="brwAnonymousSetPwdFormDiv" style="display: none">
<form id="brwAnonymousSetPwdForm">
    <div class="postcontent">
        <div class="postdiv">
            <div>请输入管理员密码：</div>
            <table class="posttable">
                <colgroup>
                    <col style="width: 30%"/>
                    <col style="width: 60%"/>
                </colgroup>
                <tr>
                    <th>密码是：</th>
                    <td>
                        <input id="roleNamePwd" name="roleNamePwd" type="password" />
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>
</div>
