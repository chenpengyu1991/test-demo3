<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/yyjbqk/yyjbqk.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:editRecord.backToSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>

</div>
<div>
	<form method="post" id="hospitalInfo_form">
		<input type="hidden" name="isDelete" value="0" />
		<input id="verifyState" name="verifyState" type="hidden" value="${record.verifyState }">
		<div class="postcontent">
			<div class="postdiv">
				<fieldset class="layui-elem-field">
					<legend>医院基本情况</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="18%" />
							<col width="30%" />
						<colgroup>
						<tr>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>档案号:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.fileNo}</c:when>
							        <c:otherwise><input type="text" name="fileNo" value="${record.fileNo}" class="x-layui-input" /></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>医院名称:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.hospitalName}</c:when>
							        <c:otherwise>
							        	<tag:autoSelect name="hospitalName" id="hospitalName" nameValue="${record.hospitalName}" codeValue="${record.hospitalName}"
								 reg='{"required":"true","maxlength":"16"}'></tag:autoSelect>
							        	<%-- <input type="text" name="hospitalName" value="${record.hospitalName}" reg='{"required":"true","maxlength":"16"}'> --%>
							        </c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label>医院地址:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.addr}</c:when>
							        <c:otherwise><input type="text" id="addr" name="addr" value="${record.addr}" class="x-layui-input" /></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label>医院组织机构代码:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.orgCode}</c:when>
							        <c:otherwise><input type="text" name="orgCode" value="${record.orgCode}" class="x-layui-input" /></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>医院级别:</label></th>
							<td><ehr:dic-list id="hLevel" name="hLevel" dicmeta="DM02-02" value="${record.hLevel }" reg='{"required":"true"}'></ehr:dic-list></td>
						</tr>
						<tr>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>法定代表人:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.legalRepr}</c:when>
							        <c:otherwise><input type="text" id="legalRepr" name="legalRepr" value="${record.legalRepr}" reg='{"required":"true","maxlength":"16"}' class="x-layui-input" /></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>防护负责人:</label></th>
							<td>
                                <c:choose>
							        <c:when test="${operationType=='1' }">${record.protectionHead}</c:when>
							        <c:otherwise><input type="text" id="protectionHead" name="protectionHead" value="${record.protectionHead}" reg='{"required":"true","maxlength":"16"}' class="x-layui-input" /></c:otherwise>
							    </c:choose>
                            </td>
                        </tr>
                        <tr>
							<th><label>联系电话:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.phone}</c:when>
							        <c:otherwise><input type="text" id="phone" name="phone" value="${record.phone}" reg='{"maxlength":"18","regex":"phone"}' class="x-layui-input" /></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label>建档时间:</label></th>
							<td>
								<c:choose>
									<c:when test="${operationType=='1' }"><fmt:formatDate value="${record.createTime}" pattern="yyyy/MM/dd"/></c:when>
									<c:otherwise>
										<c:if test="${empty record.createTime}">
											<jsp:useBean id="today" class="java.util.Date"/>
											<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="createTime" id="createTime" value="${today}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
										</c:if>
										<c:if test="${not empty record.createTime}">
											<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="createTime" id="createTime" value="<fmt:formatDate value='${record.createTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
										</c:if>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>
	</form>
</div>
<div style="text-align: center">
     <c:choose>
        <c:when test="${operationType=='4' }">
			<a id="checkRecord" href="javascript:void(0)" onclick="yyjbqk.checkRecord(${record.id})" ><button class="layui-btn layui-btn-sm">审核</button></a>
			<a id="cancleRecord" href="javascript:void(0)" onclick="yyjbqk.unCheckRecord(${record.id})" ><button class="layui-btn layui-btn-sm">退回</button></a>
        </c:when>
        <c:when test="${operationType=='1' }"></c:when>
        <c:otherwise>
			<a id="saveRecord" href="javascript:void(0)" onclick="editRecord.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:void(0)" onclick="editRecord.backToSearch()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
        </c:otherwise>
    </c:choose>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#createTime'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});

	});
</script>