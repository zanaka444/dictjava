package dictjava.tests;

import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;

import java.beans.Transient;

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
        dict.add("0", 1);
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
        dict.remove("0");
    }

    /**
     * Prueba de metodo contains con un diccionario vacío
     */
    @Test
    public void testContains(){
        boolean contains = dict.contains("0");
        assertFalse("El diccionario no contiene la clave", contains);
    }

    /**
     * Prueba de obtener las claves de un diccionario vacío
     */
    @Test
    public void testKeys(){
        Object[] keys = dict.keys();
        assertEquals("El array de claves debe ser de tamaño 0", 0, keys.length);
    }

    /**
     * Prueba de obtener los valores de un diccionario vacío
     */
    @Test
    public void testValues(){
        Object[] values = dict.values();
        assertEquals("El array de valores debe ser de tamaño 0", 0, values.length);
    } 

    /**
     * Prueba del metodo all en un diccionario vacío
     */
    @Test 
    public void testAll(){
        boolean all = dict.all();
        assertTrue("El diccionario no contiene elementos", all);
    }
}
