<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/childcareInst/monitorSearch.js" type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
	<div id="top_all">
		<div class="toolbar">
			<a id="btnAdd" ><b class="xinz">新增</b></a>
		</div>
		<div class="searchbox">
			<form id="searchForm">				
                <table id="searchTable">
				<colgroup>
					<col style="min-width:70px; width: 20%;"/>
					<col style="min-width:100px; width: 30%;"/>
                    <col style="min-width:70px; width: 20%;"/>
					<col style="min-width:100px;width: 30%; "/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">机构名称</td>
							<td class="colinput">
								<input type="text" name="orgName" style="width:200px;"/>
							</td>
							<td class="coltext">机构类型</td>
							<td class="colinput">
								<ehr:dic-list name="orgType"  dicmeta="DMBC00009" />
							</td>
						</tr>
						<tr>
							<td class="coltext">监测时间</td>
							<td class="col-input" >
								<tag:dateInput nullToToday="true" id="beginDate" name="beginDate" maxId="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
	                            ~<tag:dateInput nullToToday="true" id="endDate" name="endDate" minId="beginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
							</td>
                            <td class="coltext"></td>
		                    <td>
                            	<input type="button" id="btnSearch" value="查询" class="search_btn"/>
                        	</td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="4" class="colbottom">
	                          <span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="resultDiv">
        </div>
	</div>
</div>
