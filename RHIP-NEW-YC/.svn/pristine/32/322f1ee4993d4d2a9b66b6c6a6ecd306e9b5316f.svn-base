<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/ehrbrowser/whch/birth.css"></link>
<script type="text/javascript">
    !(function () {
        $(function () {
            //修改出生地址镇的中文、编码混用
            var re=/\u4E00-\u9FA5/;
            var cbcPatownShipId = $("#cbcPatownShipId").val();
            if (!$.isEmpty($('#newBornDetail'))) {
                if(null == cbcPatownShipId || cbcPatownShipId == ""){
                    $('#newBornDetail').find('#cbcPatownShip').attr("style", "")
                }else{
                    $('#newBornDetail').find('#cbcPatownShip').attr("style", "display:none;");
                }
            }
        });
    })();
</script>

<input id="cbcPatownShipId" type="hidden" value="<ehr:dic code="${chBirthCertificate.patownShip}" dicmeta="FS990001"/>" />
<c:choose>
    <c:when test="${empty chBirthCertificate}">
        <div class="pad margin no-print">
            <div class="callout callout-info" style="margin-bottom: 0!important;">
                <h4><i class="fa fa-info"></i> 提示：</h4>
                暂无出生证明信息！
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div id="newBornDetail" style="text-align: center;">
            <div class="birthDay">
                <!-- 姓名 -->
                <p class="birthInfo" style="left: 236px;top: 105px;width: 90px;">
                        ${chBirthCertificate.neonatalName}
                </p>
                <!-- 性别 -->
                <c:if test="${chBirthCertificate.neonatalGender == 1 }">
                    <label class="birthInfo" style="left: 325px;top: 105px;">√</label>
                </c:if>
                <c:if test="${chBirthCertificate.neonatalGender == 2 }">
                    <label class="birthInfo" style="left: 353px;top: 105px;">√</label>
                </c:if>
                <!-- 出生日期 -->
                <label class="birthInfo" style="left: 427px;top: 105px;">
                    <fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="yyyy"/>
                </label>
                <label class="birthInfo" style="left: 472px;top: 105px;">
                    <fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="MM"/>
                </label>
                <label class="birthInfo" style="left: 502px;top: 105px;">
                    <fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="dd"/>
                </label>
                <label class="birthInfo" style="left: 527px;top: 105px;">
                    <fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="HH"/>
                </label>
                <label class="birthInfo" style="left: 557px;top: 105px;">
                    <fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="mm"/>
                </label>

                <!-- 出生地 -->
                <label class="birthInfo" style="left: 210px;top: 139px;">${chBirthCertificate.paprovince}</label>
                <label class="birthInfo" style="left: 275px;top: 139px;">${chBirthCertificate.pacity}</label>
                <label class="birthInfo" style="left: 340px;top: 139px;">${chBirthCertificate.pacounty}</label>
                <label class="birthInfo" style="left: 415px;top: 139px;">
                    <ehr:dic code="${chBirthCertificate.patownShip}" dicmeta="FS990001"/>
                    <div id="cbcPatownShip" style="display: none;">
                            ${chBirthCertificate.patownShip}
                    </div>
                </label>

                <!-- 孕周 -->
                <label class="birthInfo" style="left: 545px;top: 139px;">
                        ${chBirthCertificate.gestationalWeek}
                </label>

                <!-- 健康状况 -->

                <c:choose>
                    <c:when test="${chBirthCertificate.neonatalHealth == 1}">
                        <label class="birthInfo" style="left: 275px;top: 174px;">√</label>
                    </c:when>
                    <c:when test="${chBirthCertificate.neonatalHealth == 2}">
                        <label class="birthInfo" style="left: 340px;top: 174px;">√</label>
                    </c:when>
                    <c:when test="${chBirthCertificate.neonatalHealth == 3}">
                        <label class="birthInfo" style="left: 390px;top: 174px;">√</label>
                    </c:when>
                </c:choose>

                <!-- 体重身高 -->
                <label class="birthInfo" style="left: 445px;top: 171px;">${chBirthCertificate.birthWeight}</label>
                <label class="birthInfo" style="left: 540px;top: 171px;">${chBirthCertificate.birthStature}</label>

                <!-- 母亲 -->
                <p class="birthInfo" style="left: 220px;top: 210px;width: 94px;">${chBirthCertificate.motherName}</p>

                <label class="birthInfo" style="left: 340px;top: 212px;">${chBirthCertificate.motherAge}</label>
                <label class="birthInfo" style="left: 415px;top: 212px;">
                    <ehr:dic code="${chBirthCertificate.motherNationality}" dicmeta="GBT26592000"/>
                </label>
                <label class="birthInfo" style="left: 535px;top: 212px;">
                    <ehr:dic code="${chBirthCertificate.motherNation}" dicmeta="GBT3304"/>
                </label>

                <!-- 身份证号 -->
                <c:forEach var="c" items="${midCard}" varStatus="status">
                    <c:set var="leftPx" value="${status.index * 16 + 255}"></c:set>
                    <label class="birthInfo" style="left: ${leftPx}px;top: 247px;">${c}</label>
                </c:forEach>

                <!-- 父亲 -->
                <label class="birthInfo" style="left: 250px;top: 278px;">${chBirthCertificate.fatherName}</label>
                <label class="birthInfo" style="left: 340px;top: 278px;">${chBirthCertificate.fatherAge}</label>
                <label class="birthInfo" style="left: 415px;top: 278px;">
                    <ehr:dic code="${chBirthCertificate.fatherNationality}" dicmeta="GBT26592000"/>
                </label>
                <label class="birthInfo" style="left: 535px;top: 278px;">
                    <ehr:dic code="${chBirthCertificate.fatherNation}" dicmeta="GBT3304"/>
                </label>

                <!-- 身份证号 -->

                <c:forEach var="c" items="${fidCard}" varStatus="status">
                    <c:set var="leftPx" value="${status.index * 16 + 255}"></c:set>
                    <label class="birthInfo" style="left: ${leftPx}px;top: 310px;">${c}</label>
                </c:forEach>

                <!-- 出生地点分类 -->

                <c:choose>
                    <c:when test="${chBirthCertificate.birthPlaceType == 1}">
                        <label class="birthInfo" style="left: 337px;top: 345px;">√</label>
                    </c:when>
                    <c:when test="${chBirthCertificate.birthPlaceType == 2}">
                        <label class="birthInfo" style="left: 437px;top: 345px;">√</label>
                    </c:when>
                    <c:when test="${chBirthCertificate.birthPlaceType == 3}">
                        <label class="birthInfo" style="left: 491px;top: 345px;">√</label>
                    </c:when>
                    <c:when test="${chBirthCertificate.birthPlaceType == 9}">
                        <label class="birthInfo" style="left: 576px;top: 345px;">√</label>
                    </c:when>
                </c:choose>

                <!-- 接种机构名称 -->
                <label class="birthInfo" style="left: 260px;top: 373px;">
                        ${chBirthCertificate.midwiferyOrganName}
                </label>

                <!-- 出生证编号 -->
                <label class="birthInfo" style="left: 235px;top: 419px;">
                        ${chBirthCertificate.birthCertificateNo}
                </label>

                <!-- 签发日期 -->
                <label class="birthInfo" style="left: 430px;top: 420px;">
                    <fmt:formatDate value="${chBirthCertificate.issuedDate}" pattern="yyyy"/>
                </label>
                <label class="birthInfo" style="left: 480px;top: 420px;">
                    <fmt:formatDate value="${chBirthCertificate.issuedDate}" pattern="MM"/>
                </label>
                <label class="birthInfo" style="left: 510px;top: 420px;">
                    <fmt:formatDate value="${chBirthCertificate.issuedDate}" pattern="dd"/>
                </label>

                <!-- 签发机构 -->
                <label class="birthInfo" style="left: 600px;top: 390px; font-size: 16px;font-weight: bold;">
                        ${chBirthCertificate.visaOrganName}
                </label>
            </div>
        </div>
    </c:otherwise>
</c:choose>