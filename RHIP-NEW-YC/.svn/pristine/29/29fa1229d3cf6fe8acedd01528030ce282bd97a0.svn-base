<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/followup/yishareSearch.js" type="text/javascript"></script>
<form id="yshareForm">
    <%--<i class="pop_No" style="height: 40px;">
    <a href="javascript:void(0);" id="cancel_phyExam" ${currentEhrId == null and not newPerson ? '' : 'hidden'} style="margin-top: 3.5px;"><button style="background-color: #C0C0C0;" class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    </i>--%>
    <input type="hidden" name="idcard" value="${idcard}"/>
    <input type="hidden" id="module" value="${module}"/>

    <div style="padding-left: 15px; padding-right: 15px;margin-top:10px; width: auto;">
        <fieldset class="layui-elem-field">
            <%--<legend style="padding: 0 5px;color: #404040;">一体机检查记录</legend>--%>
            <table class="formtable">
                <colgroup>
                    <col style="min-width:50px; width: 12%;"/>
                    <col style="min-width:150px; width: 12%;"/>
                    <col style="min-width:70px; width: 12%;"/>
                    <col style="min-width:100px; width: 16%;"/>
                    <col style="min-width:70px; width: 12%;"/>
                    <col style="min-width:100px; width: 12%;"/>
                    <col style="min-width:70px; width: 12%;"/>
                    <col style="min-width:100px; width: 12%;"/>
                </colgroup>
                <tr>
                    <th ><label class="">姓名</label></th>
                    <td >${name}</td>
                    <th><label class="">身份证号</label></th>
                    <td>
                        ${idcard}
                    </td>
                </tr>
            </table>
        </fieldset>
    </div>
    <div id="ysharelist" style="padding-left: 15px; padding-right: 15px; width: auto;"></div>

</form>
