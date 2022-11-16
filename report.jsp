<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ech/manage/report.js"></script>
<link href="${pageContext.request.contextPath}/css/views/ech/report.css" type="text/css"   rel="stylesheet"/>
<style>
    /* @media screen {
    #posttable {
    overflow: hidden;
    height:1000px;
    }
    }
    @media print {

    #posttable {
    overflow: hidden;
    height:1000px;
    }
    } */

    .lose{    border: none;
        border-bottom: 2px solid #ff0000;
        color: #000;}
</style>
<script type="text/javascript">
    function myBrowser(){
        var userAgent = navigator.userAgent;
        if (userAgent.indexOf("Chrome") > -1){
            return "Chrome";
        }
    }
    var mb = myBrowser();
    if ("Chrome" == mb) {
        $('#report_id').css("margin-right","6px");
    }
    var isInfo=$("#isInfo").val();
    $("#ech-phyexam-add-back-btn").on("click", function(){
        if(isInfo){
			$("#ech-manage-list-box").show();
			$("#ech-manage-input-box").hide();
		}else{
			$("#ech-person-phyexam-input-box").hide();
	        $("#ech-person-phyexam-list-box").show();
		}
	});
</script>
<div id="report">
	<input type="hidden" id="isInfo" value="${isInfo }" />
	<c:if test="${isInfo eq 1 }"><jsp:include page="personInfo.jsp"></jsp:include></c:if>
    <div class="toolbar" >
        <c:if test='${sourceFlag eq "1"}'><a href="javascript:void(0)" id="ech-phyexam-add-back-btn"><b class="fanhui">返回</b></a></c:if>
        <c:if test='${sourceFlag eq "1" || sourceFlag eq "2"}'><c:if test='${editflag == "edit"}'><a href="javascript:void(0)" id="calcTZJG" ><b class="calculator">计算</b></a></c:if>
        </c:if>
        <c:if test='${editflag == "edit"}'>
            <a href="javascript:void(0)" id="qiQualityGuidance" onclick="document.getElementById('view').scrollIntoView();"><b class="sign">指导</b></a>
            <a href="javascript:void(0)" id="save" ><b class="baocun">保存</b></a></c:if>
        <a id="button_printId"><b class="printer">打印</b></a>
    </div>
    <input type="hidden" id="sourceFlag" value="${sourceFlag}"/><%--页面来源 1：中医药，2：健康档案 --%>
    <div class="postcontent" style="width: 98%;">
        <i class="popno">老年人中医药健康管理服务记录表</i>
        <table class="posttable">
            <tbody>
            <tr>
                <th><label class="required">姓名</label></th>
                <td>
                    ${report.name}
                </td>
                <c:if test="${sourceFlag ne 2}">
                    <th><label>证件号</label></th>
                    <td>
                         <ehr:ehrBrwLink personId="${personInfo.id}">
                            <ehr:tip>${personInfo.idcard==null?personInfo.otherIdcard:personInfo.idcard}</ehr:tip>
                        </ehr:ehrBrwLink>
                    </td>
                </c:if>
                <th> <label class="required">编号：</label></th>
                <td>
                    <input type="text"  value="${report.echNo}"
                           style="width: 140px;" readonly="readonly"/>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="report_id" style="margin-right: 4px;">
            <table class="posttable" >
                <colgroup>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                </colgroup>
                <thead>
                <tr><td colspan="10" ><hr style="margin:5px 0px 5px 5px;height:1px;color:#A9C3D0"/></tr>
                <tr>
                    <th class="centerth" style="border-right: 0px;" colspan="5"><b>请根据近一年的体验和感觉,回答以下问题</b></th>
                    <th class="centerth" style="border-right: 0px;" ><b>没有<br>(根本不/从来没有)</b></th>
                    <th class="centerth" style="border-right: 0px;" ><b>很少<br>(有一点/偶尔)</b></th>
                    <th class="centerth" style="border-right: 0px;" ><b>有时<br>(有些/少数时间)</b></th>
                    <th class="centerth" style="border-right: 0px;" ><b>经常<br>(相当/多数时间)</b></th>
                    <th class="centerth" style="border-right: 0px;" ><b>总是<br>(非常/每天)</b></th>
                </tr>
                </thead>
            </table>
        </div>
        <div >
            <c:set var="contentfixed" value="${sourceFlag == '1'?'contentfixed200':'contentfixed265'}"></c:set>
            <form id="reportFormId" class="${contentfixed}" style="right: 0px; left: 12px; ">
                <input type="hidden" id="reportId" name="id" value="${report.id}"/>
                <input type="hidden" id="companyCode" name="companyCode" value="${report.companyCode}"/>
                <input type="hidden" name="name" value="${report.name}"/>
                <input type="hidden" name="personId" value="${report.personId}"/>
                <input type="hidden" id="options"  value="${options}"/>
                <%-- <input type="hidden" id="examRecordId" name="examRecordId" value="${report.examRecordId}"/>
                <input type="hidden" name="examinationDate" value="<fmt:formatDate value="${report.examinationDate}" pattern="yyyy/MM/dd" />"/> --%>
                <input type="hidden" id="idcard" name="idcard" value="${report.idcard}"/>
                <input type="hidden" name="createOrg"  value="${report.createOrg}"/>
                <input type="hidden" id="editflag"  value="${editflag}"/>
                <input type="hidden" id="currentOption"  value="1"/>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                        <col style="min-width: 70px; width: 10%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th class="leftth" colspan="5">(1)您精力充沛吗？(指精神头足,乐于做事)</th>
                        <th class="centerth"><div id="option1_1" data-option-no="1"  class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option1_2"  data-option-no="1" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option1_3"  data-option-no="1" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option1_4"  data-option-no="1" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option1_5"  data-option-no="1" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(2)您容易疲乏吗？(指体力如何,是否稍微活动一下或做一点家务劳动就感到累)</th>
                        <th class="centerth"><div id="option2_1"  data-option-no="2" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option2_2"  data-option-no="2" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option2_3"  data-option-no="2" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option2_4"  data-option-no="2" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option2_5"  data-option-no="2" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(3)您容易气短,呼吸短促,接不上气吗？</th>
                        <th class="centerth"><div id="option3_1"  data-option-no="3" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option3_2"  data-option-no="3" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option3_3"  data-option-no="3" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option3_4"  data-option-no="3" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option3_5"  data-option-no="3" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(4)您说话声音低弱无力吗?(指说话没有力气)</th>
                        <th class="centerth"><div id="option4_1"  data-option-no="4" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option4_2"  data-option-no="4" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option4_3"  data-option-no="4" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option4_4"  data-option-no="4" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option4_5"  data-option-no="4" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(5)您感到闷闷不乐、情绪低沉吗?(指心情不愉快,情绪低落)</th>
                        <th class="centerth"><div id="option5_1"  data-option-no="5" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option5_2"  data-option-no="5" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option5_3"  data-option-no="5" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option5_4"  data-option-no="5" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option5_5"  data-option-no="5" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(6)您容易精神紧张、焦虑不安吗?(指遇事是否心情紧张)</th>
                        <th class="centerth"><div id="option6_1"  data-option-no="6" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option6_2"  data-option-no="6" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option6_3"  data-option-no="6" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option6_4"  data-option-no="6" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option6_5"  data-option-no="6" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(7)您因为生活状态改变而感到孤独、失落吗？ </th>
                        <th class="centerth"><div id="option7_1"  data-option-no="7" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option7_2"  data-option-no="7" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option7_3"  data-option-no="7" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option7_4"  data-option-no="7" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option7_5"  data-option-no="7" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(8)您容易感到害怕或受到惊吓吗? </th>
                        <th class="centerth"><div id="option8_1"  data-option-no="8" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option8_2"  data-option-no="8" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option8_3"  data-option-no="8" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option8_4"  data-option-no="8" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option8_5"  data-option-no="8" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(9)您感到身体超重不轻松吗?(感觉身体沉重)[BMI 指数=体重(kg)/身高<SUP>2</SUP>(m)]</th>
                        <th class="centerth">
                            <div id="option9_1"  data-option-no="9" class="optionNormal"><b>1</b></div>
                            <div>(BMI＜24)</div>
                        </th>
                        <th class="centerth">
                            <div id="option9_2"  data-option-no="9" class="optionNormal"><b>2</b></div>
                            <div>(24≤BMI＜25)</div>
                        </th>
                        <th class="centerth">
                            <div id="option9_3"  data-option-no="9" class="optionNormal"><b>3</b></div>
                            <div>(25≤BMI＜26)</div>
                        </th>
                        <th class="centerth">
                            <div id="option9_4"  data-option-no="9" class="optionNormal"><b>4</b></div>
                            <div>(26≤BMI＜28)</div>
                        </th>
                        <th class="centerth">
                            <div id="option9_5"  data-option-no="9" class="optionNormal"><b>5</b></div>
                            <div>(BMI≥28)</div>
                        </th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(10)您眼睛干涩吗?</th>
                        <th class="centerth"><div id="option10_1"  data-option-no="10" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option10_2"  data-option-no="10" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option10_3"  data-option-no="10" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option10_4"  data-option-no="10" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option10_5"  data-option-no="10" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(11)您手脚发凉吗?(不包含周围温度低或穿的少导致的手脚发冷)</th>
                        <th class="centerth"><div id="option11_1"  data-option-no="11" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option11_2"  data-option-no="11" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option11_3"  data-option-no="11" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option11_4"  data-option-no="11" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option11_5"  data-option-no="11" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(12)您胃脘部、背部或腰膝部怕冷吗？(指上腹部、背部、腰部或膝关节等,有一处或多处怕冷)</th>
                        <th class="centerth"><div id="option12_1"  data-option-no="12" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option12_2"  data-option-no="12" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option12_3"  data-option-no="12" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option12_4"  data-option-no="12" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option12_5"  data-option-no="12" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(13)您比一般人耐受不了寒冷吗？(指比别人容易害怕冬天或是夏天的冷空调、电扇等)</th>
                        <th class="centerth"><div id="option13_1"  data-option-no="13" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option13_2"  data-option-no="13" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option13_3"  data-option-no="13" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option13_4"  data-option-no="13" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option13_5"  data-option-no="13" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(14)您容易患感冒吗?(指每年感冒的次数)</th>
                        <th class="centerth">
                            <div id="option14_1"  data-option-no="14" class="optionNormal"><b>1</b></div>
                            <div>一年＜2 次</div>
                        </th>
                        <th class="centerth">
                            <div id="option14_2"  data-option-no="14" class="optionNormal"><b>2</b></div>
                            <div>一年感冒 2-4次</div>
                        </th>
                        <th class="centerth">
                            <div id="option14_3"  data-option-no="14" class="optionNormal"><b>3</b></div>
                            <div>一年感冒 5-6次</div>
                        </th>
                        <th class="centerth">
                            <div id="option14_4"  data-option-no="14" class="optionNormal"><b>4</b></div>
                            <div>一年 8 次以上</div>
                        </th>
                        <th class="centerth">
                            <div id="option14_5"  data-option-no="14" class="optionNormal"><b>5</b></div>
                            <div>几乎每月都感冒</div>
                        </th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(15)您没有感冒时也会鼻塞、流鼻涕吗?</th>
                        <th class="centerth"><div id="option15_1"  data-option-no="15" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option15_2"  data-option-no="15" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option15_3"  data-option-no="15" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option15_4"  data-option-no="15" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option15_5"  data-option-no="15" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(16)您有口黏口腻,或睡眠打鼾吗？ </th>
                        <th class="centerth"><div id="option16_1"  data-option-no="16" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option16_2"  data-option-no="16" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option16_3"  data-option-no="16" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option16_4"  data-option-no="16" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option16_5"  data-option-no="16" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(17)您容易过敏(对药物、食物、气味、花粉或在季节交替、气候变化时)吗?</th>
                        <th class="centerth">
                            <div id="option17_1"  data-option-no="17" class="optionNormal"><b>1</b></div>
                            <div>从来没有</div>
                        </th>
                        <th class="centerth">
                            <div id="option17_2"  data-option-no="17" class="optionNormal"><b>2</b></div>
                            <div>一年 1、2 次</div>
                        </th>
                        <th class="centerth">
                            <div id="option17_3"  data-option-no="17" class="optionNormal"><b>3</b></div>
                            <div>一年 3、4 次</div>
                        </th>
                        <th class="centerth">
                            <div id="option17_4"  data-option-no="17" class="optionNormal"><b>4</b></div>
                            <div>一年 5、6 次</div>
                        </th>
                        <th class="centerth">
                            <div id="option17_5"  data-option-no="17" class="optionNormal"><b>5</b></div>
                            <div>每次遇到上述原因都过敏</div>
                        </th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(18)您的皮肤容易起荨麻疹吗?(包括风团、风疹块、风疙瘩)</th>
                        <th class="centerth"><div id="option18_1"  data-option-no="18" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option18_2"  data-option-no="18" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option18_3"  data-option-no="18" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option18_4"  data-option-no="18" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option18_5"  data-option-no="18" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(19)您的皮肤在不知不觉中会出现青紫瘀斑、皮下出血吗?(指皮肤在没有外伤的情况下出现青一块紫一块的情况)</th>
                        <th class="centerth"><div id="option19_1"  data-option-no="19" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option19_2"  data-option-no="19" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option19_3"  data-option-no="19" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option19_4"  data-option-no="19" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option19_5"  data-option-no="19" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(20)您的皮肤一抓就红,并出现抓痕吗?(指被指甲或钝物划过后皮肤的反应)</th>
                        <th class="centerth"><div id="option20_1"  data-option-no="20" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option20_2"  data-option-no="20" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option20_3"  data-option-no="20" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option20_4"  data-option-no="20" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option20_5"  data-option-no="20" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(21)您皮肤或口唇干吗? </th>
                        <th class="centerth"><div id="option21_1"  data-option-no="21" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option21_2"  data-option-no="21" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option21_3"  data-option-no="21" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option21_4"  data-option-no="21" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option21_5"  data-option-no="21" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(22)您有肢体麻或固定部位疼痛的感觉吗？ </th>
                        <th class="centerth"><div id="option22_1"  data-option-no="22" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option22_2"  data-option-no="22" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option22_3"  data-option-no="22" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option22_4"  data-option-no="22" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option22_5"  data-option-no="22" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(23)您面部或鼻部有油腻感或者油亮发光吗?(指脸上或鼻子) </th>
                        <th class="centerth"><div id="option23_1"  data-option-no="23" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option23_2"  data-option-no="23" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option23_3"  data-option-no="23" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option23_4"  data-option-no="23" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option23_5"  data-option-no="23" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(24)您面色或目眶晦黯,或出现褐色斑块/斑点吗?</th>
                        <th class="centerth"><div id="option24_1"  data-option-no="24" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option24_2"  data-option-no="24" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option24_3"  data-option-no="24" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option24_4"  data-option-no="24" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option24_5"  data-option-no="24" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(25)您有皮肤湿疹、疮疖吗？</th>
                        <th class="centerth"><div id="option25_1"  data-option-no="25" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option25_2"  data-option-no="25" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option25_3"  data-option-no="25" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option25_4"  data-option-no="25" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option25_5"  data-option-no="25" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(26)您感到口干咽燥、总想喝水吗？</th>
                        <th class="centerth"><div id="option26_1"  data-option-no="26" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option26_2"  data-option-no="26" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option26_3"  data-option-no="26" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option26_4"  data-option-no="26" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option26_5"  data-option-no="26" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(27)您感到口苦或嘴里有异味吗?(指口苦或口臭) </th>
                        <th class="centerth"><div id="option27_1"  data-option-no="27" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option27_2"  data-option-no="27" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option27_3"  data-option-no="27" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option27_4"  data-option-no="27" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option27_5"  data-option-no="27" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(28)您腹部肥大吗?(指腹部脂肪肥厚)</th>
                        <th class="centerth">
                            <div id="option28_1"  data-option-no="28" class="optionNormal"><b>1</b></div>
                            <div>(腹围&lt;80cm,相当于2.4尺)</div>
                        </th>
                        <th class="centerth">
                            <div id="option28_2"  data-option-no="28" class="optionNormal"><b>2</b></div>
                            <div>(腹围80-85cm,2.4-2.55 尺)</div>
                        </th>
                        <th class="centerth">
                            <div id="option28_3"  data-option-no="28" class="optionNormal"><b>3</b></div>
                            <div>(腹围86-90cm,2.56-2.7 尺)</div>
                        </th>
                        <th class="centerth">
                            <div id="option28_4"  data-option-no="28" class="optionNormal"><b>4</b></div>
                            <div>(腹围91-105cm,2.71-3.15 尺)</div>
                        </th>
                        <th class="centerth">
                            <div id="option28_5"  data-option-no="28" class="optionNormal"><b>5</b></div>
                            <div>(腹围&gt;105cm,3.15尺)</div>
                        </th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(29)您吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西吗？(指不喜欢吃凉的食物,或吃了凉的食物后会不舒服)</th>
                        <th class="centerth"><div id="option29_1"  data-option-no="29" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option29_2"  data-option-no="29" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option29_3"  data-option-no="29" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option29_4"  data-option-no="29" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option29_5"  data-option-no="29" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(30)您有大便黏滞不爽、解不尽的感觉吗?(大便容易粘在马桶上或便坑壁上)</th>
                        <th class="centerth"><div id="option30_1"  data-option-no="30" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option30_2"  data-option-no="30" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option30_3"  data-option-no="30" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option30_4"  data-option-no="30" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option30_5"  data-option-no="30" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(31)您容易大便干燥吗?</th>
                        <th class="centerth"><div id="option31_1"  data-option-no="31" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option31_2"  data-option-no="31" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option31_3"  data-option-no="31" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option31_4"  data-option-no="31" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option31_5"  data-option-no="31" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(32)您舌苔厚腻或有舌苔厚厚的感觉吗?(如果自我感觉不清楚可由调查员观察后填写)</th>
                        <th class="centerth"><div id="option32_1"  data-option-no="32" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option32_2"  data-option-no="32" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option32_3"  data-option-no="32" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option32_4"  data-option-no="32" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option32_5"  data-option-no="32" class="optionNormal"><b>5</b></div></th>
                    </tr>
                    <tr>
                        <th class="leftth" colspan="5">(33)您舌下静脉瘀紫或增粗吗？(可由调查员辅助观察后填写)</th>
                        <th class="centerth"><div id="option33_1"  data-option-no="33" class="optionNormal"><b>1</b></div></th>
                        <th class="centerth"><div id="option33_2"  data-option-no="33" class="optionNormal"><b>2</b></div></th>
                        <th class="centerth"><div id="option33_3"  data-option-no="33" class="optionNormal"><b>3</b></div></th>
                        <th class="centerth"><div id="option33_4"  data-option-no="33" class="optionNormal"><b>4</b></div></th>
                        <th class="centerth"><div id="option33_5"  data-option-no="33" class="optionNormal"><b>5</b>
                        </div></th>
                    </tr>

                    <c:if test='${editflag == "edit"}'>
                        <tr class="guidanceClass" ><td colspan="10" ><hr style="margin:5px 0px 5px 5px;height:1px;color:#A9C3D0"/></tr>
                        <tr class="guidanceClass" >
                            <th class="centerth"><b>体质类型</b></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="qxz"><b>气虚质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="yaxz"><b>阳虚质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="yixz"><b>阴虚质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="tsz"><b>痰湿质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="srz"><b>湿热质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="xyz"><b>血瘀质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="qyz"><b>气郁质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="tbz"><b>特禀质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="phz"><b>平和质</b></a></th>
                        </tr>
                        <tr class="guidanceClass" >
                            <th class="centerth" style="padding-top: 75px;"> <b>中医药保健指导:</b></th>
                            <th class="leftth"><!-- 气虚质 -->
                                <div>1.得分<span id="tcmQiQuality"><b>${report.tcmQiQuality}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.qiFlag eq '1'}"><span id="qiFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.qiFlag != '1'}"><span id="qiFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.qiFlag eq '3'}"><span id="qiFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.qiFlag != '3'}"><span id="qiFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;" >
                                    <div><c:if test="${report.qiFlag eq '3' or report.qiFlag eq '1'}"> <ehr:dic-checkbox  dicmeta="CHG10510" name="qiQualityGuidance" isBr="true" value="${report.qiQualityGuidance}"></ehr:dic-checkbox>
                                    </c:if>
                                        <c:if test="${report.qiFlag != '3' and report.qiFlag != '1'}"> <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="qiQualityGuidance" isBr="true" value="${report.qiQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="qiQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="qiQualityGuidancestr" value="${report.qiQualityGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>元气不足,以疲乏、气短、自汗等表现为主要特征。</div>
                                <div><b>形体特征:</b>形体偏胖,肌肉松软不实。</div>
                                <div><b>常见表现:</b>平素语音低弱,气短懒言,容易疲乏,精神不振,易出汗,易头晕,活动量减少,舌淡红,舌边有齿痕,脉弱。</div>
                                <div><b>心理特征:</b>性格偏内向,喜安静。</div>
                                <div><b>发病倾向:</b>易患感冒、内脏下垂等病;病后康复缓慢。</div>
                                <div><b>对外界环境适应能力:</b>不耐受风、寒、暑、湿邪。</div>
                            </th>
                            <th class="leftth"><!-- 阳虚质 -->
                                <div>1.得分<span id="tcmYangQuality"><b>${report.tcmYangQuality}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.yangFlag eq '1'}"><span id="yangFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.yangFlag != '1'}"><span id="yangFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.yangFlag eq '3'}"><span id="yangFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.yangFlag != '3'}"><span id="yangFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.yangFlag eq '3' or report.yangFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yangQualityGuidance" isBr="true" value="${report.yangQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.yangFlag != '3' and report.yangFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yangQualityGuidance" isBr="true" disabled="true" value="${report.yangQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="yangQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="yangQualityGuidancestr" value="${report.yangQualityGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>阳气不足,以畏寒怕冷、手足不温等表现为主要特征。</div>
                                <div><b>形体特征:</b>肌肉松软不实。</div>
                                <div><b>常见表现:</b>平素畏冷,以胃脘、背部、腰膝多见,手足不温,喜热饮食,精神不振,舌淡胖嫩,脉沉迟。</div>
                                <div><b>心理特征:</b>性格内向,多沉静。</div>
                                <div><b>发病倾向:</b>易患痹证、咳喘、泄泻等病;感邪易从寒化。</div>
                                <div><b>对外界环境适应能力:</b>耐夏不耐冬;易感风、寒、湿邪。</div>
                            </th>
                            <th class="leftth"><!-- 阴虚质 -->
                                <div>1.得分<span id="tcmYinDeficiency"><b>${report.tcmYinDeficiency}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.yinDeficiencyFlag eq '1'}"><span id="yinDeficiencyFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.yinDeficiencyFlag != '1'}"><span id="yinDeficiencyFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.yinDeficiencyFlag eq '3'}"><span id="yinDeficiencyFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.yinDeficiencyFlag != '3'}"><span id="yinDeficiencyFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.yinDeficiencyFlag eq '3' or report.yinDeficiencyFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yinDeficiencyGuidance" isBr="true" value="${report.yinDeficiencyGuidance}"></ehr:dic-checkbox>
                                        </c:if>

                                        <c:if test="${report.yinDeficiencyFlag != '3' and report.yinDeficiencyFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yinDeficiencyGuidance" isBr="true" disabled="true" value="${report.yinDeficiencyGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="yinDeficiencyGuidanceDetail" style="display: none;">
							                    <input type="text" name="yinDeficiencyGuidancestr" value="${report.yinDeficiencyGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>阴液亏少,以口燥咽干、手足心热等表现为主要特征。</div>
                                <div><b>形体特征:</b>体形偏瘦。</div>
                                <div><b>常见表现:</b>眼睛干涩,口燥咽干,鼻微干,皮肤干燥、脱屑,偏好冷饮,大便干燥,舌红少津,脉细数。</div>
                                <div><b>心理特征:</b>性格外向,易急躁。</div>
                                <div><b>发病倾向:</b>易患便秘、燥证、消渴等病;感邪易从热化。</div>
                                <div><b>对外界环境适应能力:</b>耐冬不耐夏;不耐受暑、热、燥邪。</div>
                            </th>
                            <th class="leftth"><!-- 痰湿质 -->
                                <div>1.得分<span id="tcmPhlegmWetness"><b>${report.tcmPhlegmWetness}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.phlegmWetnessFlag eq '1'}"><span id="phlegmWetnessFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.phlegmWetnessFlag != '1'}"><span id="phlegmWetnessFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.phlegmWetnessFlag eq '3'}"><span id="phlegmWetnessFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.phlegmWetnessFlag != '3'}"><span id="phlegmWetnessFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.phlegmWetnessFlag eq '3' or report.phlegmWetnessFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="phlegmWetnessGuidance" isBr="true" value="${report.phlegmWetnessGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.phlegmWetnessFlag != '3' and report.phlegmWetnessFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" disabled="true" name="phlegmWetnessGuidance" isBr="true" value="${report.phlegmWetnessGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="phlegmWetnessGuidanceDetail" style="display: none;">
							                    <input type="text" name="phlegmWetnessGuidancestr" value="${report.phlegmWetnessGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>痰湿凝聚,以形体肥胖、腹部肥满、口黏苔腻等表现为主要特征。</div>
                                <div><b>形体特征:</b>体形肥胖,腹部肥满松软。</div>
                                <div><b>常见表现:</b>面部皮肤油脂较多,多汗且黏,胸闷,痰多,口黏腻或甜,喜食肥甘甜黏,苔腻,脉滑。</div>
                                <div><b>心理特征:</b>性格温和、稳重,善于忍耐。</div>
                                <div><b>发病倾向:</b>易患鼾症、中风、胸痹等病。</div>
                                <div><b>对外界环境适应能力:</b>对梅雨季节及湿重环境适应能力差。</div>
                            </th>
                            <th class="leftth"><!-- 湿热质 -->
                                <div>1.得分<span id="tcmHeatMedium"><b>${report.tcmHeatMedium}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.heatMediumFlag eq '1'}"><span id="heatMediumFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.heatMediumFlag != '1'}"><span id="heatMediumFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.heatMediumFlag eq '3'}"><span id="heatMediumFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.heatMediumFlag != '3'}"><span id="heatMediumFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.heatMediumFlag eq '3' or report.heatMediumFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="heatMediumGuidance" isBr="true" value="${report.heatMediumGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.heatMediumFlag != '3'and report.heatMediumFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="heatMediumGuidance" isBr="true" value="${report.heatMediumGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="heatMediumGuidanceDetail" style="display: none;">
							                    <input type="text" name="heatMediumGuidancestr" value="${report.heatMediumGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>湿热内蕴,以面垢油光、口苦、苔黄腻等表现为主要特征。</div>
                                <div><b>形体特征:</b>形体中等或偏瘦。</div>
                                <div><b>常见表现:</b>面垢油光,口苦口中异味,身重困倦,大便黏滞不畅,小便短黄, 男性易阴囊潮湿,女性易带下发黄,舌质偏红,苔黄腻,脉滑数。</div>
                                <div><b>心理特征:</b>性格多变,易烦恼。</div>
                                <div><b>发病倾向:</b>易患皮肤湿疹、疮疖、口疮、黄疸等病。</div>
                                <div><b>对外界环境适应能力:</b>对夏末秋初湿热气候,湿重或气温偏高环境较难适应。</div>
                            </th>
                            <th class="leftth"><!-- 血瘀质 -->
                                <div>1.得分<span id="tcmBloodQuality"><b>${report.tcmBloodQuality}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.bloodFlag eq '1'}"><span id="bloodFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.bloodFlag != '1'}"><span id="bloodFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.bloodFlag eq '3'}"><span id="bloodFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.bloodFlag != '3'}"><span id="bloodFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.bloodFlag eq '3' or report.bloodFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="bloodQualityGuidance" isBr="true" value="${report.bloodQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.bloodFlag != '3' and report.bloodFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="bloodQualityGuidance" isBr="true" value="${report.bloodQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="bloodQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="bloodQualityGuidancestr" value="${report.bloodQualityGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>血行不畅,以肤色晦黯、舌质紫黯等表现为主要特征。</div>
                                <div><b>形体特征:</b>胖瘦均见。</div>
                                <div><b>常见表现:</b>肤色、目眶晦黯,色素沉着,容易出现瘀斑,肢体麻木,好卧,口唇黯淡,舌黯或有瘀点,舌下络脉紫黯或增粗,脉涩。</div>
                                <div><b>心理特征:</b>性格偏浮躁,易健忘。</div>
                                <div><b>发病倾向:</b>易患胸痹、癥瘕及痛证、血证等。</div>
                                <div><b>对外界环境适应能力:</b>不耐受寒邪。</div>
                            </th>
                            <th class="leftth"><!-- 气郁质 -->
                                <div>1.得分<span id="tcmQiStagnation"><b>${report.tcmQiStagnation}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.qiStagnationFlag eq '1'}"><span id="qiStagnationFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.qiStagnationFlag != '1'}"><span id="qiStagnationFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.qiStagnationFlag eq '3'}"><span id="qiStagnationFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.qiStagnationFlag != '3'}"><span id="qiStagnationFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.qiStagnationFlag eq '3' or report.qiStagnationFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="qiStagnationGuidance" isBr="true" value="${report.qiStagnationGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.qiStagnationFlag != '3' and report.qiStagnationFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="qiStagnationGuidance" isBr="true" disabled="true" value="${report.qiStagnationGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="qiStagnationGuidanceDetail" style="display: none;">
							                    <input type="text" name="qiStagnationGuidancestr" value="${report.qiStagnationGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>气机郁滞,以神情抑郁、紧张焦虑等表现为主要特征。</div>
                                <div><b>形体特征:</b>形体瘦者为多。</div>
                                <div><b>常见表现:</b>神情抑郁,紧张焦虑,烦闷不乐,有孤独感,容易受到惊吓,舌淡红,苔薄白,脉弦。</div>
                                <div><b>心理特征:</b>性格不稳定,敏感多虑。</div>
                                <div><b>发病倾向:</b>易患不寐、郁证等。</div>
                                <div><b>对外界环境适应能力:</b>对精神刺激适应能力较差;不适应阴雨天气。</div>
                            </th>
                            <th class="leftth"><!-- 特禀质 -->
                                <div>1.得分<span id="tcmSpecialQuality"><b>${report.tcmSpecialQuality}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.specialFlag eq '1'}"><span id="specialFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.specialFlag != '1'}"><span id="specialFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.倾向是
                                    <c:if test="${report.specialFlag eq '3'}"><span id="specialFlag3" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.specialFlag != '3'}"><span id="specialFlag3" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.specialFlag eq '3' or report.specialFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="specialQualityGuidance" isBr="true" value="${report.specialQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>

                                        <c:if test="${report.specialFlag != '3' and report.specialFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="specialQualityGuidance" isBr="true" value="${report.specialQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="specialQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="specialQualityGuidancestr" value="${report.specialQualityGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>过敏体质者,禀赋不耐、异气外侵,以过敏反应等为主要特征;先天失常者为另一类特禀质,以禀赋异常为主要特征。</div>
                                <div><b>形体特征:</b>过敏体质者一般无特殊;先天失常者或有畸形,或有生理缺陷。</div>
                                <div><b>常见表现:</b>过敏体质者常见哮喘、风团、咽痒、鼻塞、喷嚏等;先天失常者患遗传性疾病者,有垂直遗传、先天性、家族性特征。</div>
                                <div><b>心理特征:</b>随禀质不同情况各异。</div>
                                <div><b>发病倾向:</b>过敏体质者易患哮喘、荨麻疹、过敏性鼻炎及药物过敏等;遗传疾病如血友病等。</div>
                                <div><b>对外界环境适应能力:</b>适应能力差,如过敏体质者对季节变化、异气外侵适应能力差,易引发宿疾。</div>
                            </th>
                            <th class="leftth"><!-- 平和质 -->
                                <div>1.得分<span id="tcmPeacefulQuality"><b>${report.tcmPeacefulQuality}</b></span></div>
                                <div>2.是
                                    <c:if test="${report.peacefulFlag eq '1'}"><span id="peacefulFlag1" style="font-size:150%;color:#ff8b00; "><b>✔</b></span></c:if>
                                    <c:if test="${report.peacefulFlag != '1'}"><span id="peacefulFlag1" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div>3.基本是
                                    <c:if test="${report.peacefulFlag eq '2'}"><span id="peacefulFlag2" style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if>
                                    <c:if test="${report.peacefulFlag != '2'}"><span id="peacefulFlag2" style="font-size:150%;color:#ff8b00;display: none;"><b>✔</b></span></c:if>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.peacefulFlag eq '2' or report.peacefulFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="peacefulQualityGuidance" isBr="true" value="${report.peacefulQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.peacefulFlag != '2' and report.peacefulFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="peacefulQualityGuidance" isBr="true" value="${report.peacefulQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="peacefulQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="peacefulQualityGuidancestr" value="${report.peacefulQualityGuidancestr}"
                                                       style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>阴阳气血调和,以体态适中、面色润泽、精力充沛等为主要特征。</div>
                                <div><b>形体特征:</b>体形匀称,无明显驼背</div>。
                                <div><b>常见表现:</b>面色、肤色润泽,头发较密,目光有神,不易疲劳,精力充沛,耐受寒热,睡眠良好,胃纳佳,二便正常,舌色淡红、苔薄白,脉和缓有力。</div>
                                <div><b>心理特征:</b>性格随和开朗。</div>
                                <div><b>发病倾向:</b>平素患病较少。</div>
                                <div><b>对外界环境适应能力:</b>对自然环境和社会环境适应能力较强。</div>
                            </th>
                        </tr>
                    </c:if>
                    <c:if test='${editflag == "view"}'>
                        <tr  ><td colspan="10" ><hr style="margin:5px 0px 5px 5px;height:1px;color:#A9C3D0"/></tr>
                        <tr  >
                            <th class="centerth"><b>体质类型</b></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="qxz_view"><b>气虚质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="yaxz_view"><b>阳虚质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="yixz_view"><b>阴虚质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="tsz_view"><b>痰湿质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="srz_view"><b>湿热质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="xyz_view"><b>血瘀质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="qyz_view"><b>气郁质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="tbz_view"><b>特禀质</b></a></th>
                            <th class="centerth"><a href="javascript:void(0)" style="color:black;"id="phz_view"><b>平和质</b></a></th>
                        </tr>
                        <tr>
                            <th class="centerth" style="padding-top: 75px;"><b>中医药保健指导:</b></th>
                            <th class="leftth"><!-- 气虚质 -->
                                <div>1.得分<span><b>${report.tcmQiQuality}</b></span></div>
                                <div>2.是<c:if test="${report.qiFlag =='1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.qiFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div><c:if test="${report.qiFlag eq '3' or report.qiFlag eq '1'}"> <ehr:dic-checkbox  dicmeta="CHG10510" name="qiQualityGuidance" isBr="true" value="${report.qiQualityGuidance}"></ehr:dic-checkbox>
                                    </c:if>
                                        <c:if test="${report.qiFlag != '3' and report.qiFlag != '1'}"> <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="qiQualityGuidance" isBr="true" value="${report.qiQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="qiQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="qiQualityGuidancestr"
                                                       value="${report.qiQualityGuidancestr}" style="width: 85px;"/></span>


                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>元气不足,以疲乏、气短、自汗等表现为主要特征。</div>
                                <div><b>形体特征:</b>形体偏胖,肌肉松软不实。</div>
                                <div><b>常见表现:</b>平素语音低弱,气短懒言,容易疲乏,精神不振,易出汗,易头晕,活动量减少,舌淡红,舌边有齿痕,脉弱。</div>
                                <div><b>心理特征:</b>性格偏内向,喜安静。</div>
                                <div><b>发病倾向:</b>易患感冒、内脏下垂等病;病后康复缓慢。</div>
                                <div><b>对外界环境适应能力:</b>不耐受风、寒、暑、湿邪。</div>

                            </th>
                            <th class="leftth"><!-- 阳虚质 -->
                                <div>1.得分<span><b>${report.tcmYangQuality}</b></span></div>
                                <div>2.是<c:if test="${report.yangFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.yangFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.yangFlag eq '3' or report.yangFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yangQualityGuidance" isBr="true" value="${report.yangQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.yangFlag != '3' and report.yangFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yangQualityGuidance" isBr="true" disabled="true" value="${report.yangQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>

                                    </div>
                                    <span class="yangQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="yangQualityGuidancestr"
                                                       style="width: 85px;" value="${report.yangQualityGuidancestr }"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>阳气不足,以畏寒怕冷、手足不温等表现为主要特征。</div>
                                <div><b>形体特征:</b>肌肉松软不实。</div>
                                <div><b>常见表现:</b>平素畏冷,以胃脘、背部、腰膝多见,手足不温,喜热饮食,精神不振,舌淡胖嫩,脉沉迟。</div>
                                <div><b>心理特征:</b>性格内向,多沉静。</div>
                                <div><b>发病倾向:</b>易患痹证、咳喘、泄泻等病;感邪易从寒化。</div>
                                <div><b>对外界环境适应能力:</b>耐夏不耐冬;易感风、寒、湿邪。</div>
                            </th>
                            <th class="leftth"><!-- 阴虚质 -->
                                <div>1.得分<span><b>${report.tcmYinDeficiency}</b></span></div>
                                <div>2.是<c:if test="${report.yinDeficiencyFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.yinDeficiencyFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.yinDeficiencyFlag eq '3' or report.yinDeficiencyFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yinDeficiencyGuidance" isBr="true" value="${report.yinDeficiencyGuidance}"></ehr:dic-checkbox>
                                        </c:if>

                                        <c:if test="${report.yinDeficiencyFlag != '3' and report.yinDeficiencyFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="yinDeficiencyGuidance" isBr="true" disabled="true" value="${report.yinDeficiencyGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="yinDeficiencyGuidanceDetail" style="display: none;">
							                    <input type="text" name="yinDeficiencyGuidancestr"
                                                       value="${report.yinDeficiencyGuidancestr}" style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>阴液亏少,以口燥咽干、手足心热等表现为主要特征。</div>
                                <div><b>形体特征:</b>体形偏瘦。</div>
                                <div><b>常见表现:</b>眼睛干涩,口燥咽干,鼻微干,皮肤干燥、脱屑,偏好冷饮,大便干燥,舌红少津,脉细数。</div>
                                <div><b>心理特征:</b>性格外向,易急躁。</div>
                                <div><b>发病倾向:</b>易患便秘、燥证、消渴等病;感邪易从热化。</div>
                                <div><b>对外界环境适应能力:</b>耐冬不耐夏;不耐受暑、热、燥邪。</div>
                            </th>
                            <th class="leftth"><!-- 痰湿质 -->
                                <div>1.得分<span><b>${report.tcmPhlegmWetness}</b></span></div>
                                <div>2.是<c:if test="${report.phlegmWetnessFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.phlegmWetnessFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.phlegmWetnessFlag eq '3' or report.phlegmWetnessFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="phlegmWetnessGuidance" isBr="true" value="${report.phlegmWetnessGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.phlegmWetnessFlag != '3' and report.phlegmWetnessFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" disabled="true" name="phlegmWetnessGuidance" isBr="true" value="${report.phlegmWetnessGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="phlegmWetnessGuidanceDetail" style="display: none;">
							                    <input type="text" name="phlegmWetnessGuidancestr"
                                                       value="${report.phlegmWetnessGuidancestr}" style="width: 85px;"/></span>


                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>痰湿凝聚,以形体肥胖、腹部肥满、口黏苔腻等表现为主要特征。</div>
                                <div><b>形体特征:</b>体形肥胖,腹部肥满松软。</div>
                                <div><b>常见表现:</b>面部皮肤油脂较多,多汗且黏,胸闷,痰多,口黏腻或甜,喜食肥甘甜黏,苔腻,脉滑。</div>
                                <div><b>心理特征:</b>性格温和、稳重,善于忍耐。</div>
                                <div><b>发病倾向:</b>易患鼾症、中风、胸痹等病。</div>
                                <div><b>对外界环境适应能力:</b>对梅雨季节及湿重环境适应能力差。</div>
                            </th>
                            <th class="leftth"><!-- 湿热质 -->
                                <div>1.得分<span><b>${report.tcmHeatMedium}</b></span></div>
                                <div>2.是<c:if test="${report.heatMediumFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.heatMediumFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.heatMediumFlag eq '3' or report.heatMediumFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="heatMediumGuidance" isBr="true" value="${report.heatMediumGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.heatMediumFlag != '3'and report.heatMediumFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="heatMediumGuidance" isBr="true" value="${report.heatMediumGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="heatMediumGuidanceDetail" style="display: none;">
							                    <input type="text" name="heatMediumGuidancestr"
                                                       value="${report.heatMediumGuidancestr}" style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>湿热内蕴,以面垢油光、口苦、苔黄腻等表现为主要特征。</div>
                                <div><b>形体特征:</b>形体中等或偏瘦。</div>
                                <div><b>常见表现:</b>面垢油光,口苦口中异味,身重困倦,大便黏滞不畅,小便短黄, 男性易阴囊潮湿,女性易带下发黄,舌质偏红,苔黄腻,脉滑数。</div>
                                <div><b>心理特征:</b>性格多变,易烦恼。</div>
                                <div><b>发病倾向:</b>易患皮肤湿疹、疮疖、口疮、黄疸等病。</div>
                                <div><b>对外界环境适应能力:</b>对夏末秋初湿热气候,湿重或气温偏高环境较难适应。</div>
                            </th>
                            <th class="leftth"><!-- 血瘀质 -->
                                <div>1.得分<span><b>${report.tcmBloodQuality}</b></span></div>
                                <div>2.是<c:if test="${report.bloodFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.bloodFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.bloodFlag eq '3' or report.bloodFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="bloodQualityGuidance" isBr="true" value="${report.bloodQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.bloodFlag != '3' and report.bloodFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="bloodQualityGuidance" isBr="true" value="${report.bloodQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="bloodQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="bloodQualityGuidancestr"
                                                       value="${report.bloodQualityGuidancestr}" style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>血行不畅,以肤色晦黯、舌质紫黯等表现为主要特征。</div>
                                <div><b>形体特征:</b>胖瘦均见。</div>
                                <div><b>常见表现:</b>肤色、目眶晦黯,色素沉着,容易出现瘀斑,肢体麻木,好卧,口唇黯淡,舌黯或有瘀点,舌下络脉紫黯或增粗,脉涩。</div>
                                <div><b>心理特征:</b>性格偏浮躁,易健忘。</div>
                                <div><b>发病倾向:</b>易患胸痹、癥瘕及痛证、血证等。</div>
                                <div><b>对外界环境适应能力:</b>不耐受寒邪。</div>
                            </th>
                            <th class="leftth"><!-- 气郁质 -->
                                <div>1.得分<span><b>${report.tcmQiStagnation}</b></span></div>
                                <div>2.是<c:if test="${report.qiStagnationFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.qiStagnationFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.qiStagnationFlag eq '3' or report.qiStagnationFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="qiStagnationGuidance" isBr="true" value="${report.qiStagnationGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.qiStagnationFlag != '3' and report.qiStagnationFlag != '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="qiStagnationGuidance" isBr="true" disabled="true" value="${report.qiStagnationGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="qiStagnationGuidanceDetail" style="display: none;">
							                    <input type="text" name="qiStagnationGuidancestr"
                                                       value="${report.qiStagnationGuidancestr}" style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>气机郁滞,以神情抑郁、紧张焦虑等表现为主要特征。</div>
                                <div><b>形体特征:</b>形体瘦者为多。</div>
                                <div><b>常见表现:</b>神情抑郁,紧张焦虑,烦闷不乐,有孤独感,容易受到惊吓,舌淡红,苔薄白,脉弦。</div>
                                <div><b>心理特征:</b>性格不稳定,敏感多虑。</div>
                                <div><b>发病倾向:</b>易患不寐、郁证等。</div>
                                <div><b>对外界环境适应能力:</b>对精神刺激适应能力较差;不适应阴雨天气。</div>
                            </th>
                            <th class="leftth"><!-- 特禀质 -->
                                <div>1.得分<span><b>${report.tcmSpecialQuality}</b></span></div>
                                <div>2.是<c:if test="${report.specialFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.倾向是<c:if test="${report.specialFlag == '3'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.specialFlag eq '3' or report.specialFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="specialQualityGuidance" isBr="true" value="${report.specialQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>

                                        <c:if test="${report.specialFlag != '3' and report.specialFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="specialQualityGuidance" isBr="true" value="${report.specialQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="specialQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="specialQualityGuidancestr"
                                                       value="${report.specialQualityGuidancestr}" style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>过敏体质者,禀赋不耐、异气外侵,以过敏反应等为主要特征;先天失常者为另一类特禀质,以禀赋异常为主要特征。</div>
                                <div><b>形体特征:</b>过敏体质者一般无特殊;先天失常者或有畸形,或有生理缺陷。</div>
                                <div><b>常见表现:</b>过敏体质者常见哮喘、风团、咽痒、鼻塞、喷嚏等;先天失常者患遗传性疾病者,有垂直遗传、先天性、家族性特征。</div>
                                <div><b>心理特征:</b>随禀质不同情况各异。</div>
                                <div><b>发病倾向:</b>过敏体质者易患哮喘、荨麻疹、过敏性鼻炎及药物过敏等;遗传疾病如血友病等。</div>
                                <div><b>对外界环境适应能力:</b>适应能力差,如过敏体质者对季节变化、异气外侵适应能力差,易引发宿疾。</div>
                            </th>
                            <th class="leftth"><!-- 平和质 -->
                                <div>1.得分<span><b>${report.tcmPeacefulQuality}</b></span></div>
                                <div>2.是<c:if test="${report.peacefulFlag == '1'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div>3.基本是<c:if test="${report.peacefulFlag == '2'}"><span style="font-size:150%;color:#ff8b00;"><b>✔</b></span></c:if></div>
                                <div style="border-top: 1px solid #A9C3D0;">
                                    <div>
                                        <c:if test="${report.peacefulFlag eq '3' or report.peacefulFlag eq '1'}">
                                            <ehr:dic-checkbox  dicmeta="CHG10510" name="peacefulQualityGuidance" isBr="true" value="${report.peacefulQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                        <c:if test="${report.peacefulFlag != '3' and report.peacefulFlag != '1'}">
                                            <ehr:dic-checkbox disabled="true" dicmeta="CHG10510" name="peacefulQualityGuidance" isBr="true" value="${report.peacefulQualityGuidance}"></ehr:dic-checkbox>
                                        </c:if>
                                    </div>
                                    <span class="peacefulQualityGuidanceDetail" style="display: none;">
							                    <input type="text" name="peacefulQualityGuidancestr"
                                                       value="${report.peacefulQualityGuidancestr}" style="width: 85px;"/></span>
                                </div>
                                <div style="border-top: 1px solid #A9C3D0;"><b>总体特征:</b>阴阳气血调和,以体态适中、面色润泽、精力充沛等为主要特征。</div>
                                <div><b>形体特征:</b>体形匀称,无明显驼背</div>。
                                <div><b>常见表现:</b>面色、肤色润泽,头发较密,目光有神,不易疲劳,精力充沛,耐受寒热,睡眠良好,胃纳佳,二便正常,舌色淡红、苔薄白,脉和缓有力。</div>
                                <div><b>心理特征:</b>性格随和开朗。</div>
                                <div><b>发病倾向:</b>平素患病较少。</div>
                                <div><b>对外界环境适应能力:</b>对自然环境和社会环境适应能力较强。</div>
                            </th>
                        </tr>
                    </c:if>
                    <tr style="line-height: 20px">
                        <th style="margin-top: 15px;"><b>健康指导:</b></th>
                        <th  colspan="9">
                            <textarea reg='{"maxlength":"4000"}' name="remarks" rows="5" cols="15" style="width: 100%">${report.remarks}</textarea>
                        </th>
                    </tr>
                    <tr><td colspan="10" ><hr style="margin:5px 0px 5px 5px;height:1px;color:#A9C3D0"/></tr>

                    <tr>
                        <th class="rightth" colspan="2"><span id="view"><label class="required">填表日期</label></span></th>
                        <td class="lefttd" colspan="4">
                            <c:choose>
                                <c:when test="${editflag == 'edit'}">
                                    <tag:dateInput reg="{'required':true}" name="createDate"  onlypast="true" style="width: 177px"  date="${report.createDate}"/>
                                </c:when>
                                <c:otherwise>
                                    <fmt:formatDate value="${report.createDate}" pattern="yyyy/MM/dd" />
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <th class="rightth" colspan="2">医生签名</th>
                        <td class="lefttd" colspan="4">
                            <c:choose>
                                <c:when test="${editflag == 'edit'}">
                                    <ehr:staff-list name="createStaffCode" value="${report.createStaffCode}" defaultval="Y" style="width:177px"/>
                                </c:when>
                                <c:otherwise>
                                    <ehr:staff-name staffCode="${report.createStaffCode}"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div></div>
    <div id="printDivId" style="display:none;">
        <jsp:include page="reportPrint.jsp"></jsp:include>
    </div>
</div>
<div id="result"></div>