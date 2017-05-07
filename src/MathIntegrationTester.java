import com.math.integrate.DoubleFunction;
import com.math.integrate.DoubleFunctionV2;
import com.math.integrate.SimpsonsRule;

public class MathIntegrationTester {

	public static void main(String[] args) {

		int RAMANUJAN_NUMBER = 1729;
		// Minst kode vi behövde före Java 1.8 för att göra det annars vi måste använder Adapter Pattern för att göra det
		// Anonymous Class

		@SuppressWarnings("This is an Example")	DoubleFunction sineFunction = new DoubleFunction() {

			@Override
			public double f(double x) {
				return Math.sin(x);
			}
		};

		double integrationResult = SimpsonsRule.integrate(sineFunction, Math.PI, RAMANUJAN_NUMBER, 10);
		System.out.println("Simpsons Rule with Primitive Java Anonymous Class \n " + integrationResult);

		// denna är en enkelt satt for att göra Lamba Funktion
		DoubleFunctionV2 sineFunctionLambda = (double x) -> Math.sin(x);
		double integrationResult2 = SimpsonsRule.integrateV2(sineFunctionLambda, Math.PI, RAMANUJAN_NUMBER, 10);
		System.out.println("Simpsons Rule with Lambda as a Variable \n " + integrationResult2);


		// detta är annu bättre, pass Lambda också
		double integrationResult3 = SimpsonsRule.integrateV2((double x) -> Math.sin(x), Math.PI, RAMANUJAN_NUMBER, 10);
		System.out.println("Simpsons Rule with Lambda as a Argument, even better \n " + integrationResult3);

		// Using a method reference to call Simpson.integrate
		double integrationResult4 = SimpsonsRule.integrateV2(Math::sin, Math.PI, RAMANUJAN_NUMBER, 10);
		System.out.println("Using a method reference to call Simpson.integrate \n " + integrationResult4);

		double integrationResult5 = SimpsonsRule.integrateV2(Math::cos, Math.PI, RAMANUJAN_NUMBER, 10);
		System.out.println("Using a method reference to call Simpson.integrate 2 \n " + integrationResult5);

		double integrationResult6 = SimpsonsRule.integrateV3(Math::cos, Math.PI, RAMANUJAN_NUMBER, 10);
		System.out.println("Using the DoubleUnaryOperator \n " + integrationResult6);

		// Vi hade började med många kode, men nu vi skriver bara en linje av kod
	}
}
