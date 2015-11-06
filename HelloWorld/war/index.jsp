<%-- 
    Document   : index
    Created on : Jan 22, 2015, 2:30:44 AM
    Author     : Xingzi Guo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RSA Algorithm</title>
    </head>
    <body>
        <h3>Input x and y, I will give you the result of calculation.</h3>
        <form method="GET" action="BigCalc">
            <label for="numberLable">Input Integer x: </label>
            <input type="text" name="x" value=<%=request.getAttribute("x") == null ? "" : request.getAttribute("x")%> > <p>
            
            <label for="numberLable">Input Integer y: </label>
            <input type="text" name="y" value=<%=request.getAttribute("y") == null ? "" : request.getAttribute("y")%> > <p>
                
            <label for="operatorLabel">Select a operator:</label>
            <select name="option">
                    <option value="add">add</option>
                    <option value="multiply">multiply</option>
                    <option value="relativelyPrime">relativelyPrime</option>
                    <option value="mod">mod</option>
                    <option value="modInverse">modInverse</option>
                    <option value="power">power</option>
                </select> <p>
            <input type = "submit" value="Submit" /> <p>
        </form>
        <p><%= request.getAttribute("result") != null ? request.getAttribute("result") : ""%></p>
    </body>
</html>
