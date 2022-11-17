<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
    <div class="toolbar">
        <a href="javascript:void(0)" onclick="javascript:leprosyCommon.returnSearch('followup.searchTemp')"><b class="fanhui">返回</b></a>
       	 <c:if test="${logoff != 1 }">
	        <a href="javascript:void(0)" onclick="javascript:followup.initAddFr('${nowDateStr}')" id="xinzeng" style="display: none"><b class="xinz">新增</b></a>
	        <%--<a href="javascript:void(0)" onclick="javascript:followup.updateFr()" id="xiugai" style="display: none"><b class="xiug">修改</b></a>--%>
             <a href="javascript:void(0)" onclick="javascript:followup.updateFr()" id="xiugai" style="display: none"><b class="baocun">保存</b></a>
             <a href="javascript:void(0)" onclick="javascript:followup.addFr()" id="baocun" ><b class="baocun">保存</b></a>
	        <a href="javascript:void(0)" onclick="javascript:followup.deleteFr()" id="shanchu" style="display: none"><b class="zuofei">删除</b></a>
    	</c:if>
    </div>
    <div class="repeattable" id="followupsList" style="width:200px; float: left;margin-right: 10px;margin-left: 10px; margin-top: 10px;">
        <table id="frList">
            <colgroup>
                <col style="width:20px"/>
                <col style="width:50px"/>
            </colgroup>
            <thead>
            <tr>
                <th class="centerth">序号</th>
                <th class="centerth">随访时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="followup" items="${listFrs}" varStatus="status">
                <tr onclick="followup.clickRow(this)" id="${followup.id}">
                    <td>${status.index + 1}</</td>
                    <td><fmt:formatDate value="${followup.visitDt}" pattern="yyyy/MM/dd" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table class="mini">
            <tr>
                <ehr:pagination-mini action="followup.searchFollowList" colspan="3" />
            </tr>
        </table>
    </div>
    <div class="postcontent postdiv" id="detailDiv">
        <jsp:include page="followupDetail.jsp"/>
	</div>
</div>