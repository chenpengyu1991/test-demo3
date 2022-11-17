<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ehr/person/personCancel.js" type="text/javascript"></script>
<%-- <div style="margin-top: 13px;">
	<ul id=tags>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">档案结案</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">档案迁移</a>
	    </li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent0 class="selectTag">
		   	<c:if test="${search_Role ne 'wsj_Role'}">
			 	<div class="toolbar">
			        <a href="javascript:void(0)" id="per_export_btn"><b class="export">导出</b></a>
			    </div>
		    </c:if>
	   		<div class="searchbox">
				<form method="post" id="form_search">
					<table id="cancelSearchTableId">
						<colgroup>
		                    <col style="min-width:70px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
		                    <col style="min-width:80px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
		                    <col style="min-width:60px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
						</colgroup>	
						<tbody>
							<tr>
								<td class="coltext">姓名</td>
								<td class="colinput"><input type="text" name="personName" id="personName" style="width: 80%"/></td>
		                        <td class="coltext">结案时间</td>
								<td class="colinput">
									<tag:dateInput name="cancelBeginDate" id="cancelBeginDate" onlypast="true" style="width: 36.8%;"/> ~
									<tag:dateInput name="cancelEndDate" id="cancelEndDate" onlypast="true" style="width: 36.8%;"/>
								</td>
								<td class="coltext">结案原因</td>
								<td class="colinput">
									<ehr:dic-radio name="canceledReason" dicmeta="FS10311"/>
								</td>
		                    </tr>
							<tr>
								<td class="coltext">结案机构</td>
								<td  class="colinput">
									<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchstation"  townName="searchTown" width="32.5%;" isShowOneself="true"/>
								</td>
                                <td class="coltext">死亡时间</td>
                                <td class="colinput">
                                    <tag:dateInput name="deathBeginDate" id="deathBeginDate" onlypast="true" style="width: 36.8%;"/> ~
                                    <tag:dateInput name="deathEndDate" id="deathEndDate" onlypast="true" style="width: 36.8%;"/>
                                </td>
								<td class="coltext"></td>
								<td class="colinput">
									<input class="search_btn" type="button" name="search" id="per_search_btn" value="查询" style="float: left;"/>
								</td>
							</tr>
						</tbody>
					</table>
					<table>
		                <tr>
		                    <td colspan="4" class="colbottom">
		                          <span onclick="toggle(this,'cancelSearchTableId')" class="ico-bottom">&nbsp;</span>
		                    </td>
		                </tr>
					</table>
				</form>
			</div>
			<div id="personCancelListDiv"></div>
	   	</div>
	 	<div id="tagContent1" style="display:none" >
	 		<c:if test="${search_Role ne 'wsj_Role'}">
			 	<div class="toolbar">
			        <a href="javascript:void(0)" id="move_export_btn"><b class="export">导出</b></a>
			    </div>
		    </c:if>
	 		<div class="searchbox">
				<form method="post" id="form_moveSearch">
					<table id="moveSearchTableId">
						<colgroup>
		                    <col style="min-width:70px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
		                    <col style="min-width:80px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
		                    <col style="min-width:60px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
						</colgroup>	
						<tbody>
							<tr>
								<td class="coltext">姓名</td>
								<td class="colinput"><input type="text" name="personMoveName" id="personMoveName" style="width: 80%"/></td>
		                        <td class="coltext">迁移时间</td>
								<td class="colinput">
									<tag:dateInput name="moveBeginDate" id="moveBeginDate" onlypast="true" style="width: 36.8%;"/> ~
									<tag:dateInput name="moveEndDate" id="moveEndDate" onlypast="true" style="width: 36.8%;"/>
								</td>
								<td class="coltext"></td>
								<td class="coltext"></td>
		                    </tr>
							<tr>
								<td class="coltext">迁入机构</td>
								<td colspan="3" class="colinput">
									<ehr:dic-town-centre-station centreName="moveInCenter" stationName="moveInStation"  townName="moveInTown" width="32.5%;" isShowOneself="true" isAuthorize="false"/>
								</td>
								<td class="coltext"></td>
								<td class="colinput"></td>
							</tr>
							<tr>
								<td class="coltext">迁出机构</td>
								<td colspan="3" class="colinput">
									<ehr:dic-town-centre-station centreName="moveOutCenter" stationName="moveOutStation"  townName="moveOutTown" width="32.5%;" isShowOneself="true" isAuthorize="false"/>
								</td>
								<td class="coltext"></td>
								<td class="colinput">
									<input class="search_btn" type="button" name="search" id="move_search_btn" value="查询" style="float: left;"/>
								</td>
							</tr>
						</tbody>
					</table>
					
					<table>
		                <tr>
		                    <td colspan="4" class="colbottom">
		                          <span onclick="toggle(this,'moveSearchTableId')" class="ico-bottom">&nbsp;</span>
		                    </td>
		                </tr>
					</table>
				</form>
			</div>
			<div id="personMoveListDiv"></div>
	 	</div>
	</div>
	
</div> --%>
<div class="toolbar">
	 	<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">居民健康档案</a>
	        <a>
          <cite>档案结案迁移查看</cite></a>
      	</span>
    	</div>
	  </div>
<div class="layui-tab layui-tab-brief" lay-filter="cancelFamilyEhr" style="width: 98%;margin-left: 8px;">

  <ul class="layui-tab-title">
    <li class="layui-this">档案结案</li>
    <li>档案迁移</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
	   		<div class="searchbox searchSection x-admin-sm searchArea">
				<form method="post" id="form_search">
					<table id="cancelSearchTableId">
						<colgroup>
		                    <col style="width: 10%;"/>
		                    <col style="width: 23%;"/>
		                    <col style="width: 10%;"/>
		                    <col style="width: 23%;"/>
		                    <col style="width: 10%;"/>
		                    <col style="width: 24%;"/>
						</colgroup>	
						<tbody>
							<tr>
								<td class="coltext">姓名</td>
								<td class="colinput"><input type="text" name="personName" id="personName" style="width: 75%" class="x-layui-input"/></td>
		                        <td class="coltext">结案时间</td>
								<td class="colinput">
									<%-- <tag:dateInput name="cancelBeginDate" id="cancelBeginDate" onlypast="true" style="width: 36.8%;"/> ~
									<tag:dateInput name="cancelEndDate" id="cancelEndDate" onlypast="true" style="width: 36.8%;"/> --%>
									<input type="text" class="layui-input x-admin-sm-date" name="cancelBeginDate" id="cancelBeginDate"  style="padding-left: 0px;width: 38%;" /> ~
                            		<input type="text" class="layui-input x-admin-sm-date" name="cancelEndDate" id="cancelEndDate" style="padding-left: 0px;width: 38%;" />
								</td>
								<td class="coltext">结案原因</td>
								<td class="colinput">
									<div class="layui-form">
										<div class="layui-form-item">
			    							<div class="layui-input-block" style="margin-left: 0px;">
											<ehr:dic-radio name="canceledReason" dicmeta="FS10311"/>
			    							</div>
			    							</div>
									</div>
								</td>
		                    </tr>
							<tr>
								<td class="coltext">结案机构</td>
								<td  class="colinput">
									<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchstation"  townName="searchTown" width="75%;" isShowOneself="true" cssClass="x-layui-input"/>
								</td>
                                <td class="coltext">死亡时间</td>
                                <td class="colinput">
                                   <%--  <tag:dateInput name="deathBeginDate" id="deathBeginDate" onlypast="true" style="width: 36.8%;"/> ~
                                    <tag:dateInput name="deathEndDate" id="deathEndDate" onlypast="true" style="width: 36.8%;"/> --%>
                                    <input type="text" class="layui-input x-admin-sm-date"  name="deathBeginDate" id="deathBeginDate" style="padding-left: 0px;width: 38%;" /> ~
                            		<input type="text" class="layui-input x-admin-sm-date"  name="deathEndDate" id="deathEndDate" style="padding-left: 0px;width: 38%;" />
                                </td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td class="righttd" colspan="6">
									<!-- <input class="search_btn" type="button" name="search" id="per_search_btn" value="查询" style="float: left;"/> -->
									<button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							</tr>
						</tbody>
					</table>
					<table>
		                <tr>
		                    <td colspan="4" class="colbottom">
		                          <span onclick="toggle(this,'cancelSearchTableId')" class="ico-bottom">&nbsp;</span>
		                    </td>
		                </tr>
					</table>
				</form>
			</div>
		<c:if test="${search_Role ne 'wsj_Role'}">
			<div class="toolbarSection">
				<a href="javascript:void(0)" id="per_export_btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			</div>
		</c:if>
			<div id="personCancelListDiv"></div>
    </div>
    <div class="layui-tab-item">
	 		<div class="searchbox searchSection x-admin-sm">
				<form method="post" id="form_moveSearch">
					<table id="moveSearchTableId">
						<colgroup>
		                    <col style="min-width:70px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
		                    <col style="min-width:80px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
		                    <col style="min-width:60px; width: 10%;"/>
		                    <col style="min-width:160px; width: 23%;"/>
						</colgroup>	
						<tbody>
							<tr>
								<td class="coltext">姓名</td>
								<td class="colinput"><input type="text" name="personMoveName" id="personMoveName" style="width: 80%" class="x-layui-input"/></td>
		                        <td class="coltext">迁移时间</td>
								<td class="colinput">
									<%-- <tag:dateInput name="moveBeginDate" id="moveBeginDate" onlypast="true" style="width: 36.8%;"/> ~
									<tag:dateInput name="moveEndDate" id="moveEndDate" onlypast="true" style="width: 36.8%;"/> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="moveBeginDate" id="moveBeginDate"  style="padding-left: 0px;width: 38%;"/> ~
                            		<input type="text" class="layui-input x-admin-sm-date"  name="moveEndDate" id="moveEndDate"   style="padding-left: 0px;width: 38%;"/>
								</td>
								<td class="coltext"></td>
								<td class="coltext"></td>
		                    </tr>
							<tr>
								<td class="coltext">迁入机构</td>
								<td colspan="3" class="colinput">
									<ehr:dic-town-centre-station centreName="moveInCenter" stationName="moveInStation"  townName="moveInTown" width="32.5%;" isShowOneself="true" isAuthorize="false"/>
								</td>
								<td class="coltext"></td>
								<td class="colinput"></td>
							</tr>
							<tr>
								<td class="coltext">迁出机构</td>
								<td colspan="3" class="colinput">
									<ehr:dic-town-centre-station centreName="moveOutCenter" stationName="moveOutStation"  townName="moveOutTown" width="32.5%;" isShowOneself="true" isAuthorize="false"/>
								</td>
								<td class="coltext"></td>
								<td class="colinput">
									<!-- <input class="search_btn" type="button" name="search" id="move_search_btn" value="查询" style="float: left;"/> -->
									<button class="layui-btn layui-btn-sm" id="move_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							</tr>
						</tbody>
					</table>
					
					<table>
		                <tr>
		                    <td colspan="4" class="colbottom">
		                          <span onclick="toggle(this,'moveSearchTableId')" class="ico-bottom">&nbsp;</span>
		                    </td>
		                </tr>
					</table>
				</form>
			</div>
		<c:if test="${search_Role ne 'wsj_Role'}">
			<div class="toolbarSection">
				<a href="javascript:void(0)" id="move_export_btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			</div>
		</c:if>

			<div id="personMoveListDiv"></div>
    </div>
  </div>
  <input type="hidden" id="familyId"/>
</div>

<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(cancelFamilyEhr)', function(data){
      /* if (data.index == 0) {
    	  familySearch.viewList();
      } else if(data.index == 1) {
    	  familySearch.viewCard();
      }  */ 
  });
});

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#cancelBeginDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    //执行一个laydate实例
    laydate.render({
      elem: '#cancelEndDate'
       ,format: 'yyyy/MM/dd'
    	   ,max:0
    });
    
  //执行一个laydate实例
    laydate.render({
      elem: '#deathBeginDate'
    	  ,format: 'yyyy/MM/dd'
    		  ,max:0
    });
  
  //执行一个laydate实例
    laydate.render({
      elem: '#deathEndDate'
    	  ,format: 'yyyy/MM/dd'
    		  ,max:0
    });
  
    
    //执行一个laydate实例
      laydate.render({
        elem: '#moveBeginDate'
      	  ,format: 'yyyy/MM/dd'
      		  ,max:0
      });
    
    //执行一个laydate实例
      laydate.render({
        elem: '#moveEndDate'
      	  ,format: 'yyyy/MM/dd'
      		  ,max:0
      });
    
  });
  
  

layui.use('form', function() {
	  var form = layui.form;
	/*   form.render(); */
	});
</script>