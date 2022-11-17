<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<div class="thirdMenu" id="dm-followup-tumor-tab">
		<span class="${true==hadTumorFollowuped?'active':'active' }" ><a class="tabbtn"  data-target="con_tumor_1" data-tumorflag="1">基本信息</a></span>
		 <a >|</a>
	 	 <span class="${true==hadTumorFollowuped?'':'' }" ><a  class="tabbtn"   data-target="con_tumor_2" data-tumorflag="2" >访视情况</a></span>
	   <a>|</a>
	    <!--<span><a   class="tabbtn"   data-target="con_tumor_3" data-tumorflag="3">末次随访</a></span>-->
</div>
<div class="contentbox" id="dm-followup-tumor-tabcontent" style="width: 99.3%; text-align: left">
	<div id="con_tumor_1">
		<div id="tumorFirstFollowupDiv"></div>
	</div>
	<div id="con_tumor_2" style="display: none">
		<table>
			<tr>
				<td style="width: 200px; vertical-align: top;">
				<div class="postdiv">
						<fieldset class="layui-elem-field">
							<legend>随访列表</legend>
							<form id="dm-followup-plan-tumor-form">
								<div style="margin-bottom: 10px;">
									<%--<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
										<a href="javascript:void(0);" id="dm-followup-tumor-add-history-data"><b class="xinz" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>计划外新增</a>
									</ehr:authorize>--%>
								</div>
							<div class="toolbar" style="text-align: left;">
                               <%--  <tag:dateInput  date="${oneYearBeforeDate}" style="width:35px;" id="dm-followup-tumor-plan-year" name="planYearStart" pattern="yyyy"></tag:dateInput>~
                                <tag:dateInput  date="${currentDate }" style="width:35px;" id="dm-followup-tumor-plan-year-end" name="planYearEnd" pattern="yyyy"></tag:dateInput>年 --%>
                                
                                <input type="text" class="layui-input x-admin-content-sm-date" style="width:35px;padding-left: 0px;" placeholder="开始年份" name="planYearStart" id="dm-followup-tumor-plan-year" value="<fmt:formatDate value='${oneYearBeforeDate}' pattern='yyyy'/>"> ~
                                <input type="text" class="layui-input x-admin-content-sm-date" style="width:35px;padding-left: 0px;" placeholder="结束年份" name="planYearEnd" id="dm-followup-tumor-plan-year-end" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>">年
								<%--<ehr:authorize ifAnyGranted="0407">
										<a href="javascript:void(0);" id="dm-followup-tumor-add-history-data"><b class="xinz" >计划外新增</b></a>
									</ehr:authorize>--%>
							</div>		
							</form>
							<div class="repeattable" style="margin-top: 5px;">
								<div id="dm-followup-plan-tumor-list"></div>
							</div>
						</fieldset>
					</div>
				</td>
				<td>
					<div id="tumorFollowupInputDiv"></div>
				</td>
			</tr>
		</table>
	</div>
	<!-- 过敏史 -->
	<div id="con_tumor_3" style="display: none">
		<div id="tumorLastFollowupDiv">
			
		</div>
	</div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#dm-followup-tumor-plan-year' 
       	   ,type: 'year'
       	,done: function(value, date, endDate) {
		    $("#dm-followup-tumor-plan-year").val(value);
		    if (dmFollowupEdit.chceckPlanYear($("#dm-followup-plan-tumor-form"))) {
		    	dmFollowupEdit.emptyForm();
		    	dmFollowupEdit.loadTumor();
			}
		  }
        });

        laydate.render({
          elem: '#dm-followup-tumor-plan-year-end'
           ,type: 'year'
        	   ,done: function(value, date, endDate) {
       		    $("#dm-followup-tumor-plan-year-end").val(value);
       		    if (dmFollowupEdit.chceckPlanYear($("#dm-followup-plan-tumor-form"))) {
       		    	dmFollowupEdit.emptyForm();
       		    	dmFollowupEdit.loadTumor();
       			}
       		  }
        });
        
      });

    </script>