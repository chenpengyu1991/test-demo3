<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>

<script>
    $("#feedBackPrint").click(function(e){
    	e.preventDefault();
        $("#printDetailDiv").jqprint(
            {
                debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
                importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
                printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
                operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
            });
    });
</script>
<c:set var="personInfo" value="${personBasicInfoDto.personInfo}" scope="request"/>
<div class="toolbar">
    <!-- <a href="javascript:void(0)" id="feedBackPrint"><b class="dayin">打印</b></a> -->
    <a href="javascript:void(0)" id="feedBackPrint"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>
</div>
<div id="printDetailDiv">
    <style>
        @page {
            margin-top: 0mm; /* this affects the margin in the printer settings */
            margin-bottom: 0mm; /* this affects the margin in the printer settings */
        }
        #printDetailDiv table td{text-align:left;height:14px;line-height:14px;padding:2px;border:1px solid #000000;}
        #printDetailDiv table{width:90%; overflow:auto;clear:both;vertical-align:middle;border-collapse:collapse;font-size:12px}
    </style>
    <br/>
    <br/>
    <h2 align="center" style="">永城市<ehr:org code="${personInfo.inputOrganCode}"></ehr:org><br>健康服务结论反馈表</h2>
    <table>
        <tr>
            <td style="text-align: left;border: 0px;width:100px;padding-right: 250px;">
                <span style="float: left"><b>服务日期：</b><fmt:formatDate value="${personalPhyExamDTO.physiqueExamination.examinationDate}" pattern="yyyy/MM/dd"/></span>
            </td>
            <td style="text-align: left;border: 0px;width:80px">
                <span><b>责任医生：</b>${personalPhyExamDTO.physiqueExamination.manaDoctorName}</span>
            </td>
        </tr>
    </table>
    <table>
        <colgroup>
            <col style="width: 12%"/>
            <col style="width: 15%"/>
            <col style="width: 13%"/>
            <col style="width: 13%"/>
            <col style="width: 13%"/>
            <col style="width: 14%"/>
            <col style="width: 20%"/>
        </colgroup>
        <tr>
            <td style="text-align: center">姓名</td>
            <td style="text-align: center">${personInfo.name }</td>
            <td>性别</td>
            <td style="text-align: center"><ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}" /></td>
            <td style="text-align: center">出生年月</td>
            <td colspan="2">
                <fmt:formatDate value="${personInfo.birthday}" pattern="yyyy/MM/dd"/>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">身份证号</td>
            <td colspan="3">${personInfo.idcard}</td>
            <td style="text-align: center">联系方式</td>
            <td colspan="2">
                ${personInfo.phoneNumber}
            </td>
        </tr>
        <tr>
            <td style="text-align: center">现住址</td>
            <td style="text-align: left" colspan="6">
                <ehr:dic dicmeta="FS990001" code="${personInfo.patownShip}"></ehr:dic>
                <ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"></ehr:dic>
                <ehr:dic dicmeta="FS990001" code="${personInfo.paGroup}"></ehr:dic>
                <c:out value="${personInfo.pahouseNumber}"></c:out>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">人群类别</td>
            <td colspan="6">
                <c:if test="${personInfo.remarks eq '02'||personInfo.remarks eq '03'||personInfo.remarks eq '07'}">
                    <ehr:dic dicmeta="FS990026" code="${personInfo.remarks}"/>&nbsp;
                </c:if>
                <c:if test="${personBasicInfoDto.personInfo.maternalFlag eq '2'}">
                    孕产妇&nbsp;
                </c:if>
                <c:if test="${personInfo.remarks eq '08'}">
                    糖尿病患者&nbsp;
                </c:if>
                <%--<c:if test="${personInfo.remarks eq '121'}">
                    重症精神障碍&nbsp;
                </c:if>--%>
                <c:if test="${personBasicInfoDto.deformityFlag eq '2'}">
                    残疾人&nbsp;
                </c:if>
                <%--<c:if test="${personInfo.remarks eq '13'}">
                    结核病患者&nbsp;
                </c:if>--%>
                <c:if test="${personInfo.remarks eq '04'}">
                    老年人  高血压&nbsp;
                </c:if>
                <c:if test="${personInfo.remarks eq '05'}">
                    老年人  糖尿病&nbsp;
                </c:if>
                <c:if test="${personInfo.remarks eq '09'}">
                    高血压  糖尿病&nbsp;
                </c:if>
                <c:if test="${personInfo.remarks eq '06'}">
                    老年人  高血压  糖尿病&nbsp;
                </c:if>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">社会属性</td>
            <td style="text-align: left" colspan="6">
                <c:if test="${personInfo.veryPoverty eq '2'}">
                    贫困人口（
                    <c:if test="${personInfo.povertyType eq '1'}">
                        一般
                    </c:if>
                    <c:if test="${personInfo.povertyType eq '2'}">
                        低保
                    </c:if>
                    <c:if test="${personInfo.povertyType eq '3'}">
                       五保
                    </c:if>
                    ）
                </c:if>
                <c:if test="${personInfo.veryPoverty eq '2'}">
                    计划生育特困
                </c:if>
            </td>
        </tr>
        <tr>
            <td style="text-align: center" colspan="7"><b>服&nbsp;&nbsp;务&nbsp;&nbsp;内&nbsp;&nbsp;容</b></td>
        </tr>
        <tr>
            <td rowspan="2" style="text-align: center">一般状况</td>
            <td style="text-align: center">体温</td>
            <td style="text-align: center">${personalPhyExamDTO.physiqueExamination.temperature}℃</td>
            <td style="text-align: center">脉率</td>
            <td style="text-align: center">${personalPhyExamDTO.physiqueExamination.pulseRate}次/分钟</td>
            <td style="text-align: center">血压</td>
            <td style="text-align: center">${personalPhyExamDTO.physiqueExamination.leftSbp}/${personalPhyExamDTO.physiqueExamination.leftDbp}&nbsp;&nbsp;mmHg</td>
        </tr>
        <tr>
            <td style="text-align: center">身高</td>
            <td style="text-align: center">${personalPhyExamDTO.physiqueExamination.height}cm</td>
            <td style="text-align: center">体重</td>
            <td style="text-align: center">${personalPhyExamDTO.physiqueExamination.bodyWeight}kg</td>
            <td style="text-align: center">体质指数（BMI）</td>
            <td style="text-align: center">${personalPhyExamDTO.physiqueExamination.indexOfBodyCharacteristics}kg/㎡</td>
        </tr>
        <tr>
            <td rowspan="3" style="text-align: center">脏器功能</td>
            <td style="text-align: center">口腔</td>
            <td colspan="5">
                口唇&nbsp;<ehr:dic dicmeta="CV0410007" code="${personalPhyExamDTO.physiqueExamination.lipAppearanceCehckResult}"/>
                齿列&nbsp;${personalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag eq "0" ?"正常" :""}${personalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag eq "1" ?"异常" :""}
                ${personalPhyExamDTO.physiqueExamination.missingToothFlg eq "1" ? "缺齿" : ""}
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.missingToothFlg}">
                    <table style="width: 10%;margin-left: 0px;margin-right: 0px; display:inline">
                        <tr>
                            <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberUpl}</td>
                            <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberUpr}</td>
                        </tr>
                        <tr>
                            <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberDownl}</td>
                            <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberDownr}</td>
                        </tr>
                    </table>
                </c:if>
                ${personalPhyExamDTO.physiqueExamination.decayedToothFlg eq "1"?"龋齿":""}
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.decayedToothFlg}">
                    <table style="width: 10%;margin-left: 0px;margin-right: 0px;display:inline">
                        <tr>
                            <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberUpl}</td>
                            <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberUpr}</td>
                        </tr>
                        <tr>
                            <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberDownl}</td>
                            <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberDownr}</td>
                        </tr>
                    </table>
                </c:if>
                ${personalPhyExamDTO.physiqueExamination.dentureToothFlg eq "1"?"义齿":""}
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.dentureToothFlg}">
                    <table style="width: 10%;margin-left: 0px;margin-right: 0px;display:inline">
                        <tr>
                            <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberUpl}</td>
                            <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberUpr}</td>
                        </tr>
                        <tr>
                            <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberDownl}</td>
                            <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberDownr}</td>
                        </tr>
                    </table>
                </c:if>
                咽部&nbsp;<ehr:dic dicmeta="FS10183" code="${personalPhyExamDTO.physiqueExamination.pharynxCheckResult}"/>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">视力</td>
            <td colspan="5">
                左眼${personalPhyExamDTO.physiqueExamination.lNakedEye}
                右眼${personalPhyExamDTO.physiqueExamination.rNakedEye}
                （矫正视力:左眼${personalPhyExamDTO.physiqueExamination.lEyecorrection}
                右眼${personalPhyExamDTO.physiqueExamination.rEyecorrection})
            </td>
        </tr>
        <tr>
            <td style="text-align: center">听力</td>
            <td colspan="2"><ehr:dic dicmeta="FS10170" code="${personalPhyExamDTO.physiqueExamination.hearDetectResult}"/></td>
            <td style="text-align: center">运动功能</td>
            <td colspan="2"><ehr:dic dicmeta="FS10212" code="${personalPhyExamDTO.physiqueExamination.motorFuncState}"/></td>
        </tr>
        <tr>
            <td rowspan="5" style="text-align: center">查体</td>
            <td style="text-align: center">眼底</td>
            <td colspan="2">
                <c:if test="${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq '2'}">未检</c:if>
                ${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq"0" ?"正常":""}
                ${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq"1" ?"异常":""}
                ${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyDesc}
            </td>
            <td style="text-align: center">皮肤</td>
            <td colspan="2">
                ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"1" ?"正常":""}
                ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"2" ?"潮红":""}
                ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"3" ?"苍白":""}
                ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"4" ?"发绀":""}
                ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"5" ?"黄染":""}
                ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"6" ?"色素沉着":""}
                ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"7" ?"其他":""}
                ${personalPhyExamDTO.physiqueExamination.skinCheckDesc}
            </td>
        </tr>
        <tr>
            <td style="text-align: center">淋巴结</td>
            <td colspan="2">
                ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"1" ?"未触及 ":""}
                ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"2" ?"锁骨上 ":""}
                ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"3" ?"腋窝  ":""}
                ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"4" ?"其他  ":""}
                ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckDesc}
            </td>
            <td style="text-align: center">肺</td>
            <td colspan="2">
                桶状胸:${personalPhyExamDTO.physiqueExamination.barrelChest eq"1" ?"是":""}${personalPhyExamDTO.physiqueExamination.barrelChest eq"0" ?"否":""}
                呼吸音:${personalPhyExamDTO.physiqueExamination.lungsAnomalySound eq"1" ?"正常":""}${personalPhyExamDTO.physiqueExamination.lungsAnomalySound eq"0" ?"异常":""}${personalPhyExamDTO.physiqueExamination.lungsAnomalyDesc}
                啰音:${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"1" ?"无   ":""}${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"2" ?"干啰音 ":""}${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"3" ?"湿啰音 ":""}${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"4" ?"其它  ":""}${personalPhyExamDTO.physiqueExamination.lungsRaleDesc}
            </td>
        </tr>
        <tr>
            <td style="text-align: center">心脏</td>
            <td colspan="2">
                心率: ${personalPhyExamDTO.physiqueExamination.heartRate}次/分钟
                心律 :<ehr:dic dicmeta="FS10176" code="${personalPhyExamDTO.physiqueExamination.cardioverter}"/>
                杂音:${personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq"0" || personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq null ?"无":""}
                ${personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq"1" ?"有":""}
                <c:if test="${personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq '1'}">
                    <span id="heartMurmurDesc"> ${personalPhyExamDTO.physiqueExamination.heartMurmurDesc}次/分钟</span>
                </c:if>
            </td>
            <td style="text-align: center">腹部</td>
            <td colspan="2">
                压痛:${personalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq"0" ||personalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq null ?"无":""}
                ${personalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq"1" ?"有":""}
                ${personalPhyExamDTO.physiqueExamination.abdominalTendernessDesc}
                包块:${personalPhyExamDTO.physiqueExamination.abdominalMassFlag eq "0" || personalPhyExamDTO.physiqueExamination.abdominalMassFlag eq null ?"无":""}
                ${personalPhyExamDTO.physiqueExamination.abdominalMassFlag eq"1" ?"有":""}
                ${personalPhyExamDTO.physiqueExamination.abdominalMassDesc}
                肝大:${personalPhyExamDTO.physiqueExamination.liverFlag eq "0" || personalPhyExamDTO.physiqueExamination.liverFlag eq null ?"无":""}
                ${personalPhyExamDTO.physiqueExamination.liverFlag eq"1" ?"有":""}
                ${personalPhyExamDTO.physiqueExamination.liverDesc}
                脾大:${personalPhyExamDTO.physiqueExamination.splenomegalyFlag eq"0" || personalPhyExamDTO.physiqueExamination.splenomegalyFlag eq null ?"无":""}
                ${personalPhyExamDTO.physiqueExamination.splenomegalyFlag eq"1" ?"有":""}
                ${personalPhyExamDTO.physiqueExamination.splenomegalyDesc}
                移动性浊音:${personalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq"0" || personalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq null ?"无":""}
                ${personalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq"1" ?"有":""}
                ${personalPhyExamDTO.physiqueExamination.abdominalVoicedDesc}
            </td>
        </tr>
        <tr>
            <td style="text-align: center">妇科</td>
            <td colspan="5">
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag}">
                    外阴:<c:if test="${personalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq '2'}">未检</c:if>
                    ${personalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq"0" ?"未见异常 ":""}
                    ${personalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq"1" ?"有异常":""}
                    ${personalPhyExamDTO.physiqueExamination.vulvaAnomalyDesc}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag}">
                    阴道:<c:if test="${personalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq '2'}">未检</c:if>
                    ${personalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq"0" ?"未见异常   ":""}
                    ${personalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq"1" ?"有异常":""}
                    ${personalPhyExamDTO.physiqueExamination.vaginaAnomalyDesc}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag}">
                    宫颈:<c:if test="${personalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq '2'}">未检</c:if>
                    ${personalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq"0" ?"未见异常  ":""}
                    ${personalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq"1" ?"有异常":""}
                    ${personalPhyExamDTO.physiqueExamination.cervicalAnomalyDesc}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.corpusAnomalyFlag}">
                    宫体:<c:if test="${personalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq '2'}">未检</c:if>
                    ${personalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq"0" ?"未见异常 ":""}
                    ${personalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq"1" ?"有异常":""}
                    ${personalPhyExamDTO.physiqueExamination.corpusAnomalyDesc}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag}">
                    附件:<c:if test="${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq '2'}">未检</c:if>
                    ${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq"0" ?"未见异常 ":""}
                    ${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq"1" ?"有异常":""}
                    ${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyDesc}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">其他</td>
            <td colspan="5">${personalPhyExamDTO.physiqueExamination.otherCheckResult}</td>
        </tr>
        <tr>
            <td rowspan="12" style="text-align: center">辅助检查</td>
            <td style="text-align: center" rowspan="2">血常规</td>
            <td colspan="3">血红蛋白<u>&nbsp;${personalPhyExamDTO.physiqueExamination.hemoglobinValue}&nbsp;</u>g/L（正常110~160）</td>
            <td colspan="2">白细胞<u>&nbsp;${personalPhyExamDTO.physiqueExamination.leukocyteCount}&nbsp;</u>×10<sup>9</sup>/L（正常4~10）</td>
        </tr>
        <tr>
            <td colspan="3">血小板<u>&nbsp;${personalPhyExamDTO.physiqueExamination.plateletCount}&nbsp;</u>×10<sup>9</sup>/L（正常100~300）</td>
            <td colspan="2">其它<u>&nbsp;${personalPhyExamDTO.physiqueExamination.bloodRoutineOtherDesc}&nbsp;</u></td>
        </tr>
        <tr>
            <td style="text-align: center">尿常规</td>
            <td colspan="5">
                尿蛋白:${personalPhyExamDTO.physiqueExamination.urineProQuantitativeValue}
                &nbsp;&nbsp;&nbsp;&nbsp;
                尿糖:${personalPhyExamDTO.physiqueExamination.urineSugQuantitativeValue}
                &nbsp;&nbsp;&nbsp;&nbsp;
                尿酮体:${personalPhyExamDTO.physiqueExamination.ketQuantitativeValue}
                &nbsp;&nbsp;&nbsp;&nbsp;
                尿潜血:${personalPhyExamDTO.physiqueExamination.eryQuantitativeValue}
                &nbsp;&nbsp;&nbsp;&nbsp;
                其它:${personalPhyExamDTO.physiqueExamination.urineRoutinesOtherDesc}
            </td>
        </tr>
        <tr>
            <td style="text-align: center">空腹血糖</td>
            <td colspan="5"><u>&nbsp;<fmt:formatNumber type="number" pattern="#.00" value="${personalPhyExamDTO.physiqueExamination.fpgMmol}"/>&nbsp;</u>mmol/L（正常3.89~6.1）</td>
        </tr>
        <tr>
            <td style="text-align: center">心电图</td>
            <td colspan="5">
                <c:if test="${personalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq '2'}">未检</c:if>
                ${personalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq"0" ?"正常":""}
                ${personalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq"1" ?"异常":""}
                ${personalPhyExamDTO.physiqueExamination.ecgAnomalyDesc}
            </td>
        </tr>
        <tr>
            <td style="text-align: center" rowspan="3">肝功能</td>
            <td colspan="3">谷丙转氨酶<u>&nbsp;${personalPhyExamDTO.physiqueExamination.serumGptValue}&nbsp;</u>U/L（正常0~40）</td>
            <td colspan="2">谷草转氨酶<u>&nbsp;${personalPhyExamDTO.physiqueExamination.serumAstValue}&nbsp;</u>U/L（正常0~40）</td>
        </tr>
        <tr>
            <td colspan="3">白蛋白<u>&nbsp;${personalPhyExamDTO.physiqueExamination.albuminConcentration}&nbsp;</u>g/L（正常35~53）</td>
            <td colspan="2">总胆红素<u>&nbsp;${personalPhyExamDTO.physiqueExamination.totalBilirubin}&nbsp;</u>μmol/L（正常2~20.4）</td>
        </tr>
        <tr>
            <td colspan="5">其他<u>&nbsp;&nbsp;</u></td>
        </tr>
        <tr>
            <td style="text-align: center">肾功能</td>
            <td colspan="3">
                血清肌酐<u>&nbsp;${personalPhyExamDTO.physiqueExamination.creatinine}&nbsp;</u>μmol/L（正常44~120）
            </td>
            <td colspan="2">
                血尿素氮<u>&nbsp;${personalPhyExamDTO.physiqueExamination.bloodUreaNitrogenValue}&nbsp;</u>mmol/L（正常1.7~8.3)
            </td>
        </tr>
        <tr>
            <td style="text-align: center">血脂</td>
            <td colspan="3">
                总胆固醇<u>&nbsp;${personalPhyExamDTO.physiqueExamination.tc}&nbsp;</u>mmol/L（正常2.9~5.7）
            </td>
            <td colspan="2">
                甘油三酯<u>&nbsp;${personalPhyExamDTO.physiqueExamination.triglycerideValue}&nbsp;</u>mmol/L（正常0.42~1.71）
            </td>
        </tr>
        <tr>
            <td style="text-align: center">B超</td>
            <td colspan="5">
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag}">
                    腹部B超： ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq"2" ?"未检":""}
                    ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq"0" ?"正常":""}
                    ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq"1" ?"异常":""}
                    ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfDesc}
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag}">
                    其他B超：${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq"2" ?"未检":""}
                    ${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq"0" ?"正常":""}
                    ${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq"1" ?"异常":""}
                    ${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfDesc}
                </c:if>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">其他</td>
            <td colspan="5">
                ${personalPhyExamDTO.physiqueExamination.otherAuxiliaryExamination}
            </td>
        </tr>
        <tr>
            <td style="text-align: center" colspan="2">中医体质辨识</td>
            <td colspan="5">
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmPeacefulQuality}">
                    平和质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmPeacefulQuality}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmQiQuality}">
                    气虚质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmQiQuality}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmYangQuality}">
                    阳虚质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmYangQuality}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmYinDeficiency}">
                    阴虚质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmYinDeficiency}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmPhlegmWetness}">
                    痰湿质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmPhlegmWetness}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmHeatMedium}">
                    湿热质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmHeatMedium}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmBloodQuality}">
                    血瘀质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmBloodQuality}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmQiStagnation}">
                    气郁质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmQiStagnation}"/>
                </c:if>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmSpecialQuality}">
                    特秉质<ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmSpecialQuality}"/>
                </c:if>
            </td>
        </tr>
        <tr>
            <td style="text-align: center" colspan="2">其他</td>
            <td colspan="5">
            </td>
        </tr>
        <tr>
            <td style="text-align: center">健康评价</td>
            <td colspan="6">
                ${personalPhyExamDTO.healthEvaluateAnomalyFlg eq '0'?'体检无异常（结合临床表现综合评估）':''}
                ${personalPhyExamDTO.healthEvaluateAnomalyFlg eq '1'?'体检异常':''}
                <br>
                <c:if test="${not empty personalPhyExamDTO.physiqueExamination.id }">
                    <c:forEach items="${personalPhyExamDTO.healthEvaluateAnomalyList}" var="healEvaluateAnomaly" varStatus="status">
                        异常 ${healEvaluateAnomaly.healthEvaluateAnomalyDesc}<br>
                    </c:forEach>
                </c:if>
            </td>
        </tr>
        <tr>
            <td style="text-align: center"><b>健康指导</b></td>
            <td colspan="3">
                <c:if test="${personalPhyExamDTO.physiqueExamination.guideRegularFollowup eq '1' }">
                    <span>定期随访</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.guideIntoChronicDisease eq '1' }">
                    <span>纳入慢性病患者健康管理</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.guideSuggestionReview eq '1' }">
                    <span>建议复查</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.guideSuggestionReferral eq '1' }">
                    <span>建议转诊</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.includedSixManagement eq '1' }">
                    <span>纳入0-6岁儿童管理</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.maternalManagement eq '1' }">
                    <span>纳入孕产妇管理</span><br/>
                </c:if>
            </td>
            <td colspan="3">
                <b>危险因素控制：</b><br>
                <c:if test="${personalPhyExamDTO.physiqueExamination.riskQuitSmoking eq '1' }">
                    <span>戒烟</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.riskHealthDrink eq '1' }">
                    <span>健康饮酒</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.riskDiet eq '1' }">
                    <span>饮食</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.riskExercise eq '1' }">
                    <span>锻炼</span><br/>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.riskWeightReduction eq '1' }">
                    <span>减体重</span>
                    <c:if test="${personalPhyExamDTO.physiqueExamination.riskWeightReduction eq '1'}">
                        <span id="riskWeightTarget"> ${personalPhyExamDTO.physiqueExamination.riskWeightTarget}kg</span><br/>
                    </c:if>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.guideVaccination eq '1'}">
                    <span>建议接种疫苗</span>
                    <c:if test="${personalPhyExamDTO.physiqueExamination.guideVaccination eq '1'}">
                        <span id="guideVaccinationDesc"> ${personalPhyExamDTO.physiqueExamination.guideVaccinationDesc}</span><br/>
                    </c:if>
                </c:if>
                <c:if test="${personalPhyExamDTO.physiqueExamination.riskOther eq '1'}">
                    <span>其他</span>
                    <c:if test="${personalPhyExamDTO.physiqueExamination.riskOther eq '1'}">
                        <span id="riskOtherDesc"> ${personalPhyExamDTO.physiqueExamination.riskOtherDesc}</span><br/>
                    </c:if>
                </c:if>
            </td>
        </tr>
    </table>
    <p style="font-size:14px;width: 85%;line-height:18px;margin-top: 5px;margin-bottom:2px;margin-left: 50px;letter-spacing:2px">&#8195;&#8195;感谢您对我们工作的信任与支持！为您提供的上述服务，是您应该享受的国家政策，不用承担任何 费用。我们已经为您建立了电子居民健康档案，本次体检结果仅供参考，如果您对体检结果有任何疑问或身体有不适，请及时与家庭医生或就近的村卫生室/卫生服务站联系；也可以通过他们了解您的健康档案信息，进行健康咨询或寻求就诊帮助。<br></p>
    <p style="font-size:14px;width: 85%;line-height:18px;margin-bottom:2px;margin-left: 50px;letter-spacing:2px">&#8195;&#8195;&#8195;祝您身体健康！家庭幸福！<br>
        &#8195;&#8195;&#8195;咨询时间：上午8：00-11：30     下午14：30--17：00<br>
    </p>
    <p style="font-size:14px;width: 85%;line-height:18px;margin-bottom:2px;margin-left: 50px;letter-spacing:2px">&#8195;&#8195;&#8195;联系电话：<span style="letter-spacing:0px">_____________</span></p>



</div>

