package edp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class dict{

    private Node[] diccionario;
    private static int size = 10;
    private int contador = 0;

    public dict(){
        this.diccionario = new Node[size];
    }

    public void add(Object key, Object value){
        if(contador >= (len() * 0.8)){
            System.out.println("La tabla esta casi llena vamos a agrandarla\n");
            agrandar();
            contador = 0;
        }

        int posicion = hash1(key);

        if(diccionario[posicion] == null){
            diccionario[posicion] = new Node(key, value);
            contador++;
            System.out.println("Pareja introducida en la posición " + posicion);
        }else{
            System.out.println("Se produce colisión en la posición " + posicion);
            int avanzar = hash2(key);
            while(true){
                posicion = (posicion + avanzar) % len();
                if(diccionario[posicion] == null){
                    diccionario[posicion] = new Node(key, value);
                    contador++;
                    System.out.println("Posición final " + posicion);
                    break;
                }
            }
        }
    }


    public void remove(Object key){
        for(int i = 0; i < size; i++){
            if(diccionario[i] != null && diccionario[i].key == key){
                diccionario[i] = null;
                contador--;
            }
        }
    }

    public Object get(Object key){
        for(int i = 0; i < size; i++){
            if(diccionario[i] != null && diccionario[i].key == key){
                return diccionario[i].value;
            }
        }
        return null;
    }

    public boolean contains(Object key){
        return get(key) != null;
    }

    public void agrandar() {
        Node[] copia = diccionario;
        size = size * 2;
        diccionario = new Node[size];

        System.out.println("Recolocando los objetos");
        for (int i = 0; i < copia.length; i++) {
            if (copia[i] != null) {
                // Usar hash1 para obtener la nueva posición en la nueva tabla
                Object key = copia[i].key;
                Object value = copia[i].value;
                add(key, value);
            }
        }
    }

    /**
     * Devuelve el tamaño del diccionario
     * referencia metodos: https://www.w3schools.com/python/python_ref_dictionary.asp
     */
    public int len(){
        return diccionario.length;
    }

    /**
     * Devuelve array de las claves del diccionario
     */
    public Object[] keys(){
        Object[] keys = new Object[size];

        for(int i = 0; i < size; i++){
            if(diccionario[i] != null){
                keys[i] = diccionario[i].key;
            }
        }
        return keys;
    }

    /**
     * Devuelve array de los valores del diccionario
     */
    public Object[] values(){
        Object[] values = new Object[size];

        for(int i = 0; i < size; i++){
            if(diccionario[i] != null){
                values[i] = diccionario[i].value;
            }
        }
        return values;
    }

    public Node[] sorted() {
        // Extraemos los elementos no nulos
        // https://www.baeldung.com/java-util-arrays
        // https://www.geeksforgeeks.org/stream-toarray-java-examples/
        Node[] validElements = Arrays.stream(diccionario)
                .filter(Objects::nonNull)
                .toArray(Node[]::new);

        // Ordenar por clave
        // https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
        // https://www.geeksforgeeks.org/comparator-interface-java/
        Arrays.sort(validElements, Comparator.comparing(n -> (Comparable) n.key));

        return validElements;
    }

    /**
     * Método que devuelve true si ningun valor es null, false o 0
     */

    // https://www.w3schools.com/python/ref_func_all.asp
    // https://www.geeksforgeeks.org/python-all-function/
    // https://realpython.com/python-dicts/
    public boolean all() {
        for (Node node: diccionario) {
            if (node != null && !isTruthy(node.value)) {
                return false; // Si encontramos un valor que no es truthy, retornamos false
            }
        }
        return true; // si todos los valores son truthy, retornamos true
    }

    private boolean isTruthy(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean) return (Boolean) value;
        if (value instanceof Number) return ((Number) value).doubleValue() != 0;
        if (value instanceof String) return !((String) value).isEmpty();
        return true;
    }


    /**
     * Método que devuelve una PseudoClave si el objeto es hasheable.
     * @param key clave que queremos comprobar si es hasheable.
     * @return un número entero positivo basado en el código hash de la clave.
     */

    private int generarPseudoClave(Object key) {
        return Math.abs(key.hashCode());
    }

    /**
     * Método que devuelve la posición en la cual vamos a introducir el elemento
     * @param key clave del elemento que queremos insertar en la tabla hash.
     * @return la posición en la cual vamos a introducir el elemento en el diccionario.
     */

    private int hash1(Object key){
        int pseudoclave = generarPseudoClave(key);
        return pseudoclave % len();
    }

    public int hash2(Object key){
        int pseudoclave = generarPseudoClave(key);
        return (pseudoclave % (len() - 1)) + 1;
    }

}
