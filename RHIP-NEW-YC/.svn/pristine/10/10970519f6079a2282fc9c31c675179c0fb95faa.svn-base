<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="top_container">
	<div class="top_bar">
		<div style="float: left;">
			<span id="dateDivId"></span>
			<span class="margin-left30">
				<iframe width="auto" scrolling="no" height="25" frameborder="0" allowtransparency="true"
				        src="http://i.tianqi.com/index.php?c=code&id=34&icon=1&num=3"
				        style="vertical-align: middle"></iframe>
			</span>
		</div>
		<div class="top_bar_info">
			<ul id="top_bar_info">
				<c:if test="${empty ACCOUNT_INFO_IN_SESSION}">
					<a id="toLogin1" class="jkda_a" href="javascript:void(0)">登录</a> <font color="#666666">|</font> 
					<a id="toRegister1" class="jkda_a" href="javascript:void(0)">注册</a>
				</c:if>
				<c:if test="${not empty ACCOUNT_INFO_IN_SESSION}">
					<li class="nLi1">
						<label>${ACCOUNT_INFO_IN_SESSION.realName},您好！</label><i class="arr"></i>
						<div class="sub1">
							<div class="grxx">
								<a class="jkda_a" href="javascript:void(0)" id="toChangePerInfo">个人信息</a>
							</div>
							<div class="xgmm">
								<a class="jkda_a" href="javascript:void(0)" id="toChangePwd">修改密码</a>
							</div>
							<div class="tcdl">
								<a class="jkda_a" href="javascript:void(0)" id="loginOut">退出登录</a>
							</div>
						</div>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>