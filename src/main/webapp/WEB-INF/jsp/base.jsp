<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Exam";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <link href="../../css/main.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="row w-100">
                <div class="d-flex justify-content-between">
                    <a class="navbar-brand ms-3 btn btn-secondary" href="/">
                        Accueil
                    </a>
                    <a class="navbar-brand ms-3 btn btn-secondary" href="${UrlRoute.URL_LISTING_NEW}">
                        New
                    </a>
                </div>
            </div>

        </nav>
        <div class="container-fluid p-5">