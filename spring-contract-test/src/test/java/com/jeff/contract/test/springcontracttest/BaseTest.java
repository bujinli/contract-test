package com.jeff.contract.test.springcontracttest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest {

  @Autowired
  private WebApplicationContext context;

  @Before
  public void setup() {
    RestAssuredMockMvc.webAppContextSetup(context);
  }
}
