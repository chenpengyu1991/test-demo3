<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="REGISTER" value="<%=TbStatus.REGISTER.getValue()%>" />
<c:set var="TRANSFERTREAT" value="<%=TbStatus.TRANSFERTREAT.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/transfertreat.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<div class="section">
	<div id="top_allTrace">
		<div class="toolbar">
		<a href="javascript:tbCommon.returnSearch('transfertreat.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
    	</div>    
		<div class="searchbox">
			<form id="traceSearchForm">				
                <table id="traceSearch" >
					<colgroup>
						<col style="width: 80px;" />
						<col style="width: 150px;" />
						<col style="width: 80px;" />
						<col style="width: 150px;" />
						<col style="width: 80px;" />
						<col style="width: 100px;" />
						<col style="width: 80px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name"/></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idcard"/></td>
							<td class="coltext">到位状态</td>
							<td class="colinput"><ehr:dic-list name="placeStatus" dicmeta="IDM00255" code="4,5"/> </td>
							<td class="coltext" align="left">
								<button class="layui-btn layui-btn-sm" id="traceBtnSearch"><i class="layui-icon"></i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'traceSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="listDivTrace"></div>
	</div>
	<div id="detailDivTrace"></div>
</div>