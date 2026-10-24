import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * RockBuster catalog. It treats movies, sagas and adapted discs uniformly 
 * through {@link Product}.
 *
 * The catalog is created in the main method and passed as a parameter
 * to the methods that need it, together with the {@link Scanner}. 
 * Each menu method owns its own loop: it prints, reads, acts, and 
 * returns to its caller when the user chooses to go back.
 */
public class RockBuster {

    /**
     * Starts the program: creates the scanner, loads the catalog and opens
     * the main menu.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> catalog = loadCatalog();
        System.out.println("BIENVENIDO A ROCKBUSTER");
        showMainMenu(catalog, sc);
        System.out.println("Gracias por tu visita, esperamos que vuelva pronto");
        sc.close();
    }

    /**
     * Creates every product of the store and returns the single list that
     * holds them. Each movie is created only once and shared by every
     * saga that contains it.
     *
     * @return the list with all the products of the store
     */
    private static List<Product> loadCatalog() {
        // MOVIES
        Movie swEp1 = new Movie("Star Wars Episodio I: La Amenaza Fantasma", "George Lucas", 136,
                MovieGenre.SCIENCE_FICTION, "Dos Jedi rescatan a la reina Amidala de un bloqueo comercial y descubren a Anakin, un nino esclavo con un poder extraordinario en la Fuerza.", 40);
        Movie swEp2 = new Movie("Star Wars Episodio II: El Ataque de los Clones", "George Lucas", 142,
                MovieGenre.SCIENCE_FICTION, "Diez anos despues, Obi-Wan investiga un complot mientras Anakin protege a Padme; una guerra galactica esta a punto de comenzar.", 40);
        Movie swEp3 = new Movie("Star Wars Episodio III: La Venganza de los Sith", "George Lucas", 140,
                MovieGenre.SCIENCE_FICTION, "La Guerra de los Clones llega a su fin, Anakin cae bajo la influencia de Palpatine y la Republica se convierte en el Imperio.", 40);
        Movie swEp4 = new Movie("Star Wars Episodio IV: Una Nueva Esperanza", "George Lucas", 121,
                MovieGenre.SCIENCE_FICTION, "Luke Skywalker se une a Obi-Wan, Han Solo y la princesa Leia para destruir la Estrella de la Muerte del Imperio.", 40);
        Movie swEp5 = new Movie("Star Wars Episodio V: El Imperio Contraataca", "Irvin Kershner", 124,
                MovieGenre.SCIENCE_FICTION, "El Imperio persigue a la Rebelion mientras Luke entrena con Yoda y Darth Vader le revela una verdad que lo cambia todo.", 40);
        Movie swEp6 = new Movie("Star Wars Episodio VI: El Retorno del Jedi", "Richard Marquand", 131,
                MovieGenre.SCIENCE_FICTION, "Los rebeldes libran su batalla decisiva contra el Imperio y Luke se enfrenta a Vader y al Emperador.", 40);
        Movie swEp7 = new Movie("Star Wars Episodio VII: El Despertar de la Fuerza", "J. J. Abrams", 138,
                MovieGenre.SCIENCE_FICTION, "Treinta anos despues, Rey, Finn y Poe se unen a la Resistencia contra la Primera Orden y buscan a Luke Skywalker.", 60);
        Movie swEp8 = new Movie("Star Wars Episodio VIII: Los Ultimos Jedi", "Rian Johnson", 152,
                MovieGenre.SCIENCE_FICTION, "Rey busca respuestas junto a un Luke desencantado mientras la Resistencia huye de la flota de la Primera Orden.", 60);
        Movie swEp9 = new Movie("Star Wars Episodio IX: El Ascenso de Skywalker", "J. J. Abrams", 142,
                MovieGenre.SCIENCE_FICTION, "La Resistencia se enfrenta a la Primera Orden en la batalla final y Rey descubre el peso de su legado.", 60);
        Movie rogueOne = new Movie("Rogue One: Una Historia de Star Wars", "Gareth Edwards", 133,
                MovieGenre.SCIENCE_FICTION, "Un grupo de rebeldes se infiltra para robar los planos de la Estrella de la Muerte, justo antes de los hechos de Una Nueva Esperanza.", 60);
        Movie hp1 = new Movie("Harry Potter y la piedra filosofal", "Chris Columbus", 152,
                MovieGenre.FANTASY, "Harry descubre que es mago y comienza su primer ano en Hogwarts, donde investiga junto a sus amigos el misterio de la piedra filosofal.", 40);
        Movie hp2 = new Movie("Harry Potter y la camara secreta", "Chris Columbus", 161,
                MovieGenre.FANTASY, "Una antigua camara de Hogwarts vuelve a abrirse y los alumnos empiezan a ser petrificados; Harry debe descubrir al responsable.", 40);
        Movie hp3 = new Movie("Harry Potter y el prisionero de Azkaban", "Alfonso Cuaron", 142,
                MovieGenre.FANTASY, "Un peligroso prisionero escapa de Azkaban y Harry descubre como su historia esta ligada a la de su familia.", 40);
        Movie hp4 = new Movie("Harry Potter y el caliz de fuego", "Mike Newell", 157,
                MovieGenre.FANTASY, "Harry es inscrito misteriosamente en el Torneo de los Tres Magos mientras Voldemort prepara su regreso.", 40);
        Movie hp5 = new Movie("Harry Potter y la Orden del Fenix", "David Yates", 138,
                MovieGenre.FANTASY, "El Ministerio niega el regreso de Voldemort y Harry forma con sus amigos un grupo secreto para aprender a defenderse.", 60);
        Movie hp6 = new Movie("Harry Potter y el misterio del principe", "David Yates", 153,
                MovieGenre.FANTASY, "Dumbledore guia a Harry por el pasado de Voldemort mientras la guerra se acerca a Hogwarts.", 60);
        Movie hp7 = new Movie("Harry Potter y las Reliquias de la Muerte: Parte 1", "David Yates", 146,
                MovieGenre.FANTASY, "Harry, Ron y Hermione abandonan Hogwarts para buscar y destruir los Horrocruxes que mantienen vivo a Voldemort.", 60);
        Movie hp8 = new Movie("Harry Potter y las Reliquias de la Muerte: Parte 2", "David Yates", 130,
                MovieGenre.FANTASY, "Estalla la batalla final en Hogwarts mientras Harry termina su mision contra Voldemort.", 60);
        Movie fb1 = new Movie("Animales fantasticos y donde encontrarlos", "David Yates", 132,
                MovieGenre.FANTASY, "El magizoologo Newt Scamander llega a Nueva York con su maleta de criaturas magicas, y varias de ellas escapan.", 60);
        Movie fb2 = new Movie("Animales fantasticos: Los crimenes de Grindelwald", "David Yates", 134,
                MovieGenre.FANTASY, "Grindelwald escapa de prision y Newt, a peticion de Dumbledore, se une a la busqueda de Credence en Paris.", 60);
        Movie fb3 = new Movie("Animales fantasticos: Los secretos de Dumbledore", "David Yates", 142,
                MovieGenre.FANTASY, "Dumbledore forma un equipo para frenar los planes de Grindelwald de apoderarse del mundo magico.", 60);
        Movie ss1 = new Movie("Cincuenta sombras de Grey", "Sam Taylor-Johnson", 125,
                MovieGenre.ROMANCE_DRAMA, "La estudiante Anastasia Steele conoce al magnate Christian Grey y comienza una relacion intensa y complicada.", 40);
        Movie ss2 = new Movie("Cincuenta sombras mas oscuras", "James Foley", 118,
                MovieGenre.ROMANCE_DRAMA, "Anastasia y Christian intentan reconciliarse mientras su pasado amenaza con separarlos de nuevo.", 40);
        Movie ss3 = new Movie("Cincuenta sombras liberadas", "James Foley", 105,
                MovieGenre.ROMANCE_DRAMA, "Ya casados, Anastasia y Christian enfrentan nuevos peligros y deben aprender a confiar el uno en el otro.", 40);
        Movie ff1 = new Movie("Rapido y furioso", "Rob Cohen", 106,
                MovieGenre.ACTION, "Un policia encubierto se infiltra en el mundo de las carreras callejeras de Los Angeles para investigar una serie de robos.", 40);
        Movie ff2 = new Movie("2 Rapido 2 furioso", "John Singleton", 107,
                MovieGenre.ACTION, "Brian se alia con un viejo amigo en Miami para infiltrarse en la red de un traficante a cambio de limpiar su historial.", 40);
        Movie ff5 = new Movie("Rapidos y furiosos 5in control", "Justin Lin", 130,
                MovieGenre.ACTION, "El equipo de Dom planea un golpe en Rio de Janeiro contra un poderoso narcotraficante mientras un agente federal los persigue.", 60);
        Movie ff6 = new Movie("Rapidos y furiosos 6", "Justin Lin", 130,
                MovieGenre.ACTION, "Hobbs pide ayuda al equipo de Dom para detener a una banda de mercenarios en Europa a cambio de un indulto.", 60);
        Movie ff7 = new Movie("Rapidos y furiosos 7", "James Wan", 137,
                MovieGenre.ACTION, "El equipo enfrenta a Deckard Shaw, un exagente que busca vengar a su hermano, en una persecucion que cruza continentes.", 60);
        Movie hobbsShaw = new Movie("Rapidos y furiosos: Hobbs & Shaw", "David Leitch", 137,
                MovieGenre.ACTION, "Hobbs y Shaw, enemigos declarados, deben unir fuerzas para detener a un villano con tecnologia que amenaza a la humanidad.", 60);

        // SAGAS
        Saga precuelas = new Saga("Saga: Trilogia de Precuelas", "George Lucas",
                MovieGenre.SCIENCE_FICTION, "El ascenso de Anakin Skywalker, la caida de la Republica y el nacimiento de Darth Vader.");
        precuelas.addProduct(swEp1);
        precuelas.addProduct(swEp2);
        precuelas.addProduct(swEp3);
        Saga original = new Saga("Saga: Trilogia Original", "George Lucas, Irvin Kershner, Richard Marquand",
                MovieGenre.SCIENCE_FICTION, "Luke, Leia y Han enfrentan al Imperio Galactico y a Darth Vader en la trilogia que dio inicio a la saga.");
        original.addProduct(swEp4);
        original.addProduct(swEp5);
        original.addProduct(swEp6);
        Saga secuelas = new Saga("Saga: Trilogia de Secuelas", "J. J. Abrams, Rian Johnson",
                MovieGenre.SCIENCE_FICTION, "Rey, Finn y Poe se enfrentan a la Primera Orden decadas despues de la caida del Imperio.");
        secuelas.addProduct(swEp7);
        secuelas.addProduct(swEp8);
        secuelas.addProduct(swEp9);
        Saga starWars = new Saga("Saga: Star Wars", "Varios directores",
                MovieGenre.SCIENCE_FICTION, "La lucha entre la Rebelion y el Imperio a lo largo de tres generaciones: precuelas, trilogia original, secuelas y Rogue One.");
        starWars.addProduct(precuelas);
        starWars.addProduct(rogueOne);
        starWars.addProduct(original);
        starWars.addProduct(secuelas);
        Saga harryPotter = new Saga("Saga: Harry Potter", "Chris Columbus, Alfonso Cuaron, Mike Newell, David Yates",
                MovieGenre.FANTASY, "Los ocho filmes del joven mago Harry Potter, desde su llegada a Hogwarts hasta el enfrentamiento final con Voldemort.");
        harryPotter.addProduct(hp1);
        harryPotter.addProduct(hp2);
        harryPotter.addProduct(hp3);
        harryPotter.addProduct(hp4);
        harryPotter.addProduct(hp5);
        harryPotter.addProduct(hp6);
        harryPotter.addProduct(hp7);
        harryPotter.addProduct(hp8);
        Saga fantasticBeasts = new Saga("Saga: Animales Fantasticos", "David Yates",
                MovieGenre.FANTASY, "Las aventuras del magizoologo Newt Scamander y el conflicto contra Grindelwald, medio siglo antes de Harry Potter.");
        fantasticBeasts.addProduct(fb1);
        fantasticBeasts.addProduct(fb2);
        fantasticBeasts.addProduct(fb3);
        Saga wizardingWorld = new Saga("Saga: Wizarding World", "Varios directores",
                MovieGenre.FANTASY, "El universo magico de J. K. Rowling: las historias de Harry Potter y de Newt Scamander en una sola coleccion.");
        wizardingWorld.addProduct(harryPotter);
        wizardingWorld.addProduct(fantasticBeasts);
        Saga shades = new Saga("Saga: Cincuenta Sombras", "Sam Taylor-Johnson, James Foley",
                MovieGenre.ROMANCE_DRAMA, "La relacion entre Anastasia Steele y Christian Grey, de su primer encuentro a su vida en pareja.");
        shades.addProduct(ss1);
        shades.addProduct(ss2);
        shades.addProduct(ss3);
        Saga furiousFamily = new Saga("Saga: Rapidos y Furiosos 5 a 7", "Justin Lin, James Wan",
                MovieGenre.ACTION, "La etapa en que el equipo de Dom deja las carreras callejeras para convertirse en una familia de ladrones y agentes encubiertos.");
        furiousFamily.addProduct(ff5);
        furiousFamily.addProduct(ff6);
        furiousFamily.addProduct(ff7);
        Saga furious = new Saga("Saga: Rapidos y Furiosos", "Varios directores",
                MovieGenre.ACTION, "Una seleccion de la franquicia de carreras y accion: los inicios, la etapa familiar y el spin-off de Hobbs & Shaw.");
        furious.addProduct(ff1);
        furious.addProduct(ff2);
        furious.addProduct(hobbsShaw);
        furious.addProduct(furiousFamily);

        //DISCS
        Disc rompe = new Disc("Rompe", "Daddy Yankee", "Reggaeton", 2005, 149);
        Disc pose = new Disc("Pose", "Daddy Yankee", "Reggaeton", 2008, 149);
        Disc dtmf = new Disc("DtMF", "Bad Bunny", "Reggaeton", 2025, 179);
        Disc baileInolvidable = new Disc("BAILE INoLVIDABLE", "Bad Bunny", "Reggaeton", 2025, 179);
        Disc levitating = new Disc("Levitating", "Dua Lipa", "Pop", 2020, 159);
        Disc newRules = new Disc("New Rules", "Dua Lipa", "Pop", 2017, 139);
        Disc seven = new Disc("Seven", "Jungkook", "Pop", 2023, 169);
        Disc snty = new Disc("Standing Next to You", "Jungkook", "Pop", 2023, 169);
        Disc motorYMotivo = new Disc("Motor y Motivo", "Grupo 5", "Tropical", 2006, 129);
        Disc laCulebritica = new Disc("La Culebritica", "Grupo 5", "Tropical", 2010, 129);
        Disc lasAvispas = new Disc("Las Avispas", "Juan Luis Guerra", "Tropical", 2004, 149);
        Disc laTravesia = new Disc("La Travesia", "Juan Luis Guerra", "Tropical", 2007, 149);
        Disc bohemianRhapsody = new Disc("Bohemian Rhapsody", "Queen", "Rock", 1975, 199);
        Disc dontStopMeNow = new Disc("Don't Stop Me Now", "Queen", "Rock", 1979, 189);
        Disc deMusicaLigera = new Disc("De musica ligera", "Soda Stereo", "Rock", 1990, 169);
        Disc tratameSuave = new Disc("Tratame suavemente", "Soda Stereo", "Rock", 1984, 159);

        // COMPLETE CATALOG
        List<Product> catalog = new ArrayList<>();
        catalog.add(starWars);
        catalog.add(original);
        catalog.add(swEp4);
        catalog.add(wizardingWorld);
        catalog.add(shades);
        catalog.add(furious);
        catalog.add(hp1);

        catalog.add(new DiscAdapter(rompe));
        catalog.add(new DiscAdapter(pose));
        catalog.add(new DiscAdapter(dtmf));
        catalog.add(new DiscAdapter(baileInolvidable));
        catalog.add(new DiscAdapter(levitating));
        catalog.add(new DiscAdapter(newRules));
        catalog.add(new DiscAdapter(seven));
        catalog.add(new DiscAdapter(snty));
        catalog.add(new DiscAdapter(motorYMotivo));
        catalog.add(new DiscAdapter(laCulebritica));
        catalog.add(new DiscAdapter(lasAvispas));
        catalog.add(new DiscAdapter(laTravesia));
        catalog.add(new DiscAdapter(bohemianRhapsody));
        catalog.add(new DiscAdapter(dontStopMeNow));
        catalog.add(new DiscAdapter(deMusicaLigera));
        catalog.add(new DiscAdapter(tratameSuave));
        
        return catalog;
    }

    /**
     * Runs the main menu loop. It shows the options and the whole catalog in
     * alphabetical order, reads the option and calls the matching screen.
     * It returns only when the user chooses to exit.
     *
     * @param catalog the list with all the products
     * @param sc      the scanner used to read the user input
     */
    private static void showMainMenu(List<Product> catalog, Scanner sc) {
        while (true) {
            List<Product> ordered = orderLexicographically(catalog);
            System.out.println("\n==================== MENU PRINCIPAL ====================");
            System.out.println("Por favor, seleccione una de las opciones disponibles:");
            System.out.println("1. Ver el detalle de un producto");
            System.out.println("2. Filtrar por genero");
            System.out.println("3. Filtrar por precio maximo");
            System.out.println("4. Salir");
            System.out.println("\n--- CATALOGO COMPLETO ---");
            System.out.print(showProducts(ordered));

            int option = readInt(1, 4, sc);
            switch (option) {
                case 1:
                    selectAndShowDetail(ordered, sc);
                    break;
                case 2:
                    showGenreFilteredMenu(catalog, sc);
                    break;
                case 3:
                    showPriceFilteredMenu(catalog, sc);
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * Shows the genre filter screen: lists every genre, reads the chosen one
     * and shows the matching products. Returns when the user goes back.
     *
     * @param catalog the list with all the products
     * @param sc      the scanner used to read the user input
     */
    private static void showGenreFilteredMenu(List<Product> catalog, Scanner sc) {
        List<Genre> genres = new ArrayList<>();
        genres.addAll(Arrays.asList(MovieGenre.values()));
        genres.addAll(Arrays.asList(MusicGenre.values()));
        System.out.println("\n===== FILTRAR POR GENERO =====");
        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i + 1) + ". " + genres.get(i));
        }
        int back = genres.size() + 1;
        System.out.println(back + ". Volver al menu principal");
        System.out.print("Elige un genero (1-" + back + "): ");
        int option = readInt(1, back, sc);
        if (option == back) {
            return;
        }
        List<Product> result = filterByGenre(genres.get(option - 1), catalog);
        showFilteredResults(orderLexicographically(result), sc);
    }

    /**
     * 
     */
    private static void showPriceFilteredMenu(List<Product> catalog, Scanner sc) {
        
    }

    /**
     * Shows the result of a filter and lets the user see the detail of one
     * product or go back. Both filter screens share this flow.
     *
     * @param products the filtered products, already ordered
     * @param sc       the scanner used to read the user input
     */
    private static void showFilteredResults(List<Product> products, Scanner sc) {
        if (products.isEmpty()) {
            System.out.println("\nNo hay productos que cumplan ese filtro.");
            return;
        }
        while (true) {
            System.out.println("\n1. Ver el detalle de un producto");
            System.out.println("2. Volver al menu principal");
            System.out.println("\n--- Resultado del filtro ---");
            System.out.print(showProducts(products));
            System.out.print("Elige una opcion: ");
            int option = readInt(1, 2, sc);
            if (option == 2) {
                return;
            }
            selectAndShowDetail(products, sc);
        }
    }

    /**
     * 
     */
    private static List<Product> filterByGenre(Genre genre, List<Product> products) {

    }

    /**
     * 
     */
    private static List<Product> filterByMaxPrice(double maxPrice, List<Product> products) {
       
    }

    /**
     * Builds the numbered list of products used by every menu: 
     * number, name and price of each product.
     *
     * @param products the products to list
     * @return the text of the numbered list, one product per entry
     */
    private static String showProducts(List<Product> products) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            text.append(i + 1).append(". ").append(products.get(i)).append("\n");
        }
        return text.toString();
    }

    /**
     * Asks the user for the number of a product in the list and prints its
     * complete detail.
     *
     * @param products the numbered list the user is looking at
     * @param sc       the scanner used to read the user input
     */
    private static void selectAndShowDetail(List<Product> products, Scanner sc) {
        System.out.print("Escribe el numero del producto (1-" + products.size() + "): ");
        int index = readInt(1, products.size(), sc);
        System.out.println("\n--- Detalle ---");
        System.out.println(products.get(index - 1).detail());
    }

    /**
     * 
     */
    private static List<Product> orderLexicographically(List<Product> products) {
        // me dio hueva hacerlo jeje
    }

    /**
     * Reads an integer from the input, asking again until it is a
     * number inside the given range.
     *
     * @param min the smallest accepted value
     * @param max the largest accepted value
     * @param sc  the scanner used to read the user input
     * @return the valid integer typed by the user
     */
    private static int readInt(int min, int max, Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                //If an exception occurs, it is caught and the program continues without doing anything else
            }
            System.out.print("Opcion invalida. Escribe un numero entre " + min + " y " + max + ": ");
        }
    }

    /**
     * 
     */
    private static double readDouble(Scanner sc) {

    }
}
