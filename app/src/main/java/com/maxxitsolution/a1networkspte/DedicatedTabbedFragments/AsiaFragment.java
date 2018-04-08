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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsiaFragment extends Fragment {

    private static final String TAG = AsiaFragment.class.getSimpleName();
    private CloudServer cellModel = new CloudServer();
    private com.evrencoskun.tableview.TableView mTableView;
    private MyTableAdapter mTableAdapter;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<CloudServer> userInfoList;

    public AsiaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_asia, container, false);
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
        cellModel.setModel("ASDS001");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("L5520 2.27GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 1TB");
        cellModel.setNetwork("10Mbps On 1Gbps (95th Percentile)");
        cellModel.setCollocation("Seoul, KR");
        cellModel.setPrice("$180");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS002");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("L5520 2.27GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 128GB SSD");
        cellModel.setNetwork("10Mbps On 1Gbps (95th Percentile)");
        cellModel.setCollocation("Seoul, KR");
        cellModel.setPrice("$180");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS003");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("L3426 1.87GHZ + KVM");
        cellModel.setRam("4GB");
        cellModel.setDisk("2X 500GB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Hong Kong, HK");
        cellModel.setPrice("$199");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS004");
        cellModel.setCpu("Hong Kong");
        cellModel.setFreq("HK");
        cellModel.setRam("4GB");
        cellModel.setDisk("1X 1TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Kuala Lumpur, MY");
        cellModel.setPrice("$180");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS005");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1220V2 3.10GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 120GB SSD");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Bursa, TR");
        cellModel.setPrice("$190");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS006");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1220V2 3.10GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 120GB SSD");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Izmir, TR");
        cellModel.setPrice("$190");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS007");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1220V2 3.10GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 120GB SSD");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Bursa, TR");
        cellModel.setPrice("$190");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS008");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1220V2 3.10GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 120GB SSD");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Izmir, TR");
        cellModel.setPrice("$190");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS009");
        cellModel.setCpu("Intel Pentium");
        cellModel.setFreq("G850 2.90GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("4X 1TB");
        cellModel.setNetwork("10TB @ 100Mbps");
        cellModel.setCollocation("Singapore, SG");
        cellModel.setPrice("$185");
        userInfoList.add(cellModel);

/*        cellModel = new CloudServer();
        cellModel.setModel("ASDS010");
        cellModel.setCpu("Intel Pentium");
        cellModel.setFreq("G850 2.90GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk(" ");
        cellModel.setNetwork("10TB @ 100Mbps");
        cellModel.setCollocation("Singapore, SG");
        cellModel.setPrice("$190");
        userInfoList.add(cellModel);*/

        cellModel = new CloudServer();
        cellModel.setModel("ASDS011");
        cellModel.setCpu("Intel Celeron");
        cellModel.setFreq("J1800 2.41GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1X 500GB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Sapporo, JP");
        cellModel.setPrice("$195");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS012");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1220 3.10GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("2X 1TB");
        cellModel.setNetwork("10TB @ 100Mbps");
        cellModel.setCollocation("Singapore, SG");
        cellModel.setPrice("$230");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS013");
        cellModel.setCpu("Intel Celeron");
        cellModel.setFreq("J1800 2.41GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1X 120GB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Sapporo, JP");
        cellModel.setPrice("$220");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS014");
        cellModel.setCpu("Intel Celeron");
        cellModel.setFreq("J3060 1.60GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1X 120GB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Sapporo, JP");
        cellModel.setPrice("$220");
        userInfoList.add(cellModel);

/*        cellModel = new CloudServer();
        cellModel.setModel("ASDS015");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("X3430 2.40GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1X 500GB");
        cellModel.setNetwork("Unltd @ 20Mbps");
        cellModel.setCollocation("Jerusalem, IL");
        cellModel.setPrice("");
        userInfoList.add(cellModel);*/

        cellModel = new CloudServer();
        cellModel.setModel("ASDS016");
        cellModel.setCpu("Intel Core I3");
        cellModel.setFreq("4330 3.50GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1X 500GB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Bangkok, TH");
        cellModel.setPrice("$295");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS017");
        cellModel.setCpu("Intel Core I3");
        cellModel.setFreq("4130 3.40GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1X 1TB");
        cellModel.setNetwork("1.5TB @ 100Mbps");
        cellModel.setCollocation("Taipei, TW");
        cellModel.setPrice("$300");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS018");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230V3 3.30GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 1TB");
        cellModel.setNetwork("1TB @ 100Mbps");
        cellModel.setCollocation("Pune, IN");
        cellModel.setPrice("$350");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS019");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230 3.20GHZ");
        cellModel.setRam("32GB");
        cellModel.setDisk("2X 2TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Kuala Lumpur, MY");
        cellModel.setPrice("$320");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS020");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230 3.20GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("1X 1TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Hanoi, VN");
        cellModel.setPrice("$350");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS021");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E5300 2.60GHZ");
        cellModel.setRam("2GB");
        cellModel.setDisk("1X 250GB");
        cellModel.setNetwork("Unltd @ 5Mbps");
        cellModel.setCollocation("Chongqing, CN");
        cellModel.setPrice("$350");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("ASDS022");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("L5420 2.54GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1X 1000GB");
        cellModel.setNetwork("Unltd. @ 5Mbps");
        cellModel.setCollocation("Wuxi, CN");
        cellModel.setPrice("$320");
        userInfoList.add(cellModel);

/*        cellModel = new CloudServer();
        cellModel.setModel("ASDS023");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("X3440 2.53GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk(" ");
        cellModel.setNetwork("10TB @ 100Mbps");
        cellModel.setCollocation("Istanbul, TR");
        cellModel.setPrice("$350");
        userInfoList.add(cellModel);*/
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
