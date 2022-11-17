<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<script src="${pageContext.request.contextPath}/js/views/integration/public_health.js" type="text/javascript"></script>--%>
<script type="text/javascript">
    require(['views/integration/public_health'], function (public_health) {
        public_health.load();
    });
</script>

<div class="sectionnoborder">
    <ul id="tags">
        <li class=selectTag><a style="width: 53px;" id="plan_immu_btn" href="javascript:void(0)">计免数据</a></li>
        <li><a style="width: 53px;" id="women_children_btn" href="javascript:void(0)">妇幼数据</a></li>
    </ul>

    <div id="tagContent">
        <div id="tagContent3" class="selectTag">
            <jsp:include page="plan_immu_search_form.jsp"></jsp:include>
            <div id="plan_immu_content" style="height: 400px;"></div>
        </div>
        <div id="tagContent4" style="display: none;">
            <jsp:include page="women_children_search_form.jsp"></jsp:include>
            <div id="women_children_content" style="height: 400px;"></div>
        </div>
        <div id="tagContent5" style="display: none;">
            <div id="tagContent6" style="display: none;">
                <div id="medical_statistics_content" style="height: 400px;"></div>
            </div>
        </div>
    </div>
</div>