<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%--报告登记页面--%>
<input type="hidden" name="${namePreFix}id" value="${reportRecord.id}">
<table class="posttable">
	<colgroup>
		<col style="width: 12%; min-width: 50px;" />
		<col style="width: 38%; min-width: 300px;" />
		<col style="width: 12%; min-width: 50px;" />
		<col style="width: 38%; min-width: 300px;" />
	</colgroup>
	<tr>
		<th><label class="required" for="discoveryDate">发现时间</label></th>
		<td colspan="3"><c:choose>
				<c:when test="${namePreFix eq 'reportRecord.'}">
					<input type="text" readonly="readonly" reg="{'required':'true'}" name="${namePreFix}discoveryDate" id="discoveryDate" style="width: 178px;"
						value='<fmt:formatDate value="${reportRecord.discoveryDate}" pattern="yyyy/MM/dd" />' />
				</c:when>
				<c:otherwise>
					<%-- <tag:dateInput reg="{'required':'true'}" name="${namePreFix}discoveryDate" id="discoveryDate" style="width:178px;" onlypast="true" date="${reportRecord.discoveryDate}" /> --%>
					<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="${namePreFix}discoveryDate" id="discoveryDate" value="<fmt:formatDate value='${reportRecord.discoveryDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
				</c:otherwise>
			</c:choose></td>
	</tr>
	<%-- 	--%>
	<c:choose>
		<c:when test="${not empty reportRecord.id }">
			<c:choose>
				<c:when test="${namePreFix eq 'reportRecord.'}">
				</c:when>
				<c:otherwise>
					<tr>
						<th><label class="required" for="infoTypeCode">信息类别</label></th>
						<td><input type="hidden" name="${namePreFix}infoTypeCode" id="infoTypeCodeSel1" value="${reportRecord.infoTypeCode}"> <input type="text" readonly="readonly"
							value='<ehr:dic dicmeta="HSA00006"   code="${reportRecord.infoTypeCode}"></ehr:dic>'>
							&nbsp;&nbsp;<a href="javascript:void(0)" id="addCard1" style="display: none">新增报卡</a>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${namePreFix eq 'reportRecord.'}">
					<input type="hidden" name="${namePreFix}infoTypeCode" id="infoTypeCode" value="${reportRecord.infoTypeCode}">
				</c:when>
				<c:otherwise>
					<tr>
						<th><label class="required" for="infoTypeCode">信息类别</label></th>
						<td><ehr:dic-list defaultval="1" reg="{'required':'true'}" dicmeta="HSA00006" width="178px;" name="${namePreFix}infoTypeCode" id="infoTypeCodeSel" value="${reportRecord.infoTypeCode}"
										  code="2,3,5,6,7,8,9,10"/>
							&nbsp;&nbsp;<a href="javascript:void(0)" id="addCard" style="display: none">新增报卡</a>
						</td><%--uninclude="1,2,3,4,5,6,7,8,10,99" parendcode = 0--%>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<tr>
		<th><label class="required" for="infoContent">信息内容</label></th>
		<td><textarea style="min-width: 500px; height: 120px" class="disabledInfoContent" id="infoContent" name="${namePreFix}infoContent" reg="{'required':'true','maxlength':500}">${reportRecord.infoContent}</textarea></td>
	</tr>
	<tr>
		<th><label class="required">线索类别</label></th>
		<td>
            <c:choose>
            <c:when test="${not empty reportRecord.id and  reportRecord.infoTypeCode eq '5'}">
                 <input type="hidden" name="${namePreFix}illegalFlag"  value="2">否
            </c:when>
                <c:when test="${not empty reportRecord.id and  reportRecord.infoTypeCode eq '7'}">
                    <input type="hidden" name="${namePreFix}illegalFlag"  value="1">是
                </c:when>

                <c:when test="${ inspRecord.inspHealthProfessional eq '7'}">
                    <input type="hidden" name="${namePreFix}illegalFlag"  value="1">是
                </c:when>

                <c:when test="${ inspRecord.inspHealthProfessional eq '5'}">
                    <input type="hidden" name="${namePreFix}illegalFlag"  value="2">否
                </c:when>

            <c:otherwise>

                <ehr:dic-radio reg="{'required':'true'}" name="${namePreFix}illegalFlag" value="${reportRecord.illegalFlag}" dicmeta="WSJD00001"></ehr:dic-radio></td>

    </c:otherwise>
    </c:choose>

	</tr>
	<tr>
		<th><label class="required">接收机构</label></th>
		<td><ehr:org-type-list reg="{'required':'true'}" type="wsjdsfs" value="${reportRecord.receiveOrganization}" name="${namePreFix}receiveOrganization"></ehr:org-type-list></td>
	</tr>
	<tr>
		<th><label class="required" for="createDate">报告时间</label></th>
		<td><input type="text" readonly="readonly" value='<fmt:formatDate  value="${reportRecord.createDate}" pattern="yyyy/MM/dd" />' name="${namePreFix}createDate"></td>
	</tr>
	<tr>
		<th><label class="required" for="createDoctorCode">报告人</label></th>
		<td><input readonly="readonly" type="text" value='<ehr:staff-name staffCode="${reportRecord.createDoctorCode}"></ehr:staff-name>'></td>
	</tr>
</table>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#discoveryDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

   
  });
</script>