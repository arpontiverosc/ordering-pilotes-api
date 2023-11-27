package com.tui.ordering.pilotes.mother;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CredentialsMother {

    public static String getBase64Credentials() {

        String username = "arpontiverosc";
        String rawPassword = "123456";

        String credentials = username + ":" + rawPassword;
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }
}
