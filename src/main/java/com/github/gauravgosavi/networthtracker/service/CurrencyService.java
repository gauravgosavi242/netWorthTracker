package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.model.request.CurrencyDto;

import java.util.Collection;

public interface CurrencyService {

    Collection<CurrencyDto> getAll();
}
