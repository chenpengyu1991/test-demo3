<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/statistics/patient/list.js" type="text/javascript"></script>
<div id="reportList" class="repeattable">
    <table id="reportTable" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width: 40px; width:6%;"/>
            <col style="min-width: 80px; width:10%;"/>
            <col style="min-width: 40px; width:6%;"/>
            <col style="min-width: 40px; width:6%;"/>
            <col style="min-width: 140px; width:15%;"/>
            <col style="min-width: 100px; width:15%;"/>
            <col/>
            <col style="min-width: 130px; width:18%;"/>
            <col style="min-width: 80px; width:10%;"/>
        </colgroup>
        <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>身份证号</th>
                <th>诊断</th>
                <th>所属乡镇</th>
                <th>时间</th>
                <th>费用</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patient" items="${patientList}" varStatus="status">
                    <tr>
                        <td class="centertd">${status.index + 1}</td>
                        <td class="centertd">${patient.name}</td>
                        <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${patient.gender}" /></ehr:tip></td>
                        <td class="centertd">${patient.age}</td>
                        <td class="centertd">${patient.idcard}</td>
                        <td class="centertd">${patient.diagnosisContent}</td>
                        <td class="centertd"><ehr:tip><ehr:dic dicmeta="FS990001" code="${patient.organTown}"/></ehr:tip></td>
                        <td class="centertd">${dateRange}</td>
                        <td style="text-align: right">${patient.currentPrice}</td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="mhmPatientSearch.searchPatient" />
        </tr>
    </table>

</div>