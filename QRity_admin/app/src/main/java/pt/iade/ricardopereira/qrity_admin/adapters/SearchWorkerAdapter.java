package pt.iade.ricardopereira.qrity_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.iade.ricardopereira.qrity_admin.R;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

public class SearchWorkerAdapter extends RecyclerView.Adapter<SearchWorkerAdapter.ViewHolder> {
    private List<WorkersItem> searchWorkersItemList;
    private Context context;
    public ItemClickListener clickListener;

    public SearchWorkerAdapter(Context context, List<WorkersItem> searchWorkersItemList) {
        this.context = context;
        this.searchWorkersItemList = searchWorkersItemList;
    }

    @NonNull
    @Override
    public SearchWorkerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View workersView = inflater.inflate(R.layout.row_workers_item, parent, false);
        return new SearchWorkerAdapter.ViewHolder(workersView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchWorkerAdapter.ViewHolder holder, int position) {
        WorkersItem workersItem = searchWorkersItemList.get(position);

        // Set data to views in the ViewHolder
        holder.worker_name.setText(workersItem.getWorker_name());
        holder.role.setText("Cargo: " + workersItem.getRole());
        // You can add more fields based on your PermissionItem model
    }
    public void setOnClickListener(ItemClickListener listener){
        clickListener = listener;
    }

    @Override
    public int getItemCount() {
        return searchWorkersItemList.size();
    }
    public void setSearchWorkersItemList(List<WorkersItem> searchWorkersItemList) {
        this.searchWorkersItemList = searchWorkersItemList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView worker_name;

        public TextView role;
        // Add more TextViews or views for other fields in PermissionItem

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from the layout
            worker_name= itemView.findViewById(R.id.worker_name);
            role =  itemView.findViewById(R.id.role);
            // Initialize other views based on your PermissionItem model

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if(clickListener != null){

                clickListener.onItemClick(v, getAdapterPosition(),searchWorkersItemList.get(getAdapterPosition()));
            }
        }
    }
    public interface ItemClickListener{

        void onItemClick(View view, int position, WorkersItem selectedWorker);
    }
}

