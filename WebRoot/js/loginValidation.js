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
	}, "手机号码格式错误");
	$.validator.addMethod("password", function(value, element) {
		var usernameReg = /^[a-zA-Z0-9_][a-zA-Z0-9_]{3,9}$/;
		return this.optional(element) || (usernameReg.test(value));
	}, "密码格式错误");

	$("#loginForm").validate({
	
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
			checkcode : {
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
			checkcode : {
				required : "验证码错误",
				equalTo : "验证码错误"
			}
		}
	})

})