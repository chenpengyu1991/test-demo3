<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<script src="${pageContext.request.contextPath}/js/views/integration/medical_data.js" type="text/javascript"></script>--%>
<script type="text/javascript">
	require(['views/integration/medical_data'],function(medical_data){
		medical_data.load();
	});
</script>

<div class="sectionnoborder">
	<ul id="tags">
		<li class=selectTag><a style="width: 53px;" id="hospital_medical_btn" href="javascript:void(0)">院内数据</a></li>
		<%--<li><a style="width: 79px;" id="medical_statistics_btn" href="javascript:void(0)">医疗数据统计</a></li>--%>
		<li><a style="width: 53px;" id="physical_exam_btn" href="javascript:void(0)">体检数据</a></li>
	</ul>
	
	<div id="tagContent">
		<div id="tagContent2" class="selectTag"s>
			<jsp:include page="hospital_medical_search_form.jsp"></jsp:include>
			<div id="hospital_medical_content" style="height: 400px;" ></div>
		</div>
		<div id="tagContent5" style="display: none;">
			<jsp:include page="physical_exam_search_form.jsp"></jsp:include>
			<div id="physical_examination_content" style="height: 400px;" ></div>
		</div>
		<%--<div id="tagContent6" style="display: none;">--%>
			<%--<div id="medical_statistics_content" style="height: 400px;" ></div>--%>
		<%--</div>--%>
	</div>
</div>