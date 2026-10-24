/**
 * Common type for every genre in the catalog, whether it belongs to a movie
 * or to a music disc.
 *
 * It lets the filtering method accept any genre in a single parameter type,
 * while {@link MovieGenre} and {@link MusicGenre} keep movies and discs from
 * receiving genres of the other kind.
 */
public interface Genre {
}
