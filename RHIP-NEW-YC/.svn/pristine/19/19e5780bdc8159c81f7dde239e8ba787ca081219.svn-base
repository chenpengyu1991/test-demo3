<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>
<script type="text/javascript">
	 require(['views/portal/hospitalInfo/add'],function(hospitalInfoAdd){
		 hospitalInfoAdd.load();
	 });
</script>

<form method="post" id="hospitalInfo_form">

<!-- 更新时用到 -->
<input type="hidden" name="id" value="${hospitalInfodetails.id}" id="hosId"/>
<input type="hidden" name="createTime" value="<fmt:formatDate value='${hospitalInfodetails.createTime}' pattern='yyyy/MM/dd'/>" />
<input type="hidden" id="operation"  value="${operation}"/>

<!-- 医院信息 -->
<div class="postcontent">
    <c:if test="${operation =='1' }">
		<div class="toolbar">
				<a href="javascript:void(0)" id="backToSearch" ><b class="fanhui">返回</b></a>
		</div>
    </c:if>

    <c:if test="${operation =='2' }">
			<div class="toolbar">
				<a href="javascript:void(0)" id="backToSearch"><b class="fanhui">返回</b></a>
		        <a href="javascript:void(0);" id="updateHospitalInfo"><b class="baocun">保存</b></a>
		    </div>
	    </c:if>
		
    <c:if test="${operation =='3' }">
			<div class="toolbar">
				<a href="javascript:void(0)" id="backToSearch"><b class="fanhui">返回</b></a>
		        <a href="javascript:void(0);" id="addHospitalInfo"><b class="baocun">保存</b></a>
		    </div>
	</c:if>	
	<div class="postdiv">
	<fieldset>
	<legend>医院信息</legend>
	<table style="width:99%" class="posttable">
        <colgroup >
            <col width="18%" />
            <col width="30%" />
            <col width="18%" />
            <col width="30%" />
        <colgroup>
		<tbody>

			<tr>
				<th><label class="required">序号：</label></th>
				<td>
				<c:if test="${operation !='1' }">
					<tag:numberInput id="orderNum" name="orderNum" value="${hospitalInfodetails.orderNum}" cssClass="width30" reg='{"required":"true"}'/>
				</c:if>
				<c:if test="${operation =='1' }">
					${hospitalInfodetails.orderNum}
				</c:if>	
				</td>
				<th><label>医院编号：</label></th>
				<td>
				<c:if test="${operation !='1' }">
					<input type="text" name="hospitalNo" readonly="readonly" value="${hospitalInfodetails.hospitalNo}"/>
				</c:if>
				<c:if test="${operation =='1' }">
					${hospitalInfodetails.hospitalNo}
				</c:if>	
				</td>
			</tr>
			<tr>
				<th><label>医院名称：</label></th>
				<td>
					<c:if test="${operation !='1' }">
					<input type="text" name="hospitalName" readonly="readonly" value="${hospitalInfodetails.hospitalName}"/>
					</c:if>
					<c:if test="${operation =='1' }">
					${hospitalInfodetails.hospitalName}
					</c:if>
				</td>
				<th><label>医院类别：</label></th>
				<td>
				    <c:if test="${operation !='1' }"> 
					    <input type="text" id="hospitalCategory" name="hospitalCategory" reg='{"maxlength":"30"}'  value="${hospitalInfodetails.hospitalCategory}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.hospitalCategory}
					</c:if>
				</td>
			</tr>
			<tr>
				<th><label>医院等级：</label></th>
				<td>
                    <c:if test="${operation !='1' }">
                        <ehr:dic-list name="hospitalLevel" dicmeta="DM02-02" reg='{"required":"true"}' width="80%;" value="${hospitalInfodetails.hospitalLevel}"/>
                    </c:if>
                    <c:if test="${operation =='1' }">
                        <ehr:dic code="${hospitalInfodetails.hospitalLevel}" dicmeta="DM02-02" />
                    </c:if>
                </td>
                <th><label>医院性质：</label></th>
				<td>
					<c:if test="${operation !='1' }"> 
					      <input type="text" id="hospitalNature" name="hospitalNature" reg='{"maxlength":"30"}'  value="${hospitalInfodetails.hospitalNature}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.hospitalNature}
					</c:if>
				</td>
			</tr>
			<tr>
                <th>机构类别：</th>
                <td>
                    <%--<ehr:dic dicmeta="GBT2182002"  code="${hospitalInfoDTO.organizationType}" />--%>
                    <c:if test="${operation !='1' }">
                        <ehr:dic-list name="organizationType"  reg='{"required":"true"}' dicmeta="GBT2182002"
                                                      value="${hospitalInfodetails.organizationType}"/>
                    </c:if>
                    <c:if test="${operation =='1' }">
                        <ehr:dic code="${hospitalInfodetails.organizationType}" dicmeta="GBT2182002" />
                    </c:if>
                </td>
                <th><label>医院地址：</label></th>
				<td>
                    <%--2014-05-05，刘洋，地址不可修改，如要修改地址请统一在机构里面修改--%>
					<c:if test="${operation !='1' }">
					      <input type="text" id="hospitalAddress" name="hospitalAddress" reg='{"maxlength":"100"}'  value="${hospitalInfodetails.hospitalAddress}"/>
					</c:if>
					<c:if test="${operation =='1' }">
					      ${hospitalInfodetails.hospitalAddress}
					</c:if>
                </td>
			</tr>
			<tr>
				<th><label>所属地区：</label></th>
				<td>
					<c:if test="${operation !='1' }"> 
					      <input type="text" id="belongDistricts" name="belongDistricts" reg='{"maxlength":"50"}'  value="${hospitalInfodetails.belongDistricts}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.belongDistricts}
					</c:if>
				</td>
				<th><label>所在区域：</label></th>
				<td>
					<c:if test="${operation !='1' }"> 
					      <input type="text" id="belongArea" name="belongArea" reg='{"maxlength":"50"}'  value="${hospitalInfodetails.belongArea}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.belongArea}
					</c:if>
				</td>
			</tr>
            <tr>
				<th><label>挂号时间：</label></th>
				<td>
				    <c:if test="${operation !='1' }">
					      <input type="text" id="registrationTime" name="registrationTime" reg='{"maxlength":"50"}'  value="${hospitalInfodetails.registrationTime}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.registrationTime}
					</c:if>
				</td>
				<th><label>就诊时间：</label></th>
				<td>
				    <c:if test="${operation !='1' }"> 
					      <input type="text" id="treatmentTime" name="treatmentTime" reg='{"maxlength":"50"}'  value="${hospitalInfodetails.treatmentTime}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.treatmentTime}
					</c:if>
				</td>
            </tr>
            <tr>
				<th><label>探视时间：</label></th>
				<td>
				    <c:if test="${operation !='1' }"> 
					      <input type="text" id="visitTime" name="visitTime" reg='{"maxlength":"50"}'  value="${hospitalInfodetails.visitTime}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.visitTime}
					</c:if>
				</td>
				<th><label>医院电话：</label></th>
				<td>
				    <c:if test="${operation !='1' }"> 
					      <input type="text" id="hospitalPhone" name="hospitalPhone" reg='{"maxlength":"30","regex":"phone"}'  value="${hospitalInfodetails.hospitalPhone}"/>
					</c:if>                                                   
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.hospitalPhone}
					</c:if>
				</td>
            </tr>
            <tr>
				<th><label>乘车路线：</label></th>
				<td>
					<c:if test="${operation !='1' }"> 
					      <input type="text" id="gettingThere" name="gettingThere" reg='{"maxlength":"100"}'  value="${hospitalInfodetails.gettingThere}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.gettingThere}
					</c:if>
				</td>
				<th><label>医院网址：</label></th>
				<td>
					<c:if test="${operation !='1' }"> 
					      <input type="text" id="hospitalWebsite" name="hospitalWebsite" reg='{"maxlength":"50"}'  value="${hospitalInfodetails.hospitalWebsite}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					      ${hospitalInfodetails.hospitalWebsite}
					</c:if>
				</td>
            </tr>
            <tr>
				<th><label>是否预约挂号医院：</label></th>
				<td>
                    <c:if test="${operation !='1' }"> 
					      <select id="isRegisteredHospital" name="isRegisteredHospital">
					      <c:choose>   
					           <c:when test="${hospitalInfodetails.isRegisteredHospital == '1'}">
					                   <option value="1" selected="selected">是</option>
						               <option value="2" >否</option>
					           </c:when>  
					           <c:when test="${hospitalInfodetails.isRegisteredHospital == '2'}">
					                   <option value="1" >是</option>
						               <option value="2" selected="selected">否</option>
					           </c:when>     
					           <c:otherwise>
					                   <option value="0" selected="selected">请选择</option>
					                   <option value="1" >是</option>
						               <option value="2" >否</option>
                               </c:otherwise>  
					       </c:choose>
						   </select>
					   </c:if>
					   <c:if test="${operation =='1' }"> 
					        <c:choose>   
					           <c:when test="${hospitalInfodetails.isRegisteredHospital == '1'}">
						                                                        是
					           </c:when>  
					           <c:when test="${hospitalInfodetails.isRegisteredHospital == '2'}">
					                                                                        否
					           </c:when>     
					           <c:otherwise>
					                                                                         不详
                               </c:otherwise>  
					       </c:choose>
					   </c:if>
				</td>
            	<ehr:authorize ifAnyGranted="01,39">
				<th>审核状态：</th>
				<td nowrap="nowrap">
					<c:if test="${operation !='1' }"> 
						<ehr:dic-radio id="statusId" dicmeta="LH00008" name="status" code="0,1" value="${hospitalInfodetails.status}"/>
					</c:if>
					<c:if test="${operation =='1' }"> 
					     <ehr:tip><ehr:dic dicmeta="LH00008" code="${hospitalInfodetails.status}" /></ehr:tip>
					</c:if>
				</td>
				</ehr:authorize>
            </tr>
            <tr>
				<th><label>友情提示：</label></th>
				<td colspan="3">
					<c:if test="${operation !='1' }">
					<input type="text" id="tips" name="tips" value="${hospitalInfodetails.tips}"/>
					</c:if>
					<c:if test="${operation =='1' }">
					${hospitalInfodetails.tips}
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	</div>

     <!-- 医院简介 -->
	<div class="postdiv">
		<fieldset>
		<legend>医院简介</legend>
		<table style="width:99%" class="posttable">
			<tbody>
				<tr>
					<td>
					    <c:if test="${operation !='1' }"> 
					          <SCRIPT id=editor type=text/plain> ${hospitalInfodetails.hospitalInfo}
                              </SCRIPT> 
					    </c:if>	
					    <c:if test="${operation =='1' }"> 
					          ${hospitalInfodetails.hospitalInfo}
					    </c:if>	
					</td>
                </tr>
			</tbody>
		</table>
		</fieldset>
	</div>
	
	<!-- 就医指南 -->
	<div class="postdiv">
		<fieldset>
		<legend>就医指南</legend>
		<table style="width:99%" class="posttable">
			<tbody>
				<tr>
					<td>
					    <c:if test="${operation !='1' }"> 
					          <SCRIPT id=editor_guide type=text/plain> ${hospitalInfodetails.guideForMedical}
                              </SCRIPT> 
					    </c:if>	
					    <c:if test="${operation =='1' }"> 
					          ${hospitalInfodetails.guideForMedical}
					    </c:if>	
					</td>
                </tr>
			</tbody>
		</table>
		</fieldset>
	</div>
	
	<!-- 微导诊 -->
	<div class="postdiv">
		<fieldset>
		<legend>微导诊</legend>
		<table style="width:99%" class="posttable">
			<tbody>
				<tr>
					<td>
					    <c:if test="${operation !='1' }"> 
					          <SCRIPT id=editor_microGuide type=text/plain> ${hospitalInfodetails.microGuidance}
                              </SCRIPT> 
					    </c:if>	
					    <c:if test="${operation =='1' }"> 
					          ${hospitalInfodetails.microGuidance}
					    </c:if>	
					</td>
                </tr>
			</tbody>
		</table>
		</fieldset>
	</div>
	
	<!-- 医院图片 -->
	<div class="postdiv">
		<fieldset>
			<legend>医院图片</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 20%" />
					<col style="width: 60%" />
				</colgroup>
				<tr>
					<td></td>
					<td colspan="2">
					<c:if test="${operation !='1' }"> 
					<div id="editRollPic" style="width: 690px;">
						<c:forEach items="${attches}" var="attche" >
							<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
								<c:if test="${attche.imageFlag eq true}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
											src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
										/></a>
									</c:if>
									<c:if test="${attche.imageFlag eq false}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
									</c:if>
									<br />
									<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
							</div>
						</c:forEach>
					</div>
					</c:if>
					<c:if test="${operation =='1' }"> 
					<div id="seeHospitalPic" style="width: 690px;">
						<table>
						<tr>
							<c:forEach items="${attches}" var="attche" varStatus="status">
								<td style="padding: 15px;"><c:if test="${status.index % 4 == 0 && status.index != 0}">
										<tr>
										</tr>
										<td style="padding: 15px;">
									</c:if> 
									<c:if test="${attche.imageFlag eq true}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
											src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
										/></a>
									</c:if>
									<c:if test="${attche.imageFlag eq false}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
									</c:if>
									</td>
							</c:forEach>
						</tr>
					</table>
					</div>
					</c:if>
				</td>
				</tr>
				<c:if test="${operation !='1' }">
				<tr id="HospitalPictr">
					<th align="right">图片：</th>
                    <td><div id="hospitalPictureFile"></div></td>
					<td>
						<span style="color: blue;">注：提供医院样张照片，单张照片请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，图片数量只能为1个</span>
						<span id="activeTips" style="color: blue;"></span>
					</td>
				</tr>
				</c:if>
			</table>
		</fieldset>
	</div>
</div>
</form>

