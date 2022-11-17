<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<i class="popno">
居民健康卡信息<br/>
</i>
	<fieldset class="layui-elem-field">
		<legend>1、基本信息</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width:150px;width:20%;"/>
				<col style="min-width:80px;width:30%;"/>
				<col style="min-width:80px;width:20%;"/>
				<col style="min-width:80px;width:30%"/>
			</colgroup>
			<tr>
				<th>姓名：</th>
				<td style="text-align: left">${healthCard.name}</td>
				<th>性别：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="GBT226112003" code="${healthCard.gender}"/>
				</td>
			</tr>
			<tr>
				<th>证件类型：</th>
				<td style="text-align: left">
					<ehr:dic dicmeta="PH00034" code="${healthCard.paperType}"/>
				</td>
				<th>证件号码：</th>
				<td style="text-align: left">${healthCard.paperNo}</td>
			</tr>
			<tr>
				<th>旧健康卡号：</th>
				<td style="text-align: left">${healthCard.oldCitizenCardNo}</td>
				<th>新健康卡号：</th>
				<td style="text-align: left">${healthCard.citizenCardNo}</td>
			</tr>
			<tr>
				<th>出生日期：</th>
				<td style="text-align: left">${healthCard.birthday}</td>
				<th>市民卡状态：</th>
				<td style="text-align: left">
					${healthCard.cardStatus=='00'?'正常':healthCard.cardStatus=='01'?'挂失':healthCard.cardStatus=='02'?'冻结':healthCard.cardStatus=='03'?'退卡':healthCard.cardStatus=='04'?'换卡':'补卡'}</td>
			</tr>
			<tr>
				<th>移动电话：</th>
				<td style="text-align: left">${healthCard.phone}</td>
				<th>户籍地址：</th>
				<td style="text-align: left">${healthCard.prAddr}</td>
			</tr>
		</table>
	</fieldset>
	<fieldset class="layui-elem-field">
		<legend>2、其他信息</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width:150px;width:20%;"/>
				<col style="min-width:80px;width:30%;"/>
				<col style="min-width:80px;width:20%;"/>
				<col style="min-width:80px;width:30%"/>
			</colgroup>
			<tr>
				<th>创建时间：</th>
				<td style="text-align: left">${healthCard.createDate}</td>
				<th>创建机构：</th>
				<td style="text-align: left">${healthCard.createOrg}</td>
			</tr>
			<tr>
				<th>创建人：</th>
				<td style="text-align: left">${healthCard.createUser}</td>
				<th>更新时间：</th>
				<td style="text-align: left">${healthCard.updateDate}</td>
			</tr>
			<tr>
				<th>更新机构：</th>
				<td style="text-align: left">${healthCard.updateOrg}</td>
				<th>更新人：</th>
				<td style="text-align: left">${healthCard.updateUser}</td>
			</tr>
		</table>
	</fieldset>
</div>