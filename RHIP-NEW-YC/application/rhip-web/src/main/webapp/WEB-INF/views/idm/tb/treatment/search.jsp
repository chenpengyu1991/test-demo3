<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXJHB" value="<%=RoleType.ZXJHB.getValue()%>"/>
<c:set var="ZJHB" value="<%=RoleType.ZJHB.getValue()%>"/>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/treatment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="TREATMENT" value="<%=TbStatus.TREATMENT.getValue()%>"/>
<c:set var="ASSIGN" value="<%=TbStatus.ASSIGN.getValue()%>"/>
<c:set var="ACCEPT" value="<%=TbStatus.ACCEPT.getValue()%>"/>
<c:set var="RETURN" value="<%=TbStatus.RETURN.getValue()%>"/>
<c:set var="CANCEL" value="<%=TbStatus.CANCEL.getValue()%>"/>
<c:set var="STOP" value="<%=TbStatus.STOP.getValue()%>"/>
<c:set var="TREATMENT" value="<%=TbStatus.TREATMENT.getValue()%>" />
<c:set var="REASSIGN" value="<%=TbStatus.REASSIGN.getValue()%>"/>
<div>
	<div id="top_allTreatment">

		<div class="searchbox searchSection x-admin-sm">
			<form id="treatmentSearchForm">				
                <table id="treatmentSearch" >
					<colgroup>
						<col style="min-width:70px; width: 7%;"/>
						<col style="min-width:100px; width: 16%;"/>
						<col style="min-width:70px; width: 6%;"/>
						<col style="min-width:100px; width: 21%;"/>
						<col style="min-width:70px; width: 8%;"/>
						<col style="min-width:100px; width: 17%;"/>
						<col style="min-width:90px; width: 8%;"/>
						<col style="min-width:90px; width: 17%;"/>
					</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idcard"  id="idcard3" cssClass="x-layui-input"/>
								<input type="button" id="check-submit-btn3" value="读卡" style="width: 40px;">
							</td>							
							<td class="coltext">登记号</td>
							<td class="colinput"><input type="text" name="registerNum" class="x-layui-input"/></td>
							<td class="coltext">档案状态</td>
                            <td class="colinput">
                                <ehr:dic-list id="logoff" name="logoff" dicmeta="PH00031" cssClass="x-layui-input"/>
                            </td>
						</tr>
						<tr>
							<td class="coltext">状态</td>
							<td class="colinput">
								<select name="specialStatus" class="x-layui-input">
									<option value="">请选择</option>
									<option value="${TREATMENT}">未管理</option>
									<option value="${ASSIGN}">已分派</option>
									<option value="${RETURN}">已退回</option>
									<option value="${REASSIGN}">已重派</option>
									<option value="${ACCEPT}">已管理</option>
									<%-- <option value="${CANCEL}">已作废</option> --%>
									<option value="${STOP}">停止治疗</option>
								</select>
							</td>
							<td class="coltext">管理方式</td>
							<td class="colinput"><ehr:dic-list dicmeta="IDM00243" name="manageType" cssClass="x-layui-input"/> </td>
							<td class="coltext">登记日期</td>
							<td class="colinput">
								<%-- <tag:dateInput nullToToday="false" name="registerDtBegin" pattern="yyyy/MM/dd"  onlypast="true" style="width: 40%"/>
								~<tag:dateInput nullToToday="false" name="registerDtEnd" pattern="yyyy/MM/dd"  onlypast="true" style="width: 40%"/> --%>
								
								<input type="text" class="layui-input x-admin-sm-date"  name="registerDtBegin" id="registerDtBeginId" style="padding-left: 0px;width: 40%" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="registerDtEnd" id="registerDtEndId" style="padding-left: 0px;width: 40%" />
							</td>
                         </tr>
						<tr class="advanceSearchSection" style="display: none;">
							<ehr:authorize ifAnyGranted="${ZXJHB},${ZJHB}">
								<td class="coltext" id="sf_text" >管理机构</td>
								<td class="colinput" id="sf_input">
									<ehr:dic-org-list id="nowAddressCode" name="orgCode" defaultval="N" width="80%" isShowOneself="true"/>
								</td>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${DDCRBYY},${JKJHB},${ADMIN}">
								<td class="coltext" id="sf_text">管理机构</td>
								<td class="colinput" id="sf_input" colspan="5">
								<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchstation" townName="searchTown" isAuthorize="false" isShow="true" isShowOneself="true"
															 townId="searchTown" centreId="searchCenter" stationId="searchStation" style="width: 150px;"/>
								<input id="searchOrganCode" name="orgCode" type="hidden"/>
								</td>
							</ehr:authorize>
						</tr>
						<tr>
							<td class="righttd" colspan="8">
								<%-- <input type="button" id="treatmentBtnSearch" value="查询" class="search_btn"/> --%>
								<button class="layui-btn layui-btn-sm" id="treatmentBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
							</td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'treatmentSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="listDivTreatment"></div>
	</div>
	<div id="detailDivTreatment"></div>
</div>


<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#registerDtBeginId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#registerDtEndId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });

  });
</script>
