<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-5-16
  Time: 下午12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
    <script type="text/javascript">
        $(function(){$("#print").click(function() {
            $("#printDetaile").jqprint();
//	    mainPageH.search(1);
//	    return;
        });});
    </script>
</head>

<body>
<div class="toolbar" style="text-align: right; margin-right: 20px;">
    <a href="javascript:void(0)" id="print"><b class="">打印</b></a>
</div>

<input type="hidden" id="barcode" value="${vaccinationEvent.barcode}"/>
<!-- 患者基本情况 -->
<div class="postcontent" id="printDetaile">
	<div style="width:100%; font-size: 18px; font-weight: bold; float: left; text-align: center;">
    <div style="text-align: right;"><img src="${pageContext.request.contextPath}/barcode/show?msg=${vaccinationEvent.barcode}" height="50px" width="160px"/></div>
    <div style=" text-align: center; ">永城市23价肺炎疫苗接种知情同意书</div>
	</div>
	<br/>
    
    <div class="postdiv">
        <fieldset class="layui-elem-field">
            <legend style="font-size: 11px;">患者基本情况</legend>
            <table style="width:99%; font-size: 11px;" class="posttable">
                <colgroup >
                    <col width="15%" />
                    <col width="23%" />
                    <col width="18%" />
                    <col width="40%" />
                <colgroup>
                <tbody>
                <tr>
                    <th style="text-align: right;">姓名：</th>
                    <td>${vaccinationMgmt.name }</td>
                    <th style="text-align: right;">身份证号：</th>
                    <td>${vaccinationMgmt.idCard }</td>

                </tr>
                <tr>
                    <th style="text-align: right;">性别：</th>
                    <td><ehr:dic dicmeta="GBT226112003" code="${vaccinationMgmt.gender}"/></td>
                    <th style="text-align: right;">联系电话：</th>
                    <td>${vaccinationMgmt.phoneNumber }</td>
                </tr>
                <tr>
                    <th style="text-align: right;">年龄：</th>
                    <td>${vaccinationMgmt.age } &nbsp;岁</td>
                    <th style="text-align: right;">居住地址：</th>
                    <td>
                        <ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.patownShip}"></ehr:dic>
                        <ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.pastreet}"></ehr:dic>
                        ${vaccinationMgmt.pahouseNumber}
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>

    <!-- 接种信息  -->
    <div class="postdiv">
        <fieldset class="layui-elem-field">
            <legend style="font-size: 11px;">23价肺炎疫苗接种情况</legend>
            <c:if test="${not empty  vaccineRecord}">
            <table style="width:99%; font-size: 11px;" class="posttable">
                <colgroup >
                    <col width="15%" />
                    <col width="23%" />
                    <col width="18%" />
                    <col width="40%" />
                <colgroup>
                <tbody>
                <tr>
                    <th style="text-align: right;">接种日期：</th>
                    <td><fmt:formatDate value='${vaccineRecord.vaccinationDate}' pattern='yyyy/MM/dd'/></td>
                    <th style="text-align: right;">制品名称：</th>
                    <td>${vaccineRecord.vaccineName}</td>
                </tr>
                <tr>
                    <th style="text-align: right;">剂量：</th>
                    <td>${vaccineRecord.vaccineMeasurement} &nbsp;剂</td>
                    <th style="text-align: right;">生产厂家：</th>
                    <td>${vaccineRecord.vaccineFactory}</td>
                </tr>
                <tr>
                    <th style="text-align: right;">疫苗批号：</th>
                    <td>${vaccineRecord.vaccineLotNumber}</td>
                    <th style="text-align: right;">接种人：</th>
                    <td>${vaccineRecord.vaccinationDoctorName}</td>
                </tr>
                </tbody>
            </table>
            </c:if>
        </fieldset>
    </div>
    <!-- 接种信息  -->
    <!-- 备注 -->

    <div class="postdiv">
        <fieldset class="layui-elem-field">
            <legend style="font-size: 11px;">备注</legend>
            <textarea class="vacnte" readonly="readonly" rows="5" cols="40" style="font-size: 11px; width: 90%; margin: 0px;">${vaccinationEvent.comments}</textarea>
        </fieldset>
    </div>
</div>
</body>