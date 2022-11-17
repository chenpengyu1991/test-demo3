<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ZJSB" value="<%=RoleType.ZJSB.getValue()%>"/>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/patient/into/into.js" type="text/javascript"></script>

<div class="section" id="top_all">
		<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">精神障碍管理</a>
		        <a>
		          <cite>患者筛查</cite></a>
		      </span>
		</div>
			
        </div>
		<div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="intoSearchForm">
                <table id="intoSearch" >
				<colgroup>
					<col style="min-width:80px; width: 10%;"/>
					<col style="min-width:120px; width: 20%;"/>
                    <col style="min-width:80px; width: 10%;"/>
					<col style="min-width:120px; width: 20%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:120px; width: 20%;"/>
                    <col style="min-width:120px; width: 10%;"/>
                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">姓名</td>
                            <td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
							<td class="coltext">身份证号</td>
							<td class="colinput">
								<tag:idcardInput name="idcard" style="width:180px;" cssClass="x-layui-input"></tag:idcardInput>
							</td>
                            <td class="coltext">出生日期</td>
                            <td class="colinput">
                                <%-- <tag:dateInput nullToToday="true" id="birthdateBeginId" name="birthdateBegin" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"/>
                                ~<tag:dateInput nullToToday="true" id="birthdateEndId" name="birthdateEnd" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"/> --%>
                                <input type="text" class="layui-input x-admin-sm-date"  name="birthdateBegin" id="birthdateBeginId" style="padding-left: 0px;width:40%;"  /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="birthdateEnd" id="birthdateEndId" style="padding-left: 0px;width:40%;" />
                            </td>
						</tr>
						<tr>
                            <td class="coltext">病人来源</td>
                            <td class="colinput">
                                <ehr:dic-list  name="patientSource" dicmeta="MH00004" code="1,2,3" value="" cssClass="x-layui-input"/>
                            </td>
                            <td class="coltext">管理状态</td>
                            <td class="colinput">
                                <ehr:dic-list  name="mgntStatus" dicmeta="MH00047" value="" cssClass="x-layui-input"/>
                            </td>
							<td class="coltext">登记日期</td>
							<td class="colinput">
								<%-- <tag:dateInput nullToToday="true" id="fillBeginDate" name="fillBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
								~<tag:dateInput nullToToday="true" id="fillEndDate" name="fillEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput> --%>
								<input type="text" class="layui-input x-admin-sm-date"  name="fillBeginDate" id="fillBeginDate" style="padding-left: 0px;width:40%;"  /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="fillEndDate" id="fillEndDate" style="padding-left: 0px;width:40%;" />
							</td>
                            <td class="centertd">
                                <!-- <input type="button" id="intoBtnSearch" value="查询" class="search_btn"/> -->
                                <button class="layui-btn layui-btn-sm" id="intoBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
						</tr>
						<ehr:authorize ifAnyGranted="${JKJFZX}">
							<tr>
	                            <td class="coltext">管理机构</td>
	                            <td class="colinput" colspan="5">
									<ehr:dic-town-centre-station centreName="belongCenter" stationName="fillOrganCode" townName="belongTownship" width="180px;" cssClass="x-layui-input" />											                                
	                            </td>						
	                        </tr>
						</ehr:authorize>
						<ehr:authorize ifAnyGranted="${ZXJFYS}">
							<tr>
	                            <td class="coltext">管理机构</td>
	                            <td class="colinput" colspan="5">
									<ehr:dic-org-list  name="fillOrganCode"  width="180px;" cssClass="x-layui-input"></ehr:dic-org-list>											                                
	                            </td>
                            </tr>						
						</ehr:authorize>							
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td class="colbottom">
	                        <span onclick="mhmCommon.toggle(this,'intoSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
	<div class="toolbarSection">
		<!-- <a href="javascript:void(0)" id="outButtonDiv" onclick="intoPatient.addPatient()"><b class="fanhui">新建</b></a> -->
		<!-- <a href="javascript:void(0)" id="outButtonDiv" onclick="intoPatient.into()"><b class="xinz">新建</b></a> -->
		<a href="javascript:void(0)" id="outButtonDiv" onclick="intoPatient.into()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</div>
		<div id="intoResultDiv"></div>

    <div id="intoDetailDiv"></div>
 </div>

 <script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#birthdateBeginId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#birthdateEndId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
    laydate.render({
        elem: '#fillBeginDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
      
      laydate.render({
          elem: '#fillEndDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });
      
  });
</script>