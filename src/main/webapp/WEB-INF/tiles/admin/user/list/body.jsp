<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="users" scope="request" type="java.util.List<com.zenjava.community.service.data.UserRef>"/>


<h2>Users</h2>

<table class="table table-striped table-condensed">

    <thead>
    <tr>
        <th>Username</th>
        <th>First name</th>
        <th>Last name</th>
    </tr>
    </thead>

    <tbody>
    <c:choose>
        <c:when test="${not empty users}">
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>
                        <a href="/admin/user/${user.id}"><c:out value="${user.username}" /></a>
                    </td>
                    <td>
                        <c:out value="${user.firstName}"/>
                    </td>
                    <td>
                        <c:out value="${user.lastName}"/>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="3">
                    No users exist.
                </td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>

</table>
