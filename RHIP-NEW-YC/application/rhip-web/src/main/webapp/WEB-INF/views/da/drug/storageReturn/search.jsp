<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/drug/storageReturn/search.js" type="text/javascript"></script>

<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">药品电子监管</a>
			        <a>
			          <cite>
			          药库退库监控
			          </cite></a>
			      </span>
			</div>
</div>

<div class="section" id="top_all">
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="storageReturnSearchForm">
                <table id="storageReturnSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 35%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 35%;"/>
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<tag:autoSelect name="organCode" id="organCode" codeValue="${organCode}" style="width:200px" ></tag:autoSelect>
                            </td>	
                            <td class="coltext">退货单号</td>
                            <td class="colinput">
 								<input type="text" name="batchNo" style="width: 120px;"/>
                            </td>                            					
						</tr>
						<tr>
							<td class="coltext">退货日期</td>
							<td class="colinput">
								<%-- <tag:dateInput nullToToday="true" name="beginDt" 
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;" ></tag:dateInput>
								~<tag:dateInput nullToToday="true" name="endDt" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput> --%>
									<input type="text" class="layui-input x-admin-sm-date" name="beginDt" id="beginDt" value="<fmt:formatDate value='${firstDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;"> ~
                        	<input type="text" class="layui-input x-admin-sm-date" name="endDt" id="endDt" value="<fmt:formatDate value='${lastDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
							</td>  
                            <td class="righttd" colspan="2">
                                <!-- <input type="button" id="storageReturnBtnSearch" value="查询" class="search_btn"/> -->
                                <button class="layui-btn layui-btn-sm"  id="storageReturnBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td> 
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'storageReturnSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="storageReturnResultDiv"></div>
</div>
<div id="storageReturnDetailDiv"></div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        
        laydate.render({
            elem: '#beginDt'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });
        
        
        laydate.render({
            elem: '#endDt'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });


    });

</script>