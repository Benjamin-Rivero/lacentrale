package fr.hb.lacentrale.json_views;

public class JsonViewListing {

    public interface ListingListView extends Uuid,Title,Price,Mileage,ProducedAt,Images,JsonViewImage.Path {}
    public interface ListingShowView extends ListingListView, CreatedAt, Owner,Fuel,Model,Address {}

    public interface Images {
    }

    public interface Fuel {
    }

    public interface Model {
    }

    public interface Owner {
    }

    public interface Address {
    }

    public interface Title {
    }

    public interface Description {
    }

    public interface CreatedAt {
    }

    public interface ProducedAt {
    }

    public interface Mileage {
    }

    public interface Price {
    }

    public interface Uuid {
    }
}
