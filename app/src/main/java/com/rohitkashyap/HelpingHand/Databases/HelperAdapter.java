package com.rohitkashyap.HelpingHand.Databases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohitkashyap.HelpingHand.R;
import com.rohitkashyap.HelpingHand.User.Details;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {

    List<Details> fetchDataList;

    public HelperAdapter(List<Details> fetchDataList) {
        this.fetchDataList = fetchDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolderClass viewHolderClass = (ViewHolderClass)holder;

        Details fetchData = fetchDataList.get(position);
        viewHolderClass.name1.setText(fetchData.name);
        viewHolderClass.city1.setText(fetchData.city);
        viewHolderClass.poc1.setText(fetchData.poc);
        viewHolderClass.cap1.setText(fetchData.capacity);
        viewHolderClass.contact1.setText(fetchData.contact);
        viewHolderClass.cost1.setText(fetchData.cost);
        viewHolderClass.pin1.setText(fetchData.pincode);
        viewHolderClass.add1.setText(fetchData.address);

    }

    @Override
    public int getItemCount() {
        return fetchDataList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView name1, city1, poc1, cap1, contact1, cost1, pin1, add1;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            name1 = itemView.findViewById(R.id.name);
            city1 = itemView.findViewById(R.id.city);
            poc1 = itemView.findViewById(R.id.poc);
            cap1 = itemView.findViewById(R.id.cap);
            contact1 = itemView.findViewById(R.id.num);
            cost1 = itemView.findViewById(R.id.cost);
            pin1 = itemView.findViewById(R.id.pin);
            add1 = itemView.findViewById(R.id.add);

        }
    }

}
