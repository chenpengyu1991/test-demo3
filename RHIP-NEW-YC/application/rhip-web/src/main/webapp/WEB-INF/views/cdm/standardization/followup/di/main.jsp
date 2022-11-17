<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<table>
	<tr>
		<td style="vertical-align: top; min-width: 100px; width: 200px;">
			<div class="postdiv">
				<fieldset class="layui-elem-field">
					<legend>随访列表</legend>
					<form id="dm-followup-plan-di-form">
						<div style="margin-bottom: 10px;">
							<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
							<c:if test="${unplannedFlag=='1' }">
								<a title="计划外新增" class="add-link layui-btn layui-btn-xs" href="javascript:void(0)" id="dm-followup-di-add-history-data" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe608;</i>计划外新增</a>
								</c:if>
								<!-- <a href="javascript:void(0);" id="dm-followup-di-add-history-data"><b class="xinz" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>计划外新增</a> -->
							</ehr:authorize>
						</div>
					<div class="toolbar" style="text-align: left;">
                        <%-- <tag:dateInput  date="${oneYearBeforeDate}" style="width:35px;" id="dm-followup-di-plan-year" name="planYearStart" pattern="yyyy"></tag:dateInput>~
                        <tag:dateInput  date="${currentDate }" style="width:35px;" id="dm-followup-hbp-di-year-end" name="planYearEnd" pattern="yyyy"></tag:dateInput>年 --%>
                        <input type="text" class="layui-input x-admin-content-sm-date" style="width:35px;padding-left: 0px;" placeholder="开始年份" name="planYearStart" id="dm-followup-di-plan-year" value="<fmt:formatDate value='${oneYearBeforeDate}' pattern='yyyy'/>"> ~
                            <input type="text" class="layui-input x-admin-content-sm-date" style="width:35px;padding-left: 0px;" placeholder="结束年份" name="planYearEnd" id="dm-followup-hbp-di-year-end" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>">年
					</div>
					</form>
					<div class="repeattable" style="margin-top: 5px;">
						<div id="dm-followup-plan-di-list"></div>
					</div>
				</fieldset>
			</div>
		</td>
		<td>
			<div id="diFollowupInputDiv"></div>
		</td>
	</tr>
</table>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#dm-followup-di-plan-year' 
       	   ,type: 'year'
       	,done: function(value, date, endDate) {
		    $("#dm-followup-di-plan-year").val(value);
		    if (dmFollowupEdit.chceckPlanYear($("#dm-followup-plan-di-form"))) {
		    	dmFollowupEdit.emptyForm();
		    	dmFollowupEdit.loadDi();
			}
		  }
        });

        laydate.render({
          elem: '#dm-followup-hbp-di-year-end'
           ,type: 'year'
        	   ,done: function(value, date, endDate) {
       		    $("#dm-followup-hbp-di-year-end").val(value);
       		    if (dmFollowupEdit.chceckPlanYear($("#dm-followup-plan-di-form"))) {
       		    	dmFollowupEdit.emptyForm();
       		    	dmFollowupEdit.loadDi();
       			}
       		  }
        });
        
      });

    </script>