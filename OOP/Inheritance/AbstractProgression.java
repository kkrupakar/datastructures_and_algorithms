package OOP.Inheritance;

public abstract class AbstractProgression{
    protected long current;

    public AbstractProgression(){
        this(0);
    }

    public AbstractProgression(long start){
        this.current = start;
    }

    public long nextValue(){
        long answer = current;
        //Template Method Pattern
        advance();
        return answer;
    }

    protected abstract void advance();

    public void printProgression(int n){
        System.out.print(nextValue());
        for(int i = 1; i < n; i++){
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }
}