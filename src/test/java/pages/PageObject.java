package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PageObject {

    public static SelenideElement fistNameInput = $("#firstName");
    public static SelenideElement lastNameInput = $("#lastName");
    public static SelenideElement emailInput = $("#userEmail");
    public static SelenideElement genderInput = $("#genterWrapper");
    public static SelenideElement numberInput = $("#userNumber");
    public static SelenideElement datePicker = $("#dateOfBirthInput");
    public static SelenideElement subjectsInput = $("#subjectsInput");
    public static SelenideElement hobbiesInput = $("#hobbiesWrapper");
    public static SelenideElement uploadPicture = $("#uploadPicture");
    public static SelenideElement addressInput = $("#currentAddress");
    public static SelenideElement stateInput = $("#state");
    public static SelenideElement cityInput = $("#city");
    public static SelenideElement submitButton = $("#submit");
    public static SelenideElement tableResponsive = $(".table-responsive");
    public static SelenideElement table = $("#example-modal-sizes-title-lg");

    public PageObject openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PageObject setFistNameInput(String value){
        fistNameInput.setValue(value);
        return this;
    }

    public PageObject setLastNameInput(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public PageObject setUserEmailInput(String value){
        emailInput.setValue(value);
        return this;
    }

    public PageObject setGenderInput(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public PageObject setNumberInput(String value){
        numberInput.setValue(value);
        return this;
    }

    public PageObject setDate(String year, String month, String day) {
        datePicker.click();
        CalendarComponent calendarComponent = new CalendarComponent();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public PageObject setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PageObject setHobbies(String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public PageObject setPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public PageObject setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public PageObject setState(String value){
        stateInput.click();
        stateInput.find(byText(value)).click();
        return this;
    }

    public PageObject setCity(String value){
        cityInput.click();
        cityInput.find(byText(value)).click();
        return this;
    }

    public PageObject clickSubmit(){
        submitButton.click();
        return this;
    }

    public PageObject checkTable(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public PageObject checkEmptyTable() {
        table.shouldNotBe(visible);
        return this;
    }
}
