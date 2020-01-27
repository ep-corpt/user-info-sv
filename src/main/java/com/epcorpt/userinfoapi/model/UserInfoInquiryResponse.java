package com.epcorpt.userinfoapi.model;

import com.epcorpt.userinfoapi.dao.entity.UserInfoEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static com.epcorpt.userinfoapi.constant.UserInfoConstant.INQUIRY_USER_DETAIL_SUCCESSFULLY;
import static com.epcorpt.userinfoapi.constant.UserInfoConstant.STATUS_SUCCESS;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserInfoInquiryResponse extends UserInfoResponse {
    private UserInfoEntity userInfoDetail;

    public UserInfoInquiryResponse(UserInfoEntity userInfoDetail) {
        super(STATUS_SUCCESS, INQUIRY_USER_DETAIL_SUCCESSFULLY);
        this.userInfoDetail = userInfoDetail;
    }
}
