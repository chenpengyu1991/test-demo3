<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%-- <c:set var="reportInfo" scope="request" value="${diReport}"></c:set> --%>
<%-- <c:set var="index" scope="request" value="0"></c:set> --%>
<input type="hidden" name="report[${index}].id" value="${reportInfo.id}">
<input type="hidden" name="report[${index}].personId" value="${reportInfo.personId}" >
<input type="hidden" name="report[${index}].idCard" value="${reportInfo.idcard}">
<input type="hidden" name="report[${index}].cdmId" value="${reportInfo.cdmId}" >
<input type="hidden" name="report[${index}].reportType" value="${reportInfo.reportType}" />
<input type="hidden" name="report[${index}].dmPersonId" value="${reportInfo.dmPersonId}" />
<%--报卡类型--%>
<input type="hidden" name="report[${index}].disType" value="${reportInfo.disType}" />
<input type="hidden" id="hbpAppIndex" value="${index}"/>
<legend>高血压  <span style="color: #ff0000"><ehr:dic dicmeta="DMD00005" code="${reportInfo.cdmStatusInfo.reportStatus}"></ehr:dic>${reportInfo.reportType =='2' ? ' (死亡报卡)' :''}</span></legend>
<table class="posttable">
  <colgroup>
    <col style="width: 15%;min-width:100px;" />
    <col style="width: 35%;min-width:200px;" />
    <col style="width: 15%;min-width:100px;" />
    <col style="width: 35%;min-width:200px;" />

  </colgroup>
  <c:if test="${allowEdit}">
    <tr>
      <th><label class="required" >高血压类型</label></th>
      <td><ehr:dic-list width="180px;" dicmeta="DMD00006" defaultval="true"  name="report[${index}].hbpType" value="${reportInfo.hbpType}" reg="{'required':true}" uninclude="2"/></td>
      <th><label class="required" >发病日期</label></th>
      <td>
      <%-- <tag:dateInput onlypast="true" id="report${index}-hbpAccidentDate" name="report[${index}].hbpAccidentDate" date="${reportInfo.hbpAccidentDate}"  reg="{'required':true}" /> --%>
      <input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}"  name="report[${index}].hbpAccidentDate" id="report${index}-hbpAccidentDate" value="<fmt:formatDate value='${reportInfo.hbpAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
      </td>
    </tr>
    <tr>
      <th><label class="required"  >诊断日期</label></th>
      <td style="vertical-align:top;">
      <%-- <tag:dateInput onlypast="true"  name="report[${index}].hbpDiagnosisDate" date="${reportInfo.hbpDiagnosisDate}" reg="{'required':true,'greaterThan':'report${index}-hbpAccidentDate'}"  /> --%>
      <input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true,'greaterThan':'report${index}-hbpAccidentDate'}"  name="report[${index}].hbpDiagnosisDate" id="reportCardAppHbpDiagnosisDateId" value="<fmt:formatDate value='${reportInfo.hbpDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
      </td>
      <th><label >诊断依据</label></th>
      <td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010"  name="report[${index}].hbpDiagnosisDepends" value="${reportInfo.hbpDiagnosisDepends}" reg="{'maxlength':33}" /></td>
    </tr>
    <tr>
      <th></th>
      <td colspan="3">
          <c:forEach items="${attchesHbp}" var="attche" varStatus="status">
            <c:if test="${attche.resourceId eq reportInfo.id}">
                <div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
                  <c:if test="${attche.imageFlag eq true}">
                    <a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1">
                      <img alt="点击查看大图" title="点击查看大图" src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"/>
                    </a>
                  </c:if>
                  <c:if test="${attche.imageFlag eq false}">
                    <a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
                  </c:if>
                  <br />
                <%--<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>--%>
              </div>
            </c:if>
        </c:forEach>
      </td>
    </tr>
    <%--<tr style="margin-top:10px;">
      <th><label class="required">高血压附件</label></th>
      <td colspan="3">
        <div id="cdmCardHyperFile"></div>
        <span style="color: blue;">注：单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改),附件数量不能超过5个</span>
      </td>
    </tr>--%>
    <%-- <tr>
      <th>ICD-10编码</th>
      <td><input type="text" name="report[${index}].hbpIcdTenCode" value="${reportInfo.hbpIcdTenCode}" readonly="readonly"/></td>
    </tr> --%>
  </c:if>
  <c:if test="${false==allowEdit}">
    <tr>
      <th><label >高血压类型</label></th>
      <td><ehr:dic dicmeta="DMD00006" code="${reportInfo.hbpType}" /></td>
      <th><label >发病日期</label></th>
      <td><input type="text" value='<fmt:formatDate value="${reportInfo.hbpAccidentDate}" pattern="yyyy/MM/dd" />' readonly="readonly" /></td>
    </tr>
    <tr>
      <th><label >诊断日期</label></th>
      <td style="vertical-align:top;"><input type="text" value='<fmt:formatDate value="${reportInfo.hbpDiagnosisDate}" pattern="yyyy/MM/dd" />' readonly="readonly" /></td>
      <th><label >诊断依据</label></th>
      <td><ehr:dic dicmeta="DMD00010" code="${reportInfo.hbpDiagnosisDepends}"  /></td>
    </tr>
   <%--  <tr style="display:<c:if test="${attchesHbpShow ne '是'}">none;</c:if>">
      <th><label>高血压附件</label></th>
      <td colspan="3">
        <div style="width: 690px;">
          <c:forEach items="${attchesHbp}" var="attche" >
            <c:if test="${attche.resourceId eq reportInfo.id}">
              <div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
                <c:if test="${attche.imageFlag eq true}">
                  <a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1">
                    <img src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2" alt="点击查看大图" title="点击查看大图"/>
                  </a>
                </c:if>
                <c:if test="${attche.imageFlag eq false}">
                  <a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.fileName}</a>
                </c:if>
                <br />
              </div>
            </c:if>
          </c:forEach>
        </div>
      </td>
    </tr> --%>
    <%-- <tr>
      <th>ICD-10编码</th>
      <td>${reportInfo.hbpIcdTenCode}</td>
    </tr> --%>
  </c:if>
  <jsp:include page="inputInfo.jsp"></jsp:include>

</table>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    var hbpIndex = ${index};
    laydate.render({
        elem: '#report' + hbpIndex + "-hbpAccidentDate"
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  	, trigger: 'click'
      });
    
    laydate.render({
      elem: '#reportCardAppHbpDiagnosisDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
     	, trigger: 'click'
    });

  });
</script>
