<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="SQZ" value="<%=RoleType.Z_GLY.getValue()%>"/>
<c:set var="JFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="JFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/drugUse/drugUseSearch.js" type="text/javascript"></script>
<div>
	<div class="section" id="drugUse_top_all">
	<div class="toolbar">
		<div class="x-nav">
	      <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">精神障碍患者管理</a>
	        <a href="javascript:void(0)">免费发药管理</a>
	        <a>
	          <cite>免费发药查询</cite></a>
	      </span>
    </div>
	</div>
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="drugUseSearchForm">				
                <table id="drugUseSearch" >
				<colgroup>
                    <col style="min-width:80px; width: 13%;"/>
                    <col style="min-width:150px; width: 20%;"/>
                    <col style="min-width:80px; width: 13%;"/>
                    <col style="min-width:150px; width: 20%;"/>
                    <col style="min-width:100px; width: 13%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                </colgroup>
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                            <td class="coltext">身份证号码</td>
                            <td class="colinput">
								<tag:idcardInput name="idcard" cssClass="x-layui-input"></tag:idcardInput>
                            </td>
                            <ehr:authorize ifAnyGranted="${JFZX}">
                                <td class="coltext">发药机构</td>
                                <td class="colinput">
                                    <ehr:dic-town-centre-station centreName="fillOrganCenter" stationName="fillOrganStation" townName="fillOrganTown" width="180px;" cssClass="x-layui-input"/>
                                </td>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${JFYS},${SQZ}">
                                <td class="coltext">发药机构</td>
                                <td class="colinput">
                                    <ehr:dic-org-list  name="fillOrganStation"  value="${fillOrganStation}" width="180px;" cssClass="x-layui-input"></ehr:dic-org-list>
                                </td>
                            </ehr:authorize>
						</tr>
						<tr>
                            <td class="coltext">药品名称</td>
                            <td class="colinput">
                                <input type="text" name="drugName" class="x-layui-input"/>
                            </td>
                            <td class="coltext">发药时间</td>
                            <td class="colinput">
                               <%--  <tag:dateInput nullToToday="true" name="regBeginDate" onlypast="true" style="width:36%;"/>
                                	至<tag:dateInput nullToToday="true" name="regEndDate" onlypast="true" style="width:36%;"/> --%>
                                	
                                	<input type="text" class="layui-input x-admin-sm-date"  name="regBeginDate" id="regBeginDateId" style="padding-left: 0px;width:36%;" /> 至
                                <input type="text" class="layui-input x-admin-sm-date"  name="regEndDate" id="regEndDateId" style="padding-left: 0px;width:36%;" />
                            </td>
                            <td></td>
                            <td>
                                <!-- <input type="button" value="查询" id="drugUseBtnSearch"  class="search_btn"/> -->
                                <button class="layui-btn layui-btn-sm" id="drugUseBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="mhmCommon.toggle(this,'drugUseSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="drugUseResultDiv"></div>
	</div>
	<div id="drugUseDetailDiv" ></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#regBeginDateId' 
        	  ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#regEndDateId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
      
      });

    </script>