package com.maxxitsolution.a1networkspte.TabbedFragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evrencoskun.tableview.TableView;
import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;
import com.hanks.htextview.line.LineTextView;
import com.maxxitsolution.a1networkspte.ModelClass.VOIP;
import com.maxxitsolution.a1networkspte.tableview.VOIPTableViewListener;
import com.maxxitsolution.a1networkspte.tableview.model.ColumnHeaderModel;

import com.maxxitsolution.a1networkspte.tableview.MyTableAdapter;
import com.maxxitsolution.a1networkspte.tableview.model.CellModel;
import com.maxxitsolution.a1networkspte.tableview.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VOIPTerminationFragment extends Fragment {

    private static final String LOG_TAG = VOIPTerminationFragment.class.getSimpleName();
    private VOIP cellModel = new VOIP();
    private TableView mTableView;
    private MyTableAdapter mTableAdapter;

    private ProgressDialog mProgressDialog;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<VOIP> userInfoList;
    private LineTextView hTextView;

    public VOIPTerminationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_voiptermination, container, false);

        hTextView = (LineTextView) view.findViewById(com.maxxitsolution.a1networkspte.R.id.textview);
        hTextView.setOnClickListener(new ClickListener());
        hTextView.setAnimationListener(new SimpleAnimationListener(getActivity()));
        hTextView.animateText("TYPE OF PROVIDER");

        mTableView = (TableView) view.findViewById(com.maxxitsolution.a1networkspte.R.id.my_TableView);

        // Create TableView Adapter
        mTableAdapter = new MyTableAdapter(getContext());
        mTableView.setAdapter(mTableAdapter);

        userInfoList = new ArrayList<>();
        voipDataReady();
        populatedTableView(userInfoList);

        // Create listener
        mTableView.setTableViewListener(new VOIPTableViewListener(mTableView, getActivity(), userInfoList));

        return view;
    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            ((HTextView) v).animateText("TYPE OF PROVIDER");

        }
    }

    class SimpleAnimationListener implements AnimationListener {

        private Context context;

        public SimpleAnimationListener(Context context) {
            this.context = context;
        }

        @Override
        public void onAnimationEnd(HTextView hTextView) {
            //Toast.makeText(context, "Animation finished", Toast.LENGTH_SHORT).show();
        }
    }

    private void voipDataReady() {
        cellModel.setmCode("8801");
        cellModel.setmCountry("Bangladesh");
        cellModel.setmDestination("Bangladesh mobile");
        cellModel.setmPremium("0.0196");
        cellModel.setmSilver("0.018");
        cellModel.setmSpecial("0.0188");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("91");
        cellModel.setmCountry("India");
        cellModel.setmDestination("India mobile");
        cellModel.setmPremium("0.009");
        cellModel.setmSilver("0.004");
        cellModel.setmSpecial("0.0083");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("92");
        cellModel.setmDestination("Pakistan fix");
        cellModel.setmCountry("Pakistan");
        cellModel.setmPremium("0.0355");
        cellModel.setmSilver("0.034");
        cellModel.setmSpecial("0.0245");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("923");
        cellModel.setmDestination("Pakistan mobile");
        cellModel.setmCountry("Pakistan");
        cellModel.setmPremium("0.034");
        cellModel.setmSilver("0.033");
        cellModel.setmSpecial("0.0245");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("9230");
        cellModel.setmDestination("Pakistan mobilink");
        cellModel.setmCountry("Pakistan");
        cellModel.setmPremium("0.033");
        cellModel.setmSilver("0.0325");
        cellModel.setmSpecial("0.023");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("9231");
        cellModel.setmDestination("Pakistan Mobile zong");
        cellModel.setmCountry("Pakistan");
        cellModel.setmPremium("0.033");
        cellModel.setmSilver("0.033");
        cellModel.setmSpecial("0.0165");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("9232");
        cellModel.setmDestination("Pakistan Mobile warid");
        cellModel.setmCountry("Pakistan");
        cellModel.setmPremium("0.0345");
        cellModel.setmSilver("0.0345");
        cellModel.setmSpecial("0.01");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("9233");
        cellModel.setmDestination("Pakistan Mobile uphone");
        cellModel.setmCountry("Pakistan");
        cellModel.setmPremium("0.033");
        cellModel.setmSilver("0.031");
        cellModel.setmSpecial("0.023");
        userInfoList.add(cellModel);

        cellModel = new VOIP();

        cellModel.setmCode("9234");
        cellModel.setmDestination("Pakistan Mobile telenor");
        cellModel.setmCountry("Pakistan");
        cellModel.setmPremium("0.0105");
        cellModel.setmSilver("0.001");
        cellModel.setmSpecial("0.0055");
        userInfoList.add(cellModel);
    }

    public void populatedTableView(List<VOIP> userInfoList) {
        // create Models
        mColumnHeaderList = createColumnHeaderModelList();
        mCellList = loadCellModelList(userInfoList);
        mRowHeaderList = createRowHeaderList();

        // Set all items to the TableView
        mTableAdapter.setAllItems(mColumnHeaderList, mRowHeaderList, mCellList);
    }


    private List<ColumnHeaderModel> createColumnHeaderModelList() {
        List<ColumnHeaderModel> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeaderModel("Code"));
        list.add(new ColumnHeaderModel("Destination name"));
        list.add(new ColumnHeaderModel("Country"));
        list.add(new ColumnHeaderModel("Premium"));
        list.add(new ColumnHeaderModel("Silver"));
        list.add(new ColumnHeaderModel("Special"));

        return list;
    }

    private List<List<CellModel>> loadCellModelList(List<VOIP> userInfoList) {
        List<List<CellModel>> lists = new ArrayList<>();

        // Creating cell model list from UserInfo list for Cell Items
        // In this example, UserInfo list is populated from web service

        for (int i = 0; i < userInfoList.size(); i++) {
            VOIP userInfo = userInfoList.get(i);

            List<CellModel> list = new ArrayList<>();

            // The order should be same with column header list;
            list.add(new CellModel("1-" + i, userInfo.getmCode()));     // "Name"
            list.add(new CellModel("2-" + i, userInfo.getmDestination())); // "Nickname"
            list.add(new CellModel("3-" + i, userInfo.getmCountry()));    // "Email"
            list.add(new CellModel("4-" + i, userInfo.getmPremium())); // "BirthDay"
            list.add(new CellModel("5-" + i, userInfo.getmSilver()));   // "Gender"
            list.add(new CellModel("6-" + i, userInfo.getmSpecial()));      // "Age"

            // Add
            lists.add(list);
        }

        return lists;
    }

    private List<RowHeaderModel> createRowHeaderList() {
        List<RowHeaderModel> list = new ArrayList<>();
        for (int i = 0; i < mCellList.size(); i++) {
            // In this example, Row headers just shows the index of the TableView List.
            list.add(new RowHeaderModel(String.valueOf(i + 1)));
        }
        return list;
    }

}
