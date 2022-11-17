<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/idm/setupDisease.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 10px;">
	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">传染病及突发事件</a>
		        <a>
		          <cite>上报疾病设置</cite></a>
		      </span>
    </div>
    <a href="javascript:void(0)" onclick="javascript:setupDisease.save()"><button class="layui-btn layui-btn-sm button"> <i class="layui-icon"></i>绑定</button></a>
    <a href="javascript:void(0)" onclick="javascript:setupDisease.unbind()"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">ဆ</i>解除</button></a>
</div>
<div class="divFixed125" style="top: 55px">
    <div class="searchbox searchSection x-admin-sm">

    <form id="setForm">
        <div class="searchbox searchSection x-admin-sm" style="padding-top: 10px;">
            <table style="padding-bottom: 5px;">
                <tr>
                    <td>
                        选择要绑定的疾病名称和ICD编码：
                    </td>
                </tr>
            </table>
            <div class="postdiv" style="padding-top: 5px;">
                <fieldset class="layui-elem-field">
                    <table id="searchTable">
                        <colgroup>
                            <col style="width: 200px;">
                            <col style="width: 30%;">
                            <col style="width: 15%;">
                            <col />
                        </colgroup>
                        <tr>
                            <th style="height: 20px;text-align:right;">疾病</th>
                            <td>
                                <select name="infectiousCode" id="infection"  reg='{"required":"true"}' style="width: 250px;" class="x-layui-input"
                                        onchange="javascript:setupDisease.getInfectionsName()">
                                </select >
                                <input type="hidden" id="infectiousName" name="infectiousName"/>
                            </td>
                            <th style="text-align:right;">绑定的ICD编码</th>
                            <td> 
                                <input type="text" id="bindDiseaseCode" name="bindDiseaseCode"  reg='{"required":"true"}' class="x-layui-input"/>
                            </td>
                        </tr>
                        <tr>
                            <th style="color:red;text-align:right;">注：</th>
                            <td colspan="3" style="color:red;"> 
                                多个绑定的ICD编码之间用"，"分开；&nbsp;&nbsp;&nbsp;&nbsp;ICD编码疾病查询:<input type="text" id="disease" name="diseaseType"  style="width:250px; " class="x-layui-input"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </div>
        </div>
    </form>
    </div>
    
    <div>
    <form id="unbindForm">
        <div class="searchbox searchSection x-admin-sm" style="padding-top: 10px;">
            <table style="padding-bottom: 5px;">
                <tr>
                    <td>
                       要解除绑定的ICD编码：
                    </td>
                </tr>
            </table>
            <div class="postdiv" style="padding-top: 5px;">
                <fieldset class="layui-elem-field">
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 200px;">
                            <col />
                        </colgroup>
                        <tr>
                            <th style="text-align:right;">ICD编码</th>
                            <td> 
                             	<select id="unBindDiseaseCode" name="unBindDisease" style="width: 200px;" reg='{"required":"true"}' class="x-layui-input">
                       			 </select>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </div>
        </div>
    </form>
    </div>
    
    <div >
        <form id="resultForm"><div class="searchbox searchSection x-admin-sm">
            <table>
                <colgroup>
                    <col style="min-width:200px; width: 80%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                </colgroup>
                <tr>
                    <td style="text-align: left;">
                        <span>绑定情况：</span>
                        <%--隐藏的文本框是为了一个文本框不能响应回车事件的解决方法，不能删除--%>
                        <input type="text" style="display: none;">
                
                     
                                                                         病名：
                        <select id="searchInfectiousCode" name="itemCode" style="width: 200px;" class="x-layui-input">
                        </select>
                        ICD编码：
                        <select id="searchDiseaseCode" name="icdCode" style="width: 200px;" class="x-layui-input"
                        		>
                        </select>
                       
                    </td>
                    <td style="text-align: right;">
                    	<button class="layui-btn layui-btn-sm" id="setupBtnSearch"><i class="layui-icon"></i>查询</button>
                    </td>
                </tr>
            </table></div>
        </form>

        <div id="setDiv"></div>
    </div>
</div>