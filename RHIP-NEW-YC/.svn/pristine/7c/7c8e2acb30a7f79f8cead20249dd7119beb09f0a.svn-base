<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div id="access-content">
    <script language="JavaScript">
        $(function(){
            $("#access-submit-btn").on("click",function(){
                var parent=$("#access-content").parent();
                var id=parent.attr("id");
                var personId=$("input[name='personId']","#accsess-password-input-form").val();
                var submitFormLoadHtmlOption = {
                    url:"/ehrbrowser/index/"+personId,
                    insertDiv : id
                };
                $("#accsess-password-input-form").submitFormLoadHtml(submitFormLoadHtmlOption);
            });
        });
    </script>
    <form id="accsess-password-input-form">
        <input type="hidden" name="personId" value="${personId}">
        <div class="postcontent">
            <div class="postdiv">
                <fieldset>
                    <legend>已加密档案</legend>
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 15%;min-width:100px;"/>
                            <col style="width: 35%;min-width:200px;"/>
                            <col style="width: 15%;min-width:100px;"/>
                            <col style="width: 35%;min-width:200px;"/>
                        </colgroup>
                        <tr>
                            <td colspan="2" >
                                <label style="color: red" >  ${accessMessage}</label>
                            </td>
                        </tr>
                        <tr>
                            <td><label>密码</label></td>
                            <td><input name="password" type="password" ></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="button" id="access-submit-btn" value="提交"></td>
                        </tr>
                    </table>
                </fieldset>
            </div>
        </div>
    </form>
</div>
