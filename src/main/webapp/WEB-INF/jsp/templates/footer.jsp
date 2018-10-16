<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<div class="footer-container">
    <div class="brand-big">
        <ul>
            <li>
                <a class="navbar-brand" href="#">LUXOFT STUDY - FILES - <span id="currentYear"></span></a>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript">
    $("#currentYear").text(new Date().getFullYear());
</script>


