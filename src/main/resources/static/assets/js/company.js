$(function () {
    $.ajax({
        url:"../company/getCompanyMessage",
        type:"GET",
        dataType:"json",
        cache:false,
        async:false,
        success:function(data){
            $("#com_introduction_text").html(data.data.comIntroductionText);
            $("#com_business").html(data.data.comBusiness);
            $("#com_culture").html(data.data.comCulture);

        }
    })
})