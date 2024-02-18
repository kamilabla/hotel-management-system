import java.util.ArrayList;
import java.util.List;

public class MyMap <K, V>{
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    /**
     * Klasa przechowujaca klucze oraz ich wartosci, klucz i jego wartosc maja ten sam indeks w mapie
      * @param key
     * @param value
     */
    /**
     * Metoda pobierajaca klucz oraz jego wartosc i dodajaca je do mapy
     * @param key klucz
     * @param value wartosc
     */
    public void put(K key, V value){
        keys.add(key);
        values.add(value);
    }

    /**
     * Metoda zwracajaca wartosc pobranego klucza
      * @param key klucz
     * @return zwrocenie wartosci danego klucza
     */
    public V get(K key){
        int index = keys.indexOf(key);
        if (index != -1){
            return values.get(index);
        }
        return null;
    }

    /**
     * Metoda listujaca wszystkie klucze danej mapy
      * @return zwrocenie listy kluczy
     */
    public List<K> keys(){
        return keys;
    }

    /**
     * Metoda usuwajaca podany klucz wraz z jego wartoscia
      * @param key zwrocenie klucza
     */
    public void remove(K key){
        int index = keys.indexOf(key);
        if (index != -1){
            keys.remove(index);
            values.remove(index);
        }
    }
}
