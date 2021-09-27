<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>
<#if employees?has_content>
<ul>
    <#list employees as employee>
        <li>id = ${employee.id},fio = ${employee.fio}, salary = ${employee.salary},  companyId = ${employee.companyid}</li>
    </#list>
</ul>
    <#else>
    <p>No employees yet</p>
</#if>
</body>
</html>