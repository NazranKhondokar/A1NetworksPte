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
public class EuropeFragment extends Fragment {

    private static final String TAG = EuropeFragment.class.getSimpleName();
    private CloudServer cellModel = new CloudServer();
    private com.evrencoskun.tableview.TableView mTableView;
    private MyTableAdapter mTableAdapter;

    // For TableView
    private List<List<CellModel>> mCellList;
    private List<ColumnHeaderModel> mColumnHeaderList;
    private List<RowHeaderModel> mRowHeaderList;
    private List<CloudServer> userInfoList;

    public EuropeFragment() {
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
        cellModel.setModel("EUDS001");
        cellModel.setCpu("Intel Core i7");
        cellModel.setFreq("7700K 4.20GHZ");
        cellModel.setRam("32GB");
        cellModel.setDisk("2x 1TB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Dusseldorf, DE");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS002");
        cellModel.setCpu("AMD Opteron");
        cellModel.setFreq("3365 2.30GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 1TB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Dusseldorf, DE");
        cellModel.setPrice("$150");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS003");
        cellModel.setCpu("Intel Atom");
        cellModel.setFreq("S1260 2.00GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 500GB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Dusseldorf, DE");
        cellModel.setPrice("$130");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS004");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230V2 3.30GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 120GB SSD");
        cellModel.setNetwork("5TB @ 1Gbps");
        cellModel.setCollocation("Amsterdam, NL");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS005");
        cellModel.setCpu("Intel Atom");
        cellModel.setFreq("C2350 1.70GHZ + KVM");
        cellModel.setRam("4GB");
        cellModel.setDisk("1x 500GB");
        cellModel.setNetwork("Unltd @ 2.5Gbps");
        cellModel.setCollocation("Amsterdam, NL");
        cellModel.setPrice("$100");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS006");
        cellModel.setCpu("Intel Core i5");
        cellModel.setFreq("3470 3.20GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 2TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Chisinau, MD");
        cellModel.setPrice("$100");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS007");
        cellModel.setCpu("Intel Core i3");
        cellModel.setFreq("4130 3.40GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("2x 1TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Chisinau, MD");
        cellModel.setPrice("$180");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS008");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230V2 3.30GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 120GB SSD");
        cellModel.setNetwork("5TB @ 1Gbps");
        cellModel.setCollocation("Brussels, BE");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS009");
        cellModel.setCpu("2x AMD Opteron");
        cellModel.setFreq("4130 2.60GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 1000GB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Kiev, UA");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS010");
        cellModel.setCpu("Intel Core i7");
        cellModel.setFreq("7700 3.60GHZ");
        cellModel.setRam("32GB");
        cellModel.setDisk("1x 2TB");
        cellModel.setNetwork("50TB @ 1Gbps");
        cellModel.setCollocation("Milan, IT");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS011");
        cellModel.setCpu("2x Intel Xeon");
        cellModel.setFreq("X5670 2.93GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 300GB SAS 10K");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Kristiansand, NO");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS012");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("5140 2.33GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1x 1TB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Tallinn, EE");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS013");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1245V6 3.70GHZ");
        cellModel.setRam("32GB");
        cellModel.setDisk("2x 2TB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Frankfurt, DE");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS014");
        cellModel.setCpu("Intel Core i3");
        cellModel.setFreq("6100 3.70GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 500GB");
        cellModel.setNetwork("5TB @ 1Gbps");
        cellModel.setCollocation("Lisbon, PT");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS015");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("L5630 2.13GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 300GB SAS");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Helsinki, FI");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS016");
        cellModel.setCpu("Intel Core i3");
        cellModel.setFreq("2100 3.10GHZ");
        cellModel.setRam("4GB");
        cellModel.setDisk("1x 500GB");
        cellModel.setNetwork("Unltd. @ 100Mbps");
        cellModel.setCollocation("Luxembourg, LU");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS017");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("X3430 2.40GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("2x 500GB");
        cellModel.setNetwork("Unltd @ 100Mbps");
        cellModel.setCollocation("Kiev, UA");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS018");
        cellModel.setCpu("Intel Core i3");
        cellModel.setFreq("2100 3.10GHZ");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 120GB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Riga, LV");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS019");
        cellModel.setCpu("Intel Celeron");
        cellModel.setFreq("J1900 1.99GHZ");
        cellModel.setRam("16GB");
        cellModel.setDisk("1x 120GB SSD");
        cellModel.setNetwork("65TB @ 1Gbps");
        cellModel.setCollocation("Valencia, ES");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS020");
        cellModel.setCpu("Intel Atom");
        cellModel.setFreq("C2750 2.40GHZ + IPMI");
        cellModel.setRam("4GB");
        cellModel.setDisk("1x 128GB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Paris, FR");
        cellModel.setPrice("$99");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS021");
        cellModel.setCpu("Intel Core i3");
        cellModel.setFreq("530 2.93 GHZ + IPMI");
        cellModel.setRam("4GB");
        cellModel.setDisk("2x 1000GB HW RAID");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Paris, FR");
        cellModel.setPrice("$99");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS022");
        cellModel.setCpu("Intel Atom");
        cellModel.setFreq("C2750 2.40GHZ + IPMI");
        cellModel.setRam("8GB");
        cellModel.setDisk("1x 1000GB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Paris, FR");
        cellModel.setPrice("$130");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS023");
        cellModel.setCpu("2x Intel Xeon");
        cellModel.setFreq("E5620 2.40GHZ + IDRAC");
        cellModel.setRam("24GB");
        cellModel.setDisk("2x 2000GB HW RAID");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Paris, FR");
        cellModel.setPrice("$150");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS024");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230V3 3.30GHZ + ILO");
        cellModel.setRam("32GB");
        cellModel.setDisk("2x 2000GB HW RAID");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("Paris, FR");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS025");
        cellModel.setCpu("Xeon");
        cellModel.setFreq("E3-1270 V5 (4 CORES, 3.5GHZ)");
        cellModel.setRam("64GB");
        cellModel.setDisk("4x 250GB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("London, UK");
        cellModel.setPrice("$250");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS026");
        cellModel.setCpu("Single Xeon");
        cellModel.setFreq("E5-2630 V4 (10 CORE, 3.1 GHZ)");
        cellModel.setRam("64GB");
        cellModel.setDisk("12x 2TB SATA HDD 7200rpm 3.5");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("London, UK");
        cellModel.setPrice("$400");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS027");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("X3210 2.13GHZ (NO KVM)");
        cellModel.setRam("8GB");
        cellModel.setDisk("2x 120GB SSD");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("London, UK");
        cellModel.setPrice("$200");
        userInfoList.add(cellModel);

        cellModel = new CloudServer();
        cellModel.setModel("EUDS028");
        cellModel.setCpu("Intel Xeon");
        cellModel.setFreq("E3-1230 3.20GHZ + KVM");
        cellModel.setRam("16GB");
        cellModel.setDisk("2x 2TB");
        cellModel.setNetwork("Unltd @ 1Gbps");
        cellModel.setCollocation("London, UK");
        cellModel.setPrice("$230");
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