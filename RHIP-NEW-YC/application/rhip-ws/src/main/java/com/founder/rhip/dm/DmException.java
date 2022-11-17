package com.founder.rhip.dm;

/**
 * 异常信息
 * @author liuk
 *
 */
public class DmException extends RuntimeException {

	private static final long serialVersionUID = -9191667755599925519L;
	private DmErrorCode errorCode;//异常编码

	public DmException(DmErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public DmException(DmErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public DmErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(DmErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
