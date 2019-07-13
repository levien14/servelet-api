package gamemanager.jsonObject;

import java.lang.reflect.Field;
import java.util.HashMap;

public class JsonObjectHandle {
    private int status;
    private String message;
    private Object data;

    public void setValues(int status, String message,Object data){
        this.status = status;
        this.message = message;
        this.data = data;
//        try {
//        Field[] fields = datas.getClass().getDeclaredFields();
//        for (int i = 0; i < fields.length ; i++) {
//            fields[i].setAccessible(true);
//            this.data.put(fields[i].getName(),fields[i].get(datas));
//        }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
