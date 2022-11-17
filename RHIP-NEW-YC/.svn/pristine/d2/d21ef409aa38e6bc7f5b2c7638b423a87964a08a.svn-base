<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/index/main.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/util/watermark.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/index/main.css"/>

<div id="ehrbrowser_main" style="margin-top: 3px;">
    <input id="ehrbrowser_person_id_input" type="hidden" value="${personId}"/>
    <input id="ehrbrowser_person_idcard_input" type="hidden" value="${personIdcard}"/>
    <input type="hidden" id="waterMarkTxt" value="${waterMarkTxt}"/>
    <div id="header_pop" style="height: 25px;">
        <tiles:insertAttribute name="header"/>
    </div>
   <%--  <div id="ehrbrowser-content"></div> --%>
</div>
<script>
    debugger;
    var waterMarkTxtVal = $("#waterMarkTxt").val();
    watermarkUtil.watermark({ "watermarl_element": "ehrbrowser_main","watermark_txt": waterMarkTxtVal });
</script>
<%-- 市民卡控件
 <object id="CsSmkActive" classid="clsid:AE451137-38F8-4240-A9F9-6D8E182D9C16" codebase="${pageContext.request.contextPath}/activex/csSmk.cab#version=1,0,0,1" style="width:0;height:0;display:none;"></object>--%>
