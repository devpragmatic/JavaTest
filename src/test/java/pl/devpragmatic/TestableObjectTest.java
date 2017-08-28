package pl.devpragmatic;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestableObjectTest {

	private class TestableObjectWithEqualsModified extends TestableObject {

		public TestableObjectWithEqualsModified(String value) {
			super(value);
		}

		@Override
		public boolean equals(Object obj) {
			System.out.println("Modified equals executed");
			return false;
		}

		@Override
		public String toString() {
			return "TestableObjectWithEqualsModified [toString()=" + super.toString() + "]";
		}
	}

	@Test
	public void testCollectionAdd() {
		Set<TestableObject> set = new HashSet<>();
		System.out.println("Add 'AAA'");
		TestableObject twoTimesAdded = new TestableObject("AAA");
		set.add(twoTimesAdded);
		System.out.println("Add again 'AAA'");
		set.add(twoTimesAdded);
		System.out.println("Add new 'AAA'");
		set.add(new TestableObject("AAA"));
		System.out.println("Add 'AAB'");
		set.add(new TestableObjectWithEqualsModified("AAB"));
		System.out.println("Add new 'AAB', but equals return false");
		set.add(new TestableObjectWithEqualsModified("AAB"));
		System.out.println("In set:");
		printCollection(set);
		set = new HashSet<>();
		System.out.println("Add 'AAA'");
		set.add(new TestableObject("AAA") {
			@Override
			public String toString() {
				return "first";
			}
		});
		System.out.println("Add new 'AAA'");
		set.add(new TestableObject("AAA") {
			@Override
			public String toString() {
				return "second";
			}
		});
		printCollection(set);
	}

	private void printCollection(Set<TestableObject> set) {
		set.stream().forEach(element -> System.out.println(element));
	}
}
