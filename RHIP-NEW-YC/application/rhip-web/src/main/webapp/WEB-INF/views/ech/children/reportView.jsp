<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js"
        type="text/javascript"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/views/ech/children/report.js"></script>
<link href="${pageContext.request.contextPath}/css/views/ech/report.css" type="text/css"
      rel="stylesheet"/>

<div id="report">
    <div class="toolbar" >
        <%-- <a href="javascript:void(0)" id="cancelChildExamBtn"><b class="fanhui">返回</b></a> --%>
        <a href="javascript:void(0)" id="cancelChildExamBtn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
        <%-- <a href="javascript:void(0)" onclick="javascript:editChildExam.print()"><b class="dayin">打印</b></a> --%>
        <a href="javascript:void(0)" onclick="javascript:editChildExam.print()" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe66d;</i>打印</button></a>
<%--        <c:if test="${'new' eq type || 'edit' eq type}">
            <a href="javascript:void(0)" id="saveChildExamBtn"><b class="baocun">保存</b></a>
        </c:if>--%>
    </div>
    <div id="evaluation-main">
        <form id="evaluation-form">
            <input type="hidden" id="id" name="id" value="${exam.id}">
            <input type="hidden" name="personId" id="personId" value="${exam.personId}">
<%--            <table class="posttable">
                <tr>
                    <th style="width:15%;" align="right">月龄</th>
                    <td style="width:35%">
                        <ehr:dic-list name="cPhysicalExamAge" id="cPhysicalExamAge" defaultval="Y"
                                      dicmeta="ECH00001" code="2,4,5,6,7,8"
                                      value="${exam.cPhysicalExamAge}"></ehr:dic-list>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
            </table>--%>
            <div class="postcontent">
                <div class="postdiv">
                    <fieldset>
                        <legend><label>儿童中医体质辨识</label></legend>
                        <table class="posttable">
                            <colgroup>
                                <col style="width:30%">
                                <col style="width:70%">
                            </colgroup>
                            <tr>
                                <th><label class="">身份证号</label></th>
                                <td><tag:idcardInput name="idCard" id="idCard" value="${exam.idCard}" reg="{'required':true}" style="width:300px" /></td>
                            </tr>
                            <tr>
                                <th><label>儿童姓名</label></th>
                                <td><input type="text" name="name" id="name" value="${exam.name}" style="width:300px"/></td>
                            </tr>
                            <tr>
	                            <th><label class="">体检机构</label></th>
	                            <td>
                                    <ehr:org code="${exam.checkOrganCode}"></ehr:org>
	                            </td>
                            </tr>
                            <tr>
                                <th><label class="">随访时间</label></th>
                                <td>
                                    <fmt:formatDate value="${exam.visitDate}" pattern="yyyy/MM/dd" />
                                </td>
                            </tr>
                            <tr>
                                <th><label class="">中医药健康管理服务</label></th>
                                <c:if test="${'2' eq exam.cPhysicalExamAge or '4' eq exam.cPhysicalExamAge}">
                                <td colspan="3">
                                    <ehr:dic-checkbox name="tcmHealthManageService"
                                                      dicmeta="FS10307"
                                                      code="1,2,3,99"
                                                      reg='{"required":"true"}'
                                                      value="${exam.tcmHealthManageService}"/>
                                    <span class="tcmHealthManageDetail" style="display: none;">
                                    <input type="text" name="tcmHealthOther"
                                           value="${exam.tcmHealthOther}"
                                           style="width: 200px;"/></span>
                                </td>
                                </c:if>
                                <c:if test="${'5' eq exam.cPhysicalExamAge or '6' eq exam.cPhysicalExamAge}">
                                <td colspan="3">
                                    <ehr:dic-checkbox name="tcmHealthManageService"
                                                      dicmeta="FS10307"
                                                      code="1,2,4,99"
                                                      reg='{"required":"true"}'
                                                      value="${exam.tcmHealthManageService}"/>
                                    <span class="tcmHealthManageDetail" style="display: none;">
                                    <input type="text" name="tcmHealthOther"
                                           value="${exam.tcmHealthOther}"
                                           style="width: 200px;"/></span>
                                </td>
                                </c:if>
                                <c:if test="${'7' eq exam.cPhysicalExamAge or '8' eq exam.cPhysicalExamAge}">
                                <td colspan="3">
                                    <ehr:dic-checkbox name="tcmHealthManageService"
                                                      dicmeta="FS10307"
                                                      code="1,2,5,99"
                                                      reg='{"required":"true"}'
                                                      value="${exam.tcmHealthManageService}"/>
                                    <span class="tcmHealthManageDetail" style="display: none;">
                                    <input type="text" name="tcmHealthOther"
                                           value="${exam.tcmHealthOther}"
                                           style="width: 200px;"/></span>
                                </td>
                                </c:if>
                            </tr>
                            <tr>
                                <th><label class="">下次随访时间</label></th>
                                <td>
                                    <fmt:formatDate value="${exam.nextSupervisionDate}" pattern="yyyy/MM/dd" />

                                </td>
                            </tr>
                            <tr>
                                <th><label class="">随访医生</label></th>
                                <td><input type="text" name="visitDoctorName"
                                           value="${exam.visitDoctorName}"
                                           reg="{'required':'true'}" style="width:300px"></td>
                            </tr>
                        </table>
                    </fieldset>
                </div>
            </div>
        </form>
    </div>
</div>



