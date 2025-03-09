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
        //añadir elemento
        dict.add(0, 1);
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
        dict.add();
        int dictlen = dict.len();
        assertEquals("El tamaño debe ser 2", 2, dictLen);
    }

    /**
     * Prueba de conseguir el valor dada una clave en un diccionario de un elemento
     */
    @Test
    public void testGet(){
        int valor = dict.get(0);
        assertEquals("El valor debe ser 1", 1, valor);
    }

    /**
     * Prueba de eliminar un valor a un diccionario de un elemento
     */
    @Test
    public void testRemove(){
        dict.remove();
        int dictlen = dict.len();
        assertEquals("El tamaño debe ser 0", 0, dictLen);
    }

    
}
