package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.dto.request.CurrenncyDto;

import java.util.Set;

public interface CurrencyService {

    Set<CurrenncyDto> getAll();
}
