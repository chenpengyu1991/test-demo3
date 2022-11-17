<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>" />
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>" />
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>" />
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/idm/inspection/search.js" type="text/javascript"></script>
<div class="section"  id="top_all">
	<div class="toolbar">
		<a id="btnResourceExport" href="javascript:void(0)"><b class="export">导出</b></a>
	</div>
    <div class="searchbox">
        <form id="inspectionSearchForm">
            <table id="inspectionSearch" >
            <colgroup>
                <col style="min-width:70px; width: 10%;"/>
                <col style="min-width:160px; width: 27%;"/>
                <col style="min-width:80px; width: 15%;"/>
                <col style="min-width:160px; width: 23%;"/>
                <col style="min-width:60px; width: 10%;"/>
            </colgroup>
                <tbody>
                  <tr>
                        <td class="coltext">检查日期</td>
                        <td class="colinput">
                            <tag:dateInput id="checkBeginDate" name="checkBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;" date="${deginDate}"></tag:dateInput>
                            ~<tag:dateInput nullToToday="true" id="checkEndDate" name="checkEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                        </td>
                        <ehr:authorize ifAnyGranted="${JKFYK},${ADMIN}">
                         	<td class="coltext">机构</td>
	                        <td class="colinput" colspan="3">                 
	                            <ehr:dic-town-centre-station townId="townOrgCode" townName="townOrgCode" centreId="centerOrgCode" centreName="centerOrgCode" stationId="orgCode" stationName="orgCode" style="width:130px;"/>
	                        </td>
                        </ehr:authorize> 
                        <ehr:authorize ifAnyGranted="${YYCRB},${ZCRB}">
                         	<td class="coltext">机构</td>
	                        <td class="colinput">
	                            <ehr:org-type-list id="clinicOrganCode" name="clinicOrganCode" type="hospital,station" value="${clinicOrganCode}" code="${clinicOrganCode}" codeOther="46714114-9" defaultval="${clinicOrganCode}" />
	                        </td>
                        </ehr:authorize> 
                        <ehr:authorize ifAnyGranted="${ZXCRB}">
                         	<td class="coltext">机构</td>
	                        <td class="colinput">
	                            <ehr:dic-org-list id="clinicOrganCode" name="clinicOrganCode"  isShowOneself="true"/>
	                        </td>
                        </ehr:authorize> 
                    </tr>
                     <tr>
                        <td class="coltext">科室</td>                       
						<td>
							<select name="detectionRoomCode" id="detectionRoomCode" style="width: 150px">
								<option value="">请选择</option>
								<c:forEach var="dept" items="${deptList}">
									<option value="${dept.deptCode}"}>${dept.deptName}</option>
								</c:forEach>
							</select>
                        </td>
                        <td class="coltext">痰涂片阳性</td>                       
						<td>
							<ehr:dic-list name="sputumSmearPosi" dicmeta="PH00001" code="1,2" ></ehr:dic-list>
                        </td>
                         <td class="coltext">梅毒检测阳性</td>                       
						<td>
							<ehr:dic-list name="syphilisPosi" dicmeta="PH00001" code="1,2"></ehr:dic-list>
                        </td>
                    </tr>
                     <tr>
                        <td class="coltext">乙肝两对半阳性</td>                       
						<td>
							<ehr:dic-list name="hbvDnaPosi" dicmeta="PH00001" code="1,2"></ehr:dic-list>
                        </td>
                        <td class="coltext">谷丙谷草大于指定值</td>                       
						<td>
							<ehr:dic-list name="alanineAspartate" dicmeta="PH00001" code="1,2"></ehr:dic-list>
                        </td> 
                        <td align="right">
                            <input type="button" value="查询" onclick="inspectionSearch.search(1)" class="search_btn"/>
                        </td> 
                    </tr> 
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="inspectionSearch.toggle(this,'inspectionSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

         </form>
    </div>
    <div id="inspectionResultDiv">
    </div>
</div>
<div id="detailDiv"></div>

