            
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        
                            <div class="user_option">
                                
                                <c:if test="${sessionScope.acc != null}">
                                    <div class="topnav" id="myTopnav">
                                            <div class="dropdown">
                                                <a href="" class="user_link dropbtn">
                                                    <i class="fa fa-user" aria-hidden="true"></i>
                                                </a>
                                                <div class="dropdown-content">
                                                  <a href="changepass?action=display_user&amp;user=${account.user}">Change password</a>
                                                  <a href="logout">logout</a>
                                                </div>
                                            </div> 
                                        </a>
                                    </div>
                                </c:if>
                                <c:if test="${sessionScope.acc == null}">
                                    <a href="login.jsp" class="login">
                                        LOGIN
                                    </a>
                                </c:if>
                            </div>
                        </div>
                    </nav>
                </div>
            </header>
            <!-- end header section -->
            