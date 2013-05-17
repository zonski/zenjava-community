<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <tiles:insertAttribute name="meta"/>

    <!-- Bootstrap -->
    <link href="/resources/ext/bootstrap-2.3.1/css/bootstrap.min.css" rel="stylesheet" media="screen">

    <!-- Crisp theme -->
    <link rel="stylesheet" href="/resources/ext/theme-crisp-cool/assets/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="/resources/ext/theme-crisp-cool/assets/css/header-1.css" type="text/css"/>

    <!-- Custom styles -->
    <link href="/resources/css/community-front-style.css" rel="stylesheet" media="screen">
<body>

<tiles:insertAttribute name="header"/>

<div id="body">
    <div class="container">
        <tiles:insertAttribute name="body"/>
    </div>
</div>

<tiles:insertAttribute name="footer"/>

<script src="/resources/ext/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script src="/resources/ext/bootstrap-2.3.1/js/bootstrap.min.js"></script>

<script src="/resources/ext/theme-crisp-cool/assets/js/ddsmoothmenu-min.js"></script><!-- desktop edge detect menu -->
<script src="/resources/ext/theme-crisp-cool/assets/js/jquery.dcjqaccordion.2.7.min.js"></script><!-- mobile multi-level accordion menu -->
<script src="/resources/ext/theme-crisp-cool/assets/js/jquery.easytabs.min.js"></script><!-- tabs/testimonials -->
<script src="/resources/ext/theme-crisp-cool/assets/js/slide-to-top-accordion-min.js"></script><!-- slide to top accordion toggle -->
<script src="/resources/ext/theme-crisp-cool/assets/js/jquery.easing-1.3.min.js"></script><!--easing-->
<script src="/resources/ext/theme-crisp-cool/assets/js/jquery.flexslider-min.js"></script><!--flexslider content slider twitter slider and initializations-->
<script src="/resources/ext/theme-crisp-cool/assets/js/responsive-tables.js"></script><!--responsive table-->
<script src="/resources/ext/theme-crisp-cool/assets/js/jquery.fitvid.js"></script><!-- responsive videos -->

<script src="/resources/ext/theme-crisp-cool/assets/js/lemmon-slider-min.js"></script><!-- lemmon slider js -->
<script src="/resources/ext/theme-crisp-cool/assets/js/scripts.js"></script><!-- lemmon slider js -->

<tiles:insertAttribute name="scripts" ignore="true"/>

</body>
</html>