<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/caseSearch.js" type="text/javascript"></script>
<div>
	<div id="case_top_all">
	<%--<div class="toolbar">--%>
       	<%--<a href="javascript:void(0)" onclick='javascript:schCasesSearch.addCase("new")'><b class="xinz">新增个案</b></a>--%>
    <%--</div>   	--%>
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="caseSearchForm">				
                <table id="caseSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 26%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:183px; width: 23%;"/>
				</colgroup>		
					<tbody>
						<tr>
                            <td class="coltext">身份证号</td>
                            <td class="colinput">
                            	<tag:idcardInput name="idcard" id="idCardcase" cssClass="x-layui-input"></tag:idcardInput>&nbsp;
                                <input type="button" id="check-submit-btn1" value="读卡" style="width: 40px;">
                            </td>
                            <td class="coltext">性别</td>
                            <td class="colinput">
                                <ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" value="" isDefault="Y"/>
                            </td>
                            <td class="coltext">管理状态</td>
                            <td class="colinput">
                                <ehr:dic-list id="caseStatus" name="caseStatus" dicmeta="IDM00233" />
                            </td>

						</tr>
						<tr>
                            <td class="coltext">姓名</td>
                            <td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
							<td class="coltext">常住类型</td>
                            <td class="colinput">
                                <ehr:dic-radio name="floatPopulation" dicmeta="FS10005" value="" isDefault="Y"/>
                            </td>
                            <td class="coltext">档案状态</td>
                            <td class="colinput">
                                <ehr:dic-radio name="logoff" dicmeta="PH00031" value="" isDefault="Y"/>
                            </td>
                        </tr>
						<tr>
                            <td colspan="5"></td>
                            <td>
                                <%-- <input type="button" id="caseBtnSearch" value="查询" onclick="" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="caseBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                                <%-- <input type="button" id="caseBtnExport" value="导出" onclick="" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="caseBtnExport"><i class="layui-icon">&#xe67d;</i>导出</button>
                            </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="5" class="colbottom">
	                          <span onclick="schIndex.toggle(this,'caseSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="caseResultDiv"></div>
	</div>
	<div id="casedetailDiv" ></div>
</div>

