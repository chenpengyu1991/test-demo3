<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-24
  Time: 上午11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/examine/oneToTwo/editExam.js" type="text/javascript"></script>

<jsp:include page="../childBasicInfo.jsp"/>

<div class="toolbar">
	<a href="javascript:void(0)" id="cancelChildExamBtn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
	<a href="javascript:void(0);" id="saveChildExamBtn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
</div>
<div class="postcontent divFixed125" style="top: 260px">

    <div class="postdiv">
        <form method="post" id="childExaminationForm">
            <input type="hidden" id="id" name="id" value="${exam.id}">
            <%-- <input type="hidden" name="babyCardNo" value="${exam.babyCardNo}"> --%>
            <input type="hidden" name="personId" value="${exam.personId}">
            <input type="hidden" name="name" value="${exam.name}">
            <input type="hidden" name="gender" value="${exam.gender}">
            <tag:dateInput name="birthday" date="${exam.birthday}" style="display:none"/>
            <input type="hidden" name="pacounty" value="${exam.pacounty}">
            <input type="hidden" name="patownShip" value="${exam.patownShip}">
            <input type="hidden" name="pastreet" value="${exam.pastreet}">
            <input type="hidden" name="pahouseNumber" value="${exam.pahouseNumber}">
            <input type="hidden" name="telNumber" value="${exam.telNumber}">
            <input type="hidden" id="idCard" name="idCard" value="${exam.idCard}">
            <input type="hidden" name="motherIdcard" value="${exam.motherIdcard}">
            <input type="hidden" name="examineAgeGroup" value="${exam.examineAgeGroup}">
            <input type="hidden" name="createOrganCode" value="${exam.createOrganCode}">
            <input type="hidden" name="createOrganName" value="${exam.createOrganName}">
            <input type="hidden" name="createSuperOrganCode" value="${exam.createSuperOrganCode}">
            <input type="hidden" name="createGbCode" value="${exam.createGbCode}">
            <i class="popno">
            12～30月龄儿童健康检查记录表
            </i>
            <table class="posttable">
                <tr>
                    <th style="width:15%">月龄</th>
                    <td style="width:35%">
                        <select id="cPhysicalExamAge" name="cPhysicalExamAge">
                            <option value="12月龄" ${"12月龄" eq examAge ? 'selected' : ''}>12月龄</option>
                            <option value="18月龄" ${"18月龄" eq examAge ? 'selected' : ''}>18月龄</option>
                            <option value="24月龄" ${"24月龄" eq examAge ? 'selected' : ''}>24月龄</option>
                            <option value="30月龄" ${"30月龄" eq examAge ? 'selected' : ''}>30月龄</option>
                        </select>
                    </td>
                    <th style="width:15%">编号</th>
                    <td style="width:35%">
                        <input type="text" id="babyCardNo" name="babyCardNo" value="${empty exam.babyCardNo ? childInfo.babyCardNo : exam.babyCardNo}" readonly>
                    </td>
                </tr>
            </table>
            <div id="examDetail">
                <jsp:include page="editExamDetail.jsp"/>
            </div>
        </form>
    </div>
</div>
