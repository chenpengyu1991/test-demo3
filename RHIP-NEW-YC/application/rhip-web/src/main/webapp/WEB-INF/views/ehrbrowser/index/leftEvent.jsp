<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/index/lifeEvent.js" type="text/javascript"></script>
<input id="hiddenPersonId" type="hidden" value="${lifeEventPersonId}"/>
<div id="lifeEventChart"  style="min-height: 400px;">

    数据加载中...
</div>
<p>提示： 图中每一个点代表一次事件，点击事件点可以查看事件详细</p>
<p>当事件分布比较紧密的时候，可以按住鼠标左键选中要查看的几个事件的图标，这时选中的区域会放大，便于查看</p>
<p>在区域放大的情况下想要恢复到原始大小，可以点击右上角的“重置图表”</p>