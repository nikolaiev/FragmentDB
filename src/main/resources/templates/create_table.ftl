<head>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
    <script src="/static/bootstrap.min.js"></script>
</head>
<html class="container">
<#--private String name;-->
<#--private List<String> columns;-->
<div class="row">
    <#list tables as table>
        <div class="col-md-3">
            <h3>${table.name}</h3>
            <#list table.columns as column>
                ${column}<br>
            </#list>
        </div>
    </#list>
</div>
<br>
<br>
<br>
<form method="post" action="/create">
    <div class="form-group">
        <label for="exampleInputEmail1">View name</label>
        <input required type="text" class="form-control" id="exampleInputEmail1" name="view_name" aria-describedby="emailHelp" placeholder="View Name">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail12">Select query</label>
        <input required type="text" class="form-control" id="exampleInputEmail12"  name="query" aria-describedby="emailHelp" placeholder="Select Query">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail13">Author</label>
        <input required type="text" class="form-control" id="exampleInputEmail13"  name="author" aria-describedby="emailHelp" placeholder="Author">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail14">Information</label>
        <input required type="text" class="form-control" id="exampleInputEmail14"  name="info" aria-describedby="emailHelp" placeholder="Information">
    </div>

    <button type="submit" class="btn btn-primary">Create</button>
</form>

</html>