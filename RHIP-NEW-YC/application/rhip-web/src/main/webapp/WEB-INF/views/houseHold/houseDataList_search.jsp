<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/houseHoldList.js" type="text/javascript"></script>
<div>
    <div class="toolbar">
        <a href="javascript:void(0)" id="houseHoldAdd" onclick="houseHoldPagination.houseHoldAdd()"><b class="xinz">新增</b></a>
    </div>
    <div>
        <br/>
        <form id="houseHoldForm" method="post" action="">
            <table id="houseSearch">
                <colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 20%"/>
                    <col style="width: 20%"/>
                    <col style="width: 20%"/>
                </colgroup>
                <tbody>
                <td class="houseName" style="float: right;"><b>小区名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
                <td><input  type="text" name="houseHoldName" id="houseHoldName" style="width: 60%" style="float: right;"/></td>
                <td><input class="search_btn" type="button" name="search" id="houseHoldList" value="查询" style="float: right;"/></td>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom">
                        <span id="bloodPressureSearchSpanId" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
                <input class="hide" />
            </table>
        </form>
    </div>
</div>