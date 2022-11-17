<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/life/search.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
        <%-- <a href="javascript:void(0)" id="lifeEventImport" onclick="lifeEventSearch.importExcel()"><b class="import">导入</b></a> --%>
        <a id="lifeEventImport" onclick="lifeEventSearch.importExcel()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe62f;</i>导入</button></a>
        <%-- <a href="javascript:void(0)" id="lifeEventCancel" onclick="lifeEventSearch.cancel()"><b class="quxiao">一键注销</b></a> --%>
        <a id="lifeEventCancel" onclick="lifeEventSearch.cancel()"><button class="layui-btn layui-btn-sm"><i class="layui-icon"> &#x1006;</i>一键注销</button></a>
    </div> 
	<div class="searchBox  searchSection x-admin-sm searchArea">
		<input type="hidden" id="searchType" value="${searchType}">
		<form id="searchForm">
            <table id="searchTableLife">
                <colgroup>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 100px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 100px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 100px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" class="x-layui-input" />
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="paperNo" class="x-layui-input" />
                    </td>
                    <td class="col-text">是否注销</td>
                    <td class="col-input">
                    	<div class="layui-form">
							<div class="layui-form-item">
							<div class="layui-input-block" style="margin-left: 0px;margin-bottom: -5px;">
	                        <input name="cancelStatus" value="" type="radio"> 全部
	                        <input name="cancelStatus" value="1" type="radio"> 是
	                        <input name="cancelStatus" value="0" type="radio"> 否
	                        </div>
	                        </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">死亡日期</td>
                    <td class="col-input">
                        <%-- <tag:dateInput name="deathDate" onlypast="true"></tag:dateInput> --%>
                         <input type="text" class="layui-input x-admin-sm-date" placeholder="选择日期" name="deathDate" id="deathDate" style="width:100%;min-width: 100px;padding-left: 0px;">
                    </td>
                    <td class="col-text">人群分类</td>
                    <td class="col-input">
                    	<div class="layui-form">
							<div class="layui-form-item">
							<div class="layui-input-block" style="margin-left: 0px;margin-bottom: -5px;">
                        <ehr:dic-radio dicmeta="FS990023" name="personType" isDefault="Y"></ehr:dic-radio>
                         </div>
	                        </div>
                        </div>
                    </td>
                    <td style="text-align: center;" colspan="3">
                        <%-- <input type="button" id="btnSearch" value="查询" class="search_btn" /> --%>
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTableLife')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="resultDiv">
		<jsp:include page="list.jsp"></jsp:include>
	</div>
</div>
<div id="view" >
</div>
  <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#deathDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

      });

    </script>
