<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/ehrHomeIndexEcharts2.js"></script>

<%-- <script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/archiveManagement.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/otherStatistics.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/townDistribution.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/homePage.js" type="text/javascript"></script>
 --%>
<!-- <script type="text/javascript">
	require(['views/ehr/recordHome/sanitaryBureau/ehrHomeIndexEcharts'],function(ehrHomeIndexEcharts) {
		ehrHomeIndexEcharts.load();
	});
</script> -->
<div class="main_PS" style="width: 99%;">
	<div id="mainContent" style="width:99%;">
		<div id="inquiry" style="height:325px;width: 99%">
    		<b class="jiandang">人口概况<a class="view" id="popStatics"><b class="fenbu">人口统计</b></a><a id="popDis" class="view" href=''><b class="fenbu">人口分布</b></a></b>
    		<table id="poptable" style="width: 50%;line-height: 20px;">
		    	<tr>
		    		<td>常住人口总数：<fmt:formatNumber value="${sanitaryBureauPopulace.totalPopulace / 10000}" pattern="###,###.##"/>万</td>
		    	</tr>
		    	<tr>
		    		<td>户籍：<fmt:formatNumber value="${sanitaryBureauPopulace.houseHoldNum / 10000}" pattern="###,###.##"/>万</td>
		    		<td>非户籍：<fmt:formatNumber value="${sanitaryBureauPopulace.unHouseHoldNum / 10000}" pattern="###,###.##"/>万</td>
		    	</tr>
		    	<%--<tr>
		    		<td>男：<fmt:formatNumber value="${(sanitaryBureauPopulace.householdManNum + sanitaryBureauPopulace.unHouseholdManNum) / 10000 }" pattern="###,###.##"/>万</td>
		    		<td>女：<fmt:formatNumber value="${(sanitaryBureauPopulace.householdWomanNum + sanitaryBureauPopulace.unHouseholdWomanNum) / 10000 }" pattern="###,###.##"/>万</td>
		    	</tr>--%>
		    </table>
  
			<div id="chartContainer" style="height: 210px;width: 98%;" ></div>

			<input type="hidden" id="phb" value="${sanitaryBureauPopulace.householdPhbNum }"/>
			<input type="hidden" id="di" value="${sanitaryBureauPopulace.householdDiNum }"/>
			<input type="hidden" id="mental" value="${sanitaryBureauPopulace.householdMentalNum }"/>
		    <%--<input type="hidden" id="children" value="${sanitaryBureauPopulace.householdSixChildNum }"/>
		    <input type="hidden" id="woman" value="${sanitaryBureauPopulace.householdFertileWomanNum }"/>
		    <input type="hidden" id="old" value="${sanitaryBureauPopulace.householdSixoToSixfNum }"/>--%>
		    <input type="hidden" id="oldder" value="${sanitaryBureauPopulace.householdGreatSixfNum }"/>

			<input type="hidden" id="phb_" value="${sanitaryBureauPopulace.unhouseholdPhbNum }"/>
			<input type="hidden" id="di_" value="${sanitaryBureauPopulace.unhouseholdDiNum }"/>
			<input type="hidden" id="mental_" value="${sanitaryBureauPopulace.unhouseholdMentalNum }"/>
		    <%--<input type="hidden" id="children_" value="${sanitaryBureauPopulace.unHouseholdSixChildNum }"/>
		    <input type="hidden" id="woman_" value="${sanitaryBureauPopulace.unHouseholdFertileWomanNum }"/>
		    <input type="hidden" id="old_" value="${sanitaryBureauPopulace.unHouseholdSixoToSixfNum }"/>--%>
		    <input type="hidden" id="oldder_" value="${sanitaryBureauPopulace.unHouseholdGreatSixfNum }"/>
		</div>
		<div id="inquiry" style="height:370px;width: 99%">
		    <b class="jiandang">档案统计</b>
		    <span style="padding-left: 5px;">
		    	总档案数：<span id="totalRecord"></span>&nbsp;份&nbsp;(包括已建档)
		    </span>
			<div id="townDistributeChart" style="height: 319px;width: 98%;" ></div>
		</div>
	<div id="inquiry" style="height:325px;width: 99%">

	    <b class="jiandang">档案管理
	    <i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
           	   <span>  
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="1"  />
               &nbsp;<i style="margin-top:0px;">最新</i></span></label>
           	   <span>
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="2" checked/>
               &nbsp;<i style="margin-top:0px;">当月</i></span></label>
           	   <span>
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="3"  />
               &nbsp;<i style="margin-top:0px;">当年</i></span></label>
           	   <span>
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="4"  />
               &nbsp;<i style="margin-top:0px;">累积</i></span></label>
	         </i>
	    </b>
		<div id="archiveManagementChart" style="height: 280px;width: 98%;" ></div>
	</div>

	<div id="inquiry" style="height:325px;width: 99%">
	    <b class="jiandang" > 慢病管理
	    <i id="other_range_type_box" class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
			<span>
				<label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="1" id="RadioGroup5_1" />
	               &nbsp;<i style="margin-top:0px;">最新</i></label>
			</span>
			<span>
				<label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="2" id="RadioGroup5_2" checked/>
	               &nbsp;<i style="margin-top:0px;">当月</i></label>
			</span>
			<span>
				<label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="3" id="RadioGroup5_3"/>
	               &nbsp;<i style="margin-top:0px;">当年</i></label>
	        </span>
			<span>
	              <label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="4" id="RadioGroup5_4"/>
	               &nbsp;<i style="margin-top:0px;">累积</i></label>
	        </span>
			</i>
		</b>
		<div style="width: 100%;padding:5px">
				<jsp:include page="cdm.jsp"></jsp:include>
	     </div>
     </div>

	<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><br class="clearfloat" />
  </div>
</div>
