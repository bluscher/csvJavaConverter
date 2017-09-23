package Estructura;


import CorrecionJoins.CorreccionIndice;
import CorrecionJoins.CorrecionAbs;
import CorrecionJoins.CorreccionPromedio;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 *
 * @author Bernardo Luscher <b_luscher at hotmail.com>
 */

//Cada linea completa del archivo corresponde a un frame
public class Frame {
    
    private final Hashtable<String,ParteCuerpo> partesCuerpo;
    
    private final String[] joinsCSV = {"Torso","Neck","Head","LeftShoulder","LeftElbow",
        "","LeftHand","RightShoulder","RightElbow","","RightHand","LeftHip","LeftKnee",
        "","LeftFoot","RightHip","RightKnee","","RightFoot"};
    
     private final String[] joinsTXT = {"Head","Neck","Torso","LeftShoulder","LeftElbow",
           "LeftHand","RightShoulder","RightElbow","RightHand","LeftHip","LeftKnee",
           "LeftFoot","RightHip","RightKnee","RightFoot"};
    
    Frame(){
        this.partesCuerpo = new Hashtable<>();
    }
    
    public void addParte(ParteCuerpo p){
        partesCuerpo.put(p.getNombre(), p);
    }
    
    public ParteCuerpo getParte(String nombre){
        return partesCuerpo.get(nombre);
    }

    public Frame extraerPCValida(String[] nextLine) {
        int y = 9;
        for (String join : joinsCSV) {
            ParteCuerpo pc = new ParteCuerpo(join);
            pc.setPosX(nextLine[y]);
            pc.setPosY(nextLine[y+1]);
            pc.setPosZ(nextLine[y+2]);
            if(!joinsCSV.equals(""))
                partesCuerpo.put(pc.getNombre(), pc);
            y += 9;
        }        

        //-Luego de extrear el Frame valido completo, se le hace la correcion de posicion-
        //hago una media aritmetica entre los siguiente joins: spine llamdo "Torso" y ShoulderCenter "Neck" para simplificar el codigo
        CorreccionPromedio mapeoTorso = new CorreccionPromedio(this.getParte("Torso"),this.getParte("Neck"));
        
      
        
        CorrecionAbs mapeoCuello = new CorreccionIndice(this.getParte("Neck"),0);
        corregir(mapeoTorso);
        corregir(mapeoCuello);
        return this;
    }
    
    public int cantPartesENHash(){
        return partesCuerpo.size();
    }
    
    /* metodo de prueba
    void imprimirTodo() {
        for(Enumeration e = partesCuerpo.elements(); e.hasMoreElements();){
            ParteCuerpo aux = (ParteCuerpo)e.nextElement();
            System.out.println(aux.getNombre()+ " "+ aux.getPosX()+" "+aux.getPosY()+" "+aux.getPosZ());
        }
    }*/

    //Construyo el frame con el orden de partes de cuerpo para el EASYGR
    String imprmirFrame() {
        String resultado = "";
        for(int i = 0; i<joinsTXT.length; i++){
          //  String cadena = "";
            ParteCuerpo aux = partesCuerpo.get(joinsTXT[i]);
            String cadena = aux.getPosX()+" "+aux.getPosY()+" "+aux.getPosZ()+" ";
            resultado = resultado + cadena;
        }
        resultado = resultado + "\n";   
//        test resultado
//        System.out.println(resultado);
        return resultado;      
    }
    
    public void corregir(CorrecionAbs c){
        c.corregir();
    }
    
}
