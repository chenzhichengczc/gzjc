$(".mu-send-msg-btn").click(function () {
    var url = "../user/insertUserInformation";
    var data = $("#ajax-contact").serialize();
    $.ajax({
        "url": url,
        "data": data,
        "type": "POST",
        "dataType": "json",
        "success": function(result){
            if(result.code == 500){
                $("#errorMessage").text(result.msg)
            }
        }
    })
});
$("input[type='text']").focus(function () {
    $("#errorMessage").text("");
})


// function checkform() {
//     if(document.getElementById("name").value.length == 0){
//
//     }else if(document.getElementById("phone").value.length == 0){
//
//     }else if(document.getElementById("email").value.length == 0){
//
//     }else if(document.getElementById("subject").value.length == 0){
//
//     }else if(document.getElementById("message").value.length == 0){
//
//     }
// }