<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/reportRecord/add/add.js" type="text/javascript"></script>
<div class="toolbar">
	<!-- <a href="javascript:void(0)" id="hsa-report-record-deal-btn"><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)" id="hsa-report-record-deal-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form id="hsa-report-record-deal-form">
	<div class="postcontent">
		<i class="popno">报告登记-处理</i>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<input type="hidden" name="id" value="${reportRecord.id}">
				<table class="posttable">
					<colgroup>
						<col style="width: 12%; min-width: 50px;" />
						<col style="width: 38%; min-width: 300px;" />
						<col style="width: 12%; min-width: 50px;" />
						<col style="width: 38%; min-width: 300px;" />
					</colgroup>
					<tr>
						<th><label class="required">处理时间</label></th>
						<td><%-- <tag:dateInput name="dealDate"  date="${reportRecord.dealDate }" reg="{'required':'true'}"></tag:dateInput> --%>
						<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="dealDate" id="dealDateId" value="<fmt:formatDate value='${reportRecord.dealDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th><label class="required" for="dealAdvice">处理意见</label></th>
						<td><textarea style="min-width: 500px; height: 120px" class="disabledInfoContent" id="dealAdvice" name="dealAdvice"
								reg="{'required':'true','maxlength':200}"
							>${reportRecord.dealAdvice}</textarea></td>
					</tr>
					<tr>
						<th><label class="required">回访</label></th>
						<td><ehr:dic-radio reg="{'required':'true'}" name="visitFlag" value="${reportRecord.visitFlag}" dicmeta="FS10246"></ehr:dic-radio></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#dealDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

   
  });
</script>