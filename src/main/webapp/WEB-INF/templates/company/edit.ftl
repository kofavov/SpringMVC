<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <title>Edit company</title>
</head>
<body>
<h1>Edit company</h1>
<@sf.form action="/companies/${company.id}/edit"  method="post" modelAttribute="company">
<#--    <div>-->
<#--        <@sf.label path="id">Id</@sf.label>-->
<#--        <@sf.input path="id"/>-->
<#--        <@sf.errors path="id"/>-->
<#--    </div>-->
    <div>
        <@sf.label path="name">name</@sf.label>
        <@sf.input path="name"/>
        <@sf.errors path="name"/>
    </div>
    <div>
        <@sf.label path="openyear">openyear</@sf.label>
        <@sf.input path="openyear"/>
        <@sf.errors path="openyear"/>
    </div>
    <input type="submit">
</@sf.form>
<#--<form action="/company/new" method="post">-->
<#--    <input name="name" type="text" placeholder="name" aria-label="name">-->
<#--    <input name="openyear" type="number" placeholder="openyear" aria-label="openyear">-->
<#--    <input type="submit">-->
<#--</form>-->
</body>
</html>
