package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.service.ItemCatService;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping(value="/item/cat/list")
	@ResponseBody
	public List<TreeNode> showTree(@RequestParam(value="id", defaultValue="0") long parentId){
		List<TreeNode> tree = itemCatService.getItemCatTree(parentId);
		return tree;
	}
	
}
