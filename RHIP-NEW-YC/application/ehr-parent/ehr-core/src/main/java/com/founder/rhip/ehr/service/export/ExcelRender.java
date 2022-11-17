package com.founder.rhip.ehr.service.export;

import java.io.OutputStream;

/**
 * @author liuk
 *
 */
public interface ExcelRender {
	public void execute(Report report, OutputStream outputStream);
}
