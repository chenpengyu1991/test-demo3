<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/infectDetailAdd.js" type="text/javascript"/>
<input type="hidden" id="detailOperation" value="${operation}"/>
<form id="editInfectDetailForm" class="postcontent">
	<div class="postdiv">
		<table class="posttable">
			<input type="hidden" name="id" value="${detail.id}"/>
			<input type="hidden" name="monitorId" value="${detail.monitorId}"/>
			<input type="hidden" name="createBy" value="${detail.createBy}"/>
			<tag:dateInput name="createTime" date="${detail.createTime}" style="display:none"/>
			<colgroup>
				<col style="width: 30%"/>
				<col style="width: 70%"/>
			</colgroup>
			<tbody>
			<tr style="border-bottom:1px solid #A9C3D0">
				<th><label <c:if test="${operation eq 'edit'}">class="required"</c:if>>科室</label></th>
				<td><input type="text" name="deptName" value="${detail.deptName}" style="width: 150px" reg="{'required':'true','maxlength':40}"/></td>
			</tr>
			<tr style="border-bottom:1px solid #A9C3D0">
				<th><label <c:if test="${operation eq 'edit'}">class="required"</c:if>>抽查病例数</label></th>
				<td><tag:numberInput name="spotCheckNum" value="${detail.spotCheckNum}" style="width: 100px" reg="{'required':'true','maxlength':4}"/></td>
			</tr>
			<tr style="border-bottom:1px solid #A9C3D0">
				<th>感染部位及例数</th>
				<td>
					<table id="infectionPart" style="width: 220px">
						<tr>
							<td>呼吸系统：</td>
							<td><tag:numberInput name="breathingSys" value="${detail.breathingSys}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>心血管系统：</td>
							<td><tag:numberInput name="cardiovascularSys" value="${detail.cardiovascularSys}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>泌尿系统：</td>
							<td><tag:numberInput name="urinarySys" value="${detail.urinarySys}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>消化系统和腹部：</td>
							<td><tag:numberInput name="digestiveSysAbdomen" value="${detail.digestiveSysAbdomen}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>血液系统：</td>
							<td><tag:numberInput name="bloodSys" value="${detail.bloodSys}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>中枢神经系统：</td>
							<td><tag:numberInput name="cns" value="${detail.cns}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>皮肤与软组织：</td>
							<td><tag:numberInput name="skinSofttisstle" value="${detail.skinSofttisstle}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>生殖道：</td>
							<td><tag:numberInput name="rti" value="${detail.rti}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>手术部位：</td>
							<td><tag:numberInput name="ssi" value="${detail.ssi}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>口腔：</td>
							<td><tag:numberInput name="oral" value="${detail.oral}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>骨和关节：</td>
							<td><tag:numberInput name="boneJoint" value="${detail.boneJoint}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr style="border-bottom:1px solid #A9C3D0">
							<td>其他部位：</td>
							<td><tag:numberInput name="otherParts" value="${detail.otherParts}" style="width: 50px" reg="{'maxlength':4}"/></td>
						</tr>
						<tr>
							<td>合计：</td>
							<td><tag:numberInput name="total" value="${detail.total}" style="width: 50px" reg="{'maxlength':6}"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr style="border-bottom:1px solid #A9C3D0">
				<th>备注</th>
				<td><input type="text" name="remarks" value="${detail.remarks}" reg="{'maxlength':40}"/></td>
			</tr>
			</tbody>
		</table>
		<br/>
		<c:if test="${operation eq 'edit'}">
			<div style="text-align: center"><input type="button" id="saveDetail" value="保 存" class="btnopr button"/></div>
		</c:if>
	</div>
</form>