package com.bridgelabz.lmsproject.util;

import org.springframework.stereotype.Component;

@Component
public interface MessageListener {
    public void onMessage(Email email) throws NoSuchFieldException, SecurityException, ClassNotFoundException;
}
