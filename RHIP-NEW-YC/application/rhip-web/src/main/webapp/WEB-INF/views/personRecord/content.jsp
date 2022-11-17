<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/printStyle.css" rel="stylesheet"type="text/css" media="print">
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/record.css" type="text/css"  rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ehr/person/content.js" type="text/javascript"></script>

<div class="toolbar" style="margin-top: 10px;">
<a href="javascript:void(0)"  onclick="personRecordPagination.returnSearch(${currentPage.currentPage})"><button class="layui-btn btn-gray layui-btn-sm" ><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>

<c:choose>
	<c:when test="${not empty errorStr}">
		<jsp:include page="../common/noauthorize.jsp"/>
	</c:when>
	<c:otherwise>
		<%-- <div id="personal_basicinfo_toolbar" class="Menubox">
			<ul>
				<li id="two1" ><span id="basic_cover"><b id="basic_cover_status" class="${recordStatus==1||recordStatus==3||recordStatus==5||recordStatus==7?'person_recoed_complete':'person_record_todo' } ">封面</b></span></li>
				<li id="two2" ><span id="basic_info"><b id="basic_info_status" class="${recordStatus==2||recordStatus==3||recordStatus==6||recordStatus==7?'person_recoed_complete':'person_record_todo' }">基本信息</b></span></li>
				<li id="two3" ><span id="basic_physical_examination"><b id="basic_physical_examination_status" class="${recordStatus==4||recordStatus==5||recordStatus==6||recordStatus==7?'person_recoed_complete':'person_record_todo' }">个人体检表</b></span></li>
				<li id="two4" ><span id="basic_reception"><b id="basic_reception_status" class="${ receptionFlag eq 'completed' ?'person_recoed_complete':'person_record_todo' }">接诊记录表</b></span></li>
				<li id="two5" ><span id="basic_consultation"><b id="basic_consultation_status" class="${ consultationFlag eq 'completed' ?'person_recoed_complete':'person_record_todo' }">会诊记录表</b></span></li>
				<li id="two6" ><span id="basic_referral"><b id="basic_referral_status" class="${ recordStatus==3 ?'person_recoed_complete':'person_record_todo' }">双向转诊单</b></span></li>
			</ul>
			<i>进度状态：
				<span class="ywc">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已完成</span>
				<span class="dws">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;待完善</span>
				&nbsp;&nbsp;
			</i>
		</div>
		<div id="personal_basicinfo_content"></div> --%>
		<input type="hidden" id="ehr_urlFromPhysicalExam" value="${urlFromPhysicalExam}"/>
		<input type="hidden" id="ehr_modify_personId" value="${personInfo.id}"/>
		<input type="hidden" id="save_cover_mark" />
		<input type="hidden" id="save_person_info_mark" />
		<input type="hidden" id="save_physical_examination_mark" />
		<input type="hidden" id="save_reception_mark" />
		<input type="hidden" id="save_consultation_mark" />
		<input type="hidden" id="save_referral_mark" />
		<input type="hidden" id="cdm_card_save_mark" />
		<div class="layui-tab layui-tab-card contentfixed32" lay-filter="ehrBasicModify"  style="width:98%;margin-left:8px;
    overflow: auto;">
  		<ul class="layui-tab-title">
			<c:choose>
				<c:when test="${not empty urlFromPhysicalExam}">
					<li class="layui-this" lay-id="basic_physical_examination_li" id="basic_physical_examination_li">
						<c:if test="${recordStatus==4||recordStatus==5||recordStatus==6||recordStatus==7}"><i class="layui-icon">&#xe605;</i></c:if>
						<c:if test="${recordStatus!=4&&recordStatus!=5&&recordStatus!=6&&recordStatus!=7}"><i class="layui-icon">&#xe642;</i></c:if>
						个人体检表
					</li>
				</c:when>
				<c:otherwise>
					<li class="layui-this" lay-id="basic_cover_li" id="basic_cover_li">
						<c:if test="${recordStatus==1||recordStatus==3||recordStatus==5||recordStatus==7}"><i class="layui-icon">&#xe605;</i></c:if>
						<c:if test="${recordStatus!=1&&recordStatus!=3&&recordStatus!=5&&recordStatus!=7}"><i class="layui-icon">&#xe642;</i></c:if>
						封面
					</li>
					<li lay-id="basic_info_li" id="basic_info_li">
						<c:if test="${recordStatus==2||recordStatus==3||recordStatus==6||recordStatus==7}"><i class="layui-icon">&#xe605;</i></c:if>
						<c:if test="${recordStatus!=2&&recordStatus!=3&&recordStatus!=6&&recordStatus!=7}"><i class="layui-icon">&#xe642;</i></c:if>
						基本信息
					</li>
					<li lay-id="basic_physical_examination_li" id="basic_physical_examination_li">
						<c:if test="${recordStatus==4||recordStatus==5||recordStatus==6||recordStatus==7}"><i class="layui-icon">&#xe605;</i></c:if>
						<c:if test="${recordStatus!=4&&recordStatus!=5&&recordStatus!=6&&recordStatus!=7}"><i class="layui-icon">&#xe642;</i></c:if>
						个人体检表
					</li>
					<li lay-id="basic_reception_status_li" id="basic_reception_status_li">
						<c:if test="${receptionFlag eq 'completed'}"><i class="layui-icon">&#xe605;</i></c:if>
						<c:if test="${receptionFlag ne 'completed'}"><i class="layui-icon">&#xe642;</i></c:if>
						接诊记录表
					</li>
					<li lay-id="basic_consultation_view_li" id="basic_consultation_view_li">
						<c:if test="${consultationFlag eq 'completed'}"><i class="layui-icon">&#xe605;</i></c:if>
						<c:if test="${consultationFlag ne 'completed'}"><i class="layui-icon">&#xe642;</i></c:if>
						会诊记录表
					</li>
					<li lay-id="referral_info_li" id="referral_info_li">
						<c:if test="${recordStatus eq 3}"><i class="layui-icon">&#xe605;</i></c:if>
						<c:if test="${recordStatus ne 3}"><i class="layui-icon">&#xe642;</i></c:if>
						双向转诊单
					</li>
				</c:otherwise>
			</c:choose>
 		 </ul>
  <div style="text-align:right;padding-right: 8px;">
  	<span>进度状态:</span>
  	<i class="layui-icon">&#xe605;</i>已完成
  	<i class="layui-icon">&#xe642;</i>待完善
  </div>
  <div class="layui-tab-content">
	  <c:choose>
		  <c:when test="${not empty urlFromPhysicalExam}">
			  <div class="layui-tab-item layui-show" id="basic_physical_examination" ></div>
		  </c:when>
		  <c:otherwise>
			  <div class="layui-tab-item layui-show" id="basic_cover" ></div>
			  <div class="layui-tab-item" id="basic_info" ></div>
			  <div class="layui-tab-item" id="basic_physical_examination" ></div>
			  <div class="layui-tab-item" id="basic_reception_status"></div>
			  <div class="layui-tab-item" id="basic_consultation_view" ></div>
			  <div class="layui-tab-item" id="referral_info"></div>
		  </c:otherwise>
	  </c:choose>
  </div>
		</div>
	</c:otherwise>
</c:choose>


<script>
	var refresh = true;
	layui.use('element', function() {
		var element = layui.element;
		var isCoverClick = true;
		var isInfoClick = true;
		var isExamClick = true;
		var mbbkReportCheck = true;

		$("#basic_cover_li").click(function() {
			debugger;
			isInfoClick = true;
			isExamClick = true;
			mbbkReportCheck = true;
			if (!isEmpty($("#ehr_modify_personId").val()) || $("#save_person_info_mark").val() == "1") {
				infoClicked();//验证—-基本信息
			}else{
				refresh = false;
			}
			examClicked();//验证—-健康体检表
		});

		$("#basic_info_li").click(function() {
			isCoverClick = true;
			isExamClick = true;

			coverClicked();//验证——封面
			examClicked();//验证—-健康体检表

			if (!isEmpty($("#ehr_modify_personId").val()) && isCoverClick && isExamClick) {
				refresh = true;
			}
		});


		$("#basic_physical_examination_li").click(function() {
			isCoverClick = true;
			isInfoClick = true;
			mbbkReportCheck = true;

			coverClicked();//验证——封面
			infoClicked();//验证—-基本信息

			if (!isEmpty($("#ehr_modify_personId").val()) && isCoverClick && mbbkReportCheck && isInfoClick) {
				refresh = true;
			}
		});


		$("#basic_reception_status_li").click(function() {
			isCoverClick = true;
			isInfoClick = true;
			isExamClick = true;
			mbbkReportCheck = true;

			coverClicked();//验证——封面
			infoClicked();//验证—-基本信息
			examClicked();//验证—-健康体检表

			if (!isEmpty($("#ehr_modify_personId").val()) && isCoverClick && mbbkReportCheck && isInfoClick && isExamClick) {
				refresh = true;
			}
		});


		$("#basic_consultation_view_li").click(function() {
			isCoverClick = true;
			isInfoClick = true;
			isExamClick = true;
			mbbkReportCheck = true;

			coverClicked();//验证——封面
			infoClicked();//验证—-基本信息
			examClicked();//验证—-健康体检表

			if (!isEmpty($("#ehr_modify_personId").val()) && isCoverClick && mbbkReportCheck && isInfoClick && isExamClick) {
				refresh = true;
			}
		});


		$("#referral_info_li").click(function(){
			isCoverClick = true;
			isInfoClick = true;
			isExamClick = true;
			mbbkReportCheck = true;

			coverClicked();//验证——封面
			infoClicked();//验证—-基本信息
			examClicked();//验证—-健康体检表

			if (!isEmpty($("#ehr_modify_personId").val()) && isCoverClick && mbbkReportCheck && isInfoClick && isExamClick) {
				refresh = true;
			}
		});

		//验证——封面
		function coverClicked(){
			if($("#basic_cover_li").hasClass("layui-this")) {
				if(!isEmpty($("#ehr_modify_personId").val()) || $("#save_cover_mark").val() == "1") {
					addPersonCover.isCoverClicked();
					isCoverClick = addPersonCover.saveCover();
					if (!isCoverClick) {
						refresh = false;
					}
				} else {
					refresh = false;
				}
			}
		}

		//验证—-基本信息
		function infoClicked(){
			if($("#basic_info_li").hasClass("layui-this")) {
				addPersonInfo.isInfoClicked();
				//检查慢病管理卡是否创建
				mbbkReportCheck = addPersonInfo.mbbkReportCheck();
				if(mbbkReportCheck) {
					isInfoClick = addPersonInfo.savePersonInfo();
					if (!isInfoClick) {
						refresh = false;
					}
				} else {
					refresh = false;
				}
			}
		}

		//验证—-健康体检表
		function examClicked(){
			if ($("#basic_physical_examination_li").hasClass("layui-this")) {
				addPhyExam.isExamClicked();
				isExamClick = addPhyExam.save();
				if (!isExamClick) {
					refresh = false;
				}
			}
		}

		// 事件监听
		element.on('tab(ehrBasicModify)', function(data) {
			if (data.index == 0) {
				if (!isInfoClick) {
					element.tabChange('ehrBasicModify','basic_info_li');
					return;
				}
				if (!mbbkReportCheck) {
					element.tabChange('ehrBasicModify','basic_info_li');
					addPersonInfo.showMbGl();
					return;
				}
				if (!isExamClick) {
					element.tabChange('ehrBasicModify','basic_physical_examination_li');
					return;
				}
				if (refresh) {
					$("#basic_cover").html("");
					$("#basic_info").html("");
					$("#basic_physical_examination").html("");
					$("#basic_reception_status").html("");
					$("#basic_consultation_view").html("");
					$("#referral_info").html("");
					ehrBrowserBasic.loadCover();
				}
			} else if(data.index == 1) {
				if (isEmpty($("#ehr_modify_personId").val()) && isEmpty($("#save_cover_mark").val())) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					layer.alert("人员尚未建档，请先保存封面信息！", {icon:0,title:'提示'});
					return;
				}

				if (!isCoverClick) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					return;
				}

				if (!isExamClick) {
					element.tabChange('ehrBasicModify','basic_physical_examination_li');
					return;
				}

				if (refresh) {
					$("#basic_cover").html("");
					$("#basic_info").html("");
					$("#basic_physical_examination").html("");
					$("#basic_reception_status").html("");
					$("#basic_consultation_view").html("");
					$("#referral_info").html("");
					ehrBrowserBasic.loadInfo();
				}
			}  else if(data.index == 2) {
				if (isEmpty($("#ehr_modify_personId").val()) && isEmpty($("#save_cover_mark").val())) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					layer.alert("人员尚未建档，请先保存封面信息！", {icon:0,title:'提示'});
					return;
				}

				if (!isCoverClick) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					return;
				}

				if (!isInfoClick) {
					element.tabChange('ehrBasicModify','basic_info_li');
					return;
				}

				if (!mbbkReportCheck) {
					element.tabChange('ehrBasicModify','basic_info_li');
					addPersonInfo.showMbGl();
					return;
				}

				if (refresh) {
					$("#basic_cover").html("");
					$("#basic_info").html("");
					$("#basic_physical_examination").html("");
					$("#basic_reception_status").html("");
					$("#basic_consultation_view").html("");
					$("#referral_info").html("");
					ehrBrowserBasic.loadBasicHtml("addPersonPhyExam","basic_physical_examination");
				}
			} else if(data.index == 3) {
				if (isEmpty($("#ehr_modify_personId").val()) && isEmpty($("#save_cover_mark").val())) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					layer.alert("人员尚未建档，请先保存封面信息！", {icon:0,title:'提示'});
					return;
				}

				if (!isCoverClick) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					return;
				}

				if (!isInfoClick) {
					element.tabChange('ehrBasicModify','basic_info_li');
					return;
				}

				if (!mbbkReportCheck) {
					element.tabChange('ehrBasicModify','basic_info_li');
					addPersonInfo.showMbGl();
					return;
				}
				if (!isExamClick) {
					element.tabChange('ehrBasicModify','basic_physical_examination_li');
					return;
				}

				if (refresh) {
					$("#basic_cover").html("");
					$("#basic_info").html("");
					$("#basic_physical_examination").html("");
					$("#basic_reception_status").html("");
					$("#basic_consultation_view").html("");
					$("#referral_info").html("");
					ehrBrowserBasic.loadReception();
				}
			} else if(data.index == 4) {
				if (isEmpty($("#ehr_modify_personId").val()) && isEmpty($("#save_cover_mark").val())) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					layer.alert("人员尚未建档，请先保存封面信息！", {icon:0,title:'提示'});
					return;
				}

				if (!isCoverClick) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					return;
				}

				if (!isInfoClick) {
					element.tabChange('ehrBasicModify','basic_info_li');
					return;
				}

				if (!mbbkReportCheck) {
					element.tabChange('ehrBasicModify','basic_info_li');
					addPersonInfo.showMbGl();
					return;
				}
				if (!isExamClick) {
					element.tabChange('ehrBasicModify','basic_physical_examination_li');
					return;
				}

				if (refresh) {
					$("#basic_cover").html("");
					$("#basic_info").html("");
					$("#basic_physical_examination").html("");
					$("#basic_reception_status").html("");
					$("#basic_consultation_view").html("");
					$("#referral_info").html("");
					ehrBrowserBasic.loadConsultation();
				}
			} else if(data.index == 5) {
				if (isEmpty($("#ehr_modify_personId").val()) && isEmpty($("#save_cover_mark").val())) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					layer.alert("人员尚未建档，请先保存封面信息！", {icon:0,title:'提示'});
					return;
				}

				if (!isCoverClick) {
					element.tabChange('ehrBasicModify','basic_cover_li');
					return;
				}

				if (!isInfoClick) {
					element.tabChange('ehrBasicModify','basic_info_li');
					return;
				}

				if (!mbbkReportCheck) {
					element.tabChange('ehrBasicModify','basic_info_li');
					addPersonInfo.showMbGl();
					return;
				}
				if (!isExamClick) {
					element.tabChange('ehrBasicModify','basic_physical_examination_li');
					return;
				}

				if (refresh) {
					$("#basic_cover").html("");
					$("#basic_info").html("");
					$("#basic_physical_examination").html("");
					$("#basic_reception_status").html("");
					$("#basic_consultation_view").html("");
					$("#referral_info").html("");
					ehrBrowserBasic.loadReferral();
				}
			}
		});
	});
</script>