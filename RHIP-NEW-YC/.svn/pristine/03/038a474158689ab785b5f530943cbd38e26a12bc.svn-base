<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ehr/family/search.js" type="text/javascript"></script>
<div class="section">
    <div class="toolbar">
        <!-- <a id="familyAdd"><b class="xinz">新增</b></a> -->
        <a href="javascript:void(0)" id="familyAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <form id="searchSQFamilyRecord">
      	  	<input type="hidden" id="selectFlagInput" name="selectFlagName" value="0"/>
            <table id="reportSearch">
            	<colgroup>
            		<col width="10%;"/>
            		<col width="23%;"/>
            		<col width="10%;"/>
            		<col width="23%;"/>
                    <col width="10%;"/>
                    <col width="23%;"/>
                </colgroup>
                <tr>
                    <td class="coltext">成员姓名</td>
                    <td class="colinput"><input type="text" name="memberLink" style="width: 80%" class="x-layui-input" /></td>
                    <td class="coltext">家庭住址</td>
                    <td class="colinput"><input type="text" name="address" style="width: 80%" class="x-layui-input" /></td>
                    <td class="coltext">档案状态</td>
                    <td class="colinput">
                        <select name="status" style="width: 80%;" id="sqStatus" class="x-layui-input" >
                            <option value="-1">请选择</option>
                            <option value="0">已建档 </option>
                            <%--<option value="1">审核中</option>--%>
                            <option value="2">已结案</option>
                            <%--<option value="3">已退回</option>--%>
                        </select>
                    </td>
                </tr>
                <tr>
                      <td class="coltext">管理机构</td>
                      <td class="colinput">
                          <ehr:dic-org-list name="stationOrgCode" defaultval="Y" width="80%" cssClass="x-layui-input"/>
                      </td>
                    <td></td> <td></td> <td></td>
                    <td class="coltext">
                        <%-- <input type="button" name="button" id="familySearchSQBtn" value="查询" class="search_btn" style="float:left;"/> --%>
                        <button class="layui-btn layui-btn-sm" id="familySearchSQBtn"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="familySearch.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
        </form>
    </div>
</div>
<!-- <div id="familyResultDiv"></div> -->
<%-- <div>
    <ul id=tags>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">列表显示</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">卡片显示</a>
	    </li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent0 class="selectTag">
	   		<div id="familyRecordListDiv"></div>
	   	</div>
	 	<div id="tagContent1" style="display:none" >
	 		<div id="familyRecordCardDiv"></div>
	 	</div>
	</div>
	<input type="hidden" id="familyId"/>
</div> --%>
<div class="layui-tab layui-tab-card" lay-filter="familyEhr" style="width: 98%;margin-left: 8px;">
  <ul class="layui-tab-title">
    <li class="layui-this">列表显示</li>
    <li>卡片显示</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show" id="familyRecordListDiv" ></div>
    <div class="layui-tab-item" id="familyRecordCardDiv" ></div>
  </div>
  <input type="hidden" id="familyId"/>
</div>

<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(familyEhr)', function(data){
      if (data.index == 0) {
    	  familySearch.viewList();
      } else if(data.index == 1) {
    	  familySearch.viewCard();
      }  
  });
});
</script>