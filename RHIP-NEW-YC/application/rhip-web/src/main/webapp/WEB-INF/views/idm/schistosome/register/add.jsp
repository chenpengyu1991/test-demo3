<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/schregister.js" type="text/javascript"></script>
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
      elem: '#ihaDtId' 
   	   ,format: 'yyyy/MM/dd'
   	, trigger: 'click' 
    });
    laydate.render({
        elem: '#stoolDtId' 
     	   ,format: 'yyyy/MM/dd'
     	, trigger: 'click' 
      });
    laydate.render({
        elem: '#coptDtId' 
     	   ,format: 'yyyy/MM/dd'
     	, trigger: 'click' 
      });
    laydate.render({
        elem: '#ddiaDtId' 
     	   ,format: 'yyyy/MM/dd'
     	, trigger: 'click'
		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#ddiaDtId").removeClass("lose");
			}else{
				$("#ddiaDtId").addClass("lose");
			}
		}
      });
});
</script>
<div class="toolbar" style="margin-top: 8px;">
    <%-- <a href="javascript:void(0)" onclick="javascript:schregister.returnSearch()"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" onclick="javascript:schregister.returnSearch()" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:choose>
        <c:when test="${approveFlag=='1'}">
        	<c:if test="${type == 'add'}">
	            <%--<a href="javascript:void(0)" onclick="schregister.approval(${schistosomeDto.specialStatus})"><b class="tongguo">通过</b></a>--%>
	            <%--<a href="javascript:void(0)" onclick="schregister.approval(2)"><b class="zuofei">排除</b></a>--%>
				<input type="hidden" id="aaa" value="${schistosomeDto.specialStatus}" >
				<%-- <a href="javascript:void(0)" id="sub" onclick="javascript:void(0)"><b class="tijiao">提交</b></a> --%>
				<a href="javascript:void(0)" id="sub" onclick="javascript:void(0)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>通过</button></a>
				<a href="javascript:void(0)" onclick="schregister.approval(2)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe640;</i>排除</button></a>
            </c:if>
            <%-- <a href="javascript:void(0)" onclick="schregister.viewLog(${schistosomeDto.idmId})"><b class="jilu">操作记录</b></a> --%>
            <a href="javascript:void(0)" onclick="schregister.viewLog(${schistosomeDto.idmId})"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe60e;</i>操作记录</button></a>
        </c:when>
        <c:otherwise>
        	<c:if test="${type == 'add'}">
            	<%-- <a href="javascript:void(0)" onclick="javascript:schregister.registerSubmit()"><b class="tijiao">提交</b></a> --%>
            	<a href="javascript:void(0)" onclick="javascript:schregister.registerSubmit()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>通过</button></a>
            </c:if>
         	<c:if test="${type == 'view'}">
            	<%-- <a href="javascript:void(0)" onclick="schregister.viewLog(${schistosomeDto.idmId})"><b class="jilu">操作记录</b></a> --%>
            	<a href="javascript:void(0)" onclick="schregister.viewLog(${schistosomeDto.idmId})"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe60e;</i>操作记录</button></a>
            </c:if>           
        </c:otherwise>
    </c:choose>
</div>

<form id="registerForm">
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" name="singleId" value="${schistosomeDto.singleId}"/>
	<input type="hidden" name="idmId" value="${schistosomeDto.idmId}"/>
	<input type="hidden" id="type" name="type" value="${type}"/>
    <input type="hidden" id="specialStatusId" name="specialStatus" value="${schistosomeDto.specialStatus}"/>
    
    <input type="hidden" name="generalCondition.id" value="${schistosomeDto.generalCondition.id}">
    <input type="hidden" name="labExamine.id" value="${schistosomeDto.labExamine.id}">
    <input type="hidden"  name="caseInformation.id" value="${schistosomeDto.caseInformation.id}"/>	
    <input type="hidden"  name="caseInformation.reportPerson" value="${schistosomeDto.caseInformation.reportPerson}"/>	
    <input type="hidden"  name="caseInformation.reportOrg" value="${schistosomeDto.caseInformation.reportOrg}"/>
	<input type="hidden"  name="caseInformation.reportDate" value="<fmt:formatDate value="${schistosomeDto.caseInformation.reportDate}" pattern="yyyy/MM/dd" />"/>
	
	<input type="hidden"  name="generalCondition.floatPopulation" id="floatPopultationId" value="${schistosomeDto.generalCondition.floatPopulation}"/>
	<input type="hidden"  name="flag" id="flag" value="${flag}"/>
	<input type="hidden" id="logoff" name="logoff" value="${schistosomeDto.logoff}">
    <div class="postcontent">
        <i class="popno">
        	<c:choose>
            	<c:when test="${flag=='Local'}">本地居民血吸虫病监测登记表</c:when>
            	<c:otherwise>暂住人口血吸虫病监测登记表</c:otherwise>
            </c:choose>
        </i>
        <div class="postdiv">
        	<fieldset class="layui-elem-field">
        		<legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 120px; width: 15%;"/>
                        <col style="min-width: 120px; width: 15%;"/>
                        <col style="min-width: 150px; width: 20%;"/>
                        <col style="min-width: 80px; width: 10%;"/>
                        <col style="min-width: 150px; width: 20%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th><label class="required">姓名:</label></th>
                        <td>
                        	
                        	<input type="text" id="nameId" name="generalCondition.name" value="${schistosomeDto.generalCondition.name}" 
                        		style="width: 100px;" reg='{"maxlength":"50","required":"true"}'/>
                        </td>
                       <th>身份证号码:</th>
                        <td>
                        	<input type="text" id="idCard" name="generalCondition.idcard" value="${schistosomeDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                        </td>                     
                        <th>性别:</th>
                        <td>
                        	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${schistosomeDto.generalCondition.gender}"  code="1,2"/>
                        </td>
                    </tr>
					<tr>
                        <th>年龄:</th>
                        <td>
                        	<input type="text" id="age" name="generalCondition.age" value="${schistosomeDto.generalCondition.age}" 
                        		style="width: 100px;" reg='{"digits":"true","maxlength":"20"}'/>
                        </td>
 						<c:choose>
                    		<c:when test="${flag=='Local'}">
		                        <th>标本来源:</th>
		                        <td>
		                        	<ehr:dic-radio name="labExamine.sampleResource" dicmeta="IDM00230" value="${schistosomeDto.labExamine.sampleResource}" code="1,2"/>
		                        </td>
                    		</c:when>
                    		<c:otherwise>
						       	<th><label class="required">就业单位或暂住地址:</label></th>
							       	<td colspan="3">
										<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${schistosomeDto.generalCondition.pahouseNumber}"
							                	reg='{"maxlength":"70" ,"required":"true"}'  style="width: 98%;">
							    </td>
                    		</c:otherwise>
                    	</c:choose>

		       		</tr>
	        		<tr>
		            	<th>
		            	<c:choose>
							<c:when test="${flag=='Local'}"><label class="required">现地址:</label></c:when>
							<c:otherwise><label class="required">户籍地址:</label></c:otherwise>
                    	</c:choose>
		            	</th>
			            <td colspan="5">
			            	<c:choose>
	                    		<c:when test="${flag=='Local'}">
									<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="idmCommon.displayPaAddress"
																 townId="patown_address" villageName="generalCondition.paGroup" streetName="generalCondition.pastreet"
																 townName="generalCondition.patownShip" villageValue="${schistosomeDto.generalCondition.paGroup}" streetValue="${schistosomeDto.generalCondition.pastreet}"
																 townValue="${schistosomeDto.generalCondition.patownShip}" width="180px;" reg='{"required":"true"}'/>
		                            <div>
			                            <label id="tempPaValue">
			                                <ehr:dic code="${schistosomeDto.generalCondition.patownShip}" dicmeta="FS990001"/>
											<ehr:dic code="${schistosomeDto.generalCondition.pastreet}" dicmeta="FS990001"/>
											<ehr:dic code="${schistosomeDto.generalCondition.paGroup}" dicmeta="FS990001"/>
										</label>
			                            <input type="text" id="text_pahouseNumber" name="generalCondition.pahouseNumber" value="${schistosomeDto.generalCondition.pahouseNumber}"
							                	reg='{"maxlength":"50","required":"true"}'  style="width: 180px;">
							         	<span id="spanPaNumber">(门牌号)</span>
						         	</div>
								</c:when>
								<c:otherwise>
									<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${schistosomeDto.generalCondition.hrAddress}"
							                	reg='{"maxlength":"50","required":"true"}'  style="width: 98%;">
								</c:otherwise>			            
							</c:choose>
				        </td>
			     	</tr>
                    <tr>
                        <th>检验日期:</th>
                        <td>
                        	<input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="labExamine.ihaDt" id="ihaDtId" value="<fmt:formatDate value='${schistosomeDto.labExamine.ihaDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
                        	<%-- <tag:dateInput nullToToday="false" id="ihaDtId" name="labExamine.ihaDt" style="width: 100px;"
                        		reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schistosomeDto.labExamine.ihaDt}" onlypast="true"></tag:dateInput> --%>
                        <th>检验结果-IHA:</th>
                        <td colspan="3">
                        	<ehr:dic-radio name="labExamine.ihaCheck" dicmeta="IDM00320" code="1,2"
                                          value="${schistosomeDto.labExamine.ihaCheck}" />
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">检验日期:</label></th>
                        <td>
                        	<input type="text" reg='{"regex":"date","required":"true"}'  class="layui-input x-admin-content-sm-date"  name="labExamine.ddiaDt" id="ddiaDtId" value="<fmt:formatDate value='${schistosomeDto.labExamine.ddiaDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
<%--                         	<tag:dateInput nullToToday="false" id="ddiaDtId" name="labExamine.ddiaDt" style="width: 100px;"
                        		reg='{"regex":"date","required":"true"}'  pattern="yyyy/MM/dd" date="${schistosomeDto.labExamine.ddiaDt}" onlypast="true"></tag:dateInput>
 --%>                        <th><label class="required">检验结果-DDIA:</label></th>
                        <td colspan="3">

                        	<ehr:dic-radio name="labExamine.ddia" id="zhi"   dicmeta="PH00004" code="1,2"
                            	value="${schistosomeDto.labExamine.ddia}" reg='{"required":"true"}'/>

                        </td>
                    </tr>
                    <tr>
                        <th>检验日期:</th>
                        <td>
                        	<input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="labExamine.coptDt" id="coptDtId" value="<fmt:formatDate value='${schistosomeDto.labExamine.coptDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
                        	<%-- <tag:dateInput nullToToday="false" id="coptDtId" name="labExamine.coptDt" style="width: 100px;"
                        		reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schistosomeDto.labExamine.coptDt}" onlypast="true"></tag:dateInput> --%>
                        <th>检验结果-COPT:</th>
                        <td colspan="3">
                        	<ehr:dic-radio name="labExamine.copt" dicmeta="IDM00321" code="1,2"
                                          value="${schistosomeDto.labExamine.copt}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>检验日期:</th>
                        <td>
                        	<input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="labExamine.stoolDt" id="stoolDtId" value="<fmt:formatDate value='${schistosomeDto.labExamine.stoolDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
                        	<%-- <tag:dateInput nullToToday="false" id="stoolDtId" name="labExamine.stoolDt" style="width: 100px;"
                        		reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schistosomeDto.labExamine.stoolDt}" onlypast="true"></tag:dateInput> --%>
                        <th>检验结果-粪检:</th>
                        <td colspan="3">
                        	<ehr:dic-radio name="labExamine.stool" dicmeta="PH00004" code="1,2"
                                          value="${schistosomeDto.labExamine.stool}"/>
                        </td>                        		
                    </tr>                                                            
                    </tbody>
                </table>
            </fieldset>
        </div>
    </div>
</form>
