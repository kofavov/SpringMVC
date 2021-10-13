<html>
<head>
    <title>Companies</title>
</head>
<body>
<a href="/logout">Logout</a>
<h1>Companies</h1>
<a href="/companies/new">Добавить компанию</a>
<p>Сортировать по <a href="/companies/sortbyname">имени</a>
    <a href="/companies/sortbyemployees">количеству сотрудников</a>
    <a href="/companies/sortbysalary">средней зарплате</a>
    <a href="/companies/sortbyyear">году основания</a>
</p>
<#if companies?has_content>
    <table border="1" cellspacing="0" cellpadding="1">
        <tr class="tableHeader">
            <td>id</td>
            <td>name</td>
            <td>openyear</td>
            <td>employees</td>
            <td>average salary</td>
            <td>List employees</td>
            <td>edit</td>
            <td>delete</td>

        </tr>
        <#foreach company in companies>
            <tr class="tableBody">
                <td>${company.id}</td>
                <td>${company.name}</td>
                <td>${company.openyear}</td>
                <td>${company.employeesSize}</td>
                <td>${company.averageSalary}</td>
                <td>
                    <form action="/employees/${company.id}/getListForCompany" method="get">
                        <input type="submit" value="getList">
                    </form>
                </td>
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