package com.sisivelco.eituxtepec.retrofit;

import com.sisivelco.eituxtepec.entities.Usuarios;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface eituxService {

    @GET("usuarios/{Usr}")
    Call<Usuarios> getNombre(@Path("Usr") String Usuario);

}



