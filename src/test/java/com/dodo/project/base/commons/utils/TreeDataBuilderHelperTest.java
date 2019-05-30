package com.dodo.project.base.commons.utils;

import com.dodo.project.base.commons.utils.bean.QuestionExpandBean;
import com.dodo.project.base.commons.utils.builtTreeData.TreeDataBuilderHelper;
import com.dodo.project.base.commons.utils.json.JsonHelper;
import org.junit.Test;

import java.util.List;

/*
 * <b>TreeDataBuilderHelperTest</b></br>
 *
 * <pre>
 * 通用树生成工具-单元测试
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/28 19:18
 * @Since JDK 1.8
 */
public class TreeDataBuilderHelperTest {
	@Test
	public void genatorJsonTree(){
		String                   TreeList = "[{\"code\":\"10471000\",\"parentCode\":\"1047\",\"levelName\":null,\"children\":[],\"answer\":\"\",\"question\":\"\",\"id\":2278,\"sourcePaperName\":null,\"examinationStageType\":null,\"questionTypeId\":24,\"specificKnowledgeId\":48,\"questionCategoryId\":133,\"status\":1,\"updateTime\":1558942524000,\"createTime\":1558942524000,\"areaName\":null,\"provinceName\":null,\"sourceYear\":null,\"schoolName\":null,\"areaId\":null,\"cityName\":null,\"difficultyId\":32,\"remark\":null},{\"code\":\"104710001000\",\"parentCode\":\"10471000\",\"levelName\":null,\"children\":[],\"answer\":\"\",\"question\":\"\",\"id\":2279,\"sourcePaperName\":null,\"examinationStageType\":null,\"questionTypeId\":24,\"specificKnowledgeId\":48,\"questionCategoryId\":133,\"status\":1,\"updateTime\":1558942524000,\"createTime\":1558942524000,\"areaName\":null,\"provinceName\":null,\"sourceYear\":null,\"schoolName\":null,\"areaId\":null,\"cityName\":null,\"difficultyId\":32,\"remark\":null}]";
		List<QuestionExpandBean> questionExpandBeanList = JsonHelper.parseArray(TreeList, QuestionExpandBean.class);
		String jsonTree = TreeDataBuilderHelper.buildTree(questionExpandBeanList);
		System.out.println(jsonTree);
	}
}
