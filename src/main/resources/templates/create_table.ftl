<#import "/spring.ftl" as spring />
<head xmlns:form="http://www.w3.org/1999/html">
    <link rel="stylesheet" href="/static/bootstrap.min.css">
    <script src="/static/bootstrap.min.js"></script>
    <style>
        input[type=checkbox] {
            position: relative;
            top: 7px;
        }
    </style>
</head>
<html class="container">
<form method="post" action="/create">
<@spring.bind "view" />
    <div class="form-group">
        <label for="exampleInputEmail1">View name</label>
        <input required type="text" class="form-control" id="exampleInputEmail1" name="name"
               aria-describedby="emailHelp" placeholder="View Name">
    </div>

    <div class="row">
        <div class="col-sm-4">
            <div class="form-group">
                <label>Select groups for Kyiv</label>
                <#list kyivUniversities?keys as university>
                    <#list kyivUniversities?api.get(university) as group>
                        <div class="row">
                            <div class="col-sm-3">
                                <label>${university.title}</label>
                            </div>
                            <div class="col-sm-4">
                                <label>${group.title}</label>
                            </div>
                            <div class="col-sm-1">
                                <input type="checkbox" value="${group.id}" name="kyivGroups" aria-describedby="emailHelp">
                            </div>
                        </div>
                    </#list>
                </#list>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="form-group">
                <label>Select groups for Lviv</label>
                <#list lvivUniversities?keys as university>
                    <#list lvivUniversities?api.get(university) as group>
                        <div class="row">
                            <div class="col-sm-3">
                                <label>${university.title}</label>
                            </div>
                            <div class="col-sm-4">
                                <label>${group.title}</label>
                            </div>
                            <div class="col-sm-1">
                                <input type="checkbox" value="${group.id}" name="lvivGroups" aria-describedby="emailHelp">
                            </div>
                        </div>
                    </#list>
                </#list>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="form-group">
                <label>Select groups for Kharkiv</label>
                <#list kharkivUniversities?keys as university>
                    <#list kharkivUniversities?api.get(university) as group>
                        <div class="row">
                            <div class="col-sm-3">
                                <label>${university.title}</label>
                            </div>
                            <div class="col-sm-4">
                                <label>${group.title}</label>
                            </div>
                            <div class="col-sm-1">
                                <input type="checkbox" value="${group.id}" name="kharkivGroups" aria-describedby="emailHelp">
                            </div>
                        </div>
                    </#list>
                </#list>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="exampleInputEmail13">Author</label>
        <input required type="text" class="form-control" id="exampleInputEmail13" name="author"
               aria-describedby="emailHelp" placeholder="Author">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail14">Information</label>
        <input required type="text" class="form-control" id="exampleInputEmail14" name="info"
               aria-describedby="emailHelp" placeholder="Information">
    </div>

    <button type="submit" class="btn btn-primary">Create</button>
</form>

</html>