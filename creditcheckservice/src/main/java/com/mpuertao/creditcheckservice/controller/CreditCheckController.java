package com.mpuertao.creditcheckservice.controller;

import com.mpuertao.creditcheckservice.gateway.CreditCheckRequest;
import com.mpuertao.creditcheckservice.gateway.CreditCheckResponse;
import com.mpuertao.creditcheckservice.service.CreditCheckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCheckController {

    private final CreditCheckService creditCheckService;

    public CreditCheckController(CreditCheckService creditCheckService) {
        this.creditCheckService = creditCheckService;
    }

    @PostMapping("/credit-scores")
    public CreditCheckResponse doCreditCheck(@RequestBody CreditCheckRequest creditCheckRequest) {
        return creditCheckService.doCreditCheck(creditCheckRequest.getCitizenNumber());
    }
}
