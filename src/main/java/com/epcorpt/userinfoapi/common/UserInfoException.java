package com.epcorpt.userinfoapi.common;

import com.epcorpt.userinfoapi.constant.UserInfoConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoException extends Exception {
    private String statusCode = UserInfoConstant.STATUS_ERROR;
    private String statusDesc;

    public UserInfoException(String statusDesc) {
        super(statusDesc);
        this.statusDesc = statusDesc;
    }

    public UserInfoException(String statusDesc, Throwable ex) {
        super(statusDesc, ex);
        this.statusDesc = statusDesc;
    }

}
