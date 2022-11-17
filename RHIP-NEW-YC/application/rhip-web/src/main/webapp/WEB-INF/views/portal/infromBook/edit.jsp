<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/portal/infromBook/edit.js" type="text/javascript"></script>

<div class="toolbar">
    <a href="javascript:void(0);" onclick="infromBookModel.save()" id="infromBookSubmit"><b class="baocun" >保存</b></a>
</div>

<form method="post" id="infromBookForm">
    <input type="hidden" name="id" value="${infromBook.id}" id="infromBookId"/>
    <div class="postcontent">
        <i class="popno" style="margin-top: 30px;">告知书设置 </i>
        <div class="postdiv">
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 30%"/>
                        <col style="width: 70%"/>
                    </colgroup>
                    <tr>
                        <th><label class="required">弹窗显示时间：</label></th>
                        <td>

                            <label><input type="radio" value="5" name="time" ${infromBook.time eq '5' ? 'checked' : ''} class="radioGroup" reg="{'required':'true'}">5秒</label>
                            <label><input type="radio" value="10" name="time" ${infromBook.time eq '10' ? 'checked' : ''} class="radioGroup" reg="{'required':'true'}">10秒</label>
                            <label><input type="radio" value="30" name="time" ${infromBook.time eq '30' ? 'checked' : ''} class="radioGroup" reg="{'required':'true'}">30秒</label>
                            <label><input type="radio" value="60" name="time" ${infromBook.time eq '60' ? 'checked' : ''} class="radioGroup" reg="{'required':'true'}">60秒后自动关闭</label>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">开启状态：</label></th>
                        <td>
                            <label><input type="radio" id="openInformBook" name="isOpen" class="radioGroup" value="1" ${infromBook.isOpen eq '1' ? 'checked' : ''} class="radioGroup" reg="{'required':'true'}">开启</label>
                            <label><input type="radio" id="closeInformBook" name="isOpen" class="radioGroup" value="0" ${infromBook.isOpen eq '0' ? 'checked' : ''} class="radioGroup" reg="{'required':'true'}">关闭</label>
                        </td>
                    </tr>
                </table>
            </fieldset>

            <fieldset>
                <legend>告知书内容</legend>
                <table style="width:99%" class="posttable">
                    <tbody>
                    <tr>
                        <td>
                            <SCRIPT id=editor type=text/plain> ${infromBook.contents}</SCRIPT>
                            <input type="hidden" name="contents" value=""/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </div>
</form>
