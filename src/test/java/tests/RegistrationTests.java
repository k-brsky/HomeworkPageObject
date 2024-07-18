package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Kotik")
                .setLastName("Begemotikov")
                .setEmail("kotik@begemotikov.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("10", "May", "1990")
                .setSubject("Chemistry")
                .setHobby("Reading")
                .uploadPicture("1126.jpg")
                .setUserAddress("ulitsa Kotikov, don Begemotikov")
                .setState("Haryana")
                .setCity("Karnal")
                .submit()
                .checkResult("Student Name", "Kotik Begemotikov")
                .checkResult("Student Email", "kotik@begemotikov.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "0 May,1990")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "1126.jpg")
                .checkResult("Address", "ulitsa Kotikov, don Begemotikov")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void fillRequiredFildsTest(){
        registrationPage.openPage()
                .setFirstName("Poligraf")
                .setLastName("Sharikov")
                .setEmail("poligraf@sharikov.com")
                .setGender("Male")
                .setUserNumber("0987654321")
                .setDateOfBirth("14", "June", "1996")
                .submit()
                .checkResult("Student Name", "Poligraf Sharikov")
                .checkResult("Student Email", "poligraf@sharikov.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0987654321")
                .checkResult("Date of Birth", "14 June,1996")
                .checkResult("Subjects", " ")
                .checkResult("Hobbies", " ")
                .checkResult("Picture", " ")
                .checkResult("Address", " ")
                .checkResult("State and City", " ");
    }

    @Test
    void clickSubmitWithEmptyFields() {
        registrationPage.openPage()
                .submit()
                .checkRedFirstName()
                .checkRedLastName()
                .checkRedMobile();
    }
}

