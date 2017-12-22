package com.example.hp.poc_screenimplementation.viewholders;

import android.view.View;

import com.example.hp.poc_screenimplementation.components.SmartRecyclerView;

/**
 * Created by HP on 12/2/2017.
 */

public abstract class BaseViewHolder<W> extends SmartRecyclerView.ViewHolder implements View.OnClickListener{

    private W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void setData(W data);
}
