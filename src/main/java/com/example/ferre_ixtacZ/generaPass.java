package com.example.ferre_ixtacZ;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class generaPass {
public static void main(String[] args){

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String passHash = encoder.encode("acmolon");
        
System.out.println("Hash generado: " + passHash);
   }
}

 
 