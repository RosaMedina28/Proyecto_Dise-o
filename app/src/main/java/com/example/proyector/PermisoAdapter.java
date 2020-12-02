package com.example.proyector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.PermisoHolder> {
    private ArrayList<Permiso> permisos;

    public PermisoAdapter(ArrayList<Permiso> permisos) {
        this.permisos = permisos;
    }


    @NonNull
    @Override
    public PermisoAdapter.PermisoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_permisos,parent,false);
        return new PermisoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoAdapter.PermisoHolder holder, int position) {
        holder.añadir_permisos(permisos.get(position));
    }

    @Override
    public int getItemCount() {
        return permisos.size();
    }

    public class PermisoHolder extends RecyclerView.ViewHolder {
        TextView Nompermiso;

        public PermisoHolder(@NonNull View itemView) {
            super(itemView);
            Nompermiso = itemView.findViewById(R.id.text_permiso);
        }

        public void añadir_permisos(Permiso permiso) {
            Nompermiso.setText(permiso.getPermiso());
        }
    }
}
