package in.gndec.paigaam.crypto.sasl;

import android.util.Base64;

import java.nio.charset.Charset;

import in.gndec.paigaam.entities.Account;
import in.gndec.paigaam.xml.TagWriter;

public class Plain extends SaslMechanism {
	public Plain(final TagWriter tagWriter, final Account account) {
		super(tagWriter, account, null);
	}

	@Override
	public int getPriority() {
		return 10;
	}

	@Override
	public String getMechanism() {
		return "PLAIN";
	}

	@Override
	public String getClientFirstMessage() {
		final String sasl = '\u0000' + account.getUsername() + '\u0000' + account.getPassword();
		return Base64.encodeToString(sasl.getBytes(Charset.defaultCharset()), Base64.NO_WRAP);
	}
}
