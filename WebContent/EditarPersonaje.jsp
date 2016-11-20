<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edicion de personajes</title>
</head>
<body>

<form class="form-signin" name="signin" action="Editar" method="post">
	
	ID: &ensp; &ensp; &ensp; &ensp; &ensp;<input  name="id"  required="">
	
	
	<br>
	<br>
	NOMBRE:  &ensp;<input  name="nombre"  required="">
	<br>
	<br>
	ENERGIA:  &ensp;<input name="energia" required="">
	<br>
	<br>
	DEFENSA:  &ensp;<input name="defensa" required=""> 
	<br>
	<br>
	VIDA: &ensp; &ensp; &ensp; <input name="vida" required="">
	<br>
	<br>
	EVASION: &ensp;<input name="evasion" required=""> 
	
	<br>
	<br>
	<input type="submit" name="bCrear" style="height: 32px; "id="bCrear" value="Editar personaje" >	<%
		String res;
		if (session.getAttribute("error3")!=null){
		 res = session.getAttribute("error3").toString();
		}else{
			res="";
	} %>
	<%="" + res  %>
		

	</form>


</body>
</html>