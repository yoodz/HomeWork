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
<script data-main="<%=basePath %>source/js/main/login.js" src="<%=basePath %>source/js/lib/require.js"></script>
<link href="<%=basePath %>source/style/login.css" rel="stylesheet" type="text/css" />
  <body>
    <div class="wrap" ng-controller="loginController as ctrl">
      <div class="main-top" ng-class = "{'background1':background1boolean, 'background2':background2boolean, 'background3':background3boolean}">
        <div class="logo-style">
          <img class="logo-img" src="../../source/images/logo2.png"></img>
          <span class="logo-word-style">作业管理系统</span>
        </div>
        <div class="login-window">
          <form name="messageForm">
            <div class="input-div">
              <div class="user-style">
                <input class="input-style" name="username" ng-model="ctrl.userName" type="text" placeholder="请输入用户名" ng-minlength="4" ng-maxlength="20" required />
                <p class="error" ng-if="messageForm.username.$error.required && messageForm.username.$touched" ng-bind="ctrl.nameEmptyError"></p>
                <p class="error" ng-if="(messageForm.username.$error.minlength || messageForm.username.$error.maxlength) && messageForm.username.$touched" ng-bind="ctrl.nameLengthError"></p>
              </div>
              <div class="user-style">
                <input class="input-style" name="password" ng-model="ctrl.password" type="password" placeholder="请输入密码" ng-minlength="4" ng-maxlength="20" required />
                <p class="error" ng-if="messageForm.password.$error.required && messageForm.password.$touched" ng-bind="ctrl.passwordEmptyError"></p>
                <p class="error" ng-if="(messageForm.password.$error.minlength || messageForm.password.$error.maxlength) && messageForm.password.$touched" ng-bind="ctrl.passwordLengthError"></p>
              </div>
            </div>
            <div class="button-div">
              <div class="reset-button" value="取消">取消</div>
              <button class="basic-button login-button" ng-class = "{'background1':background1boolean, 'background2':background2boolean, 'background3':background3boolean}" ng-disabled="messageForm.username.$error.required || messageForm.username.$error.minlength
                || messageForm.username.$error.maxlength || messageForm.password.$error.required || messageForm.password.$error.minlength || messageForm.password.$error.maxlength" ng-click="ctrl.validation()" value="登陆">登陆</button>
              <span class="error error-login" ng-if="ctrl.isShowError" ng-bind="ctrl.ErrorMessage"></span>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>