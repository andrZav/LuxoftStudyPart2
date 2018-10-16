<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:url value="rediret:/{home}" var="homeUrl">
    <spring:param name="home" value="home" />
</spring:url>
<nav class="navbar navbar-expand-md navbar-light bg-white custom-menu">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse " id="navbarsExampleDefault">
        <a class="navbar-brand" href="#">
            <%--<img src="../assets/img/"  alt="">--%>
            Logo place
        </a>
        <ul class="navbar-nav mr-auto menu-container">
            <li class="nav-item">
                <a class="nav-link" href="${homeUrl}" >Home page
                    <img src="../assets/icons/svg/si-glyph-house.svg" alt="" width="20" height="20" />
                </a>
            </li>
        </ul>
    </div>
</nav>
