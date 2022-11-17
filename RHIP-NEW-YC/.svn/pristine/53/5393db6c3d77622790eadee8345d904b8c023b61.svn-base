
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/views/he/promorion/edit.js" type="text/javascript"></script>

<form  id="healthPromorionForm">
    <input name="id" type="hidden" value="${healthPromorion.id}">
    <input type="hidden" value="${healthPromorion.operatorType}" name="operatorType" id="operatorType">
    <input type="hidden" name="times" value="${healthPromorion.times}">

    <div class="postcontent">
        <div class="toolbar">
            <a href="javascript:void(0)" id="back-btn"><b class="fanhui">返回</b></a>
            <a href="javascript:void(0);" id="save-btn"><b class="baocun">保存</b></a>
        </div>
        <div class="postdiv">
            <fieldset>
                <legend>基本信息</legend>
                <table class="posttable" style="width:99%">
                    <colgroup>
                        <col style="width: 20%;"/>
                        <col style="width: 80%;"/>
                    </colgroup>
                    <tr>
                        <th><label class="required">宣传标题</label></th>
                        <td>
                            <input name="promorionTitle" type="text" reg='{"required":"true","maxlength":"200"}'
                                   value="${healthPromorion.promorionTitle}"/></td>
                        </td>

                    </tr>
                    <tr>
                        <th>是否发布</th>
                        <td>
                            <ehr:dic-radio name="status" dicmeta="LH00007" value="${healthPromorion.status}"/>
                        </td>

                    </tr>
                </table>
            </fieldset>
        </div>
        <div class="postdiv">
            <fieldset>
                <legend>宣传内容</legend>
                <table style="width: 99%" class="posttable">
                    <tbody>
                    <tr>
                        <td>
                            <c:choose>
                                <c:when test="${healthPromorion.operatorType=='1'}">
                                    <div>${healthPromorion.promorionContent}</div>
                                </c:when>
                                <c:otherwise>
                                    <SCRIPT id="editor" type=text/plain>${healthPromorion.promorionContent} </SCRIPT>
                                    <input type="hidden" name="promorionContent" id="promorionContent"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>

    </div>
</div>
</form>
