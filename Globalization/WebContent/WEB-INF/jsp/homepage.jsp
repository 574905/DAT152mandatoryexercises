<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     
     
    <fmt:setLocale value="${language}"/>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<fmt:bundle basename="no.hvl.dat152.properties/Bundle">

<fieldset>
<form method="post">

<button type = "submit" name = "lang" value = "no"><img src="images/norwegian_flag.jpg" width = "35px" height = "30px"></button>
<button type = "submit" name = "lang" value = "en"><img src="images/usa_flag.jpg" width = "35px" height = "30px"></button>
<button type = "submit" name = "lang" value = "es"><img src="images/spanish_flag.jpg" width = "35px" height = "30px"></button>

</form>
</fieldset>
    

	

    <h2>Kaffekopper AS</h2>
    <img src="images/java_cup.jpg" width = "150px" height = "150px"><br>
    <b><fmt:message key = "info"></fmt:message>
    <a href = "product"><fmt:message key = "link_products"></fmt:message></a></b>
    
</fmt:bundle>
</body>
</html>