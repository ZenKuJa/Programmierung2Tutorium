package Session2.Generics;

public class Paar<T, U> {
    private final T firstElement;
    private final U secondElement;

    public Paar(T firstElement, U secondElement){
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    @Override
    public String toString(){
        return firstElement + " and " + secondElement;
    }
}