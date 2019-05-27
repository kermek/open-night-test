package com.softserveinc.qmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Sample page
 */
public class ResultPage extends Page {

  @FindAll({@FindBy(how = How.XPATH, using = "//h3")})
  public List<WebElement> foundLinks;

  public ResultPage(WebDriver webDriver) {
    super(webDriver);
  }
}
