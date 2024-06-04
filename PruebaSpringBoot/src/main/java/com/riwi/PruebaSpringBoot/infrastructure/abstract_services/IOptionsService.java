package com.riwi.PruebaSpringBoot.infrastructure.abstract_services;

import com.riwi.PruebaSpringBoot.api.dto.request.OptionRequest;
import com.riwi.PruebaSpringBoot.api.dto.response.OptionResponse;

public interface IOptionsService extends CrudService<OptionRequest, OptionResponse, Long>{
    
}
