package com.example.attendance_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run();
        Button btn=findViewById(R.id.switch_type_btn);
        barChart=findViewById(R.id.bar_chart);
        if (getIntent().hasExtra("month_wise")){
            btn.setText("MONTH WISE");
            setMonthWise();
        }
        else {
            btn.setText("SUBJECT WISE");
            set_subject_wist_chart();
        }
    }
    public void set_subject_wist_chart(){
        List<BarEntry> entries1 = new ArrayList<>();
        entries1.add(new BarEntry(0f, 30));
        entries1.add(new BarEntry(1f, 70));
        entries1.add(new BarEntry(2f, 55));
        entries1.add(new BarEntry(3f, 40));
        entries1.add(new BarEntry(4f, 80));
        entries1.add(new BarEntry(5f, 95));
        List<String> labels = new ArrayList<>();
        // Add the time label for the x-axis
        labels.add("401 : COA");
        labels.add("402 : TOC");
        labels.add("403 : DAA");
        labels.add("404 : OOPS");
        labels.add("405 : SNS");
        labels.add("406 : OE");
        BarDataSet set1 = new BarDataSet(entries1, "Data Set 1");
        set1.setColors(Color.parseColor("#99E5E2"),Color.parseColor("#9EE599"),Color.parseColor("#E5C199"),Color.parseColor("#99C6E5"),Color.parseColor("#F2BDD6"),Color.parseColor("#D7B8AB"));
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        BarData barData=new BarData(set1);
        barChart.setData(barData);
        float groupSpace = 0.4f; // Space between groups
        float barSpace = 0.06f; // Space between individual bars within a group
        float barWidth = 0.4f;
        barData.setBarWidth(barWidth);
        barData.setValueTextColor(Color.WHITE);
        barChart.setDragEnabled(true);
        //barData.groupBars(0, groupSpace, barSpace);
        
        barChart.setDrawGridBackground(false);
        barChart.getDescription().setEnabled(false);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setDrawAxisLine(true);
        barChart.getAxisRight().setEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.getXAxis().setTextSize(12);
        barChart.getXAxis().setTextColor(Color.WHITE);
        barChart.getXAxis().setSpaceMin(20f);
        barChart.getAxisRight().setEnabled(false);
        barChart.setFitBars(true);
        barChart.invalidate();
        barChart.animateY(1000);
        
        //padding
        barChart.setExtraTopOffset(10f);
        barChart.setExtraBottomOffset(15f);
        barChart.setExtraLeftOffset(20f);
        barChart.setExtraRightOffset(10f);
        
        //XAxis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        barChart.getDescription().setTextColor(Color.WHITE);
        barChart.getLegend().setTextColor(Color.WHITE);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(false);
        xAxis.setGranularity(1f); // Display one label per data point
        xAxis.setAxisMinimum(-0.5f);
        xAxis.setTextColor(Color.WHITE);
    
        YAxis yAxis=barChart.getAxisLeft();
        yAxis.setDrawGridLines(true);
        yAxis.setDrawAxisLine(true);
        yAxis.setTextSize(12);
        yAxis.setTextColor(Color.GREEN);
    
    
    
    
    
        barChart.resetZoom();
        barChart.fitScreen();
        barChart.setVisibleXRangeMaximum(5);
        barChart.moveViewToX(0);
        
//        List<BarEntry> list=new ArrayList<>();
//        list.add(new BarEntry(0f,65f));
//        list.add(new BarEntry(1f,80f));
//        list.add(new BarEntry(2f,30f));
//        list.add(new BarEntry(3f,45f));
//        list.add(new BarEntry(4f,100f));
//        List<BarEntry> list2=new ArrayList<>();
//        list2.add(new BarEntry(0f,15f));
//        list2.add(new BarEntry(1f,30f));
//        list2.add(new BarEntry(2f,40f));
//        list2.add(new BarEntry(3f,75f));
//        list2.add(new BarEntry(4f,60f));
//        List<String> labels_list=new ArrayList<>();
//        BarDataSet barDataSet=new BarDataSet(list,"");
//        barDataSet.setColors(Color.GREEN,Color.RED,Color.BLUE,Color.BLACK,Color.YELLOW);
//        barDataSet.setValueTextColor(Color.GREEN);
//        barDataSet.setValueTextSize(12);
//        BarDataSet barDataSet1=new BarDataSet(list2,"");
//        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
//        barDataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
//        BarData barData=new BarData(barDataSet,barDataSet1);
//        barData.groupBars(0,0.02f,0.06f);
//        barChart.setData(barData);
//        XAxis xAxis=barChart.getXAxis();
//        labels_list.add("sub1");
//        labels_list.add("sub2");
//        labels_list.add("sub3");
//        labels_list.add("sub4");
//        labels_list.add("sub5");
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels_list));
//        xAxis.setDrawGridLines(false);
//        xAxis.setDrawAxisLine(true);
//        xAxis.setTextSize(12);
//        xAxis.setTextColor(Color.GREEN);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//
//        YAxis yAxis=barChart.getAxisLeft();
//        yAxis.setDrawGridLines(true);
//        yAxis.setDrawAxisLine(true);
//        yAxis.setTextSize(12);
//        yAxis.setTextColor(Color.GREEN);
//        barChart.getAxisRight().setEnabled(false);
//        barChart.setFitBars(true);
    }
    public void run(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    private void setMonthWise() {
        List<BarEntry> entries1 = new ArrayList<>();
        List<BarEntry> entries2 = new ArrayList<>();
        List<BarEntry> entries3 = new ArrayList<>();
        List<BarEntry> entries4 = new ArrayList<>();
        
        // Add sample data to entries1 and entries2
        entries1.add(new BarEntry(0f, 60));
        entries1.add(new BarEntry(1f, 70));
        entries1.add(new BarEntry(2f, 55));
        entries1.add(new BarEntry(3f, 95));
        
        entries2.add(new BarEntry(0f, 50));
        entries2.add(new BarEntry(1f, 65));
        entries2.add(new BarEntry(2f, 45));
        entries2.add(new BarEntry(3f, 65));
        
        entries3.add(new BarEntry(0f, 84));
        entries3.add(new BarEntry(1f, 60));
        entries3.add(new BarEntry(2f, 51));
        entries3.add(new BarEntry(3f, 70));
    
        entries4.add(new BarEntry(0f, 64));
        entries4.add(new BarEntry(1f, 80));
        entries4.add(new BarEntry(2f, 71));
        entries4.add(new BarEntry(3f, 90));
        
        List<String> labels = new ArrayList<>();
        // Add the time label for the x-axis
        labels.add("JANUARY");
        labels.add("FEBRUARY");
        labels.add("MARCH");
        labels.add("APRIL");
        
        BarDataSet set1 = new BarDataSet(entries1, "COA");
        set1.setColor(Color.BLUE);
        
        BarDataSet set2 = new BarDataSet(entries2, "TOC");
        set2.setColor(Color.RED);
        
        BarDataSet set3 = new BarDataSet(entries3, "DAA");
        set3.setColor(Color.GREEN);
        
        BarDataSet set4=new BarDataSet(entries4,"OOPS");
        
        float groupSpace = 0.4f; // Space between groups
        float barSpace = 0.06f; // Space between individual bars within a group
        float barWidth = 0.14f; // Width of each bar
        
        BarData barData = new BarData(set1, set2, set3, set4);
        
        barChart.setData(barData);
        
        int visibleRange = 2; // Set the desired visible range
        int dataCount = 4; // Update with the actual size of your data list
        
        barData.setBarWidth(barWidth);
        barData.setValueTextColor(Color.WHITE);
        barChart.setDragEnabled(true);
        barData.groupBars(0, groupSpace, barSpace);
        
        barChart.setDrawGridBackground(false);
        barChart.getDescription().setEnabled(false);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getXAxis().setDrawGridLines(true);
        barChart.getAxisRight().setEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.animateY(750);
        
        barChart.setNoDataTextColor(getResources().getColor(R.color.white));
        barChart.getAxisLeft().setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        
        // Set chart padding
        barChart.setExtraTopOffset(10f);
        barChart.setExtraBottomOffset(10f);
        barChart.setExtraLeftOffset(20f);
        barChart.setExtraRightOffset(10f);
        
        // Customize x-axis labels
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        
        xAxis.setGranularity(1f); // Display one label per data point
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(barData.getGroupWidth(groupSpace, barSpace) *4);
        xAxis.setTextColor(Color.WHITE);
        
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);
        leftAxis.setDrawGridLines(false);
        barChart.setFitBars(true);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setTextSize(12);
        leftAxis.setTextColor(Color.GREEN);
        barChart.getLegend().setTextColor(Color.WHITE);
        
        barChart.resetZoom();
        barChart.fitScreen();
        barChart.setVisibleXRangeMaximum(4);
        barChart.moveViewToX(0);
        barChart.invalidate();
    }
    
    public void change_type_btn(View view) {
        Button btn=view.findViewById(R.id.switch_type_btn);
        if(btn.getText().toString().equals("SUBJECT WISE")){
            Intent intent=new Intent(this,MainActivity.class);
            intent.putExtra("month_wise","v");
            startActivity(intent);
        }
        else {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            
        }
    }
}