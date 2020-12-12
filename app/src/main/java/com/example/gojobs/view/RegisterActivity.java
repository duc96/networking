package com.example.gojobs.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowId;
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
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    EditText edtUserNameRegister, edtPasswordRegister, edtRePasswordRegister, edtEmailRegister, edtPhoneRegister;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mapItem();
        callAPI();
    }

    private void mapItem() {
        edtUserNameRegister = findViewById(R.id.edt_username_register);
        edtPasswordRegister = findViewById(R.id.edt_password_register);
        edtRePasswordRegister = findViewById(R.id.edt_repassword_register);
        edtEmailRegister = findViewById(R.id.edt_email_register);
        edtPhoneRegister = findViewById(R.id.edt_phone_register);

        tvRegister = findViewById(R.id.tv_register_register);

    }

    private void callAPI() {
        final RetrofitClinet retrofit = new RetrofitClinet();

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                String tenNguoiDung = edtUserNameRegister.getText().toString();
                String matKhau = edtRePasswordRegister.getText().toString();
                String matKhau1 = edtPasswordRegister.getText().toString();
                String email = edtEmailRegister.getText().toString();
                String phone = edtPhoneRegister.getText().toString();

                User user = new User(tenNguoiDung, matKhau, email, phone);

                if (matKhau.equals(matKhau1)) {
                    API api = retrofit.getClien().create(API.class);
                    api.addUser(edtUserNameRegister.getText().toString(),edtPasswordRegister.getText().toString(), edtEmailRegister.getText().toString(), edtPhoneRegister.getText().toString())
                            .enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Log.d("respone", "onResponse: " + response.code());
//                            if (response.code() == 201){
//                                edtRePasswordRegister.setBackground(null);
//                                Toast.makeText(RegisterActivity.this, "Register success !", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//                                startActivity(intent);
//                            }else if (response.code() == 409){
//                                edtRePasswordRegister.setBackground(null);
//                                Toast.makeText(RegisterActivity.this, "Register success !", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//                                startActivity(intent);
//                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "Fail !", Toast.LENGTH_SHORT).show();

                        }
                    });
                } else {
                    edtRePasswordRegister.setBackgroundColor(R.color.colorRed);
                    Toast.makeText(RegisterActivity.this, "check your password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}