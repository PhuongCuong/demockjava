package fit.iuh.edu.vn;

import fit.iuh.edu.vn.entity.LoaiSP;
import fit.iuh.edu.vn.entity.SanPham;
import fit.iuh.edu.vn.responsitory.LoaiSPResponsitory;
import fit.iuh.edu.vn.responsitory.SanPhamResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoCkApplication {

    @Autowired
    private LoaiSPResponsitory loaiSPResponsitory;
    @Autowired
    private SanPhamResponsitory sanPhamResponsitory;

    public static void main(String[] args) {
        SpringApplication.run(DemoCkApplication.class, args);
    }

//    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            LoaiSP loaiSP1 = new LoaiSP("Đồ dùng học tập");
            LoaiSP loaiSP2 = new LoaiSP("Đồ gia dụng");
            LoaiSP loaiSP3 = new LoaiSP("Đồ điện tử");

            List<LoaiSP> loaiSPS = new ArrayList<>();
            loaiSPS.add(loaiSP1);
            loaiSPS.add(loaiSP2);
            loaiSPS.add(loaiSP3);


            SanPham sanPham1 = new SanPham("sách",5000,loaiSP1);
            SanPham sanPham2 = new SanPham("Vở",3000,loaiSP1);
            SanPham sanPham3 = new SanPham("Bút",1000,loaiSP1);

            SanPham sanPham4 = new SanPham("Bếp ga",10000,loaiSP2);
            SanPham sanPham5 = new SanPham("Nồi",7000,loaiSP2);
            SanPham sanPham6 = new SanPham("Đũa",3000,loaiSP2);

            SanPham sanPham7 = new SanPham("Quạt",10000,loaiSP3);
            SanPham sanPham8 = new SanPham("Bàn là",7000,loaiSP3);
            SanPham sanPham9 = new SanPham("Tủ lạnh",3000,loaiSP3);

            List<SanPham> sanPhams = new ArrayList<>();

            sanPhams.add(sanPham1);
            sanPhams.add(sanPham2);
            sanPhams.add(sanPham3);
            sanPhams.add(sanPham4);
            sanPhams.add(sanPham5);
            sanPhams.add(sanPham6);
            sanPhams.add(sanPham7);
            sanPhams.add(sanPham8);
            sanPhams.add(sanPham9);

            for (LoaiSP loaiSP: loaiSPS
            ) {
                loaiSPResponsitory.save(loaiSP);
            }

            for (SanPham sanPham: sanPhams
            ) {
                sanPhamResponsitory.save(sanPham);
            }
        };
    }

}
