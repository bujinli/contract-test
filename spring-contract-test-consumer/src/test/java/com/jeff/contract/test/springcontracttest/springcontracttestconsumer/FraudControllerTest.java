package com.jeff.contract.test.springcontracttest.springcontracttestconsumer;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com.jeff.contract.test:spring-contract-test:+:stubs:8090"},
                         stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class FraudControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void test_controller() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/test").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}
