public class Main  {
    public static void main(String[] args) {

        //Zona declarativa
        Socio socio;
        Socio socio1;
        Socio socio2;

        Sala sala;
        Sala sala1;
        Sala sala2;

        //Zona Ejecutiva

        socio1 = new Socio(1, "Santiago");
        socio2 = new Socio(2, "Daniela");

        sala1 = new Sala(1, "Sala 1");
        sala2 = new Sala(2, "Sala 2");

        System.out.println("-----Socios-----");

        System.out.println(socio1);
        System.out.println(socio2);

        System.out.println("-----Salas-----");

        System.out.println(sala1);
        System.out.println(sala2);





    }
}
