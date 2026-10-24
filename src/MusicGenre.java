/**
 * Genres that a music disc can have once it is adapted to the catalog.
 */
public enum MusicGenre implements Genre {

    /** Reggaeton music. */
    REGGAETON("Reggaeton"),

    /** Pop music. */
    POP("Pop"),

    /** Tropical music (cumbia, merengue and so on). */
    TROPICAL("Tropical"),

    /** Rock music. */
    ROCK("Rock");

    /** Text shown to the user for this genre. */
    private final String label;

    /**
     * Creates a music genre.
     *
     * @param label text shown to the user for this genre
     */
    MusicGenre(String label) {
        this.label = label;
    }

    /**
     * Returns the text shown to the user for this genre.
     *
     * @return the genre label
     */
    @Override
    public String toString() {
        return label;
    }
}
