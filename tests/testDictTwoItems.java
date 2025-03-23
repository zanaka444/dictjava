package dictjava.tests;

import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;
import dictjava.source.dict;

public class testDictTwoItems {

    private dict dict;

    @Before
    public void init() {
        dict = new dict();
        dict.add();
        dict.add();
    }

    /**
     * test de len con un diccionario de 2 elementos
     */
    @Test
    public void testLen() {
        int dictLen = dict.len();
        assertEquals("El tamaño debe de ser 2 después de inicializar",2,dictLen);
    }

    /**
     * test de añadir un elemento al diccionario con 2 elementos
     */
    @Test
    public void testAdd1() {
        dict.add();
        int dictLen = dict.len();
        assertEquals("El tamaño debe de ser 3",3,dictLen);
    }

    /**
     * test eliminar un elemento del diccionario
     */
    @Test
    public void testRemove() {
        dict.remove();
        int dictLen = dict.len();
        assertEquals("El tamaño debe de ser 1 al eliminar",1,dictLen);
    }

    /**
     * Test del método all().
     * Se espera que retorne true si todos los valores son "truthy".
     * Inicialmente, con 10 y 20 se consideran truthy.
     * Luego, insertamos un elemento con valor 0 (falsy) y comprobamos que all() retorne false.
     */
    @Test
    public void testAll() {
        // Primero, comprobamos que todos los valores sean truthy
        assertTrue("all() debería retornar true con valores truthy", dict.all());

        // Insertamos un elemento con valor 0 (falsy) para que all() falle
        dict.insertar("claveFalso", 0, 0);
        assertFalse("all() debería retornar false si hay al menos un valor falsy", dict.all());
    }

    /**
     * Test del método contains().
     */
    @Test
    public void testContains() {
        // Comprobamos que las claves insertadas se encuentren en el diccionario
        assertTrue("El diccionario debería contener 'clave1'", dict.contains("clave1"));
        assertTrue("El diccionario debería contener 'clave2'", dict.contains("clave2"));
        // Y que una clave no insertada retorne false
        assertFalse("El diccionario no debería contener 'claveInexistente'", dict.contains("claveInexistente"));
    }

    /**
     * Test del método keys().
     */
    @Test
    public void testKeys() {
        Object[] keys = dict.keys();
        int count = 0;
        // Contamos las claves no nulas
        for (Object key : keys) {
            if (key != null) {
                count++;
            }
        }
        assertEquals("El número de claves no coincide con los elementos insertados", 2, count);
    }

    /**
     * Test del método values().
     */
    @Test
    public void testValues() {
        Object[] values = dict.values();
        int count = 0;
        // Contamos los valores no nulos
        for (Object value : values) {
            if (value != null) {
                count++;
            }
        }
        assertEquals("El número de valores no coincide con los elementos insertados", 2, count);
    }
}
