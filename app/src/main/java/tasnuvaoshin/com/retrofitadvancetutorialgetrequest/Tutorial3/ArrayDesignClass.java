package tasnuvaoshin.com.retrofitadvancetutorialgetrequest.Tutorial3;

import java.util.List;

import tasnuvaoshin.com.retrofitadvancetutorialgetrequest.ObjectDataClass;

public class ArrayDesignClass {
    private List<ObjectDesignClass> data;

    public List<ObjectDesignClass> getData() {
        return data;
    }

    public void setData(List<ObjectDesignClass> data) {
        this.data = data;
    }

    public ArrayDesignClass() {
    }

    public ArrayDesignClass(List<ObjectDesignClass> data) {
        this.data = data;
    }
}
