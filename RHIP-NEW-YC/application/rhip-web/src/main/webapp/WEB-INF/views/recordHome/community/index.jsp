<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/community/archiveManagement.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/community/index.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/community/otherStatistics.js" type="text/javascript"></script> --%>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>
<div class="main_PS" style="width: 99%;margin-top: 15px;"">
 <div id="mainContent" style="width: 99%;">
 	<div style="border: 1px;">
		<div id="communityInfo" style="width: 33%;float: left;"></div>
		<div id="communityBasicInfo" style="width: 35%;float: left;"></div>
		<%-- <div id="inquiry" style="width: 31.7%;float: left;height: 313px;">
			<b class="jiandang">快捷办公</b>
		    <table class="repeattable" style="margin:0;padding:0;">
			   <tr>
			    <td><p style="font-weight: bold;" >待建个人档案：</p><a id="personWaitCreate"></a> 份</td>
			  </tr>
			  <tr>
			    <td><p style="font-weight: bold;">已建档案：</p>个人：<a id="personHadCreate"></a> 份&emsp;&emsp;家庭：<a id="familyHadCreate"></a> 份</td>
			  </tr>
			  <tr>
			    <td><p style="font-weight: bold;">已结案档案：</p>个人：<a id="personHadWriteoff"></a> 份&emsp;&emsp;家庭：<a id="familyHadWriteoff"></a> 份</td>
			  </tr>
		  	</table>
		</div> --%>
		<fieldset class="layui-elem-field" style="height: 313px;">
            <legend>快捷办公</legend>
             <table class="repeattable" style="margin:0;padding:0;">
			   <tr>
			    <td><p style="font-weight: bold;" >待建个人档案：</p><a id="personWaitCreate"></a> 份</td>
			  </tr>
			  <tr>
			    <td><p style="font-weight: bold;">已建档案：</p>个人：<a id="personHadCreate"></a> 份&emsp;&emsp;家庭：<a id="familyHadCreate"></a> 份</td>
			  </tr>
			  <tr>
			    <td><p style="font-weight: bold;">已结案档案：</p>个人：<a id="personHadWriteoff"></a> 份&emsp;&emsp;家庭：<a id="familyHadWriteoff"></a> 份</td>
			  </tr>
		  	</table>
        </fieldset>
	</div>
	<%-- <div id="inquiry" style="height:282px;">
	    <b class="jiandang">档案管理
	    	<i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
           	   <span>  
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="1" id="RadioGroup5_"/>
               &nbsp;<i style="margin-top:0px;">最新</i></span></label>
           	   <span>
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="2" id="RadioGroup5_" checked/>
               &nbsp;<i style="margin-top:0px;">当月</i></span></label>
           	   <span>
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="3" id="RadioGroup5_"/>
               &nbsp;<i style="margin-top:0px;">当年</i></span></label>
           	   <span>
               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="4" id="RadioGroup5_"/>
               &nbsp;<i style="margin-top:0px;">累积</i></span></label>
	         </i>
	    </b>
	    <div id="archiveManagementChart" style="height: 250px;width: 98%;" ></div>
	</div> --%>
	<fieldset class="layui-elem-field">
            <legend>档案管理</legend>
             <div style="float: right;">
		 	<form class="layui-form">
		 	<div class="layui-form-item">
			    <div class="layui-input-block">
	            <input type="radio"  name="RadioGroup5" value="1"  title="最新" lay-filter="RadioGroup5"/>
	            &nbsp;
				 <input type="radio"  name="RadioGroup5" value="2" checked="checked" title="当月" lay-filter="RadioGroup5"/>
				 &nbsp;
				 <input type="radio"  name="RadioGroup5" value="3" title="当年" lay-filter="RadioGroup5" />
				 &nbsp;
				 <input type="radio"  name="RadioGroup5"  title="累计" lay-filter="RadioGroup5" />
			</div>
		  </div>
		 </form>
          </div>
		<div id="archiveManagementChart" style="height: 250px;width: 98%;clear: both;" ></div>
        </fieldset>

<%-- <div id="inquiry" style="height:282px;">
    <b class="jiandang"> 慢病管理
	   	<i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
	          	   <span>
	               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="1" id="RadioGroup5_" />
	               &nbsp;<i style="margin-top:0px;">最新</i></label></span>
	          	   <span>
	               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="2" id="RadioGroup5_" checked/>
	               &nbsp;<i style="margin-top:0px;">当月</i></label></span>
	          	   <span>
	               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="3" id="RadioGroup5_"/>
	               &nbsp;<i style="margin-top:0px;">当年</i></label></span>
	          	   <span>
	               <label><input type="radio" style="margin-top:6px;" name="RadioGroup5_other" value="4" id="RadioGroup5_"/>
	               &nbsp;<i style="margin-top:0px;">累积</i></label></span>
	        </i>
    </b>
	<div style="width: 98%;padding:5px">
		<jsp:include page="cdm.jsp"></jsp:include>
	</div>

	<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><br class="clearfloat" />
  </div> --%>
  <fieldset class="layui-elem-field">
            <legend>慢病管理</legend>
             <div style="float: right;">
		 	<form class="layui-form">
		 	<div class="layui-form-item">
			    <div class="layui-input-block">
	            <input type="radio"  name="RadioGroup5_other" value="1" title="最新" lay-filter="RadioGroup5_other"/>
	            &nbsp;
				 <input type="radio"  name="RadioGroup5_other" value="2" checked="checked" title="当月" lay-filter="RadioGroup5_other"/>
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
</div>
</div>

<script>
layui.use('form', function(){
  var form = layui.form;
//监听提交
  form.on('radio(RadioGroup5)', function(data){
	  communityArchiveManagement.loadingArchiveManagement();
  });
  
  form.on('radio(RadioGroup5_other)', function(data){
	  communityCdm.getIdmStatistics($("input[name=RadioGroup5_other]:checked").val());
  });
});
</script>
