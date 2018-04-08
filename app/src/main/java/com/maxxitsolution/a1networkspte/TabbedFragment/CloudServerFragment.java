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

import com.maxxitsolution.a1networkspte.ModelClass.CloudServer;
import com.maxxitsolution.a1networkspte.R;
import com.maxxitsolution.a1networkspte.tableview.MyTableAdapter;
import com.maxxitsolution.a1networkspte.tableview.CloudServerTableViewListener;
import com.maxxitsolution.a1networkspte.tableview.model.CellModel;
import com.maxxitsolution.a1networkspte.tableview.model.ColumnHeaderModel;
import com.maxxitsolution.a1networkspte.tableview.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CloudServerFragment extends Fragment {

/*    private static final String[] TABLE_HEADERS = { "Model", "Disk", "Price", "Monthly" };
    private static final String[][] DATA_TO_SHOW = {
            {"CS001", "30 GB", "$30", "BUY"},
            {"CS002", "40 GB", "$40", "BUY"},
            {"CS003", "60 GB", "$50", "BUY"},
            {"CS004", "80 GB", "$60", "BUY"},
            {"Km001", "10 GB", "$20", "BUY"},
            {"Km002", "20 GB", "$30", "BUY"},
            {"Km003", "40 GB", "$40", "BUY"}};*/

    private static final String LOG_TAG = CloudServerFragment.class.getSimpleName();
    private CloudServer cellModel = new CloudServer();
    private com.evrencoskun.tableview.TableView mTableView;
    private MyTableAdapter mTableAdapter;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<CloudServer> userInfoList;
    private LineTextView hTextView;

    public CloudServerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cloud_server, container, false);
        /*TableView<String[]> tableView = (TableView<String[]>) view.findViewById(R.id.tableView);
        tableView.setColumnCount(4);
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(getActivity(), TABLE_HEADERS));
        tableView.setDataAdapter(new SimpleTableDataAdapter(getActivity(), DATA_TO_SHOW));*/
        hTextView = (LineTextView) view.findViewById(R.id.textViewCloud);
        hTextView.setOnClickListener(new ClickListener());
        hTextView.setAnimationListener(new SimpleAnimationListener(getActivity()));
        hTextView.animateText("SERVER LIST");
        mTableView = view.findViewById(R.id.my_TableView);

        // Create TableView Adapter
        mTableAdapter = new MyTableAdapter(getContext());
        mTableView.setAdapter(mTableAdapter);

        userInfoList = new ArrayList<>();
        cloudServerReady();
        populatedTableView(userInfoList);

        // Create listener
        mTableView.setTableViewListener(new CloudServerTableViewListener(mTableView, getActivity(), userInfoList));

        return view;
    }

    private void cloudServerReady() {
        cellModel.setModel("CS001");
        cellModel.setCpu("1vCore");
        cellModel.setFreq("3.5 GHz");
        cellModel.setRam("1 GB");
        cellModel.setDisk("30 GB SSD");
        cellModel.setNetwork("1 TB traffic");
        cellModel.setIp("1");
        cellModel.setCollocation("canada");
        cellModel.setPrice("$30");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("CS002");
        cellModel.setCpu("2vCore");
        cellModel.setFreq("3.5 GHz");
        cellModel.setRam("2 GB");
        cellModel.setDisk("40 GB SSD");
        cellModel.setNetwork("2 TB traffic");
        cellModel.setIp("1");
        cellModel.setCollocation("canada");
        cellModel.setPrice("$40");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("CS003");
        cellModel.setCpu("2vCore");
        cellModel.setFreq("3.5 GHz");
        cellModel.setRam("4 GB");
        cellModel.setDisk("60 GB SSD");
        cellModel.setNetwork("3 TB traffic");
        cellModel.setIp("1");
        cellModel.setCollocation("canada");
        cellModel.setPrice("$50");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("CS004");
        cellModel.setCpu("4vCore");
        cellModel.setFreq("3.5 GHz");
        cellModel.setRam("8 GB");
        cellModel.setDisk("80 GB SSD");
        cellModel.setNetwork("4 TB traffic");
        cellModel.setIp("1");
        cellModel.setCollocation("canada");
        cellModel.setPrice("$60");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("Km001");
        cellModel.setCpu("1vCore");
        cellModel.setFreq("2.4 GHz");
        cellModel.setRam("2 GB");
        cellModel.setDisk("10 GB SSD");
        cellModel.setNetwork("100 Mbps");
        cellModel.setIp("1");
        cellModel.setCollocation("canada");
        cellModel.setPrice("$20");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("Km002");
        cellModel.setCpu("1vCore");
        cellModel.setFreq("2.4 GHz");
        cellModel.setRam("4 GB");
        cellModel.setDisk("20 GB SSD");
        cellModel.setNetwork("100 Mbps");
        cellModel.setIp("1");
        cellModel.setCollocation("canada");
        cellModel.setPrice("$30");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("Km003");
        cellModel.setCpu("1vCore");
        cellModel.setFreq("2.4 GHz");
        cellModel.setRam("8 GB");
        cellModel.setDisk("40 GB SSD");
        cellModel.setNetwork("100 Mbps");
        cellModel.setIp("1");
        cellModel.setCollocation("canada");
        cellModel.setPrice("$40");
        userInfoList.add(cellModel);
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

    public void populatedTableView(List<CloudServer> userInfoList) {
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
        list.add(new ColumnHeaderModel("Model"));
        list.add(new ColumnHeaderModel("CPU"));
        list.add(new ColumnHeaderModel("Freq."));
        list.add(new ColumnHeaderModel("Ram"));
        list.add(new ColumnHeaderModel("Disk"));
        list.add(new ColumnHeaderModel("Network/Bandwidth"));
        list.add(new ColumnHeaderModel("IP"));
        list.add(new ColumnHeaderModel("Collocation"));
        list.add(new ColumnHeaderModel("Price(USD)"));

        return list;
    }

    private List<List<CellModel>> loadCellModelList(List<CloudServer> userInfoList) {
        List<List<CellModel>> lists = new ArrayList<>();

        // Creating cell model list from UserInfo list for Cell Items
        // In this example, UserInfo list is populated from web service

        for (int i = 0; i < userInfoList.size(); i++) {
            CloudServer userInfo = userInfoList.get(i);

            List<CellModel> list = new ArrayList<>();

            // The order should be same with column header list;
            list.add(new CellModel("1-" + i, userInfo.getModel()));     // "Name"
            list.add(new CellModel("2-" + i, userInfo.getCpu())); // "Nickname"
            list.add(new CellModel("3-" + i, userInfo.getFreq())); // "BirthDay"
            list.add(new CellModel("4-" + i, userInfo.getRam()));   // "Gender"
            list.add(new CellModel("5-" + i, userInfo.getDisk()));      // "Age"
            list.add(new CellModel("6-" + i, userInfo.getNetwork()));      // "Age"
            list.add(new CellModel("7-" + i, userInfo.getIp()));      // "Age"
            list.add(new CellModel("8-" + i, userInfo.getCollocation()));      // "Age"
            list.add(new CellModel("9-" + i, userInfo.getPrice()));      // "Age"

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
