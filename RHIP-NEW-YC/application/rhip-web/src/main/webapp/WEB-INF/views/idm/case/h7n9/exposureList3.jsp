<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	 表3 访问有活禽摊位的菜市场当天信息收集：<a href="javascript:void(0)" id="addEh3List" onclick="hnCase.popEh('3')"><b class="xinz">添加</b></a>
	<!-- <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('3111')"><b class="import">导入</b></a> -->
</div>
<div  class="repeattable">
   <table id="eh3Table">
        <thead>
            <tr>
                <th class="centerth" style="width: 10%">日期</th>
                <th class="centerth" style="width: 15%">是否到过</th>
                <th class="centerth" style="width: 20%">是否经过有活禽摊位的通道</th>
                <th class="centerth" style="width: 20%">是否到过活禽摊位1米之内的范围</th>
                <th class="centerth" style="width: 20%">是否直接接触活禽摊位的活禽</th>
                <th class="centerth" style="width: 10%">次数</th>             
                <th class="centerth" style="width: 80px;">操作</th>
            </tr>
        </thead>
        <c:forEach var="exposureHistorys" items="${caseDto.idmListEhList}" varStatus="status">
         <c:if test="${'3'== exposureHistorys.comments  }">
	        <tr>
	        
         		<td field="attackDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${exposureHistorys.attackDt}"/></ehr:tip></td>
	            <td field="toMarketStr"><ehr:tip>${exposureHistorys.toMarketStr}</ehr:tip></td>
	            <td field="passagewayStr"><ehr:tip>${exposureHistorys.passagewayStr}</ehr:tip></td>
	            <td field="nearMarketStr"><ehr:tip>${exposureHistorys.nearMarketStr}</ehr:tip></td>
	            <td field="contactMarketStr"><ehr:tip>${exposureHistorys.contactMarketStr}</ehr:tip></td>
	             <td field="visitNum"><ehr:tip>${exposureHistorys.visitNum}</ehr:tip></td>
	             <td field="toMarket"  style="display:none;">${exposureHistorys.toMarket}</td>    
	             <td field="passageway" style="display:none;">${exposureHistorys.passageway}</td>  
	             <td field="nearMarket" style="display:none;">${exposureHistorys.nearMarket}</td> 
	             <td field="contactMarket" style="display:none;">${exposureHistorys.contactMarket}</td>
	             <td field="comments" style="display:none;">3</td>
	            <td class="btnsublist" field="btn">
	                <a href="javascript:void(0)" onclick="hnCase.editTr(this, 'ehList','3')">修改</a>&nbsp;
	                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
	            </td>
	        </tr>
        </c:if>
         </c:forEach>
    </table>
</div>


