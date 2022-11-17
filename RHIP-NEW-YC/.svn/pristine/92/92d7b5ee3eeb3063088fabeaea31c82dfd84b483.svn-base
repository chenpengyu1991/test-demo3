<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="repeattable">
    <form id="mentalEpilepsyCensusForm">
        <table class="layui-table x-admin-sm-table-list-middle">
            <colgroup>
            	<col style="width: 10%"/>
                <col style="width: 18%"/>
                <col style="width: 9%"/>
                <col style="width: 9%"/>
                <col style="width: 9%"/>
                <col style="width: 9%"/>
                <col style="width: 9%"/>
                <col style="width: 9%"/>
                <col style="width: 9%"/>
                <col style="width: 9%"/>
            </colgroup>
            <thead>
            <tr>
             	<th rowspan="2">区县</th>
                <th rowspan="2">机构</th>
                <th colspan="8">严重精神障碍患者管理统计报表</th>
            </tr>
            <tr>
                <th>辖区内登记在册的确诊严重精神障碍患者人数</th>
                <th>辖区内按照规范要求进行管理的严重精神障碍患者人数</th>
                <th>严重精神障碍患者规范管理率</th>
                <th>最近一次随访时分类为病情稳定的患者数</th>
                <th>重性精神障碍患者稳定率</th>
                <th>癫痫发作有效控制人数</th>
                <th>随访治疗癫痫患者数</th>
                <th>癫痫患者发作有效控制率</th>
            </tr>
            </thead>
            <tbody id="noModifyTbody">
            <c:forEach items="${mentalEpiPatientList}" var="MentalEpiList">
                <tr>
               		<td>
						<ehr:tip><ehr:dic code="${MentalEpiList.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
                    <td><c:out value="${MentalEpiList.ORGANNAME}"></c:out></td>
                    
                    <td><c:out value="${MentalEpiList.MENTALNUM}"></c:out></td>
                    <td><c:out value="${MentalEpiList.MENTALMANAGENUM}"></c:out></td>
                  	<td title="<fmt:formatNumber value="${MentalEpiList.MENTALNUM==0?0:(MentalEpiList.MENTALMANAGENUM/MentalEpiList.MENTALNUM)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${MentalEpiList.MENTALNUM==0?0:(MentalEpiList.MENTALMANAGENUM/MentalEpiList.MENTALNUM)*100}" pattern="#,##0.0"/>% 
					</td>
					
                    <td><c:out value="${MentalEpiList.STABLEDISEASENUM}"></c:out></td>
                   	<td title="<fmt:formatNumber value="${MentalEpiList.MENTALNUM==0?0:(MentalEpiList.STABLEDISEASENUM/MentalEpiList.MENTALNUM)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${MentalEpiList.MENTALNUM==0?0:(MentalEpiList.STABLEDISEASENUM/MentalEpiList.MENTALNUM)*100}" pattern="#,##0.0"/>% 
					</td>
					
                    <td><c:out value="${MentalEpiList.EPILEPSYCONTROLNUM}"></c:out></td>
                    <td><c:out value="${MentalEpiList.EPILEPSYNUM}"></c:out></td>
                  	<td title="<fmt:formatNumber value="${MentalEpiList.EPILEPSYNUM==0?0:(MentalEpiList.EPILEPSYCONTROLNUM/MentalEpiList.EPILEPSYNUM)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${MentalEpiList.EPILEPSYNUM==0?0:(MentalEpiList.EPILEPSYCONTROLNUM/MentalEpiList.EPILEPSYNUM)*100}" pattern="#,##0.0"/>% 
					</td>
                </tr>
            </c:forEach>
             <c:if test="${total!=null}">
	            <tr>
	                <td colspan="2"><b>合计</b></td>
	                <td><c:out value="${total.MENTALNUM}"></c:out></td>
	                <td><c:out value="${total.MENTALMANAGENUM}"></c:out></td>
	                <td title="<fmt:formatNumber value="${total.MENTALNUM==0?0:(total.MENTALMANAGENUM/total.MENTALNUM)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${total.MENTALNUM==0?0:(total.MENTALMANAGENUM/total.MENTALNUM)*100}" pattern="#,##0.0"/>% 
					</td>
					
	                <td><c:out value="${total.STABLEDISEASENUM}"></c:out></td>
	               	<td title="<fmt:formatNumber value="${total.MENTALNUM==0?0:(total.STABLEDISEASENUM/total.MENTALNUM)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${total.MENTALNUM==0?0:(total.STABLEDISEASENUM/total.MENTALNUM)*100}" pattern="#,##0.0"/>% 
					</td>
						
	                <td><c:out value="${total.EPILEPSYCONTROLNUM}"></c:out></td>
	                <td><c:out value="${total.EPILEPSYNUM}"></c:out></td>
	               	<td title="<fmt:formatNumber value="${total.EPILEPSYNUM==0?0:(total.EPILEPSYCONTROLNUM/total.EPILEPSYNUM)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${total.EPILEPSYNUM==0?0:(total.EPILEPSYCONTROLNUM/total.EPILEPSYNUM)*100}" pattern="#,##0.0"/>% 
					</td>
	            </tr>
	           </c:if>
            </tbody>
            <tbody id="modifyTbody" style="display: none">
           	 	<tr>
           	 		<td>
						<ehr:tip><ehr:dic code="${editMental.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
           	 		<td>
			           	<input type="hidden" name="organCode" value="${editMental.organCode}"/>
			            <input type="hidden" name="organName" value="${editMental.organName}"/>
			            <input type="hidden" name="id" value="${editMental.id}"/>
			            <input type="hidden" name="parentCode" value="${editMental.parentCode}"/>
			            <input type="hidden" name="genreCode" value="${editMental.genreCode}"/>
			            <input type="hidden" name="gbCode" value="${editMental.gbCode}"/>
		            
		                <c:out value="${editMental.organName}"></c:out>
		            </td>
	                <td><tag:numberInput id="mentalNum_id"  name="mentalNum" value="${editMental.mentalNum}"></tag:numberInput></td>
	                <td><tag:numberInput id="mentalManageNum_id" name="mentalManageNum" value="${editMental.mentalManageNum}"></tag:numberInput></td>
	                <td><span id="mentalPercent"><fmt:formatNumber value="${editMental.mentalNum==0?0:(editMental.mentalManageNum/editMental.mentalNum)*100}" pattern="#,##0.0"/>%</span></td>
	            	<td><tag:numberInput id="stableDiseaseNum_id" name="stableDiseaseNum" value="${editMental.stableDiseaseNum}"></tag:numberInput></td>
	            	<td><span id="stableDiseasePercent"> <fmt:formatNumber value="${editMental.mentalNum==0?0:(editMental.stableDiseaseNum/editMental.mentalNum)*100}" pattern="#,##0.0"/>%  </span></td>
	            	<td><tag:numberInput id="epilepsyControlNum_id" name="epilepsyControlNum" value="${editMental.epilepsyControlNum}"></tag:numberInput></td>
	            	<td><tag:numberInput id="epilepsyNum_id" name="epilepsyNum" value="${editMental.epilepsyNum}"></tag:numberInput></td>
	            	<td><span id="epilepsyPercent" ><fmt:formatNumber value="${editMental.epilepsyNum==0?0:(editMental.epilepsyControlNum/editMental.epilepsyNum)*100}" pattern="#,##0.0"/>% </span></td>
	            </tr>
            </tbody>
        </table>
    </form>
</div>

