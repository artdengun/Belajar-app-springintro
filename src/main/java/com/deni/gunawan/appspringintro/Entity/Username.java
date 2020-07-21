package com.deni.gunawan.appspringintro.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Username {

    @Size(min = 5, max = 50)
    private  String Nama;
    @Size(min = 5, max = 50)
    private  String Address;
    @Email(message = "invalid message")
    private  String email;


}
