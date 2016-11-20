<html>

<body style="text-align:center">

<h1>

MENU DE ADMINISTRACIÓN

</h1><form action=CrearPersonaje.jsp>

	<input type="submit" value="CREAR PERSONAJE">
	<%		
		request.getSession().setAttribute("error1","");		 
	%>
	</form>
	<form action=EditarPersonaje.jsp>
		<input type="submit"
			id="edit" value="EDITAR PERSONAJE">
	</form>
	<form action=EliminarPersonaje.jsp>
		<input type="submit"
			id="eliminar" value="ELIMINAR PERSONAJE">
	</form>
	<form action=BuscarPersonaje.jsp>
		<input type="submit"
			id="buscar" value="BUSCAR PERSONAJE">
	</form>
	
</body>


</html>