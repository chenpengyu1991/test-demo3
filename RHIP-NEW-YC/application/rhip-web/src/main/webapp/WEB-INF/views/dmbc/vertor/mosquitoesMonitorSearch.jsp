<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mosquitoesMonitorSearch.js" type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
	<div id="top_all">
		<div class="toolbar">
			<a id="reportBtn" ><b class="lb">统计汇总表</b></a>
			<a id="initAdd" ><b class="xinz">新增</b></a>
		</div>
		<div class="searchbox">
			<form id="mosquitoesSearchForm">
                <table id="mouseSearch" >
				<colgroup>
					<col style="min-width:70px; width: 20%;"/>
					<col style="min-width:160px; width: 30%;"/>
                    <col style="min-width:80px; width: 20%;"/>
					<col style="min-width: 210px;width: 30%; "/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">监测时间</td>
							<td class="col-input" >
								<tag:dateInput nullToToday="true" id="beginDate" name="beginDate" maxId="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
	                            ~<tag:dateInput nullToToday="true" id="endDate" name="endDate" minId="beginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
							</td>
							<td class="coltext">监测乡镇</td>
                            <td class="colinput">
                                <ehr:dic-town-village townId="townShip"
									townName="townShip"
									townValue="${townShip}" width="150px;"/>
							</td>
						</tr>
                    <tr>
                    	
	                    <td class="coltext">环境类型</td>
	                    <td >
	                    	<ehr:dic-list name="environment" dicmeta="DMBC00012" width="200px;"/>
	                    </td>
	                    <td></td>
                        <td align="left">
                            <input type="button" id="mosquitoesBtnSearch" value="查询" class="search_btn"/>
                        </td>
                    </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="mosquitoesMonitorSearch.toggle(this,'mouseSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="resultDiv">
        </div>
	</div>
	<div id="detailDiv" >    </div>
</div>
<div id="operationDiv"></div>
