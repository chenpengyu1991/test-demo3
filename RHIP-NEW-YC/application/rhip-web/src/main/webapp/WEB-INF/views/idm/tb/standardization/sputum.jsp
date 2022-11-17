<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
    function onDatePickerChanged(dp){
        $(this).trigger("onDatePickerChanged");
        sputum.getDelayDays(this);
    }
</script>
<div class="toolbar">
    <%-- <a href="javascript:void(0)" onclick="javascript:tbCommon.returnSearch('standardization.searchTemp')"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" onclick="javascript:tbCommon.returnSearch('standardization.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${logoff !=1 }">
    	<%-- <a href="javascript:void(0)" onclick="javascript:sputum.saveSputum(${singleId})"><b class="baocun">保存</b></a> --%>
    	<a href="javascript:void(0)" onclick="javascript:sputum.saveSputum(${singleId})" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</c:if>
</div>
<form id="sputumForm">
</form>
<div class="repeattable">
	<table id="sputumTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:20%;"/>
			<col style="width:20%;"/>
	        <col style="width:20%;"/>
			<col style="width:40%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>预约日期</th>	
				<th>送检日期</th>
				<th>延迟天数</th>
				<th>痰检结果项</th>
			</tr>
		</thead>
		<tbody>
        <c:forEach var="listAs" items="${listAs}" varStatus="status">
            <tr id="${listAs.monthSeq}">
                <td field="sputumDt" style="text-align: center"><fmt:formatDate pattern="yyyy/MM/dd" value="${listAs.sputumDt}"/></td>
                <td style="text-align: center">
                    <%--<tag:dateInput name="inspectDt" onlypast="true" date="${listAs.inspectDt}"/>--%>
                    <input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="inspectDt" id="inspectDt${status.index}" value="<fmt:formatDate value='${listAs.inspectDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
                    <input type="hidden" name="id" value="${listAs.id}"/>
                    <input type="hidden" name="createUnit" value="${listAs.createUnit}"/>
                    <input type="hidden" name="createDt" value="<fmt:formatDate pattern="yyyy/MM/dd" value="${listAs.createDt}"/>"/>
                    <input type="hidden" name="createUser" value="${listAs.createUser}"/>
                </td>
                <td style="text-align: center"><input type="text" name="delayDays" readonly="true" style="width: 40px;" value="${listAs.delayDays}"></td>
                <td style="text-align: center">
                    <ehr:dic-radio name="sputumResult${listAs.monthSeq}" dicmeta="CV0300404" code="2,3" value="${listAs.sputumResult}" />
                </td>
            </tr>
        </c:forEach>

        <%--2月结果未填写--%>
        <%--<c:if test="${setAble == 1}">
            <c:forEach var="listAs" items="${listAs}" varStatus="status">
                <tr flag="1" id="2">
                    <td style="text-align: center" field="sputumDt"><fmt:formatDate pattern="yyyy/MM/dd" value="${listAs.sputumDt}"/></td>
                    <td style="text-align: center"><tag:dateInput name="inspectDt" onlypast="true" date="${listAs.inspectDt}"/></td>
                    <td style="text-align: center"><input type="text" name="delayDays" readonly="true" style="width: 40px;" value="${listAs.delayDays}"></td>
                    <td style="text-align: center">
                        <ehr:dic-radio name="sputumResult2" dicmeta="CV0300404" code="2,3" value="${listAs.sputumResult}" onchange="sputum.selectRows(${thisType},this)"/></td>
                </tr>
            </c:forEach>
            <tr id="3" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon3}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult3" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
            <tr id="5" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon5}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult5" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
            <tr id="6" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon6}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult6" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
            <tr id="8" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon8}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult8" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
        </c:if>
        &lt;%&ndash;2月结果已填写，下次检查结果未填写&ndash;%&gt;
        <c:if test="${setAble == 2}">
            <c:forEach var="listAs" items="${listAs}" varStatus="status">
                <c:if test="${status.index == 0}">
                    <tr flag="1" id="${listAs.monthSeq}">
                        <td style="text-align: center" field="sputumDt"><fmt:formatDate pattern="yyyy/MM/dd" value="${listAs.sputumDt}"/></td>
                        <td style="text-align: center"><tag:dateInput name="inspectDt" onlypast="true" date="${listAs.inspectDt}"/></td>
                        <td style="text-align: center"><input type="text" name="delayDays" readonly="true" style="width: 40px;" value="${listAs.delayDays}"></td>
                        <td style="text-align: center">
                            <ehr:dic-radio name="sputumResult${listAs.monthSeq}" dicmeta="CV0300404" code="2,3" value="${listAs.sputumResult}" onchange="sputum.selectRows(${thisType},this,'rm')"/></td>
                    </tr>
                </c:if>
                <c:if test="${status.index != 0}">
                    <tr flag="1" rm='rm' id="${listAs.monthSeq}">
                        <td style="text-align: center" field="sputumDt"><fmt:formatDate pattern="yyyy/MM/dd" value="${listAs.sputumDt}"/></td>
                        <td style="text-align: center"><tag:dateInput name="inspectDt" onlypast="true" date="${listAs.inspectDt}"/></td>
                        <td style="text-align: center"><input type="text" name="delayDays" readonly="true" style="width: 40px;" value="${listAs.delayDays}"></td>
                        <td style="text-align: center">
                            <ehr:dic-radio name="sputumResult${listAs.monthSeq}" dicmeta="CV0300404" code="2,3" value="${listAs.sputumResult}"/></td>
                    </tr>
                </c:if>
            </c:forEach>
            <tr id="3" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon3}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult3" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
            <tr id="5" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon5}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult5" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
            <tr id="6" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon6}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult6" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
            <tr id="8" flag="" style="display: none; text-align: center">
                <td field="sputumDt">${mon8}</td>
                <td field="inspectDt"><tag:dateInput name="inspectDt" onlypast="true" /></td>
                <td field="delayDays"><input type="text" name="delayDays" readonly="true" style="width: 40px;"></td>
                <td field="sputumResult"><ehr:dic-radio name="sputumResult8" dicmeta="CV0300404" code="2,3" /></td>
            </tr>
        </c:if>--%>
		</tbody>
	</table>
</div>

<script type="text/javascript">
    var size = "${fn:length(listAs)}";
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        for(var i = 0; i < size; i++) {
            var dateId = 'inspectDt' + i;
            laydate.render({
                elem: '#'+dateId
                , format: 'yyyy/MM/dd'
                , max: 0
                , trigger: 'click'
            });
        }

    });

</script>
