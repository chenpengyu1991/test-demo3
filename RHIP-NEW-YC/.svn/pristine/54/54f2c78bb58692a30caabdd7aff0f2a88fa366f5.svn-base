<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/exam/search.js" type="text/javascript"></script>

		<div class="sm_bg"  style="width: 97%;margin-left: 3px;">
			<form id="exam-search-from" action="<c:url value="/exam/index"  />">
				<label>机构：</label><input  style="width: 20%;height: 23px;" name="org" /><label>&nbsp; &nbsp;日期：</label>
				<%-- <tags:dateInput style="width: 20%" id="startDate"  name="startDate"/> --%>
				<input type="text" class="layui-input x-admin-sm-date" placeholder="检查时间" name="startDate" id="startDate" style="padding-left: 0px;" />
				&nbsp; &nbsp;<input class="exam-search-btn btn" value="查询" type="button" />
				<div style="float: right" >
				<label><input class="exam-search-btn" type="radio" value="1" name="timeType" checked="checked"/>最近三个月</label>
				<label><input class="exam-search-btn" name="timeType" value="2" type="radio" />最近一年</label>
				<label><input class="exam-search-btn" name="timeType" value="3" type="radio" />全部</label>
				</div>
				<input type="hidden" name="personId" readonly="readonly" value="${personId}">
			</form>
		</div>
		<div id="exam-result-content" style="width: 99.5%;margin-left: 1px;">
		</div>
 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#startDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

      });

    </script>