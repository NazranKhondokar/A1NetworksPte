package com.maxxitsolution.a1networkspte.DedicatedTabbedFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxxitsolution.a1networkspte.ModelClass.CloudServer;
import com.maxxitsolution.a1networkspte.tableview.DedicatedServerTableViewListener;
import com.maxxitsolution.a1networkspte.tableview.model.ColumnHeaderModel;
import com.maxxitsolution.a1networkspte.tableview.MyTableAdapter;
import com.maxxitsolution.a1networkspte.tableview.model.CellModel;
import com.maxxitsolution.a1networkspte.tableview.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SouthFragment extends Fragment {

    private static final String TAG = SouthFragment.class.getSimpleName();
    private CloudServer cellModel = new CloudServer();
    private com.evrencoskun.tableview.TableView mTableView;
    private MyTableAdapter mTableAdapter;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<CloudServer> userInfoList;

    public SouthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_south, container, false);
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
        cellModel = new CloudServer();
        cellModel.setModel("NADS001");
        cellModel.setCpu("Intel Core i3");
        cellModel.setFreq("2130 3.40GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 2TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Montreal, QC");
        cellModel.setPrice("$99");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS002");
        cellModel.setCpu("2x Intel Xeon");
        cellModel.setFreq("L5420 2.50GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("1x 500GB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Seattle, WA");
        cellModel.setPrice("$120");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS003");
        cellModel.setCpu("Intel Core i5");
        cellModel.setFreq("2300 2.80GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("1x 2TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Montreal, QC");
        cellModel.setPrice("$135");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS004");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3 1225V2 3.20GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 2TB");
        cellModel.setNetwork("Unltd @ 250Mbps");
        cellModel.setCollocation("Montreal, QC");
        cellModel.setPrice("$145");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS005");
        cellModel.setCpu("Intel Pentium");
        cellModel.setFreq("G6950 2.80GHZ");
        cellModel.setRam("4 GB");
        cellModel.setDisk("2x 120GB SSD");
        cellModel.setNetwork("100TB @ 1Gbps");
        cellModel.setCollocation("Washington, DC");
        cellModel.setPrice("$145");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS006");
        cellModel.setCpu("Intel Pentium");
        cellModel.setFreq("G6950 2.80GHZ");
        cellModel.setRam("4 GB");
        cellModel.setDisk("2x 1TB");
        cellModel.setNetwork("100TB @ 1Gbps");
        cellModel.setCollocation("Washington, DC");
        cellModel.setPrice("$145");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS007");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("W3520 2.67GHZ");
        cellModel.setRam("32 GB");
        cellModel.setDisk("2x 1TB");
        cellModel.setNetwork("Unltd @ 250Mbps");
        cellModel.setCollocation("Montreal, QC");
        cellModel.setPrice("$159");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS008");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3 1225V2 3.20GHZ");
        cellModel.setRam("32 GB");
        cellModel.setDisk("2x 1TB");
        cellModel.setNetwork("Unltd @ 250Mbps");
        cellModel.setCollocation("Montreal, QC");
        cellModel.setPrice("$159");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS009");
        cellModel.setCpu("I2x Intel Xeon");
        cellModel.setFreq("E3 1225V2 3.20GHZ");
        cellModel.setRam("72 GB");
        cellModel.setDisk("1x 1TB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Seattle, WA");
        cellModel.setPrice("$250");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS010");
        cellModel.setCpu("Intel Atom");
        cellModel.setFreq("C2550 2.40GHZ");
        cellModel.setRam("72 GB");
        cellModel.setDisk("1x 1TB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Seattle, WA");
        cellModel.setPrice("$250");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS011");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("X5650 2.67GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("1x 3TB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Seattle, WA");
        cellModel.setPrice("$210");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("NADS012");
        cellModel.setCpu("2x Intel Xeon");
        cellModel.setFreq("E5-2650 2.00GHZ L5520 2.26GHZ");
        cellModel.setRam("64 GB");
        cellModel.setDisk("1x 1TB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Seattle, WA");
        cellModel.setPrice("$225");
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
