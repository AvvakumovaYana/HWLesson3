package tests;

import org.junit.jupiter.api.Test;
import pages.TestBase;
import pages.TextBoxObject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest extends TestBase {

    TextBoxObject textBoxTestObject = new TextBoxObject();

    @Test
    void fillFormTest() {

        textBoxTestObject.openPage()
                .setUserNameInput("Alex")
                .setUserEmailInput("alex@egorov.com")
                .setAddressInput("Some street 1")
                .setPermanentAddressInput("Another street 1")
                .submitButtonClick()
                .outputNameCheck("Alex")
                .outputEmailCheck("alex@egorov.com")
                .outputAddressCheck("Some street 1")
                .outputPermanentAddressCheck("Another street 1");
    }

}
