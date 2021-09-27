<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>
<ul>
    <#list employees as employee>
        <li>id = ${employee.id},fio = ${employee.fio}, salary = ${employee.salary},  companyId = ${employee.companyid}</li>
    </#list>
</ul>
</body>
</html>