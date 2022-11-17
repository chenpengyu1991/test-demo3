<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
    $(function(){
        contact.changeType('closeType');
    })
</script>
<fieldset style="margin-top: 10px" class="layui-elem-field">
    <legend>涂阳肺结核患者密切接触者登记</legend>
    <form id="ccForm">
    	<input type="hidden" id="singleId" name="idmId" value="${idmId}">
        <input type="hidden" id="ccId" name="id" value="${id}">
        <table class="posttable">
            <colgroup>
                <col style="min-width: 140px; width: 30%;" />
                <col style="min-width: 80px; width: 70%;" />
            </colgroup>
            <tr>
                <th>涂阳患者姓名</th>
                <td><input type="text" id="patientNameFr" name="patientName" value="${listCc.patientName}"/></td>
            </tr>
            <tr>
                <th>涂阳患者登记号</th>
                <td><input type="text" id="registNoFr" name="registNo" value="${listCc.registNo}"/></td>
            </tr>
            <tr>
                <th><label class="required">接触者姓名</label></th>
                <td><input type="text" name="closeName" value="${listCc.closeName}" reg='{"required":"true"}'/></td>
            </tr>
            <tr>
                <th>性别</th>
                <td><ehr:dic-radio dicmeta="GBT226112003" code="1,2"  name="sex" value="${listCc.sex}"/> </td>
            </tr>
            <tr>
                <th>年龄</th>
                <td><input type="text" name="age" value="${listCc.age}"/></td>
            </tr>
            <tr>
                <th><label class="required">接触者类型</label></th>
                <td><ehr:dic-radio dicmeta="IDM00249" name="closeType" value="${listCc.closeType}" reg='{"required":"true"}'
                                   onchange="contact.changeType('closeType')"/>
                    <ehr:dic-list id="closeDetail1" name="closeDetail" dicmeta="IDM00055" code="2,3,5,7,99" value="${listCc.closeDetail}" reg='{"required":"true"}'/>
                    <ehr:dic-list id="closeDetail2" name="closeDetail" dicmeta="IDM00057" code="2,3,4,99" value="${listCc.closeDetail}" reg='{"required":"true"}'/>
                </td>
            </tr>
            <tr>
                <th>筛查日期</th>
                <td><%-- <tag:dateInput nullToToday="true" name="checkDt" pattern="yyyy/MM/dd" onlypast="true" date="${listCc.checkDt}"/> --%>
                	<input type="text" class="layui-input x-admin-content-sm-date" name="checkDt" id="checkDt" value="<fmt:formatDate value='${listCc.checkDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                </td>
            </tr>
            <tr>
                <th><label class="required">筛查者症状</label></th>
                <td><ehr:dic-radio dicmeta="PH00002" name="checkSympton" code="1,2" value="${listCc.checkSympton}" reg='{"required":"true"}'/></td>
            </tr>
            <tr>
                <th>PPD试验(mm)</th>
                <td><ehr:dic-radio name="ppd" dicmeta="CV0300404" code="2,3" value="${listCc.ppd}"/></td>
            </tr>
            <tr>
                <th>X光片检查</th>
                <td><ehr:dic-radio dicmeta="FS10039" name="x" value="${listCc.x}"/></td>
            </tr>
            <tr>
                <th>痰涂片检查</th>
                <td><ehr:dic-radio name="pic" dicmeta="PH00022" code="1,2,3,4,5" value="${listCc.pic}"/></td>
            </tr>
            <tr>
                <th>诊断结果</th>
                <td><ehr:dic-radio dicmeta="IDM00254" name="diagnosisResult" value="${listCc.diagnosisResult}"/></td>
            </tr>
            <tr>
                <th>新确诊患者登记号</th>
                <td><input type="text" name="newRegistNo" value="${listCc.newRegistNo}"/></td>
            </tr>
            <tr>
                <th ><label class="required">登记日期</label></th>
                <td><%-- <tag:dateInput reg='{"required":"true"}' nullToToday="true" name="registDt" pattern="yyyy/MM/dd" onlypast="true" date="${listCc.registDt}"/> --%>
                	<input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" name="registDt" id="registDt" value="<fmt:formatDate value='${listCc.registDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                </td>
            </tr>
        </table>
    </form>
</fieldset>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#registDt'
            ,format: 'yyyy/MM/dd'
            , trigger: 'click'
        });
        laydate.render({
            elem: '#checkDt'
            ,format: 'yyyy/MM/dd'
            , trigger: 'click'
        });
        
    });
</script>