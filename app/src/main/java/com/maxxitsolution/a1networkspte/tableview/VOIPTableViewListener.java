package com.maxxitsolution.a1networkspte.tableview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.listener.ITableViewListener;
import com.maxxitsolution.a1networkspte.ModelClass.VOIP;
import com.maxxitsolution.a1networkspte.VOIPBuyActivity;
import com.maxxitsolution.a1networkspte.tableview.holder.ColumnHeaderViewHolder;

import com.maxxitsolution.a1networkspte.tableview.popup.ColumnHeaderLongPressPopup;

import java.util.List;


/**
 * Created by evrencoskun on 2.12.2017.
 */

public class VOIPTableViewListener implements ITableViewListener {

    private final String TAG = VOIPTableViewListener.this.getClass().getSimpleName();
    private ITableView mTableView;
    private Context context;
    private List<VOIP> userInfoList;

    public VOIPTableViewListener(ITableView pTableView, Context context, List<VOIP> userInfoList) {
        this.mTableView = pTableView;
        this.context = context;
        this.userInfoList = userInfoList;
    }

    @Override
    public void onCellClicked(@NonNull RecyclerView.ViewHolder p_jCellView, int p_nXPosition, int
            p_nYPosition) {
        Log.e(TAG, p_nXPosition + " " + p_nYPosition);
        Intent intent = new Intent(context, VOIPBuyActivity.class);
        intent.putExtra("VOIP", userInfoList.get(p_nYPosition));
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
