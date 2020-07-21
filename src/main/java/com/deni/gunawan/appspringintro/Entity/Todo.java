package com.deni.gunawan.appspringintro.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private  Long userId;
    private  Long id;
    private  String title;
    private boolean completed;
}
