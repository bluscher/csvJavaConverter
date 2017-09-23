
import Estructura.Archivo;
import Estructura.ArchivoAbs;
import Estructura.ArchivoLabels;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



public class principal {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {   
     
    long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
    TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
    
    String rutaCarpeta = "./sign-gestures/";
    /***************************Archivo Completo**********************************/
//    Archivo arch = new Archivo();
//    arch.open(rutaCarpeta);

    /***************************Usando Labels*************************************/
     
    ArchivoLabels archLab = new ArchivoLabels();
    archLab.open(rutaCarpeta);
  
     
     
    TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
    }
    
}
