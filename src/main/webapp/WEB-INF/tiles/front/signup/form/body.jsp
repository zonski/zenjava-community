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
            <label class="control-label"  for="username">Username</label>
            <div class="controls">
                <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                <form:errors path="username" />
            </div>
        </div>

        <!-- Email -->
        <div class="control-group">
            <label class="control-label"  for="firstName">Email</label>
            <div class="controls">
                <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                <form:errors path="email" />
            </div>
        </div>

        <!-- First name -->
        <div class="control-group">
            <label class="control-label"  for="firstName">First name</label>
            <div class="controls">
                <input type="text" id="firstName" name="firstName" placeholder="" class="input-xlarge">
                <form:errors path="firstName" />
            </div>
        </div>

        <!-- Last name -->
        <div class="control-group">
            <label class="control-label"  for="lastName">Last name</label>
            <div class="controls">
                <input type="text" id="lastName" name="lastName" placeholder="" class="input-xlarge">
                <form:errors path="lastName" />
            </div>
        </div>

        <!-- Password-->
        <div class="control-group">
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
            </div>
        </div>

        <!-- Confirm password-->
        <div class="control-group">
            <label class="control-label" for="confirmPassword">Confirm password</label>
            <div class="controls">
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="" class="input-xlarge">
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
