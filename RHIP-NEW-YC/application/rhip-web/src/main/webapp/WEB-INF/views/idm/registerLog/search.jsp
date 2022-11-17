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

<script src="${pageContext.request.contextPath}/js/views/idm/registerLog/search.js" type="text/javascript"></script>
<div class="section"  id="top_all">
	<div class="toolbar">
		<a id="btnResourceExport" href="javascript:void(0)"><b class="export">导出</b></a>
	</div>
    <div class="searchbox">
        <form id="logSearchForm">
            <table id="logSearch" >
            <colgroup>
                <col style="min-width:70px; width: 10%;"/>
                <col style="min-width:160px; width: 27%;"/>
                <col style="min-width:80px; width: 10%;"/>
                <col style="min-width:160px; width: 27%;"/>
                <col style="min-width:60px; width: 10%;"/>
            </colgroup>
                <tbody>
                  <tr>
                        <td class="coltext">入院日期</td>
                        <td class="colinput">
                            <tag:dateInput  id="inhosBeginDate" name="inhosBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
                            ~<tag:dateInput nullToToday="true" id="inhosEndDate" name="inhosEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
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
						<td><c:if test="${staff.deptCode eq null }">
							<select name="medicalRoomCode" id="medicalRoomCode" style="width: 150px">
								<option value="">请选择</option>
								<c:forEach var="dept" items="${deptList}">
									<option value="${dept.deptCode}"}>${dept.deptName}</option>
								</c:forEach>
							</select>
							</c:if>
						</td>
                        <td class="coltext">状态</td>
                        <td class="colinput">
                            <ehr:dic-list name="visitStatus" dicmeta="DMD00064"></ehr:dic-list>    
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">患者姓名</td>
                        <td class="colinput">
                             <input type="text" name="name" />
                        </td>
                        <td class="coltext">年龄段</td>
						<td class="colinput">
							<input type="text" id="beginAge" name="beginAge" style="width:65px;" reg='{"digits":"true"}' />
							&nbsp;~&nbsp;
							<input type="text" id="endAge" name="endAge" style="width:65px;" reg='{"digits":"true"}' />
						</td>
                    </tr>
                    <tr>
                     	<td class="coltext">职业</td>
                        <td class="colinput">
                        	<ehr:dic-list name="occupation" dicmeta="GBT6565" code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"></ehr:dic-list>
                        </td>
                        <td class="coltext">诊断</td>
                        <td class="colinput">
                        	<input type="text" name=inDiagnose />
                        </td>         	
                        <td align="left">
                            <input type="button" value="查询" onclick="logSearch.search(1)" class="search_btn"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="logSearch.toggle(this,'logSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

         </form>
    </div>
    <div id="logResultDiv">
    </div>
</div>
<div id="detailDiv"></div>

