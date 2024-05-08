package com.softulp.lab3tp1.ui.login;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.lab3tp1.model.Usuario;
import com.softulp.lab3tp1.request.ApiClient;

public class ViewModelLogin extends AndroidViewModel {
private ApiClient api;
    private MutableLiveData<Usuario> usermutableData;
    public ViewModelLogin(@NonNull Application application) {
        super(application);
        api = new ApiClient();

    }
    public LiveData<Usuario> getUsermutableData(){
        if(usermutableData==null){
            usermutableData= new MutableLiveData<>();
        }
        return  usermutableData;
    }
    public void loguear(String mail, String password) {
        Usuario usuario = api.login(getApplication().getApplicationContext(), mail, password);
        if (usuario != null) {
            usermutableData.setValue(usuario);
        } else {
            Toast.makeText(getApplication(), "Credenciales incorrectas. Por favor, inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
        }
    }

    public Usuario obtenerUsuarioAlmacenado() {
        return api.leer(getApplication().getApplicationContext());
    }
}
