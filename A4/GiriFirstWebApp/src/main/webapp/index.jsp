<html>
<style>
/* Same styling */
body {
	margin: 0;
	padding: 0;
	background: #0d0f13;
	font-family: "Segoe UI", sans-serif;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	color: #fff;
}

.container {
	background: #1a1d24;
	width: 360px;
	padding: 30px;
	border-radius: 18px;
	box-shadow: 0 0 25px rgba(0, 0, 0, 0.5);
	text-align: center;
}

h2 {
	margin-bottom: 25px;
	font-weight: 500;
	color: #4da8ff;
	letter-spacing: 1px;
}

label {
	float: left;
	margin-left: 5%;
	margin-bottom: 5px;
	font-size: 14px;
	color: #99a3b5;
}

input {
	width: 90%;
	padding: 14px;
	margin-bottom: 18px;
	border-radius: 10px;
	background: #262a32;
	border: 1px solid #3a3f49;
	color: #fff;
	font-size: 17px;
	outline: none;
	transition: 0.2s;
}

input:focus {
	border-color: #4da8ff;
	background: #2d323c;
}

button {
	padding: 14px;
	background: #4da8ff;
	color: #000;
	border: none;
	width: 100%;
	border-radius: 10px;
	cursor: pointer;
	font-size: 17px;
	font-weight: bold;
	transition: 0.25s;
}

button:hover {
	background: #77c4ff;
}
</style>
<body>
<%-- 	<h2><%="Hello World!"%></h2> --%>

	<div class="container">
		<form action="second" method="get">
			<label>Enter Name</label> <input name="name" type="text" required> 
			<label>Enter Age</label> <input name="age" type="number" required>

			<button type="submit">Submit</button>
		</form>
	</div>

</body>
</html>
