<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<!-- <script src="/rhip-web/js/views/ehr/person/list.js" type="text/javascript"></script> -->
<link href="${pageContext.request.contextPath}/css/views/searchList/searchList.css" type="text/css"  rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/region/list3.js"></script>

<div class="section" id="top_all">
	<div class="toolbar">
		<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">居民健康档案</a>
	        <a>
          <cite>区域档案</cite></a>
      	</span>
    	</div>
	</div>

	<p id="cert_message" class="msgError" style="display: none;"></p>
	<p id="cert_message_type" style="display: none;"></p>
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" value="${currentLoginInfo.organization.genreCode}" id="currentAreaCode"/>
		<form method="post" id="form_search">
			<table id="reportSearch">
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:60px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
				</colgroup>	
				<tbody>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput">
                            <input type="text" name="personName" id="personName" style="width: 60%" class="x-layui-input"/>
                            <input type="checkbox" name="likeFlag" value="like" />模糊
                        </td>
                        <td class="coltext">年龄段</td>
                        <td class="colinput">
                            <tag:numberInput name="beginAge" id="beginAge" style="width : 40%" cssClass="x-layui-input"/> ~
                            <tag:numberInput name="endAge" id="endAge" style="width : 40%" cssClass="x-layui-input"/>
                        </td>
                        <td class="coltext">性别</td>
                        <td class="colinput">
                            <ehr:dic-list dicmeta="GBT226112003" name="genderCode" width="80%" cssClass="x-layui-input"/>
                        </td>
                    </tr>
					<tr>
                        <td class="coltext">身份证号</td>
                        <td class="colinput">
<!--                         	<input type="text" name="idCard" id="idCard" style="ime-mode:Disabled;width: 80%"/>  -->
                        	<tag:idcardInput name="idCard" id="text_idcard" style="width: 70%" cssClass="x-layui-input"></tag:idcardInput>
                        </td>
                        <td class="coltext">管理时间</td>
                        <td class="colinput">
                            <%-- <tag:dateInput name="createBeginDate" id="createBeginDate" onlypast="true" style="width: 40%;"/> ~
                            <tag:dateInput name="createEndDate" id="createEndDate" onlypast="true" style="width: 40%;"/> --%>
                            <input type="text" class="layui-input x-admin-sm-date"  name="createBeginDate" id="createBeginDate" style="padding-left: 0px;width: 40%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="createEndDate" id="createEndDate" style="padding-left: 0px;width: 40%;" />
                        </td>
                        <td class="coltext">档案状态</td>
                        <td class="colinput">
                            <select name="filingFlag" style="width: 80%;" class="x-layui-input">
                                <option value="1">已建档 </option>
								<option value="5">待迁入</option>
                                <option value="0">未建档</option>
                                <%--<option value="2">审核中</option>--%>
                                <%--<option value="3">已退回</option>--%>
                                <option value="9">已结案</option>
                                <option value="4">无身份证</option>
                            </select>
                        </td>
					</tr>
					<tr class="advanceSearchSection" style="display: none;">
						<td class="coltext">常住类型</td>
						<td class="colinput">
							<label><input type="radio" name="householdType" value="-1" id="householdType" checked="checked" />&nbsp;全部&nbsp;</label>
							<ehr:dic-radio dicmeta="FS10005" name="householdType" code="1,2,4"></ehr:dic-radio>
						</td>
						<td class="coltext">更新时间</td>
                        <td class="colinput">
                            <%-- <tag:dateInput name="updateBeginDate" id="updateBeginDate" onlypast="true" style="width: 40%;"/> ~
                            <tag:dateInput name="updateEndDate" id="updateEndDate" onlypast="true" style="width: 40%;"/> --%>
                            <input type="text" class="layui-input x-admin-sm-date"  name="updateBeginDate" id="updateBeginDate" style="padding-left: 0px;width: 40%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="updateEndDate" id="updateEndDate" style="padding-left: 0px;width: 40%;" />
                        </td>
                        <td class="coltext">档案星级</td>
						<td class="colinput" colspan="3">
							<label><input type="radio" name="starType" value="-1" id="starType" checked="checked" /> 全部&nbsp;</label>
							<label><input type="radio" name="starType" value="0" id="starType" /> 零星 </label>
							<label><input type="radio" name="starType" value="1" id="starType" /> 一星 </label>
							<label><input type="radio" name="starType" value="2" id="starType" /> 二星 </label>
							<label><input type="radio" name="starType" value="3" id="starType" /> 三星 </label>
						</td>
					</tr>
					<tr class="advanceSearchSection" style="display: none;">
						<%--<td class="coltext">常住类型</td>--%>
						<%--<td class="colinput">--%>
							<%--<label><input type="radio" name="livingType" value="-1" id="livingType" checked="checked" />&nbsp;全部&nbsp;</label>--%>
							<%--<ehr:dic-radio dicmeta="FS10005" name="livingType" code="3,4"></ehr:dic-radio>--%>
						<%--</td>--%>
						<td class="coltext">户籍居委会</td>
						<td class="colinput">
							<ehr:dic-town-street-village townName="hrtownShip" streetName="hrstreet" villageName="hrGroup" width="33%" cssClass="x-layui-input" />
						</td>
						<td class="coltext">人群分类</td>
						<td class="colinput">
							<ehr:dic-list width="156px" type="true"  id="groupClassification" name="groupClassification" dicmeta="FDS007" cssClass="x-layui-input" />
						</td>
						<td class="coltext">是否体检</td>
						<td class="colinput">
							<label><input type="radio" onclick="util.clickHideTexts(this,'phyExamYearSpan')"  name="isPhyExam" checked="checked" value=""/> 全部</label>
							<label><input type="radio" onclick="util.clickShowTexts(this,'phyExamYearSpan')"  name="isPhyExam"  value="1"/> 否</label>
							<label><input type="radio" onclick="util.clickShowTexts(this,'phyExamYearSpan')" name="isPhyExam"  value="2"/>是</label>
							<span id="phyExamYearSpan" class="hidediv">
								<%-- <tag:dateInput name="clinicYear" pattern="yyyy" style="width:35%;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date"  name="clinicYear" id="clinicYearId" style="padding-left: 0px;width:35%;" />
							</span>
						</td>
					</tr>
				
				<tr class="advanceSearchSection" style="display: none;">
						<td class="coltext">贫困人口</td>
							<td class="colinput">
							<label><input  type="radio" onclick="util.clickHideTexts(this,'quitDrinkAgeDescs')"  name="poverty" checked="checked" value="-1"/> 全部</label>
							<label><input  type="radio" onclick="util.clickHideTexts(this,'quitDrinkAgeDescs')"  name="poverty"  value="1"/> 否</label>
					         <label><input type="radio" id="povertys" onclick="util.clickShowTexts(this,'quitDrinkAgeDescs')" name="poverty"  value="2"/>是</label>
							
							
								<span id="quitDrinkAgeDescs" class="hidediv"><ehr:dic-list width=" 42%" reg="{'required':true}" id="povertyTypes" name="povertyType" dicmeta="FS990024" cssClass="x-layui-input"></ehr:dic-list>
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
						<ehr:dic-town-street-village townName="patownShip" streetName="pastreet" width="50%" cssClass="x-layui-input"/>
					</td>
					<td class="coltext">管理机构</td>
					<td colspan="4">
						<c:choose>
							<c:when test="${search_Role eq 'wsj_Role'}">
								<ehr:authorize ifNotGranted="04">
									<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchstation"  townName="searchTown" width="27.5%;" isShowOneself="true" includeTownCodes="${includeTownCodes}" cssClass="x-layui-input"/>
								</ehr:authorize>
							</c:when>
							<c:when test="${search_Role eq 'sqzx_Role'}">
								<ehr:dic-org-list id="nowAddressCode" name="townOrganCode"  width="27.5%;"  isShowOneself="true" cssClass="x-layui-input"></ehr:dic-org-list>
							</c:when>
						</c:choose>
						<ehr:authorize ifAnyGranted="04">
							<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchstation"  townName="searchTown" width="27.5%;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
						</ehr:authorize>
					</td>

				</tr>
				<tr class="advanceSearchSection" style="display: none;">
					<td  class="coltext">是否签约</td>
					<td>
						<ehr:dic-list name="signFlag" dicmeta="FS10399" width="80%" cssClass="x-layui-input"/>
					</td>
					<td  class="coltext">是否有医疗记录</td>
					<td class="colinput">
						<label><input  type="radio"  name="ehrFlag" checked="checked" value="" onclick="util.clickHideTexts(this,'zyjl')"/> 全部</label>
						<label><input  type="radio"  name="ehrFlag" value="0" onclick="util.clickHideTexts(this,'zyjl')"/> 否</label>
						<label><input  type="radio"  name="ehrFlag"  value="1"/>是</label>
						<span class="hidediv" id="zyjl"><ehr:dic-list width=" 40%" id="ylTypes" name="ylTypes" dicmeta="FS990030" ></ehr:dic-list>
					</td>
					<td></td>
					</td>
				</tr>
				<tr>
                   	<td class="righttd" colspan="6">
                   	<button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
					<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
                   	</td>
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
	<div class="toolbarSection">
		<ehr:authorize  ifAnyGranted="03">
			<%-- <a id="personAdd"><b class="xinz">新增</b></a> --%>
			<a id="personAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
			<%-- <a href="javascript:void(0)" id="personApprove"><b class="xiug">审核</b></a> --%>
			<a href="javascript:void(0)" id="personApprove"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe642;</i>审核</button></a>
		</ehr:authorize>
		<%-- <a href="javascript:void(0)" id="ehr-person-region-export-btn"><b class="export">导出</b></a> --%>
		 <a href="javascript:void(0)" id="ehr-person-region-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
    </div>
    <div id="list_datagrid"></div>
<input type="hidden" id="orgCode" value="${currentLoginInfo.organization.organCode}" ></input>
</div>
<div id="detailDiv"></div>
    <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#createBeginDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#createEndDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
        laydate.render({
          elem: '#updateBeginDate'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });
      
        laydate.render({
          elem: '#updateEndDate'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });
        
        laydate.render({
            elem: '#clinicYearId'
            ,type:'year'
          		  ,max:0
          });
        
      });
    

    </script>
