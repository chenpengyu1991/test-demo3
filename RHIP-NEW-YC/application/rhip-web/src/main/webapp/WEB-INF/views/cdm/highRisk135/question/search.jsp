<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-4-17
  Time: 上午9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk135/question/search.js" type="text/javascript"></script>

<div id="questionSearch" class="section">
    <div class="toolbar" align="right">
<%--        <a href="javascript:void(0)" id="addFirstQuestion"><b class="xinz">填写首次调查问卷</b></a>
        <a href="javascript:void(0)" id="addLastQuestion"><b class="xinz">填写末次调查问卷</b></a>--%>
    </div>
    <div class="searchbox">
        <form id="questionSearchForm">
            <table id="questionSearchTableId">
                <colgroup>
                    <col style="width: 11%"/>
                    <col style="width: 22%"/>
                    <col style="width: 11%"/>
                    <col style="width: 25%"/>
                    <col style="width: 11%"/>
                    <col style="width: 22%"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput"><input type="text" name="name"/></td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput"><input type="text" name="idcard" id="idCard"/>&nbsp;
                        <input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
                    </td>
                    <td class="coltext">体检年份</td>
                    <td>
                        <tag:dateInput name="createDate" pattern="yyyy" date="${currentDate}" onlypast="true"/>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">体检编号</td>
                    <td class="colinput"><input type="text" name="physicalExamNo"/></td>
                    <td class="coltext">问卷</td>
                    <td>
                        <input type="radio" name="doneQuestion" value="" checked/>全部
                        <input type="radio" name="doneQuestion" value="1"/>已做
                        <input type="radio" name="doneQuestion" value="2"/>未做
                    </td>
                    <td></td>
                    <td class="colinput">
                        <input type="button" id="questionSearchBtn" value="查询" class="search_btn" >
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span id ="questionSearchSpanId" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="questionList"></div>
</div>
<div id="questionEdit"></div>
