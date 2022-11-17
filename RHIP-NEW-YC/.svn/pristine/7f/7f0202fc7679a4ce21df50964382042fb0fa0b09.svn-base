<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/consumable/in/search.js" type="text/javascript"></script>

<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">药品电子监管</a>
			        <a>
			          <cite>
			           耗材入库监控
			          </cite></a>
			      </span>
			</div>
</div>

<div class="section" id="top_all">
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="consumableInSearchForm">
                <table id="consumableInSearch" >
					<colgroup>
						<col style="min-width:90px; width: 10%;"/>
						<col style="min-width:250px; width: 30%;"/>
	                    <col style="min-width:90px; width: 10%;"/>
						<col style="min-width:180px; width: 20%;"/>
						<col style="min-width:90px; width: 10%;"/>		
						<col style="min-width:120px; width: 15%;"/>				
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<tag:autoSelect name="organCode" id="organCode" codeValue="${organCode}" style="width:200px" ></tag:autoSelect>
                            </td>
                            <td class="coltext">入库方式</td>
                            <td class="colinput">
 								<ehr:dic-list  name="storageTypeCode" dicmeta="DA00001" value="" code="1,2,3" width="120px"/>
                            </td>                             	 						
                            <td class="coltext">发票号码</td>
                            <td class="colinput">
 								<input type="text" name="invoiceNum" style="width: 120px;"/>
                            </td>							  
						</tr>
						<tr>
							<td class="coltext">采购日期</td>
							<td class="colinput">
								<%-- <tag:dateInput nullToToday="true" name="beginDt" 
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;" ></tag:dateInput>
								~<tag:dateInput nullToToday="true" name="endDt" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="beginDt" value="<fmt:formatDate value='${firstDate}' pattern='yyyy/MM/dd'/>"  id="beginDt" style="padding-left: 0px;width: 80px;" />~
          				    <input type="text" class="layui-input x-admin-sm-date"  name="endDt" id="endDt" value="<fmt:formatDate value='${lastDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
							</td> 						
                            <td class="coltext">入库单号</td>
                            <td class="colinput">
 								<input type="text" name="batchNo" style="width: 120px;"/>
                            </td> 
                            <td class="righttd" colspan="2">
                                <button class="layui-btn layui-btn-sm"  id="consumableInBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>  	                                                      						
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'consumableInSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="consumableInResultDiv"></div>
</div>
<div id="consumableInDetailDiv"></div>

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