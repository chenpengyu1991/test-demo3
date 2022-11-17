package com.founder.elb.cas;

import com.founder.elb.cas.MD5Encoder;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-3-29
 * Time: 下午12:53
 * To implement cas password encoder.
 */
public class PasswordEncoder implements org.jasig.cas.authentication.handler.PasswordEncoder{

    @Override
    public String encode(String password) {
        return  MD5Encoder.getMD5Str(password);
    }
}




