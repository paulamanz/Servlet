<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mi libreria</title>
</head>
<body>
<h2>Bienvenido a esta libreria!</h2>

<h3>Que deseas hacer?</h3>

	<form action="home" method="post">
 
        <input type="submit" id= "ins" value="Insertar libro"/>
 
	</form>

	<form action="stock" method="get">
 
        <input type="submit" id = "ver" value="Ver libros"/>
 
    </form>


</body>
</html>