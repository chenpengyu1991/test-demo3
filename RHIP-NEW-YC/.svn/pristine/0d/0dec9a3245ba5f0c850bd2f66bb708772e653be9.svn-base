<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/ai.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:standardSearch.returnSearch()" id="cancelContact"><b class="fanhui">返回</b></a>
        <a href="javascript:ai.submitAi()"><b class="baocun">保存</b></a>
    </div>
</div>
<form id="aiListForm">
    <input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
    <input type="hidden" id="type" name="type" value="${type}"/>
    <input type="hidden" id="listAiJson" name="listAiJson"/>
    <div class="postcontent">
        <i class="popno">主动侦查记录表 </i>
        <div class="postdiv" style="margin-top: 10px;">
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 90%" />
                    </colgroup>
                    <tr>
                        <th><label class="required">调查地点：</label></th>
                        <td>
                            <ehr:dic-town-village villageId="checkStreet" townId="checkTownShip" villageName="checkStreet" townName="checkTownShip"
                                                  villageValue="${listAi.checkStreet}" townValue="${listAi.checkTownShip}" width="180px;"
                                                  reg='{"required":"true"}'/>
                            <input type="text" id="checkHouseNumber" name="checkHouseNumber" value="${listAi.checkHouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 200px;">
                            <span id="spanPaNumber">(详细地址)</span>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
        <div class="repeattable">
            <table id="aiTable">
                <thead>
                    <tr>
                        <th class="centerth" style="width: 60px;">姓名</th>
                        <th class="centerth" style="width: 60px;">户主</th>
                        <th class="centerth" style="width: 60px;">性别</th>
                        <th class="centerth" style="width: 80px;">年龄</th>
                        <th class="centerth" style="width: 80px;">走访结果</th>
                        <th class="centerth" style="width: 60px;">血检访视</th>
                        <th class="centerth" style="width: 80px;">血检结果</th>
                        <th class="centerth" style="width: 80px;">诊断结果</th>
                        <th class="centerth" style="width: 80px;">备注</th>
                        <th class="centerth" style="width: 80px;">
                            <div class="toolbarsublist" style="text-align: center"><a href="javascript:ai.popupAi()"><b class="xinz">新增</b></a></div>
                        </th>
                    </tr>
                </thead>
                <c:forEach var="ai" items="${malariaDto.listAi}" varStatus="status">
                    <tr>
                        <td field="name"><ehr:tip>${ai.name}</ehr:tip></td>
                        <td field="headHouseholdName"><ehr:tip>${ai.headHouseholdName}</ehr:tip></td>
                        <td field="genderStr"><ehr:tip>${ai.genderStr}</ehr:tip></td>
                        <td field="age"><ehr:tip>${ai.age}</ehr:tip></td>
                        <td field="visitResultStr"><ehr:tip>${ai.visitResultStr}</ehr:tip></td>
                        <td field="checkTypeStr"><ehr:tip>${ai.checkTypeStr}</ehr:tip></td>
                        <td field="checkResultStr"><ehr:tip>${ai.checkResultStr}</ehr:tip></td>
                        <td field="diagnosisResult"><ehr:tip>${ai.diagnosisResult}</ehr:tip></td>
                        <td field="comments"><ehr:tip>${ai.comments}</ehr:tip></td>
                        <td style="display: none" field="gender">${ai.gender}</td>
                        <td style="display: none" field="visitResult">${ai.visitResult}</td>
                        <td style="display: none" field="checkType">${ai.checkType}</td>
                        <td style="display: none" field="checkResult">${ai.checkResult}</td>
                        <td class="btnsublist" field="btn">
                            <a href="javascript:void(0)" onclick="ai.popupAi(this, 'edit')">修改</a>&nbsp;
                            <a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="postdiv" style="margin-top: 10px;">
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 20%" />
                        <col style="width: 40%" />
                        <col style="width: 10%" />
                        <col style="width: 20%" />

                    </colgroup>
                    <tr>
                        <th>调查人：</th>
                        <td>
                            <ehr:user userCode="${listAi.checkUser}"/>
                            <input type="hidden" id="checkUser" value="${listAi.checkUser}">
                        </td>
                        <td></td>
                        <th>上报日期：</th>
                        <td>
                            <tag:dateInput id="reportDt" name="reportDt" pattern="yyyy/MM/dd" onlypast="true" date="${listAi.reportDt}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </div>
</form>
