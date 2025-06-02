import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        TODO:
            -> Maybe forbidden Char control in course title
            -> Maybe some constraint for valid course title length
         */

        /*
        Udemy Archive Website
        TODO:
            -can make category tests
            -can make forbidden char (title) test
            -BVA for course title
            -EQ for course title
            -Search decision table
     */
        int courseCounter = 1;
        String keyword = "python";

        DiscUdemyTestBot bot = new DiscUdemyTestBot("https://www.udemy.com");
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
