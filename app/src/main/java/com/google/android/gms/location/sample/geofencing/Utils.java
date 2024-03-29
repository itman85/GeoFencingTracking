package com.google.android.gms.location.sample.geofencing;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {
    public static final String KEY_REMOVE_LIST = "remove";
    public static final String KEY_ADD_NEW_LIST = "add_new";
    public static final String GEO_ID_PLIT_CHAR = "_";
    public static void appendLog(String tag,String type,String text)
    {
        Thread task = new Thread(() -> {
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String dateFormat = s.format(new Date());

            File logFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/testlocation/geo/mylog_"+tag+".txt");
            if (!logFile.exists())
            {
                try
                {
                    logFile.createNewFile();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try
            {
                //BufferedWriter for performance, true to set append to file flag
                BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
                buf.append(dateFormat + "  " + type+ "/" + tag + ": "+text);
                buf.newLine();
                buf.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        task.start();

    }

    public static List<GeoFencingPlaceModel> createListGeoFencingPlaces(){
        List<GeoFencingPlaceModel> geoList = new ArrayList<>();
        geoList.add(new GeoFencingPlaceModel(10.776677, 106.683699,100,"CMT8_DBP"));
        geoList.add(new GeoFencingPlaceModel(10.775034, 106.686850,100,"CMT8_NDC"));
        geoList.add(new GeoFencingPlaceModel(10.772703, 106.691175,200,"CMT8_BTX"));

        geoList.add(new GeoFencingPlaceModel(10.775911, 106.682737,100,"NTHien_DBPhu"));
        geoList.add(new GeoFencingPlaceModel(10.771550, 106.685651,50,"NTHhien_VVTan"));
        geoList.add(new GeoFencingPlaceModel(10.770002, 106.688607,100,"BTXuan_TTTung"));
        geoList.add(new GeoFencingPlaceModel(10.767928, 106.695467,200,"NTHoc_THDao"));
        geoList.add(new GeoFencingPlaceModel(10.759683, 106.698477,100,"HDieu_KHoi"));
        geoList.add(new GeoFencingPlaceModel(10.753596, 106.702088,200,"CauKTe"));
        geoList.add(new GeoFencingPlaceModel(10.745254, 106.701887,100,"NHTho_D15"));
        geoList.add(new GeoFencingPlaceModel(10.745970, 106.708287,100,"Home"));

        geoList.add(new GeoFencingPlaceModel(10.778449, 106.679971,200,"Workplace"));
        geoList.add(new GeoFencingPlaceModel(10.761632, 106.689747,200,"THDao_TDXu"));
        geoList.add(new GeoFencingPlaceModel(10.756505, 106.685195,100,"THDao_NVCu"));
        geoList.add(new GeoFencingPlaceModel(10.738842, 106.689521,100,"VXoay_TS"));
        geoList.add(new GeoFencingPlaceModel(10.738688, 106.691259,200,"ChipH_TS"));
        geoList.add(new GeoFencingPlaceModel(10.755289, 106.680659,200,"HKBike_THDao"));
        geoList.add(new GeoFencingPlaceModel(10.732346, 106.705787,500,"TiemBank_PMH"));
        geoList.add(new GeoFencingPlaceModel(10.769965, 106.694273,100,"NTNghia_LeLai"));
        geoList.add(new GeoFencingPlaceModel(10.777699, 106.681903,100,"VXoay_DanChu"));

        return geoList;
    }
}
