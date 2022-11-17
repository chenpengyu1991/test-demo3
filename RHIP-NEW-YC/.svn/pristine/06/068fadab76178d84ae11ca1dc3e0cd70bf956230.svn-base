<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.File" %>
<%@ page import="com.founder.rhip.ehr.common.Uploader" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.InputStream" %>

<%
    request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String currentPath = request.getRequestURI().replace( request.getContextPath(), "" );

	File currentFile = new File( currentPath );

	currentPath = currentFile.getParent() + File.separator;

	//加载配置文件
	String propertiesPath = request.getSession().getServletContext().getRealPath( currentPath + "config.properties" );
	Properties properties = new Properties();

	try {
		System.out.println("propertiesPath=================" + propertiesPath);

		InputStream inStream = new FileInputStream(propertiesPath);
	    properties.load(inStream);
	} catch ( Exception e ) {
	    //加载失败的处理
	    e.printStackTrace();
	}

	System.out.println("savePath=================" + properties.getProperty("savePath"));
	//List<String> savePath = Arrays.asList( properties.getProperty( "savePath" ).split( "," ) );

		List<String> savePath = new ArrayList<String>();
		savePath.add("upload");
		savePath.add("upload1");
		//获取存储目录结构
	if ( request.getParameter( "fetch" ) != null ) {

	    response.setHeader( "Content-Type", "text/javascript" );

	    //构造json数据
	    Iterator<String> iterator = savePath.iterator();

	    String dirs = "[";
	    while ( iterator.hasNext() ) {

	        dirs += "'" + iterator.next() +"'";

	        if ( iterator.hasNext() ) {
	            dirs += ",";
	        }

	    }
	    dirs += "]";
	    response.getWriter().print( "updateSavePath( "+ dirs +" );" );
	    return;

	}
	
	Uploader up = new Uploader(request);
	up.setSavePath("upload");
	String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
	up.setAllowFiles(fileType);
	up.setMaxSize(500 * 1024); //单位KB
	up.upload();
	response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+up.getUrl()+"','title':'"+up.getTitle()+"','state':'"+up.getState()+"'}");
	%>

