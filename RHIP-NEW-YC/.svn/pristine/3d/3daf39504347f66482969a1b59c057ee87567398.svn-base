<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
	$(function(){
		   $("#addEchOldPeople").on("click" ,function(){
			   phyExamUtil.addEch();
			   
			   layer.close($("#idensIndex").val());
		   });
		   
		   $("[id^='removeid']").on("click" ,function(){
			   layer.confirm("确认取消关联？", {icon:2, title:'确认提示'}, function(index) {
					$("[id^='editid']").hide();
				   	$("[id^='removeid']").hide();
				   	$("[id^='relatedid']").show();
				   	$("#addEchOldPeople").show();
				   	
				   	$("#identificationId").val("");
				   	$("#CMedicine").hide();
				   	layer.close(index);
				});
		   });
		   
		   $("[id^='editid']").on("click" ,function(){
			   var id = $(this).data("id");
			   var personid = $(this).data("personid");
			   phyExamUtil.addEch(id, personid);
			   
			   layer.close($("#idensIndex").val());
		   });
		   
		   $("[id^='relatedid']").on("click" ,function(){
			  var id = $(this).data('id');
			  layer.confirm("确认关联？", {icon:2, title:'确认提示'}, function(index) {
				   $.getJsonByUrl({
			            url : "/ech/manage/report/getEchIdentification",
			            wait : true,
			            param:{id:id},
			            callback : function(msg) {
			            	var data = msg.data;
			            	layer.alert(msg.message, {icon:0,title:'提示'});
			            	if (msg.result) {
			            		$("#identificationId").val(id);
			            		
			            		layer.close($("#idensIndex").val());
		     				   	
		                    	$('input[name="PersonalPhyExamDTO.physiqueExamination.tcmPeacefulQuality"][value="' + data.peacefulFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmQiQuality"][value="' + data.qiFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmYangQuality"][value="' + data.yangFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmYinDeficiency"][value="' + data.yinDeficiencyFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmPhlegmWetness"][value="' + data.phlegmWetnessFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmHeatMedium"][value="' + data.heatMediumFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmBloodQuality"][value="' + data.bloodFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmQiStagnation"][value="' + data.qiStagnationFlag + '"]').attr("checked", 'checked');
		                        $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmSpecialQuality"][value="' + data.specialFlag + '"]').attr("checked", 'checked');
		                        
		                        $('input[name="tcmPeacefulQuality"][value="' + data.peacefulFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmQiQuality"][value="' + data.qiFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmYangQuality"][value="' + data.yangFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmYinDeficiency"][value="' + data.yinDeficiencyFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmPhlegmWetness"][value="' + data.phlegmWetnessFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmHeatMedium"][value="' + data.heatMediumFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmBloodQuality"][value="' + data.bloodFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmQiStagnation"][value="' + data.qiStagnationFlag + '"]').attr("checked", 'checked');
		                        $('input[name="tcmSpecialQuality"][value="' + data.specialFlag + '"]').attr("checked", 'checked');
		                        
			                    $("#CMedicine").show();
		                    }
			            }
			        });
				   layer.close(index);
			   });
		   });
		   
	});     
</script> 
<input type="hidden" id="idensIndex" />
<div class="repeattable" style="width: auto;">
 	<div class="toolbar">
 		<a  href="javascript:void(0);" id="addEchOldPeople" class="${empty identificationId ?'':'hidediv'}"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
    </div>
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:70px; width:10%;"/>
			<col style="min-width:70px; width:26%;"/>
			<col style="min-width:70px; width:15%;"/>
			<col style="min-width:70px; width:7%;"/>
			<col style="min-width:70px; width:16%;"/>
		</colgroup>
		<thead> 
			<tr>
				<th>填表日期</th>
				<th>体质类型</th>
				<th>填表机构</th>
				<th>填表人</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach items="${identifications}" var="iden">
		  		<tr>
			  		<td style="text-align: center;"><fmt:formatDate value="${iden.createDate}" pattern="yyyy/MM/dd"/></td>
			  		<td style="text-align: center;"><ehr:tip>${iden.tcmConclusion}</ehr:tip></td>
			  		<td style="text-align: center;"><ehr:tip><ehr:org code="${iden.createOrg}" /></ehr:tip></td>
		  			<td style="text-align: center;"><ehr:tip><ehr:user userCode="${iden.createUser}"></ehr:user></ehr:tip></td>
		  			<td>
		  				<%-- <a href="#this" id="relatedid_${iden.id}" data-id="${iden.id}" data-personid="${iden.personId}" onclick="" class="${empty identificationId ?'':'hidediv'}" title="关联"><i class="layui-icon">&#xe64c;</i></a>
	  					<a href="#this" id="editid_${iden.id}" data-id="${iden.id}" data-personid="${iden.personId}" onclick="" class="${(not empty identificationId && identificationId == iden.id) ?'':'hidediv'}" title="修改"><i class="layui-icon">&#xe642;</i></a>
	  					<a href="#this" id="removeid_${iden.id}" data-id="${iden.id}" data-personid="${iden.personId}" onclick="" class="${(not empty identificationId && identificationId == iden.id) ?'':'hidediv'}" title="取消关联"><i class="layui-icon">&#xe64d;</i></a> --%>
		  			
		  				<a href="#this" id="relatedid_${iden.id}" data-id="${iden.id}" data-personid="${iden.personId}" onclick="" class="${empty identificationId ?'add-link layui-btn layui-btn-xs':'hidediv'}  " title="关联" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>关联</a>
	  					<a  href="#this" id="editid_${iden.id}" data-id="${iden.id}" data-personid="${iden.personId}" onclick="" class="${(not empty identificationId && identificationId == iden.id) ?'add-link layui-btn layui-btn-xs':'hidediv'}  " title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
	  					<a href="#this" id="removeid_${iden.id}" data-id="${iden.id}" data-personid="${iden.personId}" onclick="" class="${(not empty identificationId && identificationId == iden.id) ?'delete-link layui-btn layui-btn-danger layui-btn-xs':'hidediv'}  " title="取消关联"  href="#" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>取消关联</a>
	  					
		  			
		  			</td>
		  		</tr>
			</c:forEach>
		</tbody> 
	</table>
</div>
