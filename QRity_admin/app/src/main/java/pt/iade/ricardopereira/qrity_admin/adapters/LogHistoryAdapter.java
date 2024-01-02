package pt.iade.ricardopereira.qrity_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.iade.ricardopereira.qrity_admin.models.LogHistoryItem;
import pt.iade.ricardopereira.qrity_admin.R; // Make sure to replace this with the correct package for your project

public class LogHistoryAdapter extends RecyclerView.Adapter<LogHistoryAdapter.LogHistoryViewHolder> {

    private List<LogHistoryItem> logHistoryItemList;
    private Context context;

    public LogHistoryAdapter(List<LogHistoryItem> logHistoryItemList, Context context) {
        this.logHistoryItemList = logHistoryItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public LogHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_log_history, parent, false);
        return new LogHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogHistoryViewHolder holder, int position) {
        LogHistoryItem logHistoryItem = logHistoryItemList.get(position);

        // Bind data to the ViewHolder
        holder.workerTextView.setText(logHistoryItem.getWorker());
        holder.doorTextView.setText(logHistoryItem.getDoor());
        holder.areaTextView.setText(logHistoryItem.getArea());

    }

    @Override
    public int getItemCount() {
        return logHistoryItemList.size();
    }

    public class LogHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView workerTextView, doorTextView, areaTextView, timestampTextView;

        public LogHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize your TextViews here
            workerTextView = itemView.findViewById(R.id.worker_log_name);
            doorTextView = itemView.findViewById(R.id.door_log_name);
            areaTextView = itemView.findViewById(R.id.area_log_name);

        }
    }
}
