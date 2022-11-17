
package com.founder.elb.dto;

import java.util.ArrayList;
import java.util.List;

import com.founder.elb.entity.Menu;

public class Node {

	String nodeId = null;

	Menu data = null;

	Node parent = null;

	List<Node> children = null;

	int deep = 0;

	public boolean equals(Object o) {
		Node n = (Node) o;
		return nodeId.equals(n.nodeId);
	}

	public Node() {
		this.nodeId = "0";
	}

	public Node(Node node, String tt, int deep, Menu data) {
		this.parent = node;
		this.nodeId = tt;
		this.deep = deep;
		this.data = data;
	}

	public void process(Menu data) {
		String[] t = data.getCode().split("/");
		Node node = this;
		for (int i = 0; i < t.length; i++) {
			if (i > 0) {
				String tt = t[i];
				Node n = new Node(node, tt, i, data);
				node = node.add(n);
			}
		}
	}

	public Node add(Node node) {
		if (children == null) {
			children = new ArrayList<Node>();
		}
		int index = children.lastIndexOf(node);
		if (index < 0)
			children.add(node);
		else {
			node = children.get(index);
		}
		return node;
	}

	public void toHTML(StringBuilder str) {
		if (children == null) {
			str.append("<li class=\"c").append(deep).append("\"><a herf=\"###\" onclick=\"javascript:navigate('");
			str.append(data.getPath()).append("');\">").append(data.getNameZh()).append("</a></li>");
		} else {
			if(data!=null){	str.append("<li class=\"p").append(deep).append("\"><i>").append(data.getNameZh()).append("</i><ul>");}
			for (Node node : children) {
				node.toHTML(str);
			}
			if(data!=null){str.append("</ul></li>");}
		}
	}
	public void toHTMLWithName(StringBuilder str) {
		if (children == null) {
			str.append("<li class=\"c").append(deep).append("\"><a menuId='"+nodeId+"' herf=\"###\" onclick=\"javascript:navigate('");
			str.append(data.getPath()).append("',this);\">").append(data.getNameZh()).append("</a></li>");
		} else {
			if(data!=null){	str.append("<li class=\"p").append(deep).append("\"><i>").append(data.getNameZh()).append("</i><ul>");}
			for (Node node : children) {
				node.toHTMLWithName(str);
			}
			if(data!=null){str.append("</ul></li>");}
		}
	}
}
