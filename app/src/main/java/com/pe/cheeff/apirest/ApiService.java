package com.pe.cheeff.apirest;

import com.pe.cheeff.home.model.PurchaseOrderResponse;
import com.pe.cheeff.login.UserRequest;
import com.pe.cheeff.login.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("/auth/usuarios-login")
    Call<UserResponse> login(@Body UserRequest userRequest);

    @GET("/ordenes-de-compra")
    Call<PurchaseOrderResponse> getPurchaseOrderResponse();

}
