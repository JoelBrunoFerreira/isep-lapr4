package antlr.domain;

public class Pair {
    String text;
    Integer value;
    public Pair(String text, Integer value) {
        this.text = text;
        this.value = value;
    }
    @Override
    public String toString(){
        return text+ " "+value+"%";
    }
}
