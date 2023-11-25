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
import pt.iade.ricardopereira.qrity_admin.models.PermissionItem;
import pt.iade.ricardopereira.qrity_admin.models.WorkersItem;

public class WorkersAdapter extends RecyclerView.Adapter<WorkersAdapter.ViewHolder> {
    private List<WorkersItem> workersItemList;
    private Context context;

    public WorkersAdapter(Context context, List<WorkersItem> workersItemList) {
        this.context = context;
        this.workersItemList = workersItemList;
    }

    @NonNull
    @Override
    public WorkersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View workersView = inflater.inflate(R.layout.row_workers_item, parent, false);
        return new ViewHolder(workersView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkersAdapter.ViewHolder holder, int position) {
       WorkersItem workersItem = workersItemList.get(position);

        // Set data to views in the ViewHolder
        holder.worker_name.setText(workersItem.getWorker_name());
        holder.role.setText("Cargo: " + workersItem.getRole());
        // You can add more fields based on your PermissionItem model
    }

    @Override
    public int getItemCount() {
        return workersItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView worker_name;

        public TextView role;
        // Add more TextViews or views for other fields in PermissionItem

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from the layout
            worker_name= itemView.findViewById(R.id.worker_name);
            role =  itemView.findViewById(R.id.role);
            // Initialize other views based on your PermissionItem model
        }
    }
}
