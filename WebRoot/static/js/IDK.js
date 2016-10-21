$(function() {

	$.validator.addMethod("email", function(value, element) {
		var emailReg = /.*@.*\.?.*?\.(com|cn)$/;
		return this.optional(element) || (emailReg.test(value));
	}, "请正确填写您的邮箱");

	$.validator.addMethod("number", function(value, element) {
		var numberReg = /^[1][3458][0-9]{9}$/;
		return this.optional(element) || (numberReg.test(value));
	}, "请正确填写您的手机号码");

	$.validator.addMethod("usernp", function(value, element) {
		var usernameReg = /^[a-zA-Z0-9_][a-zA-Z0-9_]{3,9}$/;
		return this.optional(element) || (usernameReg.test(value));
	}, "请正确填写您的用户名/密码");

	$("#myform").validate({
		errorElement : 'span',
		errorClass : 'help-block',
		focusInvalid : false,
		rules : {
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				usernp : true

			},
			passwordrepeat : {
				required : true,
				equalTo : "#inputpassword"
			},
			account : {
				required : true,
				number : true
			}
		},
		messages : {

			password : {
				required : "密码为空",
				usernp : "密码格式不正确，4-10位数字/字母/下划线"
			},
			passwordrepeat : {
				required : "确认密码为空",
				equalTo : "两次输入不一致"
			},
			email : {
				required : "邮箱必填",
				email : "邮箱地址不正确"

			},
			account : {
				required : "用户账号为空",
				number : "请输入正确手机号"
			},
			highlight : function(element) {
				$(element).closest('.form-group').addClass('has-error');
			},
			success : function(label) {
				label.closest('.form-group').removeClass('has-error');
				label.remove();
			},
			errorPlacement : function(error, element) {
				element.parent('div').append(error);
			}
		}
	})

})
/**
 * Created by Rainbow on 2016/9/15.
 */
