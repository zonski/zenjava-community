<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="post" action="/admin/setup.do" cssClass="form-horizontal">

    <fieldset>

    <div id="legend">
        <legend class="">Setup system</legend>
    </div>

    <!-- name -->
    <div class="control-group">
        <form:label path="name" cssClass="control-label">System name</form:label>
        <div class="controls">
            <form:input path="name" cssClass="input-xlarge"/>
            <form:errors path="name"/>
        </div>
    </div>

    <!-- description -->
    <div class="control-group">
        <form:label path="description" cssClass="control-label">Description</form:label>
        <div class="controls">
            <form:input path="description" cssClass="input-xlarge"/>
            <form:errors path="description"/>
        </div>
    </div>

    <!-- baseUrl -->
    <div class="control-group">
        <form:label path="description" cssClass="control-label">Base URL</form:label>
        <div class="controls">
            <form:input path="baseUrl" cssClass="input-xlarge"/>
            <form:errors path="baseUrl"/>
        </div>
    </div>

    <!-- emailServer -->
    <div class="control-group">
        <form:label path="emailServer" cssClass="control-label">Email Server</form:label>
        <div class="controls">
            <form:input path="emailServer" cssClass="input-xlarge"/>
            <form:errors path="emailServer"/>
        </div>
    </div>

    <!-- emailPort -->
    <div class="control-group">
        <form:label path="emailPort" cssClass="control-label">Email Port</form:label>
        <div class="controls">
            <form:input path="emailPort" cssClass="input-xlarge"/>
            <form:errors path="emailPort"/>
        </div>
    </div>

    <!-- emailUsername -->
    <div class="control-group">
        <form:label path="emailUsername" cssClass="control-label">Email Username</form:label>
        <div class="controls">
            <form:input path="emailUsername" cssClass="input-xlarge"/>
            <form:errors path="emailUsername"/>
        </div>
    </div>

    <!-- emailPassword -->
    <div class="control-group">
        <form:label path="emailPassword" cssClass="control-label">Email Password</form:label>
        <div class="controls">
            <form:password path="emailPassword" cssClass="input-xlarge"/>
            <form:errors path="emailPassword"/>
        </div>
    </div>

    <!-- Buttons -->
    <div class="control-group">
        <div class="controls">
            <button class="btn btn-success">Setup</button>
        </div>
    </div>

</form:form>
