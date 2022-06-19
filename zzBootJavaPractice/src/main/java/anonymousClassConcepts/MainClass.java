/**
 * 
 */
package anonymousClassConcepts;

/**
 * @author sameer
 *
 */
public class MainClass {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// OLD WAY WITH ANOTHER INTERFACE (NON FUNCTIONAL)
		WithOutFunctInterface withOutFunctInterface = new WithOutFunctInterface() {
			@Override
			public void show() {
				get("sameer");
			}

			@Override
			public void get(String name) {
				System.out.println("We Successfully Get Name ==>> " + name);

			}
		};
		withOutFunctInterface.show();

		// NEW WAY WITH ANOTHER INTERFACE (FUNCTIONAL) With Parameter
		WithFunctionalInterface withFunctionalInterface = (a) -> {
			System.out.println("Hello ==>> " + a);
		};

		withFunctionalInterface.getName("sameer");

		// NEW WAY WITH ANOTHER INTERFACE (FUNCTIONAL) With OutParameter
		WithFunctionalInterfaceWithOutParams withFunctionalInterfaceWithOutParams = () -> System.out
				.println("Yes Got It");


	}

}
