package com.example.securewebapp.models;

import org.springframework.web.client.HttpClientErrorException.NotFound;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.val;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
@Builder
@FieldDefaults(makeFinal = false, level=AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class User {
    private int ID;
    @NonNull
    private String fristName;
    private String lastName;

    @SneakyThrows(NotFound.class)
    public void printName() {
        log.info("print Name");
        val usr = User.builder().fristName("a").lastName("b").build();

        System.out.println(usr.getFristName() +" "+ usr.getLastName());
    }
}
