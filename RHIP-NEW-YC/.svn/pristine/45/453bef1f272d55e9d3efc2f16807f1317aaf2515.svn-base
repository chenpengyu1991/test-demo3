<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/case.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div>
	<div id="top_all2">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="caseSearchForm">
                <table id="caseSearch" >
				<colgroup>
					<col style="min-width:70px; width: 15%;"/>
					<col style="min-width:100px; width: 30%;"/>
					<col style="min-width:70px; width: 15%;"/>
					<col style="min-width:100px; width: 30%;"/>
					<col style="min-width:70px; width: 10%;"/>
				</colgroup>
					<tbody>
						<tr>
							<td class="coltext">患者姓名</td>
							<td class="colinput"><input type="text" name="name" /></td>
                            <td class="coltext">身份证号</td>
                            <td class="colinput">
                            	<tag:idcardInput name="idcard" ></tag:idcardInput>
                            </td>							
                            <td rowspan="3">
                                <input type="button" value="查询" onclick="malariaCase.searchCase(1)" class="search_btn"/>
                                <input type="button" value="导出" onclick="malariaCase.caseDownLoad()" class="search_btn"/>
                            </td>
						</tr>
						<tr>
                            <td class="coltext">患者性别</td>
                            <td class="colinput">
                                <ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" value="" isDefault="Y"/>
                            </td>						
                            <td class="coltext">疟疾类型</td>
                            <td class="colinput">
                                <ehr:dic-list id="malariaType" name="malariaType" dicmeta="IDM00263"/>
                            </td>
						</tr>
						<tr>                            
                            <td class="coltext">管理状态</td>
                            <td class="colinput">
                                <ehr:dic-list id="specialStatus" name="specialStatus" dicmeta="IDM00259" code="3,4"/>
                            </td>
                            <td class="coltext">档案状态</td>
                            <td class="colinput">
                                <ehr:dic-radio name="logoff" dicmeta="PH00031" value="" isDefault="Y"/>
                            </td>                            
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="5" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'caseSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="caseResultDiv"></div>
	</div>
	<div id="detailDiv2" ></div>
</div>

