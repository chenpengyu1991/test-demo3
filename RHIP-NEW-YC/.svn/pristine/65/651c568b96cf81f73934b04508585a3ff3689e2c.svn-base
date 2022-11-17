<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/inpatientDrug/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="inpatientDrugSearchForm">
                <table id="inpatientDrugSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
						<col style="min-width:90px; width: 10%;"/>						
	                </colgroup>
					<tbody>
						<tr>
							<td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<tag:autoSelect name="hospitalCode" id="hospitalCode" codeValue="${hospitalCode}" style="width:200px" ></tag:autoSelect>
                            </td>						
							<td class="coltext">监控期间</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="prescribeDateBegin" name="prescribeDateBegin"  maxId="prescribeDateEnd"
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;"  reg='{"required":"true"}' ></tag:dateInput>
								~<tag:dateInput nullToToday="true" id="prescribeDateEnd" name="prescribeDateEnd" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput>
							</td> 
	
                            <td class="righttd">
                                <input type="button" id="inpatientBtnSearch" value="查询" class="search_btn"/>
                            </td>                             													
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'inpatientDrugSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="inpatientDrugResultDiv"><jsp:include page="list.jsp"/></div>
</div>
<div id="inpatientDrugDetailDiv"></div>

