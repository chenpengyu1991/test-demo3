<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/role/manageMenu.js" type="text/javascript"></script>
<div class="postcontent">
    <form id="manageMenuForm">
        <div class="postdiv">
            <input type="hidden" id="menuId" name="id" value="${menu.id}"/>
            <input type="hidden" id="parentId" name="parentId" value="${menu.parentCode}"/>
            <input type="hidden" id="depth" name="depth" value="${menu.depth}"/>
            <input type="hidden" id="status" name="status" value="${menu.status}"/>
            <input type="hidden" id="flag" name="flag" value="${menu.flag}"/>
            <table id="addMenuTable"  class="formtable">
                <colgroup>
                    <col style="width:20%;"/>
                    <col style="width:80%;"/>
                </colgroup>
                <tr>
                    <th><label class="required">父菜单名称:</label></th>
                    <td>
                        <c:if test="${empty parentName}">无</c:if>${parentName}
                    </td>
                </tr>
                <tr>
                    <th><label class="required">包含子节点:</label></th>
                    <td>
                        <input type="radio" id="isParent1" name="isParent"  class="radioGroup" value="1" <c:if test="${menu.isParent == '1'}">checked="checked"</c:if>/><label for="isParent1">包含</label>
                        <input type="radio" id="isParent2" name="isParent"  class="radioGroup" value="0" <c:if test="${menu.isParent == '0'}">checked="checked"</c:if>/><label for="isParent2">不包含</label>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">菜单名称:</label></th>
                    <td>
                        <input type="text" name="nameZh" id="nameZh"  value ='${menu.nameZh}' reg='{"required":"true","maxlength":"300"}' style="width:220px;"/>
                    </td>
                </tr>
                <tr id="trNameZh">
                    <th><label class="required">链接地址:</label></th>
                    <td>
                        <input type="text" name="path" id="path"  value ='${menu.path}' reg='{"required":"true","maxlength":"600"}' style="width:220px;"/>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">排序:</label></th>
                    <td>
                        <input type="text" name="menuNo" id="menuNo"  value ='${menu.menuNo}' reg='{"required":"true","max":"100"}' style="width:120px;"/>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveMenu" value="添加" >
        </c:if>
        <c:if test="${type == 'modify'}">
            <input type="button" id="modifyMenu" value="修改">
        </c:if>
        <input type="button" id="cancelMenu" value="取消" >
    </div>
</div>
