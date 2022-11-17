<%--
  Created by IntelliJ IDEA.
  User: zwk
  Date: 2014/10/28
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/fdm/addtest.js"/>

<div class="toolbar" style="margin-top: 10px;">
    <!-- <a href="javascript:void(0)" id="fdm-report-back-btn" onclick="fdReportCardSearch.back();">
        <b class="fanhui">返回</b>
    </a> -->
    <a href="javascript:void(0)" id="fdm-report-back-btn" onclick="fdReportCardSearch.back();"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <ehr:authorize ifAnyGranted="44">
        <!-- <a href="javascript:void(0)" id="save" ><b class="baocun">保存</b></a> -->
        <a href="javascript:void(0)" id="save"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </ehr:authorize>
</div>
<div class="postcontent contentfixed32">
<form id="editForm">
    <div class="postdiv">
        <fieldset id="baseDiv" class="layui-elem-field">
            <legend>基本信息</legend>
            <table class="posttable">
                <tbody>
                <colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 30%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tr>
                    <input type="hidden" name="id" value="${foodTest.id}"/>
                    <input type="hidden" name="reportId" value="${foodTest.reportId}"/>
                    <th>送检医院</th>
                    <td>
                        <ehr:org code="${foodTest.organCode}" ></ehr:org>
                        <input type="hidden" name="organCode" value="${foodTest.organCode}">
                    </td>
                    <th>检验日期</th>
                    <td>
                        <tag:dateInput name="checkDate" date="${foodTest.checkDate}"></tag:dateInput>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>细菌样本结果</legend>
            <table class="posttable">
                <tbody>
                <colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 30%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tr>
                    <th>沙门氏菌</th>
                    <td>
                        <ehr:dic-radio name="salmonella" dicmeta="FS10044" value="${foodTest.salmonella}"></ehr:dic-radio>
                    </td>
                    <th>副溶血性弧菌</th>
                    <td>
                        <ehr:dic-radio name="vpa" dicmeta="FS10044" value="${foodTest.vpa}"></ehr:dic-radio>
                    </td>
                </tr>
                <tr>
                    <th>志贺氏菌</th>
                    <td> <ehr:dic-radio name="shigella" dicmeta="FS10044" value="${foodTest.shigella}"></ehr:dic-radio>
                    </td>
                    <th>金黄色葡萄球菌</th>
                    <td> <ehr:dic-radio name="sta" dicmeta="FS10044" value="${foodTest.sta}"></ehr:dic-radio>
                    </td>
                </tr>
                <tr>
                    <th>变形杆菌</th>
                    <td> <ehr:dic-radio name="proteusMirabilis" dicmeta="FS10044" value="${foodTest.proteusMirabilis}"></ehr:dic-radio>
                    </td>
                    <th>致病性大肠杆菌</th>
                    <td> <ehr:dic-radio name="pec" dicmeta="FS10044" value="${foodTest.pec}"></ehr:dic-radio>
                    </td>
                </tr>
                <tr>
                    <th>小肠结肠炎耶尔森氏菌</th>
                    <td> <ehr:dic-radio name="ejp" dicmeta="FS10044" value="${foodTest.ejp}"></ehr:dic-radio>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>病毒样本结果</legend>
            <table class="posttable">
                <tbody>
                <colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 30%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tr>
                    <th>轮状病毒</th>
                    <td> <ehr:dic-radio name="rotavirus" dicmeta="FS10044" value="${foodTest.rotavirus}"></ehr:dic-radio>
                    </td>
                    <th>诺如病毒</th>
                    <td> <ehr:dic-radio name="norovirus" dicmeta="FS10044" value="${foodTest.norovirus}"></ehr:dic-radio>
                    </td>
                </tr>
                <tr>
                    <th>札如病毒</th>
                    <td> <ehr:dic-radio name="sapovirus" dicmeta="FS10044" value="${foodTest.sapovirus}"></ehr:dic-radio>
                    </td>
                    <th>星状病毒</th>
                    <td> <ehr:dic-radio name="astrovirus" dicmeta="FS10044" value="${foodTest.astrovirus}"></ehr:dic-radio>
                    </td>
                </tr>
                <tr>
                    <th>腺病毒</th>
                    <td> <ehr:dic-radio name="adenovirus" dicmeta="FS10044" value="${foodTest.adenovirus}"></ehr:dic-radio>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
</div>