package com.riwi.PruebaSpringBoot.infrastructure.abstract_services;

import com.riwi.PruebaSpringBoot.api.dto.request.UserRequest;
import com.riwi.PruebaSpringBoot.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse,Long>{
    
}
