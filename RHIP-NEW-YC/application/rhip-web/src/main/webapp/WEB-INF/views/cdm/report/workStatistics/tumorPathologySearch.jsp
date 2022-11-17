<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="toolbar">
	<%-- <a href="javascript:void(0)" id="cdm-report-tumorPathology-export"><b class="export">导出</b></a> --%>
	<a href="javascript:void(0)" id="cdm-report-tumorPathology-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
</div>
<ehr:authorize ifAnyGranted="0107,01">
	<c:set var="isMBK" value="${true}" />
</ehr:authorize>
<div id="list_view">
	<div class="section">
		<div class="searchbox searchSection x-admin-sm">	
			<form id="tumorPathologyForm" name="" action="" method="post">
				<table id="reportSearch">
					<colgroup>
						<col style="min-width:160px; width: 38%;"/>
						<col style="min-width:160px; width: 30%;"/>
						<col style="min-width:160px; width: 10%;"/>		  
				    </colgroup>		
					<tbody>				
					   <tr>	
					   		<td>
					   		时间<%-- <tag:dateInput style="width:150px;" name="beginDate" date="${defaultBeginDate}"  id="beginDate" onlypast="true"/>~
					   		   <tag:dateInput style="width:150px;"  name="endDate" date="${currentDate}"   id="endDate" onlypast="true"/> --%>
					   		   <input type="text" class="layui-input x-admin-sm-date"   name="beginDate" id="pathologyBeginDate" value="<fmt:formatDate value='${currentYear}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;"/> ~
                               <input type="text" class="layui-input x-admin-sm-date"   name="endDate" id="pathologyEndDate" value="<fmt:formatDate value='${currentYear}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;"/>
					   		</td>
					   		<c:if test="${isMBK eq true}">
								<td class="colinput" >上报机构
									<ehr:dic-town-centre-station width="130;" centreName="organCode" townName="gbCode" cssClass="x-layui-input"/>
								</td>
							</c:if>
					   		<td>
					   			<%-- <input id="tumorPathologySearchButton" type="button" class="button search_btn" value="查询" /> --%>
					   			<button class="layui-btn layui-btn-sm" id="tumorPathologySearchButton"><i class="layui-icon">&#xe615;</i>查询</button>
					   		</td>
					   </tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="cdmWorkStatistics.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
		</div>
		<div id="tumorPathology_result"></div>
	</div>
</div>

 <script type="text/javascript">
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#pathologyBeginDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#pathologyEndDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      });

    </script>