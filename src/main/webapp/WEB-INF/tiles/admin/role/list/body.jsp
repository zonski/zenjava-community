<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="roles" scope="request" type="java.util.List<com.zenjava.community.service.data.RoleRef>"/>

<c:choose>
    <c:when test="${not empty roles}">
        <ul>
            <c:forEach items="${roles}" var="role">
                <li>
                    <a href="/admin/role/${role.id}"><c:out value="${role.name}" /></a><br/>
                </li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        No roles exist.
    </c:otherwise>
</c:choose>