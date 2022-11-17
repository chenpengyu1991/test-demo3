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

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/transfertreat.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<div>
	<div id="top_allTransfertreat">
		
		<div class="toolbar">
		   <label>待追踪患者:<a href="javascript:void(0)" onclick="transfertreat.loadSearchPage();">${notSeeDoctorCount}</a></label>
    	</div>
		<div class="searchbox searchSection x-admin-sm">
			<form id="transfertreatSearchForm">				
                <table id="transfertreatSearch" >
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 23%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 23%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:183px; width: 23%;"/>
					</colgroup>	
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idcard"  id="idcard" cssClass="x-layui-input"/>
								<input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
							</td>
							<td class="coltext">性别</td>
							<td class="colinput"><ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2" cssClass="x-layui-input" /></td>
						</tr>
						<tr>
							<td class="coltext">状态</td>
							<td class="colinput">
								<select name="specialStatus" class="x-layui-input">
									<option value="">请选择</option>
									<option value="${TRANSFERTREAT}">已转诊</option>
									<option value="${REGISTER}">未转诊</option>
								</select>
							</td>
							<td class="coltext">常住类型</td>
							<td class="colinput"><ehr:dic-list dicmeta="FS10005" name="floatPopulation" cssClass="x-layui-input"/></td>
							<td></td>
							<td>
								<%-- <input type="button" id="transfertreatBtnSearch" value="查询" class="search_btn"/> --%>
								<button class="layui-btn layui-btn-sm" id="transfertreatBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'transfertreatSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div class="toolbarSection">
			<%-- <a href="javascript:void(0)" onclick="tbCommon.add('',${TRANSFERTREAT},'1','Transfertreat')"><b class="xinz">新建</b></a> --%>
			<a href="javascript:void(0)" onclick="tbCommon.add('',${TRANSFERTREAT},'1','Transfertreat')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新建</button></a>
			<%-- <a href="javascript:void(0)" onclick="tbCommon.downLoad()"><b class="export">导出</b></a> --%>
			<a href="javascript:void(0)" onclick="tbCommon.downLoad()"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		</div>
		<div id="listDivTransfertreat"></div>
	</div>
	<div id="detailDivTransfertreat"></div>
	<div id="traceDiv"></div>
</div>