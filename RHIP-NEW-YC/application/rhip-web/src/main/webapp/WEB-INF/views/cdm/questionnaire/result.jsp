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
            $("#backToSearchBtn").click(function() {
                backToSearchBtn();
            });
        })
        function backToSearchBtn() {
            $("#answerDiv").show();
            $("#resultDiv").hide();
        }
    })();
</script>

<div class="toolbar" align="right">
    <a href="javascript:void(0)" id="backToSearchBtn"><b class="fanhui">返回</b></a>
</div>
<div class="postcontent">
    <i class="popno">健康状况基线(随访)问卷结果</i>
    <fieldset>
        <legend>基本情况</legend>
        <ul>
            <li>本次基线调查结果共收到有效问卷<b>${rs.total}</b>份，其中男性<b>${rs.sex1}</b>名，占<b>${rs.sex1precent}%</b>;女性<b>${rs.sex2}</b>名，占<b>${rs.sex2precent}%</b>。年龄最小的<b>${rs.minAge}</b>岁，最大的<b>${rs.maxAge}</b>岁，平均年龄<b>${rs.avgAge}</b>岁。</li>
        </ul>
    </fieldset>
</div>
<div class="repeattable">
    <form id="questionForm" action="">
        <fieldset>
            <legend>健康核心知识知晓率</legend>
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 150px;">
                    <col style="min-width: 150px;">
                    <col style="min-width: 150px;">
                </colgroup>
                <thead> <tr>
                <th></th>
                <th align="center">答对</th>
                <th align="center">知晓率</th>
                </tr></thead>
                <tbody class="tbody">
                <c:forEach items="${rs.list}" var="list" varStatus="st">
                    <tr>
                        <td align="center">第<b>${list.question_code}</b>题</td>
                        <td align="center">${list.cnt}</td>
                        <td align="center">${list.knowPercent}%</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </fieldset>

    </form>
</div>

