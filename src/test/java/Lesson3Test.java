import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson3Test {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 6000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Yana");
        $("#lastName").setValue("Avvakumova");
        $("#userEmail").setValue("test@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").scrollTo().setValue("7987654321");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").find("[value='1993']").click();
        $(".react-datepicker__month-select").find("[value='6']").click();
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("TestHW3.png");
        $("#currentAddress").scrollTo().setValue("Test address");
        $("#state").click();
        $("#state").find(byText("NCR")).click();
        $("#city").click();
        $("#city").find(byText("Noida")).click();
        $("#submit").click();

        $(".table-hover").shouldHave(text("Yana Avvakumova"));
        $(".table-hover").shouldHave(text("test@mail.ru"));
        $(".table-hover").shouldHave(text("Female"));
        $(".table-hover").shouldHave(text("7987654321"));
        $(".table-hover").shouldHave(text("10 July,1993"));
        $(".table-hover").shouldHave(text("Maths"));
        $(".table-hover").shouldHave(text("Reading"));
        $(".table-hover").shouldHave(text("TestHW3.png"));
        $(".table-hover").shouldHave(text("Test address"));
        $(".table-hover").shouldHave(text("NCR Noida"));
    }
}
