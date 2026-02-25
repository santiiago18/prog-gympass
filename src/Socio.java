public class Socio {
    private final int numeroSocio;
    private final String nombre;


    /**
     * Constructor de la clase socio
     * Crea una nueva instancia de un nuevo socio con un número de identificador
     * @param numeroSocio EL numero con el que se identificación el socio
     * @param nombre El nombre del socio
     */
    public Socio(int numeroSocio, String nombre) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
    }


    public int getNumeroSocio() {
        return this.numeroSocio;
    }
    public String getNombre() {
        return this.nombre;
    }


    @Override
    public String toString() {
        return "{ Numero Socio: "  + this.numeroSocio + ", Nombre: " + this.nombre + "}";
    }


}
