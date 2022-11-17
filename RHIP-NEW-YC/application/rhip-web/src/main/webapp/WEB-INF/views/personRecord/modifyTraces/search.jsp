<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/person/modifyTrace.js" type="text/javascript"></script>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/recordHome/sanitaryBureau/css/layout.css"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/recordHome/sanitaryBureau/css/page.css"> --%>

<div id="dialog-search" style="width: 99%;margin-left: 3.5px;">
	<div class="searchbox  searchSection x-admin-sm">
		<form method="post" id="form_search">
			<table>
                <colgroup>
                    <col style="width:7%;"/>
                    <col style="width:25%;"/>
                    <col style="width:7%;"/>
					<col style="width:25%;"/>
                    <col style="width:7%;"/>
                </colgroup>
                <tr>
                    <td style="text-align: right;">修改时间</td>
                    <td style="text-align: left;">
                        <input type="hidden" value="${modifyPersonId}" id="id_personId">
                        <%-- <tags:dateInput id="inputBeginDate" name="inputBeginDate" style="width: 80px" onlypast="true"></tags:dateInput> ~
                        <tags:dateInput id="inputEndDate" name="inputEndDate" style="width: 80px" onlypast="true"></tags:dateInput> --%>
                        <input type="text" class="layui-input x-admin-sm-date"  name="inputBeginDate" id="inputBeginDate" style="padding-left: 0px;width: 80px;" />~
          				<input type="text" class="layui-input x-admin-sm-date" name="inputEndDate" id="inputEndDate" style="padding-left: 0px;width: 80px;" />
                    </td>
                    <td style="text-align: right;">业务类型</td>
                    <td style="text-align: left;">
                        <input class="modifyTraces-search-btn" type="radio" name="regionType" value="-1" checked="checked" /> 全部
                        <input class="modifyTraces-search-btn" type="radio" name="regionType" value="A00000001" /> 个人档案封面
                        <input class="modifyTraces-search-btn" type="radio" name="regionType" value="A00000002" /> 个人基本信息表
                        <input class="modifyTraces-search-btn" type="radio" name="regionType" value="A00000003" /> 个人健康体检表
                    </td>
                    <td>
                        <!-- <input class="search_btn" type="button" name="search" id="search_btn" value="查询" style="float:right;"/> -->
                        <button class="layui-btn layui-btn-sm"  id="search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                 </tr>
            </table>
		</form>
	</div>
		<div id="modifyTraces-result-content">
		</div>
</div>

<script type="text/javascript">
 layui.use('laydate', function(){
     var laydate = layui.laydate;
     
     //执行一个laydate实例
     laydate.render({
       elem: '#inputBeginDate' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });

     //执行一个laydate实例
     laydate.render({
       elem: '#inputEndDate' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });
   });

 </script>