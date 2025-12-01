import java.io.Serializable;

public abstract class Nguoi implements Serializable {
    protected String hoTen;
    protected String soDinhDanh;
    protected String diaChi;
    protected String email;
    protected String gioiTinh;

    public Nguoi() {}

    public Nguoi(String hoTen, String soDinhDanh, String diaChi, String email, String gioiTinh) {
        this.hoTen = hoTen;
        this.soDinhDanh = soDinhDanh;
        this.diaChi = diaChi;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }

    public String getHoTen() { 
        return hoTen; 
    }
    public void setHoTen(String hoTen) {
         this.hoTen = hoTen; 
        }

    public String getSoDinhDanh() {
         return soDinhDanh; 
        }
    public void setSoDinhDanh(String soDinhDanh) {
         this.soDinhDanh = soDinhDanh;
         }

    public String getDiaChi() { 
        return diaChi; 
    }
    public void setDiaChi(String diaChi) { 
        this.diaChi = diaChi; 
    }

    public String getEmail() {
         return email; 
        }
    public void setEmail(String email) {
         this.email = email; 
        }

    public String getGioiTinh() {
         return gioiTinh; 
        }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public abstract void xuatThongTin();
}
