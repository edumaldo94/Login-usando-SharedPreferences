package com.softulp.lab3tp1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.lab3tp1.R;
import com.softulp.lab3tp1.databinding.ActivityLoginBinding;
import com.softulp.lab3tp1.databinding.ActivityRegistroBinding;
import com.softulp.lab3tp1.model.Usuario;
import com.softulp.lab3tp1.ui.registro.RegistroActivity;
import com.softulp.lab3tp1.ui.registro.ViewModelRegistro;

public class LoginActivity extends AppCompatActivity {
private ActivityLoginBinding binding;
private ViewModelLogin vml;
    private ActivityRegistroBinding bindingR;
    private ViewModelRegistro vmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vml= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelLogin.class);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String email = binding.etxtUser.getText().toString();
        String password = binding.etxtPass.getText().toString();


        vml.loguear(email, password);

    }
});
        vml.getUsermutableData().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if (usuario != null) {
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    Usuario usuarioAlmacenado = vml.obtenerUsuarioAlmacenado();
                    if (usuarioAlmacenado != null) {

                        Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                     intent.putExtra("usuario", usuario);
                        startActivity(intent);
                           }
                       }

            }
        });
        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                    startActivity(intent);

            }
        });
}

}