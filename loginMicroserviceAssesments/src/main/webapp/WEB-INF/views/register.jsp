<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>


.form {
margin-top:90px;
  position: relative;
  z-index: 1;
  background-color:white;
  max-width: 400px;
max-height:460px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: Century Gothic;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: Century Gothic;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 40%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form #loginbtn {
  font-family: Century Gothic;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 40%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}

body {
  background: #6D2AE2;
 
  font-family: Century Gothic;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}

select {
  box-sizing: border-box;

  appearance: none;

  background-color: white;
  color:#6D2AE2;
  border-color:#6D2AE2;
  padding: 5px;
  margin-top: 10px;
margin-bottom:45px;
  width: 100%;
text-align:center;
  font-family: Century Gothic;
  font-size: 16px;
  font-weight: 500;
  line-height: 1.3;

  cursor: default;
}
</style>

<div class="form">
    <form class="register-form" action="/registerUser" method="post">
<h3 style="color:#6D2AE2;margin-bottom:30px;">PLEASE REGISTER</h3>
      <input type="text" placeholder="username" name="userName" value="${userName}" required/>
      <input type="password" name="password" placeholder="password" required/>
      <input type="password" name="confirmpassword" placeholder="confirm password" required/>
         <select name="userLevel" id="cars">
						  <option value="EMPLOYEE">EMPLOYEE</option>
						  <option value="ADMIN">ADMIN</option>
					</select>
      				<input id="loginbtn" type="button" value="LOGIN" style="background-color: #6D2AE2;color:white;" onclick="loginPage()">
      				<input type="submit" value="REGISTER" id="loginbtn" style="background-color: #6D2AE2;color:white;">      
      
					<c:choose>
			  			<c:when test="${not empty registerErr}">
			   				<div><p class="message" style="color:red;background-color:white;">${registerErr}</p></div>
			  			</c:when>
						<c:when test="${not empty registrationError}">
			   				<div><p class="message" style="color:red;background-color:white;">${registrationError}</p></div>
			  			</c:when>
			  			<c:otherwise>
			  		  		<div><br></div>
			  			</c:otherwise>
				  </c:choose>
    </form>
		
  </div>
	
<script>
	function loginPage(){
		window.location.href = "/login";
	}
</script>