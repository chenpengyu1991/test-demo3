<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/offRecord.css" type="text/css"  rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ehr/person/offPersonRecord.js" type="text/javascript"></script>
<div class="postcontent">
	<div id="msgError" class="msgError" style="display: none;">   </div>
	<form id="offForm" method="post" class="layui-form"> 
	<input type="hidden" value="${personCanceledInfo.id}" name="id"/>
	<input type="hidden" value="${personId}" name="personId"/>
	<input type="hidden" value="${cancelPersonName}" name="personName"/>
	<input type="hidden" value="${status}" name="isApprove"/>
	<input type="hidden" value="${idCard}" name="idCard"/>
	<table class="posttable searchArea contentItem">
		<colgroup>
			<col style="min-width: 120px; width: 25%;"/>
			<col style="min-width: 150px; width: 75%;"/>
		</colgroup>
		<tr>
			<th><label class="required">结案原因：</label></th>
			<td>
			<div class="layui-form-item">
			    <div class="layui-input-block" style="margin-left: 0px;">
			     <!-- <input type="radio"  name="canceledReason" value="1" checked="checked" title="最新" lay-filter="canceledReason"/>
			     <input type="radio"  name="canceledReason" value="2"  title="最新" lay-filter="canceledReason"/> -->
				<c:if test="${status!=2}">
					<ehr:dic-radio dicmeta="FS10311"  name="canceledReason" value="${personCanceledInfo.canceledReason}" reg='{"required":"true"}' layFilter="canceledReason" />
				</c:if>
				<c:if test="${status==2}">
					&nbsp;${personCanceledInfo.canceledReason ne 2 ? '结案': '其它'}
				</c:if>
				</div>
				</div>
			</td>
		</tr>
		<tr id="cancelReasonDateTr" style="display: none">
			<th><label class="required" id="cancelReasonDateLable">死亡时间：</label></th>
			<td>
				<%-- <tag:dateInput reg='{"required":"true"}' name="canceledReasonDate" date="${personCanceledInfo.canceledReasonDate}" onlypast="true" style="width:150px"/> --%>
				<input type="text" class="layui-input x-admin-content-sm-date" placeholder="请选择时间" name="canceledReasonDate" id="canceledReasonDate" reg='{"required":"true"}' style="padding-left: 0px;width: 150px;">
				
			</td>
		</tr>
		<tr id="movePlaceTr" style="display: none">
			<th><label class="required">迁往地点：</label></th>
			<td>
				<input type="text" name="movePlace" value="${personCanceledInfo.movePlace}" reg='{"maxlength":"100","required":"true"}' class="layui-input" style="width:448px;"/>
			</td>
		</tr>
		<tr id="archivesHandoverRecordTr" style="display: none">
			<th><label class="required">档案交接记录：</label></th>
			<td>
				&nbsp;<textarea name="archivesHandoverRecord" rows="5" cols="40"  style="width:90%" reg='{"maxlength":"100","required":"true"}' <c:if test="${status==2}" >readonly="readonly"</c:if>>${personCanceledInfo.archivesHandoverRecord}</textarea>
			</td>
		</tr>
		<tr id="otherReasonTr" style="display: none">
			<th><label class="required" id="cacelReasonLabel">原因：</label></th>
			<td>
				<input type="text" name="otherReason" value="${personCanceledInfo.otherReason}" reg='{"maxlength":"100","required":"true"}' class="x-layui-input" style="width:448px;"/>
			</td>
		</tr>
		<tr>
			<th>备&emsp;&emsp;注：</th>
			<td>
				&nbsp;<textarea name="remark" rows="5" cols="40"  style="width:90%" reg='{"maxlength":"166"}' class="x-layui-textarea" <c:if test="${status==2}" >readonly="readonly"</c:if>>${personCanceledInfo.remark}</textarea>
			</td>
		</tr>
		<tr>
			<th>结案时间：</th>
			<td>
				<c:if test="${status!=2}">
					<jsp:useBean id="today" class="java.util.Date"/>
					&nbsp;<%-- <tag:dateInput reg='{"required":"true"}' name="canceledDate" date="${today}" onlypast="true" style="width:150px"/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" placeholder="时间" name="canceledDate" id="canceledDate" reg='{"required":"true"}' value="<fmt:formatDate value="${today}" pattern="yyyy/MM/dd"/> " style="padding-left: 0px;width: 150px;">
				</c:if>
				<c:if test="${status==2}">
					&nbsp;<fmt:formatDate value="${personCanceledInfo.canceledDate}" pattern="yyyy/MM/dd"/> 
				</c:if>
			</td>
		</tr>
		<c:if test="${status==2}">
			<tr>
				<th>审核：</th>
				<td width="100px">
					&nbsp;<label><input type="radio" name="status" value="9" onclick='$("#tdRefusalReason").hide();' checked="checked"/> 通过</label>
					&nbsp;<label><input type="radio" name="status" value="3" onclick='$("#tdRefusalReason").show();' /> 不通过</label>
				</td>
			</tr>
		</c:if>
		<tr id="tdRefusalReason" style="display: none">
			<th>退回原因：</th>
			<td>
				<textarea reg='{"maxlength":"166"}' name="rejectedReason" rows="5" cols="40">${personCanceledInfo.rejectedReason}</textarea>  
			</td>
		</tr>
	</table>
	</form>
</div>
<div style="text-align: center;">
	<c:choose> 
	   <c:when test="${status==2}">
			<%-- <input type="button" id="off_button" value="审核" class="search_btn width100 button"/> --%>
			<button class="layui-btn layui-btn-sm"  id="off_button">审核</button>
	   </c:when> 
	   <c:otherwise>  
			<%-- <input type="button" id="off_button" value="结案" class="search_btn width100 button"/> --%>
			<button class="layui-btn layui-btn-sm"  id="off_button" lay-filter="off_button">结案</button>
	   </c:otherwise> 
	</c:choose> 
</div>

<script>
layui.use('form', function() {
  var form = layui.form;
  form.render();
  form.on('radio(canceledReason)', function(data){
	  controlDateTimeView();
	  $('input:radio[name="canceledReason"]').parent().removeClass('lose');
  });
});

layui.use('laydate', function() {
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#canceledReasonDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	,done:function(value,date) {
        if(!$.isEmpty(value)){
            $("#canceledReasonDate").removeClass("lose");
        }else{
            $("#canceledReasonDate").addClass("lose");
        }
    }
    });

    
    //执行一个laydate实例
    laydate.render({
      elem: '#canceledDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	,done:function(value,date) {
        if(!$.isEmpty(value)){
            $("#canceledDate").removeClass("lose");
        }else{
            $("#canceledDate").addClass("lose");
        }
    }
    });

  });

function controlDateTimeView() {

	//字典：FS10311：1死亡，2迁出，3失访，9其他
    var canceledReason = $('input:radio[name="canceledReason"]:checked').val();
    $('#otherReasonTr').hide();
    if("1" == canceledReason){
		$('#cancelReasonDateLable').text("死亡时间：");
		$('#cacelReasonLabel').text("死亡原因：");
        $('#otherReasonTr').show();
	}
    if("2" == canceledReason){
        $('#cancelReasonDateLable').text("迁出时间：");
        $('#movePlaceTr').show();
        $('#archivesHandoverRecordTr').show();
    }else{
        $('#movePlaceTr').hide();
        $('#archivesHandoverRecordTr').hide();
	}
    if("3" == canceledReason){
        $('#cancelReasonDateLable').text("失访时间：");
    }
    if("9" == canceledReason){
        $('#cancelReasonDateLable').text("发生时间：");
        $('#cacelReasonLabel').text("原因：");
        $('#otherReasonTr').show();
    }
    if(!$.isEmpty(canceledReason)){
    	$('#cancelReasonDateTr').show();
	}

}
</script>