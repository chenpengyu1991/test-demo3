<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-6-9
  Time: 下午7:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="postcontent">
    <div class="postdiv">
        <fieldset style="height: 350px">
            <legend>详细信息</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 15%;"/>
                <col style="width: 35%;"/>
                <col style="width: 15%;"/>
                <col style="width: 35%;"/>
            </colgroup>
            <tr>
                <th>宣传标题</th>
                <td colspan="3">
                    ${healthPromorion.promorionTitle}
                </td>
            </tr>
            <tr>
                <th>创建时间</th>
                <td><fmt:formatDate value="${healthPromorion.createDate}" pattern="yyyy/MM/dd"/></td>
            </tr>
            <tr>
                <th>发布人</th>
                <td>
                    ${healthPromorion.userName}
                </td>
                <th>发布时间</th>
                <td><fmt:formatDate value="${healthPromorion.promorionDate}" pattern="yyyy/MM/dd"/></td>
            </tr>
            <tr>
                <th>发布内容</th>
                <td colspan="3">${healthPromorion.promorionContent}</td>
            </tr>
        </table>
            </fieldset>
    </div>
</div>
