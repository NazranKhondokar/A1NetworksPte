package com.maxxitsolution.a1networkspte.DedicatedTabbedFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxxitsolution.a1networkspte.tableview.DedicatedServerTableViewListener;
import com.maxxitsolution.a1networkspte.ModelClass.CloudServer;

import com.maxxitsolution.a1networkspte.tableview.MyTableAdapter;
import com.maxxitsolution.a1networkspte.tableview.model.CellModel;
import com.maxxitsolution.a1networkspte.tableview.model.ColumnHeaderModel;
import com.maxxitsolution.a1networkspte.tableview.model.RowHeaderModel;

import com.maxxitsolution.a1networkspte.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class USAFragment extends Fragment {

    private static final String TAG = USAFragment.class.getSimpleName();
    private CloudServer cellModel = new CloudServer();
    private com.evrencoskun.tableview.TableView mTableView;
    private MyTableAdapter mTableAdapter;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<CloudServer> userInfoList;

    public USAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_south, container, false);
        mTableView = view.findViewById(R.id.my_TableView);

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
        cellModel = new CloudServer();
        cellModel.setModel("USDS001");
        cellModel.setCpu("HP DL120G7/Intel Xeon");
        cellModel.setFreq(" ");
        cellModel.setRam("32GB DDR3");
        cellModel.setDisk("4x 1TB SATA2");
        cellModel.setNetwork("100 Mbps");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("USDS002");
        cellModel.setCpu("HP DL120G6/Intel Xeon X3440");
        cellModel.setFreq(" ");
        cellModel.setRam("16GB DDR3");
        cellModel.setDisk("4x 2TB SATA");
        cellModel.setNetwork("1 Gbps 100TB");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("USDS003");
        cellModel.setCpu("HP DL120G6/Intel Xeon X3440");
        cellModel.setFreq(" ");
        cellModel.setRam("16GB DDR3");
        cellModel.setDisk("4x 2TB SATA");
        cellModel.setNetwork("1 Gbps 100TB");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$210");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("USDS004");
        cellModel.setCpu("HP DL120G7/Intel Xeon E3-1230");
        cellModel.setFreq(" ");
        cellModel.setRam("16GB DDR3");
        cellModel.setDisk("4x 2TB SATA");
        cellModel.setNetwork("1 Gbps 100TB");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$220");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("USDS005");
        cellModel.setCpu("HP DL120G7/Intel Xeon E3-1230");
        cellModel.setFreq(" ");
        cellModel.setRam("16GB DDR3");
        cellModel.setDisk("4x 2TB SATA");
        cellModel.setNetwork("1 Gbps 100TB");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$230");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("USDS006");
        cellModel.setCpu("HP DL120G7/Intel Xeon E3-1230");
        cellModel.setFreq(" ");
        cellModel.setRam("16GB DDR3");
        cellModel.setDisk("4x 2TB SATA");
        cellModel.setNetwork("1 Gbps 100TB");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$240");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("USDS007");
        cellModel.setCpu("HP DL120G7/Intel Xeon E3-1230");
        cellModel.setFreq(" ");
        cellModel.setRam("32GB DDR3");
        cellModel.setDisk("4x 2TB SATA");
        cellModel.setNetwork("1 Gbps 100TB");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$250");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("USDS008");
        cellModel.setCpu("HP DL180G6/2x Intel Xeon E5620");
        cellModel.setFreq(" ");
        cellModel.setRam("64GB DDR3");
        cellModel.setDisk("4x 2TB SATA");
        cellModel.setNetwork("1 Gbps 100TB");
        cellModel.setCollocation("USA");
        cellModel.setPrice("$300");
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
            list.add(new CellModel("3-" + i, userInfo.getRam()));
            list.add(new CellModel("4-" + i, userInfo.getDisk()));
            list.add(new CellModel("5-" + i, userInfo.getNetwork()));
            list.add(new CellModel("6-" + i, userInfo.getCollocation()));
            list.add(new CellModel("7-" + i, userInfo.getPrice()));

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
