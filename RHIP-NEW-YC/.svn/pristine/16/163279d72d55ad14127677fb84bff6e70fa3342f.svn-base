<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/readRecord.js" type="text/javascript"></script>
<div id="dialog-search">
	<div class="searchbox searchSection x-admin-sm">
		<form id="readRecordForm">
			<input type="hidden" id="hiddenPersonId" name="personId" value="${recordPersonId}">
			<table>
				<colgroup>
					<col style="width: 5%;">
					<col style="width: 30%;">
					<col style="width: 30%;">
				</colgroup>
				<tr>
					<td class="coltext">时间范围</td>
					<td class="colinput">
						<input type="text" class="layui-input x-admin-sm-date" name="beginDate" id="beginDate" style="padding-left: 0px;width: 38%;" /> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="endDate" id="endDate" style="padding-left: 0px;width: 38%;" />
					</td>
					<td style="text-align: right;padding-right: 35px;">
					<button class="layui-btn layui-btn-sm" title="查询"  id="readRecordBtn"><i class="layui-icon">&#xe615;</i>查询</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#beginDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#endDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      });

    </script>
	<div id="readRecord-result-content"></div>
</div>