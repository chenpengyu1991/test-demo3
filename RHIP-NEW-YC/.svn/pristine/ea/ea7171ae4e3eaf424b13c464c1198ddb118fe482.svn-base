<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <table id="person_record_table">
		<colgroup>
			<col width="10%"/>
			<col width="25%"/>
			<col width="45%"/>
			<col width="10%"/>
			<col width="100px;"/>
		</colgroup>
		<thead>
			<tr>
				<th class="centerth">
					<input type="checkbox" id="checkAllId" name="checkedAll"  onclick="chkAll(this);"/>
				</th>
				<th class="centerth">接口名称(KEY)</th>
				<th class="centerth">服务器地址</th>
				<th class="centerth">服务器开关</th>
				<th class="centerth">接口描述</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach var="wsServiceInfo" items="${wsServiceInfos}" varStatus="status">
				<tr>
					<td class="centertd">
						<input type="checkbox" name="check" ${wsServiceInfo.check == "1"?'checked':''}   value="${wsServiceInfo.id}" onclick="doChk(this);"/>
					</td>
					<td><ehr:tip>${wsServiceInfo.webServiceName}</ehr:tip></td>
					<td><ehr:tip>${wsServiceInfo.wsdl}</ehr:tip></td>
					<td class="centertd"><ehr:dic dicmeta="FS990018" code="${wsServiceInfo.serverStatus}"/></td>
					<td><ehr:tip>${wsServiceInfo.webServiceDesc}</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	<table>
		<tr>
			<ehr:pagination action="serviceRegisterSearch.search" />
		</tr>
	</table>
</div>