public class Gimnasio {

    private final String codigo;
    private final String nombre;
    private Socio[] listaSocios;
    private Sala[] listasSalas;
    private int responsableId;


    public final int MAX_SOCIOS;
    public final int MAX_SALAS;

    /**
     * Constructor del Gimnasio
     * @param codigo Es el identificador del Gimnasio
     * @param nombre Es el nombre del gimnasio
     * @param cantidadMaximaSocios Es la capacidad maxima de socios
     * @param cantidadMaximaDeSalas Es la capacidad maxima de Salas
     */

    public Gimnasio(String codigo, String nombre, int cantidadMaximaSocios, int cantidadMaximaDeSalas ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.MAX_SOCIOS = cantidadMaximaSocios;
        this.MAX_SALAS = cantidadMaximaDeSalas;
        this.responsableId = -1;


        this.listaSocios = new Socio[MAX_SOCIOS];
        this.listasSalas = new Sala[MAX_SALAS];
    }

    /**
     * Registra un nuevo socio en el gimnasio
     * Verifica si el socio existe para que no este repetido y que haya un espacio libre para crear
     * un nuevo socio
     * @param s El objeto de Socio que se registra
     * @return true si el registro fue exitoso. Y false si el socio ya existe o no hay espacio
     */

    public boolean registrarSocio(Socio s) {
        boolean socioRegistrado = false;
        boolean socioExistente = false;
        int hueco = buscarPrimerHuecoLibre();

        for (int i = 0; i < listaSocios.length; i++) {
            if (listaSocios[i] != null && listaSocios[i].getNumeroSocio() == s.getNumeroSocio()) {
                socioExistente = true;
            }
            if (!socioExistente ) {
                listaSocios[hueco] = s;
                socioRegistrado = true;

            }
        }
        return socioRegistrado;
    }


    /**
     * Busca el primer hueco libre
     * @return Devuelve la primera posicion libre, y -1 si no hay espacio
     */

    public int buscarPrimerHuecoLibre(){
        int primeraPosicionLibre = -1;
        boolean continuarBuscando = true;

        for (int i = 0; i < this.listaSocios.length; i++) {
            if (listaSocios [i] == null && continuarBuscando){
                primeraPosicionLibre = i;
                continuarBuscando = false;
            }
        }
        return primeraPosicionLibre;
    }


    public Socio expulsarSocio (int numero){
        Socio miembroEliminado = null;
        boolean continuarBuscando = true;

        for(int i = 0; i < MAX_SOCIOS && continuarBuscando; i++){
            if (listaSocios [i].getNumeroSocio() == numero){
                miembroEliminado = listaSocios [i];
                listaSocios [i] = null;
                continuarBuscando = false;
            }
        }

        return miembroEliminado;
    }







}
