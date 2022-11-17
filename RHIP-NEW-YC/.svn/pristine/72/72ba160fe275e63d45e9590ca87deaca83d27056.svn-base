<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(function() {
	 toggleOtherCK('birdSpecies','birdSpeciesOtherDiv',6);
	 toggleOtherCK('contactWay','contactWayOtherDiv',13);
	 toggleOtherCK('protectWay','protectWayOtherDiv',7);
})
</script>
<div>
	<form id="addEh1Form" method="get">
		<div>
			<table class="formtable" id="popEh1Table">

				 <tr>
                    <input type="hidden" id="rowIndex" name="rowIndex" value="${rowIndex}"/>
					<th style="width: 35%">病例发病前日期</th>
					<td style="width: 65%"><tag:dateInput name="attackDt" id="attackDt" onlypast="true" date="${idmListEh.attackDt}"
                                       reg='{"required":"true"}'/></td>
				</tr>
				<tr>
					<th>接触禽的状态</th>
					<td><ehr:dic-radio id= "birdState"  name="birdState" dicmeta="IDM00531" value="${idmListEh.birdState}"/>
                    </td>
				</tr>
				<tr>
					<th>接触禽的种类（可多选）</th>
					<td><ehr:dic-checkbox id="birdSpecies" name="birdSpecies" dicmeta="IDM00523" value="${idmListEh.birdSpecies}"
	                                      onchange="toggleOtherCK('birdSpecies','birdSpeciesOtherDiv',6)"/>
                          <span id="birdSpeciesOtherDiv" style="display: none">
   						 	  <input type="text" name="birdSpeciesOther" id="birdSpeciesOther" value="${idmListEh.birdSpeciesOther}"
    									reg='{"maxlength":"50"}' style="width: 150px;"/>
   						  </span>   
	                </td>
				</tr>
				<tr>
					<th>接触方式（可多选）</th>
					<td><ehr:dic-checkbox name="contactWay" dicmeta="IDM00526" value="${idmListEh.contactWay}"
	                                    										onchange="toggleOtherCK('contactWay','contactWayOtherDiv',13)"		/>
						<span id="contactWayOtherDiv" style="display: none">
  						 	<input type="text" name="contactWayOther" id="contactWayOther"  value="${idmListEh.contactWayOther}"
   									reg='{"maxlength":"100"}' style="width: 150px;"/>
  						 </span>
				</tr>
				<tr>
					<th>接触禽类时，手部伤口情况（可多选）</th>
					<td><ehr:dic-checkbox dicmeta="IDM00527"  name="handState" value="${idmListEh.handState}"
			                       										 	/></td>
			  </tr>
              <tr>
                  <th>接触禽类时采取防护措施是（可多选）：</th>
                  <td><ehr:dic-checkbox dicmeta="IDM00529" code="1,2,3,4,5,6,8,9,7" name="protectWay" value="${idmListEh.protectWay}"
   								onchange="toggleOtherCK('protectWay','protectWayOtherDiv',7)"/>
   								<span id="protectWayOtherDiv" style="display: none">
            						 	<input type="text" name="protectWayOther" id="protectWayOther" value="${idmListEh.protectWayOther}"
             									reg='{"maxlength":"100"}' style="width: 150px;"/>
            						 </span>
            						 </td>
              </tr>						
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveExposure" value="添加" onclick="hnCase.addEhList('1')">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editExposure" value="修改" onclick="hnCase.editEhList('1')">
            </c:if>
            <input type="button" id="cancelExposure" value="取消" onclick="caseEdit.closePopUp('eh1Dialog')">
    </div>
</div>