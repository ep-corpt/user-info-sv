package com.epcorpt.userinfoapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.epcorpt.userinfoapi.constant.UserInfoConstant.STATUS_SUCCESS;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    protected String statusCode = STATUS_SUCCESS;
    protected String statusDesc;
}
