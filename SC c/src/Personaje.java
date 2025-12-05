public class Personaje {

    /* Mia atributos de mi clase personaje */
    private String nombre;
    private int vida;
    private final int ataque = 1;

    /* Constructor soLo devuelve nombre*/

    public String getNombre() {return nombre;}

    /* Mis Getters y miS sETERES */
    public int getVida() {return vida;}
    public void setVida(int vida) {this.vida = vida; if (this.vida < 0) this.vida = 0; }
    public Personaje(String nombre) {this.nombre = nombre; this.vida = 10;}
    /* Duda preguntar al profe */
    public int getAtaque() {return ataque;}

    public boolean defender() {int random = (int)(Math.random() * 2); return random == 1;} // comando de alatoriedad referente
    public void recibirDanio(int cantidad) {this.vida -= cantidad; if (vida < 0) vida = 0;}

    public String toString() {return nombre + " (Vida: " + vida + ")";}
}
