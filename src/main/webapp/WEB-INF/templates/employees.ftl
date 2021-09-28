<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>
<#if employees?has_content>
    <table border="1" cellspacing="0" cellpadding="1">
        <tr class="tableHeader">
            <td>id</td>
            <td>fio</td>
            <td>companyid</td>
            <td>salary</td>

        </tr>
        <#foreach employee in employees>
            <tr class="tableBody">
                <td>${employee.id}</td>
                <td>${employee.fio}</td>
                <td>${employee.companyid}</td>
                <td>${employee.salary}</td>
            </tr>
        </#foreach>
    </table>
    <#else>
    <p>No employees yet</p>
</#if>
</body>
</html>