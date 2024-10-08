package com.example.prarrambh;

public class eventData1 {
    private String prn;
    private String prrs;
    private String subprn;

    private String uname;
    private String ucontact;
    private String ucollege;
    private Boolean show;
    private String id;

    int img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public eventData1(String prn, String uname, String ucontact, String ucollege, String prrs, String id, Boolean show) {
this.id = id;
        this.prn = prn;
        this.uname = uname;
        this.ucontact = ucontact;
        this.ucollege = ucollege;
        this.prrs = prrs;
        this.show = show;
    }

    public String getUname() {
        return uname;
    }

    public String getUcontact() {
        return ucontact;
    }

    public String getUcollege() {
        return ucollege;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    eventData1(String prn, String prrs, String subprn, int img){
        this.prn = prn;
        this.prrs = prrs;
        this.subprn = subprn;
        this.img = img;
    }

    public String getPrn() {
        return prn;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public String getPrrs() {
        return prrs;
    }

    public void setPrrs(String prrs) {
        this.prrs = prrs;
    }

    public String getSubprn() {
        return subprn;
    }

    public void setSubprn(String subprn) {
        this.subprn = subprn;
    }
}
