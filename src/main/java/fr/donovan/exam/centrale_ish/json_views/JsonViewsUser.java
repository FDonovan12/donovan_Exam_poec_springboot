package fr.donovan.exam.centrale_ish.json_views;

public class JsonViewsUser {

    public interface MinimalUser extends Id, CreatedAt, Email{};
    public interface AllUser extends Id, CreatedAt, Email, Listings{};

    public interface Id {}
    public interface CreatedAt {}
    public interface Email {}
    public interface Password {}
    public interface Roles {}
    public interface Listings {}
}