<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/addConsultation.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
          elem: '#consulationDate'
           ,format: 'yyyy/MM/dd'
           , trigger: 'click' 
        });
      });

    </script>
<div class="Contentbox" style="text-align: left;">

	<form id="consultationForm" name="consultationForm" method="post">
        <input type="hidden" name="Consultation.id" value="${consultation.id}"/>
        <input type="hidden" name="Consultation.createDate" value="${consultation.createDate}"/>
        <input type="hidden" name="Consultation.createUser" value="${consultation.createUser}"/>
        <input type="hidden" name="Consultation.createOrg" value="${consultation.createOrg}"/>
		<i class="pop_No">
			<%--<a class="bc" id="button_save">保存</a>--%>
			<a href="javascript:void(0);" id="button_save" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
			<c:if test="${isShowAddBtn}">
				<%--<a class="xz" id="button_add">新增</a>--%>
				<a href="javascript:void(0);" id="button_add" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
			</c:if>
		</i>
		<div id="addConsultationDiv" class="postcontent">
			<style>
				#addConsultationDiv s.pop_No{width:520px;}
			</style>
			<h1 align="center">会诊记录表</h1>
			<div style="height: 40px;margin-top: 10px">
				<span class="span_floatleft">&emsp;&emsp;<b>姓名：</b>${personInfo.name}</span>
				<c:choose>
					<c:when test="${not empty personInfo.healthFileNoHtml}">
						${personInfo.healthFileNoHtml}
					</c:when>
					<c:otherwise>
						<s class="pop_No">
							<span class="text"><b>编号：</b></span>
							<span></span><span></span><span></span><span></span><span></span>
							<span class="line">-</span>
							<span></span><span></span><span></span>
							<span class="line">-</span>
							<span></span><span></span><span></span>
							<span class="line">-</span>
							<span></span><span></span><span></span><span></span>
						</s>
					</c:otherwise>
				</c:choose>
			</div>
			<hr style="width: 100%"/>
			<div class="postdiv">
				<table class="posttable" style="width: 100%;margin-top: 10px">
					<colgroup>
						<col style="width: 13%"/>
						<col style="width: 37%"/>
						<col style="width: 50%"/>
					</colgroup>
					<tr>
						<th>会诊原因：</th>
						<td colspan="2"><textarea name="Consultation.consulationReason" reg='{"required":true,"maxlength":200}' style="width: 87%;height: 100px">${consultation.consulationReason}</textarea></td>
					</tr>
					<tr>
						<th>会诊意见：</th>
						<td colspan="2"><textarea name="Consultation.consulationOpinion" reg='{"required":true,"maxlength":200}' style="width: 87%;height: 100px">${consultation.consulationOpinion}</textarea></td>
					</tr>
					<tr>
						<td colspan="2"><b>会诊医生及其所在医疗卫生机构:</b> </td>
						<td align="center">
							<a id="addOrgAndDoc" href="javascript:void(0)"><i class="layui-icon"  style="font-weight: normal;">&#xe608;</i>增加</a>&nbsp;
							<a id="delOrgAndDoc" href="javascript:void(0)" ><i class="layui-icon"  style="font-weight: normal;">&#xe640;</i>删除</a></a>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><b>医疗卫生机构名称</b></td>
						<td align="center"><b>会诊医生签字</b></td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="hidden" name="Consultation.consulationOrgAndName" id="consulationOrgAndName" value='${consultation.consulationOrgAndName}'>
							<div id="orgAndDoc">

							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="right"><b>责任医生</b><input type="text" name="Consultation.manageDoctorName" value="${consultation.manageDoctorName}" reg='{"required":true}' style="width: 20%"> </td>
					</tr>
					<tr>
						<td colspan="3" align="right"><b>会诊日期</b>
						<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="Consultation.consulationDate" id="consulationDate" 
                            value="<fmt:formatDate value='${consultation.consulationDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 20%" />
					</tr>
				</table>
			</div>
		</div>
	</form>
</div>
