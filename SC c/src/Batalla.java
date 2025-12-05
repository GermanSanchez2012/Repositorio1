import java.util.Scanner;

public class Batalla {

    /* lOS Atributos de mis personajes */
    private Personaje p1;
    private Personaje p2;

    /* Mi sCANNER  pide acciones al usuario por consola */
    private Scanner sc = new Scanner(System.in);

    /* Constructor */
    public Batalla(Personaje p1, Personaje p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /* Metodo de la parte batalla*/
    public void iniciarBatalla() {

        System.out.println("Iniciando Batalla...");
        System.out.println(p1.getNombre() + " vs " + p2.getNombre());

        while (p1.getVida() > 0 && p2.getVida() > 0) {
            int accion1 = elegirAccion(p1);
            int accion2 = elegirAccion(p2);

            if (accion1 == 1 && accion2 == 2) {
                System.out.println(p2.getNombre() + " intenta defender");
                if (p2.defender()) {
                    System.out.println("Defensa exitosa, No recibe daño.");
                } else {
                    System.out.println("Defensa fallida, Pierde 1 de vida.");
                    p2.recibirDanio(1);
                }
            } else if (accion1 == 2 && accion2 == 1) {
                System.out.println(p1.getNombre() + " intenta defender");
                if (p1.defender()) {
                    System.out.println("Defensa exitosa");
                } else {
                    System.out.println("Defensa fallida, Pierde 1 de vida.");
                    p1.recibirDanio(1);
                }
            } else if (accion1 == 1 && accion2 == 1) {
                System.out.println("Ambos atacan");
                p2.recibirDanio(1);
                p1.recibirDanio(1);
            } else if (accion1 == 2 && accion2 == 2) {
                System.out.println("Ambos defendieron. No pasa nada.");
            }

            mostrarEstado();

            if (p1.getVida() <= 0 || p2.getVida() <= 0)
                break;
        }

        if (p1.getVida() <= 0 && p2.getVida() <= 0) {
            System.out.println("Empate total.");
        } else if (p1.getVida() <= 0) {
            System.out.println("GANADOR: " + p2.getNombre());
        } else {
            System.out.println("GANADOR: " + p1.getNombre());
        }
    }

    private int elegirAccion(Personaje p) {
        System.out.println("\nTurno de " + p.getNombre()); //\n salto de linea referente
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.print("Elige acción: ");
        return sc.nextInt();
    }

    private void mostrarEstado() {
        System.out.println("\nEstado Actual:"); //\n salto de linea referente
        System.out.println(p1);
        System.out.println(p2);
        //Salto de linea motivos esteticos
        System.out.println("--------------------------------");
    }
}