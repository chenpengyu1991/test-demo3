<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/views/he/prescription/edit.js" type="text/javascript"></script>

<div>
	<form id="healthEducationPrescriptionForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${healthPrescription.id}">
			<input type="hidden" value="${operatorType}" name="operatorType" id="operatorType">
			<input type="hidden" name="times" value="${healthPrescription.times}">

			<div class="toolbar">
				<a href="javascript:void(0)" id="back-btn"><b class="fanhui">返回</b></a>
				<a href="javascript:void(0);" id="save-btn"><b class="baocun">保存</b></a>
			</div>
			<div class="postdiv">
				<fieldset>
					<legend>基本信息</legend>
					<table class="formtable">
						<tr>
							<th><label class="required">处方名称</label></th>
							<td><input name="name" type="text" reg='{"required":"true","maxlength":"50"}'
									   value="${healthPrescription.name}"/></td>
							<th><label class="required">标题</label></th>
							<td>
								<input name="title" type="text" reg='{"required":"true","maxlength":"50"}'
									   value="${healthPrescription.title}"/>
							</td>
						</tr>
						<tr>
							<th><label class="required">创建时间</label></th>
							<td>
								<tag:dateInput reg='{"required":"true"}' style="width:150px;" name="createTime"
											   id="createTime" date="${healthPrescription.createTime}" onlypast="true"/>
							</td>
							<th>是否发布</th>
							<td><ehr:authorize  ifAnyGranted="03">
									<ehr:dic-radio name="status" dicmeta="LH00007" value="${healthPrescription.status}" disabled="true"/>
								</ehr:authorize>
								<ehr:authorize  ifNotGranted="03">
									<ehr:dic-radio name="status" dicmeta="LH00007" value="${healthPrescription.status}" />
								</ehr:authorize>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div class="postdiv">
				<fieldset>
					<legend>内容摘要</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<tr>
							<td>
								<SCRIPT id="editor" type=text/plain>${healthPrescription.content} </SCRIPT>
								<input type="hidden" name="content" id="content"/>
							</td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>
	</form>
</div>