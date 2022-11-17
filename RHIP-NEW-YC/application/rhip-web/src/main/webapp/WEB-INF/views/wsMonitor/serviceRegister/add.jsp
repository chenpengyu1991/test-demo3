<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="postcontent">
	<form id="serviceInfoAddForm" name="serviceInfoAddForm" action="" method="post">

		<input type="hidden" name="id" value="${wsServiceInfo.id}">

		<div class="postdiv">
			<table style="width:99%" class="posttable">
				<colgroup>
					<col style="width: 30%;"/>
					<col style="width: 70%;"/>
				</colgroup>
				<tr>
					<th>
						<label class="required">接口名称(KEY)</label>
					</th>
					<td>
						<input type="text" id="webServiceName" name="webServiceName" reg='{"required":"true","maxlength":"50"}' value="${wsServiceInfo.webServiceName}"/>
					</td>
				</tr>
				<tr>
					<th>
						<label class="required">服务器地址</label>
					</th>
					<td>
						<input type="text" id="wsdl" name="wsdl" reg='{"required":"true","maxlength":"100"}' value="${wsServiceInfo.wsdl}"/>
					</td>
				</tr>
				<tr>
					<th>
						<label class="required">服务开关状态</label>
					</th>
					<td>
						<ehr:dic-list id="serverStatus" dicmeta="FS990018" name="serverStatus" reg='{"required":"true"}' value="${empty wsServiceInfo.serverStatus ? '1' : wsServiceInfo.serverStatus}" code="1,0"/>
					</td>
				</tr>
				<tr>
					<th>
						<label>接口描述</label>
					</th>
					<td>
						<textarea id="webServiceDesc" name="webServiceDesc" reg="{'maxlength':200}" rows="3">${wsServiceInfo.webServiceDesc}</textarea>
					</td>
				</tr>
				<tr>
					<th>
						<label>备注</label>
					</th>
					<td>
						<textarea id="remark" name="remark" reg="{'maxlength':200}" rows="3">${wsServiceInfo.remark}</textarea>
					</td>
				</tr>
				</table>
		</div>
	</form>
</div>
