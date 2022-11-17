<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div>
<form>
<div class="postcontent">
<c:if test="${surveyType eq 1}">
	<i class="popno">非碘盐用户调查表</i>
</c:if>
<c:if test="${surveyType eq 2}">
	<i class="popno">非碘盐户所在村零售点食用盐调查表</i>
</c:if>
<div class="postdiv">
	<table class="posttable">
		<tr>
			<td><b>调查日期：</b>
				<fmt:formatDate value="${record.monitorTime}" pattern="yyyy/MM/dd"/>
			</td>
		</tr>
	</table>
	<c:if test="${surveyType eq 1}">
		<fieldset class="layui-elem-field">
			<legend>基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<tr>
					<th>地址</th>
					<td colspan="3">
						<ehr:dic dicmeta="FS990001" code="${record.gbCode}"/>
						<ehr:dic dicmeta="FS990001" code="${record.villageCode}"/>
						${record.houseNumber} 组（门牌号）
					</td>
				</tr>
				<tr>
					<th>户主姓名</th>
					<td colspan="3">${record.name}</td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<br/>
		<fieldset class="layui-elem-field">
			<legend>盐样调查及相关知识</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<tr>
					<th>盐样编号</th>
					<td>${record.saltSamplingNumber}</td>
					<th>是否知道碘缺乏病</th>
					<td><ehr:dic dicmeta="FS10276" code="${record.knownIddFlag}"/></td>
				</tr>
				<tr>
					<th>盐样种类</th>
					<td><ehr:dic dicmeta="FS10259" code="${test.saltType}"/></td>
					<th>碘缺乏病是否可预防</th>
					<td><ehr:dic dicmeta="FS10277" code="${record.iddPreventableFlag}"/></td>
				</tr>
				<tr>
					<th>价格</th>
					<td>${test.saltPrice} 元/公斤</td>
					<th>碘缺乏病预防措施</th>
					<td><ehr:dic dicmeta="FS10278" code="${record.premunition}"/></td>
				</tr>
				<tr>
					<th>购盐地方</th>
					<td><ehr:dic dicmeta="FS10262" code="${test.saltSource}"/></td>
					<th>选择食盐的主要因素</th>
					<td><ehr:dic dicmeta="FS10279" code="${record.saltChoiceFactor}"/></td>
				</tr>
				<tr>
					<th>包装</th>
					<td><ehr:dic dicmeta="FS10261" code="${test.saltPackingType}"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</c:if>

	<c:if test="${surveyType eq 2}">
		<fieldset class="layui-elem-field">
			<legend>基本情况</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%"/>
					<col style="width: 80%"/>
				</colgroup>
				<tbody>
				<tr>
					<th>地址：</th>
					<td>
						<ehr:dic dicmeta="FS990001" code="${record.gbCode}"/>
						<ehr:dic dicmeta="FS990001" code="${record.villageCode}"/>
					</td>
				</tr>
				<tr>
					<th>调查商店名称</th>
					<td>${record.name}</td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<br/>
		<fieldset class="layui-elem-field">
			<legend>相关知识及购盐意向</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%"/>
					<col style="width: 80%"/>
				</colgroup>
				<tbody>
				<tr>
					<th>是否知道碘缺乏病</th>
					<td><ehr:dic dicmeta="FS10276" code="${record.knownIddFlag}"/></td>
				</tr>
				<tr>
					<th>碘缺乏病是否可以预防</th>
					<td><ehr:dic dicmeta="FS10277" code="${record.iddPreventableFlag}"/></td>
				</tr>
				<tr>
					<th>碘缺乏病的主要预防措施</th>
					<td><ehr:dic dicmeta="FS10278" code="${record.premunition}"/></td>
				</tr>
				<tr>
					<th>食盐进货的主要决定因素</th>
					<td><ehr:dic dicmeta="FS10279" code="${record.saltChoiceFactor}"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<br/>
		<fieldset class="layui-elem-field">
			<legend>盐样调查</legend>
			<div class="repeattable">
				<table style="width: 90%">
					<colgroup>
						<col style="width: 20%"/>
						<col style="width: 15%"/>
						<col style="width: 15%"/>
						<col style="width: 15%"/>
						<col style="width: 15%"/>
						<col style="width: 10%"/>
					</colgroup>
					<thead>
					<tr>
						<th style="text-align: center">品牌名称</th>
						<th style="text-align: center">食盐种类</th>
						<th style="text-align: center">食盐价格</th>
						<th style="text-align: center">包装</th>
						<th style="text-align: center">来源</th>
						<th style="text-align: center">检测结果</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="salt" items="${saltList}">
						<tr>
							<td>${salt.saltBrand}</td>
							<td><ehr:dic dicmeta="FS10259" code="${salt.saltType}"/></td>
							<td><ehr:dic dicmeta="FS10280" code="${salt.saltPrice}"/></td>
							<td><ehr:dic dicmeta="FS10261" code="${salt.saltPackingType}"/></td>
							<td><ehr:dic dicmeta="FS10262" code="${salt.saltSource}"/></td>
							<td><ehr:dic dicmeta="FS10260" code="${salt.testResult}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
	</c:if>
</div>
</div>
</form>
</div>