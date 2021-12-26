package MetodosArchivo;

import java.io.*;

/**
 *
 * @author Loaderon
 */
public class ArchivoLectura {
    private String linea;
    private BufferedReader in;
    
    public ArchivoLectura (String nombre){
        try{
            in = new BufferedReader(new FileReader(nombre));
        }
        catch(FileNotFoundException e){
            System.out.println("No se encuentra el archivo");
        }
    }
    
    public boolean hayMasLineas(){
        boolean hayMas = false;
        try{
            linea = in.readLine();
        }
        catch(IOException e){
            System.out.println("Error al leer línea");
        }
        if(linea != null){
            hayMas = true;
        }
        return hayMas;
    }
    
    public String linea(){
        return this.linea;
    }
    
    public void cerrar(){
        try{
            in.close();
        }
        catch(IOException e){
            System.out.println("Error al cerrar");
        }
    }
}
