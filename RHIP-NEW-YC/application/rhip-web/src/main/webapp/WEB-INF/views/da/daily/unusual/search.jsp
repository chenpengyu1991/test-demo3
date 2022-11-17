<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/unusual/search.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#prescribeDateBegin' 
       	   ,format: 'yyyy/MM/dd'
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#prescribeDateEnd'
           ,format: 'yyyy/MM/dd'
        });
    });
</script>
<div class="section" id="top_all">
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="unusualSearchForm">
                <table id="unusualSearch" >
					<colgroup>
						<col style="min-width:90px; width: 12%;"/>
						<col style="min-width:180px; width: 38%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 35%;"/>
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext"><label class="required">监控指标</label></td>
                            <td class="colinput">
 								<select id="monitorIndex" name="monitorIndex" style="width: 100px" onchange="unusualSearch.monitorValueChange(this.value)">
									<option value="1">处方金额</option>
									<option value="2">用量</option>
									<option value="3">天数</option>
									<option value="4">品种</option>
								</select>
								<%--<select id="monitorValue" name="monitorValue" style="width: 100px">--%>
									<%--<option value="300">大于300</option>--%>
								<%--</select>--%>
                                &nbsp;&nbsp;&nbsp;范围&nbsp;<input type="text" name="monitorValue" style="width: 60px;">~<input type="text" name="monitorValueMax" style="width: 60px;">
                            </td>
							<td class="coltext"><label class="required">开方日期</label></td>
							<td class="colinput">
								<%-- <tag:dateInput nullToToday="true" id="prescribeDateBegin" name="prescribeDateBegin" 
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;" reg="{'required':'true'}"></tag:dateInput>
								~<tag:dateInput nullToToday="true" id="prescribeDateEnd" name="prescribeDateEnd" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput> --%>
									
									<%-- <input type="text" class="layui-input x-admin-sm-date" reg="{'required':'true'}" name="prescribeDateBegin" id="prescribeDateBegin" value="<fmt:formatDate value='${firstDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;"> ~
                        	<input type="text" class="layui-input x-admin-sm-date" reg="{'required':'true'}" name="prescribeDateEnd" id="prescribeDateEnd" value="<fmt:formatDate value='${lastDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;"> --%>
                               <input type="text" class="layui-input x-admin-sm-date"  name="prescribeDateBegin" id="prescribeDateBegin" style="padding-left: 0px;width: 38%;" /> ~
                               <input type="text" class="layui-input x-admin-sm-date"  name="prescribeDateEnd" id="prescribeDateEnd"  style="padding-left: 0px;width: 38%;"/>
                               
							</td>                            
						</tr>
						<tr>
							<td class="coltext">开方医生姓名</td>
							<td class="colinput">
								<input type="text" name="prescribeDoctorName" style="width: 38%" class="x-layui-input"/>
							</td>
							<td class="coltext">开方医生工号</td>
							<td class="colinput">
								<input type="text" name="prescribeDoctorNo" style="width: 38%" class="x-layui-input"/>
							</td>						
						</tr>
						<tr>
                            <td class="coltext">所属机构</td>
                            <td class="colinput" colspan="2">
                            	<tag:autoSelect name="hospitalCode" id="hospitalCode" codeValue="${reportUnitCode}" style="width:200px" reg="{'required':'true'}"></tag:autoSelect>
                            </td>	
                            <td class="righttd">
                                <button class="layui-btn layui-btn-sm"  id="unusualBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>                            					
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'unusualSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="unusualResultDiv">
		<div class="repeattable">
			<table>
				<colgroup>
					<col style="min-width:120px;width: 15%;"/>
			        <col style="min-width:80px;width: 10%;"/>
					<col style="min-width:80px;width: 10%;"/>
			        <col style="min-width:80px;width: 10%;"/>
					<col style="min-width:140px;width: 15%;"/>
					<col style="min-width:80px;width: 10%;"/>
		           	<col style="min-width:80px;width: 10%;"/>
					<col style="min-width:100px;width: 10%;"/>
				</colgroup>
				<thead>
					<tr>
		                <th>医疗机构</th>
						<th>监控指标</th>
		                <th>
							<c:choose>
		                        <c:when test='${monitorIndex == "1"}'>处方金额</c:when>
		                        <c:when test='${monitorIndex == "2"}'>最大用量</c:when>
		                        <c:when test='${monitorIndex == "3"}'>最大天数</c:when>
		                        <c:when test='${monitorIndex == "4"}'>处方品种</c:when>
			                </c:choose>
						</th>
		                <th>处方类型</th>
						<th>处方号</th>
		                <th>开方日期</th>
		               	<th>开方医生</th>
						<th>操作</th>
					</tr>
				</thead>
			</table>
		</div>
		</div>
</div>
<div id="unusualDetailDiv"></div>

