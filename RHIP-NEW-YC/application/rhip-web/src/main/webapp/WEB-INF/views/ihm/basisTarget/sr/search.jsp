<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/sr/search.js" > </script> --%>
<!-- <script type="text/javascript">
	 require(['views/ihm/baseTarget/sr/search'],function(index){
		 index.load();
	 });
</script> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/sr/search2.js" > </script>

<div class="toolbar">
	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">基础资源</a>
			        <a>
			          <cite>
			           科研著作
			          </cite></a>
			      </span>
			</div>
</div>

<div class="section">
    <div  id="top_all">
        <div class="searchbox searchSection x-admin-sm">
            <form id="searchForm">
                <table id="searchTable">
                    <colgroup>
                        <col style="width: 8%;" />
                        <col style="width: 10%;" />
                        <col style="width: 10%;" />
                        <col style="width: 47%;" />
                        <col style="width: 10%;" />
                        <col style="width: 15%;" />
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">年份</td>
                        <td class="colinput">
                            <input type="text" class="layui-input x-admin-sm-date" name="year" id="year" 
                               style="width: 80px;padding-left: 0px;">
                        </td>
                        <td class="coltext">所属单位</td>
                        <td class="colinput" colspan="2">
                            <ehr:dic-town-centre-station isShow="true" centreName="village" stationName="station" townName="town" isShowOther="true"  isShowInfirmary="true"
                                                         isShowHealthOversight="true"  townId="sTown" centreId="sCenter" stationId="sStation" width="180px"/>
                        	<input type="hidden" id="belongOrg" name="belongOrg">
                        </td>
                        
                        <td>
                        <button class="layui-btn layui-btn-sm"  id="searchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td class="colbottom">
                            <span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
                        	<input type="hidden" id="pageIndex">
                        </td>
                        
                    </tr>
                </table>
            </form>
        </div>
        <div id="listDiv"></div>
    </div>
    <div id="detailDiv"></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#year'
            ,type:'year'
            , format: 'yyyy'
            , max: 0
            , trigger: 'click' 
        });
        

    });

</script>