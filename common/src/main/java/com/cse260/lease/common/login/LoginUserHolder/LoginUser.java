package com.cse260.lease.common.login.LoginUserHolder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUser {

    private Long userId;
    private String username;
}