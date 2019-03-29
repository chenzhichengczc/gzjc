/**
 * 提交按钮点击事件
 */
$(".mu-send-msg-btn").click(function () {
    var url = "../user/insertUserInformation";
    var data = $("#ajax-contact").serialize();
    $.ajax({
        url: url,
        data: data,
        type: "POST",
        dataType: "json",
        cache: false,
        success:function(json){
            if(json.code == 500){
                $("#errorMessage").text(json.msg);
            }

        }
    })
})

/**
 *获取焦点时错误字消失
 */
$("input[type='text']").focus(function () {
    $("#errorMessage").text("");
})

/**
 * 字段非空判断
 */
$(".mu-send-msg-btn").click(function () {
    var a = $("#name").val();
    var b = $("#phone").val();
    var c = $("#email").val();
    var d = $("#occupation").val();
    var e = $("#message").val();
    if(a == null || a == undefined || a == ""){
        alert("名字不能为空");
    }else if(b == null || b == undefined || b == ""){
        alert("号码不能为空");
    }else if(c == null || c == undefined || c == ""){
        alert("邮箱不能为空")
    }else if(d == null || d == undefined || d == "") {
        alert("职业不能为空");
    }else if(e == null || e == undefined || e == "") {
        alert("信息不能为空");
    }else{
        alert("我们会尽快联系您!");
    }
})

/**
 * 邮箱打出@的时候补全
 * @type {Document}
 */
var d = document;
var ul = d.querySelector('.mail_box>ul');

function complete(btn) {
    var val = btn.value;
    var mail = ["qq.com", "sina.com", "163.com",
        "gmail.com", "sohu.com"
    ];
    var idx = val.indexOf('@');
    if (idx != -1) {
        for (var i = 0, str = ''; i < mail.length; i++)
            str += '<li id="es">' + val.slice(0, idx + 1) + mail[i] + '</li>';
        ul.className = ul.className.replace(/(hide)/, '');
        ul.innerHTML = str;
    }
}
ul.addEventListener('click', function(e) {
    var src = e.target || e.srcElement;
    if (src.nodeName.toLowerCase() == 'li') {
        d.getElementsByName('email')[0].value = src.innerHTML;
        ul.className += 'hide';
    }
})

