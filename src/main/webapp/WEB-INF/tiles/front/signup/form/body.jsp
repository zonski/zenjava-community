<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="form-horizontal"  action='/signup.do' method="POST" commandName="signUp">

    <fieldset>

        <div id="legend">
            <legend class="">Sign up for an account</legend>
        </div>

        <!-- Username -->
        <div class="control-group">
            <form:label path="username" cssClass="control-label">Username</form:label>
            <div class="controls">
                <form:input path="username" cssClass="input-xlarge"/>
                <form:errors path="username"/>
            </div>
        </div>

        <!-- Email -->
        <div class="control-group">
            <form:label path="email" cssClass="control-label">Email</form:label>
            <div class="controls">
                <form:input path="email" cssClass="input-xlarge"/>
                <form:errors path="email"/>
            </div>
        </div>

        <!-- First name -->
        <div class="control-group">
            <form:label path="firstName" cssClass="control-label">First name</form:label>
            <div class="controls">
                <form:input path="firstName" cssClass="input-xlarge"/>
                <form:errors path="firstName"/>
            </div>
        </div>

        <!-- Last name -->
        <div class="control-group">
            <form:label path="lastName" cssClass="control-label">Last name</form:label>
            <div class="controls">
                <form:input path="lastName" cssClass="input-xlarge"/>
                <form:errors path="lastName"/>
            </div>
        </div>

        <!-- Password-->
        <div class="control-group">
            <form:label path="password" cssClass="control-label">Password</form:label>
            <div class="controls">
                <form:password path="password" cssClass="input-xlarge"/>
                <form:errors path="password"/>
            </div>
        </div>

        <!-- Confirm password-->
        <div class="control-group">
            <form:label path="confirmPassword" cssClass="control-label">Confirm password</form:label>
            <div class="controls">
                <form:password path="confirmPassword" cssClass="input-xlarge"/>
                <form:errors path="confirmPassword"/>
            </div>
        </div>


        <!-- Buttons -->
        <div class="control-group">
            <div class="controls">
                <button class="btn btn-success">Sign up</button>
            </div>
        </div>

    </fieldset>
</form:form>
