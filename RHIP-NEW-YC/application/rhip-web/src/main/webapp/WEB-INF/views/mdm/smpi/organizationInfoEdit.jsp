<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants"%>
<c:set var="JK_CODE" value="<%=EHRConstants.JK_CODE%>"/>
<c:set var="WSJ_CODE" value="<%=EHRConstants.WSJ_CODE%>" />

<script src="${pageContext.request.contextPath}/js/views/mdm/organizationArea/organizationInfoEdit.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="backButton"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a href="javascript:void(0)" id="saveButton" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>

</div>
<div class="contentfixed32" style="text-align: left;">
	<form:form id="organizationForm" modelAttribute="organization" >
		<input type="hidden" id="organizationEditFlag" value="${organizationEdit}">
		<div  class="postcontent">
			<%--<fieldset>--%>
				<legend>基本信息:</legend>
				<table class="posttable">
					<colgroup>
						 <col style="width: 20%;">
						 <col style="width: 30%;">
						 <col style="width: 25%;">
						 <col style="width: 25%;">
					</colgroup>
					<tr>
						<th><label class="required" title="自动生成,可以修改">机构顺序序号</label></th>
						<td>
							<tag:numberInput id="sort" name="sort" value="${organization.sort}" cssClass="width30" reg='{"required":"true"}'/>
						</td>
					</tr>
					<tr>
						<th><label class="required">机构编码</label></th>
						<td>
							<c:if test="${empty organization.organCode}">
								<form:input path="organCode" name="organCode"  id="eorganCodeId" reg='{"required":"true","minlength":"9","maxlength":"23"}'  />
								<input type="hidden" id="type" value="add" />
							</c:if>
							<c:if test="${not empty organization.organCode}">
								${organization.organCode}
								<form:hidden path="organCode" id="eorganCodeId"/>
								<input type="hidden" id="type" value="edit" />
							</c:if>
						</td>
						<th><label class="required">机构名称</label></th>
						<td><form:input path="organName" size="40" reg='{"required":"true","maxlength":"33"}'/></td>
					</tr>
					<tr>
						<th><label class="required">机构类别</label></th>
						<td>
							<ehr:authorize ifAnyGranted="01">
								<ehr:dic-list name="genreCode"  id="selectGenreCode" reg='{"required":"true"}' dicmeta="GBT2182002" width="80%;"
											  onchange="organizationInfoEdit.initShowHiddenFields();" code="J100,R11,A100,B100,B200,C,R200,L"
									value="${organization.genreCode}"/>
							</ehr:authorize>
							<ehr:authorize ifNotGranted="01">
								<c:choose>
									<c:when test="${empty organization.organId}">
										<ehr:dic-list name="genreCode"  id="selectGenreCode" reg='{"required":"true"}' dicmeta="GBT2182002" width="80%;"
													  onchange="organizationInfoEdit.initShowHiddenFields();" code="J100,R11,A100,B100,B200,C,R200,L"
									value="${organization.genreCode}"/>
									</c:when>
									<c:otherwise>
										<ehr:dic dicmeta="GBT2182002" code="${organization.genreCode}"/>
										<input value="${organization.genreCode}" type="hidden" name="genreCode"  id="selectGenreCode">
									</c:otherwise>
								</c:choose>
							</ehr:authorize>
						</td>
						<th><label class="required">机构级别</label></th>
						<td>
							<ehr:dic-list name="gradeCode" dicmeta="DM02-02" reg='{"required":"true"}' width="80%;" value="${organization.gradeCode}"/>
						</td>
					</tr>
					<tr id="level_1_tr" style="${organization.gradeCode != 'B1' ? 'display:none;' : ''}">
						<th><label class="required">所在乡镇</label></th>
						<td>
							<ehr:authorize ifAnyGranted="01">
								<ehr:dic-town-village townName="gbCode" townId="gbCodeId" reg='{"required":"true"}' townValue="${organization.gbCode}" width="80%;"/>
							</ehr:authorize>
							<ehr:authorize ifNotGranted="01">
								<c:choose>
									<c:when test="${empty organization.organId}">
										<ehr:dic-town-village townName="gbCode" townId="gbCodeId" reg='{"required":"true"}' townValue="${organization.gbCode}"/>
									</c:when>
									<c:otherwise>
										<ehr:dic dicmeta="FS990001" code="${organization.gbCode}"/>
										<input value="${organization.gbCode}" type="hidden" name="gbCode"  id="gbCodeId">
									</c:otherwise>
								</c:choose>
							</ehr:authorize>

						</td>
					</tr>
					<tr id="level_2_tr">
						<th><label class="required">上级机构</label></th>
						<td>
							<ehr:authorize ifAnyGranted="01">
								<tag:autoSelect name="parentCode" id="eparentCodeIdAdd" codeValue="${organization.parentCode}" reg='{"required":"true"}'></tag:autoSelect>
							</ehr:authorize>
							<ehr:authorize ifNotGranted="01">
								<c:choose>
									<c:when test="${empty organization.organId}">
										<tag:autoSelect name="parentCode" id="eparentCodeIdAdd" codeValue="${organization.parentCode}" reg='{"required":"true"}'></tag:autoSelect>
									</c:when>
									<c:otherwise>
										<ehr:org code="${organization.parentCode}"/>
										<input value="${organization.parentCode}" type="hidden" name="parentCode"  id="eparentCodeIdAdd">
									</c:otherwise>
								</c:choose>
							</ehr:authorize>
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
							<form:select path="manageCode" reg='{"required":"true"}' >
								<form:option value="" label="请选择"/>
								<ehr:dicItems dicmeta="FS10223"  value="${organization.manageCode}" />
							</form:select>
						</td>
						<th><label class="required">经济类型</label></th>
						<td>
							<form:select path="economyCode" reg='{"required":"true"}' >
								<form:option value="" label="请选择"/>
								<ehr:dicItems dicmeta="GBT124022000"  value="${organization.economyCode}" />
							</form:select>
						</td>
					</tr>
					<tr>
						<th><label>注册资金</label></th>
						<td><form:input path="registCapital" reg='{"number":"true","maxlength":"23"}' />万元</td>
						<th><label>成立日期</label></th>
						<td>
							<%-- <tag:dateInput id="startDate" name="startDate"
								reg='{"regex":"date"}' pattern="yyyy/MM/dd"  onlypast="true"
								date="${organization.startDate}"></tag:dateInput> --%>
								
						<input type="text" reg='{"regex":"date"}' class="layui-input x-admin-content-sm-date"  name="startDate" id="startDate" value="<fmt:formatDate value='${organization.startDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />		
						</td>
					</tr>
					<tr>
						<th><label>法人代表</label></th>
						<td><form:input path="artificialPerson" reg='{"maxlength":"16"}' /></td>
						<th><label>法人证件号</label></th>
						<td><form:input path="artificialIdcard" reg='{"maxlength":"23"}' /></td>
					</tr>
					<tr>
						<th><label>单位电话</label></th>
						<td><form:input path="tel" reg='{"phone":"true","maxlength":"18"}' /></td>
						<th><label>法人电话</label></th>
						<td><form:input path="artificialTel" reg='{"phone":"true","maxlength":"18"}' /></td>
					</tr>
					<tr>
						<th><label>邮政编码</label></th>
						<td><form:input path="postCode" reg='{"postCode":"true","maxlength":"18"}' /></td>
						<th><label>地址</label></th>
						<td><form:input path="address" size="40" reg='{"maxlength":"23"}' />
						</td>
					</tr>
					<%--<tr id="level_3_tr">
						<th>所含行政村</th>
						<td>--%>
							<%--<c:if test="${organizationEdit eq 'edit'}">--%>
								<%--<select name="areaCode" id="areaCodeId">--%>
									<%--<c:forEach var="used" items="${useds}">--%>
										<%--<option value="${used.areaCode}" title="${used.itemName}" selected="selected">${used.itemName}</option>--%>
										<%--&lt;%&ndash;修改村委会在机构区划和行政区划，该处值显示用，20140421，刘洋&ndash;%&gt;--%>
									<%--</c:forEach>--%>
								<%--</select>--%>
							<%--</c:if>--%>
							<%--<c:if test="${organizationEdit ne 'edit'}">--%>
								<%--<select name="areaCode" id="areaCodeId" multiple="multiple">--%>
									<%--<c:forEach var="used" items="${useds}">--%>
										<%--<option value="${used.areaCode}" title="${used.itemName}" selected="selected">${used.itemName}</option>--%>
									<%--</c:forEach>--%>
									<%--<c:forEach var="dicItem" items="${noParents}">--%>
										<%--<option value="${dicItem.itemCode}" title="${dicItem.itemName}">${dicItem.itemName}</option>--%>
									<%--</c:forEach>--%>
								<%--</select>--%>
							<%--</c:if>--%>

							<%--<select name="areaCode" id="areaCodeId" multiple="multiple">
								<c:forEach var="used" items="${useds}">
									<option value="${used.areaCode}" title="${used.itemName}" selected="selected">${used.itemName}</option>
								</c:forEach>
								<c:forEach var="dicItem" items="${noParents}">
									<option value="${dicItem.itemCode}" title="${dicItem.itemName}">${dicItem.itemName}</option>
								</c:forEach>
							</select>--%>
						<%--</td>
					</tr>--%>
					<tr>
						<th>组织机构代码</th>
						<td><form:input path="nationalOrganCode" reg='{"maxlength":"9"}'/></td>
					</tr>

					<tr>
						<th>牙椅数</th>
						<td><form:input path="dentalChairCount" reg='{"digits":"true","maxlength":"5"}'/></td>
						<th>电子邮箱</th>
						<td><form:input path="mail" reg='{"email":"true","maxlength":"33"}' /></td>
					</tr>
					<tr>
						<th>男职工数</th>
						<td><form:input path="mnumber"  reg='{"digits":"true","maxlength":"9"}' /></td>
						<th>女职工数</th>
						<td><form:input path="fnumber"  reg='{"digits":"true","maxlength":"9"}' /></td>
					</tr>
					<tr>
						<th>房屋建筑面积</th>
						<td><form:input path="area"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
						<th>业务用房面积</th>
						<td><form:input path="businessArea"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
					</tr>
					<tr>
						<th>核准床位数</th>
						<td><form:input path="bedCount" reg='{"digits":"true","maxlength":"5"}'/></td>
						<th>开放床位数</th>
						<td><form:input path="openBedCount" reg='{"digits":"true","maxlength":"4"}'/></td>
					</tr>

					<tr>
						<th>专业设备数10万以下</th>
						<td><form:input path="equipmentNum" reg='{"digits":"true","maxlength":"4"}'/></td>
						<th>专业设备数10万以上50万以下</th>
						<td><form:input path="equipmentNumOne" reg='{"digits":"true","maxlength":"4"}'/></td>
					</tr>
					<tr>
						<th>专业设备数50万以上</th>
						<td><form:input path="equipmentNumTwo" reg='{"digits":"true","maxlength":"4"}'/></td>
						<th>危房比例</th>
						<td><form:input path="dilapidatedRatio"  reg='{"number":"true","scale":4,"max":100.0000}' />%</td>
					</tr>
					<tr>
						<th>年内施工面积</th>
						<td><form:input path="constructionArea"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
						<th>年内竣工面积</th>
						<td><form:input path="completionArea"  reg='{"number":"true","scale":2,"max":999999.99}' /></td>
					</tr>
				</table>
			<%--</fieldset>--%>
		</div>
	</form:form>
</div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#startDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    
  });
</script>
