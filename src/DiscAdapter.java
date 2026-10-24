import java.util.List;

/**
 * Adapts a Mixdown {@link Disc} to the {@link Product} interface so it can be
 * listed in the RockBuster catalog.
 *
 * The translation is: artist becomes director, sale price becomes price,
 * the genre text becomes a {@link MusicGenre}, and the data that discs do not
 * have (duration and synopsis) get neutral values.
 */
public final class DiscAdapter implements Product {

    /** The adapted Mixdown disc. */
    private final Disc disc;

    /**
     * Creates an adapter for a disc. It checks the genre right away, so a
     * disc with an unknown genre fails when the catalog is loaded.
     *
     * @param disc the disc to adapt
     * @throws IllegalArgumentException if the genre of the disc does not
     *                                  match any {@link MusicGenre}
     */
    public DiscAdapter(Disc disc) {
        this.disc = disc;
        genre();
    }

    /**
     * Returns the name of the disc.
     *
     * @return the disc name
     */
    @Override
    public String name() {
        return disc.name();
    }

    /**
     * Returns the artist of the disc, which plays the role of the director.
     *
     * @return the artist
     */
    @Override
    public String director() {
        return disc.artist();
    }

    /**
     * Returns the duration of the disc. Discs do not store it, so it is 0.
     *
     * @return always 0
     */
    @Override
    public int duration() {
        return 0;
    }

    /**
     * Translates the genre text of the disc into a {@link MusicGenre},
     * ignoring case.
     *
     * @return the matching music genre
     * @throws IllegalArgumentException if no music genre matches the text
     */
    @Override
    public MusicGenre genre() {
        for (MusicGenre genre : MusicGenre.values()) {
            if (genre.toString().equalsIgnoreCase(disc.genre())) {
                return genre;
            }
        }
        throw new IllegalArgumentException(
                "Genero musical desconocido: " + disc.genre());
    }

    /**
     * Returns the synopsis of the disc. Discs do not have one.
     *
     * @return a message saying it is not available
     */
    @Override
    public String synopsis() {
        return "No disponible";
    }

    /**
     * Returns the price of the disc, which is its sale price.
     *
     * @return the price
     */
    @Override
    public double price() {
        return disc.price();
    }

    /**
     * Returns the menu text of the disc: its name and its price.
     *
     * @return the menu text
     */
    @Override
    public String toString() {
        return name() + "\n   Precio: $" + String.format("%.2f", price());
    }

    /**
     * Returns the complete information of the disc in the same layout used
     * for the rest of the products.
     *
     * @return the detail text
     */
    @Override
    public String detail() {
        return "Nombre: " + name() + "\n"
                + "Artista: " + director() + "\n"
                + "Duracion: " + "No disponible\n"
                + "Genero: " + genre() + "\n"
                + "Sinopsis: " + synopsis() + "\n"
                + "Estreno: " + disc.year() + "\n"
                + "Precio de venta: $" + String.format("%.2f", price());
    }

    /**
     * Returns a list containing only this disc, since a disc is already an
     * individual product.
     *
     * @return a list with this disc
     */
    @Override
    public List<Product> items() {
        return List.of(this);
    }
}
