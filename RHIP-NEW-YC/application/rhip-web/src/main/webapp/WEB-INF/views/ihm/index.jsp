<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/ihmIndex.css"/>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/index.js" type="text/javascript"></script>
<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a>
		          <cite>
		          统计汇总
		          </cite></a>
		      </span>
		</div>
    </div>
<p>&nbsp;</p>
<table width="1020" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr style="width: 100%">
    <td>
    	<div class="cardcontentbg">
        	<div class="cardcontent">
            	<div class="tabtitle">
                	全市实际门急诊业务（天）
                </div>
  				<div class="tabcontent">
                	<ul>
                    	<li>昨日门急诊 <font color="#FF0000"><span id="allNum"></span></font> 人次</li>
                        <li>总费用 <font color="#1282b0"><span id="allFee"></span></font> 元</li>
                        <li>药品费用 <font color="#1282b0"><span id="medicinalFee"></span> </font>元</li>
                        <li>医保医疗 <font color="#1282b0"><span id="insuranceFee"></span></font> 元</li>
                        <li>个人承担 <font color="#1282b0"><span id="personalFee"></span></font> 元</li>
                    </ul>
                </div>
            </div>
            <div class="cardcontent">
            	<div class="tabtitle">
                	全市实际门急诊业务（年）
                </div>
                <div class="tabcontent">
                	<ul>
                    	<li>今年门急诊 <font color="#FF0000"><span id="allNumYear"></span> </font>人次</li>
                        <li>总费用 <font color="#1282b0"><span id="allFeeYear"></span></font> 元</li>
                        <li>药品费用 <font color="#1282b0"><span id="medicinalFeeYear"></span> </font>元</li>
                        <li>医保医疗 <font color="#1282b0"><span id="insuranceFeeYear"></span></font> 元</li>
                        <li>个人承担 <font color="#1282b0"><span id="personalFeeYear"></span></font> 元</li>
                    </ul>
                </div>
            </div>
            <div class="cardcontent">
            	<div class="tabtitle">
                	全市实际住院业务（月）
                </div>
                <div class="tabcontent">
                	<ul>
                    	<li>上月出院 <font color="#FF0000"><span id="leaveHospitalNum"></span></font> 人次</li>
                        <li>总费用 <font color="#1282b0"><span id="inHosFee"></span></font> 元</li>
                        <li>药品费用 <font color="#1282b0"><span id="inHosMedicinalFee"></span> </font>元</li>
                        <li>医保医疗 <font color="#1282b0"><span id="inInsuranceFee"></span></font> 元</li>
                        <li>个人承担 <font color="#1282b0"><span id="inPersonalFee"></span></font> 元</li>
                    </ul>
                </div>
            </div>
            <div class="cardcontent">
            	<div class="tabtitle">
                	全市实际住院业务（年）
                </div>
                <div class="tabcontent">
                	<ul>
                    	<li>今年出院 <font color="#FF0000"><span id="leaveHospitalNumYear"></span></font> 人次</li>
                        <li>总费用 <font color="#1282b0"><span id="inHosFeeYear"></span></font> 元</li>
                        <li>药品费用 <font color="#1282b0"><span id="inHosMedicinalFeeYear"></span> </font>元</li>
                        <li>医保医疗 <font color="#1282b0"><span id="inInsuranceFeeYear"></span></font> 元</li>
                        <li>个人承担 <font color="#1282b0"><span id="inPersonalFeeYear"></span></font> 元</li>
                    </ul>
                </div>
            </div>
          <div class="cardcontent">
            	<div class="tabtitle">
                	全市实际医疗费用（年）
                </div>
                <div class="tabcontent">
                	<ul>
                    	<li>总收入 <font color="#FF0000"><span id="allFeeTotal"></span></font> 元</li>
                        <li>门急诊人均费用 <font color="#1282b0"><span id="allFeeAvg"></span></font> 元</li>
                        <li>住院人均费用 <font color="#1282b0"><span id="inHosFeeAvg"></span> </font> 元</li>
                        <li>药品费用比例 <font color="#1282b0"><span id="medicinalPercent"></span></font></li>
                    </ul>
                </div>
            </div>
            <br />
            <div class="cardcontent" style="clear: both;">
            	<div class="tabtitle">
                	全市电子健康档案
                </div>
                <div class="tabcontent">
                	<ul>
                    	<li>全市已建档 <font color="#FF0000"><span id="ehr003"></span></font> 份</li>
                        <li>全市已建档(非户籍) <font color="#FF0000"><span id="ehr002"></span></font> 份</li>
                        <li>全市已建档(户籍) <font color="#FF0000"><span id="ehr001"></span></font> 份</li>
                        <li>医生使用档案 <font color="#FF0000"><span id="docReadNum"></span></font> 次</li>
                    </ul>
                </div>
            </div>
            <div class="cardcontent">
            	<div class="tabtitle">
                	全市社区公共卫生
                </div>
                <div class="tabcontent">
                	<ul>
                        <li>糖尿病建卡 <font color="#FF0000"><span id="cdm058"></span></font> 人</li>
                        <li>高血压建卡 <font color="#FF0000"><span id="cdm032"></span> </font>人</li>
                        <li>糖尿病随访 <font color="#FF0000"><span id="cdm061"></span></font> 人次</li>
                        <li>高血压随访 <font color="#FF0000"><span id="cdm062"></span></font> 人次</li>
                    </ul>
                </div>
            </div>
            <div class="cardcontent">
            	<div class="tabtitle">
                	预防接种
                </div>
                <div class="tabcontent">
                	<ul>
                    	<li>预防接种总人数 <font color="#FF0000"><span id="vaccinationNum"></span></font> 人</li>
                        <li>本年接种人数 <font color="#FF0000"><span id="vaccinationCurrentYear"></span></font> 人</li>
                    </ul>
                </div>
            </div>
            <div class="cardcontent">
            	<div class="tabtitle">
                	妇幼保健
                </div>
                <div class="tabcontent">
                	<ul>
                    	<li>新生儿访视人数 <font color="#FF0000"><span id="wc021"></span></font> 人</li>
                        <li>婴幼儿健康管理数 <font color="#FF0000"><span id="wc022"></span></font> 人</li>
                        <li>产后访视人数 <font color="#FF0000"><span id="wc027"></span></font> 人</li>
                        <li>产后42天健康检查人数 <font color="#FF0000"><span id="wc028"></span></font> 人</li>
                    </ul>
                </div>
            </div>
            <div class="cardcontent">
            	<div class="tabtitle">
                	全市医疗单位信息
                </div>
                <div class="tabcontent">
                	<ul>
                        <%--<li>医生工作站连接数 <font color="#1282b0"></font>条</li>--%>
                        <li>昨日上报数 <font color="#1282b0"><span id="idm056"></span> </font>条</li>
                        <li>总上报数 <font color="#1282b0"><span id="idm053"></span></font>条</li>
                    </ul>
                </div>
            </div>
        </div>
    	</td>
    </tr>
    <tr>
	    <td>
	        <div class="formcontentbg">
				<table>
					<tr>
						<td>
							<div id="outAndHos" style="height: 270px;width: 505px;margin-right: 25px;"></div>
						</td>
						<td>
							<div id="outAndHosFee" style="height: 270px;width: 505px;"></div>
						</td>
					</tr>
				</table>
	        </div>
	    </td>
  </tr>
</table>