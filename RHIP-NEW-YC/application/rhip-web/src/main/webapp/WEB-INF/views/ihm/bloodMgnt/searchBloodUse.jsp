<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/bloodMgnt/search.js" type="text/javascript"></script>

<div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">献血管理</a>
		        <a>
		          <cite>
                      免费用血
		          </cite>
                </a>
		      </span>
    </div>
</div>
<div class="section">
    <div class="searchBox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">用血者姓名</td>
                    <td class="col-input">
                        <input type="text" name="patientname" style="width:160px;">
                    </td>
                    <td class="col-text">用血者证件类型</td>
                    <td class="col-input">
                        <select name="patientidentitytype" class="x-layui-input"  style="width:160px;">
                           <option value="">请选择</option>
                           <option value="居民身份证">居民身份证</option>
                           <option value="居民户口簿">居民户口簿</option>
                           <option value="护照">护照</option>
                           <option value="军官证">军官证</option>
                           <option value="驾驶证">驾驶证</option>
                           <option value="港涣居民来往内地通行证">港涣居民来往内地通行证</option>
                           <option value="台湾居民来往内地通行证">台湾居民来往内地通行证</option>
                           <option value="港澳台身份证">港澳台身份证</option>
                           <option value="医保卡">医保卡</option>
                           <option value="新农合">新农合</option>
                           <option value="一卡通">一卡通</option>
                           <option value="保险证">保险证</option>
                           <option value="残疾证">残疾证</option>
                           <option value="文职干部证">文职干部证</option>
                           <option value="出生证明">出生证明</option>
                           <option value="儿童保健卡">儿童保健卡</option>
                           <option value="预防接种卡">预防接种卡</option>
                           <option value="其他法定有效证件">其他法定有效证件</option>
                       </select>
                    </td>
                    <td class="col-text">用血者证件号</td>
                    <td class="col-input">
                        <input type="text" name="patientidentityid" style="width:160px;">
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="col-text">用血时间</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date" name="usetime" id="usetime"
                               style="width: 160px;padding-left: 0px;">
                    </td>
                    <td class="col-text">用血医院</td>
                    <td class="col-input">
                        <input type="text" name="hospital" style="width:160px;">
                    </td>
                    <td colspan="2"></td>
                    <td style="text-align: right;">
                        <button class="layui-btn layui-btn-sm"  id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="listDiv">
    </div>
</div>
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#usetime'
            , format: 'yyyy/MM/dd'
            , max: 0
        });
    });

</script>