public class Sala {

    private final int codigoSala;
    private final String descripcion;


    /**
     * Constructor de la clase Sala.
     * Crea una nueva instancia de una sala con un código identificador
     * @param codigoSala Codigo que identidfica el codigo de la sala
     * @param descripcion La descripcion que tiene la sala.
     */
    public Sala(int codigoSala, String descripcion) {
        this.codigoSala = codigoSala;
        this.descripcion = descripcion;
    }

    public int getCodigoSala() {
        return this.codigoSala;
    }


    public String getDescripcion() {
        return this.descripcion;
    }


    @Override
    public String toString() {
        return "{ Código Sala: " + this.codigoSala + ", Descripción: " + this.descripcion + " }";
    }
}
