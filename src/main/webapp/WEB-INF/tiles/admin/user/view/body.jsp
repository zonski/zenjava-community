<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="user" scope="request" type="com.zenjava.community.service.data.UserDetail"/>

<h2>Roles</h2>
<c:choose>
    <c:when test="${not empty user.roles}">
        <ul>
            <c:forEach items="${user.roles}" var="role">
                <li>
                    <a href="/admin/user/${role.name}"><c:out value="${role.id}" />) <c:out value="${role.name}" /></a><br/>
                </li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        This user has no roles.
    </c:otherwise>
</c:choose>