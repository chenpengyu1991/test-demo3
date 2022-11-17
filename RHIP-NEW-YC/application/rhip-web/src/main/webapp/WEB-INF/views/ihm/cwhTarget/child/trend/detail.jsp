<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script type="text/javascript">
	require(['views/ihm/cwhTarget/child/trend/detail'],function(trendDetail){
		trendDetail.load();
	});
</script>
<div class="toolbar">
	<span>
		<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="1"  />
		&nbsp;<i style="margin-top:0px;">全年</i></label>
	</span>
    <span>
	   <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="2"  checked/>
	   &nbsp;<i style="margin-top:0px;">按月</i></label>
	</span>
	<a href="javascript:void(0)" id="returnMain"><b class="fanhui">返回</b></a>
</div>
<input type="hidden" id="beginDate" value="${beginDate}"/>
<input type="hidden" id="endDate" value="${endDate}"/>
<%--1:新生儿性别构成，2：新生儿缺陷构成--%>
<input type="hidden" id="chartType" value="${chartType}"/>
<input type="hidden" id="subTitle" value="${subTitle}"/>
<div class="section" id="detailChartDiv" style="height:450px;padding:10px 20px 10px 20px;" >

</div>