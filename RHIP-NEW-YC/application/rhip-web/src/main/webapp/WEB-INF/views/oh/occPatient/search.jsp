<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/oh/occPatient/search.js" type="text/javascript"></script>

<div class="section" id="mainSearchDiv">
	<div id="top_all">
		<div class="toolbar">
		<ehr:authorize ifNotGranted="01">
			<a id="initAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
			<ehr:authorize ifAnyGranted="0123">
				<a href="javascript:void(0)" id="pass"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>通过</button></a>
				<a href="javascript:void(0)" id="unpass"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1006;</i>退回</button></a>
			</ehr:authorize>
		</ehr:authorize>	
		</div>
		<div class="searchbox  searchSection x-admin-sm">
			<form id="occPatientSearchForm">				
                <table id="occPatientSearch" >
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:80px; width: 10%;"/>
					<col style="min-width: 210px;width: 20%; "/>
                    <col style="min-width:60px; width: 10%;"/>
					<col style="min-width:160px; width: 20%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
                            <td class="colinput">
                                <input type="text" id="name" name="name" />
                            </td>
							<td class="coltext">身份证号</td>
							<td class="col-input" >
								<tag:idcardInput id="idcard" name="idcard"  style="ime-mode:Disabled;" ></tag:idcardInput>
							</td>
							<td class="coltext">性别</td>
		                    <td >
		                    	<ehr:dic-list name="gender" dicmeta="FS10006"  />
		                    </td>
						</tr>
                    <tr>
                    	<td class="coltext">工种</td>
		                    <td class="colinput">
		                        <input type="text" id="jobType" name="jobType" />   
		                </td>
	                    <td class="coltext">档案类型</td>
	                    <td >
	                    	<ehr:dic-list name="docType" dicmeta="OH00001"  />
	                    </td>
	                   	<td class="coltext">审核情况</td>
	                    <td >
	                    	<ehr:dic-list name="verifyState" code="1,2,3" dicmeta="CV0900103"  />
	                    </td>
                    </tr>
                    <tr>
                    	 <td class="coltext">建档时间</td>
						<td class="col-input" >
							<input type="text" class="layui-input x-admin-sm-date"  name="beginDate" id="beginDate" style="padding-left: 0px;width: 36%;" /> ~
							<input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="endDate" style="padding-left: 0px;width: 36%;" />
						</td>
                    	
	                    <td ></td>
	                    <td ></td>
                        <td ></td>
						<td style="text-align: right;" colspan="2">
							<button class="layui-btn layui-btn-sm" id="occPatientBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
                    </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="occPatientSearch.toggle(this,'occPatientSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="resultDiv">
        </div>
	</div>
	<div id="detailDiv" >    </div>
</div>
<div id="operationDiv"></div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#beginDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#endDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

	});

</script>