$(function() {

	// 获得表单.
	var form = $('#ajax-contact');

	// 获得div里的信息.
	var formMessages = $('#form-messages');

	// 为联系人表单设置事件侦听器.
	$(form).submit(function(e) {
		// 停止浏览器提交表单.
		e.preventDefault();

		// 序列化表单数据.
		var formData = $(form).serialize();

		// 使用AJAX提交表单.
		$.ajax({
			type: 'POST',
			url: $(form).attr('action'),
			data: formData
		})
		.done(function(response) {
			// Make sure that the formMessages div has the 'success' class.
			$(formMessages).removeClass('error');
			$(formMessages).addClass('success');

			// Set the message text.
			$(formMessages).text(response);

			// Clear the form.
			$('#name').val('');
			$('#email').val('');
			$('#subject').val('');
			$('#message').val('');
		})
		.fail(function(data) {
			// Make sure that the formMessages div has the 'error' class.
			$(formMessages).removeClass('success');
			$(formMessages).addClass('error');

			// Set the message text.
			if (data.responseText !== '') {
				$(formMessages).text(data.responseText);
			} else {
				$(formMessages).text('Oops! An error occured and your message could not be sent.');
			}
		});

	});

});
