package com.countries.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication
{

    public static CountryList myCountryList;
    public static void main(String[] args)
    {
        myCountryList = new CountryList();
        SpringApplication.run(JavaCountriesApplication.class, args);
    }

}
