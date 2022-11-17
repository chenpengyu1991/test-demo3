<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ep/iodate/monitorSearch.js" type="text/javascript"></script>

<div class="section">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">地方病防治</a>
		        <a href="javascript:void(0)">碘盐监测</a>
		        <a>
		          <cite>监测记录</cite></a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
			<input type="hidden" id="functionName" value="监测记录"/>
			<input type="hidden" id="functionCode" name="function" value="monitorRecord"/>
			<table id="searchTable">
				<colgroup>
					<col style="width: 10%;" />
					<col style="width: 23%;" />
					<col style="width: 10%;" />
					<col style="width: 23%;" />
					<col style="width: 10%;" />
					<col style="width: 23%;" />
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext">姓名</td>
					<td class="colinput"><input type="text" name="name" style="width: 150px" class="x-layui-input" /></td>
					<td class="coltext">随机号</td>
					<td class="colinput"><input type="text" name="randomNumber" style="width: 150px" class="x-layui-input"/></td>
					<td class="coltext">所属乡镇</td>
					<td class="colinput">
					<%-- <ehr:dic-town-village townValue="${record.gbCode}" townName="gbCode" /> --%>
						 <select name="gbCode" style="width: 150px" reg="{'required':'true'}" class="x-layui-input">
							<option value="">请选择</option>
							<c:forEach var="town" items="${townList}">
								<option value="${town[0]}" ${record.gbCode eq town[0] ? "selected" : ""}>${town[1]}</option>
							</c:forEach>
						</select> 
					</td>
				</tr>
				<tr>
					<td class="coltext">家中是否有孕妇</td>
					<td class="colinput"><ehr:dic-list name="gravidaStatus" dicmeta="FS10246" width="150px" cssClass="x-layui-input"/></td>
					<td class="coltext">监测时间</td>
					<td class="colinput">
						<%-- <tag:dateInput id="beginTime" maxId="endTime" name="beginTime" pattern="yyyy/MM/dd" style="width: 70px"/>
						&nbsp;~&nbsp;
						<tag:dateInput id="endTime" minId="beginTime" name="endTime" pattern="yyyy/MM/dd" style="width: 70px"/> --%>
						
						<input type="text" class="layui-input x-admin-sm-date"  name="beginTime" id="beginTime" style="padding-left: 0px;width: 80px;" /> &nbsp;~&nbsp;
                                <input type="text" class="layui-input x-admin-sm-date"  name="endTime" id="endTime" style="padding-left: 0px;width: 80px;" />
					</td>
					<td style="text-align: right;" colspan="2">
						<button class="layui-btn layui-btn-sm" id="searchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
					</td>
				</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="colbottom">
						<span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection x-admin-sm">
	<c:if test="${addAllowed eq true}">
			<a href="javascript:void(0)" id="addBtn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</c:if>
		</div>
	<div id="listDiv"></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#beginTime' 
        	  ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#endTime'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
      
      });
    
    </script>