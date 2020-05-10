<%-- 
    Document   : alltrainers
    Created on : May 8, 2020, 10:44:20 PM
    Author     : Walter
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--  Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!--  Custom CSS-->
        <link href="<c:url value='/static/css/shared.css' />" rel="stylesheet"></link>
        <title>List of Trainers</title>
    </head>
    <body>
        
        <div class="container text-center">
            <h1 class="mt-3"><small>List of Trainers</small></h1>
            <div class="row d-flex justify-content-center">
                <div class="col-12 col-md-9 d-flex flex-column mt-4">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col" >First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Subject</th>
                                <th scope="col" colspan="2">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${trainers}" var="trainer">
                                <tr>
                                    <th scope="row">${trainer.id}</th>
                                    <td>${trainer.firstName}</td>
                                    <td>${trainer.lastName}</td>
                                    <td>${trainer.subject}</td>
                                    <td><a href="<c:url value="edit/${trainer.id}" />">edit</a></td>
                                    <td><a href="<c:url value="delete/${trainer.id}" />">delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <button class="btn btn-dark ml-auto"><a class="text-white" href="<c:url value='/new' />">Create new trainer</a></button>
                </div>
            </div>
        </div>
    </body>
</html>
