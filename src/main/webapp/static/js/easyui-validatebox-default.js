$.extend($.fn.validatebox.defaults.rules, {
	positiveInt: {// 正整数
        validator: function (value) {
            return value > 0 && /^[0-9]*$/.test(value);
        },
        message: '请输入正整数'
    }
});