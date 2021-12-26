package MetodosArchivo;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Loaderon
 */
public class ArchivoGrabacion {
    private BufferedWriter out;
    private boolean sePudoCrear;

    public boolean getSePudoCrear() {
        return sePudoCrear;
    }
    
    public ArchivoGrabacion(String nombre){
        try{
            out = new BufferedWriter (new FileWriter(nombre));
            sePudoCrear = true;
        }
        catch (FileNotFoundException er){
            JOptionPane.showMessageDialog(null, "No existe la ruta"
                    + " especificada o no tiene permisos para acceder a"
                    + " ella.", "Error al grabar!", 0);
        }
        catch(IOException e){
            System.out.println("No se puede crear el archivo, "
                    + "tipo de error:" + e);
        }
    }
    
    public boolean grabarLinea(String linea){
        boolean ok = true;
        try{
            out.write(linea);
            out.newLine();
        }
        catch(IOException e){
            ok = false;
        }
        return ok;
    }
    
    public boolean cerrar(){
        boolean ok = true;
        try{
            out.flush();
            out.close();
        }
        catch(IOException e){
            ok = false;
        }
        return ok;
    }
}
