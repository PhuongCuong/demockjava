package fit.iuh.edu.vn.responsitory;

import fit.iuh.edu.vn.entity.LoaiSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSPResponsitory extends JpaRepository<LoaiSP,Long> {

}
