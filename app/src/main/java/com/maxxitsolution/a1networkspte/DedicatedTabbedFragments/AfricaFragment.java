package com.maxxitsolution.a1networkspte.DedicatedTabbedFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxxitsolution.a1networkspte.tableview.DedicatedServerTableViewListener;
import com.maxxitsolution.a1networkspte.tableview.model.ColumnHeaderModel;
import com.maxxitsolution.a1networkspte.ModelClass.CloudServer;
import com.maxxitsolution.a1networkspte.tableview.MyTableAdapter;
import com.maxxitsolution.a1networkspte.tableview.model.CellModel;
import com.maxxitsolution.a1networkspte.tableview.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AfricaFragment extends Fragment {

    private static final String TAG = AfricaFragment.class.getSimpleName();
    private CloudServer cellModel = new CloudServer();
    private com.evrencoskun.tableview.TableView mTableView;
    private MyTableAdapter mTableAdapter;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<CloudServer> userInfoList;

    public AfricaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_africa, container, false);
        mTableView = view.findViewById(com.maxxitsolution.a1networkspte.R.id.my_TableView);

        // Create TableView Adapter
        mTableAdapter = new MyTableAdapter(getContext());
        mTableView.setAdapter(mTableAdapter);
        userInfoList = new ArrayList<>();
        dedicatedServerReady();
        populatedTableView(userInfoList);

        // Create listener
        mTableView.setTableViewListener(new DedicatedServerTableViewListener(mTableView, getActivity(), userInfoList));
        return view;
    }

    private void dedicatedServerReady() {
        cellModel.setModel("AFDS001");
        cellModel.setCpu("Intel Core2 Duo");
        cellModel.setFreq("E6600 2.40ghz");
        cellModel.setRam("2GB");
        cellModel.setDisk("1x 500GB");
        cellModel.setNetwork("3TB @ 100Mbps");
        cellModel.setCollocation("Cairo, EG");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS002");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230 3.20ghz");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 1000GB");
        cellModel.setNetwork("2TB @ 100Mbps");
        cellModel.setCollocation("Johannesburg, ZA");
        cellModel.setPrice("$250");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS003");
        cellModel.setCpu("Intel Core i3");
        cellModel.setFreq("2100 3.10ghz");
        cellModel.setRam("8GB");
        cellModel.setDisk("2x 500GB");
        cellModel.setNetwork("3TB @ 100Mbps");
        cellModel.setCollocation("Cairo, EG");
        cellModel.setPrice("$245");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS004");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E5530 2.40ghz");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 500GB");
        cellModel.setNetwork("5TB @ 100Mbps");
        cellModel.setCollocation("Cairo, EG");
        cellModel.setPrice("$300");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS005");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("X3330 2.66ghz");
        cellModel.setRam("8GB");
        cellModel.setDisk("2x 500GB");
        cellModel.setNetwork("7TB @ 1Gbps");
        cellModel.setCollocation("Tripoli, LY");
        cellModel.setPrice("$330");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS006");
        cellModel.setCpu("2x Intel Xeon");
        cellModel.setFreq("E5530 2.40ghz");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 500GB SSD");
        cellModel.setNetwork("Unltd @ 10Mbps (international) + Unltd @ 1Gbps (local)");
        cellModel.setCollocation("Nairobi, KE");
        cellModel.setPrice("$450");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS007");
        cellModel.setCpu("2x Intel Xeon");
        cellModel.setFreq("E5530 2.40ghz");
        cellModel.setRam("16GB");
        cellModel.setDisk("1x 500GB SSD");
        cellModel.setNetwork("Unltd @ 10Mbps (international) + Unltd @ 1Gbps (local)");
        cellModel.setCollocation("Nairobi, KE");
        cellModel.setPrice("$500");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS008");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230v2 3.30ghz");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 500GB");
        cellModel.setNetwork("100Mbps");
        cellModel.setCollocation("Tunis, TN");
        cellModel.setPrice("$500");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS009");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E5-2620 2.4ghz");
        cellModel.setRam("64GB");
        cellModel.setDisk("3x 1000GB");
        cellModel.setNetwork("6TB @ 100Mbps");
        cellModel.setCollocation("Johannesburg, ZA");
        cellModel.setPrice("$500");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("AFDS010");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230 3.20ghz");
        cellModel.setRam("8GB");
        cellModel.setDisk("2x 500GB");
        cellModel.setNetwork("7TB @ 1Gbps");
        cellModel.setCollocation("Tripoli, LY");
        cellModel.setPrice("$400");
        userInfoList.add(cellModel);
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
        list.add(new ColumnHeaderModel("Core/Freq."));
        list.add(new ColumnHeaderModel("Ram"));
        list.add(new ColumnHeaderModel("Disk"));
        list.add(new ColumnHeaderModel("Network/Bandwidth"));
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
            list.add(new CellModel("1-" + i, userInfo.getModel()));
            list.add(new CellModel("2-" + i, userInfo.getCpu()));
            list.add(new CellModel("3-" + i, userInfo.getFreq()));
            list.add(new CellModel("4-" + i, userInfo.getRam()));
            list.add(new CellModel("5-" + i, userInfo.getDisk()));
            list.add(new CellModel("6-" + i, userInfo.getNetwork()));
            list.add(new CellModel("7-" + i, userInfo.getCollocation()));
            list.add(new CellModel("8-" + i, userInfo.getPrice()));

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
