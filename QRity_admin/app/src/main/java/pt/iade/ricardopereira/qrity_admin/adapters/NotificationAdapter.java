package pt.iade.ricardopereira.qrity_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.iade.ricardopereira.qrity_admin.R;
import pt.iade.ricardopereira.qrity_admin.models.NotificationItem;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private List<NotificationItem> notificationItemList;
    private Context context;

    private ViewHolder.ItemClickListener itemClickListener;
    public NotificationAdapter(Context context, List<NotificationItem> notificationItemList) {
        this.context = context;
        this.notificationItemList = notificationItemList;
        itemClickListener = null;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View notificationView = inflater.inflate(R.layout.row_request_notification, parent, false);
        return new ViewHolder(notificationView);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationItem notificationItem = notificationItemList.get(position);

        // Set the data to the views
        holder.request.setText(notificationItem.getTitle());
        holder.door.setText("Door: " + notificationItem.getDoor());
        holder.area.setText("Area: " + notificationItem.getArea());

        holder.checkMark.setOnClickListener(v ->{

                    Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show();
                    // Add your logic here for handling the cross mark click
                    // For example, you can remove the item from the list
                    notificationItemList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, notificationItemList.size());

                }


                );

        holder.crossMark.setOnClickListener(v -> {

            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show();
            // Add your logic here for handling the cross mark click
            // For example, you can remove the item from the list
            notificationItemList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, notificationItemList.size());
        });

        // Add additional logic to bind other views if needed
    }

    @Override
    public int getItemCount() {
        return notificationItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView request;
        public TextView door;

        public TextView area;

        public ImageButton checkMark;

        public ImageButton crossMark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            request = itemView.findViewById(R.id.title_label);
            door = itemView.findViewById(R.id.door_label);
            area = itemView.findViewById(R.id.area_notification_name);
            checkMark = itemView.findViewById(R.id.check_mark);
            checkMark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(null, "TEST", Toast.LENGTH_LONG);
                }
            });
            crossMark = itemView.findViewById(R.id.cross_mark);
            crossMark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(null, "TEST", Toast.LENGTH_LONG);
                }
            });

            // Initialize other views if needed
        }
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }


}

