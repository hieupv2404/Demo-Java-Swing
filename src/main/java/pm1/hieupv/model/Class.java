package pm1.hieupv.model;


import java.io.Serializable;

public class Class implements Serializable {
    private String msl;
    private String name;
    private String gvcn;

    public Class() {
    }

    public String getMsl() {
        return msl;
    }

    public void setMsl(String msl) {
        this.msl = msl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGvcn() {
        return gvcn;
    }

    public void setGvcn(String gvcn) {
        this.gvcn = gvcn;
    }

    public int getColumnCount (){
        return getClass().getDeclaredFields().length;
    }
}
