package com.epcorpt.userinfoapi.service.impl;

import com.epcorpt.userinfoapi.common.UserInfoException;
import com.epcorpt.userinfoapi.dao.entity.UserInfoEntity;
import com.epcorpt.userinfoapi.helper.UserInfoHelper;
import com.epcorpt.userinfoapi.model.UserInfoInquiryResponse;
import com.epcorpt.userinfoapi.model.UserInfoResponse;
import com.epcorpt.userinfoapi.model.UserInfoUpdateDetailRequest;
import com.epcorpt.userinfoapi.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import static com.epcorpt.userinfoapi.constant.UserInfoConstant.*;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoHelper userInfoHelper;

    @Override
    public ResponseEntity<UserInfoInquiryResponse> getUserInfoDetail(HttpServletRequest request) throws UserInfoException {
        UserInfoEntity userInfo = userInfoHelper.getUserDetail(request.getHeader(ID));
        return ResponseEntity.ok(new UserInfoInquiryResponse(userInfo));
    }

    @Override
    public ResponseEntity<UserInfoResponse> updateUserInfoDetail(UserInfoUpdateDetailRequest request, HttpServletRequest httpServletRequest) throws UserInfoException {
        UserInfoEntity userInfo = userInfoHelper.getUserDetail(httpServletRequest.getHeader(ID));
        userInfoHelper.updateUserInfo(userInfo, request);
        return ResponseEntity.ok(UserInfoResponse
                .builder()
                .statusCode(STATUS_SUCCESS)
                .statusDesc(UPDATE_USER_DETAIL_SUCCESSFULLY)
                .build());
    }
}
