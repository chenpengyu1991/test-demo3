<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>
<table>
	<tr>
		<td style="vertical-align: top; min-width: 100px; width: 200px;">
			<div class="postdiv" style="margin-top: 3px;">
				<fieldset class="layui-elem-field">
					<legend id="monitor-txt">监测列表</legend>
					<form id="plan-monitor-form">
						<div style="margin-bottom: 10px;" id="xzBtn">
							<ehr:authorize ifAnyGranted="${ZXXG},${ZXG}">
								<!-- <a href="javascript:void(0);" id="dm-followup-hbp-add-history-data"><b class="xinz">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>新增</a> -->
								<a href="javascript:void(0);" id="dm-followup-hbp-add-history-data" onclick="ncpFollowupEdit.addFollow()" title="新增"><i class="layui-icon">&#xe608;</i>新增</a>
							</ehr:authorize>
						</div>
						<div class="toolbar" style="text-align: left;">
							<%-- <tag:dateInput  date="${oneYearBeforeDate}" style="width:35px;" id="dm-followup-hbp-plan-year" name="planYearStart" pattern="yyyy"></tag:dateInput>~
							<tag:dateInput  date="${currentDate }" style="width:35px;" id="dm-followup-hbp-plan-year-end" name="planYearEnd" pattern="yyyy"></tag:dateInput> --%>
							
							<input type="text" class="layui-input x-admin-sm-date"  name="planYearStart" id="dm-followup-hbp-plan-year" style="padding-left: 0px;width:35px;" value="<fmt:formatDate value='${oneYearBeforeDate}' pattern='yyyy'/>" /> ~
                         <input type="text" class="layui-input x-admin-sm-date"  name="planYearEnd" id="dm-followup-hbp-plan-year-end" style="padding-left: 0px;width:35px;" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" />年
						</div>
					</form>
					<div class="repeattable" id="ncp-monitor-list" style="margin-top: 5px;">
						<%--显示随机计划列表 --%>
					</div>
				</fieldset>
			</div>
		</td>
		<td style="vertical-align: top;">
			<div id="monitorInputDiv">
				<%-- 显示随机记录表单 --%>
			</div>
		</td>
	</tr>
</table>


 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#dm-followup-hbp-plan-year' 
       	   ,type: 'year'
       	,done: function(value, date, endDate) {
		    $("#dm-followup-hbp-plan-year").val(value);
		    if (ncpFollowupEdit.checkPlanYear($("#plan-monitor-form"))) {
				$("#ncp-followup-main").find(".ncp-followup-from").empty();
				ncpFollowupEdit.loadMonitor1();
			}
		  }
        });

        laydate.render({
          elem: '#dm-followup-hbp-plan-year-end'
           ,type: 'year'
        	   ,done: function(value, date, endDate) {
       		    $("#dm-followup-hbp-plan-year-end").val(value);
       		 if (ncpFollowupEdit.checkPlanYear($("#plan-monitor-form"))) {
 				$("#ncp-followup-main").find(".ncp-followup-from").empty();
 				ncpFollowupEdit.loadMonitor1();
 				}
       		  }
        });
        
      });

    </script>