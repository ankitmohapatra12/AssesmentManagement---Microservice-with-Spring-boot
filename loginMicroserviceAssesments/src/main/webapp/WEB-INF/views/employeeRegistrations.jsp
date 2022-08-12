<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
		#employees caption{
		font-family:Century Gothic;
		color:#6D2AE2;
		font-style:bold;
		margin-bottom: 30px;
	
		}
		
		#employees {
		  font-family: Century Gothic;
		  border-collapse: collapse;
		  width: 80%;
		  margin-left: 150px;
		}
		
		#employees td, #employees th {
		  border: 1px solid #ddd;
		  padding: 8px;
		}
		
		#employees tr:nth-child(even){background-color: #f2f2f2;}
		
		#employees tr:hover {background-color: #ddd;}
		
		#employees th {
		  padding-top: 12px;
		  padding-bottom: 12px;
		  text-align: left;
		  background-color: #6D2AE2;
		  color: white;
		}
		  
		</style>
		<script type="text/javascript">
		 $(document).ready(function() {
		        var user_id = document.getElementById('hid').value;
		        console.log(user_id);
		        if(user_id === ""){
		        	window.location.href = "/login";
		        }
		    });
   		 </script>
	</head>
	<body>
	<div>
		<ul>
		 
			  <li><a href="/Admin/Homepage">Home</a></li>
			  <li><a class="active" href="/Admin/getAllEmployeeAssesments">Employee Assesment Registrations</a></li>
			  <li id="li4"><a href="/logout">LOGOUT</a></li>
			</ul>
			<input type="hidden" id="hid" value="${user_id}">
		<table id="employees"><caption>EMPLOYEE ASSESMENTS REGISTRATIONS</caption>
		
		  <tr>
		    
		    <th>USER ID</th>
		    <th>ASSESMENTS</th>
		    <th>Date</th>
		    <th>ASSESMENT TYPE</th>
		  </tr>
		 <c:forEach items="${assesment}" var="item">
		  
		  <tr>
		    <td>${item.user_id}</td>
		    <td>${item.assesments}</td>
		    <td>${item.dateField}</td>
		    <td>${item.assesmentType}</td>
		    
		  </tr>
		  </c:forEach>
		</table>
	 
	</div>
	
</html>