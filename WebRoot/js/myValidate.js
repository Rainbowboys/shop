/**
 * Created by Rainbow on 2016/10/15.
 */
/**
 * 用户注册界面的校验
 */
$(function() {
	// 自定义验证规则
	$.validator.addMethod("email", function(value, element) {
		var emailReg = /.*@.*\.?.*?\.(com|cn)$/;
		return this.optional(element) || (emailReg.test(value));
	}, "请正确填写您的邮箱");
	$.validator.addMethod("number", function(value, element) {
		var numberReg = /^[1][3458][0-9]{9}$/;
		return this.optional(element) || (numberReg.test(value));
	}, "请正确填写您的手机号码");
	$.validator.addMethod("password", function(value, element) {
		var usernameReg = /^[a-zA-Z0-9_][a-zA-Z0-9_]{3,9}$/;
		return this.optional(element) || (usernameReg.test(value));
	}, "请正确填写您的用户名/密码");

	$("#registerForm").validate({
		errorElement : 'span',
		errorClass : 'error',
		focusInvalid : false,
		rules : {
			username : {
				required : true,
				maxlength : 20,
				minlength : 6

			},
			password : {
				required : true,
				password : true
			},
			rePassword : {
				required : true,
				equalTo : "#password"
			},
			phone : {
				required : true,
				number : true
			},
			email : {
				required : true,
				email : true
			},
			name : {
				required : true
			},
			addr : {
				required : true
			},
			captcha : {
				required : true,
				equalTo : "#rightcheckcode"
			}

		},
		messages : {
			username : {
				required : "用户名不能为空",
				maxlength : "最大20个字符",
				minlength : "最小6个字符"
			},
			password : {
				required : "密码不能为空"
			},
			rePassword : {
				required : "确认密码必填",
				equalTo : "两次密码不相同"
			},
			phone : {
				required : "手机号必填"
			},
			email : {
				required : "邮箱必填"
			},
			name : {
				required : "姓名必填"
			},
			addr : {
				required : "地址必填"
			},
			captcha:{
				required : "验证码必须填写",
				equalTo : "验证码错误"
			}
		}

	})

})
