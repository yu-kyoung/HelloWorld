<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>회원가입(signForm.jsp)</h3>
<form name="signForm" action="signUp.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input class="form-control" type="text" name="userId" required></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input class="form-control" type="password" name="userPw" required></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input class="form-control" type="text" name="userName" required></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input class="form-control" type="file" name="userImg"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="회원가입"> <input type="reset"
					class="btn btn-secondary" value="초기화"></td>
	</table>
</form>

<script>
	let check = false;
	document.forms.signForm.addEventListener('submit', function (e) {

		if (!check) {
			e.preventDefault();
			alert('입력값 확인')
			return;
		}
		this.submit();
	})
	

	
	
	

	document.querySelector('input[name="userId"]').addEventListener('change', function () {

		let user = this.value;

		fetch('checkId.do?id=' + user)
			.then(data => data.json())
			.then(result => {
				if (result.retCode == "Exist") {
					alert("존재 아이디")

				} else {
					alert("사용할수 있는 아이디")
				}
			})
			.catch(err => console.log(err))
	})
</script>