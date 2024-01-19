package fr.donovan.exam.centrale_ish.json_views;

public class JsonViewsModel {


    public interface MinimalModel extends Id, Name, Slug {};
    public interface AllModel extends Id, Name, Slug, Brand {};

    public interface Id {}
    public interface Name {}
    public interface Slug {}
    public interface Brand {}
}