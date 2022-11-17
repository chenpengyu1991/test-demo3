<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/reserve/frequent/search.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<div class="navRight">
    <div class="contentlist">
        <div class="location">
            当前位置:<label>预约挂号</label>&gt;&gt;<label>常用联系人</label>
            <div class="location_right">

            </div>
        </div>
        <div class="contact-search" id="searchInteractionDivId">
            <form id="frequentSearch" method="post">
                <table id="interactionSearch">
                    <tr>
                       <!--  <td class="coltd">姓名:</td> -->
                       <td></td>
                        <td>
                            <input type="text" id="frequentName" name="frequentName" class="frequent-name" placeholder="  请输入姓名">
                            
                        </td>
                        <td>
                            <input id="frequentSearchBtn" class="search-btn" type="button" value="查询"/>
                            <input id="toAdd" class="add-btn" type="button" value="新增"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="contact-form" id="addFrequentForm">
            <jsp:include page="add.jsp"/>
        </div>
        <div id="listDiv"></div>
    </div>
</div>
