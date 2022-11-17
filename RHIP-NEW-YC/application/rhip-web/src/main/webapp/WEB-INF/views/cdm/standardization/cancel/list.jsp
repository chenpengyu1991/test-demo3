<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/cancel/list.js" type="text/javascript"></script>

<div class="section" id="cdm-manage-list-box">
	<div class="toolbar">
		<div class="x-nav">
	      <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">慢病健康管理</a>
	        <a href="javascript:void(0)">慢病规范化管理</a>
	        <a>
	          <cite>撤销查看</cite></a>
	      </span>
    </div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form method="post" id="form_search">
			<table id="health-card-search-table">
				<colgroup>
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 23%">
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 23%">
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 24%">
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input" /></td>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput id="idcard" name="idcard" style="ime-mode:Disabled;" cssClass="x-layui-input"></tag:idcardInput>
							<input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
						</td>
						<td class="coltext">患病类型</td>
						<td class="colinput" >
							<div class="layui-form">
								<ehr:dic-list width="156px" type="true" id="disTypeSelect" name="diseaseType" dicmeta="DMD00004" cssClass="x-layui-input"/>
							</div>
						</td>
						<%--<td class="colinput"><ehr:dic-list width="156px" type="true" id="disTypeSelect" name="diseaseType" dicmeta="DMD00004" cssClass="x-layui-input"/></td>--%>
					</tr>
					<tr>
						<td class="coltext">年龄段</td>
						<td class="colinput"><tag:numberInput maxlength="3" id="startAge" name="startAge" style="width:35%" cssClass="x-layui-input"></tag:numberInput> ~ <tag:numberInput
								maxlength="3" id="endAge" name="endAge" style="width:35%" cssClass="x-layui-input"
							></tag:numberInput>岁</td>
						<td class="coltext">性别</td>
						<td class="colinput"><ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode" cssClass="x-layui-input" /></td>
						<td class="coltext">状态</td>
						<td align="left">
						<label><input type="radio" name="deleteOrCancel" checked="checked" value="1">结案</label>
						<label><input type="radio" name="deleteOrCancel" value="2">已撤销</label></td>
					</tr>
					<tr class="advanceSearchSection" style="display: none;">
						<td class="coltext">
						 <ehr:authorize ifAnyGranted="0107,01,0207">
						 管理机构
							</ehr:authorize> 
						</td>
						<td colspan="3">
						    <ehr:authorize ifAnyGranted="0107,01">
								<ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode" townName="gbcode" isShowOneself="true" width="27.5%;" cssClass="x-layui-input"/>
							</ehr:authorize> 
							
							<ehr:authorize ifAnyGranted="0207">
								<ehr:dic-org-list id="nowAddressCode" name="stationOrganCode" isShowOneself="true" width="27.5%;" cssClass="x-layui-input"/>
							</ehr:authorize></td>
						<td class="coltext"></td>
					</tr>
					<tr>
						<td class="righttd" colspan="6">
							<%-- <input type="button" id="per_search_btn" value="查询" onclick="" class="search_btn" /> --%>
							<button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
							<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span id="health-card-search-toggle-btn" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="diseaseInfo" class="repeattable"></div>
</div>
<div id="cdm-manage-input-box"></div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
    });
    layui.config({
        base: layui.cache.dir+'lay/modules/',  //实际的multiSelect.JS文件位置,也可以用<script>引入
    });
    layui.use(['multiSelect'],function() {
        var $ = layui.jquery,form = layui.form,multiSelect = layui.multiSelect;
        $('#get-val').click(function() {
            var vals = [],
                texts = [];
            $('select[multiple] option:selected').each(function() {
                vals.push($(this).val());
                texts.push($(this).text());
            })
            console.dir(vals);
            console.dir(texts);
        })
        form.on('select(test)',function(data){
            console.dir(data);
        });
    });


</script>
