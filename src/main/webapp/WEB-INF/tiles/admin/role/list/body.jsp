<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="roles" scope="request" type="java.util.List<com.zenjava.community.service.data.RoleRef>"/>

<h2>Roles</h2>

<table class="table table-striped table-condensed">

    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
        </tr>
    </thead>

    <tbody>
    <c:choose>
        <c:when test="${not empty roles}">
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>
                        <a href="/admin/role/${role.id}"><c:out value="${role.name}" /></a><br/>
                    </td>
                    <td>
                        todo
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="2">
                    No roles exist.
                </td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>

</table>