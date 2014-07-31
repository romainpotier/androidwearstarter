package fr.romainpotier.androidwearstarter.service;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import fr.romainpotier.androidwearstarter.beans.ApiResult;

@Rest(rootUrl = "http://opendata.paris.fr/api/records/1.0", converters = { MappingJacksonHttpMessageConverter.class })
public interface CoffeeService {

    @Get("/search?dataset=liste-des-cafes-a-un-euro&rows=10000")
    ApiResult getCoffees();
}
