<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
    $(function(){
        $("#closeDetail1").hide();
        $("#closeDetail2").hide();
    })
</script>
<input type="hidden" id="patientNameCC" value="${listCc.patientName}">
<input type="hidden" id="registNoCC" value="${listCc.registNo}">
<div class="toolbar">
    <%-- <a href="javascript:void(0)" onclick="javascript:tbCommon.returnSearch('standardization.searchTemp')"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" onclick="javascript:tbCommon.returnSearch('standardization.searchTemp')"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${logoff !=1 }">
        <%-- <a href="javascript:void(0)" onclick="javascript:contact.initAddCc()"  id="xinzeng" style="display: none"><b class="xinz">新增</b></a> --%>
        <a href="javascript:void(0)" onclick="javascript:contact.initAddCc()" id="xinzeng" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
        <%--<a href="javascript:void(0)" onclick="javascript:contact.updateCc()" id="xiugai" style="display: none"><b class="xiug">修改</b></a>--%>
        <%-- <a href="javascript:void(0)" onclick="javascript:contact.updateCc()" id="xiugai" style="display: none"><b class="baocun">保存</b></a> --%>
        <a href="javascript:void(0)" onclick="javascript:contact.updateCc()"  id="xiugai"style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        <%-- <a href="javascript:void(0)" onclick="javascript:contact.addCc()" id="baocun"><b class="baocun">保存</b></a> --%>
        <a href="javascript:void(0)" onclick="javascript:contact.addCc()" id="baocun"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        <!-- <a href="javascript:void(0)" onclick="javascript:contact.deleteCc()" id="shanchu" style="display: none"><b class="zuofei">删除</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:contact.deleteCc()" id="shanchu" style="display: none" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe640;</i>删除</button></a>
    </c:if>
    <!-- <a href="javascript:void(0)" onclick="javascript:contact.contactsExport()"><b class="export">导出</b></a> -->
    <a href="javascript:void(0)" onclick="javascript:contact.contactsExport()"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
</div>
<div class="divFixed125" style="top: 200px;">
    <div class="repeattable" id="contactsList" style="width:300px; float: left;margin-right: 10px; margin-top: 10px; margin-left: 10px;">
        <table id="ccList" class="layui-table x-admin-sm-table-list-small">
            <colgroup>
                <col style="width:20px"/>
                <col style="width:50px"/>
                <col style="width:50px"/>
            </colgroup>
            <thead>
            <tr>
                <th class="centerth">序号</th>
                <th class="centerth">接触者姓名</th>
                <th class="centerth">登记日期</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contact" items="${listCcs}" varStatus="status">
                <tr onclick="contact.clickRow(this)" id="${contact.id}">
                    <td>${status.index + 1}</</td>
                    <td>${contact.closeName}</td>
                    <td class="centertd"><fmt:formatDate value="${contact.registDt}" pattern="yyyy/MM/dd" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table class="mini">
            <tr>
                <ehr:pagination-mini action="contact.search" colspan="3" />
            </tr>
        </table>
    </div>
    <div class="postcontent postdiv" id="detailDiv">
        <fieldset style="margin-top: 10px">
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
                        <td><input type="text" id="patientNameFr" name="patientName" value="${listCc.patientName}" reg='{"maxlength":"100"}' style="disabled:true;" readonly="true"/></td>
                    </tr>
                    <tr>
                        <th>涂阳患者登记号</th>
                        <td><input type="text" id="registNoFr" name="registNo" value="${listCc.registNo}" reg='{"maxlength":"20"}' style="disabled:true;" readonly="true"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">接触者姓名</label></th>
                        <td><input type="text" name="closeName" value="${listCc.closeName}" reg='{"required":"true","maxlength":"100"}'/></td>
                    </tr>
                    <tr>
                        <th>性别</th>
                        <td><ehr:dic-radio dicmeta="GBT226112003" code="1,2"  name="sex" value="${listCc.sex}"/> </td>
                    </tr>
                    <tr>
                        <th>年龄</th>
                        <td><input type="text" name="age" value="${listCc.age}" reg='{"maxlength":"20"}' /></td>
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
                        <td><ehr:dic-radio name="checkSympton" dicmeta="PH00002" code="1,2" value="${listCc.checkSympton}" reg='{"required":"true"}'/></td>
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
                        <td><input type="text" name="newRegistNo" value="${listCc.newRegistNo}" reg='{"maxlength":"20"}'/></td>
                    </tr>
                    <tr>
                        <th ><label class="required">登记日期</label></th>
                        <td>
                            <%--<tag:dateInput reg='{"required":"true"}' nullToToday="true" name="registDt" pattern="yyyy/MM/dd" onlypast="true" date="${listCc.registDt}"/>--%>
                            <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" name="registDt" id="registDt" value="<fmt:formatDate value='${listCc.registDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                        </td>
                    </tr>
                </table>
            </form>
            </fieldset>
	</div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#registDt'
            ,format: 'yyyy/MM/dd'
            , trigger: 'click'
            ,done:function (value) {
                if(!$.isEmpty(value)){
                    $("#registDt").removeClass("lose");
                }else{
                    $("#registDt").addClass("lose");
                }
            }
        });
        laydate.render({
            elem: '#checkDt'
            ,format: 'yyyy/MM/dd'
            , trigger: 'click'
        });
        
    });
</script>