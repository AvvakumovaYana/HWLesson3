package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTest extends TestBase {

    private final TextBoxPage textBoxTestObject = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxTestObject.openPage()
                .removeBanners()
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
