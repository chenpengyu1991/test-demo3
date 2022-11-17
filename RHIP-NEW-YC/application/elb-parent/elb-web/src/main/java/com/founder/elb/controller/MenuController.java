package com.founder.elb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.elb.entity.Menu;
import com.founder.elb.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private IMenuService menuService;

	
	/*
	 *	进入菜单页面 
	 * */	
	@RequestMapping("/list")
	public String index(ModelMap model) {
		List<Menu> list=menuService.getMenus();
		model.addAttribute("menus",list);
		String result = "menu/list";
		return result;
	}
	
	
	/*
	 *	进入菜单详细页面 
	 * */	
	@RequestMapping("/detail/{id}")
	public String detail(ModelMap model,@PathVariable("id") Integer id) {
		Menu menu=menuService.getMenu(id);
		model.addAttribute("menu",menu);
		String result = "menu/detail";
		return result;
	}	
	
	/*
	 *	进入新建菜单页面 
	 * */	
	@RequestMapping("/add")
	public String add() {
		String result = "menu/add";
		return result;
	}	
	
	/*
	 *	新增菜单 
	 * */	
	@RequestMapping("/save")
	public String save(ModelMap model,Menu menu) {
		int result=0;
		
		result=menuService.createMenu(menu);
		
		if(result==0){
			model.addAttribute("message","保存失败");
			return "menu/add";
		}else{
			return "redirect:menu/list";
		}
		
		
	}
	
	/*
	 * 删除菜单
	 * */
	@RequestMapping("/delete/{menuIds}")
	public String delete(ModelMap model,@PathVariable("menuIds") String menuIds){
		String[] sample=menuIds.split(",");
		Integer[] ids=new Integer[sample.length];
		
		for(int i=0;i<sample.length;i++){
		ids[i]=Integer.parseInt(sample[i]);
		}
		
		int result=menuService.deleteMenu(ids);
		
		if(result==0){
			model.addAttribute("message","删除失败");
			return "/menu/list";
			
		}else{
			model.addAttribute("message","删除成功");
			return "redirect:/menu/list";
		}
		
		
	}
	
	
	
}