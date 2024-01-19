package fr.donovan.exam.centrale_ish.mapping;

public interface UrlRouteListing {

    String URL_LISTING = "/listing";
    String URL_LISTING_NEW = URL_LISTING + "/new";
    String URL_LISTING_EDIT = URL_LISTING + "/edit";

    String URL_ADMIN_LISTING = "/admin" + URL_LISTING;
    String URL_ADMIN_LISTING_NEW = URL_ADMIN_LISTING + "/new";
    String URL_ADMIN_LISTING_EDIT = URL_ADMIN_LISTING + "/edit";
}
