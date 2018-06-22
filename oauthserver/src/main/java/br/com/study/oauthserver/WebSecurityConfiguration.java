package br.com.study.oauthserver;

//@Configuration
class WebSecurityConfiguration {

//	@Autowired
//	AccountRepository accountRepository;
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Bean
//	UserDetailsService userDetailsService() {
//		return (username) -> accountRepository
//			.findByUsername(username)
//			.map(a -> User.builder()
//				.username(a.getUsername())
//				.password(a.getPassword())
//				.authorities("USER", "write")
//				.build())
//			.orElseThrow(
//				() -> new UsernameNotFoundException("could not find the user '"
//					+ username + "'"));
//	}
}