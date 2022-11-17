<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>" />
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>" />
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>" />
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/idm/anorecta/search.js" type="text/javascript"></script>
<div class="section"  id="top_all">
	<div class="toolbar">
		 <ehr:authorize ifNotGranted="${JKFYK},${ADMIN}">
			<a href="javascript:void(0)" id="import" onclick="anorectaSearch.importTable()"><b class="import">导入</b></a>
		</ehr:authorize> 
		<a href="javascript:void(0)" id="reportExport" onclick="anorectaSearch.exportTable()"><b class="export">导出</b></a>
    </div>
    <div class="searchbox">
        <form id="searchForm">
            <table id="search" >
            <colgroup>
                <col style="min-width:70px; width: 12%;"/>
                <col style="min-width:160px; width: 10%;"/>
                <col style="min-width:80px; width: 20%;"/>
                <col style="min-width:160px; width: 30%;"/>
                <col style="min-width:60px; width: 10%;"/>
                <col style="min-width:160px; width: 18%;"/>
            </colgroup>
                <tbody>  
               		<tr>
                      <td class="coltext">时间范围</td>
                      <td class="colinput">
                          <select name="rangeType" id="rangeType" style="width: 120px;">
                          	  <option value="1">按旬</option>
                              <option value="2">按周</option>
                          </select>
                      </td>
                      <td class="coltext">时间</td>
                      <td class="colinput">
                          <div id="byXun">
                              <tags:dateInput nullToToday="true" name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                              <select name="rangeDate" id="rangeDate" style="width: 80px;">
                                  <option value="1">上旬</option>
                                  <option value="2">中旬</option>
                                  <option value="3">下旬</option>
                              </select>
                          </div>
                          <div id="byWeek">
                              <input type="hidden" id="weekBeginDate" name="weekBeginDate"/>                         
                              <input type="hidden" id="weekEndDate" name="weekEndDate"/>                             
                              <tags:dateInput nullToToday="true" name="weekDate" pattern="yyyy" id="beginDate0" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                              <select name="weekSelect" id="weekSelect" style="width: 200px;"></select>
                          </div>
                      </td>
                  </tr> 
                  <tr>
                 	    <ehr:authorize ifAnyGranted="${JKFYK},${ADMIN}">
                        	<td class="coltext">机构</td>
                            <td class="colinput" colspan="3">
                                <ehr:dic-town-centre-station townId="townOrgCode" centreId="centerOrgCode" stationId="orgCode" townName="townOrgCode" centreName="centerOrgCode" stationName="orgCode" style="width:180px;"/>
                       		</td>
                       </ehr:authorize> 
                       <ehr:authorize ifAnyGranted="${YYCRB},${ZCRB}">
                        	<td class="coltext" colspan="3">机构</td>
                       		<td class="colinput">
	                            <ehr:org-type-list id="fillOrganCode" name="fillOrganCode" type="hospital,station" value="${fillOrganCode}" code="${fillOrganCode}" codeOther="46714114-9" defaultval="${fillOrganCode}" width="180px" />
	                        </td>
                       </ehr:authorize> 
                       <ehr:authorize ifAnyGranted="${ZXCRB}">
                        	<td class="coltext">机构</td>
	                        <td class="colinput" colspan="3">
	                            <ehr:dic-org-list id="fillOrganCode" name="fillOrganCode"  isShowOneself="true" width="180px"/>
	                        </td>
                        </ehr:authorize> 
                        <td align="left">
                          <input type="button" value="查询" onclick="anorectaSearch.search(1)" class="search_btn"/>
                       </td>            
                  </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="anorectaSearch.toggle(this,'search')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

         </form>
    </div>
    <div id="resultDiv">
    </div>
</div>
<div id="detailDiv"></div>

