package az.developia.springjava13.config;

//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
//
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Profile(value = "development")
public class SecurityConfig {
}
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/files/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/users/student").permitAll().antMatchers(HttpMethod.OPTIONS, "/**")
//				.permitAll()
//
//				.anyRequest().authenticated().and()
//
//				.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		http.headers().frameOptions().disable();
//
//	}
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource);
//
//	}
//
//}