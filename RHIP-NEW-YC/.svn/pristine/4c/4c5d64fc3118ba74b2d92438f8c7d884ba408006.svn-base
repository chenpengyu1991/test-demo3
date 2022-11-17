<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/sr/edit.js"/>
<div class="toolbar">
    <a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
    <a href="javascript:void(0)" id="save"><b class="baocun">保存</b></a>
</div>
<form id="form0" class="postcontent">
    <div class="postdiv">
        <table class="posttable" style="margin: 10px;">
            <colgroup>
                <col style="width: 15%"/>
                <col style="width: 35%"/>
                <col style="width: 15%"/>
                <col style="width: 35%"/>
            </colgroup>
            <tbody>
            <tr>
                <th><label class="required">科研著作类型</label></th>
                <td>
                    <ehr:dic-list name="srType" dicmeta="PCB00000" id="srType" onchange="srEdit.toggleSrType('srType')" value="${sr.srType}" reg="{'required':'true'}"></ehr:dic-list>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
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
                    <input type="hidden" name="id" value="${sr.id}"/>
                    <th>序号</th>
                    <td><input type="text" name="serialNumber" value="${sr.serialNumber}" reg="{'maxlength':30}"/></td>
                    <th><label class="required">年份</label></th>
                    <td><input type="text" name="year" value="${sr.year}" style="width: 150px" reg="{'required':'true','length':4}"/></td>
                </tr>
                <tr>
                    <th><label class="required">项目编号</label></th>
                    <td><input type="text" name="projectNo" value="${sr.projectNo}" reg="{'required':'true','maxlength':30}"></td>
                    <th>计划性质</th>
                    <td>
                        <%--<ehr:dic-list id="planCategory" name="planCategory" dicmeta="PCB00001" value="${sr.planCategory}" onchange="srEdit.changePlanCategory('planCategory')"></ehr:dic-list>--%>
                        <ehr:dic-list id="planCategory" name="planCategory" dicmeta="PCB00001" value="${sr.planCategory}" ></ehr:dic-list>
                        <%--<select id="planType" name="planType" style="display: none"></select>--%>
                        <%--<ehr:dic-list id="planType" name="planType" dicmeta="PCB00002" value="${sr.planType}"></ehr:dic-list>--%>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">项目名称</label></th>
                    <td><input type="text" name="projectName" value="${sr.projectName}" reg="{'required':'true','maxlength':30}"></td>
                    <th>承担单位</th>
                    <td><input type="text" name="bearUnit" value="${sr.bearUnit}" reg="{'maxlength':400}"></td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td><input type="text" name="department" value="${sr.department}" reg="{'maxlength':400}"></td>
                    <th>课题负责人</th>
                    <td><input type="text" name="personInCharge" value="${sr.personInCharge}" reg="{'maxlength':800}">
                    </td>
                </tr>
                <tr>
                    <th>联系电话</th>
                    <td><input type="text" name="phoneNumber" value="${sr.phoneNumber}" reg="{'maxlength':200}"></td>
                    <th>课题完成人</th>
                    <td><input type="text" name="finishedPerson" value="${sr.finishedPerson}" reg="{'maxlength':800}">
                    </td>
                </tr>
                <tr>
                    <th>经费</th>
                    <td><input type="text" name="cost" value="${sr.cost}" reg="{'maxlength':30}"></td>
                    <th>完成时间</th>
                    <td>
                        <tag:dateInput name="finishedDate" date="${sr.finishedDate}" pattern="yyyy/MM/dd" onlypast="true"></tag:dateInput>
                    </td>
                </tr>
                <tr>
                    <th>结果</th>
                    <td><ehr:dic-checkbox name="results" value="${sr.results}" dicmeta="PCB00012"></ehr:dic-checkbox></td>
                    <th>今后意向</th>
                    <td><ehr:dic-radio name="funture" value="${sr.funture}" dicmeta="PCB00013"></ehr:dic-radio></td>
                </tr>
                <tr>
                    <th>成果文号</th>
                    <td><input type="text" name="achievementNo" value="${sr.achievementNo}" reg="{'maxlength':30}"></td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}"
                                  style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>

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
                    <input type="hidden" name="id" value="${sr.id}"/>
                    <th>序号</th>
                    <td><input type="text" name="serialNumber" value="${sr.serialNumber}" reg="{'maxlength':30}"/></td>
                    <th><label class="required">年份</label></th>
                    <td><input type="text" name="year" value="${sr.year}" style="width: 150px" reg="{'required':'true','length':4}"/></td>
                </tr>
                <tr>
                    <th><label class="required">项目编号</label></th>
                    <td><input type="text" name="projectNo" value="${sr.projectNo}" reg="{'required':'true','maxlength':30}">

                </tr>
                <tr>
                    <th>获奖名称</th>
                    <td>
                        <%--<ehr:dic-list name="awardCategory" dicmeta="PCB00005" value="${sr.awardCategory}" onchange="srEdit.changeAwardCategory('awardCategory')"></ehr:dic-list>--%>
                        <ehr:dic-list name="awardCategory" dicmeta="PCB00005" value="${sr.awardCategory}"></ehr:dic-list>
                        <%--<ehr:dic-list id="awardName" name="awardName" dicmeta="PCB00006" value="${sr.awardName}"></ehr:dic-list>--%>
                        <%--<select id="awardName" name="awardName" style="display: none"></select>--%>
                    </td>
                    <th>获奖类型</th>
                    <td><input type="text" name="awardsType" value="${sr.awardsType}" reg="{'maxlength':30}"></td>
                </tr>
                <tr>
                    <th>等级</th>
                    <td><ehr:dic-list name="grade" dicmeta="PCB00009" value="${sr.grade}"></ehr:dic-list></td>
                    <th><label class="required">项目名称</label></th>
                    <td><input type="text" name="projectName" value="${sr.projectName}" reg="{'required':'true','maxlength':30}"></td>
                </tr>
                <tr>
                    <th>承担单位</th>
                    <td><input type="text" name="bearUnit" value="${sr.bearUnit}" reg="{'maxlength':400}"></td>
                    <th>科室</th>
                    <td><input type="text" name="department" value="${sr.department}" reg="{'maxlength':400}"></td>

                </tr>
                <tr>
                    <th>负责人</th>
                    <td><input type="text" name="personInCharge" value="${sr.personInCharge}" reg="{'maxlength':800}">
                    </td>
                    <th>完成人</th>
                    <td><input type="text" name="finishedPerson" value="${sr.finishedPerson}" reg="{'maxlength':800}">
                    </td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}"
                                  style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>

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
                    <input type="hidden" name="id" value="${sr.id}"/>
                    <th>序号</th>
                    <td><input type="text" name="serialNumber" value="${sr.serialNumber}" reg="{'maxlength':30}"/></td>
                    <th><label class="required">年份</label></th>
                    <td><input type="text" name="year" value="${sr.year}" style="width: 150px" reg="{'required':'true','length':4}"/></td>
                </tr>
                <tr>
                    <th>期刊级别</th>
                    <td><ehr:dic-list name="grade" dicmeta="PCB00010" value="${sr.grade}"></ehr:dic-list></td>
                    <th>期刊名称</th>
                    <td><input type="text" name="periodicalName" value="${sr.periodicalName}" reg="{'maxlength':200}"></td>
                </tr>
                <tr>
                    <th><label class="required">题目</label></th>
                    <td><input type="text" name="title" value="${sr.title}" reg="{'required':'true','maxlength':200}"></td>
                    <th>期次</th>
                    <td><input type="text" name="stage" value="${sr.stage}" reg="{'maxlength':30}"></td>
                </tr>
                <tr>
                    <th>单位</th>
                    <td><input type="text" name="bearUnit" value="${sr.bearUnit}" reg="{'maxlength':400}"></td>
                    <th>科室</th>
                    <td><input type="text" name="department" value="${sr.department}" reg="{'maxlength':400}"></td>
                </tr>
                <tr>
                    <th>通讯作者</th>
                    <td><input type="text" name="correspondingAuthor" value="${sr.correspondingAuthor}" reg="{'maxlength':800}">
                    </td>
                    <th>第一作者</th>
                    <td><input type="text" name="firstAuthor" value="${sr.firstAuthor}" reg="{'maxlength':800}">
                    </td>
                </tr>
                <tr>
                    <th>第二作者</th>
                    <td>
                        <input type="text" name="secordAuthor" value="${sr.secordAuthor}" reg="{'maxlength':800}">
                    </td>
                    <th>其他著作人</th>
                    <td>
                        <input type="text" name="otherAuthor" value="${sr.otherAuthor}" reg="{'maxlength':1000}">
                    </td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}" style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>

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
                    <input type="hidden" name="id" value="${sr.id}"/>
                    <th>序号</th>
                    <td><input type="text" name="serialNumber" value="${sr.serialNumber}" reg="{'maxlength':30}"/></td>
                    <th><label class="required">年份</label></th>
                    <td><input type="text" name="year" value="${sr.year}" style="width: 150px" reg="{'required':'true','length':4}"/></td>
                </tr>
                <tr>
                    <th>出版社</th>
                    <td><input type="text" name="press" value="${sr.press}" reg="{'maxlength':100}"></td>
                    <th>书号（ISBN）</th>
                    <td><input type="text" name="isbn" value="${sr.isbn}" reg="{'maxlength':30}"></td>
                </tr>
                <tr>
                    <th><label class="required">题目</label></th>
                    <td><input type="text" name="title" value="${sr.title}" reg="{'required':'true','maxlength':200}"></td>
                    <th>单位</th>
                    <td><input type="text" name="bearUnit" value="${sr.bearUnit}" reg="{'maxlength':400}"></td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td><input type="text" name="department" value="${sr.department}" reg="{'maxlength':400}"></td>
                    <th>主编</th>
                    <td><input type="text" name="chiefEditor" value="${sr.chiefEditor}" reg="{'maxlength':800}"></td>
                </tr>
                <tr>
                    <th>副主编</th>
                    <td><input type="text" name="subeditor" value="${sr.subeditor}" reg="{'maxlength':800}">
                    </td>
                    <th>参编</th>
                    <td><input type="text" name="participant" value="${sr.participant}" reg="{'maxlength':800}">
                    </td>
                </tr>
                <tr>
                    <th>其他编辑</th>
                    <td><input type="text" name="otherEditor" value="${sr.otherEditor}" reg="{'maxlength':1000}">
                    </td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}" style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>

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
                    <input type="hidden" name="id" value="${sr.id}"/>
                    <th>序号</th>
                    <td><input type="text" name="serialNumber" value="${sr.serialNumber}" reg="{'maxlength':30}"/></td>
                    <th><label class="required">年份</label></th>
                    <td><input type="text" name="year" value="${sr.year}" style="width: 150px" reg="{'required':'true','length':4}"/></td>
                </tr>
                <tr>
                    <th>分类</th>
                    <td><ehr:dic-list name="type" dicmeta="PCB00011" value="${sr.type}"></ehr:dic-list></td>
                    <th>专利号</th>
                    <td><input type="text" name="patentNo" value="${sr.patentNo}" reg="{'maxlength':30}"></td>
                </tr>
                <tr>
                    <th><label class="required">专利名称</label></th>
                    <td><input type="text" name="patentName" value="${sr.patentName}" reg="{'required':'true','maxlength':800}"></td>
                    <th>单位</th>
                    <td><input type="text" name="bearUnit" value="${sr.bearUnit}" reg="{'maxlength':400}"></td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td><input type="text" name="department" value="${sr.department}" reg="{'maxlength':400}"></td>
                    <th>申请人</th>
                    <td><input type="text" name="applicant" value="${sr.applicant}" reg="{'maxlength':800}"></td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <textarea name="comments" rows="3" cols="3" reg="{'maxlength':400}" style="width: 90%">${sr.comments}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>

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
                    <th style="vertical-align: middle"><label class="required">所属</label></th>
                    <input type="hidden" id="belongFlag" value="${belongFlag}">
                    <td style="vertical-align: middle">
                        <select onchange="srEdit.belongChange()" id="belong">
                            <option value="1">个人</option>
                            <option value="2">机构</option>
                        </select>
                        <a href="javascript:srEdit.popupStaff(this,'add',1)" style="padding-left: 20px;" id="addStaffBtn">
                            <b class="xinz" style="padding-left: 20px;">添加</b>
                        </a>
                    </td>
                    <td colspan="2">
                        <div class="repeattable" style="text-align: left">
                            <table style="width: 70%" id="belongStaffs">
                                <thead>
                                <tr class="listtreven">
                                    <th style="text-align: center" width="30%">姓名</th>
                                    <th style="text-align: center" width="40%">身份证号码</th>
                                    <th style="text-align: center" width="30%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="belongName" items="${sr.belongNameList}">
                                    <tr>
                                        <td style="text-align: center" field="name">${belongName[0]}</td>
                                        <td style="text-align: center" field="idCard">${belongName[1]}</td>
                                        <td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="srEdit.removeTr(this)">删除</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <span id="organTable" style="display: none">
                                <ehr:dic-town-centre-station isShow="true" centreName="belongCenterCode" centreValue="${sr.belongCenterCode}" townName="belongGbCode" townValue="${sr.belongGbCode}" isShowOther="true"  isShowInfirmary="true"
                                                         isShowHealthOversight="true"  townId="belongGbCode" centreId="belongCenterCode"  width="130px"/>
                            </span>

                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

        </fieldset>
    </div>
</div>