<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXFK" value="<%=RoleType.JKXFK.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/malaria/malariaRegisterSearch.js" type="text/javascript"></script>

<div>
	<div id="register_top_all">
	<div class="toolbar">
		  <c:if test="${registerFlag == '1' && adminFlag != '1'}">
          	<a href="javascript:void(0)" onclick='javascript:malariaIndex.addRegister("add")'><b class="shangb">登记</b></a>
          </c:if>
          <c:if test="${approveFlag == '1' && adminFlag != '1'}">
          	<a href="javascript:void(0)" onclick="javascript:malariaIndex.distribution()"><b class="tongguo">一键通过</b></a>
          </c:if>
    </div>    
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="registerSearchForm">				
                <table id="registerSearch" >
				<colgroup>
					<col style="min-width:70px; width:8%;"/>
					<col style="min-width:100px; width: 19%;"/>
					<col style="min-width:70px; width: 8%;"/>
					<col style="min-width:100px; width: 19%;"/>
					<col style="min-width:70px; width: 8%;"/>
					<col style="min-width:100px; width: 19%;"/>
                    <col style="min-width:183px; width: 20%;"/>
                </colgroup>
					<tbody>
						<tr>
							<td class="coltext">患者姓名</td>
							<td class="colinput"><input type="text" name="name" /></td>
                            <td class="coltext">患者性别</td>
                            <td class="colinput">
                                <ehr:dic-radio  name="gender" dicmeta="GBT226112003" code="1,2" value="" isDefault="Y"/>
                            </td>
                            <td class="coltext">常住类型</td>
                            <td class="colinput">
                                <ehr:dic-radio  name="floatPopulation" dicmeta="FS10005" isDefault="Y"/>
                            </td>
                        </tr>
						<tr>
                            <td class="coltext">发病日期</td>
                            <td class="colinput">
                                <tag:dateInput nullToToday="true" id="pathogenesisBeginDate" name="pathogenesisBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
                                ~<tag:dateInput nullToToday="true" id="pathogenesisEndDate" name="pathogenesisEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"
                                                reg='{"compare":["pathogenesisBeginDate","ge","结束时间不能早于开始时间"]}'></tag:dateInput>
                            </td>
                            <td class="coltext">血检日期</td>
                            <td class="colinput">
								<tag:dateInput nullToToday="true" id="testBeginDate" name="testBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
								~<tag:dateInput nullToToday="true" id="testEndDate" name="testEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"
                                                reg='{"compare":["testBeginDate","ge","结束时间不能早于开始时间"]}'></tag:dateInput>
                            </td>
                            <td class="coltext">血检结果</td>
                            <td class="colinput">
                                <ehr:dic-list id="testResult" name="testResult" dicmeta="IDM00258" />
                            </td>
						</tr>
                        <tr>
                            <td class="coltext">登记状态</td>
                            <td class="colinput">
                                <ehr:dic-list id="specialStatus" name="specialStatus" dicmeta="IDM00259" />
                            </td>
                            <ehr:authorize ifAnyGranted="${JKXFK},${ADMIN}">
                                <td class="coltext">上报机构</td>
                                <td class="colinput">
                                    <tag:autoSelect name="reportOrg" id="reportOrg"></tag:autoSelect>
                                </td>
                                <td colspan="2"></td>
                            </ehr:authorize>
                            <ehr:authorize ifNotGranted="${JKXFK},${ADMIN}">
                                <td colspan="4"></td>
                            </ehr:authorize>
                                <td class="centertd">
                                <input type="button" id="registerBtnSearch" value="查询" onclick="" class="search_btn"/>
                                <input type="button" id="registerBtnExport" value="导出" onclick="" class="search_btn"/>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="7" class="colbottom">
	                          <span onclick="malariaIndex.toggle(this,'registerSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="registerResultDiv"></div>
	</div>
	<div id="registerdetailDiv" ></div>
</div>

