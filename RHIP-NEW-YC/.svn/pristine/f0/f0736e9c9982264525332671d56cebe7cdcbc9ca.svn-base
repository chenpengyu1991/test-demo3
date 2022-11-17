<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"/>
<script src="${pageContext.request.contextPath}/js/views/mdm/pmpi/mdmPerson.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

		personSearch.atStart();
		layui.use('laydate', function(){
	        var laydate = layui.laydate;
			laydate.render({
			  elem: '#birthday'
			  ,format: 'yyyy/MM/dd'
			  ,max:0 //今天之后不可选
			});
		});
	});
</script>
<div class="section">	
	<div id="search">
		<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">居民信息</a>
		        <a>
		          <cite>个人信息</cite></a>
		      </span>
			</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form method="post" action="${ctx}/person/getBestRecord" id="searchCondition" name="searchCondition">
				<table id="searchTable">
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
					</colgroup>
					<tbody>
					<tr>
						<td class="coltext" style="width:100px">姓名</td>
						<td class="colinput"><input name="name" type="text" style="width: 50%"/>
							<input name="useCpy" type="checkbox" value="cpy"/>拟音&nbsp;
							<input name="useLike" type="checkbox" value="like"/>模糊
						</td>
						<td class="coltext" style="width:100px">性别</td>
						<td class="colinput">
							<select name="gender" class="select" style="width:170">
								<option value=""/>
								<ehr:dicItems dicmeta="GBT226112003"/>
							</select>
						</td>
						<td class="coltext" style="width:100px">出生日期</td>
						<td class="colinput"><input id="birthday" name="birthday" type="text" maxlength="10" readonly="true"/></td>
						<td/>
					</tr>
					<tr>
						<td class="coltext" style="width:100px">本人电话</td>
						<td class="colinput"><input name="phoneNumber" type="text" /></td>
						<td class="coltext" style="width:100px">证件类型</td>
						<td class="colinput">
							<select id="idCardSelect" name="idCardType" class="select" style="width:170">
								<option value="" label="" />
								<ehr:dicItems dicmeta="CV0201101" />
							</select>
						</td>
						<td class="coltext" style="width:100px">证件号码</td>
						<td class="colinput"><input id="idCardInput" name="idCardNo" type="text" maxlength="18"/></td>
						<td/>
					</tr>
					<tr class="advanceSearchSection" style="display: none;">
						<td class="coltext" style="width:100px">个人主索引</td>
						<td class="colinput"><input name="pmpiId" type="text" /></td>
						<td class="coltext" style="width:100px">域ID</td>
						<td class="colinput"><input name="domainId" type="text" style="width:170"/></td>
						<td class="coltext" style="width:100px">系统本地ID</td>
						<td class="colinput"><input name="localId" type="text" /></td>
					</tr>
					<tr>
						<td colspan="7" class="righttd">
							<button class="layui-btn layui-btn-sm" id="searchButton"><i class="layui-icon">&#xe615;</i>查询</button>
							<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" >&#x60010;高级</button>
						</td>
					</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="toolbarSection">
		<%--<div style="text-align: left"><b>患者信息查询</b></div>--%>
		<a href="javascript:void(0)"><button id="mergeBtn" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>合并</button></a>
		<a href="javascript:void(0)"><button id="splitBtn" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe623;</i>拆分</button></a>
	</div>
	<div id="personList" class="listDiv">
		<div id="resultDiv"></div>
	</div>
</div>