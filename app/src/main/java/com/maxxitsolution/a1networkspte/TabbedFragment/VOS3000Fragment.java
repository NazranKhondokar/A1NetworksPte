package com.maxxitsolution.a1networkspte.TabbedFragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;
import com.hanks.htextview.line.LineTextView;

import com.maxxitsolution.a1networkspte.ModelClass.VOS3000;
import com.maxxitsolution.a1networkspte.R;
import com.maxxitsolution.a1networkspte.tableview.MyTableAdapter;
import com.maxxitsolution.a1networkspte.tableview.VOS3000TableViewListener;
import com.maxxitsolution.a1networkspte.tableview.model.CellModel;
import com.maxxitsolution.a1networkspte.tableview.model.ColumnHeaderModel;
import com.maxxitsolution.a1networkspte.tableview.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VOS3000Fragment extends Fragment {

    private static final String TAG = VOS3000Fragment.class.getSimpleName();
    private VOS3000 cellModel = new VOS3000();
    private com.evrencoskun.tableview.TableView mTableView;
    private MyTableAdapter mTableAdapter;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<VOS3000> userInfoList;
    private LineTextView hTextView;

    public VOS3000Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vos3000, container, false);
        mTableView = view.findViewById(R.id.my_TableView);
        hTextView = (LineTextView) view.findViewById(R.id.textview);
        hTextView.setOnClickListener(new ClickListener());
        hTextView.setAnimationListener(new SimpleAnimationListener(getActivity()));
        hTextView.animateText("SERVER LIST");

        // Create TableView Adapter
        mTableAdapter = new MyTableAdapter(getContext());
        mTableView.setAdapter(mTableAdapter);

        userInfoList = new ArrayList<>();
        VOS3000Ready();
        populatedTableView(userInfoList);

        // Create listener
        mTableView.setTableViewListener(new VOS3000TableViewListener(mTableView, getActivity(), userInfoList));

        return view;
    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            ((HTextView) v).animateText("SERVER LIST");

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

    private void VOS3000Ready() {
        cellModel = new VOS3000();
        cellModel.setConcurrent_calls("500 CC");
        cellModel.setProcessor("E3-1220");
        cellModel.setCores("4");
        cellModel.setMemory("2GB RAM");
        cellModel.setHard_disk("100 GB SATA HDD");
        cellModel.setPrice("$60");
        userInfoList.add(cellModel);

        cellModel = new VOS3000();
        cellModel.setConcurrent_calls("1000 CC");
        cellModel.setProcessor("E3-1220");
        cellModel.setCores("4");
        cellModel.setMemory("4GB RAM");
        cellModel.setHard_disk("100 GB SATA HDD");
        cellModel.setPrice("$100");
        userInfoList.add(cellModel);

        cellModel = new VOS3000();
        cellModel.setConcurrent_calls("2000 CC");
        cellModel.setProcessor("E3-1220");
        cellModel.setCores("4");
        cellModel.setMemory("8GB RAM");
        cellModel.setHard_disk("200 GB SATA HDD");
        cellModel.setPrice("$125");
        userInfoList.add(cellModel);

        cellModel = new VOS3000();
        cellModel.setConcurrent_calls("3000 CC");
        cellModel.setProcessor("E3-1220");
        cellModel.setCores("4");
        cellModel.setMemory("8GB RAM");
        cellModel.setHard_disk("200 GB SATA HDD");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new VOS3000();
        cellModel.setConcurrent_calls("5000 CC");
        cellModel.setProcessor("E3-1220");
        cellModel.setCores("4");
        cellModel.setMemory("8GB RAM");
        cellModel.setHard_disk("1000 GB SATA HDD");
        cellModel.setPrice("$225");
        userInfoList.add(cellModel);
    }

    public void populatedTableView(List<VOS3000> userInfoList) {
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
        list.add(new ColumnHeaderModel("Concurrent calls"));
        list.add(new ColumnHeaderModel("Processor"));
        list.add(new ColumnHeaderModel("Cores"));
        list.add(new ColumnHeaderModel("Memory"));
        list.add(new ColumnHeaderModel("Hard Disk"));
        list.add(new ColumnHeaderModel("Price/Monthly"));

        return list;
    }

    private List<List<CellModel>> loadCellModelList(List<VOS3000> userInfoList) {
        List<List<CellModel>> lists = new ArrayList<>();

        // Creating cell model list from UserInfo list for Cell Items
        // In this example, UserInfo list is populated from web service

        for (int i = 0; i < userInfoList.size(); i++) {
            VOS3000 userInfo = userInfoList.get(i);

            List<CellModel> list = new ArrayList<>();

            // The order should be same with column header list;
            list.add(new CellModel("1-" + i, userInfo.getConcurrent_calls()));
            list.add(new CellModel("2-" + i, userInfo.getProcessor()));
            list.add(new CellModel("3-" + i, userInfo.getCores()));
            list.add(new CellModel("4-" + i, userInfo.getMemory()));
            list.add(new CellModel("5-" + i, userInfo.getHard_disk()));
            list.add(new CellModel("6-" + i, userInfo.getPrice()));

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
