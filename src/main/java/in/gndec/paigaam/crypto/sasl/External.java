package in.gndec.paigaam.crypto.sasl;

import android.util.Base64;
import java.security.SecureRandom;

import in.gndec.paigaam.entities.Account;
import in.gndec.paigaam.xml.TagWriter;

public class External extends SaslMechanism {

	public External(TagWriter tagWriter, Account account, SecureRandom rng) {
		super(tagWriter, account, rng);
	}

	@Override
	public int getPriority() {
		return 25;
	}

	@Override
	public String getMechanism() {
		return "EXTERNAL";
	}

	@Override
	public String getClientFirstMessage() {
		return Base64.encodeToString(account.getJid().toBareJid().toString().getBytes(),Base64.NO_WRAP);
	}
}
