<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="toolbar">
	<a href="javascript:ceSearch.back()" id="back"><b class="fanhui">返回</b></a> 
</div>
<form id="staff_form" class="postcontent">
	<div class="postdiv">
		<fieldset>
			<legend>人员信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 10%;" />
					<col style="width: 20%;" />
					<col style="width: 10%;" />
					<col style="width: 20%;" />
					<col/>
				</colgroup>
				<tr>
					<th>
						姓名
					</th>
					<td>
						${staff.name}
					</td>
					<th>
						身份证号
					</th>
					<td>
						${staff.idCard}
					</td>
					<td/>
				<tr/>
				<tr>
				    <th>
						技术职称
					</th>
					<td>
						${staff.technicalName}
					</td>
					<th>
						总学时
					</th>
					<td>
						${staff.period}
					</td>
					<td/>
				<tr/>
				<tr>
					<th>
						总一类学分
					</th>
					<td>
						${staff.creditA}
					</td>
					<th>
						总二类学分
					</th>
					<td>
						${staff.creditB}
					</td>
					<td/>
				</tr>
			</table>
		</fieldset>
	</div>
</form>
<form id="continue_education_form" class="postcontent">
	<div class="postdiv">
        <fieldset>
            <legend>项目信息</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 80%"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td colspan="2">
                        <div class="repeattable" style="text-align: left">
                            <table style="width: 100%" id="projectTable">
                                <tr>
                                    <th style="text-align: center;width: 10%">登记年份</th>
                                    <th style="text-align: center;width: 15%">项目代号</th>
                                    <th style="text-align: center;width: 15%">项目名称</th>
                                    <th style="text-align: center;width: 20%">举办单位</th>
                                    <th style="text-align: center;width: 10%">学时数</th>
                                    <th style="text-align: center;width: 10%">一类学分</th>
                                    <th style="text-align: center;width: 10%">二类学分</th>
                                    <th style="text-align: center;width: 10%">操作</th>
                                </tr>
	                           <c:forEach var="continueEducation" items="${continueEducationList}" varStatus="status">
				                    <tr>
				                        <td>${continueEducation.recordYear}</td>
				                        <td>${continueEducation.projectNo}</td>
				                        <td>${continueEducation.projectName}</td>
				                        <td>${continueEducation.organizer}</td>
				                        <td>${continueEducation.period}</td>
				                        <td>${continueEducation.creditA}</td>
				                        <td>${continueEducation.creditB}</td>
				                        <td class="btnsublist">
					        	            <a href="javascript:void(0)" onclick="ceSearch.view(${continueEducation.id})">查看</a>
					                    </td>
					                </tr>
	                			</c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
