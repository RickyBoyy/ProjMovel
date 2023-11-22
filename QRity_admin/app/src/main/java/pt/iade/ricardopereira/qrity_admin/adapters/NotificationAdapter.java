package pt.iade.ricardopereira.qrity_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.iade.ricardopereira.qrity_admin.R;
import pt.iade.ricardopereira.qrity_admin.models.NotificationItem;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private List<NotificationItem> notificationItemList;
    private AdapterView.OnItemClickListener listener;
    public NotificationAdapter(List<NotificationItem> notificationItemList) {
        this.notificationItemList = notificationItemList;

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



        // Add additional logic to bind other views if needed
    }

    @Override
    public int getItemCount() {
        return notificationItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView request;
        public TextView door;

        public ImageView checkMark;

        public ImageView crossMark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            request = itemView.findViewById(R.id.title_label);
            door = itemView.findViewById(R.id.door_label);
            checkMark = itemView.findViewById(R.id.check_mark);
            crossMark = itemView.findViewById(R.id.cross_mark);


            // Initialize other views if needed
        }
    }
    public interface OnItemClickListener {
        void onCheckMarkClick(NotificationItem notificationItem);
        void onCrossMarkClick(NotificationItem notificationItem);
    }

}
