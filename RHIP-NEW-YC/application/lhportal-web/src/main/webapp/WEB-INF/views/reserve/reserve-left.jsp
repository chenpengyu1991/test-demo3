<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="text/javascript">
	function ehrHref(type){
		window.location.href = "${pageContext.request.contextPath}/userSpace" + type;
	}
	function logOut(){
		window.location.href = "${pageContext.request.contextPath}/accountInfo/loginOut";
	}	
</script>

<div class="navLeft">
	<div id="leftSubTitle" class="leftSubTitleBg">
		<ul>
			<li class="sidemenu"><a href = "${pageContext.request.contextPath}/userSpace/reserve/schedule?type=01">按医院预约</a></li>
			<li class="sidemenu"><a href = "${pageContext.request.contextPath}/userSpace/reserve/schedule?type=02">按科室预约</a></li>
            <li class="sidemenu"><a href = "${pageContext.request.contextPath}/userSpace/reserve/search">我的预约</a></li>
			<li class="sidemenu"><a href = "${pageContext.request.contextPath}/userSpace/reserve/frequent/search">常用联系人</a></li>
			<li class="sidemenu"><a href = "${pageContext.request.contextPath}/userSpace/reserve/intelligentGuidance">智能导诊</a></li>
		</ul>
	</div>
	<div id="flowChart" class="flow-chart">
	</div>
</div>