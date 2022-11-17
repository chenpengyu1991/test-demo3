<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/case/repeatCase/search.js" type="text/javascript"></script>

<div class="section"  id="top_all">
	<div class="toolbar">
		<!-- <a href="javascript:void(0)" id="btnExport"><b class="export">导出名单</b></a> -->
	</div>
		<div class="searchbox">
			<form id="reportSearchForm">				
                <table id="caseSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 27%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 27%;"/>
                    <col style="min-width:60px; width: 10%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">身份证号</td>
							<td class="colinput">
								<tag:idcardInput name="idcard" id="idCard" ></tag:idcardInput>&nbsp;
                                <input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
                                <input type="hidden" id="tab" name="tab" value="case">
							</td>
                            <td class="coltext">患者姓名</td>
                            <td class="colinput"><input type="text" name="name" /></td>
						</tr>
                        <tr>
                            <td class="coltext">出生日期</td>
                            <td class="colinput">
                                <tag:dateInput id="birthBeginDate" name="birthBeginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                                ~<tag:dateInput id="birthEndDate" name="birthEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                            </td>
                            <td class="coltext">填写单位</td>
                            <td class="colinput">
                                <%-- <ehr:org-type-list id="surveyOrgCode" name="surveyOrgCode" type="hospital,centre,other"  code="${fillOrganCode}"  codeOther="46714114-9"/> --%>
                               	<ehr:authorize ifAnyGranted="${ZCRB},${ZXCRB}">
								<ehr:dic-org-list name="surveyOrgCode"/>
								</ehr:authorize>	
								<ehr:authorize ifAnyGranted="${JKFYK},${ADMIN}">
									<ehr:org-type-list id="surveyOrgCode" name="surveyOrgCode" type="hospital,centre,other" code="${fillOrganCode}"  codeOther="46714114-9"/>
									<%-- <input type="hidden" id="surveyOrgCode" name="surveyOrgCode"/>
									<tag:autoSelect name="surveyOrgCode" id="surveyOrgCode" style="width:170px" ></tag:autoSelect> --%>
								</ehr:authorize>
                            
                            </td>
                        </tr>
                        <tr>
                            <td class="coltext">疾病名称</td>
                            <td class="colinput">
                                <select id="infectiousCode" name="infectiousCode"></select>
                            </td>
                            <td class="coltext">处置状态</td>
                            <td class="colinput">
                                    <ehr:dic-radio  name="caseStatus" dicmeta="PH00020" value="${caseStatus}" isDefault="Y"/>
                            </td>
                            <td>
                                <input type="button" value="查询" id="caseSearchId" class="search_btn"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="coltext">档案状态</td>
                            <td class="colinput">
                                <ehr:dic-radio name="logoff" dicmeta="PH00031" isDefault="Y" value="${logoff}"/>
                            </td>
                        </tr>
                        <tr>
                        	<td class="coltext"  >查重条件</td>
							<td class="colinput"  colspan="2">
								<input type="checkbox" name="repeatConditions" value="infectious_Code" checked="checked"  onclick="return false;"  disabled /> 疾病名称
								<input type="checkbox" name="repeatConditions" value="idcard" checked="checked"/> 身份证号
								<input type="checkbox" name="repeatConditions" value="name" /> 姓名
								<input type="checkbox" name="repeatConditions" value="gender" /> 性别
								<input type="checkbox" name="repeatConditions" value="occupation" /> 人群分类
								<input type="checkbox" name="repeatConditions" value="birthday" /> 出生日期
								<input type="checkbox" name="repeatConditions" value="pa_Address" /> 现住址
							</td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="repeatSearch.toggle(this,'caseSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="caseResultDiv">
        </div>

</div>
<div id="detailDiv"></div>

