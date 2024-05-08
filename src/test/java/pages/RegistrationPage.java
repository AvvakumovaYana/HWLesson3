package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    private final SelenideElement fistNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement datePicker = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final TableResultComponent tableResultComponent = new TableResultComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFistNameInput(String value){
        fistNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastNameInput(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmailInput(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGenderInput(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumberInput(String value){
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDate(String year, String month, String day) {
        datePicker.click();
        CalendarComponent calendarComponent = new CalendarComponent();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateInput.click();
        stateInput.find(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        cityInput.click();
        cityInput.find(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit(){
        submitButton.click();
        return this;
    }

    public RegistrationPage checkTable(String studentName, String studentEmail,
                                       String gender, String mobile,
                                       String dateOfBirth, String subject,
                                       String hobbies, String picture,
                                       String address, String stateAndCity) {
        tableResultComponent
                .checkRow("Student Name", studentName)
                .checkRow("Student Email", studentEmail)
                .checkRow("Gender", gender)
                .checkRow("Mobile", mobile)
                .checkRow("Date of Birth", dateOfBirth)
                .checkRow("Subjects", subject)
                .checkRow("Hobbies", hobbies)
                .checkRow("Picture", picture)
                .checkRow("Address", address)
                .checkRow("State and City", stateAndCity);
        return this;
    }

    public RegistrationPage checkTableNotVisible(){
        tableResultComponent.checkTableNotVisible();
        return this;
    }
}
