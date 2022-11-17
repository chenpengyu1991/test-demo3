<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/equipment/breakage/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="breakageSearchForm">
                <table id="breakageSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
						<col style="min-width:180px; width: 10%;"/>						
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<tag:autoSelect name="organCode" id="organCode" codeValue="${organCode}" style="width:200px" ></tag:autoSelect>
                            </td>	
                            <td class="coltext">财产编号</td>
                            <td class="colinput">
 								<input type="text" name="propertyNo" style="width: 120px;"/>
                            </td>                              						
                            <td class="righttd" rowspan="2">
                                <input type="button" id="breakageBtnSearch" value="查询" class="search_btn"/>
                            </td>  							                         
						</tr>
						<tr>
							<td class="coltext">采购日期</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" name="beginDt" 
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;" ></tag:dateInput>
								~<tag:dateInput nullToToday="true" name="endDt" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput>
							</td> 						
                            <td class="coltext">设备名称</td>
                            <td class="colinput">
 								<input type="text" name="keyword" style="width: 120px;"/>
                            </td>                            						
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'breakageSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="breakageResultDiv"></div>
</div>
<div id="breakageDetailDiv"></div>

