<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script type="text/javascript">
	$(function() {
		srList.atStart();
		$("#backButton").click(function(e) {
			e.preventDefault();
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				$("#medicalOraganDiv").empty();
				$("#oraganSearchDiv").show();
			});
		});
	});
</script>
<div class="toolbar">
	<a href="javascript:void(0)" id="backButton"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div style="padding: 5px;text-align: left;" class="smalltab">
	<%-- <ul id="tags">
		<li class=selectTag><a id="tab0" href="javascript:void(0)">基本信息</a></li>
		<li>
			<a id="tab1" href="javascript:void(0)">科研著作</a>
			<input type="hidden" id="organCodeForSr" value="${organCodeForSr}" />
		</li>
	</ul>
	<div id="tagContent">
		<div id="tagContent0" style="display: block">
			<div style="padding: 5px; width: auto;">
				<fieldset class="layui-elem-field">
					<legend></legend>
					<table class="formtable">
						<tr>
							<th width="12%">机构编码</th>
							<td width="21%">${organization.organCode}</td>
							<th width="12%">机构名称</th>
							<td width="21%">${organization.organName}</td>
							<th width="12%">上级机构名称</th>
							<td width="21%">
								<c:if test="${empty organization.parentCode}">无</c:if>
								<c:if test="${not empty organization.parentCode}"><ehr:org code="${organization.parentCode}" /></c:if>
							</td>
						</tr>
						<tr>
							<th width="12%">机构类别</th>
							<td width="21%"><ehr:dic dicmeta="GBT2182002" code="${organization.genreCode}" /></td>
							<th width="12%">机构级别</th>
							<td width="21%"><ehr:dic dicmeta="DM02-02" code="${organization.gradeCode}" /></td>
							<th width="12%">经营性质</th>
							<td width="21%"><ehr:dic dicmeta="FS10223" code="${organization.manageCode}" /></td>
						</tr>
						<tr>
							<th>经济类型</th>
							<td><ehr:dic dicmeta="GBT124022000" code="${organization.economyCode}" /></td>
							<th>注册资金</th>
							<td>${organization.registCapital}万元</td>
							<th>成立日期</th>
							<td><fmt:formatDate value="${organization.startDate}" pattern="yyyy/MM/dd" /></td>
						</tr>
						<tr>
							<th>法人代表</th>
							<td>${organization.artificialPerson}</td>
							<th>法人证件号</th>
							<td>${organization.artificialIdcard}</td>
							<th>法人电话</th>
							<td>${organization.artificialTel}</td>
						</tr>
						<tr>
							<th>行政区划</th>
							<td><ehr:dic dicmeta="FS990001" code="${organization.gbCode}" /></td>
							<th>邮政编码</th>
							<td>${organization.postCode}</td>
							<th>单位电话</th>
							<td>${organization.tel}</td>
						</tr>
						<tr>
							<th>地址</th>
							<td colspan="3">${organization.address}</td>
							<th>组织机构代码</th>
							<td>${organization.nationalOrganCode}</td>
						</tr>
						<tr>
							<th>核准床位数</th>
							<td>${organization.bedCount}</td>
							<th>牙椅数</th>
							<td>${organization.dentalChairCount}</td>
							<th>电子邮箱</th>
							<td>${organization.mail}</td>
						</tr>
						<tr>
							<th>男职工数</th>
							<td>${organization.mnumber}</td>
							<th>女职工数</th>
							<td>${organization.fnumber}</td>
							<th>撤销日期</th>
							<td>
								<c:if test="${organization.status eq -1}">
								<fmt:formatDate value="${organization.endDate}" pattern="yyyy/MM/dd" />
								</c:if>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
		</div>
		<div id="tagContent1" style="display: none">
			<div id="srDiv"></div>
		</div>
	</div> --%>
	
<div class="layui-tab layui-tab-card" lay-filter="OrganizationInfo"  style="height: 300px;">
  <ul class="layui-tab-title">
    <li class="layui-this">基本信息</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show" >
    	<div style="padding: 5px; width: auto;">
				<fieldset class="layui-elem-field">
					<table class="formtable">
						<tr>
							<th width="12%">机构编码</th>
							<td width="21%">${organization.organCode}</td>
							<th width="12%">机构名称</th>
							<td width="21%">${organization.organName}</td>
							<th width="12%">上级机构名称</th>
							<td width="21%">
								<c:if test="${empty organization.parentCode}">无</c:if>
								<c:if test="${not empty organization.parentCode}"><ehr:org code="${organization.parentCode}" /></c:if>
							</td>
						</tr>
						<tr>
							<th width="12%">机构类别</th>
							<td width="21%"><ehr:dic dicmeta="GBT2182002" code="${organization.genreCode}" /></td>
							<th width="12%">机构级别</th>
							<td width="21%"><ehr:dic dicmeta="DM02-02" code="${organization.gradeCode}" /></td>
							<th width="12%">经营性质</th>
							<td width="21%"><ehr:dic dicmeta="FS10223" code="${organization.manageCode}" /></td>
						</tr>
						<tr>
							<th>经济类型</th>
							<td><ehr:dic dicmeta="GBT124022000" code="${organization.economyCode}" /></td>
							<th>注册资金</th>
							<td>${organization.registCapital}万元</td>
							<th>成立日期</th>
							<td><fmt:formatDate value="${organization.startDate}" pattern="yyyy/MM/dd" /></td>
						</tr>
						<tr>
							<th>法人代表</th>
							<td>${organization.artificialPerson}</td>
							<th>法人证件号</th>
							<td>${organization.artificialIdcard}</td>
							<th>法人电话</th>
							<td>${organization.artificialTel}</td>
						</tr>
						<tr>
							<th>行政区划</th>
							<td><ehr:dic dicmeta="FS990001" code="${organization.gbCode}" /></td>
							<th>邮政编码</th>
							<td>${organization.postCode}</td>
							<th>单位电话</th>
							<td>${organization.tel}</td>
						</tr>
						<tr>
							<th>地址</th>
							<td colspan="3">${organization.address}</td>
							<th>组织机构代码</th>
							<td>${organization.nationalOrganCode}</td>
						</tr>
						<tr>
							<th>核准床位数</th>
							<td>${organization.bedCount}</td>
							<th>牙椅数</th>
							<td>${organization.dentalChairCount}</td>
							<th>电子邮箱</th>
							<td>${organization.mail}</td>
						</tr>
						<tr>
							<th>男职工数</th>
							<td>${organization.mnumber}</td>
							<th>女职工数</th>
							<td>${organization.fnumber}</td>
							<th>撤销日期</th>
							<td>
								<c:if test="${organization.status eq -1}">
								<fmt:formatDate value="${organization.endDate}" pattern="yyyy/MM/dd" />
								</c:if>
							</td>
						</tr>
					</table>
				</fieldset>
			</div>
    </div>
  </div>
</div>
</div>