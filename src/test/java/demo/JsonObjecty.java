package demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class JsonObjecty {
    private int status;
    private String message;
    private Object data;

    public void setValues(int status, String message, Object datas){
        this.status = status;
        this.message = message;
        this.data = datas;
        //this.data = new ArrayList<>();
//        HashMap<String ,Object> hashMapData = new HashMap<>();
//
//
//        try {
//            for (int i = 0; i < datas.size() ; i++) {
//                Field[] fields = datas.get(i).getClass().getDeclaredFields();
//                for (int j = 0; j < fields.length ; i++) {
//                    fields[i].setAccessible(true);
//                    hashMapData.put(fields[j].getName(),fields[j].get(datas.get(i)));
//                    this.data.add(hashMapData);
//                }}}
//
//             catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//
//    public ArrayList<HashMap<String, Object>> getData() {
//        return data;
//    }
//
//    public void setData(ArrayList<HashMap<String, Object>> data) {
//        this.data = data;
//    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
