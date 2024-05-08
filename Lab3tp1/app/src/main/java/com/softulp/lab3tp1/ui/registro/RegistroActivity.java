package com.softulp.lab3tp1.ui.registro;

import android.content.Intent;
import android.os.Bundle;
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
import com.softulp.lab3tp1.databinding.ActivityRegistroBinding;
import com.softulp.lab3tp1.model.Usuario;
import com.softulp.lab3tp1.ui.login.LoginActivity;
import com.softulp.lab3tp1.ui.login.ViewModelLogin;

public class RegistroActivity extends AppCompatActivity {
private ActivityRegistroBinding binding;
private ViewModelRegistro vmr;
    private ViewModelLogin vml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding=ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vmr= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegistro.class);
        vml= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelLogin.class);

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dniString = binding.etDni.getText().toString();
                long dni = Long.parseLong(dniString);
                String apellido=binding.etApellido.getText().toString();
                String nombre=binding.etNombre.getText().toString();
                String mail=binding.etMail.getText().toString();
                String password=binding.etPass.getText().toString();

                Usuario usuario=new Usuario(dni,apellido,nombre,mail,password);
                vmr.cargarReg(usuario);

                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

            vmr.getUsermutableDataReg().observe(this, new Observer<Usuario>() {
                @Override
                public void onChanged(Usuario usuario) {
                    if (getIntent().hasExtra("usuario")) {
                    binding.etDni.setText(String.valueOf(usuario.getDni()));
                    binding.etApellido.setText(usuario.getApellido());
                    binding.etNombre.setText(usuario.getNombre());
                    binding.etMail.setText(usuario.getMail());
                    binding.etPass.setText(usuario.getPassword());
                    }
                }

            });
            vmr.obtenerUsuarioAlmacenado();
        }

}
/*
     binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo=binding.etCodigo.getText().toString();
                String descripcion=binding.etDescripcion.getText().toString();
                String precio=binding.etPrecio.getText().toString();
                mv.guardar(codigo,descripcion,precio);

            }
        });
*//*
        if (getIntent().hasExtra("usuario")) {
            Usuario usuarioAlmacenado = (Usuario) getIntent().getSerializableExtra("usuario");
            binding.etDni.setText(String.valueOf(usuarioAlmacenado.getDni()));
            binding.etApellido.setText(usuarioAlmacenado.getApellido());
            binding.etNombre.setText(usuarioAlmacenado.getNombre());
            binding.etMail.setText(usuarioAlmacenado.getMail());
            binding.etPass.setText(usuarioAlmacenado.getPassword());
        }
*/