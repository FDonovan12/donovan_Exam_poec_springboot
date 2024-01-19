package fr.donovan.exam.centrale_ish.json_views;

import fr.donovan.exam.centrale_ish.json_views.JsonViewsListing.*;
import fr.donovan.exam.centrale_ish.json_views.JsonViewsUser.*;
import fr.donovan.exam.centrale_ish.json_views.JsonViewsBrand.*;
import fr.donovan.exam.centrale_ish.json_views.JsonViewsModel.*;

public class JsonViews {

    public interface ListingListJsonViews extends MinimalListing, AllModel, AllBrand {}
    public interface ListingShowJsonViews extends CompleteListing, AllModel, AllBrand {}

    public interface UserListJsonViews extends MinimalUser {}
    public interface UserShowJsonViews extends AllUser, MinimalListing, AllModel, AllBrand {}

    public interface ModelListJsonViews {}
    public interface ModelShowJsonViews {}

    public interface BrandListJsonViews { }
    public interface BrandShowJsonViews {}

}
