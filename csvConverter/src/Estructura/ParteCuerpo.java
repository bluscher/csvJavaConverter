package Estructura;

/**
 *
 * @author Bernardo Luscher <b_luscher at hotmail.com>
 */

public class ParteCuerpo {
             
    private String nombre;
    private String posX;
    private String posY;
    private String posZ;
    
    //final String joins[] = {};
    
    public ParteCuerpo(String str){
        this.nombre = str;
        this.posX = "";
        this.posY = "";
        this.posZ = "";
    }

    //constructor con argumentos
    public ParteCuerpo(String nombre, String posX, String posY, String posZ) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

   
    //Getter y Setter de las posiciones 3d
    public String getPosX() {
        return posX;
    }

    public void setPosX(String posX) {
        this.posX = posX;
    }

    public String getPosY() {
        return posY;
    }

    public void setPosY(String posY) {
        this.posY = posY;
    }

    public String getPosZ() {
        return posZ;
    }

    public void setPosZ(String posZ) {
        this.posZ = posZ;
    }

    String getNombre() {
        return this.nombre;
    }
    
    
}
