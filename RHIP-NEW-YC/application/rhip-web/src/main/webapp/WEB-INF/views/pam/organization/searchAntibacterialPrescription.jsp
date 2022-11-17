<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/pam/organ/search.js" type="text/javascript"></script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">医疗服务</a>
		        <a>
		          <cite>
		          抗菌药物统计
		          </cite></a>
		      </span>
		</div>
    </div>
    
<%--统一机构考核搜索--%>
<div>
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<input type="hidden" id="searchUrl" value="${searchUrl}">
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
                    <td class="col-text">机构类型</td>
                    <td class="col-input">
                        <select name="genreCode" id="genreCode" style="width: 130px;">
                            <%--卫生局,市级医院--%>
                            <ehr:authorize ifAnyGranted="01,39">
                                <c:if test="${empty hospitalFlag}">
                                    <option value="A100">按市级医院</option>
                                </c:if>
                            </ehr:authorize>
                            <%--卫生局,卫生院--%>
                            <ehr:authorize ifAnyGranted="01,03">
                                <c:if test="${empty superOrganFlag}">
                                    <option value="B100">按中心/卫生院</option>
                                </c:if>
                            </ehr:authorize>
                            <%--卫生局,卫生院,社区服务中心--%>
                            <ehr:authorize ifAnyGranted="01,02,03">
                                <c:if test="${empty organFlag}">
                                    <option value="B200">按社区卫生服务站</option>
                                </c:if>
                            </ehr:authorize>
                            <%--卫生局--%>
                            <%--<ehr:authorize ifAnyGranted="01">--%>
                                <%--<c:if test="${empty gbFlag}">--%>
                                    <%--<option value="0">按镇</option>--%>
                                <%--</c:if>--%>
                            <%--</ehr:authorize>--%>
                        </select>
                    </td>
                    <td class="col-text">机构</td>
                    <td class="col-input">
                        <%--卫生局角色--%>
                        <ehr:authorize ifAnyGranted="01">
                            <input type="hidden" id="gbCode" name="gbCode"/>
                            <input type="hidden" id="superOrganCode" name="superOrganCode"/>
                            <input type="hidden" id="organCode" name="organCode"/>
                            <%--市级医院--%>
                            <div id="byHospital">
                                <ehr:org-type-list id="organCode0" name="organCode0" type="hospital" value="${organCode}" code="${organCode}"  width="260px"/>
                            </div>
                            <%--卫生院--%>
                            <div id="byCentre">
                                <ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="220px;"/>
                            </div>
                            <%--社区服务站--%>
                            <div id="byStation">
                                <ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2" width="33%;" />
                            </div>
                            <%--镇--%>
                           <%--  <div id="byTown">
                                <ehr:dic-town-village townId="town3" townName="gbCode3" width="180px"/>
                            </div> --%>
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
                            <%--社区服务站--%>
                            <div id="byStation">
                                <ehr:dic-org-list name="organCode" width="180px;"/>
                            </div>
                        </ehr:authorize>
                        <%--社区服务站角色--%>
                        <ehr:authorize ifAnyGranted="02">
                            <%--社区服务站--%>
                            <div id="byStation">
                                <input type="hidden" name="organCode" value="${orgCode}"/>
                                <ehr:org  code="${orgCode}"/>
                            </div>
                        </ehr:authorize>
                    </td>

                </tr>
                <tr>
                    <td class="col-text">时间</td>
                    <td class="col-input" colspan="3">
	                    <%-- <tag:dateInput id="beginDateA" name="beginDateA" maxId="endDateA" onlypast="true" style="width: 80px;" date="${currentBeginDate}"/>~
	                    <tag:dateInput  id="endDateA" name="endDateA" minId="beginDateA" onlypast="true" style="width: 80px;" date="${currentEndDate}"/></td> --%>
	                    
	                    <input type="text" class="layui-input x-admin-sm-date" name="beginDateA" id="beginDateA" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;"> ~
                        	<input type="text" class="layui-input x-admin-sm-date" name="endDateA" id="endDateA" value="<fmt:formatDate value='${currentEndDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
                    <td>
                        <button class="layui-btn layui-btn-sm"  id="targetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom">
						<span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<div id="resultDiv">
		<jsp:include page="${listpath}" ></jsp:include>
	</div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#beginDateA'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });
        
        
        laydate.render({
            elem: '#endDateA'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });



    });

</script>