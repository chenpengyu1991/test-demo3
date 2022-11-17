<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/drugPrice/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="drugPriceSearchForm">
                <table id="drugPriceSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
						<col style="min-width:90px; width: 10%;"/>						
	                </colgroup>
					<tbody>
						<tr>
							<td class="coltext"><label class="required">所属机构</label></td>
                            <td class="colinput">
                            	<tag:autoSelect name="hospitalCode" id="hospitalCode" codeValue="${hospitalCode}" style="width:200px" reg="{'required':'true'}"></tag:autoSelect>
                            </td>						
							<td class="coltext">批号</td>
							<td class="colinput">
								<input type="text" name="batchNo" style="width: 120px;"/>
							</td> 
                            <td class="righttd" rowspan="2">
                                <input type="button" id="drugPriceBtnSearch" value="查询" class="search_btn"/>
                            </td>                             													
						</tr>
						<tr>
							<td class="coltext">失效日期</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="expiryBeginDt" name="expiryBeginDt" 
									date="${firstDate}" pattern="yyyy/MM/dd" style="width: 80px;"  reg="{'required':'true'}"></tag:dateInput>
								~<tag:dateInput nullToToday="true" id="expiryEndDt" name="expiryEndDt" 
									date="${lastDate}" pattern="yyyy/MM/dd"   style="width: 80px;" reg="{'required':'true'}"></tag:dateInput>
							</td> 
							<td class="coltext">通用名</td>
							<td class="colinput">
								<input type="text" name="keyword" style="width: 120px;"/>
							</td> 														
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'drugPriceSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="drugPriceResultDiv">
			<div class="repeattable">
				<table>
					<colgroup>
						<col style="min-width:80px;width: 10%;"/>
						<col style="min-width:80px;width: 10%;"/>
				        <col style="min-width:80px;width: 7%;"/>
						<col style="min-width:80px;width: 7%;"/>
				        <col style="min-width:80px;width: 7%;"/>
						<col style="min-width:80px;width: 7%;"/>
				        <col style="min-width:80px;width: 7%;"/>
						<col style="min-width:80px;width: 7%;"/>
				        <col style="min-width:80px;width: 7%;"/>
				        <col style="min-width:80px;width: 7%;"/>
						<col style="min-width:80px;width: 7%;"/>
				        <col style="min-width:80px;width: 7%;"/>
				        <col style="min-width:80px;width: 10%;"/>
					</colgroup>
					<thead>
						<tr>
							<th>医疗机构</th>
			                <th>药品名称</th>
							<th>通用名</th>
			                <th>药品规格</th>
							<th>包装</th>
							<th>产地</th>
							<th>生产厂家</th>
							<th>批发价格</th>
							<th>零售价格</th>
							<th>价格差</th>
							<th>差价率</th>
							<th>批号</th>
							<th>失效日期</th>
						</tr>
					</thead>
				</table>
				</div>		
			</div>
	</div>
<div id="drugPriceDetailDiv"></div>

