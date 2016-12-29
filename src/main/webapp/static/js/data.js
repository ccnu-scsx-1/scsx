// 数据统计
$(function(){
// bootbox设置区域
bootbox.setDefaults({
	locale: "zh_CN"
});

//++ 商店流量
	// 实现全选
	// $.selectAllToggle("banner-check", "banner-check-item");

	
	
//++ 搜索统计
	// 全选
	$.selectAllToggle("search-word-th", "search-word-item");
	$.selectAllToggle("search-record-th", "search-record-item");
	// 搜索词与搜索记录之间切换
	$.tabToggle("search-word-item", "search-wct-item");
	// 页面刷新保持到原有位置
	$.setPos("search-word-item", "search-wct-item");
	
	// 搜索词删除
	$("#btn-sws-del").click(function(){
		var values = $.checkboxVal("search-word-item");
		if(values.length > 0){
			bootbox.confirm("请确定是否删除？", function(result) {
				// $.get();
				//alert(result);
			});
		}else{
			bootbox.alert("请先选择，然后才能进行删除操作!", function() {
				// ----------
			});
		}
	});

});