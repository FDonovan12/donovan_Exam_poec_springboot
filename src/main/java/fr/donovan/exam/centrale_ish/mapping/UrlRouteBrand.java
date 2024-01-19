package fr.donovan.exam.centrale_ish.mapping;

public interface UrlRouteBrand {

    String URL_BRAND = "/brand";
    String URL_BRAND_NEW = URL_BRAND + "/new";
    String URL_BRAND_EDIT = URL_BRAND + "/edit";

    String URL_ADMIN_BRAND = "/admin" + URL_BRAND;
    String URL_ADMIN_BRAND_NEW = URL_ADMIN_BRAND + "/new";
    String URL_ADMIN_BRAND_EDIT = URL_ADMIN_BRAND + "/edit";
}
