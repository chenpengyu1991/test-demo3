<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 12%;" />
				<col style="width: 38%;" />
				<col style="width: 12%;" />
				<col style="width: 38%;" />
			</colgroup>
			<tr>
				<th><label class="required" for="inspDate">巡查日期</label></th>
				<td><%-- <tag:dateInput nullToToday="true" onlypast="true" name="inspDate" id="inspDate" date="${inspRecord.inspDate}" reg="{'required':true}" /> --%>
				<input type="text" class="layui-input x-admin-content-sm-date"  name="inspDate" id="inspDate" value="<fmt:formatDate value='${inspRecord.inspDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<th><label class="required" for="inspPersonName">巡查人</label></th>
				<td>	<ehr:staff-list  reg='{"required":true,"compare":["hsa-insprecord-secinsppersoncode","ne","不能选择相同的巡查人"]}' style="width:120px;" id="hsa-insprecord-insppersoncode" value="${inspRecord.inspPersonCode}" name="inspPersonCode"></ehr:staff-list> <ehr:staff-list  style="width:120px;"  value="${inspRecord.secInspPersonCode}" reg='{"compare":["hsa-insprecord-insppersoncode","ne","不能选择相同的巡查人"]}' id="hsa-insprecord-secinsppersoncode"  name="secInspPersonCode"></ehr:staff-list></td>
			</tr>
			<tr>
				<th><label for="remark">备注</label></th>
				<td colspan="3"><input type="text" id="remark" name="remark" value="${inspRecord.remark}" reg="{'maxlength':40}"></input></td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
			</colgroup>
			<tr>
				<th><label for="isGuide">是否巡查指导</label></th>
				<td><ehr:dic-radio dicmeta="FS10246" name="isGuide" id="isGuide" value="${inspRecord.isGuide!=null?inspRecord.isGuide:'2'}" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv  ${inspRecord.isGuide ==1? '':'hide'}" id="hsa-guide-content">
	<jsp:include page="locationInspGuide.jsp"></jsp:include>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
			</colgroup>
			<tr>
				<th><label for="isReport">是否报告登记</label></th>
				<td><ehr:dic-radio dicmeta="FS10246" name="isReport" id="isReport" value="${inspRecord.isReport!=null?inspRecord.isReport:'2'}" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv ${inspRecord.isReport ==1? '':'hide'}" id="hsa-report-record-content">
	<fieldset class="layui-elem-field">
		<legend>报告登记</legend>
		<c:set var="reportRecord" value="${inspRecord.reportRecord}" scope="request"></c:set>
		<c:set var="namePreFix" value="reportRecord." scope="request"></c:set>
		<jsp:include page="../../reportRecord/add/reportRecordInput.jsp"></jsp:include>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
			</colgroup>
			<tr>
				<th><label class="required" for="findMainPro">发现主要问题</label></th>
				<td colspan="3">
				<textarea id="findMainPro" rows="5"  name="findMainPro" reg="{'required':true,'maxlength':500}" style="width: 98%;">${inspRecord.findMainPro}</textarea>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
	<table class="posttable">
			<colgroup>
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
			</colgroup>
		<tr>
			<th><label class="required" for="inspectionRecord">巡查笔录</label></th>
				<td colspan="3">
				<textarea id="inspectionRecord" rows="5"  name="inspectionRecord" reg="{'required':true,'maxlength':500}" style="width: 98%;">${inspRecord.inspectionRecord}</textarea>
			</td>
		</tr>
		<tr>
						<th></th>
						<td colspan="3">
							<div style="width: 960px;">
								<c:forEach items="${attchesHbp}" var="attche" >
									<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
										<c:if test="${attche.imageFlag eq true}">
											<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}">
												<img alt="点击查看大图" title="点击查看大图" src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"/>
											</a>
										</c:if>
										<c:if test="${attche.imageFlag eq false}">
											<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
										</c:if>
										<br />
										<c:if test="${'add' eq flag||'modify' eq flag}"><a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a></c:if>
									</div>
								</c:forEach>
							</div>
						</td>
					</tr>
		<c:if test="${'add' eq flag||'modify' eq flag}">
			<tr>
				<th align="right">附件</th>
				<td><div id="linkInspFile"></div></td>
				<td colspan="2">
					<span style="color: blue;">注：提供机构样张照片，单张照片请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，图片数量不能超过1个</span>
					<span id="activeTips" style="color: blue;"></span>
				</td>
			</tr>
		</c:if>
	 	</table>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
	<table class="posttable">
			<colgroup>
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
			</colgroup>
		<tr>
			<th><label class="required" for="healthSupervisionOpinion">卫生监督意见书</label></th>
				<td colspan="3">
				<textarea id="healthSupervisionOpinion" rows="5"  name="healthSupervisionOpinion" reg="{'required':true,'maxlength':500}" style="width: 98%;">${inspRecord.healthSupervisionOpinion}</textarea>
			</td>
		</tr>
		<tr>
						<th></th>
						<td colspan="3">
							<div style="width: 960px;">
								<c:forEach items="${attchesHso}" var="attche" >
									<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
										<c:if test="${attche.imageFlag eq true}">
											<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
																																					   src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}?type=2"
													/></a>
										</c:if>
										<c:if test="${attche.imageFlag eq false}">
											<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
										</c:if>
										<br />
										<c:if test="${'add' eq flag||'modify' eq flag}"><a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a></c:if>
									</div>
								</c:forEach>
							</div>
						</td>
					</tr>
		<c:if test="${'add' eq flag||'modify' eq flag}">
			<tr>
				<th align="right">附件</th>
				<td><div id="linkHsoFile"></div></td>
				<td colspan="2">
					<span style="color: blue;">注：提供机构样张照片，单张照片请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，图片数量不能超过1个</span>
					<span id="activeTips" style="color: blue;"></span>
				</td>
			</tr>
		</c:if>
	 	</table>
	</fieldset>
</div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
      elem: '#inspDate'
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });


  });
</script>