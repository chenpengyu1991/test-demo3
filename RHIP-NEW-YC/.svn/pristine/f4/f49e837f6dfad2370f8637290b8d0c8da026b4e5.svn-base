<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	 表4 接触H7N9禽流感病例/发热病人信息收集：<a href="javascript:void(0)" id="addEh4List" onclick="hnCase.popEh('4')"><b class="xinz">添加</b></a>
	<!-- <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('3111')"><b class="import">导入</b></a> -->
</div>
<div  class="repeattable">
   <table id="eh4Table">
        <thead>
            <tr>
                <th class="centerth" style="width: 15%">日期</th>
                <th class="centerth" style="width: 20%">接触病例/发热病人类型</th>
                <th class="centerth" style="width: 20%">接触方式（可多选）</th>
                <th class="centerth" style="width: 20%">防护措施（可多选）</th>
                <th class="centerth" style="width: 10%">接触时长（小时）</th>              
                <th class="centerth" style="width: 85px;">操作</th>
            </tr>
        </thead>
        <c:forEach var="exposureHistorys" items="${caseDto.idmListEhList}" varStatus="status">
	         <c:if test="${'4'== exposureHistorys.comments  }">
		        <tr>
		        	<td field="attackDt" ><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${exposureHistorys.attackDt}"/></ehr:tip></td>
		            <td field="patientTypeStr"><ehr:tip>${exposureHistorys.patientTypeStr}</ehr:tip></td>
		            <td field="contactWayStr"><ehr:tip>${exposureHistorys.contactWayStr}</ehr:tip></td>
		            <td field="protectWayStr"><ehr:tip>${exposureHistorys.protectWayStr}</ehr:tip></td>
		            <td field="contactTime"><ehr:tip>${exposureHistorys.contactTime}</ehr:tip></td>    
		             <td field="patientType"  style="display:none;">'+patientObj.patientType+'</td>
		             <td field="contactWayOther" style="display:none;">${exposureHistorys.contactWayOther}</td>  
		             <td field="contactWay" style="display:none;">${exposureHistorys.contactWay}</td>          
		             <td field="protectWay" style="display:none;">${exposureHistorys.protectWay}</td>
		             <td field="comments" style="display:none;">4</td>      
		            <td class="btnsublist" field="btn">
		                <a href="javascript:void(0)" onclick="hnCase.editTr(this, 'ehList','4')">修改</a>&nbsp;
		                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
		            </td>
		        </tr>
		     </c:if>
         </c:forEach>
    </table>
</div>


