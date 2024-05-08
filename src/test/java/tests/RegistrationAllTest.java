package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationAllTest extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void allFormFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFistNameInput("Yana")
                .setLastNameInput("Avvakumova")
                .setUserEmailInput("test@mail.ru")
                .setGenderInput("Female")
                .setNumberInput("7987654321")
                .setDate("1993", "6", "10")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .setPicture("TestHW3.png")
                .setAddress("Test address")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmit()
                .checkTable("Yana Avvakumova", "test@mail.ru",
                        "Female", "7987654321",
                        "10 July,1993", "Maths",
                        "Reading", "TestHW3.png",
                        "Test address", "NCR Noida");
    }

    @Test
    void mainFormFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFistNameInput("Yana")
                .setLastNameInput("Avvakumova")
                .setGenderInput("Female")
                .setNumberInput("7987654321")
                .setDate("1993", "6", "10")
                .clickSubmit()
                .checkTable("Yana Avvakumova", " ",
                        "Female", "7987654321",
                        "10 July,1993", " ",
                        " ", " ",
                        " ", " ");
    }

    @Test
    void negativeFormFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setLastNameInput("Avvakumova")
                .setGenderInput("Female")
                .setNumberInput("7987654321")
                .setDate("1993", "6","10")
                .clickSubmit()
                .checkTableNotVisible();
    }
}