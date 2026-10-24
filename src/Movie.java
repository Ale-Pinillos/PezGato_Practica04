import java.util.List;

/**
 * It represents an individual movie.
 */
public class Movie implements Product {

    /** Name of the movie. */
    private final String name;

    /** Director of the movie. */
    private final String director;

    /** Duration of the movie in minutes. */
    private final int duration;

    /** Genre of the movie. */
    private final MovieGenre genre;

    /** Synopsis of the movie. */
    private final String synopsis;

    /** Rental price of the movie. */
    private final double price;

    /**
     * Creates a movie.
     *
     * @param name     name of the movie
     * @param director director of the movie
     * @param duration duration in minutes
     * @param genre    genre of the movie
     * @param synopsis synopsis of the movie
     * @param price    rental price
     */
    public Movie(String name, String director, int duration, MovieGenre genre, String synopsis, double price) {
        this.name = name;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.synopsis = synopsis;
        this.price = price;
    }

    /**
     * Returns the name of the movie.
     *
     * @return the movie name
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Returns the director of the movie.
     *
     * @return the director
     */
    @Override
    public String director() {
        return director;
    }

    /**
     * Returns the duration of the movie in minutes.
     *
     * @return the duration in minutes
     */
    @Override
    public int duration() {
        return duration;
    }

    /**
     * Returns the genre of the movie.
     *
     * @return the movie genre
     */
    @Override
    public MovieGenre genre() {
        return genre;
    }

    /**
     * Returns the synopsis of the movie.
     *
     * @return the synopsis
     */
    @Override
    public String synopsis() {
        return synopsis;
    }

    /**
     * Returns the rental price of the movie.
     *
     * @return the price
     */
    @Override
    public double price() {
        return price;
    }

    /**
     * Returns the menu text of the movie: its name and its price.
     *
     * @return the menu text
     */
    @Override
    public String toString() {
        return name + "\n   Precio: $" + String.format("%.2f", price);
    }

    /**
     * Returns the complete information of the movie.
     *
     * @return the detail text
     */
    @Override
    public String detail() {
        return "Nombre: " + name + "\n"
                + "Director: " + director + "\n"
                + "Duracion: " + (duration / 60) + " h " + (duration % 60) + " min\n"
                + "Genero: " + genre + "\n"
                + "Sinopsis: " + synopsis + "\n"
                + "Precio de renta: $" + String.format("%.2f", price);
    }

    /**
     * Returns a list containing only this movie, since a movie is already an
     * individual product.
     *
     * @return a list with this movie
     */
    @Override
    public List<Product> items() {
        return List.of(this);
    }
}
