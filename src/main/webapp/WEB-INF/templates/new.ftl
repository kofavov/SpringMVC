<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <title>New employee</title>
</head>
<body>
<h1>New employee</h1>
<#--<@sf.form action="/employees/new" method="post" modelAttribute="employee">-->
<#--&lt;#&ndash;    <div>&ndash;&gt;-->
<#--&lt;#&ndash;        <@sf.label path="id">Id</@sf.label>&ndash;&gt;-->
<#--&lt;#&ndash;        <@sf.input path="id"/>&ndash;&gt;-->
<#--&lt;#&ndash;        <@sf.errors path="id"/>&ndash;&gt;-->
<#--&lt;#&ndash;    </div>&ndash;&gt;-->
<#--    <div>-->
<#--        <@sf.label path="fio">Fio</@sf.label>-->
<#--        <@sf.input path="fio"/>-->
<#--        <@sf.errors path="fio"/>-->
<#--    </div>-->
<#--    <div>-->
<#--        <@sf.label path="salary">Salary</@sf.label>-->
<#--        <@sf.input path="salary"/>-->
<#--        <@sf.errors path="salary"/>-->
<#--    </div>-->
<#--    <div>-->
<#--        <@sf.label path="companyid">CompanyId</@sf.label>-->
<#--        <@sf.input path="companyid"/>-->
<#--        <@sf.errors path="companyid"/>-->
<#--    </div>-->

<#--   <input type="date" name="dob" placeholder="dob">-->


<#--    <input type="submit">-->
<#--</@sf.form>-->
<form action="/employees/new" method="post">
<#--    <input name="id" type="number" placeholder="id">-->
    <input name="fio" type="text" placeholder="fio" aria-label="fio">
    <input name="salary" type="number" placeholder="salary" aria-label="salary">
    <input name="dob" type="date" placeholder="Day-Month-Year" aria-label="dob">
    <input name="companyid" type="number" placeholder="companyid" aria-label="companyid">
    <input type="submit">
</form>
</body>
</html>