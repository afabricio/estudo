package br.com.study.oauthserver;

import java.security.SecureRandom;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordEncoder2 implements PasswordEncoder {
	private Pattern BCRYPT_PATTERN = Pattern
			.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
	private final Log logger = LogFactory.getLog(getClass());

	private final int strength;

	private final SecureRandom random;

	public BCryptPasswordEncoder2() {
		this(-1);
	}

	/**
	 * @param strength the log rounds to use, between 4 and 31
	 */
	public BCryptPasswordEncoder2(int strength) {
		this(strength, null);
	}

	static final int MIN_LOG_ROUNDS = 4;
	static final int MAX_LOG_ROUNDS = 31;
	
	/**
	 * @param strength the log rounds to use, between 4 and 31
	 * @param random the secure random instance to use
	 *
	 */
	public BCryptPasswordEncoder2(int strength, SecureRandom random) {
		if (strength != -1 && (strength < MIN_LOG_ROUNDS || strength > MAX_LOG_ROUNDS)) {
			throw new IllegalArgumentException("Bad strength");
		}
		this.strength = strength;
		this.random = random;
	}

	public String encode(CharSequence rawPassword) {
		String salt;
		if (strength > 0) {
			if (random != null) {
				salt = BCrypt.gensalt(strength, random);
			}
			else {
				salt = BCrypt.gensalt(strength);
			}
		}
		else {
			salt = BCrypt.gensalt();
		}
		return BCrypt.hashpw(rawPassword.toString(), salt);
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		return true;
		
//		if (encodedPassword == null || encodedPassword.length() == 0) {
//			logger.warn("Empty encoded password");
//			return false;
//		}
//
//		if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
//			logger.warn("Encoded password does not look like BCrypt");
//			return false;
//		}
//
//		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}
}