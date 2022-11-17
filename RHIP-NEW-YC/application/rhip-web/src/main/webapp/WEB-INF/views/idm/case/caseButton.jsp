<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/case/idCard.js" type="text/javascript"></script>

<div class="toolbar">
    <c:if test="${'1'== logoff}">
		<%-- <a href="javascript:caseEdit.returnSearch()" id="cancelContact"><b class="fanhui">返回</b></a> --%>
		<a href="javascript:caseEdit.returnSearch()" id="cancelContact" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	</c:if> 
	<c:if test="${'1'!= logoff  && 1 ==repeat}">
		<%-- <a href="javascript:repeatSearch.search(1)" id="cancelContact"><b class="fanhui">返回</b></a> --%>
		<a href="javascript:repeatSearch.search(1)" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	</c:if> 
	<c:if test="${'1'!= logoff  && 1 !=repeat}">
    	<%-- <a href="javascript:caseEdit.returnSearch()" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    	<a href="javascript:caseEdit.returnSearch()" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    </c:if>
	<c:if test="${'1'!= logoff  && caseDto.caseStatus==3}">
		<%-- <a href="javascript:void(0)" id="popPrintId3" onclick="javascript:casePrint.onlyPrint()"><b class="dayin">打印</b></a> --%>
		<a href="javascript:void(0)" id="popPrintId3" onclick="javascript:casePrint.onlyPrint()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>
	</c:if>
    <input type="hidden" value="${caseDto.caseStatus}">
    <c:if test="${'1'!= logoff  && caseDto.caseStatus==1}">
        <%-- <a href="javascript:caseEdit.caseSubmit(1,${infectiousCode})" id="saveContact"><b class="baocun">保存</b></a> --%>
        <a href="javascript:caseEdit.caseSubmit(1,${infectiousCode})" id="saveContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
       <!--  <a href="javascript:void(0)" id="popPrintId3" onclick="javascript:casePrint.print(1)"><b class="dayin">保存并打印</b></a> -->
    </c:if>
    <%--疾控审核 --%>
    <ehr:authorize ifAnyGranted="${JKFYK}">
    	<c:if test="${'1'!= logoff  && caseDto.caseStatus==2 && (infectiousCode=='101' || infectiousCode=='102' || infectiousCode=='2121' || infectiousCode=='204' || infectiousCode=='201')}">
    	<%-- <a href="javascript:void(0)" id="popPrintId3" onclick="javascript:casePrint.print(3)"><b class="dayin">审核并打印</b></a> --%>
    	<a href="javascript:void(0)" id="popPrintId3" onclick="javascript:casePrint.print(3)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>审核并打印</button></a>
	    	 <%-- <a href="javascript:caseEdit.caseSubmit(3,${infectiousCode})" id="editContact"><b class="baocun">审核</b></a> --%>
	    	 <a href="javascript:caseEdit.caseSubmit(3,${infectiousCode})" id="editContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe672;</i>审核</button></a>
	    	 <%-- <a href="javascript:caseEdit.caseSubmit(4,${infectiousCode})" id="editContact"><b class="tijiao">退回</b></a> --%>
	    	 <a href="javascript:caseEdit.caseSubmit(4,${infectiousCode})" id="editContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>退回</button></a>
   	 	</c:if>
	</ehr:authorize>
	 <%--疾中心审核 --%>
    <ehr:authorize ifAnyGranted="${ZXCRB}">
    	<c:if test="${'1'!= logoff  && caseDto.caseStatus==2 && !(infectiousCode=='101' || infectiousCode=='102' || infectiousCode=='2121' || infectiousCode=='204' || infectiousCode=='201')}">
    	<%-- <a href="javascript:void(0)" id="popPrintId3" onclick="javascript:casePrint.print(3)"><b class="dayin">审核并打印</b></a> --%>
    	<a href="javascript:void(0)" id="popPrintId3" onclick="javascript:casePrint.print(3)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>审核并打印</button></a>
	    	 <%-- <a href="javascript:caseEdit.caseSubmit(3,${infectiousCode})" id="editContact"><b class="baocun">审核</b></a> --%>
	    	 <a href="javascript:caseEdit.caseSubmit(3,${infectiousCode})" id="editContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe672;</i>审核</button></a>
	    	 <%-- <a href="javascript:caseEdit.caseSubmit(4,${infectiousCode})" id="editContact"><b class="tijiao">退回</b></a> --%>
	    	 <a href="javascript:caseEdit.caseSubmit(4,${infectiousCode})" id="editContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>退回</button></a>
   	 	</c:if>
   	 	<c:if test="${'1'!= logoff  && caseDto.caseStatus==2 && (infectiousCode=='101' || infectiousCode=='102' || infectiousCode=='2121' || infectiousCode=='204' || infectiousCode=='201')}">
    		<%-- <a href="javascript:caseEdit.caseSubmit(2,${infectiousCode})" id="editContact"><b class="baocun">保存</b></a> --%>
    		<a href="javascript:caseEdit.caseSubmit(2,${infectiousCode})" id="editContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
   	 	</c:if>
	</ehr:authorize>
	<%--修改 --%>
	<ehr:authorize ifAnyGranted="${ZCRB}">
	 	<c:if test="${'1'!= logoff && caseDto.caseStatus==2}">
	 		<%-- <a href="javascript:caseEdit.caseSubmit(2,${infectiousCode})" id="editContact"><b class="baocun">保存</b></a> --%>
	 		<a href="javascript:caseEdit.caseSubmit(2,${infectiousCode})" id="editContact"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	 	</c:if>
	</ehr:authorize>
</div>