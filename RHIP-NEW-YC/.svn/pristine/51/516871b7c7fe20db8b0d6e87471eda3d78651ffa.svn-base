<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="toolbar">
    <div class="toolbar" style="background: none">
        <!-- <a href="javascript:messageSearch.search(1)" id="cancelContact"><b class="fanhui">返回</b></a> -->
        <a href="javascript:messageSearch.search(1)" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    </div>
</div>
<form>
    <div class="postcontent">
        <i class="popno" style="height: auto;padding-top: 10px;"> 来自 <ehr:org code="${message.createOrganCode}"></ehr:org> 的消息</i>
        <div class="postdiv">
            <fieldset class="layui-elem-field">
                <table class="posttable">
                    <colgroup>
                        <col style="width: 15%"/>
                        <col style="width: 35%"/>
                        <col style="width: 15%"/>
                        <col style="width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>主题：</th>
                        <td>${message.title}</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>内容：</th>
                        <td colspan="3">
                            <textarea name="content" rows="7" readonly="readonly">${message.content}</textarea>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </div>
</form>
