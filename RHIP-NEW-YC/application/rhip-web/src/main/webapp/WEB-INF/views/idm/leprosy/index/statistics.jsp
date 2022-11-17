<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>
	<div id="statisticsId" class="thirdMenu">
        <span class="active">
			<a id="contactStatisticsId" href="javascript:void(0)" >密切接触者汇总表</a>
		</span>
		<a>|</a>
        <span>
			<a id="followupStatisticsId" href="javascript:void(0)">随访观察汇总表</a>
		</span>
    </div>

    <div id="contactStatisticsPage">
        <jsp:include page="../statistics/search.jsp"/>
    </div>
    <div id="followupStatisticsPage" style="display: none;">
    </div>
</div>