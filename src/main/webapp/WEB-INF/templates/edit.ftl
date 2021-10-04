<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <title>Update employee</title>
</head>
<body>
<h1>Update ${employee.fio}</h1>
<#--<@sf.form action="/employees/${employee.id}/edit" method="patch" modelAttribute="employee">-->
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

<#--   <div>-->
<#--       <@sf.label path="dob">dob</@sf.label>-->
<#--       <@sf.input path="dob"/>-->
<#--       <@sf.errors path="dob"/>-->
<#--   </div>-->
<#--    <input type="submit">-->
<#--</@sf.form>-->
<form action="/employees/${employee.id}/edit" method="post">
    <#--    <input name="id" type="number" placeholder="id">-->
    <input name="fio" type="text" placeholder="fio" >
    <input name="salary" type="number" placeholder="salary" >
    <input name="dob" type="date" placeholder="Day-Month-Year" >
    <input name="companyid" type="number" placeholder="companyid" >
    <input type="submit">
</form>
</body>
</html>