package com.softulp.lab3tp1.ui.registro;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.lab3tp1.model.Usuario;
import com.softulp.lab3tp1.request.ApiClient;

public class ViewModelRegistro extends AndroidViewModel {
    private ApiClient api;
    private MutableLiveData<Usuario> usermutableDataReg;

    public ViewModelRegistro(@NonNull Application application) {
        super(application);
        api = new ApiClient();

    }

    public LiveData<Usuario> getUsermutableDataReg() {
        if (usermutableDataReg == null) {
            usermutableDataReg = new MutableLiveData<>();
        }
        return usermutableDataReg;
    }

    public void cargarReg(Usuario usuario) {
        api.guardar(getApplication().getApplicationContext(), usuario);

        Usuario usuarioGuardado = api.leer(getApplication().getApplicationContext());
        usermutableDataReg.setValue(usuarioGuardado);
        if (usuarioGuardado != null && usuario.equals(usuarioGuardado)) {
            // Mostrar un mensaje de éxito
            Toast.makeText(getApplication(), "Los datos se guardaron correctamente", Toast.LENGTH_SHORT).show();
        } else {
            // Mostrar un mensaje de error
            Toast.makeText(getApplication(), "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }

    }
    public void obtenerUsuarioAlmacenado() {
        Usuario usuarioGuardado = api.leer(getApplication().getApplicationContext());
        usermutableDataReg.setValue(usuarioGuardado);

    }

};
