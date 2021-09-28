<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <title>New employee</title>
</head>
<body>
<h1>New employee</h1>
<@sf.form action="/employees/new" method="post" modelAttribute="employee">
<#--    <div>-->
<#--        <@sf.label path="id">Id</@sf.label>-->
<#--        <@sf.input path="id"/>-->
<#--        <@sf.errors path="id"/>-->
<#--    </div>-->
    <div>
        <@sf.label path="fio">Fio</@sf.label>
        <@sf.input path="fio"/>
        <@sf.errors path="fio"/>
    </div>
    <div>
        <@sf.label path="salary">Salary</@sf.label>
        <@sf.input path="salary"/>
        <@sf.errors path="salary"/>
    </div>
    <div>
        <@sf.label path="companyid">CompanyId</@sf.label>
        <@sf.input path="companyid"/>
        <@sf.errors path="companyid"/>
    </div>
    <input type="submit">
</@sf.form>
<#--<form action="/employees/new" method="post">-->
<#--    <input name="id" type="number" placeholder="id">-->
<#--    <input name="fio" type="text" placeholder="fio">-->
<#--    <input name="salary" type="number" placeholder="salary">-->
<#--&lt;#&ndash;    <input name="dob" type="datetime-local" placeholder="dob">&ndash;&gt;-->
<#--    <input name="companyid" type="number" placeholder="companyid">-->
<#--    -->
<#--</form>-->
</body>
</html>