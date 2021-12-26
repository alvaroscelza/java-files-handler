/*
 * To change this license header, choose License Headers in Project
 * Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MetodosArchivo;

import java.io.*;

/**
 *
 * @author Loaderon - Alvaro SC
 */
public class SerializacionArchivo {
    
    
    /**
     * guardamos todo el sistema en un archivo de texto llamado 
     * "nombreArchivo.txt"
     * @param objetoAGuardar: El objeto a guardar (cualquier objeto que 
     * se quiera serializar)
     * @param nombreArchivo: El nombre que queremos ponerle al archivo que
     * se guardará con los datos del sistema
     * @throws java.io.IOException
     * 
     */
    public static void guardarArchivo(Object objetoAGuardar,
            String nombreArchivo) throws IOException {
        //creo el archivo
        FileOutputStream file = new FileOutputStream(nombreArchivo);
        //creo el filtro de guardado y le paso el archivo creado
        BufferedOutputStream buffer = new BufferedOutputStream(file);
        //creo el serializador y le paso el archivo  filtrado
        try (ObjectOutputStream out = new ObjectOutputStream(buffer)) {
            //comienzo a guardar el objeto deseado
            out.writeObject(objetoAGuardar);
            //liberamos al buffer
            out.flush();
        }
    }
    
    /**
     * Carga un archivo guardado con los datos de un cierto sistema u 
     * objeto creado y serializado por java, lo
     * interpreta y carga en un objeto utilizable por nuestro programa.
     * @param nombreArchivo: el nombre del archivo que se cargará y 
     * deserializará
     * @return El objeto deserializado y listo para utilizarse
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static Object cargarArchivo(String nombreArchivo) throws
            IOException, ClassNotFoundException {
        //leo el archivo
        FileInputStream file = new FileInputStream(nombreArchivo);
        //creo el filtro de lectura y le paso el archivo leído
        BufferedInputStream buffer = new BufferedInputStream(file);
        //creo el deserializador y le paso el archivo filtrado
        ObjectInputStream in = new ObjectInputStream(buffer);
        //obtenemos y guardamos el objeto
        Object objetoACargar = in.readObject();
        //cerramos el archivo creado
        in.close();
        //devuelvo el objeto cargado
        return objetoACargar;
    }
}
