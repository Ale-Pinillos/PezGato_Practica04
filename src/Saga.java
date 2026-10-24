import java.util.ArrayList;
import java.util.List;

/**
 * It represents a saga: a group of movies and other sagas.
 *
 * Its duration and price are not stored. They are calculated every time
 * they are requested by asking each component, so they never become
 * outdated when components are added or removed.
 */
public class Saga implements Product {

    /** Discount applied to the sum of the prices of the components. */
    private static final double DISCOUNT = 0.05;

    /** Name of the saga. */
    private final String name;

    /** Director of the saga. */
    private final String director;

    /** Genre of the saga. */
    private final MovieGenre genre;

    /** Synopsis of the saga. */
    private final String synopsis;

    /** Components of the saga: movies and other sagas. */
    private final ArrayList<Product> content;

    /**
     * Creates an empty saga.
     *
     * @param name     name of the saga
     * @param director director of the saga
     * @param genre    genre of the saga
     * @param synopsis synopsis of the saga
     */
    public Saga(String name, String director, MovieGenre genre, String synopsis) {
        this.name = name;
        this.director = director;
        this.genre = genre;
        this.synopsis = synopsis;
        this.content = new ArrayList<>();
    }

    /**
     * Adds a component to the saga. The component is shared, not copied, so
     * the same product can belong to several sagas.
     *
     * @param product the movie or saga to add
     */
    public void addProduct(Product product) {
        content.add(product);
    }

    /**
     * Removes a component from the saga.
     *
     * @param product the movie or saga to remove
     */
    public void removeProduct(Product product) {
        content.remove(product);
    }

    /**
     * Returns the name of the saga.
     *
     * @return the saga name
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Returns the director of the saga.
     *
     * @return the director
     */
    @Override
    public String director() {
        return director;
    }

    /**
     * Returns the duration of the saga: the sum of the durations of its
     * components, in minutes.
     *
     * @return the total duration in minutes
     */
    @Override
    public int duration() {
        int total = 0;
        for (Product product : content) {
            total += product.duration();
        }
        return total;
    }

    /**
     * Returns the genre of the saga.
     *
     * @return the saga genre
     */
    @Override
    public MovieGenre genre() {
        return genre;
    }

    /**
     * Returns the synopsis of the saga.
     *
     * @return the synopsis
     */
    @Override
    public String synopsis() {
        return synopsis;
    }

    /**
     * Returns the price of the saga: the sum of the prices of its components
     * with a 5% discount. A component that is itself a saga already includes
     * its own discount.
     *
     * @return the discounted price
     */
    @Override
    public double price() {
        double total = 0;
        for (Product product : content) {
            total += product.price();
        }
        return total * (1 - DISCOUNT);
    }

    /**
     * Returns the menu text of the saga: its name and its price.
     *
     * @return the menu text
     */
    @Override
    public String toString() {
        return name + "\n   Precio: $" + String.format("%.2f", price());
    }

    /**
     * Returns the complete information of the saga, including the names of
     * its components.
     *
     * @return the detail text
     */
    @Override
    public String detail() {
        StringBuilder components = new StringBuilder();
        for (Product product : content) {
            components.append("\n  - ").append(product.name());
        }
        return "Nombre: " + name + "\n"
                + "Director: " + director + "\n"
                + "Duracion: " + (duration() / 60) + " h " + (duration() % 60) + " min\n"
                + "Genero: " + genre + "\n"
                + "Sinopsis: " + synopsis + "\n"
                + "Precio de renta: $" + String.format("%.2f", price()) + "\n"
                + "Contiene:" + components;
    }

    /**
     * Returns the individual products of the saga. It asks each
     * component for its own individual products and joins the answers,
     * so subsagas are traversed recursively. A product shared by several
     * components may appear more than once in the result.
     *
     * @return the list of individual products
     */
    @Override
    public List<Product> items() {
        List<Product> result = new ArrayList<>();
        for (Product product : content) {
            result.addAll(product.items());
        }
        return result;
    }
}
