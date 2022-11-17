
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/ihmIndex.css"/>
<script type="text/javascript">
    require(['views/integration/index'],function(integrationIndexEcharts) {
        integrationIndexEcharts.load();
    });
</script>

<div id="inquiry" style="height:325px;width: 99%">

  <b class="jiandang">集成监控统计
    <i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeIntegaration" value="1"  />
                   &nbsp;<i style="margin-top:0px;">最新</i>
                 </label>
               </span>
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeIntegaration" value="2"   checked/>
                   &nbsp;<i style="margin-top:0px;">当月</i>
                 </label>
               </span>
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeIntegaration" value="3"  />
                   &nbsp;<i style="margin-top:0px;">当年</i>
                 </label>
               </span>
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeIntegaration" value="4"  />
                   &nbsp;<i style="margin-top:0px;">累积</i>
                 </label>
               </span>
    </i>
  </b>
    <span style="padding-left: 5px;">
        正确总数：<span id="resultRightId">${resultRight}</span>&nbsp;个&nbsp;
		错误总数：<span id="resultErrorId">${resultError}</span>&nbsp;个&nbsp;
	</span>

  <div id="logChart" style="height: 280px;width: 98%;" ></div>
</div>


<div id="inquiry" style="height:325px;width: 99%">

    <b class="jiandang">院内数据监控统计
        <i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeMedical" value="1"  />
                     &nbsp;<i style="margin-top:0px;">最新</i>
                 </label>
               </span>
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeMedical" value="2"   checked/>
                     &nbsp;<i style="margin-top:0px;">当月</i>
                 </label>
               </span>
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeMedical" value="3"  />
                     &nbsp;<i style="margin-top:0px;">当年</i>
                 </label>
               </span>
           	   <span>
                 <label><input type="radio" style="margin-top:6px;" name="dateTypeMedical" value="4"  />
                     &nbsp;<i style="margin-top:0px;">累积</i>
                 </label>
               </span>
        </i>
    </b>
    <span style="padding-left: 5px;">
        正确总数：<span id="shouldCountId">${shouldCount}</span>&nbsp;个&nbsp;
		错误总数：<span id="actualCountId">${actualCount}</span>&nbsp;个&nbsp;
	</span>

    <div id="medicalChart" style="height: 280px;width: 98%;" ></div>
</div>
