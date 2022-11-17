<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="dm-followup-from-content">
<form id="dm-followup-coronary-normal-from" class="dm-followup-from">
<input type="hidden"  name="id" value="${strtum.id}"  >
	<input type="hidden" name="planId" value="${strtum.planId}">
	<input type="hidden" name="followupFlag" value="${strtum.followupFlag}" />
	<input type="hidden" name="diseaseType" value="4"/>
	<c:set var="input" value="${strtum}" scope="request"></c:set>
	<input type="hidden" name="planType" id="planType" value="${planType}"/>
	<div class="postcontent">
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>冠心病常规随访</legend>
				<%-- <jsp:include page="../common/followupWay.jsp"></jsp:include> --%>
				<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
							<tr>
							<th><label class="required" for="visitDate">随访日期</label></th>
							<td>
							<%-- <tag:dateInput style="width:178px;" onlypast="true" id="visitDate" name="visitDate" date="${strtum.visitDate}" reg="{'required':true}" /> --%>
							<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" name="visitDate" id="coronaryVisitDateId" value="<fmt:formatDate value='${strtum.visitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
							</td>
						</tr>
						<tr>
							<th><label class="required"  for="visitWayCode">随访方式</label></th>
							<td>
							<ehr:dic-radio dicmeta="DMD00026" value="${strtum.visitWayCode}" name="visitWayCode" reg="{'required':true}"  ></ehr:dic-radio>
						</tr>
					</table>
					<jsp:include page="../common/physiological.jsp"></jsp:include>
					<jsp:include page="../common/newestStatus.jsp"></jsp:include>
					<jsp:include page="../common/self.jsp"></jsp:include>
					<jsp:include page="../common/druguse.jsp"></jsp:include>
					<jsp:include page="../common/nodrug.jsp"></jsp:include>
					<jsp:include page="../common/education.jsp"></jsp:include>
					<jsp:include page="../common/result.jsp"></jsp:include>
					<jsp:include page="../common/StroCorInputInfo.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>
	<jsp:include page="normalPrint.jsp"/>
</div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#coronaryVisitDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	,done:function(value) {
        if(!$.isEmpty(value)){
            $("#coronaryVisitDateId").removeClass("lose");
        }else{
            $("#coronaryVisitDateId").addClass("lose");
        }
   }
    });
    

  });
</script>