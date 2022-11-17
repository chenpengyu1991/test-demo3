<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ehr/person/list.js" type="text/javascript"></script>

<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>"/>
<c:set var="ZXJKDN" value="<%=RoleType.ZXJKDN.getValue()%>"/>
<c:set var="ZJKDN" value="<%=RoleType.ZJKDN.getValue()%>"/>
<div class="section" id="top_all">
	<div class="toolbar">
	 	<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">居民健康档案</a>
	        <a>
          <cite>${empty urlFromPhysicalExam?'个人档案':'健康体检'}</cite></a>
      	</span>
    	</div>
	  </div>
	<p id="cert_message" class="msgError" style="display: none;"></p>
	<p id="cert_message_type" style="display: none;"></p>
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" value="${currentLoginInfo.organization.genreCode}" id="currentAreaCode"/>
		<input type="hidden" value="${urlFromPhysicalExam}" name="urlFromPhysicalExam" id="urlFromPhysicalExam"/>
		<form method="post" id="form_search">
			<table id="reportSearch">
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 25%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 22%;"/>
                    <col style="min-width:60px; width: 10%;"/>
                    <col style="min-width:160px; width: 22%;"/>
				</colgroup>	
				<tbody>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput">
                            <input type="text" name="personName" id="personName" style="width: 60%" class="x-layui-input"/>
                            <input type="checkbox" name="likeFlag" value="like"/>模糊
                        </td>
                        <td class="coltext">年龄段</td>
                        <td class="colinput">
                            <tag:numberInput name="beginAge" id="beginAge" cssClass="x-layui-input" style="width : 38%"/> ~
                            <tag:numberInput name="endAge" id="endAge" cssClass="x-layui-input" style="width : 38%"/>
                        </td>
                        <td class="coltext">性别</td>
                        <td class="colinput">
                            <ehr:dic-list dicmeta="GBT226112003" name="genderCode" width="80%"/>
                        </td>
                    </tr>
					<tr>
                        <td class="coltext">身份证号</td>
                        <td class="colinput">
<!--                         	<input type="text" name="idCard" id="idCard" style="width: 200px;ime-mode:Disabled;width: 80%"/> -->
                        	<tag:idcardInput name="idCard" id="search_idcard" style="width: 80%" cssClass="x-layui-input" ></tag:idcardInput>
							<input type="button" value="读卡" id="button_read" onclick="new Device().startFun('text_idcard','per_search_btn');" class="x-layui-input" style="width: 40px;">
                        </td>
                        <td class="coltext">管理时间</td>
						<td class="colinput">
							<input type="text" class="layui-input x-admin-sm-date"  name="createBeginDate" id="createBeginDate" style="padding-left: 0px;width: 38%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="createEndDate" id="createEndDate"  style="padding-left: 0px;width: 38%;"/>
							<%-- <tag:dateInput name="createBeginDate" id="createBeginDate" onlypast="true" style="width: 40%;"/> ~
							<tag:dateInput name="createEndDate" id="createEndDate" onlypast="true" style="width: 40%;"/> --%>
						</td>

						<c:choose>
							<%--如果从健康体检菜单点进来 档案状态写死为 已建档--%>
							<c:when test="${not empty urlFromPhysicalExam}">
								<input type="hidden" value="1" name="filingFlag"/>
								<td class="coltext">体检时间</td>
								<td class="colinput">
									<input type="text" class="layui-input x-admin-sm-date"  name="personPhyExamStartDate" id="personPhyExamStartDate" style="padding-left: 0px;width: 38%;" />~
									<input type="text" class="layui-input x-admin-sm-date"  name="personPhyExamEndDate" id="personPhyExamEndDate"  style="padding-left: 0px;width: 38%;"/>
								</td>
							</c:when>
							<c:otherwise>
								<td class="coltext">档案状态</td>
								<td class="colinput">
									<select name="filingFlag" style="width: 80%;">
										<option value="1">已建档 </option>
										<option value="5">待迁入</option>
										<option value="6">待迁入</option>
										<option value="0">未建档</option>
											<%--<option value="2">审核中</option>--%>
											<%--<option value="3">已退回</option>--%>
										<option value="9">已结案</option>
										<option value="4">无身份证</option>
									</select>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<c:choose>
						<c:when test="${not empty urlFromPhysicalExam}">
							<tr class="tjAdvanceSearchSection" style="display: none;">
								<td class="coltext">管理机构</td>
								<td class="colinput">
									<ehr:authorize ifAnyGranted="${ZXJKDN}">
										<ehr:dic-org-list id="nowAddressCode" name="orgCode" defaultval="N" width="80%" isShowOneself="true"/>
									</ehr:authorize>
									<ehr:authorize ifAnyGranted="${ZJKDN}">
										<ehr:dic-org-list id="nowAddressCode" name="orgCode" defaultval="N" width="80%" isShowOneself="true"/>
									</ehr:authorize>
								</td>
								<td class="coltext">体检录入时间</td>
								<td class="colinput">
									<input type="text" class="layui-input x-admin-sm-date" name="tjBeginDate" id="tjBeginDate" style="padding-left: 0px;width: 38%;" /> ~
									<input type="text" class="layui-input x-admin-sm-date" name="tjEndDate" id="tjEndDate" style="padding-left: 0px;width: 38%;" />
								</td>
								<!-- <td class="coltext">打印体检按编号</td>
								<td class="colinput">
									<input type="text" class="layui-input x-admin-sm-date" name="tjbh" id="tjbh" style="padding-left: 0px;width: 80%;" />
								</td> -->
							</tr>
						</c:when>
						<c:otherwise>
							<tr class="advanceSearchSection" style="display: none;">
								<td class="coltext">常住类型</td>
								<td class="colinput">
									<label><input type="radio" name="householdType" value="-1" id="householdType" checked="checked" />&nbsp;全部&nbsp;&nbsp;</label>
									<ehr:dic-radio dicmeta="FS10005" name="householdType" code="1,2,4"></ehr:dic-radio>
								</td>
								<td class="coltext">常住地址</td>
								<td class="colinput">
									<input type="text" name="paAddress" id="paAddress" class="x-layui-input" style="width: 80%"/>
								</td>
								<td class="coltext">更新时间</td>
								<td class="colinput">
									<input type="text" class="layui-input x-admin-sm-date" name="updateBeginDate" id="updateBeginDate" style="padding-left: 0px;width: 38%;" /> ~
									<input type="text" class="layui-input x-admin-sm-date" name="updateEndDate" id="updateEndDate" style="padding-left: 0px;width: 38%;" />
										<%-- <tag:dateInput name="updateBeginDate" id="updateBeginDate" onlypast="true" style="width: 40%;"/> ~
                                        <tag:dateInput name="updateEndDate" id="updateEndDate" onlypast="true" style="width: 40%;"/> --%>
								</td>

							</tr>
							<tr class="advanceSearchSection" style="display: none;">
								<td class="coltext">档案星级</td>
								<td class="colinput">
									<label><input type="radio" name="starType" value="-1" id="starType" checked="checked"/> 全部</label>
									<label><input type="radio" name="starType" value="0" id="starType" /> 零星 </label>
									<label><input type="radio" name="starType" value="1" id="starType" /> 一星 </label>
									<label><input type="radio" name="starType" value="2" id="starType" /> 二星 </label>
									<label><input type="radio" name="starType" value="3" id="starType"/> 三星 </label>
								</td>
								<td class="coltext">管理机构</td>
								<td class="colinput">
									<ehr:authorize ifAnyGranted="${ZXJKDN}">
										<ehr:dic-org-list id="nowAddressCode" name="orgCode" defaultval="N" width="80%" isShowOneself="true"/>
									</ehr:authorize>
									<ehr:authorize ifAnyGranted="${ZJKDN}">
										<ehr:dic-org-list id="nowAddressCode" name="orgCode" defaultval="N" width="80%" isShowOneself="true"/>
									</ehr:authorize>
								</td>
								<ehr:authorize ifAnyGranted="${ZXJKDN},${ZJKDN}">
									<td class="coltext" >管理医生</td>
									<td>
										<ehr:staff-list reg='{"required":true}' name="inputerId" defaultval="N" ></ehr:staff-list>
									</td>
								</ehr:authorize>
							</tr>
							<tr class="advanceSearchSection" style="display: none;">
								<td class="coltext">户籍居委会</td>
								<td class="colinput">
									<ehr:dic-town-street-village townName="hrtownShip" streetName="hrstreet" villageName="hrGroup" width="33%"/>
								</td>
								<td class="coltext">是否动态管理</td>
								<td class="colinput">
									<select name="dynamicRecord" style="width: 242px;">
										<option value="">请选择</option>
										<option value="0">否</option>
										<option value="1">是</option>
									</select>
								</td>
								<td class="coltext">人群分类</td>
								<td class="colinput">
									<ehr:dic-list width="156px" type="true"  id="groupClassification" name="groupClassification" dicmeta="FDS007" />
										<%--<select name="groupClassification" >--%>
										<%--<option value="">请选择</option>--%>
										<%--<option value="1">普通人群</option>--%>
										<%--<option value="2">儿童</option>--%>
										<%--<option value="3">老年人</option> --%>
										<%--<option value="4">孕产妇</option> --%>
										<%--<option value="5">高血压患者</option> --%>
										<%--<option value="6">糖尿病患者</option>--%>
										<%--<option value="7">传染病</option>--%>
										<%--<option value="8">肺结核</option>--%>
										<%--<option value="9">精神障碍患者</option>--%>

										<%--</select>--%>
								</td>
							</tr>
							<tr class="advanceSearchSection" style="display: none;">
								<td class="coltext">贫困人口</td>
								<td class="colinput">
									<label><input  type="radio" onclick="util.clickHideTexts(this,'quitDrinkAgeDescs')"  name="poverty" checked="checked" value="-1"/> 全部</label>
									<label><input  type="radio" onclick="util.clickHideTexts(this,'quitDrinkAgeDescs')"  name="poverty"  value="1"/> 否</label>
									<label><input type="radio" id="povertys" onclick="util.clickShowTexts(this,'quitDrinkAgeDescs')" name="poverty"  value="2"/>是</label>
									<span id="quitDrinkAgeDescs" class="hidediv"><ehr:dic-list width=" 42%" reg="{'required':true}" id="povertyTypes" name="povertyType" dicmeta="FS990024"></ehr:dic-list>
							</span>
								</td>
								<td class="coltext">残疾人口</td>
								<td class="colinput">
									<label><input  type="radio" onclick="util.clickHideTexts(this,'disabledDescs')"  name="disabled" checked="checked" value="-1"/> 全部</label>
									<label><input  type="radio" onclick="util.clickHideTexts(this,'disabledDescs')"  name="disabled"  value="1"/> 否</label>
									<label><input type="radio" id="disableds" onclick="util.clickShowTexts(this,'disabledDescs')" name="disabled"  value="2"/>是</label>
									<span class="hidediv" id="disabledDescs"><ehr:dic-list width=" 40%" reg="{'required':true}" id="veryPovertyTypes" name="veryPovertyType" dicmeta="FS990025"></ehr:dic-list>
								</span>
								</td>
								<td class="coltext">计生特困</td>
								<td class="colinput">
									<label><input  type="radio"  name="veryPoverty" checked="checked" value="-1"/> 全部</label>
									<label><input  type="radio"   name="veryPoverty" value="1"/> 否</label>
									<label><input type="radio"  name="veryPoverty"  value="2"/>是</label>
								</td>
								<td></td>
							</tr>
							<tr class="advanceSearchSection" style="display: none;">
								<td class="coltext">现住居委会</td>
								<td class="colinput">
									<ehr:dic-town-street-village townName="patownShip" streetName="pastreet" width="50%"/>
								</td>
								<td class="coltext">是否体检</td>
								<td class="colinput">
									<label><input type="radio" onclick="util.clickHideTexts(this,'phyExamYearSpan')"  name="isPhyExam" checked="checked" value=""/> 全部</label>
									<label><input type="radio" onclick="util.clickShowTexts(this,'phyExamYearSpan')"  name="isPhyExam"  value="1"/> 否</label>
									<label><input type="radio" onclick="util.clickShowTexts(this,'phyExamYearSpan')" name="isPhyExam"  value="2"/>是</label>
									<span id="phyExamYearSpan" class="hidediv">
								<tag:dateInput name="clinicYear" pattern="yyyy" style="width:35%;"/>
							</span>
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="advanceSearchSection" style="display: none;">
								<td  class="coltext">是否签约</td>
								<td>
									<ehr:dic-list name="signFlag" dicmeta="FS10399" width="80%"/>
								</td>
								<td  class="coltext">是否有医疗记录</td>
								<td class="colinput">
									<label><input  type="radio"  name="ehrFlag" checked="checked" value="" onclick="util.clickHideTexts(this,'zyjl')"/> 全部</label>
									<label><input  type="radio"  name="ehrFlag" value="0" onclick="util.clickHideTexts(this,'zyjl')"/> 否</label>
									<label><input  type="radio"  name="ehrFlag"  value="1"/>是</label>
									<span class="hidediv" id="zyjl"><ehr:dic-list width=" 40%" id="ylTypes" name="ylTypes" dicmeta="FS990030" ></ehr:dic-list>
								</td>
								<td class="colinput" colspan="2" style="float: right;">
									<!-- <input class="search_btn" type="button" name="search" id="per_search_btn" value="查询" style="float: left;"/> -->
								</td>
							</tr>
						</c:otherwise>
					</c:choose>

					 <tr>
						 <c:choose>
							 <c:when test="${not empty urlFromPhysicalExam}">
								 <td colspan="5"></td>
								 <td>
									 <button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
									 <button class="layui-btn layui-btn-sm" id="tjgjBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
								 </td>
							 </c:when>
							 <c:otherwise>
								 <td class="righttd" colspan="6">
									 <button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
									 <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
								 </td>
							 </c:otherwise>
						 </c:choose>

                    </tr>
				</tbody>
			</table>
			<table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="personRecordPagination.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
		</form>
	</div>
	<c:if test="${empty urlFromPhysicalExam}">
		<div class="toolbarSection x-admin-sm">
			<c:if test="${search_Role ne 'wsj_Role'}">
				<%-- <a id="personAdd"><b class="xinz">新增</b></a> --%>
				<a id="personAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
				<%--<a href="javascript:void(0)" id="dataBaAdd"><b class="import">数据库导入</b></a>--%>
				<ehr:authorize ifAnyGranted="${JKJKDN}">
					<a href="javascript:void(0)" id="ehr-person-import-btn"><b class="import">Excel导入</b></a>
				</ehr:authorize>
				<%-- <a href="javascript:void(0)" id="ehr-person-export-btn"><b class="export">导出</b></a> --%>
				<a id="ehr-person-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			</c:if>
		</div>
	</c:if>

	<div id="list_datagrid" ></div>
	<input type="hidden" id="orgCode" value="${currentLoginInfo.organization.organCode}" ></input>
</div>
<div id="detailDiv"></div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#createBeginDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#createEndDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      //执行一个laydate实例
        laydate.render({
          elem: '#updateBeginDate'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });
      
      //执行一个laydate实例
        laydate.render({
          elem: '#updateEndDate'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });

        //添加体检时间
		laydate.render({
			elem: '#personPhyExamStartDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#personPhyExamEndDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#tjBeginDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#tjEndDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

      });
    

    </script>
<%-- 市民卡插件
 <object id="CsSmkActive" classid="clsid:AE451137-38F8-4240-A9F9-6D8E182D9C16" codebase="${pageContext.request.contextPath}/activex/csSmk.cab#version=1,0,0,1" style="width:0;height:0;display:none;"></object>
 --%>
