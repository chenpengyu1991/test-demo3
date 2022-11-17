<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	表1 接触禽类当天信息收集：<a href="javascript:void(0)" id="addEh1List" onclick="hnCase.popEh('1')"><b class="xinz">添加</b></a>
	<!-- <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('3111')"><b class="import">导入</b></a> -->
</div>
<div  class="repeattable">
   <table id="eh1Table">
        <thead>
            <tr>
                <th class="centerth" style="width: 8%">病例发病前日期</th>
                <th class="centerth" style="width: 8%">接触禽的状态</th>
                <th class="centerth" style="width: 15%">接触禽的种类（可多选）</th>
                <th class="centerth" style="width: 10%">接触方式（可多选）</th>
                <th class="centerth" style="width: 18%">接触时手部伤口情况（可多选）</th>
                <th class="centerth" style="width: 18%">接触禽类时的防护措施（可多选）</th>
                <th class="centerth" style="width: 80px;">操作</th>
            </tr>
        </thead>
        <c:forEach var="exposureHistorys" items="${caseDto.idmListEhList}" varStatus="status">
	       	<c:if test="${'1'== exposureHistorys.comments  }">
	       
		        <tr>
		            <td field="attackDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${exposureHistorys.attackDt}"/></ehr:tip></td>
		            <td field="birdStateStr"><ehr:tip>${exposureHistorys.birdStateStr}</ehr:tip></td>
		            <td field="birdSpeciesStr"><ehr:tip>${exposureHistorys.birdSpeciesStr}</ehr:tip></td>
		            <td field="contactWayStr"><ehr:tip>${exposureHistorys.contactWayStr}</ehr:tip></td>
		            <td field="handStateStr"><ehr:tip>${exposureHistorys.handStateStr}</ehr:tip></td>
		            <td field="protectWayStr"><ehr:tip>${exposureHistorys.protectWayStr}</ehr:tip></td>
		            <td field="birdState" style="display:none;">${exposureHistorys.birdState}</td>
		           	<td field="birdSpeciesOther" style="display:none;">${exposureHistorys.birdSpeciesOther}</td>
		            <td field="birdSpecies" style="display:none;">${exposureHistorys.birdSpecies}</td>
		            <td field="contactWayOther" style="display:none;">${exposureHistorys.contactWayOther}</td>  
		            <td field="handState" style="display:none;">${exposureHistorys.handState}</td>
		            <td field="protectWay" style="display:none;">${exposureHistorys.protectWay}</td>
		            <td field="protectWayOther" style="display:none;">${exposureHistorys.protectWayOther}</td>
		            <td field="comments" style="display:none;">${exposureHistorys.comments}</td>
		            <td class="btnsublist" field="btn">
		                <a href="javascript:void(0)" onclick="hnCase.editTr(this, 'ehList','1')">修改</a>&nbsp;
		                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
		            </td>
		        </tr>
		        </c:if>	  
         </c:forEach>
    </table>
</div>


