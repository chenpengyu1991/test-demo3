<%@page pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/edit.js" type="text/javascript"></script>
<input id="id" type="hidden" value="${id }">
<input id="operationType" type="hidden" value="${operationType }">

<div id="selectionDiv" class="sectionnoborder">
	<div class="layui-tab layui-tab-brief" lay-filter="ohRadiolopyDepDocTab" style="width: 98%;margin-left: 8px;">
		<ul class="layui-tab-title">
			<li class="layui-this" id="yyjbqk" href="javascript:void(0)">医院基本情况</li>
			<li id="yyfssbqk" href="javascript:void(0)">医院放射设备情况</li>
			<li id="fsfhqk" href="javascript:void(0)">放射防护情况</li>
			<li id="grfhyp" href="javascript:void(0)">个人防护用品</li>
			<li id="grjlda" href="javascript:void(0)">放射工作人员信息</li>
			<li id="pxqk" href="javascript:void(0)">培训情况</li>
		</ul>
		<div id="tagContent" class="layui-tab-content"></div>
	</div>
</div>
<div id="grjlhjkjhda"></div>

