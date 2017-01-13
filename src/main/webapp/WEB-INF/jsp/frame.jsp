<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<title><decorator:title default="高校试卷后台管理系统"></decorator:title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta charset="utf-8" />
<meta name="Author" content="" />
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="http://apps.tclclouds.com/static/common/images/favicon.ico" />
<link href="../static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../static/js/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="../static/css/styles.css" rel="stylesheet" type="text/css" />
<script src="../static/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="../static/js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../static/js/bootbox.min.js" type="text/javascript"></script>
<script src="../static/js/jUtil.js" type="text/javascript"></script>
<script src="../static/js/jquery.raty.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../static/js/jquery-easyui-1.3.6/themes/bootstrap/easyui-customized.css" />

<link rel="StyleSheet" href="../static/css/dtree.css" type="text/css" />
<script type="text/javascript" src="../static/js/dtree.js"></script>

<script type="text/javascript" src="../static/js/WdatePicker.js"></script>
<link rel="StyleSheet" href="../static/css/WdatePicker.css" type="text/css" />
<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: ">";
}

.navbar .navbar-nav>.active>a {
	background-color: #93B6DF;
}
</style>
<script src="../static/js/jquery-easyui-1.3.6/jquery.easyui.min.js" type="text/javascript"></script>
<script src="../static/js/easyui-datagrid-default.js" type="text/javascript"></script>
<script type="text/javascript">
	var LeftMenu = {
		"小T桌面" : [ {
			name : "常见问题",
			url : "faqManage.html"
		}, {
			name : "用户反馈",
			url : "feedbackManage.html"
		}, {
			name : "节日管理",
			url : "festivalManage.html"
		}, {
			name : "励志语管理",
			url : "inspirationManage.html"
		},{
			name : "图标管理",
			url  : "iconManage.html"
		},{
			name : "主题管理",
			url  : "themeManage.html"
		},{
			name : "文件夹推荐应用投放",
			url  : "featuredAppManage.html"
		},{
			name : "文件夹推荐应用投放(新)",
			url  : "folderAppRcmdMngt.html"
		}],
		"墙纸管理" : [ {
			name : "全部墙纸列表",
			url : "wallpaperManage.html"
		}, {
			name : "小T锁屏推荐列表",
			url : "launcherWallpaperRecommend.html"
		},{
			name : "墙纸排序规则",
			url : "wallpaperOrderRuleManage.html"
		}]
	};


	// 需要在body页面赋值的变量
	var SelectedTopMenu; // 顶部菜单名
	var SelectedLeftMenu; // 左部菜单名
	var navPaths = [];
</script>
<decorator:head></decorator:head>
</head>

<body>

	<div class="wrap content">
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<div class="sub-nav-ct-item" id="sub-nav-ct-item-2">
					<div id="current-position" style="margin-bottom: -15px; margin-top: -5px">
						<ol class="breadcrumb"></ol>
					</div>
					<decorator:body />
				</div>
			</div>
		</div>
	</div>

</body>

</html>

