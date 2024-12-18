package com.appium.stepdefs;

import com.appium.pages.LoginPage;
import com.appium.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("I enter username as {string}")
    public void i_enter_username_as(String string) {
        loginPage.enterUserName(string);
    }

    @Given("I enter password as {string}")
    public void i_enter_password_as(String string) {
        loginPage.enterPassword(string);
    }

    @When("I login")
    public void i_login() {
        loginPage.pressLoginBtn();
    }

    @Then("login should fail with error {string}")
    public void login_should_fail_with_error(String errormsg) {
        Assert.assertEquals(loginPage.getErrTxt(), errormsg);
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }

    @Given("I login with {string} and {string}")
    public void loginWithUsernameAndPassword(String username, String password){
        loginPage.login(username, password);
    }
}
