<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../jsp/templates/imports.jsp">
        <jsp:param name="val" value="val"/>
    </jsp:include>
    <title>
        Home
    </title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="/assets/angular-1.4.8/angular.js" type="text/javascript"></script>
    <script src="/assets/angular-1.4.8/angular-route.js" type="text/javascript"></script>
    <script src="/assets/angular-1.4.8/angular-resource.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="../jsp/templates/menu.jsp">
    <jsp:param name="activeMenuItem" value="dashboard"/>
</jsp:include>
<div ng-app="filesApp" ng-controller="filesCtrl" id="filesCtrlId">
    <div class="container-main">
        <div class="filters">
            <div class="line-filter">
                <label>Line width</label>
                <input class="form-control" type="text" id="lineWidth" size="250" title=""/>
            </div>
            <div class="line-filter">
                <button class="btn btn-primary" type="button" data-ng-click="getFiles()">Refresh</button>&nbsp;&nbsp;
                <button class="btn btn-primary" type="button" data-ng-click="clear(lastFileName)">Clear filter</button>
            </div>
        </div>
        <div id="status-message" ng-class="cssResponse == 'OK' ? 'alert alert-success'
                    : cssResponse.includes('ERROR') ? 'alert alert-danger' : ''"> {{response}}
        </div>
        <div class="table-area table-left">
            <div class="card reg-users-container">
                <div class="card-header">
                    Files
                </div>
                <div class="card-body">
                    <table class="table table-striped table-size">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Date/time upload</th>
                            <th>File name</th>
                            <th>Delete</th>
                        </tr>
                        <thead>
                        <tbody>
                        <tr ng-repeat="file in files">
                            <td>{{$index + 1}}</td>
                            <td>{{file.dateTime}}</td>
                            <td>
                                <a class="nav-link" href="#" ng-click="getStatistic(file.fileName)">{{file.fileName}}</a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#deleteModal{{$index + 1}}">
                                    Delete file
                                </button>
                                <!-- Modal delete window -->
                                <div class="modal fade pageModal" id="deleteModal{{$index + 1}}" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="deleteModalLabel">Delete file</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                Do you really want to delete this file?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="button" data-ng-click="deleteFile(file.fileName)" class="btn btn-primary">Confirm</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="table-area table-right">
            <div class="card reg-users-container">
                <div class="card-header">
                    Statistics for selected file
                </div>
                <div class="card-body">
                    <table class="table table-striped table-size">
                        <thead>
                        <tr>
                            <th>Number of line</th>
                            <th>Longest word</th>
                            <th>Shortest word</th>
                            <th>Line length</th>
                            <th>Average word length</th>
                        </tr>
                        <thead>
                        <tbody>
                        <tr ng-repeat="statistic in statistics">
                            <td>{{$index + 1}}</td>
                            <td>{{statistic.longestWord}}</td>
                            <td>{{statistic.shortestWord}}</td>
                            <td>{{statistic.lineLength}}</td>
                            <td>{{statistic.averWordsLength}}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="templates/footer.jsp">
    <jsp:param name="activeFooterItem" value="contacts"/>
</jsp:include>
<script src="${pageContext.request.contextPath}/assets/app/js/files.js" type="text/javascript"></script>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function() {
        angular.element(document.getElementById('filesCtrlId')).scope().getFiles();
    });
</script>
