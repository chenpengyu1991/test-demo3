<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">

<script src="${pageContext.request.contextPath}/js/views/question/search.js" type="text/javascript"></script>
<div class="section">

<div class="toolbar">
	<c:if test="${fromHome}">
		 <%-- <a  id="questionBack"><b class="fanhui">返回</b></a> --%>
		 <a href="javascript:void(0)" id = "questionBack"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
		 <!-- <i id="questionBack" class="layui-icon">&#xe65c;<span>返回</span></i> -->
	</c:if>
</div>
<div class="searchbox searchSection x-admin-sm">
	<form id="questionForm">
		<table id="questionSearch" class="searchSection">
	        <colgroup>
	             <col style="width: 10%"/>
	             <col style="width: 15%"/>
	             <col style="width: 10%"/>
	             <col style="width: 30%"/>
	             <col style="width: 10%"/>
	             <col style="width: 15%"/>
	             <col style="width: 10%"/>
	         </colgroup>
			<tbody>
				<tr>
					<td class="coltext">关键字</td>
					<td class="colinput">
                         <input type="text" name="keyWord" class="x-layui-input"/>
                    </td>
                    <td class="coltext">时间</td>
                    <td class="colinput">
                    	<input type="text" class="layui-input x-admin-sm-date"  name="submitDateFrom" id="submitDateFrom" style="padding-left: 0px;width: 36%;" />~
          				<input type="text" class="layui-input x-admin-sm-date" name="submitDateTo" id="submitDateTo" style="padding-left: 0px;width: 36%;" />
                    </td>
                    <td class="coltext">回答状态</td>
					<td class="colinput">
                         <select name="answerStuts" class="x-layui-input">
                         	<option value="">请选择</option>
                         	<option value="1">已回答</option>
                         	<option value="0">未回答</option>
                         </select>
                    </td>
                    <td class="colinput">
                    <button class="layui-btn layui-btn-sm"   id="btnQuestionSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
				</tr>
				<tr>
					<td class="coltext">模块选项</td>
					<td class="colinput">
					<ehr:dic-list  name="keyWordType" dicmeta="HE00032" code="1,2,3,4,5,6,7,8,9,10,11,12" cssClass="x-layui-input"></ehr:dic-list>
					</td>
				</tr>
			</tbody>
		</table>
         <table>
              <tr>
                  <td colspan="4" class="colbottom">
						<span onclick="toggle(this,'questionSearch')" class="ico-bottom">&nbsp;</span>
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
       elem: '#submitDateFrom' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });

     //执行一个laydate实例
     laydate.render({
       elem: '#submitDateTo' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });
   });

 </script>
<div id="listDiv"></div>
</div>