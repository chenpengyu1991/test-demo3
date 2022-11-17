<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/immuneTarget/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/immuneTarget/vaccineCommon.js" type="text/javascript"></script>

<div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">免疫规划</a>
		        <a>
                    <cite>
                        <c:if test="${queryPath eq '/ihm/vaccine/vaccinelist'}">
                            儿童接种信息查询
                        </c:if>
                        <c:if test="${queryPath eq '/ihm/vaccine/taboolist'}">
                            儿童禁忌症查询
                        </c:if>
                        <c:if test="${queryPath eq '/ihm/vaccine/sideEffectlist'}">
                            儿童副反应查询
                        </c:if>
                    </cite>
                </a>
		      </span>
    </div>
</div>
<div class="section">
    <div class="searchBox searchSection x-admin-sm">
		<input type="hidden" id="vaccinePageIndex" value="${pageIndex}">
		<input type="hidden" id="queryPath" value="${queryPath}">
		<form id="vaccineSearchForm">
			<table id="vaccineSearch">
				<colgroup>
                	<col style="width: 10%; min-width: 50px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
					<col style="width: 10%; min-width: 50px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
                    <col style="width: 10%; min-width: 50px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
                    <col/>
				</colgroup>
				<tbody>
					<tr>
					    <td class="col-text">姓名</td>
                        <td class="col-input">
                            <input type="text" name="name" style="width: 180px;"/>
                        </td>
                        <td class="col-text">父亲姓名</td>
                        <td class="col-input">
                            <input type="text" name="fatherName" style="width: 180px;"/>
                        </td>
                        <td class="col-text">母亲姓名</td>
                        <td class="col-input">
                            <input type="text" name="motherName" style="width: 180px;"/>
                        </td>
                    </tr>
					<tr>  
						<td class="col-text">身份证号</td>
                        <td class="col-input">
                            <input type="text" name="idcard" style="width: 180px;" />
                        </td>
                        <td class="col-text">父亲身份证号</td>
                        <td class="col-input">
                            <input type="text" name="fatherIdcard" style="width: 180px;"/>
                        </td>
                        <td class="col-text">母亲身份证号</td>
                        <td class="col-input">
                            <input type="text" name="motherIdcard" style="width: 180px;"/>
                        </td>
                     </tr>
                    <tr class="advanceSearchSection" style="display: none;">
                        <td class="col-text">受接种者编号</td>
                        <td class="col-input">
                            <input type="text" name="vaccinationCode" style="width: 180px;"/>
                        </td>
                        <td colspan="4"></td>
					</tr>
                    <tr>
                        <td colspan="7" class="righttd">
                            <button class="layui-btn layui-btn-sm"  id="vaccineBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            <button class="layui-btn layui-btn-sm" id="perAdvanceSearchVaccineBtn"><i class="iconfont">&#x60010;</i>高级</button>
                        </td>
                    </tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span
						onclick="toggle(this,'vaccineSearch')"
						class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>

		</form>
	</div>
	<div id="vaccineDiv">
		<jsp:include page="${listpage}"></jsp:include>
	</div>
</div>