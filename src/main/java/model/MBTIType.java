package model;

import org.apache.commons.lang3.text.WordUtils;

import java.util.HashMap;
import java.util.Map;

public class MBTIType {

    public static HashMap<CognitiveRoles, String> getFunctionStack(String type) {
        CognitiveFunctions oneA, oneB, twoA, twoB, threeA, threeB, fourA, fourB, fiveA, fiveB, sixA, sixB, sevenA, sevenB, eightA, eightB;
        boolean extrovert = type.charAt(0) == 'E';
        boolean sensing = type.charAt(1) == 'S';
        boolean thinking = type.charAt(2) == 'T';
        boolean perceiving = type.charAt(3) == 'P';

        oneA = extrovert ? CognitiveFunctions.EXTROVERTED : CognitiveFunctions.INTROVERTED;
        twoA = extrovert ? CognitiveFunctions.INTROVERTED : CognitiveFunctions.EXTROVERTED;
        threeA = oneA;
        fourA = twoA;
        fiveA = twoA;
        sixA = oneA;
        sevenA = twoA;
        eightA = oneA;

        if ((perceiving && extrovert) || (!perceiving && !extrovert)) {
            oneB = sensing ? CognitiveFunctions.SENSING : CognitiveFunctions.INTUITION;
            twoB = thinking ? CognitiveFunctions.THINKING : CognitiveFunctions.FEELING;
            threeB = thinking ? CognitiveFunctions.FEELING : CognitiveFunctions.THINKING;
            fourB = sensing ? CognitiveFunctions.INTUITION : CognitiveFunctions.SENSING;
        } else {
            oneB = thinking ? CognitiveFunctions.THINKING : CognitiveFunctions.FEELING;
            twoB = sensing ? CognitiveFunctions.SENSING : CognitiveFunctions.INTUITION;
            threeB = sensing ? CognitiveFunctions.INTUITION : CognitiveFunctions.SENSING;
            fourB = thinking ? CognitiveFunctions.FEELING : CognitiveFunctions.THINKING;
        }
        fiveB = oneB;
        sixB = twoB;
        sevenB = threeB;
        eightB = fourB;


        String hero = WordUtils.capitalize((String.format("%s %s", oneA, oneB)).toLowerCase());
        String parent = WordUtils.capitalize((String.format("%s %s", twoA, twoB)).toLowerCase());
        String child = WordUtils.capitalize((String.format("%s %s", threeA, threeB)).toLowerCase());
        String inferior = WordUtils.capitalize((String.format("%s %s", fourA, fourB)).toLowerCase());
        String nemesis = WordUtils.capitalize((String.format("%s %s", fiveA, fiveB)).toLowerCase());
        String criticalParent = WordUtils.capitalize((String.format("%s %s", sixA, sixB)).toLowerCase());
        String trickster = WordUtils.capitalize((String.format("%s %s", sevenA, sevenB)).toLowerCase());
        String demon = WordUtils.capitalize((String.format("%s %s", eightA, eightB)).toLowerCase());

        HashMap<CognitiveRoles, String> functionStack = new HashMap<>();
        functionStack.put(CognitiveRoles.HERO, hero);
        functionStack.put(CognitiveRoles.PARENT, parent);
        functionStack.put(CognitiveRoles.CHILD, child);
        functionStack.put(CognitiveRoles.INFERIOR, inferior);
        functionStack.put(CognitiveRoles.NEMESIS, nemesis);
        functionStack.put(CognitiveRoles.CRITICAL_PARENT, criticalParent);
        functionStack.put(CognitiveRoles.TRICKSTER, trickster);
        functionStack.put(CognitiveRoles.DEMON, demon);

        return functionStack;
    }

    public static int calculateDistances (HashMap<CognitiveRoles, String> person1, HashMap<CognitiveRoles, String> person2) {
        int distance = 0;
        for (Map.Entry<CognitiveRoles, String> entry: person1.entrySet()) {
            int functionRank1 = entry.getKey().getCognitiveRank();
            String functionName = entry.getValue();
            String pairOfFunction = getItsPair(functionName);
            for (Map.Entry<CognitiveRoles, String> entry1: person2.entrySet()) {
                if (entry1.getValue().equals(pairOfFunction)) {
                    int functionRank2 =entry1.getKey().getCognitiveRank();
                    int difference = Math.max(functionRank1, functionRank2) - Math.min(functionRank1, functionRank2);
                    distance += difference;
                }
            }
        }
        System.out.printf("Total distance is %s%n", distance);
        return distance;
    }

    public static String getItsPair(String functionName) {
        String pair;
        if (functionName.contains("Extroverted")) {
            pair = functionName.replace("Extroverted", "Introverted");
        } else {
            pair = functionName.replace("Introverted", "Extroverted");
        }
        return pair;
    }

    public static int getPercentage(int distance) {
        int percentage = (int) (100 - distance * 2.5);
        return percentage;
    }

}
