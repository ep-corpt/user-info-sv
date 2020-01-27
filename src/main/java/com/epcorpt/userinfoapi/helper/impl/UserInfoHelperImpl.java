package com.epcorpt.userinfoapi.helper.impl;

import com.epcorpt.userinfoapi.common.UserInfoException;
import com.epcorpt.userinfoapi.constant.UserInfoConstant;
import com.epcorpt.userinfoapi.dao.entity.UserInfoEntity;
import com.epcorpt.userinfoapi.dao.repository.UserInfoRepository;
import com.epcorpt.userinfoapi.helper.UserInfoHelper;
import com.epcorpt.userinfoapi.model.UserInfoUpdateDetailRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.epcorpt.userinfoapi.constant.UserInfoConstant.INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN;
import static com.epcorpt.userinfoapi.constant.UserInfoConstant.USER_DETAIL_NOT_FOUND;

@Slf4j
@Service
public class UserInfoHelperImpl implements UserInfoHelper {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfoEntity getUserDetail(String username) throws UserInfoException {
        try {
            if (StringUtils.isEmpty(username)) {
                log.error("username in header is null, please check gateway");
                throw new UserInfoException(UserInfoConstant.INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN);
            } else {
                return userInfoRepository.findById("test").orElseThrow(() -> new UserInfoException(USER_DETAIL_NOT_FOUND));
            }
        } catch (Exception e) {
            throw new UserInfoException(INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN);
        }
    }

    @Override
    public void updateUserInfo(UserInfoEntity userInfo, UserInfoUpdateDetailRequest request) throws UserInfoException {
        try {
            userInfo.setFirstName(request.getFirstName());
            userInfo.setLastName(request.getLastName());
            userInfo.setGender(request.getGender());
            userInfo.setAge(request.getAge());
            userInfo.setMobileNo(request.getMobileNo());
            userInfo.setAddress(request.getAddress());
            userInfoRepository.save(userInfo);
        } catch (Exception e) {
            log.error("exception occurred while update userInfo,", e);
            throw new UserInfoException(INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN);
        }
    }
}
