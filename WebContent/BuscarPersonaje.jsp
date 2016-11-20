<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form class="form-signin" name="signin" action="Buscar" method="post">
	
	ID:  &ensp; &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<input  name="id"  required="">
	<br>
	<br>
	NOMBRE:  &ensp;
	<%
		String nom;
		if (session.getAttribute("nombre")!=null){
		 nom = session.getAttribute("nombre").toString();
		}else{
			nom="";
	} %>
	<%="" + nom  %>
	<br>
	<br>
	ENERGIA:  &ensp;<%
		String en;
		if (session.getAttribute("energia")!=null){
		 en = session.getAttribute("energia").toString();
		}else{
			en="";
	} %>
	<%="" + en  %>
	<br>
	<br>
	DEFENSA:  &ensp;<%
		String def;
		if (session.getAttribute("defensa")!=null){
		 def = session.getAttribute("defensa").toString();
		}else{
			def="";
	} %>
	<%="" + def  %>  
	<br>
	<br>
	VIDA: &ensp; &ensp; &ensp; <%
		String vida;
		if (session.getAttribute("ataque")!=null){
		 vida = session.getAttribute("ataque").toString();
		}else{
			vida="";
	} %>
	<%="" + vida  %>
	<br>
	<br>
	EVASION: &ensp;<%
		String ev;
		if (session.getAttribute("evasion")!=null){
		 ev = session.getAttribute("evasion").toString();
		}else{
			ev="";
	} %>
	<%="" + ev  %>
	<br>
	<br>
	PUNTOS TOTALES: <%
		String res1;
		if (session.getAttribute("totales")!=null){
		 res1 = session.getAttribute("totales").toString();
		}else{
			res1="";
	} %>
	<%="" + res1  %>
	<br>
	<br>
	<input type="submit" name="bBuscar" style="height: 32px; "id="bBuscar" value="Buscar personaje" >  
	<%
		String res;
		if (session.getAttribute("error2")!=null){
		 res = session.getAttribute("error2").toString();
		}else{
			res="";
	} %>
	<%="" + res  %>
	

</form>

</body>
</html>