package pt.iade.ricardopereira.qrity_admin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewrHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView name;
    TextView position;
    public MyViewrHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.ImageView);
        name = itemView.findViewById(R.id.name);
        position = itemView.findViewById(R.id.position);

    }
}
