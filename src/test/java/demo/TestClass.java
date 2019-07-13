package demo;

import java.util.Calendar;

public class TestClass {
    private long id;
    private String name;
    private String description;

    public TestClass() {
        this.id = Calendar.getInstance().getTimeInMillis();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
