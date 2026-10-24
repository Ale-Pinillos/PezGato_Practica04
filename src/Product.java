import java.util.List;

/**
 * Common interface for everything the store sells: movies, sagas and discs.
 *
 * The client treats every product through this interface
 * and never needs to know which concrete kind it is handling.
 */
public interface Product {

    /**
     * Returns the name of the product.
     *
     * @return the product name
     */
    String name();

    /**
     * Returns the director of the product (the artist, for a disc).
     *
     * @return the director or artist
     */
    String director();

    /**
     * Returns the duration of the product in minutes. A product without a
     * known duration returns 0.
     *
     * @return the duration in minutes
     */
    int duration();

    /**
     * Returns the genre of the product.
     *
     * @return the genre
     */
    Genre genre();

    /**
     * Returns the synopsis of the product.
     *
     * @return the synopsis, or a message saying it is not available
     */
    String synopsis();

    /**
     * Returns the price of the product.
     *
     * @return the price
     */
    double price();

    /**
     * Returns the complete information of the product.
     *
     * @return the detail text
     */
    String detail();

    /**
     * Returns the individual products contained in this product.
     * An individual product returns a list with only itself, and a
     * saga returns the individual products of all its components.
     *
     * @return the list of individual products
     */
    List<Product> items();
}
