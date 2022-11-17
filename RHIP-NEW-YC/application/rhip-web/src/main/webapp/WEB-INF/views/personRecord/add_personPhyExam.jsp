<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cleave/cleave.min.js"></script>
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/phyExam.css" type="text/css"  rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/phyExamUtil.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/phyExam.js" type="text/javascript" ></script>
<link href="${pageContext.request.contextPath}/css/views/ech/report.css" type="text/css"   rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/common.css" />

<script type="text/javascript">
	layui.use('laydate', function(){
	    var laydate = layui.laydate;
	    laydate.render({
	      elem: '#examinationDate_input'
	       ,format: 'yyyy/MM/dd'
	    	   ,done:function(value,date) {
			        if(!$.isEmpty(value)){
			            $("#examinationDate_input").removeClass("lose");
			        }else{
			            $("#examinationDate_input").addClass("lose");
			        }
			    }
	    });
	    
	    laydate.render({
	      elem: '#hospitalizedHistoryList0inDate'
	    	  ,format: 'yyyy/MM/dd'
	    		  ,trigger: 'click'
	              			,done:function(value,date) {
	        			        if(!$.isEmpty(value)){
	        			            $("#hospitalizedHistoryList0inDate").removeClass("lose");
	        			        }else{
	        			            $("#hospitalizedHistoryList0inDate").addClass("lose");
	        			        }
	        			    }
	    });
	    
	    
	    laydate.render({
		      elem: '#vaccinationInfoList0vaccinationDate'
		    	  ,format: 'yyyy/MM/dd'
		    		  ,trigger: 'click'
		              			,done:function(value,date) {
		        			        if(!$.isEmpty(value)){
		        			            $("#vaccinationInfoList0vaccinationDate").removeClass("lose");
		        			        }else{
		        			            $("#vaccinationInfoList0vaccinationDate").addClass("lose");
		        			        }
		        			    }
		    });
	    laydate.render({
		      elem: '#vaccinationInfoList1vaccinationDate'
		    	  ,format: 'yyyy/MM/dd'
		    		  ,trigger: 'click'
		              			,done:function(value,date) {
		        			        if(!$.isEmpty(value)){
		        			            $("#vaccinationInfoList1vaccinationDate").removeClass("lose");
		        			        }else{
		        			            $("#vaccinationInfoList1vaccinationDate").addClass("lose");
		        			        }
		        			    }
		    });
	    laydate.render({
		      elem: '#vaccinationInfoList2vaccinationDate'
		    	  ,format: 'yyyy/MM/dd'
		    		  ,trigger: 'click'
		              			,done:function(value,date) {
		        			        if(!$.isEmpty(value)){
		        			            $("#vaccinationInfoList2vaccinationDate").removeClass("lose");
		        			        }else{
		        			            $("#vaccinationInfoList2vaccinationDate").addClass("lose");
		        			        }
		        			    }
		    });
	    laydate.render({
		      elem: '#vaccinationInfoList3vaccinationDate'
		    	  ,format: 'yyyy/MM/dd'
		    		  ,trigger: 'click'
		              			,done:function(value,date) {
		        			        if(!$.isEmpty(value)){
		        			            $("#vaccinationInfoList3vaccinationDate").removeClass("lose");
		        			        }else{
		        			            $("#vaccinationInfoList3vaccinationDate").addClass("lose");
		        			        }
		        			    }
		    });
	    
	    laydate.render({
	        elem: '#outhos0Date'
	         ,format: 'yyyy/MM/dd'
	         ,trigger: 'click'
	        	 ,done:function(value,date) {
 			        if(!$.isEmpty(value)){
 			            $("#outhos0Date").removeClass("lose");
 			        }else{
 			            $("#outhos0Date").addClass("lose");
 			        }
 			    }
	      });
	    
	    laydate.render({
		      elem: '#hospitalizedHistoryList1inDate'
		    	  ,format: 'yyyy/MM/dd'
		    		  ,trigger: 'click'
		    			  ,done:function(value,date) {
		   			        if(!$.isEmpty(value)){
		   			            $("#hospitalizedHistoryList1inDate").removeClass("lose");
		   			        }else{
		   			            $("#hospitalizedHistoryList1inDate").addClass("lose");
		   			        }
		   			    }
		});
		  
		laydate.render({
		     elem: '#outhos1Date'
		     ,format: 'yyyy/MM/dd'
		     ,trigger: 'click'
		    	 ,done:function(value,date) {
	   			        if(!$.isEmpty(value)){
	   			            $("#outhos1Date").removeClass("lose");
	   			        }else{
	   			            $("#outhos1Date").addClass("lose");
	   			        }
	   			    }
		});
		    
		laydate.render({
			 elem: '#hospitalizedHistoryList2inDate'
			 ,format: 'yyyy/MM/dd'
			  ,trigger: 'click'
				  ,done:function(value,date) {
	   			        if(!$.isEmpty(value)){
	   			            $("#hospitalizedHistoryList2inDate").removeClass("lose");
	   			        }else{
	   			            $("#hospitalizedHistoryList2inDate").addClass("lose");
	   			        }
	   			    }
		});
			  
		laydate.render({
			elem: '#outhos2Date'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
				,done:function(value,date) {
   			        if(!$.isEmpty(value)){
   			            $("#outhos2Date").removeClass("lose");
   			        }else{
   			            $("#outhos2Date").addClass("lose");
   			        }
   			    }
		});

		laydate.render({
			elem: '#familyBedHistoryList0builtBedDate'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
				,done:function(value,date) {
   			        if(!$.isEmpty(value)){
   			            $("#familyBedHistoryList0builtBedDate").removeClass("lose");
   			        }else{
   			            $("#familyBedHistoryList0builtBedDate").addClass("lose");
   			        }
   			    }
		});

		laydate.render({
			elem: '#familyBedHistoryList0removeBedDate'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
				,done:function(value,date) {
   			        if(!$.isEmpty(value)){
   			            $("#familyBedHistoryList0removeBedDate").removeClass("lose");
   			        }else{
   			            $("#familyBedHistoryList0removeBedDate").addClass("lose");
   			        }
   			    }
		});

		laydate.render({
			elem: '#familyBedHistoryList1builtBedDate'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
				,done:function(value,date) {
   			        if(!$.isEmpty(value)){
   			            $("#familyBedHistoryList1builtBedDate").removeClass("lose");
   			        }else{
   			            $("#familyBedHistoryList1builtBedDate").addClass("lose");
   			        }
   			    }
		});

		laydate.render({
			elem: '#familyBedHistoryList1removeBedDate'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
				,done:function(value,date) {
   			        if(!$.isEmpty(value)){
   			            $("#familyBedHistoryList1removeBedDate").removeClass("lose");
   			        }else{
   			            $("#familyBedHistoryList1removeBedDate").addClass("lose");
   			        }
   			    }
		});

		laydate.render({
			elem: '#familyBedHistoryList2builtBedDate'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
				,done:function(value,date) {
   			        if(!$.isEmpty(value)){
   			            $("#familyBedHistoryList2builtBedDate").removeClass("lose");
   			        }else{
   			            $("#familyBedHistoryList2builtBedDate").addClass("lose");
   			        }
   			    }
		});

		laydate.render({
			elem: '#familyBedHistoryList2removeBedDate'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
				,done:function(value,date) {
   			        if(!$.isEmpty(value)){
   			            $("#familyBedHistoryList2removeBedDate").removeClass("lose");
   			        }else{
   			            $("#familyBedHistoryList2removeBedDate").addClass("lose");
   			        }
   			    }
		});
		 // 用药情况
	    for (var i = 0; i < 5; i++) {
	        var dhstdateId = 'drugHistoryList'+ i + 'startDate';
	        var dhsddateId = 'drugHistoryList' + i + 'stopDate';
	        laydate.render({
	            elem: '#' + dhstdateId
	            ,format: 'yyyy/MM/dd'
	            ,max:0
	            , trigger: 'click'
	        });

	        laydate.render({
	            elem: '#' + dhsddateId
	            ,format: 'yyyy/MM/dd'
	            ,max:0
	            , trigger: 'click'
	        });
	    }

  });
    $(function() {
    	if($("#identificationId").val()!="" && $("#identificationId").val()!=0){
            if($("#isElder").val()=="true"){
                $("#CMedicine").show();
            }else{
                $("#CMedicine").hide();
            }
        }else{
            $("#CMedicine").hide();
        }
        if($("input[name='PersonalPhyExamDTO.physiqueExamination.dietHunsuEquilibrium']").is(':checked')==true){
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").attr("disabled",true);
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().attr("disabled",true);
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().css("color","grey");
        }else{
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").removeAttr("disabled");
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().removeAttr("disabled");
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().css("color","");
        }
        if($("#leftBloodUp").val()!=""||$("#leftBloodDown").val()!=""||$("#rightBloodUp").val()!=""||$("#rightBloodDown").val()!=""){
            $("#bloodPressureSource").show();
        }else{
            $("#bloodPressureSource").hide();
        }
        if($("#bloodGlucoseLeft").val()!=""||$("#bloodGlucoseRight").val()!=""){
            $("#bloodSugarSource").show();
        }else{
            $("#bloodSugarSource").hide();
        }
		$('.x-admin-content-sm-date').each(function(){
			var id = $(this).attr("id");
			if(!$.isEmpty(id)){
				autoFormatDate(id);
			}
		});
		$('.datetime').each(function(){
			var id = $(this).attr("id");
			if(!$.isEmpty(id)){
				autoFormatDate(id);
			}
		});
    });

    function dietHunsuEquilibriumChange(){
        if($("input[name='PersonalPhyExamDTO.physiqueExamination.dietHunsuEquilibrium']").is(':checked')==true){
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").attr("disabled",true);
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().attr("disabled",true);
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().css("color","grey");
        }else{
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").removeAttr("disabled");
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().removeAttr("disabled");
            $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().css("color","");
        }
    }
</script>
<div id="con_two_3" class="Contentbox" style="text-align: left;overflow-y: hidden;">
	<div  class="msgError" style="display: none" id="person_px_info_errbox"></div>
	<div id="msgError" class="msgError" style="display: none;">   </div>
	<form action="" id="phyExamForm">

		<input type="hidden" value="${personInfo.star}" name="PersonalBasicInfoDTO.personInfo.star"/>
		<i class="pop_No" style="height: 40px;">
			<input type="hidden" id="loadPrePhyExamClick" value="${loadPrePhyExamClick}"/>
			<input type="hidden" id="person_name" value="${personInfo.name}"/>
			<input type="hidden" id="personId" value="${personInfo.id}" name="PersonalPhyExamDTO.personInfo.id">
			<input type="hidden" id="idCard" value="${personInfo.idcard}" name="PersonalPhyExamDTO.personInfo.idcard">
			<input type="hidden" id="currentEhrId" value="${currentEhrId}">
			<input type="hidden" id="emotionScreenResultStr" name="PersonalPhyExamDTO.physiqueExamination.emotionScreenResultStr"/>
			<input type="hidden" name="PersonalPhyExamDTO.physiqueExamination.physicalExamCode" value="${PersonalPhyExamDTO.physiqueExamination.physicalExamCode}">
			<%--<a class="fh" id="cancel_phyExam" ${currentEhrId == null and not newPerson ? '' : 'hidden'}>返回</a>
			<a class="xz" id="add_phyExam" ${currentEhrId == null ? 'hidden' : ''}>新增</a>
			<a class="bc" id="save_phyExam">保存</a>
			<a class="dy" id="button_print">打印</a>
			<a class="search" id="yitiji">一体机</a>--%>
			<a href="javascript:void(0);" id="cancel_phyExam" ${currentEhrId == null and not newPerson ? '' : 'hidden'} style="margin-top: 3.5px;"><button style="background-color: #C0C0C0;" class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
			<button  id="person-phyexam-pre-btn" class="layui-btn layui-btn-sm" style="margin-left:10px;padding-left:5px;float:right;margin-top: 3.5px;display: ${currentEhrId == null? 'block' : 'none'}">上一次体检信息</button>
			<a href="javascript:void(0);" id="save_phyExam" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
			<a href="javascript:void(0);" id="add_phyExam" ${currentEhrId == null ? 'hidden' : ''} style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
			<a href="javascript:void(0)" id="yitiji" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe615;</i>一体机</button></a>
			<a href="javascript:void(0)" id="button_print" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>
			<%--			<a href="javascript:void(0)" id="yitiji"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe615;</i>一体机</button></a>--%>
			<%--<a class="bc" id="health_Info">健康小屋</a>--%>

			<span id="selectEvent" style="display: ${currentEhrId == null ? 'none' : ''};padding-left: 350px">
				体检日期：
				<select name="ehrId" id="ehrId">
					<c:choose>
						<c:when test="${empty ehrHealthEvents}">
							<option value=""></option>
						</c:when>
						<c:otherwise>
							<c:forEach var="event" items="${ehrHealthEvents}">
								<option value="${event.ehrId}" ${currentEhrId == event.ehrId ? 'selected' : ''}><fmt:formatDate value="${event.clinicDate}"/>${event.clinicDate == null ? '未知日期' : ''}</option>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</select>
	</span>
		</i><!-- overflow-y: hidden -->
		<div class="postcontent" id="printDiv">
			<span class="span_floatleft">&emsp;&emsp;姓名:   ${personInfo.name}</span>
			<c:choose>
				<c:when test="${not empty personInfo.healthFileNoHtml}">
					${personInfo.healthFileNoHtml}
				</c:when>
				<c:otherwise>
					<s class="pop_No">
						<span class="text"><b>编号：</b></span>
						<span></span><span></span><span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span><span></span>
					</s>
				</c:otherwise>
			</c:choose>
			<div <%--style="height:460px;width: 880px;"--%>style="margin-top: 35px;">
				<%--<div style="width: 100%">--%>
					<span style="float: right; margin-right: 8px;">责任医生:
						<ehr:staff-list name="PersonalPhyExamDTO.physiqueExamination.manaDoctorId" value="${PersonalPhyExamDTO.physiqueExamination.manaDoctorId}" style="width:130px;margin-bottom: 5px;" defaultval="Y" orgCode=""/>
					</span>
					<span style="float: left; margin-left: 8px;">&nbsp;&nbsp;<label class="required" title="《考核项目》">体检日期:</label>
						<c:if test="${empty PersonalPhyExamDTO.physiqueExamination.examinationDate}">
							<jsp:useBean id="today" class="java.util.Date" />
							<input type="text" class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.physiqueExamination.examinationDate" id="examinationDate_input" 
                            value="<fmt:formatDate value='${today}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;margin-bottom: 5px;" />
						</c:if>
						<c:if test="${not empty PersonalPhyExamDTO.physiqueExamination.examinationDate}">
							<input type="text" class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.physiqueExamination.examinationDate" id="examinationDate_input" 
                            value="<fmt:formatDate value='${PersonalPhyExamDTO.physiqueExamination.examinationDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;margin-bottom: 5px;" />
						</c:if>
					</span>
					<br style="clear: both" />
				<%--</div>--%>

				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<table class="posttable">
							<tr>
								<th style="width: 16%;vertical-align: top;text-align: right;"><label class="required" title="《考核项目》">症状</label></th>
								<td>
									<label><input type="radio"
												  name="PersonalPhyExamDTO.physiqueExamination.symptomFlag"  ${PersonalPhyExamDTO.physiqueExamination.symptomFlag eq '0' or PersonalPhyExamDTO.physiqueExamination.symptomFlag eq null ? 'checked' : ''}
												  value="0" onclick="util.clickHideTable(this,'ttb1')"/> 无症状</label>
									<label><input type="radio" id="symptomFlag"
												  name="PersonalPhyExamDTO.physiqueExamination.symptomFlag"  ${PersonalPhyExamDTO.physiqueExamination.symptomFlag eq '1' ? 'checked':''}
												  value="1" onclick="util.clickShowTable(this,'ttb1')"/> 有症状</label>
									<table class="tt_hidden" id="ttb1">
										<tr>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomHeadache" ${PersonalPhyExamDTO.physiqueExamination.symptomHeadache eq '1' ? 'checked':''} value="1"> 头痛</label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomDizzy" ${PersonalPhyExamDTO.physiqueExamination.symptomDizzy eq '1' ? 'checked':''} value="1"> 头晕 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomPalpitations" ${PersonalPhyExamDTO.physiqueExamination.symptomPalpitations eq '1' ? 'checked':''} value="1"> 心悸 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomChestTightness" ${PersonalPhyExamDTO.physiqueExamination.symptomChestTightness eq '1' ? 'checked':''} value="1"> 胸闷 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomChestPain" ${PersonalPhyExamDTO.physiqueExamination.symptomChestPain eq '1' ? 'checked':''} value="1"> 胸痛 </label></td>
										</tr>
										<tr>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomChronicCough" ${PersonalPhyExamDTO.physiqueExamination.symptomChronicCough eq '1' ? 'checked':''} value="1"> 慢性咳嗽 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomCough" ${PersonalPhyExamDTO.physiqueExamination.symptomCough eq '1' ? 'checked':''} value="1"> 咳痰 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomDyspnea" ${PersonalPhyExamDTO.physiqueExamination.symptomDyspnea eq '1' ? 'checked':''} value="1"> 呼吸困难 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomPolydipsia" ${PersonalPhyExamDTO.physiqueExamination.symptomPolydipsia eq '1' ? 'checked':''} value="1"> 多饮 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomPolyuria" ${PersonalPhyExamDTO.physiqueExamination.symptomPolyuria eq '1' ? 'checked':''} value="1"> 多尿 </label></td>
										</tr>
										<tr>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomWeightLoss" ${PersonalPhyExamDTO.physiqueExamination.symptomWeightLoss eq '1' ? 'checked':''} value="1"> 体重下降 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomFatigue" ${PersonalPhyExamDTO.physiqueExamination.symptomFatigue eq '1' ? 'checked':''} value="1"> 乏力 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomJointPain" ${PersonalPhyExamDTO.physiqueExamination.symptomJointPain eq '1' ? 'checked':''} value="1"> 关节肿痛 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomBlurredVision" ${PersonalPhyExamDTO.physiqueExamination.symptomBlurredVision eq '1' ? 'checked':''} value="1"> 视力模糊 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomNumbness" ${PersonalPhyExamDTO.physiqueExamination.symptomNumbness eq '1' ? 'checked':''} value="1"> 手脚麻木 </label></td>
										</tr>
										<tr>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomUrgency" ${PersonalPhyExamDTO.physiqueExamination.symptomUrgency eq '1' ? 'checked':''} value="1"> 尿急 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomDysuria" ${PersonalPhyExamDTO.physiqueExamination.symptomDysuria eq '1' ? 'checked':''} value="1"> 尿痛 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomConstipation" ${PersonalPhyExamDTO.physiqueExamination.symptomConstipation eq '1' ? 'checked':''} value="1"> 便秘 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomDiarrhea" ${PersonalPhyExamDTO.physiqueExamination.symptomDiarrhea eq '1' ? 'checked':''} value="1"> 腹泻 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomNauseaVomiting" ${PersonalPhyExamDTO.physiqueExamination.symptomNauseaVomiting eq '1' ? 'checked':''} value="1"> 恶心呕吐 </label></td>
										</tr>
										<tr>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomVertigo" ${PersonalPhyExamDTO.physiqueExamination.symptomVertigo eq '1' ? 'checked':''} value="1"> 眼花 </label></td>
											<td><label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomTinnitus" ${PersonalPhyExamDTO.physiqueExamination.symptomTinnitus eq '1' ? 'checked':''} value="1"> 耳鸣 </label></td>
											<td><label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.symptomBreastTenderness" ${PersonalPhyExamDTO.physiqueExamination.symptomBreastTenderness eq '1' ? 'checked':''} value="1"> 乳房胀痛 </label></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td colspan="5">
												<label><input reg='{"extension":["symptomVali","请至少选择一项"]}' type="checkbox" id="symptomOther" onclick="util.clickShowText(this,'symptomOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.symptomOther" ${PersonalPhyExamDTO.physiqueExamination.symptomOther eq '1' ? 'checked':''} value="1"> 其他症状</label>
												&nbsp;&nbsp;
												<input type="text" name="PersonalPhyExamDTO.physiqueExamination.symptomOtherDesc" id="symptomOtherDesc"  class="hidediv" style="width: 200px;" value="${PersonalPhyExamDTO.physiqueExamination.symptomOtherDesc}" class="nowidth" reg='{"dependOn":"symptomOther","required":"true","maxlength":"33"}'>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<legend><label class="required" title="《考核项目》">一般状况</label></legend>
						<table class="posttable">
								<colgroup>
									<col style="width: 17%;"/>
									<col style="width: 33%;"/>
									<col style="width: 17%;"/>
									<col style="width: 33%;">
								</colgroup>
								<tr>
									<th style="text-align: right;">体温</th>
									<td >
										<tag:numberInput point="point" id="temp" onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" style="width: 80px" value="${PersonalPhyExamDTO.physiqueExamination.temperature}" name="PersonalPhyExamDTO.physiqueExamination.temperature"  reg="{'min':0,'max':42.0}"></tag:numberInput>℃</td>
									<th style="text-align: right;">脉率</th>
									<td ><tag:numberInput style="width: 80px" id="pulseRate" onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.pulseRate" value="${PersonalPhyExamDTO.physiqueExamination.pulseRate}" reg="{'min':0,'max':200}"/>次/分钟</td>
								</tr>
								<tr>
									<c:if test="${isChild}">
										<th style="text-align: right;"><label>血压</label></th>
										<td colspan="3">
											<table>
												<tr>
													<td colspan="4">
														左侧<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.leftSbp" value="${PersonalPhyExamDTO.physiqueExamination.leftSbp}"  style="width: 40px;color:FFFF33" reg="{'min':0,'max':300,'required':'true'}" id="leftBloodUp"/>/
														<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.leftDbp" value="${PersonalPhyExamDTO.physiqueExamination.leftDbp}"  style="width: 40px" reg="{'min':0,'max':300,'required':'true'}" id="leftBloodDown"/>mmHg
														&nbsp;&nbsp;&nbsp;右侧<tag:numberInput  onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.rightSbp" value="${PersonalPhyExamDTO.physiqueExamination.rightSbp}" style="width: 40px" reg="{'min':0,'max':300,'required':'true'}" id="rightBloodUp"/>/
														<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.rightDbp" value="${PersonalPhyExamDTO.physiqueExamination.rightDbp}"  style="width: 40px"  reg="{'min':0,'max':300,'required':'true'}" id="rightBloodDown"/>mmHg
													</td>
												</tr>
											</table>
										</td>
									</c:if>
									<c:if test="${!isChild}">
										<th style="text-align: right;"><label class="required">血压</label></th>
										<td colspan="3">
											<table>
												<tr>
													<td colspan="4">
														左侧<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.leftSbp" value="${PersonalPhyExamDTO.physiqueExamination.leftSbp}"  style="width: 40px" reg="{'min':0,'max':300,'required':'true'}" id="leftBloodUp"/>/
														<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.leftDbp" value="${PersonalPhyExamDTO.physiqueExamination.leftDbp}"  style="width: 40px" reg="{'min':0,'max':300,'required':'true'}" id="leftBloodDown"/>mmHg
														&nbsp;&nbsp;&nbsp;右侧<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.rightSbp" value="${PersonalPhyExamDTO.physiqueExamination.rightSbp}" style="width: 40px" reg="{'min':0,'max':300,'required':'true'}" id="rightBloodUp"/>/
														<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')"  name="PersonalPhyExamDTO.physiqueExamination.rightDbp" value="${PersonalPhyExamDTO.physiqueExamination.rightDbp}"  style="width: 40px"  reg="{'min':0,'max':300,'required':'true'}" id="rightBloodDown"/>mmHg
													</td>
												</tr>
											</table>
										</td>
									</c:if>
								</tr>
								<tr>
									<th style="text-align: right;">呼吸频率</th>
									<td><tag:numberInput id="breath" onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" name="PersonalPhyExamDTO.physiqueExamination.respiratoryRate" style="width: 80px"  value="${PersonalPhyExamDTO.physiqueExamination.respiratoryRate}" reg="{'min':0,'max':60}"/>次/分钟</td>
									<th style="text-align: right;">身高</th>
									<td><tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" reg="{'min':0,'max':260.0}" id="personHeightId" point="point" name="PersonalPhyExamDTO.physiqueExamination.height" value="${PersonalPhyExamDTO.physiqueExamination.height}" style="width: 80px" />cm</td>
								</tr>

								<tr>
									<th style="text-align: right;">体重</th>
									<td><tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" reg="{'min':0,'max':300.0}" id="personWeightId" point="point" name="PersonalPhyExamDTO.physiqueExamination.bodyWeight" value="${PersonalPhyExamDTO.physiqueExamination.bodyWeight}" style="width: 80px" />kg</td>
									<th style="text-align: right;">腰围</th>
									<td><tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" reg="{'min':0,'max':200.0}" id="personWaostline" point="point" name="PersonalPhyExamDTO.physiqueExamination.waostline" value="${PersonalPhyExamDTO.physiqueExamination.waostline}" style="width: 80px" />cm</td>
								</tr>
								<tr>
									<th style="text-align: right;">体质指数（BMI）</th>
									<td><input reg="{'min':0,'max':999.99}" type="text" id="personBMIId" name="PersonalPhyExamDTO.physiqueExamination.indexOfBodyCharacteristics" value="${PersonalPhyExamDTO.physiqueExamination.indexOfBodyCharacteristics}" readonly="readonly" style="width: 80px;"/>kg/㎡</td>
									<td></td>
									<td></td>
								</tr>
							<tr id="bloodPressureSource" style="display: none">
								<th style="text-align: right;">
									<label class="required">来源</label></th>
								<td colspan="3">
									<ehr:dic-radio dicmeta="TFJKDA001" id="bloodPressureSource" name="PersonalPhyExamDTO.physiqueExamination.bloodPressureSource" value="${PersonalPhyExamDTO.physiqueExamination.bloodPressureSource}" reg="{'required':true}"/>
								</td>
							</tr>

						</table>
					</fieldset>
				</div>
				<c:if test="${isElder}">
					<%--老年人自我评估 begin--%>
					<div class="postdiv">
						<fieldset class="layui-elem-field">
							<legend>自我评估</legend>
							<table class="posttable">
								<colgroup>
									<col style="width:35%;">
									<col>
								</colgroup>
								<tr>
									<th style="text-align: right;vertical-align: top;"><label class="required">健康状况自我评估</label></th>
									<td>
										<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.healthSelfAssessment" value="${PersonalPhyExamDTO.physiqueExamination.healthSelfAssessment}" dicmeta="CV0401013" reg="{'required':true}"/>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;"><label class="required">生活自理能力自我评估</label></th>
									<td>
										<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment" value="${PersonalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment }" dicmeta="CV0401014" reg="{'required':true}"/>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;"><label class="required">进餐:使用餐具将饭菜送入口、咀嚼、吞咽等活动</label></th>
									<td style="vertical-align: middle;">
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.eatingAssessment" onclick="addPhyExam.calculateAssessment()" value="0"
											${PersonalPhyExamDTO.physiqueExamination.eatingAssessment eq 0 ? "checked" : "" }  reg="{'required':true}"/> 独立完成（0）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.eatingAssessment" onclick="addPhyExam.calculateAssessment()" value="3"
											${PersonalPhyExamDTO.physiqueExamination.eatingAssessment eq 3 ? "checked" : ""}  reg="{'required':true}"/> 需要协助（3）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.eatingAssessment" onclick="addPhyExam.calculateAssessment()" value="5"
											${PersonalPhyExamDTO.physiqueExamination.eatingAssessment eq 5 ? "checked" : ""}  reg="{'required':true}"/> 完全需要帮助（5）</label>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;"><label class="required">梳洗:梳头、洗脸、刷牙、剃须、洗澡等活动</label></th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.cleaningAssessment" onclick="addPhyExam.calculateAssessment()" value="0"
											${PersonalPhyExamDTO.physiqueExamination.cleaningAssessment eq 0 ? "checked" : "" } reg="{'required':true}"/> 独立完成（0）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.cleaningAssessment" onclick="addPhyExam.calculateAssessment()" value="1"
											${PersonalPhyExamDTO.physiqueExamination.cleaningAssessment eq 1 ? "checked" : ""} reg="{'required':true}"/> 洗澡需协助（1）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.cleaningAssessment" onclick="addPhyExam.calculateAssessment()" value="3"
											${PersonalPhyExamDTO.physiqueExamination.cleaningAssessment eq 3 ? "checked" : ""} reg="{'required':true}"/> 协助下能完成（3）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.cleaningAssessment" onclick="addPhyExam.calculateAssessment()" value="7"
											${PersonalPhyExamDTO.physiqueExamination.cleaningAssessment eq 7 ? "checked" : ""} reg="{'required':true}"/> 完全需要帮助（7）</label>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;"><label class="required">穿衣:穿衣裤、袜子、鞋子等活动</label></th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.clothingAssessment" onclick="addPhyExam.calculateAssessment()" value="0"
											${PersonalPhyExamDTO.physiqueExamination.clothingAssessment eq 0 ? "checked" : ""} reg="{'required':true}"/> 独立完成（0）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.clothingAssessment" onclick="addPhyExam.calculateAssessment()" value="3"
											${PersonalPhyExamDTO.physiqueExamination.clothingAssessment eq 3 ? "checked" : ""} reg="{'required':true}"/> 需要协助（3）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.clothingAssessment" onclick="addPhyExam.calculateAssessment()" value="5"
											${PersonalPhyExamDTO.physiqueExamination.clothingAssessment eq 5 ? "checked" : ""} reg="{'required':true}"/> 完全需要帮助（5）</label>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;"><label class="required">如厕:小便、大便等活动及自控</label></th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.defecationAssessment" onclick="addPhyExam.calculateAssessment()" value="0"
											${PersonalPhyExamDTO.physiqueExamination.defecationAssessment eq 0 ? "checked" : ""} reg="{'required':true}"/> 不需协助（0）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.defecationAssessment" onclick="addPhyExam.calculateAssessment()" value="1"
											${PersonalPhyExamDTO.physiqueExamination.defecationAssessment eq 1 ? "checked" : ""} reg="{'required':true}"/> 偶尔失禁（1）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.defecationAssessment" onclick="addPhyExam.calculateAssessment()" value="5"
											${PersonalPhyExamDTO.physiqueExamination.defecationAssessment eq 5 ? "checked" : ""} reg="{'required':true}"/> 经常失禁（5）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.defecationAssessment" onclick="addPhyExam.calculateAssessment()" value="10"
											${PersonalPhyExamDTO.physiqueExamination.defecationAssessment eq 10 ? "checked" : ""} reg="{'required':true}"/> 完全失禁（10）</label>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;"><label class="required">活动:站立、室内行走、上下楼梯、户外活动</label></th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.exerciseAssessment" onclick="addPhyExam.calculateAssessment()" value="0"
											${PersonalPhyExamDTO.physiqueExamination.exerciseAssessment eq 0 ? "checked" : ""} reg="{'required':true}"/> 独立完成（0）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.exerciseAssessment" onclick="addPhyExam.calculateAssessment()" value="1"
											${PersonalPhyExamDTO.physiqueExamination.exerciseAssessment eq 1 ? "checked" : ""} reg="{'required':true}"/> 借助较小外力（1）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.exerciseAssessment" onclick="addPhyExam.calculateAssessment()" value="5"
											${PersonalPhyExamDTO.physiqueExamination.exerciseAssessment eq 5 ? "checked" : ""} reg="{'required':true}"/> 借助较大外力（5）</label>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.exerciseAssessment" onclick="addPhyExam.calculateAssessment()" value="10"
											${PersonalPhyExamDTO.physiqueExamination.exerciseAssessment eq 10 ? "checked" : ""} reg="{'required':true}"/> 卧床不起（10）</label>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;" title="粗筛方法:告诉被检查者“我将要说三件物品的名字（如铅笔、卡车、书）,请您立即重复”。过1分钟后请其再次重复。如被检查者无法立即重复或1分钟后无法完整回忆三件物品名称为阳性,需进一步“简易智力状态检查量表”检查"><label class="required">老年人认知功能</label></th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.cognitionScreenResult"
													  onclick="util.clickHideText(this,'cognitionScreenScore')" ${PersonalPhyExamDTO.physiqueExamination.cognitionScreenResult eq"1" ?"checked" :""}
													  value="1" reg="{'required':true}"/>
											粗筛阴性</label>
										<label><input type="radio" id="cognitionScreenResult" name="PersonalPhyExamDTO.physiqueExamination.cognitionScreenResult"
													  onclick="util.clickShowText(this,'cognitionScreenScore')" ${PersonalPhyExamDTO.physiqueExamination.cognitionScreenResult eq"0" ?"checked" :""}
													  value="0" reg="{'required':true}"/>
											粗筛阳性</label>
										<span id="cognitionScreenScore"  ${PersonalPhyExamDTO.physiqueExamination.cognitionScreenResult ne'0' ?'class="hidediv"' :''}>
					   ，简易智力状态检查，总分<tag:numberInput name="PersonalPhyExamDTO.physiqueExamination.cognitionScreenScore" style="width:40px;"
													value="${PersonalPhyExamDTO.physiqueExamination.cognitionScreenScore}" cssClass="width30"
													reg="{'dependOn':'cognitionScreenResult','required':'true','min':0,'max':9999}"/>
					</span>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;" title="粗筛方法:询问被检查者“你经常感到伤心或抑郁吗”或“你的情绪怎么样”。如回答“是”或“我想不是十分好”,为阳性,需进一步行“老年抑郁量表”检查。"><label class="required">老年人情感状态</label></th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.emotionScreenResult"
													  onclick="util.clickHideText(this,'depressionScore')" ${PersonalPhyExamDTO.physiqueExamination.emotionScreenResult eq"1" ?"checked" :""}
													  value="1" reg="{'required':true}"/>粗筛阴性</label>
										<label><input type="radio" id="emotionScreenResult" name="PersonalPhyExamDTO.physiqueExamination.emotionScreenResult"
													  onclick="util.clickShowText(this,'depressionScore')" ${PersonalPhyExamDTO.physiqueExamination.emotionScreenResult eq"0" ?"checked" :""}
													  value="0" reg="{'required':true}"/>粗筛阳性</label>
										<span id="depressionScore" ${PersonalPhyExamDTO.physiqueExamination.emotionScreenResult ne'0' ?'class="hidediv"' :''}>
						，老年人抑郁评分检查，总分<tag:numberInput name="PersonalPhyExamDTO.physiqueExamination.depressionScore" id="depressionScore" value="${PersonalPhyExamDTO.physiqueExamination.depressionScore}"
													  cssClass="width30" style="width:40px;"
													  reg="{'dependOn':'emotionScreenResult','required':'true','min':0,'max':999}"/>
							<span class="toolbarsublist" ${PersonalPhyExamDTO.physiqueExamination.emotionScreenResult ne'0' ?'class="hidediv"' :''}>
								<a href="javascript:void(0)" id="addDepressed" ><b class="xinz">老年抑郁</b></a>
							</span>
						</span>
									</td>
								</tr>
							</table>
						</fieldset>
					</div>
					<%--老年人自我评估 end--%>
				</c:if>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<legend><label class="required" title="《考核项目》">生活方式</label></legend>
							<%--<div class="postdiv">--%>
							<%--<fieldset>--%>
									<legend title="指主要锻炼,即有意识地强体健身而进行的活动。不包括因工作或其他需要而必须进行的活动,如为上班骑自行车、做强体力工作等。锻炼方式填写最常采用的具体锻炼方式。">体育锻炼</legend>
									<table class="posttable" >
										<tr>
											<th width="16%" style="text-align: right;">锻炼频率</th>
											<td colspan="3">
												<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.trainFrequencyTypeCode" dicmeta="FS10208" value="${PersonalPhyExamDTO.physiqueExamination.trainFrequencyTypeCode}"  onchange="addPhyExam.setContentStyle(this,'exerciseTypeSpan:keepTimeSpan:exerciseTimeSpan',4)"/>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">每次锻炼时间</th>
											<td>
												<span id="exerciseTimeSpan" >
													<tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" reg="{'min':0,'max':600}"  name="PersonalPhyExamDTO.physiqueExamination.trainingMin" value="${PersonalPhyExamDTO.physiqueExamination.trainingMin}" style="width: 80px" />分钟
												</span>
											</td>
											<th style="text-align: right;">坚持锻炼时间</th>
											<td>
												<span id="keepTimeSpan">
													<tag:numberInput maxlength="2" name="PersonalPhyExamDTO.physiqueExamination.trainingTotaltime" value="${PersonalPhyExamDTO.physiqueExamination.trainingTotaltime}"
																	 style="width: 80px" point="1"/>年
												</span>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;vertical-align: top;">锻炼方式</th>
											<td colspan="3">
												<span id="exerciseTypeSpan">
													<input type="hidden" value="${PersonalPhyExamDTO.physiqueExamination.trainingWay}" id="text_trainingWay"/>
													<ehr:dic-checkbox name="PersonalPhyExamDTO.physiqueExamination.trainingWay" value="${PersonalPhyExamDTO.physiqueExamination.trainingWay}" dicmeta="FS990004"></ehr:dic-checkbox>
													<span id="other_train_way_span" class="hidediv">
														<input type="text" reg='{"extension":["otherTrainWayVali","不能为空"],"maxlength":"100"}' name="PersonalPhyExamDTO.physiqueExamination.otherTrainingWay" value="${PersonalPhyExamDTO.physiqueExamination.otherTrainingWay}" style="width: 150px" >
													</span>
												</span>
											</td>
										</tr>
									</table>
								<%--</fieldset>--%>
							<%--</div>--%>
							<div class="postdiv">
								<fieldset class="layui-elem-field">
									<table class="posttable">
										<tr>
											<th style="width: 16%;text-align: right;">饮食习惯</th>
											<td colspan="3">
												<label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.dietHunsuEquilibrium" ${PersonalPhyExamDTO.physiqueExamination.dietHunsuEquilibrium eq"1"?"checked":""} value="1"/>
													荤素均衡</label>
												<label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.dietMeatMain" ${PersonalPhyExamDTO.physiqueExamination.dietMeatMain eq"2"?"checked":""} value="2"/>
													荤食为主</label>
												<label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.dietVegetarian" ${PersonalPhyExamDTO.physiqueExamination.dietVegetarian eq"3"?"checked":""} value="3"/>
													素食为主</label>
												<label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.dietHalophilic" ${PersonalPhyExamDTO.physiqueExamination.dietHalophilic eq"4"?"checked":""} value="4"/>
													嗜盐</label>
												<label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.dietAddictedOil" ${PersonalPhyExamDTO.physiqueExamination.dietAddictedOil eq"5"?"checked":""} value="5"/>
													嗜油</label>
												<label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.dietSugarCravings" ${PersonalPhyExamDTO.physiqueExamination.dietSugarCravings eq"6"?"checked":""} value="6"/>
													嗜糖</label>
											</td>
										</tr>
									</table>
								</fieldset>
							</div>
							<div class="postdiv">
								<fieldset class="layui-elem-field">
									<legend>吸烟情况</legend>
									<table class="posttable">
										<tr>
											<th width="16%" style="text-align: right;">吸烟状况</th>
											<td colspan="3">
												<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.smodeStatusCode" dicmeta="CV0300101" value="${PersonalPhyExamDTO.physiqueExamination.smodeStatusCode}" onchange="addPhyExam.setContentStyle(this,'smokePerDaySpan:beginSmokeAgeSpan:endSmokeAgeSpan',1)"/>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">日吸烟量</th>
											<td colspan="3"  >
					    <span id="smokePerDaySpan">
				    		平均
					       <tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" reg="{'min':0,'max':100}" name="PersonalPhyExamDTO.physiqueExamination.dailySmoke" value="${PersonalPhyExamDTO.physiqueExamination.dailySmoke}" style="width: 40px"/>支
					    </span>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">开始吸烟年龄</th>
											<td>
					     <span id="beginSmokeAgeSpan">
						    	<tag:numberInput reg="{'min':0,'max':999}" name="PersonalPhyExamDTO.physiqueExamination.smokeAge" value="${PersonalPhyExamDTO.physiqueExamination.smokeAge}" style="width: 40px"/>岁
					     </span>
											</td>
											<th style="text-align: right;">戒烟年龄</th>
											<td>
				    	<span id="endSmokeAgeSpan">
				    		<tag:numberInput reg="{'min':0,'max':120}" name="PersonalPhyExamDTO.physiqueExamination.quitSmokeAge" value="${PersonalPhyExamDTO.physiqueExamination.quitSmokeAge}" style="width: 40px" /> 岁
				    	</span>
											</td>
										</tr>
									</table>
								</fieldset>
							</div>
							<div class="postdiv">
								<fieldset class="layui-elem-field">
									<legend>饮酒情况</legend>
									<table class="posttable">
										<tr>
											<th width="16%" style="text-align: right;">饮酒频率</th>
											<td colspan="3">
												<ehr:dic-radio code="1,2,3,4" name="PersonalPhyExamDTO.physiqueExamination.drinkFrequency" value="${PersonalPhyExamDTO.physiqueExamination.drinkFrequency }" dicmeta="CV0300104"  onchange="addPhyExam.setContentStyle(this,'wineTypeSpan:isDrunkSpan:beginDrinkingAgeSpan:isEndDrinkingSpan:drinkingPerDaySpan',1)"/>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;" title="折合成白酒量。（啤酒/10=白酒量,红酒/4=白酒量,黄酒/5=白酒量）。">日饮酒量</th>
											<td colspan="3">
				   		<span id="drinkingPerDaySpan">
				    	平均
				        <tag:numberInput onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')" reg="{'min':0,'max':50}"  name="PersonalPhyExamDTO.physiqueExamination.dailyDrink" value="${PersonalPhyExamDTO.physiqueExamination.dailyDrink}"  style="width: 40px" />两
				        </span>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">是否戒酒</th>
											<td colspan="3">
				    	<span id="isEndDrinkingSpan">
					         <label><input type="radio" onclick="util.clickHideText(this,'quitDrinkAgeDesc')"  name="PersonalPhyExamDTO.physiqueExamination.nodrink" ${PersonalPhyExamDTO.physiqueExamination.nodrink eq"2" ?"checked" :""} value="2"/> 未戒酒</label>
					         <label><input type="radio" id="nodrinkId" onclick="util.clickShowText(this,'quitDrinkAgeDesc')" name="PersonalPhyExamDTO.physiqueExamination.nodrink" ${PersonalPhyExamDTO.physiqueExamination.nodrink eq"1" ?"checked" :""} value="1"/>已戒酒 </label>
					         <span class="hidediv" id="quitDrinkAgeDesc">&nbsp;&nbsp;&nbsp;
					                                       戒酒年龄:<tag:numberInput name="PersonalPhyExamDTO.physiqueExamination.nodrinkAge" value="${PersonalPhyExamDTO.physiqueExamination.nodrinkAge}"  style="width: 40px" reg="{'dependOn':'nodrinkId','required':'true','regex':'digits','min':0,'max':999}" />岁
					         </span>
				         </span>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">开始饮酒年龄</th>
											<td>
				    <span id="beginDrinkingAgeSpan">
				    <tag:numberInput reg="{'min':0,'max':100}"  name="PersonalPhyExamDTO.physiqueExamination.drinkAge" value="${PersonalPhyExamDTO.physiqueExamination.drinkAge}"  style="width: 40px" />岁
				    </span>
											</td>
											<th style="text-align: right;">近一年内是否曾醉酒</th>
											<td>
					    <span id="isDrunkSpan">
					    	<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.drunk" value="${PersonalPhyExamDTO.physiqueExamination.drunk }" dicmeta="FS10009"/>
					    </span>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">饮酒种类</th>
											<td colspan="3">
				    	<span id="wineTypeSpan">
				                <label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.drinkSpirit" ${PersonalPhyExamDTO.physiqueExamination.drinkSpirit eq"1"?"checked":""} value="1"/>
					     白酒 </label>
				               <label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.drinkBeer" ${PersonalPhyExamDTO.physiqueExamination.drinkBeer eq"2"?"checked":""} value="2"/>
				                啤酒 </label>
				               <label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.drinkRedWine" ${PersonalPhyExamDTO.physiqueExamination.drinkRedWine eq"3"?"checked":""} value="3"/>
				                红酒 </label>
				                <label><input type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.drinkYellowWine" ${PersonalPhyExamDTO.physiqueExamination.drinkYellowWine eq"4"?"checked":""} value="4"/>
				                黄酒 </label>
				                <label><input type="checkbox" id="drinkOther" name="PersonalPhyExamDTO.physiqueExamination.drinkOther"  onclick="util.clickShowText(this,'drinkOtherDesc')" ${PersonalPhyExamDTO.physiqueExamination.drinkOther eq"5"?"checked":""} value="5"/>
				                其他 </label>
				              <input class="hidediv" id="drinkOtherDesc" type="text" name="PersonalPhyExamDTO.physiqueExamination.drinkOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.drinkOtherDesc}" reg='{"dependOn":"drinkOther","required":"true","maxlength":"33"}'  style="width: 200px">
				   		</span>
											</td>
										</tr>
									</table>
								</fieldset>
							</div>
						<div class="postdiv">
							<fieldset class="layui-elem-field">
								<table class="posttable">
									<tr>
										<th title="填写因职业原因造成的危害。" style="width: 23%;text-align: right;vertical-align: top;">职业病危害因素接触史</th>
										<td>
											<label>
												<input type="radio" onclick="util.clickHideTable(this,'ttb2')"
													   name="PersonalPhyExamDTO.physiqueExamination.occupationExposureFlag" ${PersonalPhyExamDTO.physiqueExamination.occupationExposureFlag eq"0" || PersonalPhyExamDTO.physiqueExamination.occupationExposureFlag eq null ?"checked" :""}
													   value="0"/>无</label>
											<label>
												<input type="radio" id="occupationExposureFlag" onclick="util.clickShowTable(this,'ttb2')"
													   name="PersonalPhyExamDTO.physiqueExamination.occupationExposureFlag" ${PersonalPhyExamDTO.physiqueExamination.occupationExposureFlag eq"1" ?"checked" :""}
													   value="1"/>有</label>
											<div  class="tt_hidden" id="ttb2">
												&nbsp;(工种<input reg='{"dependOn":"occupationExposureFlag","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.physiqueExamination.riskOccupationDesc" value="${PersonalPhyExamDTO.physiqueExamination.riskOccupationDesc}"  style="width: 80px"/> 从业时间
												<tag:numberInput reg="{'dependOn':'occupationExposureFlag','required':true,'min':0,'max':999}" name="PersonalPhyExamDTO.physiqueExamination.riskOccupationTime" value="${PersonalPhyExamDTO.physiqueExamination.riskOccupationTime}"  style="width: 40px"/>年)
												<table>
													<colgroup>
														<col style="width: 15%;" />
														<col style="width: 25%;" />
														<col style="width: 15%;" />
														<col style="width: 40%;">
													</colgroup>
													<tr><td style="text-align: center;" colspan="2">毒物种类</td><td style="text-align: center;" colspan="2">防护措施</td></tr>
													<tr>
														<td style="text-align: right;">粉尘</td>
														<td ><input reg='{"maxlength":"33"}' type="text"
																			   name="PersonalPhyExamDTO.physiqueExamination.dustTypeDesc"
																			   value="${PersonalPhyExamDTO.physiqueExamination.dustTypeDesc}" style="width: 75%;"/>
														</td>
														<td style="text-align: right;">防护措施</td>
														<td  style="text-align: left;">
															<label><input type="radio"
																		  name="PersonalPhyExamDTO.physiqueExamination.dustProtectionFlag"
																		  onclick="util.clickHideText(this,'dustProtectionDesc')"  ${PersonalPhyExamDTO.physiqueExamination.dustProtectionFlag eq"0" ?"checked" :""}
																		  value="0"/>无</label>
															<label><input type="radio" id="dustProtectionFlag"
																		  name="PersonalPhyExamDTO.physiqueExamination.dustProtectionFlag"
																		  onclick="util.clickShowText(this,'dustProtectionDesc')"  ${PersonalPhyExamDTO.physiqueExamination.dustProtectionFlag eq"1" ?"checked" :""}
																		  value="1"/>有</label>
															<input type="text"
																   name="PersonalPhyExamDTO.physiqueExamination.dustProtectionDesc"
																   class="hidediv" id="dustProtectionDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.dustProtectionDesc}"
																   reg='{"dependOn":"dustProtectionFlag","required":"true","maxlength":"33"}' style="width: 60%;"/>
														</td>
													</tr>
													<tr>
														<td style="text-align: right;">放射物质</td>
														<td><input type="text" reg='{"maxlength":"33"}'
																   name="PersonalPhyExamDTO.physiqueExamination.radiationTypeDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.radiationTypeDesc}" style="width: 75%;"/>
														</td>
														<td style="text-align: right;">防护措施</td>
														<td style="text-align: left;">
															<label><input type="radio"
																		  name="PersonalPhyExamDTO.physiqueExamination.radiationProtectionFlag"
																		  onclick="util.clickHideText(this,'radiationProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.radiationProtectionFlag eq"0" ?"checked" :""}
																		  value="0"/>无</label>
															<label><input type="radio" id="radiationProtectionFlag"
																		  name="PersonalPhyExamDTO.physiqueExamination.radiationProtectionFlag"
																		  onclick="util.clickShowText(this,'radiationProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.radiationProtectionFlag eq"1" ?"checked" :""}
																		  value="1"/>有</label>
															<input type="text"
																   name="PersonalPhyExamDTO.physiqueExamination.radiationProtectionDesc"
																   class="hidediv" id="radiationProtectionDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.radiationProtectionDesc}"
																   reg='{"dependOn":"radiationProtectionFlag","required":"true","maxlength":"33"}' style="width: 60%;"/>
														</td>
													</tr>

													<tr>
														<td style="text-align: right;">物理因素</td>
														<td style="text-align: left"><input type="text" reg='{"maxlength":"33"}'
																   name="PersonalPhyExamDTO.physiqueExamination.physicsTypeDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.physicsTypeDesc}" style="width: 75%;"/>
														</td>
														<td style="text-align: right;">防护措施</td>
														<td style="text-align: left;">
															<label><input type="radio"
																		  name="PersonalPhyExamDTO.physiqueExamination.physicsProtectionFlag"
																		  onclick="util.clickHideText(this,'physicsProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.physicsProtectionFlag eq"0" ?"checked" :""}
																		  value="0"/>无</label>
															<label><input type="radio" id="physicsProtectionFlag"
																		  name="PersonalPhyExamDTO.physiqueExamination.physicsProtectionFlag"
																		  onclick="util.clickShowText(this,'physicsProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.physicsProtectionFlag eq"1" ?"checked" :""}
																		  value="1"/>有</label>
															<input type="text"
																   name="PersonalPhyExamDTO.physiqueExamination.physicsProtectionDesc"
																   class="hidediv" id="physicsProtectionDesc" class="hidediv"
																   value="${PersonalPhyExamDTO.physiqueExamination.physicsProtectionDesc}"
																   reg='{"dependOn":"physicsProtectionFlag","required":"true","maxlength":"33"}' style="width: 60%;"/>
														</td>
													</tr>
													<tr>
														<td style="text-align: right;">化学因素</td>
														<td style="text-align: left;"><input reg='{"maxlength":"33"}' type="text"
																   name="PersonalPhyExamDTO.physiqueExamination.chemistryTypeDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.chemistryTypeDesc}" style="width: 75%;"/>
														</td>
														<td style="text-align: right;">防护措施</td>
														<td style="text-align: left;">
															<label><input type="radio"
																		  name="PersonalPhyExamDTO.physiqueExamination.chemistryProtectionFlag"
																		  onclick="util.clickHideText(this,'chemistryProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.chemistryProtectionFlag eq"0" ?"checked" :""}
																		  value="0"/>无</label>
															<label><input type="radio" id="chemistryProtectionFlag"
																		  name="PersonalPhyExamDTO.physiqueExamination.chemistryProtectionFlag"
																		  onclick="util.clickShowText(this,'chemistryProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.chemistryProtectionFlag eq"1" ?"checked" :""}
																		  value="1"/>有</label>
															<input type="text"
																   name="PersonalPhyExamDTO.physiqueExamination.chemistryProtectionDesc"
																   class="hidediv" id="chemistryProtectionDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.chemistryProtectionDesc}"
																   reg='{"dependOn":"chemistryProtectionFlag","required":"true","maxlength":"33"}' style="width: 60%;"/>
														</td>
													</tr>
													<tr>
														<td style="text-align: right;">其他</td>
														<td style="text-align: left;"><input reg='{"maxlength":"33"}' type="text"
																   name="PersonalPhyExamDTO.physiqueExamination.otherTypeDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.otherTypeDesc}" style="width: 75%;"/>
														</td>
														<td style="text-align: right;">防护措施</td>
														<td style="text-align: left;">
															<label><input type="radio"
																		  name="PersonalPhyExamDTO.physiqueExamination.otherProtectionFlag"
																		  onclick="util.clickHideText(this,'otherProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.otherProtectionFlag eq"0" ?"checked" :""}
																		  value="0"/>无</label>
															<label><input type="radio" id="otherProtectionFlag"
																		  name="PersonalPhyExamDTO.physiqueExamination.otherProtectionFlag"
																		  onclick="util.clickShowText(this,'otherProtectionDesc')" ${PersonalPhyExamDTO.physiqueExamination.otherProtectionFlag eq"1" ?"checked" :""}
																		  value="1"/>有</label>
															<input type="text"
																   name="PersonalPhyExamDTO.physiqueExamination.otherProtectionDesc"
																   class="hidediv" id="otherProtectionDesc"
																   value="${PersonalPhyExamDTO.physiqueExamination.otherProtectionDesc}"
																   reg='{"dependOn":"otherProtectionFlag","required":"true","maxlength":"33"}' style="width: 60%;"/>
														</td>
													</tr>
												</table>
											</div >
										</td>
									</tr>
								</table>
						</div>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<legend><label class="required" title="《考核项目》">脏器功能</label></legend>
						<table class="posttable">
							<tr>

                                <th style="width: 16%;vertical-align: top;text-align: right;">口腔</th>
								<td style="width: 84%">
									<table>
										<tr>
											<td colspan="4">口唇&nbsp;
												<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.lipAppearanceCehckResult" value="${PersonalPhyExamDTO.physiqueExamination.lipAppearanceCehckResult }" dicmeta="CV0410007"/>
											</td>
										</tr>
										<tr>
											<td colspan="4">齿列&nbsp;
												<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag" onclick="util.clickHideTable(this,'ttb7')" ${PersonalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag eq '0' or PersonalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag eq null ? "checked" : ""} value="0">正常</label>
												<label><input type="radio" id="dentitionAnomalyFlag" name="PersonalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag" onclick="util.clickShowTable(this,'ttb7')" ${PersonalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag eq '1' ?"checked" :""}  value="1">异常</label>
												<label style="color: red">异常时请填写对应问题中"左上","右上","左下","右下"相关的牙齿数量</label>
												<div id="ttb7" style="display: none; width: 100%; padding-left: 31px;">
													<span style="float:left;"><label><input reg='{"extension":["dentitionAnomalyVali","请至少选择一项"]}' type="checkbox" id="missingTooth" name="PersonalPhyExamDTO.physiqueExamination.missingToothFlg" ${PersonalPhyExamDTO.physiqueExamination.missingToothFlg eq '1'?'checked':''} value="1"  onclick="util.clickShowText(this,'ttb3')">缺齿&nbsp;&nbsp;</label></span>
													<table class="sttb" id="ttb3" style="width: 10%;float:left;margin-right:5px;background-color: grey;-webkit-print-color-adjust:exact;-moz-print-color-adjust:exact;-ms-print-color-adjust:exact;print-color-adjust:exact;">
														<tr>
															<td><tag:numberInput style="width:30px" reg='{"extension":["missingToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.missingToothNumberUpl"  value="${PersonalPhyExamDTO.physiqueExamination.missingToothNumberUpl}"  />  </td>
															<td><tag:numberInput style="width:30px" reg='{"extension":["missingToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.missingToothNumberUpr" value="${PersonalPhyExamDTO.physiqueExamination.missingToothNumberUpr}"  /> </td>
														</tr>
														<tr>
															<td><tag:numberInput style="width:30px" reg='{"extension":["missingToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.missingToothNumberDownl" value="${PersonalPhyExamDTO.physiqueExamination.missingToothNumberDownl}"  /></td>
															<td><tag:numberInput style="width:30px" reg='{"extension":["missingToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.missingToothNumberDownr" value="${PersonalPhyExamDTO.physiqueExamination.missingToothNumberDownr}"  /></td>
														</tr>
													</table>
													<span style="float:left;"><label><input reg='{"extension":["dentitionAnomalyVali","请至少选择一项"]}' type="checkbox" id="decayedTooth" name="PersonalPhyExamDTO.physiqueExamination.decayedToothFlg" ${PersonalPhyExamDTO.physiqueExamination.decayedToothFlg eq '1'?'checked':''} value="1" onclick="util.clickShowText(this,'ttb4')">龋齿&nbsp;&nbsp;</label></span>
													<table class="sttb" id="ttb4" style="width: 10%;float:left;margin-right:5px;background-color: grey;-webkit-print-color-adjust:exact;-moz-print-color-adjust:exact;-ms-print-color-adjust:exact;print-color-adjust:exact;">
														<tr>
															<td><tag:numberInput style="width:30px" reg='{"extension":["decayedToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.decayedToothNumberUpl" value="${PersonalPhyExamDTO.physiqueExamination.decayedToothNumberUpl}"  />  </td>
															<td><tag:numberInput style="width:30px" reg='{"extension":["decayedToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.decayedToothNumberUpr" value="${PersonalPhyExamDTO.physiqueExamination.decayedToothNumberUpr}"  /> </td>
														</tr>
														<tr style="width: 10px;">
															<td><tag:numberInput style="width:30px" reg='{"extension":["decayedToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.decayedToothNumberDownl" value="${PersonalPhyExamDTO.physiqueExamination.decayedToothNumberDownl}"  /></td>
															<td><tag:numberInput style="width:30px" reg='{"extension":["decayedToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.decayedToothNumberDownr" value="${PersonalPhyExamDTO.physiqueExamination.decayedToothNumberDownr}"  /></td>
														</tr>
													</table>
													<span style="float:left;"><label><input reg='{"extension":["dentitionAnomalyVali","请至少选择一项"]}' type="checkbox" id="dentureTooth" name="PersonalPhyExamDTO.physiqueExamination.dentureToothFlg" ${PersonalPhyExamDTO.physiqueExamination.dentureToothFlg eq '1'?'checked':''} value="1"  onclick="util.clickShowText(this,'ttb5')">义齿&nbsp;&nbsp;</label></span>
													<table class="sttb" id="ttb5" style="width: 10%;float:left;margin-right:5px;background-color: grey;-webkit-print-color-adjust:exact;-moz-print-color-adjust:exact;-ms-print-color-adjust:exact;print-color-adjust:exact;">
														<tr >
															<td><tag:numberInput style="width:30px" reg='{"extension":["dentureToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.dentureToothNumberUpl" value="${PersonalPhyExamDTO.physiqueExamination.dentureToothNumberUpl}"  />  </td>
															<td><tag:numberInput style="width:30px" reg='{"extension":["dentureToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.dentureToothNumberUpr" value="${PersonalPhyExamDTO.physiqueExamination.dentureToothNumberUpr}"  /> </td>
														</tr>
														<tr>
															<td><tag:numberInput style="width:30px" reg='{"extension":["dentureToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.dentureToothNumberDownl" value="${PersonalPhyExamDTO.physiqueExamination.dentureToothNumberDownl}"  /></td>
															<td><tag:numberInput style="width:30px" reg='{"extension":["dentureToothVali","请至少选择一项"],"min":0,"max":8}' name="PersonalPhyExamDTO.physiqueExamination.dentureToothNumberDownr" value="${PersonalPhyExamDTO.physiqueExamination.dentureToothNumberDownr}"  /></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="4">咽部&nbsp;
												<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.pharynxCheckResult" value="${PersonalPhyExamDTO.physiqueExamination.pharynxCheckResult }" dicmeta="FS10183"/>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
                                <th title="填写采用对数视力表测量后的具体数值（五分记录）。" style="text-align: right;">视力</th>
								<td colspan="3">
											左眼<tag:numberInput point="point" onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')"  name="PersonalPhyExamDTO.physiqueExamination.lNakedEye" value="${PersonalPhyExamDTO.physiqueExamination.lNakedEye}" style="width: 40px" reg="{'min':0,'max':5.3}"/>
											右眼<tag:numberInput point="point" onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')"  name="PersonalPhyExamDTO.physiqueExamination.rNakedEye" value="${PersonalPhyExamDTO.physiqueExamination.rNakedEye}"  style="width: 40px" reg="{'min':0,'max':5.3}"/>
									（矫正视力:
											左眼<tag:numberInput point="point" onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')"  name="PersonalPhyExamDTO.physiqueExamination.lEyecorrection" value="${PersonalPhyExamDTO.physiqueExamination.lEyecorrection}" style="width: 40px"  reg="{'min':0,'max':5.3}"/>
											右眼<tag:numberInput  point="point" onkeyup="value=value.replace(/^0\d|[^\d.]/g,'')"  name="PersonalPhyExamDTO.physiqueExamination.rEyecorrection" value="${PersonalPhyExamDTO.physiqueExamination.rEyecorrection}"  style="width: 40px" reg="{'min':0,'max':5.3}"/>）
								</td>
							</tr>
							<tr>
									<th title="在被检查者耳边轻声耳语“你叫什么名字”（注意检查时检查者的脸应在被检查者视线之外）,判断被检查者听力状况。" style="text-align: right;">听力</th>
								<td colspan="3">
									<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.hearDetectResult" value="${PersonalPhyExamDTO.physiqueExamination.hearDetectResult }" dicmeta="FS10170"/>
								</td>
							</tr>
							<tr>
									<th title="请被检查者完成以下动作:“双手摸后脑勺”、“捡起这只笔”、“从椅子上站起,走几步,转身,坐下”,判断被检查者运动功能。" style="text-align: right;">运动功能</th>
								<td colspan="3">
									<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.motorFuncState" value="${PersonalPhyExamDTO.physiqueExamination.motorFuncState }" dicmeta="FS10212"/>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<legend title="《考核项目》建议有条件的地区开展眼底检查,特别是针对高血压或糖尿病患者。"><label class="required">查体</label></legend>
						<table class="posttable">
							<tr>
									<th style="width: 16%;text-align: right;">眼底*</th>
								<td colspan="3" style="width: 84%;">
									<label><input type="radio" id="fundusOculiAnomalyFlagWJ" onclick="util.clickHideText(this,'fundusOculiAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq "2" ? "checked" : ""} value="2">未检</label>
									<label><input type="radio" id="fundusOculiAnomalyFlagZC" onclick="util.clickHideText(this,'fundusOculiAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq "0" ? "checked" : ""} value="0">正常</label>
									<label><input type="radio" id="fundusOculiAnomalyFlag"  onclick="util.clickShowText(this,'fundusOculiAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq"1" ?"checked":""} value="1">异常</label>
									<input type="text" id="fundusOculiAnomalyDesc" class="hidediv" name="PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.fundusOculiAnomalyDesc}" style="width: 200px;" reg='{"dependOn":"fundusOculiAnomalyFlag","required":"true","maxlength":"33"}'>
								</td>
							</tr>
							<tr>
									<th style="text-align: right;vertical-align: top;">皮肤</th>
								<td colspan="3">
									<label><input type="radio" id="skinZC" onclick="util.clickHideText(this,'skinCheckDesc')" name="PersonalPhyExamDTO.physiqueExamination.skinCheckResult" ${PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq "1" or PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq null ? "checked" : ""} value="1">正常</label>
									<label><input type="radio" id="skinCH" onclick="util.clickHideText(this,'skinCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.skinCheckResult" ${PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq"2" ?"checked":""} value="2">潮红</label>
									<label><input type="radio" id="skinCB" onclick="util.clickHideText(this,'skinCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.skinCheckResult" ${PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq"3" ?"checked":""} value="3">苍白</label>
									<label><input type="radio" id="skinFQ" onclick="util.clickHideText(this,'skinCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.skinCheckResult" ${PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq"4" ?"checked":""} value="4">发绀</label>
									<label><input type="radio" id="skinHR" onclick="util.clickHideText(this,'skinCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.skinCheckResult" ${PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq"5" ?"checked":""} value="5">黄染</label>
									<label><input type="radio" id="skinSS" onclick="util.clickHideText(this,'skinCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.skinCheckResult" ${PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq"6" ?"checked":""} value="6">色素沉着</label>
									<label><input type="radio" id="skinCheckResult" onclick="util.clickShowText(this,'skinCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.skinCheckResult" ${PersonalPhyExamDTO.physiqueExamination.skinCheckResult eq"7" ?"checked":""} value="7">其他</label>
									<input type="text" id="skinCheckDesc" class="hidediv" name="PersonalPhyExamDTO.physiqueExamination.skinCheckDesc" value="${PersonalPhyExamDTO.physiqueExamination.skinCheckDesc}" style="width: 200px;" reg='{"dependOn":"skinCheckResult","required":"true","maxlength":"33"}'>
								</td>
							</tr>
							<tr>

									<th style="text-align: right;">巩膜</th>
								<td colspan="3">
									<label><input type="radio"  id="scleraZC" onclick="util.clickHideText(this,'scleraCheckDesc')"   name="PersonalPhyExamDTO.physiqueExamination.scleraCheckResult" ${PersonalPhyExamDTO.physiqueExamination.scleraCheckResult eq "1" or PersonalPhyExamDTO.physiqueExamination.scleraCheckResult eq null ? "checked" : ""} value="1">正常</label>
									<label><input type="radio"  id="scleraHR" onclick="util.clickHideText(this,'scleraCheckDesc')"   name="PersonalPhyExamDTO.physiqueExamination.scleraCheckResult" ${PersonalPhyExamDTO.physiqueExamination.scleraCheckResult eq"2" ?"checked":""} value="2">黄染</label>
									<label><input type="radio"  id="scleraBlood" onclick="util.clickHideText(this,'scleraCheckDesc')"   name="PersonalPhyExamDTO.physiqueExamination.scleraCheckResult" ${PersonalPhyExamDTO.physiqueExamination.scleraCheckResult eq"3" ?"checked":""} value="3">充血</label>
									<label><input type="radio" id="scleraCheckResult" onclick="util.clickShowText(this,'scleraCheckDesc')"   name="PersonalPhyExamDTO.physiqueExamination.scleraCheckResult" ${PersonalPhyExamDTO.physiqueExamination.scleraCheckResult eq"4" ?"checked":""} value="4">其他</label>
									<input type="text"  id="scleraCheckDesc" class="hidediv" name="PersonalPhyExamDTO.physiqueExamination.scleraCheckDesc" value="${PersonalPhyExamDTO.physiqueExamination.scleraCheckDesc}"  style="width: 200px;" reg='{"dependOn":"scleraCheckResult","required":"true","maxlength":"33"}'>
								</td>
							</tr>
							<tr>
                                <th style="text-align: right;">淋巴结</th>
								<td colspan="3">
									<label><input type="radio" id="lymphNodeZC" onclick="util.clickHideText(this,'lymphNodeCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult" ${PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq "1" or PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq null ?"checked":""} value="1">未触及</label>
									<label><input type="radio" id="lymphNodeSG" onclick="util.clickHideText(this,'lymphNodeCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult" ${PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"2" ?"checked":""} value="2">锁骨上</label>
									<label><input type="radio" id="lymphNodeWY" onclick="util.clickHideText(this,'lymphNodeCheckDesc')"  name="PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult" ${PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"3" ?"checked":""} value="3">腋窝</label>
									<label><input type="radio" id="lymphNodeCheckResult" onclick="util.clickShowText(this,'lymphNodeCheckDesc')" name="PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult" ${PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"4" ?"checked":""} value="4">其他</label>
									<input type="text" id="lymphNodeCheckDesc" class="hidediv"  name="PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckDesc" value="${PersonalPhyExamDTO.physiqueExamination.lymphNodeCheckDesc}" style="width: 200px;" reg='{"dependOn":"lymphNodeCheckResult","required":"true","maxlength":"33"}'>
								</td>
							</tr>
							<tr>
                                <th style="text-align: right;">肺</th>
								<td colspan="3">
									<table>
										<tr>
											<td style="width: 100%;">桶状胸:
												<label><input id="barrelChestZC" type="radio" name="PersonalPhyExamDTO.physiqueExamination.barrelChest" ${PersonalPhyExamDTO.physiqueExamination.barrelChest eq "0" or PersonalPhyExamDTO.physiqueExamination.barrelChest eq null ? "checked" : ""} value="0">否</label>
												<label><input id="barrelChest" type="radio" name="PersonalPhyExamDTO.physiqueExamination.barrelChest" ${PersonalPhyExamDTO.physiqueExamination.barrelChest eq "1" ?"checked":""} value="1">是</label>
											</td>
										</tr>
										<tr>
											<td>呼吸音:
												<label><input id="lungsAnomalySoundZC" type="radio" onclick="util.clickHideText(this, 'lungsAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.lungsAnomalySound" ${PersonalPhyExamDTO.physiqueExamination.lungsAnomalySound eq "1" or PersonalPhyExamDTO.physiqueExamination.lungsAnomalySound eq null ?"checked":""} value="1">正常</label>
												<label><input type="radio" id="lungsAnomalySound" onclick="util.clickShowTable(this,'lungsAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.lungsAnomalySound" ${PersonalPhyExamDTO.physiqueExamination.lungsAnomalySound eq"0" ?"checked":""} value="0">异常</label>
												<input type="text" id="lungsAnomalyDesc" name="PersonalPhyExamDTO.physiqueExamination.lungsAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.lungsAnomalyDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"lungsAnomalySound","required":"true","maxlength":"33"}'>
											</td>
										</tr>
										<tr>
											<td colspan="4">啰&nbsp;&nbsp;&nbsp;音:
												<label><input id="lungsRaleZC" type="radio" onclick="util.clickHideText(this, 'lungsRaleDesc')" name="PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag" ${PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag eq "1" or PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag eq null  ?"checked":""} value="1">无</label>
												<label><input id="lungsRaleFlagG" type="radio" onclick="util.clickHideText(this, 'lungsRaleDesc')"  name="PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag" ${PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"2" ?"checked":""} value="2">干啰音</label>
												<label><input id="lungsRaleFlagS" type="radio" onclick="util.clickHideText(this, 'lungsRaleDesc')"  name="PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag" ${PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"3" ?"checked":""} value="3">湿啰音</label>
												<label><input type="radio" id="lungsRaleFlag" onclick="util.clickShowTable(this,'lungsRaleDesc')" name="PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag" ${PersonalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"4" ?"checked":""} value="4">其他</label>
												<input type="text" id="lungsRaleDesc" name="PersonalPhyExamDTO.physiqueExamination.lungsRaleDesc" value="${PersonalPhyExamDTO.physiqueExamination.lungsRaleDesc}" CLASS="hidediv" style="width: 150px;" reg='{"dependOn":"lungsRaleFlag","required":"true","maxlength":"33"}'>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
									<th style="text-align: right;">心脏</th>
								<td colspan="3">
									<table>
										<tr>
											<td>
                                                心率:<tag:numberInput reg="{'min':0,'max':999}" id="heartRate" name="PersonalPhyExamDTO.physiqueExamination.heartRate" value="${PersonalPhyExamDTO.physiqueExamination.heartRate}"  style="width: 40px;" />次/分钟
											</td>
										</tr>
										<tr>
											<td>
												心律: <ehr:dic-radio id="cardioverter" name="PersonalPhyExamDTO.physiqueExamination.cardioverter" dicmeta="FS10176" value="${PersonalPhyExamDTO.physiqueExamination.cardioverter}"/>
											</td>
										</tr>
										<tr>
											<td>
												杂音: <label><input type="radio" id="heartMurmurFlagZC" onclick="util.clickHideText(this,'heartMurmurDesc')" name="PersonalPhyExamDTO.physiqueExamination.heartMurmurFlag" ${PersonalPhyExamDTO.physiqueExamination.heartMurmurFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.heartMurmurFlag eq null  ? "checked" : ""} value="0">无</label>
												<label><input type="radio" id="heartMurmurFlag" onclick="util.clickShowText(this,'heartMurmurDesc')" name="PersonalPhyExamDTO.physiqueExamination.heartMurmurFlag" ${PersonalPhyExamDTO.physiqueExamination.heartMurmurFlag eq"1" ?"checked":""} value="1">有</label>
												<span id="heartMurmurDesc" CLASS="hidediv"> <input reg='{"dependOn":"heartMurmurFlag","required":"true","maxlength":"33"}' type="text" name="PersonalPhyExamDTO.physiqueExamination.heartMurmurDesc" value="${PersonalPhyExamDTO.physiqueExamination.heartMurmurDesc}" style="width: 150px;">次/分钟</span>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>

									<th style="text-align: right;">腹部</th>
								<td colspan="3">
									<table>
										<tr>
											<td style="width: 100%">
												压痛:
												<label><input type="radio" id="abdominalTendernessFlagZC" onclick="util.clickHideText(this,'abdominalTendernessDesc')" name="PersonalPhyExamDTO.physiqueExamination.abdominalTendernessFlag" ${PersonalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq null ? "checked" : ""} value="0"/>无</label>
												<label><input type="radio" id="abdominalTendernessFlag" onclick="util.clickShowText(this,'abdominalTendernessDesc')" name="PersonalPhyExamDTO.physiqueExamination.abdominalTendernessFlag" ${PersonalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq "1" ? "checked" : ""} value="1" />有</label>
												<input type="text" id="abdominalTendernessDesc" name="PersonalPhyExamDTO.physiqueExamination.abdominalTendernessDesc" value="${PersonalPhyExamDTO.physiqueExamination.abdominalTendernessDesc}" CLASS="hidediv" style="width: 150px;" reg='{"dependOn":"abdominalTendernessFlag","required":"true","maxlength":"33"}'/>
											</td>
										</tr>
										<tr>
											<td>包块:
												<label><input type="radio" id="abdominalMassFlagZC" onclick="util.clickHideText(this,'abdominalMassDesc')" name="PersonalPhyExamDTO.physiqueExamination.abdominalMassFlag" ${PersonalPhyExamDTO.physiqueExamination.abdominalMassFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.abdominalMassFlag eq null ? "checked" : ""} value="0">无</label>
												<label><input type="radio" id="abdominalMassFlag" onclick="util.clickShowText(this,'abdominalMassDesc')" name="PersonalPhyExamDTO.physiqueExamination.abdominalMassFlag" ${PersonalPhyExamDTO.physiqueExamination.abdominalMassFlag eq "1" ? "checked" : ""} value="1">有</label>
												<input type="text"  id="abdominalMassDesc" name="PersonalPhyExamDTO.physiqueExamination.abdominalMassDesc" value="${PersonalPhyExamDTO.physiqueExamination.abdominalMassDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"abdominalMassFlag","required":"true","maxlength":"33"}'>
											</td>
										</tr>
										<tr>
											<td>肝大:
												<label><input type="radio" id="liverFlagZC" onclick="util.clickHideText(this,'liverDesc')" name="PersonalPhyExamDTO.physiqueExamination.liverFlag" ${PersonalPhyExamDTO.physiqueExamination.liverFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.liverFlag eq null ? "checked" : ""} value="0">无</label>
												<label><input type="radio" id="liverFlag" onclick="util.clickShowText(this,'liverDesc')" name="PersonalPhyExamDTO.physiqueExamination.liverFlag" ${PersonalPhyExamDTO.physiqueExamination.liverFlag eq "1" ? "checked" : ""} value="1">有</label>
												<input type="text"  id="liverDesc" name="PersonalPhyExamDTO.physiqueExamination.liverDesc" value="${PersonalPhyExamDTO.physiqueExamination.liverDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"liverFlag","required":"true","maxlength":"33"}'>
											</td>
										</tr>
										<tr>
											<td>脾大:
												<label><input type="radio" id="splenomegalyFlagZC" onclick="util.clickHideText(this,'splenomegalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.splenomegalyFlag" ${PersonalPhyExamDTO.physiqueExamination.splenomegalyFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.splenomegalyFlag eq null ? "checked" : ""} value="0">无</label>
												<label><input type="radio" id="splenomegalyFlag" onclick="util.clickShowText(this,'splenomegalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.splenomegalyFlag" ${PersonalPhyExamDTO.physiqueExamination.splenomegalyFlag eq "1" ? "checked" : ""} value="1">有</label>
												<input type="text"  id="splenomegalyDesc" name="PersonalPhyExamDTO.physiqueExamination.splenomegalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.splenomegalyDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"splenomegalyFlag","required":"true","maxlength":"33"}'>
											</td>
										</tr>
										<tr>
											<td>移动性浊音:
												<label><input type="radio" id="abdominalVoicedFlagZC" onclick="util.clickHideText(this,'abdominalVoicedDesc')" name="PersonalPhyExamDTO.physiqueExamination.abdominalVoicedFlag" ${PersonalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq null ? "checked" : ""} value="0">无</label>
												<label><input type="radio" id="abdominalVoicedFlag" onclick="util.clickShowText(this,'abdominalVoicedDesc')" name="PersonalPhyExamDTO.physiqueExamination.abdominalVoicedFlag" ${PersonalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq "1" ?"checked":""} value="1">有</label>
												<input type="text" id="abdominalVoicedDesc" name="PersonalPhyExamDTO.physiqueExamination.abdominalVoicedDesc" value="${PersonalPhyExamDTO.physiqueExamination.abdominalVoicedDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"abdominalVoicedFlag","required":"true","maxlength":"33"}'>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>

									<th style="text-align: right;">下肢水肿</th>
								<td colspan="3">
									<ehr:dic-radio id="legsEdema" name="PersonalPhyExamDTO.physiqueExamination.legsEdemaCheckResult" dicmeta="CV0410014"  value="${PersonalPhyExamDTO.physiqueExamination.legsEdemaCheckResult}"/>
								</td>
							</tr>
							<tr>

									<th title="糖尿病患者必须进行此项检查。" style="text-align: right;">足背动脉搏动</th>
								<td colspan="3">
									<ehr:dic-radio id="arteriopalmus" name="PersonalPhyExamDTO.physiqueExamination.arteriopalmus" dicmeta="CV0410015" value="${PersonalPhyExamDTO.physiqueExamination.arteriopalmus}"/>
								</td>
							</tr>
							<tr>
									<th style="text-align: right;vertical-align: top;">肛门指诊*</th>
								<td colspan="3">
									<label><input id="dreWJ" type="radio" name="PersonalPhyExamDTO.physiqueExamination.dreCheckResultType" ${PersonalPhyExamDTO.physiqueExamination.dreCheckResultType eq "0" ? "checked" : ""} value="0" onchange="toggleOther('PersonalPhyExamDTO.physiqueExamination.dreCheckResultType','dreCheckResultTypeSpan',9)"/>未检</label>
									<ehr:dic-radio id="dre" name="PersonalPhyExamDTO.physiqueExamination.dreCheckResultType" dicmeta="CV0410013" value="${PersonalPhyExamDTO.physiqueExamination.dreCheckResultType}" onchange="toggleOther('PersonalPhyExamDTO.physiqueExamination.dreCheckResultType','dreCheckResultTypeSpan',9)"/>
									<span style="display: none;" id="dreCheckResultTypeSpan">
							        	描述:<input reg='{"maxlength":"33"}' type="text" id="dreCheckResultDesc_inputId" name="PersonalPhyExamDTO.physiqueExamination.dreCheckResultDesc" value="${PersonalPhyExamDTO.physiqueExamination.dreCheckResultDesc}"  style="width: 200px;"/>
							        </span>
								</td>
							</tr>
							<tr>
									<th style="text-align: right;vertical-align: top;">乳腺*</th>
								<td colspan="3">
									<label><input type="radio" id="breastAnomaly" onclick="util.clickHideTable(this,'ttb8')" name="PersonalPhyExamDTO.physiqueExamination.breastAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.breastAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
									<label><input type="radio" id="breastAnomalyZC" onclick="util.clickHideTable(this,'ttb8')" name="PersonalPhyExamDTO.physiqueExamination.breastAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.breastAnomalyFlag eq "0" ?"checked":""} value="0"> 未见异常</label>
									<label><input type="radio" id="breastAnomalyFlag" onclick="util.clickShowTable(this,'ttb8','breastOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.breastAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.breastAnomalyFlag eq "1" ?"checked":""} value="1"> 有异常</label>
									<span id="ttb8" class="tt_hidden">
			            <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.breastResection" ${PersonalPhyExamDTO.physiqueExamination.breastResection eq '1' ? 'checked' : ''} value="1" > 乳房切除 </label>
			            <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.breastAnomalyLactation" ${PersonalPhyExamDTO.physiqueExamination.breastAnomalyLactation eq '1' ? 'checked' : ''} value="1"> 异常泌乳</label>
			            <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.breastMass" ${PersonalPhyExamDTO.physiqueExamination.breastMass eq '1' ? 'checked' : ''} value="1"> 乳腺包块</label>
			            <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" id="breastOther" onclick="util.clickShowText(this,'breastOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.breastOther" ${PersonalPhyExamDTO.physiqueExamination.breastOther eq '1' ? 'checked' : ''} value="1"> 其他</label>
			            <input type="text" reg='{"dependOn":"breastOther","maxlength":"33"}' id="breastOtherDesc" name="PersonalPhyExamDTO.physiqueExamination.breastOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.breastOtherDesc}" CLASS="hidediv"  style="width: 200px;"/>
			        </span>
								</td>
							</tr>
							<c:if test="${isWoman}">
								<tr>
										<th style="text-align: right;vertical-align: top;">妇科*</th>
									<td colspan="3">
										<table>
											<tr>
												<td title="记录发育情况及婚产式（未婚、已婚未产或经产式）,如有异常情况请具体描述。">外阴&nbsp;&nbsp;
													<label><input type="radio" id="vulvaAnomaly" onclick="util.clickHideText(this,'vulvaAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
													<label><input type="radio" id="vulvaAnomalyZC" onclick="util.clickHideText(this,'vulvaAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
													<label><input type="radio" id="vulvaAnomalyFlag" onclick="util.clickShowText(this,'vulvaAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq "1" ? "checked" : ""} value="1"> 有异常</label>
													<input reg='{"maxlength":"33"}' type="text" id="vulvaAnomalyDesc" name="PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"vulvaAnomalyFlag","required":"true"}'>
												</td>
											</tr>
											<tr>
												<td title="记录是否通畅,黏膜情况,分泌物量、色、性状一级有无异味等。">阴道&nbsp;&nbsp;
													<label><input type="radio" id="vaginaAnomaly" onclick="util.clickHideText(this,'vaginaAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
													<label><input type="radio" id="vaginaAnomalyZC" onclick="util.clickHideText(this,'vaginaAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
													<label><input type="radio" id="vaginaAnomalyFlag" onclick="util.clickShowText(this,'vaginaAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq"1" ?"checked":""} value="1"> 有异常</label>
													<input reg='{"maxlength":"33"}' type="text" id="vaginaAnomalyDesc" name="PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"vaginaAnomalyFlag","required":"true"}'>
												</td>
											</tr>
											<tr>
												<td title="记录大小、质地、有无糜烂、撕裂、息肉、腺囊肿;有无接触性出血、举痛等。">宫颈&nbsp;&nbsp;
													<label><input type="radio" id="cervicalAnomaly" onclick="util.clickHideText(this,'cervicalAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
													<label><input type="radio" id="cervicalAnomalyZC" onclick="util.clickHideText(this,'cervicalAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
													<label><input type="radio" id="cervicalAnomalyFlag" onclick="util.clickShowText(this,'cervicalAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq "1" ? "checked" : ""} value="1"> 有异常</label>
													<input reg='{"maxlength":"33"}' type="text" id="cervicalAnomalyDesc" name="PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"cervicalAnomalyFlag","required":"true"}'>
												</td>
											</tr>
											<tr>
												<td title="记录位置、大小、质地、活动度;有无压痛等。">宫体&nbsp;&nbsp;
													<label><input type="radio" id="corpusAnomaly" onclick="util.clickHideText(this,'corpusAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.corpusAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
													<label><input type="radio" id="corpusAnomalyZC" onclick="util.clickHideText(this,'corpusAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.corpusAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
													<label><input type="radio" id="corpusAnomalyFlag" onclick="util.clickShowText(this,'corpusAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.corpusAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq"1" ? "checked" : ""} value="1"> 有异常</label>
													<input reg='{"maxlength":"33"}' type="text" id="corpusAnomalyDesc" name="PersonalPhyExamDTO.physiqueExamination.corpusAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.corpusAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"corpusAnomalyFlag","required":"true"}'>
												</td>
											</tr>
											<tr>
												<td title="记录位置、大小、质地、活动度;有无压痛等。">附件&nbsp;&nbsp;
													<label><input type="radio" id="accessoriesAnomaly" onclick="util.clickHideText(this,'accessoriesAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
													<label><input type="radio" id="accessoriesAnomalyZC" onclick="util.clickHideText(this,'accessoriesAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
													<label><input type="radio" id="accessoriesAnomalyFlag" onclick="util.clickShowText(this,'accessoriesAnomalyDesc')" name="PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq"1" ?"checked":""} value="1"> 有异常</label>
													<input reg='{"maxlength":"33"}' type="text" id="accessoriesAnomalyDesc" name="PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"accessoriesAnomalyFlag","required":"true"}'>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</c:if>
							<tr>
									<th style="text-align: right;">其他*</th>
									<td>
										<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.physiqueExamination.otherCheckResult" value="${PersonalPhyExamDTO.physiqueExamination.otherCheckResult}" style="width: 200px;">
									</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<legend>辅助检查</legend>
						<table class="posttable"  id="accessoryExam">

								<tr>
									<th style="width: 20%;text-align: right;vertical-align: top;">血常规*</th>
									<td id="RoutineBloodTest">
										血红蛋白<tag:numberInput reg="{'min':0,'max':9999}" name="PersonalPhyExamDTO.physiqueExamination.hemoglobinValue" value="${PersonalPhyExamDTO.physiqueExamination.hemoglobinValue}" style="width: 40px;"/>g/L
										&nbsp;&nbsp;&nbsp;&nbsp;
										白细胞<tag:numberInput id="ncgLeu" reg="{'min':0,'max':999.9}" point="point"  name="PersonalPhyExamDTO.physiqueExamination.leukocyteCount" value="${PersonalPhyExamDTO.physiqueExamination.leukocyteCount}"  style="width: 40px;" /> ×10<sup>9</sup>/L
										&nbsp;&nbsp;&nbsp;&nbsp;
										血小板<tag:numberInput reg="{'min':0,'max':9999}" name="PersonalPhyExamDTO.physiqueExamination.plateletCount" value="${PersonalPhyExamDTO.physiqueExamination.plateletCount}"  style="width: 40px;" /> ×10<sup>9</sup>/L
										&nbsp;&nbsp;&nbsp;&nbsp;
										其他&nbsp;&nbsp;<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.physiqueExamination.bloodRoutineOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.bloodRoutineOtherDesc}"  style="width: 100px;"/>
									</td>
								</tr>
								<tr>
									<th title="“尿蛋白、尿糖、尿酮体、尿潜血”可以填写定性检查结果,阴性填“-”,阳性根据检查结果填写“+”、“++”、“+++”或“++++”,也可以填写定量检查结果,定量结果需写明计量单位。" style="text-align: right;vertical-align: top;">尿常规*</th>
									<td id="urinalysis">
										尿蛋白<input id="ncgPro" type="text" reg='{"maxlength":"50"}' name="PersonalPhyExamDTO.physiqueExamination.urineProQuantitativeValue" value="${PersonalPhyExamDTO.physiqueExamination.urineProQuantitativeValue}"  style="width: 80px;"/>
										&nbsp;&nbsp;
										尿糖<input id="ncgGlu" type="text" reg='{"maxlength":"50"}' name="PersonalPhyExamDTO.physiqueExamination.urineSugQuantitativeValue" value="${PersonalPhyExamDTO.physiqueExamination.urineSugQuantitativeValue}" style="width: 80px;"/>
										&nbsp;&nbsp;
										尿酮体<input id="ncgKet" type="text" reg='{"maxlength":"50"}'  name="PersonalPhyExamDTO.physiqueExamination.ketQuantitativeValue" value="${PersonalPhyExamDTO.physiqueExamination.ketQuantitativeValue}"  style="width: 80px;" />
										&nbsp;&nbsp;
										尿潜血<input id="ncgBlo" type="text" reg='{"maxlength":"50"}' name="PersonalPhyExamDTO.physiqueExamination.eryQuantitativeValue" value="${PersonalPhyExamDTO.physiqueExamination.eryQuantitativeValue}"  style="width: 80px;"/>
										&nbsp;&nbsp;
										其他<input type="text" reg='{"maxlength":"100"}' name="PersonalPhyExamDTO.physiqueExamination.urineRoutinesOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.urineRoutinesOtherDesc}"  style="width: 150px;"/>
									</td>
								</tr>
								<tr>
									<c:if test="${isChild}">
										<th style="text-align: right;"><label>空腹血糖</label></th>
										<td>
											<tag:numberInput showlen="1" point="point" reg='{"max":"99.99","scale":"2","regex":"number"}' name="PersonalPhyExamDTO.physiqueExamination.fpgMmol" value="${PersonalPhyExamDTO.physiqueExamination.fpgMmol}"  style="width: 40px;" id="bloodGlucoseLeft"/>mmol/L
											或
											<tag:numberInput showlen="1" point="point" reg='{"max":"99.99","scale":"2","regex":"number"}'  name="PersonalPhyExamDTO.physiqueExamination.fpgMg" value="${PersonalPhyExamDTO.physiqueExamination.fpgMg}"  style="width: 40px;"  id="bloodGlucoseRight"/>mg/dL
										</td>
									</c:if>
									<c:if test="${!isChild}">
										<th style="text-align: right;"><label >空腹血糖</label></th><%--class="required" "extension":["FastingBloodVali","请至少选择一项"],--%>
										<td id="ttb15">
											<tag:numberInput showlen="1" point="point" reg='{"max":"99.99","scale":"2","regex":"number"}' name="PersonalPhyExamDTO.physiqueExamination.fpgMmol" value="${PersonalPhyExamDTO.physiqueExamination.fpgMmol}"  style="width: 40px;" id="bloodGlucoseLeft"/>mmol/L
											或
											<tag:numberInput showlen="1" point="point" reg='{"max":"99.99","scale":"2","regex":"number"}'  name="PersonalPhyExamDTO.physiqueExamination.fpgMg" value="${PersonalPhyExamDTO.physiqueExamination.fpgMg}"  style="width: 40px;"  id="bloodGlucoseRight"/>mg/dL
										</td>
									</c:if>
								</tr>

								<tr id="bloodSugarSource" style="display: none">
									<th style="text-align: right;">
										<label class="required">来源</label></th>
									<td>
										<ehr:dic-radio dicmeta="TFJKDA001" id="bloodSugarSource" name="PersonalPhyExamDTO.physiqueExamination.bloodSugarSource" value="${PersonalPhyExamDTO.physiqueExamination.bloodSugarSource}" reg="{'required':true}"/>
									</td>
								</tr>



								<tr>
									<th style="text-align: right;">心电图*</th>
									<td id="ECG">
										<%--onclick="util.clickHideText(this,'ecgAnomalyDesc')"
										onclick="util.clickShowText(this,'ecgAnomalyDesc')"
										class="hidediv"--%>
										<label><input type="radio"  name="PersonalPhyExamDTO.physiqueExamination.ecgAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq "2" ? "checked" : ""} value="2"> 未检</label>
										<label><input type="radio"  name="PersonalPhyExamDTO.physiqueExamination.ecgAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq "0" ? "checked" : ""} value="0"> 正常</label>
										<label><input type="radio" id="ecgAnomalyFlag" name="PersonalPhyExamDTO.physiqueExamination.ecgAnomalyFlag" ${PersonalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq"1" ?"checked":""} value="1"> 异常</label>
									</td>
								</tr>
								<tr>
									<th></th>
									<td>
										<input type="text" id="ecgAnomalyDesc" name="PersonalPhyExamDTO.physiqueExamination.ecgAnomalyDesc" value="${PersonalPhyExamDTO.physiqueExamination.ecgAnomalyDesc}" style="width: 80%;" reg='{"dependOn":"ecgAnomalyFlag","required":"true","maxlength":"200"}'>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">尿微量白蛋白*</th>
									<td>
										<tag:numberInput point="point" reg="{'min':0,'max':9999.9}" name="PersonalPhyExamDTO.physiqueExamination.urineMicroTongAlbumin" value="${PersonalPhyExamDTO.physiqueExamination.urineMicroTongAlbumin}"  style="width: 40px;"/>mg/dL
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">大便潜血*</th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.fecalOccultBlood" ${PersonalPhyExamDTO.physiqueExamination.fecalOccultBlood eq "0" ? "checked" : ""} value="0"/>未检</label>
										<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.fecalOccultBlood" value="${PersonalPhyExamDTO.physiqueExamination.fecalOccultBlood }" dicmeta="FS10058"/>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">糖化血红蛋白*</th>
									<td>
										<tag:numberInput  point="point" reg='{"max":"99.99","scale":"2","regex":"number"}' name="PersonalPhyExamDTO.physiqueExamination.hgb" value="${PersonalPhyExamDTO.physiqueExamination.hgb}"  style="width: 40px;" />%
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">乙型肝炎表面抗原*</th>
									<td>
										<label><input type="radio" name="PersonalPhyExamDTO.physiqueExamination.hbsagDetectResult" ${PersonalPhyExamDTO.physiqueExamination.hbsagDetectResult eq "0" ? "checked" : ""} value="0"/>未检</label>
										<ehr:dic-radio name="PersonalPhyExamDTO.physiqueExamination.hbsagDetectResult" value="${PersonalPhyExamDTO.physiqueExamination.hbsagDetectResult }" dicmeta="FS10058"/>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">肝功能*</th>
									<td id="liver">
										血清谷丙转氨酶 <tag:numberInput point="point" reg="{'min':0,'max':999.99}"  name="PersonalPhyExamDTO.physiqueExamination.serumGptValue" value="${PersonalPhyExamDTO.physiqueExamination.serumGptValue}" style="width: 80px;" />U/L
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										血清谷草转氨酶 <tag:numberInput point="point" reg="{'min':0,'max':999.99}"  name="PersonalPhyExamDTO.physiqueExamination.serumAstValue" value="${PersonalPhyExamDTO.physiqueExamination.serumAstValue}"  style="width: 80px;" />U/L
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										白蛋白浓度  <tag:numberInput point="point" reg="{'min':0,'max':999.99}"  name="PersonalPhyExamDTO.physiqueExamination.albuminConcentration" value="${PersonalPhyExamDTO.physiqueExamination.albuminConcentration}"  style="width: 80px;"  />g/L
										<br>
										总胆红素  <tag:numberInput id="ncgBil" point="point" reg="{'min':0,'max':999.9}"  name="PersonalPhyExamDTO.physiqueExamination.totalBilirubin" value="${PersonalPhyExamDTO.physiqueExamination.totalBilirubin}" style="width: 80px;" />μmol/L
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										结合胆红素  <%--<tag:numberInput point="point" reg="{'min':0,'max':9999.9}"  name="PersonalPhyExamDTO.physiqueExamination.conjugatedBilirubin" value="${PersonalPhyExamDTO.physiqueExamination.conjugatedBilirubin}"  style="width: 80px;" />--%>
										<%--<input type="text" name="PersonalPhyExamDTO.physiqueExamination.conjugatedBilirubin" value="${PersonalPhyExamDTO.physiqueExamination.conjugatedBilirubin}"  style="width: 80px;" />μmol/L--%>
										<tag:numberInput point="point" reg="{'min':0,'max':9999.9}"  name="PersonalPhyExamDTO.physiqueExamination.conjugatedBilirubin" value="${PersonalPhyExamDTO.physiqueExamination.conjugatedBilirubin}"  style="width: 80px;" />μmol/L
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">肾功能*</th>
									<td id="kidney">
										血清肌酐 <tag:numberInput point="point" reg="{'min':0,'max':999.9}"  name="PersonalPhyExamDTO.physiqueExamination.creatinine" value="${PersonalPhyExamDTO.physiqueExamination.creatinine}"  style="width: 80px;" />μmol/L
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										血尿素氮 <tag:numberInput point="point" reg="{'min':0,'max':999.9}"  name="PersonalPhyExamDTO.physiqueExamination.bloodUreaNitrogenValue" value="${PersonalPhyExamDTO.physiqueExamination.bloodUreaNitrogenValue}" style="width: 80px;" />mmol/L
										<br>
										血钾浓度  <tag:numberInput point="point"  reg="{'min':0,'max':999.9}" name="PersonalPhyExamDTO.physiqueExamination.potassiumConcentration" value="${PersonalPhyExamDTO.physiqueExamination.potassiumConcentration}"  style="width: 80px;" />mmol/L
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										血钠浓度  <tag:numberInput  reg="{'min':0,'max':9999}"  name="PersonalPhyExamDTO.physiqueExamination.sodiumConcentration" value="${PersonalPhyExamDTO.physiqueExamination.sodiumConcentration}" style="width: 80px;"  />mmol/L
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">血脂*</th>
									<td id="bloodFat">
										总胆固醇 <tag:numberInput id="cho" point="point" reg="{'min':0,'max':999.99}" name="PersonalPhyExamDTO.physiqueExamination.tc" value="${PersonalPhyExamDTO.physiqueExamination.tc}" style="width: 80px;" />mmol/L
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										甘油三酯 <tag:numberInput id="tg" point="point" reg="{'min':0,'max':99.9}" name="PersonalPhyExamDTO.physiqueExamination.triglycerideValue" value="${PersonalPhyExamDTO.physiqueExamination.triglycerideValue}"  style="width: 80px;"  />mmol/L
										<br>
										血清低密度脂蛋白胆固醇 <tag:numberInput id="ldl" reg="{'min':0,'max':999.99}" point="point" name="PersonalPhyExamDTO.physiqueExamination.ldlcDetectValue" value="${PersonalPhyExamDTO.physiqueExamination.ldlcDetectValue}"  style="width: 80px;" />mmol/L
										<br>
										血清高密度脂蛋白胆固醇  <tag:numberInput id="hdl" reg="{'min':0,'max':999.99}" point="point" name="PersonalPhyExamDTO.physiqueExamination.hdlcDetectValue" value="${PersonalPhyExamDTO.physiqueExamination.hdlcDetectValue}" style="width: 80px;" />mmol/L
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;">胸部X线片*</th>
									<td>
										<%--onclick="util.clickHideText(this,'chestXAnomalyfDesc')"
										onclick="util.clickShowText(this,'chestXAnomalyfDesc')"
										CLASS="hidediv"--%>
										<label><input type="radio"  name="PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag" value="2" ${PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
										<label><input type="radio"  name="PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag eq "0" ?"checked":""} value="0"> 正常</label>
										<label><input type="radio" id="chestXAnomalyfFlag"  name="PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag eq"1" ?"checked":""} value="1"> 异常</label>
											<br/>
										<input type="text" id="chestXAnomalyfDesc" name="PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfDesc" value="${PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfDesc}"  style="width: 80%;"  reg='{"dependOn":"chestXAnomalyfFlag","required":"true","maxlength":"500"}'>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;vertical-align: top;">B超*</th>
									<td id="BUltrason">
										腹部B超：
										<%--onclick="util.clickHideText(this,'bmodeAnomalyfDesc')"
										onclick="util.clickShowText(this,'bmodeAnomalyfDesc')"
										class="hidediv"--%>
										<label><input type="radio"  name="PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag" value="2" ${PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
										<label><input type="radio"  name="PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq "0" ?"checked":""} value="0"> 正常</label>
										<label><input type="radio" id="bmodeAnomalyfFlag"  name="PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq"1" ?"checked":""} value="1"> 异常</label>
										<input type="text" id="bmodeAnomalyfDesc" name="PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfDesc" value="${PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfDesc}" title="${PersonalPhyExamDTO.physiqueExamination.bmodeAnomalyfDesc}" style="width: 80%;"  reg='{"maxlength":"800"}'>
										<br>
										其他B超：
										<label><input  type="radio"  name="PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag" value="2" ${PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
										<label><input  type="radio"  name="PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq "0" ?"checked":""} value="0"> 正常</label>
										<label><input  type="radio" id="bmodeOtherAnomalyfFlag" onclick="util.clickShowText(this,'bmodeOtherAnomalyfDesc')" name="PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq"1" ?"checked":""} value="1"> 异常</label>
										<input type="text" id="bmodeOtherAnomalyfDesc" name="PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfDesc" value="${PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfDesc}" title="${PersonalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfDesc}"  style="width: 80%;"  reg='{"maxlength":"100"}'>
									</td>
								</tr>
								<c:if test="${isWoman}">
									<tr>
										<th style="text-align: right;">宫颈涂片*</th>
										<td>
											<label><input type="radio" onclick="util.clickHideText(this,'cervicalSmearAnomalyfDesc')" name="PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag" value="2" ${PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
											<label><input type="radio" onclick="util.clickHideText(this,'cervicalSmearAnomalyfDesc')" name="PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag eq "0" ?" checked" : ""} value="0"> 正常</label>
											<label><input type="radio" id="cervicalSmearAnomalyfFlag" onclick="util.clickShowText(this,'cervicalSmearAnomalyfDesc')"name="PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag" ${PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag eq"1" ? "checked" : ""} value="1"> 异常</label>
											<input type="text" id="cervicalSmearAnomalyfDesc" name="PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfDesc" value="${PersonalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"cervicalSmearAnomalyfFlag","required":"true","maxlength":"100"}'>
										</td>
									</tr>
								</c:if>
								<tr>
									<th style="text-align: right;">其他*</th>
									<td>
										<input type="text" reg='{"maxlength":"200"}' name="PersonalPhyExamDTO.physiqueExamination.otherAuxiliaryExamination" value="${PersonalPhyExamDTO.physiqueExamination.otherAuxiliaryExamination}" style="width: 80%;" />
									</td>
								</tr>
						</table>
					</fieldset>
				</div>
				<%-- <c:if test="${personInfo.oldPeopleFlag}">--%>
					<c:if test="${isElder}">
					<div class="postdiv">
						<fieldset class="layui-elem-field">
							<legend class="required">中医体质辨识</legend>
							<div class="toolbarsublist">
								<input type="hidden" value="${isElder}" id="isElder"/>
				            	<input type="hidden" value="${PersonalPhyExamDTO.physiqueExamination.identificationId}" id="identificationId" name="PersonalPhyExamDTO.physiqueExamination.identificationId"/>
				                <input type="hidden" value="${PersonalPhyExamDTO.physiqueExamination.identificationId}" name="PersonalPhyExamDTO.physiqueExamination.oldIdentificationId"/>
				                <a class="add-link layui-btn layui-btn-xs" id="relatedIden" href="#" title="关联体质辨识" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>关联体质辨识</a>
				                
							</div>

							<table class="posttable" id="CMedicine" style="display: none;">
								<tr>
									<th style="width: 16%;text-align: right;">平和质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmPeacefulQuality" dicmeta="FS10186" code="1,2,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmPeacefulQuality}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">气虚质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmQiQuality" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmQiQuality}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">阳虚质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmYangQuality" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmYangQuality}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">阴虚质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmYinDeficiency" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmYinDeficiency}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">痰湿质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmPhlegmWetness" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmPhlegmWetness}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">湿热质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmHeatMedium" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmHeatMedium}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">血瘀质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmBloodQuality" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmBloodQuality}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">气郁质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmQiStagnation" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmQiStagnation}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
								<tr>
									<th style="text-align: right;">特秉质</th>
									<td>
										<ehr:dic-radio  name="PersonalPhyExamDTO.physiqueExamination.tcmSpecialQuality" dicmeta="FS10186" code="1,3,0" value="${PersonalPhyExamDTO.physiqueExamination.tcmSpecialQuality}" disabled="disabled"></ehr:dic-radio>
									</td>
								</tr>
							</table>
						</fieldset>
					</div>
					</c:if>
					<%-- </c:if>--%>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<legend title="《考核项目》指曾经出现或一直存在,并影像目前身体健康状况的疾病。可以多选。若有高血压、糖尿病等现患疾病或者新增的疾病需同时填写在个人基本信息表既往史一栏。">
							<label class="required">现存主要健康问题</label></legend>
						<table class="posttable">
							<tr>
									<th style="width: 16%;text-align: right;vertical-align: top;">脑血管疾病</th>
								<td>
									<label><input type="radio" onclick="util.clickHideTable(this,'ttb9')" name="PersonalPhyExamDTO.physiqueExamination.cvascularFlag" ${PersonalPhyExamDTO.physiqueExamination.cvascularFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.cvascularFlag eq null ?"checked":""} value="0"> 未发现</label>
									<label><input type="radio" id="cvascularFlag" onclick="util.clickShowTable(this,'ttb9','cvascularOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.cvascularFlag" ${PersonalPhyExamDTO.physiqueExamination.cvascularFlag eq"1" ?"checked":""} value="1"> 已发现</label>
									<span id="ttb9" class="tt_hidden">
			            <label><input reg='{"extension":["cvascularVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.cvascularHemorrhageStroke" ${PersonalPhyExamDTO.physiqueExamination.cvascularHemorrhageStroke eq '1' ? 'checked':''} value="1"> 缺血性卒中</label>
			            <label><input reg='{"extension":["cvascularVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.cvascularHemorrhage" ${PersonalPhyExamDTO.physiqueExamination.cvascularHemorrhage eq '1' ? 'checked':''} value="1"> 脑出血</label>
			            <label><input reg='{"extension":["cvascularVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.cvascularSah" ${PersonalPhyExamDTO.physiqueExamination.cvascularSah eq '1' ? 'checked':''} value="1"> 蛛网膜下腔出血</label>
			            <label><input reg='{"extension":["cvascularVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.covascularTransientIschemic" ${PersonalPhyExamDTO.physiqueExamination.covascularTransientIschemic eq '1' ? 'checked':''} value="1"> 短暂性脑缺血发作</label>
			            <label><input reg='{"extension":["cvascularVali","请至少选择一项"]}'  type="checkbox" id="covascularOther" onclick="util.clickShowText(this,'cvascularOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.covascularOther" ${PersonalPhyExamDTO.physiqueExamination.covascularOther eq '1' ? 'checked':''} value="1"> 其他</label>
			            <input type="text" id="cvascularOtherDesc" name="PersonalPhyExamDTO.physiqueExamination.cvascularOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.cvascularOtherDesc}" CLASS="hidediv" style="width: 150px;" reg='{"dependOn":"covascularOther","required":"true","maxlength":"33"}'>
			        </span>
								</td>
							</tr>
							<tr>
									<th style="text-align: right;vertical-align: top;">肾脏疾病</th>
								<td>
									<label><input type="radio" onclick="util.clickHideTable(this,'ttb10')" name="PersonalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag" ${PersonalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag eq "0"  or PersonalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag eq null ?"checked":""} value="0"> 未发现</label>
									<label><input type="radio" id="kidneyDiseaseFlag" onclick="util.clickShowTable(this,'ttb10','kidneyOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag" ${PersonalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag eq"1" ?"checked":""} value="1"> 已发现</label>
									<span id="ttb10" class="tt_hidden">
			            <label><input reg='{"extension":["kidneyDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.kidneyDiabeticNephropathy" ${PersonalPhyExamDTO.physiqueExamination.kidneyDiabeticNephropathy eq '1' ? 'checked':''} value="1"> 糖尿病肾病</label>
			            <label><input reg='{"extension":["kidneyDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.kidneyRenalFailure" ${PersonalPhyExamDTO.physiqueExamination.kidneyRenalFailure eq '1' ? 'checked':''} value="1"> 肾功能衰竭</label>
			            <label><input reg='{"extension":["kidneyDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.kidneyAcuteNephritis" ${PersonalPhyExamDTO.physiqueExamination.kidneyAcuteNephritis eq '1' ? 'checked':''} value="1"> 急性肾炎</label>
			            <label><input reg='{"extension":["kidneyDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.kidneyChronicNephritis" ${PersonalPhyExamDTO.physiqueExamination.kidneyChronicNephritis eq '1' ? 'checked':''} value="1"> 慢性肾炎</label>
			            <label><input reg='{"extension":["kidneyDiseaseVali","请至少选择一项"]}'  type="checkbox" id="kidneyOther" onclick="util.clickShowText(this,'kidneyOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.kidneyOther" ${PersonalPhyExamDTO.physiqueExamination.kidneyOther eq '1' ? 'checked':''} value="1"> 其他</label>
			            <input type="text" id="kidneyOtherDesc" name="PersonalPhyExamDTO.physiqueExamination.kidneyOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.kidneyOtherDesc}" CLASS="hidediv" style="width: 150px;"  reg='{"dependOn":"kidneyOther","required":"true","maxlength":"33"}'>
			        </span>
								</td>
							</tr>
							<tr>
									<th style="text-align: right;vertical-align: top;">心脏疾病</th>
								<td>
									<label><input type="radio" onclick="util.clickHideTable(this,'ttb11')" name="PersonalPhyExamDTO.physiqueExamination.heartDiseaseFlag" ${PersonalPhyExamDTO.physiqueExamination.heartDiseaseFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.heartDiseaseFlag eq null ?"checked":""} value="0"> 未发现</label>
									<label><input type="radio" id="heartDiseaseFlag" onclick="util.clickShowTable(this,'ttb11','heartOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.heartDiseaseFlag" ${PersonalPhyExamDTO.physiqueExamination.heartDiseaseFlag eq"1" ?"checked":""} value="1"> 已发现</label>
									<span id="ttb11" class="tt_hidden">
			            <label><input reg='{"extension":["heartDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.heartMiocardialInfarction" ${PersonalPhyExamDTO.physiqueExamination.heartMiocardialInfarction eq '1' ? 'checked':''} value="1"> 心肌梗死</label>
			            <label><input reg='{"extension":["heartDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.heartAnginaPectoris" ${PersonalPhyExamDTO.physiqueExamination.heartAnginaPectoris eq '1' ? 'checked':''} value="1"> 心绞痛</label>
			            <label><input reg='{"extension":["heartDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.heartCoronary" ${PersonalPhyExamDTO.physiqueExamination.heartCoronary eq '1' ? 'checked':''} value="1"> 冠状动脉血运重建</label>
			            <label><input reg='{"extension":["heartDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.heartCongestiveHeart" ${PersonalPhyExamDTO.physiqueExamination.heartCongestiveHeart eq '1' ? 'checked':''} value="1"> 充血性心力衰竭</label>
			            <label><input reg='{"extension":["heartDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.heartPrecordialPain" ${PersonalPhyExamDTO.physiqueExamination.heartPrecordialPain eq '1' ? 'checked':''} value="1"> 心前区疼痛</label>
			            <label><input reg='{"extension":["heartDiseaseVali","请至少选择一项"]}'  type="checkbox" id="heartOther" onclick="util.clickShowText(this,'heartOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.heartOther" ${PersonalPhyExamDTO.physiqueExamination.heartOther eq '1' ? 'checked':''} value="1"> 其他</label>
			            <input type="text" id="heartOtherDesc" name="PersonalPhyExamDTO.physiqueExamination.heartOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.heartOtherDesc}" CLASS="hidediv" style="width: 100px;"  reg='{"dependOn":"heartOther","required":"true","maxlength":"33"}'>
			         </span>
								</td>
							</tr>
							<tr>

									<th style="text-align: right;">血管疾病</th>
								<td>
									<label><input type="radio" onclick="util.clickHideTable(this,'ttb12')" name="PersonalPhyExamDTO.physiqueExamination.arteryDiseaseFlag" ${PersonalPhyExamDTO.physiqueExamination.arteryDiseaseFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.arteryDiseaseFlag eq null ?"checked":""} value="0"> 未发现</label>
									<label><input type="radio" id="arteryDiseaseFlag" onclick="util.clickShowTable(this,'ttb12','arteryOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.arteryDiseaseFlag" ${PersonalPhyExamDTO.physiqueExamination.arteryDiseaseFlag eq"1" ?"checked":""} value="1"> 已发现</label>
									<span id="ttb12" class="tt_hidden">
			            <label><input reg='{"extension":["arteryDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.arteryDissectingAneurysm" ${PersonalPhyExamDTO.physiqueExamination.arteryDissectingAneurysm eq '1' ? 'checked':''} value="1"> 夹层动脉瘤</label>
			            <label><input reg='{"extension":["arteryDiseaseVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.arteryPaod" ${PersonalPhyExamDTO.physiqueExamination.arteryPaod eq '1' ? 'checked':''} value="1"> 动脉闭塞性疾病</label>
			            <label><input reg='{"extension":["arteryDiseaseVali","请至少选择一项"]}'  type="checkbox" id="arteryOther" onclick="util.clickShowText(this,'arteryOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.arteryOther" ${PersonalPhyExamDTO.physiqueExamination.arteryOther eq '1' ? 'checked':''} value="1"> 其他</label>
			            <input type="text" id="arteryOtherDesc" name="PersonalPhyExamDTO.physiqueExamination.arteryOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.arteryOtherDesc}" CLASS="hidediv" style="width: 150px;"  reg='{"dependOn":"arteryOther","required":"true","maxlength":"33"}'>
			         </span>
								</td>
							</tr>
							<tr>

									<th style="text-align: right;vertical-align: top;">眼部疾病</th>
								<td>
									<label><input type="radio" onclick="util.clickHideTable(this,'ttb13')" name="PersonalPhyExamDTO.physiqueExamination.eyeDiseasesFlag" ${PersonalPhyExamDTO.physiqueExamination.eyeDiseasesFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.eyeDiseasesFlag eq null ?"checked":""} value="0"> 未发现</label>
									<label><input type="radio" id="eyeDiseasesFlag" onclick="util.clickShowTable(this,'ttb13','eyeOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.eyeDiseasesFlag" ${PersonalPhyExamDTO.physiqueExamination.eyeDiseasesFlag eq"1" ?"checked":""} value="1"> 已发现</label>
									<span id="ttb13" class="tt_hidden">
			            <label><input reg='{"extension":["eyeDiseasesVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.eyeRetinalOozing" ${PersonalPhyExamDTO.physiqueExamination.eyeRetinalOozing eq '1' ? 'checked':''} value="1"> 视网膜出血或者渗出</label>
			            <label><input reg='{"extension":["eyeDiseasesVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.eyeOpticPapilla" ${PersonalPhyExamDTO.physiqueExamination.eyeOpticPapilla eq '1' ? 'checked':''} value="1"> 视乳头水肿</label>
			            <label><input reg='{"extension":["eyeDiseasesVali","请至少选择一项"]}'  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.eyeCataract" ${PersonalPhyExamDTO.physiqueExamination.eyeCataract eq '1' ? 'checked':''} value="1"> 白内障</label>
			            <label><input reg='{"extension":["eyeDiseasesVali","请至少选择一项"]}'  type="checkbox" id="eyeOther" onclick="util.clickShowText(this,'eyeOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.eyeOther" ${PersonalPhyExamDTO.physiqueExamination.eyeOther eq '1' ? 'checked':''} value="1"> 其他</label>
			            <input type="text" id="eyeOtherDesc" name="PersonalPhyExamDTO.physiqueExamination.eyeOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.eyeOtherDesc}" class="hidediv" style="width: 200px;"  reg='{"dependOn":"eyeOther","required":"true","maxlength":"33"}'>
			        </span>
								</td>
							</tr>
							<tr>

									<th style="text-align: right;">神经系统疾病</th>
								<td>
									<label><input type="radio" id="nervousDiseasesNotFind" onclick="util.clickHideText(this,'nervousDiseasesDesc')" name="PersonalPhyExamDTO.physiqueExamination.nervousDiseasesFlag" ${PersonalPhyExamDTO.physiqueExamination.nervousDiseasesFlag eq "0" or PersonalPhyExamDTO.physiqueExamination.nervousDiseasesFlag eq null ? "checked" : ""} value="0"> 未发现</label>
									<label><input type="radio" id="nervousDiseasesFlag" onclick="util.clickShowText(this,'nervousDiseasesDesc')" name="PersonalPhyExamDTO.physiqueExamination.nervousDiseasesFlag" ${PersonalPhyExamDTO.physiqueExamination.nervousDiseasesFlag eq"1" ?"checked":""} value="1"> 有</label>
									<input type="text" id="nervousDiseasesDesc" name="PersonalPhyExamDTO.physiqueExamination.nervousDiseasesDesc" value="${PersonalPhyExamDTO.physiqueExamination.nervousDiseasesDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"nervousDiseasesFlag","required":"true","maxlength":"33"}'>
								</td>
							</tr>
							<tr>

									<th style="text-align: right;">其他系统疾病</th>
								<td>
									<label><input type="radio" onclick="util.clickHideText(this,'healthOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.healthOther" ${PersonalPhyExamDTO.physiqueExamination.healthOther eq "0" or PersonalPhyExamDTO.physiqueExamination.healthOther eq null ? "checked" : ""} value="0"> 未发现</label>
									<label><input type="radio" id="healthOther" onclick="util.clickShowText(this,'healthOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.healthOther" ${PersonalPhyExamDTO.physiqueExamination.healthOther eq"1" ?"checked":""} value="1"> 有</label>
									<input type="text" id="healthOtherDesc" name="PersonalPhyExamDTO.physiqueExamination.healthOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.healthOtherDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"healthOther","required":"true","maxlength":"33"}'>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<legend>住院治疗情况</legend>
						<table class="posttable">
							<tr>

									<th style="width: 12%;text-align: right;vertical-align: top;">住院史</th>
								<td>
									<label><input type="radio" name="PersonalPhyExamDTO.hospitalizedHistoryFlg" ${PersonalPhyExamDTO.hospitalizedHistoryFlg eq "0" or PersonalPhyExamDTO.hospitalizedHistoryFlg eq null? "checked":""} onclick="util.clickHideTable(this,'ttb20')" value="0"> 无</label>
									<label><input type="radio" id="hospitalizedHistoryFlg" name="PersonalPhyExamDTO.hospitalizedHistoryFlg" ${PersonalPhyExamDTO.hospitalizedHistoryFlg eq "1" ? "checked":""} onclick="util.clickShowTable(this,'ttb20')" value="1"> 有</label>
									<c:if test="${empty PersonalPhyExamDTO.physiqueExamination.id || empty PersonalPhyExamDTO.hospitalizedHistoryList}">
										<table id="ttb20" class="tt_hidden hospitalized_history">
											<tr>
												<th style="text-align:center;width: 33%;">入院时间</th><th style="text-align:center;width: 30%;">原因</th><th style="text-align:center;width: 20%;">医疗机构名称</th><th style="text-align:center;width: 17%;">病案号</th>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text" reg="{'dependOn':'hospitalizedHistoryFlg','required':true}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[0].inDate" id="hospitalizedHistoryList0inDate" 
                            									 style="padding-left: 0px;width: 46%;" />
													/  
													<input type="text" reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"compare":["hospitalizedHistoryList0inDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[0].outhosDate" id="outhos0Date" 
                            									 style="padding-left: 0px;width: 46%;" />
												
												</td>
												<td style="text-align:center;">
													<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[0].inhosReason" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[0].inputOrganName" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[0].medicalRecordNo" style="width: 75%;">
												</td>
											</tr>
											<tr>
												<td style="text-align:center;">
												<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[1].inDate" id="hospitalizedHistoryList1inDate" 
                            									 style="padding-left: 0px;width: 46%;" />
													/  
													<input type="text" reg='{"compare":["hospitalizedHistoryList1inDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[1].outhosDate" id="outhos1Date" 
                            									 style="padding-left: 0px;width: 46%;" />
												
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].inhosReason" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].inputOrganName" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].medicalRecordNo" style="width: 75%;">
												</td>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[2].inDate" id="hospitalizedHistoryList2inDate" 
                            									 style="padding-left: 0px;width: 46%;" />
													/  
													<input type="text" reg='{"compare":["hospitalizedHistoryList1inDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[2].outhosDate" id="outhos2Date" 
                            									 style="padding-left: 0px;width: 46%;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[2].inhosReason" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[2].inputOrganName" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[2].medicalRecordNo" style="width: 75%;">
												</td>
											</tr>
										</table>
									</c:if>
									<c:if test="${not empty PersonalPhyExamDTO.physiqueExamination.id}">
										<table id="ttb20" class="tt_hidden hospitalized_history">
											<tr>
												<th style="text-align:center;width: 33%;">入院时间</th><th style="text-align:center;width: 30%;">原因</th><th style="text-align:center;width: 20%;">医疗机构名称</th><th style="text-align:center;width: 17%;">病案号</th>
											</tr>
											<c:forEach items="${PersonalPhyExamDTO.hospitalizedHistoryList}" var="hospitalizedList" varStatus="status">
												<tr>
													<c:if test="${status.index eq 0}">
														<td style="text-align:center;">
															<input type="text" reg="{'dependOn':'hospitalizedHistoryFlg','required':true}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inDate" id="hospitalizedHistoryList${status.index}inDate" 
                            									 style="padding-left: 0px;width: 46%;" value="<fmt:formatDate value='${hospitalizedList.inDate}' pattern='yyyy/MM/dd'/>"/>
															/  <input type="text" reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"compare":["hospitalizedHistoryList${status.index}inDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].outhosDate" id="outhos${status.index}Date" 
                            									 style="padding-left: 0px;width: 46%;" value="<fmt:formatDate value='${hospitalizedList.outhosDate}' pattern='yyyy/MM/dd'/>"/>
														</td>
														<td style="text-align:center;">
															<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inhosReason" value="${hospitalizedList.inhosReason}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inputOrganName" value="${hospitalizedList.inputOrganName}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].medicalRecordNo" value="${hospitalizedList.medicalRecordNo}" style="width: 75%;">
														</td>
													</c:if>
													<c:if test="${status.index ne 0}">
														<td style="text-align:center;">
															<%-- <tag:dateInput  onlypast="true" style="width: 70px;" id="hospitalizedHistoryList${status.index}inDate"  date="${hospitalizedList.inDate}" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inDate"></tag:dateInput>
															/  <tag:dateInput onlypast="true" reg='{"compare":["hospitalizedHistoryList${status.index}inDate","ge","结束日期不能小于开始日期"]}' style="width: 70px;" date="${hospitalizedList.outhosDate}" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].outhosDate" ></tag:dateInput>
														 --%><input type="text" reg="{'dependOn':'hospitalizedHistoryFlg'}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inDate" id="hospitalizedHistoryList${status.index}inDate"
                            									 style="padding-left: 0px;width: 46%;" value="<fmt:formatDate value='${hospitalizedList.inDate}' pattern='yyyy/MM/dd'/>"/>
															/  <input type="text" reg='{"dependOn":"hospitalizedHistoryFlg","compare":["hospitalizedHistoryList${status.index}inDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].outhosDate" id="outhos${status.index}Date"
                            									 style="padding-left: 0px;width: 46%;" value="<fmt:formatDate value='${hospitalizedList.outhosDate}' pattern='yyyy/MM/dd'/>"/>
														
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inhosReason" value="${hospitalizedList.inhosReason}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inputOrganName" value="${hospitalizedList.inputOrganName}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].medicalRecordNo" value="${hospitalizedList.medicalRecordNo}" style="width: 75%;">
														</td>
													</c:if>
												</tr>
											</c:forEach>
										</table>
									</c:if>
								</td>
							</tr>
							<tr>

									<th style="width: 12%;text-align: right;vertical-align: top;">家庭病床史</th>
								<td>
									<label><input type="radio" name="PersonalPhyExamDTO.familyBedHistoryFlg" ${PersonalPhyExamDTO.familyBedHistoryFlg eq '0' or PersonalPhyExamDTO.familyBedHistoryFlg eq null ? 'checked':''} onclick="util.clickHideTable(this,'ttb21')" value="0"> 无</label>
									<label><input type="radio" id="familyBedHistoryFlg" name="PersonalPhyExamDTO.familyBedHistoryFlg" ${PersonalPhyExamDTO.familyBedHistoryFlg eq '1' ? 'checked':''} onclick="util.clickShowTable(this,'ttb21')" value="1"> 有</label>
									<c:if test="${empty PersonalPhyExamDTO.physiqueExamination.id || empty PersonalPhyExamDTO.familyBedHistoryList }">
										<table id="ttb21" class="tt_hidden bed_history">
											<tr>
												<th style="text-align:center;width: 33%;">建/撤床日期</th><th style="text-align:center;width: 30%;">原因</th><th style="text-align:center;width: 20%;">医疗机构名称</th><th style="text-align:center;width: 17%;">病案号</th>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text" reg="{'dependOn':'familyBedHistoryFlg','required':true}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[0].builtBedDate" id="familyBedHistoryList0builtBedDate"
														   style="padding-left: 0px;width: 46%;" />
													/
													<input type="text" reg='{"dependOn":"familyBedHistoryFlg","required":true,"compare":["familyBedHistoryList0builtBedDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[0].removeBedDate" id="familyBedHistoryList0removeBedDate"
														   style="padding-left: 0px;width: 46%;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"33","dependOn":"familyBedHistoryFlg","required":true}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[0].builtBedReason" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23","dependOn":"familyBedHistoryFlg","required":true}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[0].inputOrganName" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[0].medicalRecordNo" style="width: 75%;">
												</td>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text" reg="{'dependOn':'familyBedHistoryFlg'}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[1].builtBedDate" id="familyBedHistoryList1builtBedDate"
														   style="padding-left: 0px;width: 46%;" />
													/
													<input type="text" reg='{"dependOn":"familyBedHistoryFlg","compare":["familyBedHistoryList1builtBedDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[1].removeBedDate" id="familyBedHistoryList1removeBedDate"
														   style="padding-left: 0px;width: 46%;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[1].builtBedReason" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[1].inputOrganName" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[1].medicalRecordNo" style="width: 75%;">
												</td>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text" reg="{'dependOn':'familyBedHistoryFlg'}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[2].builtBedDate" id="familyBedHistoryList2builtBedDate"
														   style="padding-left: 0px;width: 46%;" />
													/
													<input type="text" reg='{"dependOn":"familyBedHistoryFlg","compare":["familyBedHistoryList2builtBedDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[2].removeBedDate" id="familyBedHistoryList2removeBedDate"
														   style="padding-left: 0px;width: 46%;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[2].builtBedReason" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[2].inputOrganName" style="width: 75%;">
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[2].medicalRecordNo" style="width: 75%;">
												</td>
											</tr>
										</table>
									</c:if>
									<c:if test="${not empty PersonalPhyExamDTO.physiqueExamination.id}">
										<table id="ttb21" class="tt_hidden bed_history">
											<tr>
												<th style="text-align:center;width: 33%;">建/撤床日期</th><th style="text-align:center;width: 30%;">原因</th><th style="text-align:center;width: 20%;">医疗机构名称</th><th style="text-align:center;width: 17%;">病案号</th>
											</tr>
											<c:forEach items="${PersonalPhyExamDTO.familyBedHistoryList}" var="familyBed" varStatus="status">
												<tr>
													<c:if test="${status.index eq 0}">
														<td style="text-align:center;">
															<input type="text" value="<fmt:formatDate value='${familyBed.builtBedDate}' pattern='yyyy-MM-dd'/>" reg="{'dependOn':'familyBedHistoryFlg','required':true}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedDate" id="familyBedHistoryList${status.index}builtBedDate"
																   style="padding-left: 0px;width: 46%;" />
															/
															<input type="text" value="<fmt:formatDate value='${familyBed.removeBedDate}' pattern='yyyy-MM-dd'/>" reg='{"dependOn":"familyBedHistoryFlg","required":true,"compare":["familyBedHistoryList${status.index}builtBedDate","ge","结束日期不能小于开始日期"]}'   class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].removeBedDate" id="familyBedHistoryList${status.index}removeBedDate"
																   style="padding-left: 0px;width: 46%;" />
														</td>
														<td style="text-align:center;">
															<input reg='{"dependOn":"familyBedHistoryFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedReason" value="${familyBed.builtBedReason}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"dependOn":"familyBedHistoryFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].inputOrganName" value="${familyBed.inputOrganName}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].medicalRecordNo" value="${familyBed.medicalRecordNo}" style="width: 75%;">
														</td>
													</c:if>
													<c:if test="${status.index ne 0}">
														<td style="text-align:center;">
															<tag:dateInput onlypast="true" style="width: 45%;" id="familyBedHistoryList${status.index}builtBedDate" date="${familyBed.builtBedDate}" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedDate"></tag:dateInput>
															/  <tag:dateInput onlypast="true" reg='{"compare":["familyBedHistoryList${status.index}builtBedDate","ge","结束日期不能小于开始日期"]}' style="width: 45%;" date="${familyBed.removeBedDate}" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].removeBedDate"></tag:dateInput>
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedReason" value="${familyBed.builtBedReason}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].inputOrganName" value="${familyBed.inputOrganName}" style="width: 75%;">
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].medicalRecordNo" value="${familyBed.medicalRecordNo}" style="width: 75%;">
														</td>
													</c:if>
												</tr>
											</c:forEach>
										</table>
									</c:if>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<table class="posttable">
							<tr>
								<th title="《考核项目》对长期服要的慢性病患者了解其最近1年内的主要用药情况,西药填写化学名及商品名,中药填写药品名称或中药汤剂、用法、用量按医生医嘱填写。服药依从性是指对此药的依从情况,“规律”为按医嘱服药,“间断”为未按医嘱服药,频次或数量不足,“不服药”即为医生开了处方,但患者未使用此药。" style="width:15%;text-align:right;vertical-align: top;">
									<label class="required">主要用药情况</label></th>
								<td>
									<label><input type="radio"  name="PersonalPhyExamDTO.drugHistoryFlag" ${PersonalPhyExamDTO.drugHistoryFlag eq '0' or PersonalPhyExamDTO.drugHistoryFlag eq null?'checked':'' } onclick="util.clickHideTable(this,'ttb22')" value="0"> 无</label>
									<label><input type="radio" id="drugHistoryFlag" name="PersonalPhyExamDTO.drugHistoryFlag" ${PersonalPhyExamDTO.drugHistoryFlag eq '1'?'checked':'' } onclick="util.clickShowTable(this,'ttb22')" value="1"> 有</label>
									<br>
									<table id="ttb22" class="tt_hidden">
										<colgroup>
											<col style="width: 30%;"/>
											<col style="width: 70%;"/>
										</colgroup>
										<tr>
											<th style="text-align: right;">第一种药物名称</th>
											<td style="text-align: left;"><input reg='{"dependOn":"drugHistoryFlag","required":true,"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[0].drugGenericName" value="${PersonalPhyExamDTO.drugHistoryList[0].drugGenericName}" style="width: 65%;"/></td>
										</tr>

										<tr>
											<th style="text-align: right;">用法与用量</th>
											<td style="text-align: left;">
												<ehr:dic-list reg="{'dependOn':'drugHistoryFlag','required':true}" id="dicList1" name="PersonalPhyExamDTO.drugHistoryList[0].drugUseRouteCode" dicmeta="CV0600102" value="${PersonalPhyExamDTO.drugHistoryList[0].drugUseRouteCode}" width="25%;"/>
												每日<input reg='{"dependOn":"drugHistoryFlag","required":true,"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[0].drugUseFrequency" value="${PersonalPhyExamDTO.drugHistoryList[0].drugUseFrequency}" style="width: 15%"/>次,
												每次<input reg='{"dependOn":"drugHistoryFlag","required":true,"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[0].drugUseState" value="${PersonalPhyExamDTO.drugHistoryList[0].drugUseState}" style="width: 15%"/>
												<input class="hide" style="display: none;">
												<ehr:dic-list dicmeta="DMD00067" reg='{"dependOn":"drugHistoryFlag","required":true}'  name="PersonalPhyExamDTO.drugHistoryList[0].drugUseDoseUnit" value="${PersonalPhyExamDTO.drugHistoryList[0].drugUseDoseUnit}" width="15%;"></ehr:dic-list>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">用药时间</th>
											<td style="text-align: left;">

												<input type="text" reg="{'dependOn':'drugHistoryFlag','required':true}" class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[0].startDate" id="drugHistoryList0startDate" value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[0].startDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />
												/
												<input type="text" reg='{"compare":["drugHistoryList0startDate","ge","结束日期不能小于开始日期"]}' class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[0].stopDate" id="drugHistoryList0stopDate"
													   value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[0].stopDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />


												<%-- <tag:dateInput reg="{'dependOn':'drugHistoryFlag','required':true}" onlypast="true"  style="width: 70px;" id="drugHistoryList0startDate" name="PersonalPhyExamDTO.drugHistoryList[0].startDate" date="${PersonalPhyExamDTO.drugHistoryList[0].startDate}"></tag:dateInput> /
												<tag:dateInput reg='{"compare":["drugHistoryList0startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[0].stopDate" date="${PersonalPhyExamDTO.drugHistoryList[0].stopDate}"></tag:dateInput> --%>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">服药依从性</th>
											<td><ehr:dic-radio reg="{'dependOn':'drugHistoryFlag','required':true}" name="PersonalPhyExamDTO.drugHistoryList[0].medicationCompliance" dicmeta="FS10141" value="${PersonalPhyExamDTO.drugHistoryList[0].medicationCompliance}"/></td>
										</tr>
										<tr>
											<th style="text-align: right;">第二种药物名称</th>
											<td style="text-align: left;"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[1].drugGenericName" value="${PersonalPhyExamDTO.drugHistoryList[1].drugGenericName}" style="width: 65%;" /></td>
										</tr>
										<tr>
											<th style="text-align: right;">用法与用量</th>
											<td style="text-align: left;">
												<ehr:dic-list id="dicList2" name="PersonalPhyExamDTO.drugHistoryList[1].drugUseRouteCode" dicmeta="CV0600102" value="${PersonalPhyExamDTO.drugHistoryList[1].drugUseRouteCode}" width="25%"/>
												每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[1].drugUseFrequency"  value="${PersonalPhyExamDTO.drugHistoryList[1].drugUseFrequency}" style="width: 15%"/>次,
												每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[1].drugUseState" value="${PersonalPhyExamDTO.drugHistoryList[1].drugUseState}" style="width: 15%"/>
												<input class="hide" style="display: none;">
												<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[1].drugUseDoseUnit" value="${PersonalPhyExamDTO.drugHistoryList[1].drugUseDoseUnit}" width="15%"></ehr:dic-list>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">用药时间</th>
											<td style="text-align: left;">
												<%-- <tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList1startDate" name="PersonalPhyExamDTO.drugHistoryList[1].startDate"  date="${PersonalPhyExamDTO.drugHistoryList[1].startDate}"></tag:dateInput> /
												<tag:dateInput reg='{"compare":["drugHistoryList1startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[1].stopDate"  date="${PersonalPhyExamDTO.drugHistoryList[1].stopDate}"></tag:dateInput> --%>
												<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[1].startDate" id="drugHistoryList1startDate" value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[1].startDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />
												/
												<input type="text" reg='{"compare":["drugHistoryList1startDate","ge","结束日期不能小于开始日期"]}' class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[1].stopDate" id="drugHistoryList1stopDate"
													   value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[1].stopDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">服药依从性</th>
											<td style="text-align: left;"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[1].medicationCompliance" dicmeta="FS10141" value="${PersonalPhyExamDTO.drugHistoryList[1].medicationCompliance}"/></td>
										</tr>
										<tr>
											<th style="text-align: right;">第三种药物名称</th>
											<td style="text-align: left;"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[2].drugGenericName" value="${PersonalPhyExamDTO.drugHistoryList[2].drugGenericName}" style="width: 65%;" /></td>
										</tr>
										<tr>
											<th style="text-align: right;">用法与用量</th>
											<td style="text-align: left;">
												<ehr:dic-list id="dicList2" name="PersonalPhyExamDTO.drugHistoryList[2].drugUseRouteCode" dicmeta="CV0600102" value="${PersonalPhyExamDTO.drugHistoryList[2].drugUseRouteCode}" width="25%"/>
												每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[2].drugUseFrequency" style="width: 15%;" value="${PersonalPhyExamDTO.drugHistoryList[2].drugUseFrequency}" />次,
												每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[2].drugUseState" style="width: 15%;" value="${PersonalPhyExamDTO.drugHistoryList[2].drugUseState}"/>
												<input class="hide" style="display: none;">
												<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[2].drugUseDoseUnit" value="${PersonalPhyExamDTO.drugHistoryList[2].drugUseDoseUnit}" width="15%"></ehr:dic-list>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">用药时间</th>
											<td style="text-align: left;">
												<%-- <tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList2startDate" name="PersonalPhyExamDTO.drugHistoryList[2].startDate"  date="${PersonalPhyExamDTO.drugHistoryList[2].startDate}"></tag:dateInput> /
												<tag:dateInput reg='{"compare":["drugHistoryList2startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[2].stopDate"  date="${PersonalPhyExamDTO.drugHistoryList[2].stopDate}"></tag:dateInput> --%>
												<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[2].startDate" id="drugHistoryList2startDate" value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[2].startDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />
												/
												<input type="text" reg='{"compare":["drugHistoryList2startDate","ge","结束日期不能小于开始日期"]}' class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[2].stopDate" id="drugHistoryList2stopDate"
													   value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[2].stopDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />

											</td>
										</tr>
										<tr>
											<th style="text-align: right;">服药依从性</th>
											<td style="text-align: left;"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[2].medicationCompliance" dicmeta="FS10141" value="${PersonalPhyExamDTO.drugHistoryList[2].medicationCompliance}"/></td>
										</tr>
										<tr>
											<th style="text-align: right;">第四种药物名称</th>
											<td style="text-align: left;"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[3].drugGenericName" value="${PersonalPhyExamDTO.drugHistoryList[3].drugGenericName}" style="width: 65%;" /></td>
										</tr>
										<tr>
											<th style="text-align: right;">用法与用量</th>
											<td style="text-align: left;">
												<ehr:dic-list id="dicList3" name="PersonalPhyExamDTO.drugHistoryList[3].drugUseRouteCode" dicmeta="CV0600102" value="${PersonalPhyExamDTO.drugHistoryList[3].drugUseRouteCode}" width="25%"/>
												每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[3].drugUseFrequency" style="width: 15%;" value="${PersonalPhyExamDTO.drugHistoryList[3].drugUseFrequency}" />次,
												每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[3].drugUseState" style="width: 15%;" value="${PersonalPhyExamDTO.drugHistoryList[3].drugUseState}"/>
												<input class="hide" style="display: none;">
												<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[3].drugUseDoseUnit" value="${PersonalPhyExamDTO.drugHistoryList[3].drugUseDoseUnit}" width="15%"></ehr:dic-list>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">用药时间</th>
											<td style="text-align: left;">
												<%-- <tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList3startDate" name="PersonalPhyExamDTO.drugHistoryList[3].startDate"  date="${PersonalPhyExamDTO.drugHistoryList[3].startDate}"></tag:dateInput> /
												<tag:dateInput reg='{"compare":["drugHistoryList3startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[3].stopDate"  date="${PersonalPhyExamDTO.drugHistoryList[3].stopDate}"></tag:dateInput> --%>
												<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[3].startDate" id="drugHistoryList3startDate" value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[3].startDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />
												/
												<input type="text" reg='{"compare":["drugHistoryList3startDate","ge","结束日期不能小于开始日期"]}' class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[3].stopDate"  id="drugHistoryList3stopDate"
													   value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[3].stopDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />

											</td>
										</tr>
										<tr>
											<th style="text-align: right;">服药依从性</th>
											<td style="text-align: left;"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[3].medicationCompliance" dicmeta="FS10141" value="${PersonalPhyExamDTO.drugHistoryList[3].medicationCompliance}"/></td>
										</tr>
										<tr>
											<th style="text-align: right;">第五种药物名称</th>
											<td style="text-align: left;"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[4].drugGenericName" value="${PersonalPhyExamDTO.drugHistoryList[4].drugGenericName}" style="width: 65%;" /></td>
										</tr>
										<tr>
											<th style="text-align: right;">用法与用量</th>
											<td style="text-align: left;">
												<ehr:dic-list id="dicList4" name="PersonalPhyExamDTO.drugHistoryList[4].drugUseRouteCode" dicmeta="CV0600102" value="${PersonalPhyExamDTO.drugHistoryList[4].drugUseRouteCode}" width="25%"/>
												每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[4].drugUseFrequency" style="width: 15%;" value="${PersonalPhyExamDTO.drugHistoryList[4].drugUseFrequency}" />次,
												每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[4].drugUseState" style="width: 15%;" value="${PersonalPhyExamDTO.drugHistoryList[4].drugUseState}"/>
												<input class="hide" style="display: none;">
												<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[4].drugUseDoseUnit" value="${PersonalPhyExamDTO.drugHistoryList[4].drugUseDoseUnit}" width="15%"></ehr:dic-list>
											</td>
										</tr>
										<tr>
											<th style="text-align: right;">用药时间</th>
											<td style="text-align: left;">
												<%-- <tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList4startDate" name="PersonalPhyExamDTO.drugHistoryList[4].startDate"  date="${PersonalPhyExamDTO.drugHistoryList[4].startDate}"></tag:dateInput> /
												<tag:dateInput reg='{"compare":["drugHistoryList4startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[4].stopDate"  date="${PersonalPhyExamDTO.drugHistoryList[4].stopDate}"></tag:dateInput> --%>
												<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[4].startDate" id="drugHistoryList4startDate" value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[4].startDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />
												/
												<input type="text" reg='{"compare":["drugHistoryList4startDate","ge","结束日期不能小于开始日期"]}' class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.drugHistoryList[4].stopDate"  id="drugHistoryList4stopDate"
													   value="<fmt:formatDate value='${PersonalPhyExamDTO.drugHistoryList[4].stopDate}' pattern='yyyy/MM/dd'/>"
													   style="padding-left: 0px;width: 35%;" />

											</td>
										</tr>
										<tr>
											<th style="text-align: right;">服药依从性</th>
											<td style="text-align: left;"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[4].medicationCompliance" dicmeta="FS10141" value="${PersonalPhyExamDTO.drugHistoryList[4].medicationCompliance}"/></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<table class="posttable">
							<tr>
									<th title="填写最近1年内接种的情况。" style="width: 21%;text-align: right;vertical-align: top;">非免疫规划预防接种史</th>
								<td>
									<label><input type="radio" onclick="util.clickHideTable(this,'ttb23')" ${PersonalPhyExamDTO.vaccinationInfoFlg eq '0' or PersonalPhyExamDTO.vaccinationInfoFlg eq null ? 'checked':''} name="PersonalPhyExamDTO.vaccinationInfoFlg" value="0"> 无</label>
									<label><input type="radio" id="vaccinationInfoFlg" onclick="util.clickShowTable(this,'ttb23')" ${PersonalPhyExamDTO.vaccinationInfoFlg eq '1' ? 'checked':''} name="PersonalPhyExamDTO.vaccinationInfoFlg" value="1"> 有</label>
									<c:if test="${empty PersonalPhyExamDTO.physiqueExamination.id || empty PersonalPhyExamDTO.vaccinationInfoList }">
										<table id="ttb23" class="tt_hidden vaccination_info">
											<tr>
												<th style="text-align:center;">名称</th><th style="text-align:center;">接种日期</th><th style="text-align:center;">接种机构</th>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[0].vaccineName" CLASS="width100">
												</td>
												<td style="text-align:center;">
													<input type="text" reg="{'dependOn':'vaccinationInfoFlg','required':true}"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.vaccinationInfoList[0].vaccinationDate" id="vaccinationInfoList0vaccinationDate" style="padding-left: 0px;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[0].vaccinationUnitName" CLASS="width100"/>
												</td>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text" reg='{"maxlength":"33"}'  name="PersonalPhyExamDTO.vaccinationInfoList[1].vaccineName" CLASS="width100">
												</td>
												<td style="text-align:center;">
													<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.vaccinationInfoList[1].vaccinationDate" id="vaccinationInfoList1vaccinationDate" style="padding-left: 0px;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[1].vaccinationUnitName" CLASS="width100">
												</td>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text" reg='{"maxlength":"33"}'  name="PersonalPhyExamDTO.vaccinationInfoList[2].vaccineName" CLASS="width100">
												</td>
												<td style="text-align:center;">
													<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.vaccinationInfoList[2].vaccinationDate" id="vaccinationInfoList2vaccinationDate" style="padding-left: 0px;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[2].vaccinationUnitName" CLASS="width100">
												</td>
											</tr>
											<tr>
												<td style="text-align:center;">
													<input type="text" reg='{"maxlength":"33"}' name="PersonalPhyExamDTO.vaccinationInfoList[3].vaccineName" CLASS="width100">
												</td>
												<td style="text-align:center;">
													<input type="text"  class="layui-input x-admin-content-sm-date"  name="PersonalPhyExamDTO.vaccinationInfoList[3].vaccinationDate" id="vaccinationInfoList3vaccinationDate" style="padding-left: 0px;" />
												</td>
												<td style="text-align:center;">
													<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[3].vaccinationUnitName" CLASS="width100">
												</td>
											</tr>
										</table>
									</c:if>
									<c:if test="${not empty PersonalPhyExamDTO.physiqueExamination.id }">
										<table id="ttb23" class="tt_hidden vaccination_info">
											<tr>
												<th style="text-align:center;">名称</th><th style="text-align:center;">接种日期</th><th style="text-align:center;">接种机构</th>
											</tr>
											<c:forEach items="${PersonalPhyExamDTO.vaccinationInfoList}" var="vaccinationInfo" varStatus="status">
												<tr>
													<c:if test="${status.index eq 0}">
														<td style="text-align:center;">
															<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccineName" value="${vaccinationInfo.vaccineName}" CLASS="width100">
														</td>
														<td style="text-align:center;">
															<input type="text" reg="{'dependOn':'vaccinationInfoFlg','required':true}" class="layui-input x-admin-content-sm-date" value="<fmt:formatDate value='${vaccinationInfo.vaccinationDate}' pattern='yyyy/MM/dd'/>" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationDate" id="vaccinationInfoList${status.index}vaccinationDate" style="padding-left: 0px;" />
														</td>
														<td style="text-align:center;">
															<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationUnitName" value="${vaccinationInfo.vaccinationUnitName}" CLASS="width100">
														</td>
													</c:if>
													<c:if test="${status.index ne 0}">
														<td style="text-align:center;">
															<input  reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccineName" value="${vaccinationInfo.vaccineName}" CLASS="width100">
														</td>
														<td style="text-align:center;">
															<input type="text" class="layui-input x-admin-content-sm-date" value="<fmt:formatDate value='${vaccinationInfo.vaccinationDate}' pattern='yyyy/MM/dd'/>" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationDate" id="vaccinationInfoList${status.index}vaccinationDate" style="padding-left: 0px;" />
														</td>
														<td style="text-align:center;">
															<input reg='{"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationUnitName" value="${vaccinationInfo.vaccinationUnitName}" CLASS="width100">
														</td>
													</c:if>
												</tr>
											</c:forEach>
										</table>
									</c:if>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<table class="posttable" >
							<tr>
								<th title="《考核项目》无异常是指无新发疾病原有疾病控制良好无加重或进展,否则为有异常。" style="width: 16%;text-align: right;vertical-align: top;"><label class="required">健康评价</label></th>
								<td>
									<label><input type="radio" id="healthEvaluateAnomalyFlgN" onclick="util.clickHideTable(this,'ttb30')" ${PersonalPhyExamDTO.healthEvaluateAnomalyFlg eq '0' or PersonalPhyExamDTO.healthEvaluateAnomalyFlg eq null ? 'checked' : ''} name="PersonalPhyExamDTO.healthEvaluateAnomalyFlg" value="0"> 体检无异常（结合临床表现综合评估）</label>
									<label><input type="radio" id="healthEvaluateAnomalyFlg" onclick="util.clickShowTable(this,'ttb30')" ${PersonalPhyExamDTO.healthEvaluateAnomalyFlg eq '1'?'checked':''} name="PersonalPhyExamDTO.healthEvaluateAnomalyFlg" value="1"> 有异常 <font color="red">异常情况勿填写诊断类描述（如：高血压，糖尿病）</font></label>
									<br>
									<span class="hidediv" id="ttb30">
										<ehr:dic-checkbox id ="healthEvaluateCheckList" name="PersonalPhyExamDTO.physiqueExamination.healthEvaluateCheck"  dicmeta="IDM00645" value="${PersonalPhyExamDTO.physiqueExamination.healthEvaluateCheck}"  onchange="addPhyExam.changeCheck()"/><br/>
									<c:if test="${empty PersonalPhyExamDTO.physiqueExamination.id || empty PersonalPhyExamDTO.healthEvaluateAnomalyList}">
									             <%-- 异常 <input type="text" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[0].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal1"> <br>
									              异常 <input type="text" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[1].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal2"> <br>
									              异常 <input type="text" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[2].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal3"> <br>
									              异常 <input type="text" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[3].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal4"> <br>
										--%>
										异常<textarea name="PersonalPhyExamDTO.healthEvaluateAnomalyList[0].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal1"></textarea><br/>
										异常<textarea name="PersonalPhyExamDTO.healthEvaluateAnomalyList[1].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal2"></textarea><br/>
										异常<textarea name="PersonalPhyExamDTO.healthEvaluateAnomalyList[2].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal3"></textarea><br/>
										异常<textarea name="PersonalPhyExamDTO.healthEvaluateAnomalyList[3].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="healthAbnormal4"></textarea><br/>
							        </c:if>
				        			<c:if test="${not empty PersonalPhyExamDTO.physiqueExamination.id }">
										<c:forEach items="${PersonalPhyExamDTO.healthEvaluateAnomalyList}" var="healEvaluateAnomaly" varStatus="status">
											异常 <%--<input  type="text" reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}'
													name="PersonalPhyExamDTO.healthEvaluateAnomalyList[${status.index}].healthEvaluateAnomalyDesc" 
													value="${healEvaluateAnomaly.healthEvaluateAnomalyDesc}" style="width: 80%;word-break:break-all;"
													id="healthAbnormal${status.index+1}"><br>--%>
											<textarea reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}'
													  name="PersonalPhyExamDTO.healthEvaluateAnomalyList[${status.index}].healthEvaluateAnomalyDesc"
													  style="width: 80%;height:60px;word-break:break-all;"
													  id="healthAbnormal${status.index+1}">${healEvaluateAnomaly.healthEvaluateAnomalyDesc}</textarea><br/>
										</c:forEach>
									</c:if>
                                            <span class="hiddediv" id ="tjyc">
                                                <%--异常 <input type="text" reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;" id="tjycDesc1">--%>
                                            </span>
                                        其他异常 <%--<input type="text" name="PersonalPhyExamDTO.physiqueExamination.healthEvaluateOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.healthEvaluateOtherDesc}" reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}' style="width: 80%;word-break:break-all;" id="tjqtycDesc">--%>
										<textarea reg='{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}'
												  name="PersonalPhyExamDTO.physiqueExamination.healthEvaluateOtherDesc"
												   style="width: 77.5%;height:60px;word-break:break-all;"
												  id="tjqtycDesc">${PersonalPhyExamDTO.physiqueExamination.healthEvaluateOtherDesc}</textarea>
					   		 		</span>
					   		 		<input type="hidden" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[0].sort" value="1"/>
							        	<input type="hidden" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[1].sort" value="2"/>
							        	<input type="hidden" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[2].sort" value="3"/>
							        	<input type="hidden" name="PersonalPhyExamDTO.healthEvaluateAnomalyList[3].sort" value="4"/>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<table class="posttable">
							<tr>
								<th title="《考核项目》纳入慢性病患者健康管理是指高血压、糖尿病、严重精神障碍患者等重点人群定期随访和健康体检。减体重的目标是指根据居民或患者的具体情况,指定下次体检之前需要减重的目标值。" style="width: 16%;text-align: right;vertical-align: top;"><label class="required">健康指导</label></th>
								<td id="ttbhealth">
									<%--<label>--%>
									<%--<input reg='{"extension":["healthGuidanceVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.guideRegularFollowup" ${PersonalPhyExamDTO.physiqueExamination.guideRegularFollowup eq"1" ?"checked":""} value="1" />--%>
									<%--<span>定期随访</span>--%>
									<%--</label>--%>
									<%--<br>--%>
									<label>
										<input   type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.guideIntoChronicDisease" ${PersonalPhyExamDTO.physiqueExamination.guideIntoChronicDisease eq"1" ?"checked":""} value="1" />
										<span>
							纳入慢性病患者健康管理
							<font style="color: red">注：若勾选此选项,请核实第二页基本信息既往史已经勾选高血压、糖尿病或严重精神障碍</font>
						</span>
									</label>
									<br>
									<label>
										<input   type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.guideSuggestionReview" ${PersonalPhyExamDTO.physiqueExamination.guideSuggestionReview eq"1" ?"checked":""} value="1" />
										<span>建议复查</span>
									</label>
									<br>
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.guideSuggestionReferral" ${PersonalPhyExamDTO.physiqueExamination.guideSuggestionReferral eq"1" ?"checked":""} value="1" />
										<span>建议转诊</span>
									</label>
									<br/>
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.preventionOsteoporosis" ${PersonalPhyExamDTO.physiqueExamination.preventionOsteoporosis eq"1" ?"checked":""} value="1" />
										<span>骨质疏松预防</span>
									</label>
									<br/>
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.preventionTumble" ${PersonalPhyExamDTO.physiqueExamination.preventionTumble eq"1" ?"checked":""} value="1" />
										<span>防跌倒措施</span>
									</label>
									<br/>
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.preventionInjury" ${PersonalPhyExamDTO.physiqueExamination.preventionInjury eq"1" ?"checked":""} value="1" />
										<span>意外伤害预防</span>
									</label>
									<%--<br>--%>
									<%--<label>--%>
									<%--<input reg='{"extension":["healthGuidanceVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.includedSixManagement" ${PersonalPhyExamDTO.physiqueExamination.includedSixManagement eq"1" ?"checked":""} value="1" />--%>
									<%--<span>纳入0-6岁儿童管理</span>--%>
									<%--</label>--%>
									<%--<br>--%>
									<%--<label>--%>
									<%--<input reg='{"extension":["healthGuidanceVali","请至少选择一项"]}' type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.maternalManagement" ${PersonalPhyExamDTO.physiqueExamination.maternalManagement eq"1" ?"checked":""} value="1" />--%>
									<%--<span>纳入孕产妇管理</span>--%>
									<%--</label>--%>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<table class="posttable">
							<tr>
								<th style="width: 16%;text-align: right;vertical-align: top;"><label class="required">危险因素控制</label></th>
								<td id="ttbRisk">
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking" ${PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking eq '1' ? 'checked' : ''}  value="1"/>
										<span>戒烟</span>
									</label>
									<br>
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.riskHealthDrink" ${PersonalPhyExamDTO.physiqueExamination.riskHealthDrink eq '1' ? 'checked' : ''}  value="1"/>
										<span>健康饮酒</span>
									</label>
									<br>
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.riskDiet" ${PersonalPhyExamDTO.physiqueExamination.riskDiet eq '1' ? 'checked' : ''}  value="1"/>
										<span>饮食</span>
									</label>
									<br>
									<label>
										<input  type="checkbox" name="PersonalPhyExamDTO.physiqueExamination.riskExercise" ${PersonalPhyExamDTO.physiqueExamination.riskExercise eq '1' ? 'checked' : ''}  value="1"/>
										<span>锻炼</span>
									</label>
									<br>
									<label>
										<input  type="checkbox" id="riskWeightReduction" onclick="util.clickShowText(this,'riskWeightTarget')" name="PersonalPhyExamDTO.physiqueExamination.riskWeightReduction" ${PersonalPhyExamDTO.physiqueExamination.riskWeightReduction eq '1' ? 'checked' : ''}  value="1"/>
										<span>减体重</span>
									</label>
									<span id="riskWeightTarget" class="hidediv">目标:&nbsp;
										<!--  <input type="text" name="PersonalPhyExamDTO.physiqueExamination.riskWeightTarget" value="${PersonalPhyExamDTO.physiqueExamination.riskWeightTarget}">  -->
		            	 <tag:numberInput point="point"  style="width: 40px;"  value="${PersonalPhyExamDTO.physiqueExamination.riskWeightTarget}" name="PersonalPhyExamDTO.physiqueExamination.riskWeightTarget"  cssClass="width30 " reg="{'dependOn':'riskWeightReduction','scale':2,'required':'true','min':0,'max':9999}"/>Kg
		            </span>
									<br>
									<label>
										<input  type="checkbox" id="guideVaccination" onclick="util.clickShowText(this,'guideVaccinationDesc')" name="PersonalPhyExamDTO.physiqueExamination.guideVaccination" ${PersonalPhyExamDTO.physiqueExamination.guideVaccination eq '1' ? 'checked' : ''}  value="1"/>
										<span>建议接种疫苗</span>
									</label>
									<span id="guideVaccinationDesc" class="hidediv"> <input type="text" name="PersonalPhyExamDTO.physiqueExamination.guideVaccinationDesc" value="${PersonalPhyExamDTO.physiqueExamination.guideVaccinationDesc}" style="width: 200px;"  reg='{"dependOn":"guideVaccination","required":"true","maxlength":"33"}'> </span>
									<br>
									<label>
										<input  type="checkbox" id="riskOther" onclick="util.clickShowText(this,'riskOtherDesc')" name="PersonalPhyExamDTO.physiqueExamination.riskOther" ${PersonalPhyExamDTO.physiqueExamination.riskOther eq '1' ? 'checked' : ''}  value="1"/>
										<span>其他</span></label>
									<span id="riskOtherDesc" class="hidediv"><input type="text" name="PersonalPhyExamDTO.physiqueExamination.riskOtherDesc" value="${PersonalPhyExamDTO.physiqueExamination.riskOtherDesc}" reg='{"dependOn":"riskOther","required":"true","maxlength":"33"}' style="width: 200px;" ></span>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>

			</div></div>
	</form>
</div>
