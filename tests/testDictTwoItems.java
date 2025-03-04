package dictjava.tests;

import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;
import source.dict;

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
}
