package com.spring.boot.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.config.domains.Result;
import com.spring.boot.config.domains.ResultEnum;
import com.spring.boot.entities.Person;
import com.spring.boot.models.FileModel;
import com.spring.boot.repositories.PersonRepository;
import com.spring.boot.services.PersonService;
import com.spring.boot.utils.ResultUtil;

/**
 * 人员相关控制器
 * @author wang_donggang
 */
@RestController
@RequestMapping("/app/v1")
public class PersonController {
	
	@Autowired
	private PersonRepository pReponsitory;
	
	@Autowired
	private PersonService pService;
	/**
	 * 查询列表
	 * @return
	 */
	@GetMapping("/person")
	public Result<List<Person>> personList() {
		return ResultUtil.success(pReponsitory.findAll());
	}
	/**
	 * 分页查询
	 * @param pn
	 * @param ps
	 * @return
	 */
	@GetMapping("/person/{pn}/{ps}")
	public Result<Page<Person>> personPage(
			@PathVariable("pn") int pn,
			@PathVariable("ps") int ps) {
		//Sort sort = new Sort(Direction.ASC, "id");
		Pageable pageable = new PageRequest(pn - 1, ps);
		return ResultUtil.success(pReponsitory.findAll(pageable));
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@GetMapping("/person/{id}")
	public Result<Person> personFindOne(@PathVariable("id") int id) {
		return ResultUtil.success(pReponsitory.findOne(id));
	}
	/**
	 * 根据姓名查询
	 * @param name
	 * @return
	 */
	@GetMapping("/person/name/{name}")
	public Result<List<Person>> personFindByName(/*@RequestParam(value = "name", required = true) String name*/
			@PathVariable("name") String name) {
		return ResultUtil.success(pReponsitory.findByNameLike("%" + name + "%"));
	}
	/**
	 * 添加
	 * @param p
	 * @return
	 */
	@PostMapping("/person")
	public Result<Person> personSave(@Valid Person p, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(pReponsitory.save(p));
	}
	/**
	 * 测试事务
	 */
	@PostMapping("/person/two")
	public void personSaveTwo() {
		pService.insertTwo();
	}
	/**
	 * 修改全部属性
	 * @param p
	 * @return
	 */
	@PutMapping("/person")
	public Result<Person> personUpdate(Person p) {
		return ResultUtil.success(pReponsitory.save(p));
	}
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/person/{id}")
	public Result<String> personDelete(@PathVariable("id") int id) {
		try {
			pReponsitory.delete(id);
			return ResultUtil.success();
		} catch (EmptyResultDataAccessException ce) {
			return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS);
		} catch (Exception e) {
			return ResultUtil.error(ResultEnum.FAILED);
		}
	}
	/**
	 * 上传文件
	 * @param files
	 * @return
	 */
	@PostMapping("/upload")
	public Result<String> upload(FileModel files) {
		return ResultUtil.success("");
	}
/*
<input type="file" multiple="multiple" /> 

var files = $('#files')[0].files,
    formData = new FormData();
$.each(files, (i, file) => {
    formData.append('files', file);
});
formData.append('name', $('#name').val());
formData.append('num', $('#num').val());
$.ajax({
    beforeSend: request => {
        request.setRequestHeader("Cookie", "__UTOKEN__=MGM2MGZlOTctYzNiNi00MTcxLTlkMTgtZmQwZjA1NjMyNzI0");
    },
    xhrFields: {
        // 允许携带cookie请求
        withCredentials: true
    },
    url: 'http://127.0.0.1:8080/app/v1/upload3',
    type: 'POST',
    dataType: 'json',
    // 设置为false,上传文件不需要缓存
    cache: false,
    // 必须false才会自动加上正确的Content-Type
    processData: false,
    // 必须false才会避开jQuery对formdata的默认处理,XMLHttpRequest会对 ormdata进行正确的处理
    contentType: false,
    // 数据类型必须是FormData
    data: formData,
    success: res => {
        console.log(res);
    }
});
 */
}
