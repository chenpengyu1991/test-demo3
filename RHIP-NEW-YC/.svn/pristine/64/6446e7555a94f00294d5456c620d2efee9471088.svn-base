<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/hsa/inspRecord/list/list.js" type="text/javascript"></script>
<div class="section" id="hsa-record-list-box">
	<!-- 	<div class="toolbar"> -->
	<%-- 		<ehr:authorize ifAnyGranted="03,28"> --%>
	<!-- 		<a href="javascript:void(0)" id="hsa-inspRecord-add-btn"><b class="xinz">新增</b></a> -->
	<%-- 		 </ehr:authorize>	 --%>
	<!-- 	</div> -->
	<div class="searchbox searchSection x-admin-sm">
		<form method="post" id="form_search">
			<table id="hsa-record-recordSearchBox">
				<colgroup>
					<col style="min-width: 70px; width: 12%;" />
					<col style="min-width: 140px; width: 21%;" />
					<col style="min-width: 70px; width: 12%;" />
					<col style="min-width: 100px; width: 17%;" />
					<col style="min-width: 70px; width: 12%;" />
					<col style="min-width: 160px; width: 23%;" />
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">巡查日期</td>
						<td class="colinput"><%-- <tag:dateInput nullToToday="true" name="startDate" pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;"
								id="hsa-startDate"
							></tag:dateInput> ~<tag:dateInput nullToToday="true" name="endDate" pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;" id="hsa-endDate"></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-sm-date"  name="startDate" id="hsa-startDate" style="padding-left: 0px;width: 36%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="hsa-endDate" style="padding-left: 0px;width: 36%;" />
							
							</td>
						<td class="coltext">是否报告登记</td>
						<td class="colinput"><ehr:dic-list dicmeta="FS10097" name="isReport" cssClass="x-layui-input"/></td>
						<td class="coltext">是否巡查指导</td>
						<td class="colinput"><ehr:dic-list dicmeta="FS10097" name="isGuide" cssClass="x-layui-input"/></td>
					</tr>
					<tr>
						<td class="coltext">巡查人</td>
						<td class="colinput"><input type="text" name="createDoctorName" class="x-layui-input"></td>
						<td class="coltext">状态</td>
						<td class="colinput"><label><input type="radio" name="status" value="1" checked="checked" />待确认</label><label><input type="radio" name="status" value="2" />已确认</label> 
						</td>
						<td></td>
						<td align="left"><!-- <input type="button" id="hsa-inspRecord-list-search_btn" value="查询" class="search_btn" width="80"> -->
						<button class="layui-btn layui-btn-sm" id="hsa-inspRecord-list-search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
					<ehr:authorize ifAnyGranted="01,28">
						<tr>
							<td class="coltext">巡查机构</td>
							<td colspan="5"><ehr:dic-town-centre-station centreName="centerOrganCode" townName="gbcode" isShowOther="true" width="200px;" /></td>
						</tr>
					</ehr:authorize>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="hsaInspRecordList.toggle(this,'hsa-record-recordSearchBox')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="hsa-record-result-list" class="repeattable"></div>
</div>
<div id="hsa-record-input-add" class="postdiv"></div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#hsa-startDate' 
        	  ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#hsa-endDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
      
      });

    </script>