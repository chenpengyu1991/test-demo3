<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/physicianDrug/search.js" type="text/javascript"></script>
<div class="section" id="top_all">
	<div class="toolbar">
		<div class="x-nav">
		<span class="layui-breadcrumb">
			<a href="javascript:void(0)">综合管理</a>
			<a href="javascript:void(0)">药品电子监管</a>
			<a><cite>医师用药</cite></a>
		</span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="physicianDrugSearchForm">
                <table id="physicianDrugSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 25%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 45%;"/>
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">药品通用名</td>
							<td class="col-input">
                            	<input type="text" name="drugGenericName" />
                            </td>
                            <td class="coltext"><label class="required">费用类型</label></td>
							<td class="col-input">
								<input type="radio" id="outpatient" name="patientType"  class="radioGroup" value="1" checked="checked" /><label for="outpatient">门急诊</label>
								<input type="radio" id="inpatient" name="patientType"  class="radioGroup" value="2" /><label for="inpatient">住院</label>								
                            </td>  
						</tr>
						<tr>
							<td class="coltext"><label class="required">监控期间</label></td>
							<td class="colinput">
								<input type="text" class="layui-input x-admin-sm-date" name="prescribeDateBegin" id="prescribeDateBegin" value="<fmt:formatDate value="${firstDate}" pattern="yyyy/MM/dd"/>" reg='{"required":"true"}' style="padding-left: 0px;width: 38%;" /> ~
								<input type="text" class="layui-input x-admin-sm-date" name="prescribeDateEnd" id="prescribeDateEnd" value="<fmt:formatDate value="${lastDate}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;width: 38%;" />
							</td>
							<td class="coltext"><label class="required">所属机构</label></td>
                            <td class="colinput" >
                            	<tag:autoSelect name="hospitalCode" id="hospitalCode" codeValue="${hospitalCode}" style="width:200px" reg='{"required":"true"}'></tag:autoSelect>
                            </td>														
						</tr>
						<tr>
							<td align="right" colspan="4">
								<button class="layui-btn layui-btn-sm" id="physicianBtnSearch"><i class="layui-icon"></i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'physicianDrugSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="physicianDrugResultDiv"><jsp:include page="list.jsp"/></div>
</div>
<div id="physicianDrugDetailDiv"></div>
<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;
		laydate.render({
			elem: '#prescribeDateBegin'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});

		laydate.render({
			elem: '#prescribeDateEnd'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
	});

</script>
