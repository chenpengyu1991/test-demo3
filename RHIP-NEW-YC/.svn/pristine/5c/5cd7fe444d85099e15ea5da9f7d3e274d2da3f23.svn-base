<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%--报告登记页面--%>
<table class="posttable">
	<colgroup>
		<col style="width: 12%; min-width: 50px;" />
		<col style="width: 38%; min-width: 300px;" />
		<col style="width: 12%; min-width: 50px;" />
		<col style="width: 38%; min-width: 300px;" />
	</colgroup>
	<c:choose>
		<c:when test="${reportRecord.status eq '1'}">
			<tr>
				<th>接收状态</th>
				<td>未接收</td>
				<td colspan="2"></td>
			</tr>
		</c:when>
		<c:when test="${reportRecord.status eq '2'}">
			<tr>
				<th>接收状态</th>
				<td>已接收</td>
				<td colspan="2"></td>
			</tr>
				<tr>
				<th><label class="required">接收时间</label></th>
				<td><%-- <tag:dateInput name="receiveDate" date="${reportRecord.receiveDate }"  reg="{'required':'true'}"></tag:dateInput> --%>
				<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="receiveDate" id="receiveDateId" value="<fmt:formatDate value='${reportRecord.receiveDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<td colspan="2"></td>
			</tr>
		</c:when>
		<c:when test="${reportRecord.status eq '3'}">
			</tr>
				<tr>
				<th><label class="required">接收时间</label></th>
				<td><%-- <tag:dateInput name="receiveDate" date="${reportRecord.receiveDate }"  reg="{'required':'true'}"></tag:dateInput> --%>
				<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="receiveDate" id="receiveDateId" value="<fmt:formatDate value='${reportRecord.receiveDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
						<th><label class="required">处理时间</label></th>
						<td><%-- <tag:dateInput date="${reportRecord.dealDate }" name="dealDate" reg="{'required':'true'}"></tag:dateInput> --%>
						<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="dealDate" id="dealDateId" value="<fmt:formatDate value='${reportRecord.dealDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
						<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required" for="dealAdvice">处理意见</label></th>
				<td><textarea style="min-width: 500px; height: 120px" class="disabledInfoContent" id="dealAdvice" name="dealAdvice"
						reg="{'required':'true','maxlength':200}"
					>${reportRecord.dealAdvice}</textarea></td>
					<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required">回访</label></th>
				<td><ehr:dic-radio reg="{'required':'true'}" name="visitFlag" value="${reportRecord.visitFlag}" dicmeta="FS10246"></ehr:dic-radio></td>
				<td colspan="2"></td>
			</tr>
		</c:when>
		<c:when test="${reportRecord.status eq '4'}">
		</tr>
				<tr>
				<th><label class="required">接收时间</label></th>
				<td><%-- <tag:dateInput name="receiveDate" date="${reportRecord.receiveDate }"  reg="{'required':'true'}"></tag:dateInput> --%>
				<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="receiveDate" id="receiveDateId" value="<fmt:formatDate value='${reportRecord.receiveDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required">处理时间</label></th>
				<td><%-- <tag:dateInput name="dealDate" date="${reportRecord.dealDate }"  reg="{'required':'true'}"></tag:dateInput> --%>
				<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="dealDate" id="dealDateId" value="<fmt:formatDate value='${reportRecord.dealDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required" for="dealAdvice">处理意见</label></th>
				<td><textarea style="min-width: 500px; height: 120px" class="disabledInfoContent" id="dealAdvice" name="dealAdvice"
						reg="{'required':'true','maxlength':200}"
					>${reportRecord.dealAdvice}</textarea></td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required">回访</label></th>
				<td><ehr:dic-radio reg="{'required':'true'}" name="visitFlag" value="${reportRecord.visitFlag}" dicmeta="FS10246"></ehr:dic-radio></td>
				<td colspan="2"></td>
			</tr>
		</c:when>
		<c:when test="${reportRecord.status eq '5'}">
		</tr>
				<tr>
				<th><label class="required">接收时间</label></th>
				<td><%-- <tag:dateInput name="receiveDate" date="${reportRecord.receiveDate }"  reg="{'required':'true'}"></tag:dateInput> --%>
				<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="receiveDate" id="receiveDateId" value="<fmt:formatDate value='${reportRecord.receiveDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required">处理时间</label></th>
				<td><%-- <tag:dateInput name="dealDate" date="${reportRecord.dealDate }"  reg="{'required':'true'}"></tag:dateInput> --%>
				<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="dealDate" id="dealDateId" value="<fmt:formatDate value='${reportRecord.dealDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required" for="dealAdvice">处理意见</label></th>
				<td><textarea style="min-width: 500px; height: 120px" class="disabledInfoContent" id="dealAdvice" name="dealAdvice"
						reg="{'required':'true','maxlength':200}"
					>${reportRecord.dealAdvice}</textarea></td>
			<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required">回访时间</label></th>
				<td><%-- <tag:dateInput name="visitDate" date="${reportRecord.visitDate }"  reg="{'required':'true'}"></tag:dateInput> --%>
				<input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="visitDate" id="visitDateId" value="<fmt:formatDate value='${reportRecord.visitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th><label class="required" for="visitAdvice">回访意见</label></th>
				<td><textarea style="min-width: 500px; height: 120px" class="disabledInfoContent" id="visitAdvice" name="visitAdvice"
						reg="{'required':'true','maxlength':200}"
					>${reportRecord.visitAdvice}</textarea></td>
				<td colspan="2"></td>
			</tr>
		</c:when>
	</c:choose>
</table>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#receiveDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click'
    });
    
    
    laydate.render({
        elem: '#dealDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });
    
    
    laydate.render({
        elem: '#visitDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });
    
    
   
  });
</script>