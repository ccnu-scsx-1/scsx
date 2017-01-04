$(function(){
// bootbox 区域设置
bootbox.setDefaults({
	locale: "zh_CN"
});

//++ 广告&资源
	// 全选或取消全选
	$.selectAllToggle("ad-res-check", "ad-res-check-item");
	
	// 删除app
	$("#sf-del-sw").click(function(){
		var result = $.checkboxVal("ad-res-check-item");
		if(result.length > 0){
			bootbox.confirm("确实要删除所选项到回收站吗？", function(result) {
				// ----------
			});
		}else{
			bootbox.alert("请先选择App，然后才能进行删除!", function() {
				// ----------
			});
		}
	});

	// app投放 
	$("#sf-throw-sw").click(function(){
		// 获取广告&资源checkbox的value
		var result = $.checkboxVal("ad-res-check-item");
		if(result.length > 0){
			$("#app-throw").modal('show');
		}else{
			bootbox.alert("请先选择App，然后才能进行投放!", function() {
				// ----------
			});
		}
	});

	// app下架
	$("#sf-down-sw").click(function(){
		var result = $.checkboxVal("ad-res-check-item");
		if(result.length > 0){
			bootbox.confirm("选择下架后，你投放的资源将被移除，是否继续？", function(result) {
				// ----------
			});
		}else{
			bootbox.alert("请先选择App，然后才能进行下架操作!", function() {
				// ----------
			});
		}
	});

//++ 回收站
	// 全选或取消全选
	$.selectAllToggle("cycle-check", "cycle-check-item");
	
	// 还原
	$("#sf-cy-re-sw").click(function(){
		var result = $.checkboxVal("cycle-check-item");
		if(result.length > 0){
			bootbox.confirm("确定还原选中的选项吗？", function(result) {
				// ----------
			});
		}else{
			bootbox.alert("请先选择App，然后才能进行还原操作!", function() {
				// ----------
			});
		}
	});

	// 从回收站删除
	$("#sf-cy-del-sw").click(function(){
	var result = $.checkboxVal("cycle-check-item");
		if(result.length > 0){
			bootbox.confirm("删除后将不能再找回，确定要删除吗？", function(result) {
				// ----------
			});
		}else{
			bootbox.alert("请先选择App，然后才能进行删除操作!", function() {
				// ----------
			});
		}
	});

//+ app上传模块
	// icon 选择
	$("#btn-icon-select").click(function(){
		var $target = $(this).parent().parent().find("input[type='text']");
		$("#icon-file-input").click();
		$("#icon-file-input").change(function(){
			$target.val($(this).val());
		});
		;
	});

	// Banner图片
	$("#btn-banner-select").click(function(){
		var $target = $(this).parent().parent().find("input[type='text']");
		$("#banner-file-input").click();
		$("#banner-file-input").change(function(){
			$target.val($(this).val());
		});
	});

	// 默认截图选择
	$("#btn-sfc-select-1").click(function(){
		var $target = $(this).parent().parent().find("input[type='file']");
		var $targetShow = $(this).parent().parent().find("input[type='text']");
		$target.click();
		$target.change(function(){
			$targetShow.val($(this).val());
		});
	});

	var sfcNum = 2;
	//
	$("#btn-sfc-add").click(function(){
		var id = $.random(1000, 9999);
		var $addedEle = $("<tr style='background-color:#ddd'><td>截图&nbsp;"+sfcNum+"</td>"+
					   "<td><input type='file' class='hidden' /><input type='text' class='form-control input-sm' placeholder='://' /></td>"+
					   "<td><input type='button' class='btn btn-default btn-xs btn-sfc-select' value='选择' />&nbsp;"+
					   "<input type='button' class='btn btn-warning btn-xs btn-sfc-del' value='删除' /></td>"+
					   "<td></td></tr>");
		$("#insert-before").before($($addedEle));
		$addedEle.find(".btn-sfc-select").click(function(){
			$addedEle.find("input[type='file']").click();
			$addedEle.find("input[type='file']").change(function(){
				$addedEle.find("input[type='text']").val($(this).val());
			});
		});
		$addedEle.find(".btn-sfc-del").click(function(){
			$addedEle.remove();
			sfcNum--;
		});
		sfcNum++;
	});

	// 软件包
	$("#btn-sfpak-select").click(function(){
		var $target = $(this).parent().parent().find("input[type='text']");
		$("#sfpak-file-input").click();
		$("#sfpak-file-input").change(function(){
			$target.val($(this).val());
		});
	});

	// app投放生成树
	// 测试数据
				var data = [{
				text:"Banner",
				id:"1",
				children:[{
					text:"首页",
					id:"2"
				},{
					text:"分类",
					id:"3"
				},{
					text:"专题",
					id:"4"
				}]
				},
				{
				text:"Subject",
				id:"5",
				children:[{
					text:"悦读越快乐",
					id:"6"
				}]
				},
				{
				text:"Category",
				id:"7",
				children:[{
					text:"影音",
					id:"8"
				},{
					text:"生活",
					id:"9"
				},{
					text:"社交",
					id:"10"
				},{
					text:"系统",
					id:"11"
				},{
					text:"购物",
					id:"12"
				},{
					text:"阅读",
					id:"13"
				}
				]
				}];
			
	$("#throw-tree").checkboxTree(data);

	// app修改
	$(".app-modify").click(function(){
		var id = $(this).parent().parent().find("input[type='checkbox']").val();
		// $.post("", {id:id}, function(data){ });
		$("#app-modify").modal("show");
	});



});