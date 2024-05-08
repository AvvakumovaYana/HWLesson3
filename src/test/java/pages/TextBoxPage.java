package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement userName = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputName = $("#output #name");
    private final SelenideElement outputEmail = $("#output #email");
    private final SelenideElement outputAddress = $("#output #currentAddress");
    private final SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        removeBanners();
        return this;
    }

    public TextBoxPage removeBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserNameInput(String value){
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmailInput(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setAddressInput(String value) {
        addressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddressInput(String value){
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submitButtonClick() {
        submitButton.click();
        return this;
    }
    public TextBoxPage outputNameCheck(String value) {
        outputName.shouldHave(text(value));
        return this;
    }

    public TextBoxPage outputEmailCheck(String value) {
        outputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxPage outputAddressCheck(String value) {
        outputAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPage outputPermanentAddressCheck(String value) {
        outputPermanentAddress.shouldHave(text(value));
        return this;
    }
}
