<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/drug/pharmacyCancel/detailSearch.js" type="text/javascript"></script>
<div class="toolbar">
    <!-- <a href="javascript:void(0)" onclick="pharmacyCancelSearch.returnSearch()"><b class="fanhui">返回</b></a> -->
    <a href="javascript:void(0)"  onclick="pharmacyCancelSearch.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button" style="margin-top: 5px;"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>

	
<div class="section"style="margin:10px 0px 0px 0px">
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="detailPageIndex" value="${detailPageIndex}">
		<input type="hidden" id="batchNo" value="${batchNo}">
		<form id="detailSearchForm">
               <table id="detailSearch" >
				<colgroup>
					<col style="min-width:90px; width: 10%;"/>
					<col style="min-width:200px; width: 30%;"/>
                    <col style="min-width:100px; width: 10%;"/>
                    <col style="min-width:100px; width: 30%;"/>
                </colgroup>
				<tbody>
					<tr>
		               	<td class="coltext">通用名</td>
		                <td class="colinput">
		                	<input type="text" name="drugGenericName" style="width: 200px;"/>
		                </td>
		               	<td class="coltext">失效日期</td>
		                <td>
							<%-- <tag:dateInput nullToToday="true" name="beginDt" 
								date="${firstDate}" pattern="yyyy/MM/dd"   style="width: 80px;" ></tag:dateInput>
							~<tag:dateInput nullToToday="true" name="endDt" 
								date="${lastDate}" pattern="yyyy/MM/dd"   style="width: 80px;"></tag:dateInput> --%>
								<input type="text" class="layui-input x-admin-sm-date" name="beginDt" id="beginDt1" value="<fmt:formatDate value='${firstDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 150px;padding-left: 0px;"> ~
                        	<input type="text" class="layui-input x-admin-sm-date" name="endDt" id="endDt1" value="<fmt:formatDate value='${lastDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 150px;padding-left: 0px;">
		                </td>  
					</tr>				
					<tr>
						<td class="coltext">生产厂家</td>
                        <td class="colinput">
                        	<input type="text" name="facName" style="width: 200px;"/>
                        </td>						
                        <td class="righttd" colspan="2">
                            <!-- <input type="button" id="detailBtnSearch" value="查询" class="search_btn"/> -->
                            <button class="layui-btn layui-btn-sm"  id="detailBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>                             													
					</tr>
				</tbody>
			</table>
               <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="daCommon.toggle(this,'detailSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
		 </form>
	</div>
	<div id="detailResultDiv"></div>
</div>
<div id="detailDetailDiv"></div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        
        laydate.render({
            elem: '#beginDt1'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });
        
        
        laydate.render({
            elem: '#endDt1'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });


    });

</script>