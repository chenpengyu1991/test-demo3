<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	 表2 访问禽类养殖场所当天信息收集：<a href="javascript:void(0)" id="addEh2List" onclick="hnCase.popEh('2')"><b class="xinz">添加</b></a>
	<!-- <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('3111')"><b class="import">导入</b></a> -->
</div>
<div  class="repeattable">
   <table id="eh2Table">
        <thead>
            <tr>
                <th class="centerth" style="width: 10%">日期</th>
                <th class="centerth" style="width: 15%">此养殖场所养殖的禽类种类</th>
                <th class="centerth" style="width: 20%">访问时此场所有无禽类病死现象</th>
                <th class="centerth" style="width: 25%">是否到过养殖场所中饲养禽类的房间或车间</th>
                <th class="centerth" style="width: 20%">是否直接接触过养殖场所内的禽类</th>
                <th class="centerth" style="width: 80px;">操作</th>
            </tr>
        </thead>
        <c:forEach var="exposureHistorys" items="${caseDto.idmListEhList}" varStatus="status">
         <c:if test="${'2'== exposureHistorys.comments  }">
	        <tr>
	     
	            <td field="attackDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${exposureHistorys.attackDt}"/></ehr:tip></td>          
	            <td field="birdSpeciesStr" reg='{"maxlength":"50"}'><ehr:tip>${exposureHistorys.birdSpeciesStr}</ehr:tip></td>
	            <td field="birdDeathStr"><ehr:tip>${exposureHistorys.birdDeathStr}</ehr:tip></td>
	            <td field="workshopStr" ><ehr:tip>${exposureHistorys.workshopStr}</ehr:tip></td>
	            <td field="contactBirdStr"><ehr:tip>${exposureHistorys.contactBirdStr}</ehr:tip></td> 
	          	 <td field="birdSpeciesOther" style="display:none;">${exposureHistorys.birdSpeciesOther}</td>
	             <td field="birdSpecies" style="display:none;">${exposureHistorys.birdSpecies}</td>           
	             <td field="birdDeath" style="display:none;">${exposureHistorys.birdDeath}</td>              
	             <td field="workshop" style="display:none;">${exposureHistorys.workshop}</td>     
	             <td field="contactBird" style="display:none;">${exposureHistorys.contactBird}</td>
	             <td field="comments" style="display:none;">${exposureHistorys.comments}</td>           
	            <td class="btnsublist" field="btn">
	                <a href="javascript:void(0)" onclick="hnCase.editTr(this, 'ehList','2')">修改</a>&nbsp;
	                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
	            </td>
	            
	        </tr>
	        </c:if>
         </c:forEach>
    </table>
</div>


