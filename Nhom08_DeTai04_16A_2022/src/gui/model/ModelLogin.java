package gui.model;

public class ModelLogin {
    private String maNV;
    private String password;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModelLogin(String maNV, String password) {
        this.maNV = maNV;
        this.password = password;
    }

    public ModelLogin() {
    }
}
