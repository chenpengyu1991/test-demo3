<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/offRecord.css" type="text/css"  rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ehr/family/offFamily.js" type="text/javascript"></script>

<div class="postcontent">
	<div id="msgError" class="msgError" style="display: none;">   </div>
	<form id="offForm" method="post">
	<input type="hidden" value="${familyCanceledInfo.id}" name="id"/>
	<input type="hidden" value="${familyId}" name="familyId"/>
	<input type="hidden" value="${status}" name="isApprove"/>
	<table class="posttable">
		<tr>
			<th style="width: 20%">结案原因：</th>
			<td style="width: 80%">
				<c:choose>
					<c:when test="${status==1}">
						&nbsp;${familyCanceledInfo.canceledReason ne 2 ? '迁出'  : '其他'}
					</c:when>
					<c:otherwise>
						&nbsp;<input type="radio" name="canceledReason" value="1" <c:if test="${familyCanceledInfo.canceledReason!=2}">checked="checked"</c:if> class="x-layui-input" /> 迁出
						&nbsp;<input type="radio" name="canceledReason" value="2" <c:if test="${familyCanceledInfo.canceledReason==2}">checked="checked"</c:if> class="x-layui-input" /> 其它
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>备&emsp;&emsp;注：</th>
			<td>
				<textarea reg='{"maxlength":"166"}' name="remark" rows="5" cols="40" class="x-layui-input" <c:if test="${status==1}" >readonly="readonly"</c:if>>${familyCanceledInfo.remark}</textarea>
			</td>
		</tr>
		<tr>
			<th>结案时间：</th>
			<td width="100px">
				<c:choose>
					<c:when test="${status==1}">
						&nbsp;<fmt:formatDate value="${familyCanceledInfo.canceledDate}" pattern="yyyy/MM/dd"/> 
					</c:when>
					<c:otherwise>
						<jsp:useBean id="today" class="java.util.Date"></jsp:useBean>
						&nbsp;<%-- <tag:dateInput reg='{"required":"true"}' name="canceledDate" date="${today}" onlypast="true"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" placeholder="结案时间" name="canceledDate" id="canceledDate"  reg='{"required":"true"}' value="<fmt:formatDate value="${today}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;width: 75%;" />
					</c:otherwise>
				</c:choose>				
			</td>
		</tr>
		<c:if test="${status==1}">
			<tr>
				<th>审核：</th>
				<td width="100px">
					&nbsp;<input type="radio" name="status" value="2" onclick='$("#tdRefusalReason").hide();' checked="checked"/> 通过
					&nbsp;<input type="radio" name="status" value="3" onclick='$("#tdRefusalReason").show();' /> 不通过
				</td>
			</tr>
			<tr id="tdRefusalReason" style="display: none;">
				<th>退回原因：</th>
				<td width="100px">
					<textarea name="rejectedReason" rows="5" cols="40" class="x-layui-input">${familyCanceledInfo.rejectedReason}</textarea>  
				</td>
			</tr>
		</c:if>
	</table>
	</form>
    <%--</div>      --%>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <div style="text-align: center;">
        <c:choose>
           <c:when test="${status==1}">
                <%-- <input type="button" id="off_button" value="审核" class="width50 button"/> --%>
                <button class="layui-btn layui-btn-sm"  id="off_button">审核</button>
           </c:when>
           <c:otherwise>
                <%-- <input type="button" id="off_button" value="结案" class="width50 button"/>--%>
                <button class="layui-btn layui-btn-sm"  id="off_button">结案</button>
           </c:otherwise>
        </c:choose>
    </div>
</div>
<script type="text/javascript">
 layui.use('laydate', function(){
     var laydate = layui.laydate;
     
     //执行一个laydate实例
     laydate.render({
       elem: '#canceledDate' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });

 });
 </script>