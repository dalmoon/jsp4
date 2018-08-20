<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="/join.do" method="post">
아이디 : <input type="text" id="id" name="id" oninput="checkId()">
<span id = "chkMsg"></span><br>
비번 : <input type="password" name="pw"><br>
비번확인 : <input type="password" name="PwCheck" onkeyup="checkPwd()">
<div id="checkPwd"></div>
이름 : <input type="text" name="name"><br>
<input type="submit" value="회원가입">
<input type="button" value="취소" onClick="history.back();">
</form>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

function checkId(){
    var id = $('#id').val();
    $.ajax({
        url:'/idDuplChk.do',
        type:'post',
        data:{id:id},
        success:function(data){
            if($.trim(data)==0){
                $('#chkMsg').html("사용 가능합니다.");                
            }else{
                $('#chkMsg').html("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
            }
        },
        error:function(){
                alert("에러입니다");
        }
    });
};

function checkPwd(){
	  var f1 = document.forms[0];
	  var pw1 = f1.pw.value;
	  var pw2 = f1.PwCheck.value;
	  if(pw1!=pw2){
	   document.getElementById('checkPwd').style.color = "red";
	   document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요."; 
	  }else{
	   document.getElementById('checkPwd').style.color = "black";
	   document.getElementById('checkPwd').innerHTML = "암호가 일치 되었습니다."; 
	  }
	 }
</script>
</body>
</html>