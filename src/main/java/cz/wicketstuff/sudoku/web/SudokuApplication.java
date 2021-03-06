package cz.wicketstuff.sudoku.web;

import javax.annotation.PostConstruct;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cz.wicketstuff.sudoku.web.page.SudokuHomePage;

/**
 * @author Martin Strejc
 *
 */
public class SudokuApplication extends WebApplication implements ApplicationContextAware
{
	
	//private static final Logger logEx = LoggerFactory.getLogger(ExceptionMapper.class);
	
//	@Resource(mappedName = "wicket.configuration")
//	private String wicketConfiguration;
	
	private ApplicationContext context;
	
	// private Supplier<IExceptionMapper> exceptionMapperProvider = ExceptionMapper::new;
	
	@PostConstruct
	public void postConstruct() {
		// setConfigurationType("DEVELOPMENT".equalsIgnoreCase(wicketConfiguration) ? RuntimeConfigurationType.DEVELOPMENT : RuntimeConfigurationType.DEPLOYMENT);
	}
	
	@Override
	protected void init()
	{
		
		super.init();

		getComponentInstantiationListeners().add(new SpringComponentInjector(this, context));
		
		//Bootstrap.install(this);
		
//		HomePage.mount(this);
//		InstitutePage.mount(this);
//		GiftPage.mount(this);
//		GiftMailSentPage.mount(this);
//		GiftConfirmationPage.mount(this);
		
//		mountPage("secure/login", SignInPage.class);
//		mountPage("secure/logout", SignOutPage.class);
//		AdminPage.mount(this);
//		
//		NotFoundPage.mount(this);
//		LinkExpiredPage.mount(this);
//		getApplicationSettings().setPageExpiredErrorPage(NotFoundPage.class);
//		getApplicationSettings().setInternalErrorPage(NotFoundPage.class);
//		
//		DesignPage.mount(this);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) 
	{
		this.context = context;

	}

	@Override
	public Class<? extends Page> getHomePage()
	{
		return SudokuHomePage.class;
	}
	
//	@Override
//	public Supplier<IExceptionMapper> getExceptionMapperProvider()
//	{
//		return exceptionMapperProvider;
//	}
	
//	private class ExceptionMapper extends DefaultExceptionMapper {
//		
//		@Override
//		protected IRequestHandler mapUnexpectedExceptions(Exception e, Application application)
//		{
//			logEx.warn("Exception handled ", e);
//			if (checkExcpetionMis(e)) {
//				// Page currentPage = extractCurrentPage();e,
//				// currentPage)
//				return createPageRequestHandler(new PageProvider(new LinkExpiredPage()));
//			}
//			return super.mapUnexpectedExceptions(e, application);
//		}
//		
//		protected boolean checkExcpetionMis(Throwable t) {
//			if (t == null) {
//				return false;
//			}
//			return t instanceof MissingGiftException ? true : checkExcpetionMis(t.getCause());
//			
//		}
//		
//	}

}
