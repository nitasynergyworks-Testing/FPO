package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By LogoutBTN = By.xpath("(//*[name()='svg'])[21]");
    By LogoutconfBTN = By.xpath("//button[contains(text(),'Logout')]");
    By DashboardAppointment = By.xpath("(//div[contains(text(),'Appointments')]/../div[2])[1]");
    By AppointmentTab = By.xpath("(//div[text()='Appointments'])[2]");
    By AppointmentTotalCOunt = By.xpath("(//div[text()='Appointments'])/../../div[3]/div");
    By RegisterPatients = By.xpath("//div[contains(text(),'Registered')]/../div[2]");
    By PatientsTab = By.xpath("(//div[contains(text(),'Patients')])[2]");
    By PatientsTotalCOunt = By.xpath("(//div[text()='Patients'])/../../div[3]/div");

    By RegisterDoctors = By.xpath("(//div[contains(text(),'Doctors')])[2]/../div[2]");
    By DoctorsTab = By.xpath("(//div[contains(text(),'Doctors')])[2]");
    By DoctorsTotalCOunt = By.xpath("(//div[text()='Doctors'])/../../div[3]/div");


    public void clickLogoutBTN() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(LogoutBTN)).click();
    }


    public void clickLogoutCNFBTN() {
        wait.until(ExpectedConditions.elementToBeClickable(LogoutconfBTN)).click();
    }


    public void GetcountandredirecttoAppointment() {
        String count1 = wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardAppointment)).getText();
        System.out.println("Total Dashboard count is :- " + count1);
        wait.until(ExpectedConditions.elementToBeClickable(DashboardAppointment)).click();
        System.out.println("I am redirected to the Appointment tab. :- " + wait.until(ExpectedConditions.elementToBeClickable(AppointmentTab)).isDisplayed());
        String count2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppointmentTotalCOunt)).getText();
       // Assert.assertTrue(count1.contains(count2), "Text does not contain expected value");
        if (count2.contains(count1)) {
            System.out.println("Dashboard count is - " + count1 + ", Appoinment tab count is - " + count2);
            System.out.println("Count is matching with DAshboard and Appoinment tab");
        } else {
            System.out.println("Dashboard count is - " + count1 + ", Appoinment tab count is - " + count2);
            System.out.println("Count is not matching with DAshboard and Appoinment tab");
            Assert.fail();
        }

    }

    public void GetcountandredirecttoPatients() {
        String count1 = wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPatients)).getText();
        System.out.println("Total Dashboard count is :- " + count1);
        wait.until(ExpectedConditions.elementToBeClickable(RegisterPatients)).click();
        System.out.println("I am redirected to the Appointment tab. :- " + wait.until(ExpectedConditions.elementToBeClickable(PatientsTab)).isDisplayed());
        String count2 = wait.until(ExpectedConditions.visibilityOfElementLocated(PatientsTotalCOunt)).getText();
        if (count2.contains(count1)) {
            System.out.println("Dashboard count is - " + count1 + ", Appoinment tab count is - " + count2);
            System.out.println("Count is matching with DAshboard and Appoinment tab");
        } else {
            System.out.println("Dashboard count is - " + count1 + ", Appoinment tab count is - " + count2);
            System.out.println("Count is not matching with DAshboard and Appoinment tab");
        }

    }

    public void GetcountandredirecttoDoctors() {
        String count1 = wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterDoctors)).getText();
        System.out.println("Total Dashboard count is :- " + count1);
        wait.until(ExpectedConditions.elementToBeClickable(RegisterDoctors)).click();
        System.out.println("I am redirected to the Appointment tab. :- " + wait.until(ExpectedConditions.elementToBeClickable(DoctorsTab)).isDisplayed());
        String count2 = wait.until(ExpectedConditions.visibilityOfElementLocated(DoctorsTotalCOunt)).getText();
        if (count2.contains(count1)) {
            System.out.println("Dashboard count is - " + count1 + ", Appoinment tab count is - " + count2);
            System.out.println("Count is matching with DAshboard and Appoinment tab");

        } else {
            System.out.println("Dashboard count is - " + count1 + ", Appoinment tab count is - " + count2);
            System.out.println("Count is not matching with DAshboard and Appoinment tab");
            Assert.fail();
        }

    }

}
