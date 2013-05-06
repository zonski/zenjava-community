<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <tiles:insertAttribute name="meta"/>
    <link href="/resources/ext/bootstrap-2.3.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/resources/css/community-style.css" rel="stylesheet" media="screen">
<body>

<div class="container-fluid">

    <div id="header">
        <tiles:insertAttribute name="header"/>
    </div>

    <div id="body" class="container-fluid">
        <tiles:insertAttribute name="body"/>
    </div>

    <div id="footer">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>

<script src="/resources/ext/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script src="/resources/ext/bootstrap-2.3.1/js/bootstrap.min.js"></script>

</body>
</html>