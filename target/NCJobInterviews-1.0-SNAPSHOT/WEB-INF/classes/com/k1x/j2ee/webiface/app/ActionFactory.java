package com.k1x.j2ee.webiface.app;

import com.k1x.j2ee.webiface.actions.AddCalculationAction;
import com.k1x.j2ee.webiface.actions.CalculationListAction;
import com.k1x.j2ee.webiface.actions.DeleteAction;
import com.k1x.j2ee.webiface.actions.GetImageAction;
import com.k1x.j2ee.webiface.actions.RegisterAction;
import com.k1x.j2ee.webiface.actions.LoginAction;
import com.k1x.j2ee.webiface.actions.SecretpageAction;
import com.k1x.j2ee.webiface.actions.ActionIface;
import com.k1x.j2ee.webiface.actions.LogoutAction;
import com.k1x.j2ee.webiface.actions.ViewCalculationAction;

import java.util.HashMap;
import java.util.Map;



public class ActionFactory {
	protected Map<String, Class<?>> map = defaultMap();
	
	public ActionFactory() {
		super();
	}
	public ActionIface create(String actionName) {
		Class<?> klass = (Class<?>) map.get(actionName);
		if (klass == null)
			throw new RuntimeException(getClass() + " was unable to find an action named '" + actionName + "'.");
		
		ActionIface actionInstance = null;
		try {
			actionInstance = (ActionIface) klass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return actionInstance;
	}
	protected Map<String, Class<?>> defaultMap() {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();

		map.put("login", LoginAction.class);
		map.put("register", RegisterAction.class);
		map.put("logout", LogoutAction.class);
		map.put("secretpage", SecretpageAction.class);
        map.put("getimage", GetImageAction.class);
        map.put("calculationslist", CalculationListAction.class);
        map.put("add_calculation", AddCalculationAction.class);
        map.put("view_calculation", ViewCalculationAction.class);
        map.put("delete", DeleteAction.class);
      
        return map;
	}
}