package fit.iuh.edu.vn.responsitory;

import fit.iuh.edu.vn.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamResponsitory extends JpaRepository<SanPham,Long> {
    List<SanPham> findSanPhamsByLoaiSP_Id(Long loaiSP);

}
