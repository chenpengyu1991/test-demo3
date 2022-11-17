<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-6-18
  Time: 上午10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="repeattable">
    <div>
        	提示：该医生停诊期间有如下预约记录
    </div>
     <div style="display: none">
        <tag:dateInput name="oldStartDate1" date="${startDate}"  id="oldStartDate1"></tag:dateInput>
        <tag:dateInput name="oldEndDate1" date="${endDate}"  id="oldEndDate1"></tag:dateInput>
    </div>
    <br/>
    <table id="person_record_table">
        <colgroup>
            <col style="width:15%;"/>
            <col style="width:20%;"/>
            <col style="width:30%;"/>
            <col style="width:15%;"/>
            <col style="width:15%;"/>
        </colgroup>
        <thead>
        <tr>
            <th style="text-align: center;">到诊日期</th>
            <th style="text-align: center;">姓名</th>
            <th style="text-align: center;">身份证</th>
            <th style="text-align: center;">预约日期</th>
            <th style="text-align: center;">状态</th>
        </tr>
        </thead>
        <tbody class="tbody">
        <c:forEach items="${reserveRegisters}" var="reserveRegister" varStatus="status">
            <tr>
                <td style="text-align:center">
                    <fmt:formatDate value='${reserveRegister.requestDate}' pattern='yyyy/MM/dd'/>
                </td>
                <td title="${reserveRegister.name}" style="text-align:left">
                    ${reserveRegister.name}
                </td>
                <td title="${reserveRegister.idcard}" style="text-align:left">
                    ${reserveRegister.idcard}
                </td>
                <td style="text-align:center" >
                    <fmt:formatDate value='${reserveRegister.submitDate}' pattern='yyyy/MM/dd'/>
                </td>
                <td style="text-align:center">
                    <tag:reserveStauts stauts="${reserveRegister.reserverStauts}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <ehr:pagination action="stopDetailSearch.recordsShow" colspan="5"/>
        <!-- 实现分页功能 -->
    </table>
    <br/>
    <br/>
    <div style="text-align: center;">
        <input id="stop2_search_btn" class="search_btn" type="button" onclick="stopDetailSearch.search(2)" value="停诊"  type="hidden"/>
    </div>
</div>
