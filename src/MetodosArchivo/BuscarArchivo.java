/*
 * To change this license header, choose License Headers in Project 
 * Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosArchivo;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BuscarArchivo {

    /**
     * Permite elegir mediante el JFileChooser cualquier archivo en la pc
     * (no
     * filtra extensiones)
     *
     * @return El archivo elegido (File), null si se cancela la ventana
     * o hay un
     * error
     * @author Loaderon - Alvaro SC
     */
    public static File buscarArchivoGeneral() {
        //creamos el archivo que devolveremos
        File archivoSeleccionado = null;
        //creamos un nuevo file chooser
        JFileChooser chooser = new JFileChooser();
        //creamos el título de la ventana
        chooser.setDialogTitle("Elija el archivo deseado.");
        //indicamos que el chooser soportará una operación de programación
        //(ni se abrirá el archivo
        //ni se guardará nada
        chooser.setDialogType(JFileChooser.CUSTOM_DIALOG);
        //creamos la opcion de aceptar/cancelar/error
        int opcion = chooser.showOpenDialog(null);
        //si se acepta...
        if (opcion == JFileChooser.APPROVE_OPTION) {
            //creamos un nuevo archivo conteniendo al archivo seleccionado
            //(lo pasamos a java)
            archivoSeleccionado = chooser.getSelectedFile();

        } //si se cancela 
        else if (opcion == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Se canceló la ventana.");
        } //si hay un error
        else if (opcion == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(null, "ERROR!" + 
                    JFileChooser.ERROR_OPTION);
        }
        //devolvemos el archivo cargado en la variable
        return archivoSeleccionado;
    }

    /**
     * Permite elegir un archivo pero sólo si cumple con la extensión 
     * solicitada
     *
     * @param extensionDada tan sólo la terminación sin incluír el punto
     * @return El archivo (File) elegido con la extensión específicada,
     * null si
     * se eligió un archivo con una extensión distinta
     *
     */
    public static File buscarArchivoEspecifico(String extensionDada) {
        File archivoElegido = buscarArchivoGeneral();
        File archivoADevolver = null;
        //tomamos el nombre del archivo y nos fijamos si su extesión es jpg
        String nombreArchivo = archivoElegido.getName();
        //obtengo su extension
        int i = nombreArchivo.lastIndexOf('.');
        if (i > 0) {
            String extension = nombreArchivo.substring(i + 1);
            //comparamos
            if (extension.equals(extensionDada)) {
                archivoADevolver = archivoElegido;
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de archivo"
                        + " incorrecto, debe elegir otro!", "Error!", 0);
                buscarArchivoEspecifico(extensionDada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no tiene"
                    + " extensión!!", "Error Extraño!!", 0);
        }
        return archivoADevolver;
    }
}
