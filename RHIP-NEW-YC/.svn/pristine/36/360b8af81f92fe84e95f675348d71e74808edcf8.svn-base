<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/fsfhqk/fskwzbzqkEdit.js" type="text/javascript"></script>
<div>
	<div class="postcontent">
		<form method="post" id="radiologicalPostion_form">
			<input name="id" type="hidden" value="${record.id }">
			<input name="isDelete" type="hidden" value="${record.isDelete }">
				<fieldset class="layui-elem-field">
					<legend>放射科位置布置情况</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="18%" />
							<col width="25%" />
						<colgroup>
						<tr>
						    <th><label>警示标识:</label></th>
						    <td><ehr:dic-list name="caution" dicmeta="PH00002" value="${record.caution }"></ehr:dic-list></td>
						</tr>
						<tr>
							<th><label>工作指示灯:</label></th>
							<td><ehr:dic-list name="indicator" dicmeta="PH00002" value="${record.indicator }"></ehr:dic-list></td>
						</tr>
						<tr>
							<th><label>门机联锁装置:</label></th>
							<td><ehr:dic-list name="doorInterlock" dicmeta="PH00002" value="${record.doorInterlock }"></ehr:dic-list></td>
						</tr>
						<tr>
							<th><label>报警仪:</label></th>
							<td><ehr:dic-list name="alarm" dicmeta="PH00002" value="${record.alarm }"></ehr:dic-list></td>
						</tr>
						<tr>
							<th>放射科布置图</th>
							<td style="width: 80px;"><div id="layoutUrl"></div></td>
							<td colspan="2"><span style="color: blue;">附件支持jpeg, jpg, gif, png格式，单个附件请控制在5M之内</span></td>
							<input id="layoutUrl" type="hidden" name="layoutUrl" value="${record.layoutUrl }"/>
						</tr>
						<tr>
							<th>放射科位置图</th>
							<td style="width: 80px;"><div id="localtionUrl"></div></td>
							<td colspan="2"><span style="color: blue;">附件支持jpeg, jpg, gif, png格式，单个附件请控制在5M之内</span></td>
							<input id="localtionUrl" type="hidden" name="localtionUrl" value="${record.localtionUrl }"/>
						</tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:fskwzbzqkEdit.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:fskwzbzqkEdit.cancle()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</div>
	</div>
</div>
