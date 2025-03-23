package dictjava.tests;

import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;

import java.beans.Transient;

import source.dict;

public class testDictOneItem {
    private dict dict;

    @Before
    public void init() {
        dict = new dict();
        dict.add("0", 1);
    }

    /**
     * Prueba de len con un diccionario de un elemento
     */
    @Test
    public void testLen() {
        int dictLen = dict.len();
        assertEquals("El tamaño debe ser 1 después de inicializar",1,dictLen);
    }

    /**
     * Prueba de añadir un valor a un diccionario de un elemento
     */
    @Test
    public void testAdd(){
        dict.add("1", 2);
        int dictlen = dict.len();
        assertEquals("El tamaño debe ser 2", 2, dictLen);
    }

    /**
     * Prueba de conseguir el valor dada una clave en un diccionario de un elemento
     */
    @Test
    public void testGet(){
        int valor = dict.get("0");
        assertEquals("El valor debe ser 1", 1, valor);
    }

    /**
     * Prueba de eliminar un valor a un diccionario de un elemento
     */
    @Test
    public void testRemove(){
        dict.remove("0");
        int dictlen = dict.len();
        assertEquals("El tamaño debe ser 0", 0, dictLen);
    }

    /**
     * Prueba de metodo contains con un diccionario de un elemento
     */
    @Test
    public void testContains(){
        boolean contains = dict.contains("0");
        assertTrue("El diccionario contiene la clave", contains);
    }

    /**
     * Prueba de obtener las claves de un diccionario de un elemento
     */
    @Test
    public void testKeys(){
        Object[] keys = dict.keys();
        assertEquals("El array de claves debe ser de tamaño 1", 1, keys.length);
    }

    /**
     * Prueba de obtener los valores de un diccionario de un elemento
     */
    @Test
    public void testValues(){
        Object[] values = dict.values();
        assertEquals("El array de valores debe ser de tamaño 1", 1, values.length);
    } 

    /**
     * Prueba del metodo all en un diccionario de un elemento
     */
    @Test 
    public void testAll(){
        boolean all = dict.all();
        assertTrue("El diccionario no contiene elementos null", all);
    }

    
}
