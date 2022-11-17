<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cleave/cleave.min.js"></script>
<script type="text/javascript">
    $("#village_address").change(displayFlAddress);
    function displayFlAddress() {
        var town = $("#town_address option:selected").text();
        var street = $("#street_address option:selected").text();
        var village = $("#village_address option:selected").text();
        if(!$.isEmpty($("#village_address option:selected").val())) {
            $("#text_flhouseNumber").removeAttr("reg");
            $("#text_flhouseNumber").removeClass("lose");
        }
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择')
            result = result + street;
        if (village != '请选择') {
            result = result + village;
        }
        $("#tempFlValue").text(result);
    }
</script>
<div class="dm-followup-from-content">
<form id="dm-followup-tumor-from" class="dm-followup-from">
	<input type="hidden" name="id" value="${tumor.id}" />
    <input type="hidden" name="planId" value="${tumor.planId}"/>
    <input type="hidden" name="followupFlag" value="${tumor.followupFlag}"/>
	<div class="postcontent">
			<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>肿瘤随访</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label class="required" for="visitDate">随访日期</label></th>
					<td>
					<%-- <tag:dateInput style="width:178px;" onlypast="true" id="visitDate" name="visitDate" date="${tumor.visitDate}" reg="{'required':true,'compare':['definitionNextDate','le','随访日期不能大于下次随访日期']}" /> --%>
					<input type="text" reg="{'required':true,'compare':['definitionNextDate','le','随访日期不能大于下次随访日期']}"  class="layui-input x-admin-content-sm-date"  name="visitDate" id="visitDate" value="<fmt:formatDate value='${tumor.visitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
					</td>
                </tr>
				<tr>
					<th>
                        <label  class="required" for="visitWayCode">随访方式</label>
                    </th>
					<td>
                        <ehr:dic-radio dicmeta="DMD00026"  value="${tumor.visitWayCode}" name="visitWayCode" reg="{'required':true}" ></ehr:dic-radio>
                    </td>
				</tr>
				<tr>
					<th>是否失访</th>
					<td><ehr:dic-radio dicmeta="FS10246" name="lossVisit" value="${tumor.lossVisit}"></ehr:dic-radio></td>
				</tr>
                <tr id="tumor-lossVisit" ${tumor.lossVisit !='1'?'style="display:none"':'' }>
                    <th><label class="required" >失访原因</label></th>
                    <td>
                        <ehr:dic-checkbox reg="{'required':true}" dicmeta="CDM00004" name="lossVisitReason" value="${tumor.lossVisitReason}"
                        onchange="toggleOtherCK('lossVisitReason','lossVisit-reason','7')"></ehr:dic-checkbox>
                        <br />
                        <span  id="lossVisit-reason" ${!(tumor.lossVisitReason).contains('7')?'style="display:none"':'' } >
                            <input type="text" id="lossVisitReasonDesc" name="lossVisitReasonDesc" value="${tumor.lossVisitReasonDesc}" />
                        </span>
                    </td>
                </tr>
                <tr>
                    <th>具体随访地址</th>
                    <td>
                        <ehr:dic-radio dicmeta="CDM00005" name="followupPlace" value="${tumor.followupPlace }"></ehr:dic-radio>
                        <br />
                        <span id="tumor-followupPlace"  ${tumor.followupPlace !='3'?'style="display:none"':'' }>
                            <ehr:dic-town-street-village villageId="village_address" streetId="street_address"
                                                         townId="town_address" villageName="flGroup" streetName="flstreet"
                                                         townName="fltownShip" villageValue="${tumor.flGroup}" streetValue="${tumor.flstreet}"
                                                         townValue="${tumor.fltownShip}" width="118px;" reg="{'required':true}" callback="displayFlAddress"/>

                            <br />
                            <label id="tempFlValue">
                                <ehr:dic code="${tumor.fltownShip}" dicmeta="FS990001"/>
                                <ehr:dic code="${tumor.flstreet}" dicmeta="FS990001"/>
                                <ehr:dic code="${tumor.flGroup}" dicmeta="FS990001"/>
                            </label><br/>
                            <input type="text" id="text_flhouseNumber" reg='{"required":true,"maxlength":50}'  name="flhouseNumber" value="${tumor.flhouseNumber}"/>(详细地址)
                        </span>
                    </td>
                </tr>
				<tr>
					<th>是否治疗</th>
					<td><ehr:dic-radio dicmeta="DMD00048" name="cure" value="${tumor.cure }"></ehr:dic-radio></td>
				</tr>
                <tr id="tumor-cure" ${tumor.cure !='1'?'style="display:none"':'' }>
                    <th><label class="required" >治疗方式</label></th>
                    <td>
                        <ehr:dic-checkbox reg="{'required':true}" dicmeta="DMD00047" name="cureProject" value="${tumor.cureProject}"></ehr:dic-checkbox>
                    </td>
                </tr>
                <tr>
                    <th>是否死亡</th>
                    <td><ehr:dic-radio dicmeta="FS10246" name="death" value="${tumor.death }"></ehr:dic-radio></td>
                </tr>
                <tr id="tumor-deathDate" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th><label  class="required" for="deathDate">死亡日期</label></th>
                    <td>
                        <%-- <tag:dateInput style="width:178px;"  onlypast="true" id="deathDate" name="deathDate" date="${tumor.deathDate}" reg='{"required":true,"compare":["cancelDate","le","死亡日期不能大于撤销管理日期"]}' /> --%>
                    	<input type="text" reg="{'required':true,'compare':['definitionNextDate','le','随访日期不能大于下次随访日期']}"  class="layui-input x-admin-content-sm-date"  name="deathDate" id="deathDate" value="<fmt:formatDate value='${tumor.deathDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
                    </td>
                </tr>
                <tr id="tumor-deathForTumor" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th><label  class="required" for="deathForTumor">是否死于肿瘤</label></th>
                    <td><ehr:dic-radio dicmeta="FS10246" name="deathForTumor" value="${tumor.deathForTumor }" reg="{'required':true}" /></td>
                </tr>
                <tr id="tumor-deathReason" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th><label for="deathReason">根本死因</label></th>
                    <td><input type="text" id="deathReason" name="deathReason" value="${tumor.deathReason}" /></td>
                </tr>
                <tr id="tumor-deathPlace" ${tumor.death !='1'?'style="display:none"':'' }>
                    <th><label  class="required" for="deathPlaceCode">死亡地点</label></th>
                    <td>
                        <ehr:dic-radio dicmeta="DMD00052" name="deathPlaceCode" value="${tumor.deathPlaceCode }" reg="{'required':true}" />
                        <span style="display:${tumor.deathPlaceCode !='4'?'none':'inline' }" id="death-place">
                            <input name="deathPlace" type="text" value="${tumor.deathPlace }" reg="{'required':true,'maxlength':100,'dependOn':'deathPlaceCode','dependValue':'4'}"/>
                        </span>
                    </td>
                </tr>
                <tr>
                    <th>是否撤销随访</th>
                    <td><ehr:dic-radio dicmeta="FS10246" name="cancel" value="${tumor.cancel }"></ehr:dic-radio></td>
                </tr>
                <tr id="tumor-cancelDate" ${tumor.cancel !='1'?'style="display:none"':'' }>
                    <th><label  class="required" for="cancelDate">撤销随访日期</label></th>
                    <td>
                    <%-- <tag:dateInput style="width:178px;"  onlypast="true" id="cancelDate" name="cancelDate" date="${tumor.cancelDate}" reg='{"required":true,"compare":["deathDate","ge","撤销管理日期不能小于死亡日期"]}' /> --%>
                    <input type="text" reg='{"required":true,"compare":["deathDate","ge","撤销管理日期不能小于死亡日期"]}'  class="layui-input x-admin-content-sm-date"  name="cancelDate" id="cancelDate" value="<fmt:formatDate value='${tumor.cancelDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
                    </td>
                </tr>
                <tr id="tumor-cancelRea" ${tumor.cancel !='1'?'style="display:none"':'' }>
                    <th><label  class="required" for="cancelReason">撤销随访原因</label></th>
                    <td><ehr:dic-radio dicmeta="CDM00006" name="cancelReason" value="${tumor.cancelReason }" reg="{'required':true}" /></td>
                </tr>

                <%--<tr>
					<th><label for="recur">有无复发</label></th>
					<td><ehr:dic-radio dicmeta="FS10238" name="recur" value="${tumor.recur }"></ehr:dic-radio>
				<span style="display:${tumor.recur !='2'?'none':'inline' }" id="recurTimeSpan">复发次数:
				<tag:numberInput style="width:65px;" id="recurTime" name="recurTime" value="${tumor.recurTime}" reg="{'required':true,'min':0,'max':9999,'dependOn':'recur','dependValue':'2'}" />次</span></td>
				</tr>
				<tr>
						<th><label for="metastasis">转移情况</label></th>
						<td><ehr:dic-radio dicmeta="FS10238" name="metastasis" value="${tumor.metastasis }"></ehr:dic-radio><span style="display:${tumor.metastasis !='2'?'none':'inline' }" id="metastasisPart">
						转移部位:<input style="width: 170px;" name="metastasisPart" type="text" value="${tumor.metastasisPart }" reg="{'required':true,'maxlength':100,'dependOn':'metastasis','dependValue':'2'}"/></span></td>
					</tr>
				<tr>
					<th><label  >目前情况</label></th>
					<td><ehr:dic-radio dicmeta="DMD00049" name="currentStatusFlag" value="${tumor.currentStatusFlag}" /></td>
				</tr>
				<tr>
					<th><label  for="guidanceContent">指导内容</label></th>
					<td><ehr:dic-checkbox dicmeta="DMD00050" name="guidanceContent" value="${tumor.guidanceContent }" ></ehr:dic-checkbox></td>
				</tr>
				<tr>
					<th><label class="required" for="curSymptom">卡氏评分</label></th>
					<td><select style="width: 60px;" name="crtesianValue" reg="{'required':true}">
							<option ${tumor.crtesianValue eq 100 ?"selected='true'":""} value="100">100</option>
							<option ${tumor.crtesianValue eq 90 ?"selected='true'":""} value="90">90</option>
							<option ${tumor.crtesianValue eq 80 ?"selected='true'":""} value="80">80</option>
							<option ${tumor.crtesianValue eq 70 ?"selected='true'":""} value="70">70</option>
							<option ${tumor.crtesianValue eq 60 ?"selected='true'":""} value="60">60</option>
							<option ${tumor.crtesianValue eq 50 ?"selected='true'":""} value="50">50</option>
							<option ${tumor.crtesianValue eq 40 ?"selected='true'":""} value="40">40</option>
							<option ${tumor.crtesianValue eq 30 ?"selected='true'":""} value="30">30</option>
							<option ${tumor.crtesianValue eq 20 ?"selected='true'":""} value="20">20</option>
							<option ${tumor.crtesianValue eq 10 ?"selected='true'":""} value="10">10</option>
							<option ${tumor.crtesianValue eq 0 ?"selected='true'":""} value="0">0</option>
					</select></td>
				</tr>
				<tr>
					<th><label class="required" for="definitionNextDate">下次随访日期</label></th>
					<td><tag:dateInput style="width:178px;" onlyfuture="true" id="nextVisitDate" name="nextVisitDate" date="${tumor.nextVisitDate}" reg="{'required':true,'compare':['visitDate','ge','下次随访日期不能小于随访日期']}" /></td>
				</tr>--%>
				<%--<tr>--%>
					<%--<th><label  for="nextVisitDate">备注</label></th>--%>
					<%--<td><input type="text" name="remark" value="${tumor.remark }" reg="{'maxlength':100}"/></td>--%>
				<%--</tr>--%>
			</table>
				<c:set var="input" value="${tumor}" scope="request"></c:set>
		</fieldset>
        <fieldset class="layui-elem-field">
            <legend>工作记录</legend>
            <input type="hidden" name="createOrganCode" value="${input.createOrganCode}" />
            <input type="hidden" name="createOrganName" value="${input.createOrganName}" />
            <input type="hidden" name="createDoctorCode" value="${input.createDoctorCode}" />
            <input type="hidden" name="createDoctorName" value="${input.createDoctorName}" />
            <input type="hidden" name="createDate" readonly="readonly" value='<fmt:formatDate value="${input.createDate}" pattern="yyyy/MM/dd" />' />
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 100px; width: 30%" />
                    <col style="min-width: 150px; width: 70%" />
                </colgroup>
                <tr>
                    <th><label class="required" for="createDate">调查日期</label></th>
                    <td>
                        <%-- <tag:dateInput style="width:178px;" onlypast="true" id="createDate" name="createDate" date="${input.createDate}" /> --%>
                        <input type="text"  class="layui-input x-admin-content-sm-date"  name="createDate" id="createDate" value="<fmt:formatDate value='${input.createDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
                        <%--<input id="createDate"  type="text" name="createDate" value='<fmt:formatDate value="${input.createDate}" pattern="yyyy/MM/dd" />' />--%>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">调查医师签名</label></th>
                    <td><c:choose>
                        <c:when test="${empty input.createDoctorCode}">
                        <input style="width:178px;" type="text" readonly="readonly" value="${input.createDoctorName}" />
                        </c:when>
                        <c:otherwise>
                        <input style="width:178px;" type="text" readonly="readonly" value="<ehr:user userCode='${input.createDoctorCode}' />" >
                        </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th><label>调查单位</label></th>
                    <td><input style="width:178px;" type="text" readonly="readonly" value='<ehr:org code="${input.createOrganCode}"></ehr:org>' /></td>
                </tr>
                <tr>
                    <th><label class="required">核查医师签名</label></th>
                    <td><c:choose>
                        <c:when test="${empty input.createDoctorCode}">
                        <input style="width:178px;" type="text" readonly="readonly" value="${input.createDoctorName}" />
                        </c:when>
                        <c:otherwise>
                        <input style="width:178px;" type="text" readonly="readonly" value="<ehr:user userCode='${input.createDoctorCode}' />" >
                        </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </fieldset>
		</div>
	</div>
</form>
    <jsp:include page="tumorFollowupInputPrint.jsp"/>
</div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#visitDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   		,done:function(value) {
        if(!$.isEmpty(value)){
            $("#visitDate").removeClass("lose");
        }else{
            $("#visitDate").addClass("lose");
        }
   	}
    });
    
    laydate.render({
        elem: '#deathDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
     		 ,done:function(value) {
     	        if(!$.isEmpty(value)){
     	            $("#deathDate").removeClass("lose");
     	        }else{
     	            $("#deathDate").addClass("lose");
     	        }
     		 }
      });

    laydate.render({
        elem: '#cancelDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
     			,done:function(value) {
     		        if(!$.isEmpty(value)){
     		            $("#cancelDate").removeClass("lose");
     		        }else{
     		            $("#cancelDate").addClass("lose");
     		        }
     		   	}
      });
    
    laydate.render({
        elem: '#createDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
     		 ,done:function(value) {
  		        if(!$.isEmpty(value)){
  		            $("#createDate").removeClass("lose");
  		        }else{
  		            $("#createDate").addClass("lose");
  		        }
  		   	}
      });
    
    laydate.render({
        elem: '#hbpReferralDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
     		 ,done:function(value) {
   		        if(!$.isEmpty(value)){
   		            $("#hbpReferralDateId").removeClass("lose");
   		        }else{
   		            $("#hbpReferralDateId").addClass("lose");
   		        }
   		   	}
      });
  });

$(function () {
    autoFormatDate('visitDate');
    autoFormatDate('nextVisitDate');
});
</script>