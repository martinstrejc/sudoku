/**
 * 
 */
package cz.wicketstuff.sudoku.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.wicketstuff.sudoku.web.SudokuApplication;

/**
 * @author martin
 *
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
	public SudokuApplication application() {
		return new SudokuApplication();
	}
			
}
