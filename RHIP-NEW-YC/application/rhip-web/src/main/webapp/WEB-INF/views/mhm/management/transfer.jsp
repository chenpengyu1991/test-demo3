<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/transfer.js" type="text/javascript"></script>
<div class="postcontent">
	<form id="transferForm">
		<input type="hidden" id="typeId" value="${type}">
		<div class="postdiv">
			<div class="toolbarsublist">
				<table class="formtable">
					<colgroup>
						<col style="width:15%;"/>
						<col style="width:35%;"/>
						<col style="width:15%;"/>
						<col style="width:35%;"/>						
					</colgroup>					
					<tr>
						<th><label class="required"><span id="transferNameId">迁往社区:</span></label></th>
						<td colspan="3">
							<c:choose>
								<c:when test="${type == '2'}">古里镇湖东村</c:when>
								<c:otherwise>
									<ehr:dic-town-village villageId="pavillage_address" townId="patown_address"
		                            	villageName="pastreet" townName="patownShip"
		                                villageValue=""
		                                townValue="" width="180px;"
		                                reg='{"required":"true"}'/>								
								</c:otherwise>
							</c:choose>

						</td>
					</tr>
					<tr>
						<th>姓名：</th>
						<td>任兰英</td>	
						<th>性别：</th>
						<td>女</td>												
					</tr>
					<tr>
						<th>身份证号码：</th>
						<td>320520194504214420</td>
						<th>婚姻状况：</th>
						<td>已婚</td>						
					</tr>
					<tr>
						<th>家庭电话：</th>
						<td>0512-88888888</td>
						<th>民族：</th>
						<td>汉</td>						
					</tr>	
					<tr>
						<th>监护人姓名：</th>
						<td>任学祥</td>
						<th>经济状况：</th>
						<td>一般</td>						
					</tr>	
					<tr>
						<th>家庭地址：</th>
						<td colspan="3">江苏省某市虞山镇永红村1-12组</td>
					</tr>	
					<tr>
						<th>户籍地址：</th>
						<td colspan="3">江苏省某市虞山镇永红村1-12组</td>
					</tr>
					<tr>
						<th>迁出时间：</th>
						<td colspan="3">
							<tag:dateInput nullToToday="true" id="ihaDtId" name="labExamine.ihaDt" style="width: 100px;"
                    			reg='{"regex":"date"}'  pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput>
						</td>
					</tr>	
					<tr>
						<th>迁出原因：</th>
						<td colspan="3">
							<input type="text" id="age" name="generalCondition.age" value="" 
		           				style="width: 98%;" reg='{"maxlength":"100"}'/>
						</td>
					</tr>	
					<tr>
						<th>备注：</th>
						<td colspan="3">
							<textarea name="otherCondition.comments" style="width: 98%" rows=5  reg='{"maxlength":"1000"}'></textarea>
						</td>
					</tr>																																						
				</table>
			</div>
		</div>	
	</form>
	<br>
	<div class="toolbarpop">
		<input type="button" id="transferBtn" name="transfer" value="迁移" onclick="transfer.save()">
		<input type="button" id="cancelTransferBtn" name="cancelDis" value="取消" onclick="mhmCommon.closePopUp('transferDialog')">
	</div>
</div>