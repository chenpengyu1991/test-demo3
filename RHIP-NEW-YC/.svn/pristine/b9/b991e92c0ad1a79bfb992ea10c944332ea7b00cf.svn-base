<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/standardization.js" type="text/javascript"></script>

<div class="toolbar" id="cancelContactBtnDiv">
    <%-- <a href="javascript:tbCommon.returnSearch('standardization.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:tbCommon.returnSearch('standardization.searchTemp')" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <%--<c:if test="${logoff !=1 }">
        <a href="javascript:standardization.saveChild('1','standardization.searchTemp')" id="saveContact"><b class="baocun">保存</b></a>
    </c:if>--%>
</div>
<div class="toolbar" id="dycsfBackBtnDiv" style="display: none;">
    <a href="javascript:void(0)" id="dycsfBackBtn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <a href="javascript:standardization.saveServiceRecord('addFrForm')" id="saveContactBtn" style="display: none;"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe605;</i>保存</button></a>
    <a href="javascript:standardization.saveServiceRecord('addFrForm')" id="editContactBtn" style="display: none;"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe642;</i>修改</button></a>
</div>
<form id="tbFormList">
    <input type="hidden" id="idmIdsf" name="singleId" value="${singleId}">
    <input type="hidden" id="logoff" value="${logoff}">
    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
    <input type="hidden" id="listSdJson" name="listSdJson"/>
    <input type="hidden" id="listDdJson" name="listDdJson"/>
    <input type="hidden" id="listFrJson" name="listFrJson"/>
    <div class="divFixed125" style="top: 200px;">

        <div id="sfDiv">
            <div class="toolbarsublist">
                随访记录：
                <c:if test="${logoff !=1 }">
                    <%--<a href="javascript:standardization.popup('','','fw','${singleId}')" id="addEfcList" ><b class="xinz">添加</b> </a>--%>
                    <%--<a href="javascript:standardization.popup('','','fw','${singleId}','1')" id="addEfcList" ><b class="xinz">新增第一次入户随访</b> </a>
                    <a href="javascript:standardization.popup('','','fw','${singleId}','2')" id="addEfcList" ><b class="xinz">新增非首次随访</b> </a>--%>
                    <a href="javascript:void(0)" id="addFirstFollowup"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增第一次入户随访</button></a>
                    <a href="javascript:void(0)"  id="addOtherFollowup"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增非首次随访</button></a>
                </c:if>
            </div>
            <div class="repeattable">
                <table id="frTable" class="layui-table x-admin-sm-table-list-middle">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 5%" />
                        <col style="width: 10%" />
                        <col style="width: 20%" />
                        <col style="width: 15%" />
                        <col style="width: 10%" />
                        <col style="width: 8%" />
                        <col style="width: 12%" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th class="centerth" style="width: 10%">日期</th>
                        <th class="centerth" style="width: 5%">月序</th>
                        <th class="centerth" style="width: 5%">督导人员</th>
                        <th class="centerth" style="width: 35%">随访方式</th>
                        <th class="centerth" style="width: 5%">处理意见</th>
                        <th class="centerth" style="width: 5%">下次随访时间</th>
                        <th class="centerth" style="width: 5%">随访医生</th>
                        <th class="centerth" style="width: 5%">操作</th>
                    </tr>
                    </thead>
                    <c:forEach var="listFr" items="${tbSaveDto.listSr}" varStatus="status">
                        <tr>
                            <td class="centertd" field="idmId" style="display: none;">${singleId}</td>
                            <td field="visitTime"><fmt:formatDate value="${listFr.visitTime}" pattern="yyyy/MM/dd" /></td>
                            <td field="monthCount"><ehr:tip>${listFr.monthCount}</ehr:tip></td>
                            <td field="supervisorType"><ehr:dic dicmeta="IDM00413" code="${listFr.supervisorType}"/> </td>
                            <td field="visitType"><ehr:dic dicmeta="IDM00414" code="${listFr.visitType}"/> </td>
                            <td field="adv" >${listFr.adv}</td>
                            <td field="visitTime"><fmt:formatDate value="${listFr.nextVisitTime}" pattern="yyyy/MM/dd" /></td>
                            <td field="visitDoctor" >${listFr.visitDoctor}</td>
                            <td class="centertd btnsublist" field="btn">
                                        <%--<a href="javascript:void(0)" onclick="standardization.popupEdit(${listFr.id},'${singleId}','fw')">修改</a>&nbsp;
                                        <a href="javascript:void(0)" onclick="standardization.delFw(${listFr.id})">删除</a>--%>
                            <a href="javascript:void(0)" onclick="standardization.addFirstFollowup(${listFr.id},'edit',${singleId},'')" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
                            <a href="javascript:void(0)" onclick="standardization.delFw(${listFr.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>&nbsp;
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>


    </div>
</form>