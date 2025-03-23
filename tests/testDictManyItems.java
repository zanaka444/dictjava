package dictjava.tests;


import dictjava.source.dict;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.Random;

import static org.junit.Assert.*;


public class testDictManyItems {

    private dict dict;
    private Integer[] data;

    @Before
    public void init() {
        dict = new dict() {
        };
        data = new Integer[10];

         Random randomNumber = new Random();

         for (int i = 0; i < data.length; i++) {
             data[i] = randomNumber.nextInt(100);
         }

         for (int i = 0; i < data.length; i++) {
             int pos = dict.hashCode();
             dict.insertar("clave1", data[i], pos);
         }
    }


    /**
     * test de len con un diccionario con varios elementos
     */
    @Test
    void testLen() {
        int dataLen = data.length;
        int dictLen = dict.len();
        assertEquals(dataLen, dictLen, "El tamaño del diccionario es incorrecto");
    }

    /**
     * test de añadir un elemento al diccionario con varios elementos
     */

    @Test
    void testAdd() {
        dict.insertar("clave2", 500, pos);
        int dataLen = data.length;
        int dictLen = dict.len();
        assertEquals("Tamaño incorrecto", dataLen + 1, dictLen);
    }
    /**
     * test de añadir otro elemento al diccionario con varios elementos
     */

    @Test
    void testAdd2() {
        dict.insertar("clave3", 600, pos);
        int dataLen = data.length;
        int dictLen = dict.len();
        assertEquals("Tamaño incorrecto", dataLen, dictLen);
    }

    /**
     *  Test eliminar un elemento del diccionario
     */

    @Test
    void testDelete() {
        dict.eliminar("clave1");
        int dataLen = data.length;
        int dictLen = dict.len();
        assertEquals("Tamaño incorrecto", dataLen - 1, dictLen);
    }

    /**
     * Test del método all().
     * Se espera que retorne true si todos los valores son "truthy" (no 0, no false, no null).
     * Dado que los números distintos de 0 se consideran truthy, se comprueba según los datos insertados.
     */
    @Test
    public void testAll() {
        boolean allResult = dict.all();

        // Verificamos si entre los datos existe algún 0, ya que 0 se considera falsy
        boolean tieneCero = false;
        for (Integer num : data) {
            if (num == 0) {
                tieneCero = true;
                break;
            }
        }
        if (tieneCero) {
            assertFalse("all() debería retornar false si existe un 0", allResult);
        } else {
            assertTrue("all() debería retornar true si todos los valores son truthy", allResult);
        }
    }

    /**
     * Test del método contains().
     */
    @Test
    public void testContains() {
        // Verificamos que las claves insertadas existan
        assertTrue("El diccionario debería contener 'clave0'", dict.contains("clave0"));
        assertTrue("El diccionario debería contener 'clave5'", dict.contains("clave5"));
        // Y que una clave que no se insertó retorne false
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
        assertEquals("El número de claves no coincide con los elementos insertados", data.length, count);
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
        assertEquals("El número de valores no coincide con los elementos insertados", data.length, count);
    }
}
