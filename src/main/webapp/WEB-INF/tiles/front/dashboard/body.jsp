<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="user" scope="request" type="com.zenjava.community.service.data.UserDetail"/>

<p>Welcome <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></p>
