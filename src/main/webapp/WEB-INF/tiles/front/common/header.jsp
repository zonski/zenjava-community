<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- begin accesibility skip to nav skip content -->
<ul class="visuallyhidden" id="top">
    <li><a href="#nav" title="Skip to navigation" accesskey="n">Skip to navigation</a></li>
    <li><a href="#page" title="Skip to content" accesskey="c">Skip to content</a></li>
</ul>
<!-- end /.visuallyhidden accesibility-->

<!-- mobile navigation trigger-->
<h5 class="mobile_nav"><a href="javascript:void(0)">&nbsp;<span></span></a></h5>
<!--end mobile navigation trigger-->

<section class="container preheader">

    <nav class="user clearfix">
        <sec:authorize access="isAuthenticated()">
            <ul class="social">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <sec:authentication property="principal.username"/> <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
                <a href="/login"><i class="icon-user"></i> Login</a>
                <a href="/signup"><i class="icon-pencil"></i> Sign Up</a>
        </sec:authorize>
    </nav>

    <div class="search-wrapper">
        <form class="search" method="post" action="search">
            <div id="search-trigger">Search:</div>
            <input id="search-box" type="text" placeholder="search + enter">
        </form>
    </div>
    <ul class="social">
        <li><a class="socicon small rss" href="#" data-placement="bottom" title="Subscribe to our RSS feed"></a></li>
        <li><a class="socicon small facebook" href="#" data-placement="bottom" title="Follow us on Facebook"></a></li>
        <li><a class="socicon small twitterbird" href="#" data-placement="bottom" title="Follow us on Twitter"></a></li>
        <li><a class="socicon small linkedin" href="#" data-placement="bottom" title="Follow us on LinkedIn"></a></li>
        <li><a class="socicon small dribbble" href="#" data-placement="bottom" title="Follow us on dribble"></a></li>
        <li><a class="socicon small vimeo" href="#" data-placement="bottom" title="Follow us on Vimeo"></a></li>
    </ul>
</section>


<!-- begin .header-->
<header class="header clearfix"><img src="/resources/ext/theme-crisp-cool/assets/images/print-logo.png"
                                     class="print logo" alt="name of company"/>

    <div class="container">

        <!-- begin #main_menu -->
        <nav id="main_menu">
            <ul class="accordmobile">
                <li class="active"><a href="/dashboard">Dashboard</a></li>
                <li class="parent"><a href="javascript:void(0)">Sample Menu<i></i></a>
                    <ul>
                        <li><a href="#">Sample menu item 1</a></li>
                        <li><a href="#">Sample menu item 2</a></li>
                        <li><a href="#">Sample menu item 3</a></li>
                        <li><a href="#">Sample menu item 4</a></li>
                        <li><a href="#">Sample menu item 5</a></li>
                    </ul>
                </li>
                <li><a href="/account">My Account</a></li>
            </ul>
        </nav>
        <!-- close / #main_menu -->

        <!-- begin #logo -->
        <div id="logo"><a href="/"><img alt="" src="/resources/ext/theme-crisp-cool/assets/images/trans.gif"/><em>Crisp
            Responsive HTML Retina Ready Bootstrap Goodness</em><!--effing ie7 support--></a></div>
        <!-- end #logo -->

    </div>
    <!-- close / .container-->
</header>
<!-- close /.header -->


<%--
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="/">ZenJava Community</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="/dashboard">Dashboard</a></li>
                </ul>


            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
--%>
