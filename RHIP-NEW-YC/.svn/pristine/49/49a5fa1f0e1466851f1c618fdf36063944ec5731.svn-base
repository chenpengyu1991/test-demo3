<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/datagrid.js" type="text/javascript"></script>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>"/>
<c:set var="ZXYFJZ" value="<%=RoleType.ZXYFJZ.getValue()%>"/>
<c:set var="JKAZB" value="<%=RoleType.JKAZB.getValue()%>"/>
<c:set var="YYFJZ" value="<%=RoleType.YYFJZ.getValue()%>"/>

<!-- 医院用户登录主页面 -->
<!-- 主页面查询条件和导出功能 -->
<div id="vaccineDivIdSearch" class="section">
<div class="toolbar">
	<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">预防接种管理</a>
	        <a>
          <cite>预防接种首页</cite></a>
      	</span>
    	</div>
    
</div>
<div class="searchbox searchSection x-admin-sm">
	<form method="post" id="form_search">
		<table id="reportSearch">
			<colgroup>
				<col style="min-width:70px; width:10%;"/>
				<col style="min-width:160px; width: 23%;"/>
				<col style="min-width:70px; width:10%;"/>
				<col style="min-width:160px; width: 23%;"/>
				<col style="min-width:60px; width: 10%;"/>
				<col style="min-width:160px; width: 23%;"/>
			</colgroup>
			<tbody>	
				<tr>
				
					<td class="coltext">身份证号</td>
					<td class="colinput">
						<tag:idcardInput name="idcard" style="width:80%"></tag:idcardInput>
					</td>
					<td class="coltext">性别</td>
					<td class="colinput">
						<ehr:dic-list dicmeta="GBT226112003" name="gender" width="80%"/>
					</td>
                    <td class="coltext">登记日期</td>
                    <td class="colinput">
						<input type="text" class="layui-input x-admin-sm-date" name="vaccinationFromDate" id="createBeginDate" style="padding-left: 0px;width: 35%;" /> ~
						<input type="text" class="layui-input x-admin-sm-date" name="vaccinationToDate" id="createEndDate" style="padding-left: 0px;width: 35%;" />
					</td>
				</tr>		
				<tr>
                    <td class="coltext">患者姓名</td>
                    <td class="colinput"><input  style="width:80%" type="text" name="name" /></td>
                    <td class="coltext">疫苗类型</td>
					<td class="colinput">
						<select name="immType" style="width:80%" onchange="mainPageH.showVaccineFlag(this.value)">
							<option value="0">请选择</option>
							<option value="1">狂犬疫苗</option>
							<option value="2">乙肝疫苗</option>
							<option value="3">流感疫苗</option>
							<option value="4">23价肺炎疫苗</option>
						</select>
					</td>
                    <td class="coltext">条形码</td>
                    <td class="colinput"><input  style="width:80%" type="text" name="barcode"/></td>
                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <td class="coltext">接诊单位</td>
                    <td>
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKYFJZ},${JKAZB}">
                            <ehr:org-type-list name="createOrg" type="hospital,centre,other" value="${currentOrgCode}"/>
                        </ehr:authorize>
                        <ehr:authorize ifNotGranted="${ADMIN},${JKYFJZ},${JKAZB}">
                            <input  style="width:80%" readonly="readonly" type="text" name="createOrgshow" value="${currentLoginInfo.organization.organName}" />
                            <input  style="width:80%" type="hidden" name="createOrg" value="${currentLoginInfo.organization.organCode}" />
                        </ehr:authorize>
                    </td>
                    <td id="vaccineFlagLabel"></td>
                    <td id="vaccineFlagValue"></td>
                    <td></td>                
                   	<td class="colinput">
						<!-- <button class="layui-btn layui-btn-sm" id="vaccineRecordsSearch"><i class="layui-icon">&#xe615;</i>查询</button> -->
                    </td>
                </tr>
                
                <tr>
                    	<td class="righttd" colspan="6">
                    	<button class="layui-btn layui-btn-sm" id="vaccineRecordsSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
                    	</td>
                    </tr>
			</tbody>
		</table>
		<table>
           <tr>
             <td colspan="6" class="colbottom">
              　			 <span onclick="toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
             </td>
           </tr>
		</table>
	</form>
</div>
<div class="toolbarSection x-admin-sm">
<ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${JKAZB},${YYFJZ}">
    	<a id="vaccineRecordsAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
    </ehr:authorize>
     <ehr:authorize ifAnyGranted='${JKYFJZ},${ZXYFJZ},${JKAZB},${YYFJZ},${ADMIN}'>
         <a href="javascript:void(0)" id="btnExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
     </ehr:authorize>
</div>
<div id="recordsGrid"></div>
</div>
<div id="vaccineDivIdDetail" class="postcontent">

</div>
 <object id="CsSmkActive" classid="clsid:AE451137-38F8-4240-A9F9-6D8E182D9C16" codebase="${pageContext.request.contextPath}/activex/csSmk.cab#version=1,0,0,2" style="width:0;height:0;display:none;"></object>