<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="toolbar">
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/sr/edit.js"/>--%>
    <a href="javascript:void(0)" id="back" onclick="srSearch.search();"><b class="fanhui">返回</b></a>
</div>
<table class="posttable" style="margin: 10px;">
    <colgroup>
        <col style="width: 15%"/>
        <col style="width: 35%"/>
        <col style="width: 15%"/>
        <col style="width: 35%"/>
    </colgroup>
    <tbody>
    <tr>
        <th>科研著作类型</th>
        <td>
            <ehr:dic code="${sr.srType}" dicmeta="PCB00000"></ehr:dic>
        </td>
    </tr>
    </tbody>
</table>
<c:if test="${sr.srType == 1}">
<form id="form1" class="postcontent">
    <div class="postdiv">
        <fieldset>
            <legend>科研项目</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
                <tr>
                    <th>序号</th>
                    <td>${sr.serialNumber}</td>
                    <th>年份</th>
                    <td>${sr.year}</td>
                </tr>
                <tr>
                    <th>项目编号</th>
                    <td>${sr.projectNo}</td>
                    <th>计划性质</th>
                    <td>
                        <ehr:dic code="${sr.planCategory}" dicmeta="PCB00001"></ehr:dic>&nbsp;&nbsp;
                        <%--<c:if test="${sr.planCategory == 1}">--%>
                            <%--<ehr:dic code="${sr.planType}" dicmeta="PCB00002"></ehr:dic>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${sr.planCategory == 2}">--%>
                            <%--<ehr:dic code="${sr.planType}" dicmeta="PCB00003"></ehr:dic>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${sr.planCategory == 3}">--%>
                            <%--<ehr:dic code="${sr.planType}" dicmeta="PCB00004"></ehr:dic>--%>
                        <%--</c:if>--%>

                    </td>
                </tr>
                <tr>
                    <th>项目名称</th>
                    <td>${sr.projectName}</td>
                    <th>承担单位</th>
                    <td>${sr.bearUnit}</td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td>${sr.department}</td>
                    <th>课题负责人</th>
                    <td>${sr.personInCharge}</td>
                </tr>
                <tr>
                    <th>联系电话</th>
                    <td>${sr.phoneNumber}</td>
                    <th>课题完成人</th>
                    <td>${sr.finishedPerson}</td>
                </tr>
                <tr>
                    <th>经费</th>
                    <td>${sr.cost}</td>
                    <th>完成时间</th>
                    <td><fmt:formatDate value="${sr.finishedDate}"></fmt:formatDate></td>
                </tr>
                <tr>
                    <th>结果</th>
                    <td><ehr:dic code="${sr.results}" dicmeta="PCB00012"></ehr:dic></td>
                    <th>今后意向</th>
                    <td><ehr:dic code="${sr.funture}" dicmeta="PCB00013"></ehr:dic></td>
                </tr>
                <tr>
                    <th>成果文号</th>
                    <td>${sr.achievementNo}</td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" style="width: 90%" readonly="true">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
</c:if>
<c:if test="${sr.srType == 2}">
<form id="form2" class="postcontent">
    <div class="postdiv">
        <fieldset>
            <legend>科研成果</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
                <tr>
                    <th>序号</th>
                    <td>${sr.serialNumber}</td>
                    <th>年份</th>
                    <td>${sr.year}</td>
                </tr>
                <tr>
                    <th>项目编号</th>
                    <td>${sr.projectNo}</td>

                </tr>
                <tr>
                    <th>获奖名称</th>
                    <td>
                        <ehr:dic dicmeta="PCB00005" code="${sr.awardCategory}"></ehr:dic>&nbsp;&nbsp;
                            <%--<c:if test="${sr.awardCategory == 1}">--%>
                            <%--<ehr:dic dicmeta="PCB00006" code="${sr.awardName}"></ehr:dic>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${sr.awardCategory == 2}">--%>
                            <%--<ehr:dic dicmeta="PCB00007" code="${sr.awardName}"></ehr:dic>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${sr.awardCategory == 3}">--%>
                            <%--<ehr:dic dicmeta="PCB00008" code="${sr.awardName}"></ehr:dic>--%>
                            <%--</c:if>--%>
                    </td>
                    <th>获奖类型</th>
                    <td>${sr.awardsType}</td>
                </tr>
                <tr>
                    <th>等级</th>
                    <td><ehr:dic code="${sr.grade}" dicmeta="PCB00009" ></ehr:dic></td>
                    <th>项目名称</th>
                    <td>${sr.projectName}</td>
                </tr>
                <tr>
                    <th>承担单位</th>
                    <td>${sr.bearUnit}</td>
                    <th>科室</th>
                    <td>${sr.department}</td>

                </tr>
                <tr>
                    <th>负责人</th>
                    <td>${sr.personInCharge}</td>
                    <th>完成人</th>
                    <td>${sr.finishedPerson}</td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}" readonly="true" style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
</c:if>
<c:if test="${sr.srType == 3}">
<form id="form3" class="postcontent">
    <div class="postdiv">
        <fieldset>
            <legend>论文期刊</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
                <tr>
                    <th>序号</th>
                    <td>${sr.serialNumber}</td>
                    <th>年份</th>
                    <td>${sr.year}</td>
                </tr>
                <tr>
                    <th>期刊级别</th>
                    <td><ehr:dic dicmeta="PCB00010" code="${sr.grade}"></ehr:dic></td>
                    <th>期刊名称</th>
                    <td>${sr.periodicalName}</td>
                </tr>
                <tr>
                    <th>题目</th>
                    <td>${sr.title}</td>
                    <th>期次</th>
                    <td>${sr.stage}</td>
                </tr>
                <tr>
                    <th>单位</th>
                    <td>${sr.bearUnit}</td>
                    <th>科室</th>
                    <td>${sr.department}</td>
                </tr>
                <tr>
                    <th>通讯作者</th>
                    <td>${sr.correspondingAuthor}</td>
                    <th>第一作者</th>
                    <td>${sr.firstAuthor}</td>
                </tr>
                <tr>
                    <th>第二作者</th>
                    <td>${sr.secordAuthor}</td>
                    <th>其他著作人</th>
                    <td>${sr.otherAuthor}</td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}" readonly="readonly" style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
</c:if>
<c:if test="${sr.srType == 4}">
<form id="form4" class="postcontent">
    <div class="postdiv">
        <fieldset>
            <legend>论著</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
                <tr>
                    <th>序号</th>
                    <td>${sr.serialNumber}</td>
                    <th>年份</th>
                    <td>${sr.year}</td>
                </tr>
                <tr>
                    <th>出版社</th>
                    <td>${sr.press}</td>
                    <th>书号（ISBN）</th>
                    <td>${sr.isbn}</td>
                </tr>
                <tr>
                    <th>题目</th>
                    <td>${sr.title}</td>
                    <th>单位</th>
                    <td>${sr.bearUnit}</td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td>${sr.department}</td>
                    <th>主编</th>
                    <td>${sr.chiefEditor}</td>
                </tr>
                <tr>
                    <th>副主编</th>
                    <td>${sr.subeditor}</td>
                    <th>参编</th>
                    <td>${sr.participant}</td>
                </tr>
                <tr>
                    <th>其他编辑</th>
                    <td>${sr.otherEditor}</td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}" readonly="readonly" style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
</c:if>
<c:if test="${sr.srType == 5}">
<form id="form5" class="postcontent">
    <div class="postdiv">
        <fieldset>
            <legend>专利发明</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
                <tr>
                    <th>序号</th>
                    <td>${sr.serialNumber}</td>
                    <th>年份</th>
                    <td>${sr.year}</td>
                </tr>
                <tr>
                    <th>分类</th>
                    <td><ehr:dic dicmeta="PCB00011" code="${sr.type}"></ehr:dic></td>
                    <th>专利号</th>
                    <td>${sr.patentNo}</td>
                </tr>
                <tr>
                    <th>专利名称</th>
                    <td>${sr.patentName}</td>
                    <th>单位</th>
                    <td>${sr.bearUnit}</td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td>${sr.department}</td>
                    <th>申请人</th>
                    <td>${sr.applicant}</td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}" readonly="readonly" style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
</c:if>
<div class="postcontent">
    <div class="postdiv">
        <fieldset>
            <legend>所属</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 20%"/>
                    <col style="width: 15%"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <th style="vertical-align: middle">所属</th>
                    <td style="vertical-align: middle">
                        <c:if test="${sr.belongName != null}">个人</c:if>
                        <c:if test="${empty sr.belongName}">机构</c:if>
                    </td>
                    <td colspan="2">
                        <c:if test="${sr.belongName != null}">
                            <div class="repeattable" style="text-align: left">
                                <table style="width: 70%" id="belongStaffs">
                                    <tr>
                                        <th style="text-align: center">姓名</th>
                                        <th style="text-align: center">身份证号</th>
                                    </tr>
                                    <c:forEach var="belongName" items="${sr.belongNameList}">
                                        <tr>
                                            <td style="text-align: center">${belongName[0]}</td>
                                            <td style="text-align: center">${belongName[1]}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${empty sr.belongName}">
                            <%--<c:if test="${!empty sr.belongGbCode}"><ehr:org code="${sr.belongGbCode}"></ehr:org></c:if>--%>
                            <c:if test="${!empty sr.belongCenterCode}"><ehr:org code="${sr.belongCenterCode}"></ehr:org></c:if>
                            <c:if test="${!empty sr.belongOrganCode}"><ehr:org code="${sr.belongOrganCode}"></ehr:org></c:if>
                        </c:if>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</div>