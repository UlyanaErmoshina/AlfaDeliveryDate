package ru.netology;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor

public class UserInfo {
    public UserInfo(String city, String name, String phone) {
        this.city = city;
        this.name = name;
        this.phone = phone;
    }

    private String city;
    private String name;
    private String phone;

    }



