package com.countries.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopController
{
    // localhost:8080/population/size/100
    // return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "/size/{people}")
    public ResponseEntity<?> getCountriesPopSize (@PathVariable long people)
    {
        ArrayList<Country> rtnPop = JavaCountriesApplication.myCountryList.findCountries(c -> c.getPopulation() >= people);
        rtnPop.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnPop, HttpStatus.OK);
    }

    // localhost:8080/population/min
    // return the country with the smallest population
    @GetMapping(value = "/min")
    public Country getMinPop()
    {
        long min = 1000000000;
        Country country = null;

        for (Country c : JavaCountriesApplication.myCountryList.countryList)
        {
            if (c.getPopulation() <= min)
            {
                min = c.getPopulation();
                country = c;
            }
        }
        return country;
    }

    // localhost:8080/population/max
    // return the country with the largest population
    @GetMapping(value = "/max")
    public Country getMaxPop()
    {
        long max = 0;
        Country thisCountry = null;

        for (Country c : JavaCountriesApplication.myCountryList.countryList)
        {
            if (c.getPopulation() > max)
            {
                max = c.getPopulation();
                thisCountry = c;
            }
        }
        return thisCountry;
    }
}
