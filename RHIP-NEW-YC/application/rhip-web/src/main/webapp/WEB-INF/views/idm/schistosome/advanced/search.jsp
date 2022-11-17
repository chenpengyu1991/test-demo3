<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXXC" value="<%=RoleType.JKXXC.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/advancedSearch.js" type="text/javascript"></script>
<div>
	<div id="advanced_top_all">
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="advancedSearchForm">				
                <table id="advancedSearch" >
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
                            	<tag:idcardInput name="idcard" id="idCard1" cssClass="x-layui-input"></tag:idcardInput>&nbsp;
                                <input type="button" id="check-submit-btn2" value="读卡" style="width: 40px;">
                            </td>
                            <td class="coltext">常住类型</td>
                            <td class="colinput">
                                <ehr:dic-radio name="floatPopulation" dicmeta="FS10005" value="" isDefault="Y"/>
                            </td>
                            <td class="coltext">管理状态</td>
                            <td class="colinput">
                                <ehr:dic-list id="advancedStatus" name="advancedStatus" dicmeta="IDM00325" cssClass="x-layui-input"/>
                            </td>
						</tr>
						<tr>
                            <td class="coltext">姓名</td>
                            <td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                            <td class="coltext">是否死亡</td>
                            <td class="colinput"><ehr:dic-radio name="caseType" dicmeta="PH00001" code="1,2" value="" isDefault="Y" /></td>
                            <td class="coltext">档案状态</td>
                            <td class="colinput">
                                <ehr:dic-radio name="logoff" dicmeta="PH00031" value="" isDefault="Y"/>
                            </td>

						</tr>
						<tr class="advanceSearchSection" style="display: none;">
                            <td class="coltext">性别</td>
                            <td class="colinput">
                                <ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" value="" isDefault="Y" />
                            </td>
                            <ehr:authorize ifAnyGranted="${JKXXC},${ADMIN}">
                                <td class="coltext">管理单位</td>
                                <td class="colinput">
                                    <tag:autoSelect name="currentUnit" id="currentUnit" ></tag:autoSelect>
                                </td>
                            </ehr:authorize>
                            <ehr:authorize ifNotGranted="${JKXXC},${ADMIN}">
                                <td colspan="2"></td>
                            </ehr:authorize>
                            <td></td>
                            <td>
                            </td>
						</tr>
                        <tr>
                            <td colspan="6" class="righttd">
                                <%-- <input type="button" id="advancedBtnSearch" value="查询" onclick="" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="advancedBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                                <%-- <input type="button" id="advancedBtnExport" value="导出" onclick="" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="advancedBtnExport"><i class="layui-icon">&#xe67d;</i>导出</button>
                                <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn2" ><i class="iconfont">&#x60010;</i>高级</button>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="5" class="colbottom">
	                          <span onclick="schIndex.toggle(this,'advancedSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="advancedResultDiv"></div>
	</div>
	<div id="advanceddetailDiv" ></div>
</div>

