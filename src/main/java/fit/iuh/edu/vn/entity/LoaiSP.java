package fit.iuh.edu.vn.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loai_sp")
public class LoaiSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenloaisp")
    private String tenLoaiSP;

    @OneToMany(mappedBy = "loaiSP")
    private List<SanPham> sanPhams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    public LoaiSP() {
    }

    public LoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    @Override
    public String toString() {
        return "LoaiSP{" +
                "id=" + id +
                ", tenLoaiSP='" + tenLoaiSP + '\'' +
                ", sanPhams=" + sanPhams +
                '}';
    }
}
