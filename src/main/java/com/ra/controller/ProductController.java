package com.ra.controller;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.dto.ProductResponseDTO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.service.CategoryService;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }
    @GetMapping("/add")
    public String add(Model model){
        ProductRequestDTO product = new ProductRequestDTO();
        model.addAttribute("product",product);
        // lay danh sach danh muc
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "add";
    }
    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("product") ProductRequestDTO product, BindingResult bindingResult, Model model){
        // validate
        if (bindingResult.hasErrors()){
            // lay danh sach danh muc
            List<Category> categories = categoryService.getAllCategories();
            model.addAttribute("categories",categories);
            return "add";
        }
        boolean result = productService.create(product);

        if (result){
            return "redirect:/products";
        }
        return "add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        if(productService.delete(id)){
            return "redirect:/products";
        }
        return "error";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        ProductResponseDTO product = productService.findById(id);
        model.addAttribute("product",product);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("product") ProductRequestDTO product,
                         Model model){
        if (productService.update(product,id)){
            return "redirect:/products";
        }
        return "error";
    }
}
