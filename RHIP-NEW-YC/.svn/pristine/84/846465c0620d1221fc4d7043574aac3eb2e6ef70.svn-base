<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="toolbar" style="margin-top: 10px;margin-right: 25px;">
	<!-- <a href="javascript:void(0)" id="fdm-report-back-btn"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="fdm-report-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<jsp:include page="input.jsp"></jsp:include>
<script type="text/javascript">
	!(function() {
        toggleOtherCK('nerveSymptom','pupilException','513');
        toggleOtherCK('previousHistory','previousHistoryOther','99');
        toggleOtherCK('foodHistory','foodHistoryOther','99');
		$(function() {
			$("#fdm-report-back-btn").on("click", back);
			
			makeFormViewOnly($("#report-input-form"));
		});

		function makeFormViewOnly($form) {
			if ($form)
			{
				$form.find("input,textarea").prop("readonly", true);
				$form.find("input[type='checkbox']").prop("disabled", true);
				$form.find("input[type='radio']").prop("disabled", true);
				$form.find("select").prop("disabled", true);
				$form.find(".required").removeClass("required");
			}
		}
		
		function back() {
			fdReportCardSearch.back();
		}

	})();
</script>