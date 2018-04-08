package com.maxxitsolution.a1networkspte.tableview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.listener.ITableViewListener;

import com.maxxitsolution.a1networkspte.DedicatedServerBuyActivity;
import com.maxxitsolution.a1networkspte.ModelClass.CloudServer;
import com.maxxitsolution.a1networkspte.tableview.holder.ColumnHeaderViewHolder;
import com.maxxitsolution.a1networkspte.tableview.popup.ColumnHeaderLongPressPopup;

import java.util.List;

/**
 * Created by TOSHIBA on 3/8/2018.
 */

public class DedicatedServerTableViewListener implements ITableViewListener {

    private final String TAG = DedicatedServerTableViewListener.this.getClass().getSimpleName();
    private ITableView mTableView;
    private Context context;
    private List<CloudServer> userInfoList;

    public DedicatedServerTableViewListener(ITableView pTableView, Context context, List<CloudServer> userInfoList) {
        this.mTableView = pTableView;
        this.context = context;
        this.userInfoList = userInfoList;
    }

    @Override
    public void onCellClicked(@NonNull RecyclerView.ViewHolder p_jCellView, int p_nXPosition, int
            p_nYPosition) {
        //Log.e(TAG, p_nXPosition + " " + p_nYPosition);
        Intent intent = new Intent(context, DedicatedServerBuyActivity.class);
        intent.putExtra("DedicatedServer", userInfoList.get(p_nYPosition));
        context.startActivity(intent);
    }

    @Override
    public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder p_jColumnHeaderView, int
            p_nXPosition) {

    }

    @Override
    public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder p_jColumnHeaderView,
                                          int p_nXPosition) {
        if (p_jColumnHeaderView != null && p_jColumnHeaderView instanceof ColumnHeaderViewHolder) {

            // Create Long Press Popup
            ColumnHeaderLongPressPopup popup = new ColumnHeaderLongPressPopup(
                    (ColumnHeaderViewHolder) p_jColumnHeaderView, mTableView);

            // Show
            popup.show();
        }
    }

    @Override
    public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder p_jRowHeaderView, int
            p_nYPosition) {

    }

    @Override
    public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder p_jRowHeaderView, int
            p_nYPosition) {

    }
}

