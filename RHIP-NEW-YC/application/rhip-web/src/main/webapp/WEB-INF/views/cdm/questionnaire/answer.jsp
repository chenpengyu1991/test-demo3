<%--
  Created by IntelliJ IDEA.
  User: mei
  Date: 17-5-19
  Time: 下午1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" >
    var questionnaire = (function() {
        var validate;
        $(function () {
            validate = $('#questionForm').easyValidate();
            $("#saveQuestionBtn").click(function() {
                save();
            });
            $("#resultBtn").click(function() {
                result();
            });
        })
        function save() {
            if (validate.validateForm()) {
                $('#questionForm').submitFormGetJson({
                    url: '/cdm/Questionnaire/save',
                    callback: function(data) {
                        if (data.success) {
                            layer.alert("保存成功！", {icon:0,title:'提示'});
                        } else {
                            layer.alert(data.message, {icon:0,title:'提示'});
                        }
                    }
                });
            }
        }

        function result(){
            $("#answerDiv").hide();
            $.loadHtmlByUrl({
                url : '/cdm/Questionnaire/result',
                insertDiv :"resultDiv"
            });
            $("#resultDiv").show();
        }
    })();
</script>
<div id="answerDiv">
    <div class="toolbar" align="right">
            <a href="javascript:void(0)" id="resultBtn"><b class="liulanjl">调查结果</b></a>
            <a href="javascript:void(0)" id="saveQuestionBtn"><b class="baocun">保存</b></a>
    </div>
    <div class="postcontent">
        <i class="popno"><i class="popno">健康状况基线(随访)问卷</i></i>
        <div class="postdiv">
            <form id="questionForm" action="">
                <fieldset>
                    <legend>调查对象</legend>
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 15%"/>
                            <col style="width: 35%"/>
                            <col style="width: 15%"/>
                            <col style="width: 35%"/>
                        </colgroup>
                        <tr>
                            <th><label class="required">性别</label></th>
                            <td><ehr:dic-radio name="sex" dicmeta="GBT226112003" code="1,2"
                                               value="" reg="{'required':true}"/></td>
                            <th><label class="required">年龄</label></th>
                            <td><input type="text" name="age" value="" reg="{'required':true,'digits':true}" maxlength="3" style="width: 30px"></td>
                        </tr>
                    </table>
                </fieldset>
                <fieldset>
                    <legend>健康核心知识和健康行为调查表</legend>
                    <table class="posttable">
                        <colgroup>
                            <col />
                            <col />
                        </colgroup>
                        <c:forEach items="${list}" var="quest" varStatus="st">
                        <tr>
                            <td><b>${st.index+1}.${quest.question}</b> <c:if test="${quest.type eq '2'}">(可多选)</c:if></td>
                            <td>
                                <c:if test="${quest.type eq '1'}">
                                    <ehr:dic-radio dicmeta="${quest.answerCode}" name="answers[${st.index}].answer" reg="{'required':true}" />
                                </c:if>
                                <c:if test="${quest.type eq '2'}">
                                    <ehr:dic-checkbox dicmeta="${quest.answerCode}" name="answers[${st.index}].answer" reg="{'required':true}" />
                                </c:if>
                                <input type="hidden" name="answers[${st.index}].questionCode" value="${quest.questionCode}">
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </fieldset>

            </form>
        </div>
    </div>
</div>
<div id="resultDiv">
</div>