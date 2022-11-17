<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-6-9
  Time: 下午8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script>
        function search(indexPage){
               window.location.href($("#basePath").val()+"/health/promorionMh/list?indexPage="+indexPage);
        };

        function searchHealthPromorionMhById(id) {
               var dialogParams = {
                    id : "healthPromorionDpMhId",
                    url : "/health/promorionMh/detail/"+id,
                    height : 500,
                    width : 850,
                    title : "查看健康宣传"
                };
        $.dialog(dialogParams);
    };
</script>
<input type="hidden" id="pageIndex" value="${pageIndex}">
<div class="rightnav">
    <table style="width: 95%;border: 0">
        <tr>
            <td class="dingwei"><div id="location">当前位置:&gt;&gt;健康宣传</div>
            </td>
        </tr>
    </table>
    <div  class="repeattable">
        <table>
        <colgroup>
            <col style="width: 100px;" />
            <col style="width: 100px;" />
            <col style="width: 100px;" />
            <col style="width: 100px;" />
            <col style="width: 100px;" />
        </colgroup>
        <thead>
        <tr>
            <th>机构名称</th>
            <th>宣传标题</th>
            <th>发布人</th>
            <th>发布日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${healthPromorions}"  var="promorion" >
            <tr>

                <td ><ehr:tip>${promorion.organName}</ehr:tip></td>
                <td ><ehr:tip>${promorion.promorionTitle}</ehr:tip></td>
                <td ><ehr:tip>${promorion.userName}</ehr:tip></td>
                <td  style="text-align: center; padding-left: 2px;"><fmt:formatDate value="${promorion.promorionDate}" pattern="yyyy-MM-dd"/></td>
                <td  style="text-align: center;; padding-left: 2px;">
                    <a href="javascript:void(0);" class="link" onclick="searchHealthPromorionMhById(${promorion.id})">查看</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        <table>
            <tr>
                <ehr:pagination action="search"/>
            </tr>
        </table>
</div>
</div>
