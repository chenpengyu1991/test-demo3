<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/cdm/report/cdmManageAnalysis/list.js"></script>
<div class="section">
	<div class="toolbar">
		          <%-- <a href="javascript:void(0)" id="cdm-manageanalysis-export"><b class="export">导出</b></a> --%>
		          <a href="javascript:void(0)" id="cdm-manageanalysis-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		    	</div> 
	<div class="searchbox searchSection x-admin-sm">
			<form method="post" id="cdmManageAnalysisForm">
				<table class="reportSearch" id="cdmManageAnalysisTable">
					<colgroup>
							<col style="width:10%;"/>
							<col style="width:4%;"/>
							<col style="width:10%;"/>
						</colgroup>
						<tr>
							<td class="coltext">日期</td>
							<td class="colinput">
								<%-- <tag:dateInput nullToToday="true" name="createDate"
											   date="${currentYear}" pattern="yyyy" style="width: 80%"/> --%>
											   <input type="text" class="layui-input x-admin-sm-date" placeholder="选择年份" name="createDate" id="cdmManageAnalysisCreateDateId" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>" style="padding-left: 0px;" />
							</td>
							<td>
								<%-- <input type="button" id="search_btn" class="search_btn" value="查询"/> --%>
								<button class="layui-btn layui-btn-sm" id="search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</table>

				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="listCdmManageAnalysis.toggle(this,'cdmManageAnalysisTable')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
	</div>
	<%--<div id="cdmManageAnalysisResultDiv" style="min-width: 750px; min-height:400px;overflow: auto;"></div>--%>
    <div id="cdmManageAnalysisResultDiv">
        <jsp:include page="${listpath}" ></jsp:include>
    </div>
</div>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#cdmManageAnalysisCreateDateId' 
     	   ,type: 'year'
     	   ,max:0
      });

  
});
</script>
