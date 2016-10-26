package com.auth0.jwtdecodejava;

import com.auth0.jwtdecodejava.exceptions.JWTException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.Nullable;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import java.io.IOException;

class Utils {

    @Nullable
    static String base64Decode(String string) throws JWTException {
        String decoded;
        try {
            decoded = StringUtils.newStringUtf8(Base64.decodeBase64(string));
        } catch (NullPointerException e) {
            throw new JWTException("Received bytes didn't correspond to a valid Base64 encoded string.", e);
        }
        return decoded;
    }

    @Nullable
    static String base64Encode(String string) throws JWTException {
        String encoded;
        try {
            encoded = StringUtils.newStringUtf8(Base64.encodeBase64(string.getBytes(), false, true));
        } catch (NullPointerException e) {
            throw new JWTException("Received bytes didn't correspond to a valid Base64 encoded string.", e);
        }
        return encoded;
    }
}
