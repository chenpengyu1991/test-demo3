<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-6-18
  Time: 上午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/portal/stop/stopDetail_search.js" type="text/javascript"></script>


<div class="postcontent">
<!-- 医生基本信息-->
<div class="postdiv">
    <form method="post" id="stop_detail_search">
        <fieldset>
            <legend>停诊医生基本信息</legend>

            <table style="width:99%" class="posttable">
                <colgroup >
                    <col width="15%" />
                    <col width="30%" />
                    <col width="15%" />
                    <col width="30%" />
                <colgroup>
                <tbody>
                    <tr>
                        <th>医生姓名：</th>
                        <td>${stopDoctor.doctorName}</td>
                        <th>医生编号：</th>
                        <td>${stopDoctor.doctorSn}</td>
                    </tr>
                    <tr>
                        <th>所属科室：</th>
                        <td>${stopDoctor.deptName}</td>
                        <th>所属医院：</th>
                        <td><ehr:org code="${stopDoctor.hospitalCode}"></ehr:org></td>
                    </tr>
                    <tr>
                        <th><label class="required">停诊开始时间：</label></th>
                        <td class="colinput">
                            <input name="doctorName" type="hidden" value='${stopDoctor.doctorName}' />
                            <input name="doctorSn" type="hidden" value='${stopDoctor.doctorSn}' />
                            <input name="deptSn" type="hidden" value='${stopDoctor.deptSn}' />
                            <input name="hospitalCode" type="hidden" value='${stopDoctor.hospitalCode}' />
                        <tag:dateInput name="startDate"  date="${stopDoctor.startDate}" style="width:45%;"
                                       id="startDate"></tag:dateInput>
                        </td>
                        <th><label class="required">停诊结束时间：</label></th>
                        <td class="colinput">
                            <tag:dateInput name="endDate" date="${stopDoctor.endDate}" style="width:45%;"
                                           id="endDate"></tag:dateInput>
                        </td>
                    </tr>
                </tbody>
            </table>
        </fieldset>
        <br/><br/>
        <div style="text-align: center;">
            <input id="stop1_search_btn" class="search_btn" type="button" onclick="stopDetailSearch.search(1)"  value="停诊"/>
        </div>
    <div id="stopDetail_records"></div>
    </form>
</div>
</div>
