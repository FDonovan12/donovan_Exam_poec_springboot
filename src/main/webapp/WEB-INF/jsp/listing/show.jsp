<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Centrale Ish"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/tag.jsp"/>

    <h1>${listing.title}</h1>
        <p class="mt-2 main-listing-card">
            <div class="listing-card-full">
                <div class="h-50 h-md-75 h-lg-100 listing-card-img">
                    <img alt="${listing.title}" src="${listing.image}">
                </div>
                <div class="d-flex justify-content-between">
                    <p>${listing.model.name}-${listing.model.brand.name}</p>
                    <p>${listing.mileage}KM</p>
                    <p>${listing.price}€</p>
                </div>
            </div>
    <p>Voiture fabriqué en ${listing.producedYear}</p>
    <h2 class="mt-4 mb-2">Description</h2>
    <p>${listing.description}</p>

<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/footer.jsp"/>
