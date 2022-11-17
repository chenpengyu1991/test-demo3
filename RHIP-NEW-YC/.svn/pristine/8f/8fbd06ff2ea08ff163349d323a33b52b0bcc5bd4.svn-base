<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/list.js" type="text/javascript"></script>

<div class="section" id="list_view">
	<%-- 
	<div class="toolbar">
		<b class="xinz" style="display: none" id="save-to-manage-no-btn">纳入管理</b><a href="javascript:void(0)" id="save-to-manage-btn"><b class="xinz">纳入管理</b></a>
	</div>
	--%>
		<div class="searchbox searchSection x-admin-sm" style="width: 100%" >
			<form method="post" id="form_search">
				<%--重要! viewType用来标志是否显示审核操作列 --%>
				<input type="hidden" name="viewType" value="1"/>
				<table style="" id="searchTable">
				<colgroup>
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 150px;width:25%">
					<col style="min-width: 60px;width:8%">
					<col style="min-width: 140px;width:23%">
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext" >姓名</td>
							<td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input" /></td>
							<td class="coltext" >身份证号</td>
							<td class="colinput">	<tag:idcardInput name="idcard"  style="ime-mode:Disabled;" id="idcard" cssClass="x-layui-input"></tag:idcardInput>
								<input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
							</td>
							<td class="coltext">性别</td>
							<td class="colinput">
								<ehr:dic-list dicmeta="GBT226112003"  name="gender"/>
							</td>
							
						</tr>
						<tr>
						<td class="coltext" >上报时间</td>
							<td class="colinput">
								<%-- <tag:dateInput name="reportCreateStartDate" id="reportCreateStartDate" onlypast="true" reg="{'required':true}" style="width:35%;"/>
									~
								<tag:dateInput name="reportCreateEndDate" id="reportCreateEndDate" onlypast="true" reg="{'required':true}" style="width:35%;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" reg="{'required':true}" placeholder="开始日" name="reportCreateStartDate" id="reportCreateStartDate" style="width: 38.5%;padding-left: 0px;" />~
          				        <input type="text" class="layui-input x-admin-sm-date" reg="{'required':true}" placeholder="截止日" name="reportCreateEndDate" id="reportCreateEndDate" style="width: 38.5%;padding-left: 0px;" />
							</td>
						
							<td class="coltext">年龄段</td>
							<td class="colinput">
								<tag:numberInput maxlength="3" style="width:35%;"  name="startAge" id="startAge"  /> ~ 
								<tag:numberInput maxlength="3"  style="width:35%;"   name="endAge" id="endAge"  /> 岁
							</td>
							<td class="coltext"  >患病类型</td>
							<td class="colinput" >
								<div class="layui-form">
									<ehr:dic-list type="true"  id="disTypeSelect" name="disType"  width="158px" dicmeta="DMD00004" />
								</div>
							</td>
						</tr>
						<tr>
							
							<td class="coltext"  >状态</td>
							<td>
								<%--是否待纳入--%>
								<input type="hidden" name="isDNR" value="1">
								<%-- <ehr:dic-list id="dm-report-manage-status"  defaultval="Y"  dicmeta="DMD00005"  uninclude="1,2,3,4,5,6,8,11" name="reportStatus"   />--%>
								<ehr:dic-list id="dm-report-manage-status"  defaultval="Y"  dicmeta="DMD00005"  uninclude="1,2,3,4,5,6,8,11,10,12" name="reportStatus"   />
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td  align="left">
										<%-- <input type="button" id="reportCard_search_btn" value="查询" onclick="" class="search_btn"/> --%>
										<button class="layui-btn layui-btn-sm"  id="reportCard_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				  <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span  class="ico-bottom" id="slideTable">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			
			</form>
		</div>
	
	<div id="list_datagrid" 	class="repeattable">
	</div>
</div>
<div id="input_view" style="display: none">
</div>
<div id="manage_view" style="display: none"></div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#reportCreateStartDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#reportCreateEndDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

    });

    layui.config({
        base: layui.cache.dir+'lay/modules/',  //实际的multiSelect.JS文件位置,也可以用<script>引入
    });
    layui.use(['multiSelect'],function() {
        var $ = layui.jquery,form = layui.form,multiSelect = layui.multiSelect;
        $('#get-val').click(function() {
            var vals = [],
                texts = [];
            $('select[multiple] option:selected').each(function() {
                vals.push($(this).val());
                texts.push($(this).text());
            })
            console.dir(vals);
            console.dir(texts);
        })
        form.on('select(test)',function(data){
            console.dir(data);
        });
    });

</script>
