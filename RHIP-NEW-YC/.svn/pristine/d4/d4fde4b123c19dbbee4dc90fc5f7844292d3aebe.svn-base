<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		healthEducationUpload.uploadFile("heMaterialFile","/he/upload/uploadFile/jjzy","/he/upload/deleteFile/jjzy");
	});
</script>
<div class="toolbar">
	<!-- <a href="javascript:void(0)"
       id="healthEducationResourceSaveButton"
   ><b class="baocun">保存</b></a> -->

	<a href="javascript:void(0)"
	   id="healthEducationResourceSaveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="divAbsolute55">
	<form id="healthEducationResourceForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${healthEducationResource.id}">
			<input type="hidden" name="resourceType" value="${type}">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
				</colgroup>
				<c:if test="${type eq '1'}">
					<tr>
						<th><label class="required">时间</label></th>
						<td>
							<%-- <tag:dateInput reg='{"required":"true"}' name="resourceRecordTime" id="resourceRecordTime" date="${healthEducationResource.resourceRecordTime}" /> --%>
							<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="resourceRecordTime" id="resourceRecordTime" value="<fmt:formatDate value='${healthEducationResource.resourceRecordTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
						<th><label class="required">器材名称</label></th>
						<td>
							<ehr:dic-list name="deviceName" dicmeta="HE00006" width="99px" id="deviceName" reg='{"required":"true"}' value="${healthEducationResource.deviceName}" onchange="healthEducationResourceEdit.addOtherDevice()" cssClass="x-layui-input"></ehr:dic-list>
							<input type="text" style="width:120px;" reg='{"required":"true"}' class="${healthEducationResource.deviceName eq '99' ? '':'hide'}" name="otherDeviceName" id="otherDeviceName" value="${healthEducationResource.otherDeviceName}" class="x-layui-input"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">数量</label></th>
						<td><input name="resourcelQuantity" type="text"  reg='{"required":"true","digits":"true","max":"99999"}' value="${healthEducationResource.resourcelQuantity}" class="x-layui-input" /></td>
						<th><label class="required">规格型号</label></th>
						<td><input name="specification" type="text"  reg='{"required":"true","maxlength":"18"}' value="${healthEducationResource.specification}" class="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label>价值</label></th>
						<td><input name="deviceCost" type="text"  reg='{"number":"true","max":999999999}' value="${healthEducationResource.deviceCost}" class="x-layui-input"/></td>
						<th><label class="required">保管部门</label></th>
						<td><input name="custodyDept" type="text"  reg='{"required":"true","maxlength":"50"}' value="${healthEducationResource.custodyDept}" class="x-layui-input" /></td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3"><textarea name="resourceRemark" reg='{"maxlength":"4000"}' style="height: 125px;width: 665px;" class="x-layui-input">${healthEducationResource.resourceRemark}</textarea></td>
					</tr>
                    <tr>
                        <td></td>
                        <td colspan="3">说明：各卫生院需一并登记各卫生服务站宣传设备。</td>
                    </tr>
				</c:if>
				<c:if test="${type eq '2'}">
					<tr>
						<th><label class="required">年度</label></th>
						<td>
							<c:if test="${empty healthEducationResource.id}">
                                <%-- <tag:dateInput reg='{"required":"true"}' name="positionYear" id="positionYear" date="${healthEducationResource.resourceRecordTime}" pattern="yyyy" onlypast="false"/> --%>
                                <input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="positionYear" id="positionYearId" value="<fmt:formatDate value='${healthEducationResource.resourceRecordTime}' pattern='yyyy'/>" style="padding-left: 0px;" />
                            </c:if>
                            <c:if test="${not empty healthEducationResource.id}">
                                <fmt:formatDate value="${healthEducationResource.resourceRecordTime}" pattern="yyyy"/>
                                <%-- <tag:dateInput style="display: none" reg='{"required":"true"}' name="positionYear" id="positionYear" date="${healthEducationResource.resourceRecordTime}" pattern="yyyy" onlypast="false"/> --%>
                            </c:if>
						</td>
						<th>宣传栏数</th>
						<td><input type="text" name="galleryQuantity" reg='{"digits":"true","max":"99999"}' value="${healthEducationResource.galleryQuantity}" class="x-layui-input"/></td>
					</tr>
					<tr>
						<th>黑板块数</th>
						<td><input type="text" name="blackboardQuantity" reg='{"digits":"true","max":"99999"}' value="${healthEducationResource.blackboardQuantity}" class="x-layui-input"/></td>
						<th>LED显示屏数</th>
						<td><input type="text" name="ledQuantity" reg='{"digits":"true","max":"99999"}' value="${healthEducationResource.ledQuantity}" class="x-layui-input"/></td>
					</tr>
					<tr>
						<th>阅报栏数</th>
						<td><input type="text" name="boardQuantity" reg='{"digits":"true","max":"99999"}' value="${healthEducationResource.boardQuantity}" class="x-layui-input"/></td>
                        <th>资料架数</th>
                        <td><input type="text" name="displayStandQuantity" reg='{"digits":"true","max":"99999"}' value="${healthEducationResource.displayStandQuantity}" class="x-layui-input"/></td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3"><textarea name="resourceRemark" reg='{"maxlength":"1300"}' style="height: 100px;width: 665px;" class="x-layui-input">${healthEducationResource.resourceRemark}</textarea></td>
					</tr>
                    <tr>
                        <td></td>
                        <td colspan="3">说明：各卫生院需一并登记各卫生服务站宣传阵地。</td>
                    </tr>
				</c:if>
				<c:if test="${type eq '3'}">
					<tr>
						<th>
							<label class="required">宣传材料类型</label>
						</th>
						<td>
							<ehr:dic-list name="materialType" dicmeta="HE00007" width="100px" id="materialType" reg='{"required":"true"}' value="${healthEducationResource.materialType}" onchange="healthEducationResourceEdit.addOtherMaterial()" cssClass="x-layui-input"></ehr:dic-list>
							<input type="text" style="width:120px;" reg='{"required":"true"}' class="${healthEducationResource.materialType eq '99' ? '':'hide'}" name="otherMaterialName" id="otherMaterialName" value="${healthEducationResource.otherMaterialName}" class="x-layui-input"/>
						</td>
						<th><label class="required">时间</label></th>
						<td>
							<%-- <tag:dateInput reg='{"required":"true"}' name="resourceRecordTime" id="resourceRecordTime" date="${healthEducationResource.resourceRecordTime}" /> --%>
							<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="resourceRecordTime" id="resourceRecordTime" value="<fmt:formatDate value='${healthEducationResource.resourceRecordTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th><label class="required">资料名称</label></th>
						<td><input type="text" name="materialName"  reg='{"required":"true","maxlength":"100"}' value="${healthEducationResource.materialName}" class="x-layui-input"/></td>
						<th><label class="required">资料数量</label></th>
						<td><input type="text" name="resourcelQuantity"  reg='{"required":"true","digits":"true","max":"99999"}' value="${healthEducationResource.resourcelQuantity}" class="x-layui-input"/></td>
					</tr>
					<tr>
						<th></th>
						<td colspan="3">
								<div style="width: 960px;">
									<c:forEach items="${attches}" var="attche" >
										<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
											<c:if test="${attche.imageFlag eq true}">
												<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}"><img alt="点击查看大图" title="点击查看大图"
																																					src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
												/></a>
											</c:if>
											<c:if test="${attche.imageFlag eq false}">
												<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
											</c:if>
											<br />
											<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
										</div>
									</c:forEach>
								</div>
						</td>
					</tr>
					<tr>
						<th><label class="required">附件</label></th>
						<td style="width: 120px;"><div id="heMaterialFile"></div></td>
						<td colspan="2">
						<span style="color: blue;">注：提供宣传材料样张照片，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span>
						<span id="activeTips" style="color: blue;"></span>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
	</form>
</div>

<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;

    laydate.render({
      elem: '#resourceRecordTime'
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click'
		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#resourceRecordTime").removeClass("lose");
			}else{
				$("#resourceRecordTime").addClass("lose");
			}
		}
    });

    laydate.render({
        elem: '#positionYearId'
     	   ,type: 'year'
     	   ,max:0
     	, trigger: 'click'
		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#positionYearId").removeClass("lose");
			}else{
				$("#positionYearId").addClass("lose");
			}
		}
      });


  });
</script>