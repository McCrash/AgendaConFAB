package com.example.luis.agendaconfab;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogConfirmarBorrado.AvisaBorrado, DialogInsertar.OyenteDialog{
    //El implements es para poder usar la interfazAvisaBorrado para pasarel id que debe ser borrado al Main

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agenda);
        Contacto c1=new Contacto("Ana", "5565998", 1);
        Contacto c2=new Contacto("Jose", "955656889", 2);
        Contacto c3=new Contacto("Teresa", "6556598", 3);
        Contacto c4=new Contacto("Ana", "5565998", 4);
        List<Contacto> lista_contactos=new ArrayList<>();
        lista_contactos.add(c1);
        lista_contactos.add(c2);
        lista_contactos.add(c3);
        lista_contactos.add(c4);
        ListView lista=findViewById(R.id.lv_contactos);
        AdaptadorListView ad=new AdaptadorListView(lista_contactos, this, getFragmentManager());
        lista.setAdapter(ad);


        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab_insertar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInsertar d=new DialogInsertar();
                d.show(getFragmentManager(), "Nuevo contacto");
            }
        });
    }

    @Override
    public void aceptarBorrado(int id) {
        Log.v("Borrar desde Main", "Borrar contacto con id "+id);
    }

    @Override
    public void insertarContacto(Contacto c) {
        Log.v("Insertar desde Main", c.getId()+" "+c.getNombre()+" "+c.getTelefono());
    }
}
