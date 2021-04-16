package xyz.facturacafe.fieldscombination.compresion;

import java.util.zip.ZipEntry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import xyz.facturacafe.fieldscombination.Editor;

/**
 * Clase para pruebas de la clase Compresor.
 * @author Ing. Adrián Alvarado Ramírez.
 */
public class CompresorTest {
    
    public CompresorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Prueba el método obtenerEntradaArchivo.
     * @throws java.lang.Exception
     */
    @Test
    public void testObtenerEntradaArchivo() throws Exception {
        System.out.println("Probando obtenerEntradaArchivo");
        String rutaArchivoZip = "O:\\archivos\\fc-ejemplo.docx";
        String rutaEntrada = Editor.RECURSO_PRICIPAL_WORD;
        
        //Method metodo = Compresor.class.getDeclaredMethod("obtenerEntradaArchivo", String.class, String.class);
        //metodo.setAccessible(true);
        
        Compresor instance = new Compresor();        
        //ZipEntry result = (ZipEntry)metodo.invoke(instance, rutaArchivoZip, rutaEntrada);
        ZipEntry result = instance.obtenerEntradaArchivo(rutaArchivoZip, rutaEntrada);
                       
        assertNotNull(result);        
    }
    
}
