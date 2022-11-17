<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable" >
    <form>
    <table class="layui-table x-admin-sm-table-list-middle">
        <thead>
	        <tr>
	        	<th rowspan="2">区县</th>
	            <th rowspan="2">机构</th>
	            <th colspan="5">孕产妇健康管理统计报表</th>
	        </tr>
	        <tr>
	            <th>该地该时间段内活产数</th>
	            <th>辖区内孕13周之前建册并进行第一次产前检查的产妇人数</th>
	            <th>早孕建册率</th>
	            <th>辖区内产妇出院后28天内接受过产后访视的产妇人数</th>
	            <th>产后访视率</th>
	        </tr>
        </thead>
        <tbody>
        <c:forEach items="${maternalHealthManages}" var="MaternalHealthManage">
            <tr>
            <td><ehr:tip><ehr:dic code="${MaternalHealthManage.gbCode}" dicmeta="FS990001"  /></ehr:tip></td>
            <td>${MaternalHealthManage.organName}</td>
            <td>${MaternalHealthManage.liveBirthsNum}</td>
            <td>${MaternalHealthManage.pregnantThirtweekExaNum}</td>
            <td>${MaternalHealthManage.earlyPregnancyRate}%</td>
            <td>${MaternalHealthManage.leavehosTwentyeightDay}</td>
            <td>${MaternalHealthManage.postpartumVisitRate}%</td>
            </tr>
        </c:forEach>
        <c:if test="${total!=null}">
	        <tr>
	            <td colspan="2"><b>合计</b></td>
	            <td>${total.liveBirthsNum}</td>
	            <td>${total.pregnantThirtweekExaNum}</td>
	            <td>${total.earlyPregnancyRate}%</td>
	            <td>${total.leavehosTwentyeightDay}</td>
	            <td>${total.postpartumVisitRate}%</td>
	        </tr>
        </c:if>
        </tbody>
    </table>
    </form>
</div>
