<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants"%>
<c:set var="JK_CODE" value="<%=EHRConstants.JK_CODE%>"/>
<c:set var="WSJ_CODE" value="<%=EHRConstants.WSJ_CODE%>" />
<script src="${pageContext.request.contextPath}/js/views/mdm/organizationArea/organizationInfoEdit.js" type="text/javascript"></script>

<div class="postcontent">
	<div style="padding-left: 15px; padding-right: 15px; padding-top: 10px; width: auto;" class="postdiv">
	  <form id="organizationForm">
	  <input type="hidden" name="oldCode" value="${orgCodesOld}"/>
	  	<table style="width:99%" class="posttable">
	  		<colgroup>
				 <col style="width: 15%;">
                 <col style="width: 85%;">
			</colgroup>
				
	  		<tr>
	  			<th>合并方式</th>
	  			<td>
	  				<c:choose>
	  					<c:when test="${flag == false}">
	  						<ehr:org-type-list name="newCode" code="${orgCodes}" defaultval="Y" onchange="toggleOtherSC('newCode','newCodeDiv','');"/> 
	  					</c:when>
	  					<c:otherwise>
	  						<ehr:org-type-list name="newCode" code="${orgCodes}" firstLabel="新建" onchange="toggleOtherSC('newCode','newCodeDiv','');"/> 
	  					</c:otherwise>
	  				</c:choose>
	  				
	  			</td>
	  		</tr>
	  	</table>
	  	<c:if test="${flag == true}">
		<fieldset id="newCodeDiv">
			<legend>基本信息:</legend>
			<table style="width:99%" class="posttable">
				<colgroup>
					<col style="width: 18%;">
					<col style="width: 32%;">
					<col style="width: 15%;">
					<col style="width: 35%;">
				</colgroup>
				<tr>
					<th><label class="required" title="自动生成,可以修改">机构顺序序号</label></th>
					<td>
						<tag:numberInput id="sort" name="sort" cssClass="width30" reg='{"required":"true"}' value="${organization.sort}"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">机构编码</label></th>
					<td>
						<input type="text" name="organCode" reg='{"required":"true","minlength":"9","maxlength":"23"}'/>
					</td>
					<th><label class="required">机构名称</label></th>
					<td><input type="text" name="organName" reg='{"required":"true","maxlength":"500"}'/></td>
				</tr>
				<tr>
					<th><label class="required">机构类别</label></th>
					<td>
						<ehr:dic-list name="genreCode"  id="selectGenreCode" reg='{"required":"true"}' dicmeta="GBT2182002"
									  onchange="organizationInfoEdit.initShowHiddenFields();" code="${genreCode}" width="80%;"/>
					</td>
					<th><label class="required">机构级别</label></th>
					<td>
						<ehr:dic-list name="gradeCode" dicmeta="DM02-02" reg='{"required":"true"}' width="80%;"/>
					</td>
				</tr>
				<tr id="level_1_tr">
					<th><label class="required">所在乡镇</label></th>
					<td>
						<ehr:dic-town-village townName="gbCode" reg='{"required":"true"}' width="80%;"/>
					</td>
				</tr>
				<tr id="level_2_tr">
					<th><label class="required">上级机构</label></th>
					<td>
						<tag:autoSelect reg="{'required':true}"  name="parentCode" id="eparentCodeIdAdd" codeValue="${organization.parentCode}"></tag:autoSelect>
					</td>
				</tr>
				<tr id="level_4_tr">
					<th><label class="required">上级机构</label></th>
					<td colspan="3">
						<label><input type="checkbox" reg='{"extension":["symptomVali","请至少选择一项"]}' name="parentCodeCentre" id="parentCodeCentreId"
									  value="${JK_CODE}" ${organization.parentCode eq JK_CODE ? 'checked' : ''}/><ehr:org code="${JK_CODE}"/></label>
						<label><input type="checkbox" reg='{"extension":["symptomVali","请至少选择一项"]}' name="parentCodeHealth" id="parentCodeHealthId"
									  value="${WSJ_CODE}" ${organization.parentCodeHealth eq WSJ_CODE ? 'checked' : ''}/><ehr:org code="${WSJ_CODE}"/></label>
					</td>
				</tr>
				<tr>
					<th><label class="required">经营性质</label></th>
					<td>
						<ehr:dic-list name="manageCode" dicmeta="FS10223" reg='{"required":"true"}' width="80%;"/>
					</td>
					<th><label class="required">经济类型</label></th>
					<td>
						<ehr:dic-list name="economyCode" dicmeta="GBT124022000" reg='{"required":"true"}' width="80%;"/>
					</td>
				</tr>
				<tr>
					<th>注册资金</th>
					<td><input type="text" name="registCapital" reg='{"number":"true","maxlength":"23"}'/>万元</td>
					<th>成立日期</th>
					<td>
						<tag:dateInput id="startDate" name="startDate"
									   reg='{"regex":"date"}' pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput>
					</td>
				</tr>
				<tr>
					<th>法人代表</th>
					<td><input type="text" name="artificialPerson" reg='{"maxlength":"16"}' /></td>
					<th>法人证件号</th>
					<td><input type="text" name="artificialIdcard" reg='{"maxlength":"23"}' /></td>
				</tr>
				<tr>
					<th>单位电话</th>
					<td><input type="text" name="tel" reg='{"phone":"true","maxlength":"18"}' /></td>
					<th><label>法人电话</label></th>
					<td><input type="text" name="artificialTel" reg='{"phone":"true","maxlength":"18"}' /></td>
				</tr>
				<tr>
					<th>邮政编码</th>
					<td><input type="text" name="postCode" reg='{"postCode":"true","maxlength":"18"}' /></td>
					<th>地址</th>
					<td><input type="text" name="address" reg='{"maxlength":"23"}' />
					</td>
				</tr>
				<tr>
					<th>组织机构代码</th>
					<td><input type="text"  name="nationalOrganCode" reg='{"maxlength":"50"}'/></td>
				</tr>
				<tr>
					<th>牙椅数</th>
					<td><input type="text" name="dentalChairCount" reg='{"digits":"true","maxlength":"5"}'/></td>
					<th>电子邮箱</th>
					<td><input type="text" name="mail" reg='{"email":"true","maxlength":"33"}' /></td>
				</tr>
				<tr>
					<th>男职工数</th>
					<td><input type="text" name="mnumber" reg='{"digits":"true","maxlength":"9"}' /></td>
					<th>女职工数</th>
					<td><input type="text" name="fnumber" reg='{"digits":"true","maxlength":"9"}' /></td>
				</tr>
				<tr>
					<th>房屋建筑面积</th>
					<td><input type="text"  name="area"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
					<th>业务用房面积</th>
					<td><input type="text"  name="businessArea"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
				</tr>
				<tr>
					<th>核准床位数</th>
					<td><input type="text"  name="bedCount" reg='{"digits":"true","maxlength":"5"}'/></td>
					<th>开放床位数</th>
					<td><input type="text"  name="openBedCount" reg='{"digits":"true","maxlength":"4"}'/></td>
				</tr>

				<tr>
					<th>专业设备数10万以下</th>
					<td><input type="text"  name="equipmentNum" reg='{"digits":"true","maxlength":"4"}'/></td>
					<th>专业设备数10万以上50万以下</th>
					<td><input type="text" name="equipmentNumOne" reg='{"digits":"true","maxlength":"4"}'/></td>
				</tr>
				<tr>
					<th>专业设备数50万以上</th>
					<td><input type="text"  name="equipmentNumTwo" reg='{"digits":"true","maxlength":"4"}'/></td>
					<th>危房比例</th>
					<td><input type="text"  name="dilapidatedRatio"  reg='{"number":"true","scale":4,"max":100.0000}' />%</td>
				</tr>
				<tr>
					<th>年内施工面积</th>
					<td><input type="text"  name="constructionArea"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
					<th>年内竣工面积</th>
					<td><input type="text"  name="completionArea"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
				</tr>
			</table>
		</fieldset>
		</c:if>
		</form>
		<p style="margin-top: 15px;" align="center">
			<input type="button" value="保 存" class="btnopr" onclick="villageAdd.mergeOrganization()"/> 
			<input type="button" value="关 闭" class="btnopr" onclick="villageAdd.closePopUp('mergeDialog')"/>
		</p>
	</div>
</div>
