package com.example.softuiexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.softuiexample.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ActivityListBinding ui;
    private ListAdapter adapter;
    private List<EmployeeList> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = DataBindingUtil.setContentView(ListActivity.this, R.layout.activity_list);
        addData();
        initUi();
    }

    private void addData() {
        employeeList = new ArrayList<>();

        EmployeeList emp1 = new EmployeeList();

        emp1.setName("Umesh Kumar");
        emp1.setDesignation("Technical Architect");
        emp1.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp1);

        EmployeeList emp2 = new EmployeeList();
        emp2.setName("Ravi Shankar Singh");
        emp2.setDesignation("Sr. Android Developer| Flutter Developer| Blogger");
        emp2.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp2);

        EmployeeList emp3 = new EmployeeList();
        emp3.setName("Chandravir Singh");
        emp3.setDesignation("Sr. Android Developer");
        emp3.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp3);

        EmployeeList emp4 = new EmployeeList();
        emp4.setName("Sumit Singh");
        emp4.setDesignation("Android Developer");
        emp4.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp4);

        EmployeeList emp5 = new EmployeeList();
        emp5.setName("Nishu Singh");
        emp5.setDesignation("Android Developer");
        emp5.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp5);

        EmployeeList emp6 = new EmployeeList();
        emp6.setName("Ashish Sharma");
        emp6.setDesignation("Android Developer");
        emp6.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp6);


        EmployeeList emp7 = new EmployeeList();
        emp7.setName("Saurav Bansal");
        emp7.setDesignation("Android Developer");
        emp7.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp7);

        EmployeeList emp8 = new EmployeeList();
        emp8.setName("Rajni Srivastava");
        emp8.setDesignation("Android Developer");
        emp8.setProfileImage(R.drawable.test_thumb);
        employeeList.add(emp8);

    }

    private void initUi() {
        adapter = new ListAdapter(this);
        ui.recyclerView.setHasFixedSize(true);//every item of the RecyclerView has a fix size
        ui.recyclerView.setAdapter(adapter);
        adapter.setData(employeeList);
    }
}
