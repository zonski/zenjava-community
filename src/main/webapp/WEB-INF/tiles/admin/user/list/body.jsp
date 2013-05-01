<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="users" scope="request" type="java.util.List<com.zenjava.community.service.data.UserRef>"/>

<c:choose>
    <c:when test="${not empty users}">
        <dl class="listings">
            <c:forEach items="${users}" var="user">
                <dt>
                    <a href="/admin/user/${user.id}"><c:out value="${user.username}" /></a><br/>
                </dt>
            </c:forEach>
        </dl>
    </c:when>
    <c:otherwise>
        No users exist.
    </c:otherwise>
</c:choose>