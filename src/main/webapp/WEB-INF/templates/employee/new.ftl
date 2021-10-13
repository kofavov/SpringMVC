<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <title>New employee</title>
</head>
<body>
<a href="/logout">Logout</a>
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
<#--    <input name="company_id" type="number" placeholder="company_id" aria-label="company_id">-->
    <label>
        <select name="c" >
            <option>Выберите из списка</option>
            <#foreach c in companies>
                <option value="${c.id}">${c.name}</option>
            </#foreach>
        </select>
    </label>

<#--    <input name="c" type="text" placeholder="company" aria-label="c">-->
    <input type="submit">
</form>
</body>
</html>