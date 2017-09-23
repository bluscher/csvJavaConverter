/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructura;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Bernardo Luscher <b_luscher at hotmail.com>
 */
public abstract class ArchivoAbs {
    protected  Vector<Frame> frames;
    protected  CSVReader reader;
    protected  String nombre;



public ArchivoAbs(String path) throws FileNotFoundException {
        this.frames = new Vector<>();        
        this.reader  = new CSVReader(new FileReader(path));
        nombre = path;
    }
    
public ArchivoAbs(){
    this.frames = new Vector<>();
    File directorio = new File("./ItalianGestures");
    directorio.mkdir();
}

  
  public abstract void escribirTxt()throws IOException;
  public abstract void select(String g1, int inicio, int fin) throws IOException;
  public abstract void open(String rutaCarpeta) throws IOException;
  
  
  //recupera la estructura del Frame del .csv y lo guarda en el registro
  public void leerCsv() throws IOException{
    /*----------ejemplo de la libreria
    String [] nextLine;
    while ((nextLine = reader.readNext()) != null) {
    // nextLine[] is an array of values from the line
    System.out.println(nextLine[0] + nextLine[1] + "etc...");
    }*/
        
    String [] nextLine;
    while ((nextLine = reader.readNext()) != null) {
        Frame linea = new Frame();
        //Agrego el nuevo frame compatible con EASYGR
        frames.add(linea.extraerPCValida(nextLine));
        }
    }
  
  public int cantFrames(){
        return frames.size();
    }
  
   
    public Vector getVectorFrame(){
        return this.frames;
    }
    
    public String getNombre(){ return nombre.substring(0, nombre.lastIndexOf('.'));}
    
    public void setNombre(String n){ this.nombre = n;}
    
    public void setReader(String path) throws FileNotFoundException{
        this.reader  = new CSVReader(new FileReader(path));
    }
    
    public CSVReader getReader(){ return this.reader;}
    public Vector getFrames(){ return this.frames;}
    
    //metodo para prueba
//    public Frame getPrimerElem(){
//        return this.frames.firstElement();
//    }
//    public void imprimirFrameCSV1(){
//        Frame prueba = frames.get(0);
//        prueba.imprimirTodo();
//    }
//    
//    public void imprimirFrameTXT1(){
//        Frame prueba = frames.get(0);
//        System.out.println(prueba.imprmirFrame());
//    } 
}
