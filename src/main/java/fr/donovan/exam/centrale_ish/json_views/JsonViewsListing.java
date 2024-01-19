package fr.donovan.exam.centrale_ish.json_views;

public class JsonViewsListing {

    public interface MinimalListing extends Id, Title, ProducedYear, Mileage, Price, Image, Slug, Model {}
    public interface CompleteListing extends Id, Title, Description, ProducedYear, Mileage, Price, CreatedAt, Image, Slug, User, Model {}

    public interface Id {}
    public interface Title {}
    public interface Description {}
    public interface ProducedYear {}
    public interface Mileage {}
    public interface Price {}
    public interface CreatedAt {}
    public interface Image {}
    public interface Slug {}
    public interface User {}
    public interface Model {}
}