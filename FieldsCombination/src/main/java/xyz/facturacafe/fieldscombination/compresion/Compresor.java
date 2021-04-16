package xyz.facturacafe.fieldscombination.compresion;

import java.util.zip.*;
import java.io.*;

/**
 * Clase prinicipal para la compresión y descompresión de un archivo .zip.
 * @author Ing. Adrián Alvarado Ramírez
 */
public class Compresor {
     
    
    /**
     * Obtiene un ZipEntry (entrada) de un archivo dada una ruta.
     * @param rutaArchivoZip Ruta del archivo Zip.
     * @param rutaEntrada Ruta de la entrada dentro del archivo Zip.
     * @return ZipEntry especificado o null si no fue encontrado.
     * @throws java.io.FileNotFoundException
     * @throws java.util.zip.ZipException
     */
    public ZipEntry obtenerEntradaArchivo(String rutaArchivoZip, String rutaEntrada)throws FileNotFoundException, ZipException, IOException{
        File archivo = new File(rutaArchivoZip);
        ZipEntry entrada = null;
        
        if(archivo.exists() && archivo.canRead()){
            ZipFile archivoZip = new ZipFile(archivo);
            
            entrada = archivoZip.getEntry(rutaEntrada);
        }else{
            throw new FileNotFoundException("El archivo especificado no existe o no puede ser leído");
        }
        
        return entrada;
    }
    
    public void descomprimirArchivoZip(String rutaArchivoZip, String rutaSalida){
        
    } 
    
}
