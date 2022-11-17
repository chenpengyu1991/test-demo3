<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/studentExam/viewStudentExam.js"></script>

<c:if test="${operation eq 'view'}">
    <div class="toolbar">
        <a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
    </div>
</c:if>
<div ref="printPage">
    <style>
        .headTable {width: 650px;line-height: 200%;text-align: left}
        .headTable td input[type="text"] {border:none;border-bottom:1px solid #000;}
        .printTable {width: 645px;border: 1px solid; line-height: 200%; text-align: center}
        .printTable td {border: 1px solid;}

    </style>
    <c:forEach var="exam" items="${examList}">
        <div class="print" style="text-align: center;">
            <br/><br/>
            <h2 style="text-align: center">市中小学生健康检查表/个体报告单</h2>
            <br/>
            <div id="head" class="postcontentprint">
                <table class="headTable">
                    <tbody>
                    <tr>
                        <td>
                            学校 <input type="text" value="${exam.schoolName}" style="width: 120px;" readonly/>&nbsp;&nbsp;&nbsp;
                            入学年份 <input type="text" value="${exam.inYear}" style="width: 50px;" readonly/>&nbsp;&nbsp;&nbsp;
                            班级 <input type="text" value="${exam.classCode}" style="width: 70px;" readonly/>&nbsp;&nbsp;&nbsp;
                            学籍卡号 <input type="text" value="${exam.studentNo}" style="width: 120px;" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            姓名 <input type="text" value="${exam.name}" style="width: 70px;" readonly/>&nbsp;&nbsp;&nbsp;
                            性别 <input type="text" value='<ehr:dic dicmeta="GBT226112003" code="${exam.gender}"/>' style="width: 30px;"/>&nbsp;&nbsp;&nbsp;
                            出生日期 <input type="text" value='<fmt:formatDate value="${exam.birthday}" pattern="yyyy年MM月dd日"/>' style="width: 100px;" readonly/>&nbsp;&nbsp;&nbsp;
                            民族 <input type="text" value="${exam.nation}" style="width: 50px;" readonly/>&nbsp;&nbsp;&nbsp;
                            血型 <input type="text" value="${exam.aboBloodType}" style="width: 50px;" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            身份证号码： <input type="text" value="${exam.idcard}" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            父亲文化程度：<ehr:dic dicmeta="GBT46582006" code="${exam.fatherEducation}"/>&nbsp;&nbsp;&nbsp;
                            母亲文化程度 ：<ehr:dic dicmeta="GBT46582006" code="${exam.motherEducation}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            既往重要病史： ${exam.medicalHistory}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            预防接种： ${exam.vaccination}
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div id="examTable">
                <table class="printTable" cellspacing="0">
                    <colgroup>
                        <col style="width: 10%"/>
                        <col style="width: 15%"/>
                        <col style="width: 15%"/>
                        <col style="width: 15%"/>
                        <col style="width: 15%"/>
                        <col style="width: 15%"/>
                        <col style="width: 15%"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td>形体</td>
                        <td>身高</td><td style="text-align: left;">${exam.height} cm</td>
                        <td>体重</td><td style="text-align: left;">${exam.bodyWeight} kg</td>
                        <td>医生签名</td><td style="text-align: left;">${exam.bodyDoctor}</td>
                    </tr>
                    <tr>
                        <td rowspan="2">生理功能</td>
                        <td>血压</td><td colspan="3" style="text-align: left;">${exam.sbp} / ${exam.dbp} mmHg</td>
                        <td>脉搏</td><td style="text-align: left;">${exam.pulseRate} 次/分</td>
                    </tr>
                    <tr>
                        <td>肺活量</td><td colspan="3" style="text-align: left;">${exam.vitalCapacity} ml</td>
                        <td>医生签名</td><td style="text-align: left;">${exam.physicalDoctor}</td>
                    </tr>
                    <tr>
                        <td rowspan="3">眼科</td>
                        <td>裸眼视力右</td><td style="text-align: left;">${exam.rNakedEye}</td>
                        <td>裸眼视力左</td><td style="text-align: left;">${exam.lNakedEye}</td>
                        <td>辨色</td><td style="text-align: left;">${exam.colorVision eq '1' ? '正常' : '异常'}</td>
                    </tr>
                    <tr>
                        <td>沙眼右</td><td style="text-align: left;">
                        <ehr:dic dicmeta="HM00001" code="${exam.rTrachomaEye}"/>
                    </td>
                        <td>沙眼左</td>
                        <td style="text-align: left;">
                            <ehr:dic dicmeta="HM00001" code="${exam.lTrachomaEye}"/>
                        </td>
                        <td>结膜炎</td>
                        <td style="text-align: left;">
                            <ehr:dic dicmeta="HM00001" code="${exam.conjunctivitis}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>其他</td><td colspan="3" style="text-align: left;">${exam.eyeOther}</td>
                        <td>医生签名</td><td style="text-align: left;">${exam.eyeDoctor}</td>
                    </tr>
                    <tr>
                        <td rowspan="2">口腔</td>
                        <td>龋齿D</td>
                        <td>
                            <c:if test="${exam.decayedToothNoUpl > 0}">乳牙${exam.decayedToothNoUpl}颗<br/></c:if>
                            <c:if test="${exam.decayedToothNoUpr > 0}">恒牙${exam.decayedToothNoUpr}颗</c:if>
                        </td>
                        <td>龋缺M</td>
                        <td>
                            <c:if test="${exam.missingToothNoUpl > 0}">乳牙${exam.missingToothNoUpl}颗<br/></c:if>
                            <c:if test="${exam.missingToothNoUpr > 0}">恒牙${exam.missingToothNoUpr}颗</c:if>
                        </td>
                        <td>龋补F</td>
                        <td>
                            <c:if test="${exam.fillToothNoUpl > 0}">乳牙${exam.fillToothNoUpl}颗<br/></c:if>
                            <c:if test="${exam.fillToothNoUpr > 0}">恒牙${exam.fillToothNoUpr}颗</c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>牙周病</td><td style="text-align: left;"><ehr:dic dicmeta="HM00002" code="${exam.periodontalCehckResult}"/></td>
                        <td>其他</td><td style="text-align: left;">${exam.toothOther}</td>
                        <td>医生签名</td><td style="text-align: left;">${exam.toothDoctor}</td>
                    </tr>
                    <tr>
                        <td rowspan="2">内科</td>
                        <td>心</td><td colspan="3" style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.heartOther}">
                                <ehr:dic dicmeta="HM00003" code="${exam.heartCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.heartOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td>肝</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.liverOther}">
                                <ehr:dic dicmeta="HM00005" code="${exam.liverCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.liverOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    </tr>
                    <tr>
                        <td>肺</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.lungsOther}">
                                <ehr:dic dicmeta="HM00004" code="${exam.lungsCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.lungsOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td>脾</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.spleenOther}">
                                <ehr:dic dicmeta="HM00006" code="${exam.spleenCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.spleenOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td>医生签名</td><td style="text-align: left;">${exam.internalDoctor}</td>
                    </tr>
                    <tr>
                        <td rowspan="3">外科</td>
                        <td>头部</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.headOther}">
                                <ehr:dic dicmeta="HM00007" code="${exam.headCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.headOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td>颈部</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.neckOther}">
                                <ehr:dic dicmeta="HM00008" code="${exam.neckCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.neckOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td>胸部</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.chestOther}">
                                <ehr:dic dicmeta="HM00009" code="${exam.chestCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.chestOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    </tr>
                    <tr>
                        <td>脊柱</td><td style="text-align: left;">
                        <c:choose>
                        <c:when test="${empty exam.spineOther}">
                        <ehr:dic dicmeta="HM00010" code="${exam.spineCheckResult}"/></td>
                        </c:when>
                        <c:otherwise>
                            <ehr:tip>${exam.spineOther}</ehr:tip>
                        </c:otherwise>
                        </c:choose>
                        <td>四肢</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.limbsOther}">
                                <ehr:dic dicmeta="HM00011" code="${exam.limbsCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.limbsOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td>皮肤</td><td style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.skinOther}">
                                <ehr:dic dicmeta="HM00012" code="${exam.skinCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.skinOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    </tr>
                    <tr>
                        <td>淋巴结</td><td colspan="3" style="text-align: left;">
                        <c:choose>
                            <c:when test="${empty exam.lymphNodeOther}">
                                <ehr:dic dicmeta="HM00013" code="${exam.lymphNodeCheckResult}"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip>${exam.lymphNodeOther}</ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td>医生签名</td><td style="text-align: left;">${exam.surgeryDoctor}</td>
                    </tr>
                    <tr>
                        <td rowspan="3">化验</td>
                        <td>结核菌素试验<sup>*</sup></td><td colspan="2" style="text-align: left;">${exam.tuberculinTest}</td>
                        <td>血红蛋白<sup>**</sup></td><td colspan="2" style="text-align: left;"><c:if test="${exam.hemoglobinValue > 0}">${exam.hemoglobinValue} g/L</c:if></td>
                    </tr>
                    <tr>
                        <td>肝功能<sup>***</sup></td><td>谷丙转氨酶</td><td style="text-align: left;"><c:if test="${exam.serumGptValue > 0}">${exam.serumGptValue} U/L</c:if></td>
                        <td>胆红素</td><td colspan="2" style="text-align: left;"><c:if test="${exam.totalBilirubin > 0}">${exam.totalBilirubin} umol/L</c:if></td>
                    </tr>
                    <tr>
                        <td colspan="4">/</td>
                        <td>医生签名</td><td style="text-align: left;">${exam.labTestDoctor}</td>
                    </tr>
                    <tr>
                        <td>其他</td>
                        <td style="text-align: left;">${exam.otherCheckItem}</td><td colspan="3" style="text-align: left;">${exam.otherCheckResult}</td>
                        <td>医生签名</td><td style="text-align: left;">${exam.otherCheckDoctor}</td>
                    </tr>
                    <tr>
                        <td>体检结论</td>
                        <td colspan="6" style="text-align: left;padding-left:10px;">
                                ${exam.examinationResult}<br/>
                            <span style="float: right;;padding-right:10px;">主检医生签名：${exam.manaDoctorName}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>健康指导意见</td><td colspan="6" style="text-align: left ;padding-left:10px;">${exam.healthGuidance}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <br/>
            <div id="foot">
                <table style="width: 650px">
                    <tr>
                        <td colspan="2" style="text-align: left;">体检单位（盖章）：</td>
                        <td style="text-align: right">体检日期：<fmt:formatDate value="${exam.examDate}" pattern="yyyy年MM月dd日"/></td>
                    </tr>
                    <tr><td><br/></td></tr>
                    <tr>
                        <td style="width: 50px;vertical-align: top">【注】</td>
                        <td style="text-align: left">
                            *&nbsp;&nbsp;&nbsp;小学、初中入学新生必检项目<br/>
                            **&nbsp;&nbsp;小学生必要时进行的体检项目<br/>
                            ***&nbsp;寄宿制学生必要时进行的体检项目
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </c:forEach>
</div>