package cz.wicketstuff.sudoku.web;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

/**
 * @author Martin Strejc
 *
 */
public class SudokuSession extends AuthenticatedWebSession
{

	private static final long serialVersionUID = 1L;
	
	private final Roles roles = new Roles(Roles.ADMIN);
		
//	@SpringBean
//	@SuppressWarnings("squid:S1948")
//	private DarujConfigBean darujConfigBean;

	public SudokuSession(Request request)
	{
		super(request);
		Injector.get().inject(this);
	}

	@Override
	protected boolean authenticate(String username, String password)
	{
// 		return darujConfigBean.getAdminUser().equals(username) && darujConfigBean.getAdminPassword().equals(password);
		return true;
	}

	@Override
	public Roles getRoles()
	{
		return isSignedIn() ? roles : null;
	}

}
