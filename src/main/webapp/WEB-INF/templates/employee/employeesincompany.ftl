<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees in ${company.name}</h1>
<a href="/employees/new">Добавить работника</a>
<p>Сортировать по <a href="/employees/sortbyfio">имени</a>
    <a href="/employees/sortbysalary">зарплате</a>
    <a href="/employees/sortbycompany">компании</a>
    <a href="/employees/sortbydob">дате рождения</a>

</p>
Найти по ФИО<form action="/employees/findbyfio/${company.id}" method="get">
    <input name="fio" type="text" placeholder="fio" aria-label="fio">
    <input type="submit" value="Найти">

</form>

Найти по зарплате между
<form action="/employees/findbysalary/${company.id}" method="get">
    <input name="i" type="number" placeholder="от" aria-label=""  >
    <input name="j" type="number" placeholder="до" aria-label="" >
    <input type="submit" value="Найти">
</form>


    <#if employees?has_content>
        <table border="1" cellspacing="0" cellpadding="1">
            <tr class="tableHeader">
                <td>id</td>
                <td>fio</td>
                <td>dob</td>
                <td>company</td>
                <td>salary</td>
                <td>edit</td>
                <td>delete</td>

            </tr>
            <#foreach employee in employees>
                <tr class="tableBody">
                    <td>${employee.id}</td>
                    <td>${employee.fio}</td>
                    <td>${employee.dob?date}</td>
                    <td>${employee.company.name}</td>
                    <td>${employee.salary}</td>
                    <td>
                        <form action="/employees/${employee.id}/edit" method="get">
                            <input type="submit" value="edit">
                        </form>
                    </td>
                    <td>
                        <form action="/employees/${employee.id}/delete" method="get">
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