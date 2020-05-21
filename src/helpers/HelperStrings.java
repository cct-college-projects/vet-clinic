package helpers;

public class HelperStrings {

    public static String addTabToString(String word){
        String result = "";

        if(word.length() <= 3){
            result = word.trim() + " \t"; }
        else if(word.length() > 3 && word.length() < 8){
            result = word.trim()+"\t";
        } else {
            result = word.trim();
        }

        return result;
    }
}
