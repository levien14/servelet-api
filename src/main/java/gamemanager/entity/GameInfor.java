package gamemanager.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Calendar;

@Entity

public class GameInfor {
    @Id
    private long id;
    @Index
    private String name;
    @Index
    private String kind;
    @Index
    private double price;
//    @Index
//    private String imgURL;
    @Index
    private String description;
    @Index
    private long release;
    @Index
    private long createdAT;
    @Index
    private long updatedAT;
    @Index
    private long deletedAT;
    @Index
    private int status;

    public GameInfor() {
        this.id = Calendar.getInstance().getTimeInMillis();
        this.createdAT = Calendar.getInstance().getTimeInMillis();
        this.updatedAT = Calendar.getInstance().getTimeInMillis();
        this.deletedAT = Calendar.getInstance().getTimeInMillis();
        this.status = Status.ACTIVE.getValue();
    }

    public GameInfor(long id, String name, String kind, double price, String description, long release, long createdAT, long updatedAT, long deletedAT) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.description = description;
        this.release = release;
        this.createdAT = createdAT;
        this.updatedAT = updatedAT;
        this.deletedAT = deletedAT;
    }

    public enum  Status{
        ACTIVE(1), DEACTIVE(0);
        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRelease() {
        return release;
    }

    public void setRelease(long release) {
        this.release = release;
    }

    public long getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(long createdAT) {
        this.createdAT = createdAT;
    }

    public long getUpdatedAT() {
        return updatedAT;
    }

    public void setUpdatedAT(long updatedAT) {
        this.updatedAT = updatedAT;
    }

    public long getDeletedAT() {
        return deletedAT;
    }

    public void setDeletedAT(long deletedAT) {
        this.deletedAT = deletedAT;
    }


}
