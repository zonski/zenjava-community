<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form class="form-horizontal" action='j_spring_security_check' method="POST">

    <fieldset>

        <div id="legend">
            <legend class="">Login</legend>
        </div>

        <div class="control-group">
            <!-- Username -->
            <label class="control-label"  for="username">Username</label>
            <div class="controls">
                <input type="text" id="username" name="j_username" placeholder="" class="input-xlarge"
                       value="<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/>">
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="password" name="j_password" placeholder="" class="input-xlarge">
            </div>
        </div>

        <c:if test="${not empty param.authfailed}">
            <div class="control-group">
                <div class="controls">
                    <span class="alert alert-error">
                        Login failed due to: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                    </span>
                </div>
            </div>
        </c:if>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Login</button>
            </div>
        </div>
    </fieldset>
</form>
