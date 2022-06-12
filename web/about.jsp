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
                                <li class="nav-item active">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/about">About <span class="sr-only">(current)</span> </a>
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
                                    <li class="nav-item">
                                        <a class="nav-link" href="<%=request.getContextPath()%>/accmng">Account Management</a>
                                    </li>
                                </c:if>
                            </ul>  
                            <%@include file = "header.jsp"%>
                            <!-- end header section -->
                        </div>
                        <!--about section--> 

                        <section class="about_section layout_padding">
                            <div class="container  ">

                                <div class="row">
                                    <div class="col-md-6 ">
                                        <div class="img-box">
                                            <img src="images/about-img.png" alt="">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="detail-box">
                                            <div class="heading_container">
                                                <h2>
                                                    We Are EaHiu
                                                </h2>
                                            </div>
                                            <p>
                                                As you enter the place you are welcomed by a magnificent setting, a delightful marriage of antique cut stones and the luxuries of modernity. Sitting in any table you have a wonderful view of the workshop-like kitchen where you can see the chefs working. For those who do not book a table and are waiting, there is a cosy lounge with aged leather armchairs and pictures of polo players displayed on the walls.
                                                <br>
                                                The menu offers a wide variety of mouth-watering starters. I had the white asparagus accompanied by a mousseline sauce and poached eggs, while my friend tried the zucchini carpaccio served with sundries tomatoes and a mozzarella strudel. They were exquisite. The main course consisted in a risotto with scallop cooked in cream and a cassolette of coley with mussels, which really thrilled us. It all was followed by a delicious apple pie served with a scoop of vanilla ice cream for dessert.
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>

                        <!--end about section--> 

                        <!--footer section--> 
                        <%@include file = "footer.jsp"%>
