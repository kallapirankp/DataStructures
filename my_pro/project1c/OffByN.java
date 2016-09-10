public class OffByN implements CharacterComparator{
    //Instance Variable
    public int N;

    public OffByN(int N){
        this.N = N;

    }

    @Override
    public boolean equalChars(char x, char y){
        if(x - y == N || x - y == -N){
            return true;
        }
        else{
            return false;
        }

    }
}