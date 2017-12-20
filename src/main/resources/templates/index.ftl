<head>
    <style>

        tr:hover td {
            background: #5bc0de;
        }


    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
<html class="container">
<h1>Choose existing GenTables!</h1>
<a href="/create">Or create one</a>
<br>
<br>

<#if tables??>
    <table  class="table table-striped">
        <tr class="thead-inverse">
            <th>Info</th>
            <th>AuthorName</th>
            <th>ViewName</th>
            <th>Query</th>
        </tr>
    <#list tables as table>
        <tr onclick="window.location = '/view/${table.viewName}'">
            <td>${table.title}</td>
            <td>${table.authorName}</td>
            <td>${table.viewName}</td>
            <td>${table.query}</td>
        </tr>

    </#list>
    </table>
</#if>


</html>