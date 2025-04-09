package Model;

public class TaiKhoan {
    private int id;
    private String tenDangNhap ;
    private String matKhau;
    private String vaiTro;

    public TaiKhoan() {}

    public TaiKhoan(String tenDangNhap , String matKhau, String vaiTro) {
        this.tenDangNhap  = tenDangNhap ;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenNguoiDung() { return tenDangNhap ; }
    public void setTenNguoiDung(String tenNguoiDung) { this.tenDangNhap  = tenNguoiDung; }

    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }

    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }
}