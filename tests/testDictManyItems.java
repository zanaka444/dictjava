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
}
