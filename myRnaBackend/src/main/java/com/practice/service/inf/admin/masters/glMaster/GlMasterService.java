/**
 * 
 */
package com.practice.service.inf.admin.masters.glMaster;

import java.util.List;

import com.practice.model.admin.masters.glMaster.GlMaster;
import com.practice.model.common.ApplicationException;


/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 25/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

public interface GlMasterService {
	public GlMaster saveGlData(GlMaster glMaster) throws ApplicationException;

	public List<GlMaster> getGlMasterData();

	public GlMaster getGlDataById(long glId);

	public void deleteGlMaster(Long glId);

	public void updateGlMaster(GlMaster glData, long glId);

	public List<GlMaster> findGlMasterByStatus();
	
	public String getMaxGlCode(String glType);
}
