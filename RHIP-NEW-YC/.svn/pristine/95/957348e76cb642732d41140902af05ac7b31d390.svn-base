package com.founder.rhip.dm;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

/**
 * 处理异常信息
 * 
 * @author liuk
 * 
 */
public class DmErrorInterceptor extends AbstractSoapInterceptor {

	public DmErrorInterceptor() {
		super(Phase.MARSHAL);
		getAfter().add(Soap11FaultOutInterceptor.class.getName());
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Fault fault = (Fault) message.getContent(Exception.class);
		Throwable t = getOriginalCause(fault.getCause());
		// 如果是DmException异常,则返回code和message
		if (t instanceof DmException) {
			fault.setMessage(((DmException) t).getErrorCode().getMessage());
			fault.setFaultCode(new QName(((DmException) t).getErrorCode().getCode()));
		} else {
			fault.setMessage(t.getMessage());
			fault.setFaultCode(new QName("faultCode"));
		}

	}

	/**
	 * 获取到异常
	 * 
	 * @param t
	 * @return
	 */
	private Throwable getOriginalCause(Throwable t) {
		if (t.getCause() == null || t.getCause().equals(t)) {
			return t;
		} else {
			return getOriginalCause(t.getCause());
		}
	}

}
