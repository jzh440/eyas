package com.hdsx.framework.lang.dto;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hdsx.framework.util.StringUtile;
/**
 * 树结构工具
 * @author xiongxt
 * @2015年3月25日
 */
public class DtoUtil {
	/**
	 * 转化成树结构
	 * @param ts 需要转化数据
	 * @param ids 被选中的数据
	 * @param currId 当前数据标识
	 * @param fields 对象中对应树0:id，1:text，2:children属性名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<ComboTree> listToList(List<T> ts, final List<String> ids,
			final String currId,final String[] fields){
		List<ComboTree> dtos = new ArrayList<ComboTree>();
		if(ts != null && ts.size() > 0){
			for(final T t : ts){
				
				//获取数据id
				String id_ = null;
				String idname = fields[0];//id
				Object idvalue = getValue(idname,t);
				if(idvalue != null){
					id_ = idvalue.toString();
				}
				final String id = id_;
				
				//获取数据子节点
				// 有子节点时关着，否则开着
				List<Object> children_ = null;
				try {
					String childrenname = fields[2];// children
					Object childrenvalue = getValue(childrenname, t);
					if (childrenvalue != null && childrenvalue instanceof List) {
						children_ = (List<Object>)childrenvalue;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("获取children失败！");
				}
				
				final List<Object> children = children_;
				
				IObjectToTree tree = new IObjectToTree() {
					
					@Override
					public String getId() {
						// TODO Auto-generated method stub
						return id;
					}

					@Override
					public String getText() {
						// TODO Auto-generated method stub
						String text = null;
						String name = fields[1];//text
						Object value = getValue(name,t);
						if(value != null){
							text = value.toString();
						}
						return text;
					}

					@Override
					public String getState() {
						// TODO Auto-generated method stub
						if (ids != null && ids.contains(id) && children != null && !children.isEmpty()) {
							return "open";
						} else {
							return "closed";
						}
					}

					@Override
					public boolean getChecked() {
						// TODO Auto-generated method stub
						if(ids != null && ids.contains(id)){ //被选中的情况
							return true;
						}else{
							return false;
						}
					}

					@Override
					public Map<String, Object> getAttributes() {
						// TODO Auto-generated method stub
						Map<String, Object> arrtributes = new HashMap<String, Object>();
						if(currId == null || !currId.equals(id)){
							arrtributes.put("currId", false);
						} else {
							arrtributes.put("currId", true);
						}
						return arrtributes;
					}

					@Override
					public List<ComboTree> getChildren() {
						List<ComboTree> dtos = new ArrayList<ComboTree>();
						if(children != null && children.size() > 0){
							dtos = listToList(children,ids,currId,fields);
						}
						
						return dtos;
					}

				};
				ComboTree dto = treeToDto(tree);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	/**
	 * 对象树结构映射
	 * @param depts
	 * @param ids
	 * @param currId
	 * @return
	 */
	public static ComboTree treeToDto(IObjectToTree tree){
		return new ComboTree(tree.getId(), tree.getText(), tree.getState(), tree.getChecked(),
				tree.getAttributes(), tree.getChildren());
	}
	
	/**
	 * 反射获取值
	 * @param name
	 * @param o
	 * @return
	 */
	public static <T> Object getValue(String name, T o) {
		Object result = null;
		try {
			if (!StringUtile.isEmptyString(name) && o != null) {
				Class<?> clazz = o.getClass();
				if (clazz != null) {
					Method method = clazz.getMethod("get"
							+ StringUtile.upperInitial(name));
					if (method != null) {
						result = method.invoke(o);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
}
