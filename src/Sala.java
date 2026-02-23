public class Sala {

    private int codigoSala;
    private String descripcion;

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

    public String toString() {
        return "Sala: " + this.codigoSala + ", Descripcion: " + this.descripcion;
    }
}
