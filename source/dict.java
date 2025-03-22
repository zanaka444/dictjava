package dictjava.source;

import java.util.Arrays;
import java.util.Objects;

public class dict{

    private Node[] diccionario;
    private static int size = 10;
    private int contador = 0;

    public dict(){
        this.diccionario = new Node[size];
    }

    public void add(Object key, Object value, int posicion){
        if(contador >= (diccionario.length * 0.8)){
            agrandar();
        }

        if(diccionario[posicion] != null){
            diccionario[posicion] = new Node(key, value);
            contador++;
        }else{
            //hacer lo de las colisiones
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
        return null ;
    }

    public boolean contains(Object key){
        return obtener(key) != null;
    }

    public void agrandar(){
        diccionario = new Node[size * 2];
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

    /**

     public int hash1(int key){
     return Math.abs(key.hashCode()) % diccionario.length;
     }

     public int hash2(){
     return 1;
     }

     */

    //H(x) = (x mod LTabla)

    //Utilizar esto para sacar la pseudoclave, para luego utilizarla como la x en la siguiente formula -> //H(x) = (x mod LTabla)
    // y asi saber la posicion en cual insertar el elemento
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(diccionario), contador);
    }
}
