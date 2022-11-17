<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #coronaryPrintFollowUp .table-01{width:100%;height:10%; overflow:auto;clear:both;vertical-align:middle;}
    #coronaryPrintFollowUp .table-01{background:#FFF}
    #coronaryPrintFollowUp .table-01 table{width:100%; border-left:#C8BAAE solid 1px;border-top:#C8BAAE solid 1px;border-collapse:collapse;}
    #coronaryPrintFollowUp .table-01 td{text-align:left;height:24px;line-height:24px;border:1px solid #ccc;padding:2px;}
    #coronaryPrintFollowUp .table-01 th{border:1px solid #CCC;background:#EFF7FF;font-weight:normal;}
    #coronaryPrintFollowUp .table-01 td.td_gray{background:#EEE;}
    #coronaryPrintFollowUp .table-01 td.h_top{background:#66B9DB; font-weight:bold;text-align:center;color:#FFF;}
</style>

<div id="coronaryPrintFollowUp" style="display: none">
    <h3 align="center">冠心病常规随访服务记录表</h3>
    <span style="float:left;margin-top: 5px;"><b>姓名:</b>${personInfo.name}</span>
    <span style="float:right;margin-top: 5px"><b>身份证号:</b>${personInfo.idcard}</span>
    <table border="1" cellpadding="0" cellspacing="0" style="clear:both; width: 100%;font-size: 14px" class="table-01">
        <colgroup>
            <col style="width: 25%;" />
            <col style="width: 25%;" />
            <col style="width: 25%;" />
            <col style="width: 25%;" />
        </colgroup>
        <tr>
            <th colspan="2">随访日期</th>
            <td colspan="2"><fmt:formatDate value="${strtum.visitDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <th colspan="2">随访方式</th>
            <td colspan="2"><ehr:dic dicmeta="DMD00026" code="${strtum.visitWayCode}" /></td>
        </tr>
        <tr>
            <th rowspan="3">生理生化指标</th>
            <th>血压检测标志</th>
            <td colspan="2">
                <c:choose>
                    <c:when test="${strtum.bpExamFlag !='1'}">未做</c:when>
                    <c:otherwise>${strtum.sbp}~${strtum.dbp} mmHg</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th>血糖检测</th>
            <td colspan="2">
                <c:choose>
                    <c:when test="${strtum.bloodGlucoseFalg !='1'}">未做</c:when>
                    <c:otherwise>
                        空腹血糖值：${strtum.fpg} mmol/L<br/>
                        餐后2小时血糖值：${strtum.gluValue} mmol/L<br/>
                        糖化血红蛋白值：${strtum.hgb} %<br/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th>血脂检测</th>
            <td colspan="2">
                <c:choose>
                    <c:when test="${strtum.bloodFat !='1'}">未做</c:when>
                    <c:otherwise>
                        总胆固醇值：${strtum.tc} mmol/L<br/>
                        甘油三酯值：${strtum.triglycerideValue} mmol/L<br/>
                        血清低密度脂蛋白胆固醇检测值：${strtum.ldlcDetectValue} mmol/L<br/>
                        血清高密度脂蛋自胆固醇检测值：${strtum.hdlcDetectValue} mmol/L<br/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th rowspan="5">最新健康状况</th>
            <th>体格检查阳性体征</th>
            <td colspan="2">${strtum.positiveSigns}</td>
        </tr>
        <tr>
            <th>化验</th>
            <td colspan="2">${strtum.assay}</td>
        </tr>
        <tr>
            <th>心电图</th>
            <td colspan="2">${strtum.ecg}</td>
        </tr>
        <tr>
            <th>特殊检查</th>
            <td colspan="2">${strtum.specialExam}</td>
        </tr>
        <tr>
            <th>其他状况/th>
            <td colspan="2">${strtum.otherStatus}</td>
        </tr>
        <tr>
            <th rowspan="8">自我评价</th>
            <th>吸烟量与以前相比</th>
            <td colspan="2"><ehr:dic code="${strtum.smoking}" dicmeta="DMD00028"/></td>
        </tr>
        <tr>
            <th>饮酒量与以前相比</th>
            <td colspan="2"><ehr:dic code="${strtum.drinking}" dicmeta="DMD00028"/></td>
        </tr>
        <tr>
            <th>肉类较以前摄入</th>
            <td colspan="2"><ehr:dic code="${strtum.meat}" dicmeta="DMD00028"/></td>
        </tr>
        <tr>
            <th>蔬菜水果较以前摄入</th>
            <td colspan="2"><ehr:dic code="${strtum.produce}" dicmeta="DMD00028"/></td>
        </tr>
        <tr>
            <th>体力活动较以前</th>
            <td colspan="2"><ehr:dic code="${strtum.physicalActivity}" dicmeta="DMD00028"/></td>
        </tr>
        <tr>
            <th>测心电图次数</th>
            <td colspan="2"><ehr:dic code="${strtum.ecgTimes}" dicmeta="DMD00029"/></td>
        </tr>
        <tr>
            <th>测血生化指标次数</th>
            <td colspan="2"><ehr:dic code="${strtum.bloodTimes}" dicmeta="DMD00030"/></td>
        </tr>
        <tr>
            <th>月平均药费支出（元）</th>
            <td colspan="2"><ehr:dic code="${strtum.drugPayments}" dicmeta="DMD00031"/></td>
        </tr>
        <c:choose>
        <c:when test="${strtum.bpDrugFlag=='1'}">
            <tr>
                <th rowspan="3">控制血压用药情况</th>
                <th>第一种药物名称/使用方法</th>
                <td colspan="2">${strtum.bpDrugNameFirst} / ${strtum.bpDrugMethodFirst}</td>
            </tr>
            <tr>
                <th>第二种药物名称/使用方法</th>
                <td colspan="2">${strtum.bpDrugNameSecond} / ${strtum.bpDrugMethodSecond}</td>
            </tr>
            <tr>
                <th>第三种药物名称/使用方法</th>
                <td colspan="2">${strtum.bpDrugNameThird} / ${strtum.bpDrugMethodThird}</td>
            </tr>
        </c:when>
        <c:when test="${strtum.bpDrugFlag=='2'}">
            <tr>
                <th>控制血压用药情况</th>
                <td>未规律用药</td>
                <th>未规律用药原因</th>
                <td><ehr:dic code="${strtum.bpDrugNoRegularReason }" dicmeta="DMD00033"/> </td>
            </tr>
        </c:when>
        <c:otherwise>
            <tr>
                <th colspan="2">控制血压用药情况</th>
                <td colspan="2">不用药</td>
            </tr>
        </c:otherwise>
    </c:choose>
        <c:choose>
            <c:when test="${strtum.bgDrugFlag=='1'}">
                <tr>
                    <th rowspan="3">控制血糖用药情况</th>
                    <th>第一种药物名称/使用方法</th>
                    <td colspan="2">${strtum.bgDrugNameFirst} / ${strtum.bgDrugMethodFirst}</td>
                </tr>
                <tr>
                    <th>第二种药物名称/使用方法</th>
                    <td colspan="2">${strtum.bgDrugNameSecond} / ${strtum.bgDrugMethodSecond}</td>
                </tr>
                <tr>
                    <th>第三种药物名称/使用方法</th>
                    <td colspan="2">${strtum.bgDrugNameThird} / ${strtum.bgDrugMethodThird}</td>
                </tr>
            </c:when>
            <c:when test="${strtum.bgDrugFlag=='2'}">
                <tr>
                    <th>控制血糖用药情况</th>
                    <td>未规律用药</td>
                    <th>未规律用药原因</th>
                    <td><ehr:dic code="${strtum.bgDrugNoRegularReason }" dicmeta="DMD00033"/> </td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <th colspan="2">控制血糖用药情况</th>
                    <td colspan="2">不用药</td>
                </tr>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${strtum.bfDrugFlag=='1'}">
                <tr>
                    <th rowspan="3">控制血脂用药情况</th>
                    <th>第一种药物名称/使用方法</th>
                    <td colspan="2">${strtum.bfDrugNameFirst} / ${strtum.bfDrugMethodFirst}</td>
                </tr>
                <tr>
                    <th>第二种药物名称/使用方法</th>
                    <td colspan="2">${strtum.bfDrugNameSecond} / ${strtum.bfDrugMethodSecond}</td>
                </tr>
                <tr>
                    <th>第三种药物名称/使用方法</th>
                    <td colspan="2">${strtum.bfDrugNameThird} / ${strtum.bfDrugMethodThird}</td>
                </tr>
            </c:when>
            <c:when test="${strtum.bfDrugFlag=='2'}">
                <tr>
                    <th>控制血脂用药情况</th>
                    <td>未规律用药</td>
                    <th>未规律用药原因</th>
                    <td><ehr:dic code="${strtum.bfDrugNoRegularReason }" dicmeta="DMD00033"/> </td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <th colspan="2">控制血脂用药情况</th>
                    <td colspan="2">不用药</td>
                </tr>
            </c:otherwise>
        </c:choose>
        <tr>
            <th colspan="2">非药物治疗措施</th>
            <td colspan="2">
                <c:forEach var="nonDrug" items="${strtum.nonDrugsArray}" varStatus="status">
                    <c:choose>
                        <c:when test="${nonDrug eq '9'}">无</c:when>
                        <c:when test="${nonDrug eq '8'}">${strtum.nonDrugsOther}</c:when>
                        <c:otherwise><ehr:dic code="${nonDrug}" dicmeta="DMD00054"/></c:otherwise>
                    </c:choose>
                    <c:if test="${!status.last}">,</c:if>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <th colspan="2">针对性健康教育</th>
            <td colspan="2">${strtum.heducation}</td>
        </tr>
        <tr>
            <th rowspan="2">本次病情总体评价与转归</th>
            <th>结论</th>
            <td colspan="2"><ehr:dic code="${strtum.conclusion}" dicmeta="DMD00035"/></td>
        </tr>
        <tr>
            <th>患者（或亲属）确认</th>
            <td colspan="2">${strtum.affirmPerson}</td>
        </tr>
        <tr>
            <th colspan="2">随访医生签名</th>
            <td colspan="2">${strtum.createDoctorName}</td>
        </tr>
        <tr>
            <th colspan="2">随访机构</th>
            <td colspan="2"><ehr:org code="${strtum.createOrganCode}"/></td>
        </tr>
        <tr>
            <th colspan="2">备注</th>
            <td colspan="2">${strtum.comments}</td>
        </tr>
    </table>
</div>