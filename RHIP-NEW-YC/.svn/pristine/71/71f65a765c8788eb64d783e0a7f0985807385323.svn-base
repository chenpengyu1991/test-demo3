<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"/>
<script src="${pageContext.request.contextPath}/js/views/ihm/dcConfig/examSearch.js" type="text/javascript"></script>
<div class="section">
<div id="top_all">
    <div class="toolbar" >
        <a href="javascript:void(0)"><button id="initAdd" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加检验项</button></a>
    </div>
    <div class="section">
        <div class="searchbox searchSection x-admin-sm">	
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="searchForm">
                <table id="searchTable">
                    <colgroup>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 70px;"/>
                        <col style="width: 70%; min-width: 70px;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="col-text">检查项目</td>
                        <td class="col-input" >
                             <!-- <input type="text" name="queryCode"> 
                             <input type="text" name="queryCode1" style="display: none">-->
                              <ehr:dic-list name="queryCode" dicmeta="WST1021998" reg='{"required":"true"}' code="3080090101,3080080101,3020210101,3020240101,3020260101,3020110101,3050050101,3050140101,3050120101,3020010101,3020020101,3040010101,4040030101,4040040101,4040050101,4040060101,4040070101,4040100101,4020150101,4020160101,4020170101,4020180101,4020190101,4110010101,4030160101,4030170101"></ehr:dic-list>
                        </td>
                        <td >
                            <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td class="col-bottom"><span onclick="examDCSearch.toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
<div id="resultDiv"></div>
</div>
<div id="detailDiv"></div>
</div>