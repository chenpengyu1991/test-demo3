<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
 <style type="text/css">
.x-layui-inputs{
    border: 1px solid #DCDEE0;
    vertical-align: middle;
    border-radius: 3px;
    height: 23px;
    padding: 0px 0px;
    font-size: 14px;
    color: #555555;
    outline: none;
    width: 80%;
    box-sizing: border-box;
}
</style>
<script src="${pageContext.request.contextPath}/js/views/idm/setup.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
          
        laydate.render({
            elem: '#setYear' 
         	   ,type: 'year'
         	, trigger: 'click' 
          });
         laydate.render({
            elem: '#searchYear' 
         	   ,type: 'year'
         	, trigger: 'click' 
          }); 
      });

</script>
<div class="toolbar">
	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">传染病及突发事件</a>
		        <a>
		          <cite>参数设置</cite></a>
		      </span>
		</div>
    <a href="javascript:void(0);" onclick="javascript:setup.save()"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
</div>
<div class="section divFixed125" style="top:50px">
    <div class="searchbox searchSection x-admin-sm">
    

    <form id="setForm">
        <div class="postcontent" style="padding-top: 10px;">
            <table style="padding-bottom: 5px; display:none;">
                <tr>
                    <td>
                        选择要绑定的疾病名称和机构名称：
                        <input type="text"  reg='{"required":"true"}' class="layui-input x-admin-sm-date" name="setYear" id="setYear" style="padding-left: 0px;width: 75px;" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>"/>
                        年度
                    </td>
                </tr>
            </table>
            <div class="postdiv" style="padding-top: 5px;">
                <fieldset class="layui-elem-field">
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 160px;">
                            <col style="width: 40%;">
                            <col style="width: 160px;">
                            <col style="width: 40%;">
                        </colgroup>
                        <tr>
                            <th style="height: 20px;">疾病</th>
                            <td>
                                <select name="infectiousCode" id="disease" multiple="multiple" reg='{"required":"true"}'  class="x-layui-input" style="width:200px"
                                        onchange="javascript:setup.getInfectionsName()">
                                </select >
                                <input type="hidden" id="infectiousName" name="infectiousName"/>
                            </td>
                            <th>机构</th>
                            <td>
                                <ehr:org-type-list id="organization" type="hospital,centre,station" name="caseOrganCode" cssClass="x-layui-input"
                                                   isMultiple="true" reg='{"required":"true"}' width="200px;"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </div>
        </div>
    </form>
   </div>

    <div > 
        <form id="resultForm">
            <table>
                <colgroup>
                    <col style="min-width:200px; width: 80%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                </colgroup>
                <tr>
                    <td style="text-align: left;">
                        <span><label id="labelYear"></label>年份，处置绑定情况：</span>
                        <%--隐藏的文本框是为了一个文本框不能响应回车事件的解决方法，不能删除--%>
                        <input type="text" style="display: none;">
                        年份：
                        <input type="text"  reg='{"required":"true"}' class="layui-input x-admin-sm-date" name="setYear" id="searchYear" style="padding-left: 0px;width: 75px;" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>"/>
                        机构：
                        <ehr:org-type-list id="searchCaseOrganCode" name="caseOrganCode" type="hospital,centre,station" value="${caseOrganCode}" code="${caseOrganCode}" width="200px" cssClass="x-layui-inputs"/>
                        病名：
                        <select id="searchInfectiousCode" name="infectiousCode" style="width: 200px;" class="x-layui-inputs">
                        </select>
                    </td>
                    <td style="text-align: right;">
                    	<button class="layui-btn layui-btn-sm" id="setupBtnSearch"><i class="layui-icon"></i>查询</button>
                    </td>
                </tr>
            </table>
        </form>

        <div id="setDiv"></div>
    </div>
</div>