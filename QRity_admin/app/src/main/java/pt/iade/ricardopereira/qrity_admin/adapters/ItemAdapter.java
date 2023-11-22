package pt.iade.ricardopereira.qrity_admin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pt.iade.ricardopereira.qrity_admin.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    private LayoutInflater inflater;

    private itemClickListener clickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView doorName;
        public TextView areaName;

        public Switch locked;


        public ViewHolder(View itemView){

            super(itemView);


            doorName = itemView.findViewById(R.id.row_name);
            areaName = itemView.findViewById(R.id.specific_name);
            locked = itemView.findViewById(R.id.locked_switch);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(clickListener != null){
                clickListener.onItemClick(view, getAdapterPosition());
            }

        }
    }
    public interface itemClickListener {
        void onItemClick(View view, int position);
    }

}
