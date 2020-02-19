package demo.liferay.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.service.model.Guest;
import com.service.service.GuestLocalService;
import demo.liferay.constants.MainClassPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
	{
		Guest guest = guestLocalService.createGuest((int) CounterLocalServiceUtil.increment());
		guest.setId(1);
		guest.setUserName("Ario Bimo");
		guest.setCreateDate(new Date());
		guestLocalService.addGuest(guest);
		System.out.println("guest successfully added");

		super.doView(renderRequest, renderResponse);
	}
}