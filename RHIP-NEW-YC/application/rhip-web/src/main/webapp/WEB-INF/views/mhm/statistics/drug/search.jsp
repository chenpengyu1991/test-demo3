<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>


<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/mhm/statistics/drug/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<script>
    $(function() {
        mhmCommon.initDrugSelectBox('drugSelectBox',selectFun);
    });
    function selectFun(data){
        $('#hDrugName').val($(data).attr("drugName"));
    }
</script>
<div>
    <div class="section" id="management_top_all">
        <div class="toolbar">
            <!-- <a href="javascript:void(0)" id="drugExport"><b class="export">导出</b></a> -->
            <a href="javascript:void(0)" id="drugExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        </div>
        <div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="drugSearchForm">
                <table id="drugSearch" >
                    <colgroup>
                        <col style="min-width:70px; width: 15%;"/>
                        <col style="min-width:160px; width: 25%;"/>
                        <col style="min-width:70px; width: 15%;"/>
                        <col style="min-width:160px; width: 30%;"/>
                        <col style="min-width:90px; width: 15%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">药品名称</td>
                        <td class="colinput">
                            <tag:autoSelect
                                            codeValue="${drugRecord.drugId}"
                                            nameValue="${drugRecord.drugName}"
                                            name="drugId" id="drugSelectBox"/>
                            <input type="hidden" id="hDrugName" name="drugName" value='${drugRecord.drugName}'/>
                        </td>
                        <td class="coltext">发药时间</td>
                        <td class="colinput">
                            <%-- <tag:dateInput name="drugDtFrom" onlypast="true" style="width: 36%;"/>
                            至<tag:dateInput name="drugDtTo" onlypast="true"  style="width: 36%;"/> --%>
                            
                            <input type="text" class="layui-input x-admin-sm-date"  name="drugDtFrom" id="drugDtFromId" style="padding-left: 0px;width: 36%;" /> 至
                                <input type="text" class="layui-input x-admin-sm-date"  name="drugDtTo" id="drugDtToId" style="padding-left: 0px;width: 36%;" />
                        </td>

                    </tr>
                    <tr>
                        <td class="coltext">管理机构</td>
                        <td class="colinput" colspan="3">
                            <ehr:dic-town-centre-station centreName="centerCode" stationName="stationCode" townName="townCode" width="160px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </td>
                        <td><!-- <input type="button" value="查询" id="drugBtnSearch" class="search_btn"/> -->
                        <button class="layui-btn layui-btn-sm" id="drugBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="mhmCommon.toggle(this,'drugSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="drugResultDiv">
            <div id="reportList" class="repeattable">
                <table>
                    <colgroup>
                        <col style="width: 40px;"/>
                        <col/>
                        <col style="width: 70px;"/>
                        <col/>
                        <col/>
                        <col style="width: 150px;"/>
                        <col style="width: 80px;"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>药品名称</th>
                        <th>剂型</th>
                        <th>规格</th>
                        <th>机构</th>
                        <th>时间</th>
                        <th>费用</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <div id="drugDetailDiv" ></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#drugDtFromId' 
        	  ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#drugDtToId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
      
      });

    </script>