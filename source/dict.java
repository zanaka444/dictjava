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

    public void insertar(Object key, Object value, int posicion){
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

    public void eliminar(Object key){
        for(int i = 0; i < size; i++){
            if(diccionario[i] != null && diccionario[i].key == key){
                diccionario[i] = null;
                contador--;
            }
        }
    }

    public Object obtener(Object key){
        for(int i = 0; i < size; i++){
            if(diccionario[i] != null && diccionario[i].key == key){
                return diccionario[i].value;
            }
        }
        return null ;
    }

    public boolean contiene(Object key){
        return obtener(key) != null;
    }

    public void agrandar(){
        diccionario = new Node[size * 2];
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
