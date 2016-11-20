<html>

<body style="text-align:center">

<h1>
<form>
			
		</form>
MENU DEL JUEGO

</h1><form action=index.jsp>
		<input type="submit" value="JUGAR">
	</form>
	<form action=menuAdministrar.jsp>
		<input type="submit"
			id="edit" value="EDITAR PERSONAJES">
	</form>


	<%
	String res;
	if (session.getAttribute("resultado")!=null){
	 res = session.getAttribute("resultado").toString();
	}else{
		res="";
	} %>
	<%="" + res  %>
	

</body>

</html>