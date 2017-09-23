package Estructura;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;



public class Archivo extends ArchivoAbs{
    
    public Archivo(String path) throws FileNotFoundException {
        super(path);
    }

    public Archivo() {
        super();
    }

    
    
    @Override
    public void escribirTxt() throws IOException{
        String sArchivo = super.getNombre()+ ".txt"; 
        File archivo = new File(sArchivo);
        if(!archivo.exists()){
              archivo.createNewFile();
              System.out.println("Archivo '" + archivo.getName() + "', HA SIDO CREADO");           
        }
       
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for(Enumeration e = frames.elements();e.hasMoreElements();){
                Frame fAux = (Frame)e.nextElement();
                //graba en el archivo el frame que se imprime por metodo
                bw.write(fAux.imprmirFrame());
            } //end for
        bw.close();
        }
    }
    
    

    
    @Override
    public void select(String g1, int inicio, int fin) throws IOException{
        String sArchivo = "./ItalianGestures/" + g1 + ".txt";
        File archivo = new File(sArchivo);
        if(!archivo.exists()){
         
              archivo.createNewFile();
              System.out.println("Archivo de Gesto'" + archivo.getName() + "', HA SIDO CREADO");           
        }
       
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for(int i = inicio; i<= fin; i++){
                Frame fAux = frames.get(i);
                //graba en el archivo el frame que se imprime por metodo
                bw.write(fAux.imprmirFrame());
            } //end for
        bw.close();
        }   
    } 
    
    @Override
    public void open(String rutaCarpeta) throws IOException{
    
     File folder = new File(rutaCarpeta);
     File[] listOfFiles = folder.listFiles(); 
     String files;
     for (int i = 0; i < listOfFiles.length; i++){
        if (listOfFiles[i].isFile()){
           // String ruta = listOfFiles[i].getCanonicalPath();
            files = listOfFiles[i].getName();
            if(files.contains("skeleton")){
                super.setReader(rutaCarpeta + files);
                super.setNombre(files);
               // System.out.println(arch.getNombre());
                System.out.println("");
                super.leerCsv();
                this.escribirTxt();
                System.out.println("---TERMINADO---");
                System.out.println("procesados " + super.cantFrames() + " Frames");
            }             
        }
     }//end for
    }
}