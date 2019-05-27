package com.softserveinc.qmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(how = How.CSS, using = "input[name='q']")
  public WebElement searchField;

  @FindBy(how = How.XPATH, using = "//h3")
  public WebElement found;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public ResultPage getResults() {
      new WebDriverWait(driver, 60)
              .until(ExpectedConditions.visibilityOf(found));
      return PageFactory.initElements(driver, ResultPage.class);
  }
}
