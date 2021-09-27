<html>
<head>
    <title>New employee</title>
</head>
<body>
<h1>New employee</h1>
<form action="/employees/new" method="post">
    <input name="id" type="number" placeholder="id">
    <input name="fio" type="text" placeholder="fio">
    <input name="salary" type="number" placeholder="salary">
<#--    <input name="dob" type="datetime-local" placeholder="dob">-->
    <input name="companyid" type="number" placeholder="companyid">
    <input type="submit">
</form>
</body>
</html>