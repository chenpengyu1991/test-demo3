<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-23
  Time: 下午3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/examine/childList.js" type="text/javascript"></script>
<table id="childListTable" class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
        <col style="width: 10%;" />
        <col style="width: 20%;" />
        <col style="width: 10%;" />
        <col style="width: 20%;" />
        <col style="width: 20%;" />
        <col style="width: 20%;" />
    </colgroup>
    <thead>
    <tr>
        <th>姓名</th>
        <th>身份证号</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>出生编号</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="exam" items="${childExams}">
        <tr>
            <td style="text-align: center">${exam.name}</td>
            <td style="text-align: center">${exam.idCard}</td>
            <td style="text-align: center"><ehr:dic dicmeta="GBT226112003" code="${exam.gender}" /></td>
            <td style="text-align: center"><fmt:formatDate value="${exam.birthday}" pattern="yyyy/MM/dd" /></td>
            <td style="text-align: center">${exam.babyCardNo}</td>
            <td style="text-align: center">
                <c:if test="${examineAgeGroup eq '1'}">
                <a title="查看全部体检信息" class="child_view layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" onclick="childList.viewChildExams('${exam.babyCardNo}')"
                   data-baby-card-no="${exam.babyCardNo}" data-check-organ-code="${exam.checkOrganCode}"><i class="layui-icon"></i>查看</a>
                    <ehr:authorize ifAnyGranted="0204,0304,0404">
                        <a title="新增体检信息" class="child_add layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" onclick="childList.editChildExam('${exam.babyCardNo}')"
                           data-baby-card-no="${exam.babyCardNo}"><i class="layui-icon">&#xe608;</i>新增</a>
                    </ehr:authorize>
                </c:if>
                <c:if test="${examineAgeGroup ne '1'}">
                 <a title="查看全部体检信息" class="child_view layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" onclick="childList.viewChildExams('${exam.idCard}')"
                       data-baby-card-no="'${exam.idCard}'" data-check-organ-code="${exam.checkOrganCode}"><i class="layui-icon"></i>查看</a>
                    <ehr:authorize ifAnyGranted="0204,0304,0404">
                        <a title="新增体检信息" class="child_add layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" onclick="childList.editChildExamSix('${exam.idCard}')"
                           data-baby-card-no="'${exam.idCard}'"><i class="layui-icon">&#xe608;</i>新增</a>
                    </ehr:authorize>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <ehr:pagination action="childSearch.search" colspan="6" />
</table>
