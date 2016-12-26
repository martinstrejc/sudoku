/**
 * 
 */
package cz.wicketstuff.sudoku.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author martin
 *
 */
@Configuration
@Import({ApplicationContextConfig.class})
@EnableAspectJAutoProxy
public class SudokuConfig {
	

}
