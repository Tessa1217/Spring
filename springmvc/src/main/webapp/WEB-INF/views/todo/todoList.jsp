<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
/* Include the padding and border in an element's total width and height */
* {
	box-sizing: border-box;
}

/* Remove margins and padding from the list */
ul {
	margin: 0;
	padding: 0;
}

/* Style the list items */
ul li {
	cursor: pointer;
	position: relative;
	padding: 12px 8px 12px 40px;
	background: #eee;
	font-size: 18px;
	transition: 0.2s;
	/* make the list items unselectable */
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
ul li:nth-child(odd) {
	background: #f9f9f9;
}

/* Darker background-color on hover */
ul li:hover {
	background: #ddd;
}

/* When clicked on, add a background color and strike out text */
ul li.checked {
	background: #888;
	color: #fff;
	text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
ul li.checked::before {
	content: '';
	position: absolute;
	border-color: #fff;
	border-style: solid;
	border-width: 0 2px 2px 0;
	top: 10px;
	left: 16px;
	transform: rotate(45deg);
	height: 15px;
	width: 7px;
}

/* Style the close button */
.close {
	position: absolute;
	right: 0;
	top: 0;
	padding: 12px 16px 12px 16px;
}

.close:hover {
	background-color: #f44336;
	color: white;
}

/* Style the header */
.header {
	background-color: #f44336;
	padding: 30px 40px;
	color: white;
	text-align: center;
}

/* Clear floats after the header */
.header:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the input */
input {
	margin: 0;
	border: none;
	border-radius: 0;
	width: 75%;
	padding: 10px;
	float: left;
	font-size: 16px;
}

/* Style the "Add" button */
.addBtn {
	padding: 10px;
	width: 25%;
	background: #d9d9d9;
	color: #555;
	float: left;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	border-radius: 0;
}

.addBtn:hover {
	background-color: #bbb;
}
</style>
<body>
	<div id="myDIV" class="header">
		<h2 style="margin: 5px">My To Do List</h2>
		<input type="text" id="myInput" placeholder="Title..."> <span
			onclick="newElement()" class="addBtn">Add</span>
	</div>
	<ul id="myUL">
	</ul>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script>
	$(function() {
		todoSelect();
		todoInsert();
		todoUpdate(); 
		todoDelete();
		function makeLi(obj) {
		      let li = $(`<li>\${obj.contents}<span class='close'>X</span></li>`);
		      li.attr("data-no", obj.no);
					if (obj.todoyn == "1") {
						li.addClass("checked");
					}
					$("#myUL").append(li);
		    }
		function todoSelect() {
			let url = "http://localhost/mvc/todo";
			$.ajax(url)
				.then(function(arr){
					for (let obj of arr) {
						makeLi(obj);
					}
				});
		}
		function todoInsert() {
			let url = "http://localhost/mvc/todo";
			$(".addBtn").on("click", function() {
        // input value 비어있을 경우
        if ($("#myInput").val() == "") {
          return;
        } 
        else {
        let data = {contents : $("#myInput").val()};
        $.post(url, data, function(data, status) {
          if (status == 'success') {
            makeLi(data);
            $('#myInput').val("");
          }
         })}
      })
		}
		function todoUpdate() {
			let url = "http://localhost/mvc/todo";
			 $("#myUL").on("click", "li", function() {
			   if (this.tagName != "LI") {
			     return;
			   } 
			   else {
		     let data = {};
		     let li = $(this);
		     data.no = li.data("no");
		     li.hasClass("checked") ? data.todoyn = "0" : data.todoyn = "1";
		     // JSON으로 넘겨줄 경우 contentType을 반드시 "application/json"으로 지정 필요
		     $.ajax({
		       url : url,
		       method : 'PUT',
		       contentType : "application/json",
		       dataType: "json",
		       data : JSON.stringify(data)
		       // data : {no, todoyn} (변수명이랑 필드명 똑같을 경우에는 그냥 한번만 적어도 됨)
		      })
		       .then(function(obj) {
		         li.toggleClass("checked");
		       })
			   }
			 })		
		}
		function todoDelete() {
			let url = "http://localhost/mvc/todo";
			$("#myUL").on("click", ".close", function() {
        let li = $(this).parent(); 
        let no = $(this).parent().data("no");
        $.ajax({
          url : url + `/\${no}`,
          method : 'DELETE'
        })
          .then(function(no) {
            li.remove(); 
          })
	      })
			}
	})
	
</script>
</body>
</html>