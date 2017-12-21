package com.example.luis.agendaconfab;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luis on 20/12/2017.
 */

public class AdaptadorListView implements ListAdapter {
private List<Contacto> lista_contactos;
private Context contexto;
private FragmentManager fm;

    public AdaptadorListView(List<Contacto> lista_contactos, Context contexto, FragmentManager fm) {
        this.lista_contactos = lista_contactos;
        this.contexto = contexto;
        this.fm=fm;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return lista_contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return lista_contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(contexto);
        View vista=inflater.inflate(R.layout.layout_contacto, parent, false);
        TextView tv_nombre=vista.findViewById(R.id.tv_nombre);
        TextView tv_telefono=vista.findViewById(R.id.tv_telefono);
        final String nombre=lista_contactos.get(position).getNombre();
        final Contacto c=lista_contactos.get(position);
        ImageButton btn_borrar=vista.findViewById(R.id.btn_borrar);
        tv_nombre.setText(lista_contactos.get(position).getNombre());
        tv_telefono.setText(lista_contactos.get(position).getTelefono());
        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogConfirmarBorrado df=new DialogConfirmarBorrado();

                Bundle argumentos=new Bundle();
                argumentos.putString("nombre", c.getNombre());
                argumentos.putInt("id", c.getId());
                df.setArguments(argumentos);//Argumentos que se mandan al DialogFragment
                df.show(fm, "Confirmación de borrado de "+c.getNombre());

            }
        });
        return vista;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return lista_contactos.size()==0;
    }
}
