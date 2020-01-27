package com.epcorpt.userinfoapi.helper;

import com.epcorpt.userinfoapi.common.UserInfoException;
import com.epcorpt.userinfoapi.dao.entity.UserInfoEntity;
import com.epcorpt.userinfoapi.model.UserInfoUpdateDetailRequest;

public interface UserInfoHelper {
    UserInfoEntity getUserDetail(String username) throws UserInfoException;
    void updateUserInfo(UserInfoEntity userInfo, UserInfoUpdateDetailRequest request) throws UserInfoException;
}
