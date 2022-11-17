<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>

<div class="toolbar">
    <%-- <a href="javascript:tbCommon.returnSearch('ndyFuyao.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:tbCommon.returnSearch('ndyFuyao.searchTemp')" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <%--<c:if test="${logoff !=1 }">
        <a href="javascript:standardization.saveChild('1','standardization.searchTemp')" id="saveContact"><b class="baocun">保存</b></a>
    </c:if>--%>
</div>
<form id="tbFormList">
    <input type="hidden" id="idmId" name="singleId" value="${singleId}">
    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
    <input type="hidden" id="listSdJson" name="listSdJson"/>
    <input type="hidden" id="listDdJson" name="listDdJson"/>
    <input type="hidden" id="listFrJson" name="listFrJson"/>
    <input type="hidden" id="singleId" value="${singleId}">
    <input type="hidden" id="patientName" value="${patientName}">
    <input type="hidden" id="logoff" value="${logoff}">
    <div>

        <div >
            <div class="toolbarsublist">
                耐多药服药卡：<%-- <a href="javascript:standardization.initNdyDrug('${singleId}','${patientName}','${logoff}','add')" id="addEfcList" ><b class="xinz">添加</b> </a> --%>
                <%-- <a href="javascript:standardization.initNdyDrug('${singleId}','${patientName}','${logoff}','add')"><i class="layui-icon">&#xe608;</i>添加</a> --%>
                <a class="add-link layui-btn layui-btn-xs" href="javascript:standardization.initNdyDrug('${singleId}','${patientName}','${logoff}','add')" title="添加" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>添加</a>
                
            </div>
            <div class="repeattable">
                <table id="frTable" class="layui-table x-admin-sm-table-list-middle">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 5%" />
                        <col style="width: 10%" />
                        <col style="width: 20%" />
                        <col style="width: 25%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                    </colgroup>
                    <thead>
                    <tr>

                        <th class="centerth" style="width: 5%">登记号</th>
                        <th class="centerth" style="width: 5%">患者姓名</th>
                        <th class="centerth" style="width: 10%">建卡年月</th>
                        <th class="centerth" style="width: 5%">月序</th>
                        <th class="centerth" style="width: 35%">督导机构</th>
                        <th class="centerth" style="width: 5%">治疗方案</th>
                        <th class="centerth" style="width: 5%">开始时间</th>
                        <th class="centerth" style="width: 15%">操作</th>
                    </tr>
                    </thead>
                    <c:forEach var="obj" items="${listNdy}" varStatus="status">
                        <tr>
                            <td class="centertd" >${obj.registNo}</td>
                            <td field="visitTime">${obj.name}</td>
                            <td field="monthCount"><ehr:tip>${obj.createTime}</ehr:tip></td>
                            <td field="supervisorType"><ehr:tip>${obj.monthCount}</ehr:tip> </td>
                            <td field="visitType"><ehr:tip><ehr:org code="${obj.orgCode}" /></ehr:tip></td>
                            <td field="adv" >${obj.treatmentPlanA}</td>
                            <td field="visitTime"><fmt:formatDate value="${obj.treatmentDateA}" pattern="yyyy/MM/dd" /></td>
                            <td class="centertd btnsublist" field="btn">
                                        <%--<a href="javascript:void(0)" onclick="standardization.initNdyDrug('${singleId}','${patientName}','${logoff}','edit','${obj.id}')">修改</a>&nbsp;
                                        <a href="javascript:void(0)" onclick="standardization.delNdy(${obj.id},${obj.idmId},'${patientName}','${logoff}')">删除</a>--%>
                                        
                                <a href="javascript:void(0)" class="layui-btn layui-btn-xs" onclick="standardization.initNdyDrug('${singleId}','${patientName}','${logoff}','edit','${obj.id}')" title="修改"style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;        
                                <%-- <a href="javascript:void(0)" onclick="standardization.initNdyDrug('${singleId}','${patientName}','${logoff}','edit','${obj.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp; --%>
                                <%-- <a href="javascript:void(0)" onclick="standardization.delNdy(${obj.id},${obj.idmId},'${patientName}','${logoff}')" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp; --%>
                                <a href="javascript:void(0)" class="layui-btn layui-btn-danger layui-btn-xs" onclick="standardization.delNdy(${obj.id},${obj.idmId},'${patientName}','${logoff}')" title="删除"style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>&nbsp;        
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>


    </div>
</form>