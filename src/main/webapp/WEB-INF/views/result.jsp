<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!--  Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Action Result Page</title>
        <style>


        </style>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row text-center d-flex justify-content-center">
                <div class="col-10">
                    <p class="lead">${msg}</p>
                    <br/>
                    <br/>
                    Go back to <a href="<c:url value='/list' />">List of All Trainers</a>
                </div> 
            </div>
        </div>
    </body>
</html>