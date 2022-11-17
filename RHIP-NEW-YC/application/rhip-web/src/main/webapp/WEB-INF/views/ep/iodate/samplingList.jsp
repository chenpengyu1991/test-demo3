<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/samplingList.js"/>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 25%"/>
			<col style="width: 25%"/>
			<col style="width: 25%"/>
			<col style="width: 25%"/>
		</colgroup>
		<thead>
		<tr>
			<th>方向</th>
			<th>抽检乡镇</th>
			<th>抽检年份</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="record" items="${recordList}">
			<tr>
				<td class="centertd"><ehr:dic dicmeta="FS10270" code="${record.position}"/></td>
				<td><ehr:dic dicmeta="FS990001" code="${record.gbCode}"/></td>
				<td class="centertd">${record.samplingYear}</td>
				<td>
					<a href="javascript:void(0);"  onclick="epSamplingList.detail(${record.samplingYear}, ${record.gbCode})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;&nbsp;
					<c:if test="${record.samplingYear eq thisYear}">
						<a href="javascript:void(0);"  onclick="epSamplingSearch.edit('edit',${record.samplingYear}, ${record.gbCode})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;&nbsp;
						<a href="javascript:void(0);"  onclick="epSamplingList.del(this, ${record.samplingYear}, ${record.gbCode})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<ehr:pagination action="epSamplingSearch.search" colspan="4"/>
		</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="epSamplingSearch.search"/>
		</tr>
	</table> --%>
</div>
<div><input type="hidden" id="indexPage" value="${indexPage}"/></div>