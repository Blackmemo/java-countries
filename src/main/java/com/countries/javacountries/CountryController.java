package com.countries.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController
{
    // localhost:8080/names/all
    // return the names of all the countries alphabetically
    @RequestMapping(value = "/all")
    public ResponseEntity<?> getAllCountries()
    {
        JavaCountriesApplication.myCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavaCountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

    // localhost:8080/names/start/a
    // return the countries alphabetically that begin with the given letter
    @GetMapping(value = "/start/{letter}")
    public ResponseEntity<?> getCountriesLetter (@PathVariable char letter)
    {

        ArrayList<Country> rtnCoun = JavaCountriesApplication.myCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCoun.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCoun, HttpStatus.OK);
    }

    // localhost:8080/names/size/1
    // return the countries alphabetically that have a name equal to or longer than the given length
    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> getCountriesNameSize (@PathVariable int number)
    {
        ArrayList<Country> rtnNames = JavaCountriesApplication.myCountryList.findCountries(c -> c.getName().length() >= number);
        rtnNames.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnNames, HttpStatus.OK);
    }
}
