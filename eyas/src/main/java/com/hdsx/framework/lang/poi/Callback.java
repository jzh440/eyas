package com.hdsx.framework.lang.poi;

import java.util.Arrays;
import java.util.List;

/**
 * poi导出excel接口
 * @author xiongxt
 * @2015年3月26日
 * @param <T>
 */
public interface Callback {
	String[][] CLASSNAME = {
			{"国省干线","GIS_LX"},
			{"农村路线","GIS_NCLX"},
			{"隧道","GIS_SD"},
			{"桥梁","GIS_QL"},
			{"收费站","GIS_SFZ"},
			{"交通量观测站","GIS_JTLGCZ"},
			{"可变情报板","GIS_KBQBB"},
			{"监控设施设备","GIS_JKSSSB"},
			{"服务区","GIS_FWQ"},
			{"出入口","GIS_CRK"},
			{"治超站","GIS_ZCZ"},
			{"标识标牌","GIS_BZBP"},
			{"出租车停靠点","GIS_CZCTKD"},
			{"城市轨道交通运营站点","GIS_CSGDJTYYZD"},
			{"城市轨道交通运营线路","GIS_CSGDJTYYXL"},
			{"公共电汽车停车保养场","GIS_GGDQCTCBYC"},
			{"常规公众汽车运营线路","GIS_CGGGQCYYXL"},
			{"常规公众汽车运营站点","GIS_CGGGQCYYZD"},
			{"港口","GIS_GK"},
			{"车辆维修企业","GIS_CLWXQY"},
			{"货运站点","GIS_HYZD"},
			{"客运站点","GIS_KYZD"},
			{"客运班线","GIS_KYBX"},
			{"货运装载源头企业","GIS_HYZZYTQY"},
			{"驾培机构","GIS_JPJG"},
			{"内河航道","GIS_NHHD"},
			{"码头","GIS_MT"},
			{"重点渡口","GIS_ZDDK"},
			{"地面构筑物","GIS_DMGZW"},
			{"非公路标志","GIS_FGLBZ"},
			{"广告牌","GIS_GGP"},
			{"跨越公路设施","GIS_KYGLSS"},
			{"执法部门","GIS_ZFBM"}};
	String[] INTEGERS_ = {"sxxfx","dllxbm","qlkjfldm","asynxfldm","sjhzdjdm","qljszkpddm","ldmclxdm","dmdm","sfyfgsbmbm","cdsl",
			"ldjsdjbmbm","sdfl","lx","sfzlx","zczlx","gczlx","gcfx","qbblx","sbsyzt","jksslx","yyclpbs",
			"ryzs","rfbc","syxz","zdjb","lxjsdj","lxxzdj","jglx","bplx"};
	
	List<String> INTEGERS = Arrays.asList(INTEGERS_);
	
	String[] NOTMEIJU_ = {"ryzs","rfbc","yyclpbs"};
	
	List<String> NOTMEIJU = Arrays.asList(NOTMEIJU_);
	
	String[] SHORTS_ ={"mtbwgs"};
	
	List<String> SHORTS = Arrays.asList(SHORTS_);
	
	/**
	 * 制表单位
	 */
	static String ZBDW = "制表单位：北京恒达时讯科技开发责任有限公司";
	/**
	 * 填报单位，填报时间
	 */
	static String TBDW_TBSJ = "填报单位:                                 XXXX年";
	/**
	 * 大标题
	 * @return
	 */
	String getTitle();
	/**
	 * 数据
	 * @param t
	 * @return
	 */
	List<String> getColumnValues(Object o);
	/**
	 * 头部行数 一般2行，如果有3行，请在最后删除第二行
	 * @return
	 */
	int getHeadRows();
	/**
	 * 列名
	 * @return
	 */
	List<String> getColumnNames();
	/**
	 * 列宽
	 * @return
	 */
	List<Integer> getColumnsWidths();
	/**
	 * 列类型
	 * @return
	 */
//	List<String> getTypes();
	/**
	 * 列数
	 * @return
	 */
	int getColumns();
	/**
	 * 合并列序列
	 * @return
	 */
	List<Integer> getMergeIndexs();
	
	/**
	 * 合并列序列
	 * @return
	 */
	List<Integer> getSecondMergeIndexs();
	
	/**
	 * 对象属性
	 * @return
	 */
	List<String> getFields();
}
