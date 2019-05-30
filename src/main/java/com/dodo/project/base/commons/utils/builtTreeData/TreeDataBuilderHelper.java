package com.dodo.project.base.commons.utils.builtTreeData;
/** 
* @Description: 树数据生成器 
* @Author: walk_code walk_code@163.com
* @Param:  
* @return:   
* @Date: 2019/5/28 18:13
*/ 
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.dodo.project.base.commons.utils.json.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TreeDataBuilderHelper<T> {
	List<T>				  treeDataBean = new ArrayList<T>();
	private static Logger log		   = LoggerFactory.getLogger(TreeDataBuilderHelper.class);
	
	public TreeDataBuilderHelper() {
		
	}
	
	public TreeDataBuilderHelper(List<T> treeNodeBeans) {
		this.treeDataBean = treeNodeBeans;
	}
	
	/** 
	* @Description: 构建树 
	* @Author: walk_code walk_code@163.com
	* @Param: [topicTreeNodeBeans] 
	* @return: java.lang.String  
	* @Date: 2019/5/28 18:13
	*/ 
	public static String buildTree(List<?> topicTreeNodeBeans) {
		TreeDataBuilderHelper<?> treeBuilderHelper = new TreeDataBuilderHelper(topicTreeNodeBeans);
		
		return treeBuilderHelper.buildJSONTree();
	}
	
	/** 
	* @Description: 构建json树 
	* @Author: walk_code walk_code@163.com
	* @Param: [] 
	* @return: java.lang.String  
	* @Date: 2019/5/28 18:13
	*/ 
	public String buildJSONTree() {
		List<?>   topicTreeNodeBeans = buildTree();
		String    jsonObject         = JsonHelper.toJson(topicTreeNodeBeans);
		JSONArray jsonArray          = JSONArray.parseArray(jsonObject);
		
		return jsonArray.toString();
	}
	
	/** 
	* @Description: 构建json树 
	* @Author: walk_code walk_code@163.com
	* @Param: [] 
	* @return: java.util.List<T>  
	* @Date: 2019/5/28 18:13
	*/ 
	public List<T> buildTree() {
		List<T> treeItemNodes = new ArrayList<T>();
		List<T> rootItemNodes = getALLRootNodes();
		for (T topicTreeNodeBean : rootItemNodes) {
			buildChildNodes(topicTreeNodeBean);
			treeItemNodes.add(topicTreeNodeBean);
		}
		
		return treeItemNodes;
	}
	
	/** 
	* @Description: 递归子节点 
	* @Author: walk_code walk_code@163.com
	* @Param: [topicTreeNodeBean] 
	* @return: void  
	* @Date: 2019/5/28 18:14
	*/ 
	public void buildChildNodes(T topicTreeNodeBean) {
		List<T> children = getChildNodesByParentNode(topicTreeNodeBean);
		if (!children.isEmpty()) {
			for (T nodeBean : children) {
				buildChildNodes(nodeBean);
			}
			
			try {
				Class<?> topicTreeNodeBeanClass = topicTreeNodeBean.getClass();
				Field field = topicTreeNodeBeanClass.getDeclaredField("children");
				field.setAccessible(true);
				if (field.getType() != List.class) {
					throw new Exception("children类型必须为List类型。");
				}
				field.setAccessible(true);
				field.set(topicTreeNodeBean, children);
			}
			catch (Exception e) {
				log.error("获取类属性失败，{}", e);
			}
			
		}
	}
	
	/** 
	* @Description: 通过父节点获取所有子节点 
	* @Author: walk_code walk_code@163.com
	* @Param: [parentNode] 
	* @return: java.util.List<T>  
	* @Date: 2019/5/28 18:14
	*/ 
	public List<T> getChildNodesByParentNode(T parentNode) {
		List<T> childNodes = new ArrayList<T>();
		
		try {
			Class<?> parentNodeClass = parentNode.getClass();
			Field code = parentNodeClass.getDeclaredField("code");
			Field parentCode = parentNodeClass.getDeclaredField("parentCode");
			code.setAccessible(true);
			String codeStr = (String) code.get(parentNode);
			if (code.getType() != String.class) {
				throw new Exception("code 类型错误,必须为string类型。");
			}
			if (parentCode.getType() != String.class) {
				throw new Exception("parent_code 类型错误,必须为string类型。");
			}
			
			for (T nodeBean : treeDataBean) {
				Class<?> nodeParentCodeClass = nodeBean.getClass();
				Field field = nodeParentCodeClass.getDeclaredField("parentCode");
				field.setAccessible(true);
				String nodeParentCode = (String) field.get(nodeBean);
				if (codeStr.equals(nodeParentCode)) {
					childNodes.add(nodeBean);
				}
			}
		}
		catch (Exception e) {
			log.error("获取子节点数据失败：{}", e);
		}
		
		return childNodes;
	}
	
	
	/** 
	* @Description: 判断是否为根节点 
	* @Author: walk_code walk_code@163.com
	* @Param: [topicTreeNodeBean] 
	* @return: boolean  
	* @Date: 2019/5/28 18:14
	*/ 
	public boolean isRootNode(T topicTreeNodeBean) {
		boolean isRootNode_ = true;
		for (T nodeBean : treeDataBean) {
			try {
				Class<?> nodeParentCodeClass = nodeBean.getClass();
				Field field = nodeParentCodeClass.getDeclaredField("code");
				field.setAccessible(true);
				String code = (String) field.get(nodeBean);
				
				Class<?> topicTreeNodeBeanClass = topicTreeNodeBean.getClass();
				Field pField = topicTreeNodeBeanClass.getDeclaredField("parentCode");
				pField.setAccessible(true);
				String pFieldParentCode = (String) pField.get(topicTreeNodeBean);
				if (pFieldParentCode.equals(code)) {
					isRootNode_ = false;
					break;
				}
			}
			catch (Exception e) {
				log.error("获取父节点失败：{}", e);
			}
		}
		
		return isRootNode_;
	}
	
	/** 
	* @Description: 获取所有根节点
	* @Author: walk_code walk_code@163.com
	* @Param: [] 
	* @return: java.util.List<T>  
	* @Date: 2019/5/28 18:14
	*/ 
	public List<T> getALLRootNodes() {
		List<T> allRootNodes = new ArrayList<T>();
		for (T nodeBean : treeDataBean) {
			if (isRootNode(nodeBean)) {
				allRootNodes.add(nodeBean);
			}
		}
		
		return allRootNodes;
	}
}
