<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.PrintArea.js"></script>

<script type="text/javascript">

	$(function () {
		$("#back-btn").click(returnSearch);
	});

	function printPrescription() {
		$("#printPrescription").printArea();
   }
	function returnSearch() {
		if (contentChanged) {
			msgUtil.backConfirm(function () {
				returnfunction();
			});
		} else {
			returnfunction();
		}
	}

	function returnfunction() {
		$("#operationDiv").empty();
		$("#mainSearchDiv").show();
		healthEducationPrescriptionSearch.search($("#currentPage").val());
	}

//-->
</script>

<div class="toolbar">
	<a href="javascript:void(0)" id="back-btn"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)" id="healthEducationPrescriptionSaveButton" onclick="printPrescription()"><b
			class="dayin">打印</b></a>
</div>
<div class="postcontent">
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
				</colgroup>
				<tr>
					<th>处方名称</th>
					<td>
						${healthPrescription.name}
					</td>
					<th>创建时间</th>
					<td><fmt:formatDate value="${healthPrescription.createTime}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>标题</th>
					<td>${healthPrescription.title}</td>
					<th>是否发布</th>
					<td><ehr:dic code="${healthPrescription.status}" dicmeta="LH00007"/></td>
				</tr>
				<tr>
					<th>内容摘要</th>
					<td colspan="3">${healthPrescription.content}</td>
				</tr>
			</table>
		</div>
		<div id="printPrescription" style="display: none;">
			<div style="text-align: center;"><h3>${healthPrescription.title}</h3></div>
			<div style="padding: 15px;margin-top: 10px;">
				${healthPrescription.content}
			</div>
		</div>
</div>