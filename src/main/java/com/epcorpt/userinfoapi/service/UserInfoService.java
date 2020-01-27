package com.epcorpt.userinfoapi.service;

import com.epcorpt.userinfoapi.common.UserInfoException;
import com.epcorpt.userinfoapi.model.UserInfoInquiryResponse;
import com.epcorpt.userinfoapi.model.UserInfoResponse;
import com.epcorpt.userinfoapi.model.UserInfoUpdateDetailRequest;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface UserInfoService {
    ResponseEntity<UserInfoInquiryResponse> getUserInfoDetail(HttpServletRequest request) throws UserInfoException;
    ResponseEntity<UserInfoResponse> updateUserInfoDetail(UserInfoUpdateDetailRequest request, HttpServletRequest httpServletRequest) throws UserInfoException;
}
