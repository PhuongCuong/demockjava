package fit.iuh.edu.vn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tensp")
    private String tenSP;
    @Column(name = "dongia")
    private double donGia;

    @ManyToOne
    @JoinColumn(name = "loaisp_id")
    private LoaiSP loaiSP;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public LoaiSP getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(LoaiSP loaiSP) {
        this.loaiSP = loaiSP;
    }

    public SanPham() {
    }

    public SanPham(String tenSP, double donGia, LoaiSP loaiSP) {
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.loaiSP = loaiSP;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", tenSP='" + tenSP + '\'' +
                ", donGia=" + donGia +
                ", loaiSP=" + loaiSP +
                '}';
    }
}
