<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="user" scope="request" type="com.zenjava.community.service.data.UserDetail"/>

<h2><c:out value="${user.username}"/></h2>

<dl class="dl-horizontal">

    <dt>First name</dt>
    <dd>
        <c:out value="${user.firstName}" />
    </dd>

    <dt>Last name</dt>
    <dd>
        <c:out value="${user.lastName}" />
    </dd>

    <dt>Roles</dt>
    <dd>
        <c:choose>
            <c:when test="${not empty user.roles}">
                <ul>
                    <c:forEach items="${user.roles}" var="role">
                        <li>
                            <a href="/admin/role/${role.id}"><c:out value="${role.name}" /></a><br/>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                This user has no roles.
            </c:otherwise>
        </c:choose>
    </dd>

</dl>


