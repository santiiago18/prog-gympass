public class Socio {
    private final int numeroSocio;
    private final String nombre;


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
        return "Numero Socio: "  + this.numeroSocio + ", Nombre: " + this.nombre + "}";
    }


}
