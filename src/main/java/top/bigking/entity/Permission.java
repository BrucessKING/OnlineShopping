package top.bigking.entity;

public class Permission {
    private Short psId;

    private String psName;

    private short psPid;

    private String psC;

    private String psA;

    private String psLevel;

    public Short getPsId() {
        return psId;
    }

    public void setPsId(Short psId) {
        this.psId = psId;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName == null ? null : psName.trim();
    }

    public Short getPsPid() {
        return psPid;
    }

    public void setPsPid(Short psPid) {
        this.psPid = psPid;
    }

    public String getPsC() {
        return psC;
    }

    public void setPsC(String psC) {
        this.psC = psC == null ? null : psC.trim();
    }

    public String getPsA() {
        return psA;
    }

    public void setPsA(String psA) {
        this.psA = psA == null ? null : psA.trim();
    }

    public String getPsLevel() {
        return psLevel;
    }

    public void setPsLevel(String psLevel) {
        this.psLevel = psLevel == null ? null : psLevel.trim();
    }
}