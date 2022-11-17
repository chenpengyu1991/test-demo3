<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/sr/search.js"/>
<div class="section">
    <div  id="top_all">
        <div class="toolbar">
            <div style="position: relative">
                <a href="javascript:void(0)"><b class="xinz" id="addBtn">新增</b></a>
            </div>
        </div>
        <div class="searchbox">
            <form id="searchForm">
                <table id="searchTable">
                    <colgroup>
                        <col style="width: 10%;" />
                        <col style="width: 18%;" />
                        <col style="width: 10%;" />
                        <col style="width: 23%;" />
                        <col style="width: 8%;" />
                        <col />
                        <col style="width: 12%;" />
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">年份</td>
                        <td class="colinput">
                            <tag:dateInput name="year" pattern="yyyy"></tag:dateInput>
                        </td>
                        <td class="coltext">所属单位</td>
                        <td class="colinput" colspan="3">
                            <%--<ehr:org-type-list name="belongOrg" type="hospital,centre,other" value="${currentOrgCode}"  codeOther="46714114-9"/>--%>
                            <ehr:dic-town-centre-station isShow="true" centreName="village" townName="town" isShowOther="true"  isShowInfirmary="true"
                                                         isShowHealthOversight="true"  townId="sTown" centreId="sCenter" width="180px"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">姓名</td>
                        <td class="colinput">
                            <input type="text" name="name">
                        </td>
                        <td class="coltext">身份证号</td>
                        <td class="colinput">
                            <input type="text" name="idCard" reg='{"idCard":true}'>
                        </td>
                        <td class="coltext">职称</td>
                        <td class="colinput">
                            <select name="technical" style="width: 80px;">
                                <option value="">请选择</option>
                                <option value="1">初级</option>
                                <option value="2">中级</option>
                                <option value="3">高级</option>
                            </select>
                        </td>
                        <td><input type="button" id="searchBtn" value="查询" class="search_btn"/></td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td class="colbottom">
                            <span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
                        </td>
                        <input type="hidden" id="pageIndex">
                    </tr>
                </table>
            </form>
        </div>
        <div id="listDiv"></div>
    </div>
    <div id="detailDiv"></div>
</div>