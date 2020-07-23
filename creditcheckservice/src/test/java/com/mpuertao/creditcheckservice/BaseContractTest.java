package com.mpuertao.creditcheckservice;

import com.mpuertao.creditcheckservice.controller.CreditCheckController;
import com.mpuertao.creditcheckservice.gateway.CreditCheckResponse;
import com.mpuertao.creditcheckservice.service.CreditCheckService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.Mockito;

import static com.mpuertao.creditcheckservice.gateway.CreditCheckResponse.Score.HIGH;
import static org.mockito.Mockito.mock;

public class BaseContractTest {

    @Before
    public void setUp() {
        final CreditCheckService mock = mock(CreditCheckService.class);
        Mockito.when(mock.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(mock));
    }
}
