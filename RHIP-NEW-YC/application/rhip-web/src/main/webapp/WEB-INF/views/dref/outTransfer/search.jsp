<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<c:set var="HGZX" value="<%=RoleType.HGZX.getValue()%>"/>
<c:set var="YWK" value="<%=RoleType.SJYYYWK.getValue()%>"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/dref/outTransfer/search.js"/>
<script src="${pageContext.request.contextPath}/js/views/dref/outTransfer/edit.js" type="text/javascript"></script>
<div class="section" id="searchDiv">
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 7%;" />
					<col style="width: 18%;" />
					<col style="width: 7%;" />
					<col style="width: 30%;"/>
					<col style="width: 7%;" />
					<col />
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext">姓名</td>
					<td class="colinput"><input type="text" name="name" style="width: 150px"/></td>
					<td class="coltext">身份证号</td>
					<td class="colinput"><input type="text" name="idCard"></td>
                    <ehr:authorize ifAnyGranted="${HGZX}">
                        <td class="coltext">机构名称</td>
                        <td class="colinput">
                            <%--<input type="text" name="fromOrganCode">--%>
                            <select name="fromOrganCode">
                                <option value="">请选择</option>
                                <option value="46714063-X">常熟市第一人民医院</option>
                                <option value="46714062-1">常熟市第二人民医院</option>
                                <option value="46714062-11">常熟市第二人民医院城中分院</option>
                                <option value="320002991">常熟市第二人民医院传染病分院</option>
                                <option value="46714062-12">常熟市第二人民医院琴枫分院</option>
                                <option value="46714117-3">常熟市第三人民医院</option>
                                <option value="46714077-9">常熟市第五人民医院(老)</option>
                                <option value="46714077-91">常熟市第五人民医院(新)</option>
                                <option value="46714078-7">常熟市中医院（常市新区医院）</option>
                                <option value="46714078-71">常熟市中医院（新区医院）外菱塘分院</option>
                            </select>
                        </td>
                    </ehr:authorize>
                    <ehr:authorize ifAnyGranted="${YWK}">
                        <td class="coltext">机构名称</td>
                        <td class="colinput">
                                <%--<input type="text" name="fromOrganCode">--%>
                            <select name="fromOrganCode">
                                <option value="">请选择</option>
                            </select>
                        </td>
                    </ehr:authorize>
				</tr>
				<tr>
					<td class="coltext">病人类型</td>
					<td class="colinput"><ehr:dic-list name="patientType" dicmeta="CV0710003"/></td>
					<td class="coltext">审核状态</td>
					<td class="colinput">
                        <ehr:dic-radio name="status1" dicmeta="OT00003" onchange="toggleOther('status1','status2','2')"></ehr:dic-radio>
                        <span id="status2" style="display: none"><ehr:dic-list name="status2" dicmeta="OT00004" width="120px;"></ehr:dic-list></span>
                    </td>
                    <td class="coltext">转诊日期</td>
                    <td class="colinput">
                        <tag:dateInput nullToToday="true" id="transferDateBegin" name="transferDateBegin" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
                        ~<tag:dateInput nullToToday="true" id="transferDateEnd" name="transferDateEnd" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"
                                        reg='{"compare":["transferDateBegin","ge","结束时间不能早于开始时间"]}'></tag:dateInput>
                    </td>
					<%--<td></td>--%>
					<%--<td>--%>
                        <%--<input type="button" id="searchBtn" value="查询" class="search_btn"/>--%>
                        <%--<input type="button" id="otExportBtn" value="导出" class="search_btn"/>--%>
                    <%--</td>--%>
				</tr>
                <tr>
                    <td colspan="4"></td>
                    <td colspan="2">
                    <input type="button" id="searchBtn" value="查询" class="search_btn"/>
                    <input type="button" id="otExportBtn" value="导出" class="search_btn"/>
                    </td>
                </tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="colbottom">
						<span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="listDiv"></div>
</div>
<div id="detailDiv"></div>