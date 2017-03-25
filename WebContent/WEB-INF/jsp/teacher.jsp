<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
    + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script data-main="<%=basePath %>source/js/main/teacher.js" src="<%=basePath %>source/js/lib/require.js"></script>
<link href="<%=basePath %>source/style/teacher.css" rel="stylesheet" type="text/css" />
<body ng-controller="teacherController as ctrl">
    
    <div class="wrap">
        <div>
            <div class="title">
                <span class="logo-style"><img class="logo-img" src="../../source/images/logo2.png"></img></span>
                <div class="menu-content">
                    <div class="menu-style" ui-sref="step1">首页</div>
                    <div class="menu-style" ui-sref="step2">公告管理</div>
                    <div class="menu-style" ui-sref="step3">作业管理</div>
                    <div class="menu-style" ui-sref="step4">学生管理</div>
                    <div class="menu-usr-style" ng-mouseenter="ctrl.showDropDowm()" ng-mouseleave="ctrl.displayDropDowm()">欢迎你，${user.userName}
                        <span class="drop-down-img"></span>
                        <div class="drop-down-style" ng-class = {"show-drop-down":ctrl.isShowDropDown}>
                            <span class="every-drop-down">我的信息</span>
                            <span class="every-drop-down" ng-click="ctrl.logout()">退出登陆</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <ui-view></ui-view>

    <script type="text/ng-template" id="create.html">
      <div class="class-modal">
        <div class="modal-main">
            <div class="modal-content">
                <p><img src=""><span class="modal-title">创建公告<span></p>
                <span class="text-style-area"><textarea placeholder="请输入..." maxlength="3000" class="text-area-style" ng-model="content"></textarea></span>
                <div class="modal-bottom">
                  <div ng-click="cancel()" class="modal-cancel">
                    <span>取消</span>
                    <img src="">
                </div>
                  <div ng-click="submit()" class="modal-submit">
                    <span>确定</span>
                    <img src="">
                </div>
                  <div class="clear"></div>
              </div>
            </div>
        </div>
      </div>
    </script>
</body>
</html>