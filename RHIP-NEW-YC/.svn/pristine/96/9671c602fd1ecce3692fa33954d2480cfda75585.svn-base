<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="posttable">
	<colgroup>
		<col style="min-width: 100px; width: 30%" />
		<col style="min-width: 150px; width: 70%" />
	</colgroup>
		<tr>
		<th><label class="required" for="visitDate">随访日期</label></th>
		<td>
		<%-- <tag:dateInput style="width:178px;" onlypast="true" id="visitDate" name="visitDate" date="${strtum.visitDate}" reg="{'required':true}" /> --%>
		<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}"  name="visitDate" id="commonVisitDateId" value="<fmt:formatDate value='${strtum.visitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
		</td>
	</tr>
	<tr>
		<th><label class="required"  for="visitWayCode">随访方式</label></th>
		<td>
		<ehr:dic-radio dicmeta="DMD00026" value="${strtum.visitWayCode}" name="visitWayCode" reg="{'required':true}"  ></ehr:dic-radio>
	</tr>
</table>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#commonVisitDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
    

  });
</script>