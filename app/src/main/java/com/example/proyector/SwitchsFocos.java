package com.example.proyector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SwitchsFocos extends RecyclerView.Adapter<SwitchsFocos.ViewHolderSwitchs>{
    @NonNull

    ArrayList<SwitchVo> ListaSwitch;

    public SwitchsFocos(@NonNull ArrayList<SwitchVo> ListaSwitch) {
        this.ListaSwitch = ListaSwitch;
    }

    @Override
    public ViewHolderSwitchs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.diseno_switch,null,false);
        return new ViewHolderSwitchs(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSwitchs holder, int position) {
        holder.Etilugar.setText(ListaSwitch.get(position).getLugar());

    }

    @Override
    public int getItemCount() {
        return ListaSwitch.size();
    }

    public class ViewHolderSwitchs extends RecyclerView.ViewHolder {

        TextView Etilugar;


        public ViewHolderSwitchs(@NonNull View itemView) {
            super(itemView);
            Etilugar=itemView.findViewById(R.id.lugar);

        }
    }
}
