package tasnuvaoshin.com.retrofitadvancetutorialgetrequest;

import java.util.List;

public class OurMainDataClass {
    private List<ObjectDataClass> data;

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }

    public OurMainDataClass() {
    }

    public OurMainDataClass(List<ObjectDataClass> data) {
        this.data = data;
    }
}
