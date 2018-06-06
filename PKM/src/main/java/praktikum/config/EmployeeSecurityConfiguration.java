package praktikum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	//Enable jdbc authentication
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/vendor/**");
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/img/**");
		web.ignoring().antMatchers("/scss/**");
		web.ignoring().antMatchers("/js/**");
		web.ignoring().antMatchers("/gulpfile.js");
		web.ignoring().antMatchers("/package.json");
		web.ignoring().antMatchers("/package-lock.json");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/aktualno").permitAll()
				.antMatchers("/index").permitAll()
				.antMatchers("/klubi","/kultura","/narava","/registracija","/restavracije","/sport").permitAll()
				.antMatchers("/podrobnosti").permitAll()
				.antMatchers("/dodajanjeDogodka").hasAnyRole("USER","ADMIN")

				.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
				.antMatchers("/addNewEmployee").hasAnyRole().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll()
//^^^^^^^^^ tu gori nastavis Loginpage
				.and().logout().permitAll();

		http.csrf().disable();
	}

}