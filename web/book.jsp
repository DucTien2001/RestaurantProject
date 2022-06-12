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
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/home">Home </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/menu">Menu</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/about">About</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/book?action=checkUser&amp;user=${sessionScope.acc.user}">Book Table <span class="sr-only">(current)</span> </a>
                                </li>
                                <c:if test="${sessionScope.acc.isSell == 1}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="<%=request.getContextPath()%>/promng">Product Management</a>
                                    </li>
                                </c:if>
                                <c:if test="${sessionScope.acc.isAdmin == 1}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="<%=request.getContextPath()%>/accmng">Account Management</a>
                                    </li>
                                </c:if>
                            </ul>    
<%@include file = "header.jsp"%>

        </div>
        <!-- book section -->
        <section class="book_section layout_padding">

            <div class="container">
                <div class="heading_container">
                    <h2>
                        Book A Table
                    </h2>
                </div>
                <p style="color: red"><i>${message}</i></p>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form_container">
                            <form action="bookTable" method="post">
                                <input type="hidden" name="action" value="add">
                                <div>
                                    <input type="text" class="form-control" placeholder="Your Name" name="cusName" value="${book.cusName}" required/>
                                </div>
                                <div>
                                    <input type="text" class="form-control" placeholder="Phone Number" name="cusPhone" value="${book.cusPhone}" required/>
                                </div>
                                <div>
                                    <input type="email" class="form-control" placeholder="Your Email" name="cusEmail" value="${book.cusEmail}" required/>
                                </div>
                                <div>
                                    <input type="text" class="form-control" placeholder="Table" name="idTable" value="${book.idTable}" required/>
                                </div>
                                <div>
                                    <input type="text" class="form-control" placeholder="People" name="people" value="${book.people}" required/>
                                </div>
                                <!--                                <div>
                                                                    <select class="form-control nice-select wide">
                                                                        <option value="${book.idTable}" name="idTable" disabled selected>
                                                                            Choose your table?
                                                                        </option>
                                                                        <option value="${book.idTable}" name="idTable" required>
                                                                            1
                                                                        </option>
                                                                        <option value="${book.idTable}" name="idTable" required>
                                                                            2
                                                                        </option>
                                                                        <option value="${book.idTable}" name="idTable" required>
                                                                            3
                                                                        </option>
                                                                        <option value="${book.idTable}" name="idTable" required>
                                                                            4
                                                                        </option>
                                                                        <option value="${book.idTable}" name="idTable" required>
                                                                            5
                                                                        </option>
                                                                        <option value="${book.idTable}" name="idTable" required>
                                                                            6
                                                                        </option>
                                                                        <option value="${book.idTable}" name="idTable" required>
                                                                            7
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                                <div>
                                                                    <select class="form-control nice-select wide">
                                                                        <option value="${book.people}" name="people" disabled selected>
                                                                            How many persons?
                                                                        </option>
                                                                        <option value="${book.people}" name="people" required>
                                                                            2
                                                                        </option>
                                                                        <option value="${book.people}" name="people" required>
                                                                            3
                                                                        </option>
                                                                        <option value="${book.people}" name="people" required>
                                                                            4
                                                                        </option>
                                                                        <option value="${book.people}" name="people" required>
                                                                            5
                                                                        </option>
                                                                    </select>
                                                                </div>-->
                                <div>
                                    <input type="text" class="form-control" placeholder="Set time example: 2021/01/01" name="time" value="${book.time}" required> 
                                </div>
                                <div >
                                    <input type="submit" value="Book Now">
                                    <!--<input type="hidden" name="action" value="join" class="btn_box">-->
                                   <!-- <a href="<%=request.getContextPath()%>/bookTable">Book</a>
                                    <button>
                                        
                                    </button>-->
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="map_container ">
                            <div id="googleMap"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end book section -->

        <!-- footer section -->
        <%@include file = "footer.jsp"%>
