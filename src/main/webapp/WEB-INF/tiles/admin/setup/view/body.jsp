<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="systemInfo" scope="request" type="com.zenjava.community.service.data.SystemInfoDetail"/>

Name: <c:out value="${systemInfo.name}" /><br/>
Description: <c:out value="${systemInfo.description}" /><br/>
