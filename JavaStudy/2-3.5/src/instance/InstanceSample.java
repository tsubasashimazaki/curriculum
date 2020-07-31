package instance;

import java.util.Objects;

public class InstanceSample {

	private String firstName;

	public void InstanceOfSato(String firstName) {
		this.firstName = firstName;
	}

	// 自動生成部分
	@Override
	public int hashCode() {
		return Objects.hash(firstName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof InstanceSample)) {
			return false;
		}
		InstanceSample other = (InstanceSample) obj;
		return Objects.equals(firstName, other.firstName);
	}
	// 自動生成部分ここまで
}
