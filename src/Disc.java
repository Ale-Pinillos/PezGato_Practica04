/**
 * A music disc from the Mixdown store. It keeps Mixdown's own data 
 * and vocabulary and knows nothing about the RockBuster catalog.
 */
public class Disc {

    /** Name of the disc. */
    private final String name;

    /** Artist of the disc. */
    private final String artist;

    /** Musical genre of the disc. */
    private final String genre;

    /** Release year of the disc. */
    private final int year;

    /** Sale price of the disc. */
    private final double price;

    /**
     * Creates a disc.
     *
     * @param name   name of the disc
     * @param artist artist of the disc
     * @param genre  musical genre
     * @param year   release year
     * @param price  sale price
     */
    public Disc(String name, String artist, String genre, int year, double price) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    /**
     * Returns the name of the disc.
     *
     * @return the disc name
     */
    public String name() {
        return name;
    }

    /**
     * Returns the artist of the disc.
     *
     * @return the artist
     */
    public String artist() {
        return artist;
    }

    /**
     * Returns the musical genre of the disc.
     *
     * @return the genre text
     */
    public String genre() {
        return genre;
    }

    /**
     * Returns the release year of the disc.
     *
     * @return the release year
     */
    public int year() {
        return year;
    }

    /**
     * Returns the sale price of the disc.
     *
     * @return the sale price
     */
    public double price() {
        return price;
    }
}
