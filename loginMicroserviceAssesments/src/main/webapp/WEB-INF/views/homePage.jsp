<html>
	<head>
	<style>
		body {
		      float:top;
			  font-size: 15px;
			  width:100%;
			  height:100%;
			   margin_left:-20px;
			  margin_top:-20px;
			  font-family:Century Gothic;
			}
			
			ul {
			  list-style-type: none;
			  overflow: hidden;
			  background-color: #6D2AE2;
			 position: -webkit-sticky; 
			  position: sticky;
			 
			  
			}
			
			li {
			  float: left;
			}
			
			li a {
			  display: block;
			  color: white;
			  text-align: center;
			  padding: 14px 26px;
			  text-decoration: none;
			}
			
			li a:hover {
			  background-color: white;
			  color:#6D2AE2;
			}
			
			.active {
			  color:#6D2AE2 ;
			  background-color:white;
			}
			
			#li4{
			float:right;
			}
			
			
			
			#welcome{
			
			text-align:center;
			margin-top:350px;
			font-size:40px;		
			font-family:Century Gothic;
				}
	</style>
	</head>
	<body>
	    

			<ul>
			  <li><a class="active" href="/Home">Home</a></li>
			  <li><a href="/Employee/behavioralTechnicalAssesment">Behavioral Assesment Registration</a></li>
			  <li><a href="/Employee/scheduleTechnicalAssesment">Technical Assesment Registration</a></li>
			  <li id="li4"><a href="/logout">LOGOUT</a></li>
			</ul>
	
		<h1 id="welcome" style="color:lightblue">Welcome <span style="color:#6D2AE2">${UserName}</span></h1>
		
		<input type="hidden" name="user_id" value="${user_id}" readonly="readonly">
	
		
	</body>
</html>