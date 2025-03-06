package com.example.webmovie.mapper;

import com.example.webmovie.Model.User;
import com.example.webmovie.dto.request.UpdateUseRequest;
import com.example.webmovie.dto.request.UserRequest;
import com.example.webmovie.dto.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest userRequest);

    UserResponse toUserReponse(User user);

    List<UserResponse> toUserResponseList(List<User> users);

    User updateUserRequestToUser(UpdateUseRequest updateUseRequest);


}