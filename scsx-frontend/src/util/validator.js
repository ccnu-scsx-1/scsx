export default {
    isEmpty: function(str){
        return !str
    },
    isEmail: function(str){
        let  emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
        return !!str && emailReg.test(str)
    },
    isTel: function(str){
        let telReg = /^1[34578]\d{9}$/;
        return !!str && telReg.test(str)
    },
    isNumeric: function(str){
        return !!str && !isNaN(str)
    },
    isEqual: function(str, rstr){
        return str.length === rstr.length && str === rstr
    }
}