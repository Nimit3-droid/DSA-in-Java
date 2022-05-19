package HashMaps;
import java.util.*;

public class SortMap {
    public static <K, V extends Comparable<? super V>> HashMap<K, V> sortByValue(HashMap<K, V> unsortMap) {

        List<HashMap.Entry<K, V>> list = new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<HashMap.Entry<K, V>>() {
            public int compare(HashMap.Entry<K, V> o1, HashMap.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<K, V> result = new LinkedHashMap<>();
        for (HashMap.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }
    public static <K, V> void printMap(HashMap<K, V> map) {
        for (HashMap.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> unsortMap = new HashMap<String, Integer>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        HashMap<String, Integer> sortedMap = sortByValue(unsortMap);
        printMap(sortedMap);

    }

    // private static HashMap<String, Integer> sortByVal(HashMap<String, Integer> unsortMap) {

    //     // 1. Convert Map to List of Map
    //     List<HashMap.Entry<String, Integer>> list =
    //             new LinkedList<HashMap.Entry<String, Integer>>(unsortMap.entrySet());

    //     // 2. Sort list with Collections.sort(), provide a custom Comparator
    //     //    Try switch the o1 o2 position for a different order
    //     Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
    //         public int compare(HashMap.Entry<String, Integer> o1,
    //                            HashMap.Entry<String, Integer> o2) {
    //             return (o1.getValue()).compareTo(o2.getValue());
    //         }
    //     });

    //     // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
    //     HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
    //     for (HashMap.Entry<String, Integer> entry : list) {
    //         sortedMap.put(entry.getKey(), entry.getValue());
    //     }

    //     /*
    //     //classic iterator example
    //     for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
    //         Map.Entry<String, Integer> entry = it.next();
    //         sortedMap.put(entry.getKey(), entry.getValue());
    //     }*/


    //     return sortedMap;
    // }

}

