import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

/*
    Test-No: 34 (new)
    Test ID: TC-EP-TITLE1
    Test Feature: Course Title
    Test Description: Course title with only letters and spaces is accepted
    Test Technique: Equivalence Partitioning
    Tester: Egemen Üner
*/
public class TC_EP_TITLE1 {

    private DiscUdemyTestBot bot;
    private static final String URL = "https://www.discudemy.com/";

    // E
    private static final List<String> expectedTitles = Arrays.asList(
            // Expected Inputs  – Valid course titles: only letters, spaces, numbers, basic punctuation
            "Java Programming for Beginners",
            "Learn Python 3.10 from Scratch",
            "HTML & CSS Basics",
            "C# Fundamentals – .NET Core",
            "Machine Learning Bootcamp"
    );

    // U
    private static final List<String> unexpectedTitles = Arrays.asList(
            // Unexpected Inputs – Invalid characters (should not be accepted)
            "Java! Programming",       // Contains '!'
            "C++ #1 Guide",            // Contains '+', '#'
            "@Python for Data*",       // Contains '@', '*'
            "SQL & Databases$",        // Contains '$'
            "🚀 Fullstack Dev Course"  // Contains emoji
    );

    @BeforeEach
    void setup() {
        bot = new DiscUdemyTestBot(URL);
    }

    @Test
    @DisplayName("TC-EP-TITLE1 - Course title with only letters and spaces is accepted")
    void testOnlyLettersAndSpacesAreAccepted() {
        String keyword = "java";

        bot.search(keyword);
        bot.storeData();
        List<String> resultTitles = bot.getCourseTitles();

        //Expected class check: all valid characters
        boolean allExpectedValid = resultTitles.stream().allMatch(title ->
                title.matches("[a-zA-Z0-9\\s:\\-.,()'’]+")
        );

        //Fail if any course title contains forbidden characters
        assertTrue(allExpectedValid,
                "Unexpected character(s) found in course titles.\nTitles:\n" + resultTitles);

        bot.quit();
    }
}
