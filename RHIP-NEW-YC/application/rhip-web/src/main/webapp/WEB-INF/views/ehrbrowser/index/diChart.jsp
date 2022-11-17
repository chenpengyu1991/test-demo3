<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/index/diChart.js" type="text/javascript"></script>
<input id="ehrbrw_hbp_chart_person_id" type="hidden" value="${personId}"/>

<div id="ehrbrw-index-di-chart"  style="min-height: 400px;">
    数据加载中...
</div>
<p>    提示：</p>

<p> 当时间分布比较紧密的时候，可以按住鼠标左键在一定范围内拖动，这时选中的区域会放大，便于查看；
</p>

<p> 在区域放大的情况下想要恢复到原始大小，可以点击右上角的“重置图表”。
</p>