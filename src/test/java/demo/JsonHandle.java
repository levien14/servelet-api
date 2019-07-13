package demo;

public class JsonHandle {
    private int status;
    private String mesaage;
    private Object data;

    public void setValues(int status, String massage, Object data){
        this.status = status;
        this.mesaage = mesaage;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMesaage() {
        return mesaage;
    }

    public void setMesaage(String mesaage) {
        this.mesaage = mesaage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
