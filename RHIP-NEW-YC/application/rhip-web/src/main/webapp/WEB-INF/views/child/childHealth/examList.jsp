<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-24
  Time: 上午10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/examine/examList.js" type="text/javascript"></script>

<%--<div class="toolbar">
    <a href="javascript:void(0)" id="returnChildSearchBtn"><b class="fanhui">返回</b></a>
    <c:if test="${examineAgeGroup eq '1'}">
    <a href="javascript:void(0)" id="newExamBtn" data-baby-card-no="${exam.babyCardNo}"><b class="xinz">新增</b></a>
    </c:if>
    <c:if test="${examineAgeGroup ne '1'}">
        <a href="javascript:void(0)" id="newExamBtnSix" data-id-card-no="'${exam.idCard}'"><b class="xinz">新增</b></a>
    </c:if>
</div>--%>
<div class="repeattable x-admin-sm">
    <table id="examListTable" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 20%;" />
            <col style="width: 20%;" />
            <col style="width: 20%;" />
            <col style="width: 20%;" />
            <col style="width: 20%;" />
        </colgroup>
        <thead>
        <tr>
            <th>随访日期</th>
            <th>月龄</th>
            <th>体检机构</th>
            <th>随访医生</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="examination" items="${examList}">
            <tr>
                <td style="text-align: center"><fmt:formatDate value="${examination.visitDate}" pattern="yyyy/MM/dd" /></td>
                <td style="text-align: center">${examination.cPhysicalExamAge}</td>
                <td style="text-align: center"><ehr:org code="${examination.checkOrganCode}"/></td>
                <td style="text-align: center"><ehr:staff-name staffCode="${examination.visitDoctorCode}"/></td>
                <td style="text-align: center">
                    <c:if test="${examineAgeGroup eq '1'}">
                    <a class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="#" title="查看" onclick="childHealth.view('${examination.id}')"><i class="layui-icon">&#xe615;</i>查看</a>
                
                    
                    <%-- <a href="javascript:void(0);"  onclick="childHealth.view('${examination.id}')" title="查看" ><i class="layui-icon">&#xe615;</i></a> --%>
                    <%--<ehr:authorize ifAnyGranted="02,03">
                        <c:if test="${currentLoginInfo.organization.organCode eq examination.createOrganCode}">
                            <a title="修改体检信息" class="exam_edit" href="javascript:void(0)"
                               data-baby-card-no="${examination.babyCardNo}" data-id="${examination.id}">修改</a>
                            <a title="删除体检信息" class="exam_delete" href="javascript:void(0)"
                               data-baby-card-no="${examination.babyCardNo}" data-id="${examination.id}">删除</a>
                        </c:if>
                    </ehr:authorize>--%>
                    </c:if>
                    <c:if test="${examineAgeGroup ne '1'}">
                     <a class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="#" title="查看" onclick="childHealth.view('${examination.id}')"><i class="layui-icon">&#xe615;</i>查看</a>
                    	<%-- <a href="javascript:void(0);"  onclick="childHealth.view('${examination.id}')" title="查看" ><i class="layui-icon">&#xe615;</i></a> --%>
                      <%--  <ehr:authorize ifAnyGranted="02,03">
                            <c:if test="${currentLoginInfo.organization.organCode eq examination.createOrganCode}">
                                <a title="修改体检信息" class="exam_editSix" href="javascript:void(0)"
                                   data-id-card-no="'${examination.idCard}'" data-id="${examination.id}">修改</a>
                                <a title="删除体检信息" class="exam_deleteSix" href="javascript:void(0)"
                                   data-id-card-no="'${examination.idCard}'" data-id="${examination.id}">删除</a>
                            </c:if>
                        </ehr:authorize>--%>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
