<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="role" scope="request" type="com.zenjava.community.service.data.RoleDetail"/>

<h2>Role <c:out value="${role.name}"/></h2>

<p>
    <c:out value="${role.description}" />
</p>

todo show permissions