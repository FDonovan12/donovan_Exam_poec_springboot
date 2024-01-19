package fr.donovan.exam.centrale_ish.mapping;

public interface UrlRouteModel {

    String URL_MODEL = "/model";
    String URL_MODEL_NEW = URL_MODEL + "/new";
    String URL_MODEL_EDIT = URL_MODEL + "/edit";

    String URL_ADMIN_MODEL = "/admin" + URL_MODEL;
    String URL_ADMIN_MODEL_NEW = URL_ADMIN_MODEL + "/new";
    String URL_ADMIN_MODEL_EDIT = URL_ADMIN_MODEL + "/edit";
}
