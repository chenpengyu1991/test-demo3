<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-24
  Time: 下午12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/examine/childInfo.js" type="text/javascript"></script>

<div class="toolbar">
	<a href="javascript:void(0)" id="cancelChildInfoBtn">
            <button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button>
    </a>
    <a href="javascript:void(0)" id="showExamineFormBtn">
            <button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>填写体检信息</button>
    </a>
    <!-- <a href="javascript:void(0)" id="cancelChildInfoBtn"><b class="fanhui">返回</b></a>
    <a href="javascript:void(0)" id="showExamineFormBtn"><b class="xiug">填写体检信息</b></a> -->
</div>
<div class="postcontent">
    <fieldset>
        <legend style="color: black;">&nbsp;基本信息&nbsp; </legend>
        <form method="post" id="childInfoForm">
            <input type="hidden" name="text_personId" id="text_personId">
            <input type="hidden" name="examineAgeGroup" id="examineAgeGroup" value="${examineAgeGroup}">
            <table class="posttable">
                <colgroup>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                </colgroup>
                <tbody>
                <tr>
                    <th><label class="required">姓名</label></th>
                    <td><input type="text" id="name" name="name" reg="{'required':'true'}"/></td>
                    <c:if test="${'1' eq examineAgeGroup}">
                        <th><label class="required">出生编号</label></th>
                        <td><input type="text" id="babyCardNo" onkeyup="this.value=this.value.replace(/[, ]/g,'')" name="babyCardNo" reg="{'required':'true','regex':'number'}" maxlength="17"></td>
                    </c:if>
                    <c:if test="${'1' ne examineAgeGroup}">
                        <th><label>出生编号</label></th>
                        <td><input type="text" id="babyCardNo" name="babyCardNo" reg="{'regex':'number'}" maxlength="17"></td>
                    </c:if>
                    <th><label class="required">出生日期</label></th>
                    <td><input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="birthday" id="birthday"  style="padding-left: 0px;width:120px;" />
                    </td>
                </tr>
                <tr>
                    <th><label class="required">性别</label></th>
                    <td><ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode" width="120px" reg="{'required':'true'}"/></td>
                    <c:if test="${'1' eq examineAgeGroup}">
                        <th><label>身份证号</label></th>
                        <td><input type="text" id="idCard" name="idCard" reg="{'idCard':true,'maxlength':18}"/></td>
                    </c:if>
                    <c:if test="${'1' ne examineAgeGroup}">
                    <th><label class="required">身份证号</label></th>
                    <td><input type="text" id="idCard" name="idCard" reg="{'idCard':true,'maxlength':18,'required':'true'}"/></td>
                    </c:if>
                    <th><label class="required">母亲身份证号</label></th>
                    <td><input type="text" id="motherIdcard" name="motherIdcard" reg="{'required':'true','idCard':true}"/></td>
                </tr>
                <tr>
                    <th>现住地址</th>
                    <td colspan="5">
                        <ehr:dic-town-street-village
                                villageId="homeVillage_address" townId="homeTown_address"
                                streetId="homeStreet_address"
                                villageName="paGroup" streetName="pastreet"
                                townName="patownShip" width="118px;"
                                reg="{'dependValue':'1'}"
                                callback="childInfo.displayHrAddress" />
                    </td>
                </tr>
                <tr>
                    <th>现住详细地址</th>
                    <td colspan="4">
                        <span id="homeSpan">
                            <label id="tempHrValue">
							</label>
						</span><br/>
                        <input type="text" id="text_pahouseNumber" reg='{"maxlength":50}'
                               name="pahouseNumber"/>
                    </td>
                </tr>
                <tr>
                    <th>联系电话</th>
                    <td><input type="text" id="telNumber" name="telNumber"/></td>
                </tr>
                <tr>
                    <th><label class="required">月龄</label></th>
                    <td>
                        <select id="cPhysicalExamAge" name="cPhysicalExamAge" reg="{'required':'true'}">
                            <c:if test="${'1' eq examineAgeGroup}">
                                <option value="满月">满月</option>
                                <option value="3月龄">3月龄</option>
                                <option value="6月龄">6月龄</option>
                                <option value="8月龄">8月龄</option>
                            </c:if>
                            <c:if test="${'2' eq examineAgeGroup}">
                                <option value="12月龄">12月龄</option>
                                <option value="18月龄">18月龄</option>
                                <option value="24月龄">24月龄</option>
                                <option value="30月龄">30月龄</option>
                            </c:if>
                            <c:if test="${'6' eq examineAgeGroup}">
                                <option value="3岁">3岁</option>
                                <option value="4岁">4岁</option>
                                <option value="5岁">5岁</option>
                                <option value="6岁">6岁</option>
                            </c:if>
                        </select>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </fieldset>
</div>
<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#birthday'
			,format: 'yyyy/MM/dd'
			,trigger: 'click'
		});

	});
</script>