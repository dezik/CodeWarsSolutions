import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ParseMoleculeTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] { {Arrays.asList("H", "O"),
                Arrays.asList( 2,   1 ),
                "H2O",
                "water"},

                {Arrays.asList("Mg", "H", "O"),
                        Arrays.asList(  1,   2,   2 ),
                        "Mg(OH)2",
                        "magnesium hydroxide"},

                {Arrays.asList("K", "O", "N", "S"),
                        Arrays.asList( 4,   14,  2,   4 ),
                        "K4[ON(SO3)2]2",
                        "Fremy's salt"},
        });
    }

    private Map<String,Integer> expected;
    private String formula, name;

    public ParseMoleculeTest(List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String,Integer> exp = new HashMap<>();
        for (int i = 0 ; i < atoms.size() ; i++) exp.put(atoms.get(i), nums.get(i));

        this.expected = exp;
        this.formula = formula;
        this.name = name;
    }

    @Test
    public void testMolecule() {
        System.out.println(formula);
        System.out.println(expected);
        assertEquals(String.format("Should parse %s: %s", name, formula), expected, ParseMolecule.getAtoms(formula));
    }
}


//        Should parse glucose: C6H12O6 expected:<{C=6, H=12, O=6}> but was:<{C=6, H=1, O=6}>
//        Should parse ferrocene: Fe(C5H5)2 expected:<{C=10, H=10, Fe=1}> but was:<{C=2, H=2, Fe=1}>
//        Should parse cyclopentadienyliron dicarbonyl dimer: (C5H5)Fe(CO)2CH3 expected:<{C=8, H=8, Fe=1, O=2}> but was:<{C=2, H=2, Fe=2, O=2}>
//        Should parse tetrakis(triphenylphosphine)palladium(0): Pd[P(C6H5)3]4 expected:<{P=4, C=72, Pd=1, H=60}> but was:<{P=1, C=12, Pd=1, H=12}>
//        Should parse Fremy's salt: K4[ON(SO3)2]2 expected:<{S=4, K=4, N=2, O=14}> but was:<{S=4, K=4, N=4, O=4}>
//        Should parse really weird molecule: As2{Be4C5[BCo3(CO2)3]2}4Cu5 expected:<{As=2, B=8, Cu=5, Be=16, C=44, Co=24, O=48}> but was:<{As=1, B=24, Cu=1, Be=24, C=24, Co=24, O=24}>
//        Should parse hexol sulphate: {[Co(NH3)4(OH)2]3Co}(SO4)3 expected:<{S=3, H=42, Co=4, N=12, O=18}> but was:<{S=3, H=72, Co=72, N=72, O=18}>
//        Your function should throw an IllegalArgumentException for a wrong formula: Mg(OH
//        Your function should throw an IllegalArgumentException for a wrong formula: MgOH)2
//        Your function should throw an IllegalArgumentException for a wrong formula: Mg(OH]2
//        Your function should throw an IllegalArgumentException for a wrong formula: Au5(C2H5[OH)3Li]3
