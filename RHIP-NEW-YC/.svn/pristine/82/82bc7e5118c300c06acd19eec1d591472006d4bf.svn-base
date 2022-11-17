<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/config/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="configSearchForm">
                <table id="configSearch" >
					<colgroup>
						<col style="min-width:100px; width: 15%;"/>
						<col style="min-width:160px; width: 35%;"/>
	                    <col style="min-width:80px; width: 12%;"/>
						<col style="min-width:160px; width: 38%;"/>
				
	                </colgroup>
					<tbody>
						<tr>
							<td class="coltext">全国唯一识别码</td>
                            <td class="colinput">
 								<input type="text" name="nationalOrganCode" style="width: 120px;"/>
                            </td>
                            <td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<ehr:dic-town-centre-station  centreName="parentCode" stationName="organCode" townName="gbCode" width="120px;" />
                            </td>							
  
						</tr>
						<tr>
							<td class="coltext">机构类别</td>
							<td class="colinput"><ehr:dic-list  dicmeta="GBT2182002"  name="genreCode" code="A1,B1,B2,D400,L,R2" width="120px"/></td>
							<td class="coltext">申请日期</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" name="beginDt" 
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;" ></tag:dateInput>
								~<tag:dateInput nullToToday="true" name="endDt" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput>
							</td>  
						</tr>	
						<tr>
							<td class="coltext" colspan="4" >
                                <input type="button" id="configBtnSearch" value="查询" class="search_btn" style="float:right;"/>
                            </td> 
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'configSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="configResultDiv"></div>
</div>
<div id="configDetailDiv"></div>

