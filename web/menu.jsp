<%-- 
    Document   : menu
    Created on : Oct 29, 2021, 10:01:24 PM
    Author     : Viet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <li class="nav-item active">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/menu">Menu</a>
                                </li>
                                <li class="nav-item">
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
                    </nav>
                </div>
            </header>
            <!-- end header section -->
        </div>

        <!-- food section -->

        <section class="food_section layout_padding">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Our Menu
                    </h2>
                </div>

                <ul class="filters_menu">
                    <li class="active" data-filter="*">All</li>
                    <li data-filter=".burger">Burger</li>
                    <li data-filter=".pizza">Pizza</li>
                    <li data-filter=".pasta">Pasta</li>
                    <li data-filter=".fries">Fries</li>
                </ul>

                <div class="filters-content">
                    <div class="row grid">
                        <c:forEach items="${menus}" var="menu" >
                            <c:choose>
                                <c:when test = "${menu.typeOfFood == 'Pizza'}">
                                    <div class="col-sm-6 col-lg-4 all pizza">
                                        <div class="box">
                                            <div>
                                                <div class="img-box">
                                                    <img src="${menu.picture}" alt="${menu.menuName}">
                                                </div>
                                                <div class="detail-box">
                                                    <h5 class="h5-box">
                                                        ${menu.menuName}
                                                    </h5>
                                                    <p class="p-box">
                                                        ${menu.detail}
                                                    </p>
                                                    <div class="options">
                                                        <h6>
                                                            $${menu.price}
                                                        </h6>
<!--                                                        <form action="cart" method="post">
                                                            <input type="hidden" name="productCode" 
                                                                   value="${menu.menuId}">
                                                            <input type="submit" value="Add To Cart">                                                              
                                                        </form>-->
                                                        <a class="btn btn-dark" href="<%=request.getContextPath()%>/cart?action=checkUser&amp;user=${sessionScope.acc.user}&amp;productCode=${menu.menuId}">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test = "${menu.typeOfFood == 'Hamburger'}">
                                    <div class="col-sm-6 col-lg-4 all burger">
                                        <div class="box">
                                            <div>
                                                <div class="img-box">
                                                    <img src="${menu.picture}" alt="${menu.menuName}">
                                                </div>
                                                <div class="detail-box">
                                                    <h5 class="h5-box">
                                                        ${menu.menuName}
                                                    </h5>
                                                    <p class="p-box">
                                                        ${menu.detail}
                                                    </p>
                                                    <div class="options">
                                                        <h6>
                                                            $${menu.price}
                                                        </h6>
<!--                                                        <form action="cart" method="post">
                                                            <input type="hidden" name="productCode" 
                                                                   value="${menu.menuId}">
                                                            <input type="submit" value="Add To Cart">                                                              
                                                        </form>-->
                                                        <a class="btn btn-dark" href="<%=request.getContextPath()%>/cart?action=checkUser&amp;user=${sessionScope.acc.user}&amp;productCode=${menu.menuId}">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test = "${menu.typeOfFood == 'Pasta'}">
                                    <div class="col-sm-6 col-lg-4 all pasta">
                                        <div class="box">
                                            <div>
                                                <div class="img-box">
                                                    <img src="${menu.picture}" alt="${menu.menuName}">
                                                </div>
                                                <div class="detail-box">
                                                    <h5 class="h5-box">
                                                        ${menu.menuName}
                                                    </h5>
                                                    <p class="p-box">
                                                        ${menu.detail}
                                                    </p>
                                                    <div class="options">
                                                        <h6>
                                                            S${menu.price}
                                                        </h6>
<!--                                                        <form action="cart" method="post">
                                                            <input type="hidden" name="productCode" 
                                                                   value="${menu.menuId}">
                                                            <input type="submit" value="Add To Cart">                                                              
                                                        </form>-->
                                                        <a class="btn btn-dark" href="<%=request.getContextPath()%>/cart?action=checkUser&amp;user=${sessionScope.acc.user}&amp;productCode=${menu.menuId}">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="col-sm-6 col-lg-4 all fries">
                                        <div class="box">
                                            <div>
                                                <div class="img-box">
                                                    <img src="${menu.picture}" alt="${menu.menuName}">
                                                </div>
                                                <div class="detail-box">
                                                    <h5 class="h5-box">
                                                        ${menu.menuName}
                                                    </h5>
                                                    <p class="p-box">
                                                        ${menu.detail}
                                                    </p>
                                                    <div class="options">
                                                        <h6>
                                                            $${menu.price}
                                                        </h6>
<!--                                                        <form action="cart" method="post">
                                                            <input type="hidden" name="productCode" 
                                                                   value="${menu.menuId}">
                                                            <input type="submit" value="Add To Cart">                                                              
                                                        </form>-->
                                                        <a class="btn btn-dark" href="<%=request.getContextPath()%>/cart?action=checkUser&amp;user=${sessionScope.acc.user}&amp;productCode=${menu.menuId}">Add To Cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>

        <!-- end food section -->

        <!-- footer section -->
        <%@include file = "footer.jsp"%>