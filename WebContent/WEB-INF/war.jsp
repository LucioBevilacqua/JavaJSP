
<%@page import="entidades.Personaje"%>
<%@page import="ctrl.ABMCPersonaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>War!!</title>
</head>
<body>
	<h1>War!!</h1>
	
	<% 
		Personaje p1= ((Personaje)session.getAttribute("P1"));
		Personaje p2= ((Personaje)session.getAttribute("P2"));
		ABMCPersonaje ctrl = ((ABMCPersonaje)application.getAttribute("CTRL"));
		
	%>
	<%=" "+p1.getNombre()+" " %> 	&ensp;    &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  &ensp; &ensp;<%=" "+p2.getNombre() %>
	<br>
	<br>
	Vida:  <%= p1.getAtaque() %> 	&ensp;    &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  &ensp;Vida:   <%= p2.getAtaque() %>
	<br>
	Energia: <%= p1.getEnergia() %> &ensp;    &ensp;  &ensp;  &ensp;  &ensp;  &ensp;   Energia:  <%= p2.getEnergia() %>	
	<br>
	Defensa: <%= p1.getDefensa() %> &ensp;    &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  Defensa:  <%= p2.getDefensa() %>	
	<br>
	Evasion: <%= p1.getEvasion() %> &ensp;    &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  &ensp;  Evasion:  <%= p2.getEvasion() %>	
	<br>
	<br>
	Turno: <%= " " + ctrl.getTurno().getNombre() %>
	<br>
	<br>
	Energia ataque: 
	
<form class="form-signin" name="signin" action="Atacar" method="post">	
<input name="tEnergia" id="inputEnergia" class="form-control" placeholder="tEnergia" required="" autofocus="" type="">
<input type="submit" name="bAtacar" style="height: 32px; "id="bAtacar" value="ATACAR" >   

<%
	String error;
	if (session.getAttribute("error")!=null){
	 error = session.getAttribute("error").toString();
	}else{
		error="";
	} %>
	<%="" + error  %>
<%--<input type="hidden" name="ctrl" value="${ctrl}"/> --%>
</form>

<form class="form-signin" name="signin" action="Defender" method="post">	
<input type="submit" name="bDefender" style="height: 32px; "id="bDefender" value="DEFENDER">
	</form>


</body>
</html>