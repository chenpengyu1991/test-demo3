<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.PrintArea.js"></script>
<style type="text/css">
	ul.decimal {list-style-type: none;text-indent: 2em;line-height: 200%;font-size:20px;}
	ul.none {list-style-type: none}
	.printDiv {width: 645px;line-height: 200%; text-align: center}
	.backgroundDiv1{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 300px;
		width: 375px;
	}
	.backgroundDiv2{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 300px;
		width: 198px;
	}
	.backgroundDiv3{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 300px;
		width: 268px;
	}
	.backgroundDiv4{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 300px;
		width: 262px;
	}
	.backgroundDiv5{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 300px;
		width: 208px;
	}
	
	.backgroundDiv6{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 300px;
		width: 366px;
	}	
	.backgroundDiv7{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 348px;
		width: 496px;
	}	
	.backgroundDiv8{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 298px;
		width: 400px;
	}
	.backgroundDiv9{
		margin-right: auto;
		margin-left: auto;
		margin-top: 10px;
		margin-bottom: 10px;
		height: 300px;
		width: 383px;
	}							
</style>
<div id="printPage">
	<div class="print">
		<br/><br/>
		<c:choose>
			<c:when test="${type == '2'}"><jsp:include page="qiquality.jsp"></jsp:include></c:when>
			<c:when test="${type == '3'}"><jsp:include page="yangquality.jsp"></jsp:include></c:when>
			<c:when test="${type == '4'}"><jsp:include page="yindeficiency.jsp"></jsp:include></c:when>
			<c:when test="${type == '5'}"><jsp:include page="phlegmwetness.jsp"></jsp:include></c:when>
			<c:when test="${type == '6'}"><jsp:include page="heatmedium.jsp"></jsp:include></c:when>
			<c:when test="${type == '7'}"><jsp:include page="bloodquality.jsp"></jsp:include></c:when>
			<c:when test="${type == '8'}"><jsp:include page="qistagnation.jsp"></jsp:include></c:when>
			<c:when test="${type == '9'}"><jsp:include page="specialquality.jsp"></jsp:include></c:when>
			<c:when test="${type == '1'}"><jsp:include page="peaceful.jsp"></jsp:include></c:when>
		</c:choose>
		<br/>
	</div>
</div>