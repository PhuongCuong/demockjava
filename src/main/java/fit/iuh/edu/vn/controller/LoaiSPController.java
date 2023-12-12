package fit.iuh.edu.vn.controller;

import fit.iuh.edu.vn.entity.LoaiSP;
import fit.iuh.edu.vn.entity.SanPham;
import fit.iuh.edu.vn.responsitory.LoaiSPResponsitory;
import fit.iuh.edu.vn.responsitory.SanPhamResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class LoaiSPController {
    @Autowired
    private LoaiSPResponsitory loaiSPResponsitory;
    @Autowired
    private SanPhamResponsitory sanPhamResponsitory;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("getAllLoaiSP",loaiSPResponsitory.findAll());
        return "home";
    }

    @GetMapping("/view-sp/{loaispId}")
    public String getListSP(@PathVariable("loaispId") Long loaispId,Model model){
        List<SanPham> sanPhams = sanPhamResponsitory.findSanPhamsByLoaiSP_Id(loaispId);
        if(!sanPhams.isEmpty()){
            model.addAttribute("getAllSPbyLoaiSp",sanPhams);
        }
        return "listSanPham";

    }





}
