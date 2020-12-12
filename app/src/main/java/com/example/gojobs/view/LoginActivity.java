package com.example.gojobs.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gojobs.MainActivity;
import com.example.gojobs.R;
import com.example.gojobs.api.API;
import com.example.gojobs.api.RetrofitClinet;
import com.example.gojobs.modal.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName, edtPassword;
    private TextView tvLogin, tvRegister;
    Boolean result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initItem();
        login();
    }

    private void initItem() {
        edtUserName = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        tvLogin = findViewById(R.id.tv_login);
        tvRegister = findViewById(R.id.tv_register);
    }

    private void login() {
        final RetrofitClinet retrofit = new RetrofitClinet();
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = edtUserName.getText().toString();
                final String pass = edtPassword.getText().toString();
                final Intent intent = new Intent(LoginActivity.this,MainActivity.class);

                API api = retrofit.getClien().create(API.class);
                api.getAllUser().enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (response.code() == 200) {
                            List<User> users = response.body();
                            for (int i = 0; i < users.size(); i++) {
                                System.out.println(users.get(i).toString());
                                if (name.equals(users.get(i).getUserName()) && pass.equals(users.get(i).getPassWord())) {
                                    startActivity(intent);
                                    result = true;
                                }
                            }
                            if (result == false){
                                Toast.makeText(LoginActivity.this, "Login fail !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Fail to read users", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Is Upgrating, Sorry for this misstake !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}