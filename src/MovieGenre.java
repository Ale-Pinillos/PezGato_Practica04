/**
 * Genres that a {@link Movie} or a {@link Saga} can have.
 */
public enum MovieGenre implements Genre {

    /** Science fiction movies. */
    SCIENCE_FICTION("Ciencia ficcion"),

    /** Fantasy movies. */
    FANTASY("Fantasia"),

    /** Romance and drama movies. */
    ROMANCE_DRAMA("Romance/Drama"),

    /** Action movies. */
    ACTION("Accion");

    /** Text shown to the user for this genre. */
    private final String label;

    /**
     * Creates a movie genre.
     *
     * @param label text shown to the user for this genre
     */
    MovieGenre(String label) {
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
