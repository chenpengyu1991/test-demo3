<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/jcReport.js" type="text/javascript"/>
<div>
    <div id="register_top_all">
        <div id="reportIndexId" class="thirdMenu">
            <input type="hidden" id="selectedTagST"/>
            <span class="active">
			<a id="drugRegId" href="javascript:void(0)">血吸虫病监测月报</a>
		    </span>
        </div>
        <div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="jcReportSearchForm1">
                <table id="reportSearch" >
                    <colgroup>
                    </colgroup>
                    <tbody>
                    <tr>
                        <input type="hidden" id="pageIndex" value="1"<%--"${pageIndex}"--%>/>
                        <td class="coltext">月份</td>
                        <td class="colinput">
                        <%-- <tag:dateInput nullToToday="false" id="month" name="month" pattern="yyyy/MM"  onlypast="true" style="width: 24%;"> 
                        </tag:dateInput>--%>
                        <input type="text" class="layui-input x-admin-sm-date" style="width:35%;padding-left: 0px;" placeholder="选择月份" name="month" id="month"  />
                        </td>
                        <td class="coltext">村镇</td>
                        <td class="colinput"> <ehr:dic-town-village townId="patownShip" townName="patownShip" width="180px;" cssClass="x-layui-input" /></td>
                        <td>
                            <%-- <input type="button" id="ch_search_btn" value="查询" onclick="javascript:void(0);" class="search_btn"/> --%>
                            <button class="layui-btn layui-btn-sm" id="ch_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
                            <!-- <input type="button" id="" value="导出" onclick="jcReport.downLoad()" class="search_btn"/> -->
                            <button class="layui-btn layui-btn-sm" id="ch_downExcel_btn"><i class="layui-icon">&#xe67d;</i>导出</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">

                            <span onclick="idmCommon.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>


    </div>
    <div id="jcReportDiv" ></div>
</div>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#month' 
     	   ,type: 'month'
     	   ,format:'yyyy/MM'
     	   ,max:0
      });

  
});
</script>