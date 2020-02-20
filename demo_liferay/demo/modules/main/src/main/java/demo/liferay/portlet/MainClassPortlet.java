package demo.liferay.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.service.model.Guest;
import com.service.service.GuestLocalService;
import demo.liferay.constants.MainClassPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Date;

/**
 * @author Ario Bimo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MainClass",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MainClassPortletKeys.MAINCLASS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MainClassPortlet extends MVCPortlet
{
	@Reference
	private GuestLocalService guestLocalService;

	public void addGuest(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, PortalException
	{
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Guest.class.getName(), actionRequest);

		int id = ParamUtil.getInteger(actionRequest, "id");
		String userName = ParamUtil.getString(actionRequest, "user_name");

		if (id > 0)
		{
			try
			{
				guestLocalService.updateGuest
				(
						(int) serviceContext.getUserId(), userName
				);
			}
			catch (Exception e)
			{
				System.out.println(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				actionResponse.getRenderParameters().setValue("mvcPath", "/guest/edit.jsp");
			}
		}
		else
		{
			try
			{
				guestLocalService.addGuest
						(
								(int) serviceContext.getUserId(), userName
						);
			}
			catch (Exception e)
			{
				System.out.println(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				actionResponse.getRenderParameters().setValue("mvcPath", "/guest/edit.jsp");
			}
		}
	}

	public void deleteGuest(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, PortalException {
		int id = ParamUtil.getInteger(actionRequest, "id");

		try
		{
			guestLocalService.deleteGuest(id);
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
