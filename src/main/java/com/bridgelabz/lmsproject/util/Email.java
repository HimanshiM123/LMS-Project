package com.bridgelabz.lmsproject.util;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;


@Component
@ToString
@Data
public class Email {
    public String to;
    public String from;
    public String body;
    public String subject;

}
