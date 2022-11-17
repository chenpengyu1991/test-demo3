package com.founder.rhip.ehr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.BaseController;

/**
 * 临时类  用于跳转到指定jsp页面（正在开发提示页面）
 * @author Jiang Haiying
 *
 */
@Controller
@RequestMapping("/developing")
public class DevelopingController extends BaseController {

	/**
	 * 临时跳转到 提示页面（正在开发）
	 * @return
	 */
	@RequestMapping("/temp")
	public String search() {
		return "rhip.developing.temp";
	}
	
}
