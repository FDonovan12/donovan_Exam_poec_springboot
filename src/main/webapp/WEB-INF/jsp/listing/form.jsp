<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Centrale Ish"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/tag.jsp"/>

    <h1>${listing.title}</h1>
    <f:form modelAttribute="listing" method="post" action="${action}" cssClass="p-5">
        <div class="mb-3 row">
            <f:label path="title" class="col-sm-2 col-form-label">Titre</f:label>
            <div class="col-sm-10 mb-3">
                <f:input type="text" cssClass="form-control" path="title"/>
                <f:errors path="title" cssClass="invalid-feedback"/>
            </div>

            <f:label path="description" class="col-sm-2 col-form-label">Description</f:label>
            <div class="col-sm-10 mb-3">
                <f:input type="text" cssClass="form-control" path="description"/>
                <f:errors path="description" cssClass="invalid-feedback"/>
            </div>

            <f:label path="mileage" class="col-sm-2 col-form-label">Kilometrage</f:label>
            <div class="col-sm-10 mb-3">
                <f:input type="number" cssClass="form-control" path="mileage"/>
                <f:errors path="mileage" cssClass="invalid-feedback"/>
            </div>

            <f:label path="producedYear" class="col-sm-2 col-form-label">Anne de fabrication</f:label>
            <div class="col-sm-10 mb-3">
                <f:input type="number" cssClass="form-control" path="producedYear"/>
                <f:errors path="producedYear" cssClass="invalid-feedback"/>
            </div>

            <f:label path="price" class="col-sm-2 col-form-label">Prix</f:label>
            <div class="col-sm-10 mb-3">
                <f:input type="number" cssClass="form-control" path="price"/>
                <f:errors path="price" cssClass="invalid-feedback"/>
            </div>

            <f:label path="model_id" class="col-sm-2 col-form-label">Modèle</f:label>
            <div class="col-sm-10 mb-3">
                <f:input type="number" cssClass="form-control" path="model_id"/>
                <f:errors path="model_id" cssClass="invalid-feedback"/>
            </div>
        </div>
        <f:button class="btn btn-secondary" type="reset">Reset</f:button>
        <f:button class="btn btn-primary">Submit</f:button>
    </f:form>

<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/footer.jsp"/>
