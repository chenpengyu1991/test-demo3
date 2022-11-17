<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/newCitizenScoreSearch.js" type="text/javascript"></script>
<div class="section">
    <div class="searchBox">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 25%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">接口类别</td>
                    <td class="col-input">
                           <select name="logType">
                           <option value="">请选择</option>
                           <option value="1">5年内的捐献全血量</option>
                           <option value="2">5年内的捐献血小板量</option>
                           <option value="3">是否早孕建卡</option>
                           <option value="4">是否满足5次产检检查</option>
                           <option value="5">是否3星健康档案</option>
                           <option value="6">是否预防接种齐全</option>
                           <option value="7">是否办理从业人员健康证</option>
                           <option value="8">是否受过行政处罚</option>
                           <option value="9">儿童是否定期检查</option>
                       </select>
                    </td>
                    <td class="col-text">身份证号码</td>
                    <td class="col-input">
                        <input type="text" name="idCard" style="width:125px;">
                    </td>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="personName" style="width:125px;">
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="col-text">父亲/母亲姓名</td>
                    <td class="col-input">
                        <input type="text" name="parentName" style="width:150px;">
                    </td>
                     <td class="col-text">参数时间</td>
                    <td class="col-input">
                        <tag:dateInput name="operateDate" pattern="yyyyMMdd" style="width:125px;"></tag:dateInput>
                    </td>
                    <td colspan="2"></td>
                    <td style="text-align: right;">
                        <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" />
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="listDiv">
    </div>
</div>