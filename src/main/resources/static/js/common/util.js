//ajax util
function ajaxGet(url, data, success, error) {
	$.ajax({
		url : url,
		cache : false,
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : data,
		method : "GET",
		success : success,
		error : error
	});
}