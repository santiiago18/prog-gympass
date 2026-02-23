public class Sala {

    private final int codigoSala;
    private final String descripcion;

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
        return "Sala: " + this.codigoSala + ", Descripción: " + this.descripcion;
    }
}
