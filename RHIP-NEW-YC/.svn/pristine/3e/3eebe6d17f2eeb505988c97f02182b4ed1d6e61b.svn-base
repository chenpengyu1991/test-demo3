<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<!-- <script type="text/javascript">
	require(['views/ihm/idmTarget/trend/search'],function(trendSearch) {
		trendSearch.load();
		});
</script>  -->

<script src="${pageContext.request.contextPath}/js/views/ihm/idmTarget/trend/search.js" type="text/javascript"></script>

<div class="toolbar">
	    	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">疾病控制</a>
			        <a>
			          <cite>
			           传染病疫情分析统计
			          </cite></a>
			      </span>
			</div>
	    </div>

<div class="section">
	<div class="searchbox searchSection x-admin-sm">
		<form id="targetSearchForm">
			<table id="targetSearch">
                <colgroup>
                    <col style="width: 8%; min-width: 55px;"/>
                    <col style="width: 18%; min-width: 100px;"/>
                    <col style="width: 6%; min-width: 45px;"/>
                    <col/>
                    <col style="width: 11%; min-width: 80px;"/>
                </colgroup>
				<tbody>
					<tr>
                    	<td class="coltext">统计类型</td>
                        <td class="colinput">
                        	<select name="genreCode" id="genreCode" style="width: 130px;">
                                <%--卫生局--%>
                                <ehr:authorize ifAnyGranted="01">
                                    <c:if test="${empty gbFlag}">
                                        <option value="0">按镇</option>
                                    </c:if>
                                </ehr:authorize>
                            <%--卫生局,市级医院--%>
								<ehr:authorize ifAnyGranted="01,39">
									<c:if test="${empty hospitalFlag}">
										<option value="A100">按市级医院</option>
									</c:if>
								</ehr:authorize>
								<%--卫生局,卫生院--%>
	                          	<ehr:authorize ifAnyGranted="01,03">
									<c:if test="${empty superOrganFlag}">
										<option value="B100">按卫生院</option>
									</c:if>
								</ehr:authorize>
                        	</select>
                        </td>
                        <td class="coltext"><label class="required">时间</label></td>
						<td class="colinput">
								<%-- <tag:dateInput name="yearDate" pattern="yyyy" id="yearDate"  date="${currentBeginDate}" onlypast="true" reg="{'required':'true'}" style="width: 80px;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" name="yearDate" id="yearDate" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
						</td>
						<c:choose>
							 <c:when test="${trend eq 1}">
							 	<td rowspan="3">
									<button class="layui-btn layui-btn-sm"  id="idmBtnSearch"><i class="layui-icon">&#xe615;</i>查看</button>
								</td> 
							 </c:when>
							 <c:otherwise>
							 	<td rowspan="2">
									<button class="layui-btn layui-btn-sm"  id="idmBtnSearch"><i class="layui-icon">&#xe615;</i>查看</button>
								</td> 							 
							 </c:otherwise>
						</c:choose>
					</tr>
					<tr>
                        <td class="coltext"><label class="required">机构</label></td>
						<td class="colinput" colspan="3">
							<%--卫生局角色--%>
							<ehr:authorize ifAnyGranted="01">	
								<input type="hidden" id="gbCode" name="gbCode"/>
								<input type="hidden" id="superOrganCode" name="superOrganCode"/>
								<input type="hidden" id="organCode" name="organCode"/>
								
								<input type="hidden" id="gbName" name="gbName"/>
								<input type="hidden" id="superOrganName" name="superOrganName"/>
								<input type="hidden" id="organName" name="organName"/>								
								<%--市级医院--%>
								<div id="byHospital">
									<ehr:org-type-list id="organCode0" name="organCode0" type="hospital" subsid="0" value="${organCode}" code="${organCode}" reg="{'required':'true'}" width="220px"/>
								</div>								
								<%--卫生院--%>					
								<div id="byCentre">
									<ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" reg="{'required':'true'}" width="220px;" />
								</div>	
								<%--镇--%>					
								<div id="byTown">
									<ehr:dic-town-village townId="town3" townName="gbCode3" reg="{'required':'true'}" width="180px"/>
								</div>															
							</ehr:authorize>
							<%--市级医院角色--%>
							<ehr:authorize ifAnyGranted="39">
								<%--市级医院--%>
								<div id="byHospital">
									<input type="hidden" name="organCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>
							</ehr:authorize>							
							<%--卫生院角色--%>
							<ehr:authorize ifAnyGranted="03">	
								<%--卫生院--%>					
								<div id="byCentre">
									<input type="hidden" name="superOrganCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>	
							</ehr:authorize>
				
						</td>   
					</tr>
					<tr>
							<td class="coltext">疾病名称</td>
	                        <td class="colinput" colspan="3">
	                        	<input class="radioGroup" onclick="trendSearch.changeInfectious(this.value)" id="infectiousType1" name="infectiousType" value="1" type="radio" CHECKED="checked" ><label for="infectiousType1">按分类</label>
	                        	<input class="radioGroup" onclick="trendSearch.changeInfectious(this.value)" id="infectiousType2" name="infectiousType" value="2" type="radio" ><label for="infectiousType2">按名称</label>
	                            <ehr:dic-list name="type" id="searchType" dicmeta="IDM00400" width="120px;" defaultval = "A"  onchange="trendSearch.querySearchInfection()"/>
	                            <select name="infectiousCode" id="searchInfectiousCode" style="width: 150px;">
	                            </select>                        	
	                        </td> 						
					</tr>					
				</tbody>
			</table>
			<table>
				<tr>
					<td class="col-bottom">
						<span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
					</td>   					
				</tr>
			</table>

		</form>
	</div>
	<div id="idm_trend_chart"></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

       
        laydate.render({
            elem: '#yearDate'
            ,type:'year'
            , format: 'yyyy'
            , max: 0
            , trigger: 'click' 
        });
        
      
        
        
   
    });

</script>