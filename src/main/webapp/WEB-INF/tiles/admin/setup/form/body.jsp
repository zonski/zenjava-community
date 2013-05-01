<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="post" action="/admin/setup.do">

    <table>
        <tr>
            <td><form:label path="name">System name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="description">System description</form:label></td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Setup"/>
            </td>
        </tr>
    </table>

</form:form>