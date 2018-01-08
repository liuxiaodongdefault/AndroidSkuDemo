package sku.product.com.skudemo;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int CHECK_TYPE = 100; // 选择项
    public static final int PROPERTY_TYPE = 101; // 属性行

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    private Activity context;
    private List<RvDataModel> mList;

    public ProductRvAdapter(Activity context, List<RvDataModel> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CHECK_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_check, null);
            CheckHolder checkHolder = new CheckHolder(view);
            checkHolder.checkedTv = (TextView) view.findViewById(R.id.tv_check);
            return checkHolder;
        } else {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_title, null);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            view1.setLayoutParams(params);
            TitleHolder titleHolder = new TitleHolder(view1);
            titleHolder.titleTv = (TextView) view1.findViewById(R.id.tv_title);
            return titleHolder;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TitleHolder) {
            TitleHolder titleHolder = (TitleHolder) holder;
            titleHolder.titleTv.setText(mList.get(position).getName());
        } else if (holder instanceof CheckHolder) {
            CheckHolder checkHolder = (CheckHolder) holder;
            checkHolder.checkedTv.setText(mList.get(position).getName());
            switch (mList.get(position).getStatus()) {
                case 0:
                    checkHolder.checkedTv.setBackgroundResource(R.drawable.rectangle_gray);
                    checkHolder.checkedTv.setTextColor(Color.parseColor("#FF292929"));
                    break;
                case 1:
                    checkHolder.checkedTv.setBackgroundResource(R.drawable.rectangle_blue);
                    checkHolder.checkedTv.setTextColor(Color.WHITE);
                    break;
                case 2:
                    checkHolder.checkedTv.setBackgroundResource(R.drawable.rectangle_gray);
                    checkHolder.checkedTv.setTextColor(Color.parseColor("#FF818181"));
                    break;
            }
            if (mOnItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onItemClick(holder.itemView, position);
                    }
                });
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class TitleHolder extends RecyclerView.ViewHolder {

        TitleHolder(View itemView) {
            super(itemView);
        }
        TextView titleTv;
    }
    class CheckHolder extends RecyclerView.ViewHolder {

        CheckHolder(View itemView) {
            super(itemView);
        }
        TextView checkedTv;
    }
}
