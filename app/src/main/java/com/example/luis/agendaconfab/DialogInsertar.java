package com.example.luis.agendaconfab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by luis on 20/12/2017.
 */

public class DialogInsertar extends DialogFragment {
    OyenteDialog oyente;
    public interface OyenteDialog
    {
        public void insertarContacto(Contacto c);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View vista=inflater.inflate(R.layout.layout_insertar_contacto, null);

        //Los botones de los Dialog tiene que gestionarlos el builder porque así al clicarlos hará el dismiss(cerrar Dialog)
        builder.setPositiveButton("Grabar", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

               String nombre=((EditText)vista.findViewById(R.id.et_nombre)).getText().toString();
               String telefono=((EditText)vista.findViewById(R.id.et_telefono)).getText().toString();
               oyente=(OyenteDialog) getActivity();
                oyente.insertarContacto(new Contacto(nombre, telefono, 999));
                Log.v("Grabar", nombre);
            };
        });
        builder.setView(vista);
        return builder.create();
    }
}
