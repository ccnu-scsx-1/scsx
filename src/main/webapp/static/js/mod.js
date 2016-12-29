$(function(){
// bootbox设置区域
bootbox.setDefaults({
	locale: "zh_CN"
});

//++ app banner位模块
	// 实现全选
	$.selectAllToggle("banner-check", "banner-check-item");

	// 下架
	$("#btn-banner-sw").click(function(){
		var result = $.checkboxVal("banner-check-item");
		if(result.length > 0){
			bootbox.confirm("选择下架后，你投放的资源将被移除，是否继续？", function(type) {
                if(type){
                    params = {'url': '/admin/ads/offshelf/',
                              'data': {'ad_ids': result},
                             }
                    $.sendAjax(params)
                }
			});
		}else{
			bootbox.alert("请先选择，然后才能进行下架操作!", function() {
				// ----------
			});
		}
	});

    // 修改广告排序
    $(".update_ads_priority").updatePriority('/admin/ads/priority/update/');

//++ 首页管理
	// 实现全选
	$.selectAllToggle("mp-check", "mp-check-item");
	// 下架
	$("#btn-mp-sw").click(function(){
		var result = $.checkboxVal("mp-check-item");
		if(result.length > 0){
			bootbox.confirm("选择下架后，你投放的资源将被移除，是否继续？", function(value) {
                if(value){
                    var listbox = document.getElementById("provider");
                    var provider = listbox.options[listbox.selectedIndex].value;
                    var params = {"id":result, "provider":provider};
                    $.sendAjax({"url": "/admin/featured/off_shelf/",
                        "type": "POST",
                        "data": params
                        });
                }
			});
		}else{
			bootbox.alert("请先选择，然后才能进行下架操作!", function() {
				// ----------
			});
		}
	});
	// 保存
    $('.featured_priority').updatePriority('/admin/featured/update_priority/');
    //修改单页条数
    $('.itemperpage').updateItemsPerPage();
    //来源过滤
    $("#provider").change(function(){
        var provider_list = document.getElementById("provider");
        var provider = provider_list.options[provider_list.selectedIndex].value;
        var url = "/admin/featured/filter/?provider=" + provider;
        $.reload(url);
    });

//++ 分类管理
    //修改排序
    $(".category_priority").updatePriority('/admin/category/priority/update/');

	// 删除分类
	$(".btn-clsf-del").click(function(){
		var id = $(this).parent().parent().find(".clsf-check-item").val();
		bootbox.confirm("请确定是否删除所选分类?", function(type) {
            if(type){
                params = {
                        'url': '/admin/category/delete/',
                        'data': {'id': id},
                        }
                $.sendAjax(params);
            }
        });
	});
    //++ 分类软件列表
    //全选
	$.selectAllToggle("capl-check", "capl-check-item");
    //更改排序
    var url = '/admin/category/list_app/update/' + $("#category_id").val() + "/";
    $('.category_app_priority').updatePriority(url);
    //下架
	$("#btn-capl-sw").click(function(){
		var result = $.checkboxVal("capl-check-item");
		if(result.length > 0){
			bootbox.confirm("选择下架后，你投放的资源将被移除，是否继续？", function(value) {
                if(value){
                    var params = {"ids": result};
                    var url = "/admin/category/list_app/offshelf/" + $("#category_id").val() + "/";
                    $.sendAjax({"url": url,
                        "type": "POST",
                        "data": params
                        });
                }
			});
		}else{
			bootbox.alert("请先选择，然后才能进行下架操作!", function() {
				// ----------
			});
		}
	});


 // 点击增加按钮
    $("#btn-cat-add").click(function(){
       reset_add_category_form();
    });


    // 添加分类，分类名称唯一性检查
    $("#add-category-name").blur(function(){
        if(! $.isNull($.trim($(this).val()))){
            if ($.strLength($.trim($(this).val()), 1)){
                $.sendAjax({
                    "url": "/admin/category/name/check/",
                    "type": "POST",
                    "data": {'name': $.trim($(this).val()), 'category_id': $('#input-category-id').val()},
                    "callback": function(data){
                        if(data.status == 'success'){
                            $("#category-name-check").html("<img src='/static/common/images/right.png' />");
                        }
                        else{
                             $("#category-name-check").html("<img src='/static/common/images/error.png' />" +
                                "<span class='label label-warning'>" + data.msg + "</span>");
                        }
                    },
                });
            }
        }
        else{
            $("#category-name-check").html("");
        }
    });

    // icon 选择
    var cat_upload_params = function(input_id, img_id){
        var param = {
                    url: '/admin/category/icon/upload/',
                    secureuri: false,
                    fileElementId: input_id,
                    dataType: 'json',
                    beforeSend: function(){},
                    success: function (data, status){
                        if(data.status == 'success'){
                            $("#" + img_id).parent().find("img").attr("src", '/download/' + data.img_path);
                            $("#" + img_id).parent().find("img").removeClass('hidden');
                            $('#input-category-icon').val(data.img_path);
                        }
                        else {
                            bootbox.alert(data.msg);
                        }
                        //解决ajaxfileupload后事件被清除的bug
                        $("#category-icon-file").change(function(){
                            var $target = $(this).parent().parent().find("input[type='text']");
                            if (! $.checkFileSuffix($("#category-icon-file").val(), 'img')){
                                bootbox.alert('请上传.png或者.jpg文件');
                                return;
                            }
                            $('#selected-category-icon').val(this.value);
                            $.ajaxFileUpload(cat_upload_params('category-icon-file', 'btn-category-icon'));
                            $target.val($(this).val());

                        });
                    }
                };
        return param;
    }

    // 添加分类图片
    $("#btn-category-icon").click(function(){
        var $target = $(this).parent().parent().find("input[type='text']");
        $("#category-icon-file").click();
    });
    $("#category-icon-file").change(function(){
        var $target = $(this).parent().parent().find("input[type='text']");
        if (! $.checkFileSuffix($("#category-icon-file").val(), 'img')){
            bootbox.alert('请上传.png或者.jpg文件');
            return;
        }
        $.ajaxFileUpload(cat_upload_params('category-icon-file', 'btn-category-icon'));
        $target.val($(this).val());
    });
 // 提交添加分类
    $("#btn-add-category").click(function(){
        $("#btn-add-category-real").click();
    });
    $("#btn-add-category-real").click(function(){
        if($.trim($("#add-category-name").val())!='')
        {
            $.sendAjax({
                "url": "/admin/category/name/check/",
                "type": "POST",
                "data": {'name': $.trim($('#add-category-name').val()), 'category_id': $('#input-category-id').val()},
                "sync": false,
                "callback": function(data){
                    if(data.status == 'success'){
                        $("#category-name-check").html("<img src='/static/common/images/right.png' />");
                    }
                    else{
                         $("#category-name-check").html("<img src='/static/common/images/error.png' />" +
                            "<span class='label label-warning'>" + data.msg + "</span>");
                    }
                },
            });
        }
        // 检查分类类型
        if( $("#category-type").val() == '-1'){
            bootbox.alert("请选择分类类型");
            return false;
        };

        // 检查分类名
        if( ! ($("#category-name-check").find('img').attr('src') == '/static/common/images/right.png')){
            bootbox.alert("无效的分类名");
            return false;
        };

        //检查图片
        if( $.isNull($("#input-category-icon").val())){
            bootbox.alert("无效的图片");
            return false;
        };

        //检查描述
        if ( $.isNull($("#category-description").val())){
            bootbox.alert("分类描述不能为空");
            return false;
        };
    });

    // 修改分类
    $('.btn-modify-category').click(function(){
        reset_add_category_form();
        $.sendAjax({
            'url': '/admin/category/info/',
            'type': "POST",
            'data': {'category_id': $(this).attr('value')},
            'callback': function(data){
                if(data.status == 'success')
                {
                    $('#input-category-id').val(data.category_id);
                    $('#add-category-name').val(data.name);
                    $("#category-name-check").html("<img src='/static/common/images/right.png' />");
                    $('#input-category-icon').val(data.icon);
                    $("#btn-category-icon").parent().find("img").attr("src", '/download/' + data.icon);
                    $("#btn-category-icon").parent().find("img").removeClass('hidden');
                    $("#category-type").val(data.category_type);
                    $("#category-type").attr('disabled', 'disabled');
                    $("#recommend_app_1").val(data.recommend_app_1);
                    $("#recommend_app_2").val(data.recommend_app_2);
                    $("#category-description").val(data.description);
                    $("#operate-category-title").html('修改分类');
                }
                else{
                    bootbox.alert(data.msg);
                }
            },
            });
        $('#category-add').modal('show');
    });

    // 分类图片预览
    $('.imgpreviews').imgPreview();



//++ 专题管理
    // 专题介绍表格
    var options = {
                    width : '100%',
                    items:['fontname','fontsize','|'
                          ,'forecolor','bold','italic','underline','|'
                          ,'justifyleft','justifycenter','justifyright','justifyfull','|'
                          ,'insertorderedlist','insertunorderedlist','|'
                          ,'indent','outdent'
                          ],
                    resizeType:0,
                  };
    var editor;

	// 实现全选
	$.selectAllToggle("sbj-check", "sbj-check-item");
	// 点击增加按钮
	$("#btn-sbj-add").click(function(){
       reset_add_subject_form();
       if (! editor){
            editor = KindEditor.create('#subject-description', options);
       }
	});
	// 投放
	$("#btn-sbj-sw").click(function(){
		var result = $.checkboxVal("sbj-check-item");
		if(result.length > 0){
            params = {
                        'url': '/admin/subject/throw/',
                        'type': 'GET',
                        'callback': function(data){
                                // 清空
                                $("#sj-throw").html("");
                                $("#sj-throw").checkboxTree(data.data, 'subject-throw-node');
                            }
                    }
            $.sendAjax(params);
			$("#sbj-throw").modal('show');
		}else{
			bootbox.alert("请先选择专题，然后才能进行投放!", function() {
				// ----------
			});
		}
	});

    //确定投放
    $("#throw-yes-btn").click(function(){
              var checkednodes = $.checkboxVal('subject-throw-node');
              var checkedsubjects = $.checkboxVal('sbj-check-item');

              if(checkednodes.length == 1 && checkednodes[0] == '-1')
              {
			        bootbox.alert("请选择要投放到的模块!", function(){});
                    return;
              }
              if(checkednodes.length > 0){
                var post_data = {};
                post_data['subject_ids'] = checkedsubjects;
                post_data['checked_nodes'] = checkednodes;
                params = {
                            'url': '/admin/subject/throw/',
                            'data': post_data,
                         }
                $.sendAjax(params);
              }
              else{
			           bootbox.alert("请选择要投放到的模块!", function() {
                    });
                  }
            });

	// 下架
	$(".btn-sbj-offshelf").click(function(){
        var subject_id = $(this).attr('value');
		bootbox.confirm("请确定是否下架所选专题?", function(result) {
            if(result){
                params = {
                          'url': '/admin/subject/offshelf/',
                          'data': {'subject_id': subject_id},
                         }
                    $.sendAjax(params);
            }
	    });
    });
	// 上架
	$(".btn-sbj-onshelf").click(function(){
        var subject_id = $(this).attr('value');
		bootbox.confirm("请确定是否上架所选专题?", function(result) {
            if(result){
                params = {
                          'url': '/admin/subject/onshelf/',
                          'data': {'subject_id': subject_id},
                         }
                    $.sendAjax(params);
            }
	    });
	});
	// 删除
	$("#btn-sbj-del").click(function(){
		var values = $.checkboxVal("sbj-check-item");
		if(values.length > 0){
			bootbox.confirm("请确定是否删除所选专题?", function(type) {
                if(type){
                    params = {
                            'url': '/admin/subject/delete/',
                            'data': {'subject_ids' : values},
                            }
                    $.sendAjax(params);
                }
			});
		}else{
			bootbox.alert("请先选择专题，然后才能进行删除操作!", function() {
			});
		}
	});
	// 全选
	$.selectAllToggle("slist-check", "slist-check-item");
    // 添加专题，专题名称唯一性检查
    $("#add-subject-name").blur(function(){
        if(! $.isNull($.trim($(this).val()))){
            if ($.strLength($.trim($(this).val()), 1)){
                $.sendAjax({
                    "url": "/admin/subject/title/check/",
                    "type": "POST",
                    "data": {'title': $.trim($(this).val()), 'subject_id': $('#input-subject-id').val()},
                    "callback": function(data){
                        if(data.status == 'success'){
                            $("#subject-name-check").html("<img src='/static/common/images/right.png' />");
                        }
                        else{
                             $("#subject-name-check").html("<img src='/static/common/images/error.png' />" +
                                "<span class='label label-warning'>" + data.msg + "</span>");
                        }
                    },
                });
            }
        }
        else{
             $("#subject-name-check").html("");
        }
    });

    // icon 选择
    var upload_params = function(input_id, img_id, type, input_subject){
        var param = {
                    url: '/admin/subject/image/upload/' + type + '/',
                    secureuri: false,
                    fileElementId: input_id,
                    dataType: 'json',
                    beforeSend: function(){},
                    success: function (data, status){
                        if(data.status == 'success'){
                            $("#" + img_id).parent().find("img").attr("src", '/download/' + data.img_path);
                            $("#" + img_id).parent().find("img").removeClass('hidden');
                            $('#' + input_subject).val(data.img_path);
                        }
                        else {
                            bootbox.alert(data.msg);
                        }
                        if(input_id=='subject-banner-file')
                        {
                            $("#subject-banner-file").change(function(){
                                var $target = $(this).parent().parent().find("input[type='text']");
                                if (! $.checkFileSuffix($("#subject-banner-file").val(), 'img')){
                                    bootbox.alert('请上传.png或者.jpg文件');
                                    return;
                                }
                                $.ajaxFileUpload(upload_params('subject-banner-file', 'btn-subject-banner', 'banner', 'input-subject-banner'));
                                $target.val($(this).val());
                            });
                        }
                        else
                        {
                            $("#subject-icon-file").change(function(){
                                var $target = $(this).parent().parent().find("input[type='text']");
                                if (! $.checkFileSuffix($("#subject-icon-file").val(), 'img')){
                                    bootbox.alert('请上传.png或者.jpg文件');
                                    return;
                                }
                                $.ajaxFileUpload(upload_params('subject-icon-file', 'btn-subject-icon', 'icon', 'input-subject-icon'));
                                $target.val($(this).val());
                            });
                        }
                    }
                };
        return param;
    }

    // 添加专题banner图片
    $("#btn-subject-banner").click(function(){
        var $target = $(this).parent().parent().find("input[type='text']");
        $("#subject-banner-file").click();
    });
    $("#subject-banner-file").change(function(){
        var $target = $(this).parent().parent().find("input[type='text']");
        if (! $.checkFileSuffix($("#subject-banner-file").val(), 'img')){
            bootbox.alert('请上传.png或者.jpg文件');
            return;
        }
        $.ajaxFileUpload(upload_params('subject-banner-file', 'btn-subject-banner', 'banner', 'input-subject-banner'));
        $target.val($(this).val());
    });

    // 添加专题icon图片
    $("#btn-subject-icon").click(function(){
        var $target = $(this).parent().parent().find("input[type='text']");
        $("#subject-icon-file").click();
    });
    $("#subject-icon-file").change(function(){
        var $target = $(this).parent().parent().find("input[type='text']");
        if (! $.checkFileSuffix($("#subject-icon-file").val(), 'img')){
            bootbox.alert('请上传.png或者.jpg文件');
            return;
        }
        $.ajaxFileUpload(upload_params('subject-icon-file', 'btn-subject-icon', 'icon', 'input-subject-icon'));
        $target.val($(this).val());
    });


    // 提交添加专题
    $("#btn-add-subject").click(function(){$("#btn-add-subject-real").click();});
    $("#btn-add-subject-real").click(function(){
        if($.trim($("#add-subject-name").val())!='')
        {
            $.sendAjax({
                "url": "/admin/subject/title/check/",
                "type": "POST",
                "data": {'title': $.trim($('#add-subject-name').val()), 'subject_id': $('#input-subject-id').val()},
                "sync": false,
                "callback": function(data){
                    if(data.status == 'success'){
                        $("#subject-name-check").html("<img src='/static/common/images/right.png' />");
                    }
                    else{
                         $("#subject-name-check").html("<img src='/static/common/images/error.png' />" +
                            "<span class='label label-warning'>" + data.msg + "</span>");
                    }
                },
            });
        }
        
        // 检查专题名
        if( ! ($("#subject-name-check").find('img').attr('src') == '/static/common/images/right.png')){
            bootbox.alert("无效的专题名");
            return false;
        };

        //检查图片
        if( $.isNull($("#input-subject-icon").val())){
            bootbox.alert("专题Icon图片不能为空");
            return false;
        };

        //检查描述
        if (editor.isEmpty()){
            bootbox.alert("专题描述不能为空");
            return false;
        }
        var htmlv = editor.html();
        htmlv = htmlv.replace(/(<p>\s*<br \/>\s*<\/p>\s*)*\s*$/g,"");
        editor.html(htmlv);
        // 同步数据后可以直接取得textarea的value
        editor.sync();
    });

    // 修改专题
    $('.btn-modify-subject').click(function(){
        reset_add_subject_form();
        if (! editor){
            editor = KindEditor.create('#subject-description', options);
        }
        $.sendAjax({
            'url': '/admin/subject/info/',
            'type': "POST",
            'data': {'subject_id': $(this).attr('value')},
            'callback': function(data){
                if(data.status == 'success')
                {
                    $('#input-subject-id').val(data.subject_id);
                    $('#add-subject-name').val(data.title);
                    $("#subject-name-check").html("<img src='/static/common/images/right.png' />");
                    $('#input-subject-icon').val(data.icon);
                    $('#input-subject-banner').val(data.banner);
                    $("#btn-subject-icon").parent().find("img").attr("src", '/download/' + data.icon);
                    $("#btn-subject-banner").parent().find("img").attr("src", '/download/' + data.banner);
                    $("#btn-subject-icon").parent().find("img").removeClass('hidden');
                    $("#btn-subject-banner").parent().find("img").removeClass('hidden');
                    $("#recommend_app_1").val(data.recommend_app_1);
                    $("#recommend_app_2").val(data.recommend_app_2);
                    $("#operate-subject-title").html('修改专题');
                    editor.html(data.description);
                }
                else{
                    bootbox.alert(data.msg);
                }
            },
            });
        $('#sbj-add').modal('show');
    });

    // 专题图片预览
    $('.imgpreviews').imgPreview();



//++ 搜索管理
	// 实现全选
	$.selectAllToggle("search-check", "search-check-item");

	// 删除
	$("#btn-search-del").click(function(){
		var result = $.checkboxVal("search-check-item");
		if(result.length > 0){
			bootbox.confirm("请确定是否删除所选项?", function(value) {
                if(value){
                    var params = {"ids": result};
                    $.sendAjax({
                        "url": "/admin/keyword/delete/",
                        "type": "POST",
                        "data": params
                        });
                }
			});
		}else{
			bootbox.alert("请先选择，然后才能进行删除操作!", function() {
				// ----------
			});
		}
	});
    //搜索管理导入表单验证

    //输入时验证
    var addKeywordFlag;
    var addBatchKeywordFlag;
    $('#k_name').blur(function(){
        var name = $.trim($('#k_name').val());
        var nameBatch = $.trim($('#k_batch').val());
        $('#k_name_tip1').addClass('hidden');
        $('#k_name_tip2').addClass('hidden');
        $('#k_name_tip3').addClass('hidden');
        //验证名字是否重复
        if(name != ''){
            var params = {
                'url': '/admin/keyword/get/',
                'data': {'name': name},
                'type': 'POST',
                'callback': function(data){
                    if(data.status == 'failed'){
                        $('#k_name_tip2').removeClass('hidden');
                    }else{
                        $('#k_name_tip2').addClass('hidden');
                    }
                }
            };
            $.sendAjax(params);
        }
        //输入检测
        if(name == '' && nameBatch == '')
        {
            $('#k_name_tip1').removeClass('hidden');
            $('#k_name_tip3').addClass('hidden');
        }
        else if (name.length >4)
        {
            $('#k_name_tip1').addClass('hidden');
            $('#k_name_tip3').removeClass('hidden')
        }
        else{
            $('#k_name_tip1').addClass('hidden');
            $('#k_name_tip3').addClass('hidden')}
    })

    $('#k_batch').blur(function(){
        var name = $.trim($('#k_name').val());
        var nameBatch = $.trim($('#k_batch').val());
        var nameBatchList = nameBatch.split('\n');
        var repeatCheck = [];
        //验证名字是否重复
        if (nameBatch.length > 0){
            var keywordList = nameBatch.split('\n');
            var i ;
            for(i=0; i<keywordList.length; i++){
                keyword = keywordList[i];
                if(keyword.indexOf(',') == -1){
                    addBatchKeywordFlag = false;
                }
                var keyword = keyword.split(',')[0];
                var priority = keyword.split(',')[1];
                if(keyword != null){
                    var params = {
                        'url': '/admin/keyword/get/',
                        'data': {'name': keyword},
                        'type': 'POST',
                        'callback': function(data){
                            if(data.status == 'failed'){
                                $('#k_batch_tip1').removeClass('hidden');
                            }
                            else
                            {
                                $('#k_batch_tip1').addClass('hidden');
                            }
                        }
                    };
                    $.sendAjax(params);
                    if(!addBatchKeywordFlag){
                        break;
                    }
                }
            }

            if(i == keywordList.length){
                addBatchKeywordFlag = true;
                $('#k_batch_tip1').addClass('hidden');
            }
        }
        //输入检测
        $('#k_batch_tip5').addClass('hidden');
            for(var index in nameBatchList)
            {
                var nameSingle = nameBatchList[index].split(',');
                if(nameBatch !="" && nameSingle.length<2)
                {
                    $('#k_batch_tip2').removeClass('hidden');
                    $('#k_batch_tip1').addClass('hidden');
                    $('#k_batch_tip3').addClass('hidden');
                    $('#k_batch_tip4').addClass('hidden');
                }
                else if(nameSingle[0].length>4)
                {
                    $('#k_batch_tip2').addClass('hidden');
                    $('#k_batch_tip3').removeClass('hidden');
                    break;
                }
                else
                {
                    $('#k_batch_tip2').addClass('hidden');
                    $('#k_batch_tip3').addClass('hidden');
                    $('#k_batch_tip4').addClass('hidden');
                }
                if(nameSingle.length>1 && !$.isNumber(nameSingle[1]) && nameSingle[1].length>0)
                {
                    $('#k_batch_tip4').removeClass('hidden');
                    break;
                }
                else
                {
                    $('#k_batch_tip4').addClass('hidden');
                }
                repeat:
                {
                    if(nameSingle[0] == name && nameBatch!='')
                    {
                        $('#k_batch_tip5').removeClass('hidden');
                        repeatCheck.push(nameSingle[0]);
                        break repeat;
                    }
                    else
                    {
                        if(repeatCheck.length==0)
                        {repeatCheck.push(nameSingle[0]);}
                        else
                        {
                            for(var item in repeatCheck)
                            {
                                if(nameSingle[0] == repeatCheck[item])
                                {
                                    $('#k_batch_tip5').removeClass('hidden');
                                    repeatCheck.push(nameSingle[0]);
                                    break repeat;
                                }
                                else
                                {
                                    repeatCheck.push(nameSingle[0]);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
    })

    $('#k_priority').blur(function(){
        var priority = $.trim($('#k_priority').val());
        if(priority != '')
        {
            if(!$.isNumber(priority))
            {
                $('#k_priority_tip').removeClass('hidden');
            }
            else
            {
                $('#k_priority_tip').addClass('hidden');
            }
        }
    })
    //提交时验证
    $('#keyword_submit').click(function(){
        $('#keyword_submit_real').click();
    });

    $('#keyword_submit_real').click(function(){
        var name = $.trim($('#k_name').val());
        var nameBatch = $.trim($('#k_batch').val());
        var nameResult, nameBatchResult, priorityResult;
        nameResult = nameBatchResult = priorityResult = true;
        var nameTip , nameBatchTip ,priorityTip;
        nameTip = nameBatchTip = priorityTip = '';
        var repeatCheck = [];
        var none_repeat = true;
        $('#k_batch_tip5').addClass('hidden');

        if(name!='')
        {
            $.sendAjax({
                'url': '/admin/keyword/get/',
                'data': {'name': name},
                'type': 'POST',
                'sync': false,
                'callback': function(data){
                    if(data.status == 'failed'){
                        addKeywordFlag = false;
                        $('#k_name_tip2').removeClass('hidden');
                    }else{
                        addKeywordFlag = true;
                        $('#k_name_tip2').addClass('hidden');
                    }
                }
            });
        }

        if (nameBatch!=''){
            var keywordList = nameBatch.split('\n');
            var i ;
            for(i=0; i<keywordList.length; i++){
                keyword = keywordList[i];
                if(keyword.indexOf(',') == -1){
                    addBatchKeywordFlag = false;
                }
                var keyword = keyword.split(',')[0];
                if(keyword != null){
                    $.sendAjax({
                        'url': '/admin/keyword/get/',
                        'data': {'name': keyword},
                        'type': 'POST',
                        'sync': false,
                        'callback': function(data){
                            if(data.status == 'failed'){
                                addBatchKeywordFlag = false;
                                $('#k_batch_tip1').removeClass('hidden');
                            }
                            else
                            {
                                addBatchKeywordFlag = true;
                                $('#k_batch_tip1').addClass('hidden');
                            }
                        }
                    });
                    if(!addBatchKeywordFlag){
                        break;
                    }
                }
            }

            if(i == keywordList.length){
                addBatchKeywordFlag = true;
                $('#k_batch_tip1').addClass('hidden');
            }
        }

        if(name.length ==0 && nameBatch.length == 0)
        {
                nameTip = '#k_name_tip1';
                nameResult = false;
        }
        else if(name.length >4)
        {
            nameTip = '#k_name_tip3';
            nameResult = false;
        }
        var nameBatchList = nameBatch.split('\n');
        for(var index in nameBatchList)
        {
            var nameSingle = nameBatchList[index].split(',');
            if(nameSingle[0].length>4)
            {
                nameBatchResult = nameBatchResult && false;
                nameBatchTip = '#k_batch_tip3';
            }
            if(nameSingle.length>1 && nameSingle[1]!='' && !$.isNumber(nameSingle[1]))
            {
                nameBatchResult = nameBatchResult && false;
                nameBatchTip = '#k_batch_tip4';
            }
            if( nameSingle.length<2 && nameBatch!='')
            {
                nameBatchResult = nameBatchResult && false;
                nameBatchTip = '#k_batch_tip2';
            }
            repeatValid:
            {
                var nameSingle = nameBatchList[index].split(',');
                if(nameSingle[0] == name && nameBatch!='')
                {
                    $('#k_batch_tip5').removeClass('hidden');
                    repeatCheck.push(nameSingle[0]);
                    none_repeat = false;
                    break repeatValid;
                }
                else
                {
                    if(repeatCheck.length==0)
                    {repeatCheck.push(nameSingle[0]);}
                    else
                    {
                        for(var item in repeatCheck)
                        {
                            if(nameSingle[0] == repeatCheck[item])
                            {
                                $('#k_batch_tip5').removeClass('hidden');
                                none_repeat = false;
                                repeatCheck.push(nameSingle[0]);
                                break repeatValid;
                            }
                            else
                            {
                                repeatCheck.push(nameSingle[0]);
                                continue;
                            }
                        }
                    }
                }
            }
        }

        var priority = $.trim($('#k_priority').val());
        if(priority.length > 0){
            if(!$.isNumber(priority)){
                priorityTip = '#k_priority_tip';
                priorityResult = false;
            }else{
                priorityTip = '#k_priority_tip';
            }
        }
        if(addKeywordFlag){
            nameResult = nameResult && addKeywordFlag;
            if(nameResult)
            {nameTip = '#k_name_tip2';}
        }
        if(addBatchKeywordFlag){
            nameBatchResult = nameBatchResult && addBatchKeywordFlag;
            if(nameBatchResult)
            {nameBatchTip = '#k_batch_tip1';}
        }

        if(!nameResult)
            {$(nameTip).removeClass('hidden');}
        if(!nameBatchResult)
            {}
        if(!priorityResult)
            {$(priorityTip).removeClass('hidden');}
        if($.trim($('#k_name').val()) != '' && $.trim($('#k_batch').val())=='')
            {addBatchKeywordFlag=true}
        if($.trim($('#k_batch').val()) != '' && $.trim($('#k_name').val())=='')
            {addKeywordFlag=true}
        var result = nameResult && nameBatchResult && priorityResult && addBatchKeywordFlag && addKeywordFlag && none_repeat;
        return result;
    });


    $('.keyword_priority').updatePriority('/admin/keyword/update/');

    // 修改专题里面app的排序
    $(".update-subject-app-priority").updatePriority('/admin/subject/list/priority/update/' + $('#btn-subject-app-list').attr('value') +'/');
    // 修改专题排序
    $(".update-subject-priority").updatePriority('/admin/subject/priority/update/');
    // 专题软件列表全选
	$.selectAllToggle("app-check", "app-check-item");
	// 专题软件列表下架
	$("#btn-subject-app-list").click(function(){
		var result = $.checkboxVal("app-check-item");
        var subject_id = $(this).attr('value');
		if(result.length > 0){
			bootbox.confirm("选择下架后，你投放的资源将被移除，是否继续？", function(type) {
                if(type){
                    params = {'url': '/admin/offshelf_app_from_subject/' + subject_id + '/',
                              'data': {'app_ids': result},
                             }
                    $.sendAjax(params)
                }
			});
		}else{
			bootbox.alert("请先选择，然后才能进行下架操作!", function() {
				// ----------
			});
		}
	});

});

function reset_form(targetForm)
{
    targetForm.reset();
    $(targetForm).find('.label-warning').addClass('hidden');
}



function reset_add_subject_form(){
    $('#input-subject-id').val('-1');
    $("#subject-name-check").html('<small>专题名称建议不超过14个字</small>');
    $('#add-subject-name').val('');
    $('#selected-subject-icon').val('');
    $('#input-subject-banner').val('');
    $('#input-subject-icon').val('');
    $("#btn-subject-banner").parent().find("img").attr("src", '');
    $("#btn-subject-icon").parent().find("img").attr("src", '');
    $("#recommend_app_1").val('');
    $("#recommend_app_2").val('');
    $("#subject-description").val('');
    $("#operate-subject-title").html('增加专题');
}

function reset_add_category_form(){
    $('#input-category-id').val('-1');
    $("#category-type").val('-1');
    $("#category-name-check").html('<small>分类名称建议不超过7个字</small>');
    $('#add-category-name').val('');
    $('#selected-category-icon').val('');
    $('#input-category-icon').val('');
    $("#category-type").removeAttr("disabled");
    $("#btn-category-icon").parent().find("img").attr("src", '');
    $("#recommend_app_1").val('');
    $("#recommend_app_2").val('');
    $("#category-description").val('');
    $("#operate-category-title").html('增加分类');
    $("#category-type").removeAttr('disabled');
}

function is_iE()
{
    return !!window.ActiveXObject;
}
