/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructura;

import com.opencsv.CSVReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Bernardo Luscher <b_luscher at hotmail.com>
 */
public class ArchivoLabels extends ArchivoAbs{
    private String pathLabels;
    private CSVReader readerLabels;
    
    public ArchivoLabels(String path, String Labels) throws FileNotFoundException, IOException {
        super(path);
        this.readerLabels  = new CSVReader(new FileReader(Labels));
        super.leerCsv();
    }

    public ArchivoLabels() {
        super();
    }

    

     //selecciono un grupo de frames dado un rango y lo escribo en un nuevo archivo act.6/4/2016
    @Override
    public void select(String id, int inicio, int fin) throws IOException{
        
        String sArchivo = "./ItalianGestures/" + super.getNombre() + id + ".txt";
        //String sArchivo = super.getNombre() + id + ".txt";
        File archivo = new File(sArchivo);
        if(!archivo.exists()){
         
              archivo.createNewFile();
              System.out.println("Archivo de Gesto'" + archivo.getName() + "', HA SIDO CREADO");           
        }
        
        System.out.println("Convirtiendo "+ archivo.getName());
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
    public void escribirTxt() throws IOException {
        String [] nextLine;
        int i=1;
        while ((nextLine = readerLabels.readNext()) != null) {
           String name = (nextLine[0]);
           int inicio = Integer.parseInt(nextLine[1]);
           int fin = Integer.parseInt(nextLine[2]);
           select(name, inicio, fin);
           i++;
        }//end while    
    }

    @Override
    public void open(String rutaCarpeta) throws IOException {
     
     
     File folder = new File(rutaCarpeta);
     File[] listOfFiles = folder.listFiles(); 
     String files = null;
     int i = 0;
     while(i < listOfFiles.length){
        if (listOfFiles[i].isFile()){
            files = listOfFiles[i].getName();
            if(files.contains("label")){
                this.readerLabels = new CSVReader(new FileReader(rutaCarpeta + files));
                this.pathLabels = files.substring(0, files.lastIndexOf('.'));
                String fileAux = listOfFiles[i+1].getName();
                if(fileAux.contains("skeleton")){
                    super.setReader(rutaCarpeta + fileAux);
                    super.setNombre(fileAux);
                }
                super.leerCsv();
                this.escribirTxt();
            }             
          }
        i++;
        }
      this.organizarGestos();
     }
    
    public void organizarGestos(){
        System.out.println("Reorganizado archivos ...");
        
        for(int i=1; i<= 20; i++){
         String id = String.valueOf(i);
         File directorio = new File("./ItalianGestures/" + "G"+id);
         System.out.println("Creando nueva caprtena" + directorio.getName());
         directorio.mkdir();
        }
        
        File folder = new File("./ItalianGestures/");
        File[] listOfFiles = folder.listFiles(); 
        File file;
        int i = 0;
        while(i < listOfFiles.length){
         if (listOfFiles[i].isFile()){
             file = (File)listOfFiles[i];
             if (file.getName().contains("skeleton1.txt")){
                 file.renameTo(new File("./ItalianGestures/G1/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G1" );
              }
             if (file.getName().contains("skeleton2.txt")){
                 file.renameTo(new File("./ItalianGestures/G2/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G2" );
              }
             if (file.getName().contains("skeleton3.txt")){
                 file.renameTo(new File("./ItalianGestures/G3/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G3" );
              }
             if (file.getName().contains("skeleton4.txt")){
                 file.renameTo(new File("./ItalianGestures/G4/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G4" );
              }
             if (file.getName().contains("skeleton5.txt")){
                 file.renameTo(new File("./ItalianGestures/G5/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G5" );
              }
             if (file.getName().contains("skeleton6.txt")){
                 file.renameTo(new File("./ItalianGestures/G6/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G6" );
              }
             if (file.getName().contains("skeleton7.txt")){
                 file.renameTo(new File("./ItalianGestures/G7/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G7" );
              }
             if (file.getName().contains("skeleton8.txt")){
                 file.renameTo(new File("./ItalianGestures/G8/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G8" );
              }
             if (file.getName().contains("skeleton9.txt")){
                 file.renameTo(new File("./ItalianGestures/G9/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G9" );
              }
             if (file.getName().contains("skeleton10.txt")){
                 file.renameTo(new File("./ItalianGestures/G10/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G10" );
              }
             if (file.getName().contains("skeleton11.txt")){
                 file.renameTo(new File("./ItalianGestures/G11/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G11" );
              }
             if (file.getName().contains("skeleton12.txt")){
                 file.renameTo(new File("./ItalianGestures/G12/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G12" );
              }
             if (file.getName().contains("skeleton13.txt")){
                 file.renameTo(new File("./ItalianGestures/G13/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G13" );
              }
             if (file.getName().contains("skeleton14.txt")){
                 file.renameTo(new File("./ItalianGestures/G14/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G14" );
              }
             if (file.getName().contains("skeleton15.txt")){
                 file.renameTo(new File("./ItalianGestures/G15/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G15" );
              }
             if (file.getName().contains("skeleton16.txt")){
                 file.renameTo(new File("./ItalianGestures/G16/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G16" );
              }
             if (file.getName().contains("skeleton17.txt")){
                 file.renameTo(new File("./ItalianGestures/G17/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G17" );
              }
             if (file.getName().contains("skeleton18.txt")){
                 file.renameTo(new File("./ItalianGestures/G18/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G18" );
              }
             if (file.getName().contains("skeleton19.txt")){
                 file.renameTo(new File("./ItalianGestures/G19/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G19" );
              }
             if (file.getName().contains("skeleton20.txt")){
                 file.renameTo(new File("./ItalianGestures/G20/",file.getName()));
                 System.out.println("moviendo archivo: " + file.getName() + " a carpeta G20" );
              }
          }
        i++;
        }//end while
        System.out.println("Finalizado...");
    }

}
