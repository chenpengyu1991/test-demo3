<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/active/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        healthEducationUpload.uploadFile("heActivityFile", "/he/upload/uploadFile/jjhd", "/he/upload/deleteFile/jjhd");

        var val = $("#healthEducationActiveForm #activeType").val();
        if (val == '99') {
            $('#activeTips').text('提供活动照片、签到及相关书面材料等等');
        } else if (val == '1') {
            $('#activeTips').text('提供讲座照片、签到、讲稿、通知等附件');
        } else if (val == '2') {
            $('#activeTips').text('提供活动照片、通知、小结等附件');
        } else {
            $('#activeTips').text('提供活动照片、签到及相关书面材料等等');
        }
    });
</script>
<div class="toolbar">
    <!-- 	<a href="javascript:void(0)" id="healthEducationActiveBackButton"><b class="fanhui">返回</b></a> -->
    <!-- <a href="javascript:void(0)"
       id="healthEducationActiveSaveButton"
   ><b class="baocun">保存</b></a> -->
    <a href="javascript:void(0)" id="healthEducationActiveBackButton"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
    <a href="javascript:void(0)"
       id="healthEducationActiveSaveButton">
        <button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button>
    </a>
</div>
<div class="postcontent divAbsolute55" style="top: 60px;" >
    <form id="healthEducationActiveForm">
        <div class="postcontent">
            <input type="hidden" name="id" value="${healthEducationActive.id}">
            <input type="hidden" name="systemType"
                   value="${empty healthEducationActive.systemType ? '1' : healthEducationActive.systemType}">
            <table class="posttable">
                <colgroup>
                    <col style="width: 20%;"/>
                    <col style="width: 30%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 30%;"/>
                </colgroup>
                <tr>
                    <th><label class="required">${healthEducationActive.systemType eq '1' ?'培训':'活动'}类别</label></th>
                    <td><c:choose>
                        <c:when test="${healthEducationActive.systemType eq '1'}">
                            <ehr:dic-list name="activeType" value="${healthEducationActive.activeType }"
                                          uninclude="1,2,3,4,5,6,7,8,9,10,99" dicmeta="HE00001" width="115px"
                                          id="activeType" reg='{"required":"true"}'
                                          onchange="healthEducationActiveEdit.addOtherActiveType()"
                                          cssClass="x-layui-input"></ehr:dic-list>
                        </c:when>
                        <c:otherwise>
                            <ehr:dic-list name="activeType" value="${healthEducationActive.activeType }" code="1,2"
                                          dicmeta="HE00001" width="115px" id="activeType" reg='{"required":"true"}'
                                          onchange="healthEducationActiveEdit.addOtherActiveType()"
                                          cssClass="x-layui-input"></ehr:dic-list>
                        </c:otherwise>
                    </c:choose>
                        <input type="text" style="width: 125px;"
                               class="${healthEducationActive.activeType eq '99' ?'':'hide'}"
                               reg='{"required":"true","maxlength":50}' name="otherActiveType" id="otherActiveType"
                               value="${healthEducationActive.otherActiveType}" class="x-layui-input"
                        /></td>
                    <th><label class="required">活动时间</label></th>
                    <td><%-- <tag:dateInput reg='{"required":"true"}' name="activeTime" id="activeTime" date="${healthEducationActive.activeTime}" onlypast="true" /> --%>
                        <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                               name="activeTime" id="activeTime"
                               value="<fmt:formatDate value='${healthEducationActive.activeTime}' pattern='yyyy/MM/dd'/>"
                               style="padding-left: 0px;"/>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">活动地点</label></th>
                    <td><input name="activePlace" type="text" reg='{"required":"true","maxlength":"100"}'
                               value="${healthEducationActive.activePlace}" class="x-layui-input"/></td>
                    <th><label class="required">活动主题</label></th>
                    <td><input name="activeTheme" type="text" reg='{"required":"true","maxlength":"50"}'
                               value="${healthEducationActive.activeTheme}" class="x-layui-input"/></td>
                </tr>
                <tr>
                    <th><label class="required">出动${healthEducationActive.systemType eq '1' ?'':'医务'}人员数</label></th>
                    <td><input name="medicalPersonQuantity" type="text"
                               reg='{"required":"true","digits":"true","max":99999}'
                               value="${healthEducationActive.medicalPersonQuantity}" class="x-layui-input"
                    /></td>
                    <th><label>组织者</label></th>
                    <td><input name="organizer" type="text" reg='{"maxlength":"20"}'
                               value="${healthEducationActive.organizer}" class="x-layui-input"/></td>
                </tr>
                <tr>

                    <c:choose>
                        <c:when test="${healthEducationActive.systemType eq '1'}">
                            <th><label class="required">卫生专业</label></th>
                            <td><input type="hidden" value="99" name="educationPersonType"/><input type="hidden"
                                                                                                   value="其他"
                                                                                                   name="otherPersonType"/><ehr:dic-list
                                    dicmeta="HSA00006" name="industryType" reg='{"required":"true"}'
                                    value="${healthEducationActive.industryType}" width="150px;" id="industryType"
                                    uninclude="1,4,99" parentCode="0" cssClass="x-layui-input"/></td>
                        </c:when>
                        <c:otherwise>
                            <th><label class="required">接受健康教育人员类别</label></th>
                            <td><ehr:dic-list dicmeta="HE00002" name="educationPersonType"
                                              value="${healthEducationActive.educationPersonType }"
                                              id="educationPersonType" type="true" width="115px;"
                                              reg='{"required":"true"}'
                                              onchange="healthEducationActiveEdit.addOtherPersonType()"
                                              cssClass="x-layui-input"/><input
                                    class="${fn:contains(healthEducationActive.educationPersonType,'99') ?'x-layui-input':'hide'}"
                                    reg='{"required":"true","maxlength":50}' type="text" style="width: 125px;"
                                    name="otherPersonType" id="otherPersonType"
                                    value="${healthEducationActive.otherPersonType}"/></td>
                        </c:otherwise>
                    </c:choose>
                    <th><label class="required">接受健康教育人员人数</label></th>
                    <td><input name="educationPersonQuantity" type="text"
                               reg='{"required":"true","digits":"true","max":99999}'
                               value="${healthEducationActive.educationPersonQuantity}" class="x-layui-input"
                    /></td>
                </tr>
                <tr>
                    <th><label class="required">发放健康教育资料种类</label></th>
                    <td>
                        <ehr:dic-list dicmeta="HE00003" name="materialType" reg='{"required":"true"}'
                                      value="${healthResourceRecord.materialType}" width="130px"
                                      id="materialType" onchange="healthEducationActiveEdit.addOtherMaterialType()"
                                      cssClass="x-layui-input"/>
                        <input type="text" style="width:125px;" reg='{"required":"true"}'
                               class="${healthResourceRecord.materialType eq '99' ? '':'hide'}" name="otherMaterialType"
                               id="otherMaterialType" value="${healthResourceRecord.otherMaterialType}"/>
                    </td>
                    <th>发放健康教育资料数量</th>
                    <td><input name="issueQuantity" reg='{"digits":"true","max":99999}' type="text"
                               value="${healthResourceRecord.issueQuantity}" class="x-layui-input"/></td>
                </tr>
                <c:choose>
                    <c:when test="${healthEducationActive.systemType eq '1'}">
                        <input type="hidden" value="9" name="businessType"/>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <th><label class="required">业务分类</label></th>
                            <td><ehr:dic-list name="businessType" dicmeta="HE00005" width="130px" id="businessType"
                                              reg='{"required":"true"}' value="${healthEducationActive.businessType}"
                                              onchange="healthEducationActiveEdit.addOtherBusinessType()"
                                              cssClass="x-layui-input"></ehr:dic-list> <input type="text"
                                                                                              style="width: 125px;"
                                                                                              class="${healthEducationActive.businessType eq '99' ?'x-layui-input':'hide'}"
                                                                                              reg='{"required":"true","maxlength":50}'
                                                                                              name="otherBusinessType"
                                                                                              id="otherBusinessType"
                                                                                              value="${healthEducationActive.otherBusinessType}"
                                                                                              class="x-layui-input"/>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                <tr>
                    <th>活动主要内容</th>
                    <td colspan="3"><textarea name="activeDetail" reg='{"maxlength":"600"}'
                                              style="height: 80px; width: 700px;"
                                              class="x-layui-input">${healthEducationActive.activeDetail}</textarea>
                    </td>
                </tr>
                <tr>
                    <th>工作计划</th>
                    <td colspan="3"><textarea name="workPlan" reg='{"maxlength":"600"}'
                                              style="height: 80px; width: 700px;"
                                              class="x-layui-input">${healthEducationActive.workPlan}</textarea></td>
                </tr>
                <tr>
                    <th>活动总体评价</th>
                    <td colspan="3"><textarea name="activeTotalEval" reg='{"maxlength":"600"}'
                                              style="height: 80px; width: 700px;"
                                              class="x-layui-input">${healthEducationActive.activeTotalEval}</textarea>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td colspan="3">
                        <div style="width: 690px;">
                            <c:forEach items="${attches}" var="attche">
                                <div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;"
                                     id="${attche.id}-div">
                                    <c:if test="${attche.imageFlag eq true}">
                                        <a target="blank"
                                           href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}"><img
                                                alt="点击查看大图" title="点击查看大图"
                                                src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
                                        /></a>
                                    </c:if>
                                    <c:if test="${attche.imageFlag eq false}">
                                        <a target="blank"
                                           href="${pageContext.request.contextPath}/he/upload/download/${attche.id}"
                                           onclick="javascript:void(0)">${attche.originalFileName}</a>
                                    </c:if>
                                    <br/>
                                    <a href="javascript:void(0);"
                                       onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">附件</label></th>
                    <td style="width: 120px;">
                        <div id="heActivityFile"></div>
                    </td>
                    <td colspan="2"><span style="color: blue;">注：单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a
                            href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改),附件数量不能超过5个</span>
                        <span id="activeTips" style="color: blue;"></span>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#activeTime'
            , format: 'yyyy/MM/dd'
            , max: 0
            ,done:function (value) {
                if(!$.isEmpty(value)){
                    $("#activeTime").removeClass("lose");
                }else{
                    $("#activeTime").addClass("lose");
                }
            }
        });


    });
</script>