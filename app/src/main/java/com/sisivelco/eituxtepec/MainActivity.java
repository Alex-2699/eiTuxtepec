package com.sisivelco.eituxtepec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;
import com.sisivelco.eituxtepec.entities.Usuarios;
import com.sisivelco.eituxtepec.retrofit.eituxService;
import com.sisivelco.eituxtepec.utilities.GlobalClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView txtUsuario;
    EditText Contra;

    String strUsuario, strContra;
    String sisUsuario,sisContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btnLogin =findViewById(R.id.btnAcceso);
        txtUsuario = findViewById(R.id.txtUsuario);
        Contra = findViewById(R.id.Contra);
        btnLogin.setOnClickListener(this);
    }

    public void sendMessage() {
        Intent intent = new Intent(this, Menu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    public void onClick(View v) {
        strUsuario =txtUsuario.getText().toString();
        strContra = Contra.getText().toString();
        getAcceso();
    }

    private void getAcceso(){
        String ipEquip =((GlobalClass) this.getApplication()).getIpEquipo();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ipEquip)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final eituxService Service = retrofit.create(eituxService.class);
        Call<Usuarios> call = Service.getNombre(strUsuario);

        call.enqueue(new Callback<Usuarios>() {
            @Override
            public void onResponse(Call<Usuarios> call, Response<Usuarios> response) {
                //Toast.makeText(MainActivity.this,response.message(),Toast.LENGTH_SHORT).show();
                Usuarios rUsuario = response.body();

                sisUsuario = rUsuario.getUsuario();
                sisContra= rUsuario.getContraseña();

                if(strContra.equals(sisContra)){
                    Toast.makeText(MainActivity.this,"Bienvenido "+sisUsuario,Toast.LENGTH_SHORT).show();
                    sendMessage();

                }else{
                    Toast.makeText(MainActivity.this,"Usuario o contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<Usuarios> call, Throwable t) {
               Toast.makeText(MainActivity.this,"Usuario o Contraseña no encontrado",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
