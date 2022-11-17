<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/vaccine/inoculation/index.js" type="text/javascript"></script>

<div class="section">
		<div class="toolbar">
			<a href="javascript:void(0)" onclick="inoculationIndex.addInoculation(${inoculation.id})"><b id="addInoculation" class="xinz">新增</b></a>
			<a href="javascript:void(0)" onclick="inoculationIndex.excel()"><b class="export">导出</b></a>
		</div>
<div class="searchbox">
	<form method="post" id="form_search">
		<table id="inoculationSearch">
			<colgroup>
					<col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:60px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
			</colgroup>
		<tbody>	
				<tr>
					<td class="coltext">姓名</td>
					<td class="colinput">
						<input style="width:50%" type="text" name="epersonName" />
					</td>
					<td class="coltext">身份证号</td>
					<td class="colinput">
						<tag:idcardInput name="epersonIdcard" style="width:50%"></tag:idcardInput>
					</td>
					<td class="coltext">预约时间</td>
					<td class="colinput">
					 <tag:dateInput  nullToToday="true" id="dateFrom" style="width:35%"
                               pattern="yyyy/MM/dd" name="dateFrom" date="${defaultMonth}"/>~
                      <tag:dateInput nullToToday="true" id="dateTo" pattern="yyyy/MM/dd" 
                               name="dateTo" style="width:35%"/>
					</td>       
                </tr>
              <tr>
                   <td class="coltext">预约机构</td>
				   <c:if test="${currentLoginInfo.organization.organName eq '永城市疾病预防控制中心'}">
                    <td class="colinput">
	                    <ehr:org-type-list name="eorganCode" type="centre" value="${currentOrgCode}" width="50%" />
                    </td>
                    </c:if>
                    <c:if test="${currentLoginInfo.organization.organName ne '永城市疾病预防控制中心'}">
                    <td class="colinput">
                    	<input  style="width:51%" readonly="readonly" type="text" name="createOrgshow" value="${currentLoginInfo.organization.organName}" />
                    	<input  style="width:51%" type="hidden" name="eorganCode" value="${currentLoginInfo.organization.organCode}" />
                    </td>
                    </c:if>
                    <td class="coltext">是否接种</td>  
                    <td class="colinput">
                    	<select name="isInject" style="width:50%">
                    		<option value="">请选择</option>
							<option value="1">是</option> 
                    		<option value="0">否</option>
                    	</select>
                    </td>  
                    <td class="coltext">疫苗类型</td>                
                   	<td class="colinput">
                    	<select name="vaccineType" style="width:50%">
                    		<option value="1">老年人23价疫苗预约</option>
							<option value="3">3价流感疫苗预约</option> 
                    		<option value="4">4价流感疫苗预约</option>
                    		<option value="5">4价HPV疫苗预约</option>
                    		<option value="6">9价HPV疫苗预约</option>
                    	</select>
                    </td>  
             </tr>
             <tr>
             	<td colspan="5"></td>                
                <td class="colinput">
                    <input id="inoculation_Search_Btn" class="search_btn" type="button" value="查询"/>
                </td>
             </tr>
             
		</tbody>
		</table>
		<table>
           <tr>
             <td colspan="6" class="colbottom">
              　			 <span onclick="util.toggle(this,'inoculationSearch')" class="ico-bottom">&nbsp;</span>
             </td>
           </tr>
		</table>
	</form>
</div>
<div id="inoculationList"></div>
</div>
