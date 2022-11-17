<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-6-14
  Time: 上午11:03
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/portal/stop/search.js" type="text/javascript"></script>
<div class="section" id="searchDiv">
    <div class="searchbox" id="searchBox">
        <form method="post" id="form_search">
            <table id="reportSearch">
                <tbody>
                <colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:60px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                </colgroup>
                <tr>
                    <td class="coltext">医生姓名:</td>
                    <td><input type="text" name="doctorName" onkeydown="if(event.keyCode==13){return false;}"/></td>
                    <td class="coltext">状态</td>
                    <td>
                        <select name="stopingStatus" id="stoppingStatusSelect">
                            <option value="-1">请选择</option>
                            <option value="0">未停诊</option>
                            <option value="1">已停诊</option>
                        </select>
                    </td>
                    <td></td>
                    <td><input id="per_search_btn" class="search_btn" type="button" value="查询" style="float: left;" /></td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span onclick="stopSearch.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="stopDoctor_records"></div>
</div>
