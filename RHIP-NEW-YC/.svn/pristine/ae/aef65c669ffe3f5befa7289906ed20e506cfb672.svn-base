<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/index/main.css"/>
<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/emr/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/emr/hrCommon.js" type="text/javascript"></script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">医疗服务</a>
		        <a>
		          <cite>
		          <c:if test="${type eq 'prescription'}">
		          	处方查询
		          </c:if>
		           <c:if test="${type eq 'inspect'}">
		          	检查查询
		          </c:if>
		          <c:if test="${type eq 'exam'}">
		          	检验查询
		          </c:if>
		           <c:if test="${type eq 'beHospital'}">
		          	入院记录
		          </c:if>
		          <c:if test="${type eq 'leaveHospital'}">
		          	出院小结
		          </c:if>
		          <c:if test="${type eq 'case'}">
		          	病案首页
		          </c:if>
		          </cite></a>
		      </span>
		</div>
    </div>

<div class="section">
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="emrPageIndex" value="${pageIndex}">
		<input type="hidden" id="queryPath" value="${queryPath}">
		<form id="emrSearchForm">
			<table id="emrSearch">
				<colgroup>
                	<col style="width: 8%; min-width: 80px;"/>
                    <col style="width: 25%; min-width: 200px;"/>
                    <col style="width: 8%; min-width: 80px;"/>
					<col style="width: 20%; min-width: 150px;"/>
					<col style="width: 7%; min-width: 70px;"/>
					<col style="width: 18%; min-width: 100px;"/>
                    <col/>
				</colgroup>
				<tbody>
					<tr>
                    	<td class="col-text">机构</td>
						<td class="col-input">
							<%--<input type="hidden" id="genreCode" name="genreCode"/>--%>
							<tag:autoSelect name="organCode" id="organCode" style="width:180px;" ></tag:autoSelect>
							<input type="text" style="display: none"/>
						</td>
						<td class="col-text">时间</td>
                        <td class="col-input">
                        	<%-- <tag:dateInput name="beginDate" id="beginDate" maxId="endDate" onlypast="true" style="width: 80px;"/>
                          	~<tag:dateInput name="endDate" id="endDate" minId="beginDate" onlypast="true"  style="width: 80px;"/> --%>
                          	<input type="text" class="layui-input x-admin-sm-date" name="beginDate" id="beginDate"
                               style="width: 80px;padding-left: 0px;"> ~
                        	<input type="text" class="layui-input x-admin-sm-date" name="endDate" id="endDate"
                               style="width: 80px;padding-left: 0px;">
                        </td>
                        <td class="col-text">姓名</td>
                        <td class="col-input">
                            <input type="text" name="name" width="120px;"/>
                        </td>
                        <td></td>
					</tr>
					<tr>

                        <td class="col-text">身份证号</td>
                        <td class="col-input">
                            <input type="text" name="idcard" style="width:180px;"/>
                        </td>
                        <c:if test="${isOutpatient==1}">
	                        <td class="col-text">门诊号</td>
	                        <td class="col-input">
	                            <input type="text" name="outpatientNo" style="width:180px"/>
	                        </td>
                        </c:if>
                        <c:if test="${isOutpatient==0}">
	                        <td class="col-text">住院号</td>
	                        <td class="col-input">
	                            <input type="text" name="admissionNo" style="width:180px"/>
	                        </td>
                        </c:if>
                        <c:if test="${isOutpatient==99}">
                            <td></td>
                            <td></td>
                        </c:if>
                        <td colspan="2"></td>
                        <td style="text-align: right">
							<button class="layui-btn layui-btn-sm"  id="emrBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span
						onclick="toggle(this,'emrSearch')"
						class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>

		</form>
	</div>
	<div id="emrDiv">
		<jsp:include page="${listpage}"></jsp:include>
	</div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#beginDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#endDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });


    });

</script>