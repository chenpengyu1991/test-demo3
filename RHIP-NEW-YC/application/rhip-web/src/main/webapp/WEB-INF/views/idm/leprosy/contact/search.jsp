<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/leprosy_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/contact.js" type="text/javascript"></script>

<div>
	<div id="top_allContact">
	<div class="searchbox">
		<form id="contactSearchForm">
          <table id="contactSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:90px; width: 10%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">患者姓名</td>
							<td class="colinput"><input type="text" name="name" /></td>
                            <td class="coltext">患者性别</td>
                            <td class="colinput">
                                <ehr:dic-list id="gender" name="gender" dicmeta="GBT226112003" code="1,2" />
                            </td>
                            <td class="coltext">上报日期</td>
                            <td class="colinput">
                                <tag:dateInput nullToToday="true" name="modifySurveyDateBegin" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
                                ~<tag:dateInput nullToToday="true" name="modifySurveyDateEnd" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                            </td>
                            <td class="centertd">
                                <input type="button" id="contactBtnSearch" value="查询" onclick="" class="search_btn"/>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="leprosyIndex.toggle(this,'contactSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
			</div>
		<div id="listDivContact"></div>
	</div>
	<div id="detailDivContact"></div>
</div>

