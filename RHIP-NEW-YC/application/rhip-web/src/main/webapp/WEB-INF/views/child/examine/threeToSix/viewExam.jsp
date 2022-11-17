<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-26
  Time: 下午12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
    <ul>
        <li style="text-align: center; font-size: 25px;">3～6岁儿童健康检查记录表</li>
    </ul>
    <br/>
    <table>
        <colgroup>
            <col style="width: 10%;"/>
            <col style="width: 15%;"/>
            <col style="width: 5%;"/>
            <col style="width: 10%;"/>
            <col style="width: 5%;"/>
            <col style="width: 5%;"/>
            <col style="width: 10%;"/>
            <col style="width: 15%;"/>
        </colgroup>
        <tr>
            <th>出生编号：</th>
            <td><c:out value="${exam.babyCardNo}"/></td>
            <th>姓名：</th>
            <td><c:out value="${exam.name}"/></td>
            <th>性别：</th>
            <td><ehr:dic code="${exam.gender}" dicmeta="GBT226112003"/></td>
            <th>体检时间：</th>
            <td>
                <fmt:formatDate value="${exam.visitDate}" pattern="yyyy/MM/dd"/>
            </td>
        </tr>
    </table>
    <div class="table-basic">
        <table>
            <colgroup>
                <col style="width: 20%;"/>
                <col style="width: 30%;"/>
                <col style="width: 20%;"/>
                <col style="width: 30%;"/>
            </colgroup>
            <tr>
                <th>月龄</th>
                <td><c:out value="${exam.cPhysicalExamAge}"/></td>
                <th>出生日期</th>
                <td><fmt:formatDate value="${exam.birthday}" pattern="yyyy/MM/dd"/></td>
            </tr>
            <tr>
                <th>身份证件号码</th>
                <td><c:out value="${exam.idCard}"/></td>
                <th>母亲身份证件号码</th>
                <td><c:out value="${exam.motherIdcard}"/></td>

            </tr>
            <tr>
                <th >体重(kg)</th>
                <td><c:out value="${exam.bodyWeight}"/></td>
                <th>年龄别体重评价结果</th>
                <td><ehr:dic code="${exam.evaluationresultcode}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>身高(cm)</th>
                <td><c:out value="${exam.stature}"></c:out></td>
                <th>年龄别身高评价结果</th>
                <td><ehr:dic code="${exam.heightEvaluationResult}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>体格发育评价</th>
                <td colspan="3">
                    <ehr:dic code="${exam.physiquegrowthCode}" dicmeta="CV0410020"/>
                </td>
            </tr>
            <tr>
                <th>体重/身高</th>
                <td><c:out value="${exam.bodyWeightStature}"></c:out></td>
                <th>体重别身高评价结果</th>
                <td><ehr:dic code="${exam.weightHeightResult}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>视力</th>
                <td>
                    <c:if test="${not empty exam.lNakedEye and not empty exam.rNakedeye}">
                        左眼：${exam.lNakedEye} 右眼：${exam.rNakedeye}
                    </c:if>
                </td>
                <th>听力筛查结果</th>
                <td>
                    <c:if test="${'1' eq exam.hearingScreeningResults}">
                        <c:out value="通过"/>
                    </c:if>
                    <c:if test="${'2' eq exam.hearingScreeningResults}">
                        <c:out value="未过"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>牙数(颗)</th>
                <td>
                    <c:out value="${exam.teethNumber}"/>
                </td>
                <th>龋齿数(颗)</th>
                <td>
                    <c:out value="${exam.decayedToothNumber}"/>
                </td>
            </tr>
            <tr>
                <th>胸部检查</th>
                <td>
                    <c:if test="${!empty exam.heartLungAnomalySign}">
                        <c:out value='${exam.heartLungAnomalySign eq "1" ? "未见异常" : "有异常"}'/>
                        <c:if test="${exam.heartLungAnomalySign ne '1'}">
                            <br/><c:out value="${exam.heartLungAnomalyDesc}"/>
                        </c:if>
                    </c:if>
                </td>
                <th>腹部检查</th>
                <td>
                    <c:if test="${!empty exam.abdominalPalp}">
                        <c:out value='${exam.abdominalPalp eq "1" ? "未见异常" : "有异常"}'/>
                    </c:if>
                    <c:if test="${exam.abdominalPalp ne '1'}">
                        <br/><c:out value="${exam.abdominalPalpAnomalyDesc}"/>
                    </c:if>
                </td>
            </tr>
                <th>血红蛋白值(g/L)</th>
                <td colspan="3">
                    <c:out value="${exam.hemoglobinValue}"/>
                </td>
            </tr>
            <tr>
                <th>其他</th>
                <td colspan="3">
                    <c:out value="${exam.other}"/>
                </td>
            </tr>
            <tr>
                <th>发育评估</th>
                <td colspan="3"> <ehr:dic code="${exam.childDevelopmentEvaluation}" dicmeta="CV0510110"/></td>
            </tr>
            <tr>
                <th>两次随访间患病标志</th>
                <td>
                    <c:if test="${!empty exam.followupSick}">
                        <c:out value='${exam.followupSick eq "1" ? "无" : "有"}'/>
                    </c:if>
                </td>
                <th>两次随访间患肺炎住院次数</th>
                <td>
                    <c:out value="${exam.pneumoniaHospitalizations}"/>
                </td>
            </tr>
            <tr>
                <th>两次随访间患腹泻住院次数</th>
                <td>
                    <c:out value="${exam.diarrheaHospitalizations}"/>
                </td>
                <th>两次随访间因外伤住院次数</th>
                <td>
                    <c:out value="${exam.traumaHospitalizations}"/>
                </td>
            </tr>
            <tr>
                <th>两次随访间患其他疾病情况</th>
                <td colspan="3">
                    <c:out value="${exam.otherDiseaseState}"/>
                </td>
            </tr>
            <tr>
                <th>转诊建议</th>
                <td <c:if test='${exam.referralFlag eq "1"}'> colspan="3" </c:if>>
                    <c:if test="${!empty exam.referralFlag}">
                        <c:out value='${exam.referralFlag eq "2" ? "有" : "无"}'/>
                    </c:if>
                </td>
                <c:if test='${exam.referralFlag eq "2"}'>
                    <th>转入机构科室名称</th>
                    <td>
                        <c:out value="${exam.referralHospitalName}"/>
                        <c:out value="${exam.referralDeptName}"/>
                    </td>
                </c:if>
            </tr>
            <c:if test='${exam.referralFlag eq "2"}'>
                <tr>
                    <th>转诊原因</th>
                    <td colspan="3">
                        <c:out value="${exam.referralReason}"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>儿童健康指导类别</th>
                <td colspan="3">
                    <ehr:dic code="${exam.guidanceCategory}" dicmeta="CV0600310"/>
                </td>
            </tr>
            <tr>
                <th>处理及指导意见</th>
                <td colspan="3">
                    <c:out value="${exam.mgOpinion}"/>
                </td>
            </tr>
            <tr>
                <th>下次随访时间：</th>
                <td>
                    <fmt:formatDate value="${exam.nextSupervisionDate}" pattern="yyyy/MM/dd"/>
                </td>
                <th>随访医生签名</th>
                <td colspan="3">
                    <ehr:staff-name staffCode="${exam.visitDoctorCode}"/>
                </td>
            </tr>
        </table>
    </div>
</div>
