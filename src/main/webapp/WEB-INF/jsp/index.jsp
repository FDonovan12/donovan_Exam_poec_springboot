<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Centrale Ish"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

    <h1>Derniere offre mise sur le site</h1>
    <div class="row">
        <c:forEach items="${listings}" var="listing">
            <a class="col-12 col-md-6 col-lg-4 mt-2 main-listing-card" href="${UrlRoute.URL_LISTING}/${listing.id}">
                <div class="listing-card">
                    <div class="listing-card-img">
                        <img alt="${listing.title}" src="${listing.image}">
                    </div>
                    <div class="d-flex justify-content-between">
                        <p>${listing.model.name}-${listing.model.brand.name}</p>
                        <p>${listing.mileage}KM</p>
                        <p>${listing.price}€</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>

<%@ include file="footer.jsp" %>
