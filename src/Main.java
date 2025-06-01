import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        TODO:
            -> Maybe forbidden Char control in course title
            -> Maybe some constraint for valid course title length
         */

        int courseCounter = 1;
        String keyword = "python";

        DiscUdemyTestBot bot = new DiscUdemyTestBot("https://www.discudemy.com/search");
        bot.searchByKeyword(keyword);

        ArrayList<String> _courseTitles = bot.getCourseTitles();

        for(String st: _courseTitles){

            System.out.println("------------------------------");
            System.out.println("Course No: " + courseCounter);
            System.out.println("Course Contains Keyword: " + st.toLowerCase().contains(keyword.toLowerCase()));

            courseCounter++;
        }
        System.out.println("------------------------------");
    }
}
