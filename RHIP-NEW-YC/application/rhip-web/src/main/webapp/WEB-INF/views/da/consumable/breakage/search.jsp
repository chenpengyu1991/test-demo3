<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/consumable/breakage/search.js" type="text/javascript"></script>
<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">药品电子监管</a>
			        <a>
			          <cite>
			           报损监控
			          </cite></a>
			      </span>
			</div>
</div>

<div class="section" id="top_all">
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="breakageSearchForm">
                <table id="breakageSearch" >
					<colgroup>
						<col style="min-width:90px; width: 10%;"/>
						<col style="min-width:250px; width: 25%;"/>
	                    <col style="min-width:90px; width: 10%;"/>
						<col style="min-width:180px; width: 20%;"/>
						<col style="min-width:180px; width: 10%;"/>	
						<col style="min-width:180px; width: 25%;"/>					
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<tag:autoSelect name="organCode" id="organCode" codeValue="${organCode}" style="width:200px" ></tag:autoSelect>
                            </td>	 						
                            <td class="coltext">报损原因</td>
                            <td class="colinput">
 								<ehr:dic-list  name="breakageReason" dicmeta="DA00014" value="" code="1,2,3,4" width="120px"/>
                            </td>   
                            <td class="coltext">耗材名称</td>
                            <td class="colinput">
 								<input type="text" name="keyword" style="width: 120px;"/>
                            </td>                                 
						</tr>
						<tr>
							<td class="coltext">报损日期</td>
							<td class="colinput">
								<%-- <tag:dateInput nullToToday="true" name="beginDt" 
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;" ></tag:dateInput>
								~<tag:dateInput nullToToday="true" name="endDt" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="beginDt" value="<fmt:formatDate value='${firstDate}' pattern='yyyy/MM/dd'/>"  id="beginDt" style="padding-left: 0px;width: 80px;" />~
          				    <input type="text" class="layui-input x-admin-sm-date"  name="endDt" id="endDt" value="<fmt:formatDate value='${lastDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
							</td>	
                            <td class="coltext">管理分类</td>
                            <td class="colinput">
 								<ehr:dic-list  name="manageTypeCodeGb" dicmeta="DA00016" value=""  width="120px"/>
                            </td>   
                            <td class="righttd" colspan="2">
                                <button class="layui-btn layui-btn-sm"  id="breakageBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>                              												
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'breakageSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="breakageResultDiv"></div>
</div>
<div id="breakageDetailDiv"></div>

<script type="text/javascript">
 layui.use('laydate', function(){
     var laydate = layui.laydate;
     
     laydate.render({
       elem: '#beginDt' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });

     //执行一个laydate实例
     laydate.render({
       elem: '#endDt' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });
   });

 </script>