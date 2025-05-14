package Session2.Generics;

import java.util.ArrayList;

public class GenericExamples {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Christian");
        names.add("Sabine");
        int len = names.size();
        System.out.println(len);
        names.remove(0);

        Paar<String, Integer> paar = new Paar<String,Integer>("Christian", 420);
        System.out.println(paar.toString());
    }
}
