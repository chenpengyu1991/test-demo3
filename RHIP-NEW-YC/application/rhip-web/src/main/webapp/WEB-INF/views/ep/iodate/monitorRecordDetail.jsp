<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div>
	<div class="postcontent">
		<form class="postcontent">
			<table class="posttable">
				<tr>
					<td><b>监测日期：</b>
						<fmt:formatDate value="${record.monitorTime}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</table>
			<fieldset class="layui-elem-field">
				<legend>监测记录</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 17%;"/>
						<col style="width: 33%;"/>
						<col style="width: 17%;"/>
						<col style="width: 33%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>永城市</th>
						<td colspan="3">
							<ehr:dic dicmeta="FS990001" code="${record.gbCode}"/>
							<ehr:dic dicmeta="FS990001" code="${record.villageCode}"/>
						</td>
					</tr>
					<tr>
						<th>户主姓名</th>
						<td>${record.name}</td>
						<th>随机号</th>
						<td>${record.randomNumber}</td>
					</tr>
					<tr>
						<th>户主身份证号</th>
						<td>${record.idCard}</td>
						<th>食盐种类</th>
						<td><ehr:dic dicmeta="FS10259" code="${test.saltType}"/></td>
					</tr>
					<tr>
						<th>联系电话</th>
						<td>${record.telephone}</td>
						<th>是否海藻碘盐或强化盐</th>
						<td><ehr:dic dicmeta="FS10246" code="${test.specialSaltStatus}"/></td>
					</tr>
					<tr>
						<th>家中是否有孕妇</th>
						<td><ehr:dic dicmeta="FS10246" code="${record.gravidaStatus}"/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>现场半定量监测</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 17%;"/>
						<col style="width: 83%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>监测结果</th>
						<td><ehr:dic dicmeta="FS10260" code="${test.testResult}"/></td>
					</tr>
					<tr>
						<th>备注</th>
						<td>${test.testRemark}</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>实验室检测记录</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 17%;"/>
						<col style="width: 33%;"/>
						<col style="width: 17%;"/>
						<col style="width: 33%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>实验室</th>
						<td>${test.laboratory}</td>
						<th>该省选定的碘盐含量</th>
						<td>${test.provinceIodineStandard} mg/Kg</td>
					</tr>
					<tr>
						<th>样品原编号</th>
						<td>${test.saltSamplingNumber}</td>
						<th>监测方法</th>
						<td>${test.monitorMethod}</td>
					</tr>
					<tr>
						<th>实验室监测编号</th>
						<td>${test.monitorNumber}</td>
						<th>测定结果</th>
						<td>${test.determinedResult} mg/Kg</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3">${test.labCheckRemark}</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
</div>