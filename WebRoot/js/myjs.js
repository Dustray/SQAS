$(function() {
	function changeTitle(tag) {//更改iframe上方标题
		document.getElementById("showTitle").innerHTML = tag;
	}

	function selectListening() {//简单查询框选择监听
		var obj = document.getElementById("selectType");
		var index = obj.selectedIndex;
		var v = obj.options[index].value;
		if (v == "brldepartmentid") {
			document.getElementById("selectContentA").style.display = "none";
			document.getElementById("selectDepartmentB").style.display = "block";
		} else {
			document.getElementById("selectContentA").style.display = "block";
			document.getElementById("selectDepartmentB").style.display = "none";
		}
		document.getElementById("selectContentA").value = "";
	}
	function contentChange() {//简单查询框文字改变
		document.getElementById("simpleSelectForm").submit();
		$("#simpleSelectForm").submit();
		document.simpleSelectForm.submit();
	}
	
	//toast弹出事件：
	
var intervalCounter = 0;
function hideToast() {
	var alert = document.getElementById("toast");
	alert.style.opacity = 0;
	clearInterval(intervalCounter);
}
function drawToast(message) {
	var alert = document.getElementById("toast");
	if (alert == null) {
		var toastHTML = '<div id="toast">' + message + '</div>';
		document.body.insertAdjacentHTML('beforeEnd', toastHTML);
	} else {
		alert.style.opacity = .5;
	}
	intervalCounter = setInterval("hideToast()", 3000);
}
	
})