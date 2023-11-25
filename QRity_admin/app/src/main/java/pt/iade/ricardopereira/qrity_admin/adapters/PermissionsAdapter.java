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

public class PermissionsAdapter extends RecyclerView.Adapter<PermissionsAdapter.ViewHolder> {
    private List<PermissionItem> permissionItemList;
    private Context context;
    public ItemClickListener clickListener;

    public PermissionsAdapter(Context context, List<PermissionItem> permissionItemList) {
        this.context = context;
        this.permissionItemList = permissionItemList;
        clickListener = null;
    }

    public void setOnClickListener(ItemClickListener listener){
        clickListener = listener;
    }

    @NonNull
    @Override
    public PermissionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View permissionView = inflater.inflate(R.layout.row_permissions, parent, false);
        return new ViewHolder(permissionView);
    }

    @Override
    public void onBindViewHolder(@NonNull PermissionsAdapter.ViewHolder holder, int position) {
        PermissionItem permissionItem = permissionItemList.get(position);

        // Set data to views in the ViewHolder
        holder.door_name.setText(permissionItem.getDoor_name());
        holder.area.setText("Area: " + permissionItem.getArea());
        // You can add more fields based on your PermissionItem model
    }

    @Override
    public int getItemCount() {
        return permissionItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public TextView door_name;

        public TextView area;
        // Add more TextViews or views for other fields in PermissionItem

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from the layout
            door_name= itemView.findViewById(R.id.door_name);
            area =  itemView.findViewById(R.id.area_name);

            itemView.setOnClickListener(this);
            // Initialize other views based on your PermissionItem model
        }
        @Override
        public void onClick(View view){
            if(clickListener != null){

                clickListener.onItemClick(view, getAdapterPosition());
            }

        }
    }

    public interface ItemClickListener{

        void onItemClick(View view, int position);
    }
}
