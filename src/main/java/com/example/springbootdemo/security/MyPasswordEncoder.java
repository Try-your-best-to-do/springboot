package com.example.springbootdemo.security;


import org.springframework.security.crypto.password.PasswordEncoder;

/*
* security的password
* ye
* 2020.11.10
* */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
