<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>
</head>
<#if tableRows[0]??>
<html class="container">
<h1>${tableName} generated table</h1>
<br>
<table class="table table-striped">

    <tr class="thead-inverse">
            <#assign item = tableRows[0]/>

            <#list item?keys as prop>
                <th>${prop}</th>
            </#list>
    </tr>
    <tbody>

        <#list tableRows as row>
            <#if row??>
                <tr>
                    <#list row?keys as prop>
                        <td>${row[prop]}</td>
                    </#list>
                </tr>
            </#if>
        </#list>

    </tbody>
</table>
</html>
<#else >
Table is Empty
</#if>