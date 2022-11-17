<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
 <jsp:include page="../../layouts/load-js-css-resources.jsp"/>
 <script type="text/javascript">
	layui.use('laydate', function(){
        var laydate = layui.laydate;
		//年月日
		laydate.render({
		  elem: '#dateBegin'
		  ,format: 'yyyy/MM/dd'
		  ,max:0 //今天之后不可选
		});
		laydate.render({
		  elem: '#dateEnd'
		  ,format: 'yyyy/MM/dd'
		  ,max:0 //今天之后不可选
		});
	});
</script>

<script src="${pageContext.request.contextPath}/js/views/he/copy/search.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
		<a href="javascript:void(0)"><button id="heCopyAdd" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form id="heCopySearchForm">
			<table id="heCopySearch">
				<colgroup>
					<col style="min-width: 70px; width: 8%;"/>
					<col style="min-width: 140px; width: 20%;"/>
					<col style="min-width: 70px; width: 10%;"/>
					<col style="min-width: 100px; width: 22%;"/>
					<col style="min-width: 70px; width: 10%;"/>
					<col style="min-width: 160px; width: 20%;"/>
					<col style="width: 100px;"/>
				</colgroup>
				<tbody>
					<tr>
						<td class="col-text">类型</td>
						<td class="col-input"><ehr:dic-list cssClass="x-layui-input" name="type" dicmeta="HE00013"></ehr:dic-list></td>
						<td class="col-text">刊（播）日期</td>
						<td class="col-input">
							<input type="text" class="layui-input x-admin-sm-date"  name="dateBegin" id="dateBegin" style="padding-left: 0px;width: 100px;" /> &nbsp;~&nbsp;
                        	<input type="text" class="layui-input x-admin-sm-date"  name="dateEnd" id="dateEnd" style="padding-left: 0px;width: 100px;" />
						</td>
						<td class="col-text">单位</td>
						<td class="col-input"><ehr:dic-list cssClass="x-layui-input" name="organCode" dicmeta="HE00012"></ehr:dic-list></td>
						<td>
							<button class="layui-btn layui-btn-sm" id="heCopyBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span onclick="heCopySearch.toggle(this,'heCopySearch')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="heCopyResultDiv"></div>
</div>