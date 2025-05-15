package Session2.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> idNameMap = new HashMap<Integer, String>();
        idNameMap.put(123, "Christian");
        idNameMap.put(1234, "Sabine");
        System.out.println(idNameMap.get(1234));
        //Sabine
        System.out.println(idNameMap.size());
        //2
        idNameMap.remove(1234);
        System.out.println(idNameMap.containsKey(123));
        //true
        System.out.println(idNameMap.containsValue("Christian"));
        //true
        System.out.println(idNameMap.keySet());
        //[123]
        System.out.println(idNameMap.entrySet());
        //[123=Christian]
        System.out.println(idNameMap.values());
        //[Christian]
    }
}
