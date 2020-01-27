package com.epcorpt.userinfoapi.controller;

import com.epcorpt.userinfoapi.common.UserInfoException;
import com.epcorpt.userinfoapi.model.UserInfoInquiryResponse;
import com.epcorpt.userinfoapi.model.UserInfoResponse;
import com.epcorpt.userinfoapi.model.UserInfoUpdateDetailRequest;
import com.epcorpt.userinfoapi.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/inquiry")
    @ApiImplicitParam(name = "id", paramType = "header", value = "test", required = true)
    public ResponseEntity<UserInfoInquiryResponse> inquiry(HttpServletRequest request) throws UserInfoException {
        return userInfoService.getUserInfoDetail(request);
    }

    @PatchMapping("/update")
    @ApiImplicitParam(name = "id", paramType = "header", value = "test", required = true)
    public ResponseEntity<UserInfoResponse> updateUserDetail(@Valid @RequestBody UserInfoUpdateDetailRequest request, HttpServletRequest httpServletRequest) throws UserInfoException {
        return userInfoService.updateUserInfoDetail(request, httpServletRequest);
    }
}
