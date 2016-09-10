/*This class finds whether the word is a Palindrome*/

public class Palindrome<Blorp> {

    public static Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> a =  new LinkedListDeque<Character>();
        for(int i = 0; i<word.length(); i++){
            a.addLast(word.charAt(i));
        }
        return a;
    }

    public static boolean isPalindrome(String word){
        if(word == null){
            return true;
        }else {
        int start = 0;
        int count = 0;
        int end = word.length()-1;
        return recursiveHelper(word, count, start, end);
       }
    }

    public static boolean recursiveHelper(String word, int count, int start, int end){
        if(count == word.length()/2){
            return true;
        }
        else if(word.charAt(start) == word.charAt(end) && count < word.length()/2){
            return recursiveHelper(word, count+1, start+1 , end-1);
        }else{
            return false;
        }
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        if(word == null){
            return true;
        }else {
       int start = 0;
        int count = 0;
        int end = word.length()-1;
        return recursiveHelper(word, count, start, end, cc);
        }
    }

    public static boolean recursiveHelper(String word, int count, int start, int end, CharacterComparator cc ){
        if(count == word.length()/2){
            return true;
        }
        else if(cc.equalChars(word.charAt(start), word.charAt(end))){
            return recursiveHelper(word, count+1, start+1 , end-1, cc);
        }else{
            return false;
        } 
    }
}