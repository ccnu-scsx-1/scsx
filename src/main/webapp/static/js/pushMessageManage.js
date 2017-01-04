/**
 * Author： deng.zhang
 * Time: 2014-10-17 14:31
 */

var tableType = $.urlParam('tableType');

SelectedTopMenu = "PUSH管理";
SelectedLeftMenu = "消息管理";

var languageDict = {
    'en': '英语',
    'ja': '日语',
    'de': '德语',
    'fr': '法语',
    'ru': '俄语',
    'zh_TW': '中文繁体（台湾）',
    'zh_HK': '中文繁体（香港）'
};

$(function () {
    $("#add-message-translation-window").load('module/languageAdd.htm');

    $('#app-select-window').load('module/appSelectPanel.htm', function () {
        $.parser.parse();
    });

    $('#country-select-window').load('module/countrySelectPanel.htm', function () {
        $.parser.parse();
    });

    $('#distributor-select-window').load('module/distributorSelectPanel.htm', function () {
        $.parser.parse();
    });

    $('#device-select-window').load('module/deviceSelectPanel.htm', function () {
        $.parser.parse();
    });

    $('#subject-select-window').load('module/subjectSelectPanel.htm', function () {
        $.parser.parse();
    });

    $("#add-message-window").load('module/messageAdd.htm', function () {
        $.parser.parse();
    });

    initSearchCondition();

    $('#create-message-btn').click(function () {
        clearForm();
        $('#message-tip').html('添加消息');
        $("#add-message-window").modal("show");
    });

    $("#delete-message-btn").click(function () {
        var rows = $('#message-list').datagrid('getChecked');
        if (rows.length == 0) {
            bootbox.alert("请先选择需要删除的消息！", function () {
            });
            return;
        }

        if (confirm("确认删除已选择的消息吗？")) {
            var ids = [];
            $.each(rows, function (i, row) {
                ids.push(row.id);
            });
            $.post('../push/deleteMessageByIds', {ids: ids.join(",")}, function (result) {
                if (result.success) {
                    bootbox.alert("删除成功!", function () {
                    });
                    $('#message-list').datagrid('reload');
                } else {
                    bootbox.alert("删除失败:" + result.msg, function () {
                    });
                }
            });
        }
    });

    //查找应用按钮事件绑定
    $('#search-message-btn').click(function () {
        var searchForm = $("form[id='search-message-form']");
        var params = {
            "params['title']": searchForm.find("input[id='title']").val(),
            "params['region']": searchForm.find("select[id='region']").combobox("getValue"),
            "params['country']": searchForm.find("select[id='country']").combobox("getValue"),
            "params['operator']": searchForm.find("select[id='operator']").combobox("getValue"),
            "params['type']": searchForm.find("select[id='message-type']").combobox("getValue")
        };
        $('#message-list').datagrid('load', params);
    });

    $('#clear-condition-btn').click(function () {
        var searchForm = $("form[id='search-message-form']");
        searchForm.find("input[id='title']").val('');
        initSearchCondition();
    });

    $('#message-list').datagrid({
        url: "../push/getMessageByPage",
        queryParams: {
            page: 0
        },
        pagination: true,
        loadMsg: '数据加载中...',
        columns: [
            [
                {checkbox: true},
                {field: "id", hidden: true},
                {field: "title", title: "标题", align: "center", width: 90},
                {field: "content", title: "内容", align: "center", width: 90},
                {field: "priority", title: "优先级", align: "center", width: 50, editor: 'numberbox'},
                {field: "description", title: "描述", align: "center", width: 90},
                {field: "createdOn", title: "创建时间", align: "center", width: 90},
                {field: "pushTime", title: "发送时间", align: "center", width: 90},
                {field: "pushedOn", title: "发送完成时间", align: "center", width: 90},
                {field: "status", title: "状态", align: "center", width: 50},
                {field: "action", title: "操作", align: "center", width: 130, formatter: function (value, row, index) {
                    var push = '<a href="#" class="btn btn-xs" style="margin-right:5px;background-color:lightgray;color: #808080;cursor:auto ">推送</a>';
                    if (row.pushedOn == "") {
                        push = '<a href="#" onclick="push(' + row.id + ')" class="btn btn-xs btn-warning" style="margin-right:5px;" >推送</a>';
                    }

                    var detail = '<a href="#" onclick="edit(' + index + ',\'detail\')" class="btn btn-xs btn-primary" style="margin-right:5px;" >详情</a>';

                    var edit = '<a href="#" onclick="edit(' + index + ',\'edit\')" class="btn btn-xs btn-info" style="margin-right:5px;" >修改</a>';
                    if (row.status == "已完成") {
                        edit = '<a href="#" class="btn btn-xs" style="margin-right:5px;background-color:lightgray;color: #808080;cursor:auto ">修改</a>';
                    }
                    var del = '<a href="#" onclick="del(' + row.id + ')" class="btn btn-xs btn-danger" style="margin-right:5px;" >删除</a>';
                    return push + detail + edit + del;
                }}
            ]
        ]
    });
});

/**
 * 初始化查询条件
 */
function initSearchCondition() {
    var $searchMessageForm = $("form[id='search-message-form']");
    //加载区域
    $.ajax({
        url:'../region/all',
        method:'get',
        success: function (data) {
            if (!data) {
                data = [];
            }
            data.unshift({id:'all',name:'全部区域',selected:true});
            $searchMessageForm.find("select[id='region']").combobox({
                valueField: 'id',
                textField: 'name',
                multiple: false,
                panelHeight: '150',
                data:data,
                onChange: function (n) {
                    //重新加载所选区域内的国家
                    $searchMessageForm.find("select[id='country']").combobox('clear');
                    var url = '';
                    if ('all' == n) {
                        url = '../country/getAllCountrys';
                    } else {
                        url = '../country/getCountriesByRegionIds?ids=' + n;
                    }
                    $.ajax({
                        url:url,
                        method:'get',
                        success: function (data) {
                            if (!data) {
                                data = [];
                            }
                            data.unshift({id:'all',name:'全部国家',selected:true});
                            $searchMessageForm.find("select[id='country']").combobox({
                                valueField: 'id',
                                textField: 'name',
                                multiple: false,
                                panelHeight: '150',
                                data:data
                            });
                        }
                    });
                }
            });
        }
    });

    //加载国家
    $.ajax({
        url: '../country/getAllCountrys',
        method: 'get',
        success: function (data) {
            if (!data) {
                data = [];
            }
            data.unshift({id:'all',name:'全部国家',selected:true});
            $searchMessageForm.find("select[id='country']").combobox({
                valueField: 'id',
                textField: 'name',
                multiple: false,
                panelHeight: '150',
                data:data
            });
        }
    });

    //加载运营商
    $.ajax({
        url: '../distributor/getAllDistributors',
        method: 'get',
        success: function (data) {
            if (!data) {
                data = [];
            }
            data.unshift({id:'all',name:'全部运营商',selected:true});
            $searchMessageForm.find("select[id='operator']").combobox({
                valueField: 'id',
                textField: 'name',
                multiple: false,
                panelHeight: '150',
                data:data
            });
        }
    });

    //加载消息类型
    $searchMessageForm.find("select[id='message-type']").combobox({
        valueField: 'value',
        textField: 'label',
        multiple: false,
        editable: false,
        panelHeight: '150',
        data:[
            {label:'全部类别',value:'all',selected:true},
            {label:'单应用推荐',value:'singleAppRecommend'},
            {label:'多应用推荐',value:'multiAppsRecommend'},
            {label:'单应用升级',value:'singleAppUpdate'},
            {label:'多应用升级',value:'multiAppsUpdate'},
            {label:'活动推荐',value:'activityRecommend'}
        ]
    });
}

function del(messageId) {
    if (confirm("请确定是否删除该消息？")) {
        $.post('../push/deleteMessageById', {messageId: messageId}, function () {
            $('#message-list').datagrid('reload');
        });
    }
}

function push(messageId) {
    if (confirm("请确认是否发送消息？")) {
        $.post('../push/pushMessage', {messageId: messageId}, function () {
            $('#message-list').datagrid('reload');
        });
    }
}