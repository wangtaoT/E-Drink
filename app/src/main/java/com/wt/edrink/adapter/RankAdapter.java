package com.wt.edrink.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wt.edrink.R;
import com.wt.edrink.bean.RankListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroid.base.SimpleRecAdapter;

/**
 * Created by 美时美课 on 2017/5/24.
 */

public class RankAdapter extends SimpleRecAdapter<RankListBean, RecyclerView.ViewHolder> {
    public RankAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder newViewHolder(View itemView) {
        return new mViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_rank;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RankListBean item = data.get(position);
        ((mViewHolder) holder).tvNum.setText(position + 1 + "");
        ((mViewHolder) holder).tvUserName.setText(item.getNickName());
        ((mViewHolder) holder).tvLike.setOnClickListener(onClickListener(position, item));
    }

    private View.OnClickListener onClickListener(final int position, final RankListBean model) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRecItemClick().onItemClick(position, model, v.getId(), null);
            }
        };
        return onClickListener;
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rank_num)
        TextView tvNum;
        @BindView(R.id.tv_rank_mobile)
        TextView tvUserName;
        @BindView(R.id.tv_rank_like)
        TextView tvLike;

        public mViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}