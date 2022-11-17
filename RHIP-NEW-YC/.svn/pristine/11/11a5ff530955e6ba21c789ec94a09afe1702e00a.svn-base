<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script
	src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/views/ehr/child/employees/add.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js//views/ehr/person/list.js"
	type="text/javascript"></script>
<style>

.postcontent {
    padding: 0 2px 10px 2px;
}
</style>
<div id="msgError" class="msgError" style="display: none;"></div>
<div class="Contentbox" >
	<form id="employeesForm" name="employeesForm" method="post"
		class="${contentfixed265}">
		<%-- <input type="hidden" id="flag" name="flag" value="${flag}" />  --%>
		<div class="toolbar">
			<a href="javascript:void(0)" id="cancelBtn"><b class="fanhui">返回</b></a>
			<a class="bc" id="button_print"><b class="baocun">打印</b></a>
		</div>
		<div class="postcontent" id="printDiv" >
			<input type="hidden" value="${employeesHealthCheckList[0].companys}" id="companys0"/>
			<table style="line-height: 8px;text-align: left" >
			<tr>
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[0] ne null ? '' : 'display:none'}" id="healthCard1">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable" >
						<colgroup>
					        	<col style="width: 20%;"/>
					            <col style="width: 25%;"/>
					            <col style="width: 22%;"/>
					            <col style="width: 33%;"/>
					        </colgroup>
					        <tbody>
						<tr>
							<td colspan="4"  align="center"
								
								style="font-size: 15px; font-weight: bold;">银川市从业人员预防性健康体检合格证书 
							</td>
						</tr>
						<%-- <tr>
							<td colspan="4" ><img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" /></td>

						</tr> --%>
						<tr>
							<td colspan="3"><label>姓名:</label><input type="text"  style="width:50px"
								name="name" value="${employeesHealthCheckList[0].name}"/>
								<label>性别:
								<U><ehr:dic code="${employeesHealthCheckList[0].genders}" dicmeta="GBT226112003"/></U>
								</label>
								<label>年龄:</label>
								<U><span>${employeesHealthCheckList[0].age}</span></U>岁
								
								
								
							</td>
							<td rowspan="3" >
							<img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" />
							</td>
						</tr>
						<tr>
							<td colspan="3" ><label>身份证号:</label>
							<input type="text" name="idcard"  value="${employeesHealthCheckList[0].idcard}" style="width:140px"></input>
							</td>
						</tr>
						<tr>
							
							<td colspan="3" >
							<label>单位名称:</label>
							<U>${employeesHealthCheckList[0].companys}</U>
							<%-- <input  type="text" name="companys" value="${employeesHealthCheckList[0].companys}" style="width:140px"/> --%></td>
						</tr>
						<tr>
							<td colspan="2" >
							<label>类别:<input  type="text" value="<ehr:dic code="${employeesHealthCheckList[0].nature}" dicmeta="CHG10600"/>" style="width:100px"/></label>
							</td>
							
							<td colspan="2" >
							<label>体检日期：</label>
							<tag:dateInput id="text_inputDate" style="width:100px"
									name="physicalExaminationDate" onlypast="true" date="${employeesHealthCheckList[0].physicalExaminationDate}"></tag:dateInput>
							</td>
						</tr>
						<tr>
							
							<td colspan="4" align="right">
							
							<label>发证单位:</label>
							<c:choose>
                 <c:when test="${employeesHealthCheckList[0].createOrganCode eq '640104000000'}">
                 		兴庆区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[0].createOrganCode eq '640105000000'}">
                 		西夏区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[0].createOrganCode eq '640106000000'}">
                 		金凤区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[0].createOrganCode eq '640104000000'}">
                 		永宁县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[0].createOrganCode eq '640104000000'}">
                 		贺兰县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[0].createOrganCode eq '640104000000'}">
                 		灵武市卫生管理中心
                 
                 </c:when>
                 <c:otherwise>
                  <ehr:tip><ehr:org code="${employeesHealthCheckList[0].createOrganCode}"/></ehr:tip>
                 </c:otherwise></c:choose></td>
								 
						</tr>
						<tr>
							<td colspan="4"  >
							<div id="healthCardDiv1"
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
						</tbody>	
					</table>
				</fieldset>
			</div>
			
			</td>
			
			
			
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[1] ne null ? '' : 'display:none'}" id="healthCard2">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable" >
						<colgroup>
					        	<col style="width: 20%;"/>
					            <col style="width: 25%;"/>
					            <col style="width: 22%;"/>
					            <col style="width: 33%;"/>
					        </colgroup>
					        <tbody>
						<tr>
							<td colspan="4" align="center"
								
								style="font-size: 15px; font-weight: bold;">银川市从业人员预防性健康体检合格证书 
							</td>
						</tr>
						<%-- <tr>
							<td colspan="4" ><img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" /></td>

						</tr> --%>
						<tr>
							<td colspan="3"  ><label>姓名:</label><input type="text"  style="width:50px"
								name="name" value="${employeesHealthCheckList[1].name}"/>
								<label>性别:
								<U><ehr:dic code="${employeesHealthCheckList[1].genders}" dicmeta="GBT226112003"/></U>
								</label>
								<label>年龄:</label>
								<U><span>${employeesHealthCheckList[1].age}</span></U>岁
								
								
							</td>
							<td rowspan="3"  >
							<img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" />
							</td>
						</tr>
						<tr>
							<td colspan="3" ><label>身份证号:</label>
							<input type="text" name="idcard"  value="${employeesHealthCheckList[1].idcard}" style="width:140px"></input>
							</td>
						</tr>
						<tr>
							
							<td colspan="3" >
							<label>单位名称:</label>
							<U>${employeesHealthCheckList[1].companys}</U></td>
						</tr>
						<tr>
							
							<td colspan="2" >
							<label>类别:<input  type="text" value="<ehr:dic code="${employeesHealthCheckList[1].nature}" dicmeta="CHG10600"/>" style="width:100px"/></label>
							</td>
							
							<td colspan="2" >
							<label>体检日期：</label>
							<tag:dateInput id="text_inputDate" style="width:100px"
									name="physicalExaminationDate" onlypast="true" date="${employeesHealthCheckList[1].physicalExaminationDate}"></tag:dateInput>
							</td>
						</tr>
						<tr>
							
							<td colspan="4" align="right">
							
							<label>发证单位:</label>
							<c:choose>
                 <c:when test="${employeesHealthCheckList[1].createOrganCode eq '640104000000'}">
                 		兴庆区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[1].createOrganCode eq '640105000000'}">
                 		西夏区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[1].createOrganCode eq '640106000000'}">
                 		金凤区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[1].createOrganCode eq '640104000000'}">
                 		永宁县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[1].createOrganCode eq '640104000000'}">
                 		贺兰县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[1].createOrganCode eq '640104000000'}">
                 		灵武市卫生管理中心
                 
                 </c:when>
                 <c:otherwise>
                  <ehr:tip><ehr:org code="${employeesHealthCheckList[1].createOrganCode}"/></ehr:tip>
                 </c:otherwise></c:choose></td>
								 
						</tr>
						<tr>
							<td colspan="4"  >
							<div id="healthCardDiv2"
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
						</tbody>	
					</table>
				</fieldset>
			</div>
			
			</td>
			</tr>
			
			<tr>
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[2] ne null ? '' : 'display:none'}" id="healthCard3">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable" >
						<colgroup>
					        	<col style="width: 20%;"/>
					            <col style="width: 25%;"/>
					            <col style="width: 22%;"/>
					            <col style="width: 33%;"/>
					        </colgroup>
					        <tbody>
						<tr>
							<td colspan="4" align="center"
								
								style="font-size: 15px; font-weight: bold;">银川市从业人员预防性健康体检合格证书 
							</td>
						</tr>
						<%-- <tr>
							<td colspan="4" ><img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" /></td>

						</tr> --%>
						<tr>
							<td colspan="3"  ><label>姓名:</label><input type="text"  style="width:50px"
								name="name" value="${employeesHealthCheckList[2].name}"/>
								<label>性别:
								<U><ehr:dic code="${employeesHealthCheckList[2].genders}" dicmeta="GBT226112003"/></U>
								</label>
								<label>年龄:</label>
								<U><span>${employeesHealthCheckList[2].age}</span></U>岁
								
								
							</td>
							<td rowspan="3"  >
							<img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" />
							</td>
						</tr>
						<tr>
							<td colspan="3" ><label>身份证号:</label>
							<input type="text" name="idcard"  value="${employeesHealthCheckList[2].idcard}" style="width:140px"></input>
							</td>
						</tr>
						<tr>
							
							<td colspan="3" >
							<label>单位名称:</label>
							<U>${employeesHealthCheckList[2].companys}</U></td>
						</tr>
						<tr>
							
							<td colspan="2" >
							<label>类别:<input  type="text" value="<ehr:dic code="${employeesHealthCheckList[2].nature}" dicmeta="CHG10600"/>" style="width:100px"/></label>
							</td>
							
							<td colspan="2" >
							<label>体检日期：</label>
							<tag:dateInput id="text_inputDate" style="width:100px"
									name="physicalExaminationDate" onlypast="true" date="${employeesHealthCheckList[2].physicalExaminationDate}"></tag:dateInput>
							</td>
						</tr>
						<tr>
							
							<td colspan="4" align="right">
							
							<label>发证单位:</label>
							<c:choose>
                 <c:when test="${employeesHealthCheckList[2].createOrganCode eq '640104000000'}">
                 		兴庆区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[2].createOrganCode eq '640105000000'}">
                 		西夏区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[2].createOrganCode eq '640106000000'}">
                 		金凤区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[2].createOrganCode eq '640104000000'}">
                 		永宁县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[2].createOrganCode eq '640104000000'}">
                 		贺兰县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[2].createOrganCode eq '640104000000'}">
                 		灵武市卫生管理中心
                 
                 </c:when>
                 <c:otherwise>
                  <ehr:tip><ehr:org code="${employeesHealthCheckList[2].createOrganCode}"/></ehr:tip>
                 </c:otherwise></c:choose></td>
								 
						</tr>
						<tr>
							<td colspan="4"  >
							<div id="healthCardDiv3"
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
						</tbody>	
					</table>
				</fieldset>
			</div>
			
			</td>
			
			
			
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[3] ne null ? '' : 'display:none'}" id="healthCard4">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable" >
						<colgroup>
					        	<col style="width: 20%;"/>
					            <col style="width: 25%;"/>
					            <col style="width: 22%;"/>
					            <col style="width: 33%;"/>
					        </colgroup>
					        <tbody>
						<tr>
							<td colspan="4" align="center"
								
								style="font-size: 15px; font-weight: bold;">银川市从业人员预防性健康体检合格证书 
							</td>
						</tr>
						<%-- <tr>
							<td colspan="4" ><img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" /></td>

						</tr> --%>
						<tr>
							<td colspan="3"  ><label>姓名:</label><input type="text"  style="width:50px"
								name="name" value="${employeesHealthCheckList[3].name}"/>
								<label>性别:
								<U><ehr:dic code="${employeesHealthCheckList[3].genders}" dicmeta="GBT226112003"/></U>
								</label>
								<label>年龄:</label>
								<U><span>${employeesHealthCheckList[3].age}</span></U>岁
								
								
							</td>
							<td rowspan="3"  >
							<img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" />
							</td>
						</tr>
						<tr>
							<td colspan="3" ><label>身份证号:</label>
							<input type="text" name="idcard"  value="${employeesHealthCheckList[3].idcard}" style="width:140px"></input>
							</td>
						</tr>
						<tr>
							
							<td colspan="3" >
							<label>单位名称:</label>
							<U>${employeesHealthCheckList[3].companys}</U></td>
						</tr>
						<tr>
							
							<td colspan="2" >
							<label>类别:<input  type="text" value="<ehr:dic code="${employeesHealthCheckList[3].nature}" dicmeta="CHG10600"/>" style="width:100px"/></label>
							</td>
							
							<td colspan="2" >
							<label>体检日期：</label>
							<tag:dateInput id="text_inputDate" style="width:100px"
									name="physicalExaminationDate" onlypast="true" date="${employeesHealthCheckList[3].physicalExaminationDate}"></tag:dateInput>
							</td>
						</tr>
						<tr>
							
							<td colspan="4" align="right">
							
							<label>发证单位:</label>
							<c:choose>
                 <c:when test="${employeesHealthCheckList[3].createOrganCode eq '640104000000'}">
                 		兴庆区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[3].createOrganCode eq '640105000000'}">
                 		西夏区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[3].createOrganCode eq '640106000000'}">
                 		金凤区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[3].createOrganCode eq '640104000000'}">
                 		永宁县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[3].createOrganCode eq '640104000000'}">
                 		贺兰县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[3].createOrganCode eq '640104000000'}">
                 		灵武市卫生管理中心
                 
                 </c:when>
                 <c:otherwise>
                  <ehr:tip><ehr:org code="${employeesHealthCheckList[3].createOrganCode}"/></ehr:tip>
                 </c:otherwise></c:choose></td>
								 
						</tr>
						<tr>
							<td colspan="4"  >
							<div id="healthCardDiv4"
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
						</tbody>	
					</table>
				</fieldset>
			</div>
			
			</td>
			</tr>
			
			<tr>
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[4] ne null ? '' : 'display:none'}" id="healthCard5">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable" >
						<colgroup>
					        	<col style="width: 20%;"/>
					            <col style="width: 25%;"/>
					            <col style="width: 22%;"/>
					            <col style="width: 33%;"/>
					        </colgroup>
					        <tbody>
						<tr>
							<td colspan="4" align="center"
								
								style="font-size: 15px; font-weight: bold;">银川市从业人员预防性健康体检合格证书 
							</td>
						</tr>
						<%-- <tr>
							<td colspan="4" ><img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" /></td>

						</tr> --%>
						<tr>
							<td colspan="3"  ><label>姓名:</label><input type="text"  style="width:50px"
								name="name" value="${employeesHealthCheckList[4].name}"/>
								<label>性别:
								<U><ehr:dic code="${employeesHealthCheckList[4].genders}" dicmeta="GBT226112003"/></U>
								</label>
								<label>年龄:</label>
								<U><span>${employeesHealthCheckList[4].age}</span></U>岁
								
								
							</td>
							<td rowspan="3"  >
							<img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" />
							</td>
						</tr>
						<tr>
							<td colspan="3" ><label>身份证号:</label>
							<input type="text" name="idcard"  value="${employeesHealthCheckList[4].idcard}" style="width:140px"></input>
							</td>
						</tr>
						<tr>
							
							<td colspan="3" >
							<label>单位名称:</label>
							<U>${employeesHealthCheckList[4].companys}</U></td>
						</tr>
						<tr>
							
							<td colspan="2" >
							<label>类别:<input  type="text" value="<ehr:dic code="${employeesHealthCheckList[4].nature}" dicmeta="CHG10600"/>" style="width:100px"/></label>
							</td>
							
							<td colspan="2" >
							<label>体检日期：</label>
							<tag:dateInput id="text_inputDate" style="width:100px"
									name="physicalExaminationDate" onlypast="true" date="${employeesHealthCheckList[4].physicalExaminationDate}"></tag:dateInput>
							</td>
						</tr>
						<tr>
							
							<td colspan="4" align="right">
							
							<label>发证单位:</label>
							<c:choose>
                 <c:when test="${employeesHealthCheckList[4].createOrganCode eq '640104000000'}">
                 		兴庆区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[4].createOrganCode eq '640105000000'}">
                 		西夏区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[4].createOrganCode eq '640106000000'}">
                 		金凤区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[4].createOrganCode eq '640104000000'}">
                 		永宁县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[4].createOrganCode eq '640104000000'}">
                 		贺兰县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[4].createOrganCode eq '640104000000'}">
                 		灵武市卫生管理中心
                 
                 </c:when>
                 <c:otherwise>
                  <ehr:tip><ehr:org code="${employeesHealthCheckList[4].createOrganCode}"/></ehr:tip>
                 </c:otherwise></c:choose></td>
								 
						</tr>
						<tr>
							<td colspan="4"  >
							<div id="healthCardDiv5"
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
						</tbody>	
					</table>
				</fieldset>
			</div>
			
			</td>
			
			
			
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[5] ne null ? '' : 'display:none'}" id="healthCard6">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable" >
						<colgroup>
					        	<col style="width: 20%;"/>
					            <col style="width: 25%;"/>
					            <col style="width: 22%;"/>
					            <col style="width: 33%;"/>
					        </colgroup>
					        <tbody>
						<tr>
							<td colspan="4" align="center"
								
								style="font-size: 15px; font-weight: bold;">银川市从业人员预防性健康体检合格证书 
							</td>
						</tr>
						<%-- <tr>
							<td colspan="4" ><img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" /></td>

						</tr> --%>
						<tr>
							<td colspan="3"  ><label>姓名:</label><input type="text"  style="width:50px"
								name="name" value="${employeesHealthCheckList[5].name}"/>
								<label>性别:
								<U><ehr:dic code="${employeesHealthCheckList[5].genders}" dicmeta="GBT226112003"/></U>
								</label>
								<label>年龄:</label>
								<U><span>${employeesHealthCheckList[5].age}</span></U>岁
								
								
							</td>
							<td rowspan="3"  >
							<img
								src="${pageContext.request.contextPath}/images/128.gif"
								style="width: 100px; height: 100px;" />
							</td>
						</tr>
						<tr>
							<td colspan="3" ><label>身份证号:</label>
							<input type="text" name="idcard"  value="${employeesHealthCheckList[5].idcard}" style="width:140px"></input>
							</td>
						</tr>
						<tr>
							
							<td colspan="3" >
							<label>单位名称:</label>
							<U>${employeesHealthCheckList[5].companys}</U></td>
						</tr>
						<tr>
							
							<td colspan="2" >
							<label>类别:<input  type="text" value="<ehr:dic code="${employeesHealthCheckList[5].nature}" dicmeta="CHG10600"/>" style="width:100px"/></label>
							</td>
							
							<td colspan="2" >
							<label>体检日期：</label>
							<tag:dateInput id="text_inputDate" style="width:100px"
									name="physicalExaminationDate" onlypast="true" date="${employeesHealthCheckList[5].physicalExaminationDate}"></tag:dateInput>
							</td>
						</tr>
						<tr>
							
							<td colspan="4" align="right">
							
							<label>发证单位:</label>
							<c:choose>
                 <c:when test="${employeesHealthCheckList[5].createOrganCode eq '640104000000'}">
                 		兴庆区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[5].createOrganCode eq '640105000000'}">
                 		西夏区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[5].createOrganCode eq '640106000000'}">
                 		金凤区卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[5].createOrganCode eq '640104000000'}">
                 		永宁县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[5].createOrganCode eq '640104000000'}">
                 		贺兰县卫生管理中心
                 
                 </c:when>
                  <c:when test="${employeesHealthCheckList[5].createOrganCode eq '640104000000'}">
                 		灵武市卫生管理中心
                 
                 </c:when>
                 <c:otherwise>
                  <ehr:tip><ehr:org code="${employeesHealthCheckList[5].createOrganCode}"/></ehr:tip>
                 </c:otherwise></c:choose></td>
								 
						</tr>
						<tr>
							<td colspan="4"  >
							<div id="healthCardDiv6"
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
						</tbody>	
					</table>
				</fieldset>
			</div>
			
			</td>
			</tr>
			
			
			<tr>
			<td style="vertical-align: top; width: 50%">
			<div style="page-break-after:always;"></div>
			<div class="postcontent" style="${employeesHealthCheckList[1] ne null ? '' : 'display:none'}">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable">
						<tr>
							<td colspan="4" align="center"
								style="font-size: 20px; font-weight: bold;">注意事项 <br /> 
							</td>
						</tr>
						
						<tr>
							<th><label>1：</label></th>
							<td colspan="3">
							从业人员必须持本证方可上岗工作，有效期一年
							</td>
							
							
						</tr>
						
						 <tr>
						 	<th><label>2：</label></th>
							<td colspan="3">
							本证涂改、过期、章迹不清无效
							</td>
							
						</tr> 
							<tr>
						 	
							<th><label>3：</label></th>
							<td colspan="3">本证不得转借，本证限持证本人使用
							</td>
						</tr>
						
						<tr>
							<th ><label>4：</label></th>
							<td colspan="3">
							若毁损或遗失本证，原证作废，持证人应及时申请补办此证
							</td>
						</tr>
						<tr>
							<td colspan="4"  >
							<div
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
					</table>
				</fieldset>
			</div>
			
			</td>
			<td style="vertical-align: top; width: 50%" >
			<div style="page-break-after:always;"></div>
			<div class="postcontent" style="${employeesHealthCheckList[0] ne null ? '' : 'display:none'}" id="healthCard1_1">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable">
						<tr>
							<td colspan="4" align="center"
								style="font-size: 20px; font-weight: bold;">注意事项 <br /> 
							</td>
						</tr>
						<tr>
							<th><label>1：</label></th>
							<td colspan="3">
							从业人员必须持本证方可上岗工作，有效期一年
							</td>
							
							
						</tr>
						
						 <tr>
						 	<th><label>2：</label></th>
							<td colspan="3">
							本证涂改、过期、章迹不清无效
							</td>
							
						</tr> 
							<tr>
						 	
							<th><label>3：</label></th>
							<td colspan="3">本证不得转借，本证限持证本人使用
							</td>
						</tr>
						
						<tr>
							<th ><label>4：</label></th>
							<td colspan="3">
							若毁损或遗失本证，原证作废，持证人应及时申请补办此证
							</td>
						</tr>
						<tr>
							<td colspan="4"  >
							<div
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
					</table>
				</fieldset>
			</div>
			
			</td>
			
			</tr>
			
			<tr>
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[3] ne null ? '' : 'display:none'}">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable">
						<tr>
							<td colspan="4" align="center"
								style="font-size: 20px; font-weight: bold;">注意事项 <br /> 
							</td>
						</tr>
						<tr>
							<th><label>1：</label></th>
							<td colspan="3">
							从业人员必须持本证方可上岗工作，有效期一年
							</td>
							
							
						</tr>
						
						 <tr>
						 	<th><label>2：</label></th>
							<td colspan="3">
							本证涂改、过期、章迹不清无效
							</td>
							
						</tr> 
							<tr>
						 	
							<th><label>3：</label></th>
							<td colspan="3">本证不得转借，本证限持证本人使用
							</td>
						</tr>
						
						<tr>
							<th ><label>4：</label></th>
							<td colspan="3">
							若毁损或遗失本证，原证作废，持证人应及时申请补办此证
							</td>
						</tr>
						<tr>
							<td colspan="4"  >
							<div
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
					</table>
				</fieldset>
			</div>
			
			</td>
			<td style="vertical-align: top; width: 50%" >
			<div class="postcontent" style="${employeesHealthCheckList[2] ne null ? '' : 'display:none'}">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable">
						<tr>
							<td colspan="4" align="center"
								style="font-size: 20px; font-weight: bold;">注意事项 <br /> 
							</td>
						</tr>
						<tr>
							<th><label>1：</label></th>
							<td colspan="3">
							从业人员必须持本证方可上岗工作，有效期一年
							</td>
							
							
						</tr>
						
						 <tr>
						 	<th><label>2：</label></th>
							<td colspan="3">
							本证涂改、过期、章迹不清无效
							</td>
							
						</tr> 
							<tr>
						 	
							<th><label>3：</label></th>
							<td colspan="3">本证不得转借，本证限持证本人使用
							</td>
						</tr>
						
						<tr>
							<th ><label>4：</label></th>
							<td colspan="3">
							若毁损或遗失本证，原证作废，持证人应及时申请补办此证
							</td>
						</tr>
						<tr>
							<td colspan="4"  >
							<div
								
								style="width: 100px; height: 100px;" ></div>
							</td>

						</tr>
					</table>
				</fieldset>
			</div>
			
			</td>
			
			</tr>
			
			<tr>
			<td style="vertical-align: top; width: 50%">
			<div class="postcontent" style="${employeesHealthCheckList[5] ne null ? '' : 'display:none'}">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable">
						<tr>
							<td colspan="4" align="center"
								style="font-size: 20px; font-weight: bold;">注意事项 <br /> 
							</td>
						</tr>
						<tr>
							<th><label>1：</label></th>
							<td colspan="3">
							从业人员必须持本证方可上岗工作，有效期一年
							</td>
							
							
						</tr>
						
						 <tr>
						 	<th><label>2：</label></th>
							<td colspan="3">
							本证涂改、过期、章迹不清无效
							</td>
							
						</tr> 
							<tr>
						 	
							<th><label>3：</label></th>
							<td colspan="3">本证不得转借，本证限持证本人使用
							</td>
						</tr>
						
						<tr>
							<th ><label>4：</label></th>
							<td colspan="3">
							若毁损或遗失本证，原证作废，持证人应及时申请补办此证
							</td>
						</tr>
						<tr>
							<td colspan="4"  style="width: 100px; height: 100px;">
							</td>

						</tr>
					</table>
				</fieldset>
				
			</div>
			
			</td>
			<td style="vertical-align: top; width: 50%" >
			<div class="postcontent"  style="${employeesHealthCheckList[4] ne null ? '' : 'display:none'}">
				<fieldset>
					<legend></legend>
					<br />
					<table style="line-height: 10px;" class="posttable">
						<tr>
							<td colspan="4" align="center"
								style="font-size: 20px; font-weight: bold;">注意事项 <br /> 
							</td>
						</tr>
						<tr>
							<th><label>1：</label></th>
							<td colspan="3">
							从业人员必须持本证方可上岗工作，有效期一年
							</td>
							
							
						</tr>
						
						 <tr>
						 	<th><label>2：</label></th>
							<td colspan="3">
							本证涂改、过期、章迹不清无效
							</td>
							
						</tr> 
							<tr>
						 	
							<th><label>3：</label></th>
							<td colspan="3">本证不得转借，本证限持证本人使用
							</td>
						</tr>
						
						<tr>
							<th ><label>4：</label></th>
							<td colspan="3">
							若毁损或遗失本证，原证作废，持证人应及时申请补办此证
							</td>
						</tr>
						<tr>
							<td colspan="4"  style="width: 100px; height: 100px;">
							</td>

						</tr>
					</table>
				</fieldset>
				
			</div>
			
			</td>
			
			</tr>
			</table>
			

		</div>
	</form>
</div>