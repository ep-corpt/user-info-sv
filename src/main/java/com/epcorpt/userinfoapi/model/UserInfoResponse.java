package com.epcorpt.userinfoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.epcorpt.userinfoapi.constant.MessageConstant.REGISTER_SUCCESSFULLY;
import static com.epcorpt.userinfoapi.constant.MessageConstant.STATUS_SUCCESS;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private String statusCode = STATUS_SUCCESS;
    private String description = REGISTER_SUCCESSFULLY;
}
