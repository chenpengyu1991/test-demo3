<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(function() {
	toggleOtherCK('birdSpecies','birdSpeciesOtherDiv',6);
})
</script>

<div>
	<form iid="addEh2Form" method="get">
		<div>
			<table class="formtable" id="popEh2Table">

				 <tr>
                    <input type="hidden" id="rowIndex" name="rowIndex" value="${rowIndex}"/>
					<th style="width: 35%">病例发病前日期</th>
					<td style="width: 65%"><tag:dateInput name="attackDt" id="attackDt" onlypast="true" date="${idmListEh.attackDt}"
                                       reg='{"required":"true"}'/></td>
				</tr>
				
				<tr>
					<th>此养殖场所养殖的禽类种类</th>
					<td><ehr:dic-checkbox id="birdSpecies" name="birdSpecies" dicmeta="IDM00523" value="${idmListEh.birdSpecies}"
	                                      onchange="toggleOtherCK('birdSpecies','birdSpeciesOtherDiv',6)"/>
                          <span id="birdSpeciesOtherDiv" style="display: none">
   						 	  <input type="text" name="birdSpeciesOther" id="birdSpeciesOther" value="${idmListEh.birdSpeciesOther}"
    									reg='{"maxlength":"50"}' style="width: 150px;"/>
   						  </span>   
	                </td>
				</tr>
				
				<tr>
					<th>访问时此场所有无禽类病死现象</th>
					<td><ehr:dic-radio dicmeta="PH00001" code="1,2,4"  name="birdDeath" value="${idmListEh.birdDeath}"/></td>
				</tr>
				<tr>
					<th>是否到过养殖场所中饲养禽类的房间或车间</th>
					<td><ehr:dic-radio dicmeta="PH00001" code="1,2,4"  name="workshop" value="${idmListEh.workshop}"/></td>
			  </tr>
              <tr>
                    <th>是否直接接触过养殖场所内的禽类</th>
				    <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4"  name="contactBird" value="${idmListEh.contactBird}"/>
				    </td>
              </tr>						
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveExposure" value="添加" onclick="hnCase.addEhList('2')">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editExposure" value="修改" onclick="hnCase.editEhList('2')">
            </c:if>
            <input type="button" id="cancelExposure" value="取消" onclick="caseEdit.closePopUp('eh2Dialog')">
    </div>
</div>