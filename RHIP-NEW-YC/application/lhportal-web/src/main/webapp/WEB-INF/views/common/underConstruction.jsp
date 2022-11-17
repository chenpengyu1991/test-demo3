<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/index/main.css"/>
<style>
    .error-container {
        margin: 20px;
        padding: 0;
        background: #FFF;
    }
    .well {
        border-radius: 0;
        min-height: 20px;
        padding: 19px;
        margin-bottom: 20px;
        background-color: #f5f5f5;
        border: 1px solid #e3e3e3;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
        box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
    }
    .grey {
        color: #777!important;
    }
    h1.smaller {
        font-size: 31px;
    }
    .lighter {
        font-weight: lighter;
    }
    .bigger-125 {
        font-size: 125%!important;
    }
    .blue {
        color: #478FCA!important;
    }
</style>
<div id="ehrbrowser_main" style="margin-top: 20px;">
    <div id="ehrbrowser-content" class="error-container">
        <div class="well">
            <h1 class="grey lighter smaller">
                <span class="blue bigger-125">此功能正在开发中</span>
             </h1>
        </div>

    </div>
</div>


