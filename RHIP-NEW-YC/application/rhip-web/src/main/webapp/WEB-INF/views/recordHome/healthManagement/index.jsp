<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/healthManagement/archiveManagement.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/modules/exporting.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/healthManagement/homePage.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/healthManagement/communityDistribution.js" type="text/javascript"></script>
<div class="main_PS" style="width: 99%;margin-top: 15px;">
	<div id=mainContent style="width:99%;">
		<fieldset class="layui-elem-field">
            <legend>人口概况</legend>
            <div style="float: right;padding-right: 20px;">
            <a href="javascript:void(0)" id="popDis" class="x-a" ><i class="layui-icon">&#xe770;</i>人口分布</a>
            </div>
            <table id="poptable" style="width: 300px;line-height: 20px;float: left;">
				<tr>
		    		<td style="padding-left: 5px;">常住人口总数：<fmt:formatNumber value="${healthManagementPopulace.totalPopulace / 10000}" pattern="###,###.##"/>万</td>
		    	</tr>
		    	<tr>
		    		<td style="padding-left: 5px;">户籍：<fmt:formatNumber value="${healthManagementPopulace.houseHoldNum / 10000}" pattern="###,###.##"/>万</td>
		    		<td style="padding-left: 5px;">非户籍：<fmt:formatNumber value="${healthManagementPopulace.unHouseHoldNum / 10000}" pattern="###,###.##"/>万</td>
		    	</tr>
		    	<%--<tr>
		    		<td>男：<fmt:formatNumber value="${(healthManagementPopulace.householdManNum + healthManagementPopulace.unHouseholdManNum) / 10000 }" pattern="###,###.##"/>万</td>
		    		<td>女：<fmt:formatNumber value="${(healthManagementPopulace.householdWomanNum + healthManagementPopulace.unHouseholdWomanNum) / 10000 }" pattern="###,###.##"/>万</td>
		    	</tr>--%>
	   		</table>
	    	<div id="chartContainer" style="height:210px;width: 98%;clear: both;" ></div>
			<input type="hidden" id="phb" value="${healthManagementPopulace.householdPhbNum }"/>
			<input type="hidden" id="di" value="${healthManagementPopulace.householdDiNum }"/>
			<input type="hidden" id="mental" value="${healthManagementPopulace.householdMentalNum }"/>
		    <input type="hidden" id="children" value="${healthManagementPopulace.householdSixChildNum }"/>
		    <%--<input type="hidden" id="woman" value="${healthManagementPopulace.householdFertileWomanNum }"/>
		    <input type="hidden" id="old" value="${healthManagementPopulace.householdSixoToSixfNum }"/>--%>
		    <input type="hidden" id="oldder" value="${healthManagementPopulace.householdGreatSixfNum }"/>
			<input type="hidden" id="phb_" value="${healthManagementPopulace.unhouseholdPhbNum }"/>
			<input type="hidden" id="di_" value="${healthManagementPopulace.unhouseholdDiNum }"/>
			<input type="hidden" id="mental_" value="${healthManagementPopulace.unhouseholdMentalNum }"/>
		    <input type="hidden" id="children_" value="${healthManagementPopulace.unHouseholdSixChildNum }"/>
		    <%--<input type="hidden" id="woman_" value="${healthManagementPopulace.unHouseholdFertileWomanNum }"/>
		    <input type="hidden" id="old_" value="${healthManagementPopulace.unHouseholdSixoToSixfNum }"/>--%>
		    <input type="hidden" id="oldder_" value="${healthManagementPopulace.unHouseholdGreatSixfNum }"/>
        </fieldset>
		<%-- <div id="inquiry" style="height:325px;width: 100%">
			<b class="jiandang">人口概况<a class="view" id="popDis" style="height:26px;color: blue;">人口分布</a></b>
			<table id="poptable" style="width: 300px;line-height: 20px;">
				<tr>
		    		<td>常住人口总数：<fmt:formatNumber value="${healthManagementPopulace.totalPopulace / 10000}" pattern="###,###.##"/>万</td>
		    	</tr>
		    	<tr>
		    		<td>户籍：<fmt:formatNumber value="${healthManagementPopulace.houseHoldNum / 10000}" pattern="###,###.##"/>万</td>
		    		<td>非户籍：<fmt:formatNumber value="${healthManagementPopulace.unHouseHoldNum / 10000}" pattern="###,###.##"/>万</td>
		    	</tr>
		    	<tr>
		    		<td>男：<fmt:formatNumber value="${(healthManagementPopulace.householdManNum + healthManagementPopulace.unHouseholdManNum) / 10000 }" pattern="###,###.##"/>万</td>
		    		<td>女：<fmt:formatNumber value="${(healthManagementPopulace.householdWomanNum + healthManagementPopulace.unHouseholdWomanNum) / 10000 }" pattern="###,###.##"/>万</td>
		    	</tr>
	   		</table>
	    	<div id="chartContainer" style="height:210px;width: 98%" ></div>
			<input type="hidden" id="phb" value="${healthManagementPopulace.householdPhbNum }"/>
			<input type="hidden" id="di" value="${healthManagementPopulace.householdDiNum }"/>
			<input type="hidden" id="mental" value="${healthManagementPopulace.householdMentalNum }"/>
		    <input type="hidden" id="children" value="${healthManagementPopulace.householdSixChildNum }"/>
		    <input type="hidden" id="woman" value="${healthManagementPopulace.householdFertileWomanNum }"/>
		    <input type="hidden" id="old" value="${healthManagementPopulace.householdSixoToSixfNum }"/>
		    <input type="hidden" id="oldder" value="${healthManagementPopulace.householdGreatSixfNum }"/>
			<input type="hidden" id="phb_" value="${healthManagementPopulace.unhouseholdPhbNum }"/>
			<input type="hidden" id="di_" value="${healthManagementPopulace.unhouseholdDiNum }"/>
			<input type="hidden" id="mental_" value="${healthManagementPopulace.unhouseholdMentalNum }"/>
		    <input type="hidden" id="children_" value="${healthManagementPopulace.unHouseholdSixChildNum }"/>
		    <input type="hidden" id="woman_" value="${healthManagementPopulace.unHouseholdFertileWomanNum }"/>
		    <input type="hidden" id="old_" value="${healthManagementPopulace.unHouseholdSixoToSixfNum }"/>
		    <input type="hidden" id="oldder_" value="${healthManagementPopulace.unHouseholdGreatSixfNum }"/>
        </div> --%>
		<fieldset class="layui-elem-field">
            <legend>档案统计</legend>
             <span style="padding-left: 5px;">
		    	总档案数：<span id="totalRecord"></span>&nbsp;份(包括已建档)
		    </span>
            <div id="communityDistributeChart" style="height:469px;width:100%;" ></div>
        </fieldset>
        <!-- <div id="inquiry" style="height:550px;width: 100%">
            <b class="jiandang">档案统计</b>
            <span style="padding-left: 5px;">
		    	总档案数：<span id="totalRecord"></span>&nbsp;份(包括已建档)
		    </span>
            <div id="communityDistributeChart" style="height:469px;width:100%;" ></div>
        </div> -->
        <!-- <br/>
        <br/> -->
    	<fieldset class="layui-elem-field">
            <legend>档案管理</legend>
             <div style="float: right;">
		 	<form class="layui-form">
		 	<div class="layui-form-item">
			    <div class="layui-input-block">
	            <input type="radio"  name="RadioGroup5" value="1" checked="checked"  title="最新" lay-filter="RadioGroup5"/>
	            &nbsp;
				 <input type="radio"  name="RadioGroup5" value="2" title="当月" lay-filter="RadioGroup5"/>
				 &nbsp;
				 <input type="radio"  name="RadioGroup5" value="3" title="当年" lay-filter="RadioGroup5" />
				 &nbsp;
				 <input type="radio"  name="RadioGroup5"  title="累计" lay-filter="RadioGroup5" />
			</div>
		  </div>
		 </form>
          </div>
		<div id="archiveManagementChart" style="height: 280px;width: 98%;clear: both;" ></div>
        </fieldset>
		<!-- <div id="inquiry" style="height:325px;">
			<b class="jiandang">档案管理
                <i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
					<span>  
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="1" id="RadioGroup5_" checked/>
						&nbsp;<i style="margin-top:0px;">最新</i></label>
					</span>
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="2" id="RadioGroup5_"/>
						&nbsp;<i style="margin-top:0px;">当月</i></label>
					</span>
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="3" id="RadioGroup5_"/>
						&nbsp;<i style="margin-top:0px;">当年</i></label>
					</span>
					<span>
						<label><input type="radio" style="margin-top:6px;" name="RadioGroup5" id="RadioGroup5_"/>
						&nbsp;<i style="margin-top:0px;">累积</i></label>
					</span>
				</i>
			</b>
			<div id="archiveManagementChart" style="height: 280px;width: 98%;" ></div>
		</div> -->
		<fieldset class="layui-elem-field">
            <legend>慢病管理</legend>
             <div style="float: right;">
		 	<form class="layui-form">
		 	<div class="layui-form-item">
			    <div class="layui-input-block">
	            <input type="radio"  name="RadioGroup5_other" value="1" checked="checked" title="最新" lay-filter="RadioGroup5_other"/>
	            &nbsp;
				 <input type="radio"  name="RadioGroup5_other" value="2"  title="当月" lay-filter="RadioGroup5_other"/>
				 &nbsp;
				 <input type="radio"  name="RadioGroup5_other" value="3" title="当年" lay-filter="RadioGroup5_other" />
				 &nbsp;
				 <input type="radio"  name="RadioGroup5_other"   title="累计" lay-filter="RadioGroup5_other" />
			</div>
		  </div>
		 </form>
          </div>
		<div style="width: 100%;padding:5px;clear: both;">
				<jsp:include page="cdm.jsp"></jsp:include>
    		</div>
        </fieldset>
       	<%-- <div id="inquiry" style="height:325px;">
           	<b class="jiandang"> 慢病管理
				<i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
				<span>
					<label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="1" id="RadioGroup5_" checked/>
					&nbsp;<i style="margin-top:0px;">最新</i></label>
				</span>
           	   	<span>
					<label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="2" id="RadioGroup5_"/>
					&nbsp;<i style="margin-top:0px;">当月</i></label>
				</span>
				<span>
					<label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="3" id="RadioGroup5_"/>
					&nbsp;<i style="margin-top:0px;">当年</i></label>
				</span>
           	   	<span>
               		<label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" id="RadioGroup5_"/>
               		&nbsp;<i style="margin-top:0px;">累积</i></label>
               	</span>
         		</i>
        		</b>
			<div style="width: 100%;padding:5px">
				<jsp:include page="cdm.jsp"></jsp:include>
    		</div>
       	</div> --%>
        <!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><!-- <br class="clearfloat" /> -->
    </div>
</div>

<script>
layui.use('form', function(){
  var form = layui.form;
//监听提交
  form.on('radio(RadioGroup5)', function(data){
	  cdcArchiveManagement.loadingArchiveManagement();
  });
  
  form.on('radio(RadioGroup5_other)', function(data){
	  cdcCdm.getIdmStatistics($("input[name=RadioGroup5_other]:checked").val());
  });
});
</script>