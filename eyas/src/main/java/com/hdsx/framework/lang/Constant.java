package com.hdsx.framework.lang;

/**
 * @ClassName: Constant
 * @Description: 常量類
 * @author Luqi
 * @date 2014年1月2日 上午11:11:42
 * 
 */
public class Constant {
	/**
	 * @Fields PAGE : 分页起始页数
	 */
	public static final int PAGE = 1;
	/**
	 * @Fields ROWS : 每页显示数量
	 */
	public static final int ROWS = 15;
	/**
	 * @Fields DATE_FMT_TO_SEC : 日期格式化
	 */
	public static final String DATE_FMT_TO_SEC = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 显示时间
	 */
	public static final String SIMPLE_DATE_SHOW = "yyyy-MM-dd";
	/**
	 * 发车时间等时刻
	 */
	public static final String SIMPLE_DATE_MOMENT = "HH:mm";
	/**
	 * 新增
	 */
	public static final String INSERT = "1";
	/**
	 * 新增
	 */
	public static final String ADD = "1";
	/**
	 * 修改
	 */
	public static final String UPDATE = "2";
	/**
	 * 删除
	 */
	public static final String DELETE = "3";
	/**
	 * 成功
	 */
	public static final String SUCCEED = "1";
	/**
	 * 失败
	 */
	public static final String FAIL = "0";
	/**
	 * 异常
	 */
	public static final String ERROR = "0";
	/**
	 * 是否有空间数据 否
	 */
	public static final String EXIST_NO = "0";
	/**
	 * 是否有空间数据 是
	 */
	public static final String EXIST_YES = "1";
	/**
	 * 是否上报 否
	 */
	public static final String SBZT_NO = "0";
	/**
	 * 是否上报 是
	 */
	public static final String SBZT_YES = "1";
	
	/**
	 * 是否上报 是
	 */
	public static final String SBZT_REFUSE = "2";
	/**
	 * 是否审核通过 否
	 */
	public static final String SHZT_NO = "0";
	/**
	 * 是否审核通过 是
	 */
	public static final String SHZT_YES = "1";
	/**
	 * 是否有采集计划 否
	 */
	public static final String CJZT_NO = "0";
	/**
	 * 是否有采集计划 是
	 */
	public static final String CJZT_YES = "1";
	
	/**
	 * 所属专题 运管
	 */
	public static final String SUBJECT_YG = "1";
	/**
	 * 所属专题 公路
	 */
	public static final String SUBJECT_GL = "2";
	/**
	 * 所属专题 港航
	 */
	public static final String SUBJECT_GH = "3";
	/**
	 * 所属专题 省厅
	 */
	public static final String SUBJECT_ST = "4";
	/**
	 * 重复检查：异常
	 */
	public static final String REPEAT_EXCEPTION = "0";
	/**
	 * 重复检查：重复
	 */
	public static final String REPEAT_YES = "1";
	/**
	 * 重复检查：不重复，可用
	 */
	public static final String REPEAT_NO = "2";
	/**
	 * 数据添加检验：重复
	 */
	public static final String REPEAT_FOR_ADD = "2";
	/**
	 * 数据修改检验：重复
	 */
	public static final String REPEAT_FOR_MODIFY = "2";
	/**
	 * 采集系统角色：局级编辑员
	 */
	public static final String GISCJ_ROLE_JJBJY = "3";
	/**
	 * 采集系统角色：局级管理员
	 */
	public static final String GISCJ_ROLE_JJGLY = "4";
	/**
	 * 采集系统角色：局级采集员
	 */
	public static final String GISCJ_ROLE_JJCJY = "5";
	/**
	 * 采集系统角色：厅级管理员
	 */
	public static final String GISCJ_ROLE_STGLY = "6";
	/**
	 * 修改密码，提供的当前密码错误提示
	 */
	public static final String MODIFY_PASSWORD_ERROR = "2";
	
	/**
	 * 导入是否数据重复：是
	 */
	public static final String IMPORT_REPEAT_YES = "1";
	/**
	 * 导入是否数据重复：否
	 */
	public static final String IMPORT_REPEAT_N0 = "0";
	/**
	 * 是否被退回：是
	 */
	public static final String THZT_YES = "2";
	/**
	 * 计划分类：新计划
	 */
	public static final String JHFL_NEW = "new";
	/**
	 * 计划分类：已下发
	 */
	public static final String JHFL_YXF = "yxf";
	/**
	 * 计划分类：待审核
	 */
	public static final String JHFL_DSH = "dsh";
	/**
	 * 计划分类：未通过
	 */
	public static final String JHFL_WTG = "shwtg";
	
}
