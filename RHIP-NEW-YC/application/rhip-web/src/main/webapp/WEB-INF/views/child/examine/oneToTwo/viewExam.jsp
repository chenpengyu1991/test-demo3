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
        <li style="text-align: center; font-size: 25px;">12～30月龄儿童健康检查记录表</li>
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
                <th>身长(高)(cm)</th>
                <td><c:out value="${exam.stature}"></c:out></td>
                <th>年龄别身高评价结果</th>
                <td><ehr:dic code="${exam.heightEvaluationResult}" dicmeta="CV0510006"/></td>
            </tr>
            <%--<tr>
                <th>头围(cm)</th>
                <td colspan="3">
                    <c:out value="${exam.headCircumference}" />
                </td>
            </tr>--%>
            <tr>
                <th>儿童面色</th>
                <td >
                    <ehr:dic code="${exam.childrenComplexionCode}" dicmeta="CV0410008"/>
                    <c:if test="${'9' eq exam.childrenComplexionCode}">
                        <br><c:out value="${exam.complexionOther}"/>
                    </c:if>
                </td>
                <th>皮肤检查异常</th>
                <td >
                    <c:if test="${!empty exam.skinInspectionAnomalySign}">
                        <c:out value='${exam.skinInspectionAnomalySign eq "1" ? "未见异常" : "异常"}'/>
                        <c:if test="${exam.skinInspectionAnomalySign ne '1'}">
                            <br/><c:out value="${exam.skinInspectionAnomalyDesc}"/>
                        </c:if>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>前囟闭合</th>
                <td colspan="3">
                    <c:if test="${!empty exam.afClosureFlag}">
                        <c:out value='${exam.afClosureFlag eq "11" ? "未闭合" : "闭合"}'/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>前囟横径(cm)</th>
                <td>
                    <c:out value="${exam.afTransverseDiameter}"/>
                </td>
                <th>前囟纵径(cm)</th>
                <td>
                    <c:out value="${exam.bregmaDiameter}"/>
                </td>
            </tr>
            <tr>
                <th>眼睛检查异常</th>
                <td colspan="3">
                    <c:if test="${!empty exam.eyeappearanceSign}">
                        <c:out value='${exam.eyeappearanceSign eq "1" ? "未见异常" : "异常"}'/>
                        <c:if test="${exam.eyeappearanceSign ne '1'}">
                            <br/><c:out value="${exam.eyeAppearanceInspectionDesc}"/>
                        </c:if>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>耳外观检查异常</th>
                <td>
                    <c:if test="${!empty exam.earappearanceSign}">
                        <c:out value='${exam.earappearanceSign eq "1" ? "未见异常" : "异常"}'/>
                        <c:if test="${exam.earappearanceSign ne '1'}">
                            <br/><c:out value="${exam.earappearanceDesc}"/>
                        </c:if>
                    </c:if>
                </td>
                <th>新生儿听力筛查结果</th>
                <td>
                    <ehr:dic code="${exam.hearingScreeningResults}" dicmeta="MH00055"/>
                </td>
            </tr>
            <tr>
                <th>出牙数(颗)</th>
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
                        <c:out value='${exam.heartLungAnomalySign eq "1" ? "未见异常" : "异常"}'/>
                        <c:if test="${exam.heartLungAnomalySign ne '1'}">
                            <br/><c:out value="${exam.heartLungAnomalyDesc}"/>
                        </c:if>
                    </c:if>
                </td>
                <th>腹部检查</th>
                <td>
                    <c:if test="${!empty exam.abdominalPalp}">
                        <c:out value='${exam.abdominalPalp eq "1" ? "未见异常" : "异常"}'/>
                    </c:if>
                    <c:if test="${exam.abdominalPalp ne '1'}">
                        <br/><c:out value="${exam.abdominalPalpAnomalyDesc}"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>四肢异常</th>
                <td>
                    <c:if test="${!empty exam.limbActivityAnomalySign}">
                        <c:out value='${exam.limbActivityAnomalySign eq "1" ? "未见异常" : "异常"}'/>
                        <c:if test="${exam.limbActivityAnomalySign ne '1'}">
                            <br/><c:out value="${exam.limbActivityDesc}"/>
                        </c:if>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>步态异常(左脚)</th>
                <td>
                    <c:if test="${!empty exam.leftAbnormalGait}">
                        <c:out value='${exam.leftAbnormalGait eq "1" ? "未见异常" : "异常"}'/>
                        <c:if test="${exam.leftAbnormalGait ne '1'}">
                            <br/><c:out value="${exam.leftAbnormalGaitDesc}"/>
                        </c:if>
                    </c:if>
                </td>
                <th>步态异常(右脚)</th>
                <td>
                    <c:if test="${!empty exam.rightAbnormalGait}">
                        <c:out value='${exam.rightAbnormalGait eq "1" ? "未见异常" : "异常"}'/>
                        <c:if test="${exam.rightAbnormalGait ne '1'}">
                            <br/><c:out value="${exam.rightAbnormalGaitDesc}"/>
                        </c:if>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>可疑佝偻病体征</th>
                <td>
                    <ehr:dic code="${exam.suspiciousRicketsSigns}" dicmeta="CV0410022"/>
                </td>
                <th>血红蛋白值(g/L)</th>
                <td>
                    <c:out value="${exam.hemoglobinValue}"/>
                </td>
            </tr>
            <tr>
                <th>户外活动时长(h)</th>
                <td colspan="3">
                    <c:out value="${exam.outdoorDuration}"/>
                </td>
            </tr>
            <tr>
                <th>服用维生素D剂量(IU/d)</th>
                <td>
                    <c:out value="${exam.takeVitaminD}"/>
                </td>
                <th>服用维生素D名称</th>
                <td>
                    <c:out value="${exam.takeVitaminDName}"/>
                </td>
            </tr>
            <tr>
                <th>儿童发育评估</th>
                <td colspan="3">
                    <c:if test="${!empty exam.childDevelopmentEvaluation}">
                        <ehr:dic code="${exam.childDevelopmentEvaluation}" dicmeta="CV0510110"/>
                    </c:if>
                </td>
            </tr>
            
            <tr>
                <th>两次随访间患病标志</th>
                <td colspan="3">
                    <c:if test="${!empty exam.followupSick}">
                        <c:out value='${exam.followupSick eq "1" ? "无" : "有"}'/>
                    </c:if>
                    <c:if test="${exam.followupSick eq '2'}">
                    
                        肺炎：<c:out value='${exam.pneumoniaHospitalizations}'/>次    腹泻：<c:out value='${exam.diarrheaHospitalizations}'/>次 
                        外伤：<c:out value='${exam.traumaHospitalizations}'/>次     其他：<c:out value='${exam.otherDiseaseState}'/>次 
                    </c:if>
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
                <th>中医药健康管理服务</th>
                <td colspan="3">
                    <ehr:dic code="${exam.tcmHealthManageService}" dicmeta="FS10307"/>
                    <c:out value="${exam.tcmHealthOther}"/>
                </td>
            </tr>
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
