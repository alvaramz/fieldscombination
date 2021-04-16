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
    
    public String descomprimirArchivoZip(String rutaArchivoZip, String rutaSalida)throws FileNotFoundException, IOException{
        String nombreCarpetaCreada = null;
        File archivoZip = new File(rutaArchivoZip);        
        File directorioSalida = new File(rutaSalida);        
        
        if(!archivoZip.exists() || !archivoZip.canRead()){            
             throw new FileNotFoundException("El archivo ZIP especificado no existe o no puede ser leído.");
        }
        
        if(!directorioSalida.exists() || !directorioSalida.canWrite()){            
             throw new FileNotFoundException("La ruta de salida no existe o no puede escribirse.");
        }
        
        ZipEntry entrada;
        ZipInputStream streamEntrada = new ZipInputStream(new FileInputStream(archivoZip));
        
        // Antes de continuar crea el directorio contenedor
        File directorioDescomprimido = new File(directorioSalida.getAbsolutePath() + File.separator + archivoZip.getName().replaceAll("\\.","_"));
        
        // Lee cada entrada del zip para escribirla descomprimida.
        entrada = streamEntrada.getNextEntry();
        while(entrada != null){

            if(entrada.isDirectory()){
                 File salida = new File(directorioDescomprimido.getAbsolutePath() + File.separator + entrada.getName());
                 salida.createNewFile();
            }

            // Continúa la lectura de archivos.
            entrada = streamEntrada.getNextEntry();
        }

        streamEntrada.close();
        nombreCarpetaCreada = directorioSalida.getAbsolutePath();
        
        return nombreCarpetaCreada;
    } 
    
}
