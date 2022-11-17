<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/hm/verify/search.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
        <ehr:authorize ifAnyGranted="${ADMIN},${ZXLNR},${ZLNR}"><!-- 站、中心 -->
			<a href="javascript:void(0)" id="btnReflash"><b class="gengxin" id="btnReflashLabel">更新名单</b></a>
            <a href="javascript:void(0)" id="btnConfirmAll"><b class="tongguo">一键核实</b></a>
            <a href="javascript:void(0)" id="btnConfirm"><b class="tongguo">核实确认</b></a>
			<a href="javascript:void(0)" id="btnCancelConfirm"><b class="quxiao">取消核实</b></a>
        </ehr:authorize>
        <ehr:authorize ifNotGranted="${ADMIN}">
            <a href="javascript:void(0)" id="btnDownExcel"><b class="shangb">导出已核实名单</b></a>
        </ehr:authorize>
    </div>    
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 140px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 140px;"/>
					<col style="width: 10%; min-width: 70px;"/>
					<col style="width: 20%; min-width: 140px;"/>
                    <col style="width: 10%"/>
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">社&nbsp;&nbsp;&nbsp;&nbsp;区</td>
						<td class="colinput">
							<ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
								<ehr:dic-org-list name="inputOrganCode" width="150px"/>
							</ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ADMIN}">
                                <input type="hidden" id="selectCodeType" name="selectCodeType"/>
                                <tag:autoSelect name="organCode" id="organCode" style="width:170px" ></tag:autoSelect>
                            </ehr:authorize>
						</td>
						<td class="coltext">年&nbsp;&nbsp;&nbsp;&nbsp;龄</td>
						<td class="colinput">
							<input type="text" id="beginAge" name="beginAge" style="width:65px;" reg='{"digits":"true"}' />
							&nbsp;~&nbsp;
							<input type="text" id="endAge" name="endAge" style="width:65px;" reg='{"digits":"true"}' />
						</td>
						<td class="coltext">是否核实</td>
						<td class="colinput">
							<select name="confirm" style="width:150px;" >
								<option value="">请选择</option>
								<option value="0" selected>否</option>
								<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="coltext">姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
						<td class="colinput"><input type="text" name="name" style="width:150px;"/></td>
						<td class="coltext">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td class="colinput"><ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2" width="150px" /></td>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput name="idcard" style="width:150px" /></td>
					</tr>
					<tr>
						<td class="coltext">是否注销</td>
						<td class="colinput">
							<select name="logoff" >
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
						<td colspan="2"></td>
                        <td colspan="2" class="centertd">
							<input type="button" id="btnSearch" value="查询"  class="search_btn"/>
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
	<div id="verifyListDiv"></div>
	<div id="excelDownDiv"></div>
</div>