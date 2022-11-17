<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/houseHoldList.js" type="text/javascript"></script>
<div class="repeattable">
    <form method="post" action="">
        <table id="person_record_table">
            <colgroup>
                <col style="width: 33%"/>
                <col style="width: 33%"/>
                <col style="width: 33%"/>
            </colgroup>
            <thead>
            <tr>
                <th>居委会名称</th>
                <th>小区名称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody class="tbody">
            <c:forEach items="${houseHoldList}" var="houseHold">
                <tr>
                    <td class="villageName">
                            ${houseHold.parentName}
                    </td>
                    <td class="itemcode" name="itemcode">
                            ${houseHold.itemName}
                    </td>
                    <td class="caoZuo">
                        <a href="javascript:void(0)"
                           onclick="houseHoldPagination.houseModify(${houseHold.itemCode})">修改</a>
                        <a href="javascript:void(0)"
                           onclick="houseHoldPagination.houseDelete(${houseHold.itemCode})">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
    <ehr:paging/>
</div><input type="hidden" id="indexPage" value="${indexPage}"/></div>


