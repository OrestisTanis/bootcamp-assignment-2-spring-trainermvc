<%-- 
    Document   : newtrainer
    Created on : May 9, 2020, 10:11:27 AM
    Author     : Walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--  Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Register New Trainer</title>
        <style>
            .error {
                color: #ff0000;
                display:block;
                font-size: 0.8rem;
            }
            
            button {
                background-color: #343A40 !important;
                border-color:#343A40 !important;
                color: white !important;
            }
            button:hover {
                text-decoration: underline !important;
                color: white !important;
            }
        </style>
    </head>
    <body>
        <h1 class="text-center mt-4">Register New Trainer</h1>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-9 col-lg-6">
                    <form:form method="POST" modelAttribute="trainer" class="mt-3">
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <form:input class="form-control" path="firstName" id="firstName" />
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <form:input class="form-control" path="lastName" id="lastName" />
                            <form:errors path="lastName" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="subject" >Subject</label>
                            <form:input class="form-control" path="subject" id="subject" />
                            <form:errors path="subject" cssClass="error"/>
                        </div>
                        <button type="submit" class="btn"/>Register trainer</button>
                    </form:form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
