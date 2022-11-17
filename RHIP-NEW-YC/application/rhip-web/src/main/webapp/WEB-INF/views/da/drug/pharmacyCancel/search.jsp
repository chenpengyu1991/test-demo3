<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/drug/pharmacyCancel/search.js" type="text/javascript"></script>

<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">药品电子监管</a>
			        <a>
			          <cite>
			          药房退药监控
			          </cite></a>
			      </span>
			</div>
</div>

<div class="section" id="top_all">
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="pharmacyCancelSearchForm">
                <table id="pharmacyCancelSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
						<col style="min-width:180px; width: 10%;"/>						
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<tag:autoSelect name="organCode" id="organCode" codeValue="${organCode}" style="width:200px" ></tag:autoSelect>
                            </td>
                            <td class="coltext">退往药房</td>
                            <td class="colinput">
 								<ehr:dic-list  name="targetPharmacyType" dicmeta="DA00015" value="" code="1,2,3,4" width="120px"/>
                            </td>                             
						</tr>
						<tr>
							<td class="coltext">退药日期</td>
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
                            <td class="coltext">退药类别</td>
                            <td class="colinput">
 								<ehr:dic-list  name="cancelTypeCode" dicmeta="DA00013" value="" code="1,2" width="120px"/>
                            </td>   						 						
                            <td class="righttd" colspan="2">
                                <!-- <input type="button" id="pharmacyCancelBtnSearch" value="查询" class="search_btn"/> -->
                                <button class="layui-btn layui-btn-sm"  id="pharmacyCancelBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>  
	                            						
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'pharmacyCancelSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="pharmacyCancelResultDiv"></div>
</div>
<div id="pharmacyCancelDetailDiv"></div>

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