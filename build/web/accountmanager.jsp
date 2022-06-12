<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="images/favicon.png" type="">

        <title> EaHiu </title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
    </head>
    <body class="sub_page">
        <div class="hero_area">
            <div class="bg-box">
                <img src="images/hero-bg.jpg" alt="">
            </div>
            <!-- header section strats -->
            <header class="header_section">
                <div class="container">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="<%=request.getContextPath()%>/home">
                            <span>
                                EaHiu
                            </span>
                        </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item ">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/home">Home </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/menu">Menu</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/about">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/book?action=checkUser&amp;user=${sessionScope.acc.user}">Book Table</a>
                                </li>
                                <c:if test="${sessionScope.acc.isSell == 1}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="<%=request.getContextPath()%>/promng">Product Management</a>
                                    </li>
                                </c:if> 
                                <c:if test="${sessionScope.acc.isAdmin == 1}">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="<%=request.getContextPath()%>/accmng">Account Management <span class="sr-only">(current)</span> </a>
                                    </li>
                                </c:if>
                            </ul>        
                            <%@include file = "header.jsp"%>
            <!-- end header section -->
        </div>
        <!-- about section -->

        <section class="manager_section layout_padding">
            <div class="container  ">

                <div class="row">
                    <div style="display: flex; justify-content: space-between; width: 100%">
                        <span class="heading_container" style="margin-top: -12px; margin-bottom: 24px;">
                            <h2>
                                List of accounts
                            </h2>
                        </span>
                        <span>
                            <button class="btn btn-dark margin_bottom_40px"><a href="insertaccount.jsp" style="color: white;">Insert</a></button>
                        </span>
                    </div>
                    
                    <table style="width: 100%">
                        <tr>
                            <th>ID</th>
                            <th>User</th>
                            <th>Password</th>
                            <th>IsSell</th>
                            <th>IsAdmin</th>
                            <th colspan="2">Edit</th>
                        </tr>

                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <c:forEach items="${accounts}" var="account" >
                            <tr>
                                <td>${account.id}</td>
                                <td>${account.user}</td>
                                <td>${account.pass}</td>
                                <td>${account.isSell}</td>
                                <td>${account.isAdmin}</td>
                                <td><a href="accmng?action=display_account&amp;id=${account.id}">Update</a></td>
                                <td><a href="accmng?action=delete_account&amp;id=${account.id}">Delete</a></td>
                            
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section>

        <!-- end about section -->

        <!-- footer section -->
        <%@include file = "footer.jsp"%>