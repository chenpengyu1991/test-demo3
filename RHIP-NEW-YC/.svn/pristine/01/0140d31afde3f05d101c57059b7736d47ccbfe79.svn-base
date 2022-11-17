package com.founder.rhip.ehr.tld;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 字典数据以checkbox形式展现
 * @author Jiang Haiying
 *
 */
public class DictionaryCheckboxTag  extends BaseTag {

	private static final long serialVersionUID = -8761458137221381000L;

	// attribute
	private String id = null;
	private String name = null;
	private String dicmeta = null;
	private String value = null;
	private String code = null;
	private String uninclude = null;
    private String onchange = null;
    private String onclick = null;
    private String reg = null;
    private String disabled = null;
   	private boolean isBr = false;//选项之间是否换行

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		List<DicItem> list = this.getDicItems();
		String html = null;
		StringBuilder sb = new StringBuilder();
		if(ObjectUtil.isNotEmpty(list)) {
			int i = 0;
			for (DicItem dic : list) {
				this.getCheck(dic, sb);
				i++;
				if(isBr && i < list.size()) {
					sb.append("<br/>");
				}
			}
		}
		
		html = sb.toString();
		
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDicmeta() {
		return dicmeta;
	}

	public void setDicmeta(String dicmeta) {
		this.dicmeta = dicmeta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUninclude() {
		return uninclude;
	}

	public void setUninclude(String uninclude) {
		this.uninclude = uninclude;
	}

    public String getOnchange() {
        return onchange;
    }

    public void setOnchange(String onchange) {
        this.onchange = onchange;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getReg() {
        return reg;
    }

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public boolean getIsBr() {
		return isBr;
	}

	public void setIsBr(boolean isBr) {
		this.isBr = isBr;
	}

	private StringBuilder getCheck(DicItem dic, StringBuilder sb) {

		sb.append("<label><input type=\"checkbox\"");
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		sb.append(" name=\"" + name + "\"");
		if(StringUtils.isNotEmpty(disabled)) {
			sb.append(" disabled=\"disabled\"");
		}
		sb.append(" class=\"checkboxGroup\"" );
		
		if (StringUtils.isNotEmpty(reg)) {
            sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
            this.setReg(null);
        }
        
		if(StringUtils.isNotEmpty(onchange)){
            sb.append(" onchange=\"" + onchange + "\"");
        }

        if(StringUtils.isNotEmpty(onclick)){
            sb.append(" onclick=\"" + onclick + "\"");
        }
        
        sb.append("onclick=\"this.blur()\"");

		boolean flag = true;
		if(StringUtils.isEmpty(dic.getItemName())) {
			dic.setItemName("");
		}
		if (StringUtils.isNotEmpty(value)) {
			String values[] = value.split(",");
			for(String temp: values) {
				if (dic.getItemCode().equals(temp)) {
					sb.append(" value=\"" + dic.getItemCode() +"\" checked=\"checked\"><span>"  + dic.getItemName()  + "&emsp;</span></input></label>");
					flag = false;
					break;
				}
			}
		}
		if (flag){
			sb.append(" value=\"" + dic.getItemCode() +"\" ><span>"  + dic.getItemName() + "&emsp;</span></input></label>");
		}
		return sb;
	}
	
	private List<DicItem> getDicItems() {
		List<DicItem> temp = dictionaryApp.queryDicItem(dicmeta);// WebCache.dicItemList.get(dicmeta);
		List<DicItem> list = new ArrayList<DicItem>();
	
		if(StringUtils.isNotEmpty(this.code) && StringUtils.isNotEmpty(this.uninclude)) {
			return temp;
		}
		if(StringUtils.isNotEmpty(this.code)) {
			list = this.getIncludeDicItems(temp);
		} else if(StringUtils.isNotEmpty(this.uninclude)) {
			list = this.getUnincludeDicItems(temp);
		} else {
			return temp;
		}
		return list;
	}
	
	/**
	 * 根据code获取code所包含的数据
	 * @return
	 */
	private List<DicItem> getIncludeDicItems(List<DicItem> temp) {
		List<DicItem> list = new ArrayList<DicItem>();
		String[] codes = this.code.split(",");
		for (String code : codes) {
			for (DicItem item : temp) {
				if (StringUtils.equals(code, item.getItemCode())) {
					list.add(item);
					break;
				}
			}
		}
		return list;
	}
	
	/**
	 * 根据uninclude排除其包含的数据
	 * @return
	 */
	private List<DicItem> getUnincludeDicItems(List<DicItem> temp) {
		List<DicItem> list = new ArrayList<DicItem>();
		list.addAll(temp);
		String[] unincludes = this.uninclude.split(",");
		for (String code : unincludes) {
			for (DicItem item : temp) {
				if (StringUtils.equals(code, item.getItemCode())) {
					list.remove(item);
					break;
				}
			}
		}
		return list;
	}
}
