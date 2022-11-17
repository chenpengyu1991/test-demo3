<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/search.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	
	// 高级查询条件显示控制
	 $("#perAdvanceSearchConditionBtn").click(function(e) {
           e.preventDefault();
           controlAdvanceSearchSection($(this));
       });
});
</script>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="JFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="ZJSB" value="<%=RoleType.ZJSB.getValue()%>"/>
	<div class="section" id="management_top_all">
	<div class="toolbar">
	 	<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">精神障碍患者管理</a>
	        <a>
          <cite>规范化管理</cite></a>
      	</span>
    	</div>
	  </div>
	<%-- <div class="toolbar">
		<ehr:authorize ifAnyGranted="${JKJFZX},${JFYS},${ZJSB}">
            <a href="javascript:void(0)" id="outButtonDiv" onclick="managementSearch.intoManagement()">
            <button class="layui-btn layui-btn-xs button"><i class="layui-icon"></i>新建</button>
            </a>
        </ehr:authorize>
	</div> --%>
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="managementSearchForm">				
                <table id="managementSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:90px; width: 14%;"/>
                    <col style="min-width:140px; width: 25%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                            <td class="coltext">身份证号</td>
                            <td class="colinput"><input type="text" name="idcard" class="x-layui-input"/></td>
                            <td class="coltext">管理所在镇</td>
                            <td class="colinput">
                                <%--<ehr:dic-town-village  townName="managementTown" townValue="${townValue}"/>--%>
                                <c:choose>
                                    <c:when test='${ROLE==JKJFZX}'>
                                        <ehr:dic-town-village  townName="managementTown" cssClass="x-layui-input"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select  title="<ehr:dic dicmeta="FS990001" code="${townValue}"/>" name="managementTown" class="x-layui-input">
                                            <option title="<ehr:dic dicmeta="FS990001" code="${townValue}"/>" value="${townValue}"><ehr:dic dicmeta="FS990001" code="${townValue}"/></option>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
						</tr>
						<tr>
                            <td class="coltext">病人类型</td>
                            <td class="colinput">
                                <ehr:dic-list name="patientType" dicmeta="MH00003" code="1,2" cssClass="x-layui-input"/>
                            </td>
                            <td class="coltext">管理方式</td>
                            <td class="colinput">
                                <ehr:dic-list name="mgntType" dicmeta="MH00006" code="1,2" cssClass="x-layui-input"/>
                            </td>
                            <td class="coltext">病人来源</td>
                            <td class="colinput">
                                <ehr:dic-list name="patientSource" dicmeta="MH00004" code="1,2,3" cssClass="x-layui-input"/>
                            </td>
						</tr>
						<tr class="advanceSearchSection" style="display: none;">
                            <td class="coltext">是否免费服药</td>
                            <td class="colinput">
                                <ehr:dic-list name="freeType" dicmeta="PH00001" code="1,2" cssClass="x-layui-input"/>
                            </td>
							<td class="coltext">存活状态</td>
							<td class="colinput">
								<ehr:dic-list name="aliveType" dicmeta="MH00005" code="1,2" cssClass="x-layui-input"/>
							</td>
                            <td class="coltext">登记时间</td>
                            <td class="colinput">
                                <%-- <tag:dateInput nullToToday="true" name="regBeginDate" onlypast="true" style="width: 36%;"/>
                                至<tag:dateInput nullToToday="true" name="regEndDate" onlypast="true"  style="width: 36%;"/> --%>
                                
                                <input type="text" class="layui-input x-admin-sm-date"  name="regBeginDate" id="regBeginDateId" style="padding-left: 0px;width: 36%;" /> 至
                                <input type="text" class="layui-input x-admin-sm-date"  name="regEndDate" id="regEndDateId" style="padding-left: 0px;width: 36%;" />
                            </td>
						</tr>
						<tr class="advanceSearchSection" style="display: none;">
                            <td class="coltext">疾病类型</td>
                            <%--<td><ehr:dic-list name="diseaseType" dicmeta="MH00052"></ehr:dic-list></td>--%>
                            <td>
                                <input type="text" id="mhmIcd10Code" name="diseaseType" cssClass="x-layui-input"/>
                            </td>
                            <td colspan="2"></td>
                            <td class="coltext"></td>
                            <td class="colinput">
                                <!-- <button class="layui-btn layui-btn-sm" id="searchManagementButton"><i class="layui-icon">&#xe615;</i>查询</button> -->
                            </td>
						</tr>
						<tr>
	                    	<td class="righttd" colspan="6">
                                <button class="layui-btn layui-btn-sm" id="searchManagementButton"><i class="layui-icon">&#xe615;</i>查询</button>
                                <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
	                    	</td>
                    	</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="mhmCommon.toggle(this,'managementSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div class="toolbarSection x-admin-sm">
    	<ehr:authorize ifAnyGranted="${JKJFZX},${JFYS},${ZJSB}">
            <a href="javascript:void(0)" id="outButtonDiv" onclick="managementSearch.intoManagement()">
            <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i>新建</button>
            </a>
        </ehr:authorize>
    </div>
		
		<div id="managementResultDiv"></div>
	</div>
	<div id="managementDetailDiv" ></div>

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