<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>
   <#macro repeat count>
       <#local y = "test">
       <#list 1..count as x>
           ${y} ${count}/${x} : <#nested>
       </#list>
   </#macro>

    <@repeat count=3>${y!"?"} ${x!"?"}${count!"?"}</@repeat>
</h1>
</body>
</html>