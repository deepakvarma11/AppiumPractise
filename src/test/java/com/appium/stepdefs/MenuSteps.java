package com.appium.stepdefs;

import com.appium.pages.MenuPage;
import com.appium.pages.SettingsPage;
import io.cucumber.java.en.Then;

public class MenuSteps {
    MenuPage menuPage;
    SettingsPage settingsPage;

    @Then("I click on Menu")
    public void i_click_on_menu() {
        menuPage = new MenuPage();
        settingsPage = menuPage.pressSettingsBtn();

    }
    @Then("I click on Logout")
    public void i_click_on_logout() {
        settingsPage.pressLogoutBtn();
    }
}
