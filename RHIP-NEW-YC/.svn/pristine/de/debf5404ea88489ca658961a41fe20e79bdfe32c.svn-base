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

<jsp:include page="childBasicInfo.jsp"/>
<div class="toolbar">
    <a href="javascript:void(0)" id="returnChildSearchBtn">
        <button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button>
    </a>
    <c:if test="${examineAgeGroup eq '1'}">
    <a href="javascript:void(0)" id="newExamBtn" data-baby-card-no="'${exam.babyCardNo}'">
        <button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe608;</i>新增</button>
    </a>
    </c:if>
    <c:if test="${examineAgeGroup ne '1'}">
        <a href="javascript:void(0)" id="newExamBtnSix" data-id-card-no="'${exam.idCard}'">
            <button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe608;</i>新增</button>
        </a>
    </c:if>
</div>
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
                    <a title="查看体检信息" class="exam_view layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)"
                       data-baby-card-no="${examination.babyCardNo}" data-id="${examination.id}"><i class="layui-icon"></i>查看</a>
                    <ehr:authorize ifAnyGranted="0204,0304,0404">
                        <c:if test="${currentLoginInfo.organization.organCode eq examination.createOrganCode}">
                            <a title="修改体检信息" class="exam_edit layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)"
                               data-baby-card-no="${examination.babyCardNo}" data-id="${examination.id}"><i class="layui-icon"></i>修改</a>
                            <a title="删除体检信息" class="exam_delete layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)"
                               data-baby-card-no="${examination.babyCardNo}" data-id="${examination.id}"><i class="layui-icon"></i>删除</a>
                        </c:if>
                    </ehr:authorize>
                    </c:if>
                    <c:if test="${examineAgeGroup ne '1'}">
                        <a title="查看体检信息" class="exam_view layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)"
                           data-id-card-no="'${examination.idCard}'" data-id="${examination.id}"><i class="layui-icon"></i>查看</a>
                        <ehr:authorize ifAnyGranted="0204,0304,0404">
                            <c:if test="${currentLoginInfo.organization.organCode eq examination.createOrganCode}">
                                <a title="修改体检信息" class="exam_editSix layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)"
                                   data-id-card-no="'${examination.idCard}'" data-id="${examination.id}"><i class="layui-icon"></i>修改</a>
                                <a title="删除体检信息" class="exam_deleteSix layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)"
                                   data-id-card-no="'${examination.idCard}'" data-id="${examination.id}"><i class="layui-icon"></i>删除</a>
                            </c:if>
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
