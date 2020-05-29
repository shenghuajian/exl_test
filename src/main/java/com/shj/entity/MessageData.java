package com.shj.entity;

import lombok.Data;

import java.util.List;

@Data
public class MessageData {
    private int code;
    private String message;
    private List<Person> list;
}
