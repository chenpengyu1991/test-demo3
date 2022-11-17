<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/drug.js" type="text/javascript"></script>
<div class="toolbar">
    <%-- <a href="javascript:void(0)" onclick="javascript:tbCommon.returnSearch('standardization.searchTemp')"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" onclick="javascript:tbCommon.returnSearch('standardization.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${logoff !=1 }">
	    <%-- <a href="javascript:void(0)" onclick="javascript:drug.saveDrug(${singleId})"><b class="baocun">保存</b></a> --%>
	    <a href="javascript:void(0)" onclick="javascript:drug.saveDrug(${singleId})"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</c:if>
</div>
<div class="divFixed105" style="top: 200px">
    <input type="hidden" id="initJson" value="${initJson}">
    <div  style="margin: 10px;">
        <table>
            <tr>
                <td>
                    已领药：<img src="${pageContext.request.contextPath}/images/lingyao.gif">
                    已服药：<img src="${pageContext.request.contextPath}/images/fuyao.png">
                </td>
                <td>
                    病人：${patientName}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    督导医生：<ehr:user userCode="${drugDoctor}"/>
                </td>
            </tr>
        </table>
    </div>
    <div class="repeattable">
        <table id="drugTable" class="layui-table x-admin-sm-table-list-middle">
            <thead>
            <tr>
                <th class="centerth" style="width: 55px;">月序/日期</th>
                <c:forEach var="h" begin="1" end="31" step="1">
                    <th>${h}</th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="i" begin="1" end="12" step="1">
                <tr>
                    <td>${i}</td>
                    <c:forEach var="j" begin="1" end="31" step="1">
                        <td id="${i}-${j}" onclick="drug.changePic(this)" flag="" ></td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

