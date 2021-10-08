<html>
<head>
    <title>Companies</title>
</head>
<body>
<h1>Companies</h1>
<a href="/companies/new">Добавить компанию</a>
<#if companies?has_content>
    <table border="1" cellspacing="0" cellpadding="1">
        <tr class="tableHeader">
            <td>id</td>
            <td>name</td>
            <td>openyear</td>
            <td>employees</td>
            <td>edit</td>
            <td>delete</td>

        </tr>
        <#foreach company in companies>
            <tr class="tableBody">
                <td>${company.id}</td>
                <td>${company.name}</td>
                <td>${company.openyear}</td>
                <td>${company.employeesSize}</td>
                <td>
                    <form action="/companies/${company.id}/edit" method="get">
                        <input type="submit" value="edit">
                    </form>
                </td>
                <td>
                    <form action="/companies/${company.id}/delete" method="get">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </#foreach>
    </table>
<#else>
    <p>No companies yet</p>
</#if>

</body>
</html>