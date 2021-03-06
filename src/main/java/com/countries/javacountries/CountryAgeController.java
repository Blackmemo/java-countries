package com.countries.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/age")
public class CountryAgeController
{

    // localhost:8080/age/age/1
    // return the countries that have a median age equal to or greater than the given age
    @GetMapping(value = "/age/{age}")
    public ResponseEntity<?> getCountriesAge (@PathVariable int age)
    {
        ArrayList<Country> rtnAge = JavaCountriesApplication.myCountryList.findCountries(c -> c.getMedianAge() >= age);
        rtnAge.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnAge, HttpStatus.OK);
    }

    // localhost:8080/age/max
    // return the country with the largest median age
    @GetMapping(value = "/max")
    public Country getMaxAge()
{
    int age = 0;
    Country country = null;

    for (Country c : JavaCountriesApplication.myCountryList.countryList)
    {
        if (c.getMedianAge() > age)
        {
            age = c.getMedianAge();
            country = c;
        }
    }
    return country;
}

    // localhost:8080/age/min
    // return the country with the smallest age
    @GetMapping(value = "/min")
    public Country getMinAge()
    {
       int min = 1000;
       Country minAge = null;
       for (Country c : JavaCountriesApplication.myCountryList.countryList)
       {
           if (c.getMedianAge() <= min)
           {
               min = c.getMedianAge();
               minAge = c;
           }
       }
       return minAge;
    }
}
