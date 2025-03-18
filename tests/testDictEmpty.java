package dictjava.tests;

import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;
import dictjava.source.dict;

public class testDictEmpty {
    private dict dict;

    @Before
    public void init() {
        dict = new dict();
    }


    /**
     * Prueba de len con un diccionario vacío
     */
    @Test
    public void testLen() {
        int dictLen = dict.len();
        assertEquals("El tamaño debe ser 0 después de inicializar",0,dictLen);
    }

    /**
     * Prueba de añadir un valor a un diccionario vacío
     */
    @Test
    public void testAdd(){
        dict.add();
        int dictlen = dict.len();
        assertEquals("El tamaño debe ser 1", 1, dictLen);
    }

    /**
     * Prueba de conseguir el valor dada una clave en un diccionario vacío
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGet(){
        int valor = dict.get();
    }
    
    /**
     * Prueba de eliminar un valor a un diccionario vacío
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemove(){
        dict.remove();
    }

    
}
