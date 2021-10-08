<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <title>New company</title>
</head>
<body>
<h1>New company</h1>
<#--<@sf.form action="/companies/new"  method="post" modelAttribute="company">-->
<#--&lt;#&ndash;    <div>&ndash;&gt;-->
<#--&lt;#&ndash;        <@sf.label path="id">Id</@sf.label>&ndash;&gt;-->
<#--&lt;#&ndash;        <@sf.input path="id"/>&ndash;&gt;-->
<#--&lt;#&ndash;        <@sf.errors path="id"/>&ndash;&gt;-->
<#--&lt;#&ndash;    </div>&ndash;&gt;-->
<#--    <div>-->
<#--        <@sf.label path="name">name</@sf.label>-->
<#--        <@sf.input path="name"/>-->
<#--        <@sf.errors path="name"/>-->
<#--    </div>-->
<#--    <div>-->
<#--        <@sf.label path="openyear">openyear</@sf.label>-->
<#--        <@sf.input path="openyear"/>-->
<#--        <@sf.errors path="openyear"/>-->
<#--    </div>-->
<#--    <input type="submit">-->
<#--</@sf.form>-->
<form action="/companies/new" method="post">
    <input name="name" type="text" placeholder="name" aria-label="name">
    <input name="openyear" type="number" placeholder="openyear" aria-label="openyear">
    <input type="submit">
</form>
</body>
</html>