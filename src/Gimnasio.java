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

    /**
     * Elimina a un socio del gimnasio basándose en su número de socio.
     * Si el socio existe, se retira del listado dejando su posición libre
     * @param numero Es el número de identificador del socio
     * @return Se elimina el socio si se encuentra. Si es null es porque no se encontro
     */

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

    /**
     * Verifica si un socio existe en el listado mediante su número identificador
     * @param numero El número de socio que se desea buscar
     * @return True cuando el socio existe. False si no existe
     */

    public boolean existeSocio (int numero){
        boolean continuarBuscando = true;
        boolean posicionSocio = false;

        for(int i = 0; i < MAX_SOCIOS && continuarBuscando; i++){
            if (listaSocios [i].getNumeroSocio() == numero){
                continuarBuscando = false;
            }
        }
        return posicionSocio;
    }

    /**
     * SI el numero de socio existe en el gimnasio se puede designar como el responsable
     * @param numeroSocio
     * @return True si se designo el admin. False si no se designo el admin
     */
    boolean designarResponsable(int numeroSocio){
        boolean resultado = false;
        if(existeSocio(numeroSocio)){
            responsableId = numeroSocio;
            resultado = true;
        }
        return resultado;
    }

    /**
     * Registra una nueva sala en el gimnasio.
     * Verifica que no exista otra sala con el mismo código y que haya espacio.
     * @param sala Sala a incorporar
     * @return True si se pudo registrar. False si ya existe o esta lleno
     */
    public boolean incorporarSala(Sala sala){
        boolean resultado = false;
        int posicionSala;

        posicionSala = buscarPrimerHuecoLibreSala();

        if (!contieneSala(sala.getCodigoSala()) && posicionSala != -1 ){
            listasSalas[posicionSala] = sala;
            resultado = true;
        }
        return resultado;
    }


    /**
     * Busca la primera posición disponible null en el inventario de salas
     * @return Muestra el primer hueco libre o -1 si no hay espacio
     */
    private int buscarPrimerHuecoLibreSala() {
        int primeraPosicionSalaLibre = -1;
        boolean continuarBuscando = true;
        for (int i = 0; i < MAX_SALAS && continuarBuscando; i++){
            if (listasSalas[i] == null){
                primeraPosicionSalaLibre = i;
                continuarBuscando = false;
            }
        }
        return primeraPosicionSalaLibre;
    }

    /**
     * Verifica si una sala ya existe en el gimnasio mediante su código identificador
     * @param numero El código numérico de la sala a buscar
     * @return true si la sala ya está registrada. False si no esta registrada
     */

    public boolean contieneSala(int numero ) {
        boolean resultado = false;

        for (int i = 0; i < MAX_SALAS && !resultado; i++) {
            if( listasSalas[i] != null && listasSalas[i].getCodigoSala() == numero ){
                resultado = true;
            }
        }
        return resultado;
    }

}
