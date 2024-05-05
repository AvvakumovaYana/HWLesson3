package tests;

import org.junit.jupiter.api.Test;
import pages.PageObject;
import pages.TestBase;


public class RegistrationAllTest extends TestBase {

    PageObject pageObject = new PageObject();

    @Test
    void AllFormFieldsTest() {
        pageObject.openPage()
                .setFistNameInput("Yana")
                .setLastNameInput("Avvakumova")
                .setUserEmailInput("test@mail.ru")
                .setGenderInput("Female")
                .setNumberInput("7987654321")
                .setDate("1993", "6","10")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .setPicture("TestHW3.png")
                .setAddress("Test address")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmit ()
                .checkTable("Student Name", "Yana Avvakumova")
                .checkTable("Student Email", "test@mail.ru")
                .checkTable("Gender", "Female")
                .checkTable("Mobile", "7987654321")
                .checkTable("Date of Birth", "10 July,1993")
                .checkTable("Subjects", "Maths")
                .checkTable("Hobbies", "Reading")
                .checkTable("Picture", "TestHW3.png")
                .checkTable("Address", "Test address")
                .checkTable("State and City", "NCR Noida");
    }

    @Test
    void MainFormFieldsTest() {
        pageObject.openPage()
            .setFistNameInput("Yana")
            .setLastNameInput("Avvakumova")
            .setGenderInput("Female")
            .setNumberInput("7987654321")
            .setDate("1993", "6","10")
            .clickSubmit ()
            .checkTable("Student Name", "Yana Avvakumova")
            .checkTable("Student Email", " ")
            .checkTable("Gender", "Female")
            .checkTable("Mobile", "7987654321")
            .checkTable("Date of Birth", "10 July,1993")
            .checkTable("Subjects", " ")
            .checkTable("Hobbies", " ")
            .checkTable("Picture", " ")
            .checkTable("Address", " ")
            .checkTable("State and City", " ");
    }

    @Test
    void NegativeFormFieldsTest() {
        pageObject.openPage()
                .setLastNameInput("Avvakumova")
                .setGenderInput("Female")
                .setNumberInput("7987654321")
                .setDate("1993", "6","10")
                .clickSubmit()
                .checkEmptyTable();
    }
}