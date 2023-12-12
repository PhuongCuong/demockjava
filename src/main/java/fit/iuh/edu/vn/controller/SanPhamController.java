package fit.iuh.edu.vn.controller;

import fit.iuh.edu.vn.entity.LoaiSP;
import fit.iuh.edu.vn.entity.SanPham;
import fit.iuh.edu.vn.responsitory.LoaiSPResponsitory;
import fit.iuh.edu.vn.responsitory.SanPhamResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SanPhamController {
    @Autowired
    private SanPhamResponsitory sanPhamResponsitory;

    @Autowired
    private LoaiSPResponsitory loaiSPResponsitory;
    @GetMapping("/form-add/{loaiSpId}")
    public String getformAdd(@PathVariable("loaiSpId") Long loaiSpId,Model model){
        SanPham sanPham = new SanPham();
        Optional<LoaiSP> optional = loaiSPResponsitory.findById(loaiSpId);
        if(optional.isPresent()){
            sanPham.setLoaiSP(optional.get());
        }
        model.addAttribute("sanpham",new SanPham("",0,optional.get()));
        return "add";
    }

    @PostMapping("/add-action")
    public String getAdd(@ModelAttribute("sanpham") SanPham sanPham){
        Optional<LoaiSP> optional = loaiSPResponsitory.findById(sanPham.getLoaiSP().getId());
        if(optional.isPresent()){
            sanPham.setLoaiSP(optional.get());
            if(sanPham != null){
                sanPhamResponsitory.save(sanPham);
            }
        }
        return "redirect:/view-sp/" + sanPham.getLoaiSP().getId();
    }

    @GetMapping("/delet-action/{sanphamID}")
    public String getDelete(@PathVariable("sanphamID") Long sanphamID){
        Optional<SanPham> optional = sanPhamResponsitory.findById(sanphamID);
        if(optional.isPresent()){
            sanPhamResponsitory.delete(optional.get());
        }
        return "redirect:/view-sp/" + optional.get().getLoaiSP().getId();

    }

    @GetMapping("/form-update/{sanphamId}")
    public String getformUpdate(@PathVariable("sanphamId") Long sanphamId,Model model){
        Optional<SanPham> optional = sanPhamResponsitory.findById(sanphamId);
        if(optional.isPresent()){
            model.addAttribute("sanpham",optional.get());

        }
        return "update";
    }

    @PostMapping("/update-action")
    public String getUpdate(@ModelAttribute("sanpham") SanPham sanPham){
        System.out.println(sanPham);
        if(sanPham != null){
            sanPhamResponsitory.save(sanPham);
        }
        return "redirect:/view-sp/" + sanPham.getLoaiSP().getId();

    }

}
