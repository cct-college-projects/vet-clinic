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

    public static String nChar(char character, int quantity){
        String line = "";
        for (int i = 0; i < quantity; i++) {
            line = line.concat(String.valueOf(character));
        }
        return line;
    };

    public static String nCharIntervals(char character, char charInterval, int[] intervals){
        String line = "";
        int nIntervals = intervals.length;
            for (int j = 0; j < nIntervals; j++) {
                for (int i = 0; i < intervals[nIntervals-1]; i++) {
                    if (intervals[j] == line.length()){
                        line = line.concat(String.valueOf(charInterval));
                        break;
                    } else {
                        line = line.concat(String.valueOf(character));
                    }
                }
            }
        return line;
    };
}
