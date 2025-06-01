import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public  class DiscUdemySearchTest{

    static final char[] forbiddenChars = {
            '!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '/',
            ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '`',
            '{', '|', '}', '~'
    };

    static ArrayList<String> courseTitles;

    @BeforeAll
    public static void setup() {
        String URL = "https://www.discudemy.com/search";
        DiscUdemyTestBot bot = new DiscUdemyTestBot(URL);
        bot.searchByKeyword("python");
        courseTitles = bot.getCourseTitles();
    }

    static Stream<Arguments> titleProvider() {
        return courseTitles.stream().map(Arguments::of);
    }

    static String clean(String title) {
        return title.replaceFirst("^\\d+\\.\\s*", "").trim();
    }

    @ParameterizedTest
    @MethodSource("titleProvider")
    public void testCourseTitle(String rawTitle) {
        String title = clean(rawTitle);

        assertNotNull(title, "Title is null");
        assertFalse(title.isEmpty(), "Title is empty");

        assertTrue(rawTitle.toLowerCase().contains("python"), "course title does not contain key word!");
    }
}
