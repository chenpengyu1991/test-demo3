<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/mhm/drugEdit.js" type="text/javascript"></script>

<div class="toolbar" style="margin-top: 10px;">
    <!-- <a href="javascript:void(0)" id="returnSearch" ><b class="fanhui">返回</b></a> -->
    <a href="javascript:void(0)" id="returnSearch" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <!-- <a href="javascript:void(0)" id="saveDrug" ><b class="baocun">保存</b></a> -->
    <a href="javascript:void(0)" id="saveDrug"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
   	<c:if test="${not empty mhmDrug.id}">
	<!-- <a href="javascript:void(0)" id="popuHistory" ><b class="jilu">操作记录</b></a> -->
	<a href="javascript:void(0)" id="popuHistory"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe60e;</i>操作记录</button></a>
	</c:if>
    <input type="hidden" id="pageIndex" value="${pageIndex}">
</div>
<br/>
<br/>
<form id="drugEditForm">
	<input type="hidden" id="drugId" name="id" value="${mhmDrug.id}">
	<input type="hidden" name="version" value="${mhmDrug.version}">
    <div class="postcontent contentfixed32">
        <i class="popno">药品维护表单</i>
        <div class="postdiv">
            <fieldset class="layui-elem-field">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 15%;"/>
                        <col style="min-width: 150px; width: 35%;"/>
                        <col style="min-width: 80px; width: 15%;"/>
                        <col style="min-width: 150px; width: 35%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th><label class="required">药品名称</label></th>
                        <td>
                        	<input type="text" id="drugName" name="drugName" value="${mhmDrug.drugName}"
                                   reg='{"maxlength":"50","required":"true"}'/>
                        </td>
                        <th><label class="required">药品剂型</label></th>
                        <td>
                        	<input type="text" id="drugForm" name="drugForm" value="${mhmDrug.drugForm}"
                                   reg='{"maxlength":"20","required":"true"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">单位</label></th>
                        <td>
                        	<input type="text" id="drugUnit" name="drugUnit" value="${mhmDrug.drugUnit}"
                                   reg='{"maxlength":"20","required":"true"}'/>
                        </td>
                        <th><label class="required">单位剂量</label></th>
                        <td>
                        	<input type="text" id="unitMeasure" name="unitMeasure" value="${mhmDrug.unitMeasure}"
                                   reg='{"scale":"2","min":"0.01","max":"10000","required":"true"}'/>
                        </td>
                    </tr>                    
                    <tr>
                        <th><label class="required">每盒数量</label></th>
                        <td>
                        	<input type="text" id="amount" name="amount" value="${mhmDrug.amount}"
                                   reg='{"digits":"true","min":"1","max":"10000","required":"true"}'/>
                        </td>                    
                        <th>药品规格</th>
                        <td>
                        	<label id="specificationsLabel">${mhmDrug.drugSpecifications}</label>
                        	<input type="hidden" id="drugSpecifications" name="drugSpecifications" value="${mhmDrug.drugSpecifications}">
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">单位价格</label></th>
						<td>
							<input type="text" id="unitPrice" name="unitPrice" value="${mhmDrug.unitPrice}"
                                   reg='{"number":"true","scale":"2","min":"0","max":"10000","required":"true"}'/>
                        </td>                     
                        <th><label class="required">药品价格</label></th>
                        <td>
                        	<input type="text" id="drugPrice" name="drugPrice" value="${mhmDrug.drugPrice}"
                                   reg='{"number":"true","scale":"2","min":"0","max":"10000","required":"true"}'/>                        	
                        </td>                     
                    </tr>
                    <tr>
                        <th><label class="required">是否免费药</label></th>
						<td colspan="3">
                        	<ehr:dic-radio name="isFree" dicmeta="PH00001" value="${mhmDrug.isFree}" code="1,2" reg='{"required":"true"}'/>
                        </td>                     
                    </tr>                    
                    </tbody>
                </table>
            </fieldset>
        </div>
    </div>
</form>
