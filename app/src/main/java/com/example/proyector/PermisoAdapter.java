package com.example.proyector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.PermisoHolder> {
    private List<Permiso> permisos;

    public PermisoAdapter(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    @NonNull
    @Override
    public PermisoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_permisos,parent,false);
        return new PermisoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoHolder holder, int position) {
    holder.añadir_permisos(permisos.get(position));
    }

    @Override
    public int getItemCount() {
        return permisos.size();
    }

    public class PermisoHolder extends RecyclerView.ViewHolder {
        TextView nombre_permiso;
        Switch aSwitchPermiso;
        public PermisoHolder(@NonNull View itemView) {
            super(itemView);
            nombre_permiso = itemView.findViewById(R.id.text_nombre_permiso);
            aSwitchPermiso = itemView.findViewById(R.id.switch_permiso);
        }

        public void añadir_permisos(Permiso permiso) {
            nombre_permiso.setText(Permiso.getNombre());
        }
    }
}
