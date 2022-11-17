<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/whch_menu.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/whch_menu.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/left.js"></script>

<script type="text/javascript">

	$(function() {
		$('.whch-left-nav #nav li')[0].click();
		$("#premaritalHealthServiceList").click();
	});
</script>

<div class="sidemenu">
	<div class="whch-left-nav"  style="overflow:auto;height: 325px;">
      <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b2;</i>
                    <cite>婚前检查</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a id="premaritalHealthServiceList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>婚前保健服务</cite>
                        </a>
                    </li >
                    <li>
                        <a id="womanDiseaseCensusList" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>妇女病普查</cite>
                        </a>
                    </li >
                </ul>
            </li>
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b3;</i>
                    <cite>孕产妇保健</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                	<li>
                		<a id ="pregnantwomentabList" href="javascript:void(0);" class="manageSelect">
                			<i class="iconfont">&#xe6a7;</i>
                            <cite>孕产妇登记</cite>
                         </a>
                    </li>
					<li>
						<a id="highRiskMaternalRegistrationList" href="javascript:void(0);" class="manageSelect">
						<i class="iconfont">&#xe6a7;</i>
						<cite>高危产妇登记</cite>
						</a>
					</li>
					<li><a id="highRiskMaternalTimeList" href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>高危产妇随访</cite></a></li>
					<li><a id="prenatalScreenDiagnosisList"href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>产前筛查与诊断</cite></a></li>
					<li><a id="firstantenatalvisitList" href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>第1次产前随访</cite></a></li>
					<li><a id="twoToFivevisit" href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>第2-5次产前随访</cite></a></li>
					<li><a id="deliveryInfoRecordList" href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>分娩信息记录</cite></a></li>
					<li><a id="bornDefectList"href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>出生缺陷登记</cite></a></li>
					<li><a id="postnatalInterviewList" href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>产后产妇访视</cite></a></li>
					<li><a id="healthCheckRecordList" href="javascript:void(0);" class="manageSelect">
					<i class="iconfont">&#xe6a7;</i>
					<cite>产后42天检查记录表</cite></a></li>
                
                
                   <%--  <li>
                        <a id="pregnantwomentabList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>孕产妇专项卡</cite>
                        </a>
                    </li >
                    <li>
                        <a id="firstantenatalvisitList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>产前第1次随访</cite>
                        </a>
                    </li >
                    <li>
                        <a id="twoToFivevisit" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>产前第2-5次随访</cite>
                        </a>
                    </li >
                    <li>
                        <a id="postnatalInterviewList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>产后产妇访视</cite>
                        </a>
                    </li >
                    <li>
                        <a id="highRiskMaternalRegistrationList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>高危产妇登记</cite>
                        </a>
                    </li >
                    <li>
                        <a id="highRiskMaternalTimeList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>高危产妇随访</cite>
                        </a>
                    </li >
                    <li>
                        <a id="deliveryInfoRecordList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>分娩信息记录表</cite>
                        </a>
                    </li >
                    <li>
                        <a id="healthCheckRecordList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>产后42天健康检查记录表</cite>
                        </a>
                    </li >
                    <li>
                        <a id="maternalDeathRegistration" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>孕产妇死亡登记</cite>
                        </a>
                    </li > --%>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6e9;</i>
                    <cite>儿童保健</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a id="newBornInterviewList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>新生儿家庭访视</cite>
                        </a>
                    </li >
                    <li>
                        <a id="neonatalDiseaseScreenList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>新生儿疾病筛查</cite>
                        </a>
                    </li >
                    <li>
                        <a id="childHealthCard" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>儿童保健卡</cite>
                        </a>
                    </li >
                    <li>
                        <a id="frailChildFollowupList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>体弱儿童管理随访</cite>
                        </a>
                    </li >
                    <li>
                        <a id="childHealthExaminationOneList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>1-8月龄儿童检查记录</cite>
                        </a>
                    </li >
                    <li>
                        <a id="childHealthExaminationTwoList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>12-30月龄检查记录</cite>
                        </a>
                    </li >
                    <li>
                        <a id="childHealthExaminationThreeList" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>3-6岁儿童检查记录</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>出生医学证明</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a id="ownBornDetail" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>本人出生医学证明</cite>
                        </a>
                    </li >
                    <c:if test="${empty chEtbjCsyxzm}">
                    <li>
                        <a id="newBornDetail/0" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>子女出生医学证明</cite>
                        </a>
                    </li >
					</c:if>
					
                    <c:if test="${ not empty chEtbjCsyxzm}">
					<c:forEach items="${chEtbjCsyxzm}" var="fcf">
						<li>
                        <a id="newBornDetail/${fcf.id}" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>子女${fcf.xm}的出生医学证明</cite>
                        </a>
                    </li >
					</c:forEach>
				</c:if>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6bf;</i>
                    <cite>计生技术服务</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a id="birthController" href="javascript:void(0);" class="manageSelect">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>计生技术服务</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
      </div>
    </div>
	<%-- <ul id="healthTree" class="sidemenulist treeview-famfamfam">
		<li class="sidemenu01"><span class="sidemenu01">婚前检查</span>
			<ul>
				<li class="sidemenu022"><span class="sidemenu022"><a id="premaritalHealthService" class="manageSelect" href="#">婚前保健服务</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="womanDiseaseCensusList" class="manageSelect" href="#">妇女病普查</a></span></li>
			</ul>
		</li>
		<li class="sidemenu01"><span class="sidemenu01">孕产妇保健</span>
			<ul>
				<li class="sidemenu022"><span class="sidemenu022"><a id="pregnantwomentabList" class="manageSelect" href="#">孕产妇专项卡</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="firstantenatalvisitList" class="manageSelect" href="#">产前第1次随访</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="twoToFivevisit" class="manageSelect" href="#">产前第2-5次随访</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="postnatalInterviewList" class="manageSelect" href="#">产后产妇访视</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="highRiskMaternalRegistrationList" class="manageSelect" href="#">高危产妇登记</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="highRiskMaternalTimeList" class="manageSelect" href="#">高危产妇随访</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="deliveryInfoRecordList" class="manageSelect" href="#">分娩信息记录表</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="healthCheckRecordList" class="manageSelect" href="#">产后42天健康检查记录表</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="maternalDeathRegistration" class="manageSelect" href="#">孕产妇死亡登记</a></span></li>
			</ul>
		</li>
		<li class="sidemenu01"><span class="sidemenu01">儿童保健</span>
			<ul>
				<li class="sidemenu022"><span class="sidemenu022"><a id="newBornBabyRegisterList" class="manageSelect" href="#">新生儿登记表</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="childInformation" class="manageSelect" href="#">儿童信息登记卡</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="newBornInterviewList" class="manageSelect" href="#">新生儿访视表</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="childHealthExaminationOneList" class="manageSelect" href="#">1-8月龄儿童健康检查记录</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="childHealthExaminationTwoList" class="manageSelect" href="#">12-30月龄儿童健康检查记录</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="childHealthExaminationThreeList" class="manageSelect" href="#">3-6岁儿童健康检查记录</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="frailInfantsFileList" class="manageSelect" href="#">体弱儿专项档案</a></span></li>
				<li class="sidemenu022"><span class="sidemenu022"><a id="weakChildrenList" class="manageSelect" href="#">体弱儿童随访</a></span></li>
			</ul>
		</li>
		<li class="sidemenu01"><span class="sidemenu01">出生医学证明</span>
			<ul>
				<li class="sidemenu022"><span class="sidemenu022"><a id="ownBornDetail" class="manageSelect" href="#">本人出生医学证明</a></span></li>
				<c:if test="${empty chEtbjCsyxzm}">
					<li class="sidemenu022"><span class="sidemenu022"><a  id="newBornDetail/0" class="manageSelect" href="#">子女出生医学证明</a></span></li>
				</c:if>

				<c:if test="${ not empty chEtbjCsyxzm}">
					<c:forEach items="${chEtbjCsyxzm}" var="fcf">
						<li class="sidemenu022"><span class="sidemenu022"><a  id="newBornDetail/${fcf.id}" class="manageSelect" href="#">子女${fcf.xm}的出生医学证明</a></span></li>
					</c:forEach>
				</c:if>

			</ul>
		</li>
		<li class="sidemenu01 expandable"><span id="birthController" class="sidemenu01 manageSelect">计划生育技术服务信息</span></li>
	</ul> --%>
</div>