<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="SQZX" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="SJYYFBK" value="<%=RoleType.DDCRBYY.getValue()%>"/>
<c:set var="FYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="MBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXWJ" value="<%=RoleType.ZXWJ.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/mdm/userOperationLog/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
    <div class="searchbox searchSection x-admin-sm">
    	<input type="hidden" id="pageIndex" value="${pageIndex}">
        <form id="reportSearchForm">
            <table id="reportSearchTable">
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 23%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 23%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 23%;"/>
                </colgroup>
                <tr>
                    <td class="coltext">报卡机构</td>
                    <td class="colinput">
                        <ehr:authorize ifAnyGranted="${ZXWJ},${SQZX}">
                                <ehr:dic-org-list id="createOrganCode"  name="createOrganCode" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${SJYYFBK},${ADMIN},${FYK},${MBK}">
                            <ehr:org-type-list id="createOrganCode" name="createOrganCode" type="hospital,centre" value="${createOrganCode}" code="${createOrganCode}" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>
                    <td class="coltext">报卡状态</td>
                    <td class="colinput" >
						<ehr:authorize ifAnyGranted="${ADMIN},${SQZX},${SJYYFBK},${ZXWJ}">
							<ehr:dic-list id="type" name="type" dicmeta="PH00028" onchange="userOperationLogSearch.changeType()" cssClass="x-layui-input"/>	
	                        <br/>
	                        <div id="statusDiv" style="visibility: hidden; padding-top: 5px;">
	                            <span id="idmStatus" style="display: none; ">
	                                <ehr:dic-list name="idmStatus" dicmeta="IDM00336" uninclude="3,9" value="1" cssClass="x-layui-input"/><%--需求变更默认为未上报,2014-03-12--%>
	                            </span>
	                            <span id="dmdStatus" style="display: none;">
	                                <ehr:dic-list name="dmdStatus" dicmeta="DMD00064" uninclude="9" value="" cssClass="x-layui-input"/>
	                            </span>
	                        </div>											
						</ehr:authorize>                    
						<ehr:authorize ifAnyGranted="${FYK}">
	                        <ehr:dic-list name="idmStatus" dicmeta="IDM00336" uninclude="3,9" value="1" cssClass="x-layui-input"/><%--需求变更默认为未上报,2014-03-12--%>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${MBK}">
	                        <ehr:dic-list name="dmdStatus" dicmeta="DMD00064" uninclude="9" value="" cssClass="x-layui-input"/>
						</ehr:authorize>
                    </td>
                    <td class="coltext">上报时间</td>
                    <td class="colinput">
                        <%-- <tag:dateInput nullToToday="true" id="createDateBegin" name="createDateBegin"
                                       pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;"></tag:dateInput>
                        ~
                        <tag:dateInput nullToToday="true" id="createDateEnd" name="createDateEnd" pattern="yyyy/MM/dd"
                                       onlypast="true" style="width: 36%;"></tag:dateInput> --%>
                    
                    <input type="text" class="layui-input x-admin-sm-date"  name="createDateBegin" id="createDateBegin" style="padding-left: 0px;width:36%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="createDateEnd" id="createDateEnd" style="padding-left: 0px;width:36%;" />
                    </td>
                </tr>
                <tr>
                    <td class="coltext">报卡医生</td>
                    <td class="colinput">
                        <input type="text" id="reportDoctorName" name="reportDoctorName" value="${reportDoctorName}" class="x-layui-input"/>
                    </td>
                    <td  class="coltext">是否删除</td>
                    <td  class="colinput">
                    	<ehr:dic-radio name="deleteFlag" dicmeta="PH00001" code="1,2" value="" isDefault="Y"/>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">身份证号</td>
                    <td class="colinput">
                        <input type="text" id="idcard" name="idcard" value="${idcard}" class="x-layui-input"/>
                    </td>
                    <td  class="coltext">姓名</td>
                    <td  class="colinput">
                        <input type="text" id="name" name="name" value="${name}" class="x-layui-input"/>
                    </td>
                    <td></td>
                    <td>
                        <!-- <input type="button" value="查询" class="search_btn" id="searchReportRecordId"/> -->
                        <button class="layui-btn layui-btn-sm" id="searchReportRecordId"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td class="colbottom">
                    	<span onclick="userOperationLogSearch.toggle(this,'reportSearchTable')" class="ico-bottom">&nbsp;</span>
                   	</td>
                </tr>
            </table>
        </form>
    </div>
    <div id="reportRecordList"></div>
</div>
<div id="reportRecordListDiv"></div>


<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#createDateBegin' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#createDateEnd' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
  });
</script>
