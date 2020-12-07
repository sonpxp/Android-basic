package com.sonmob.studentmanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sonmob.studentmanager.Model.Lop;
import com.sonmob.studentmanager.R;
import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.LopViewHolder>{
    private List<Lop> mListLop;
    Context context;

    public void setData(List<Lop> list, Context context){
        this.mListLop = list;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop, parent, false);
        return new LopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LopViewHolder holder, final int position)  {
        final Lop lop = mListLop.get(position);
        if (lop  == null){
            return;
        }
        holder.tvTenLop.setText(lop.getTenLop());
        holder.tvMaLop.setText(lop.getMaLop());
        holder.ivXoaLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"ban da click nut delete",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListLop != null){
            return mListLop.size();
        }
        return 0;
    }

    public  class LopViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgLop, ivXoaLop;
        private TextView tvTenLop;
        private TextView tvMaLop;

        public LopViewHolder(@NonNull final View itemView) {
            super(itemView);

            imgLop = itemView.findViewById(R.id.img_lop);
            tvTenLop = itemView.findViewById(R.id.tv_tenLop);
            tvMaLop = itemView.findViewById(R.id.tv_maLop);
            ivXoaLop = itemView.findViewById(R.id.tv_delete);

        }
    }
}