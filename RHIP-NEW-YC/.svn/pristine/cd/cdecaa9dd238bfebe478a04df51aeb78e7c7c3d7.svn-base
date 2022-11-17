<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/popTarget.js" type="text/javascript"></script>
<div class="section">
	<div class="searchBox searchSection x-admin-sm">
		<form id="popTargetSearchForm">
			<table id="targetSearchPop">
                <colgroup>
                    <col style="width: 15%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 15%;"/>
                    <col style="width: 50%;"/>
                    <col/>
                </colgroup>
				<tbody>
					<tr>
                    	<td class="col-text">机构类型</td>
                        <td class="col-input">
                        	<select name="genreCode" id="genreCodePopId" style="width: 130px;">
								<option value="0">按区县</option>
								<option value="B1">按卫生院</option>
                        	</select>
                        </td>
                        <td class="col-text">机构</td>
						<td class="col-input">
							<%--镇--%>					
							<div id="byTown">
								<ehr:dic-town-village townId="town3" townName="gbCode" width="220px"/>
							</div>
							<%--卫生院--%>					
							<div id="byCentre">
								<ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="organCode" townName="gbCodeOrg" width="220px;" />
							</div>														
						</td>     
					</tr>
					<tr>
                        <td class="col-text">年份</td>
						<td class="col-input">
							<input class="layui-input" placeholder="选择年度" name="countYear" id="countYearId"  style="height: 25px;width: 130px;">
						</td>
						<td colspan="2" style="text-align: center;">
							<!-- <input type="button" id="popTargetBtnSearch" value="查询" onclick="" class="search_btn" /> -->
							<button class="layui-btn layui-btn-sm"  id="popTargetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>   
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="col-bottom">
						<span onclick="toggle(this,'targetSearchPop')" class="ico-bottom">&nbsp;</span>
					</td>   					
				</tr>
			</table>

		</form>
	</div>
	<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          type:"year",
          elem: '#countYearId', //指定元素
          max:0,
          value: new Date()
        });

      });

    </script>
	<div id="resultDiv">
		<jsp:include page="list.jsp"/>
	</div>
</div>
