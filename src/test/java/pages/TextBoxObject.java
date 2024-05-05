package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxObject {

    public static SelenideElement userName = $("#userName");
    public static SelenideElement userEmailInput = $("#userEmail");
    public static SelenideElement addressInput = $("#currentAddress");
    public static SelenideElement permanentAddressInput = $("#permanentAddress");
    public static SelenideElement submitButton = $("#submit");
    public static SelenideElement outputName = $("#output #name");
    public static SelenideElement outputEmail = $("#output #email");
    public static SelenideElement outputAddress = $("#output #currentAddress");
    public static SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxObject openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxObject setUserNameInput(String value){
        userName.setValue(value);
        return this;
    }

    public TextBoxObject setUserEmailInput(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxObject setAddressInput(String value) {
        addressInput.setValue(value);
        return this;
    }

    public TextBoxObject setPermanentAddressInput(String value){
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxObject submitButtonClick() {
        submitButton.click();
        return this;
    }
    public TextBoxObject outputNameCheck(String value) {
        outputName.shouldHave(text(value));
        return this;
    }

    public TextBoxObject outputEmailCheck(String value) {
        outputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxObject outputAddressCheck(String value) {
        outputAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxObject outputPermanentAddressCheck(String value) {
        outputPermanentAddress.shouldHave(text(value));
        return this;
    }
}
