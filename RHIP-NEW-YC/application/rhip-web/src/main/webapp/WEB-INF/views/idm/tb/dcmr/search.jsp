<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="TRANSFERTREAT" value="<%=TbStatus.TRANSFERTREAT.getValue()%>" />
<c:set var="DCMR" value="<%=TbStatus.DCMR.getValue()%>" />
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/dcmr.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<div>
	<div id="top_allDcmr">
		<ehr:authorize ifAnyGranted="${JKJHB},${DDCRBYY}">
			<div class="toolbar">
	          <%-- <a href="javascript:void(0)" onclick="tbCommon.add('',${DCMR},'1','Dcmr')"><b class="xinz">新建</b></a> --%>
	          <a href="javascript:void(0)" onclick="tbCommon.add('',${DCMR},'1','Dcmr')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新建</button></a>
	          <input type="hidden" id="idmIdTemp"/>
	    	</div>
	    </ehr:authorize>  
		<div class="searchbox searchSection x-admin-sm">
			<form id="dcmrSearchForm">				
                <table id="dcmrSearch" >
					<colgroup>
						<col style="min-width:70px; width: 8%;"/>
						<col style="min-width:100px; width: 17%;"/>
						<col style="min-width:70px; width: 8%;"/>
						<col style="min-width:100px; width: 17%;"/>
						<col style="min-width:70px; width: 8%;"/>
						<col style="min-width:100px; width: 17%;"/>
						<col style="min-width:90px; width: 8%;"/>
						<col style="min-width:90px; width: 17%;"/>
					</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input" /></td>
							<td class="coltext">身份证号</td>					
							<td class="colinput"><tag:idcardInput name="idcard"  id="idcard2" cssClass="x-layui-input"/>
								<input type="button" id="check-submit-btn2" value="读卡" style="width: 40px;">
							</td>
							<td class="coltext">性别</td>
							<td class="colinput"><ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2"/></td>
							<td class="coltext">档案状态</td>
                            <td class="colinput">
                                <ehr:dic-list id="logoff" name="logoff" dicmeta="PH00031" cssClass="x-layui-input"/>
                            </td>
						</tr>
						<tr>
							<td class="coltext">常住类型</td>
							<td class="colinput"><ehr:dic-list dicmeta="FS10005" name="floatPopulation" cssClass="x-layui-input"/> </td>
							<td class="coltext">治疗分类</td>
							<td class="colinput"><ehr:dic-list name="thisType" dicmeta="IDM00215"/></td>	
							<td class="coltext">状态</td>
							<td class="colinput">
								<select name="specialStatus" cssClass="x-layui-input">
									<option value="">请选择</option>
									<option value="${DCMR}">已建专用病历</option>
									<option value="${TRANSFERTREAT}">未建专用病历</option>
								</select>
							</td>
                            <td class="centertd" colspan="2">
                                <%-- <input type="button" id="dcmrBtnSearch" value="查询" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="dcmrBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'dcmrSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="listDivDcmr"></div>
	</div>
	<div id="detailDivDcmr"></div>
</div>

