package pt.iade.ricardopereira.qrity_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.iade.ricardopereira.qrity_admin.R;
import pt.iade.ricardopereira.qrity_admin.models.PermissionAreasItem;
import pt.iade.ricardopereira.qrity_admin.models.PermissionItem;

public class PermissionsAreasAdapter extends RecyclerView.Adapter<PermissionsAreasAdapter.ViewHolder> {
    private ArrayList<PermissionAreasItem> permissionItemList;
    private Context context;
    public ItemClickListener clickListener;

    public PermissionsAreasAdapter(Context context, ArrayList<PermissionAreasItem> permissionItemList) {
        this.context = context;
        this.permissionItemList = permissionItemList;
        clickListener = null;
    }

    public void setOnClickListener(PermissionsAreasAdapter.ItemClickListener listener){
        clickListener = listener;
    }

    @NonNull
    @Override
    public PermissionsAreasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View permissionView = inflater.inflate(R.layout.row_permission_areas, parent, false);
        return new ViewHolder(permissionView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PermissionAreasItem permissionItem = permissionItemList.get(position);
        holder.door_area.setText(permissionItem.getArea());
    }



    @Override
    public int getItemCount() {
        return permissionItemList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {


        public TextView door_area;
        // Add more TextViews or views for other fields in PermissionItem

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from the layout

            door_area =  itemView.findViewById(R.id.door_area);

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
