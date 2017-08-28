package pl.devpragmatic;

public class TestableObject {

	private String value;

	public TestableObject(final String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		System.out.println("HashCode method executed");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals method executed");
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TestableObject)) {
			return false;
		}
		TestableObject other = (TestableObject) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TestableObject [value=" + value + ", hashCode=" + hashCode() + "]";
	}

}
