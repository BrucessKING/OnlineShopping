package top.bigking.entity;

public class PermissionApi {
    private Integer id;

    private Integer psId;

    private String psApiService;

    private String psApiAction;

    private String psApiPath;

    private Integer psApiOrder;

    private Permission permission;

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPsId() {
        return psId;
    }

    public void setPsId(Integer psId) {
        this.psId = psId;
    }

    public String getPsApiService() {
        return psApiService;
    }

    public void setPsApiService(String psApiService) {
        this.psApiService = psApiService == null ? null : psApiService.trim();
    }

    public String getPsApiAction() {
        return psApiAction;
    }

    public void setPsApiAction(String psApiAction) {
        this.psApiAction = psApiAction == null ? null : psApiAction.trim();
    }

    public String getPsApiPath() {
        return psApiPath;
    }

    public void setPsApiPath(String psApiPath) {
        this.psApiPath = psApiPath == null ? null : psApiPath.trim();
    }

    public Integer getPsApiOrder() {
        return psApiOrder;
    }

    public void setPsApiOrder(Integer psApiOrder) {
        this.psApiOrder = psApiOrder;
    }

    @Override
    public String toString() {
        return "PermissionApi{" +
                "id=" + id +
                ", psId=" + psId +
                ", psApiService='" + psApiService + '\'' +
                ", psApiAction='" + psApiAction + '\'' +
                ", psApiPath='" + psApiPath + '\'' +
                ", psApiOrder=" + psApiOrder +
                ", permission=" + permission +
                '}';
    }
}