// /**
//  *获取焦点时错误字消失
//  */
// $("input[type='text']").focus(function () {
//     $("#errorMessage").text("");
// })

/**
 * 表单输入提示
 */
$(function ($) {
    checkName();
    checkPhone();
    checkEmail();

    $(".mu-send-msg-btn").on("click",function () {
        commit();
    });
});

var flag = false;

var checkName = function () {
    $("#name").on("blur",function () {
        var pattern = /^[\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*$/;
        var element = $("#name");
        if(pattern.test(element.val())){
            element.css("border", "2px solid green");
            flag = true;
        }else {
            element.css("border", "2px solid red");
            // document.getElementById("name").innerHTML = "用户名格式错误";
            flag = false;
        }
    })
}

var checkPhone = function () {
    $("#phone").on("blur",function () {
        var pattern = /((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}/;
        var element = $("#phone");
        if(pattern.test(element.val())){
            element.css("border", "2px solid green");
            flag = true;
        }else {
            element.css("border", "2px solid red");
            // document.getElementById("phoneError").innerHTML = "手机号码格式错误";
            flag = false;
        }
    })
}

var checkEmail = function () {
    $("#email").on("blur",function () {
        var pattern = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        var element = $("#email");
        if(pattern.test(element.val())){
            element.css("border", "2px solid green");
            flag = true;
        }else {
            element.css("border", "2px solid red");
            // document.getElementById("emailError").innerHTML = "邮箱格式错误";
            flag = false;
        }
    })
}

/**
 * 提交按钮点击事件
 */
var commit = function () {
    var url = "../user/insertUserInformation";
    var data = $("#ajax-contact").serialize();
    $.ajax({
        url: url,
        data: data,
        type: "POST",
        dataType: "json",
        success: function (json) {
            console.log(json);
            if(json.code == 0){
                alert("我们会尽快联系您!")
                location.href = "index.html"
            }
        }
    })
}

/**
 * 字段非空判断
 */
$(".mu-send-msg-btn").click(function () {
    var a = $("#name").val();
    var b = $("#phone").val();
    var c = $("#email").val();
    var d = $("#occupation").val();
    var e = $("#message").val();
    if (a == null || a == undefined || a == "") {
        alert("名字不能为空");
    } else if (b == null || b == undefined || b == "") {
        alert("号码不能为空");
    } else if (c == null || c == undefined || c == "") {
        alert("邮箱不能为空")
    } else if (d == null || d == undefined || d == "") {
        alert("职业不能为空");
    } else if (e == null || e == undefined || e == "") {
        alert("信息不能为空");
    }
})

/**
 * 邮箱打出@的时候补全
 * @type {Document}
 */
// var d = document;
// var ul = d.querySelector('.mail_box>ul');
//
// function complete(btn) {
//     var val = btn.value;
//     var mail = ["qq.com", "sina.com", "163.com",
//         "gmail.com", "sohu.com"];
//     var idx = val.indexOf('@');
//     if (idx != -1) {
//         for (var i = 0, str = ''; i < mail.length; i++)
//             str += '<li id="es">' + val.slice(0, idx + 1) + mail[i] + '</li>';
//         ul.className = ul.className.replace(/(hide)/, '');
//         ul.innerHTML = str;
//     }
// }
//
// ul.addEventListener('click', function (e) {
//     var src = e.target || e.srcElement;
//     if (src.nodeName.toLowerCase() == 'li') {
//         d.getElementsByName('email')[0].value = src.innerHTML;
//         ul.className += 'hide';
//     }
// })

