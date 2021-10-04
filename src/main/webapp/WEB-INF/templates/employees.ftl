<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>
<a href="/employees/new">Добавить работника</a>
<#if employees?has_content>
    <table border="1" cellspacing="0" cellpadding="1">
        <tr class="tableHeader">
            <td>id</td>
            <td>fio</td>
            <td>dob</td>
            <td>companyid</td>
            <td>salary</td>
            <td>edit</td>
            <td>delete</td>

        </tr>
        <#foreach employee in employees>
            <tr class="tableBody">
                <td>${employee.id}</td>
                <td>${employee.fio}</td>
                <td>${employee.dob?date}</td>
                <td>${employee.companyid}</td>
                <td>${employee.salary}</td>
                <td>
                    <form action="/employees/${employee.id}/edit" method="get">
                        <input type="submit" value="edit">
                    </form>
                </td>
                <td>
                    <form action="/employees/${employee.id}/delete" method="post">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </#foreach>
    </table>
    <#else>
    <p>No employees yet</p>
</#if>

</body>
</html>