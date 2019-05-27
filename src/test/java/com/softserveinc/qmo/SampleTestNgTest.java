package com.softserveinc.qmo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserveinc.qmo.pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testSearch() {
    driver.get(baseUrl);

    assertEquals(homepage.getTitle(), "Google", "Google was not opened");

    homepage.searchField.sendKeys("open night softserve kyiv" + Keys.ENTER);

    assertTrue(homepage.getResults().foundLinks.stream()
            .anyMatch(element -> element.getText()
                    .equals("Open night IТ Academy Softserve, 28 травня | DOU")),
            "Event was not found");
  }
}
